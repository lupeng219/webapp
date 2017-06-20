package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;
import java.util.Date;

public class P2p_loan_product {
	
    private String ppProductno;//产品编号（与借款申请表loanNo一致）

    private String ppCustno;//客户编号

    private String ppLoantitle;//产品标题

    private Integer ppLoanterm;//借款期限

    private BigDecimal ppLoanamount;//借款目标金额

    private BigDecimal ppLoanamountexist;//已融资金额

    private BigDecimal ppComprehensiverate;//借款年利率

    private Integer ppLoanrepayment;//还款方式

    private BigDecimal ppRepaymentamount;//应还款总额

    private String ppProducttypeid;

    private String ppLoanApplyid;

    private Integer ppBulkloanstatus;//融资状态

    private Date ppBulkloanstarttime;//预定投标开始时间

    private Date ppBulkloanendtime;//预定投标结束时间

    private Date ppBulkloaneffecttime;//实际满标时间

    private String ppBulkloandealseconds;//成交用时

    private BigDecimal ppTerderminamount;//最小投标金额

    private BigDecimal ppTendermaxamount;//最大投标金额

    private BigDecimal ppTenderincreaseamount;//递增金额

    private Integer pp_activityType;//产品活动类型 1：新手体验

    private Integer ppDuration;
    
    public String getPpProductno() {
        return ppProductno;
    }

    public void setPpProductno(String ppProductno) {
        this.ppProductno = ppProductno == null ? null : ppProductno.trim();
    }

    public String getPpCustno() {
        return ppCustno;
    }

    public void setPpCustno(String ppCustno) {
        this.ppCustno = ppCustno == null ? null : ppCustno.trim();
    }

    public String getPpLoantitle() {
        return ppLoantitle;
    }

    public void setPpLoantitle(String ppLoantitle) {
        this.ppLoantitle = ppLoantitle == null ? null : ppLoantitle.trim();
    }

    public Integer getPpLoanterm() {
        return ppLoanterm;
    }

    public void setPpLoanterm(Integer ppLoanterm) {
        this.ppLoanterm = ppLoanterm;
    }

    public BigDecimal getPpLoanamount() {
        return ppLoanamount;
    }

    public void setPpLoanamount(BigDecimal ppLoanamount) {
        this.ppLoanamount = ppLoanamount;
    }

    public BigDecimal getPpLoanamountexist() {
        return ppLoanamountexist;
    }

    public void setPpLoanamountexist(BigDecimal ppLoanamountexist) {
        this.ppLoanamountexist = ppLoanamountexist;
    }

    public BigDecimal getPpComprehensiverate() {
        return ppComprehensiverate;
    }

    public void setPpComprehensiverate(BigDecimal ppComprehensiverate) {
        this.ppComprehensiverate = ppComprehensiverate;
    }

    public Integer getPpLoanrepayment() {
        return ppLoanrepayment;
    }

    public void setPpLoanrepayment(Integer ppLoanrepayment) {
        this.ppLoanrepayment = ppLoanrepayment;
    }

    public BigDecimal getPpRepaymentamount() {
        return ppRepaymentamount;
    }

    public void setPpRepaymentamount(BigDecimal ppRepaymentamount) {
        this.ppRepaymentamount = ppRepaymentamount;
    }

    public String getPpProducttypeid() {
        return ppProducttypeid;
    }

    public void setPpProducttypeid(String ppProducttypeid) {
        this.ppProducttypeid = ppProducttypeid == null ? null : ppProducttypeid.trim();
    }

    public String getPpLoanApplyid() {
        return ppLoanApplyid;
    }

    public void setPpLoanApplyid(String ppLoanApplyid) {
        this.ppLoanApplyid = ppLoanApplyid == null ? null : ppLoanApplyid.trim();
    }

    public Integer getPpBulkloanstatus() {
        return ppBulkloanstatus;
    }

    public void setPpBulkloanstatus(Integer ppBulkloanstatus) {
        this.ppBulkloanstatus = ppBulkloanstatus;
    }

    public Date getPpBulkloanstarttime() {
        return ppBulkloanstarttime;
    }

    public void setPpBulkloanstarttime(Date ppBulkloanstarttime) {
        this.ppBulkloanstarttime = ppBulkloanstarttime;
    }

    public Date getPpBulkloanendtime() {
        return ppBulkloanendtime;
    }

    public void setPpBulkloanendtime(Date ppBulkloanendtime) {
        this.ppBulkloanendtime = ppBulkloanendtime;
    }

    public Date getPpBulkloaneffecttime() {
        return ppBulkloaneffecttime;
    }

    public void setPpBulkloaneffecttime(Date ppBulkloaneffecttime) {
        this.ppBulkloaneffecttime = ppBulkloaneffecttime;
    }

    public String getPpBulkloandealseconds() {
        return ppBulkloandealseconds;
    }

    public void setPpBulkloandealseconds(String ppBulkloandealseconds) {
        this.ppBulkloandealseconds = ppBulkloandealseconds == null ? null : ppBulkloandealseconds.trim();
    }

    public BigDecimal getPpTerderminamount() {
        return ppTerderminamount;
    }

    public void setPpTerderminamount(BigDecimal ppTerderminamount) {
        this.ppTerderminamount = ppTerderminamount;
    }

    public BigDecimal getPpTendermaxamount() {
        return ppTendermaxamount;
    }

    public void setPpTendermaxamount(BigDecimal ppTendermaxamount) {
        this.ppTendermaxamount = ppTendermaxamount;
    }

    public BigDecimal getPpTenderincreaseamount() {
        return ppTenderincreaseamount;
    }

    public void setPpTenderincreaseamount(BigDecimal ppTenderincreaseamount) {
        this.ppTenderincreaseamount = ppTenderincreaseamount;
    }

	public Integer getPp_activityType() {
		return pp_activityType;
	}

	public void setPp_activityType(Integer pp_activityType) {
		this.pp_activityType = pp_activityType;
	}

	public Integer getPpDuration() {
		return ppDuration;
	}

	public void setPpDuration(Integer ppDuration) {
		this.ppDuration = ppDuration;
	}
}