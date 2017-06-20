package com.baibao.web.p2p.controller.eventBus;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 事件执行器
 * 
 * @author liuchangyan
 */
public class EventExecutor extends ThreadPoolExecutor {

    // 默认参数
    public static final int DEFAULT_CORE_POOL_SIZE = 10;
    public static final int DEFAULT_MAX_POOL_SIZE = 50;
    public static final int DEFAULT_KEEP_ALIVE_TIME = 30;
    public static final int DEFAULT_WORK_QUEUE_SIZE = 50;

    public EventExecutor() {
        super(DEFAULT_CORE_POOL_SIZE, DEFAULT_MAX_POOL_SIZE,
                DEFAULT_KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(DEFAULT_WORK_QUEUE_SIZE));
    }

    public EventExecutor(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, int workQueueSize) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(workQueueSize));
    }

}
