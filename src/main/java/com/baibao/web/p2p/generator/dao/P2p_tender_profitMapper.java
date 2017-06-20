package com.baibao.web.p2p.generator.dao;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.bean.P2p_tender_profitExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_tender_profitMapper {
    int countByExample(P2p_tender_profitExample example);

    int deleteByExample(P2p_tender_profitExample example);

    int deleteByPrimaryKey(Long ptpId);

    int insert(P2p_tender_profit record);

    int insertSelective(P2p_tender_profit record);

    List<P2p_tender_profit> selectByExample(P2p_tender_profitExample example);

    P2p_tender_profit selectByPrimaryKey(Long ptpId);

    int updateByExampleSelective(@Param("record") P2p_tender_profit record, @Param("example") P2p_tender_profitExample example);

    int updateByExample(@Param("record") P2p_tender_profit record, @Param("example") P2p_tender_profitExample example);

    int updateByPrimaryKeySelective(P2p_tender_profit record);

    int updateByPrimaryKey(P2p_tender_profit record);
    /**
     * 根据产品编号修改状态
     * @param productNo
     * @return
     */
    int updateStatusByProductNo(Map<String, Object>map);
    /**
     * 根据产品编号和当前期数、未收益，查找收益本息和
     * @param map
     * @return
     */
    public BigDecimal getRepaymentMoney(Map<String, Object> map);
    
    /**
     * 得到每期还款计划对应的收益
     * @param map
     * @return
     */
    public List<P2p_tender_profit> getListByMap(Map<String, Object> map);
    
    /**
     * 更新收益状态未还款中的
     * @param map
     * @return
     */
    public int updatePtpProfitstatus(Map<String, Object> map);
    
    /**
     * 根据订单号进行更新
     * @param map
     * @return
     */
    public int updateStatusByOrderNo(Map<String, Object> map);
    /**
     * 根据投资单号查询待收本息
     * @param tenderFlowNo
     * @return
     */
    public BigDecimal tenderProfitByTenderFlowNo(String tenderFlowNo);
    
    public BigDecimal tenderFactProfitByTenderFlowNo(String tenderFlowNo);
    
    public BigDecimal tenderInterestByTenderFlowNo(Map<String,Object>map);
    
    public BigDecimal tenderInterestedByTenderFlowNo(Map<String,Object>map);
    /**
     * 得到某个借款的所有收益
     * @param bulkloanNumber
     * @return
     */
    public List<P2p_tender_profit>  getAllProfitByBulkloanNumber(Map<String, Object> map);
    
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
     * @param month
     * @return
     * @throws BusinessException
     */
    public List<Map<String, Object>> getIncomeAmount(String custNo) throws BusinessException;
    
    /**
     * 根据收益流水号进行查询
     * @param ptpIncomebillNo
     * @return
     */
	public P2p_tender_profit getByTradeFlowNo(String tradeFlowNo);
	
	/**
	 * 更新收益记录状态
	 * @param map
	 * @return
	 */
	public int updateProfitRecord(Map<String, Object> map);

	
	/**
	 * 累计收益总数
	 * @return
	 */
	public BigDecimal  getFrofitTotal();
	/**
	 * 收益查询 （待收 ，已收）
	 * @return
	 */
	public BigDecimal profitSum(Map<String, Object> map);
	
	/**
	 * 得到某个产品某一期的所有收益记录
	 * @param map
	 * @return
	 */
	public List<P2p_tender_profit> getAllProfit(Map<String, Object> map);
	
	
	public BigDecimal tenderProfit(String profitType);
	
	/**
	 * 还款计划
	 * @param tenderFlowNo
	 * @return
	 */
	public List<Map<String, Object>> paymentPlanByTenderFlowNo(String tenderFlowNo);
	public List<Map<String, Object>> paymentPlanByTenderFlowNo2(Map<String, Object> map);

	/**
	 * 根据产品和期数查询未收益人数
	 * @param productNo
	 * @param loanSeq
	 * @return
	 */
	public int getNotprofitCount(@Param("productNo")String productNo,@Param("loanSeq")String loanSeq );
	
	/**
	 * 根据借款编号查出收益
	 * @param productNo
	 * @return
	 */
	public List<P2p_tender_profit> getTenderProfitByProductNo(Map<String, Object> map);
	
	/**
	 * 根据借款编号查出收益
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