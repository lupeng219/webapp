package com.baibao.web.p2p.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.web.p2p.generator.bean.P2p_cust_logon;
import com.baibao.web.p2p.repository.CustLogonRepository;
import com.baibao.web.p2p.service.CustLogonService;
@Service("custService")
public class CustLogonServiceImpl implements CustLogonService{
	private static final Logger logger = LoggerFactory.getLogger(CustLogonServiceImpl.class);
	@Autowired
	private CustLogonRepository custLogonRepository;
	
	@Override
	@Transactional(readOnly = false)
	public int saveLogon(P2p_cust_logon cusLogon) throws RuntimeException {
		try {
			return custLogonRepository.saveLogon(cusLogon);
		} catch (RuntimeException e) {
			logger.error("保存登录日志信息出错", e);
			throw e;
		}
	}

	@Override
	public P2p_cust_logon getCustLogonByCustNo(String custNo) {
		try {
			return custLogonRepository.getCustLogonByCustNo(custNo);
		} catch (Exception e) {
			logger.error("查询登录日志信息出错", e);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public int updateLogonByCustNo(P2p_cust_logon cusLogon) throws RuntimeException {
		return custLogonRepository.updateLogonByCustNo(cusLogon);
	}

}
