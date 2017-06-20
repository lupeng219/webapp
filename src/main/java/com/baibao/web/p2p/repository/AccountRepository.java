package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;

public interface AccountRepository {

	/**
	 * 保存充值、提现流水
	 * @param transFlowNo 流水号
	 * @param custNo 客户号
	 * @param payCustNo	支付账号
	 * @param amount 金额
	 * @param transChannel  交易渠道
	 * @param transType 流水类型
	 * @param rechargeType 充值类型
	 * @return map
	 * @throws RuntimeException
	 */
	public Map<String, Object> saveAccountFlow(
		String transFlowNo, String custNo,
		String payCustNo, String amount,
		String transChannel,
		String transType, String rechargeType,
		String status, String remark)
			throws RuntimeException;
	
	/**
	 * 网银流水
	 * @param transFlowNo
	 * @param custNo
	 * @param payCustNo
	 * @param amount
	 * @param transChannel
	 * @param transType
	 * @param rechargeType
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, Object>
		saveOnlineBankAccountFlow(
			String transFlowNo, String custNo,
			String payCustNo, String amount, String transChannel,
			String transType,String rechargeType, String remark)
				throws RuntimeException;
	
	
	/**
	 * 更新交易记录新浪返回数据
	 * @param pafHostResponseTime
	 * @param pafHostReturnCode
	 * @param pafHostReturnMessage
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> updateAccountFlow(
		String transFlowNo, String pafHostResponseTime,
		String pafHostReturnCode, String pafHostReturnMessage,
		String state)
			throws BusinessException;
	
	public Map<String, Object>
		updateBalanceAndRechargeByCustNoAccountNo(
			BigDecimal accountBalance, String custNo, String accountNo)
				throws RuntimeException;
	
	/**
	 * 查询个人账户信息
	 * @param custNo 客户号
	 * @return
	 * @throws BusinessException
	 */
	public P2p_cust_account getCustAccountByIdOrCustNo(String custNo)
		throws BusinessException;
	
	/**
	 * 查询可疑状态的充值/提现流水
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> querySuspiciousFlow()
		throws BusinessException;
	
	/**
	 * 根据流水修改订单状态
	 * @return
	 * @throws Exception
	 */
	public int updateSuspiciousFlow(String paf_transFlowNo, String status)
		throws BusinessException;
	
	/**
	 * 根据流水号查询（充值、提现）流水
	 * @param paf_transFlowNo
	 * @return
	 * @throws BusinessException
	 */
	public P2p_account_flow getAccountFlow(String paf_transFlowNo) throws BusinessException;
}
