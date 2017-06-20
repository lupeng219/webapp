package com.baibao.web.p2p.generator.bean;

/**
 * 还款交易表(付款)
 * @author zy
 *
 */
public class P2p_repayment_bill_trans_detail{
	
	private String prdIncomebillno;
	
    private String prdRepaybillno;
	
	private String prdTendertransflowno;
	
	private String prdTradeflowno;
	
   
	private String prdOutaccountno;

    private String prdInaccountno;

    private String prdRepaymentseq;

    private String prdRepaymentmoney;

    private String prdTendertype;

    private String prdStatus;

    private String prdHostResponseTime;

    private String prdHostResponseFlownum;

    private String prdHostReturnCode;

    private String prdHostReturnMessage;

    private String prbProductno;

    private String prdOutcustno;

    private String prdIncustno;
    
    
    

    public String getPrdIncomebillno() {
		return prdIncomebillno;
	}

	public void setPrdIncomebillno(String prdIncomebillno) {
		this.prdIncomebillno = prdIncomebillno;
	}

	public String getPrdRepaybillno() {
		return prdRepaybillno;
	}

	public void setPrdRepaybillno(String prdRepaybillno) {
		this.prdRepaybillno = prdRepaybillno;
	}

	public String getPrdTendertransflowno() {
		return prdTendertransflowno;
	}

	public void setPrdTendertransflowno(String prdTendertransflowno) {
		this.prdTendertransflowno = prdTendertransflowno;
	}

	public String getPrdTradeflowno() {
		return prdTradeflowno;
	}

	public void setPrdTradeflowno(String prdTradeflowno) {
		this.prdTradeflowno = prdTradeflowno;
	}

	public String getPrdOutaccountno() {
        return prdOutaccountno;
    }

    public void setPrdOutaccountno(String prdOutaccountno) {
        this.prdOutaccountno = prdOutaccountno == null ? null : prdOutaccountno.trim();
    }

    public String getPrdInaccountno() {
        return prdInaccountno;
    }

    public void setPrdInaccountno(String prdInaccountno) {
        this.prdInaccountno = prdInaccountno == null ? null : prdInaccountno.trim();
    }

    public String getPrdRepaymentseq() {
        return prdRepaymentseq;
    }

    public void setPrdRepaymentseq(String prdRepaymentseq) {
        this.prdRepaymentseq = prdRepaymentseq == null ? null : prdRepaymentseq.trim();
    }

    public String getPrdRepaymentmoney() {
        return prdRepaymentmoney;
    }

    public void setPrdRepaymentmoney(String prdRepaymentmoney) {
        this.prdRepaymentmoney = prdRepaymentmoney == null ? null : prdRepaymentmoney.trim();
    }

    public String getPrdTendertype() {
        return prdTendertype;
    }

    public void setPrdTendertype(String prdTendertype) {
        this.prdTendertype = prdTendertype == null ? null : prdTendertype.trim();
    }

    public String getPrdStatus() {
        return prdStatus;
    }

    public void setPrdStatus(String prdStatus) {
        this.prdStatus = prdStatus == null ? null : prdStatus.trim();
    }

    public String getPrdHostResponseTime() {
        return prdHostResponseTime;
    }

    public void setPrdHostResponseTime(String prdHostResponseTime) {
        this.prdHostResponseTime = prdHostResponseTime == null ? null : prdHostResponseTime.trim();
    }

    public String getPrdHostResponseFlownum() {
        return prdHostResponseFlownum;
    }

    public void setPrdHostResponseFlownum(String prdHostResponseFlownum) {
        this.prdHostResponseFlownum = prdHostResponseFlownum == null ? null : prdHostResponseFlownum.trim();
    }

    public String getPrdHostReturnCode() {
        return prdHostReturnCode;
    }

    public void setPrdHostReturnCode(String prdHostReturnCode) {
        this.prdHostReturnCode = prdHostReturnCode == null ? null : prdHostReturnCode.trim();
    }

    public String getPrdHostReturnMessage() {
        return prdHostReturnMessage;
    }

    public void setPrdHostReturnMessage(String prdHostReturnMessage) {
        this.prdHostReturnMessage = prdHostReturnMessage == null ? null : prdHostReturnMessage.trim();
    }

    public String getPrbProductno() {
        return prbProductno;
    }

    public void setPrbProductno(String prbProductno) {
        this.prbProductno = prbProductno == null ? null : prbProductno.trim();
    }

    public String getPrdOutcustno() {
        return prdOutcustno;
    }

    public void setPrdOutcustno(String prdOutcustno) {
        this.prdOutcustno = prdOutcustno == null ? null : prdOutcustno.trim();
    }

    public String getPrdIncustno() {
        return prdIncustno;
    }

    public void setPrdIncustno(String prdIncustno) {
        this.prdIncustno = prdIncustno == null ? null : prdIncustno.trim();
    }
}