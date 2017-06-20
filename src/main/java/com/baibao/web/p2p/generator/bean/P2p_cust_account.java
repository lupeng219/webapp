package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class P2p_cust_account implements Serializable{
   
	private static final long serialVersionUID = 1L;

    private String pcaCustNo;                   //用户编号
    private String pcaAccountno;                //支付账号
    private String pcaAccounttype;              //账号类型  00 企业 01 个人
    private String pcaCustodyType;              //第三方分类 1.富友
    private BigDecimal pcaAccountBalance;       //账户余额
    private BigDecimal pcaAccountFreeze;        //账户冻结额度
    /*
    private BigDecimal pcaAccountRecharge;      //充值金额
    private BigDecimal pcaMentionNow;           //提现金额
    private BigDecimal pcaInvestmoney;          //投资总额
    */
    private Date pcaAccountOpenTime;            //创建时间
    private Date pcaModifytime;                 //最后更改时间
    private String pcaStatus;                   //状态：10使用中 11冻结 12未激活
    private String pcaPayPassword;              //交易密码

    public String getPcaCustNo() {
        return pcaCustNo;
    }

    public void setPcaCustNo(String pcaCustNo) {
        this.pcaCustNo = pcaCustNo == null ? null : pcaCustNo.trim();
    }

    public String getPcaAccountno() {
        return pcaAccountno;
    }

    public void setPcaAccountno(String pcaAccountno) {
        this.pcaAccountno = pcaAccountno == null ? null : pcaAccountno.trim();
    }

    public String getPcaAccounttype() {
        return pcaAccounttype;
    }

    public void setPcaAccounttype(String pcaAccounttype) {
        this.pcaAccounttype = pcaAccounttype == null ? null : pcaAccounttype.trim();
    }

    public String getPcaCustodyType() {
        return pcaCustodyType;
    }

    public void setPcaCustodyType(String pcaCustodyType) {
        this.pcaCustodyType = pcaCustodyType == null ? null : pcaCustodyType.trim();
    }

    public BigDecimal getPcaAccountBalance() {
        return pcaAccountBalance;
    }

    public void setPcaAccountBalance(BigDecimal pcaAccountBalance) {
        this.pcaAccountBalance = pcaAccountBalance;
    }

    public BigDecimal getPcaAccountFreeze() {
        return pcaAccountFreeze;
    }

    public void setPcaAccountFreeze(BigDecimal pcaAccountFreeze) {
        this.pcaAccountFreeze = pcaAccountFreeze;
    }

    public Date getPcaAccountOpenTime() {
        return pcaAccountOpenTime;
    }

    public void setPcaAccountOpenTime(Date pcaAccountOpenTime) {
        this.pcaAccountOpenTime = pcaAccountOpenTime;
    }

    public Date getPcaModifytime() {
        return pcaModifytime;
    }

    public void setPcaModifytime(Date pcaModifytime) {
        this.pcaModifytime = pcaModifytime;
    }

    public String getPcaStatus() {
        return pcaStatus;
    }

    public void setPcaStatus(String pcaStatus) {
        this.pcaStatus = pcaStatus == null ? null : pcaStatus.trim();
    }

	public String getPcaPayPassword() {
		return pcaPayPassword;
	}

	public void setPcaPayPassword(String pcaPayPassword) {
		this.pcaPayPassword = pcaPayPassword;
	}
    
    
}