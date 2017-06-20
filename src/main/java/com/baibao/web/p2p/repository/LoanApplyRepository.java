package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;

public interface LoanApplyRepository {
	 /**
	  * 插入借款申请表
	  * @param record
	  * @return
	  */
	int insertSelective(P2p_loan_apply record);
	
	/**
	 * 借款申请记录
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public List<P2p_loan_apply> findLoanApplyRecordsByCust(Map<String, Object> params) throws BusinessException;
	
	/**
	 * 借款申请记录count
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public int findLoanApplyRecordsByCustTotal(Map<String, Object> params) throws BusinessException;
	/**
	 * 根据产品编号查询借款申请
	 * @param productNo
	 * @return
	 */
	public P2p_loan_apply searchByPorductNo(String productNo);
	
	
}
