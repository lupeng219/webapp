
package com.baibao.web.p2p.controller.eventBus;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.SubscriberExceptionHandler;

/**
 * 自定义异步处理事件总线，管理观察者模式的组件，此对象需交由spring实例化
 * 
 * @author yangyang
 *
 */
@Component
public class QZBAsyncEventBus extends AsyncEventBus implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(QZBAsyncEventBus.class);

    private static final String QZB_ASYNC_ENVENT_BUS_IDENTIFIER = "qzb_async_event_bus";

    /**
     * 手动注册订阅者,当不使用注解定义订阅者时，此方法有效。
     * 
     * @param subscriber
     * @return [参数说明]
     * 
     * @return IPPJREventBus [返回类型说明]
     */
    public QZBAsyncEventBus registerSubscriber(Object subscriber)
    {
        register(subscriber);
        logger.debug("Register subscriber: " + subscriber.getClass().getName());
        return this;
    }

    public QZBAsyncEventBus()
    {
        super(QZB_ASYNC_ENVENT_BUS_IDENTIFIER, new EventExecutor());
    }

    public QZBAsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler)
    {
        super(executor, subscriberExceptionHandler);
    }

    public QZBAsyncEventBus(Executor executor)
    {
        super(executor);
    }

    public QZBAsyncEventBus(String identifier, Executor executor)
    {
        super(identifier, executor);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        Map<String, Object> subscriberBeans = applicationContext.getBeansWithAnnotation(Subscriber.class);
        if (subscriberBeans != null)
        {
            for (Entry<String, Object> entry : subscriberBeans.entrySet())
            {
                register(entry.getValue());
                logger.debug("Register subscriber: " + entry.getValue().getClass().getName());
            }
        }
    }
}
