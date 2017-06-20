package com.baibao.p2p.task;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baibao.core.cache.LoadSystemConfigServlet;

/**
 * 还款代收作业仓库
 * @author bbjf
 *
 */
//@Component
public class RepaymentTrade_Storage {
	private static Logger logger = LoggerFactory.getLogger(RepaymentTrade_Storage.class); 
	
	// 仓库最大容量
    private final int MAX_SIZE = 100;  
    // 仓库列表
    private LinkedBlockingQueue<Map<String, Object>> list = new LinkedBlockingQueue<Map<String, Object>>(MAX_SIZE);  
    
    // 生产
    public void produce( Map<String, Object> map )  
    {  
        // 如果仓库剩余容量为0  
        if ( list.size() == MAX_SIZE )  
        {  
            System.out.println("[库存量]:" + MAX_SIZE + "已满/t暂时不能执行生产任务!");  
        }  
        try  
        {  
              // 放入产品，自动阻塞  
              list.put( map );  
        }  
        catch (InterruptedException e)  
        {  
              logger.error("produce", e);  
        }  
        System.out.println("[库存量]:" + list.size());  
    }  
  
    // 消费产品  
    public Map<String, Object> consume( )  
    {  
        // 如果仓库存储量不足  
        if (list.size() == 0)  
        {  
            System.out.println("[库存量]:0/t暂时不能执行消费任务!");  
        }  
        // 消费条件满足情况下，消费num个产品  
        try  
        {
             // 消费产品，自动阻塞  
             return list.take();  
        }  
        catch (InterruptedException e)  
        {  
             logger.error("consume", e);  
        }  
        return null;
    }

	public int getListCount() {
		return list.size();
	}  
}
