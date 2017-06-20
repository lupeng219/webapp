package com.baibao.web.p2p.service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;

public interface LoanApplyService {

	int insertSelective(P2p_loan_apply custNo) throws BusinessException;
	
	/**
	 * 借款申请记录
	 * @param custNo
	 * @param loanApplyStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws RuntimeException
	 */
	public Paging<P2p_loan_apply> findLoanApplyRecordsByCust(String custNo,
			String loanApplyStatus, int currentPageNo, int pageSize)
			throws BusinessException;
	 
	
	public P2p_loan_apply  searchByPorductNo(String productNo);
}
