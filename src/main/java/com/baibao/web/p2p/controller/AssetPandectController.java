package com.baibao.web.p2p.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.UmpayService;
import com.baibao.web.p2p.service.transRecord.TransRecordService;

/**
 * 资产总览
 * @Title: AssetPandectController.java
 * @Package com.baibao.web.p2p.controller
 * @author zhangpx
 * @date 2016年1月9日
 */
@Controller
@RequestMapping("/asset")
public class AssetPandectController{
	private static Logger logger = LoggerFactory.getLogger(AssetPandectController.class); 
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private TenderProfitService tenderProfitService;
	@Autowired
	private RepaymentBillService repaymentBillService;
	@Autowired
	private TransRecordService transRecordService;
	@Autowired
	private UmpayService umpayService;
	/**
	 * 资产总览 
	 * @return
	 */
	@RequestMapping
	public String index(Model model)
		throws BusinessException
	{	
		logger.info("index parameter : ");
		
		P2p_user user = SecurityUserHolder.getCurrentUser();
		
		P2p_cust_account custAccount =
			accountService.getCustAccountByCustNo(
				user.getPuCustNo(), true);

		BigDecimal accountBalance = custAccount.getPcaAccountBalance();

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("custNo", user.getPuCustNo());
		params.put("accountBalance", accountBalance);
		
		Map<String, Object> result =
			accountService.assetPandect(params);
		
		model.addAttribute("assetPandect", result);
		
		logger.info(String.format("index parameter : --- return : mav = %s", 
				JsonHelper.formatJson(model)));

		return "/personal/personalCenter";
	}
	
	/**
	 * 构建投资、收益曲线图数据
	 */
	@RequestMapping("/getTmentIncome")
	@ResponseBody
	private Map<String, Object> buildTenderProfitPicutreData() throws BusinessException{
		
		logger.info("buildTenderProfitPicutreData parameter : ");
		P2p_user user = SecurityUserHolder.getCurrentUser();
		Map<String, Object> result = new HashMap<String, Object>();
		List investmentAmount = null; 
		List incomeAmount = null;
		List month = null;
		String  custNo = user.getPuCustNo();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
			String end = formatter.format(new Date());
			month = DateUtils.getDatedifference("2016-02", end);
			investmentAmount = transRecordService.getInvestmentAmount(custNo,month);
			incomeAmount = tenderProfitService.getIncomeAmount(custNo, month);
			result.put("investmentAmount", investmentAmount);
			result.put("incomeAmount", incomeAmount);
			result.put("month", month);
		} catch (BusinessException e) {
			logger.error("buildTenderProfitPicutreData", e);
		}
		
		logger.info(String.format("buildTenderProfitPicutreData parameter : --- return : result = %s", 
				JsonHelper.formatJson(result)));
		return result;
	}
	
	/**
	 * 我的账户切换至旧版
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException 
	 */
	/*#RequestMapping("/switcholdaccount")*/
	public ModelAndView switchOldAccount(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		
		logger.info("switchOldAccount parameter : ");
		
		ModelAndView model = new ModelAndView("/personal/personalOldAccount");
		String custNo = SecurityUserHolder.getCustNo();
		int currentPageNo = 1;
		int pageSize = 5;
		//可用余额、冻结金额、合计充值、资产总计、合计提现 
		Map<String, Object> result = umpayService.selectCustAccount(custNo);
		//交易记录
		Paging<Map<String, Object>> paging = umpayService.getTransactionRecordPage(custNo, null, 0, null, null, currentPageNo, pageSize);
		List<Map<String, Object>> list = paging.getPageList();
		model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
		model.addObject("paging", paging);
		model.addObject("startTime", "");
		model.addObject("endTime", "");
		model.addObject("ajaxPageUrl","asset/ajaxPageTransRecord");
		model.addObject("result",result);
		
		logger.info(String.format("switchOldAccount parameter : --- return : model = %s", 
				JsonHelper.formatJson(model)));
		return model;
	}
	
	@RequestMapping("ajaxPageTransRecord")
	@ResponseBody
	public ModelAndView ajaxPageTransRecord(HttpServletRequest request,Integer currentPageNo,
			@RequestParam(value="transType",required=false) Integer transType,
			@RequestParam(value="transStatus",required=false) Integer transStatus,
			@RequestParam(value="startTime", required=false) String startTime,
			@RequestParam(value="endTime",required=false) String endTime)throws BusinessException{
		
		logger.info(String.format("ajaxPageTransRecord parameter : currentPageNo = %s,"
				+ " transType = %s, transStatus = %s, startTime = %s, endTime = %s", 
				currentPageNo, transType, transStatus, startTime, endTime));
		
		ModelAndView model = new ModelAndView("/personal/_personalOldAccountPage");
		String custNo = SecurityUserHolder.getCustNo();
		int pageSize = 5;
		//可用余额、冻结金额、合计充值、资产总计、合计提现 
		Map<String, Object> result = umpayService.selectCustAccount(custNo);
		//交易记录
		Paging<Map<String, Object>> paging = umpayService.getTransactionRecordPage(custNo, transType, transStatus, startTime, endTime, currentPageNo, pageSize);
		List<Map<String, Object>> list = paging.getPageList();
		model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
		model.addObject("paging", paging);
		model.addObject("startTime", "");
		model.addObject("endTime", "");
		model.addObject("ajaxPageUrl","asset/ajaxPageTransRecord");
		model.addObject("result",result);
		
		logger.info(String.format("ajaxPageTransRecord parameter : currentPageNo = %s,"
				+ " transType = %s, transStatus = %s, startTime = %s, endTime = %s --- return : model = %s", 
				currentPageNo, transType, transStatus, startTime, endTime, JsonHelper.formatJson(model)));
		return model;
	}
	
	
	
	/**
	 * 联动提现页面跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	/*#RequestMapping("/skipWithdrawCash")*/
	public ModelAndView skipWithdrawCash(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		
		logger.info("skipWithdrawCash parameter : ");
		
		ModelAndView model = new ModelAndView("umpay/skipWithdrawCash");
		String custNo = SecurityUserHolder.getCustNo();
		Map<String, Object> result = umpayService.getPresentPage(custNo); 
		model.addObject("result",result);
		
		logger.info(String.format("skipWithdrawCash parameter : --- return : model = %s"
				, JsonHelper.formatJson(model)));
		return model;
	}
	
	/**
	 * 联动提现
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	/*#RequestMapping("/umpayWithdrawCash")*/
	@ResponseBody
	public Map<String, Object> umpayWithdrawCash(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("withdrawalsMoney") String withdrawalsMoney) throws BusinessException{
		
		logger.info(String.format("umpayWithdrawCash parameter : withdrawalsMoney = %s"
				, withdrawalsMoney));
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(StringUtil.isEmpty(withdrawalsMoney)){
			result.put(Const.retCode, false);
			return result;
		}
		String custNo = SecurityUserHolder.getCustNo();
		result = umpayService.withdrawCash(custNo, withdrawalsMoney);
		
		logger.info(String.format("umpayWithdrawCash parameter : withdrawalsMoney = %s --- return : result = %s"
				,  JsonHelper.formatJson(result)));
		return result;
	}
	
}
