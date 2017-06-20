package com.baibao.web.p2p.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.common.util.PropertiesUtil;
import com.baibao.core.comm.http.HttpClientUtil;
import com.baibao.utils.HttpHelper;
import com.baibao.utils.MapBuilder;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_smsRecord;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.service.SmsRecordService;

@Component
public class SMSUtil
{
	private static Logger log = LoggerFactory.getLogger(SMSUtil.class);

	@Autowired
	private JedisUtil jedisUtil ;
	@Autowired
    private SmsRecordService smsRecordService;
	
	private SMSUtil()
	{ }

	/**
	 * 发送普通短信
	 * @param mobilePhone
	 * @param smsContent
	 * @return
	 */
//	public static Boolean sendOrdinarySMSMessage(
//		String mobilePhone, String smsContent)
//	{
//		log.info(String.format(
//			"发送to%s普通短信: %s", mobilePhone, smsContent));
//		
//		String sendSMSUrl = "http://yunpian.com/v1/sms/send.json";
//		
//		Map<String,String> paramMap = new HashMap<String,String>();
//		
//		paramMap.put("apikey", PropertiesUtil.getSysConfigParams("SMSAPIKEY"));
//		paramMap.put("mobile", mobilePhone);
//		paramMap.put("text", smsContent);
//		
//		String returnValue =
//			HttpClientUtil.sendPostRequest(sendSMSUrl, paramMap, "UTF-8");
//		
//		log.info("发送结果:" + returnValue);
//		
//		System.out.println(returnValue);
//		
//		Map<String,Object> map = JSON.parseObject(returnValue);
//		
//		Integer code =(Integer) map.get("code");
//		String msg =(String) map.get("msg");
//		
//		log.info("返回码:" + code + ", 发送状态:" + msg);
//		
//		return (code.intValue() == 0);
//	}
	/**
	 * 加密方式发送短信
	 * @param mobilePhone
	 * @param smsContent
	 * @return
	 *//*
	public static Boolean sendEncryptSMSMessage(String mobilePhone,String smsContent){
		log.info(smsContent);

		log.debug("发送普通短信.........[开始]");

		String sendSMSUrl = "http://sms.yunpian.com/v2/sms/single_send.json";
		Map<String,String> paramMap = new HashMap<String,String>();
		try {
			String secret = PropertiesUtil.getSysConfigParams("SMSSECRET");
			String encryptMobile = TeaUtil.encryptForYunpianV2(mobilePhone, secret);
			String encryptContent =TeaUtil.encryptForYunpianV2(smsContent,secret);
			paramMap.put("apikey", PropertiesUtil.getSysConfigParams("SMSAPIKEY"));
			paramMap.put("mobile", encryptMobile);
			paramMap.put("encrypt", "tea");
			paramMap.put("text", encryptContent);
			String _sign = SignUtil.getSign(paramMap,secret);
			paramMap.put("_sign", _sign);
			String returnValue = HttpClientUtil.sendPostRequest(sendSMSUrl, paramMap, "UTF-8");
			log.debug("发送结果:"+returnValue);
			log.info(returnValue);
			Map<String,Object> map = JSON.parseObject(returnValue);
			Integer code = (Integer) map.get("code");
			String msg = (String) map.get("msg");
			log.debug("返回码:"+code+",发送状态:"+msg);
			log.debug("发送普通短信.........[完成]");
			if(code.intValue()==0){
				return true;
			}else{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("sendEncryptSMSMessage",e);
		}
	
	  return  false;
	}*/
	
	/**
	 * 
	 * 发送模板短信
	 * 	<table>
	 * 	<tr><td><b>模板id</b></td><td><b>    模板内容</b></td> </tr>
		<tr><td>1</td>	<td>    【#company#】您的验证码是#code#	</td></tr>
		<tr><td>2</td>	<td>	【#company#】您的验证码是#code#。如非本人操作，请忽略本短信</td></tr>
		<tr><td>3</td>	<td>	【#company#】亲爱的#name#，您的验证码是#code#。如非本人操作，请忽略本短信</td></tr>
		<tr><td>4</td>	<td>	【#company#】亲爱的#name#，您的验证码是#code#。有效期为#hour#小时，请尽快验证</td></tr>
		<tr><td>5</td>	<td>	【#company#】感谢您注册#app#，您的验证码是#code#</td></tr>
		<tr><td>6</td>	<td>	【#company#】欢迎使用#app#，您的手机验证码是#code#。</td></tr>
		<tr><td>7</td>	<td>	【#company#】正在找回密码，您的验证码是#code#</td></tr>
		<tr><td>8</td>	<td>	【#company#】激活码是#code#。如非本人操作，请致电#tel#</td></tr>
		<tr><td>9</td>	<td>	【#company#】#code#(#app#手机动态码，请完成验证)，如非本人操作，请忽略本短信</td></tr>
		</table>
	 * @param mobilePhone
	 * @param tplId
	 * @param tplValue
	 * @return
	 */
	public static int sendTemplateSMSMessage(
		String mobilePhone, Integer tplId, String tplValue)
	{
		log.info(String.format(
			"发送to%s模板短信: %s!%s", mobilePhone, tplId, tplValue));
		String sendSMSUrl = "http://yunpian.com/v1/sms/tpl_send.json";
		
		Map<String,String> paramMap = new HashMap<String, String>();
		
		paramMap.put("apikey", PropertiesUtil.getSysConfigParams("SMSAPIKEY"));
		paramMap.put("mobile", mobilePhone);
		paramMap.put("tpl_id", tplId+"");
		paramMap.put("tpl_value", tplValue);

		String returnValue =
			HttpClientUtil.sendPostRequest(sendSMSUrl, paramMap, "UTF-8");

		log.info("发送结果:" + returnValue);
		
		Map<String,Object> map = JSON.parseObject(returnValue);
		
		Integer code = (Integer) map.get("code");
		String msg = (String) map.get("msg");
		
		log.info("返回码:" + code + ", 发送状态:" + msg);
		log.info("发送模板短信.........[完成]");
		return code.intValue();
	}
	
	
	/**
	 * 发送验证码验证(注册、找回登录密码、找回交易密码)
	 * @param type 1:注册 2:找回登录密码 3:找回交易密码
	 * @param phone 手机号
	 * @return
	 */
	public Map<String, Object> 
		sendValidateCode(HttpServletRequest request, Integer type, String phone)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		if (type == null || phone == null)
		{
			result.put(Const.retMsg, "参数不对，请重试!");//
			result.put(Const.retCode, false);

			return result;
		}
		
