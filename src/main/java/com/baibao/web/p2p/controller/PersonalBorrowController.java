package com.baibao.web.p2p.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.security.web.SubmitToken;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.data.Response;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.dataDIC.BulkLoanStatus;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.LoanApplyService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.esotericsoftware.minlog.Log;

/**
 * 我的借款
 * @Title: PersonalBorrowController.java
 * @Package com.baibao.web.p2p.controller
 * @author zhangx
 * @date 2016年1月27日
 */
@Controller
@RequestMapping("/personalBorrow")
public class PersonalBorrowController
{
	private static Logger logger =
		LoggerFactory.getLogger(PersonalBorrowController.class); 
	
	@Autowired
	private LoanApplyService loanApplyService;
	@Autowired
	private LoanProductAidService productAidService;
	@Autowired
	private RepaymentBillService repaymentBillService;
	@Autowired
	private AccountService accountService;

	@RequestMapping
	public String index(
		HttpServletRequest request, HttpServletResponse response, Model model)
		throws BusinessException
	{
		
		logger.info(String.format("index parameter : model = %s", 
				JsonHelper.formatJson(model)));
		
		try
		{
			int currentPageNo = 1;
			int pageSize = 5;
			
			// 借款申请记录
			String custNo = SecurityUserHolder.getCustNo();

			Paging<P2p_loan_apply> loanApplicationpaging =
				loanApplyService.findLoanApplyRecordsByCust(
					custNo, null, currentPageNo, pageSize);

			model.addAttribute("loanApplicationpaging", loanApplicationpaging);
			model.addAttribute(
				"loanApplicationPageUrl", "personalBorrow/loanApplicationPageUrl");

			// 状态为“还款中”的借款记录
			Paging<P2p_loan_product_aid> repaymentInpaging =
				productAidService.findLoanProductAidPage(
					custNo, BulkLoanStatus.repaymenting.getIndex(),
					currentPageNo, pageSize);
			model.addAttribute("repaymentInpaging", repaymentInpaging);
			model.addAttribute(
				"repaymentInPageUrl", "personalBorrow/repaymentInPageUrl");

			// 状态为“已还清”的借款记录
			Paging<P2p_loan_product_aid> hasPaidOffpaging =
				productAidService.findLoanProductAidPage(
					custNo, BulkLoanStatus.completeproduct.getIndex(),
					currentPageNo, pageSize);
			
			model.addAttribute("hasPaidOffpaging", hasPaidOffpaging);
			model.addAttribute(
				"hasPaidOffPageUrl", "personalBorrow/hasPaidOffPageUrl");

			//当前账户
			P2p_cust_account account =
				accountService.getCustAccountByCustNo(custNo,false);
			//是否设置交易密码
			if (!StringUtil.isEmpty(account.getPcaPayPassword()))
			{
				model.addAttribute("isSetPcaPayPassword", 1);//已设置交易密码
			} else
			{
				model.addAttribute("isSetPcaPayPassword", 0);//未设置交易密码
			}

			//我的负债
			Map<String, Object> result = accountService.myDebt(custNo);
			model.addAttribute("myDebt",result);
		} catch(Exception e)
		{
			logger.error("index", e);
		}
		logger.info(String.format("index parameter : model = %s --- return : model = %s", 
				JsonHelper.formatJson(model), JsonHelper.formatJson(model)));
		return "/personal/personalBorrow";
	}
	//借款申请记录分页
	@RequestMapping("/loanApplicationPageUrl")
	public ModelAndView loanApplicationPageUrl(
		HttpServletRequest request, Integer currentPageNo, String bulkStatus)
	{
		
		logger.info(String.format("loanApplicationPageUrl parameter : currentPageNo = %s, bulkStatus = %s", 
				currentPageNo, bulkStatus));
		
		int pageSize = 5;

		ModelAndView mav = new ModelAndView("/personal/_borrowRecords");
		
		String custNo = SecurityUserHolder.getCustNo();
		
		Paging<P2p_loan_apply> loanApplicationpaging = new Paging<P2p_loan_apply>();

		try
		{
			loanApplicationpaging =
				loanApplyService.findLoanApplyRecordsByCust(
					custNo, bulkStatus, currentPageNo,pageSize);
		} catch(BusinessException e)
		{
			Log.error("loanApplicationPageUrl", e);
		}

		mav.addObject("loanApplicationpaging", loanApplicationpaging);
		mav.addObject("loanApplicationPageUrl",
			"personalBorrow/loanApplicationPageUrl");
		
		logger.info(String.format("loanApplicationPageUrl parameter : "
				+ "currentPageNo = %s, bulkStatus = %s, mav = %s", 
				currentPageNo, bulkStatus, JsonHelper.formatJson(mav)));
		return mav;
	}

