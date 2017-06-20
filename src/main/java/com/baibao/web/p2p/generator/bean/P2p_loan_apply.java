package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 借款申请表
 * @author hs
 * @date  2016年6月22日
 */
public class P2p_loan_apply {
	
	private String ppProductNo;//借款编号
	
    private String ppCustno;//客户编号

    private String ppProducttype;//产品类型

    private Date ppLoanapplytime;//申请借款时间

    private Integer ppLoanterm;//借款期限

    private BigDecimal ppLoanamount;//借款目标金额

    private Long ppLoanmanagefeerate;//借款管理费率

    private Long ppComprehensiverate;//借款年利率

    private BigDecimal plaAssignationFeeRate;

    private String ppLoandesc;//借款描述
    /** 0等额本息,1先息后本,2按天计息,3等额本金,4等本等息  备注：按照后台上标的选项加的备注 */
    private Integer ppLoanrepayment;//0等额本息,1等额本金,2先息后本,3到期还本付息,4p2p产品

    private String ppLoanapplystatus;//21初审待审,22初审拒绝,31复审待审,32复审拒绝,41已完成

    private Date ppLoangranttime;//借款放款时间

    private Date ppLoanrepaymenttime;//借款到期时间

    private String ppLoanpurpose;//借款用途

    private String ppLoantitle;//借款标题

    private Long ppRepaymentamount;//应还款总额

    private String ppLoanApplyMobile;//借款申请时，填写的手机号码(需要经过在线发验证码验证)

    private String ppGuaranteeinfo;//担保信息

    private String ppMortgageinfo;//抵押信息

    private String ppRiskmeasure;//风险措施

    private Long ppGuaranteefeerate;//担保费率

    private Long ppServicefeerate;//服务费率

    private Long ppRiskmanageamountrate;//风险备用金率

    private Long ppRiskmanageamount;//风险备用金

    private Long ppInterestfeerate;//利息管理费率

    private String ppPrincipalname;//被代理人真实姓名

    private String ppPrincipalidcard;//被代理人身份证

    private Integer ppApplytype;//10 外部申请, 11内部发标

    private String ppRemark;//审核意见

    //临时字段
    private String puMobile;//用户手机号
    
    private String ppProvince;//代理人所在省份
    
    private String ppCity;//代理人所在城市

    private String ppModelcar;//车的型号
    
    private String ppVehicleRegistration;//车辆登记地
    
    private String ppCellName;//小区名称
    
    private String ppBuiltupArea;//建筑面积
    
    private String ppBorrowerType;//借款人类型 1：个人，2：企业

    private String ppCompanyName;//企业公司名称
    
    private String ppOwnedIndustry;//所属行业
    
    private Date ppSetUpTime;//成立时间
    
    private String ppRegisteredCapital;//注册资本
    
    private String ppOtherLoans;//有无其他贷款  1:有，2：无
    
    private String mortgageMode;//借款类型 1：车抵押2：房抵押0：信用

    public String getPpProductNo() {
		return ppProductNo;
	}

	public void setPpProductNo(String ppProductNo) {
		this.ppProductNo = ppProductNo;
	}

	public String getPpCustno() {
        return ppCustno;
    }

    public void setPpCustno(String ppCustno) {
        this.ppCustno = ppCustno == null ? null : ppCustno.trim();
    }

    public String getPpProducttype() {
        return ppProducttype;
    }

    public void setPpProducttype(String ppProducttype) {
        this.ppProducttype = ppProducttype == null ? null : ppProducttype.trim();
    }

    public Date getPpLoanapplytime() {
        return ppLoanapplytime;
    }

