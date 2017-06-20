package com.baibao.web.p2p.controller.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.common.util.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.ActiveId;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.IsMobile;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.controller.eventBus.events.LotteryDrawEvent;
import com.baibao.web.p2p.controller.eventBus.events.SendRedEnvelopeEvent;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_cust_logon;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.CustLogonService;
import com.baibao.web.p2p.service.UserInfoService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.SMSUtil;

/**
 * 登录控制
 * 
 * @author Denny
 * @date 2016年6月21日
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CustLogonService logonService;
    @Autowired
    Md5PasswordEncoder passwordEncode;
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private SMSUtil sMSUtil;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private BaseLog baseLog;
    @Autowired
    private SendRedEnvelopeEvent sendRedEnvelopeEvent;
    @Autowired
    private LotteryDrawEvent lotteryDrawEvent;
    @Autowired
    private ActiveService activeService;
    @Autowired
    private AccountService accountService;

    /**
     * 登陆成功之后的方法
     * 
     * @return
     */
    @RequestMapping("/loginSucc")
    @ResponseBody
    public Map<String, Object> loginSucc(HttpServletRequest request)
    {
    	logger.info("loginSucc parameter : ");
        P2p_user currentUser = SecurityUserHolder.getCurrentUser();
        Map<String, Object> map = new HashMap<String, Object>();

        try
        {
        	P2p_cust_account custAccount = accountService.getCustAccountByCustNo(
        			currentUser.getPuCustNo(), false);
            P2p_cust_logon logon = logonService.getCustLogonByCustNo(currentUser.getPuCustNo());
            P2p_user_info userinfo = userInfoService.getByCustNo(currentUser.getPuCustNo());
            //登陆日志
            if (logon == null)
            {
                logon = new P2p_cust_logon();
                logon.setPclCustNo(currentUser.getPuCustNo());
                logon.setPclLoginsuccNum(1);// 成功登陆次数
                logon.setPclFirstLogin(new Date());// 首次登陆时间
                logon.setPclLastLoginsucc(new Date());// 最后登录成功的时间
                logonService.saveLogon(logon);
                currentUser.setPuLastlogintime(new Date());// 最后登录时间
            } else
            {
                currentUser.setPuLastlogintime(logon.getPclLastLoginsucc());// 最后登录时间
                logon.setPclLastLoginsucc(new Date());// 最后登录成功的时间
                logon.setPclLoginsuccNum(logon.getPclLoginsuccNum() + 1);// 成功登陆次数
                logonService.updateLogonByCustNo(logon);
            }
            
            if (userinfo.getPuiMobilebindtime() != null)
            {
            	SessionUtils.putAttrInSession(request, "isMobilAuth", 1);
            }
            if (userinfo.getPuiEmailbindtime() != null)
            {
            	SessionUtils.putAttrInSession(request, "isEmailAuth", 1);
            }
            if ("0".equals(userinfo.getPuiPlataccountiscert()))
            {
            	SessionUtils.putAttrInSession(request, "isRealNameAuth", 1);
            }
            if (!StringUtil.isEmpty(custAccount.getPcaAccountno()))
            {
            	SessionUtils.putAttrInSession(request, "isBindAccountNo", 1);
            }
            
            if (currentUser.getPuLastlogintime() == null)
            {
                currentUser.setPuLastlogintime(new Date());
            }

            if (!StringUtils.isEmpty(currentUser.getPuHeadUrl()))
            {
                SessionUtils.putAttrInSession(request, "head_url", currentUser.getPuHeadUrl());
            }

            SessionUtils.setCurrentUser(request, currentUser);

            if (userinfo != null)
            {
                SessionUtils.putAttrInSession(request, "isRealName", userinfo.getPuiPlataccountiscert());
            }

            if (StringUtils.isNotEmpty(currentUser.getPuMail()))
            {
                SessionUtils.putAttrInSession(request, "userPuMail", currentUser.getPuMail());
            }

            map.put("retCode", true);
            map.put("retMsg", "登陆成功！");

            baseLog.writer(currentUser.getPuCustNo(), "",
            	map.toString(), BusinessType.LOGINSUCCESS.getDesc(),
                RegistType.PC.getName(), "/login/loginSucc");
        } catch (Exception e)
        {
            logger.error("loginSucc", e);
            baseLog.writer(currentUser.getPuCustNo(), "", map.toString(), BusinessType.LOGINSUCCESS.getDesc(),
                    RegistType.PC.getName(), "/login/loginSucc");
        }
        logger.info(String.format("loginSucc parameter --- return : map = %s", 
        		JsonHelper.formatJson(map)));
        return map;
    }

    /**
     * 登陆失败
     * 
     * @return
     */
    @RequestMapping("/loginFail")
    @ResponseBody
    public Map<String, Object> loginFail(HttpServletRequest request)
    {
    	logger.info("loginFail parameter : ");
        Map<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        Exception exception = (Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        String msg = null;

        if (exception != null)
        {
            msg = exception.getMessage();
            // 只能有一个账户进行登陆
            if (exception instanceof SessionAuthenticationException)
            {
                // 您已经登录，不能重复登录
                msg = "您已经登录，不能重复登录";
            } else if (exception instanceof LockedException)
            {
                // 您的账户已被冻结，请联系平台客服
                msg = "您的账户已被冻结，请联系平台客服";
            }
        } else
        {
            // 用户名或密码错误
            msg = "用户名或密码错误";
        }

        result.put("retCode", false);
        result.put("retMsg", msg);
        logger.info(String.format("loginFail parameter --- return : result = %s", 
        		JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 未登录
     * 
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/unSecurity")
    public String unSecurity(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    	throws IOException
    {
    	logger.info(String.format("unSecurity parameter : model = %s", 
        		JsonHelper.formatJson(model)));
        // 手机浏览器请求
        Boolean flag = IsMobile.JudgeIsMoblie(request);
        if (flag)
        {
        	logger.info(String.format("unSecurity parameter : model = %s ---  return : flag = %s ", 
            		JsonHelper.formatJson(model),flag));

        	String root = request.getContextPath();

        	response.sendRedirect(root + "/service/wapShare/register");

        	return "/wap/tip";
        }
        /**
         * 没有权限的返回应该返回：没有权限提示，目前返回到登陆页面
         */
        String isAjax = request.getParameter("isAjax"); // 所有ajax请求要加该参数,
        if (!StringUtils.isBlank(isAjax))
        {
            Map<String, String> result = new HashMap<String, String>();
            result.put("retMsg", "0000");
            result.put("retCode", "您还没有登陆!");
            responseOutWithJson(response, result);
        } else
        {
        	logger.info(String.format("unSecurity parameter : model = %s ---  return :", 
            		JsonHelper.formatJson(model)));
            // 跳转到登陆页面
            return "login";
        }
        logger.info(String.format("unSecurity parameter : model = %s ---  return :", 
        		JsonHelper.formatJson(model)));
        return null;
    }

    public void responseOutWithJson(HttpServletResponse response, Map<String, String> map)
    {
        // 将实体对象转换为JSON Object转换
        JSONObject responseJSONObject = new JSONObject();
        responseJSONObject.putAll(map);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try
        {
            out = response.getWriter();
            out.append(responseJSONObject.toString());
        } catch (IOException e)
        {
            logger.error("responseOutWithJson", e);
        } finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }

    /**
     * 登陆页面
     * 
     * @return
     */
    @RequestMapping
    public String testSecerty(HttpServletRequest request)
    {
        return "login";
    }

    /**
     * 找回登录密码页
     * 
     * @return
     */
    @RequestMapping("/backLoginPassword")
    public String backLoginPassword(HttpServletRequest request)
    {
        return "backLoginPassword";
    }

    /**
     * 验证图片验证码(登录密码找回)
     * 
     * @param request
     * @return
     */
    @RequestMapping("/testingImageCode")
    public @ResponseBody Map<String, Object> testingImageCode(HttpServletRequest request,
            @RequestParam(value = "mobile", required = true) String mobile,
            @RequestParam(value = "imgVer", required = true) String imgVer)
    {
    	logger.info(String.format("testingImageCode parameter : mobile = %s, imgVer = %s", 
    			mobile,imgVer));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("retCode", true);
        // 获得图片验证码
        String realCheckCode = (String) SessionUtils.getAttrFromSession(request, Const.SCAPTCHA);
        // 判断图片验证码是否正确
        if (!imgVer.toUpperCase().equals(realCheckCode))
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "验证码错误");// 验证码错误
            map.put("errorType", "code");
            logger.info(String.format("testingImageCode parameter : mobile = %s, imgVer = %s --- return : map = %s", 
        			mobile,imgVer,JsonHelper.formatJson(map)));
            return map;
        }
        
        if (StringUtils.isEmpty(mobile))
        {
        	map.put(Const.retCode, false);
        	map.put(Const.retMsg, "手机号不能未空");// 参数不符合规范
        	map.put("errorType", "mobile");
            logger.info(String.format("testingImageCode parameter : mobile = %s, imgVer = %s --- return : map = %s", 
            		mobile, JsonHelper.formatJson(map)));
            return map;
        }
        
        try
        {
            Map<String, Object> result = userService.checkMobileIsExists(mobile);
            if (result != null && !Boolean.valueOf(result.get(Const.retCode).toString()))
            {
                jedisUtil.setValue("FIND_LOGIN_PWD_IMG" + mobile, "verified", 60 * 10);
                logger.info(String.format("testingImageCode parameter : mobile = %s, imgVer = %s --- return : map = %s", 
            			mobile,imgVer,JsonHelper.formatJson(map)));
                return map;
            }
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "该手机号不存在");
            map.put("errorType", "mobile");
        } catch (Exception e)
        {
            logger.error("testingImageCode", e);
        }
        logger.info(String.format("testingImageCode parameter : mobile = %s, imgVer = %s --- return : map = %s", 
    			mobile,imgVer,JsonHelper.formatJson(map)));
        return map;
    };

    /**
     * 手机发送验证码(登录密码找回)
     * 
     * @param request
     * @return
     */
    @RequestMapping("/getPhoneVar")
    public @ResponseBody Map<String, Object> getPhoneVar(HttpServletRequest request,
            @RequestParam(value = "userMobile", required = true) String userMobile)
    {
    	logger.info(String.format("getPhoneVar parameter : mobile = %s ", 
        		userMobile));
        Map<String, Object> map = new HashMap<String, Object>();
        String verified = jedisUtil.getValue("FIND_LOGIN_PWD_IMG" + userMobile);

        if (StringUtils.isEmpty(verified))
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "验证已失效，请重新找回密码");// 验证已失效，请重新找回密码
            map.put(Const.retType, "unVerified");
            logger.info(String.format("getPhoneVar parameter : mobile = %s --- return : map = %s", 
            		userMobile,JsonHelper.formatJson(map)));
            return map;
        }

        try
        {
            P2p_user user = userService.findUserByMobile(userMobile);
            if (user != null)
            {
                map = sMSUtil.sendValidateCode(request, MessageType.LOGINPASSWORD.getIndex(), userMobile);
            } else
            {
                map.put(Const.retCode, false);
                map.put(Const.retMsg, "用户手机号不存在");// 用户手机号不存在
            }

            baseLog.writer(user.getPuCustNo(), userMobile, map.toString(), BusinessType.RETRIEVEPASSWORD.getDesc(),
                    RegistType.PC.getName(), "/login/getPhoneVar");
        } catch (Exception e)
        {
            logger.error(" send code error", e);
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "请填写正确的绑定的手机号");//
        }
        logger.info(String.format("getPhoneVar parameter : mobile = %s --- return : map = %s", 
        		userMobile,JsonHelper.formatJson(map)));
        return map;
    };

    /**
     * 验证手机验证码(登录密码找回)
     * 
     * @param request
     * @param userMobile
     *            用户手机号
     * @param validateCode
     *            手机验证码
     * @return
     */
    @RequestMapping("/testingverifyCode")
    public @ResponseBody Map<String, Object> testingverifyCode(HttpServletRequest request,
            @RequestParam(value = "userMobile", required = true) String userMobile,
            @RequestParam(value = "validateCode", required = true) String validateCode)
    {
    	logger.info(String.format("testingverifyCode parameter : userMobile = %s ,validateCode = %s", 
        		userMobile,validateCode));
        Map<String, Object> map = new HashMap<String, Object>();
        String temp = jedisUtil.getValue(userMobile);
        if (null == temp || temp == "")
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "\u9a8c\u8bc1\u7801\u5df2\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");// 验证码已失效，请重新获取
            logger.info(String.format("testingverifyCode parameter : userMobile = %s ,validateCode = %s --- return : map = %s", 
            		userMobile,validateCode,JsonHelper.formatJson(map)));
            return map;
        }
        if (validateCode != null)
        {
            if (!temp.equals(validateCode))
            {
                map.put(Const.retCode, false);
                map.put(Const.retMsg, "\u77ed\u4fe1\u9a8c\u8bc1\u7801\u9519\u8bef");// 短信验证码错误
                logger.info(String.format("testingverifyCode parameter : userMobile = %s ,validateCode = %s --- return : map = %s", 
                		userMobile,validateCode,JsonHelper.formatJson(map)));
                return map;
            } else
            {
                map.put(Const.retCode, true);
                SessionUtils.putAttrInSession(request, "userMobile", userMobile);
                jedisUtil.setValue("UPDATE_LOGINPWD_IS_VERIFIED" + userMobile, "VERIFIED", 60 * 10);
            }
        }
        logger.info(String.format("testingverifyCode parameter : userMobile = %s ,validateCode = %s --- return : map = %s", 
        		userMobile,validateCode,JsonHelper.formatJson(map)));
        return map;
    };

    /**
     * 重设密码(登录密码找回)
     * 
     * @param request
     * @return
     */
    @RequestMapping("/updatePassword")
    public @ResponseBody Map<String, Object> updatePassword(HttpServletRequest request,
            @RequestParam(value = "password", required = true) String newPassword,
            @RequestParam(value = "passwordSub", required = true) String newPasswordSub)
    {
    	logger.info(String.format("updatePassword parameter : newPassword = %s ,newPasswordSub = %s", 
    			newPassword,newPasswordSub));
        Map<String, Object> map = new HashMap<String, Object>();
        if (!newPassword.equals(newPasswordSub))
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "两次密码不一致，请重新输入");// 两次密码不一致，请重新输入
            logger.info(String.format("updatePassword parameter : newPassword = %s ,newPasswordSub = %s --- return : map = %s", 
        			newPassword,newPasswordSub,JsonHelper.formatJson(map)));
            return map;
        }
        String mobile = (String) SessionUtils.getAttrFromSession(request, "userMobile");
        String isVerified = jedisUtil.getValue("UPDATE_LOGINPWD_IS_VERIFIED" + mobile);
        if (StringUtils.isEmpty(isVerified) || mobile == null)
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "验证已失效，请重新找回密码");// 验证已失效，请重新找回密码
            logger.info(String.format("updatePassword parameter : newPassword = %s ,newPasswordSub = %s --- return : map = %s", 
        			newPassword,newPasswordSub,JsonHelper.formatJson(map)));
            return map;
        }
        try
        {
            P2p_user user = userService.findUserByMobile(mobile);
            if (user == null)
            {
                map.put(Const.retCode, false);
                map.put(Const.retMsg, "用户信息不存在");// 用户信息不存在
                logger.info(String.format("updatePassword parameter : newPassword = %s ,newPasswordSub = %s --- return : map = %s", 
            			newPassword,newPasswordSub,JsonHelper.formatJson(map)));
                return map;
            }
            String password = passwordEncode.encodePassword(newPassword, user.getPuCustNo());
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("custNo", user.getPuCustNo());
            params.put("password", password);
            params.put("registType", "PC");
            userService.updateLoginPassword(params);
            map.put(Const.retCode, true);
            SessionUtils.removeFromSession(request, "userMobile");
        } catch (Exception e)
        {
            logger.error("update password error", e);
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "更新密码失败，请稍后重试");// 更新密码失败，请稍后重试
        }
        logger.info(String.format("updatePassword parameter : newPassword = %s ,newPasswordSub = %s --- return : map = %s", 
    			newPassword,newPasswordSub,JsonHelper.formatJson(map)));
        return map;
    };

}
