package com.baibao.web.p2p.controller.eventBus.events;

import org.springframework.stereotype.Component;

import com.baibao.web.p2p.generator.bean.P2p_activity_elements;


/**
 * 注册事件
 * @author guodong
 *
 */
@Component
public class FriendsInvestmentEvent {
	   
		private String activeId;//活动编码

		private String puCustNo;//投资人客户号
		
		private P2p_activity_elements activity;//活动详情
		
		private String investAmount;//投资金额
		
		private String tenderFlowNo;//投资流水号
		
		private String projectNo;//标的编号
		
		private String projectTerm;//
		
		public String getActiveId() {
			return activeId;
		}

		public void setActiveId(String activeId) {
			this.activeId = activeId;
		}

		public String getPuCustNo() {
			return puCustNo;
		}

		public void setPuCustNo(String puCustNo) {
			this.puCustNo = puCustNo;
		}

		public String getInvestAmount() {
			return investAmount;
		}

		public void setInvestAmount(String investAmount) {
			this.investAmount = investAmount;
		}

		public P2p_activity_elements getActivity() {
			return activity;
		}

		public void setActivity(P2p_activity_elements activity) {
			this.activity = activity;
		}

		public String getTenderFlowNo() {
			return tenderFlowNo;
		}

		public void setTenderFlowNo(String tenderFlowNo) {
			this.tenderFlowNo = tenderFlowNo;
		}

		public String getProjectNo() {
			return projectNo;
		}

		public void setProjectNo(String projectNo) {
			this.projectNo = projectNo;
		}


		public String getProjectTerm() {
			return projectTerm;
		}

		public void setProjectTerm(String projectTerm) {
			this.projectTerm = projectTerm;
		}
		
		
}
