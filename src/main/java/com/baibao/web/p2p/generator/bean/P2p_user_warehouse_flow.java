package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

public class P2p_user_warehouse_flow implements Serializable {

	private static final long serialVersionUID = 1L;

	private String puwf_flowNo;
	
	private String puwf_whNo;
	
	private Date puwf_time;
	
	private String puwf_status;

	public String getPuwf_flowNo() {
		return puwf_flowNo;
	}

	public void setPuwf_flowNo(String puwf_flowNo) {
		this.puwf_flowNo = puwf_flowNo;
	}

	public String getPuwf_whNo() {
		return puwf_whNo;
	}

	public void setPuwf_whNo(String puwf_whNo) {
		this.puwf_whNo = puwf_whNo;
	}

	public Date getPuwf_time() {
		return puwf_time;
	}

	public void setPuwf_time(Date puwf_time) {
		this.puwf_time = puwf_time;
	}

	public String getPuwf_status() {
		return puwf_status;
	}

	public void setPuwf_status(String puwf_status) {
		this.puwf_status = puwf_status;
	}
	
	
}