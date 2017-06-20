package com.baibao.web.p2p.controller.eventBus.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.FriendsInvestmentEvent;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 投资奖励活动
 * @author yangyang
 *
 */
@Subscriber
@Component
public class FriendsInvestmentHandler extends ActiveBaseHandler{
	private static final Logger log = LoggerFactory.getLogger(FriendsInvestmentHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(FriendsInvestmentEvent event){
		log.info("###############好友投资投资赠送活动入口###################");
			//验证活动是否生效、是否过期、是否存在
		if(!checkActive(event.getActiveId()))
			return;
		
		try {
			//实际操作
			activeService.excutFriendsInvestment(event);
		} catch (Exception e) {
			log.error("########处理好友投资赠送活动逻辑异常", e);
		}
		log.info("############好友投资赠送活动逻辑结束###########");
		
	}
	
}
