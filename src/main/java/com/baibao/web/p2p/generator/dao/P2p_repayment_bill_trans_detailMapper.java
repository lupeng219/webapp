package com.baibao.web.p2p.generator.dao;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans_detail;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans_detailExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_repayment_bill_trans_detailMapper {
	int countByExample(P2p_repayment_bill_trans_detailExample example);

    int deleteByExample(P2p_repayment_bill_trans_detailExample example);

    int insert(P2p_repayment_bill_trans_detail record);

    int insertSelective(P2p_repayment_bill_trans_detail record);

    List<P2p_repayment_bill_trans_detail> selectByExample(P2p_repayment_bill_trans_detailExample example);

    int updateByExampleSelective(@Param("record") P2p_repayment_bill_trans_detail record, @Param("example") P2p_repayment_bill_trans_detailExample example);

    int updateByExample(@Param("record") P2p_repayment_bill_trans_detail record, @Param("example") P2p_repayment_bill_trans_detailExample example);

    int updateByPrimaryKeySelective(P2p_repayment_bill_trans_detail record);

    int updateByPrimaryKey(P2p_repayment_bill_trans_detail record);
    
    /**
     * 更新还款状态
     * @param map
     * @return
     */
    public int updatePrdStatus(Map<String, Object> map);
    
    /**
     * 保存记录
     * @param map
     * @return
     */
    public int saveRepaymentBillTransDetail(Map<String, Object> map);
    
    /**
     * 更新代付记录
     * @param map
     * @return
     */
	public int upadteRepaymentBillTransDetails(Map<String, Object> map);

	
	/**
	 * 根据交易流水号查询
	 * @param tradeFlowNo
	 * @return
	 */
	 P2p_repayment_bill_trans_detail selectByTradeFlowNo(String tradeFlowNo);

	
	/**
	 * 还款代付查询“处理中”状态
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> querySuspiciousPaymentFlow() throws BusinessException;
	
	/**
	 * 根据还款账单查询已还金额
	 * @param repaybillNo
	 * @return
	 */
	public String serachRepaymentMoneyBybillNo(@Param("repaybillNo")String repaybillNo);

}