package com.baibao.web.p2p.controller.wap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.StatisticalvisitorUtil;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.p2p_sysMsg;
import com.baibao.web.p2p.generator.dataDIC.RedEnvelopeType;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.MobileAppService;
import com.baibao.web.p2p.service.MsgService;
import com.baibao.web.p2p.service.UserService;

//@Controller
@RequestMapping("/wapMessages")
public class WapMessagesController {

	
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
	/**
	 * 消息list
	 * @param cursor
	 * @param count
	 * @return
	 */
	/*#RequestMapping(value="/wapFindmsg")*/
	public String findmsg(HttpServletRequest request,Integer currentPageNo,Integer pageSize,Model model){
		Map<String, Object> retMap = new HashMap<String, Object>();
		P2p_user user = SecurityUserHolder.getCurrentUser();
		currentPageNo=currentPageNo==null?1:currentPageNo;
		pageSize=pageSize==null?10:pageSize;
		Paging<p2p_sysMsg> page = msgService.findList(currentPageNo, pageSize,user.getPuCustNo());
		List<p2p_sysMsg> list = page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo()); 
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "查询成功");//查询成功
		model.addAttribute("result", retMap);
		model.addAttribute("pageNum", currentPageNo);
		model.addAttribute("endNum", page.getPageTotal());
		return "/wap/wapFindmsg";
	}
	
	/**
	 * 消息详情
	 * @param id
	 * @return
	 */
	/*#RequestMapping(value="/wapMsgDetails")*/
	public String wapMsgDetails(HttpServletRequest request,String msgIds,Model model){
		try {
			p2p_sysMsg sysMsg = msgService.selectById(msgIds);
			model.addAttribute("sysMsg", sysMsg);
			//标记为已读
			msgService.setMsgReaded(msgIds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/wap/wapMsgDetails";
	}
	
	/**
	 * 删除站内信
	 * @param request
	 * @param msgIds
	 * @return
	 */
	/*#RequestMapping("/wapDeleteMsg")*/
	public @ResponseBody Map<String, Object> deleteMsg(HttpServletRequest request,String msgIds){
		Map<String, Object> result = new HashMap<String, Object>();
		String msgId[] = msgIds.split(",");
		int i = 0;
		for (String id : msgId) {
			try {
				 msgService.deleteMsg(id);
				 i++;
			} catch (Exception e) {
				result.put(Const.retCode,false);
				result.put(Const.retMsg,"删除站内信失败");
				break;
			}
		}
		if(i != msgId.length){
			result.put(Const.retCode,false);
			result.put(Const.retMsg,"删除站内信失败");
			return result;
		}
		result.put(Const.retCode,true);
		result.put(Const.retMsg,"删除成功");
		return result;
	}
	
	/**
	 * 标记已读站内信
	 * @param SysMsgID
	 * @return
	 */
	/*#RequestMapping("/wapReadMsg")*/
	@ResponseBody
	public Map<String, Object>readMsg(String msgIds){
		Map<String, Object> retMsg = new HashMap<String, Object>();
		String msgId[] = msgIds.split(",");
		int i=0;
		for(String id : msgId){
			try {
				 msgService.setMsgReaded(id);
				 i++;
			} catch (Exception e) {
				e.printStackTrace();
				retMsg.put(Const.retMsg, "操作失败");//操作失败
				retMsg.put(Const.retCode, false);
				return retMsg;
			}
			
		}
		if(i != msgId.length){
			retMsg.put(Const.retMsg, "操作失败");//操作失败
			retMsg.put(Const.retCode, false);
			return retMsg;
		}
		retMsg.put(Const.retMsg, "操作成功");//操作成功
		retMsg.put(Const.retCode, true);
		return retMsg;
	}
	
	/**
	 * 优惠活动
	 * @param custNo
	 * @return
	 */
	/*#RequestMapping(value="/wapActive")*/
	@ResponseBody
	public Map<String, Object>active(String custNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo=jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retMsg,"参数不符合规范");//参数不符合规范
			retMap.put(Const.retCode, false);
			return retMap;
		}
		P2p_user user = userService.getByLoginCustNo(custNo);
		if(user!=null){
			try {
				String  inviteCode=user.getPuInviteCode();
				retMap.put("invitationUrl",Const.basePath+"/service/wapRegister/toWapRegister?code="+inviteCode );
				retMap.put("shareIllustrates","中融佰诚-高收益等你来拿！！安全稳定放心，快来加入吧！");
				//未使用优惠卷列表
				List<Map<String, Object>>  noUseList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.noUseStatus.getIndex()+"");
				if(noUseList!=null){
					for(Map<String, Object> map:noUseList ){
						map.put("puw_code", "红包");
					}
				}
				
				//已使用优惠卷列表
				List<Map<String, Object>>  usedList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.usedStatus.getIndex()+"");
				//已过期优惠卷列表
				List<Map<String, Object>>  overTimeList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.overTimeStatus.getIndex()+"");
				retMap.put("noUseList",noUseList);
				retMap.put("useList",usedList);
				retMap.put("overTimeList",overTimeList);
				retMap.put(Const.retCode, true);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
		}
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
	/*#RequestMapping("/wapGoodsReward")*/
	public String wapGoodsReward(HttpServletRequest request,
			@RequestParam(value = "pageNum",required =false)Integer pageNum,
			@RequestParam(value="pageSize",required = false)Integer pageSize){
		String custNo =  SecurityUserHolder.getCustNo();
		pageNum =pageNum ==null ? 1: pageNum ;
	    pageSize = pageSize == null ?10:pageSize;
		Paging<Map<String, Object>> page = activeService.goodsReward(custNo, pageNum, pageSize);
		List<Map<String, Object>> list =page.getPageList();
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("endNum", page.getPageTotal());
		return "/wap/wapGoodsReward";
	}
}
