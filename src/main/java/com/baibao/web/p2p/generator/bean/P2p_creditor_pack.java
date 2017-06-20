package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;

import org.apache.openjpa.ee.RegistryManagedRuntime;

import com.baibao.core.utils.StringUtil;

public class P2p_creditor_pack
{
	private Long pcpId;
	/** 产品标号 */
	private String pcpProductNo;
	/** 债务人用户编号 */
	private String pcpCustNo;
	/** 债务人姓名 */
	private String pcpRealName;
	/** 贷款金额 */
	private BigDecimal pcpAmount;
	/** 类型 */
	private String pcpCertType;
	/** 身份证号 */
	private String pcpCertNo;
	/** 年龄 */
	private String pcpAge;
	/** 婚姻状况 */
	private String pcpMateria;
	/** 居住地址 */
	private String pcpAddress;
	/** 籍贯 */
	private String pcpNativePlace;
	/** 工作城市 */
	private String pcpWorkCity;
	/** 工作地址 */
	private String pcpWorkAddress;
	/** 学历 */
	private String pcpEducation;
	/** 工作年龄 */
	private String pcpWorkAge;
	/** 工作职位 */
	private String pcpWorkPosition;
	/** 月收入 */
	private String pcpMonthSalary;
	/** 备注 */
	private String pcpRemark;

	public Long getPcpId() {
		return pcpId;
	}
	public void setPcpId(Long pcpId) {
		this.pcpId = pcpId;
	}
	public String getPcpProductNo() {
		return pcpProductNo;
	}
	public void setPcpProductNo(String pcpProductNo) {
		this.pcpProductNo = pcpProductNo;
	}
	public String getPcpCustNo() {
		return pcpCustNo;
	}
	public void setPcpCustNo(String pcpCustNo) {
		this.pcpCustNo = pcpCustNo;
	}
	public String getPcpRealName() {
		return pcpRealName;
	}
	public void setPcpRealName(String pcpRealName) {
		this.pcpRealName = pcpRealName;
	}
	public BigDecimal getPcpAmount() {
		return pcpAmount;
	}
	public void setPcpAmount(BigDecimal pcpAmount) {
		this.pcpAmount = pcpAmount;
	}
	public String getPcpRemark() {
		return pcpRemark;
	}
	public void setPcpRemark(String pcpRemark) {
		this.pcpRemark = pcpRemark;
	}
	public String getPcpCertType() {
		return pcpCertType;
	}
	public void setPcpCertType(String pcpCertType) {
		this.pcpCertType = pcpCertType;
	}
	public String getPcpCertNo() {
		
		return pcpCertNo;
	}
	public void setPcpCertNo(String pcpCertNo) {
		this.pcpCertNo = pcpCertNo;
	}
	public String getPcpAge() {
		return pcpAge;
	}
	public void setPcpAge(String pcpAge) {
		this.pcpAge = pcpAge;
	}
	public String getPcpMateria() {
		return pcpMateria;
	}
	public void setPcpMateria(String pcpMateria) {
		this.pcpMateria = pcpMateria;
	}
	public String getPcpAddress() {
		return pcpAddress;
	}
	public void setPcpAddress(String pcpAddress) {
		this.pcpAddress = pcpAddress;
	}
	public String getPcpNativePlace() {
		return pcpNativePlace;
	}
	public void setPcpNativePlace(String pcpNativePlace) {
		this.pcpNativePlace = pcpNativePlace;
	}
	public String getPcpWorkCity() {
		return pcpWorkCity;
	}
	public void setPcpWorkCity(String pcpWorkCity) {
		this.pcpWorkCity = pcpWorkCity;
	}
	public String getPcpWorkAddress() {
		return pcpWorkAddress;
	}
	public void setPcpWorkAddress(String pcpWorkAddress) {
		this.pcpWorkAddress = pcpWorkAddress;
	}
	public String getPcpWorkAge() {
		return pcpWorkAge;
	}
	public void setPcpWorkAge(String pcpWorkAge) {
		this.pcpWorkAge = pcpWorkAge;
	}
	public String getPcpWorkPosition() {
		return pcpWorkPosition;
	}
	public void setPcpWorkPosition(String pcpWorkPosition) {
		this.pcpWorkPosition = pcpWorkPosition;
	}
	public String getPcpMonthSalary() {
		return pcpMonthSalary;
	}
	public void setPcpMonthSalary(String pcpMonthSalary) {
		this.pcpMonthSalary = pcpMonthSalary;
	}
	public String getPcpEducation() {
		return pcpEducation;
	}
	public void setPcpEducation(String pcpEducation) {
		this.pcpEducation = pcpEducation;
	}
	/**
	 * 替换姓名：赵**
	 * @return
	 */
	public String fetchMaskRealName(){
		return 	StringUtil.replaceRealName(pcpRealName);
	}
	/**
	 * 替换身份证
	 * @return
	 */
	public String fetchMaskPcpCertNo(){
		return 	StringUtil.replaceIdCard(pcpCertNo);
	}
	
}
