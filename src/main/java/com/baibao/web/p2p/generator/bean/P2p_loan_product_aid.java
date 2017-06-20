package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * 产品子表
 * @author zy
 *
 */
public class P2p_loan_product_aid
{
    private String ppProductno;
    private String ppCustno;
    private String ppLoantitle;
    private Integer ppLoanterm;
    private BigDecimal ppLoanamount;
    private BigDecimal ppLoanamountexist;
    private BigDecimal ppComprehensiverate;
    private Integer ppLoanrepayment;
    private BigDecimal ppRepaymentamount;
    private String ppProducttypeNo;
    private String ppLoanApplyid;

    private Integer ppBulkloanstatus;
    
    private Date ppBulkloanstarttime;
    private Date ppBulkloanendtime;
    private Date ppBulkloaneffecttime;
	private String ppBulkloandealseconds;
	
    private BigDecimal ppTerderminamount;
    private BigDecimal ppTendermaxamount;
    private BigDecimal ppTenderincreaseamount;
    
    private Integer ppActivityType;//产品活动类型1：新手体验
    private String ptrTenderFlowNo;//投资单号
    private String type;//临时字段
    private Integer ppInvestmentType; //投资类型1.直投标2.债转标3.资产包
    
    private String pp_inviteCode;  //邀请码  如果存在，往前台发送'BBJF', 不存在为 null 

    private Integer ppDuration;//项目总共日数
    
    /** 临时字段 **/
    private String tenderStatus; //投资记录的状态
    private BigDecimal ptr_amount; // 用户该标的投资金额
    private Date ptr_transTime;    // 交易时间
    private String ptr_tradeStatus;// 交易状态
    private String plp_Address;//首页展示图片地址
    private String progress;//进度
    private String pp_loanDesc;//描述
    private BigDecimal residualAmount;//可投金额
    private Long assignCountdown;  //债转标开放购买倒计时，单位毫秒
    
    private String ptp_tenderFlowNo;
    private Integer ptp_profitTerm;
    private BigDecimal ptp_capital;
    private BigDecimal ptp_interest;
    private BigDecimal ptp_profit;

    /** 可债转的冻结期数 */
    private Integer plpLockAssignationSeq;
    /** 计算出来的债转解冻日期 */
    private Date plpLockAssignationDate;
    /** 计算出来的债转解冻时间签 */
    private Long plpLockAssignationDateTime;
    /** 债转的原项目总期数 */
    private Integer plpAssignTerm;
    /** 债转的投资记录ID */
    private String plpAssignTenderNo;
    /** 源自哪个转让项目 */
    private String plpAssignProductNo;
    /** 债转费率  */
    private BigDecimal assignationFeeRate;
    /** 冻结期 那一期的返利状态 */
    private Integer lockAssignationStatus;
    
    /** 是否可以转让：true可以转让，false不可以转让 */
    private Integer isTransfer;
    
