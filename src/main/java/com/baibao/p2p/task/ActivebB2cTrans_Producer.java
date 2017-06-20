package com.baibao.p2p.task;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.baibao.web.p2p.generator.dao.P2p_activityMapper;

//@Component
public class ActivebB2cTrans_Producer implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(ActivebB2cTrans_Producer.class);
	
	@Autowired
	private ActivebB2cTrans_Storage storage;
	@Autowired
	private P2p_activityMapper p2p_activityMapper;
	
	public ActivebB2cTrans_Producer(){}
	public ActivebB2cTrans_Producer( ActivebB2cTrans_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	TimeUnit.MILLISECONDS.sleep(900000);
            	if(storage.getListCount() == 0){
            		 // 生产
            		 producerHandler();
            	}
            	/*// 生产
            	Thread.sleep( 1200000 );
                producerHandler();*/
            }
        } catch (Exception ex) {
        	logger.error("Producer Interrupted", ex);
        }
    }
	public void producerHandler( )
	{
		/*
		 * 查询处理中状态
		 */
		List<Map<String, Object>> suspiciousFlowList = null;
		try{
			//TimeUnit.MILLISECONDS.sleep(2000);
			suspiciousFlowList = p2p_activityMapper.selectActiveTransByProcessing();
		}catch(Exception e )
		{
			logger.error("producerHandler", e);
			return;
		}
		
		Map<String, Object> map = null;
		for( int i = 0 ;i < suspiciousFlowList.size() ; i++ )
		{
			map = suspiciousFlowList.get(i);
			//Map<String, Object> storageMap = new HashMap<String, Object>();
			//storageMap.put(key, value);
			storage.produce( map );
		}
	}
}
