package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 还款代付
 * @Title: RepaymentDetailsTrade_Service.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月18日
 */
//@Service
public class OrdinaryTrans_Service {

	private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 
	 @Autowired
	 private OrdinaryTrans_Storage storage;
	 @Autowired
	 private OrdinaryTrans_Producer ordinaryTrans_Producer;
	 @Autowired
	 private OrdinaryTrans_Consumer ordinaryTrans_Consumer;
	 
	 public void service()
	 {
		 service.execute( ordinaryTrans_Producer );
		 service.execute( ordinaryTrans_Consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		 ExecutorService service = Executors.newFixedThreadPool( 4 );
		 RepaymentDetailsTrade_Storage storage = new RepaymentDetailsTrade_Storage();
		 RepaymentDetailsTrade_Producer  repaymentDetailsTrade_Producer = new RepaymentDetailsTrade_Producer( storage );
		 service.execute( repaymentDetailsTrade_Producer );
		 
		 RepaymentDetailsTrade_Consumer  repaymentDetailsTrade_Consumer = new RepaymentDetailsTrade_Consumer( storage );
		 service.execute( repaymentDetailsTrade_Consumer );
	 }
}
