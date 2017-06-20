package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_user_role;
import com.baibao.web.p2p.generator.bean.P2p_user_roleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_user_roleMapper {
    int countByExample(P2p_user_roleExample example);

    int deleteByExample(P2p_user_roleExample example);

    int deleteByPrimaryKey(Long purId);

    int insert(P2p_user_role record);

    int insertSelective(P2p_user_role record);

    List<P2p_user_role> selectByExample(P2p_user_roleExample example);

    P2p_user_role selectByPrimaryKey(Long purId);

    int updateByExampleSelective(@Param("record") P2p_user_role record, @Param("example") P2p_user_roleExample example);

    int updateByExample(@Param("record") P2p_user_role record, @Param("example") P2p_user_roleExample example);

    int updateByPrimaryKeySelective(P2p_user_role record);

    int updateByPrimaryKey(P2p_user_role record);
}