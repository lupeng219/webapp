package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.dao.P2p_ordinary_transMapper;
import com.baibao.web.p2p.generator.dao.P2p_tender_profitMapper;
import com.baibao.web.p2p.repository.TendertProfitRepository;
@Repository
public class TendertProfitRepositoryImpl implements TendertProfitRepository {
	
	@Autowired
	private P2p_tender_profitMapper tenProfitMapper;
	@Autowired
	private P2p_ordinary_transMapper ordinaryTransDao;
	

	@Override
	public Map<String, BigDecimal> getCustAllProfitByCustNoAndStatus(Map<String,Object > map) {
		return tenProfitMapper.getCustAllProfitByCustNoAndStatus(map);
	}

	@Override
	public Map<String, Object> getCustWaitdayInterest(Map<String, Object> map) {
		return  tenProfitMapper.getCustWaitdayInterest(map);
	}

	@Override
	public List<P2p_tender_profit> findTenderProfitListByTenderFlowNo(Map<String, Object> map) {
		return tenProfitMapper.findTenderProfitListByTenderFlowNo(map);
	}
	
	@Override
	public List<Map<String, Object>> getIncomeAmount(String custNo) throws BusinessException {
		return tenProfitMapper.getIncomeAmount(custNo);
	}
	@Override
	public P2p_tender_profit getByTradeFlowNo(String tradeFlowNo) {
		return tenProfitMapper.getByTradeFlowNo(tradeFlowNo);
	}

	@Override
	public int updateProfitRecord(P2p_tender_profit profit, String profitstatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ptp_incomebillNo", profit.getPtpIncomebillNo());
		map.put("ptp_factCapital", profit.getPtpFactcapital());
		map.put("ptp_factInterest", profit.getPtpFactinterest());
		map.put("ptp_factProfit", profit.getPtpFactcapital().add(profit.getPtpFactinterest()));
		map.put("ptp_factProfitTime", new Date());
		map.put("ptp_remark","投资收益" );
		map.put("ptp_profitstatus", profitstatus);//投资收益状态：0未收益  1已收益 02处理中
		int flag = tenProfitMapper.updateProfitRecord(map);
		return flag;
	}


	@Override
	public BigDecimal getFrofitTotal() {
		
		return tenProfitMapper.getFrofitTotal();
	}

	@Override
	public BigDecimal tenderProfit(String profitType) {
		return tenProfitMapper.tenderProfit(profitType);
	}

	@Override
	public BigDecimal tenderProfitByTenderFlowNo(String tenderFlowNo)
			throws BusinessException {
		return tenProfitMapper.tenderProfitByTenderFlowNo(tenderFlowNo);
	}

	@Override
	public BigDecimal tenderFactProfitByTenderFlowNo(String tenderFlowNo)
			throws BusinessException {
		return tenProfitMapper.tenderFactProfitByTenderFlowNo(tenderFlowNo);
	}

	@Override
	public List<Map<String, Object>> paymentPlanByTenderFlowNo(
			String tenderFlowNo) {
		return tenProfitMapper.paymentPlanByTenderFlowNo(tenderFlowNo);
	}

	@Override
	public int getNotprofitCount(String productNo, String loanSeq) {
		
		return tenProfitMapper.getNotprofitCount(productNo, loanSeq);
	}

	@Override
	public int updateStatusByProductNo(Map<String, Object> map) {
		return tenProfitMapper.updateStatusByProductNo(map);
	}

	@Override
	public Map<String, Object> getB2cByTradeFlowNo(String outer_trade_no) {
		return ordinaryTransDao.getB2cByTradeFlowNo(outer_trade_no);
	}

	@Override
	public Map<String, Object> getTradeFlowNo(String outer_trade_no) {
		return ordinaryTransDao.getTradeFlowNo(outer_trade_no);
	}

	@Override
	public List<P2p_tender_profit> getTenderProfitByProductNo(Map<String, Object> map) {
		return tenProfitMapper.getTenderProfitByProductNo(map);
	}
	
	@Override
	public List<P2p_tender_profit> getTenderProfitByProduct(Map<String, Object> map) {
		return tenProfitMapper.getTenderProfitByProduct(map);
	}

	@Override
	public BigDecimal profitSum(Map<String, Object> map) {
		return tenProfitMapper.profitSum(map);
	}

	@Override
	public BigDecimal tenderInterestByTenderFlowNo(Map<String, Object> map) throws BusinessException {
		return tenProfitMapper.tenderInterestByTenderFlowNo(map);
	}

    @Override
    public BigDecimal tenderInterestedByTenderFlowNo(Map<String, Object> map) throws BusinessException {
        return tenProfitMapper.tenderInterestedByTenderFlowNo(map);
    }

	@Override
	public P2p_tender_profit findLastTenderProfit(String productNo) {
		 return tenProfitMapper.findLastTenderProfit(productNo);
	}

	
}
