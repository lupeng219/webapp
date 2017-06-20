package com.baibao.p2p.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class IpStatistical_Service {

	 private final ExecutorService service = Executors.newFixedThreadPool( 4 );
	 @Autowired
	 private IpStatistical_Storage storage;
	 @Autowired
	 private IpStatistical_Producer ipStatistical_Producer;
	 @Autowired
	 private IpStatistical_Consumer ipStatistical_consumer ;
	 
	 public void service()
	 {
		 service.execute( ipStatistical_Producer );
		 service.execute( ipStatistical_consumer );
	 }
	 
}
