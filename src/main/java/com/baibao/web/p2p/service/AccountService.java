package com.baibao.web.p2p.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.dataDIC.RegistType;

/**
 * 快捷充值(绑定支付)、支付推进(绑定支付)、网银支付、提现申请
 * @author jiangp
 * @date 2015年10月16日
 */
public interface AccountService
{ 
	/**
	 * 查询个人资金账户信息
	 * @param custNo
	 * @return
	 * @throws Exception
	 */
	public P2p_cust_account
		getCustAccountByCustNo(String custNo, boolean isRequestSina)
		throws BusinessException;
	
	/**
	 * 快捷充值(绑定支付)
	 * @param amount 	   充值金额
	 * @param custNo	   客户号
	 * @param transChannel	交易渠道（PC或Mobile）
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> bindingPayment(Map<String, Object> parameter)
			throws BusinessException;
	
	/**
	 * 支付推进(绑定支付)
	 * @param custNo 	         客户号
	 * @param validateCode 短信验证码
	 * @param transFlowNo 充值流水
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> advanceHostingPay(Map<String, Object> parameter) 
			throws BusinessException;

	
	/**
	 * 网银支付
	 * @param custNo 客户号
	 * @param amount 充值金额
	 * @param bankCode 银行编码
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> onlineBankPayment(
		String custNo, String amount, String bankCode,
		String registType, String rechargeType, String notifyUrl)
			throws BusinessException;
	
	
	/**
	 * 处理提现申请
	 * @param payCustNo 第三方支付账号
	 * @param custNo	 客户号
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> createHostingWithDraw(Map<String, Object> parameter)
		throws BusinessException;

	/**
	 * 查询可疑状态的充值/提现流水
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> querySuspiciousFlow() throws BusinessException;

	/**
	 * 根据流水修改订单状态
	 * @return
	 * @throws Exception
	 */
	public int updateSuspiciousFlow(String paf_transFlowNo, String status)
		throws BusinessException;
	
	/**
	 * 资产总览
	 * @param map
	 * @return
	 */
	public Map<String, Object> assetPandect(Map<String, Object> map)
		throws BusinessException;
	
	/**
	 * 我的负债
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> myDebt(String custNo)
		throws BusinessException;

	/**
	 * 第三方支付更改银行卡
	 * 
	 * @param custNo
	 * @param notifyUrl
	 * @return
	 */
	public Map<String, Object> changeCard(String custNo, String notifyUrl, RegistType registType);

	/**
	 * 第三方支付更改手机号
	 * 
	 * @param custNo
	 * @param notifyUrl
	 * @return
	 */
	public Map<String, Object> changePhone(String custNo, String notifyUrl);

	/**
	 * 第三方支付更改密码
	 * 
	 * @param custNo
	 * @param notifyUrl
	 * @return
	 */
	public Map<String, Object> changePassword(String custNo, String notifyUrl);
	
	/**
	 * 保存流水
	 * 
	 * @param transFlowNo 流水号
	 * @param custNo 用户号
	 * @param accountNo 帐户号
	 * @param amount 金额
	 * @param transChannel 交易渠道
	 * @param transType 交易类型
	 * @param rechargeType 充值类型
	 * @param status 状态
	 * 
	 * @return
	 * @throws RuntimeException
	 */
	public int saveAccountFlow(
		String transFlowNo, String custNo,
		String accountNo, String amount, String transChannel,
		String transType, String rechargeType, String status,
		String remark)
			throws RuntimeException;

	/**
	 * 同步三方账户资金
	 * @param accountNo
	 * @param custNo
	 */
	public void syncFreezedAmont(String accountNo, String custNo);
	
	/**
	 * 根据客户号查询收益 (待收 ，已收）
	 * @param map
	 * @return
	 */
	public BigDecimal profitSum(Map<String, Object> map);
}
