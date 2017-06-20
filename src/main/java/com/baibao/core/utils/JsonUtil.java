package com.baibao.core.utils;

import com.alibaba.fastjson.JSON;
/**  
 *  
 * @author bottle  
 * 
 * java对象转换成json字符串
 * 
 */

public class JsonUtil {
	
	public static String createJsonString(Object value)
    {
        String alibabaJson = JSON.toJSONString(value);
        return alibabaJson;
    }
	
	
}
