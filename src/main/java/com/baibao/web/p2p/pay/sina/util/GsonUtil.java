package com.baibao.web.p2p.pay.sina.util;


import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * <p>GSON工具类</p>
 * @author Wallis Wang
 * @version $Id: GsonUtil.java, v 0.1 2014年5月15日 下午5:41:20 wangqiang Exp $
 */
public class GsonUtil {

    private static Gson gson = null;
    static {
        gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    /**
     * 小写下划线的格式解析JSON字符串到对象
     * <p>例如 is_success->isSuccess</p>
     * @param json
     * @param classOfT
     * @return
     */
    public static <T> T fromJsonUnderScoreStyle(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    /**
     * JSON字符串转为Map<String,String>
     * @param json
     * @return
     */
    @SuppressWarnings("all")
    public static <T> T fronJson2Map(String json) {
        return gson.fromJson(json, new TypeToken<Map<String, String>>() {
        }.getType());
    }
    /**
     * 小写下划线的格式将对象转换成JSON字符串
     * @param src
     * @return
     */
    public static String toJson(Object src) {
        return gson.toJson(src);
    }
    public static void main(String[] args) {
    	String aa=toJson("_input_charset=utf-8&cert_no=111111111111111111&cert_type=IC&encrypt_version=1.0&identity_id=2165656555568914773190920&identity_type=UID&notify_url=https://testgate.pay.sina.com.cn/mgs/gateway.do&partner_id=200004135630&real_name=张晓&request_time=20150425170413&retCode=0000&return_url=https://testgate.pay.sina.com.cn/mgs/gateway.do&service=set_real_name&sign=c8a676799b165e7d3efed77b66b1435d&sign_type=MD5&sign_version=1.0&version=1.0");
    	
    	System.out.println("=============="+aa+"===============");
	}
}
