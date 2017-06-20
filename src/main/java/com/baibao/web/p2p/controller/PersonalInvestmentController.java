package com.baibao.web.p2p.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.ebaoquan.EbaoquanUtils;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.service.AgreementService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.TenderProfitService;

/**
 * 我的理财
 * @Title: PersonalInvestmentController.java
 * @Package com.baibao.web.p2p.controller
 * @author zhangx
 * @date 2016年1月28日
 */
@Controller
@RequestMapping("/personalInvestment")
public class PersonalInvestmentController
{
	private static Logger logger =
		LoggerFactory.getLogger(PersonalInvestmentController.class); 
	
	@Autowired
	private TenderProfitService tenderProfitService;
	@Autowired
	private LoanProductAidService loanProductAidService;
	@Autowired
	private AgreementService agreementService;
	@Autowired
	private EbaoquanUtils ebaoquanUtils;
	
	private List<P2p_loan_product_aid>
		checkIsTransfer(List<P2p_loan_product_aid> products)
	{
		// 判断剩余期数、返利时间 start
		for (P2p_loan_product_aid loanProduct : products)
		{
			loanProduct.setIsTransfer(0);

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("productNo", loanProduct.getPpProductno());
			map.put("tenderFlowNo", loanProduct.getPtp_tenderFlowNo());
			map.put("profitStatus",
				RepaymentBillStatus.NOREPAYMETN.getIndex());

			List<P2p_tender_profit> tenderProfitList =
				tenderProfitService.getTenderProfitByProductNo(map);
			if (CollectionUtils.isNotEmpty(tenderProfitList))
			{
				int days =
					Utils.betweenDays(
						tenderProfitList.get(0).getPtpProfittime(), Utils.today());
				
				if (days > 7 && tenderProfitList.size() > 1)
				{
					loanProduct.setIsTransfer(1);
				}
			}
		}
		// 判断剩余期数、返利时间 end
		
		return products;
	}
	
	/**
	 * 我的理财主页
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping
	public String myInvestment(HttpServletRequest request, Model model)
		throws BusinessException
	{
		logger.info(String.format("myInvestment parameter : "
			+ "model = %s", 
			JsonHelper.formatJson(model)));
		
		String custNo = SecurityUserHolder.getCustNo();
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("custNo", custNo);
		
		Map<String, Object> result =
			tenderProfitService.getCustWaitdayInterest(params);
		
		//查询用户当前正在投资金额
		BigDecimal investTotal = tenderProfitService.getPtrAmount(custNo);
		
		investTotal = (investTotal == null)? new BigDecimal(0): investTotal;

		model.addAttribute("dayWaitInterest",
			(result.get("dayWaitInterest") == null?
				new BigDecimal(0):
				result.get("dayWaitInterest")));//今日收益
		model.addAttribute("monthTotalInterest",
			(result.get("monthTotalInterest") == null?
				new BigDecimal(0):
				result.get("monthTotalInterest")));//本月收益
		model.addAttribute("totalIncome",
			(result.get("totalIncome") == null?
				new BigDecimal(0):
				result.get("totalIncome")));//累计收益
		model.addAttribute("monthPrincipal",
			(result.get("monthPrincipal") == null?
				new BigDecimal(0):
				result.get("monthPrincipal")));//本月到期
		model.addAttribute("financingAmount",
			(result.get("financingAmount") == null?
				new BigDecimal(0).add(investTotal):
				new BigDecimal(
					result.get("financingAmount").toString())
						.add(investTotal)));//冻结金额
		model.addAttribute("monthMatureCount",
			(result.get("monthMatureCount") == null?
				0: result.get("monthMatureCount")));//共**笔
		
		/** 我的投资记录 **/
		Paging<P2p_loan_product_aid> page =
			loanProductAidService.queryTenderRecordByCust(
				custNo, null, 1, 5, null, null);

		List<P2p_loan_product_aid> list =
			checkIsTransfer(page.getPageList());
		
		model.addAttribute("total",
			(list != null && list.size() > 0)? list.size(): 0);
		model.addAttribute("paging", page);
		model.addAttribute("ajaxPageUrl",
			"personalInvestment/ajaxPagetenderRecord");
		model.addAttribute("products", JsonHelper.formatJson(list));
		model.addAttribute("now",
			System.currentTimeMillis());

		logger.info(String.format("myInvestment parameter : "
			+ "model = %s --- return : model = %s", 
			JsonHelper.formatJson(model), JsonHelper.formatJson(model)));

		return "/personal/personalInvestment";
	}

	@RequestMapping("/ajaxPagetenderRecord")
	public String ajaxPageTenderRrcord(
		Integer currentPageNo, String beginTime, String endTime,
		String bulkStatus, Model model)
	{	
		logger.info(String.format("ajaxPageTenderRrcord parameter : "
			+ "currentPageNo = %s, beginTime = %s, endTime = %s, bulkStatus = %s", 
			currentPageNo, beginTime, endTime, bulkStatus));

		if ("00".equals(bulkStatus))
		{
			bulkStatus = null;
		}

		if (!StringUtil.isEmpty(beginTime))
		{
			beginTime = beginTime + " 00:00:00";
		}
		
		if (!StringUtil.isEmpty(endTime))
		{
			endTime = endTime + " 23:59:59";
		}
		
		Paging<P2p_loan_product_aid> page =
			loanProductAidService.queryTenderRecordByCust(
				SecurityUserHolder.getCustNo(),
				bulkStatus, currentPageNo, 5,
				beginTime, endTime);

		model.addAttribute(
			"products", JsonHelper.formatJson(
				checkIsTransfer(page.getPageList())));
		model.addAttribute("now", System.currentTimeMillis());
		model.addAttribute("paging", page);
		model.addAttribute(
			"ajaxPageUrl", "personalInvestment/ajaxPagetenderRecord");

		logger.info(String.format("ajaxPageTenderRrcord parameter : "
			+ "currentPageNo = %s, beginTime = %s, endTime = %s, bulkStatus = %s --- return : mav = %s", 
			currentPageNo, beginTime, endTime, bulkStatus, JsonHelper.formatJson(model)));

		return "/personal/_tenderRecords";
	}

	/**
	 * 查询投资收益
	 * @param tenderflowNo 投资单号
	 * @return
	 */
	@RequestMapping("/ajaxGetTenderProitRecord")
	public @ResponseBody List<P2p_tender_profit>
		ajaxGetTenderProitRrcord(String tenderflowNo)
	{
			
		logger.info(String.format("ajaxGetTenderProitRrcord parameter : "
				+ "tenderflowNo = %s", 
				tenderflowNo));
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("tenderFlowNo", tenderflowNo);

		List<P2p_tender_profit> tenderpritlist =
			tenderProfitService.findTenderProfitListByTenderFlowNo(map);
		
		logger.info(String.format("ajaxGetTenderProitRrcord parameter : "
				+ "tenderflowNo = %s --- return : tenderpritlist = %s", 
				tenderflowNo, JsonHelper.formatJson(tenderpritlist)));
		return tenderpritlist;
	}
}
