package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.dao.P2p_cust_accountMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_billMapper;
import com.baibao.web.p2p.repository.CustAccountRepository;
import com.baibao.pay.PayService;
import com.baibao.pay.data.BalanceRequest;
import com.baibao.pay.data.BalanceResponse;
import com.baibao.pay.data.PayResponse;
import com.baibao.utils.MapBuilder;

@Repository
public class CustAccountRepositoryImpl
	implements CustAccountRepository
{	
	private static Logger logger = LoggerFactory.getLogger(CustAccountRepositoryImpl.class);
	@Autowired
	private P2p_cust_accountMapper custAccountMapper;
	
	@Autowired
	private P2p_repayment_billMapper reapymentBillDao;
	
	@Autowired
	private PayService payService;
	
	@Override
	public P2p_cust_account queryIdentityId(String custNo) {
		if(StringUtils.isEmpty(custNo)){
			return null;
		}
		return custAccountMapper.queryIdentityId(custNo);
	}


	@Override
	public int updateTransPassword(Map<String, Object> map) throws Exception {
		if(map == null||map.size() == 0){
			return 0;
		}
		return custAccountMapper.updatePayPassword(map);
	}


	@Override
	public P2p_cust_account getCustAccountByIdOrCustNo(
			Map<String, Object> params) throws BusinessException {
		if(params == null || params.size()==0){
			return null;
		}
		return custAccountMapper.getCustAccountByIdOrCustNo(params);
	}


	@Override
	public int updateBalanceAndRechargeByCustNoAccountNo(
			Map<String, Object> params) throws RuntimeException {
		if(params == null || params.size()==0){
			return 0;
		}
		return custAccountMapper.updateBalanceAndRechargeByCustNoAccountNo(params);
	}


	@Override
	public int updateBalanceAndMentionNowByCustNoAccountNo(
			Map<String, Object> params) throws RuntimeException {
		if(params == null || params.size()==0){
			return 0;
		}
		return custAccountMapper.updateBalanceAndMentionNowByCustNoAccountNo(params);
	}


	@Override
	public int updateAccountBalance(String accountNo, String custNo)
	{
		Map<String, Object> sinaRetMap = new HashMap<String, Object>();

		int flag = 0;
		try
		{
			BalanceRequest request = new BalanceRequest();
			
			request.setAccountId(accountNo);
			
			BalanceResponse response = payService.queryBalance(request);
			if (response.getStatus() == PayResponse.OK)
			{
				BigDecimal balance_Amount =
					new BigDecimal(response.getAvalidated())
						.divide(new BigDecimal(100));
				
				flag = custAccountMapper.updatePcaAccountBalance(
					new MapBuilder<String, Object>()
						.append("pca_account_balance", balance_Amount)
						.append("pca_cust_no", custNo).toMap());
			}
			
			/*Map<String, String> queryBalanceParam = new HashMap<String, String>();
			queryBalanceParam.put("identity_id", accountNo);
			queryBalanceParam.put("identity_type", "UID");
			queryBalanceParam.put("account_type", "SAVING_POT");
			queryBalanceParam.put("extend_param", "");
			
			//sinaRetMap = queryBalanceHandler.handle(queryBalanceParam);
			sinaRetMap = payService.query_balance(queryBalanceParam);
			
			if( null != sinaRetMap )
			{
				BigDecimal balance_Amount =  new BigDecimal(sinaRetMap.get("available_balance").toString());//用户可用余额
				sinaRetMap.clear();
				sinaRetMap.put("pca_account_balance", balance_Amount);
				sinaRetMap.put("pca_cust_no", custNo);
				flag = custAccountMapper.updatePcaAccountBalance(sinaRetMap);
			}*/
		}catch( Exception e )
		{
			e.printStackTrace();
			logger.error("\u67e5\u8be2\u4f59\u989d\u5931\u8d25");//查询余额失败
		}

		return flag;
	}

	@Override
	public int updateByPrimaryKeySelective(P2p_cust_account record)
	{
		return custAccountMapper.updateByPrimaryKeySelective(record);
	}
}
