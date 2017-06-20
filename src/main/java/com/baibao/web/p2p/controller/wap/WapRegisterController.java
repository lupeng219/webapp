package com.baibao.web.p2p.controller.wap;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.controller.RegisterController;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.UserService;

//@Controller
@RequestMapping("/wapRegister")
public class WapRegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private BaseLog baseLog;
	@Autowired
	private UserService userService;
	/**
	 * 到注册页面
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/toWapRegister")*/
	public String toH5Register(HttpServletRequest request,Model model){
		String invitingMobile = request.getParameter("code");
		model.addAttribute("invitingMobile", invitingMobile);
		return "/wap/wapRegister";
	}
	
	/**
	 * 注册协议
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/registerAgreement")*/
	public String registerAgreement(HttpServletRequest request){
		return "/wap/registerAgreement";
	}
	
	/**
	 * 注册
	 * 
	 * @param userName 用户名
	 * @param mobile 手机号/邮箱
	 * @param verification  验证码
	 * @param passd密码
	 * @param friendMobile 推荐人
	 * @return result
	 */
	@RequestMapping("/wapRegister")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request,
			String mobile, String verification, String passd,String friendMobile) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = userService.addUsers(mobile, verification, passd, friendMobile, RegistType.WAP.getIndex(), null);
		} catch (BusinessException e) {
			e.printStackTrace();
			logger.error("\u6ce8\u518c\u5931\u8d25");
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "注册失败");//注册失败
		}
		
		baseLog.writer(mobile,"",result.toString(),BusinessType.REGISTER.getDesc(), RegistType.WAP.getName(), "/wapRegister");
		return result;
	}
}
