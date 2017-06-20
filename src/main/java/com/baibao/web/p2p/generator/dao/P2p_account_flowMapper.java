package com.baibao.web.p2p.generator.dao;


import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;

public interface P2p_account_flowMapper {
   
	public int save(P2p_account_flow accountFlow) throws RuntimeException;
	
	/**
	 * 更新交易记录新浪返回数据
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public int updateAccountFlow(Map<String, Object> result) throws BusinessException;
	
	public int updateTransFlowNo(Map<String, Object> map) throws RuntimeException;
	
	public P2p_account_flow getByTransFlowNo(String transFlowNo) throws BusinessException;
	
	public List<P2p_account_flow> getByCustNoAndType(Map<String, Object> params);
	
	public Integer getTransRecordTotal(Map<String, Object> params);
	
	public List<P2p_account_flow> allTransFlow (Map<String, Object> params);
	
	public Integer allTransFlowTotal(Map<String, Object> params);
	
	public List<P2p_account_flow> allTransFlowApp (Map<String, Object> params);
	
	public Integer allTransFlowTotalApp(Map<String, Object> params);
	
	
	public List<Map<String, Object>> querySuspiciousFlow() throws BusinessException;
	
	public int updateSuspiciousFlow( Map<String, Object> params );
	
}