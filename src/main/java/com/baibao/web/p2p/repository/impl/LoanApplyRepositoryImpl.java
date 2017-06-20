package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.dao.P2p_loan_applyMapper;
import com.baibao.web.p2p.repository.LoanApplyRepository;
@Repository
public class LoanApplyRepositoryImpl implements LoanApplyRepository {


	@Autowired
	private P2p_loan_applyMapper p2pLoanApplyMapper;
	
	@Override
	public int insertSelective(P2p_loan_apply record) {
		return  p2pLoanApplyMapper.insertSelective(record);
	}
	
	@Override
	public P2p_loan_apply searchByPorductNo(String productNo) {
		return p2pLoanApplyMapper.searchByPorductNo(productNo);
	}

	@Override
	public List<P2p_loan_apply> findLoanApplyRecordsByCust(
			Map<String, Object> params) throws BusinessException {
		return p2pLoanApplyMapper.findLoanApplyRecordsByCust(params);
	}

	@Override
	public int findLoanApplyRecordsByCustTotal(Map<String, Object> params)
			throws BusinessException {
		return p2pLoanApplyMapper.findLoanApplyRecordsByCustTotal(params);
	}

	
}
