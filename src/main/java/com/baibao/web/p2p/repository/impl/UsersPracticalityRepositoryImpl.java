package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.dao.P2p_users_practicalityMapper;
import com.baibao.web.p2p.repository.UsersPracticalityRepository;

@Repository
public class UsersPracticalityRepositoryImpl implements UsersPracticalityRepository {

	@Autowired
	private P2p_users_practicalityMapper p2p_users_practicalityMapper;
	
	@Override
	public int getPracticalityLotteryDrawNo(String pulLotterydrawno) {
		return p2p_users_practicalityMapper.getPracticalityLotteryDrawNo(pulLotterydrawno);
	}

	@Override
	public int savePracticality(Map<String, Object> map) throws BusinessException {
		
		return p2p_users_practicalityMapper.savePracticality(map);
	}

	@Override
	public List<Map<String, Object>> goodsReward(Map<String, Object> map) {
		return p2p_users_practicalityMapper.goodsReward(map);
	}

	@Override
	public Integer goodsRewardCount(Map<String, Object> map) {
		return p2p_users_practicalityMapper.goodsRewardCount(map);
	}

	@Override
	public int getPracticalityByCustNo(String custNo,String puptestimonialNo) {
		
		return p2p_users_practicalityMapper.getPracticalityByCustNo(custNo,puptestimonialNo);
	}


}
