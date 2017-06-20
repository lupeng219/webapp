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
public class ActivebB2cTrans_Service {

	private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 
	 @Autowired
	 private ActivebB2cTrans_Storage storage;
	 @Autowired
	 private ActivebB2cTrans_Producer activebB2cTrans_Producer;
	 @Autowired
	 private ActivebB2cTrans_Consumer activebB2cTrans_Consumer;
	 
	 public void service()
	 {
		 service.execute( activebB2cTrans_Producer );
		 service.execute( activebB2cTrans_Consumer );
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
