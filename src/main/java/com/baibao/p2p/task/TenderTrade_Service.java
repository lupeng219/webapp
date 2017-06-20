package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 投资跑批
 * @Title: TenderTrade_Service.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月19日
 */
//@Service
public class TenderTrade_Service {

	 private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 @Autowired
	 private TenderTrade_Storage storage;
	 @Autowired
	 private TenderTrade_Producer tenderTrade_Producer;
	 @Autowired
	 private TenderTrade_Consumer tenderTrade_Consumer;
	 
	 public void service()
	 {
		 service.execute( tenderTrade_Producer );
		 service.execute( tenderTrade_Consumer );
	 }
	 
	 public static void main(String agrs[])
	 {
		 ExecutorService service = Executors.newFixedThreadPool( 4 );
		 TenderTrade_Storage storage = new TenderTrade_Storage();
		 TenderTrade_Producer  tenderTrade_Producer = new TenderTrade_Producer( storage );
		 service.execute( tenderTrade_Producer );
		 
		 TenderTrade_Consumer  tenderTrade_Consumer = new TenderTrade_Consumer( storage );
		 service.execute( tenderTrade_Consumer );
	 }
}
