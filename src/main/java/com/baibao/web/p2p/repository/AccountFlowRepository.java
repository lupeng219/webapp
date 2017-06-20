package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;

public interface AccountFlowRepository {

	public int save(P2p_account_flow accountFlow) throws RuntimeException;
	
	public int updateTransFlowNo(Map<String, Object> map) throws RuntimeException;
	
	/**
	 * 查询充值、提现记录
	 * @param transFlowNo 充值、提现流水号
	 * @return
	 * @throws BusinessException
	 */
	public P2p_account_flow getByTransFlowNo(String transFlowNo) throws BusinessException;
	
	public List<P2p_account_flow> getByCustNoAndType(Map<String, Object> params);
	
	public Integer getTransRecordTotal(Map<String, Object> params);
	
	public List<P2p_account_flow> allTransFlow (Map<String, Object> params);
	
	public Integer allTransFlowTotal(Map<String, Object> params);
	
}
