package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_product;

public interface LoanProductRepository {
	
	 /**
     * 根据状态获得产品
     * @param map
     * @return
     */
	public List<P2p_loan_product> getByBulkloanstatus(Map<String, Object> map);
	
	/**
	 * 更新产品状态
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	int updateLoanProductStatus(Map<String, Object>map) ;
	
	int updateLoanProduct_aidStatus(Map<String, Object>map);

}
