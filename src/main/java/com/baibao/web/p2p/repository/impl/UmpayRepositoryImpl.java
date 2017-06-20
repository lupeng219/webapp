package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DataDIC;
import com.baibao.web.p2p.comm.GetUniqueNoUtil;
import com.baibao.web.p2p.generator.dao.P2p_umpayMapper;
import com.baibao.web.p2p.repository.UmpayRepository;

@Repository
public class UmpayRepositoryImpl implements UmpayRepository{
	
	@Autowired
	private P2p_umpayMapper p2p_umpayMapper;
	
	@Override
	public String selectCustAccount(String custNo)
			throws BusinessException {
		String umpayId = "";
		if(!StringUtil.isEmpty(custNo)){
			umpayId = p2p_umpayMapper.selectCustAccount(custNo);
		}
		return umpayId;
	}

	@Override
	public Map<String, Object> getPropertyPandect(String custNo) throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(custNo)){
			result = p2p_umpayMapper.getPropertyPandect(custNo);
		}
		return result;
	}

	@Override
	public BigDecimal getAccountFreeze(String custNo) throws BusinessException {
		BigDecimal accountFreeze = new BigDecimal(0);
		if(!StringUtil.isEmpty(custNo)){
			accountFreeze = p2p_umpayMapper.getAccountFreeze(custNo);
		}
		return accountFreeze;
	}

	@Override
	public List<Map<String, Object>> getTransactionRecordPage(Map<String, Object> params)
			throws BusinessException {
		List<Map<String, Object>> resultMap = new ArrayList<Map<String, Object>>();
		if(params !=null){
			resultMap = p2p_umpayMapper.getTransactionRecordPage(params);
		}
		return resultMap;
	}
	
	@Override
	public Integer getTransactionRecordPageTotal(Map<String, Object> params)
			throws BusinessException {
		int total = 0;
		if(params !=null){
			total = p2p_umpayMapper.getTransactionRecordPageTotal(params);
		}
		return total;
	}

	@Override
	public Map<String, Object> getBankCard(String custNo) throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		if(!StringUtil.isEmpty(custNo)){
			result = p2p_umpayMapper.getBankCard(custNo);
		}
		return result;
	}

	@Override
	public Map<String, Object> saveWithDrawals(String custNo,BigDecimal money,String umpayUserId)
			throws BusinessException {
		Map<String, Object> pamart  = new HashMap<String, Object>();
		String orderNo = GetUniqueNoUtil.getOrderNo();//提现流水
		pamart.put("orderNo", orderNo);
		pamart.put("custNo", custNo);
		pamart.put("money", money);
		pamart.put("dates", new Date());
		pamart.put("custNO", umpayUserId);
		pamart.put("state", DataDIC.TRANSING.getDataCode());
		int i = p2p_umpayMapper.saveWithDrawals(pamart);
		if(i>0){
			pamart.put(Const.retCode,true);
		}else{
			pamart.put(Const.retCode,false);
		}
		return pamart;
	}

	@Override
	public int updateWithDrawals(Map<String, String> map) throws BusinessException {
		return p2p_umpayMapper.updateWithDrawals(map);
	}
}
