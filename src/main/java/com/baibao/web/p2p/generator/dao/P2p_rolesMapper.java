package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_roles;
import com.baibao.web.p2p.generator.bean.P2p_rolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface P2p_rolesMapper {
    int countByExample(P2p_rolesExample example);

    int deleteByExample(P2p_rolesExample example);

    int deleteByPrimaryKey(Long prId);

    int insert(P2p_roles record);

    int insertSelective(P2p_roles record);

    List<P2p_roles> selectByExample(P2p_rolesExample example);

    P2p_roles selectByPrimaryKey(Long prId);

    int updateByExampleSelective(@Param("record") P2p_roles record, @Param("example") P2p_rolesExample example);

    int updateByExample(@Param("record") P2p_roles record, @Param("example") P2p_rolesExample example);

    int updateByPrimaryKeySelective(P2p_roles record);

    int updateByPrimaryKey(P2p_roles record);
}