package com.baibao.web.p2p.utils;

/**
 * 银行卡属性
 * @author liuchangyan
 *
 */
public enum BankCardAttribute {

	B("对公"), 
	C("对私");
	
	private String value;
	
	private BankCardAttribute(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
