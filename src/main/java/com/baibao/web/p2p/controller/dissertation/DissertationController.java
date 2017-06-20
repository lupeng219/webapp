package com.baibao.web.p2p.controller.dissertation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.IsMobile;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 我的活动
 * @date 2016年1月27日
 */
@Controller
@RequestMapping("/dissertation")
public class DissertationController {
	private static Logger log = LoggerFactory.getLogger(DissertationController.class);
	
	@Autowired
	private ActiveService activeService;
	/**
	 * 2015年---双十二活动专题页
	 * @return String
	 */
	/*#RequestMapping("/toTwelveActivity")*/
	public String toTwelveActivity(HttpServletRequest request){
		return "seckill/special/twelveActivity";
	};
	
	/**
	 * 2015年---新年活动专题页
	 * @return String
	 */
	/*#RequestMapping("/toNewYear")*/
	public String toNewYear(HttpServletRequest request){
		return "seckill/special/newYear";
	};
	
	/**
	 * app宣传专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/appSpecial")*/
	public String appSpecial(HttpServletRequest request) {
		return "seckill/special/appSpecial";
	}
	
	/**
	 * 新浪支付专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/sinaSpecial")*/
	public String sinaSpecial(HttpServletRequest request) {
		return "seckill/special/sinaSpecial";
	}
	
	/**
	 * 邀请好友专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/inviteFriends")*/
	public String inviteFriends(HttpServletRequest request) {
		return "seckill/special/inviteFriends";
	}
	
	/**
	 * 大转盘专题页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/slyderAdventures")*/
	public String slyderAdventures(HttpServletRequest request,Model model){
		P2p_user user = (P2p_user) SessionUtils.getAttrFromSession(request, Const.CURRENT_LOGIN_USER);
		int custNoCount = 0;
		List<Map<String, Object>> spoilList = new ArrayList<Map<String, Object>>();
		try {
			if(user!=null){
				//查询用户抽奖次数(当天)
				custNoCount = activeService.queryLotteryDrawCount(user.getPuCustNo());
			}
			//查询用户中奖纪录
			spoilList = activeService.querySpoilList();
		} catch (BusinessException e) {
			log.error("slyderAdventures", e);
		}
		model.addAttribute("custNoCount", custNoCount);
		model.addAttribute("spoilList", spoilList);
		return "seckill/special/slyderAdventures";
	}
	
	/*#RequestMapping("/minisite")*/
	public String minisite(HttpServletRequest request,Model model){
		P2p_user user = (P2p_user) SessionUtils.getAttrFromSession(request, Const.CURRENT_LOGIN_USER);
		int custNoCount = 0;
		try {
			if(user!=null){
				//查询用户抽奖次数(当天)
				custNoCount = activeService.queryLotteryDrawCount(user.getPuCustNo());
			}
		} catch (BusinessException e) {
			log.error("minisite", e);
		}
		model.addAttribute("custNoCount", custNoCount);
		//手机浏览器请求
		Boolean flag = IsMobile.JudgeIsMoblie(request);
		if(flag){
			return "/wap/wapActiveAxis";
		}else{
			return "seckill/special/activeAxis";
		}
	}
	
	/**
	 * 数据保全
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/dataSecurity")*/
	public String dataSecurity(HttpServletRequest request) {
		return "seckill/special/dataSecurity";
	}
}
