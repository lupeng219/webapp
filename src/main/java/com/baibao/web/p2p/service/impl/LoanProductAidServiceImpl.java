package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.comm.Arith;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.repository.LoanProductAidRepository;
import com.baibao.web.p2p.service.LoanProductAidService;

@Service("loanProductAidService")
public class LoanProductAidServiceImpl implements LoanProductAidService {

	@Autowired
	private LoanProductAidRepository loanProductAidRepository;

	@Override
	public Paging<P2p_loan_product_aid> queryTenderRecordByCust(
			String custNo, String bulkStatus,
			int currentPageNo, int pageSize,
			String beginTime, String endTime) 
	{
		Map<String, Object> params = new HashMap<String, Object>();
		Paging<P2p_loan_product_aid> pag =
			new Paging<P2p_loan_product_aid>(
				currentPageNo, pageSize);

		params.put("custNo", custNo);
		params.put("bulkStatus", bulkStatus);
		params.put("beginTime", beginTime);
		params.put("endTime", endTime);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		params.put("isPage", "isPage");

		pag.setPageList(
			loanProductAidRepository.queryTenderRecordByCust(params));
		pag.setCountTotal(
			loanProductAidRepository.getCustTenderRecordTotal(params));

		for(P2p_loan_product_aid product: pag.getPageList())
		{
			product.setPlpLockAssignationDateTime(
				product.getPlpLockAssignationDate() == null?
					0l: product.getPlpLockAssignationDate().getTime());
		}
		
		return pag;
	}

	@Override
	public List<P2p_loan_product_aid> queryLoanProductAidList(Map<String, Object> params) {
		return loanProductAidRepository.queryTenderRecordByCust(params);
	}

	@Override
	public List <P2p_loan_product_aid> queryProductAid(String productTypeNo,Integer showCount) {
		Map<String, Object> params= new HashMap<String, Object>();
		params.put("productTypeNo", productTypeNo);
		params.put("showCount", showCount);
  		return loanProductAidRepository.queryProductAid(params);
	}

	@Override
	public P2p_loan_product_aid queryByProductNo(String productNo) {
		return loanProductAidRepository.queryByProductNo(productNo);
	}

