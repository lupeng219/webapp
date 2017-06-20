package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.core.exception.BusinessException;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.dao.P2p_account_flowMapper;
import com.baibao.web.p2p.generator.dao.P2p_cust_accountMapper;
import com.baibao.web.p2p.repository.AccountRepository;
import com.umpay.api.util.StringUtil;

@Repository
public class AccountRepositoryImpl
	implements AccountRepository
{
	private static final Logger logger =
		LoggerFactory.getLogger(AccountRepositoryImpl.class);
	
	@Autowired
	private P2p_account_flowMapper accountFlowMapper;	
	@Autowired
	private P2p_cust_accountMapper custAccountMapper;

	@Override
	@Transactional
	public Map<String, Object> saveAccountFlow(
		String transFlowNo, String custNo,
		String payCustNo, String amount, String transChannel,
		String transType, String rechargeType, String status,
		String remark)
			throws RuntimeException
	{
		Map<String, Object> result = new HashMap<String, Object>();

		result.put(Const.retCode, true);

		if (status == null)
			status = Const.pending;

		// 保存充值或提现流水
		P2p_account_flow accountFlow = new P2p_account_flow();
		
		accountFlow.setPafTransflowno(transFlowNo);
		accountFlow.setPafCustno(custNo);
		accountFlow.setPafAccountno(payCustNo);
		accountFlow.setPafTransactionmoney(new BigDecimal(amount));
		accountFlow.setPafTransactiondatetime(Utils.now());
		accountFlow.setPafChannelnum(transChannel); // 交易渠道(pc/mobile)
		accountFlow.setPafStatus(status);
		accountFlow.setPafRemark(remark);

		accountFlow.setPafTransactiontype(transType);
		accountFlow.setPafRechargeType(rechargeType);
		
		int count = accountFlowMapper.save(accountFlow);
		
		if (count <= 0)
			result.put(Const.retCode, false);

		return result;
	}

	@Override
	public Map<String, Object> saveOnlineBankAccountFlow(
		String transFlowNo, String custNo,
		String payCustNo, String amount, String transChannel,
		String transType,String rechargeType, String remark)
			throws RuntimeException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Const.retCode, true);
		
		// 保存充值或提现流水
		P2p_account_flow accountFlow = new P2p_account_flow();
		
		accountFlow.setPafTransflowno(transFlowNo);
		accountFlow.setPafCustno(custNo);
		accountFlow.setPafAccountno(payCustNo);
		accountFlow.setPafTransactionmoney(new BigDecimal(amount));
		accountFlow.setPafTransactiondatetime(new Date());
		accountFlow.setPafChannelnum(transChannel); // 交易渠道(pc/mobile)
		accountFlow.setPafStatus(Const.processing);
		//accountFlow.setPafHostReturnCode("PROCESSING");
		accountFlow.setPafTransactiontype(transType);
		accountFlow.setPafRechargeType(rechargeType);
		accountFlow.setPafRemark(remark);
		
		int count = accountFlowMapper.save(accountFlow);
		if (count <= 0)
			result.put(Const.retCode, false);

		return result;
	}
	
	/**
	 * 更新交易记录新浪返回数据
	 * @param pafHostResponseTime
	 * @param pafHostReturnCode
	 * @param pafHostReturnMessage
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public Map<String, Object> updateAccountFlow(String transFlowNo,String pafHostResponseTime,String pafHostReturnCode,String pafHostReturnMessage,String state) throws BusinessException{
		Map<String, Object> result = new HashMap<String, Object>();
		if(StringUtil.isEmpty(transFlowNo) || StringUtil.isEmpty(pafHostReturnMessage) || StringUtil.isEmpty(pafHostReturnCode) || StringUtil.isEmpty(pafHostResponseTime)){
			result.put(Const.retCode, false);
			return result;
		}
		result.put("transFlowNo", transFlowNo);
		result.put("pafHostResponseTime", pafHostResponseTime);
		result.put("pafHostReturnCode", pafHostReturnCode);
		result.put("pafHostReturnMessage", pafHostReturnMessage);
		result.put("paf_status", state);
		int count = accountFlowMapper.updateAccountFlow(result);
		result.clear();
		if(count > 0){
			result.put(Const.retCode, true);
		}else{
			result.put(Const.retCode, false);
		}
		return result;
	}
	
	@Override
	public Map<String, Object> updateBalanceAndRechargeByCustNoAccountNo(BigDecimal accountBalance,
			String custNo,String accountNo) throws RuntimeException {
		Map<String, Object> params = new HashMap<String, Object>();
		if(accountBalance == null || StringUtils.isEmpty(custNo)
				|| StringUtils.isEmpty(accountNo)){
			params.put(Const.retCode, false);
			return params;
		}
		params.put("balance", accountBalance);
		params.put("custNo", custNo);

		int i = custAccountMapper.updateBalanceAndRechargeByCustNoAccountNo(params);
		params.clear();
		params.put(Const.retCode, false);
		if(i > 0){
			params.put(Const.retCode, true);
		}
		return params;
	}

	@Override
	public P2p_cust_account getCustAccountByIdOrCustNo(String custNo) throws BusinessException {
		if(StringUtils.isEmpty(custNo)){
			return null;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("custNo", custNo);
		P2p_cust_account account = custAccountMapper.getCustAccountByIdOrCustNo(params);
		return account;
	}

	@Override
	public List<Map<String, Object>> querySuspiciousFlow() throws BusinessException {
		return accountFlowMapper.querySuspiciousFlow();
	}

	@Override
	public int updateSuspiciousFlow(String paf_transFlowNo, String status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("paf_transFlowNo", paf_transFlowNo);
		params.put("paf_status", status);
		try{
			return accountFlowMapper.updateSuspiciousFlow( params );
		}catch(Exception e)
		{
			logger.error( "修改订单异常:" + e.getMessage() );
		}
		return 0;
	}

	@Override
	public P2p_account_flow getAccountFlow(String paf_transFlowNo)
			throws BusinessException {
		return accountFlowMapper.getByTransFlowNo(paf_transFlowNo);
	}
}
