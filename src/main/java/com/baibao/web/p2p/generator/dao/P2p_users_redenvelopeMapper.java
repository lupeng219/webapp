package com.baibao.web.p2p.generator.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;


public interface P2p_users_redenvelopeMapper {

	int sendRedEnvelope_520(Map<String, Object> params);
	
	
	int updateredenvelo(Map<String, Object>map);
	
    P2p_users_redenvelope queryBytransFlowNoPay(String flowNo);
    
    P2p_users_redenvelope  selectBytransFlowNoAction(String flowNo);

	int queryRedEnvelope_520(@Param(value="activeId")String activeId,@Param(value="custNo") String custNo);

	
	P2p_users_redenvelope queryRedEnvelopeActivation_520(@Param(value="activeId")String activeId,
			@Param(value="custNo")String custNo, @Param(value="amount")BigDecimal amount);


	int updateRedenvelopeUsed(P2p_users_redenvelope redenvelope);
    
    /**
     * 根据客户号查询不同状态的红包
     * @param custNo
     * @param status
     * @return
     */
    public List<Map<String, Object>> queryRedenvelopeBycustNo(@Param("custNo")String custNo,@Param("status")String status);
    
    /**
     * 查询未使用、小于当前时间红包(跑批使用接口)
     * @return
     */
    public List<P2p_users_redenvelope> queryRedenvelopeNotused();
    
    /**
     * 更新过期红包状态(跑批使用接口)
     * @param list
     * @return
     */
    public int updateRedenvelopeMature(List<P2p_users_redenvelope> redenvelopeList);
    
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