package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

public class P2p_smsRecord implements Serializable{


	private static final long serialVersionUID = 1L;

	private Long smsRecordId;// 消息记录ID
	private Date sendTime;// 发送时间
	private String smsContent;// 发送内容
	private String sendResult;// 发送结果
	private String realName;// 员工姓名
	private String failPhone; //发送失败手机号
	private String sendType;//发送类型

	public String getFailPhone() {
		return failPhone;
	}

	public void setFailPhone(String failPhone) {
		this.failPhone = failPhone;
	}

	public Long getSmsRecordId() {
		return smsRecordId;
	}

	public void setSmsRecordId(Long smsRecordId) {
		this.smsRecordId = smsRecordId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getSendResult() {
		return sendResult;
	}

	public void setSendResult(String sendResult) {
		this.sendResult = sendResult;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
}
