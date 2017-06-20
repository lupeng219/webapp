package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_bank_type;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.repository.UmpayRepository;
import com.baibao.web.p2p.service.UmpayService;
import com.baibao.web.p2p.umpay.base.UMPayQueryBase;
import com.baibao.web.p2p.umpay.base.UMPayTransBase;
import com.umpay.api.exception.ReqDataException;


@Service(value = "umpayService")
public class UmpayServiceImpl implements UmpayService {
	private static Logger logger = LoggerFactory.getLogger(UmpayServiceImpl.class);

	@Autowired
	private UMPayQueryBase uMPayQueryBase;
	@Autowired
	private UmpayRepository  umpayRepository;
	@Autowired
	private UMPayTransBase uMPayTransBase;
	@Autowired
	private P2p_bank_typeMapper bankTypeDao;

	@Override
	public Map<String, Object> selectCustAccount(String custNo)
			throws BusinessException {
		String umpayId =  umpayRepository.selectCustAccount(custNo);
		Map<String, Object> result = new HashMap<String, Object>();
		BigDecimal balance = new BigDecimal(0);
		try {
			//查询用户余额
			if(!StringUtil.isEmpty(umpayId)){
				Map<String,String> retMap = uMPayQueryBase.userSearch(umpayId, "01", "0");
				if( retMap != null && retMap.get("ret_code").equals("0000") )
				{
					balance = new BigDecimal(retMap.get("balance"));
					if(balance.compareTo(new BigDecimal(0)) > 0){
						balance = new BigDecimal(retMap.get("balance")).divide(BigDecimal.valueOf(100));
					}
				}
			}
		} catch (ReqDataException e) {
			logger.error("selectCustAccount",e);
		}
		//资产总计
		BigDecimal allCount = new BigDecimal(0);
		//预期收益本息
		BigDecimal principal = new BigDecimal(0); 
		//预期收益本金
		BigDecimal b_SumEarnPrincipal = new BigDecimal(0);
		//预期收益利息
		BigDecimal b_SumEarnInterest = new BigDecimal(0);
		//查询代收本息
		Map<String, Object> map = umpayRepository.getPropertyPandect(custNo);
		b_SumEarnPrincipal = (BigDecimal) (map == null?b_SumEarnPrincipal:map.get("expectEarnPrincipal"));
		b_SumEarnInterest = (BigDecimal) (map == null?b_SumEarnPrincipal:map.get("expectEarnInterest"));
		principal = b_SumEarnPrincipal.add(b_SumEarnInterest);
		//查询冻结金额
		BigDecimal bidAmount = umpayRepository.getAccountFreeze(custNo);
		bidAmount = bidAmount == null?new BigDecimal(0):bidAmount;
		DecimalFormat    df   = new DecimalFormat("#0.00");
		allCount = bidAmount.add(principal).add(balance);
		String allCounts=df.format(allCount);
		BigDecimal allmoney=new BigDecimal(allCounts);
		result.put("realAmount", balance);
		result.put("allCount", allmoney);
		result.put("principal", principal);
		result.put("bidAmount", bidAmount);
		return result;
	}

