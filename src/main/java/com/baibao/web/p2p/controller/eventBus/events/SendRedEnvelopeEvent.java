package com.baibao.web.p2p.controller.eventBus.events;

import org.springframework.stereotype.Component;

import com.baibao.web.p2p.generator.bean.P2p_activity_elements;


/**
 * 红包要素（520元红包）
 * @author yangyang
 *
 */
@Component
public class SendRedEnvelopeEvent {
	   
		private String activeId;//活动编码

		private String custNo;//客户号

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
		
		
}
