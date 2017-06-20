package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;

public interface CustAccountRepository {

	public P2p_cust_account queryIdentityId(String custNo);
	
	
	/**
	 * 更新交易密码
	 * @param map
	 */
	public int updateTransPassword(Map<String, Object> map) throws Exception;
	
	public P2p_cust_account getCustAccountByIdOrCustNo(Map<String, Object> params)
			throws BusinessException;
	
	/**
	 * 根据客户号和支付账号更新账户余额及充值金额
	 * @param params
	 * @throws Exception
	 */
	int updateBalanceAndRechargeByCustNoAccountNo(Map<String, Object> params) throws RuntimeException;
	
	/**
	 * 根据客户号和支付账号更新账户余额及提现金额
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int updateBalanceAndMentionNowByCustNoAccountNo(Map<String, Object> params) throws RuntimeException;

	/**
	 * 更新账户余额
	 * @param outer_trade_no
	 * @return
	 */
	public int updateAccountBalance(String accountNo, String custNo);
	
	public int updateByPrimaryKeySelective(P2p_cust_account record);
}
