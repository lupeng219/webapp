package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.pay.data.BankCard;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;

public interface BankCardService {
	
	/**
	 * 绑定银行卡
	 * @param result
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> bankCardBinding(Map<String, Object> result)
		throws BusinessException;
	
	public Map<String, Object>
		bankCardBindingAdvance(Map<String, String> params)
		throws BusinessException;

	public P2p_bank_card getBankCardByCustNo(String custNo)
		throws Exception;
	
	public P2p_bank_card getBankCardByBankCardNo(String bankCardNo);

	public Map<String, Object>
		unbindingbankCard(Map<String, String> params, String custNo);
	
	public Map<String, Object> unbindingbankCardNew(
		Map<String, String> params, String custNo, String cardNo);
	
	public Map<String, Object> unbindingbankCardAdvance(
		Map<String, String> params,String custNo,String cardNo);
	
	
	/**
	 * 查询三方平台，银行卡信息
	 * @param accountno  三方平台账户
	 * @param custNo  本地账户
	 * @return
	 */
	public boolean refreshCard(String accountno, String custNo);
	
	
}
