package com.baibao.web.p2p.cache;

import com.baibao.core.cache.SystemConfigCache;

public class SystemCacheUtil {

	public static String getSinaUrl()
	{
		String test_or_product = (String)SystemConfigCache.getValue("common", "test_or_product");
		
		if( test_or_product.equals( "0" ) )
		{
			return (String)SystemConfigCache.getValue("common", "sinaVipTestUrl");
		}else
		{
			return (String)SystemConfigCache.getValue("common", "sinaVipProductUrl");
		}
	}
}
