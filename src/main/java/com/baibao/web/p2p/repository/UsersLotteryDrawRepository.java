package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_users_lotteryDraw;


public interface UsersLotteryDrawRepository {
	
	/**
	 * 根据客户号查询用户抽奖次数(当天)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public int queryLotteryDrawCount(String custNo) throws BusinessException;
	
	/**
	 * 根据客户号查询用户抽奖次数(当天)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public List<P2p_users_lotteryDraw> queryLotteryDrawList(String custNo) throws BusinessException;
	
	/**
	 * 查询用户中奖纪录
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> queryPracticalityAndRedenvelopeList(String activeid_dzp) throws BusinessException;
	
	/**
	 * 根据客户号、来源类型查询抽奖次数
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public int queryBycustNoAndSourceType(String custNo,String sourceType) throws BusinessException;
	
	/**
	 * p2p_users_lotteryDraw表插入数据
	 * @return
	 * @throws BusinessException
	 */
	public int insertLotteryDraw(Map<String, Object> params) throws BusinessException;
	
	/**
	 * 根据用户抽奖编号修改使用状态
	 * @param pulLotteryDrawNo
	 * @return
	 * @throws BusinessException
	 */
	public int updateLotteryDraw(String pulLotteryDrawNo) throws BusinessException;
	
}
