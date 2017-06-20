package com.baibao.web.p2p.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author lupeng
 * @date: 2015年12月15日下午4:18:25
 */
public interface RepaymentUtilService {
	/**
	 * 获得应还利息
	 *@param annualRate 年利率
	 *@param loanAount 借款金额
	 *@param deadline 借款期限
	 **@param num 还款月数
	 *@return Double 利息
	 * */
	public BigDecimal interest(BigDecimal annualRate, BigDecimal loanAount, int deadline, int num);
	/**
	 * 获得应还本金
	 *@param annualRate 年利率
	 *@param loanAount 借款金额
	 *@param deadline 借款期限
	 *@param num 还款月数
	 *@return Double 本金
	 * */
	public BigDecimal principal(BigDecimal annualRate, BigDecimal loanAount, int deadline, int num);
	/**
	 * 获得应还本息
	 *@param annualRate 年利率
	 *@param loanAount 借款金额
	 *@param deadline 借款期限
	 *@return Double 本息
	 * */
	public BigDecimal interAndPri(BigDecimal annualRate, BigDecimal loanAount, int deadline);
	
	/**
	 * 等额本息
	 *@param annualRate 年利率
	 *@param loanAount 借款金额
	 *@param deadline 借款期限
	 *@return Double 本息
	 * */
	public List<Map<String, Object>> getAverageCapitalPlusInterestData(BigDecimal loanAount, BigDecimal annualRate, int deadline);
	
	/**
	 * 先息后本
	 * “按月付息”还款方式，计算公式如下：
	 * 总利息 = 本金 x（年利率÷12）x 总期数；
	 * 每个月的利息 = 总利息÷总期数。
	 * @param capital 本金
	 * @param yearRate 年利率
	 * @param periodsNum 总期数
	 * @return capital 本金，interest 利息，capitalInt 本息
	 * 
	 */
	public List<Map<String, Object>> getDataFirstInterestLastCapital(BigDecimal capital, BigDecimal yearRate, Integer periodsNum);
	/**
	 * 按天计息
	 * 公式：
	 * 总利息 =本金*(年利率/365)*理财天数
	 * @param loanAount 本金
	 * @param yearRate 年利率
	 * @param periodsNum 总天数
	 * @return 本金  利息  本息
	 */
	public Map<String, Object> getInteresByDay(BigDecimal loanAount,BigDecimal yearRate, Integer periodsNum);
	
	/**
	 * 得到按天计息的计划
	 * @param loanAount
	 * @param yearRate
	 * @param periodsNum
	 * @return
	 */
	public List<Map<String, Object>> getInteresByDayPlan(BigDecimal loanAount,BigDecimal yearRate, Integer allDays);
	
	
	/**
	 * 根据按天计息的总天数获得还款期数
	 * @param allDays
	 * @return
	 */
	public Integer getTotalLoanterm(Integer allDays);
}
