package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 充值、提现跑批
 * @Title: Account_Service.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月18日
 */
//@Service
public class Account_Service {

	 private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 @Autowired
	 private Account_Storage storage;
	 @Autowired
	 private Account_Producer account_Producer;
	 @Autowired
	 private Account_Consumer account_consumer ;
	 
	 public void service()
	 {
		 service.execute( account_Producer );
		 service.execute( account_consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		 ExecutorService service = Executors.newFixedThreadPool( 4 );
		 Account_Storage storage = new Account_Storage();
		 Account_Producer  account_Producer = new Account_Producer( storage );
		 service.execute( account_Producer );
		 
		 Account_Consumer  account_consumer = new Account_Consumer( storage );
		 service.execute( account_consumer );
	 }
}
