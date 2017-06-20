package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author hs
 *
 * @date 2017年2月8日
 */
public class P2pInitParams implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 关于我们
	 */
	private String contactus;
	/**
	 *安全中心
	 */
	private String security;
	/**
	 * 协议范本
	 */
	private String contract;
	/**
	 * 注册协议
	 */
	private String registerAgreement;
	/**
	 * 帮助中心
	 */
	private String helpCenterApp;
	/**
	 * 电话号码
	 */
	private String telephone;
	/**
	 * 新手引导
	 */
	private String beginerGuide;
	public P2pInitParams() {
	}
	public String getContactus() {
		return contactus;
	}
	public void setContactus(String contactus) {
		this.contactus = contactus;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getContract() {
		return contract;
	}
	public void setContract(String contract) {
		this.contract = contract;
	}
	public String getRegisterAgreement() {
		return registerAgreement;
	}
	public void setRegisterAgreement(String registerAgreement) {
		this.registerAgreement = registerAgreement;
	}
	public String getHelpCenterApp() {
		return helpCenterApp;
	}
	public void setHelpCenterApp(String helpCenterApp) {
		this.helpCenterApp = helpCenterApp;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getBeginerGuide() {
		return beginerGuide;
	}
	public void setBeginerGuide(String beginerGuide) {
		this.beginerGuide = beginerGuide;
	}
	
}
