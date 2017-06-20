package com.baibao.web.p2p.ebaoquan;

import com.google.common.collect.Maps;
import com.baibao.core.cache.SystemConfigCache;
import com.baibao.core.utils.StringUtil;

import org.mapu.themis.ThemisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ThemisClientInit {
	
	public static   String _test_or_product = "";
	
	
	//请填入服务地址（根据环境的不同选择不同的服务地址），沙箱环境，正式环境
	public static String SERVICE_URLTest;

	//请填入你的APPKey
	public static String APP_KEYTest;

	//请填入你的APPSecret
	public static String APP_SECRETTest;
	

	//请填入服务地址（根据环境的不同选择不同的服务地址），沙箱环境，正式环境
	public static String SERVICE_URL;

	//请填入你的APPKey
	public static String APP_KEY;

	//请填入你的APPSecret
	public static String APP_SECRET;

	protected static Map<String,String> props = Maps.newHashMap();
	
	private static ThemisClient themisClient;

	public static void initParam(){
		
		_test_or_product = (String) SystemConfigCache.getValue( "common", "test_or_product" );
		
		SERVICE_URLTest = (String) SystemConfigCache.getValue( "common", "service_urlTest" );
		APP_KEYTest = (String) SystemConfigCache.getValue( "common", "app_keyTest" );
		APP_SECRETTest = (String) SystemConfigCache.getValue( "common", "app_secretTest" );

		SERVICE_URL = (String) SystemConfigCache.getValue( "common", "service_url" );
		APP_KEY = (String) SystemConfigCache.getValue( "common", "app_key" );
		APP_SECRET = (String) SystemConfigCache.getValue( "common", "app_secret" );
	}

	public static ThemisClient getClient(){
		if( StringUtil.isEmpty( _test_or_product ))
			initParam();
		if( _test_or_product.equals( "0" )){
			themisClient = new ThemisClient(SERVICE_URLTest,APP_KEYTest,APP_SECRETTest);
		}else{
			themisClient = new ThemisClient(SERVICE_URL,APP_KEY,APP_SECRET);
		}
		//themisClient = new ThemisClient("http://sandbox.api.ebaoquan.org/services","a1450f06d2987d9c","2a67eca505bb6eeaeafa103eb6c1fdf3");
		return themisClient;
	}

}
