package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;













import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;

public interface WarehouseRepository {

	void addPrize(Map<String, Object> params) throws Exception;
	
	/*List<P2p_user_warehouse> queryWarehouseBycustNo(String custNo,String status);*/
	
	List<Map<String, Object>> queryFriendRecordBycustNo(Map<String, Object> params);
	
	int getFriendRecordTotalBycustNo(Map<String, Object> params);

	
	List<Map<String, Object>> getFriendTenderRecordBycustNo(Map<String, Object> params);
	
	int  getFriendTenderRecordTotalBycustNo(Map<String, Object> params);

	/**
	 * 根据id查询仓库商品信息
	 * @param id
	 * @return
	 */
	public P2p_user_warehouse queryPrizeById(String id);
	
	/**
	 * 好友投资仓库表插入
	 * @param params
	 */
	public int addFriendTender(Map<String, Object> params);
	
	/**
	 * 查看是否有该条记录
	 * @param custNo
	 * @param whNo
	 * @return
	 */
	public P2p_user_warehouse inspectWarehouse(String custNo, String activityId,String goodTypes);
	
	/**
	 * 查看好友投资仓库表是否有记录
	 * @param custNo
	 * @param tenderFlowNo
	 * @param projectNo
	 * @return
	 */
	public int inspectFriendTender(String custNo, String tenderFlowNo,String projectNo);

	void sendRedEnvelope_520(Map<String, Object> params) throws Exception;
	/**
	 * 查询520元红包是否已经发送
	 * @param activeId
	 * @param custNo
	 * @return
	 */
	boolean queryRedEnvelope_520(String activeId, String custNo);
	/**
	 * 查询相应的金额的投资红包有无激活
	 * @param activeId
	 * @param custNo
	 * @param amount
	 * @return
	 */
	P2p_users_redenvelope queryRedEnvelopeActivation_520(String activeId, String custNo, BigDecimal amount);

	void updateRedenvelopeUsed(P2p_users_redenvelope redenvelope) throws Exception ;

	void insertRedenvelope_friendTender(String purRedenvelopeno, String custNo,
			String projectNo, String tenderFlowNo) throws Exception ;

}
