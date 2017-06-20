package com.baibao.web.p2p.generator.bean;

public class P2p_bank_type
{
	/**
	 * 银行编码
	 */
	private String bankCode;
	
	/**
	 * 银行描述
	 */
	private String bankDesc;
	
	/**
	 * 是否支持个人网银
	 */
	private Boolean supportPerson;
	
	/**
	 * 是否支持企业网银
	 */
	private Boolean supportCompany;
	
	/**
	 * 是否支持快捷支付
	 */
	private Boolean supportQuickPay;
	
	/**
	 * 首次绑定支付限额(元)
	 */
	private Integer firstBindLimit;
	
	/**
	 * 快捷支付单笔限额(元)
	 */
	private Integer singleLimit;
	
	/**
	 * 快捷支付单日累计限额(元)
	 */
	private Integer singleDayLimit;
	
	/**
	 * 单笔最低限额(元)
	 */
	private Double singleMinimum;
	/**
	 * 银行logo
	 */
	private String bankLogo;
	

	public String getBankLogo() {
		return bankLogo;
	}

	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankDesc() {
		return bankDesc;
	}

	public void setBankDesc(String bankDesc) {
		this.bankDesc = bankDesc;
	}

	public Boolean getSupportPerson() {
		return supportPerson;
	}

	public void setSupportPerson(Boolean supportPerson) {
		this.supportPerson = supportPerson;
	}

	public Boolean getSupportCompany() {
		return supportCompany;
	}

	public void setSupportCompany(Boolean supportCompany) {
		this.supportCompany = supportCompany;
	}

	public Boolean getSupportQuickPay() {
		return supportQuickPay;
	}

	public void setSupportQuickPay(Boolean supportQuickPay) {
		this.supportQuickPay = supportQuickPay;
	}

	public Integer getFirstBindLimit() {
		return firstBindLimit;
	}

	public void setFirstBindLimit(Integer firstBindLimit) {
		this.firstBindLimit = firstBindLimit;
	}

	public Integer getSingleLimit() {
		return singleLimit;
	}

	public void setSingleLimit(Integer singleLimit) {
		this.singleLimit = singleLimit;
	}

	public Integer getSingleDayLimit() {
		return singleDayLimit;
	}

	public void setSingleDayLimit(Integer singleDayLimit) {
		this.singleDayLimit = singleDayLimit;
	}

	public Double getSingleMinimum() {
		return singleMinimum;
	}

	public void setSingleMinimum(Double singleMinimum) {
		this.singleMinimum = singleMinimum;
	}
}
