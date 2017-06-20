package com.baibao.web.p2p.controller.app;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.ActiveId;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.controller.eventBus.events.SendRedEnvelopeEvent;
import com.baibao.web.p2p.generator.bean.P2p_cust_logon;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.CustLogonService;
import com.baibao.web.p2p.service.UserInfoService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.AppCallLogUtil;


/**
 * @author lupeng
 * @date: 2016年1月4日下午5:35:31
 */
@Controller
@RequestMapping("AppLogin")
public class AppLoginController {
	
	private static final Logger logger = LoggerFactory
            .getLogger(AppLoginController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private Md5PasswordEncoder passwordEncode;
	@Autowired
	private CustLogonService logonService;
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	@Autowired
	private BaseLog baseLog;
	@Autowired
	private SendRedEnvelopeEvent sendRedEnvelopeEvent;
	@Autowired
    private UserInfoService userInfoService;
	
	/**
	 * App登录
	 * @param phone
	 * @param password
	 * @return
	 */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> login(HttpServletRequest request,String phone, String password){
		AppCallLogUtil.printMsg(request, "AppLogin.login", "phone","password");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(phone)|| StringUtil.isEmpty(password)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		
		P2p_user user =  userService.getByLoginName(phone);
		if(user!=null){
			String temp_password = user.getPassword();
			String custNo = user.getPuCustNo();
			String retphone = user.getPuMobile();
			String relpassword = passwordEncode.encodePassword(password, custNo);
			if(!relpassword.equals(temp_password)){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u624b\u673a\u53f7\u7801\u6216\u767b\u5f55\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");//手机号码或登录密码错误，请重新输入
				return retMap;
			}
			if(StringUtil.isNotEmpty(retphone)){
				retMap.put("allphone", retphone); //手机号
				retphone=retphone.substring(0,3)+"****"+retphone.substring(7, 11);
				retMap.put("retphone", retphone);  //手机号
			}else{
				retMap.put("allphone", null); //手机号
			}
			//appId加密
			String	appId = passwordEncode.encodePassword(phone, phone);
			retMap.put("custNo", appId);    //客户号
			//将唯一标志放入缓存中
			jedisUtil.setValue(appId, custNo, 60*60*24*7);
			P2p_cust_logon logon = logonService.getCustLogonByCustNo(custNo);
			if(logon == null){
				logon = new P2p_cust_logon();
				logon.setPclCustNo(custNo);
				logon.setPclLoginsuccNum(1);//成功登陆次数
				logon.setPclFirstLogin(new Date());//首次登陆时间
				logon.setPclLastLoginsucc(new Date());//最后登录成功的时间
				logonService.saveLogon(logon);
				user.setPuLastlogintime(new Date());// 最后登录时间
			}else{
				user.setPuLastlogintime(logon.getPclLastLoginsucc());//最后登录时间
				logon.setPclLastLoginsucc(new Date());//最后登录成功的时间
				logon.setPclLoginsuccNum(logon.getPclLoginsuccNum()+1);//成功登陆次数
				logonService.updateLogonByCustNo(logon);
			}
			if(user.getPuLastlogintime() == null){
				user.setPuLastlogintime(new Date());
			}
			retMap.put(Const.retCode, true);
			//用户头像
			if(StringUtils.isBlank(user.getPuHeadUrl())){
                retMap.put("headUrl", "");
            }else{
                retMap.put("headUrl", this.getUserHeadUrl(request, user.getPuHeadUrl()));
            }
			//是否实名认证
            P2p_user_info info = userInfoService.getByCustNo(custNo);
            if(info!=null && StringUtils.isNotBlank(info.getPuiRealName())){
                retMap.put("puiRealName", info.getPuiRealName());
            }else{
                retMap.put("puiRealName", "");
            }
			
			sendRedEnvelopeEvent.setActiveId(ActiveId.ACTIVEID_520);
			sendRedEnvelopeEvent.setCustNo(user.getPuCustNo());
			
			baseLog.writer(custNo,"",retMap.toString(),BusinessType.LOGINSUCCESS.getDesc(), RegistType.APP.getName(), "/login");
			return retMap;
		}else{
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u624b\u673a\u53f7\u7801\u6216\u767b\u5f55\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");//手机号码或登录密码错误，请重新输入
			return retMap;
		}
	}
	
	private String getUserHeadUrl(HttpServletRequest request, String headUrl){
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        return basePath + "/service/file/" + headUrl;
    }
	
	/**
	 * 忘记密码第一步
	 * @param phone
	 * @param validataCode
	 * @return
	 */
	@RequestMapping(value="/findPasswordByPhone",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findPasswordByPhone(HttpServletRequest request,String phone,String code){
		AppCallLogUtil.printMsg(request, "AppLogin.findPasswordByPhone", "phone","code");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(phone)||StringUtil.isEmpty(code)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		String getCode = jedisUtil.getValue(phone);
		if(StringUtil.isEmpty(getCode)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u9a8c\u8bc1\u7801\u8d85\u65f6\u8bf7\u91cd\u65b0\u83b7\u53d6");//验证码超时请重新获取
			return retMap;			  
		}
		if(!getCode.equalsIgnoreCase(code)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "短信验证码错误，请您重新输入");
			return retMap;
		}
		P2p_user user =  userService.getByLoginName(phone);
		if(user==null){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u7528\u6237\u4e0d\u5b58\u5728\u8bf7\u91cd\u8bd5");//用户不存在请重试
			return retMap;
		}
		//appId加密
		String	appId = passwordEncode.encodePassword(phone, phone);
		retMap.put("custNo", appId);    //客户号
		String custNo = user.getPuCustNo();
		jedisUtil.setValue(appId, custNo, 60*60*24*7);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u624b\u673a\u8ba4\u8bc1\u6210\u529f");//手机认证成功!
		return retMap;
		
	}
	/**
	 * 忘记密码第二步
	 * @param password
	 * @param repassoword
	 * @return
	 */
	@RequestMapping(value="/modifyPassword",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyPassword(HttpServletRequest request,String newPassword,String reNewPassword,String custNo){
		AppCallLogUtil.printMsg(request, "AppLogin.modifyPassword", "newPassword","reNewPassword","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(newPassword) || StringUtil.isEmpty(reNewPassword)||StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		};
		if(!newPassword.equals(reNewPassword)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u5bc6\u7801\u548c\u91cd\u590d\u5bc6\u7801\u4e0d\u76f8\u7b49");//密码和重复密码不相等
			return retMap;
		};
		try {
			if(StringUtil.isNotEmpty(custNo)){
				custNo = jedisUtil.getValue(custNo);
				if(StringUtils.isEmpty(custNo)){
	                retMap.put(Const.retCode, false);
	                retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
	                return retMap;
	            }
				//进行密码加密
				newPassword = passwordEncode.encodePassword(newPassword, custNo);
				P2p_user user = userService.getByLoginCustNo(custNo);
				if(user!=null){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("password", newPassword);
					map.put("custNo", custNo);
					map.put("registType",RegistType.APP.getName() );
					userService.updateLoginPassword(map);
					retMap.put(Const.retCode, true);
					retMap.put(Const.retMsg, "\u4fdd\u5b58\u6210\u529f");//保存成功
					baseLog.writer(custNo,map.toString(),retMap.toString(),BusinessType.RETRIEVEPASSWORD.getDesc(), RegistType.APP.getName(), "/modifyPassword");
					return retMap;
				}else{
					retMap.put(Const.retCode, false);
					retMap.put("msg", "\u8be5\u7528\u6237\u4e0d\u5b58\u5728");//该用户不存在
					return retMap;
				}
			}else{
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u7528\u6237\u672a\u767b\u5f55\u8bf7\u91cd\u8bd5");//用户未登录请重试
				return retMap;
			}
		} catch (Exception e) {
			logger.error("忘记密码修改错误,接口名AppLogin/modifyPassword", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u5fd8\u8bb0\u5bc6\u7801\u4fee\u6539\u9519\u8bef");//忘记密码修改错误
		}
		return retMap;
	}
	/**
	 * 重置密码
	 * @param custNo
	 * @param code
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value="resetPassword",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>resetPassword(HttpServletRequest request,String custNo,String code,String newPassword){
		AppCallLogUtil.printMsg(request, "AppLogin.resetPassword", "code","newPassword","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		if(StringUtil.isEmpty(code) || StringUtil.isEmpty(newPassword) ){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		P2p_user user = userService.getByLoginCustNo(custNo);
		if(user!=null){
			String getCode = jedisUtil.getValue(user.getPuMobile());
			if(StringUtil.isEmpty(getCode)){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u9a8c\u8bc1\u7801\u8d85\u65f6\u8bf7\u91cd\u65b0\u83b7\u53d6");//验证码超时请重新获取
				return retMap;			  
			}
			if(!getCode.equalsIgnoreCase(code)){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "短信验证码错误，请您重新输入");
				return retMap;
			}
			//进行密码加密
			newPassword = passwordEncode.encodePassword(newPassword, custNo);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("password", newPassword);
			map.put("custNo", custNo);
			map.put("registType",RegistType.APP.getName() );
			userService.updateLoginPassword(map);
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u4fdd\u5b58\u6210\u529f");//保存成功
			baseLog.writer(custNo,map.toString(),retMap.toString(),BusinessType.RETRIEVEPASSWORD.getDesc(), RegistType.APP.getName(), "/resetPassword");
		}else{
			retMap.put(Const.retCode, false);
			retMap.put("msg", "\u8be5\u7528\u6237\u4e0d\u5b58\u5728");//该用户不存在
			return retMap;
		}
		return retMap;
	}
	/**
	 * 修改密码
	 * @param oldPassword
	 * @param newPassword
	 * @param reNewPassword
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value="updatePad",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>updatePad(HttpServletRequest request,String oldPassword,
			String newPassword, String reNewPassword, String custNo ){
		AppCallLogUtil.printMsg(request, "AppLogin.updatePad", "oldPassword","newPassword","reNewPassword","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (StringUtil.isEmpty(custNo) || StringUtil.isEmpty(oldPassword)|| StringUtil.isEmpty(newPassword)|| StringUtil.isEmpty(reNewPassword)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}		
		if(!newPassword.equals(reNewPassword)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4");// 两次密码不一致
			retMap.put(Const.retType, "passSub");
			return retMap;
		}
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		oldPassword = md5PasswordEncoder.encodePassword(oldPassword, custNo);
		P2p_user user = userService.getByLoginCustNo(custNo);
		if(user==null){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
			return retMap;
		}
		if(!oldPassword.equals(user.getPuPassword())){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u8bf7\u60a8\u8f93\u5165\u6b63\u786e\u7684\u539f\u767b\u5f55\u5bc6\u7801");//请您输入正确的原登录密码
		}else{
			retMap.put("password", md5PasswordEncoder.encodePassword(newPassword, user.getPuCustNo()));
			retMap.put("custNo", user.getPuCustNo());
			retMap.put("registType", RegistType.APP.getIndex());
			retMap = userService.updateLoginPassword(retMap);
			if((boolean) retMap.get(Const.retCode)){
				retMap.put(Const.retMsg, "\u4fdd\u5b58\u6210\u529f");//保存成功
			}
		}
		baseLog.writer(custNo,"",retMap.toString(),BusinessType.CHANGEPASSWORD.getDesc(), RegistType.APP.getName(), "/updatePad");
		return retMap;
		
	}
	/**
	 * 修改手势密码时验证登录密码
	 * @param request
	 * @param password
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value="checkPadByGesture",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>checkPadByGesture(HttpServletRequest request,
			String password, String custNo ){
		AppCallLogUtil.printMsg(request, "AppLogin.checkPadByGesture", "password","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (StringUtil.isEmpty(custNo) ||  StringUtil.isEmpty(password)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}	
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		password = md5PasswordEncoder.encodePassword(password, custNo);
		P2p_user user = userService.getByLoginCustNo(custNo);
		if(user==null){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
			return retMap;
		}
		if(!password.equals(user.getPuPassword())){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u767b\u5f55\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u60a8\u91cd\u65b0\u8f93\u5165");//登录密码错误，请您重新输入
		}else{
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u5bc6\u7801\u6b63\u786e");//密码正确
		}
		return retMap;
	}

}
