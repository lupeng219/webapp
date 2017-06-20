package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baibao.web.p2p.comm.Arith;
import com.baibao.web.p2p.service.RepaymentUtilService;

/**
 * @author lupeng
 * @date: 2015年12月15日下午4:19:11
 */
@Service("repaymentUtilService")
public class RepaymentUtilServiceImpl implements RepaymentUtilService {
	
	//按天计息已30天为一期
	private static Integer days = 30;
	
	@Override
	public BigDecimal interest(BigDecimal annualRate, BigDecimal loanAount,
			int deadline, int num) {
		
		return null;
	}

	@Override
	public BigDecimal principal(BigDecimal annualRate, BigDecimal loanAount,
			int deadline, int num) {
		BigDecimal d1 = Arith.mul(loanAount, Arith.div(annualRate, BigDecimal.valueOf(12), 6));
		BigDecimal d2 = Arith.add(BigDecimal.valueOf(1), Arith.div(annualRate, BigDecimal.valueOf(12), 6)).pow(num-1);
		BigDecimal d3 = Arith.mul(d1, d2);
		BigDecimal d4 = Arith.add(BigDecimal.valueOf(1), Arith.div(annualRate, BigDecimal.valueOf(12), 6)).pow(deadline);
		BigDecimal d5 = Arith.sub(d4, BigDecimal.valueOf(1));
		BigDecimal capital = d3.divide(d5,2,BigDecimal.ROUND_HALF_UP);
		return capital;
	}

	/**
	 * 按月分期还款:分期还款采用的是通用的"等额本息还款法"，即借款人每月以相等的金额偿还贷款本息。 
	 * 这里要注意区分 等额本息还款法和等额本金还款法
	 * 本息保留两位四舍五入
	 * */
	@Override
	public BigDecimal interAndPri(BigDecimal annualRate, BigDecimal loanAount,
			int deadline) {
		/**
		 * 获取每期还款的本息总额
		 * 每月还款额（本s息） =〔贷款本金×月利率×(1＋月利率)＾还款月数〕÷〔(1＋月利率)＾还款月数-1〕
		 * @param capital 借款本金
		 * @param yearRate 年利率
		 * @param periodsNum 总期数
		 * @return 返回本息总额
		 */
		BigDecimal monthRate = Arith.div(annualRate, BigDecimal.valueOf(12), 6);//计算出每月利率
		BigDecimal incrementVal = Arith.add(BigDecimal.valueOf(1), monthRate).pow(deadline);
		BigDecimal b1 = Arith.mul(Arith.mul(loanAount, monthRate), incrementVal);
		BigDecimal b2 = Arith.sub(incrementVal, BigDecimal.valueOf(1));
		BigDecimal interAndPri = b1.divide(b2,2, BigDecimal.ROUND_HALF_UP);
		return interAndPri;
	}

	@Override
	public List<Map<String, Object>> getAverageCapitalPlusInterestData(
			BigDecimal loanAount, BigDecimal annualRate, int deadline) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		RepaymentUtilService re = new RepaymentUtilServiceImpl();
		BigDecimal bx = re.interAndPri(annualRate, loanAount, deadline);
		
