package com.baibao.web.p2p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.controller.eventBus.events.InvitatRegistEvent;
import com.baibao.web.p2p.controller.eventBus.events.RegisterEvent;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.SMSUtil;

/**
 * @author robin
 * @date: 2016年6月21日
 * @see 注册及现骨干功能
 */
@Controller
@RequestMapping("/register")
public class RegisterController
{
    private static final Logger logger =
    	LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private ActiveService activeServive;
    @Autowired
    private SMSUtil sMSUtil;
    @Autowired
    private InvitatRegistEvent invitatRegistEvent;
    @Autowired
    private RegisterEvent registerEvent;
    @Autowired
    private BaseLog baseLog;

    /**
     * 注册首页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping
    public ModelAndView toRegister(HttpServletRequest request,
            @RequestParam(value = "mobile", required = false) String mobile)
    {
    	logger.info(String.format("toRegister parameter: mobile = %s", mobile));
        ModelAndView model = new ModelAndView("register");
        if (StringUtil.isNotEmpty(mobile))
        {
            request.setAttribute("mobile", mobile);
        }
        String inviteCode = request.getParameter("inviteCode");
        if (inviteCode != null && inviteCode != "")
        {
            model.addObject("inviteCode", inviteCode);
        }
        logger.info(String.format("toRegister parameter: mobile = %s --- return: model = %s", mobile, JsonHelper.formatJson(model)));
        return model;
    }

    /**
     * 验证手机号是否存在
     * 
     * @param mobile
     * @return
     */
    @RequestMapping("/ajaxCheckMobile")
    @ResponseBody
    public Map<String, Object> ajaxCheckUserInfo(String mobile)
    {
    	logger.info(String.format("ajaxCheckUserInfo parameter: mobile = %s", mobile));
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isEmpty(mobile))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
            
