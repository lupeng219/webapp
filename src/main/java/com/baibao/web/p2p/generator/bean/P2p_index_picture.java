package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

public class P2p_index_picture implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long indexPictureID;
	private String pathUrl;
	private String activityUrl;
	private Integer indexSort;
	private String type;
	private String interimPathUrl;//展示图片地址
	public Long getIndexPictureID() {
		return indexPictureID;
	}
	public void setIndexPictureID(Long indexPictureID) {
		this.indexPictureID = indexPictureID;
	}
	public String getPathUrl() {
		return pathUrl;
	}
	public void setPathUrl(String pathUrl) {
		this.pathUrl = pathUrl;
	}
	public String getActivityUrl() {
		return activityUrl;
	}
	public void setActivityUrl(String activityUrl) {
		this.activityUrl = activityUrl;
	}
	public Integer getIndexSort() {
		return indexSort;
	}
	public void setIndexSort(Integer indexSort) {
		this.indexSort = indexSort;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInterimPathUrl() {
		return interimPathUrl;
	}
	public void setInterimPathUrl(String interimPathUrl) {
		this.interimPathUrl = interimPathUrl;
	}
}
