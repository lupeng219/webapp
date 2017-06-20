package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

public interface P2p_ordinary_trans_aidMapper {
	
	/**
	 * 更新普通转账代付记录
	 * @param map
	 * @return
	 */
	public int upadteP2pB2cTransAid(Map<String, Object> map);
	
	/**
	 * 查询处理中的记录
	 * @return
	 */
	public List<Map<String, Object>> querySuspiciousPaymentFlow();
	

}
