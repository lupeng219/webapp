package com.baibao.web.p2p.repository;

import com.baibao.web.p2p.generator.bean.P2p_bank_card;

public interface BankCardRepository {

	public P2p_bank_card getBankCardByBankCardNo(String bankCardNo) throws RuntimeException;
	
	public int saveBankCard(P2p_bank_card bankCard) throws RuntimeException;
	
	public int updateBankcardByNo(P2p_bank_card bankCard) throws RuntimeException;
	
	public P2p_bank_card getBankCardByCustNo(String custNo) throws RuntimeException;
	
	public int deleteBankCardByCustNo(String custNo) throws RuntimeException;
	
	public int updateBankcardBycustNo(P2p_bank_card bankCard);
	/**
	 * 根据银行卡号查询是否已经绑定
	 * @param bankCardNo
	 * @return
	 * @throws RuntimeException
	 */
	public Integer getBankCardByBankNo (String bankCardNo) throws RuntimeException;
}
