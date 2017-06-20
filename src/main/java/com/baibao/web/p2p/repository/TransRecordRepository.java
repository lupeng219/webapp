package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;

public interface TransRecordRepository {

	
	public List<P2p_account_flow> getByCustNoAndType(Map<String, Object> params);
	
	public Integer getTransRecordTotal(Map<String, Object> params);
	
	public List<P2p_account_flow> allTransFlow (Map<String, Object> params);
	
	public Integer allTransFlowTotal(Map<String, Object> params);
	
	public List<P2p_account_flow> allTransFlowApp (Map<String, Object> params);
	
	public Integer allTransFlowTotalApp(Map<String, Object> params);
	
	/**
	 * 每月投资总额
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> getInvestmentAmount(String custNo) throws BusinessException;

	public List<Map<String, Object>> tenderRecord(Map<String, Object>map)throws BusinessException;
	
	public Integer tenderRecordCount(Map<String, Object>map)throws BusinessException;
	
	/**
	 * 查询标的投标记录(合同)
	 * @param productNo
	 * @return
	 */
	public List<Map<String, Object>> getBidRecord(Map<String, Object> map);
	
	/**
	 * 查询标的投标记录Count(合同)
	 * @param map
	 * @return
	 */
	public int getBidRecordCount(Map<String, Object> map);
}
