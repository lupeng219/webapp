package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

public class P2p_activity_param implements  Serializable{

	/**
	 * 版本id
	 */
	private static final long serialVersionUID = 1L;
	
	private Long paramId;//主键id
	
	private Long activeId;//活动编号
	
	private String fromParamValue;//起始参数值
	
	private String toParamValue;//终止参数值
	
	private String excitationValue;//活动奖励值
	
	private String paramType;//参数类型 0 单笔，1累计
	

	public Long getParamId() {
		return paramId;
	}

	public void setParamId(Long paramId) {
		this.paramId = paramId;
	}

	public Long getActiveId() {
		return activeId;
	}

	public void setActiveId(Long activeId) {
		this.activeId = activeId;
	}

	

	public String getFromParamValue() {
		return fromParamValue;
	}

	public void setFromParamValue(String fromParamValue) {
		this.fromParamValue = fromParamValue;
	}

	public String getToParamValue() {
		return toParamValue;
	}

	public void setToParamValue(String toParamValue) {
		this.toParamValue = toParamValue;
	}

	public String getExcitationValue() {
		return excitationValue;
	}

	public void setExcitationValue(String excitationValue) {
		this.excitationValue = excitationValue;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
	
}
