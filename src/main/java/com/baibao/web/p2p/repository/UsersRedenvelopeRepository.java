package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;


public interface UsersRedenvelopeRepository {
	/**
	 *  根据客户号查询不同状态的红包
	 * @param custNo
	 * @param status
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> queryRedenvelopeBycustNo(String custNo,String status) throws BusinessException;
	
	/**
	 * 更新过期红包状态(跑批使用接口)
	 */
	public void updateRedenvelopeMature();
	
	/**
	 * 根据用户抽奖编号查询用户红包
	 * @param lotteryDrawNo
	 * @return
	 */
	public int getRedenvelopeLotteryDrawNo(String lotteryDrawNo);
	
	/**
	 * 保存红包(大转盘活动)
	 * @param parameter
	 * @return
	 * @throws BusinessException
	 */
	public int saveRedenvelope(Map<String, Object> parameter) throws BusinessException;
}
