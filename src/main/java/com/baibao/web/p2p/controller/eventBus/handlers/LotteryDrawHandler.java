package com.baibao.web.p2p.controller.eventBus.handlers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.eventbus.Subscribe;
import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.UtilTools;
import com.baibao.web.p2p.controller.eventBus.Subscriber;
import com.baibao.web.p2p.controller.eventBus.events.LotteryDrawEvent;
import com.baibao.web.p2p.service.ActiveService;

@Subscriber
@Component
public class LotteryDrawHandler extends ActiveBaseHandler {
	
	private static final Logger log = LoggerFactory.getLogger(LotteryDrawHandler.class);
	@Autowired
	ActiveService activeService;
	
	@Subscribe
	public void excutEntrance(LotteryDrawEvent event){
		log.info("###############抽奖次数活动入口###################");
		
			//验证活动是否生效、是否过期、是否存在
		if(!checkActive(event.getActiveId()))
			return;
		
		try {
			//实际操作
			int count =activeService.queryBycustNoAndSourceType(event.getPulCustno(), event.getPulSourcetype());
			if(event.getPulSourcetype().equals("1")){ //1 登录 2 投资
				if(count==0){
					insertLotteryDraw(event);
				}
			}else if(event.getPulSourcetype().equals("2")){
				if(count<2){
					insertLotteryDraw(event);
				}
			}
			
		} catch (Exception e) {
			log.error("########处理抽奖活动次数异常", e);
		}
		log.info("############抽奖活动次数逻辑结束###########");
		
	}

	public void insertLotteryDraw(LotteryDrawEvent event){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("pul_lotteryDrawNo", UtilTools.getUUId());
		params.put("pul_custNo", event.getPulCustno());
		params.put("pul_sourceType", event.getPulSourcetype());
		params.put("pul_getTime", new Date());
		params.put("pul_tenderFlowNo", event.getPulTenderflowno());
		params.put("pul_status", "0");
		try {
			activeService.insertLotteryDraw(params);
		} catch (BusinessException e) {
			
			log.error("########处理抽奖活动次数异常", e);
		}
	}
}
