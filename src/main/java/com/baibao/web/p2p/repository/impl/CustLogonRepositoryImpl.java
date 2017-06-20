package com.baibao.web.p2p.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_cust_logon;
import com.baibao.web.p2p.generator.dao.P2p_cust_logonMapper;
import com.baibao.web.p2p.repository.CustLogonRepository;

@Repository
public class CustLogonRepositoryImpl implements CustLogonRepository {
	
	@Autowired
	private P2p_cust_logonMapper logonMapper;

	@Override
	public int saveLogon(P2p_cust_logon cusLogon) throws RuntimeException {
		
		return logonMapper.saveLogon(cusLogon);
	}

	@Override
	public P2p_cust_logon getCustLogonByCustNo(String custNo) throws Exception {
		
		return logonMapper.getCustLogonByCustNo(custNo);
	}

	@Override
	public int updateLogonByCustNo(P2p_cust_logon cusLogon) throws RuntimeException {
		
		return logonMapper.updateLogonByCustNo(cusLogon);
	}

}
