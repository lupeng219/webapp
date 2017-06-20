package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * @author hs
 *
 * @date 2017年2月8日
 */
public class P2p_system_params implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 参数id
	 */
	private String id;
	/**
	 * 参数名称
	 */
	private String name;
	/**
	 * 参数值
	 */
	private String value;
	/**
	 *参数说明
	 */
	private String description;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Timestamp created;
	/**
	 * 修改时间
	 */
	private Timestamp updated;
	/**
	 * 状态
	 */
	private String status;
	public P2p_system_params() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
