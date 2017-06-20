package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.p2p_user_friends;


public interface P2p_user_friendsMapper {
	
	/**
	 * 邀请信息保存
	 * @param userFriends
	 * @return
	 */
	public int saveUserFriends(p2p_user_friends userFriends);
	
	/**
	 * 根据客户号查询邀请人信息
	 * @param custNo
	 * @return
	 */
	List<Map<String, Object>> queryFriendRecordBycustNo(Map<String, Object> params);
	
	/**
	 * 根据客户号查询邀请人总数
	 * @param custNo
	 * @return
	 */
	int getFriendRecordTotalBycustNo(Map<String, Object> params);
	
	/**
	 * 根据客户号查询邀请人投资记录
	 * @param custNo
	 * @return
	 */
	List<Map<String, Object>> getFriendTenderRecordBycustNo(Map<String, Object> params);
	
	/**
	 * 根据客户号查询邀请人投资记录
	 * @param custNo
	 * @return
	 */
	int  getFriendTenderRecordTotalBycustNo(Map<String, Object> params);
}
