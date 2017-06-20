package com.baibao.p2p.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.generator.dao.P2p_loan_recordMapper;

//@Component
public class PaymentTrade_Producer implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(PaymentTrade_Producer.class);
	@Autowired
	private PaymentTrade_Storage storage;
	@Autowired
	private P2p_loan_recordMapper p2p_loan_recordMapper;
	
	public PaymentTrade_Producer(){}
	public PaymentTrade_Producer( PaymentTrade_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	//Thread.sleep( 300000);
            	TimeUnit.MILLISECONDS.sleep(900000);
            	if(storage.getListCount()==0){
	        		// 生产
	                producerHandler();
	        	}
                // 生产
            	/*Thread.sleep( 1200000 );
                producerHandler();*/
            }
        } catch (Exception ex) {
        	logger.error("Producer Interrupted", ex.getMessage());
        }
    }
	public void producerHandler( )
	{
		/*
		 * 查询处理中状态
		 */
		//List<P2p_loan_record> suspiciousFlowList = null;
		List<Map<String, Object>> suspiciousFlowList = new ArrayList();
		try{
			suspiciousFlowList = p2p_loan_recordMapper.querySuspiciousPaymentFlow();
		}catch(Exception e )
		{
			logger.error("producerHandler", e);
			return;
		}
		
		//P2p_loan_record record = null;
		Map<String, Object> map = null;
		for( int i = 0 ;i < suspiciousFlowList.size() ; i++ )
		{
			map = suspiciousFlowList.get( i );
			//Map<String, Object> storageMap = new HashMap<String, Object>();
			//storageMap.put(key, value);
			//map = suspiciousFlowList.get( i );
			storage.produce( map );
		}
	}
}
