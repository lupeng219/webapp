package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_loan_record implements Serializable{
    
	private static final long serialVersionUID = 1L;
    
    private String ptfTransflowno;
    private BigDecimal ptfOutpayaccfee;
    private BigDecimal ptfRepaymentAmount;
    private String ptfProductNo;
    private String ptfOutAccountno;
    private String ptfOutcustno;
    private String ptfInCustno;
    private String ptfInAccountno;
    private String ptfTenderflowno;
    private Date ptfHostResponseTime;

    private String ptfHostResponseFlownum;

    private String ptfHostReturnCode;

    private String ptfHostReturnMessage;

    private String ptfPaystatus;

    private String ptfRemark;


    public BigDecimal getPtfRepaymentAmount() {
		return ptfRepaymentAmount;
	}

	public void setPtfRepaymentAmount(BigDecimal ptfRepaymentAmount) {
		this.ptfRepaymentAmount = ptfRepaymentAmount;
	}

	public String getPtfTransflowno() {
        return ptfTransflowno;
    }

    public void setPtfTransflowno(String ptfTransflowno) {
        this.ptfTransflowno = ptfTransflowno == null ? null : ptfTransflowno.trim();
    }

    public BigDecimal getPtfOutpayaccfee() {
        return ptfOutpayaccfee;
    }

    public void setPtfOutpayaccfee(BigDecimal ptfOutpayaccfee) {
        this.ptfOutpayaccfee = ptfOutpayaccfee;
    }

  
    public String getPtfOutAccountno() {
		return ptfOutAccountno;
	}

	public void setPtfOutAccountno(String ptfOutAccountno) {
		this.ptfOutAccountno = ptfOutAccountno;
	}

	public String getPtfOutcustno() {
		return ptfOutcustno;
	}

	public void setPtfOutcustno(String ptfOutcustno) {
		this.ptfOutcustno = ptfOutcustno;
	}

	public String getPtfInCustno() {
		return ptfInCustno;
	}

	public void setPtfInCustno(String ptfInCustno) {
		this.ptfInCustno = ptfInCustno;
	}

	public String getPtfInAccountno() {
		return ptfInAccountno;
	}

	public void setPtfInAccountno(String ptfInAccountno) {
		this.ptfInAccountno = ptfInAccountno;
	}


    public String getPtfProductNo() {
		return ptfProductNo;
	}

	public void setPtfProductNo(String ptfProductNo) {
		this.ptfProductNo = ptfProductNo;
	}

	public String getPtfTenderflowno() {
        return ptfTenderflowno;
    }

    public void setPtfTenderflowno(String ptfTenderflowno) {
        this.ptfTenderflowno = ptfTenderflowno == null ? null : ptfTenderflowno.trim();
    }

    public Date getPtfHostResponseTime() {
        return ptfHostResponseTime;
    }

    public void setPtfHostResponseTime(Date ptfHostResponseTime) {
        this.ptfHostResponseTime = ptfHostResponseTime;
    }

    public String getPtfHostResponseFlownum() {
        return ptfHostResponseFlownum;
    }

    public void setPtfHostResponseFlownum(String ptfHostResponseFlownum) {
        this.ptfHostResponseFlownum = ptfHostResponseFlownum == null ? null : ptfHostResponseFlownum.trim();
    }

    public String getPtfHostReturnCode() {
        return ptfHostReturnCode;
    }

    public void setPtfHostReturnCode(String ptfHostReturnCode) {
        this.ptfHostReturnCode = ptfHostReturnCode == null ? null : ptfHostReturnCode.trim();
    }

    public String getPtfHostReturnMessage() {
        return ptfHostReturnMessage;
    }

    public void setPtfHostReturnMessage(String ptfHostReturnMessage) {
        this.ptfHostReturnMessage = ptfHostReturnMessage == null ? null : ptfHostReturnMessage.trim();
    }

    public String getPtfPaystatus() {
        return ptfPaystatus;
    }

    public void setPtfPaystatus(String ptfPaystatus) {
        this.ptfPaystatus = ptfPaystatus == null ? null : ptfPaystatus.trim();
    }

    public String getPtfRemark() {
        return ptfRemark;
    }

    public void setPtfRemark(String ptfRemark) {
        this.ptfRemark = ptfRemark == null ? null : ptfRemark.trim();
    }
}