		HttpSession session = request.getSession();

		Long sendTime =
			(Long) SessionUtils.getAttrFromSession(request, "sendTime");
		
		Boolean bool =false;
		if (sendTime != null && !"".equals(sendTime))
		{
			//距离上次发送验证码的时间
			long differ = System.currentTimeMillis() - sendTime;
			//大于60秒
			if (differ >= 60000)
			{
				result = sendMessage(type, phone,jedisUtil);
				bool = Boolean.valueOf(result.get("retCode").toString());
				if (bool)
				{
					session.setAttribute("sendTime", System.currentTimeMillis());
				} else
				{	
					int code = (int) result.get("errorCode");
					if(code==17 || code ==22 || code==33){
						result.put(Const.retCode, false);
						result.put(Const.retMsg,  "下发验证码过频繁，请您稍后再试");
					}else{
						result.put(Const.retCode, false);
						result.put(Const.retMsg, "获取短信验证码失败");
					}
				}
			} else
			{
				result.put(Const.retCode, false);
				result.put(Const.retMsg, "短信已经发送请耐心等待");
				return result;
			}
		} else
		{
			result = sendMessage(type, phone,jedisUtil);
			bool = Boolean.valueOf(result.get("retCode").toString());
			if (bool)
			{
				session.setAttribute("sendTime", System.currentTimeMillis());
			} else
			{	
				int code = (int) result.get("errorCode");
				if(code==17 || code ==22 || code==33){
					result.put(Const.retCode, false);
					result.put(Const.retMsg,  "下发验证码过频繁，请您稍后再试");
				}else{
					result.put(Const.retCode, false);
					result.put(Const.retMsg, "获取短信验证码失败");
				}
			}
		}
		
		P2p_smsRecord smsRecord = new P2p_smsRecord();
        smsRecord.setFailPhone(phone);
        smsRecord.setRealName(phone);
        smsRecord.setSendResult(result.get("retMsg").toString());
        smsRecord.setSendTime(new Date());
        smsRecord.setSmsContent(jedisUtil.getValue(phone));
        
        if (type == MessageType.REGISTER.getIndex())
		{
        	smsRecord.setSendType(MessageType.REGISTER.getDesc());
		} else if (type == MessageType.LOGINPASSWORD.getIndex())
		{
			smsRecord.setSendType(MessageType.LOGINPASSWORD.getDesc());
		} else if (type == MessageType.TRADINGPASSWORD.getIndex())
		{
			smsRecord.setSendType(MessageType.TRADINGPASSWORD.getDesc());
		} else 
		{
			smsRecord.setSendType(type+"");
		}
        
        smsRecordService.saveSmsRecord(smsRecord);
		return result;
	}

	private static Map<String, Object>
		sendMessage(Integer type, String phone, JedisUtil jedisUtil)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		String randomValue = RandomStringUtils.randomNumeric(6);

		jedisUtil.setValue(phone, randomValue, 60 * 10);// 10分钟缓存
		int flag = sendTemplateSMSMessage(phone, type,
			HttpHelper.encodeForm(
				new MapBuilder<String, Object>()
					.append("#code#", randomValue)
					.toMap()));
		if(flag==0){
			result.put(Const.retCode, true);
			result.put(Const.retMsg, "发送成功");
		}else{
			result.put("errorCode", flag);
			result.put(Const.retCode, false);
			result.put(Const.retMsg,  "发送失败");
		}
		result.put("valicode", randomValue);
		return result;
	}

	public static Boolean
		sendMessage(MessageType type, String phone,
			Map<String, Object> parameters)
	{
		String params = HttpHelper.encodeForm(parameters);
		
//		Boolean result =
//			sendTemplateSMSMessage(phone, type.getIndex(), params);
		int result =
				sendTemplateSMSMessage(phone, type.getIndex(), params);
		P2p_smsRecord smsRecord = new P2p_smsRecord();

        smsRecord.setFailPhone(phone);
        smsRecord.setRealName(phone);
        smsRecord.setSendResult(result==0? "发送成功": "发送失败");
        smsRecord.setSendTime(new Date());
        smsRecord.setSendType(type.getDesc());
        smsRecord.setSmsContent(params);
        
        return result==0?true:false;
	}
	
}
