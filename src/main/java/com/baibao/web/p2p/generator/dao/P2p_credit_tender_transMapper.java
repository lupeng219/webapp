package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_credit_tender_trans;
import com.baibao.web.p2p.generator.bean.P2p_credit_tender_transExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_credit_tender_transMapper {
    int countByExample(P2p_credit_tender_transExample example);

    int deleteByExample(P2p_credit_tender_transExample example);

    int deleteByPrimaryKey(Long pctId);

    int insert(P2p_credit_tender_trans record);

    int insertSelective(P2p_credit_tender_trans record);

    List<P2p_credit_tender_trans> selectByExample(P2p_credit_tender_transExample example);

    P2p_credit_tender_trans selectByPrimaryKey(Long pctId);

    int updateByExampleSelective(@Param("record") P2p_credit_tender_trans record, @Param("example") P2p_credit_tender_transExample example);

    int updateByExample(@Param("record") P2p_credit_tender_trans record, @Param("example") P2p_credit_tender_transExample example);

    int updateByPrimaryKeySelective(P2p_credit_tender_trans record);

    int updateByPrimaryKey(P2p_credit_tender_trans record);
}