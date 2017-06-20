package com.baibao.web.p2p.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.web.p2p.generator.bean.P2p_mobile_app;
import com.baibao.web.p2p.repository.MobileAppRepository;
import com.baibao.web.p2p.service.MobileAppService;

/**
 * @author lupeng
 * @date: 2016年1月27日下午4:20:55
 */
@Service("mobileAppRepository")
public class MobileAppServiceImpl implements MobileAppService{

	@Autowired
	private MobileAppRepository mobileAppRepository;
	
	@Override
	public P2p_mobile_app findAll() {
		P2p_mobile_app result = mobileAppRepository.findAll();
		return result;
	}
	
	@Transactional(readOnly=false,rollbackFor=RuntimeException.class)
	@Override
	public int saveMobileApp(P2p_mobile_app app) {
		int result =  mobileAppRepository.saveMobileApp(app);
		return result;
	}
	
	@Transactional(readOnly=false,rollbackFor=RuntimeException.class)
	@Override
	public int updateMobileApp(P2p_mobile_app app) {
		int result =  mobileAppRepository.updateMobileApp(app);
		return result;
	}
}
