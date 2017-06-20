package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_transExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_repayment_bill_transMapper {
    int countByExample(P2p_repayment_bill_transExample example);

    int deleteByExample(P2p_repayment_bill_transExample example);

    int deleteByPrimaryKey(String prtRepaybillno);

    int insert(P2p_repayment_bill_trans record);

    int insertSelective(P2p_repayment_bill_trans record);

    List<P2p_repayment_bill_trans> selectByExample(P2p_repayment_bill_transExample example);

    P2p_repayment_bill_trans selectByPrimaryKey(Map<String, Object> map);
    
    int updateByExampleSelective(@Param("record") P2p_repayment_bill_trans record, @Param("example") P2p_repayment_bill_transExample example);

    int updateByExample(@Param("record") P2p_repayment_bill_trans record, @Param("example") P2p_repayment_bill_transExample example);

    int updateByPrimaryKeySelective(P2p_repayment_bill_trans record);

    int updateByPrimaryKey(P2p_repayment_bill_trans record);
    
    /**
     * 更新状态
     * @param map
     * @return
     */
    public int updatePrtRepaystatus(Map<String, Object> map);
    
    /**
	 * 更新代付记录操作
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillTrans(Map<String, Object> map);
	
	/**
	 * 查询还款代收可疑流水
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> querySuspiciousPaymentFlow();
	
	/**
	 * 更新收益状态(跑批使用方法)
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillTransFlowNo(Map<String, Object> map);
	
	/**
	 * 只根据账单号查询代收记录
	 * @param map
	 * @return
	 */
	P2p_repayment_bill_trans selectByRepaybillno(Map<String, Object> map);
    
}