package com.baibao.web.p2p.repository;

import java.util.Map;

import com.baibao.core.Context;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans;

public interface RepaymentBillTransRepository {
	/**
	 * 插入表
	 * @param record
	 * @return
	 */
	 int insert(P2p_repayment_bill_trans record);
	 
	 
 	/**
     * 更新状态
     * @param map
     * @return
     */
	 public int updatePrtRepaystatus(Map<String, Object> map);

	 /**
	  * 更新收益状态(回调使用方法)
	  * @param allDataMap
	  * @return
	  */
	public int upadteRepaymentBillTrans(Context context,Boolean flag);
	
	/**
	 * 更新收益状态(跑批使用方法)
	 * @param prt_tradeFlowNo
	 * @param status
	 * @return
	 */
	public int upadteRepaymentBillTransFlowNo(String prt_tradeFlowNo,String status,String ptrHostResponseTime,String ptrHostReturnCode,String ptrHostReturnMessage);
	
	/**
	 * 根据账单号和流水号查询还款代收流水详情
	 * @param prtRepaybillno
	 * @return
	 */
	public P2p_repayment_bill_trans selectTransByRepaybillno(String prtRepaybillno,String tradeNo);
	/**
	 * 只根据账单号查询还款代收流水详情
	 * @param prtRepaybillno
	 * @return
	 */
	public P2p_repayment_bill_trans selectByRepaybillno(String prtRepaybillno);

	
	/**
	 * 更新普通转账代收记录状态
	 * @param context
	 * @param judgment
	 * @return
	 */
	public int upadteP2pB2cTransAid(Context context, Boolean judgment);


	public int updateOrdinaryTransAidByFlowNo(String prt_tradeFlowNo, String status,
			String ptrHostResponseTime, String ptrHostReturnCode,String ptrHostReturnMessage);
	


}
