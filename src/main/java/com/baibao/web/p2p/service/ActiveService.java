package com.baibao.web.p2p.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;





import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.controller.eventBus.events.FriendsInvestmentEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentActivationEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvitatRegistEvent;
import com.baibao.web.p2p.controller.eventBus.events.RegisterEvent;
import com.baibao.web.p2p.controller.eventBus.events.SendRedEnvelopeEvent;
import com.baibao.web.p2p.generator.bean.P2p_activity_elements;

/**
 * 活动业务类
 * @author yangyang
 *
 */
public interface ActiveService {

	public P2p_activity_elements getActiveById(Long activeId);

	public String getUserByInvitatId(Map<String, Object> map);
	/**
	 * 邀请注册活动业务接口
	 * @param event
	 * @throws Exception
	 */
	public void excutInvitatRegis(InvitatRegistEvent event)throws Exception;
	
	public void excutInvestment(InvestmentEvent event)throws Exception;
	
	/**
	 * 根据客户号和状态查询优惠券列表
	 * @param custNo
	 * @param status
	 * @return
	 */
	/*public List<P2p_user_warehouse> queryWarehouseBycustNo(String custNo,String status);*/
	
	/**
	 * 根据客户号查询邀请人信息
	 * @param custNo
	 * @return
	 */
	Paging<Map<String, Object>> queryFriendRecordBycustNo(String custNo,int pageNo,int pageSize,String startTime,String endTime,String userMobile);
	
	/**
	 * 根据类型查询唯一活动
	 * @param type
	 * @return
	 */
	public P2p_activity_elements getActiveByType(String type);

	/**
	 * 根据客户号查询邀请人投资记录
	 * @param custNo
	 * @return
	 */
	Paging<Map<String, Object>> getFriendTenderRecordBycustNo(String custNo,int pageNo,int pageSize,String startTime,String endTime,String userMobile);

	/**
	 * 活动插入公共入口
	 * @param event
	 */
	public void publicPortal(RegisterEvent event) throws Exception;
	
	/**
	 * 好友投资赠送入口
	 * @param event
	 */
	public void excutFriendsInvestment(FriendsInvestmentEvent event)  throws Exception;
	
	/**
	 * 首页活动页展示
	 * @return
	 */
	List<Map<String, Object>> showActiveList(Integer count);
	
	/**
	 * 根据客户号获取用户(未发放)奖励金额
	 * @param custNo
	 * @return
	 */
	public BigDecimal getSumReward(String custNo);
	
	/****注册送521元红包活动 start***/
	/**
	 * 520大红包活动
	 * @param event
	 */
	public void sendRedEnvelope_520(SendRedEnvelopeEvent event) throws Exception;

	public void redEnvelopeActivation_520(InvestmentActivationEvent event) throws Exception ;

	/**
	 * 根据客户号查询不同状态的红包
	 * @param custNo
	 * @param status
	 * @return
	 */
	public List<Map<String, Object>> queryRedenvelopeBycustNo(String custNo,String status) throws BusinessException;
	/****注册送521元红包活动 end***/
	
	/****大转盘活动start***/
	
	/**
	 * 根据客户号查询用户抽奖次数(当天)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public int queryLotteryDrawCount(String custNo) throws BusinessException;
	
	/**
	 * 查询用户中奖纪录
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> querySpoilList() throws BusinessException;
	
	/**
	 * 抽奖方法
	 * @param parameter
	 * @return
	 */
	public Map<String, Object> lotteryDraw(String custNo) throws BusinessException;
	
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
	 * 根据客户号查询得到的实物奖品
	 * @param custNo
	 * @return
	 */
	Paging<Map<String, Object>> goodsReward(String custNo,int pageNo,int pageSize);
	
	/****大转盘活动end***/
}
