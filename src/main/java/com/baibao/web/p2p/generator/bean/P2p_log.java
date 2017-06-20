package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志表
 * @author jiangp
 * @date 2015年11月16日
 */
public class P2p_log implements Serializable {
	private static final long serialVersionUID = 4598509540344181835L;

	private Long logId;//日志编号
	private String custno;//客户编号
	private Date operationTime;//操作时间
	private String operationIp;//操作ip
	private String operationData;//操作内容
	private String operationResult;//操作结果
	private String operationDec;//业务类型
	private String operationChannel;//客户端类型
	private String operationjoggle;//接口名称
	
	public Long getLogId() {
		return logId;
	}
	public void setLogId(Long logId) {
		this.logId = logId;
	}
	public String getCustno() {
		return custno;
	}
	public void setCustno(String custno) {
		this.custno = custno;
	}
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	public String getOperationIp() {
		return operationIp;
	}
	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}
	public String getOperationDec() {
		return operationDec;
	}
	public void setOperationDec(String operationDec) {
		this.operationDec = operationDec;
	}
	public String getOperationChannel() {
		return operationChannel;
	}
	public void setOperationChannel(String operationChannel) {
		this.operationChannel = operationChannel;
	}
	public String getOperationData() {
		return operationData;
	}
	public void setOperationData(String operationData) {
		this.operationData = operationData;
	}
	public String getOperationResult() {
		return operationResult;
	}
	public void setOperationResult(String operationResult) {
		this.operationResult = operationResult;
	}
	public String getOperationjoggle() {
		return operationjoggle;
	}
	public void setOperationjoggle(String operationjoggle) {
		this.operationjoggle = operationjoggle;
	}
	
}
