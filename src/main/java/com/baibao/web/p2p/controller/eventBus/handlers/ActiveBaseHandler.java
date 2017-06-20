package com.baibao.web.p2p.controller.eventBus.handlers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.bean.P2p_activity_elements;
import com.baibao.web.p2p.generator.dataDIC.BooleanType;
import com.baibao.web.p2p.service.ActiveService;

/**
 * 活动业务处理基类
 * @author yangyang
 *
 */
@Component
public class ActiveBaseHandler
{	
	@Autowired ActiveService activeService;
	
   /**
    * 验证活动
    * @param elements 活动bean
    * @throws Exception
    */
	public boolean checkActive(String activeId)
	{	
		if (StringUtil.isEmpty(activeId))
		{
			//throw new QZBException("活动参数为空");
			return false;
		}
		
		//查询活动表根据活动编号
		P2p_activity_elements elements =
			activeService.getActiveById(Long.parseLong(activeId));

		//TODO 活动为空  空指针
		if (elements == null)
			return false;
		
		String isActiveEnable = elements.getPae_isEnable();
		if (BooleanType.getBooleanType(isActiveEnable) == BooleanType.no)
		{
			//throw new QZBException("活动未启用");
			return false;
		}
		
		String activeStarTime = elements.getPae_starTime();
		String activeEndTime = elements.getPae_endTime();
		
		if (!DateUtils.isBetweenDate(
				DateUtils.string2Date(activeStarTime, DateUtils.DEFAULT_FORMAT),
				DateUtils.string2Date(activeEndTime, DateUtils.DEFAULT_FORMAT),
				new Date()))
		{
			//throw new QZBException("活动不在有效期内");
			return false;
		}

		return true;
	}
}
