package com.baibao.web.p2p.service;

import com.baibao.web.p2p.generator.bean.P2p_public_order;

public interface PublicOrderService {
	
	/**
	 * 插入订单记录表
	 * @return
	 */
	public int insertPublicOrder(P2p_public_order record);
	/**
	 * 根据流水号修改状态
	 * @return
	 */
	public int updateByOrderFlowNo(String orderFlowNo, String ppoStatus);
	
	/**
	 * 根据流水号查询订单
	 * @param orderFlowNo
	 * @return
	 */
	P2p_public_order  selectByPrimaryKey(String orderFlowNo);

}
