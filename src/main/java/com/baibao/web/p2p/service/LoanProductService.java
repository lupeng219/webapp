package com.baibao.web.p2p.service;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_loan_product;


public interface LoanProductService {
	
	/**
	 * 根据产品状态获得产品
	 * @param bulkLoanStatus
	 * @return
	 */
	public List<P2p_loan_product>  getByBulkloanstatus(Map<String, Object> map);
	
}
