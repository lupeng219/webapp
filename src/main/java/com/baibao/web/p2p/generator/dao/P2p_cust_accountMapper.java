package com.baibao.web.p2p.generator.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;

public interface P2p_cust_accountMapper {

	/**
	 * 保存第三方支付信息
	 * @param cusAccount
	 * @return
	 * @throws Exception
	 */
	int save(P2p_cust_account cusAccount) throws BusinessException;
	
	/**
	 * 查询个人账户信息	
	 * @param params
	 * @return
	 * @throws Exception
	 */
	P2p_cust_account getCustAccountByIdOrCustNo(Map<String, Object> params)
			throws BusinessException;
	/**
	 * 根据客户号和支付账号更新账户余额及充值金额
	 * @param params
	 * @throws Exception
	 */
	int updateBalanceAndRechargeByCustNoAccountNo(Map<String, Object> params) throws RuntimeException;

	
	/**
	 * 查询第三方信息
	 * @param map
	 * @return
	 */
	public P2p_cust_account getByCustNoAndType(Map<String, Object> map);
	
	/**
	 * 根据客户号和支付账号更新账户余额及提现金额
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int updateBalanceAndMentionNowByCustNoAccountNo(Map<String, Object> params) throws RuntimeException;

	P2p_cust_account queryIdentityId(String custNo);
	
	/**
	 * 更新账户余额
	 * @param map
	 * @return
	 */
	public int updatePcaAccountBalance(Map<String, Object> map) throws RuntimeException;
	
	/**
	 * 更新账户余额和冻结金额
	 * @param map
	 * @return
	 */
	public int updateBalanceAndFreeze(@Param("custNo")String custNo,@Param("balance")String balance,@Param("freeze")String freeze);
	
	/**
	 * 更新或设置交易密码
	 * @param map
	 * @return
	 * @throws RuntimeException
	 */
	public int updatePayPassword(Map<String, Object> map) throws RuntimeException;
	
	/**
	 * 更新账户余额
	 * @param pca_accountNo 第三方那个支付账号
	 * @return
	 */
	public int updateAccountBalance(Map<String, Object> map);
	
	/**
	 * 根据客户号修改更新使用状态
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public int updateCustAccount(Map<String, Object> map) throws BusinessException;
	
	public int updateByPrimaryKeySelective(P2p_cust_account record);
}