package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

public class P2p_feedback implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String pf_custNo ;
	
	private String pf_phone;
	
	private String pf_content;
	
	private Date pf_time;

	public String getPf_custNo() {
		return pf_custNo;
	}

	public void setPf_custNo(String pf_custNo) {
		this.pf_custNo = pf_custNo;
	}

	public String getPf_phone() {
		return pf_phone;
	}

	public void setPf_phone(String pf_phone) {
		this.pf_phone = pf_phone;
	}

	public String getPf_content() {
		return pf_content;
	}

	public void setPf_content(String pf_content) {
		this.pf_content = pf_content;
	}

	public Date getPf_time() {
		return pf_time;
	}

	public void setPf_time(Date pf_time) {
		this.pf_time = pf_time;
	}
	
	
	

}
