package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.Context;
import com.baibao.web.p2p.generator.bean.P2p_activity_elements;
import com.baibao.web.p2p.generator.bean.P2p_activity_param;

public interface ActiveRepository {

	public P2p_activity_elements getActiveById(Long activeId);

	public String getUserByInvitatId(Map<String, Object> map);

	void addFriendsRegistInvitation(Map<String, Object> params) throws Exception ;

	public P2p_activity_elements getActiveByType(String type);

	public List<P2p_activity_param> getActiveParamById(Long id);
	/**
	 * 统计时间段内投资的金额总和
	 * @param p 参数
	 * @return
	 */
	public Map<String, Object> statisticalTendAmountPeriodOfTime(
			Map<String, Object> p);
	
	/**
	 * 投资用户好友客户号
	 * @param puCustNo
	 * @return
	 */
	public String getUserFriends(String puCustNo);
	
	/**
	 * 首页活动展示
	 * @return
	 */
	List<Map<String, Object>> showActiveList(Integer count);
	
	/**
	 * 根据投资流水号获得产品详情
	 * @param tenderFlowNo
	 * @return
	 */
	public Map<String, Object> getProductByTenderFlowNo(String tenderFlowNo);

	/**
	 * 根据客户号获取用户(未发放)奖励金额
	 * @param custNo
	 * @return
	 */
	public BigDecimal getSumReward(String custNo);
	
	
	/**
	 * 更新活动代收流水
	 * @param context
	 * @param judgment
	 * @return
	 */
	public int updateActiveB2cTransAid(Context context, Boolean judgment);
	
	/**
	 * 更新活动代付流水
	 * @param context
	 * @param judgment
	 * @return
	 */
	public int updateActiveB2cTrans(Context context, String judgment);
}
