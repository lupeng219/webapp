package com.baibao.web.p2p.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.pay.PayService;
import com.baibao.pay.data.AccountInfoRequest;
import com.baibao.pay.data.AccountInfoResponse;
import com.baibao.pay.data.ActiveAccountRequest;
import com.baibao.pay.data.ActiveAccountResponse;
import com.baibao.pay.data.BalanceRequest;
import com.baibao.pay.data.BalanceResponse;
import com.baibao.pay.data.DepositRequest;
import com.baibao.pay.data.DepositResponse;
import com.baibao.pay.data.FreezeRequest;
import com.baibao.pay.data.FreezeResponse;
import com.baibao.pay.data.HostingCollectRequest;
import com.baibao.pay.data.HostingCollectResponse;
import com.baibao.pay.data.HostingPayRequest;
import com.baibao.pay.data.HostingPayResponse;
import com.baibao.pay.data.HostingRefundRequest;
import com.baibao.pay.data.HostingRefundResponse;
import com.baibao.pay.data.ModifyAccountRequest;
import com.baibao.pay.data.ModifyAccountResponse;
import com.baibao.pay.data.QueryDepositRequest;
import com.baibao.pay.data.QueryDepositResponse;
import com.baibao.pay.data.QueryDetailRequest;
import com.baibao.pay.data.QueryDetailResponse;
import com.baibao.pay.data.QueryHostingTradeRequest;
import com.baibao.pay.data.QueryHostingTradeResponse;
import com.baibao.pay.data.QueryWithdrawRequest;
import com.baibao.pay.data.QueryWithdrawResponse;
import com.baibao.pay.data.UnfreezeRequest;
import com.baibao.pay.data.UnfreezeResponse;
import com.baibao.pay.data.WithdrawRequest;
import com.baibao.pay.data.WithdrawResponse;

@RequestMapping("/test")
@Controller
public class TestController
{
	@Autowired
	protected PayService payService;

	//public ActiveAccountResponse activeAccount(ActiveAccountRequest request);
	@ResponseBody
	/*#RequestMapping("/activeAccount")*/
	public ActiveAccountResponse activeAccount(
		@RequestBody ActiveAccountRequest request)
	{
		ActiveAccountResponse response = payService.activeAccount(request);
		
		return response;
	}

	//public ModifyAccountResponse modifyAccount(ModifyAccountRequest request);
	@ResponseBody
	/*#RequestMapping("/modifyAccount")*/
	public ModifyAccountResponse modifyAccount(
		@RequestBody ModifyAccountRequest request)
	{
		ModifyAccountResponse response = payService.modifyAccount(request);
		
		return response;
	}

	//public AccountInfoResponse getAccountInfo(AccountInfoRequest request);
	@ResponseBody
	/*#RequestMapping("/getAccountInfo")*/
	public AccountInfoResponse getAccountInfo(
		@RequestBody AccountInfoRequest request)
	{
		AccountInfoResponse response = payService.getAccountInfo(request);
		
		return response;
	}

	//public BalanceResponse queryBalance(BalanceRequest request);
	@ResponseBody
	/*#RequestMapping("/queryBalance")*/
	public BalanceResponse queryBalance(
		@RequestBody BalanceRequest request)
	{
		BalanceResponse response = payService.queryBalance(request);
		
		return response;
	}
	
	//public FreezeResponse freeze(FreezeRequest request);
	@ResponseBody
	/*#RequestMapping("/freeze")*/
	public FreezeResponse freeze(
		@RequestBody FreezeRequest request)
	{
		FreezeResponse response = payService.freeze(request);
		
		return response;
	}
	
	//public UnfreezeResponse unfreeze(UnfreezeRequest request);
	@ResponseBody
	/*#RequestMapping("/unfreeze")*/
	public UnfreezeResponse unfreeze(
		@RequestBody UnfreezeRequest request)
	{
		UnfreezeResponse response = payService.unfreeze(request);
		
		return response;
	}
	
	//public HostingCollectResponse hostingCollect(HostingCollectRequest request);
	@ResponseBody
	/*#RequestMapping("/hostingCollect")*/
	public HostingCollectResponse hostingCollect(
		@RequestBody HostingCollectRequest request)
	{
		HostingCollectResponse response = payService.hostingCollect(request);
		
		return response;
	}
	
	//public HostingPayResponse hostingPay(HostingPayRequest request);
	@ResponseBody
	/*#RequestMapping("/hostingPay")*/
	public HostingPayResponse hostingPay(
		@RequestBody HostingPayRequest request)
	{
		HostingPayResponse response = payService.hostingPay(request);
		
		return response;
	}
	
	//public HostingRefundResponse hostingRefund(HostingRefundRequest request);
	@ResponseBody
	/*#RequestMapping("/hostingRefund")*/
	public HostingRefundResponse hostingRefund(
		@RequestBody HostingRefundRequest request)
	{
		HostingRefundResponse response = payService.hostingRefund(request);
		
		return response;
	}
	
	//public DepositResponse deposit(DepositRequest request);
	@ResponseBody
	/*#RequestMapping("/deposit")*/
	public DepositResponse deposit(
		@RequestBody DepositRequest request)
	{
		DepositResponse response = payService.deposit(request);
		
		return response;
	}
	
	//public DepositResponse recharge(DepositRequest request);
	@ResponseBody
	/*#RequestMapping("/recharge")*/
	public DepositResponse recharge(
		@RequestBody DepositRequest request)
	{
		DepositResponse response = payService.recharge(request);
		
		return response;
	}
	
	//public WithdrawResponse withdraw(WithdrawRequest request);
	@ResponseBody
	/*#RequestMapping("/withdraw")*/
	public WithdrawResponse withdraw(
		@RequestBody WithdrawRequest request)
	{
		WithdrawResponse response = payService.withdraw(request);
		
		return response;
	}
	
	//public QueryDepositResponse queryDeposit(QueryDepositRequest request);
	@ResponseBody
	/*#RequestMapping("/queryDeposit")*/
	public QueryDepositResponse queryDeposit(
		@RequestBody QueryDepositRequest request)
	{
		QueryDepositResponse response = payService.queryDeposit(request);
		
		return response;
	}
	
	//public QueryWithdrawResponse queryWithdraw(QueryWithdrawRequest request);
	@ResponseBody
	/*#RequestMapping("/queryWithdraw")*/
	public QueryWithdrawResponse queryWithdraw(
		@RequestBody QueryWithdrawRequest request)
	{
		QueryWithdrawResponse response = payService.queryWithdraw(request);
		
		return response;
	}
	
	//public QueryHostingTradeResponse queryHostingTrade(QueryHostingTradeRequest request);
	@ResponseBody
	/*#RequestMapping("/queryHostingTrade")*/
	public QueryHostingTradeResponse queryHostingTrade(
		@RequestBody QueryHostingTradeRequest request)
	{
		QueryHostingTradeResponse response =
			payService.queryHostingTrade(request);
		
		return response;
	}
	
	//public QueryDetailResponse queryDetail(QueryDetailRequest request);
	@ResponseBody
	/*#RequestMapping("/queryDetail")*/
	public QueryDetailResponse queryDetail(
		@RequestBody QueryDetailRequest request)
	{
		QueryDetailResponse response = payService.queryDetail(request);
		
		return response;
	}
}
