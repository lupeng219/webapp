package com.baibao.p2p.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.baibao.p2p.task.Account_Service;

//@Component
public class taskConfigListener
	implements ApplicationListener<ContextRefreshedEvent>
{	
	@Autowired
	private Account_Service account_Service;
	@Autowired
	private PaymentTrade_Service paymentTrade_Service;
	@Autowired
	private RepaymentDetailsTrade_Service repaymentDetailsTrade_Service;
	@Autowired
	private RepaymentTrade_Service repaymentTrade_Service;
	@Autowired
	private TenderTrade_Service tenderTrade_Service;
	@Autowired
	private RepaymentBill_Service repaymentBill_Service;
	@Autowired
	private OrdinaryTrans_Service ordinaryTrans_Service;
	@Autowired
	private OrdinaryTransAid_Service ordinaryTransAid_Service;
	@Autowired
	private ActivebB2cTrans_Service activebB2cTrans_Service;
	@Autowired
	private ActivebB2cTransAid_Service activebB2cTransAid_Service;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event)
	{
		if (event.getApplicationContext().getParent() == null)
		{
			account_Service.service(); //充值、提现跑批
			paymentTrade_Service.service(); //结标跑批
			repaymentDetailsTrade_Service.service(); //还款代付跑批
			repaymentTrade_Service.service(); //还款待收跑批
			tenderTrade_Service.service(); //投资跑批
			repaymentBill_Service.service(); //还款账单状态跑批
		}
	}
}