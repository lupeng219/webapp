package com.baibao.web.p2p.controller.eventBus.events;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

/**
 * 投资激活红包
 * @author yangyang
 *
 */
@Component
public class InvestmentActivationEvent {
	private String activeId;//活动编码
	
	private String custNo;//投资人
	
	private BigDecimal amount;//投资金额 
	
	private String projectNo;//项目编号
	
	private String tenderFlowNo;//投资流水号

	public String getActiveId() {
		return activeId;
	}

	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getTenderFlowNo() {
		return tenderFlowNo;
	}

	public void setTenderFlowNo(String tenderFlowNo) {
		this.tenderFlowNo = tenderFlowNo;
	}

	
	
	
}
