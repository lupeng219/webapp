package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.Context;
import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_activity_elements;
import com.baibao.web.p2p.generator.bean.P2p_activity_param;
import com.baibao.web.p2p.generator.dao.P2p_activityMapper;
import com.baibao.web.p2p.generator.dao.P2p_activity_elementsMapper;
import com.baibao.web.p2p.generator.dao.P2p_activity_paramMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_recordMapper;
import com.baibao.web.p2p.generator.dao.P2p_userMapper;
import com.baibao.web.p2p.repository.ActiveRepository;
@Repository
public class ActiveRepositoryImpl implements ActiveRepository {

	@Autowired
	P2p_activity_elementsMapper activeDao;
	@Autowired
	P2p_activity_paramMapper activeParamDao;
	@Autowired
	P2p_tender_recordMapper tendRecordDao;
	@Autowired
	P2p_userMapper userDao;
	@Autowired
	P2p_tender_recordMapper tenderRecordDao;
	@Autowired
	private P2p_activityMapper p2p_activityMapper;
	
	
	@Override
	public P2p_activity_elements getActiveById(Long activeId) {
		
		return activeDao.getActiveById(activeId);
	}

	@Override
	public String getUserByInvitatId(Map<String, Object> map) {
		return activeDao.getUserByInvitatId(map);
	}

	@Override
	public void addFriendsRegistInvitation(Map<String, Object> params) throws Exception {
		int i = 0;
		i = activeDao.addFriendsRegistInvitation(params);
		if(i != 1)
			throw new BusinessException("插入好友注册赠送表失败");
	}

	@Override
	public P2p_activity_elements getActiveByType(String type) {
		return activeDao.getActiveByType(type);
	}

	@Override
	public List<P2p_activity_param> getActiveParamById(Long id) {
		return activeParamDao.getActiveParamById(id);
	}

	@Override
	public Map<String, Object> statisticalTendAmountPeriodOfTime(
			Map<String, Object> p) {
		return tendRecordDao.statisticalTendAmountPeriodOfTime(p);
	}

	@Override
	public String getUserFriends(String puCustNo) {
		return userDao.getUserFriends(puCustNo);
	}

	@Override
	public List<Map<String, Object>> showActiveList(Integer count) {
		return activeDao.showActiveList(count);
	}

	@Override
	public Map<String, Object> getProductByTenderFlowNo(String tenderFlowNo) {
		Map<String, Object> map = tenderRecordDao.getProductByTenderFlowNo(tenderFlowNo);
		return map;
	}

	@Override
	public BigDecimal getSumReward(String custNo) {
		return activeDao.getSumReward(custNo);
	}

	@Override
	public int updateActiveB2cTransAid(Context context, Boolean judgment) {
		Map<String, Object> map = new HashMap<String, Object>();
		String outer_trade_no = context.getString("outer_trade_no");
		String inner_trade_no = context.getString("inner_trade_no");
		String trade_status = context.getString("trade_status");
		String gmt_close = context.getString("gmt_close");
		
		map.put("part_transFlowNo", outer_trade_no);//还款账单编号(如果是批次,则是批次号)
		map.put("part_host_response_time", gmt_close);//响应时间
		map.put("part_host_response_flowNum", inner_trade_no);//返回的交易流水号
		map.put("part_host_return_code", trade_status);//返回码
		if(judgment){
			map.put("part_status", "00");//还款状态 00 成功  01 失败   02 处理中
		}else{
			map.put("part_status", "01");//还款状态 00 成功  01 失败   02 处理中
		}
		int count = p2p_activityMapper.updateActiveB2cTransAid(map);
		return count;
	}

	@Override
	public int updateActiveB2cTrans(Context context, String judgment) {
		Map<String, Object> map = new HashMap<String, Object>();
		String outer_trade_no = context.getString("part_transFlowNo");
		String inner_trade_no = context.getString("inner_trade_no");
		String trade_status = context.getString("trade_status");
		String gmt_close = context.getString("gmt_close");
		
		map.put("part_transFlowNo", outer_trade_no);//还款账单编号(如果是批次,则是批次号)
		map.put("part_host_response_time", gmt_close);//响应时间
		map.put("part_host_response_flowNum", inner_trade_no);//返回的交易流水号
		map.put("part_host_return_code", trade_status);//返回码
		map.put("part_status", judgment);//还款状态 00 成功  01 失败   02 处理中
		p2p_activityMapper.updateActiveB2cTrans(map);
		return 0;
	}


}
