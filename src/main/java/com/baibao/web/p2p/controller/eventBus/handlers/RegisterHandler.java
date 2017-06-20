package com.baibao.web.p2p.controller.eventBus.handlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.RegisterEvent;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 用户注册活动
 * @author yangyang
 *
 */
@Subscriber
@Component
public class RegisterHandler extends ActiveBaseHandler{
   private static final Logger log = LoggerFactory.getLogger(RegisterHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(RegisterEvent event){
		log.info("###############注册活动入口###################");
		
		if(!checkActive(event.getActiveId()))
			return;
		
		try {
			activeService.publicPortal(event);
		} catch (Exception e) {
			log.error("########处理邀请注册活动逻辑异常", e);
		}
		log.info("############邀请注册活动逻辑结束###########");
		
	}
	
}
