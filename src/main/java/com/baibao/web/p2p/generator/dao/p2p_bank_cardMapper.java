package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_bank_card;


public interface p2p_bank_cardMapper {
    int deleteByPrimaryKey(Long pbcId);

    int insert(P2p_bank_card record);

    int insertSelective(P2p_bank_card record);

    P2p_bank_card selectByPrimaryKey(Long pbcId);

    int updateByPrimaryKeySelective(P2p_bank_card record);

    int updateByPrimaryKey(P2p_bank_card record);
    
    /**
     * 根据客户号查询银行卡信息
     * @param custNo
     * @return
     * @throws Exception
     */
    P2p_bank_card getBankCardByCustNo(String custNo);
    /**
     * 根据银行卡查询银行卡是否存在
     * @param bankNo
     * @return
     */
    Integer getBankCardByBankNo(String bankCardNo);
    
    /**
     * 更改是否为安全卡标识
     * @param record
     * @return
     * @throws Exception
     */
    int updateIsSafeCardById(P2p_bank_card record) throws RuntimeException;
    
    /**
     * 根据银行卡号查询银行卡信息
     * @param custNo
     * @return
     * @throws Exception
     */
    P2p_bank_card getBankCardByBankCardNo(String bankCardNo); 
    
    int updateBankCardByNo(P2p_bank_card record);
    
    int deleteBankCardByCustNo(String custNo);
    
    int updateBankCardByCustNo(P2p_bank_card record);
}
