package com.baibao.p2p.task;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.service.StatisticalService;

/**
 * ip统计来源作业消费者
 * @author yangyang
 *
 */
//@Component
public class IpStatistical_Consumer implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(IpStatistical_Consumer.class);
	@Autowired
	private StatisticalService statisticalService;
	
	@Autowired
	private IpStatistical_Storage storage;
	
	public IpStatistical_Consumer() {
    }
	
	public IpStatistical_Consumer(IpStatistical_Storage storage) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	//TimeUnit.MILLISECONDS.sleep(500);//正式环境去掉，因为联调环境调用频率1s3次
            	consumerHandler( );
            }
        } catch (Exception ex) {
        	
        	logger.error( "Consumer Interrupted", ex);
        }
    }
	
	public void consumerHandler()
	{
		
    	Map<String, Object> consumeMap = storage.consume();
    	String ip = (String) consumeMap.get( "ip" );
    	statisticalService.updateIpInfo(ip);
    	
	}
	
}
