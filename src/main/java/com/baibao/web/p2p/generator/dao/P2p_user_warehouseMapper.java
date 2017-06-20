package com.baibao.web.p2p.generator.dao;

import java.util.Map;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
public interface P2p_user_warehouseMapper {

	int addPrize(Map<String, Object> params);
	
	/**
	 * 查询优惠券列表
	 * @param custNo
	 * @param status
	 * @return
	 */
	/*List<P2p_user_warehouse> queryWarehouseBycustNo(@Param("custNo")String custNo,@Param("status")String status);*/
	
	
	P2p_user_warehouse queryPrizeById(String id);
	
	/**
	 * 查询是否有该条记录
	 * @param map
	 * @return
	 */
	P2p_user_warehouse inspectWarehouse(Map<String, Object> map);
	/**
	 * 修改仓库表发放状态
	 * @param map
	 */
	void updateByPuw_whNo(Map<String, Object>map);
	
	P2p_user_warehouse selectBytransFlowNoAction(String flowNo);
//	待收跑批
	P2p_user_warehouse selectBytransFlowNo(String flowNo);
//	代付跑批
	P2p_user_warehouse selectBytransFlowNoPay(String flowNo);

}
