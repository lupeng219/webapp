package com.baibao.web.p2p.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_mobile_app;
import com.baibao.web.p2p.generator.dao.P2p_mobile_appMapper;
import com.baibao.web.p2p.repository.MobileAppRepository;

/**
 * @author lupeng
 * @date: 2016年1月27日下午4:28:22
 */
@Repository
public class MobileAppRepositoryImpl implements MobileAppRepository{

	@Autowired
	private P2p_mobile_appMapper mobileAppDao;
	
	@Override
	public P2p_mobile_app findAll() {
		return mobileAppDao.findAll();
	}

	@Override
	public int saveMobileApp(P2p_mobile_app app) throws RuntimeException {
		int result = mobileAppDao.saveMobileApp(app);
		return result;
	}

	@Override
	public int updateMobileApp(P2p_mobile_app app) throws RuntimeException {
		int result = mobileAppDao.updateMobileApp(app);
		return result;
	}


}
