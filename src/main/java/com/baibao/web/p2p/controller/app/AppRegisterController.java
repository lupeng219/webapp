package com.baibao.web.p2p.controller.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.CustAccountService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.AppCallLogUtil;
import com.baibao.web.p2p.utils.SMSUtil;
import com.umpay.api.common.Base64;



/**
 * @author lupeng
 * @date: 2016年1月4日下午2:36:48
 * App 注册
 */
@Controller
@RequestMapping("/AppRegister")
public class AppRegisterController {
	
	private static final Logger logger = LoggerFactory
            .getLogger(AppRegisterController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private SMSUtil sMSUtil;
	@Autowired
	private JedisUtil jedisUtil;
	
	@Autowired
    private CustAccountService custAccountService;
	@Autowired
	private BaseLog baseLog;
	/**
	 * 注册
	 * @param request
	 * @param phone
	 * @param password
	 * @param code
	 * @param invitingMobile
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object>
		register(HttpServletRequest request,
			String phone, String password, String code, String invitingMobile)
				throws Exception
	{
		AppCallLogUtil.printMsg(request, "AppRegister.register","phone","password","code","invitingMobile");
		Map<String, Object> retMap = new HashMap<String, Object>();
	
		if (StringUtil.isEmpty(phone) ||
			StringUtil.isEmpty(password) ||
			StringUtil.isEmpty(code))
		{
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg,
				"\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			
			return retMap;
		}
		
		try
		{
			retMap = userService.checkMobileIsExists(phone);
			
			if (retMap.get("retCode").equals(false))
			{
				return retMap;
			}
			
			retMap.clear();
			
			if (StringUtil.isNotEmpty(invitingMobile))
			{
				retMap = userService.checkInviter(invitingMobile);
				if (retMap.get("retCode").equals(false))
				{
					return retMap;
				}
			}

			retMap =
				userService.addUsers(phone, code, password,
				invitingMobile, RegistType.APP.getIndex(), null);
			
			baseLog.writer(phone, "", retMap.toString(),
				BusinessType.REGISTER.getDesc(), RegistType.APP.getName(),
				"/register");
		} catch(Exception e)
		{
			logger.error("注册接口出错 。出错地址为******AppRegister/register", e);

			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg,"\u6ce8\u518c\u5931\u8d25" );//注册失败
			return retMap;
		}
		
		return retMap;
	}
	/**
	 * 检查验证码是否正确
	 * @param phone
	 * @param phoneCode
	 * @return
	 */
	@RequestMapping(value="/checkPhoneCode",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>checkPhoneCode(HttpServletRequest request,String phone,String phoneCode){
		AppCallLogUtil.printMsg(request, "AppRegister.checkPhoneCode","phone","phoneCode");
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			 String code = jedisUtil.getValue(phone);
		        if (StringUtil.isNotEmpty(code)){
		        	  if (!code.equals(phoneCode)){
		        		  retMap.put(Const.retCode, false);
		        		  retMap.put(Const.retMsg, "\u77ed\u4fe1\u9a8c\u8bc1\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");//短信验证码错误，请重新输入
		        	  }else{
		        		  retMap.put(Const.retCode, true);
		        		  retMap.put(Const.retMsg, "\u77ed\u4fe1\u9a8c\u8bc1\u7801\u6b63\u786e");//短信验证码正确
		        	  }
		        }else{
		        	 retMap.put(Const.retCode, false);
		             retMap.put(Const.retMsg,"\u9a8c\u8bc1\u7801\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");//验证码超时,请重新获取
		        }
			
		} catch (Exception e) {
		     logger.error("app接口出错 AppRegister/checkPhoneCode", e);
			 retMap.put(Const.retCode, false);
             retMap.put(Const.retMsg,"\u77ed\u4fe1\u9a8c\u8bc1\u7801\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
		}
		return retMap;
	}
	/**
	 * 实名认证
	 * @param request
	 * @param realName
	 * @param idCard
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value="openAccount",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>openAccount(HttpServletRequest request,
			@RequestParam("realName") String realName,
			@RequestParam("idCard") String idCard,
			@RequestParam("custNo")String custNo){

		AppCallLogUtil.printMsg(request, "AppRegister.openAccount","realName","idCard","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo =jedisUtil.getValue(custNo); 
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);// 参数不符合规范
            return retMap;
        }
		if(StringUtils.isEmpty(realName) || StringUtils.isEmpty(idCard) || StringUtils.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return retMap;
		}
		P2p_cust_account account = custAccountService.queryIdentityId(custNo);
		String accountNo = "";
		if(null != account){
			accountNo = account.getPcaAccountno();
		}
		Map<String, String> params=new HashMap<String, String>();
		params.put("identity_id", accountNo);
		params.put("real_name", realName);
		params.put("cert_no", idCard);
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result = custAccountService.activateNemberOrBindingVerify(custNo);
			if((Boolean)result.get(Const.retCode)){
				retMap = custAccountService.certificationOperation(params,custNo);
				if((Boolean)retMap.get(Const.retCode)){
				    retMap.put(Const.retMsg, "\u4fdd\u5b58\u6210\u529f");//保存成功
				}
			}
			baseLog.writer(custNo,params.toString(),result.toString(),BusinessType.REALNAMEAUTHENTICATION.getDesc(),RegistType.APP.getName(),"/AppRegister/openAccount");
		} catch (Exception e) {
			logger.error("实名认证失败"+e+"接口名字AppRegister/openAccount");
			retMap.put("retCode", false);
			retMap.put("retMsg", "\u60a8\u8f93\u5165\u7684\u59d3\u540d\u6216\u8eab\u4efd\u8bc1\u53f7\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");//您输入的姓名或身份证号错误，请重新输入
			baseLog.writer(custNo,params.toString(),result.toString(),BusinessType.REALNAMEAUTHENTICATION.getDesc(),RegistType.APP.getName(),"/AppRegister/openAccount");
			return retMap;
		}
		return retMap;
		
	}
	/**
	 * 获取短信验证码
	 * @param phone	手机号
	 * @param style 类型   1 注册 2找回登录密码3找回交易密码
	 * @param request
	 * @param codechar 图形验证码
	 * @param UUid  手机端唯一标识
	 * @return
	 */
	@RequestMapping(value="/verificationCode",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String, Object> verificationCode(HttpServletRequest request,
			@RequestParam(value="codechar",required=false) String codechar,
			@RequestParam(value="UUid",required=false) String UUid,
			@RequestParam(value="phone",required=false) String phone,
			@RequestParam(value="style",required=false) String style){

		AppCallLogUtil.printMsg(request, "AppRegister.verificationCode","codechar","UUid","phone","style");
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> checkMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(phone)|| StringUtil.isEmpty(style)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg,"\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		try {
			checkMap = userService.checkMobileIsExists(phone);//true 不存在 false 已经存在
			if(MessageType.REGISTER.getName().equals(style)){//注册
				if(checkMap.get("retCode").equals(false)){
					retMap.put(Const.retCode,false );
					retMap.put(Const.retMsg,"\u8be5\u624b\u673a\u53f7\u5df2\u88ab\u6ce8\u518c" );//该手机号已被注册
					return retMap;
				}
				/**
				String charANDnum =jedisUtil.getValue(UUid);
				if(StringUtil.isEmpty(charANDnum)){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u56fe\u7247\u9a8c\u8bc1\u7801\u9519\u8bef");//图片验证码错误
					return retMap;
				}
				if(StringUtil.isEmpty(codechar)){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u56fe\u7247\u9a8c\u8bc1\u7801\u9519\u8bef");//图片验证码错误
					return retMap;
				}
				if(!charANDnum.equalsIgnoreCase(codechar)){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u56fe\u7247\u9a8c\u8bc1\u7801\u9519\u8bef");//图片验证码错误
					return retMap;
				}
				
				retMap = sMSUtil.sendValidateCode(request,MessageType.REGISTER.getIndex(), phone);
				**/
			}else{ //找回登录密码  找回交易密码
				if(checkMap.get("retCode").equals(true)){
					retMap.put(Const.retCode,false );
					retMap.put(Const.retMsg,"\u7528\u6237\u4e0d\u5b58\u5728" );//用户不存在
					return retMap;
				}
				/**
				retMap = sMSUtil.sendValidateCode(request,style, phone);
				**/
			}
			if(MessageType.getEnumByName(style)==null){
				retMap.put(Const.retCode,false );
				retMap.put(Const.retMsg,"\u83b7\u53d6\u77ed\u4fe1\u9a8c\u8bc1\u7801\u51fa\u9519" );//获取短信验证码出错
				return retMap;
			}
			retMap = sMSUtil.sendValidateCode(request,MessageType.getEnumByName(style).getIndex(), phone);
			if((Boolean)retMap.get(Const.retCode)){
			        retMap.put(Const.retMsg, "\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\u81f3\u60a8\u624b\u673a\uff0c\u8bf7\u6ce8\u610f\u67e5\u6536" );//验证码已发送至您手机，请注意查收
			}
		} catch (Exception e) {
			logger.error("获取短信验证码出错", e);
			e.printStackTrace();
			retMap.put(Const.retCode,false );
			retMap.put(Const.retMsg,"\u83b7\u53d6\u77ed\u4fe1\u9a8c\u8bc1\u7801\u51fa\u9519" );//获取短信验证码出错
			return retMap;
		}
		return retMap;
	}
	/**
	 * 获取图形验证码
	 * @param UUid 唯一标识
	 * @return
	 */
	@RequestMapping("/getcharAndNum")
	@ResponseBody
	public  Map<String, Object>  getcharandNum(String UUid){
		Map<String, Object> retMap = new HashMap<String, Object>();
		 Random random = new Random(); 
         String results="";
         for(int i=0;i<4;i++){
             String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
             if ("char".equalsIgnoreCase(charOrNum)) {
            	 int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
            	 results += (char) (choice + random.nextInt(26));
             } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
            	 results += String.valueOf(random.nextInt(10));
             }
         }
         jedisUtil.setValue(UUid, results);
         retMap.put("codes", results);
         retMap.put(Const.retCode,true);
         retMap.put(Const.retMsg,"\u83b7\u53d6\u6210\u529f");//获取成功
		return retMap;
		
	}
	/**
	 * 跳转到微信注册页
	 * @return
	 */
	/*#RequestMapping("/webRegister")*/
	public String phoneRegister(HttpServletRequest request,Model model){
		String invitingMobile = request.getParameter("code");
		model.addAttribute("invitingMobile", invitingMobile);
		
		return "/wap/wapRegister";
	}
	
}
