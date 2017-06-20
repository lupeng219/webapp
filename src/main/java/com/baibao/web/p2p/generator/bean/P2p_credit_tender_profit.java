package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_credit_tender_profit implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long ptpId;

    private String ptpTenderflowno;

    private String ptpCustno;

    private String ptpLoanno;

    private Integer ptpLoanseq;

    private BigDecimal ptpCapital;

    private BigDecimal ptpInterest;

    private BigDecimal ptpProfit;

    private BigDecimal ptpFactcapital;

    private BigDecimal ptpFactinterest;

    private BigDecimal ptpFactprofit;

    private Date ptpProfittime;

    private Date ptpFactprofittime;

    private String ptpProfittype;

    private String ptpProfitstatus;

    private String ptpRemark;
    
    //临时字段,新浪支付号
    private String accountNo;

    public Long getPtpId() {
        return ptpId;
    }

    public void setPtpId(Long ptpId) {
        this.ptpId = ptpId;
    }

    public String getPtpTenderflowno() {
        return ptpTenderflowno;
    }

    public void setPtpTenderflowno(String ptpTenderflowno) {
        this.ptpTenderflowno = ptpTenderflowno == null ? null : ptpTenderflowno.trim();
    }

    public String getPtpCustno() {
        return ptpCustno;
    }

    public void setPtpCustno(String ptpCustno) {
        this.ptpCustno = ptpCustno == null ? null : ptpCustno.trim();
    }

    public String getPtpLoanno() {
        return ptpLoanno;
    }

    public void setPtpLoanno(String ptpLoanno) {
        this.ptpLoanno = ptpLoanno == null ? null : ptpLoanno.trim();
    }

    public Integer getPtpLoanseq() {
        return ptpLoanseq;
    }

    public void setPtpLoanseq(Integer ptpLoanseq) {
        this.ptpLoanseq = ptpLoanseq;
    }

    public BigDecimal getPtpCapital() {
        return ptpCapital;
    }

    public void setPtpCapital(BigDecimal ptpCapital) {
        this.ptpCapital = ptpCapital;
    }

    public BigDecimal getPtpInterest() {
        return ptpInterest;
    }

    public void setPtpInterest(BigDecimal ptpInterest) {
        this.ptpInterest = ptpInterest;
    }

    public BigDecimal getPtpProfit() {
        return ptpProfit;
    }

    public void setPtpProfit(BigDecimal ptpProfit) {
        this.ptpProfit = ptpProfit;
    }

    public BigDecimal getPtpFactcapital() {
        return ptpFactcapital;
    }

    public void setPtpFactcapital(BigDecimal ptpFactcapital) {
        this.ptpFactcapital = ptpFactcapital;
    }

    public BigDecimal getPtpFactinterest() {
        return ptpFactinterest;
    }

    public void setPtpFactinterest(BigDecimal ptpFactinterest) {
        this.ptpFactinterest = ptpFactinterest;
    }

    public BigDecimal getPtpFactprofit() {
        return ptpFactprofit;
    }

    public void setPtpFactprofit(BigDecimal ptpFactprofit) {
        this.ptpFactprofit = ptpFactprofit;
    }

    public Date getPtpProfittime() {
        return ptpProfittime;
    }

    public void setPtpProfittime(Date ptpProfittime) {
        this.ptpProfittime = ptpProfittime;
    }

    public Date getPtpFactprofittime() {
        return ptpFactprofittime;
    }

    public void setPtpFactprofittime(Date ptpFactprofittime) {
        this.ptpFactprofittime = ptpFactprofittime;
    }

    public String getPtpProfittype() {
        return ptpProfittype;
    }

    public void setPtpProfittype(String ptpProfittype) {
        this.ptpProfittype = ptpProfittype == null ? null : ptpProfittype.trim();
    }

    public String getPtpProfitstatus() {
        return ptpProfitstatus;
    }

    public void setPtpProfitstatus(String ptpProfitstatus) {
        this.ptpProfitstatus = ptpProfitstatus == null ? null : ptpProfitstatus.trim();
    }

    public String getPtpRemark() {
        return ptpRemark;
    }

    public void setPtpRemark(String ptpRemark) {
        this.ptpRemark = ptpRemark == null ? null : ptpRemark.trim();
    }

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
}