package com.baibao.web.p2p.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;

public interface RepaymentBillService {
	
	
    /**
	 * 根据借款编号查询还款记录
	 * @return
	 */
	public List<P2p_repayment_bill>  getByBulkLoanNumber(String prbBulkLoanNumber); 
	
	/**
     * 查询借款人负债情况
     * @param custNo
     * @return
     */
    public Map<String, BigDecimal> getCustLiabilitiesByCustNo(String custNo);
    
    /**
     * 还款信息展示
     * @param productNo
     * @return
     * @throws BusinessException
     */
    public Map<String, Object> getproductRepayment(Map<String, Object> map) throws BusinessException;

    /**
     * 还款
     */
    public int repay(
    	String custNo, String transPassword, String[] repaybillNos);
    
    /**
     * 验证还款
     * @param map
     * @return
     * @throws BusinessException
    
    public Map<String, Object> validateRepayment(String prbRepaybillno,String pcaPayPassword) throws BusinessException;
	public Map<String, Object> operationRepayment(String prbRepaybillno) throws BusinessException;
	public Map<String, Object> repaymentPay(String prbRepaybillno,String tradeNo) throws BusinessException;
	 */

	/**
	 * 代收失败操作
	 * @param bill
	 * @param repaymentAmount
	 */
	public int collectingFailOperation(String tradeFlowNo,P2p_repayment_bill bill,BigDecimal repaymentAmount,Map<String, Object> map);
	
	/**
	 * 还款记录old(一期项目)
	 * @param productNo
	 * @return
	 */
	public List<P2p_repayment_bill> getOldByBulkLoanNumber(String productNo);
	
	/**
	 * 获得还款记录
	 * @param map
	 * @return
	 */
    public boolean getRepaymentBillByProduct(Map<String, Object> map, String[] repaybillNos);
}