	//还款中借款记录分页
	@RequestMapping("/repaymentInPageUrl")
	public ModelAndView repaymentInPageUrl(
		HttpServletRequest request,Integer currentPageNo)
	{
		
		logger.info(String.format("repaymentInPageUrl parameter : "
				+ "currentPageNo = %s", 
				currentPageNo));
		
		int pageSize = 5;
		ModelAndView mav = new ModelAndView("/personal/_repaymentIn");
		
		String custNo = SecurityUserHolder.getCustNo();
		
		Paging<P2p_loan_product_aid> repaymentInpaging =
			productAidService.findLoanProductAidPage(
				custNo, BulkLoanStatus.repaymenting.getIndex(),
				currentPageNo, pageSize);
		
		mav.addObject("repaymentInpaging", repaymentInpaging);
		mav.addObject("repaymentInPageUrl","personalBorrow/repaymentInPageUrl");
		
		logger.info(String.format("repaymentInPageUrl parameter : "
				+ "currentPageNo = %s --- return : mav = %s", 
				currentPageNo, JsonHelper.formatJson(mav)));
		return mav;
	}

	//已还清借款记录分页
	@RequestMapping("/hasPaidOffPageUrl")
	public ModelAndView hasPaidOffPageUrl(
		HttpServletRequest request,Integer currentPageNo)
	{
		
		logger.info(String.format("hasPaidOffPageUrl parameter : "
				+ "currentPageNo = %s", 
				currentPageNo));
		
		int pageSize = 5;

		ModelAndView mav = new ModelAndView("/personal/_hasPaidOff");
		String custNo = SecurityUserHolder.getCustNo();
		
		Paging<P2p_loan_product_aid> hasPaidOffpaging =
			productAidService.findLoanProductAidPage(
				custNo, BulkLoanStatus.completeproduct.getIndex(),
				currentPageNo, pageSize);
		
		mav.addObject("hasPaidOffpaging", hasPaidOffpaging);
		mav.addObject("hasPaidOffPageUrl","personalBorrow/hasPaidOffPageUrl");
		
		
		logger.info(String.format("hasPaidOffPageUrl parameter : "
				+ "currentPageNo = %s --- return : mav = %s", 
				currentPageNo, JsonHelper.formatJson(mav)));
		return mav;
	}
	
	//还款信息展示
	@SubmitToken(setToken=true)
	@RequestMapping("/productRepayment")
	@ResponseBody
	public Map<String, Object> productRepayment(
		HttpServletRequest request, String productNo)
			throws BusinessException
	{
		
		logger.info(String.format("productRepayment parameter : "
				+ "productNo = %s", 
				productNo));
		String sessionId =
			(String) request.getSession(false).getAttribute("_TOKEN_SESSION");

		Map<String, Object> result = new HashMap<String, Object>();
		String custNo = SecurityUserHolder.getCustNo();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("productNo", productNo);
		map.put("custNo", custNo);
		
		try
		{
			result.put("productRepaymentMap",
				repaymentBillService.getproductRepayment(map));

			result.put("sessionId", sessionId);
			result.put("retCode", true);
		} catch(Exception e)
		{
			logger.error("productRepayment", e);
		}
		logger.info(String.format("productRepayment parameter : "
				+ "productNo = %s --- return : result = %s", 
				productNo, JsonHelper.formatJson(result)));
		return result;
	}

	/**
	 * 还款
	 */
	//@ResponseBody
	//@RequestMapping("/repay")
	/*public Response repay(
		@RequestParam(value = "repaybillNos[]") String[] repaybillNos,
		String transPassword, String currentProductNo)
	{
		
		logger.info(String.format("repay parameter : "
				+ "repaybillNos = %s, transPassword = %s, currentProductNo = %s", 
				JsonHelper.formatJson(repaybillNos), transPassword, currentProductNo));
		
		Response response = new Response();

		String custNo = SecurityUserHolder.getCustNo();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("productNo", currentProductNo);
		map.put("custNo", custNo);
//		List<String> list = new ArrayList<String>();
//		Collections.addAll(list, repaybillNos);
//		list.add("0001720160713200507482290");
//		String[] arr = new String[list.size()];
//		list.toArray(arr);
		boolean b = repaymentBillService.getRepaymentBillByProduct(map, 
				repaybillNos);
		logger.error("还款日期选择:" + (b ? "正确" : "错误"));
		if (!b)
		{
			response.setRetCode(404);
			response.setRetMsg("非法操作");
			
			logger.info(String.format("repay parameter : "
					+ "repaybillNos = %s, transPassword = %s, currentProductNo = %s --- "
					+ "return : response = %s", 
					JsonHelper.formatJson(repaybillNos), transPassword, 
					currentProductNo, JsonHelper.formatJson(response)));
			return response;
		}
		try
		{
			response.setRetCode(
				repaymentBillService.repay(
					custNo, transPassword, repaybillNos));
		} catch(Exception e)
		{
			logger.error("repay", e);
			
			response.setRetCode(0);
			response.setRetMsg(e.getMessage());
		}

		logger.info(String.format("repay parameter : "
				+ "repaybillNos = %s, transPassword = %s, currentProductNo = %s --- "
				+ "return : response = %s", 
				JsonHelper.formatJson(repaybillNos), transPassword, 
				currentProductNo, JsonHelper.formatJson(response)));
		return response;
	}*/
}
