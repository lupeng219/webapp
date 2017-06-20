package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_refund;
import com.baibao.web.p2p.generator.bean.P2p_refundExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_refundMapper {
    int countByExample(P2p_refundExample example);

    int deleteByExample(P2p_refundExample example);

    int deleteByPrimaryKey(Long prId);

    int insert(P2p_refund record);

    int insertSelective(P2p_refund record);

    List<P2p_refund> selectByExample(P2p_refundExample example);

    P2p_refund selectByPrimaryKey(Long prId);

    int updateByExampleSelective(@Param("record") P2p_refund record, @Param("example") P2p_refundExample example);

    int updateByExample(@Param("record") P2p_refund record, @Param("example") P2p_refundExample example);

    int updateByPrimaryKeySelective(P2p_refund record);

    int updateByPrimaryKey(P2p_refund record);
}