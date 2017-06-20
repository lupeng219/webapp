package com.baibao.web.p2p.generator.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.web.p2p.generator.bean.P2p_activity_elements;

public interface P2p_activity_elementsMapper {

	P2p_activity_elements getActiveById(Long activeId);

	public String getUserByInvitatId(Map<String, Object> map);

	int addFriendsRegistInvitation(Map<String, Object> params);

	P2p_activity_elements getActiveByType(String type);
	
	List<Map<String, Object>> showActiveList(@Param("count")Integer count);
	
	/**
	 * 根据客户号获取用户(未发放)奖励金额
	 * @param custNo
	 * @return
	 */
	public BigDecimal getSumReward(String custNo);

}
