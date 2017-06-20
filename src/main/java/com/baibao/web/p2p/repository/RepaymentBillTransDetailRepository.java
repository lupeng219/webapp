package com.baibao.web.p2p.repository;

import java.util.Map;

import com.baibao.core.Context;

public interface RepaymentBillTransDetailRepository {
	
	/**
	 * 修改代收记录的状态
	 * @param ptpIncomebillNo
	 * @param context
	 * @param b
	 * @return
	 */
	public int upadteRepaymentBillTransDetails(
			Context context, String status);
	
	
	/**
     * 更新还款状态
     * @param map
     * @return
     */
    public int updatePrdStatus(Map<String, Object> map);
    
	/**
	 * 根据还款账单查询已还金额
	 * @param repaybillNo
	 * @return
	 */
	public String serachRepaymentMoneyBybillNo(String repaybillNo);

	
	/**
	 * 更新普通转账代付记录
	 * @param context
	 * @param success
	 * @return
	 */
	public int upadteP2pB2cTrans(Context context, String status);
	
	/**
	 * 更新普通转账代付记录
	 * @param context
	 * @param success
	 * @return
	 */
	public int updateOrdinaryTransByFlowNo(String prt_tradeFlowNo,String status, String ptrHostResponseTime,
			String ptrHostReturnCode, String ptrHostReturnMessage);
	
}
