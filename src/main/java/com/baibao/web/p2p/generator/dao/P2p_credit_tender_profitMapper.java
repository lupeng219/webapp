package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_credit_tender_profit;
import com.baibao.web.p2p.generator.bean.P2p_credit_tender_profitExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_credit_tender_profitMapper {
    int countByExample(P2p_credit_tender_profitExample example);

    int deleteByExample(P2p_credit_tender_profitExample example);

    int deleteByPrimaryKey(Long ptpId);

    int insert(P2p_credit_tender_profit record);

    int insertSelective(P2p_credit_tender_profit record);

    List<P2p_credit_tender_profit> selectByExample(P2p_credit_tender_profitExample example);

    P2p_credit_tender_profit selectByPrimaryKey(Long ptpId);

    int updateByExampleSelective(@Param("record") P2p_credit_tender_profit record, @Param("example") P2p_credit_tender_profitExample example);

    int updateByExample(@Param("record") P2p_credit_tender_profit record, @Param("example") P2p_credit_tender_profitExample example);

    int updateByPrimaryKeySelective(P2p_credit_tender_profit record);

    int updateByPrimaryKey(P2p_credit_tender_profit record);
    
    /**
     * 得到某期未收益的的债券收益
     * @param map
     * @return
     */
    public BigDecimal getAllCapitalAndInterest(Map<String, Object> map);
    
    /**
     * 得到所有未收益的计划
     * @param map
     * @return
     */
    public List<P2p_credit_tender_profit>  getAllCreditTenderProfits(Map<String, Object> map);
    
    /**
     * 更新状态
     * @param map
     * @return
     */
    public int updatePtpProfitstatus(Map<String, Object> map);
}