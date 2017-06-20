package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_loan_product;
import com.baibao.web.p2p.generator.dao.P2p_loan_productMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_product_aidMapper;
import com.baibao.web.p2p.repository.LoanProductRepository;

@Repository
public class LoanProductRepositoryImpl implements LoanProductRepository {

	@Autowired
	private P2p_loan_productMapper loanProductDao;
	@Autowired
	private P2p_loan_product_aidMapper product_childDao;
	
	@Override
	public List<P2p_loan_product> getByBulkloanstatus(Map<String, Object> map) {
		
		return loanProductDao.getByBulkloanstatus(map);
	}

	@Override
	public int updateLoanProductStatus(Map<String, Object> map) {
		return loanProductDao.updateLoanProductStatusTwo(map);
	}

	@Override
	public int updateLoanProduct_aidStatus(Map<String, Object> map) {
		return product_childDao.updateLoanProduct_aidStatus(map);
	}

}
