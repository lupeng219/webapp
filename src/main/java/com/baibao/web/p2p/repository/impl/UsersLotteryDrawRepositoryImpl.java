package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.generator.bean.P2p_users_lotteryDraw;
import com.baibao.web.p2p.generator.dao.P2p_users_lotteryDrawMapper;
import com.baibao.web.p2p.repository.UsersLotteryDrawRepository;

@Repository
public class UsersLotteryDrawRepositoryImpl implements UsersLotteryDrawRepository {

	@Autowired
	private P2p_users_lotteryDrawMapper p2p_users_lotteryDrawMapper;
	
	@Override
	public int queryLotteryDrawCount(String custNo) throws BusinessException {
		if(StringUtil.isEmpty(custNo)){
			return 0;
		}
		return p2p_users_lotteryDrawMapper.queryLotteryDrawCount(custNo);
	}

	@Override
	public List<P2p_users_lotteryDraw> queryLotteryDrawList(String custNo)
			throws BusinessException {
		if(StringUtil.isEmpty(custNo)){
			return null;
		}
		return p2p_users_lotteryDrawMapper.queryLotteryDrawList(custNo);
	}

	@Override
	public List<Map<String, Object>> queryPracticalityAndRedenvelopeList(String activeid_dzp)
			throws BusinessException {
		return p2p_users_lotteryDrawMapper.queryPracticalityAndRedenvelopeList(activeid_dzp);
	}

	@Override
	public int queryBycustNoAndSourceType(String custNo, String sourceType) throws BusinessException {
		return p2p_users_lotteryDrawMapper.queryBycustNoAndSourceType(custNo, sourceType);
	}

	@Override
	public int insertLotteryDraw(Map<String, Object> params) throws BusinessException {
		return p2p_users_lotteryDrawMapper.insertLotteryDraw(params);
	}

	@Override
	public int updateLotteryDraw(String pulLotteryDrawNo) throws BusinessException {
		return p2p_users_lotteryDrawMapper.updateLotteryDraw(pulLotteryDrawNo);
	}


}
