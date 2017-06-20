package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.dao.P2p_cust_accountMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_productMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_billMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_bill_transMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_bill_trans_detailMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_profitMapper;
import com.baibao.web.p2p.repository.RepaymentBillRepository;

@Repository
public class RepaymentBillRepositoryImpl implements RepaymentBillRepository {
	
	@Autowired
	private P2p_repayment_billMapper reapymentBillDao;
	
	@Autowired
	private P2p_loan_productMapper loanProductDao;
	
	@Autowired
	private P2p_tender_profitMapper tenderProfitDao;
	
	@Autowired
	private P2p_repayment_bill_transMapper repaymentBillTransDao;
	
	@Autowired
	private P2p_cust_accountMapper custAccountDao;
	
	@Autowired
	private P2p_repayment_bill_trans_detailMapper repaymentBillTransDetailDao;
	
	
	
	@Override
	public List<P2p_repayment_bill> getByBulkLoanNumber(String productNo) {
		return reapymentBillDao.getByBulkLoanNumber(productNo);
	}
	
	@Override
	public Map<String, BigDecimal> getCustLiabilitiesByCustNo(String custNo) {
		return reapymentBillDao.getCustLiabilitiesByCustNo(custNo);
	}

	@Override
	public int upadteRepaymentBillStatus(P2p_repayment_bill bill,Boolean flag) {
		Map<String, Object> map = new HashMap<String, Object>();
		int overDueDays = 0;//逾期天数
		overDueDays = DateUtils.getBetweenDay(bill.getPrbRepaymenttime(), new Date());
		if(flag){
			map.put("prb_infactRepaymentTime", new Date());//实际还款日期
			if(overDueDays>0){
				//2逾期还款
				map.put("prb_repaymentStatus", "2");
			}else{
				//1正常还款
				map.put("prb_repaymentStatus", "1");
			}
		}else{
			//设置状态成未还款
			map.put("prb_repaymentStatus", "0");
		}
		map.put("prbRepaybillno", bill.getPrbRepaybillno());
		int result = reapymentBillDao.upadteRepaymentBillStatus(map);
		return result;
	}

	@Override
	public int isLastRepayment(P2p_repayment_bill bill,Boolean flag) {
		Integer currentSeq = bill.getPrbRepaymentseq();
		Integer loanTerm = bill.getPpLoanterm();
		int result = 0;
		if(currentSeq.equals(loanTerm)){
			//是最后一期,更新标的状态为已完成
			result = updateLoanProductStatus(bill.getPrbProductNo(),flag);
		}
		return result;
	}

	/**
	 * 更新产品的状态为已完成
	 * @param productNo
	 * @return
	 */
	private int updateLoanProductStatus(String productNo,Boolean flag) {
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if(flag){
			map.put("pp_bulkLoanStatus", 5);
		}else{
			map.put("pp_bulkLoanStatus", 4);
		}
		map.put("pp_productNo", productNo);
		result = loanProductDao.updateLoanProductStatus(map);
		return result;
	}

	@Override
	public P2p_repayment_bill getByprbRepaybillno(String repaybillNo) {
		P2p_repayment_bill bill = reapymentBillDao.getByprbRepaybillno(repaybillNo);
		return bill;
	}

	@Override
	public List<Map<String, Object>> getproductRepayment(Map<String, Object> map)
			throws BusinessException {
		return reapymentBillDao.getproductRepayment(map);
	}

	@Override
	public P2p_repayment_bill getRepaymentDetails(String prbRepaybillno) {
		return reapymentBillDao.getRepaymentDetails(prbRepaybillno);
	}
	
    @Override
	public int upadteRepaymentBillTrans(Map<String, Object> map) {
		int result = 0;
		result = repaymentBillTransDao.updatePrtRepaystatus(map);
		return result;
	}

    @Override
	public int upadteRepaymentBillStatus(Map<String, Object> map) {
		int result = 0;
		result = reapymentBillDao.upadteStatusBybillNoAndProductNo(map);
		return result;
	}

    @Override
	public int updateAccountBalance(Map<String, Object> map) {
		return custAccountDao.updateAccountBalance(map);
	}

    @Override
	public List<P2p_tender_profit> getAllProfit(Map<String, Object> map) throws RuntimeException{
		return tenderProfitDao.getAllProfit(map);
	}

	@Override
	public int updateLoanProductStatus(Map<String, Object> map) {
		int result = loanProductDao.updateLoanProductStatus(map);
		return result;
	}

	@Override
	public int upadteRepaymentBillTransDetails(Map<String, Object> map) throws RuntimeException{
		int result = repaymentBillTransDetailDao.upadteRepaymentBillTransDetails(map);
		return result;
	}

	@Override
	public int updateProfitRecord(Map<String, Object> map) {
		int result = tenderProfitDao.updateProfitRecord(map);
		return result;
	}

	@Override
	public int updateRepaymentBillStatusAndDate(String prbRepaybillno, String status,Date repayDate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prb_repaybillNo", prbRepaybillno);
		map.put("prb_repaymentStatus", status);
		map.put("prb_infactRepaymentTime", repayDate);
		return reapymentBillDao.upadteStatusAndDate(map);
	}

	@Override
	public P2p_repayment_bill getByTradeFlowNo(String tradeFlowNo) {
		
		return reapymentBillDao.getByTradeFlowNo(tradeFlowNo);
	}

	@Override
	public int upadteRepaymentBillStatusByProductNo(Map<String, Object> map) {
		return reapymentBillDao.upadteRepaymentBillStatusByProductNo(map);
	}

	@Override
	public List<P2p_repayment_bill> getOldByBulkLoanNumber(String productNo) {
		return reapymentBillDao.getOldByBulkLoanNumber(productNo);
	}

}
