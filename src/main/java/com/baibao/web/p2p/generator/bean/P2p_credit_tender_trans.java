package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_credit_tender_trans implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Long pctId;

    private String pctTransflowno;

    private String pctOutcustno;

    private String pctOutcusttype;

    private String pctOutpayacc;

    private BigDecimal pctOutpayaccfee;

    private String pctIntcusttype;

    private String pctInpayacc;

    private BigDecimal pctInpayaccfee;

    private BigDecimal pctTranamt;

    private Date pctTranstime;

    private String pctTenderflowno;

    private Date pctHostResponseTime;

    private String pctHostResponseFlownum;

    private String pctHostReturnCode;

    private String pctHostReturnMessage;

    private String pctPaystatus;

    private String pctRemark;

    public Long getPctId() {
        return pctId;
    }

    public void setPctId(Long pctId) {
        this.pctId = pctId;
    }

    public String getPctTransflowno() {
        return pctTransflowno;
    }

    public void setPctTransflowno(String pctTransflowno) {
        this.pctTransflowno = pctTransflowno == null ? null : pctTransflowno.trim();
    }

    public String getPctOutcustno() {
        return pctOutcustno;
    }

    public void setPctOutcustno(String pctOutcustno) {
        this.pctOutcustno = pctOutcustno == null ? null : pctOutcustno.trim();
    }

    public String getPctOutcusttype() {
        return pctOutcusttype;
    }

    public void setPctOutcusttype(String pctOutcusttype) {
        this.pctOutcusttype = pctOutcusttype == null ? null : pctOutcusttype.trim();
    }

    public String getPctOutpayacc() {
        return pctOutpayacc;
    }

    public void setPctOutpayacc(String pctOutpayacc) {
        this.pctOutpayacc = pctOutpayacc == null ? null : pctOutpayacc.trim();
    }

    public BigDecimal getPctOutpayaccfee() {
        return pctOutpayaccfee;
    }

    public void setPctOutpayaccfee(BigDecimal pctOutpayaccfee) {
        this.pctOutpayaccfee = pctOutpayaccfee;
    }

    public String getPctIntcusttype() {
        return pctIntcusttype;
    }

    public void setPctIntcusttype(String pctIntcusttype) {
        this.pctIntcusttype = pctIntcusttype == null ? null : pctIntcusttype.trim();
    }

    public String getPctInpayacc() {
        return pctInpayacc;
    }

    public void setPctInpayacc(String pctInpayacc) {
        this.pctInpayacc = pctInpayacc == null ? null : pctInpayacc.trim();
    }

    public BigDecimal getPctInpayaccfee() {
        return pctInpayaccfee;
    }

    public void setPctInpayaccfee(BigDecimal pctInpayaccfee) {
        this.pctInpayaccfee = pctInpayaccfee;
    }

    public BigDecimal getPctTranamt() {
        return pctTranamt;
    }

    public void setPctTranamt(BigDecimal pctTranamt) {
        this.pctTranamt = pctTranamt;
    }

    public Date getPctTranstime() {
        return pctTranstime;
    }

    public void setPctTranstime(Date pctTranstime) {
        this.pctTranstime = pctTranstime;
    }

    public String getPctTenderflowno() {
        return pctTenderflowno;
    }

    public void setPctTenderflowno(String pctTenderflowno) {
        this.pctTenderflowno = pctTenderflowno == null ? null : pctTenderflowno.trim();
    }

    public Date getPctHostResponseTime() {
        return pctHostResponseTime;
    }

    public void setPctHostResponseTime(Date pctHostResponseTime) {
        this.pctHostResponseTime = pctHostResponseTime;
    }

    public String getPctHostResponseFlownum() {
        return pctHostResponseFlownum;
    }

    public void setPctHostResponseFlownum(String pctHostResponseFlownum) {
        this.pctHostResponseFlownum = pctHostResponseFlownum == null ? null : pctHostResponseFlownum.trim();
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

    public String getPctPaystatus() {
        return pctPaystatus;
    }

    public void setPctPaystatus(String pctPaystatus) {
        this.pctPaystatus = pctPaystatus == null ? null : pctPaystatus.trim();
    }

    public String getPctRemark() {
        return pctRemark;
    }

    public void setPctRemark(String pctRemark) {
        this.pctRemark = pctRemark == null ? null : pctRemark.trim();
    }
}