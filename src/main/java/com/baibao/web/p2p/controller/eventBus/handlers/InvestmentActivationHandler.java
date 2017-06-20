package com.baibao.web.p2p.controller.eventBus.handlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentActivationEvent;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 投资激活
 * @author yangyang
 *
 */
@Subscriber
@Component
public class InvestmentActivationHandler{
   private static final Logger log = LoggerFactory.getLogger(InvestmentActivationHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(InvestmentActivationEvent event){
		log.info("###############520元大红包投资激活开始###################");
		try {
			activeService.redEnvelopeActivation_520(event);
		} catch (Exception e) {
			log.error("########520元大红包投资激活逻辑异常", e);
		}
		log.info("############520元大红包投资激活逻辑结束###########");
		
	}
	
}
