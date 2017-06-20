package com.baibao.web.p2p.service;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;

/**
 * <p>版权所有：(C)2013-2018 中融佰诚</p>
 * @时间：2015-12-01
 * @描述：投标记录业务层接口
 */
public interface TenderService
{	
	/**
	 * 投标
	 * @throws RuntimeException
	 */
	public Map<String, Object>
		tender(String custNo, String ppProductNo, BigDecimal loanAmount,
			String _TOKEN_SESSION, String channel, String password,String inviteCode);
	
	public Map<String, Object> tenderHandler(
		String custNo, String ppProductNo, BigDecimal loanAmount,
		String channel, String password,String inviteCode)
			throws BusinessException;
	
	/**
	 * 投标验证
	 * @throws RuntimeException
	 */
	public Map<String, Object>
		checkTender(HttpServletRequest request, String custNo,
			String ppProductNo, BigDecimal loanAmount, String _TOKEN_SESSION);
	
	/**
	 * 查询全网累计投资总额
	 * @return
	 */
	public BigDecimal getAllTenderAmount();
	
	/**
	 * 全网累计交易笔数(标的数量)
	 * @return
	 */
	public int getAllProductCount();
	
	/**
	 * 查询平台逾期总数
	 */
	public int queryOverDueTotal();
	
	/**
	 * 查询平台投资总人数
	 */	
	public int queryTenderPeopleTotal();

	/**
	 * 查询某标的投资个数
	 * @param map
	 * @return
	 */
	public int selectTotalByPorductNo(Map<String,Object> map);
	
	/*
	 * 债权转让
	 * 
	 * @param tenderFlowNo 投资id
	 */
	public boolean creditTrans(String tenderFlowNo);
}
