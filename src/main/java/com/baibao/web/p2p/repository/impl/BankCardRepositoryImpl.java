package com.baibao.web.p2p.repository.impl;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.dao.p2p_bank_cardMapper;
import com.baibao.web.p2p.repository.BankCardRepository;

@Repository
public class BankCardRepositoryImpl implements BankCardRepository{

	private static Logger log = LoggerFactory.getLogger(BankCardRepositoryImpl.class);
	
	@Autowired
	private p2p_bank_cardMapper bank_cardMapper; 
	
	@Override
	public P2p_bank_card getBankCardByBankCardNo(String bankCardNo)
			throws RuntimeException {
		if(StringUtils.isEmpty(bankCardNo)){
			return null;
		}
		return bank_cardMapper.getBankCardByBankCardNo(bankCardNo);
	}

	@Override
	public int saveBankCard(P2p_bank_card bankCard) throws RuntimeException {
		if(bankCard == null){
			return 0;
		}
		return bank_cardMapper.insert(bankCard);
	}

	@Override
	public int updateBankcardByNo(P2p_bank_card bankCard) throws RuntimeException {
		if(bankCard == null){
			return 0;
		}
		return bank_cardMapper.updateBankCardByNo(bankCard);
	}

	@Override
	public P2p_bank_card getBankCardByCustNo(String custNo)
			throws RuntimeException {
		if(StringUtils.isEmpty(custNo)){
			return null;
		}
		return bank_cardMapper.getBankCardByCustNo(custNo);
	}

	@Override
	public int deleteBankCardByCustNo(String custNo) throws RuntimeException {
		if(StringUtils.isEmpty(custNo)){
			return 0;
		}
		int count;
		try{
			count = bank_cardMapper.deleteBankCardByCustNo(custNo);
		}
		catch(Exception e){
			count =0;
			log.error("error", e);
		}
		return count ;
	}

	@Override
	public int updateBankcardBycustNo(P2p_bank_card bankCard) {
		
		return bank_cardMapper.updateBankCardByCustNo(bankCard);		                        
	}

	@Override
	public Integer getBankCardByBankNo(String bankCardNo)
			throws RuntimeException {
		return bank_cardMapper.getBankCardByBankNo(bankCardNo);
	}

}