		for(int i=1; i<=deadline; i++){
			Map<String, Object> dataMap = new HashMap<String, Object>();
			//设置期数
			dataMap.put("periodsNum", i);
			//设置还款本息
			dataMap.put("capitalInt", bx);
			//设置还款本金
			dataMap.put("capital", re.principal(annualRate, loanAount, deadline, i));
			//设置还款利息
			BigDecimal lx = bx.subtract(re.principal(annualRate, loanAount, deadline, i));
			dataMap.put("interest", lx);
			dataList.add(dataMap);
		}
		return dataList;
	}
	@Override
	public Map<String, Object> getInteresByDay(BigDecimal loanAount,
			BigDecimal yearRate, Integer periodsNum) {
		Map<String, Object>map = new HashMap<String, Object>();
		
		BigDecimal totalInterest =Arith.mul(Arith.mul(loanAount, Arith.div(yearRate, BigDecimal.valueOf(365))),new BigDecimal(periodsNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
		map.put("interest",totalInterest );
		map.put("capital",loanAount );
		map.put("capitalInt", Arith.add(loanAount,totalInterest) );
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getDataFirstInterestLastCapital(
			BigDecimal capital, BigDecimal yearRate, Integer periodsNum) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		System.out.println("RepaymentUtilServiceImpl"+capital+"*****"+yearRate+"***"+periodsNum+"*");
		System.out.println("RepaymentUtilServiceImpl**"+periodsNum+"*****");
		BigDecimal totalInterest = Arith.mul(capital, Arith.div(yearRate,BigDecimal.valueOf(12))).setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println("RepaymentUtilServiceImpl***");
		System.out.println("RepaymentUtilServiceImpl*");
		for(int i=1; i<=periodsNum; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			//期数
			map.put("periodsNum", i);
			if(i==periodsNum){
				//本金
				map.put("capital", capital);
				//利息
				map.put("interest", totalInterest);
				//本息
				map.put("capitalInt", Arith.add(capital,totalInterest));
			}else{
				//本金
				map.put("capital", BigDecimal.valueOf(0.0));
				//利息
				map.put("interest",totalInterest);
				//本息
				map.put("capitalInt", totalInterest);
			}
			
			dataList.add(map);
		}
		return dataList;
	}
	
	public static List<Map<String, Object>> getDataF(
			BigDecimal capital, BigDecimal yearRate, Integer periodsNum) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		System.out.println("RepaymentUtilServiceImpl"+capital+"*****"+yearRate+"****");
		System.out.println("RepaymentUtilServiceImpl*");
		BigDecimal totalInterest = Arith.mul(capital, Arith.div(yearRate,BigDecimal.valueOf(12))).setScale(2,BigDecimal.ROUND_HALF_UP);
		System.out.println("RepaymentUtilServiceImpl***");
		System.out.println("RepaymentUtilServiceImpl*");
		for(int i=1; i<=periodsNum; i++){
			Map<String, Object> map = new HashMap<String, Object>();
			//期数
			map.put("periodsNum", i);
			if(i==periodsNum){
				//本金
				map.put("capital", capital);
				//利息
				map.put("interest", totalInterest);
				//本息
				map.put("capitalInt", Arith.add(capital,totalInterest));
			}else{
				//本金
				map.put("capital", BigDecimal.valueOf(0.0));
				//利息
				map.put("interest",totalInterest);
				//本息
				map.put("capitalInt", totalInterest);
			}
			
			dataList.add(map);
		}
		return dataList;
	}
	public static Map<String, Object> getInteresByDays(BigDecimal loanAount,
			BigDecimal yearRate, Integer periodsNum) {
		Map<String, Object>map = new HashMap<String, Object>();
		
		BigDecimal totalInterest =Arith.mul(Arith.mul(loanAount, Arith.div(yearRate, BigDecimal.valueOf(365))),new BigDecimal(periodsNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
		map.put("totalInterest",totalInterest );
		return map;
	}
	public static void main(String agrs[])
	{
		Map<String, Object> a = getInteresByDays(BigDecimal.valueOf(100), BigDecimal.valueOf(0.1), 7);
		System.err.println(a);
//		List<Map<String, Object>> dataList = getDataF(BigDecimal.valueOf(100),BigDecimal.valueOf(0),3);
//		for(Map<String, Object> map: dataList){
//			Integer periodsNum = (Integer)map.get("periodsNum");
//			BigDecimal capitalInt = (BigDecimal)map.get("capitalInt");
//			BigDecimal capital = (BigDecimal)map.get("capital");
//			BigDecimal interest = (BigDecimal)map.get("interest");
////			/System.out.println(periodsNum+", "+capitalInt+", "+capital+", "+interest);
//			System.out.println("第"+periodsNum+"期"+","+"本息:"+capitalInt+","+"本金:"+capital+","+"利息:"+interest);
//		}
	}

	@Override
	public List<Map<String, Object>> getInteresByDayPlan(BigDecimal loanAount,
			BigDecimal yearRate, Integer allDays) {
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
		//最后一期天数
		Integer lastPeriodOfDays = 0;
		//1.通过总的天数，以30天为一期算出总的期数
		Integer loanTerm =  allDays % days == 0 ? allDays / days : allDays / days + 1;
		//2.根据期数算出每一期的收益利息，通过天数来计算
		//如果只有一期,期数就是总的天数
		if(loanTerm==1){
			Map<String, Object> map = new HashMap<String, Object>();
			BigDecimal totalInterest =Arith.mul(Arith.mul(loanAount, Arith.div(yearRate, BigDecimal.valueOf(365))),new BigDecimal(allDays)).setScale(2,BigDecimal.ROUND_HALF_UP);
			//期数
			map.put("periodsNum", 1);
			//本金
			map.put("capital", loanAount);
			//利息
			map.put("interest", totalInterest);
			//本息
			map.put("capitalInt", Arith.add(loanAount,totalInterest));
			//总期数
			map.put("loanTerm", loanTerm);
			//添加list
			dataList.add(map);
			
		}else{
			for(int i=1; i<=loanTerm; i++){
				Map<String, Object> map = new HashMap<String, Object>();
				//当前期数
				map.put("periodsNum", i);
				//最后一期
				if(i==loanTerm){
					lastPeriodOfDays = allDays-((loanTerm-1)*days);
					BigDecimal totalInterest =Arith.mul(Arith.mul(loanAount, Arith.div(yearRate, BigDecimal.valueOf(365))),new BigDecimal(lastPeriodOfDays)).setScale(2,BigDecimal.ROUND_HALF_UP);
					//本金
					map.put("capital", loanAount);
					//利息
					map.put("interest", totalInterest);
					//本息
					map.put("capitalInt", Arith.add(loanAount,totalInterest));
				}else{
					BigDecimal totalInterest =Arith.mul(Arith.mul(loanAount, Arith.div(yearRate, BigDecimal.valueOf(365))),new BigDecimal(days)).setScale(2,BigDecimal.ROUND_HALF_UP);
					//利息
					map.put("interest",totalInterest );
					//本金
					map.put("capital",loanAount );
					//本息
					map.put("capitalInt", Arith.add(loanAount,totalInterest) );
				}
				//总期数
				map.put("loanTerm", loanTerm);
				//添加list
				dataList.add(map);
			}
		}
		return dataList;
	}

	@Override
	public Integer getTotalLoanterm(Integer allDays) {
		Integer loanTerm =  allDays % days == 0 ? allDays / days : allDays / days + 1;
		return loanTerm;
	}



}
