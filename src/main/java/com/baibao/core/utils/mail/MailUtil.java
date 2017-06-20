package com.baibao.core.utils.mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;

import freemarker.template.TemplateException;




/**
 * youjian
 * @author shigs
 *
 */
public class MailUtil {
	private static Logger log= LoggerFactory.getLogger(MailUtil.class);
	
	private MailUtil() {
	}
	
	/**
	 * 邮件相关设置
	 */
	private static Configuration config = null;
	
	/**
	 * 系统初始化，读取配置文件
	 */
	static{
		try {
			log.debug("读取邮件模块配置..........[开始]");
			config = getMailConfiguration();
			log.debug("邮件模块配置完成..........[完成]");
		} catch (ConfigurationException e) {
			log.error("读邮件模块配置异常：异常如下:", e);
		}
	}
	
	/**
	 * 获取配置
	 * @return
	 * @throws ConfigurationException
	 */
	private static PropertiesConfiguration getMailConfiguration() throws ConfigurationException{
		return new PropertiesConfiguration("config/system/mail.properties");
	}
	
	public static void main(String[] args){
		System.out.println("正在发送邮件");
		System.out.println(config.getString("mail.host"));
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("userNickName", "马啃菠萝");
		//sendMail( "993839291@qq.com", "测试", "register_confirm.ftl",paramMap );
		
		System.out.println("发送邮件完成");
	}
	
	/**
	 * 发送邮件
	 * @param mailToAddr  收件地址
	 * @param mailSubject  主题
	 * @param templateName  使用模板名称
	 * @param paramMap  模板参数
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static boolean sendMail( String mailToAddr, String mailSubject, String templateName,Map<String,String> paramMap) throws BusinessException {
		MailSenderInfo mailInfo = new MailSenderInfo();   
	    mailInfo.setMailServerHost(config.getString("mail.host"));   
	    mailInfo.setMailServerPort(config.getString("mail.port"));   
	    mailInfo.setValidate(true);   
	    mailInfo.setUserName(config.getString("mail.username"));
	    mailInfo.setPassword(config.getString("mail.password"));//您的邮箱密码   
	    mailInfo.setFromAddress( StringUtil.formatAddress( config.getString("mail.autor"),config.getString("mail.from") ) );   
	    mailInfo.setToAddress( mailToAddr );
	    mailInfo.setSubject( mailSubject );
	    
	    mailInfo.setContent(EmailTemplateUtil.getProcessResult(paramMap, templateName));
	    Map<String, String> map = new HashMap<String, String>();
        map.put("content", "test");
	         //这个类主要来发送邮件  
	    String a=SimpleMailSender.sendHtmlMail(mailInfo);
	    if(a.equals("success")){
	    	return true;
	    }
	    return false;
	}
}
