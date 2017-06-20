package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

public class P2p_refund implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Long prId;

    private String prFefundflowno;

    private String prFefundtype;

    private String prOriginalno;

    private String prStatus;

    private String prRemark;

    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public String getPrFefundflowno() {
        return prFefundflowno;
    }

    public void setPrFefundflowno(String prFefundflowno) {
        this.prFefundflowno = prFefundflowno == null ? null : prFefundflowno.trim();
    }

    public String getPrFefundtype() {
        return prFefundtype;
    }

    public void setPrFefundtype(String prFefundtype) {
        this.prFefundtype = prFefundtype == null ? null : prFefundtype.trim();
    }

    public String getPrOriginalno() {
        return prOriginalno;
    }

    public void setPrOriginalno(String prOriginalno) {
        this.prOriginalno = prOriginalno == null ? null : prOriginalno.trim();
    }

    public String getPrStatus() {
        return prStatus;
    }

    public void setPrStatus(String prStatus) {
        this.prStatus = prStatus == null ? null : prStatus.trim();
    }

    public String getPrRemark() {
        return prRemark;
    }

    public void setPrRemark(String prRemark) {
        this.prRemark = prRemark == null ? null : prRemark.trim();
    }
}