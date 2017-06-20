package com.baibao.web.p2p.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.web.p2p.generator.bean.P2p_loan_product;
import com.baibao.web.p2p.repository.LoanProductRepository;
import com.baibao.web.p2p.service.LoanProductService;
@Service("loanProductService")
public class LoanProductServiceImpl implements LoanProductService {
	
	@Autowired
	private LoanProductRepository loanProductRepository;
	
	@Override
	public List<P2p_loan_product> getByBulkloanstatus(Map<String, Object> map) {
		return loanProductRepository.getByBulkloanstatus(map);
	}

}
