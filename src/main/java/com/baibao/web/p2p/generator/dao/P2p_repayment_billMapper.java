package com.baibao.web.p2p.generator.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;
import com.baibao.web.p2p.generator.bean.P2p_repayment_billExample;

public interface P2p_repayment_billMapper {
    int countByExample(P2p_repayment_billExample example);

    int deleteByExample(P2p_repayment_billExample example);

    int deleteByPrimaryKey(Long prbRepaymentid);

    int insert(P2p_repayment_bill record);

    int insertSelective(P2p_repayment_bill record);

    List<P2p_repayment_bill> selectByExample(P2p_repayment_billExample example);

    P2p_repayment_bill selectByPrimaryKey(Long prbRepaymentid);

    int updateByExampleSelective(@Param("record") P2p_repayment_bill record, @Param("example") P2p_repayment_billExample example);

    int updateByExample(@Param("record") P2p_repayment_bill record, @Param("example") P2p_repayment_billExample example);

    int updateByPrimaryKeySelective(P2p_repayment_bill record);

    int updateByPrimaryKey(P2p_repayment_bill record);
    
    /*以上部分是自动生成代码，如需使用把xml注释打开即可/
	
	/**
	 * 根据借款编号查询还款记录
	 * @return
	 */
	public List<P2p_repayment_bill>  getByBulkLoanNumber(String productNo); 
	
	/**
	 * 查询借款人负债情况
	 * @param custNo
	 * @return
	 */
	public Map<String, BigDecimal> getCustLiabilitiesByCustNo(String custNo);
	
	/**
	 * 根据借款编号进行查询
	 * @param prbRepaybillno
	 * @return
	 */
	public P2p_repayment_bill getByprbRepaybillno(String prbRepaybillno);
	
	/**
	 * 更新状态
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillStatus(Map<String, Object> map);
	/**
	 * 更新状态根据借款编号
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillStatusByProductNo(Map<String, Object> map);
	
	/**
	 * 还款信息展示
	 * @param productNo
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> getproductRepayment(Map<String, Object> map) throws BusinessException;

 	/**
	 * 得到还款详情
	 * @param prbRepaybillno
	 * @return
	 */
	public P2p_repayment_bill getRepaymentDetails(String prbRepaybillno);
	
	/**
	 * 更新还款账单状态
	 * @param map
	 * @return
	 */
	public int upadteStatusBybillNoAndProductNo(Map<String, Object> map);
	
	/**
	 * 更新账单状态和还款时间
	 * @param map
	 * @return
	 */
	public int  upadteStatusAndDate(Map<String, Object> map);
	/**
	 * 根据流水号 查询账单
	 * @param prd_tradeFlowNo
	 * @return
	 */
	public P2p_repayment_bill  getByTradeFlowNo(String prd_tradeFlowNo);
	
	/**
	 * 查询处理中的账单
	 */
	public List<Map<String, Object>> querySuspiciousPaymentFlow();
	
	/**
	 * 还款账单 old
	 * @param productNo
	 * @return
	 */
	public List<P2p_repayment_bill> getOldByBulkLoanNumber(String productNo);
	
	/**
	 * 查询平台逾期总数
	 */
	
	public int queryOverDueTotal();
	
	/**
	 * 查询应还账单表总期数
	 * @param productNo
	 * @return
	 */
	public int quertRepaymentSeqCount(String productNo);
	
	
	public int countRepaymentBill(Map<String, Object> map);
	
	
}