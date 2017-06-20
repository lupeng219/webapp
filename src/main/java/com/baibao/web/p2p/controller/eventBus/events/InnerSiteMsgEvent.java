package com.baibao.web.p2p.controller.eventBus.events;

import org.springframework.stereotype.Component;

/**
 * 站内信事件主体
 * @author yangyang
 *
 */
@Component
public class InnerSiteMsgEvent {

	private String custNo;
	
	private String sysMsgType;
	
	private String sysMsgPubTime;
	
	private String sysMsgContent;

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getSysMsgType() {
		return sysMsgType;
	}

	public void setSysMsgType(String sysMsgType) {
		this.sysMsgType = sysMsgType;
	}

	public String getSysMsgPubTime() {
		return sysMsgPubTime;
	}

	public void setSysMsgPubTime(String sysMsgPubTime) {
		this.sysMsgPubTime = sysMsgPubTime;
	}

	public String getSysMsgContent() {
		return sysMsgContent;
	}

	public void setSysMsgContent(String sysMsgContent) {
		this.sysMsgContent = sysMsgContent;
	}
	
	
}
