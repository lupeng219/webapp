package com.baibao.web.p2p.controller.eventBus.events;

import org.springframework.stereotype.Component;

/**
 * 邀请注册事件
 * @author yangyang
 *
 */
@Component
public class InvitatRegistEvent {
   
	private String activeId;//活动编码

	private String registMobile;//注册用户手机号
	
	private String invitatId;//邀请人id 手机号或邀请码
	
	private String effectTime;//活动奖品过期时间
	
	private String pae_goodsType;//奖品种类
	
	public String getActiveId() {
		return activeId;
	}

	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}


	public String getRegistMobile() {
		return registMobile;
	}

	public void setRegistMobile(String registMobile) {
		this.registMobile = registMobile;
	}

	public String getInvitatId() {
		return invitatId;
	}

	public void setInvitatId(String invitatId) {
		this.invitatId = invitatId;
	}

	public String getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public String getPae_goodsType() {
		return pae_goodsType;
	}

	public void setPae_goodsType(String pae_goodsType) {
		this.pae_goodsType = pae_goodsType;
	}
	
	
}
