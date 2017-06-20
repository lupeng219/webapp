package com.baibao.p2p.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.service.AccountService;

//@Component
public class Account_Producer implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(Account_Consumer.class);
	@Autowired
	private Account_Storage storage;
	
	@Autowired
	private AccountService accountService;
	
	public Account_Producer(){}
	
	public Account_Producer( Account_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
        	  while (true) {
        		TimeUnit.MILLISECONDS.sleep(900000);
	        	if(storage.getListCount()==0){
	        		// 生产
	                producerHandler();
	        	}
        	  }
          /* while (true) {
                // 生产
            	Thread.sleep( 1200000 );
                producerHandler();
            }*/
        } catch (Exception ex) {
        	logger.error("Producer Interrupted", ex);
        }
    }
	public void producerHandler()
	{
		/*
		 * 查询处理中状态
		 */
		List<Map<String, Object>> suspiciousFlowList = new ArrayList();
		try{
			suspiciousFlowList = accountService.querySuspiciousFlow();
		}catch(Exception e )
		{
			logger.error("producerHandler", e);
			return;
		}
		
		Map<String, Object> map = null;
		for( int i = 0 ;i < suspiciousFlowList.size() ; i++ )
		{
			map = suspiciousFlowList.get( i );
			storage.produce( map );
		}
	}
}
