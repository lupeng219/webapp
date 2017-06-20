package com.baibao.web.p2p.generator.bean;

public class P2p_bank_card {
    private Long pbcId;//银行卡ID
    private String pbcCustno;//客户号
    private String pbcRequestno;//绑卡请求号
   /* private String pbcBankcardid;//银行卡编号*/ 
   private String pbcAccountno;//支付账号
    private String pbcBankcardno;//银行卡号
    private String pbcBankcode;//银行编号
    private String pbcBankName;//银行卡名称
    private String pbcBankcardname;//户名
    private String pbcCardType;//卡类型
    private String pbcCardAttribute;//卡属性
    private String pbcCertType;//证件类型
    private String pbcCertNo;//证件号码
    private String pbcPhoneNo;//银行预留手机号
    private String pbcValidityPeriod;//有效期 （月份/年份）：信用卡专用字段
    private String pbcVerificationValue;//CVV2：信用卡专用字段
/*    private String pbcProvince;//code省份
    private String pbcCity;//code城市*/
    private String pbcProvinceName;///////////省份
    private String pbcCityName;///////////城市
    private String pbcBankBranch;//银行支行名称
    private String pbcVerifyMode;//认证方式
    private String pbcExtendParam;//扩展信息
    private String pbcInputtime;//绑定时间
    private String pbcIssafecard;//是否安全卡  Y：安全卡;N：非安全卡
    /*private String pbcTicket;//后续推进需要的参数*/
    private String pbcIfadvance;//是否完成推进  00未完成   01 已完成
    private String pbccardId;/////////////////////卡ID
   /* private String pbcisVerified; ///////////是否采用卡认证的方式*/
    private String pbcResponseCode;//绑卡新浪返回码
    
    private String bankLogo;//银行logo
    
    public String getBankLogo() {
		return bankLogo;
	}

	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}

	public Long getPbcId() {
        return pbcId;
    }

    public void setPbcId(Long pbcId) {
        this.pbcId = pbcId;
    }

    public String getPbcCustno() {
        return pbcCustno;
    }

    public void setPbcCustno(String pbcCustno) {
        this.pbcCustno = pbcCustno == null ? null : pbcCustno.trim();
    }

    public String getPbcRequestno() {
        return pbcRequestno;
    }

    public void setPbcRequestno(String pbcRequestno) {
        this.pbcRequestno = pbcRequestno == null ? null : pbcRequestno.trim();
    }

    public String getPbcAccountno() {
        return pbcAccountno;
    }

    public void setPbcAccountno(String pbcAccountno) {
        this.pbcAccountno = pbcAccountno == null ? null : pbcAccountno.trim();
    }

    public String getPbcBankcardno() {
        return pbcBankcardno;
    }

    public void setPbcBankcardno(String pbcBankcardno) {
        this.pbcBankcardno = pbcBankcardno == null ? null : pbcBankcardno.trim();
    }

    public String getPbcBankcode() {
        return pbcBankcode;
    }

    public void setPbcBankcode(String pbcBankcode) {
        this.pbcBankcode = pbcBankcode == null ? null : pbcBankcode.trim();
    }

    public String getPbcBankcardname() {
        return pbcBankcardname;
    }

    public void setPbcBankcardname(String pbcBankcardname) {
        this.pbcBankcardname = pbcBankcardname == null ? null : pbcBankcardname.trim();
    }

    public String getPbcCardType() {
        return pbcCardType;
    }

    public void setPbcCardType(String pbcCardType) {
        this.pbcCardType = pbcCardType == null ? null : pbcCardType.trim();
    }

    public String getPbcCardAttribute() {
        return pbcCardAttribute;
    }

    public void setPbcCardAttribute(String pbcCardAttribute) {
        this.pbcCardAttribute = pbcCardAttribute == null ? null : pbcCardAttribute.trim();
    }

    public String getPbcCertType() {
        return pbcCertType;
    }

    public void setPbcCertType(String pbcCertType) {
        this.pbcCertType = pbcCertType == null ? null : pbcCertType.trim();
    }

    public String getPbcCertNo() {
        return pbcCertNo;
    }

    public void setPbcCertNo(String pbcCertNo) {
        this.pbcCertNo = pbcCertNo == null ? null : pbcCertNo.trim();
    }

    public String getPbcPhoneNo() {
        return pbcPhoneNo;
    }

    public void setPbcPhoneNo(String pbcPhoneNo) {
        this.pbcPhoneNo = pbcPhoneNo == null ? null : pbcPhoneNo.trim();
    }

    public String getPbcValidityPeriod() {
        return pbcValidityPeriod;
    }

    public void setPbcValidityPeriod(String pbcValidityPeriod) {
        this.pbcValidityPeriod = pbcValidityPeriod == null ? null : pbcValidityPeriod.trim();
    }

    public String getPbcVerificationValue() {
        return pbcVerificationValue;
    }

    public void setPbcVerificationValue(String pbcVerificationValue) {
        this.pbcVerificationValue = pbcVerificationValue == null ? null : pbcVerificationValue.trim();
    }

    public String getPbcBankBranch() {
        return pbcBankBranch;
    }

    public void setPbcBankBranch(String pbcBankBranch) {
        this.pbcBankBranch = pbcBankBranch == null ? null : pbcBankBranch.trim();
    }

    public String getPbcVerifyMode() {
        return pbcVerifyMode;
    }

    public void setPbcVerifyMode(String pbcVerifyMode) {
        this.pbcVerifyMode = pbcVerifyMode == null ? null : pbcVerifyMode.trim();
    }

    public String getPbcExtendParam() {
        return pbcExtendParam;
    }

    public void setPbcExtendParam(String pbcExtendParam) {
        this.pbcExtendParam = pbcExtendParam == null ? null : pbcExtendParam.trim();
    }

    public String getPbcInputtime() {
        return pbcInputtime;
    }

    public void setPbcInputtime(String pbcInputtime) {
        this.pbcInputtime = pbcInputtime == null ? null : pbcInputtime.trim();
    }

    public String getPbcIssafecard() {
        return pbcIssafecard;
    }

    public void setPbcIssafecard(String pbcIssafecard) {
        this.pbcIssafecard = pbcIssafecard == null ? null : pbcIssafecard.trim();
    }

    public String getPbcIfadvance() {
        return pbcIfadvance;
    }

    public void setPbcIfadvance(String pbcIfadvance) {
        this.pbcIfadvance = pbcIfadvance == null ? null : pbcIfadvance.trim();
    }

	public String getPbccardId() {
		return pbccardId;
	}

	public void setPbccardId(String pbccardId) {
		this.pbccardId = pbccardId;
	}

	public String getPbcResponseCode() {
		return pbcResponseCode;
	}

	public void setPbcResponseCode(String pbcResponseCode) {
		this.pbcResponseCode = pbcResponseCode;
	}

	public String getPbcBankName() {
		return pbcBankName;
	}

	public void setPbcBankName(String pbcBankName) {
		this.pbcBankName = pbcBankName;
	}

	public String getPbcProvinceName() {
		return pbcProvinceName;
	}

	public void setPbcProvinceName(String pbcProvinceName) {
		this.pbcProvinceName = pbcProvinceName;
	}

	public String getPbcCityName() {
		return pbcCityName;
	}

	public void setPbcCityName(String pbcCityName) {
		this.pbcCityName = pbcCityName;
	}
    
}