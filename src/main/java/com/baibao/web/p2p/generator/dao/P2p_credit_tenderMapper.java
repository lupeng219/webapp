package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_credit_tender;
import com.baibao.web.p2p.generator.bean.P2p_credit_tenderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_credit_tenderMapper {
    int countByExample(P2p_credit_tenderExample example);

    int deleteByExample(P2p_credit_tenderExample example);

    int deleteByPrimaryKey(Long pctId);

    int insert(P2p_credit_tender record);

    int insertSelective(P2p_credit_tender record);

    List<P2p_credit_tender> selectByExample(P2p_credit_tenderExample example);

    P2p_credit_tender selectByPrimaryKey(Long pctId);

    int updateByExampleSelective(@Param("record") P2p_credit_tender record, @Param("example") P2p_credit_tenderExample example);

    int updateByExample(@Param("record") P2p_credit_tender record, @Param("example") P2p_credit_tenderExample example);

    int updateByPrimaryKeySelective(P2p_credit_tender record);

    int updateByPrimaryKey(P2p_credit_tender record);
}