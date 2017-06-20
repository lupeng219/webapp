package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;
import com.baibao.web.p2p.generator.dao.P2p_friend_tenderMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_friendsMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_warehouseMapper;
import com.baibao.web.p2p.generator.dao.P2p_users_redenvelopeMapper;
import com.baibao.web.p2p.generator.dao.P2p_users_redenvelope_friendTenderMapper;
import com.baibao.web.p2p.repository.WarehouseRepository;
@Repository
public class WarehouseRepositoryImpl implements WarehouseRepository {
	private static Logger logger = LoggerFactory.getLogger(WarehouseRepositoryImpl.class);

	@Autowired
	P2p_user_warehouseMapper warehouseDao;
	
	@Autowired
	P2p_friend_tenderMapper friendTenderDao;
	
	@Autowired
	private P2p_user_friendsMapper userFriendsDao;
	
	@Autowired
	private P2p_users_redenvelopeMapper redenvelopeDao;
	
	@Autowired
	private P2p_users_redenvelope_friendTenderMapper redenvelope_friendTenderDao;
	
	@Override
	public void addPrize(Map<String, Object> params) throws Exception {
        int i = 0;
        	i = warehouseDao.addPrize(params);
        	if(i != 1)
        		throw new BusinessException("插入仓库表失败");
		
	}
	
	/*@Override
	public List<P2p_user_warehouse> queryWarehouseBycustNo(String custNo,String status) {
		
		return warehouseDao.queryWarehouseBycustNo(custNo,status);
	}*/

	@Override
	public List<Map<String, Object>> queryFriendRecordBycustNo(Map<String, Object> params) {
		
		return userFriendsDao.queryFriendRecordBycustNo(params);
	}

	@Override
	public int getFriendRecordTotalBycustNo(Map<String, Object> params) {
		
		return userFriendsDao.getFriendRecordTotalBycustNo(params);
	}

	@Override
	public List<Map<String, Object>> getFriendTenderRecordBycustNo(Map<String, Object> params) {
		
		return userFriendsDao.getFriendTenderRecordBycustNo(params);
	}
	
	@Override
	public int getFriendTenderRecordTotalBycustNo(Map<String, Object> params) {
		
		return userFriendsDao.getFriendTenderRecordTotalBycustNo(params);
	}

	@Override
	public P2p_user_warehouse queryPrizeById(String id) {
		return warehouseDao.queryPrizeById(id);
	}

	@Override
	public int addFriendTender(Map<String, Object> params) {
		int result = friendTenderDao.insertFriendTender(params);
		return result;
	}

	@Override
	public P2p_user_warehouse inspectWarehouse(String custNo, String activityId,String goodTypes) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("puw_custNo", custNo);
		map.put("puw_activeId", activityId);
		map.put("puw_code", goodTypes);
		return warehouseDao.inspectWarehouse(map);
	}

	@Override
	public int inspectFriendTender(String custNo,
			String tenderFlowNo, String projectNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("puwa_friendCustNo", custNo);
		map.put("puwa_projectNo", projectNo);
		map.put("puwa_tenderFlowNo", tenderFlowNo);
		int result = friendTenderDao.inspectFriendTender(map);
		return result;
	}

	@Override
	public void sendRedEnvelope_520(Map<String, Object> params) throws Exception {
		int i = 0;
		try {
			i = redenvelopeDao.sendRedEnvelope_520(params);
			if(i != 1)
				throw new BusinessException("插入红包表失败");
		} catch (Exception e) {
			logger.error("sendRedEnvelope_520",e);
			throw e;
		}
	}

	@Override
	public boolean queryRedEnvelope_520(String activeId, String custNo) {
		 return redenvelopeDao.queryRedEnvelope_520(activeId,custNo)>0;
	}

	@Override
	public P2p_users_redenvelope queryRedEnvelopeActivation_520(
			String activeId, String custNo, BigDecimal amount) {
		return redenvelopeDao.queryRedEnvelopeActivation_520(activeId, custNo, amount);
	}

	@Override
	public void updateRedenvelopeUsed(P2p_users_redenvelope redenvelope) throws Exception {
		int i = 0;
		try {
			i = redenvelopeDao.updateRedenvelopeUsed(redenvelope);
			if(i != 1)
				throw new BusinessException("更新红包状态失败");
		} catch (Exception e) {
			logger.error("updateRedenvelopeUsed",e);
			throw e;
		}
	}

	@Override
	public void insertRedenvelope_friendTender(String purRedenvelopeno,
			String custNo, String projectNo, String tenderFlowNo) throws Exception  {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("purRedenvelopeno", purRedenvelopeno);
		param.put("custNo", custNo);
		param.put("projectNo", projectNo);
		param.put("tenderFlowNo", tenderFlowNo);
		try {
			int i = 0;
			i = redenvelope_friendTenderDao.insertRedenvelope_friendTender(param);
			if( i != 1)
				throw  new BusinessException("插入红包激活记录表失败");
		} catch (Exception e) {
			logger.error("insertRedenvelope_friendTender",e);
			throw e;
		}
	}

}
