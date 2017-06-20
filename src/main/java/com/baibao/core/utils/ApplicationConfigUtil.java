package com.baibao.core.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * applicationContext工具类
 * @author yy
 *
 */
public class ApplicationConfigUtil {
	@SuppressWarnings("resource")
	public static Object getBean(String fileName,String beaname){
   	 String path = ApplicationConfigUtil.class.getClassLoader().getResource("config/spring/"+fileName).getPath();
   	 ApplicationContext context = new FileSystemXmlApplicationContext(path);
   	 return context.getBean(beaname);
    }
}