	@Override
	public Paging<P2p_loan_product_aid> findLoanProductAidPage(String custNo,int bulkStatus,int pageNo,int pageSize) {
		Paging<P2p_loan_product_aid> pag = new Paging<P2p_loan_product_aid>(
				pageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("custNo", custNo);
		params.put("bulkStatus", bulkStatus);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		pag.setPageListMap(loanProductAidRepository.findLoanProductAidPage(params));
		pag.setCountTotal(loanProductAidRepository.findLoanProductAidTotal(params));
		return pag;
	}

	@Override
	public Paging<P2p_tender_record> queryTenderRecordByPorductNo(String productNo, int currentPageNo, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		Paging<P2p_tender_record> pag = new Paging<P2p_tender_record>(
				currentPageNo, pageSize);
		params.put("productNo", productNo);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		pag.setPageList(loanProductAidRepository.queryTenderRecordByPorductNo(params));
		pag.setCountTotal(loanProductAidRepository
				.selectTotalByPorductNo(params));
		return pag;
	}

	@Override
	public Paging<P2p_loan_product_aid> findLoanProductAidListPage(
			String productType, String bulkStatus,
			Integer loanTerm, int pageNo, int pageSize,
			String ppActivityType, String ppInvestmentType) {
		Paging<P2p_loan_product_aid> pag = new Paging<P2p_loan_product_aid>(
				pageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("productType", null);
		params.put("bulkStatus", bulkStatus);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		params.put("ppInvestmentType", ppInvestmentType);
		//用于区分活动
		params.put("activityType", ppActivityType);
		if(null!=loanTerm){
			if (loanTerm == 1)
			{
				params.put("beginTerm", 0);
				params.put("endTerm", 30);
			}
			else if (loanTerm==3)
			{
				params.put("beginTerm", 30);
				params.put("endTerm", 90);
			}
			else if (loanTerm ==6)
			{
				params.put("beginTerm", 120);
				params.put("endTerm", 180);
			}
			else if (loanTerm ==12)
			{
				params.put("beginTerm", 210);
				params.put("endTerm", 720);
			}
		}
		
		pag.setPageList(loanProductAidRepository.findLoanProductAidListPage(params));
		Integer count = loanProductAidRepository.getLoanProductAidListTotal(params);
		
		pag.setCountTotal(count);
		return pag;
	}
	
	@Override
	public Paging<P2p_loan_product_aid> findLoanProductAidCreditTransListPage(
			Integer loanTerm, Integer loanRate, int pageNo, int pageSize)
	{
		Paging<P2p_loan_product_aid> pag = new Paging<P2p_loan_product_aid>(
				pageNo, pageSize);
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		
		if (null != loanTerm)
		{
			if (loanTerm == 1)
			{
				params.put("beginTerm", 0);
				params.put("endTerm", 3);
			}
			else if (loanTerm == 2)
			{
				params.put("beginTerm", 3);
				params.put("endTerm", 6);
			}
			else if (loanTerm == 3)
			{
				params.put("beginTerm", 6);
				params.put("endTerm", 9);
			}
			else if (loanTerm == 4)
			{
				params.put("beginTerm", 9);
				params.put("endTerm", Integer.MAX_VALUE);
			}
		}	
		if (loanRate != null)
		{
			if (loanRate == 1)
			{
				params.put("beginRate", 13);
				params.put("endRate", 15);
			}
			else if (loanRate == 2)
			{
				params.put("beginRate", 12);
				params.put("endRate", 13);
			}
			else if (loanRate == 3)
			{
				params.put("beginRate", 10);
				params.put("endRate", 12);
			} else if (loanRate == 4)
			{
				params.put("beginRate", 0);
				params.put("endRate", 10);
			}
		}
		
		pag.setPageList(loanProductAidRepository.findLoanProductAidCreditTransListPage(params));
		Integer count = loanProductAidRepository.getLoanProductAidCreditTransListTotal(params);
		
		pag.setCountTotal(count);
		return pag;
	}
	
	@Override
	public Paging<P2p_loan_product_aid> findLoanProductAidListType(
			String productType, String bulkStatus, Integer loanTerm,
			int pageNo, int pageSize, String type, String noviceNo) {
		Paging<P2p_loan_product_aid> pag = new Paging<P2p_loan_product_aid>(
				pageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("productType", type);
		params.put("bulkStatus", bulkStatus);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		params.put("noviceNo", noviceNo);
//		params.put("type", type);
		if(null!=loanTerm){
		if(loanTerm==3){
			params.put("beginTerm", 0);
			params.put("endTerm", 3);
		}else if(loanTerm ==6){
			params.put("beginTerm", 4);
			params.put("endTerm", 6);
		}else if(loanTerm ==12){
			params.put("beginTerm", 7);
			params.put("endTerm", 12);
		}
		}
		pag.setPageList(loanProductAidRepository.findLoanListByActivityType(params));
		Integer count = loanProductAidRepository.findLoanListByActivityTypeCount(params);
		pag.setCountTotal(count);
		return pag;
	}
	
	
	@Override
	public List<P2p_loan_product_aid> findActiveProductAidList() {
		
		return loanProductAidRepository.findActiveProductAidList();
	}

	@Override
	public Map<String, Object> queryPorductAidActiveApp() {
		return loanProductAidRepository.queryPorductAidActiveApp();
	}

	@Override
	public Map<String, Object> queryPorductAidApp() {
		return loanProductAidRepository.queryPorductAidApp();
	}

	@Override
	public List<P2p_loan_product_picture> selectByproductNo(
			Map<String, Object> map) {
		return loanProductAidRepository.selectByproductNo(map);
	}

	@Override
	public Paging<Map<String, Object>> tenderRecordByCustNo(String custNo,
			String bulkLoanStatus, int currentPageNo, int pageSize) {
		Map<String, Object>params = new  HashMap<String, Object>();
		Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
				currentPageNo, pageSize);
		params.put("custNo", custNo);
		params.put("bulkLoanStatus", bulkLoanStatus);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		pag.setPageList(loanProductAidRepository.tenderRecordByCustNo(params));
		pag.setCountTotal(loanProductAidRepository.tenderRecordByCustNoCount(params));
		return pag;
	}
	
	@Override
    public Paging<Map<String, Object>> tenderAssignAbleByCustNo(String custNo,
            String bulkLoanStatus, int currentPageNo, int pageSize) {
        Map<String, Object> params = new  HashMap<String, Object>();
        Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
                currentPageNo, pageSize);
        params.put("custNo", custNo);
        params.put("bulkLoanStatus", bulkLoanStatus);
        params.put("beginWith", pag.getBeginWith());
        params.put("count", pag.getPageSize());
        pag.setPageList(loanProductAidRepository.tenderRecordByCustNo(params));
        pag.setCountTotal(loanProductAidRepository.tenderRecordByCustNoCount(params));
        return pag;
    }
	
	@Override
    public Paging<P2p_loan_product_aid> tenderAssigningByCustNo(String custNo, int currentPageNo, int pageSize) {
        Map<String, Object> params = new  HashMap<String, Object>();
        Paging<P2p_loan_product_aid> pag = new Paging<P2p_loan_product_aid>(currentPageNo, pageSize);
        params.put("custNo", custNo);
        params.put("investmentType", Const.IFTHESTANDARD);
        params.put("beginWith", pag.getBeginWith());
        params.put("count", pag.getPageSize());
        pag.setPageList(loanProductAidRepository.tenderAssigning(params));
        pag.setCountTotal(loanProductAidRepository.tenderAssigningCount(params));
        return pag;
    }
    
    @Override
    public Paging<P2p_loan_product_aid> tenderAssignFinishByCustNo(String custNo, int currentPageNo, int pageSize) {
        Map<String, Object> params = new  HashMap<String, Object>();
        Paging<P2p_loan_product_aid> pag = new Paging<P2p_loan_product_aid>(currentPageNo, pageSize);
        params.put("custNo", custNo);
        params.put("investmentType", Const.IFTHESTANDARD);
        params.put("beginWith", pag.getBeginWith());
        params.put("count", pag.getPageSize());
        pag.setPageList(loanProductAidRepository.tenderAssignFinish(params));
        pag.setCountTotal(loanProductAidRepository.tenderAssignFinishCount(params));
        return pag;
    }

	@Override
	public List<P2p_loan_product_aid> queryProductAidBydybz(String productTypeNo,int ztCount) {
		Map<String, Object>params = new  HashMap<String, Object>();
		params.put("productTypeNo", productTypeNo);
		params.put("ztCount", ztCount);
		return loanProductAidRepository.queryProductAidBydybz(params);
	}
	
	@Override
	public List<P2p_loan_product_aid> queryAssetsPackProductAid(int assetsPackCount) {
		Map<String, Object> params = new  HashMap<String, Object>();
		params.put("assetsPackCount", assetsPackCount);
		return loanProductAidRepository.queryAssetsPackProductAid(params);
	}
	
	@Override
	public List<P2p_loan_product_aid> queryTermDaysProductAid(int termDaysCount) {
		Map<String, Object> params = new  HashMap<String, Object>();
		params.put("termDaysCount", termDaysCount);
		return loanProductAidRepository.queryTermDaysProductAid(params);
	}
	
	@Override
	public P2p_loan_product_aid queryNoviceExclusive() {
		return loanProductAidRepository.queryNoviceExclusive();
	}
	
	@Override
	public List<P2p_loan_product_aid> queryNoviceExclusives() {
		return loanProductAidRepository.queryNoviceExclusives();
	}

	@Override
	public List<Map<String, Object>> getProfitByEqual(BigDecimal amount,
			BigDecimal yearRate, Integer periodsNum) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		RepaymentUtilServiceImpl re = new RepaymentUtilServiceImpl();
		BigDecimal bx = re.interAndPri(yearRate, amount, periodsNum);
		//除去最后一期的本金和
		BigDecimal sumAmount=new BigDecimal(0);
		for(int i=1; i<=periodsNum; i++){
			Map<String, Object> dataMap = new HashMap<String, Object>();
			//判断是否为最后一期
			if(i==periodsNum){
				//设置期数
				dataMap.put("periodsNum", i);
				//设置还款本息
				dataMap.put("capitalInt", bx);
				//设置还款本金  最后一期为本金减去剩余期数
				dataMap.put("capital",amount.subtract(sumAmount) );
				//设置还款利息最后一期利息
				//BigDecimal lx = bx.subtract(re.principal(yearRate, amount.subtract(sumAmount), 1, 1));
				dataMap.put("interest", bx.subtract(amount.subtract(sumAmount)));
				list.add(dataMap);
			}else{
				//设置期数
				dataMap.put("periodsNum", i);
				//设置还款本息
				dataMap.put("capitalInt", bx);
				//设置还款本金
				BigDecimal capital = re.principal(yearRate, amount, periodsNum, i);
				dataMap.put("capital", capital);
				sumAmount=sumAmount.add(capital);
				//设置还款利息
				BigDecimal lx = bx.subtract(re.principal(yearRate, amount, periodsNum, i));
				dataMap.put("interest", lx);
				list.add(dataMap);
			}
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> getProfitByAfterPrincipal(
		BigDecimal capital, BigDecimal yearRate, Integer periodsNum)
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		BigDecimal comprehensiverate =
			yearRate.divide(BigDecimal.valueOf(12),
				10, RoundingMode.HALF_UP);
		
		BigDecimal interest = 
			capital.multiply(comprehensiverate)
				.setScale(2, RoundingMode.DOWN);

		for(int index = 1; index <= periodsNum; ++index)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			
			BigDecimal theCaptial =
				(index == periodsNum)? capital: new BigDecimal(0);
			map.put("periodsNum", index);
			map.put("capital", theCaptial);
			map.put("interest", interest);
			map.put("capitalInt", theCaptial.add(interest));
			list.add(map);
		}

		/*BigDecimal totalInterest = Arith.div(Arith.mul(Arith.mul(capital, BigDecimal.valueOf(periodsNum)), yearRate), BigDecimal.valueOf(12), 4);
		for(int i=1; i<=periodsNum; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			//期数
			map.put("periodsNum", i);
			if(i==periodsNum){
				//本金
				map.put("capital", capital);
				//利息
				map.put("interest", Arith.div(totalInterest, BigDecimal.valueOf(periodsNum), 4));
				//本息
				map.put("capitalInt", Arith.add(capital, Arith.div(totalInterest, BigDecimal.valueOf(periodsNum), 4)));
			}else{
				//本金
				map.put("capital", BigDecimal.valueOf(0.0));
				//利息
				map.put("interest", Arith.div(totalInterest, BigDecimal.valueOf(periodsNum), 4));
				//本息
				map.put("capitalInt", Arith.div(totalInterest, BigDecimal.valueOf(periodsNum), 4));
			}
			
			list.add(map);
		}*/

		return list;
	}
	
