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
public class OrdinaryTransAid_Service {

	 private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 @Autowired
	 private OrdinaryTransAid_Storage storage ;
	 @Autowired
	 private OrdinaryTransAid_Producer ordinaryTransAid_Producer;
	 @Autowired
	 private OrdinaryTransAid_Consumer ordinaryTransAid_Consumer;
	 
	 public void service()
	 {
		 service.execute( ordinaryTransAid_Producer );
		 service.execute( ordinaryTransAid_Consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		 ExecutorService service = Executors.newFixedThreadPool( 4 );
		 OrdinaryTransAid_Storage storage = new OrdinaryTransAid_Storage();
		 OrdinaryTransAid_Producer  account_Producer = new OrdinaryTransAid_Producer( storage );
		 service.execute( account_Producer );
		 
		 OrdinaryTransAid_Consumer  account_consumer = new OrdinaryTransAid_Consumer( storage );
		 service.execute( account_consumer );
	 }
}
