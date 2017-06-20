package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 还款待收
 * @Title: RepaymentTrade_Service.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月18日
 */
//@Service
public class RepaymentTrade_Service {

	 private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 @Autowired
	 private RepaymentTrade_Storage storage ;
	 @Autowired
	 private RepaymentTrade_Producer repaymentTrade_Producer;
	 @Autowired
	 private RepaymentTrade_Consumer repaymentTrade_Consumer;
	 
	 public void service()
	 {
		 service.execute( repaymentTrade_Producer );
		 service.execute( repaymentTrade_Consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		 
	 }
}
