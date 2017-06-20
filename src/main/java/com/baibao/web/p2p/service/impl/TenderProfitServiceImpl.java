package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.utils.MapBuilder;
import com.baibao.web.p2p.generator.bean.P2p_bill_plan;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.dao.P2p_bill_planMapper;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
import com.baibao.web.p2p.service.TenderProfitService;

@Service("tenderProfitService")
public class TenderProfitServiceImpl implements TenderProfitService{

	@Autowired
	private TendertProfitRepository tenderProfitRepository;
	
	@Autowired
	private TenderRepository tenderRepository;
	
	@Autowired 
	private P2p_bill_planMapper p2p_bill_planMapper;
	
	@Override
	public Map<String, BigDecimal> getCustAllProfitByCustNoAndStatus(Map<String, Object> map) {
		return tenderProfitRepository.getCustAllProfitByCustNoAndStatus(map);
	}

	@Override
	public Map<String, Object> getCustWaitdayInterest(
			Map<String, Object> map) {
		return tenderProfitRepository.getCustWaitdayInterest(map);
	}

	@Override
	public List<P2p_tender_profit> findTenderProfitListByTenderFlowNo(
			Map<String, Object> map) {
		return tenderProfitRepository.findTenderProfitListByTenderFlowNo(map);
	}

	@Override
	public List getIncomeAmount(String custNo, List month) throws BusinessException {
		List incomeAmount = new ArrayList();
		List<Map<String, Object>> p2pTenderRecordList = tenderProfitRepository.getIncomeAmount(custNo);
		if(p2pTenderRecordList !=null && p2pTenderRecordList.size() >0){
			for (int i = 0; i < month.size(); i++) {
				Boolean bool = false;
				for (Map<String, Object> map : p2pTenderRecordList) {
					if(map.get("ptp_factProfitTime").equals(month.get(i))){
						incomeAmount.add(map.get("ptp_factInterest"));
						bool = true;
					}
				}
				if(!bool){
					incomeAmount.add(0);
				}
			}
		}else{
			for (int i = 0; i < month.size(); i++) {
				incomeAmount.add(0);
			}
		}
		return incomeAmount;
	}


	@Override
	public BigDecimal getFrofitTotal() {
		
		return tenderProfitRepository.getFrofitTotal();
	}


	@Override
	public BigDecimal tenderProfit(String profitType) {
		return tenderProfitRepository.tenderProfit(profitType);
	}

	@Override
	public BigDecimal tenderProfitByTenderFlowNo(String tenderFlowNo)
			throws BusinessException {
		return tenderProfitRepository.tenderProfitByTenderFlowNo(tenderFlowNo);
	}

	@Override
	public BigDecimal tenderFactProfitByTenderFlowNo(String tenderFlowNo)
			throws BusinessException {
		return tenderProfitRepository.tenderFactProfitByTenderFlowNo(tenderFlowNo);
	}

	@Override
	public List<Map<String, Object>> paymentPlanByTenderFlowNo(
			String tenderFlowNo) {
		return tenderProfitRepository.paymentPlanByTenderFlowNo(tenderFlowNo);
	}

	@Override
	public BigDecimal getPtrAmount(String custNo) throws BusinessException {
		
		return  tenderRepository.getPtrAmount(custNo);
	}

	@Override
	public List<P2p_tender_profit> getTenderProfitByProductNo(
			Map<String, Object> map) {
		return tenderProfitRepository.getTenderProfitByProductNo(map);
	}
	
	@Override
	public List<P2p_tender_profit> getTenderProfitByProduct(
			Map<String, Object> map) {
		return tenderProfitRepository.getTenderProfitByProduct(map);
	}
	
	public int getBillPlanCountByProductNo(String productNo) {
		int allCount = this.p2p_bill_planMapper.countBillPlan(
				new MapBuilder<String, Object>()
					.append("productNo", productNo)
					.append("profitStatus", "0")//0：未返利
					.toMap());
		return allCount;
	}
	
	public List<P2p_bill_plan> findBillPlanByProduct(Map<String, Object> map) {
		
		return this.p2p_bill_planMapper.findBillPlanByProduct(map);
	}

	@Override
	public BigDecimal tenderInterestByTenderFlowNo(String tenderFlowNo,String status) throws BusinessException {
		
		return	tenderProfitRepository.tenderInterestByTenderFlowNo(new MapBuilder<String, Object>()
				.append("tenderFlowNo", tenderFlowNo)
				.append("status", status)
				.toMap());
		//return tenderProfitRepository.tenderInterestByTenderFlowNo(tenderFlowNo,status);
	}

    @Override
    public BigDecimal tenderInterestedByTenderFlowNo(String tenderFlowNo) throws BusinessException {
        return  tenderProfitRepository.tenderInterestedByTenderFlowNo(new MapBuilder<String, Object>()
                .append("tenderFlowNo", tenderFlowNo)
                .toMap());
    }

	@Override
	public Date findLastPtpProfittime(String productNo) throws BusinessException {
		P2p_tender_profit tender_profit = tenderProfitRepository.findLastTenderProfit(productNo);
		if(tender_profit == null){
			throw new BusinessException("查询最后一期收益记录失败");
		}
		return tender_profit.getPtpProfittime();
	}
	
	
}
