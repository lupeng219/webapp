package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_record;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;
import com.baibao.web.p2p.generator.dao.P2p_cust_accountMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_product_aidMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_recordMapper;
import com.baibao.web.p2p.generator.dao.P2p_public_orderMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_billMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_recordMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_warehouseMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_warehouse_flowMapper;
import com.baibao.web.p2p.generator.dao.P2p_users_redenvelopeMapper;
import com.baibao.web.p2p.repository.TenderRepository;
@Repository
public class TenderRepositoryImpl implements TenderRepository {

	@Autowired
	private P2p_loan_product_aidMapper loanProductAidMapper;

	@Autowired
	private P2p_cust_accountMapper custAccountMapper;
	
	@Autowired
	private P2p_tender_recordMapper tenderRecordMapper;

	@Autowired
	private P2p_public_orderMapper publicOrderMapper;
	
	@Autowired
	private P2p_loan_recordMapper loanRecordMapper;
	
	@Autowired
	private P2p_loan_recordMapper loanProductMapper;
	
	@Autowired
	private P2p_repayment_billMapper repaymentBillMapper;
	
	@Autowired
	private P2p_user_warehouseMapper  user_warehouseMapper;
	
	@Autowired
	private P2p_user_warehouse_flowMapper  user_warehouse_flowMapper;
	@Autowired
	private P2p_users_redenvelopeMapper users_redenvelopeMapper;
	
	@Override
	public int updateByTenderFlowNo(Map<String, Object> params) {
		
		return tenderRecordMapper.updateByTenderFlowNo(params);
	}

	@Override
	public int updateByOrderFlowNo(String orderFlowNo, String ppoStatus) {
		
		return publicOrderMapper.updateByOrderFlowNo(orderFlowNo, ppoStatus);
	}

	@Override
	public P2p_cust_account getByCustNoAndType(Map<String, Object> map) {
		
		return custAccountMapper.getByCustNoAndType(map);
	}

	@Override
	public P2p_loan_product_aid selectByProductNo(String productNo) {
		
		return loanProductAidMapper.queryByProductNo(productNo);
	}

	@Override
	public int updateBalanceAndFreeze(String custNo, String balance, String freeze) {
		
		return custAccountMapper.updateBalanceAndFreeze(custNo, balance,
				freeze);
	}

	@Override
	public List<Map<String, Object>> querySuspiciousTenderFlow() {
		return tenderRecordMapper.querySuspiciousTenderFlow();
	}

	@Override
	public int updateSuspiciousTenderFlow(String flowNo, String status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tradeStatus", status);
		paramMap.put("tenderFlowNo", flowNo);
		return tenderRecordMapper.updateSuspiciousTenderFlow( paramMap );
	}


	@Override
	public BigDecimal getAllTenderAmount() {
		
		return tenderRecordMapper.getAllTenderAmount();
	}


	@Override
	public BigDecimal getPtrAmount(String custNo) throws BusinessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("custNo", custNo);
		paramMap.put("tradeStatusSuccess", Const.success);//成功的
		paramMap.put("tradeStatusProcessing",Const.processing );//处理中的
		return tenderRecordMapper.getAmountBycustNo(paramMap);
	}

	@Override
	public int updateSuspiciousPaymentFlow(String flowNo, String status) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ptf_transFlowNo", flowNo);
		paramMap.put("ptf_payStatus", status);
		return loanRecordMapper.updateSuspiciousPaymentFlow( paramMap );
	}

	@Override
	public int updateLoanProductStatus(String paf_transFlowNo, String status) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ptf_transFlowNo", paf_transFlowNo);
		paramMap.put("ptf_payStatus", status);
		return loanProductMapper.updateLoanProductStatus( paramMap );
	}

	@Override
	public P2p_loan_record getLoanRecordByFlowNo(String paf_transFlowNo) {
		return loanRecordMapper.getLoanRecordByFlowNo( paf_transFlowNo );
	}

	@Override
	public Map<String, Object> findByTenderFlowNo(Map<String, Object> params) {
		
		return tenderRecordMapper.findByTenderFlowNo(params);
	}

	@Override
	public int getAllProductCount() {
		
		return loanProductAidMapper.getAllProductCount();
	}

	@Override
	public int queryOverDueTotal() {
		
		return repaymentBillMapper.queryOverDueTotal();
	}

	@Override
	public int getAllTenderPeopleCount() {
		
		return tenderRecordMapper.getAllTenderPeopleCount();
	}

	@Override
	public int checkRecord(Map<String, Object> params) {
		return tenderRecordMapper.checkRecord(params);
	}

	@Override
	public void updateByPuw_whNo(Map<String, Object> params) {
		user_warehouseMapper.updateByPuw_whNo(params);
		
	}

	@Override
	public P2p_user_warehouse selectBytransFlowNo(String flowNo) {
		
		return user_warehouseMapper.selectBytransFlowNo(flowNo);
	}

	@Override
	public void updateBywhNo(Map<String, Object> params) {
		user_warehouse_flowMapper.updateBywhNo(params);
		
	}

	@Override
	public P2p_user_warehouse selectBytransFlowNoPay(String flowNo) {
		return user_warehouseMapper.selectBytransFlowNoPay(flowNo);
	}

	@Override
	public int updateredenvelo(Map<String, Object> map) {
		return users_redenvelopeMapper.updateredenvelo(map);
	}

	@Override
	public P2p_users_redenvelope queryBytransFlowNoPay(String flowNo) {
		return users_redenvelopeMapper.queryBytransFlowNoPay(flowNo);
	}

	@Override
	public P2p_users_redenvelope selectBytransFlowNoAction(String flowNo) {
		return users_redenvelopeMapper.selectBytransFlowNoAction(flowNo);
	}

	@Override
	public BigDecimal queryTenderSum(String custNo) throws BusinessException {
		if(StringUtil.isEmpty(custNo)){
			return new BigDecimal(0);
		}
		return tenderRecordMapper.queryTenderSum(custNo);
	}

	@Override
	public int selectTotalByPorductNo(Map<String, Object> params) {
		return tenderRecordMapper.selectTotalByPorductNo(params);
	}


}
