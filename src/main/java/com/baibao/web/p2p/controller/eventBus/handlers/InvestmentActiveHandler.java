package com.baibao.web.p2p.controller.eventBus.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentEvent;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 投资奖励活动
 * @author yangyang
 *
 */
@Subscriber
@Component
public class InvestmentActiveHandler extends ActiveBaseHandler{
	private static final Logger log = LoggerFactory.getLogger(InvestmentActiveHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(InvestmentEvent event){
		log.info("###############投资赠送活动入口###################");
		
		if(!checkActive(event.getActiveId()))
			return;
		
		try {
			activeService.excutInvestment(event);
		} catch (Exception e) {
			log.error("########处理投资赠送活动逻辑异常", e);
		}
		log.info("############投资赠送活动逻辑结束###########");
		
	}
	
}
