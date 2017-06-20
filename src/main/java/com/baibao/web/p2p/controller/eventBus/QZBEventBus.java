
package com.baibao.web.p2p.controller.eventBus;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.EventBus;

/**
 * 自定义同步处理事件总线，管理观察者模式的组件，此对象需交由spring实例化
 * @author yangyang
 *
 */
@Component
public class QZBEventBus extends EventBus implements ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(QZBEventBus.class);

    /**
     * 手动注册订阅者
     * 
     * @param subscriber
     * @return [参数说明]
     * 
     * @return IPPJREventBus [返回类型说明]
     */
    public QZBEventBus registerSubscriber(Object subscriber) {
        register(subscriber);
        logger.debug("Register subscriber: " + subscriber.getClass().getName());
        return this;
    }

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        Map<String, Object> subscriberBeans = applicationContext
                .getBeansWithAnnotation(Subscriber.class);
        if (subscriberBeans != null) {
            for (Entry<String, Object> entry : subscriberBeans.entrySet()) {
                register(entry.getValue());
                logger.debug("Register subscriber: "
                        + entry.getValue().getClass().getName());
            }
        }
    }
}
