package com.baibao.web.p2p.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_bill_plan;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;

public interface TenderProfitService {

	/**
     * 根据客户号和收益状态统计总收益
     * @param map
     * @return
     */
    public Map<String, BigDecimal> getCustAllProfitByCustNoAndStatus(Map<String, Object> map);
	
    /**
     * 查询用户当日待收收益
     * @param map
     * @return
     */
    public Map<String, Object> getCustWaitdayInterest(Map<String, Object> map);
    
    /**
     * 根据投资流水查询收益记录
     * @param map
     * @return
     */
    public List<P2p_tender_profit> findTenderProfitListByTenderFlowNo(Map<String, Object> map);
    
    /**
	 * 每月收益总额
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public  List getIncomeAmount(String custNo,List month) throws BusinessException;

	
	/**
	 * 累计收益总额
	 * @return
	 */
	public BigDecimal  getFrofitTotal();


	/**
	 * 总收益
	 * @return
	 */
	public BigDecimal tenderProfit(String profitType);
 /**
  * 根据投资单号查询待收本息
  * @param tenderFlowNo
  * @return
  * @throws BusinessException
  */
    public BigDecimal tenderProfitByTenderFlowNo(String tenderFlowNo) throws BusinessException;
    /**
     * 根据投资单号查询待收利息
     * @param tenderFlowNo
     * @return
     * @throws BusinessException
     */
    public BigDecimal tenderInterestByTenderFlowNo(String tenderFlowNo,String status) throws BusinessException;
    
    /**
     * 根据投资单号查询已收利息
     * @param tenderFlowNo
     * @return
     * @throws BusinessException
     */
    public BigDecimal tenderInterestedByTenderFlowNo(String tenderFlowNo) throws BusinessException;
    
    /**
     * 根据投资单号查询已收本息
     * @param tenderFlowNo
     * @return
     * @throws BusinessException
     */
    public BigDecimal tenderFactProfitByTenderFlowNo(String tenderFlowNo) throws BusinessException;
    
	/**
	 * 回款计划
	 * @param tenderFlowNo
	 * @return
	 */
	public List<Map<String, Object>>paymentPlanByTenderFlowNo(String tenderFlowNo);
	
	/**
	 * 根据客户号查询用户正在投资金额
	 */
	public  BigDecimal getPtrAmount(String custNo) throws BusinessException;
	
	/**
	 * 通过借款编号查出收益记录
	 * @param productNo
	 * @return
	 */
	public List<P2p_tender_profit> getTenderProfitByProductNo(Map<String, Object> map);
	
	/**
	 * 通过借款编号查出收益记录
	 * @param productNo
	 * @return
	 */
	public List<P2p_tender_profit> getTenderProfitByProduct(Map<String, Object> map);
	
	/**
	 * 通过借款编号查出剩余期数
	 * @param productNo
	 * @return
	 */
	public int getBillPlanCountByProductNo(String productNo);
	
	/**
	 * 获得还款计划
	 * @param map
	 * @return
	 */
	public List<P2p_bill_plan> findBillPlanByProduct(Map<String, Object> map);
	/**
	 * 通过编号查询最后一期收益时间
	 * @param productNo
	 * @return
	 */
	public Date findLastPtpProfittime(String productNo);
}
