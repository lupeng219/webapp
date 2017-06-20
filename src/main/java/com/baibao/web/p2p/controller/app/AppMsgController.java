package com.baibao.web.p2p.controller.app;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;







import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMethodMappingNamingStrategy;

import com.baibao.core.cache.LoadSystemConfigServlet;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.file.fastDfs.client.FdfsFile;
import com.baibao.core.file.fastDfs.client.FdfsUtils;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.ActiveId;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.controller.eventBus.events.LotteryDrawEvent;
import com.baibao.web.p2p.generator.bean.P2p_mobile_app;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.p2p_sysMsg;
import com.baibao.web.p2p.generator.dataDIC.PrizeType;
import com.baibao.web.p2p.generator.dataDIC.RedEnvelopeType;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.MobileAppService;
import com.baibao.web.p2p.service.MsgService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.AppCallLogUtil;

/**
 * @author lupeng
 * @date: 2016年1月12日下午7:27:29
 */
@Controller
@RequestMapping("/AppMsg")
public class AppMsgController {
	private static Logger logger = LoggerFactory.getLogger(AppMsgController.class); 
	
	@Autowired
	private MsgService  msgService; 

	@Autowired
	private MobileAppService mobileAppService;
	
	@Autowired
	private JedisUtil jedisUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ActiveService activeService;
	@Autowired
	private LotteryDrawEvent lotteryDrawEvent;