	@Override
	public List<Map<String, Object>> getInteresByDayPlan(
		BigDecimal loanAmount, BigDecimal yearRate,
		Integer loanterm)
	{
		List<Map<String, Object>> dataList =
			new ArrayList<Map<String, Object>>();

		BigDecimal totalCaptial = new BigDecimal(0);
		BigDecimal totalInterest = new BigDecimal(0);

		//月利率
		BigDecimal comprehensiverate =
			yearRate.divide(BigDecimal.valueOf(365),
				6, RoundingMode.HALF_UP);

		//为每个人生成当期的还款计划
		BigDecimal capital = loanAmount;

		//计算公式: 最终利息 = 贷款本金×日利率×天数
		//计算公式: 最终还款额 = 贷款本金×(1＋日利率×天数)
		BigDecimal interest =
			capital.multiply(comprehensiverate)
				.multiply(new BigDecimal(loanterm))
				.setScale(2, RoundingMode.HALF_UP);
		BigDecimal principal =
			capital.add(interest)
				.setScale(2, RoundingMode.HALF_UP);

		totalCaptial = totalCaptial.add(capital);
		totalInterest = totalInterest.add(interest);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//期数
		map.put("periodsNum", 1);
		//本金
		map.put("capital", totalCaptial);
		//利息
		map.put("interest", totalInterest);
		//本息
		map.put("capitalInt",
			Arith.add(totalCaptial, totalInterest));
		//总期数
		map.put("loanTerm", 1);

		//添加list
		dataList.add(map);
		
	    /*Integer days = 30;
		//最后一期天数
		Integer lastPeriodOfDays = 0;

		//1.通过总的天数，以30天为一期算出总的期数
		Integer loanTerm =  allDays % days == 0 ? allDays / days : allDays / days + 1;
		
		//2.根据期数算出每一期的收益利息，通过天数来计算
		//如果只有一期,期数就是总的天数
		if (loanTerm == 1)
		{
			Map<String, Object> map = new HashMap<String, Object>();
			BigDecimal totalInterest =
				Arith.mul(Arith.mul(loanAount,
					Arith.div(yearRate, BigDecimal.valueOf(365))),
					new BigDecimal(allDays))
					.setScale(2, BigDecimal.ROUND_HALF_UP);
			//期数
			map.put("periodsNum", 1);
			//本金
			map.put("capital", loanAount);
			//利息
			map.put("interest", totalInterest);
			//本息
			map.put("capitalInt",
				Arith.add(loanAount, totalInterest));
			//总期数
			map.put("loanTerm", loanTerm);
			//添加list
			dataList.add(map);
		} else
		{
			for(int i=1; i<=loanTerm; i++)
			{
				Map<String, Object> map = new HashMap<String, Object>();
				//当前期数
				map.put("periodsNum", i);
				//最后一期
				if (i == loanTerm)
				{
					lastPeriodOfDays = allDays-((loanTerm-1)*days);
					BigDecimal totalInterest =
						Arith.mul(Arith.mul(loanAount,
							Arith.div(yearRate, BigDecimal.valueOf(365))),
							new BigDecimal(lastPeriodOfDays))
						.setScale(2,BigDecimal.ROUND_HALF_UP);

					//本金
					map.put("capital", loanAount);
					//利息
					map.put("interest", totalInterest);
					//本息
					map.put("capitalInt", Arith.add(loanAount,totalInterest));
				} else
				{
					BigDecimal totalInterest =
						Arith.mul(Arith.mul(loanAount,
							Arith.div(yearRate, BigDecimal.valueOf(365))),
						new BigDecimal(days))
						.setScale(2,BigDecimal.ROUND_HALF_UP);
					//利息
					map.put("interest",totalInterest );
					//本金
					map.put("capital",new BigDecimal(0) );
					//本息
					map.put("capitalInt", totalInterest);
				}

				//总期数
				map.put("loanTerm", loanTerm);
				//添加list
				dataList.add(map);
			}
		}*/

		return dataList;
	}
	
	@Override
	public Paging<P2p_tender_record> queryOldTenderRecord(String productNo,
			int currentPageNo, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		Paging<P2p_tender_record> pag = new Paging<P2p_tender_record>(
				currentPageNo, pageSize);
		params.put("productNo", productNo);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		pag.setPageList(loanProductAidRepository.queryOldTenderRecord(params));
		pag.setCountTotal(loanProductAidRepository.selectOldTotal(params));
		return pag;
	}

	@Override
	public Map<String, Object> getProductNo(String productNo)
			throws BusinessException {
		
		return loanProductAidRepository.getProductNo(productNo);
	}

	@Override
	public Map<String, Object> findByTenderFlowNo(String tenderFlowNo) {
		return loanProductAidRepository.findByTenderFlowNo(tenderFlowNo);
	}

    @Override
    public Map<String, Object> queryPorductAidAppDirect() {
        return loanProductAidRepository.queryPorductAidAppDirect();
    }

    @Override
    public Map<String, Object> queryPorductAidAppDay() {
        return loanProductAidRepository.queryPorductAidAppDay();
    }

    @Override
    public Integer queryPorductAidAppAttornCount() {
        return loanProductAidRepository.queryPorductAidAppAttornCount();
    }

	
	
}
