package com.baibao.web.p2p.controller.wap;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.comm.StatisticalvisitorUtil;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.SMSUtil;

//@Controller
@RequestMapping("/wapLogin")
public class WapLoginController {
	
	private static Logger logger = LoggerFactory.getLogger(WapLoginController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private SMSUtil sMSUtil;
	@Autowired
	Md5PasswordEncoder passwordEncode;
	/**
	 * wap登陆页面
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/toWapLogin")*/
	public String toH5LoginIndex(HttpServletRequest request){
		return "/wap/wapLogin";
	}
	
	/**
	 * wap找回登录密码页:第一步
	 * @return
	 */
	/*#RequestMapping("/wapFindPassWordOne")*/
	public String wapFindPassWordOne(HttpServletRequest request){
		return "/wap/wapFindPassWordOne";
	}
	
	/**
	 * wap找回登录密码页：第二步
	 * @return
	 */
	/*#RequestMapping("/wapFindPassWordTwo")*/
	public String wapFindPassWordTwo(HttpServletRequest request){
		return "/wap/wapFindPassWordTwo";
	}
	
	
	/**
	 * 验证图片验证码(登录密码找回)
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/getPhoneVar")*/
	public @ResponseBody Map<String, Object> testingImageCode(HttpServletRequest request,
			@RequestParam(value="mobile",required=true) String mobile,
			@RequestParam(value="imgVer",required=true) String imgVer){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("retCode", true);
		//获得图片验证码
		String realCheckCode = (String) SessionUtils.getAttrFromSession(request, Const.SCAPTCHA);
		//判断图片验证码是否正确
		if (!imgVer.toUpperCase().equals(realCheckCode)) {
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u56fe\u7247\u9a8c\u8bc1\u7801\u9519\u8bef");//图片验证码错误
			return map;
		}
		try {
			map = getPhoneVar(request,mobile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	};
	
	/**
	 * 手机发送验证码(登录密码找回)
	 * @param request
	 * @return
	 */
	public  Map<String, Object> getPhoneVar(HttpServletRequest request,String userMobile){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			P2p_user user =  userService.findUserByMobile(userMobile);
			if(user!=null){
				map = sMSUtil.sendValidateCode(request,MessageType.LOGINPASSWORD.getIndex(), userMobile);
			}else{
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "\u9a8c\u8bc1\u5df2\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u627e\u56de\u5bc6\u7801");//用户手机号不存在
			}
		}catch(Exception e){
			logger.error(" send code error",e);
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u8bf7\u586b\u5199\u6b63\u786e\u7684\u7ed1\u5b9a\u7684\u624b\u673a\u53f7");//请填写正确的绑定的手机号
		}
		return map;
	};
	
	
	/**
	 * 验证手机验证码(登录密码找回)
	 * @param request
	 * @param userMobile 用户手机号
	 * @param validateCode 手机验证码
	 * @return
	 */
	/*#RequestMapping("/testingverifyCode")*/
	public @ResponseBody Map<String, Object> testingverifyCode(HttpServletRequest request,
			@RequestParam(value="userMobile",required=true) String userMobile,
			@RequestParam(value="validateCode",required=true) String validateCode,
			@RequestParam(value="imgVer",required=true) String imgVer){
		Map<String, Object> map=new HashMap<String, Object>();
		String temp=jedisUtil.getValue(userMobile);
		if(null==temp||temp==""){
			map.put(Const.retCode,false);
			map.put(Const.retMsg,"\u9a8c\u8bc1\u7801\u5df2\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");//验证码已失效，请重新获取
			return map;
		}
		
		//获得图片验证码
		String realCheckCode = (String) SessionUtils.getAttrFromSession(request, Const.SCAPTCHA);
		//判断图片验证码是否正确
		if (!imgVer.toUpperCase().equals(realCheckCode)) {
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u9a8c\u8bc1\u7801\u9519\u8bef");//验证码错误
			return map;
		}
				
		if(validateCode !=null){
			if(!temp.equals(validateCode)){
				map.put(Const.retCode, false);
				map.put(Const.retMsg,"\u77ed\u4fe1\u9a8c\u8bc1\u7801\u9519\u8bef");//短信验证码错误
				return map;
			}else{
				map.put(Const.retCode, true);
				SessionUtils.putAttrInSession(request, "userMobile", userMobile);
				jedisUtil.setValue("UPDATE_LOGINPWD_IS_VERIFIED"+userMobile, "VERIFIED", 60*10);
			}
		}
		return map;
	};
	
	/**
	 * 重设密码(登录密码找回)
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/updatePassword")*/
	public @ResponseBody Map<String, Object> updatePassword(HttpServletRequest request,
			@RequestParam(value="password",required=true) String newPassword,
			@RequestParam(value="passwordSub",required=true) String newPasswordSub){
		Map<String, Object> map=new HashMap<String, Object>();
		if(!newPassword.equals(newPasswordSub)){
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");//两次密码不一致，请重新输入
			return map;
		}
		String mobile=(String)SessionUtils.getAttrFromSession(request, "userMobile");
		String isVerified = jedisUtil.getValue("UPDATE_LOGINPWD_IS_VERIFIED"+mobile);
		if(StringUtils.isEmpty(isVerified)||mobile == null){
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u9a8c\u8bc1\u5df2\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u627e\u56de\u5bc6\u7801");//验证已失效，请重新找回密码
			return map;
		}
		try{
			P2p_user user =  userService.findUserByMobile(mobile);
			if(user == null){
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "\u7528\u6237\u4fe1\u606f\u4e0d\u5b58\u5728");//用户信息不存在
				return map;
			}
			String password = passwordEncode.encodePassword(newPassword,user.getPuCustNo());
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("custNo", user.getPuCustNo());
			params.put("password",password);
			params.put("registType","WAP");
			userService.updateLoginPassword(params);
			map.put(Const.retCode, true);
			SessionUtils.removeFromSession(request, "userMobile");
		}catch(Exception e){
			logger.error("update password error", e);
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u66f4\u65b0\u5bc6\u7801\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");//更新密码失败，请稍后重试
		}
		return map;
	};
	
	
	/**
	 * 关于我们
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapAboutWe")*/
	public String wapAboutWe(HttpServletRequest request){
		return "/wap/wapAboutWe";
	};
}
