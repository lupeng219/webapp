package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_loan_product;
import com.baibao.web.p2p.generator.bean.P2p_loan_productExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_loan_productMapper {
    int countByExample(P2p_loan_productExample example);

    int deleteByExample(P2p_loan_productExample example);

    int deleteByPrimaryKey(Long ppProductid);

    int insert(P2p_loan_product record);

    int insertSelective(P2p_loan_product record);

    List<P2p_loan_product> selectByExample(P2p_loan_productExample example);

    P2p_loan_product selectByPrimaryKey(Long ppProductid);

    int updateByExampleSelective(@Param("record") P2p_loan_product record, @Param("example") P2p_loan_productExample example);

    int updateByExample(@Param("record") P2p_loan_product record, @Param("example") P2p_loan_productExample example);

    int updateByPrimaryKeySelective(P2p_loan_product record);

    int updateByPrimaryKey(P2p_loan_product record);
    
    List<P2p_loan_product> selectProductByPage(Map<String, Object> map);
    
    /**
     * 根据状态获得产品
     * @param map
     * @return
     */
	public List<P2p_loan_product> getByBulkloanstatus(Map<String, Object> map);
	/**
	 * 根据产品编号获得产品
	 * @param productNo
	 * @return
	 */
	public P2p_loan_product selectByProductNo(String productNo);
	
	/**
	 * 更新标的状态
	 * @param map
	 * @return
	 */
	public int updateLoanProductStatus(Map<String, Object> map);
	
	public int updateLoanProductStatusTwo(Map<String, Object> map);
	
	public int updateProductState(Map<String, Object> map);
}