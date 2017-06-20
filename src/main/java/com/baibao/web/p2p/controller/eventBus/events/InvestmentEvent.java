package com.baibao.web.p2p.controller.eventBus.events;


import org.springframework.stereotype.Component;

/**
 * 投资奖励事件
 * @author yangyang
 *
 */
@Component
public class InvestmentEvent {

	private String activeId;//活动编码
	
	private String effectTime;//活动奖品过期时间
	
	private String custNo;//投资人客户号
	
	private String goodsType;//奖品种类
	
	private String amount;//投资额
	
	private String activeStarTime;//活动起始时间
	
	private String activeEndTime;//活动终止时间

	public String getActiveId() {
		return activeId;
	}

	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}

	public String getEffectTime() {
		return effectTime;
	}

	public void setEffectTime(String effectTime) {
		this.effectTime = effectTime;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getActiveStarTime() {
		return activeStarTime;
	}

	public void setActiveStarTime(String activeStarTime) {
		this.activeStarTime = activeStarTime;
	}

	public String getActiveEndTime() {
		return activeEndTime;
	}

	public void setActiveEndTime(String activeEndTime) {
		this.activeEndTime = activeEndTime;
	}
	
	
}
