package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lupeng
 * @date: 2016年1月12日下午4:47:00
 */
public class p2p_sysMsg implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息id
	 * 
	 */
	private String sysMsgID;
	
	/**
	 * 消息类型
	 */
	private String sysMsgType;
	
	private String custNo;//客户号
	
	private String isRead;//是否已读 1是，0否
	/**
	 * 消息内容
	 */
	private String sysMsgContent;
	
	/**
	 * 消息发布时间
	 */
	private Date sysMsgPubTime;

	public String getSysMsgID() {
		return sysMsgID;
	}

	public void setSysMsgID(String sysMsgID) {
		this.sysMsgID = sysMsgID;
	}

	
	public String getSysMsgContent() {
		return sysMsgContent;
	}

	public void setSysMsgContent(String sysMsgContent) {
		this.sysMsgContent = sysMsgContent;
	}

	public Date getSysMsgPubTime() {
		return sysMsgPubTime;
	}

	public void setSysMsgPubTime(Date sysMsgPubTime) {
		this.sysMsgPubTime = sysMsgPubTime;
	}

	public String getSysMsgType() {
		return sysMsgType;
	}

	public void setSysMsgType(String sysMsgType) {
		this.sysMsgType = sysMsgType;
	}

	public String getCustNo() {
		return custNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}
	
	
}
