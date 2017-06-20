package com.baibao.web.p2p.service.impl;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.baibao.core.cache.SystemConfigCache;
import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.cache.SystemCacheUtil;
import com.baibao.web.p2p.service.RestTemplateService;

@Service("restTemplateService")
public class RestTemplateServiceImpl implements RestTemplateService{
    private static final Logger log = LoggerFactory.getLogger(RestTemplateServiceImpl.class);
	@Autowired
    private  RestTemplate template;
	private static HttpHeaders httpHeaders=null;
	static{
		//设置Http请求头和报文体  
		httpHeaders = new HttpHeaders() ;  
        //设置HTTP请求的请求头信息  
        httpHeaders.setContentType(MediaType.parseMediaType("application/x-www-form-urlencoded;charset=UTF-8"));  
        //设置相应内容，相应内容将被转换为json格式返回  
        httpHeaders.setAcceptCharset(Collections.singletonList(Charset.forName("UTF-8")));  
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));  
	}
	
	@Override
	public String postForEntityForSina(String url,String data) throws BusinessException {
		try{
			//设置HttpEntity的Body类型为String，调用StringHttpMessageConverter转换报文体参数  
	        HttpEntity<String> httpEntity = new HttpEntity<String>( data ,httpHeaders ) ; 
	    
			//ResponseEntity<String> response1 = template.postForEntity( SystemCacheUtil.getSinaUrl(), httpEntity, String.class);
			ResponseEntity<String> response1 = template.postForEntity( url , httpEntity, String.class);
			String responseString = URLDecoder.decode( response1.getBody() ,"utf-8");

			return responseString;
		}catch( Exception e )
		{   
			log.error("与新浪通讯异常", e);
			throw new BusinessException( "与新浪通讯异常" );
		}
	}

	@Override
	public String postForEntity(MultiValueMap<String, String> params)
			throws BusinessException {
		try{
			String coreTrans = (String) SystemConfigCache.getValue("common", "coreTransUrl");
			String returnJSON  = template.postForObject( coreTrans, params, String.class);
			return returnJSON;
		}catch( Exception e )
		{
			log.error("######交易错误######",e);
			throw new BusinessException( "与核心交易通讯异常" );
		}
	}

	
}
