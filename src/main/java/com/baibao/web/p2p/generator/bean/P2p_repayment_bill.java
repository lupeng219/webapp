package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_repayment_bill implements Serializable{
    
	private static final long serialVersionUID = 1L;

	//private Long prbRepaymentid;

    private String prbRepaybillno;//账单编号

    private String prbCustno;//客户编号

    private String prbProductNo;//借款编号（关联产品表借款编号）

    private Integer prbRepaymentseq;//还款期数

    private Date prbRepaymenttime;//合约还款日期

    private BigDecimal prbRepaymentcapital;//应还本金

    private BigDecimal prbRepaymentinterest;//应还利息

    private BigDecimal prbRepaymentprincipal;//应还本息

    private BigDecimal prbInfactrepaymentpricipal;//实际还款本息

    private Date prbInfactrepaymenttime;//实际还款日期

    private Integer prbOverduedays;//逾期天数

    private BigDecimal prbOverdueamount;//逾期费用

    private BigDecimal prbOverduepunishscore;//逾期催收费用

    private String prbOverduenote;//还款说明备注

    private Integer prbRepaymentstatus;//还款状态
    
    //临时字段,借款期限
    private Integer ppLoanterm;
    //临时字段，借款年利率
    private BigDecimal ppComprehensiverate;
    //临时字段借款金额
    private BigDecimal ppLoanamount;
    //临时字段，还款方式
    private Integer ppLoanrepayment;
    //临时字段，支付账户号
    private String accountNo;
    //临时字段，产品编号
    private String ppProductNo;

    public String getPpProductNo() {
		return ppProductNo;
	}

	public void setPpProductNo(String ppProductNo) {
		this.ppProductNo = ppProductNo;
	}

	public String getPrbRepaybillno() {
        return prbRepaybillno;
    }

    public void setPrbRepaybillno(String prbRepaybillno) {
        this.prbRepaybillno = prbRepaybillno == null ? null : prbRepaybillno.trim();
    }

    public String getPrbCustno() {
        return prbCustno;
    }

    public void setPrbCustno(String prbCustno) {
        this.prbCustno = prbCustno == null ? null : prbCustno.trim();
    }


    public Integer getPrbRepaymentseq() {
        return prbRepaymentseq;
    }

    public void setPrbRepaymentseq(Integer prbRepaymentseq) {
        this.prbRepaymentseq = prbRepaymentseq;
    }

    public Date getPrbRepaymenttime() {
        return prbRepaymenttime;
    }

    public void setPrbRepaymenttime(Date prbRepaymenttime) {
        this.prbRepaymenttime = prbRepaymenttime;
    }

    public BigDecimal getPrbRepaymentcapital() {
        return prbRepaymentcapital;
    }

    public void setPrbRepaymentcapital(BigDecimal prbRepaymentcapital) {
        this.prbRepaymentcapital = prbRepaymentcapital;
    }

    public BigDecimal getPrbRepaymentinterest() {
        return prbRepaymentinterest;
    }

    public void setPrbRepaymentinterest(BigDecimal prbRepaymentinterest) {
        this.prbRepaymentinterest = prbRepaymentinterest;
    }

    public BigDecimal getPrbRepaymentprincipal() {
        return prbRepaymentprincipal;
    }

    public void setPrbRepaymentprincipal(BigDecimal prbRepaymentprincipal) {
        this.prbRepaymentprincipal = prbRepaymentprincipal;
    }

    public BigDecimal getPrbInfactrepaymentpricipal() {
        return prbInfactrepaymentpricipal;
    }

    public void setPrbInfactrepaymentpricipal(BigDecimal prbInfactrepaymentpricipal) {
        this.prbInfactrepaymentpricipal = prbInfactrepaymentpricipal;
    }

    public Date getPrbInfactrepaymenttime() {
		return prbInfactrepaymenttime;
	}

	public void setPrbInfactrepaymenttime(Date prbInfactrepaymenttime) {
		this.prbInfactrepaymenttime = prbInfactrepaymenttime;
	}

	public Integer getPrbOverduedays() {
        return prbOverduedays;
    }

    public void setPrbOverduedays(Integer prbOverduedays) {
        this.prbOverduedays = prbOverduedays;
    }

    public BigDecimal getPrbOverdueamount() {
    	if(prbOverdueamount==null){
    		prbOverdueamount = new BigDecimal(0);
    	}
        return prbOverdueamount;
    }

    public void setPrbOverdueamount(BigDecimal prbOverdueamount) {
        this.prbOverdueamount = prbOverdueamount;
    }

    public BigDecimal getPrbOverduepunishscore() {
        return prbOverduepunishscore;
    }

    public void setPrbOverduepunishscore(BigDecimal prbOverduepunishscore) {
        this.prbOverduepunishscore = prbOverduepunishscore;
    }

    public String getPrbOverduenote() {
        return prbOverduenote;
    }

    public void setPrbOverduenote(String prbOverduenote) {
        this.prbOverduenote = prbOverduenote == null ? null : prbOverduenote.trim();
    }

    public Integer getPrbRepaymentstatus() {
        return prbRepaymentstatus;
    }

    public void setPrbRepaymentstatus(Integer prbRepaymentstatus) {
        this.prbRepaymentstatus = prbRepaymentstatus;
    }

	public Integer getPpLoanterm() {
		return ppLoanterm;
	}

	public void setPpLoanterm(Integer ppLoanterm) {
		this.ppLoanterm = ppLoanterm;
	}

	public BigDecimal getPpComprehensiverate() {
		return ppComprehensiverate;
	}

	public void setPpComprehensiverate(BigDecimal ppComprehensiverate) {
		this.ppComprehensiverate = ppComprehensiverate;
	}

	public BigDecimal getPpLoanamount() {
		return ppLoanamount;
	}

	public void setPpLoanamount(BigDecimal ppLoanamount) {
		this.ppLoanamount = ppLoanamount;
	}

	public Integer getPpLoanrepayment() {
		return ppLoanrepayment;
	}

	public void setPpLoanrepayment(Integer ppLoanrepayment) {
		this.ppLoanrepayment = ppLoanrepayment;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPrbProductNo() {
		return prbProductNo;
	}

	public void setPrbProductNo(String prbProductNo) {
		this.prbProductNo = prbProductNo;
	}

}