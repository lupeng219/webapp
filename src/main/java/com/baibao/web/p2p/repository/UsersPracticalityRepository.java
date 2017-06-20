package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;


public interface UsersPracticalityRepository {
	
	/**
	 * 查询是否已经使用抽奖机会得到实物
	 * @param pulLotterydrawno
	 * @return
	 */
	public int getPracticalityLotteryDrawNo(String pulLotterydrawno);
	
	/**
	 * 查询该用户是否已经得到某一实物
	 * @param pulLotterydrawno
	 * @return
	 */
	public int getPracticalityByCustNo(String custNo,String puptestimonialNo);
	
	/**
	 * 保存用户实物
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public int savePracticality(Map<String, Object> map) throws BusinessException;
	
	 /**
	 * 根据客户号查询得到的实物奖品
	 * @param custNo
	 * @return
	 */
	public List<Map<String, Object>>goodsReward(Map<String, Object> map);
	public Integer goodsRewardCount(Map<String, Object> map);
}
