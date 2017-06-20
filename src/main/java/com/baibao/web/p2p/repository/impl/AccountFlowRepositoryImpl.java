package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.dao.P2p_account_flowMapper;
import com.baibao.web.p2p.repository.AccountFlowRepository;

@Repository
public class AccountFlowRepositoryImpl implements AccountFlowRepository{
	private static Logger logger = LoggerFactory.getLogger(AccountFlowRepositoryImpl.class);

	@Autowired
	private P2p_account_flowMapper account_flowMapper;
	
	@Override
	public int save(P2p_account_flow accountFlow) throws RuntimeException {
		if(accountFlow == null){
			return 0;
		}
		return account_flowMapper.save( accountFlow );
	}

	@Override
	public int updateTransFlowNo(Map<String, Object> map)throws RuntimeException {
		if( map == null || map.size() == 0 ){
			return 0;
		}
		try{
			account_flowMapper.updateTransFlowNo(map);
		}catch(Exception e)
		{
			logger.error("updateTransFlowNo",e);
		}
		return account_flowMapper.updateTransFlowNo(map);
	}

	@Override
	public P2p_account_flow getByTransFlowNo(String transFlowNo)
			throws BusinessException {
		if(StringUtils.isEmpty(transFlowNo)){
			return null;
		}
		return account_flowMapper.getByTransFlowNo(transFlowNo);
	}
	
	@Override
	public List<P2p_account_flow> getByCustNoAndType(Map<String, Object> params) {
		if(params == null||params.size() == 0){
			return null;
		}
		return account_flowMapper.getByCustNoAndType(params);
	}

	@Override
	public Integer getTransRecordTotal(Map<String, Object> params) {
		if(params == null||params.size() == 0){
			return 0;
		}
		return account_flowMapper.getTransRecordTotal(params);
	}

	@Override
	public List<P2p_account_flow> allTransFlow(Map<String, Object> params) {
		if(params == null||params.size() == 0){
			return null;
		}
		return account_flowMapper.allTransFlow(params);
	}

	@Override
	public Integer allTransFlowTotal(Map<String, Object> params) {
		if(params == null||params.size() == 0){
			return null;
		}
		return account_flowMapper.allTransFlowTotal(params);
	}

}