    public void setPpLoanapplytime(Date ppLoanapplytime) {
        this.ppLoanapplytime = ppLoanapplytime;
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

    public Long getPpLoanmanagefeerate() {
        return ppLoanmanagefeerate;
    }

    public void setPpLoanmanagefeerate(Long ppLoanmanagefeerate) {
        this.ppLoanmanagefeerate = ppLoanmanagefeerate;
    }

    public Long getPpComprehensiverate() {
        return ppComprehensiverate;
    }

    public void setPpComprehensiverate(Long ppComprehensiverate) {
        this.ppComprehensiverate = ppComprehensiverate;
    }

    public String getPpLoandesc() {
        return ppLoandesc;
    }

    public void setPpLoandesc(String ppLoandesc) {
        this.ppLoandesc = ppLoandesc == null ? null : ppLoandesc.trim();
    }

    public Integer getPpLoanrepayment() {
        return ppLoanrepayment;
    }

    public void setPpLoanrepayment(Integer ppLoanrepayment) {
        this.ppLoanrepayment = ppLoanrepayment;
    }

    public String getPpLoanapplystatus() {
        return ppLoanapplystatus;
    }

    public void setPpLoanapplystatus(String ppLoanapplystatus) {
        this.ppLoanapplystatus = ppLoanapplystatus;
    }

    public Date getPpLoangranttime() {
        return ppLoangranttime;
    }

    public void setPpLoangranttime(Date ppLoangranttime) {
        this.ppLoangranttime = ppLoangranttime;
    }

    public Date getPpLoanrepaymenttime() {
        return ppLoanrepaymenttime;
    }

    public void setPpLoanrepaymenttime(Date ppLoanrepaymenttime) {
        this.ppLoanrepaymenttime = ppLoanrepaymenttime;
    }

    public String getPpLoanpurpose() {
        return ppLoanpurpose;
    }

    public void setPpLoanpurpose(String ppLoanpurpose) {
        this.ppLoanpurpose = ppLoanpurpose == null ? null : ppLoanpurpose.trim();
    }

    public String getPpLoantitle() {
        return ppLoantitle;
    }

    public void setPpLoantitle(String ppLoantitle) {
        this.ppLoantitle = ppLoantitle == null ? null : ppLoantitle.trim();
    }

    public Long getPpRepaymentamount() {
        return ppRepaymentamount;
    }

    public void setPpRepaymentamount(Long ppRepaymentamount) {
        this.ppRepaymentamount = ppRepaymentamount;
    }

    public String getPpLoanapplymobile() {
        return ppLoanApplyMobile;
    }

    public void setPpLoanapplymobile(String ppLoanapplymobile) {
        this.ppLoanApplyMobile = ppLoanapplymobile == null ? null : ppLoanapplymobile.trim();
    }

    public String getPpGuaranteeinfo() {
        return ppGuaranteeinfo;
    }

    public void setPpGuaranteeinfo(String ppGuaranteeinfo) {
        this.ppGuaranteeinfo = ppGuaranteeinfo == null ? null : ppGuaranteeinfo.trim();
    }

    public String getPpMortgageinfo() {
        return ppMortgageinfo;
    }

    public void setPpMortgageinfo(String ppMortgageinfo) {
        this.ppMortgageinfo = ppMortgageinfo == null ? null : ppMortgageinfo.trim();
    }

    public String getPpRiskmeasure() {
        return ppRiskmeasure;
    }

    public void setPpRiskmeasure(String ppRiskmeasure) {
        this.ppRiskmeasure = ppRiskmeasure == null ? null : ppRiskmeasure.trim();
    }

    public Long getPpGuaranteefeerate() {
        return ppGuaranteefeerate;
    }

    public void setPpGuaranteefeerate(Long ppGuaranteefeerate) {
        this.ppGuaranteefeerate = ppGuaranteefeerate;
    }

    public Long getPpServicefeerate() {
        return ppServicefeerate;
    }

    public void setPpServicefeerate(Long ppServicefeerate) {
        this.ppServicefeerate = ppServicefeerate;
    }

    public Long getPpRiskmanageamountrate() {
        return ppRiskmanageamountrate;
    }

    public void setPpRiskmanageamountrate(Long ppRiskmanageamountrate) {
        this.ppRiskmanageamountrate = ppRiskmanageamountrate;
    }

    public Long getPpRiskmanageamount() {
        return ppRiskmanageamount;
    }

    public void setPpRiskmanageamount(Long ppRiskmanageamount) {
        this.ppRiskmanageamount = ppRiskmanageamount;
    }

    public Long getPpInterestfeerate() {
        return ppInterestfeerate;
    }

    public void setPpInterestfeerate(Long ppInterestfeerate) {
        this.ppInterestfeerate = ppInterestfeerate;
    }

    public String getPpPrincipalname() {
        return ppPrincipalname;
    }

    public void setPpPrincipalname(String ppPrincipalname) {
        this.ppPrincipalname = ppPrincipalname == null ? null : ppPrincipalname.trim();
    }

    public String getPpPrincipalidcard() {
        return ppPrincipalidcard;
    }

    public void setPpPrincipalidcard(String ppPrincipalidcard) {
        this.ppPrincipalidcard = ppPrincipalidcard == null ? null : ppPrincipalidcard.trim();
    }

    public Integer getPpApplytype() {
        return ppApplytype;
    }

    public void setPpApplytype(Integer ppApplytype) {
        this.ppApplytype = ppApplytype;
    }

    public String getPpRemark() {
        return ppRemark;
    }

    public void setPpRemark(String ppRemark) {
        this.ppRemark = ppRemark == null ? null : ppRemark.trim();
    }

	public String getPuMobile() {
		return puMobile;
	}

	public void setPuMobile(String puMobile) {
		this.puMobile = puMobile;
	}


	public String getPpProvince() {
		return ppProvince;
	}

	public void setPpProvince(String ppProvince) {
		this.ppProvince = ppProvince;
	}

	public String getPpCity() {
		return ppCity;
	}

	public void setPpCity(String ppCity) {
		this.ppCity = ppCity;
	}

	public String getPpModelcar() {
		return ppModelcar;
	}

	public void setPpModelcar(String ppModelcar) {
		this.ppModelcar = ppModelcar;
	}

	public String getPpVehicleRegistration() {
		return ppVehicleRegistration;
	}

	public void setPpVehicleRegistration(String ppVehicleRegistration) {
		this.ppVehicleRegistration = ppVehicleRegistration;
	}

	public String getPpCellName() {
		return ppCellName;
	}

	public void setPpCellName(String ppCellName) {
		this.ppCellName = ppCellName;
	}

	public String getPpBuiltupArea() {
		return ppBuiltupArea;
	}

	public void setPpBuiltupArea(String ppBuiltupArea) {
		this.ppBuiltupArea = ppBuiltupArea;
	}

	public String getPpLoanApplyMobile() {
		return ppLoanApplyMobile;
	}

	public void setPpLoanApplyMobile(String ppLoanApplyMobile) {
		this.ppLoanApplyMobile = ppLoanApplyMobile;
	}

	public String getPpBorrowerType() {
		return ppBorrowerType;
	}

	public void setPpBorrowerType(String ppBorrowerType) {
		this.ppBorrowerType = ppBorrowerType;
	}

	public String getPpCompanyName() {
		return ppCompanyName;
	}

	public void setPpCompanyName(String ppCompanyName) {
		this.ppCompanyName = ppCompanyName;
	}

	public String getPpOwnedIndustry() {
		return ppOwnedIndustry;
	}

	public void setPpOwnedIndustry(String ppOwnedIndustry) {
		this.ppOwnedIndustry = ppOwnedIndustry;
	}

	public Date getPpSetUpTime() {
		return ppSetUpTime;
	}

	public void setPpSetUpTime(Date ppSetUpTime) {
		this.ppSetUpTime = ppSetUpTime;
	}

	public String getPpRegisteredCapital() {
		return ppRegisteredCapital;
	}

	public void setPpRegisteredCapital(String ppRegisteredCapital) {
		this.ppRegisteredCapital = ppRegisteredCapital;
	}

	public String getPpOtherLoans() {
		return ppOtherLoans;
	}

	public void setPpOtherLoans(String ppOtherLoans) {
		this.ppOtherLoans = ppOtherLoans;
	}

	public String getMortgageMode() {
		return mortgageMode;
	}

	public void setMortgageMode(String mortgageMode) {
		this.mortgageMode = mortgageMode;
	}

	public BigDecimal getPlaAssignationFeeRate() {
		return plaAssignationFeeRate;
	}

	public void setPlaAssignationFeeRate(BigDecimal plaAssignationFeeRate) {
		this.plaAssignationFeeRate = plaAssignationFeeRate;
	}

	
    
}