package com.baibao.web.p2p.pay.sina.util;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.cache.utils.JedisUtil;



public class Tools
{
	private static Logger logger = LoggerFactory.getLogger(Tools.class);

	// 签名版本名称
    public static final String SIGN_VERSION_NAME = "sign_version";

    //签名类型名称
    public static final String SIGN_TYPE_NAME    = "sign_type";

    // 签名名称
    public static final String SIGN_NAME         = "sign";

    /**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params
     *            需要排序并参与字符拼接的参数组
     * @param encode 是否需要urlEncode
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, Object> params, boolean encode) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        String charset = String.valueOf(params.get("_input_charset"));
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = String.valueOf(params.get(key));
            if (encode) 
            {
                try {
                    value =URLEncoder.encode(URLEncoder.encode(value,charset),charset);
                } catch (UnsupportedEncodingException e) {
                	 logger.error("createLinkString",e);
                }
            }
            if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
    public static String createLinkStringForOneLine(Map<String, Object> params, boolean encode) {
    	List<String> keys = new ArrayList<String>(params.keySet());
    	Collections.sort(keys);
    	String prestr = "";
    	String charset = String.valueOf(params.get("_input_charset"));
    	for (int i = 0; i < keys.size(); i++) {
    		String key = keys.get(i);
    		String value = String.valueOf(params.get(key));
    		if (encode) 
    		{
    			try {
    				value = URLEncoder.encode(value,charset);
    			} catch (UnsupportedEncodingException e) {
    				 logger.error("createLinkStringForOneLine",e);
    			}
    		}
    		if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
    			prestr = prestr + key + "=" + value;
    		} else {
    			prestr = prestr + key + "=" + value + "&";
    		}
    	}
    	return prestr;
    }
    
    /**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getParameterMap(HttpServletRequest request,boolean isFilter) {
		// 参数Map
		Map<String, String[]> requestMap = request.getParameterMap();
		// 返回值Map
		Map<String, Object> returnMap = new HashMap<String, Object>();

		Iterator<Map.Entry<String, String[]>> entries = requestMap.entrySet().iterator();
		Map.Entry<String, String[]> entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry<String, String[]>) entries.next();
			name = (String) entry.getKey();
			if(isFilter)
            {
	            if(!name.equals("sign")&&!name.equals("sign_type")&&!name.equals("sign_version"))
	            {
		            Object valueObj = entry.getValue();
		            if(null == valueObj){
		                value = "";
		            }else if(valueObj instanceof String[]){
		                String[] values = (String[])valueObj;
		                for(int i=0;i<values.length;i++){
		                    value = values[i] + ",";
		                }
		                value = value.substring(0, value.length()-1);
		            }else{
		                value = valueObj.toString();
		            }
		            returnMap.put(name, value);
	            }
	        }else
	        {
	        	Object valueObj = entry.getValue();
				if (null == valueObj) {
					value = "";
				} else if (valueObj instanceof String[]) {
					String[] values = (String[]) valueObj;
					for (int i = 0; i < values.length; i++) {
						value = values[i] + ",";
					}
					value = value.substring(0, value.length() - 1);
				} else {
					value = valueObj.toString();
				}
				returnMap.put(name, value);
	        }
		}
		return returnMap;
	}
    
}
