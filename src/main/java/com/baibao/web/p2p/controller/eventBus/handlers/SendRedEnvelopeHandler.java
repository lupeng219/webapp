package com.baibao.web.p2p.controller.eventBus.handlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.SendRedEnvelopeEvent;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 登录送520元投资红包
 * @author yangyang
 *
 */
@Subscriber
@Component
public class SendRedEnvelopeHandler extends ActiveBaseHandler{
   private static final Logger log = LoggerFactory.getLogger(SendRedEnvelopeHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(SendRedEnvelopeEvent event){
		log.info("###############520元大红包活动代码开始###################");
		
		if(!checkActive(event.getActiveId()))
			return;
		
		try {
			activeService.sendRedEnvelope_520(event);
		} catch (Exception e) {
			log.error("########处520元大红包活动逻辑异常", e);
		}
		log.info("############520元大红包活动逻辑结束###########");
		
	}
	
}
