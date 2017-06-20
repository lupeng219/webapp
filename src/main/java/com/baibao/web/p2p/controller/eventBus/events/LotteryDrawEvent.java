package com.baibao.web.p2p.controller.eventBus.events;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class LotteryDrawEvent {
	
	    
	    private String  activeId;  //活动编号 
	    
	    private String pulLotterydrawno; //用户抽奖编号

	    private String pulCustno;//用户客户号

	    private String pulSourcetype;//来源类型(1：登录(每天1次)2：投资(最多2次))

	    private Date pulGettime;//获得时间(登录时间、投标时间)

	    private String pulTenderflowno;//投标流水

	    private Integer pulStatus;//使用状态(0：未使用1：已使用)

		
	    public String getActiveId() {
			return activeId;
		}

		public void setActiveId(String activeId) {
			this.activeId = activeId;
		}

		public String getPulLotterydrawno() {
			return pulLotterydrawno;
		}

		public void setPulLotterydrawno(String pulLotterydrawno) {
			this.pulLotterydrawno = pulLotterydrawno;
		}

		public String getPulCustno() {
			return pulCustno;
		}

		public void setPulCustno(String pulCustno) {
			this.pulCustno = pulCustno;
		}

		public String getPulSourcetype() {
			return pulSourcetype;
		}

		public void setPulSourcetype(String pulSourcetype) {
			this.pulSourcetype = pulSourcetype;
		}

		public Date getPulGettime() {
			return pulGettime;
		}

		public void setPulGettime(Date pulGettime) {
			this.pulGettime = pulGettime;
		}

		public String getPulTenderflowno() {
			return pulTenderflowno;
		}

		public void setPulTenderflowno(String pulTenderflowno) {
			this.pulTenderflowno = pulTenderflowno;
		}

		public Integer getPulStatus() {
			return pulStatus;
		}

		public void setPulStatus(Integer pulStatus) {
			this.pulStatus = pulStatus;
		}
	    
	    
	    


}
