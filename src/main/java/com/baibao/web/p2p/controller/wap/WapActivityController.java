package com.baibao.web.p2p.controller.wap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.comm.StatisticalvisitorUtil;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.dataDIC.RedEnvelopeType;
import com.baibao.web.p2p.service.ActiveService;

//@Controller
@RequestMapping("/wapActivity")
public class WapActivityController {
	
	@Autowired
	private ActiveService activeService;
	/**
	 * web站邀请好友----邀请功能，邀请记录
	 * 
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapInviteFriends")*/
	public String inviteFriends(HttpServletRequest request,
			@RequestParam(value="pageNum",required=false) Integer pageNum) {
		pageNum = (pageNum==null)?1:pageNum;
		P2p_user user = SecurityUserHolder.getCurrentUser();
		//邀请人记录
		Paging<Map<String, Object>>  page =activeService.queryFriendRecordBycustNo(user.getPuCustNo(),pageNum,10,"","","");
		List<Map<String, Object>> list =page.getPageList();
		if(user!=null){
			request.setAttribute("code", user.getPuInviteCode());
		}
		request.setAttribute("paging", page);
		request.setAttribute("list", list);
		request.setAttribute("total", (list!=null&&list.size()>0)?list.size():0);
		request.setAttribute("endNum", page.getPageTotal());
		request.setAttribute("pageNum", pageNum);
		return "/wap/wapInviteFriends";
	}
	
	
	/**
	 * 邀请好友记录分页
	 * @param request
	 * @param pageNum
	 * @return
	 */
	/*#RequestMapping("/ajaxInviteFriends")*/
	public String ajaxInviteFriends(HttpServletRequest request,
			@RequestParam(value="pageNum",required=false) Integer pageNum) {
		pageNum = (pageNum==null)?1:pageNum;
		P2p_user user = SecurityUserHolder.getCurrentUser();
		//邀请人记录
		Paging<Map<String, Object>>  page =activeService.queryFriendRecordBycustNo(user.getPuCustNo(),pageNum,10,"","","");
		List<Map<String, Object>> list =page.getPageList();
		if(user!=null){
			request.setAttribute("code", user.getPuInviteCode());
		}
		request.setAttribute("paging", page);
		request.setAttribute("list", list);
		request.setAttribute("total", (list!=null&&list.size()>0)?list.size():0);
		request.setAttribute("endNum", page.getPageTotal());
		request.setAttribute("pageNum", pageNum);
		return "/wap/_inviteFriends";
	}
	
	/**
	 * 投资推荐记录分页
	 * @param request
	 * @param pageNum
	 * @return
	 */
	/*#RequestMapping("/ajaxRecomTender")*/
	public String ajaxRecomInvite(HttpServletRequest request,
			@RequestParam(value="pageNum",required=false) Integer pageNum) {
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		if(user!=null){
			//好友投资记录
			Paging<Map<String, Object>> page = activeService.getFriendTenderRecordBycustNo(user.getPuCustNo(), pageNum, 10, null, null,null);
			List<Map<String, Object>> list =page.getPageList();
			request.setAttribute("paging", page);
			request.setAttribute("list", list);
			request.setAttribute("total", (list!=null&&list.size()>0)?list.size():0);
			request.setAttribute("endNum", page.getPageTotal());
			request.setAttribute("pageNum", pageNum);
		}
		return "/wap/_recomTender";
	}
	
	/**
	 * 我的活动---优惠券，奖励记录
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapRedEnvelopes")*/
	public ModelAndView redEnvelopeRecordApp(HttpServletRequest request){
		ModelAndView  model = new ModelAndView("/wap/wapRedEnvelopes");
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		if(user!=null){
			try {
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
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			
		}
		return model;
	};
	
	/**
	 * 注册邀请送专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapInviteSpecial")*/
	public ModelAndView wapInviteSpecial(HttpServletRequest request){
		ModelAndView  model = new ModelAndView("/wap/wapInviteSpecial");
		return model;
	};
	
	/**
	 * wap幸运大转盘页面
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapTurntable")*/
	public ModelAndView wapTurntable(HttpServletRequest request){
		ModelAndView  model = new ModelAndView("/wap/wapTurntableSpecial");
		P2p_user user = (P2p_user) SessionUtils.getAttrFromSession(request, Const.CURRENT_LOGIN_USER);
		int custNoCount = 0;
		if(user!=null){
			try {
				//查询用户抽奖次数(当天)
				custNoCount = activeService.queryLotteryDrawCount(user.getPuCustNo());
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		model.addObject("custNoCount",custNoCount);
		return model;
	};
	
	/**
	 * 中融佰诚4.0版全面升级专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapWebsitePromotion")*/
	public ModelAndView wapWebsitePromotion(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/wap/wapWebsitePromotion");
		return model;
	};
	
	/**
	 * 投资送
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapInvestmentDelivery")*/
	public ModelAndView wapInvestmentDelivery(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/wap/wapInvestmentDelivery");
		return model;
	};
	
	/**
	 * 中融佰诚荣升网金委副理事长单位
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapNetGoldCommission")*/
	public ModelAndView wapNetGoldCommission(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/wap/wapNetGoldCommission");
		return model;
	};
	
	/**
	 * 新浪专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapSina")*/
	public ModelAndView wapSina(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/wap/wapSina");
		return model;
	};
	
	/**
	 * 数据保全专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapDataSecurity")*/
	public ModelAndView wapDataSecurity(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/wap/wapDataSecurity");
		return model;
	};
}
