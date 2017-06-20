package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.repository.AccountRepository;
import com.baibao.web.p2p.repository.UserInfoRepository;
import com.baibao.web.p2p.service.PiggyBankService;
import com.baibao.pay.PayService;
import com.baibao.pay.data.BalanceRequest;
import com.baibao.pay.data.BalanceResponse;

/**
 * ClassName: PiggyBankSericeImpl 
 * @Description: 
 * @author zhangpengxiang
 * @date 2016年4月13日
 */
@Service("piggyBankService")
public class PiggyBankSericeImpl
	implements PiggyBankService
{
	@Autowired
	private PayService payService;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private AccountRepository accountRepository; 

	@Override
	public Map<String, Object> getEssentialInformation(String custNo)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		P2p_user_info userInfo = userInfoRepository.getUserInfo(custNo);
		P2p_cust_account cust_account = null;
		
		try
		{
			cust_account = accountRepository.getCustAccountByIdOrCustNo(custNo);
		} catch (BusinessException e)
		{
			e.printStackTrace();
		}
		
		if (userInfo != null &&
			userInfo.getPuiPlataccountiscert().equals(Const.ALREADYCERTIFIED))
		{
			map.put("isRealName", true);
			map.put("puiRealName", userInfo.getPuiRealName());
			map.put("PuiCertNo", userInfo.getPuiCertNo());
			map.put("custNo", custNo);

			BalanceRequest request = new BalanceRequest();

			request.setAccountId(cust_account.getPcaAccountno());
			
			BalanceResponse response = payService.queryBalance(request);
			if (response.isOk())
			{
				map.put("availableBalance",
					String.valueOf(
						new BigDecimal(response.getAvalidated())
							.divide(new BigDecimal(100))));
			}
			
			/*Map<String, String> params = new HashMap<String, String>();
			
			params.put("identity_id", custNo);
	    	params.put("identity_type", Const.UID);
	    	params.put("account_type", Const.SAVING_POT);
			
	    	//Map<String, Object> result = queryBalanceHandler.handle(params);
	    	Map<String, Object> result = payService.query_balance(params);
			
	    	if(result!=null&&result.get("response_code").toString().equals(Const.ApplySuccess)){
				map.put("availableBalance", result.get("available_balance").toString());//可用余额
				String[] bonus = result.get("bonus").toString().split("\\^");
				if(bonus!=null){
					map.put("earningsYesterday", bonus[0]);//昨日收益
					map.put("januaryEarnings", bonus[1]);//最近一月收益
					map.put("totalRevenue", bonus[2]);//总收益
				}
			}*/
		} else
		{
			map.put("isRealName", false);
			map.put("realName", userInfo.getPuiRealName());
			map.put("idCard", userInfo.getPuiCertNo());
		}

		return map;
	}
	
	@Override
	public Map<String, Object> getYieldrate()
		throws Exception
	{
		HashMap<String, String> parameters = new HashMap<String,String>();
		parameters.put("fund_code", "000330");
		
		//Map<String, Object> queryFundYieldMap = queryFundYieldHandler.handle(parameters);
		//Map<String, Object> queryFundYieldMap =
		//	payService.query_fundyield(parameters);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		/*if (queryFundYieldMap != null &&
			queryFundYieldMap.get("response_code").toString().equals(Const.ApplySuccess))
		{
			List date = new ArrayList();
			List yieldRate = new ArrayList();
			String yield_list = queryFundYieldMap.get("yield_list").toString();
			String[] yieldList = yield_list.split("\\|");
			SimpleDateFormat sdft = new SimpleDateFormat("yyyyMMdd") ; 
			SimpleDateFormat asdm = new SimpleDateFormat("yyyy-MM-dd") ;
			for (int i = 6; i >=0; i--) {
				String yieldLists = yieldList[i];
				String[] yield = yieldLists.split("\\^");
				date.add(asdm.format(sdft.parse(yield[0])));
				yieldRate.add(yield[1]);
			}
			returnMap.put("date", date);
			returnMap.put("yieldRate", yieldRate);
		}*/

		return returnMap;
	}

	@Override
	public Map<String, Object> showMemberInfosSina(String custNo) {
		/*Map<String, String> params = new HashMap<String, String>();
		params.put("identity_id", custNo);
		params.put("identity_type", "UID");
		params.put("resp_method", "1");//1 url返回
		
		return showMemberInfosSinaHandler.handle(params);*/
		return new HashMap<String, Object>();
	}

}
