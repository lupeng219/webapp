package com.baibao.web.p2p.controller.eventBus.handlers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.common.eventbus.Subscribe;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.InvitatRegistEvent;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 邀请注册活动订阅者
 * @author yangyang
 *
 */
@Subscriber
@Component
public class InvitatRegistHandler extends ActiveBaseHandler{
   private static final Logger log = LoggerFactory.getLogger(InvitatRegistHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(InvitatRegistEvent event){
		log.info("###############邀请注册活动入口###################");
		
		if(!checkActive(event.getActiveId()))
			return;
		
		String invitatId = event.getInvitatId();
		if(StringUtil.isEmpty(invitatId)){
			log.info("##########邀请注册活动邀请id为空，返回###########");
			return;
		}
		try {
			activeService.excutInvitatRegis(event);
		} catch (Exception e) {
			log.error("########处理邀请注册活动逻辑异常", e);
		}
		log.info("############邀请注册活动逻辑结束###########");
		
	}
	
}
