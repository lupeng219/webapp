package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_credite_loan;
import com.baibao.web.p2p.generator.bean.P2p_credite_loanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_credite_loanMapper {
    int countByExample(P2p_credite_loanExample example);

    int deleteByExample(P2p_credite_loanExample example);

    int deleteByPrimaryKey(Long pclId);

    int insert(P2p_credite_loan record);

    int insertSelective(P2p_credite_loan record);

    List<P2p_credite_loan> selectByExample(P2p_credite_loanExample example);

    P2p_credite_loan selectByPrimaryKey(Long pclId);

    int updateByExampleSelective(@Param("record") P2p_credite_loan record, @Param("example") P2p_credite_loanExample example);

    int updateByExample(@Param("record") P2p_credite_loan record, @Param("example") P2p_credite_loanExample example);

    int updateByPrimaryKeySelective(P2p_credite_loan record);

    int updateByPrimaryKey(P2p_credite_loan record);
}