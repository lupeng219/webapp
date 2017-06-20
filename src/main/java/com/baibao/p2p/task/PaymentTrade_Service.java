package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 结标跑批
 * @Title: PaymentTrade_Service.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月18日
 */
//@Service
public class PaymentTrade_Service {

	private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	@Autowired
	private PaymentTrade_Storage storage;
	@Autowired
	private PaymentTrade_Producer paymentTrade_Producer;
	@Autowired
	private PaymentTrade_Consumer paymentTrade_Consumer;
	 
	 public void service()
	 {
		 service.execute( paymentTrade_Producer );
		 service.execute( paymentTrade_Consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		 ExecutorService service = Executors.newFixedThreadPool( 4 );
		 PaymentTrade_Storage storage = new PaymentTrade_Storage();
		 PaymentTrade_Producer  tenderTrade_Producer = new PaymentTrade_Producer( storage );
		 service.execute( tenderTrade_Producer );
		 
		 PaymentTrade_Consumer  tenderTrade_Consumer = new PaymentTrade_Consumer( storage );
		 service.execute( tenderTrade_Consumer );
	 }
}
