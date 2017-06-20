package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.bean.P2p_loan_applyExample;

public interface P2p_loan_applyMapper {
    int countByExample(P2p_loan_applyExample example);

    int deleteByExample(P2p_loan_applyExample example);

    int deleteByPrimaryKey(Integer ppLoanapplyid);

    int insert(P2p_loan_apply record);

    int insertSelective(P2p_loan_apply record);

    List<P2p_loan_apply> selectByExample(P2p_loan_applyExample example);

    P2p_loan_apply selectByPrimaryKey(Integer ppLoanapplyid);

    int updateByExampleSelective(@Param("record") P2p_loan_apply record, @Param("example") P2p_loan_applyExample example);

    int updateByExample(@Param("record") P2p_loan_apply record, @Param("example") P2p_loan_applyExample example);

    int updateByPrimaryKeySelective(P2p_loan_apply record);

    int updateByPrimaryKey(P2p_loan_apply record);
    
    /**
     * 借款申请记录
     * @param params
     * @return
     * @throws RuntimeException
     */
    public List<P2p_loan_apply> findLoanApplyRecordsByCust(Map<String, Object> params) throws BusinessException;
    
    /**
     * 借款申请记录count
     * @param params
     * @return
     * @throws RuntimeException
     */
    public int findLoanApplyRecordsByCustTotal(Map<String, Object> params) throws BusinessException;
    
    public P2p_loan_apply searchByPorductNo(String productNo);
}