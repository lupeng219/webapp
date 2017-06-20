package com.baibao.web.p2p.controller.pay;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso(value = {
	CommonAnswer.class
})
@XmlRootElement(name = "ap")
public class FuyouResponse<T>
{
	private T plain;
	private String signature;
	private String message;

	@XmlElement(type = CommonAnswer.class)
	public T getPlain()
	{
		return plain;
	}
	
	public void setPlain(T plain)
	{
		this.plain = plain;
	}

	public String getSignature()
	{
		return signature;
	}

	public void setSignature(String signature)
	{
		this.signature = signature;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
