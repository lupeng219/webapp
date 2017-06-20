package com.baibao.web.p2p.controller.tender;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.core.security.web.SubmitToken;
import com.baibao.data.Response;
import com.baibao.loan.model.LoanProductAid;
import com.baibao.loan.model.TenderRecord;
import com.baibao.loan.service.TenderRecordManager;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.controller.eventBus.events.FriendsInvestmentEvent;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.CustAccountService;
import com.baibao.web.p2p.service.LoanApplyService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.service.TenderService;
import com.baibao.web.p2p.service.UserService;

/**
 * <p>版权所有：(C)2013-2018 中融佰诚</p>
 * @时间：2015-12-01
 * @描述：标的接入层
 */
@Controller
@RequestMapping("/tender")
public class TenderController
{	
	private static Logger log = LoggerFactory.getLogger(TenderController.class);

	@Autowired
	private TenderService tenderService;

	@Autowired
	private BaseLog baseLog;

	@Autowired
	private TenderRecordManager tenderRecordManager;
	
	@Autowired
	private CustAccountService custAccountService;
	
	/**
	 * 执行债转
	 */
	@ResponseBody
	@RequestMapping("/assignation.do")
	public Response<LoanProductAid>
		assignation(String tenderFlowNo, String password)
	{
		Response<LoanProductAid> response =
			new Response<LoanProductAid>();

		String custNo = SecurityUserHolder.getCustNo();

		P2p_cust_account account =
			custAccountService.queryIdentityId(custNo);

		if (!account.getPcaPayPassword().equals(password))
        {
			response.setRetCode(401);
			response.setRetMsg("交易密码不正确");

			return response;
        }

		TenderRecord tenderRecord =
			tenderRecordManager.get(tenderFlowNo);
		if (tenderRecord == null ||
			!custNo.equals(tenderRecord.getCustNo()))
		{
			response.setRetCode(404);
			response.setRetMsg("没有找到指定投资记录");

			return response;
		}

		try
		{
			LoanProductAid aid =
				tenderRecordManager.creditTrans(tenderFlowNo);

			response.setResult(aid);
		} catch(Exception e)
		{
			response.setRetCode(500);
			response.setRetMsg(e.getMessage());
		}

		return response;
	}
	
	/**
	 * 检查投标
	 * @param request
	 * @return
	 */
	@SubmitToken(setToken=true)
	@RequestMapping("/checkTender")
	public @ResponseBody Map<String, Object> checkAccountProtocol(
		HttpServletRequest request,
		@RequestParam(value = "productNo") String productNo,
		@RequestParam("loanAmount") BigDecimal loanAmount,
		@RequestParam(value = "_TOKEN_SESSION", required = false) String _TOKEN_SESSION)
	{
		log.info(String.format(
			"checkAccountProtocol parameter : productNo = %s, loanAmount = %s, _TOKEN_SESSION = %s", 
			productNo, loanAmount, _TOKEN_SESSION));

		Map<String, Object> map = new HashMap<String, Object>();

		try
		{
			String custNo = SecurityUserHolder.getCustNo();
			map = tenderService.checkTender(
				request, custNo, productNo, loanAmount, _TOKEN_SESSION);
		} catch(Exception e)
		{
			//系统异常，请稍后再试
			map.put("success", false);
			map.put("retMsg",
				"系统异常，请稍后再试");
			log.error("checkAccountProtocol", e);
		}
		
		log.info(String.format(
			"checkAccountProtocol parameter : productNo = %s, loanAmount = %s, _TOKEN_SESSION = %s --- return : map = %s", 
			productNo, loanAmount, _TOKEN_SESSION,
			JsonHelper.formatJson(map)));
		
		return map;
	}
	
	/**
	 * 投标
	 * @param productNo
	 * @param loanAmount
	 * @param _TOKEN_SESSION
	 * @return
	 */
	@SubmitToken(checkToken=true)
	@RequestMapping("/sureTender")
	public @ResponseBody Map<String, Object> sureAccountProtocol(
		@RequestParam(value = "password") String password,
		@RequestParam(value = "productNo") String productNo,
		@RequestParam("loanAmount") BigDecimal loanAmount,
		@RequestParam(value = "inviteCode",required = false ) String inviteCode,
		@RequestParam(value="channel",required=false) String channel,
		@RequestParam(value = "_TOKEN_SESSION",required=false) String _TOKEN_SESSION)
	{	
		log.info(String.format("sureAccountProtocol parameter : password = %s, productNo = %s,loanAmount = %s, channel = %s, _TOKEN_SESSION = %s", 
			password, productNo,loanAmount, channel,_TOKEN_SESSION));

		Map<String, Object> map =  new HashMap<String, Object>();

		try
		{
			String custNo = SecurityUserHolder.getCustNo();
			map = tenderService.tender(
				custNo, productNo, loanAmount,
				_TOKEN_SESSION, channel, password,inviteCode);
			baseLog.writer(custNo, "",
				map.toString(),
				BusinessType.TENDER.getDesc(),
				RegistType.PC.getName(),
				"/tender/sureTender");
		} catch (Exception e) {
			log.error("sureAccountProtocol", e);
			map.put("success", false);
			map.put("retMsg", "系统异常，请稍后再试");
		}

		log.info(String.format("sureAccountProtocol parameter : password = %s, productNo = %s,loanAmount = %s, channel = %s, _TOKEN_SESSION = %s --- return : map = %s", 
			password, productNo,loanAmount, channel,
			_TOKEN_SESSION, JsonHelper.formatJson(map)));	
		
		return map;
	}
}
