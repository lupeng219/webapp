package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_credite_loan implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Long pclId;

    private String pclCrediteflowno;

    private String pclOldflownum;

    private String pclLoannum;

    private String pclCustno;

    private Date pclTransfertime;

    private Integer pclTenderdatetime;

    private BigDecimal pclCrediterate;

    private BigDecimal pclCrediteamt;

    private BigDecimal pclTransferamt;

    private Integer pclCrediteperiods;

    private String pclChannel;

    private String pclCreditestatus;

    private String pclDescription;

    public Long getPclId() {
        return pclId;
    }

    public void setPclId(Long pclId) {
        this.pclId = pclId;
    }

    public String getPclCrediteflowno() {
        return pclCrediteflowno;
    }

    public void setPclCrediteflowno(String pclCrediteflowno) {
        this.pclCrediteflowno = pclCrediteflowno == null ? null : pclCrediteflowno.trim();
    }

    public String getPclOldflownum() {
        return pclOldflownum;
    }

    public void setPclOldflownum(String pclOldflownum) {
        this.pclOldflownum = pclOldflownum == null ? null : pclOldflownum.trim();
    }

    public String getPclLoannum() {
        return pclLoannum;
    }

    public void setPclLoannum(String pclLoannum) {
        this.pclLoannum = pclLoannum == null ? null : pclLoannum.trim();
    }

    public String getPclCustno() {
        return pclCustno;
    }

    public void setPclCustno(String pclCustno) {
        this.pclCustno = pclCustno == null ? null : pclCustno.trim();
    }

    public Date getPclTransfertime() {
        return pclTransfertime;
    }

    public void setPclTransfertime(Date pclTransfertime) {
        this.pclTransfertime = pclTransfertime;
    }

    public Integer getPclTenderdatetime() {
        return pclTenderdatetime;
    }

    public void setPclTenderdatetime(Integer pclTenderdatetime) {
        this.pclTenderdatetime = pclTenderdatetime;
    }

    public BigDecimal getPclCrediterate() {
        return pclCrediterate;
    }

    public void setPclCrediterate(BigDecimal pclCrediterate) {
        this.pclCrediterate = pclCrediterate;
    }

    public BigDecimal getPclCrediteamt() {
        return pclCrediteamt;
    }

    public void setPclCrediteamt(BigDecimal pclCrediteamt) {
        this.pclCrediteamt = pclCrediteamt;
    }

    public BigDecimal getPclTransferamt() {
        return pclTransferamt;
    }

    public void setPclTransferamt(BigDecimal pclTransferamt) {
        this.pclTransferamt = pclTransferamt;
    }

    public Integer getPclCrediteperiods() {
        return pclCrediteperiods;
    }

    public void setPclCrediteperiods(Integer pclCrediteperiods) {
        this.pclCrediteperiods = pclCrediteperiods;
    }

    public String getPclChannel() {
        return pclChannel;
    }

    public void setPclChannel(String pclChannel) {
        this.pclChannel = pclChannel == null ? null : pclChannel.trim();
    }

    public String getPclCreditestatus() {
        return pclCreditestatus;
    }

    public void setPclCreditestatus(String pclCreditestatus) {
        this.pclCreditestatus = pclCreditestatus == null ? null : pclCreditestatus.trim();
    }

    public String getPclDescription() {
        return pclDescription;
    }

    public void setPclDescription(String pclDescription) {
        this.pclDescription = pclDescription == null ? null : pclDescription.trim();
    }
}