package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;

public interface TendertProfitRepository {
	
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
	public  List<Map<String, Object>> getIncomeAmount(String custNo) throws BusinessException;
	/**
	 * 待收本息
	 * @return
	 */
	public BigDecimal tenderProfitByTenderFlowNo(String tenderFlowNo) throws BusinessException;
	/**
	 * 待收利息
	 * @param tenderFlowNo
	 * @return
	 * @throws BusinessException
	 */
	public BigDecimal tenderInterestByTenderFlowNo(Map<String,Object>map) throws BusinessException;
	
	/**
     * 已收利息
     * @param tenderFlowNo
     * @return
     * @throws BusinessException
     */
    public BigDecimal tenderInterestedByTenderFlowNo(Map<String,Object>map) throws BusinessException;
    
	/**
	 * 已收本息
	 * @param tenderFlowNo
	 * @return
	 * @throws BusinessException
	 */
	public BigDecimal tenderFactProfitByTenderFlowNo(String tenderFlowNo) throws BusinessException;
    /**
     * 根据收益流水号进行查询
     * @param outer_trade_no
     * @return
     */
	public P2p_tender_profit getByTradeFlowNo(String tradeFlowNo);
	
	/**
	 * 更新收益记录状态
	 * @param profit
	 * @param ptpProfittype
	 * @param object
	 * @return
	 */
	public int updateProfitRecord(P2p_tender_profit profit, String status);
	/**
	 * 更新状态根据产品编号
	 * @param map
	 * @return
	 */
	public int updateStatusByProductNo(Map<String, Object>map);
	
	/**
	 * 累计收益总额
	 * @return
	 */
	public BigDecimal getFrofitTotal();

	/**
	 * 总收益
	 * @return
	 */
	public BigDecimal tenderProfit(String profitType);
	/**
	 * 
	 * @param profitType
	 * @return
	 */
	public BigDecimal profitSum(Map<String, Object> map);
	
	/**
	 * 回款计划
	 * @param tenderFlowNo
	 * @return
	 */
	public List<Map<String, Object>>paymentPlanByTenderFlowNo(String tenderFlowNo);
	
	/**
	 * 根据产品和期数查询未收益人数
	 * @param productNo
	 * @param loanSeq
	 * @return
	 */
	public int getNotprofitCount(String productNo,String loanSeq );
	
	/**
	 * 查询客户号和支付账号
	 * @param outer_trade_no
	 * @return
	 */
	public Map<String, Object> getB2cByTradeFlowNo(String outer_trade_no);
	
	public Map<String, Object> getTradeFlowNo(String outer_trade_no);
	
	/**
	 * 查看借款单号的投资收益
	 * @param productNo
	 * @return
	 */
	public List<P2p_tender_profit> getTenderProfitByProductNo(Map<String, Object> map);

	/**
	 * 查看借款单号的投资收益
	 * @param productNo
	 * @return
	 */
	public List<P2p_tender_profit> getTenderProfitByProduct(Map<String, Object> map);
	/**
	 * 通过编号查询最后一条投资记录
	 * @param productNo
	 * @return
	 */
	public P2p_tender_profit findLastTenderProfit(String productNo);
}
