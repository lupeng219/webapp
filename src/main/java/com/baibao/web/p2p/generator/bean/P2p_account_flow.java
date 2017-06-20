package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_account_flow implements Serializable {
    
	private static final long serialVersionUID = 1L;

    private String pafTransflowno;//交易流水号

    private String pafCustno;//用户编号

    private String pafAccountno;//支付账号

    private BigDecimal pafTransactionmoney;//交易金额

    private Date pafTransactiondatetime;//交易时间

    private String pafTransactiontype;//交易类型：10充值 11提现
    
    private String pafRechargeType;//充值类型

    private String pafChannelnum;//交易渠道

    private String pafRemark;//备注

    private String pafHostResponseTime;//第三方响应时间

    private String pafHostReturnCode;//第三方返回码

    private String pafHostReturnMessage;//第三方返回信息

    private String pafStatus;//状态：00成功01失败02处理中

    private BigDecimal pafFee;//手续费

    private byte[] pafHostFlow;

    public String getPafTransflowno() {
        return pafTransflowno;
    }

    public void setPafTransflowno(String pafTransflowno) {
        this.pafTransflowno = pafTransflowno == null ? null : pafTransflowno.trim();
    }

    public String getPafCustno() {
        return pafCustno;
    }

    public void setPafCustno(String pafCustno) {
        this.pafCustno = pafCustno == null ? null : pafCustno.trim();
    }

    public String getPafAccountno() {
        return pafAccountno;
    }

    public void setPafAccountno(String pafAccountno) {
        this.pafAccountno = pafAccountno == null ? null : pafAccountno.trim();
    }

    public BigDecimal getPafTransactionmoney() {
        return pafTransactionmoney;
    }

    public void setPafTransactionmoney(BigDecimal pafTransactionmoney) {
        this.pafTransactionmoney = pafTransactionmoney;
    }

    public Date getPafTransactiondatetime() {
        return pafTransactiondatetime;
    }

    public void setPafTransactiondatetime(Date pafTransactiondatetime) {
        this.pafTransactiondatetime = pafTransactiondatetime;
    }

    public String getPafTransactiontype() {
        return pafTransactiontype;
    }

    public void setPafTransactiontype(String pafTransactiontype) {
        this.pafTransactiontype = pafTransactiontype == null ? null : pafTransactiontype.trim();
    }

    public String getPafChannelnum() {
        return pafChannelnum;
    }

    public void setPafChannelnum(String pafChannelnum) {
        this.pafChannelnum = pafChannelnum == null ? null : pafChannelnum.trim();
    }

    public String getPafHostResponseTime() {
        return pafHostResponseTime;
    }

    public void setPafHostResponseTime(String pafHostResponseTime) {
        this.pafHostResponseTime = pafHostResponseTime == null ? null : pafHostResponseTime.trim();
    }

    public String getPafHostReturnCode() {
        return pafHostReturnCode;
    }

    public void setPafHostReturnCode(String pafHostReturnCode) {
        this.pafHostReturnCode = pafHostReturnCode == null ? null : pafHostReturnCode.trim();
    }

    public String getPafHostReturnMessage() {
        return pafHostReturnMessage;
    }

    public void setPafHostReturnMessage(String pafHostReturnMessage) {
        this.pafHostReturnMessage = pafHostReturnMessage == null ? null : pafHostReturnMessage.trim();
    }

    public String getPafStatus() {
        return pafStatus;
    }

    public void setPafStatus(String pafStatus) {
        this.pafStatus = pafStatus == null ? null : pafStatus.trim();
    }

    public BigDecimal getPafFee() {
        return pafFee;
    }

    public void setPafFee(BigDecimal pafFee) {
        this.pafFee = pafFee;
    }

    public byte[] getPafHostFlow() {
        return pafHostFlow;
    }

    public void setPafHostFlow(byte[] pafHostFlow) {
        this.pafHostFlow = pafHostFlow;
    }

	public String getPafRechargeType() {
		return pafRechargeType;
	}

	public void setPafRechargeType(String pafRechargeType) {
		this.pafRechargeType = pafRechargeType;
	}

	public String getPafRemark() {
		return pafRemark;
	}

	public void setPafRemark(String pafRemark) {
		this.pafRemark = pafRemark;
	}
    
}