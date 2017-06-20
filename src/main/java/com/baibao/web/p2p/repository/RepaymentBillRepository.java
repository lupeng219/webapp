package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;

public interface RepaymentBillRepository {
	 
	/**
	 * 根据借款编号查询还款记录
	 * @return
	 */
	public List<P2p_repayment_bill> getByBulkLoanNumber(String prbBulkLoanNumber);
	
	/**
	 * 查询借款人负债情况
	 * @param custNo
	 * @return
	 */
	public Map<String, BigDecimal> getCustLiabilitiesByCustNo(String custNo);
	
	
	/**
	 * 判断是否是最后一期
	 * @param repaymentBill
	 * @return
	 */
	public int isLastRepayment(P2p_repayment_bill repaymentBill,Boolean flag);
	/**
	 * 根据产品编号修改还款计划状态
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillStatusByProductNo(Map<String, Object>map);
	
	/**
	 * 更具还款账单号进行查询
	 * @param outer_trade_no
	 * @return
	 */
	public P2p_repayment_bill getByprbRepaybillno(String repaybillNo);
	
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
	 * 更新操作
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillTrans(Map<String, Object> map);
	
	/**
	 * 更新还款账单状态
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillStatus(Map<String, Object> map);
	
	/**
	 * 更新账户余额
	 * @param pca_accountNo 第三方那个支付账号
	 * @return
	 */
	public int updateAccountBalance(Map<String, Object> map);
	
	/**
	 * 得到某个产品某一期的所有收益记录
	 * @param map
	 * @return
	 */
	public List<P2p_tender_profit> getAllProfit(Map<String, Object> map) throws RuntimeException;
	
	/**
	 * 产品状态
	 * @param map
	 * @return
	 */
	public int updateLoanProductStatus(Map<String, Object> map);
	
	/**
	 * 更新代付操作记录
	 * @param map
	 * @return
	 */
	public int upadteRepaymentBillTransDetails(Map<String, Object> map) throws RuntimeException;
	
	/**
	 * 更新收益记录状态
	 * @param map
	 * @return
	 */
	public int updateProfitRecord(Map<String, Object> map);

	/**
	 * 更新还款计划的状态
	 * @param allDataMap
	 * @return
	 */
	int upadteRepaymentBillStatus(P2p_repayment_bill bill, Boolean flag);
	
	/**
	 * 更新账单状态和还款时间
	 * @param prbRepaybillno
	 * @param status
	 * @return
	 */
	int updateRepaymentBillStatusAndDate(String prbRepaybillno,String status,Date repayDate);
	
	/**
	 * 
	 * @param tradeFlowNo
	 * @return
	 */
	public P2p_repayment_bill  getByTradeFlowNo(String tradeFlowNo);
	
	/**
	 * 还款账单old
	 * @param productNo
	 * @return
	 */
	public List<P2p_repayment_bill> getOldByBulkLoanNumber(String productNo);
	
   
}
