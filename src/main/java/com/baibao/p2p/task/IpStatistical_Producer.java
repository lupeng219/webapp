package com.baibao.p2p.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.service.StatisticalService;
/**
 * ip来源统计作业生产者
 * @author yangyang
 *
 */
//@Component
public class IpStatistical_Producer implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(IpStatistical_Producer.class);
	@Autowired
	private IpStatistical_Storage storage;
	
	@Autowired
	private StatisticalService statisticalService;
	
	public IpStatistical_Producer(){}
	
	public IpStatistical_Producer( IpStatistical_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
        	  while (true) {
        		TimeUnit.MILLISECONDS.sleep(600000);
	        	if(storage.getStorageSize()==0){
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
        	logger.error( "Producer Interrupted", ex.getMessage());
        }
    }
	public void producerHandler()
	{
		
		List<Map<String, Object>> ipList = new ArrayList();
		try{
			ipList = statisticalService.selectIpForDeal();
		}catch(Exception e )
		{
			logger.error("producerHandler", e);
			return;
		}
		
		Map<String, Object> map = null;
		for( int i = 0 ;i < ipList.size() ; i++ )
		{
			map = ipList.get( i );
			storage.produce( map );
		}
	}
}
