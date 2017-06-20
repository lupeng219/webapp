package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_loan_bulk_check;
import com.baibao.web.p2p.generator.bean.P2p_loan_bulk_checkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_loan_bulk_checkMapper {
    int countByExample(P2p_loan_bulk_checkExample example);

    int deleteByExample(P2p_loan_bulk_checkExample example);

    int deleteByPrimaryKey(Long plbcCheckid);

    int insert(P2p_loan_bulk_check record);

    int insertSelective(P2p_loan_bulk_check record);

    List<P2p_loan_bulk_check> selectByExample(P2p_loan_bulk_checkExample example);

    P2p_loan_bulk_check selectByPrimaryKey(Long plbcCheckid);

    int updateByExampleSelective(@Param("record") P2p_loan_bulk_check record, @Param("example") P2p_loan_bulk_checkExample example);

    int updateByExample(@Param("record") P2p_loan_bulk_check record, @Param("example") P2p_loan_bulk_checkExample example);

    int updateByPrimaryKeySelective(P2p_loan_bulk_check record);

    int updateByPrimaryKey(P2p_loan_bulk_check record);
}