	@Override
	public Paging<Map<String, Object>> getTransactionRecordPage(
			String custNo,Integer transType,Integer status,String startTime,String endTime,int currentPageNo, int pageSize) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		Paging<Map<String, Object>> paging = new Paging<Map<String, Object>>(currentPageNo, pageSize);
		params.put("custNo", custNo);//客户号
		params.put("type", transType);//类型
		params.put("startTime",startTime);//开始时间
		params.put("endTime",endTime);//结束时间
		params.put("status",status);//状态
		params.put("beginWith",paging.getBeginWith());// 开始条数
		params.put("count", paging.getPageSize());//每页显示个数
		paging.setPageList(umpayRepository.getTransactionRecordPage(params));
		paging.setCountTotal(umpayRepository.getTransactionRecordPageTotal(params));
		return paging;
	}

	@Override
	public Map<String, Object> getPresentPage(String custNo)
			throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		String umpayId =  umpayRepository.selectCustAccount(custNo);
		BigDecimal balance = new BigDecimal(0);
		try {
			//查询用户余额
			if(!StringUtil.isEmpty(umpayId)){
				Map<String,String> retMap = uMPayQueryBase.userSearch(umpayId, "01", "0");
				if( retMap != null && retMap.get("ret_code").equals("0000") )
				{
					balance = new BigDecimal(retMap.get("balance"));
					if(balance.compareTo(new BigDecimal(0)) > 0){
						balance = new BigDecimal(retMap.get("balance")).divide(BigDecimal.valueOf(100));
					}
				}
			}
		} catch (ReqDataException e) {
			logger.error("getPresentPage",e);
		}
		//查询用户银行卡
		P2p_bank_type bankType = null;
		String bankNum = null;
		Map<String, Object> bankCardResult = umpayRepository.getBankCard(custNo);
		if(bankCardResult!=null){
			bankType = bankTypeDao.getBankType(bankCardResult.get("bankNo").toString());
		    bankNum= bankCardResult.get("bankCardNum").toString();
		}
		result.put("realAmount", balance);
		result.put("bankType", bankType);
		result.put("bankNum",bankNum );
		return result;
	}

	@Override
	public Map<String, Object> withdrawCash(String custNo,
			String withdrawalsMoney) throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		BigDecimal money = new BigDecimal(withdrawalsMoney);
		String umpayId =  umpayRepository.selectCustAccount(custNo);
		BigDecimal balance = new BigDecimal(0);
		try {
			//查询用户余额
			if(!StringUtil.isEmpty(umpayId)){
				Map<String,String> retMap = uMPayQueryBase.userSearch(umpayId, "01", "0");
				if( retMap != null && retMap.get("ret_code").equals("0000") )
				{
					balance = new BigDecimal(retMap.get("balance"));
					if(balance.compareTo(new BigDecimal(0)) > 0){
						balance = new BigDecimal(retMap.get("balance")).divide(BigDecimal.valueOf(100));
					}
				}
			}
		} catch (ReqDataException e) {
			logger.error("withdrawCash",e);
		}
		if(money.compareTo(balance) >0){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u53ef\u7528\u4f59\u989d\u4e0d\u8db3");//可用余额不足
			return result;
		}
		/*if(money.compareTo(new BigDecimal(50)) <0 || money.compareTo(new BigDecimal(1000000)) >0){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u63d0\u73b0\u91d1\u989d");//请输入正确的提现金额
			return result;
		}*/
		Map<String, Object> WithDrawalsMap = umpayRepository.saveWithDrawals(custNo, money, umpayId);
		if((Boolean)WithDrawalsMap.get(Const.retCode)){
			try {
				String url = uMPayTransBase.custWithDrawals(WithDrawalsMap.get("orderNo").toString(), "1", "", umpayId, "", money.multiply(new BigDecimal(100)).intValue() + "");
				if(!("".equals(url)) || url != null){
					result.put(Const.retCode, true);
					result.put("url", url);
				}
			} catch (ReqDataException e) {
				logger.error("withdrawCash",e);
			}
		}
		return result;
	}
	@Override
	public Map<String, Object> withdrawCashApp(String custNo,
			String withdrawalsMoney) throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		BigDecimal money = new BigDecimal(withdrawalsMoney);
		String umpayId =  umpayRepository.selectCustAccount(custNo);
		BigDecimal balance = new BigDecimal(0);
		try {
			//查询用户余额
			if(!StringUtil.isEmpty(umpayId)){
				Map<String,String> retMap = uMPayQueryBase.userSearch(umpayId, "01", "0");
				if( retMap != null && retMap.get("ret_code").equals("0000") )
				{
					balance = new BigDecimal(retMap.get("balance"));
					if(balance.compareTo(new BigDecimal(0)) > 0){
						balance = new BigDecimal(retMap.get("balance")).divide(BigDecimal.valueOf(100));
					}
				}
			}
		} catch (ReqDataException e) {
			logger.error("withdrawCashApp",e);
		}
		if(money.compareTo(balance) >0){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u53ef\u7528\u4f59\u989d\u4e0d\u8db3");//可用余额不足
			return result;
		}
		/*if(money.compareTo(new BigDecimal(50)) <0 || money.compareTo(new BigDecimal(1000000)) >0){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u63d0\u73b0\u91d1\u989d");//请输入正确的提现金额
			return result;
		}*/
		Map<String, Object> WithDrawalsMap = umpayRepository.saveWithDrawals(custNo, money, umpayId);
		if((Boolean)WithDrawalsMap.get(Const.retCode)){
			try {
				String url = uMPayTransBase.custWithDrawalsApp(WithDrawalsMap.get("orderNo").toString(), "1", "", umpayId, "", money.multiply(new BigDecimal(100)).intValue() + "");
				if(!("".equals(url)) || url != null){
					result.put(Const.retCode, true);
					result.put("url", url);
				}
			} catch (ReqDataException e) {
				logger.error("withdrawCashApp",e);
			}
		}
		return result;
	}
	@Override
	public int updateWithdrawCash(Map<String, String> map) throws BusinessException {
		int count = 0;
		if(map!=null){
			
			count = umpayRepository.updateWithDrawals(map);
		}
		return count;
	}
}
