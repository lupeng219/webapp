package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_tender_profit implements Serializable{
   
	private static final long serialVersionUID = 1L;
	
	private String ptpIncomebillNo;//收益流水号

    private String ptpTenderFlowNo;//投资收益ID
    
    private String ptpProductNo;//借款单号

    private Integer ptpLoanseq;//期数

    private BigDecimal ptpCapital;//预期本期本金

    private BigDecimal ptpInterest;//预期本期利息

    private BigDecimal ptpProfit;//预期本期本息和

    private BigDecimal ptpFactcapital;//实际本期本金

    private BigDecimal ptpFactinterest;//实际本期利息

    private BigDecimal ptpFactprofit;//实际本期本息和

    private Date ptpProfittime;//预期收益时间

    private Date ptpFactprofittime;//实际收益时间

    private String ptpProfittype;//收益类型  40 本金  41 利息 42 本息和  43 佣金

    private String ptpCustno;//用户编号

    private String ptpProfitstatus;//投资收益状态：10未收益  11已收益 12还款中

    private String ptpRemark;//收益描述
    
    
    //临时字段，第三方支付账号
    private String pcaAccountNo;
    //临时字段，本息和
    private BigDecimal profit;

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

    public String getPtpCustno() {
        return ptpCustno;
    }

    public void setPtpCustno(String ptpCustno) {
        this.ptpCustno = ptpCustno == null ? null : ptpCustno.trim();
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

	public String getPcaAccountNo() {
		return pcaAccountNo;
	}

	public void setPcaAccountNo(String pcaAccountNo) {
		this.pcaAccountNo = pcaAccountNo;
	}

	public BigDecimal getProfit() {
		if(profit==null){
			profit = new BigDecimal(0);
		}
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public String getPtpProductNo() {
		return ptpProductNo;
	}

	public void setPtpProductNo(String ptpProductNo) {
		this.ptpProductNo = ptpProductNo;
	}

	public String getPtpIncomebillNo() {
		return ptpIncomebillNo;
	}

	public void setPtpIncomebillNo(String ptpIncomebillNo) {
		this.ptpIncomebillNo = ptpIncomebillNo;
	}

	public String getPtpTenderFlowNo() {
		return ptpTenderFlowNo;
	}

	public void setPtpTenderFlowNo(String ptpTenderFlowNo) {
		this.ptpTenderFlowNo = ptpTenderFlowNo;
	}
	
	
}