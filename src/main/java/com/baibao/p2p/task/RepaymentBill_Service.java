package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 还款账单状态
 * @Title: RepaymentBill_Service.java
 * @Package com.baibao.p2p.task
 * @author zhangh
 * @date 2016年1月20日
 */
//@Service
public class RepaymentBill_Service {

	private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 
	 @Autowired
	 private RepaymentBill_Storage storage;
	 @Autowired
	 private RepaymentBill_Producer repaymentBill_Producer;
	 @Autowired
	 private RepaymentBill_Consumer repaymentBill_Consumer;
	 
	 public void service()
	 {
		 service.execute( repaymentBill_Producer );
		 service.execute( repaymentBill_Consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		/* ExecutorService service = Executors.newFixedThreadPool( 4 );
		 RepaymentBill_Storage storage = new RepaymentBill_Storage();
		 RepaymentBill_Producer  RepaymentBill_Producer = new RepaymentBill_Producer( storage );
		 service.execute( RepaymentBill_Producer );
		 
		 RepaymentBill_Consumer  RepaymentBill_Consumer = new RepaymentBill_Consumer( storage );
		 service.execute( RepaymentBill_Consumer );*/
	 }
}
