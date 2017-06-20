package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.generator.bean.P2p_public_orderExample;

public interface P2p_public_orderMapper {
    int countByExample(P2p_public_orderExample example);

    int deleteByExample(P2p_public_orderExample example);

    int deleteByPrimaryKey(String ppoOrderflowno);

    int insert(P2p_public_order record);

    int insertSelective(P2p_public_order record);

    List<P2p_public_order> selectByExample(P2p_public_orderExample example);

    P2p_public_order selectByPrimaryKey(String ppoOrderflowno);

    int updateByExampleSelective(
    	@Param("record") P2p_public_order record,
    	@Param("example") P2p_public_orderExample example);

    int updateByExample(
    	@Param("record") P2p_public_order record,
    	@Param("example") P2p_public_orderExample example);

    int updateByPrimaryKeySelective(P2p_public_order record);

    int updateByPrimaryKey(P2p_public_order record);
    
    public int updateByOrderFlowNo(
    	@Param("orderFlowNo") String orderFlowNo,
    	@Param("ppoStatus") String ppoStatus);
    
	/**
	 * 插入订单表
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	Integer insert2(Map<String, Object>map) throws BusinessException;
	/**
	 * 修改订单表状态
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	Integer updateByOrderFlowNo2(Map<String, Object>map)throws BusinessException;
}