	public Integer getIsTransfer() {
		return isTransfer;
	}

	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}

	public Integer getPlpLockAssignationSeq() {
		return plpLockAssignationSeq;
	}

	public void setPlpLockAssignationSeq(Integer plpLockAssignationSeq) {
		this.plpLockAssignationSeq = plpLockAssignationSeq;
	}

	public Date getPlpLockAssignationDate() {
		return plpLockAssignationDate;
	}

	public void setPlpLockAssignationDate(Date plpLockAssignationDate) {
		this.plpLockAssignationDate = plpLockAssignationDate;
	}

	public Integer getPlpAssignTerm() {
		return plpAssignTerm;
	}

	public void setPlpAssignTerm(Integer plpAssignTerm) {
		this.plpAssignTerm = plpAssignTerm;
	}

	public String getPlpAssignTenderNo() {
		return plpAssignTenderNo;
	}

	public void setPlpAssignTenderNo(String plpAssignTenderNo) {
		this.plpAssignTenderNo = plpAssignTenderNo;
	}

	public String getPlpAssignProductNo() {
		return plpAssignProductNo;
	}

	public void setPlpAssignProductNo(String plpAssignProductNo) {
		this.plpAssignProductNo = plpAssignProductNo;
	}

	public String getPp_inviteCode()
    {
        return pp_inviteCode;
    }

    public void setPp_inviteCode(String pp_inviteCode)
    {
        this.pp_inviteCode = pp_inviteCode;
    }

    public String getPp_loanDesc() {
		return pp_loanDesc;
	}

	public void setPp_loanDesc(String pp_loanDesc) {
		this.pp_loanDesc = pp_loanDesc;
	}

	public String getProgress() {
  		return progress;
  	}

  	public void setProgress(String progress) {
  		this.progress = progress;
  	}

    
    public String getPlp_Address() {
		return plp_Address;
	}

	public void setPlp_Address(String plp_Address) {
		this.plp_Address = plp_Address;
	}

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

   

    public String getPpProducttypeNo() {
		return ppProducttypeNo;
	}

	public void setPpProducttypeNo(String ppProducttypeNo) {
		this.ppProducttypeNo = ppProducttypeNo;
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

	public BigDecimal getPtr_amount() {
		return ptr_amount;
	}

	public void setPtr_amount(BigDecimal ptr_amount) {
		this.ptr_amount = ptr_amount;
	}

	public Date getPtr_transTime() {
		return ptr_transTime;
	}

	public void setPtr_transTime(Date ptr_transTime) {
		this.ptr_transTime = ptr_transTime;
	}

	public String getPtr_tradeStatus() {
		return ptr_tradeStatus;
	}

	public void setPtr_tradeStatus(String ptr_tradeStatus) {
		this.ptr_tradeStatus = ptr_tradeStatus;
	}



	public Integer getPpActivityType() {
		return ppActivityType;
	}

	public void setPpActivityType(Integer ppActivityType) {
		this.ppActivityType = ppActivityType;
	}

	public String getPtrTenderFlowNo() {
		return ptrTenderFlowNo;
	}

	public void setPtrTenderFlowNo(String ptrTenderFlowNo) {
		this.ptrTenderFlowNo = ptrTenderFlowNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPpInvestmentType() {
		return ppInvestmentType;
	}

	public void setPpInvestmentType(Integer ppInvestmentType) {
		this.ppInvestmentType = ppInvestmentType;
	}

    public BigDecimal getResidualAmount()
    {
        return residualAmount;
    }

    public void setResidualAmount(BigDecimal residualAmount)
    {
        this.residualAmount = residualAmount;
    }

    public Long getAssignCountdown()
    {
        return assignCountdown;
    }

    public void setAssignCountdown(Long assignCountdown)
    {
        this.assignCountdown = assignCountdown;
    }

    public BigDecimal getAssignationFeeRate()
    {
        return assignationFeeRate;
    }

    public void setAssignationFeeRate(BigDecimal assignationFeeRate)
    {
        this.assignationFeeRate = assignationFeeRate;
    }
	
	public String getTenderStatus() {
		return tenderStatus;
	}

	public void setTenderStatus(String tenderStatus) {
		this.tenderStatus = tenderStatus;
	}

	public Long getPlpLockAssignationDateTime() {
		return plpLockAssignationDateTime;
	}

	public void setPlpLockAssignationDateTime(Long plpLockAssignationDateTime) {
		this.plpLockAssignationDateTime = plpLockAssignationDateTime;
	}

	public String getPtp_tenderFlowNo() {
		return ptp_tenderFlowNo;
	}

	public void setPtp_tenderFlowNo(String ptp_tenderFlowNo) {
		this.ptp_tenderFlowNo = ptp_tenderFlowNo;
	}

	public Integer getPtp_profitTerm() {
		return ptp_profitTerm;
	}

	public void setPtp_profitTerm(Integer ptp_profitTerm) {
		this.ptp_profitTerm = ptp_profitTerm;
	}

	public BigDecimal getPtp_capital() {
		return ptp_capital;
	}

	public void setPtp_capital(BigDecimal ptp_capital) {
		this.ptp_capital = ptp_capital;
	}

	public BigDecimal getPtp_interest() {
		return ptp_interest;
	}

	public void setPtp_interest(BigDecimal ptp_interest) {
		this.ptp_interest = ptp_interest;
	}

	public BigDecimal getPtp_profit() {
		return ptp_profit;
	}

	public void setPtp_profit(BigDecimal ptp_profit) {
		this.ptp_profit = ptp_profit;
	}

	public Integer getLockAssignationStatus() {
		return lockAssignationStatus;
	}

	public void setLockAssignationStatus(Integer lockAssignationStatus) {
		this.lockAssignationStatus = lockAssignationStatus;
	}

	public Integer getPpDuration() {
		return ppDuration;
	}

	public void setPpDuration(Integer ppDuration) {
		this.ppDuration = ppDuration;
	}
}