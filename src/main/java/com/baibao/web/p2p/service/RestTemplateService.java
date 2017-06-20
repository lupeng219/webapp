package com.baibao.web.p2p.service;

import org.springframework.util.MultiValueMap;

import com.baibao.core.exception.BusinessException;

public interface RestTemplateService {

	public  String postForEntityForSina(String url,String data) throws BusinessException;
	public  String postForEntity( MultiValueMap<String, String> params) throws BusinessException;
}
