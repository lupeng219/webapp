package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;


public interface P2p_ordinary_transMapper {
	
	/**
	 * 更新普通转账代付记录
	 * @param map
	 * @return
	 */
	public int upadteP2pB2cTrans(Map<String, Object> map);
	
	/**
	 * 查询客户号和支付账号
	 * @param outer_trade_no
	 * @return
	 */
	public Map<String, Object> getB2cByTradeFlowNo(String outer_trade_no);
	
	public Map<String, Object> getTradeFlowNo(String outer_trade_no);
	/**
	 * 查询处理中的代付记录
	 * @return
	 */
	public List<Map<String, Object>> querySuspiciousPaymentFlow();
	
}