	/**
	 * 消息
	 * @param cursor
	 * @param count
	 * @return
	 */
	@RequestMapping(value="/findmsg",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findmsg(String custNo,Integer currentPageNo,Integer pageSize){
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo= jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		}
		currentPageNo=currentPageNo==null?1:currentPageNo;
		pageSize=pageSize==null?10:pageSize;
		Paging<p2p_sysMsg> page = msgService.findList(currentPageNo, pageSize,custNo);
		List<p2p_sysMsg> list = page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo()); 
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 删除站内信
	 * @param request
	 * @param msgIds
	 * @return
	 */
	@RequestMapping("/deleteMsg")
	public @ResponseBody Map<String, Object> deleteMsg(HttpServletRequest request,String msgIds){
		Map<String, Object> result = new HashMap<String, Object>();
		String msgId[] = msgIds.split(",");
		int i = 0;
		for (String id : msgId) {
			try {
				 msgService.deleteMsg(id);
				 i++;
			} catch (Exception e) {
				logger.error("deleteMsg", e);
				result.put(Const.retCode,false);
				result.put(Const.retMsg,"\u5220\u9664\u7ad9\u5185\u4fe1\u5931\u8d25");//删除站内信失败
				break;
			}
		}
		if(i != msgId.length){
			result.put(Const.retCode,false);
			result.put(Const.retMsg,"\u5220\u9664\u7ad9\u5185\u4fe1\u5931\u8d25");//删除站内信失败
			return result;
		}
		result.put(Const.retCode,true);
		result.put(Const.retMsg,"\u5220\u9664\u6210\u529f");//删除成功
		return result;
	}
	/**
	 * 标记已读站内信
	 * @param SysMsgID
	 * @return
	 */
	@RequestMapping("readMsg")
	@ResponseBody
	public Map<String, Object>readMsg(String msgIds){
		Map<String, Object> retMsg = new HashMap<String, Object>();
		if(StringUtil.isEmpty(msgIds)){
			retMsg.put(Const.retMsg, "\u64cd\u4f5c\u5931\u8d25");//操作失败
			retMsg.put(Const.retCode, false);
			return retMsg;
		}
		
		String msgId[] = msgIds.split(",");
		int i=0;
		for(String id : msgId){
			try {
				 msgService.setMsgReaded(id);
				 i++;
			} catch (Exception e) {
				logger.error("readMsg", e);
				retMsg.put(Const.retMsg, "\u64cd\u4f5c\u5931\u8d25");//操作失败
				retMsg.put(Const.retCode, false);
				return retMsg;
			}
			
		}
		if(i != msgId.length){
			retMsg.put(Const.retMsg, "\u64cd\u4f5c\u5931\u8d25");//操作失败
			retMsg.put(Const.retCode, false);
			return retMsg;
		}
		retMsg.put(Const.retMsg, "\u64cd\u4f5c\u6210\u529f");//操作成功
		retMsg.put(Const.retCode, true);
		return retMsg;
	}
	/**
	 * 优惠活动
	 * @param custNo
	 * @param version 接口版本号  (接口版本号1对应app版本号 2.2)(接口版本号null对应app版本号 2.0)
	 * @return
	 */
	@RequestMapping(value="active",method= RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>active(HttpServletRequest request,String custNo,String version){
		Map<String, Object> retMap = new HashMap<String, Object>();
		String custNoTwo = custNo;
		custNo=jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		}
		String rule ="投资后48小时内到账";
		String paraName = "红包";
		String metric = "元";
		if(StringUtil.isNotEmpty(version)){
			if("1".equals(version)){
				P2p_user user = userService.getByLoginCustNo(custNo);
				if(user!=null){
					String  inviteCode=user.getPuInviteCode();
					retMap.put("invitationUrl",Const.basePath+"/service/wapRegister/toWapRegister?code="+inviteCode );
					retMap.put("shareIllustrates","中融佰诚-高收益等你来拿！！安全稳定放心，快来加入吧！");
					//未使用优惠卷列表
					List<Map<String, Object>> noUseList=null;
					List<Map<String, Object>> usedList=null;
					List<Map<String, Object>> overTimeList=null;
					try {
						noUseList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.noUseStatus.getIndex()+"");
						if(noUseList!=null){
							for(Map<String, Object> list :noUseList){
								list.put("puwEffecttime", "有效期至:"+list.get("puwEffecttime").toString().substring(0, 11));
								list.put("paraName",paraName );
								list.put("metric",metric );
								list.put("rule","使用规则: 单次投资≥"+list.get("pur_rule")+"元");
								list.put("grantRule","发放规则: "+rule );
							}
						}
						usedList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.usedStatus.getIndex()+"");
						if(usedList!=null){
							for(Map<String, Object> list :usedList){
								list.put("puwEffecttime", "有效期至:"+list.get("puwEffecttime").toString().substring(0, 11));
								list.put("paraName",paraName );
								list.put("metric",metric );
								list.put("rule","使用规则: 单次投资≥"+list.get("pur_rule")+"元");
								list.put("grantRule","发放规则: "+rule );
							}
						}
						overTimeList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.overTimeStatus.getIndex()+"");
						if(overTimeList!=null){
							for(Map<String, Object> list :overTimeList){
								list.put("puwEffecttime", "有效期至:"+list.get("puwEffecttime").toString().substring(0, 11));
								list.put("paraName",paraName );
								list.put("metric",metric );
								list.put("rule","使用规则: 单次投资≥"+list.get("pur_rule")+"元");
								list.put("grantRule","发放规则: "+rule );
							}
						}
					} catch (BusinessException e) {
						logger.error("active", e);
					}
					retMap.put("noUseList",noUseList);
					retMap.put("useList",usedList);
					retMap.put("overTimeList",overTimeList);
					Map<String, Object> map= null;
					List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
					for(int i =0 ;i<2;i++){
						map= new HashMap<String, Object>();
						if(i==0){
							map.put("name","幸运大转盘");
							map.put("url", Const.basePath+"/service/AppMsg/toluckDraw?custNo="+custNoTwo);
							//map.put("url","http://192.168.1.52:8080/qzb_p2p/service/AppMsg/toluckDraw?custNo="+custNoTwo);
							list.add(map);
						}
					}
					retMap.put("goodsreward", "实物奖励");
					retMap.put("list", list);
					retMap.put(Const.retCode, true);
					retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
				}else{
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
				}
				
			}
		}else{
			P2p_user user = userService.getByLoginCustNo(custNo);
			if(user!=null){
				String  inviteCode=user.getPuInviteCode();
				retMap.put("invitationUrl",Const.basePath+"/service/wapRegister/toWapRegister?code="+inviteCode );
				retMap.put("shareIllustrates","中融佰诚-高收益等你来拿！！安全稳定放心，快来加入吧！");
				//未使用优惠卷列表
				List<Map<String, Object>> noUseList=null;
				List<Map<String, Object>> usedList=null;
				List<Map<String, Object>> overTimeList=null;
				try {
					if (request.getHeader("user-agent") != null) {
						String header = request.getHeader("user-agent").toLowerCase();
						if(header.indexOf("iphone")>0 || header.indexOf("ios")>0){
							noUseList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.usedStatus.getIndex()+"");
							if(noUseList!=null){
								for(Map<String, Object> list :noUseList){
									list.put("puwGettime", list.get("puwGettime").toString());
									list.put("puwEffecttime", list.get("puwEffecttime").toString());
									list.put("paraName",paraName );
									list.put("metric",metric );
									list.put("grantRule",rule );
									list.put("rule","单次投资≥"+list.get("pur_rule")+"元");
									list.put("puwCode", "1000");
								}
							}
							usedList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.noUseStatus.getIndex()+"");
							if(usedList!=null){
								for(Map<String, Object> list :usedList){
									list.put("puwGettime", list.get("puwGettime").toString());
									list.put("puwEffecttime", list.get("puwEffecttime").toString());
									list.put("paraName",paraName );
									list.put("metric",metric );
									list.put("grantRule",rule );
									list.put("rule","单次投资≥"+list.get("pur_rule")+"元");
									list.put("puwCode", "1000");
								}
							}
						}
					}else{
						noUseList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.noUseStatus.getIndex()+"");
						if(noUseList!=null){
							for(Map<String, Object> list :noUseList){
								list.put("puwGettime", list.get("puwGettime").toString());
								list.put("puwEffecttime", list.get("puwEffecttime").toString());
								list.put("paraName",paraName );
								list.put("metric",metric );
								list.put("grantRule",rule );
								list.put("rule","单次投资≥"+list.get("pur_rule")+"元");
								list.put("puwCode", "1000");
							}
						}
						usedList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.usedStatus.getIndex()+"");
						if(usedList!=null){
							for(Map<String, Object> list :usedList){
								list.put("puwGettime", list.get("puwGettime").toString());
								list.put("puwEffecttime", list.get("puwEffecttime").toString());
								list.put("paraName",paraName );
								list.put("metric",metric );
								list.put("grantRule",rule );
								list.put("rule","单次投资≥"+list.get("pur_rule")+"元");
								list.put("puwCode", "1000");
							}
						}
					}
					overTimeList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.overTimeStatus.getIndex()+"");
					if(overTimeList!=null){
						for(Map<String, Object> list :overTimeList){
							list.put("puwGettime", list.get("puwGettime").toString());
							list.put("puwEffecttime", list.get("puwEffecttime").toString());
							list.put("paraName",paraName );
							list.put("metric",metric );
							list.put("grantRule",rule );
							list.put("rule","单次投资≥"+list.get("pur_rule")+"元");
							list.put("puwCode", "1000");
						}
					}
				} catch (BusinessException e) {
					logger.error("active", e);
				}
				retMap.put("noUseList",noUseList);
				retMap.put("useList",usedList);
				retMap.put("overTimeList",overTimeList);
				Map<String, Object> map= null;
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				for(int i =0 ;i<2;i++){
					map= new HashMap<String, Object>();
					if(i==0){
						map.put("name","其它活动");
					//	map.put("url","http://192.168.1.52:8080/qzb_p2p/service/AppMsg/toluckDraw?custNo="+custNoTwo);
						map.put("url", Const.basePath+"/service/AppMsg/toluckDraw?custNo="+custNoTwo);
						list.add(map);
					}
				}
				retMap.put("list", list);
				retMap.put(Const.retCode, true);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			}else{
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
			}
		}
		//抽奖次数验证
		lotteryDrawEvent.setActiveId(ActiveId.ACTIVEID_DZP);
		lotteryDrawEvent.setPulCustno(custNo);
		lotteryDrawEvent.setPulSourcetype("1");//1 登录  2 投资

		return retMap;
	}
	/**
	 * 查询个人获得实物列表
	 * @param request
	 * @param currentPageNo
	 * @param pageSize
	 * @param custNo
	 * @return
	 */
	@RequestMapping("goodsReward")
	@ResponseBody
	public Map<String, Object>goodsReward(HttpServletRequest request,
			@RequestParam(value = "currentPageNo",required =false)Integer currentPageNo,
			@RequestParam(value="pageSize",required = false)Integer pageSize,
			@RequestParam("custNo")String custNo){
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
	    pageSize = pageSize == null ? 10:pageSize;
		Map<String, Object> retMap =new HashMap<String, Object>();
		custNo= jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		}
		Paging<Map<String, Object>> page = activeService.goodsReward(custNo, currentPageNo, pageSize);
		List<Map<String, Object>> list =page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 分页查询邀请人投资记录
	 * @param request
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ShowFriendRewardRecord")
	@ResponseBody
	public Map<String, Object> ShowFriendrewardRecord(HttpServletRequest request,
		@RequestParam(value = "currentPageNo",required =false)Integer currentPageNo,
		@RequestParam(value="pageSize",required = false)Integer pageSize,
		@RequestParam("custNo")String custNo
		){
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
	    pageSize = pageSize == null ? 10:pageSize;
		Map<String, Object> retMap =new HashMap<String, Object>();
		custNo= jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		}
		P2p_user user =  userService.getByLoginCustNo(custNo);
		if(user!=null){
			//好友投资记录
			Paging<Map<String, Object>> page = activeService.getFriendTenderRecordBycustNo(user.getPuCustNo(), currentPageNo, pageSize, "", "","");
			
			List<Map<String, Object>> list =page.getPageList();
			if(list!=null){
				for(Map<String, Object> lists: list){
					String retphone = (String) lists.get("pu_mobile");
					retphone=retphone.substring(0,3)+"**"+retphone.substring(7, 11);
					lists.put("pu_mobile",retphone );
				}
				
			}
			retMap.put("countTotal", page.getCountTotal());
			retMap.put("endNum",page.getEndPageNo() );
			retMap.put("statrNum",page.getStartPageNo());
			retMap.put("list", list);
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		}
		return retMap;
	}
	/**
	 * 分页查询邀请人信息
	 * @param request
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ShowFriendRecord")
	@ResponseBody
	public Map<String, Object> ShowFriendRecord(HttpServletRequest request,
		@RequestParam(value = "currentPageNo",required =false)Integer currentPageNo,
		@RequestParam(value="pageSize",required = false)Integer pageSize,
		@RequestParam("custNo")String custNo
		){
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
	    pageSize = pageSize == null ? 10:pageSize;
		Map<String, Object> retMap =new HashMap<String, Object>();
		custNo= jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			retMap.put(Const.retCode, false);
			return retMap;
		}
		P2p_user user =  userService.getByLoginCustNo(custNo);
		if(user!=null){
			Paging<Map<String, Object>>  page =activeService.queryFriendRecordBycustNo(custNo,currentPageNo,pageSize,"","","");
			List<Map<String, Object>> list =page.getPageList();
			if(list!=null){
				for(Map<String, Object> lists : list){
					String retphone = (String) lists.get("pu_mobile");
					retphone=retphone.substring(0,3)+"****"+retphone.substring(7, 11);
					lists.put("pu_mobile",retphone );
				}
				
			}
			retMap.put("countTotal", page.getCountTotal());
			retMap.put("endNum",page.getEndPageNo() );
			retMap.put("statrNum",page.getStartPageNo());
			retMap.put("list", list);
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		}
		return retMap;
	}
	/**
	 * 活动通知{App推送}
	 * @return
	 */
	@RequestMapping(value="actionNotice",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> actionNotice(){
		Map<String, Object>  result =new HashMap<String, Object>();
		//result.put("title","投资送酒");
		//result.put("url","https://www.quanziben.com/service/msg/activityMoneyRecordHtml");
		result.put(Const.retCode,true);
		return result;
	}
	/**
	 * 意见反馈
	 * @param content
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="/feedback",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> feedback(HttpServletRequest request,String content,String phone,String custNo){

		AppCallLogUtil.printMsg(request, "AppMsg.feedback","phone","content","custNo");
		Map<String, Object>  retMap =new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
            retMap.put(Const.retMsg, Const.noLoginMsg);
            retMap.put(Const.retCode, false);
            return retMap;
        }
		if(StringUtil.isEmpty(custNo) || StringUtil.isEmpty(phone) || StringUtil.isEmpty(content)){
			retMap.put(Const.retMsg,"\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303"); //参数不符合规范
			retMap.put(Const.retCode, false);
			return retMap;
		}
		try {
			msgService.saveFeedback(custNo,phone, content);
			retMap.put(Const.retMsg,"\u975e\u5e38\u611f\u8c22\u60a8\u7684\u5b9d\u8d35\u610f\u89c1"); //非常感谢您的宝贵意见
			retMap.put(Const.retCode, true);
		} catch (Exception e) {
		    logger.error("意见反馈接口出错,接口名AppMsg/feedback", e);
			retMap.put(Const.retMsg,"\u63d0\u4ea4\u5931\u8d25");//提交失败
			retMap.put(Const.retCode, false);
		}
		return retMap;
	}
	
	/**
	 * android在线升级
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/appDown")
	@ResponseBody
	public Map<String, Object> download(HttpServletRequest request,HttpServletResponse response){
		AppCallLogUtil.printMsg(request, "AppMsg.appDown");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			P2p_mobile_app apps = mobileAppService.findAll();
			if(null!=apps){
				result.put("name", apps.getName());
				result.put("version", apps.getVersion());
//				result.put("url", apps.getUrl());
				result.put("remarks", apps.getRemarks());
				result.put("type", apps.getType());
			}else{
				result.put("name", "");
				result.put("version", "");
//				result.put("url", "");
				result.put("remarks", "");
				result.put("type", "");
			}
			result.put(Const.retCode,true );
			result.put(Const.retMsg, "\u6267\u884c\u6210\u529f");//执行成功
		} catch (Exception e) {
			logger.error("download", e);
			result.put(Const.retMsg,"\u6267\u884c\u5931\u8d25");//执行失败
			result.put(Const.retCode, false);
		}
		return result;
	}
	/**
	 * app下载
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	@RequestMapping("/appDownload")
	public void appDownload(HttpServletRequest request,HttpServletResponse response) throws Exception{
			AppCallLogUtil.printMsg(request, "AppMsg.appDownload");
			P2p_mobile_app app =  mobileAppService.findAll();
			if(app!=null){
				app.setDownloadNum(app.getDownloadNum()+1);
			    int a = mobileAppService.updateMobileApp(app);
				ByteArrayOutputStream output = new ByteArrayOutputStream();
				FdfsFile file = new FdfsFile(URLDecoder.decode(app.getUrl(), "utf-8"), output);
				FdfsUtils.download(file);
			   
				BufferedOutputStream bos = null;
				BufferedInputStream bis = null;
				try {
					byte[] out = output.toByteArray();
					 response.setContentType("text/html;charset=utf-8");
					 response.setContentType("application/x-msdownload;");
					 response.setHeader("Content-disposition", "attachment; filename="
								+"bbjf.apk");
					 response.setHeader("Content-Length", String.valueOf(out.length));
					 
					 byte[] buff = new byte[2048*100];
					 bis = new BufferedInputStream(new ByteArrayInputStream(out));
					 bos = new BufferedOutputStream(response.getOutputStream());
					 int bytesRead;
					 while (-1 != (bytesRead = bis.read(buff))) {
						 bos.write(buff, 0, bytesRead);
					 }
					 
//					bos = new BufferedOutputStream(response.getOutputStream());
//					
//					//int bytesRead;
//					int i ;
//					for(i=0;i<out.length;i++){
//						bos.write(out, 0, i);
//					}
//					bos.flush();
//					while (-1 != (bytesRead = bis.read(out, 0, out.length))) {
//						bos.write(out, 0, bytesRead);
//					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					if (bis != null)
						try {
							bis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					if (bos != null)
						try {
							bos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
				}
			}
		
	}
	
	
	/**
	 * 注册邀请送专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/appInviteSpecial")*/
	public ModelAndView appInviteSpecial(HttpServletRequest request){
		ModelAndView  model = new ModelAndView("/app/appInviteSpecial");
		return model;
	};
	
	/**
	 * app幸运大转盘规则页面（banner点击进入）
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/appTurntableRules")*/
	public ModelAndView appTurntableRules(HttpServletRequest request){
		ModelAndView  model = new ModelAndView("/app/appTurntableSpecial");
		return model;
	};
	
	/**
	 * app幸运大转盘抽奖页
	 * @param request
	 * @return
	 */
	@RequestMapping("/toluckDraw")
	public ModelAndView toluckDraw(HttpServletRequest request,
			@RequestParam(value = "custNo",required =true) String custNo){
		ModelAndView model = new ModelAndView("/app/appluckDraw");
		P2p_user user=null;
		int custNoCount = 0;
		if(StringUtil.isNotEmpty(custNo)){
			user=userService.getByLoginCustNo(jedisUtil.getValue(custNo));
		}
		if(user!=null){
			//查询用户抽奖次数(当天)
			try {
				custNoCount = activeService.queryLotteryDrawCount(user.getPuCustNo());
				model.addObject("ifLogin", true);
				model.addObject("custNo", custNo);
			} catch (BusinessException e) {
				logger.error("toluckDraw", e);
			}
		}
		model.addObject("custNoCount", custNoCount);
		return model;
	};
	
	/**
	 * App大转盘活动抽奖
	 * @param reques
	 * @return
	 */
	 @RequestMapping("appLotteryDraw")
	 @ResponseBody
	public Map<String, Object> appLotteryDraw(HttpServletRequest reques,
			@RequestParam(value = "custNo",required =true) String custNo){
		Map<String, Object> result = new HashMap<String, Object>();
		custNo=jedisUtil.getValue(custNo);
		P2p_user user=null;
		if(StringUtil.isNotEmpty(custNo)){
			user=userService.getByLoginCustNo(custNo);
		}
		try {
			if(user!=null){
				result = activeService.lotteryDraw(custNo);
			}else{
				result.put("prizeNo", 8);
				result.put("prizeName", "谢谢参与");
			}
		} catch (BusinessException e) {
			logger.error("appLotteryDraw", e);
		}
		return result;
	}
	
	/**
	 * 跳转APP登录页
	 * @return
	 */
	@RequestMapping("/appLogin")
	public ModelAndView appLogin(){
		ModelAndView model = new ModelAndView("/app/jump");
		return model;
	};
	/**
	 * 投资送大奖页面
	 * @return
	 */
	/*#RequestMapping("/givePrize")*/
	public ModelAndView givePrize(){
		ModelAndView model = new ModelAndView("/app/givePrize");
		return model;
	}
	/**
	 * 平台升级页面
	 * @return
	 */
	/*#RequestMapping("/upgrade")*/
	public ModelAndView upgrade(){
		ModelAndView model = new ModelAndView("/app/upgrade");
		return model;
	}
	
	/**
	 * 中融佰诚荣升网金委副理事长单位
	 * @return
	 */
	/*#RequestMapping("/appNetGoldCommission")*/
	public ModelAndView appNetGoldCommission(){
		ModelAndView model = new ModelAndView("/app/appNetGoldCommission");
		return model;
	}
	
	/**
	 * 跳转APP注册页
	 * @return
	 */
	@RequestMapping("/appRegister")
	public ModelAndView appRegister(){
		ModelAndView model = new ModelAndView("/app/jump");
		return model;
	};
	
	/**
	 * 跳转APP投资列表
	 * @return
	 */
	@RequestMapping("/appProductList")
	public ModelAndView appProductList(){
		ModelAndView model = new ModelAndView("/app/jump");
		return model;
	};
	
	/**
	 * 新浪专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/appSina")*/
	public ModelAndView appSina(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/app/appSina");
		return model;
	};
	
	/**
	 * 帮助中心
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/appHelpCenter")*/
	public ModelAndView appHelpCenter(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/app/appHelpCenter");
		return model;
	};
	
	/**
	 * 数据保全专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/appDataSecurity")*/
	public ModelAndView appDataSecurity(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/app/appDataSecurity");
		return model;
	};
}
