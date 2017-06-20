package com.baibao.core.utils.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.cache.LoadSystemConfigServlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * 使用 邮件 处理 模板
 * @author w.s
 *
 */
public class EmailTemplateUtil {
	
	private static Logger log = LoggerFactory.getLogger(EmailTemplateUtil.class); 
	private static Configuration conf;
	
	 private static String templatePath = "/config/mail_template";
	
	/**
	 * 初始化配置
	 * @throws IOException
	 */
	private static void init() throws IOException{
		if(conf==null){			
				conf = new Configuration();
				conf.setClassForTemplateLoading(EmailTemplateUtil.class, templatePath);
				conf.setDefaultEncoding("UTF-8");
		}
	}
	
	public static void main(String[] args) {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 处理 模板，得到替换后的 文字内容
	 * @param objMap   数据<K,V>
	 * @param templateName 模板名称
	 * @return
	 * @throws Exception
	 */
	public static String getProcessResult(Map<String,String> objMap,String templateName){
		try {
			init();
			Template template = conf.getTemplate(templateName);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out);
			template.process(objMap, writer);
			return out.toString();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("getProcessResult", e);
			return null;
		}
	}

}
