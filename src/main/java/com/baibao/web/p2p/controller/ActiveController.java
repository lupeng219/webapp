package com.baibao.web.p2p.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.RedEnvelopeType;
import com.baibao.web.p2p.service.ActiveService;

@Controller
@RequestMapping("/active")
public class ActiveController {
	
	private static Logger logger = LoggerFactory.getLogger(ActiveController.class); 
	
	@Autowired
	private ActiveService activeService;
	/**
	 * 我的优惠券
	 * @param request
	 * @return
	 * @throws BusinessException 
	 */
	/*#RequestMapping("/toMyActive")*/
	public ModelAndView toMyActive(HttpServletRequest request) throws BusinessException {
		
		logger.info("toMyActive parameter : ");
		
		ModelAndView  model = new ModelAndView("seckill/mySeckill");
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		if(user!=null){
			String  inviteCode=user.getPuInviteCode();
			model.addObject("inviteCode",inviteCode);
			//未使用优惠卷列表
			List<Map<String, Object>>  noUseList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.noUseStatus.getIndex()+"");
			//已使用优惠卷列表
			List<Map<String, Object>>  usedList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.usedStatus.getIndex()+"");
			//已过期优惠卷列表
			List<Map<String, Object>>  overTimeList = activeService.queryRedenvelopeBycustNo(user.getPuCustNo(),RedEnvelopeType.overTimeStatus.getIndex()+"");
			model.addObject("noUseList",noUseList);
			model.addObject("usedList",usedList);
			model.addObject("overTimeList",overTimeList);
		}
		logger.info(String.format("toMyActive parameter : --- return : model = %s", 
        		JsonHelper.formatJson(model)));
		return model;
	}
	
	/**
	 * 邀请好友页面
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/inviteFriends")*/
	public ModelAndView inviteFriends(HttpServletRequest request) {
		
		logger.info("inviteFriends parameter : ");
		
		ModelAndView  model = new ModelAndView("seckill/inviteFriends");
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		if(user!=null){
			String  inviteCode=user.getPuInviteCode();
			model.addObject("inviteCode",inviteCode);
			//邀请人记录
			Paging<Map<String, Object>>  page =activeService.queryFriendRecordBycustNo(user.getPuCustNo(),1,10,"","","");
			List<Map<String, Object>> list =page.getPageList();
			//邀请人投资记录
			Paging<Map<String, Object>> tenderPage = activeService.getFriendTenderRecordBycustNo(user.getPuCustNo(), 1, 10, "","","");
			List<Map<String, Object>> tenderList =page.getPageList();
			model.addObject("paging", page);
			model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
			model.addObject("ajaxPageUrl","active/ajaxShowFriendRecord");
			model.addObject("tenderPaging", tenderPage);
			model.addObject("tenderListTotal", (tenderList!=null&&tenderList.size()>0)?tenderList.size():0);
			model.addObject("tenderAjaxPageUrl","active/ajaxShowFriendTenderRecord");
		}
		logger.info(String.format("inviteFriends parameter : --- return : model = %s", 
        		JsonHelper.formatJson(model)));
		return model;
	}
	
	/**
	 * 分页查询邀请人记录
	 * @param request
	 * @param currentPageNo
	 * @return
	 */
	/*#RequestMapping("/ajaxShowFriendRecord")*/
	public ModelAndView  ajaxShowFriendRecord(HttpServletRequest request,
		@RequestParam(required=false,value="currentPageNo")Integer currentPageNo,
		@RequestParam(required=false,value="startTime")String startTime,
		@RequestParam(required=false,value="endTime")String endTime,
		@RequestParam(required=false,value="userMobile")String userMobile){
		
		logger.info(String.format("ajaxShowFriendRecord parameter : currentPageNo = %s, "
				+ "startTime = %s, endTime = %s, userMobile = %s", 
				currentPageNo, startTime, endTime, userMobile));
		
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		ModelAndView model = new ModelAndView("seckill/_friendRecordPage");
		if(user!=null){
			//邀请好友记录
			Paging<Map<String, Object>>  page =activeService.queryFriendRecordBycustNo(user.getPuCustNo(),currentPageNo,10,startTime,endTime,userMobile);
			List<Map<String, Object>> list =page.getPageList();
			//好友投资记录
			model.addObject("paging", page);
			model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
			model.addObject("ajaxPageUrl","active/ajaxShowFriendRecord");
			model.addObject("startTime",startTime);
			model.addObject("endTime",endTime);
			model.addObject("userMobile",userMobile);
		}
		
		logger.info(String.format("ajaxShowFriendRecord parameter : currentPageNo = %s, "
				+ "startTime = %s, endTime = %s, userMobile = %s --- return : model = %s", 
				currentPageNo, startTime, endTime, userMobile, JsonHelper.formatJson(model)));
		return model;
	}
	
	/**
	 * 分页查询邀请人投资记录
	 * @param request
	 * @param currentPageNo
	 * @return
	 */
	/*#RequestMapping("/ajaxShowFriendTenderRecord")*/
	public ModelAndView  ajaxShowFriendTenderRecord(HttpServletRequest request,
		@RequestParam(required=false,value="currentPageNo")Integer currentPageNo,
		@RequestParam(required=false,value="startTime")String startTime,
		@RequestParam(required=false,value="endTime")String endTime,
		@RequestParam(required=false,value="userMobile")String userMobile){
		
		logger.info(String.format("ajaxShowFriendTenderRecord parameter : currentPageNo = %s, "
				+ "startTime = %s, endTime = %s, userMobile = %s", 
				currentPageNo, startTime, endTime, userMobile));
		
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		ModelAndView model = new ModelAndView("seckill/_invitationAwardPage");
		if(user!=null){
			//好友投资记录
			Paging<Map<String, Object>> page = activeService.getFriendTenderRecordBycustNo(user.getPuCustNo(), currentPageNo, 10, startTime, endTime, userMobile);
			List<Map<String, Object>> tenderList =page.getPageList();
			model.addObject("tenderPaging", page);
			model.addObject("tenderListTotal", (tenderList!=null&&tenderList.size()>0)?tenderList.size():0);
			model.addObject("tenderAjaxPageUrl","active/ajaxShowFriendTenderRecord");
			model.addObject("tenderStartTime",startTime);
			model.addObject("tenderEndTime",endTime);
			model.addObject("tenderUserMobile",userMobile);
		}
		
		logger.info(String.format("ajaxShowFriendTenderRecord parameter : currentPageNo = %s, "
				+ "startTime = %s, endTime = %s, userMobile = %s --- return : model = %s", 
				currentPageNo, startTime, endTime, userMobile, JsonHelper.formatJson(model)));
		return model;
	}
	
	/**
	 * 大转盘活动
	 * @param reques
	 * @return
	 */
	 /*#RequestMapping("lotteryDraw")*/
	 @ResponseBody
	public Map<String, Object> lotteryDraw(HttpServletRequest reques){
		 
		logger.info("lotteryDraw parameter : ");
		Map<String, Object> result = new HashMap<String, Object>();
		String custNo = SecurityUserHolder.getCustNo();
		try {
			result = activeService.lotteryDraw(custNo);
		} catch (BusinessException e) {
			logger.error("lotteryDraw", e);
		}
		
		logger.info(String.format("lotteryDraw parameter : --- return : result = %s", 
				JsonHelper.formatJson(result)));
		return result;
	}
	 
	 /**
	  * 实物奖励
	  * @param reques
	  * @return
	  */
	 /*#RequestMapping("physicalReward")*/
	 public ModelAndView physicalReward(HttpServletRequest reques,
		 @RequestParam(value = "currentPageNo",required =false)Integer currentPageNo,
		 @RequestParam(value="pageSize",required = false)Integer pageSize){
		 
		 logger.info(String.format("physicalReward parameter : currentPageNo = %s, pageSize = %s", 
				 currentPageNo, pageSize));
		 
		 ModelAndView model = new ModelAndView("seckill/physicalReward");
		 String custNo = SecurityUserHolder.getCustNo();
		 Paging<Map<String, Object>> page = activeService.goodsReward(custNo, 1, 20);
		 model.addObject("paging",page);
		 
		 logger.info(String.format("physicalReward parameter : currentPageNo = %s, pageSize = %s --- return : model = %s", 
				 currentPageNo, pageSize, JsonHelper.formatJson(model)));
		 return model;
	 }
	
}
