package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.Context;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans;
import com.baibao.web.p2p.generator.dao.P2p_ordinary_trans_aidMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_bill_transMapper;
import com.baibao.web.p2p.repository.RepaymentBillTransRepository;

@Repository
public class RepaymentBillTransRepositoryImpl implements RepaymentBillTransRepository {

	private static Logger log = LoggerFactory
			.getLogger(RepaymentBillTransRepositoryImpl.class);
	@Autowired
	private P2p_repayment_bill_transMapper  repaymentBillTransDao;
	
	@Autowired
	private P2p_ordinary_trans_aidMapper  ordinaryTransAidDao;
	
	
	
	@Override
	public int insert(P2p_repayment_bill_trans record) {
		
		return repaymentBillTransDao.insert(record);
	}

	@Override
	public int updatePrtRepaystatus(Map<String, Object> map) {
		
		return repaymentBillTransDao.updatePrtRepaystatus(map);
	}

	@Override
	public int upadteRepaymentBillTrans(Context context,Boolean flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		String outer_trade_no = context.getString("outer_trade_no");
		String inner_trade_no = context.getString("inner_trade_no");
		String trade_status = context.getString("trade_status");
		String gmt_close = context.getString("gmt_close");
		
		map.put("prt_tradeFlowNo", outer_trade_no);//还款账单编号(如果是批次,则是批次号)
		map.put("prt_host_response_time", gmt_close);//响应时间
		map.put("prt_host_response_flowNum", inner_trade_no);//返回的交易流水号
		map.put("prt_host_return_code", trade_status);//返回码aa
		if(flag){
			map.put("prt_repayStatus", "00");//还款状态 00 成功  01 失败   02 处理中
		}else{
			map.put("prt_repayStatus", "02");//还款状态 00 成功  01 失败   02 处理中
		}
		int result = repaymentBillTransDao.updatePrtRepaystatus(map);
		return result;
	}

	@Override
	public P2p_repayment_bill_trans selectTransByRepaybillno(String prtRepaybillno,String tradeNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prtRepaybillno", prtRepaybillno);
		map.put("prtTradeflowno", tradeNo);
		return repaymentBillTransDao.selectByPrimaryKey(map);
	}
	
	@Override
	public int upadteRepaymentBillTransFlowNo(String prt_tradeFlowNo,String status,String ptrHostResponseTime,String ptrHostReturnCode,String ptrHostReturnMessage){
		Map<String, Object> map = new HashMap<String, Object>();
		if(prt_tradeFlowNo!=null && status != null){
			map.put("prt_repayStatus",status );
			map.put("prt_tradeFlowNo", prt_tradeFlowNo);
		}
		map.put("ptrHostResponseTime", ptrHostResponseTime);
		map.put("ptrHostReturnCode", ptrHostReturnCode);
		map.put("ptrHostReturnMessage", ptrHostReturnMessage);
		return repaymentBillTransDao.upadteRepaymentBillTransFlowNo(map);
	}

	@Override
	public P2p_repayment_bill_trans selectByRepaybillno(String prtRepaybillno) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prt_repaybillNo",prtRepaybillno );
		return repaymentBillTransDao.selectByRepaybillno(map);
	}

	@Override
	public int upadteP2pB2cTransAid(Context context, Boolean judgment) {

		Map<String, Object> map = new HashMap<String, Object>();
		String outer_trade_no = context.getString("outer_trade_no");
		String inner_trade_no = context.getString("inner_trade_no");
		String trade_status = context.getString("trade_status");
		String gmt_close = context.getString("gmt_close");
		
		map.put("prt_tradeFlowNo", outer_trade_no);//还款账单编号(如果是批次,则是批次号)
		map.put("prt_host_response_time", gmt_close);//响应时间
		map.put("prt_host_response_flowNum", inner_trade_no);//返回的交易流水号
		map.put("prt_host_return_code", trade_status);//返回码aa
		if(judgment){
			map.put("pbt_status", "00");//还款状态 00 成功  01 失败   02 处理中
		}else{
			map.put("pbt_status", "01");//还款状态 00 成功  01 失败   02 处理中
		}
		int result = ordinaryTransAidDao.upadteP2pB2cTransAid(map);
		return result;
	
	}

	@Override
	public int updateOrdinaryTransAidByFlowNo(String prt_tradeFlowNo,
			String status, String ptrHostResponseTime,
			String ptrHostReturnCode, String ptrHostReturnMessage) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(prt_tradeFlowNo!=null && status != null){
			map.put("pbt_status",status );
			map.put("prt_tradeFlowNo", prt_tradeFlowNo);
		}
		map.put("prt_host_response_time", ptrHostResponseTime);
		map.put("prt_host_return_code", ptrHostReturnCode);
		map.put("response_message", ptrHostReturnMessage);
		return ordinaryTransAidDao.upadteP2pB2cTransAid(map);
	}


}
