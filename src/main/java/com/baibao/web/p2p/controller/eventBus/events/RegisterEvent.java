package com.baibao.web.p2p.controller.eventBus.events;

import org.springframework.stereotype.Component;

import com.baibao.web.p2p.generator.bean.P2p_activity_elements;


/**
 * 注册事件
 * @author guodong
 *
 */
@Component
public class RegisterEvent {
	   
		private String activeId;//活动编码

		private String registMobile;//注册用户手机号
		
		private String effectTime;//活动奖品过期时间
		
		private P2p_activity_elements p2pActivityElements;//活动详情
		
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


		public String getEffectTime() {
			return effectTime;
		}

		public void setEffectTime(String effectTime) {
			this.effectTime = effectTime;
		}

		public P2p_activity_elements getP2pActivityElements() {
			return p2pActivityElements;
		}

		public void setP2pActivityElements(P2p_activity_elements p2pActivityElements) {
			this.p2pActivityElements = p2pActivityElements;
		}
		
		
}
