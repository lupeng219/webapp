package com.baibao.web.p2p.controller.eventBus.handlers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.repository.MsgRepository;

/**
 * 站内信事件处理类
 * @author yangyang
 *
 */
@Subscriber
@Component
public class InnerSiteMsgHandler{

	private static final Logger log = LoggerFactory.getLogger(InnerSiteMsgHandler.class);
	
	@Autowired
	private MsgRepository msgrepository;
	
	@Subscribe
	public void excutEntrance(InnerSiteMsgEvent event){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("custNo", event.getCustNo());
		params.put("sysMsgType", event.getSysMsgType());
		params.put("sysMsgPubTime", event.getSysMsgPubTime());
		params.put("sysMsgContent", event.getSysMsgContent());
		try {
			msgrepository.addInnerSiteMsg(params);
		} catch (Exception e) {
			log.error("发送"+event.getSysMsgType()+"类型的站内信失败", e);
		}
	}
}
