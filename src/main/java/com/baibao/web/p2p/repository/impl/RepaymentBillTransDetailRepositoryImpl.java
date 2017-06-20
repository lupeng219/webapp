package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.Context;
import com.baibao.web.p2p.generator.dao.P2p_ordinary_transMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_bill_trans_detailMapper;
import com.baibao.web.p2p.repository.RepaymentBillTransDetailRepository;
@Repository("repaymentBillTransDetailRepository")
public class RepaymentBillTransDetailRepositoryImpl implements
		RepaymentBillTransDetailRepository {
	
	private static Logger log = LoggerFactory.getLogger(RepaymentBillTransDetailRepositoryImpl.class);
	@Autowired
	private P2p_repayment_bill_trans_detailMapper repaymentBillTransDetailDao;
	
	@Autowired
	private P2p_ordinary_transMapper ordinaryTransDao;
	
	@Override
	public int upadteRepaymentBillTransDetails(
			Context context, String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		String outer_trade_no = context.getString("outer_trade_no");
		String inner_trade_no = context.getString("inner_trade_no");
		String trade_status = context.getString("trade_status");
		String gmt_close = context.getString("gmt_close");
		
		map.put("response_time", gmt_close);//响应时间
		map.put("prd_host_response_flowNum", inner_trade_no);//返回的交易流水号
		map.put("prd_host_return_code", trade_status);//返回码
		map.put("prd_tradeFlowNo", outer_trade_no);//交易流水号
		map.put("prd_status", status);//还款状态 00 成功  01 失败   02 处理中
		int result = 0;
		result = repaymentBillTransDetailDao.upadteRepaymentBillTransDetails(map);
		return result;
	}

	@Override
	public int updatePrdStatus(Map<String, Object> map) {
		
		return repaymentBillTransDetailDao.updatePrdStatus(map);
	}

	@Override
	public String serachRepaymentMoneyBybillNo(String repaybillNo) {
		
		return repaymentBillTransDetailDao.serachRepaymentMoneyBybillNo(repaybillNo);
	}

	@Override
	public int upadteP2pB2cTrans(Context context, String status) {
		Map<String, Object> map = new HashMap<String, Object>();
		String outer_trade_no = context.getString("outer_trade_no");
		String inner_trade_no = context.getString("inner_trade_no");
		String trade_status = context.getString("trade_status");
		String gmt_close = context.getString("gmt_close");
		
		map.put("response_time", gmt_close);//响应时间
		map.put("prd_host_response_flowNum", inner_trade_no);//返回的交易流水号
		map.put("prd_host_return_code", trade_status);//返回码
		map.put("prd_tradeFlowNo", outer_trade_no);//交易流水号
		map.put("pbt_status", status);//还款状态 00 成功  01 失败   02 处理中
		int result = 0;
		result = ordinaryTransDao.upadteP2pB2cTrans(map);
		return result;
	}

	@Override
	public int updateOrdinaryTransByFlowNo(String prt_tradeFlowNo,
			String status, String ptrHostResponseTime,
			String ptrHostReturnCode, String ptrHostReturnMessage) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(prt_tradeFlowNo!=null && status != null){
			map.put("pbt_status",status );
			map.put("prd_tradeFlowNo", prt_tradeFlowNo);
		}
		map.put("response_time", ptrHostResponseTime);
		map.put("prd_host_return_code", ptrHostReturnCode);
		map.put("response_message", ptrHostReturnMessage);
		return ordinaryTransDao.upadteP2pB2cTrans(map);
	}

}
