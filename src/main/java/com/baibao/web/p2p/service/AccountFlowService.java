package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.exception.BusinessException;

public interface AccountFlowService {
	
	/**
	 * 充值
	 * @param custNo 客户号
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> toRecharge(String custNo,String mobile) throws BusinessException;
	
	/**
	 * 提现
	 * @param custNo 客户号
	 * @return
	 */
	public Map<String, Object> toWithDrawals(String custNo,String mobile) throws BusinessException;
}