            logger.info(String.format("ajaxCheckUserInfo parameter: mobile = %s --- return : result = %s", 
            		mobile, JsonHelper.formatJson(result)));
            return result;
        }
        try
        {
            result = userService.checkMobileIsExists(mobile);
        } catch (Exception e)
        {
            result.put(Const.retCode, false);
            logger.error("ajaxCheckUserInfo", e);
        }
        logger.info(String.format("ajaxCheckUserInfo parameter: mobile = %s --- return : result = %s", 
        		mobile, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 验证邀请人是否存在
     * 
     * @param mobile
     * @return
     */
    @RequestMapping("/getCheckInviter")
    @ResponseBody
    public Map<String, Object> ajaxCheckInviter(String mobile)
    {
    	
    	logger.info(String.format("ajaxCheckInviter parameter: mobile = %s", mobile));
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isEmpty(mobile))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
            
            logger.info(String.format("ajaxCheckInviter parameter: mobile = %s --- return : result = %s", 
            		mobile, JsonHelper.formatJson(result)));
            return result;
        }
        try
        {
            result = userService.checkInviter(mobile);
        } catch (BusinessException e)
        {
            result.put(Const.retCode, false);
            logger.error("ajaxCheckInviter", e);
        }
        logger.info(String.format("ajaxCheckInviter parameter: mobile = %s --- return : result = %s", 
        		mobile, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 发送注册验证码
     * 
     * @param mobile
     * @return
     */
    @RequestMapping("/getValidateCode")
    @ResponseBody
    public Map<String, Object> sendValidateCode(
    	HttpServletRequest request, String mobile, String imgVer)
    {
    	
    	logger.info(String.format("sendValidateCode parameter: mobile = %s, imgVer = %s", mobile, imgVer));
    	
        Map<String, Object> result = new HashMap<String, Object>();
        String referer = request.getHeader("referer");
        if (StringUtils.isEmpty(referer) || StringUtils.isEmpty(imgVer) || StringUtils.isEmpty(mobile))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "参数不符合规范");// \u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303
            
            logger.info(String.format("sendValidateCode parameter: mobile = %s, imgVer = %s --- return : result = %s", 
            		mobile, imgVer, JsonHelper.formatJson(result)));
            return result;
        }
        result.put(Const.retCode, false);
        result.put(Const.retMsg, "验证码发送失败");// \u9a8c\u8bc1\u7801\u53d1\u9001\u5931\u8d25

        // --- 防盗链
        /*{
            String scheme = request.getScheme();
            String serverName = request.getServerName();
            String path = request.getContextPath();
            // 正式测试环境打开
            int port = request.getServerPort();
            String registerUrl = scheme + "://" + serverName + ":" + port + path + "/service/register";
            String inviteUrl = scheme + "://" + serverName + ":" + port + path + "/service/invite";
            String wapRegisterUrl = scheme + "://" + serverName + ":" + port + path + "/service/wapRegister/toWapRegister";
            // 本地使用时打开
            //String registerUrl = scheme + "://" + serverName + path + "/service/register";
            String subReferer = referer.substring(0, referer.length() - 11);
            if (!referer.equals(registerUrl) && !referer.equals(wapRegisterUrl) && !subReferer.equals(inviteUrl))
            {
                return result;
            }        
        }*/
        // ---

        if (StringUtils.isEmpty(mobile))
        {
            result.put("codeORmobile", false);
            result.put(Const.retMsg, "手机号不能为空");// \u624b\u673a\u53f7\u4e0d\u80fd\u4e3a\u7a7a
            
            logger.info(String.format("sendValidateCode parameter: mobile = %s, imgVer = %s --- return : result = %s", 
        		mobile, imgVer, JsonHelper.formatJson(result)));
            return result;
        }

        String realCheckCode =(String)
        	SessionUtils.getAttrFromSession(
        		request, Const.SCAPTCHA);

        try
        {
            Map<String, Object> checkMobileIsExistsResult =
            	userService.checkMobileIsExists(mobile);
            if (!(Boolean) checkMobileIsExistsResult.get(Const.retCode))
            {
                result.put("codeORmobile", false);
                result.put(Const.retMsg, "该手机号已被注册");// \u8be5\u624b\u673a\u53f7\u5df2\u88ab\u6ce8\u518c
                
                logger.info(String.format("sendValidateCode parameter: mobile = %s, imgVer = %s --- return : result = %s", 
                		mobile, imgVer, JsonHelper.formatJson(result)));
                return result;
            }  else
            if (!realCheckCode.equalsIgnoreCase(imgVer))
            {
                result.put("codeORmobile", true);
                result.put(Const.retMsg, "图形验证码不正确");// \u56fe\u5f62\u9a8c\u8bc1\u7801\u4e0d\u6b63\u786e
                
                logger.info(String.format("sendValidateCode parameter: mobile = %s, imgVer = %s --- return : result = %s", 
                		mobile, imgVer, JsonHelper.formatJson(result)));
                return result;
            } else
            {
                result.clear();
                result = sMSUtil.sendValidateCode(
                	request, MessageType.REGISTER.getIndex(),
                	mobile);
            }
        } catch (Exception e)
        {
            result.put(Const.retCode, false);
            logger.error("sendValidateCode", e);
        }

        logger.info(String.format(
        	"sendValidateCode parameter: mobile = %s, imgVer = %s --- return : result = %s", 
    		mobile, imgVer, JsonHelper.formatJson(result)));

        return result;
    }

    /**
     * 用户注册
     * 
     * @param mobile
     *            手机号/邮箱
     * @param verification
     *            手机验证码
     * @param passd
     *            密码
     * @param friendMobile
     *            推荐人
     * @return result
     */
    @RequestMapping("/regist")
    @ResponseBody
    public Map<String, Object> register(
		HttpServletRequest request,
		String mobile, String verification, String passd,
        String friendMobile)
    {
    	logger.info(String.format(
    		"register parameter : mobile = %s, verification = %s, passd = %s, friendMobile = %s", 
			mobile, verification, passd, friendMobile));
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            result = userService.addUsers(
            	mobile, verification, passd, friendMobile,
            	RegistType.PC.getIndex(), null);
        } catch (Exception e)
        {
            logger.error("register failed", e);
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "注册失败");// \u6ce8\u518c\u5931\u8d25
            
            logger.info(String.format(
            	"register parameter : mobile = %s, verification = %s, passd = %s, friendMobile = %s --- "
        		+ "return : result = %s", 
    			mobile, verification, passd, friendMobile, JsonHelper.formatJson(result)));
            
            return result;
        }

        // 注册成功之后再进行操作
        if ((Boolean) result.get(Const.retCode))
        {
            // 邀请注册活动
            // 1.查询邀请注册活动
            /*
             * P2p_activity_elements active =
             * activeServive.getActiveByType(ActiveType.friendsregist.getIndex()
             * ); if(active != null){
             * 
             * invitatRegistEvent.setActiveId(active.getPae_activeId().toString(
             * )); invitatRegistEvent.setRegistMobile(mobile);
             * invitatRegistEvent.setInvitatId(friendMobile);
             * invitatRegistEvent.setEffectTime(active.getPae_effectTime());
             * invitatRegistEvent.setPae_goodsType(active.getPae_goodsType());
             * qzbAsyncEventBus.post(invitatRegistEvent);//发布邀请注册活动 }
             */

            // 2.注册活动
            /*
             * P2p_activity_elements activeRegister =
             * activeServive.getActiveByType(ActiveType.regist.getIndex());
             * //活动不为空 if(activeRegister!=null){
             * registerEvent.setActiveId(activeRegister.getPae_activeId().
             * toString());
             * registerEvent.setEffectTime(activeRegister.getPae_effectTime());
             * registerEvent.setRegistMobile(mobile);
             * registerEvent.setP2pActivityElements(activeRegister);
             * qzbAsyncEventBus.post(registerEvent);//发布注册活动 }
             */
            baseLog.writer(result.get("custNo").toString(), "", result.toString(), BusinessType.REGISTER.getDesc(),
                    RegistType.PC.getName(), "/register/regist");
        }

        logger.info(String.format("register parameter : mobile = %s, verification = %s, passd = %s, friendMobile = %s --- "
    		+ "return : result = %s", 
			mobile, verification, passd, friendMobile, JsonHelper.formatJson(result)));

        return result;
    }
}
