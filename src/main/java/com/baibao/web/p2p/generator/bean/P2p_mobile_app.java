package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

/**
 * app信息
 * @author lp
 *
 */
public class P2p_mobile_app implements Serializable{
	private static final long serialVersionUID = 8109680379309988019L;
	
	private Long id;		// ID
	private String name;	// 名字
	private String version; // 版本
	private String url;		// 下载路径
	private String remarks; // 更新描述
	private Integer downloadNum;// 下载量
	private String type;  //测试正式类型
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getDownloadNum() {
		if(downloadNum == null){
			downloadNum = 0;
		}
		return downloadNum;
	}
	public void setDownloadNum(Integer downloadNum) {
		this.downloadNum = downloadNum;
	}
	
}
