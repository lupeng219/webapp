package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_credit_tender implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long pctId;

    private String pctCreditflowno;

    private String pctBuycreditcustno;

    private String pctBuycreditaccount;

    private BigDecimal pctBuyamount;

    private String pctBuycusttype;

    private String pctLoancreditcustno;

    private String pctLoancreditaccount;

    private String pctLoancusttype;

    private String pctCrediteflowno;

    private String pctChannel;

    private String pctPaystatus;

    private String pctTradestatus;

    private String pctPaystatuscode;

    private Date pctHostResponseTime;

    private String pctHostResponseFlowno;

    private String pctHostReturnCode;

    private String pctHostReturnMessage;

    private String pctDealstatus;

    private String pctBackstatus;

    private String pctRemark;

    public Long getPctId() {
        return pctId;
    }

    public void setPctId(Long pctId) {
        this.pctId = pctId;
    }

    public String getPctCreditflowno() {
        return pctCreditflowno;
    }

    public void setPctCreditflowno(String pctCreditflowno) {
        this.pctCreditflowno = pctCreditflowno == null ? null : pctCreditflowno.trim();
    }

    public String getPctBuycreditcustno() {
        return pctBuycreditcustno;
    }

    public void setPctBuycreditcustno(String pctBuycreditcustno) {
        this.pctBuycreditcustno = pctBuycreditcustno == null ? null : pctBuycreditcustno.trim();
    }

    public String getPctBuycreditaccount() {
        return pctBuycreditaccount;
    }

    public void setPctBuycreditaccount(String pctBuycreditaccount) {
        this.pctBuycreditaccount = pctBuycreditaccount == null ? null : pctBuycreditaccount.trim();
    }

    public BigDecimal getPctBuyamount() {
        return pctBuyamount;
    }

    public void setPctBuyamount(BigDecimal pctBuyamount) {
        this.pctBuyamount = pctBuyamount;
    }

    public String getPctBuycusttype() {
        return pctBuycusttype;
    }

    public void setPctBuycusttype(String pctBuycusttype) {
        this.pctBuycusttype = pctBuycusttype == null ? null : pctBuycusttype.trim();
    }

    public String getPctLoancreditcustno() {
        return pctLoancreditcustno;
    }

    public void setPctLoancreditcustno(String pctLoancreditcustno) {
        this.pctLoancreditcustno = pctLoancreditcustno == null ? null : pctLoancreditcustno.trim();
    }

    public String getPctLoancreditaccount() {
        return pctLoancreditaccount;
    }

    public void setPctLoancreditaccount(String pctLoancreditaccount) {
        this.pctLoancreditaccount = pctLoancreditaccount == null ? null : pctLoancreditaccount.trim();
    }

    public String getPctLoancusttype() {
        return pctLoancusttype;
    }

    public void setPctLoancusttype(String pctLoancusttype) {
        this.pctLoancusttype = pctLoancusttype == null ? null : pctLoancusttype.trim();
    }

    public String getPctCrediteflowno() {
        return pctCrediteflowno;
    }

    public void setPctCrediteflowno(String pctCrediteflowno) {
        this.pctCrediteflowno = pctCrediteflowno == null ? null : pctCrediteflowno.trim();
    }

    public String getPctChannel() {
        return pctChannel;
    }

    public void setPctChannel(String pctChannel) {
        this.pctChannel = pctChannel == null ? null : pctChannel.trim();
    }

    public String getPctPaystatus() {
        return pctPaystatus;
    }

    public void setPctPaystatus(String pctPaystatus) {
        this.pctPaystatus = pctPaystatus == null ? null : pctPaystatus.trim();
    }

    public String getPctTradestatus() {
        return pctTradestatus;
    }

    public void setPctTradestatus(String pctTradestatus) {
        this.pctTradestatus = pctTradestatus == null ? null : pctTradestatus.trim();
    }

    public String getPctPaystatuscode() {
        return pctPaystatuscode;
    }

    public void setPctPaystatuscode(String pctPaystatuscode) {
        this.pctPaystatuscode = pctPaystatuscode == null ? null : pctPaystatuscode.trim();
    }

    public Date getPctHostResponseTime() {
        return pctHostResponseTime;
    }

    public void setPctHostResponseTime(Date pctHostResponseTime) {
        this.pctHostResponseTime = pctHostResponseTime;
    }

    public String getPctHostResponseFlowno() {
        return pctHostResponseFlowno;
    }

    public void setPctHostResponseFlowno(String pctHostResponseFlowno) {
        this.pctHostResponseFlowno = pctHostResponseFlowno == null ? null : pctHostResponseFlowno.trim();
    }

    public String getPctHostReturnCode() {
        return pctHostReturnCode;
    }

    public void setPctHostReturnCode(String pctHostReturnCode) {
        this.pctHostReturnCode = pctHostReturnCode == null ? null : pctHostReturnCode.trim();
    }

    public String getPctHostReturnMessage() {
        return pctHostReturnMessage;
    }

    public void setPctHostReturnMessage(String pctHostReturnMessage) {
        this.pctHostReturnMessage = pctHostReturnMessage == null ? null : pctHostReturnMessage.trim();
    }

    public String getPctDealstatus() {
        return pctDealstatus;
    }

    public void setPctDealstatus(String pctDealstatus) {
        this.pctDealstatus = pctDealstatus == null ? null : pctDealstatus.trim();
    }

    public String getPctBackstatus() {
        return pctBackstatus;
    }

    public void setPctBackstatus(String pctBackstatus) {
        this.pctBackstatus = pctBackstatus == null ? null : pctBackstatus.trim();
    }

    public String getPctRemark() {
        return pctRemark;
    }

    public void setPctRemark(String pctRemark) {
        this.pctRemark = pctRemark == null ? null : pctRemark.trim();
    }
}