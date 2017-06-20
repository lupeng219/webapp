package com.baibao.core.utils;

import java.security.SecureRandom;

/*
 * @author bottle
 */
public class CommonUtilMethod {
      
	
	/*
	 * 生成不重复的唯一数   支持并发访问  长度 （18-20）
	 * 生成规则：当前时间（年月日时分秒毫秒）+随机数
	 */
	public  synchronized String generatorRandomData(){
		SecureRandom random=new SecureRandom();
		int randomInt=random.nextInt(999);
		String code=CalenderUtil.generatorCurrentDate("yyyyMMddHHmmssSSS");
		return  code+randomInt;
	}
	
}
