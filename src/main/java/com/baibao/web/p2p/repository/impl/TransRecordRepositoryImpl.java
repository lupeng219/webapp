package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.dao.P2p_account_flowMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_recordMapper;
import com.baibao.web.p2p.repository.TransRecordRepository;

@Repository
public class TransRecordRepositoryImpl implements TransRecordRepository {

	@Autowired
	private P2p_account_flowMapper p2pAccountFlowMapper;
	@Autowired
	private P2p_tender_recordMapper p2pTenderRecordMapper;
	
	@Override
	public List<P2p_account_flow> getByCustNoAndType(Map<String, Object> params) {
		return p2pAccountFlowMapper.getByCustNoAndType(params);
	}

	@Override
	public Integer getTransRecordTotal(Map<String, Object> params) {
		return p2pAccountFlowMapper.getTransRecordTotal(params);
	}

	@Override
	public List<P2p_account_flow> allTransFlow(Map<String, Object> params) {
		return p2pAccountFlowMapper.allTransFlow(params);
	}

	@Override
	public Integer allTransFlowTotal(Map<String, Object> params) {
		return p2pAccountFlowMapper.allTransFlowTotal(params);
	}

	@Override
	public List<Map<String, Object>> getInvestmentAmount(String custNo)
			throws BusinessException {
		return p2pTenderRecordMapper.getInvestmentAmount(custNo);
	}

	@Override
	public List<Map<String, Object>> tenderRecord(Map<String, Object> map)
			throws BusinessException {
		return p2pTenderRecordMapper.tenderRecord(map);
	}

	@Override
	public Integer tenderRecordCount(Map<String, Object> map)
			throws BusinessException {
		return p2pTenderRecordMapper.tenderRecordCount(map);
	}

	@Override
	public List<Map<String, Object>> getBidRecord(Map<String, Object> map) {
		return p2pTenderRecordMapper.getBidRecord(map);
	}

	@Override
	public int getBidRecordCount(Map<String, Object> map) {
		
		return p2pTenderRecordMapper.getBidRecordCount(map);
	}

	@Override
	public List<P2p_account_flow> allTransFlowApp(Map<String, Object> params) {
		return p2pAccountFlowMapper.allTransFlowApp(params);
	}

	@Override
	public Integer allTransFlowTotalApp(Map<String, Object> params) {
		return p2pAccountFlowMapper.allTransFlowTotalApp(params);
	}

}
