package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

public class P2p_article implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	private Long articleID;
	private String articleType;
	private String articleTitle;
	private String articleAuthor;
	private Date articlePushTime;
	private Integer sort;
	private String articleContents;
	private String paperCoverUrl;
	private String introduction;
	public Long getArticleID() {
		return articleID;
	}
	public void setArticleID(Long articleID) {
		this.articleID = articleID;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleAuthor() {
		return articleAuthor;
	}
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public Date getArticlePushTime() {
		return articlePushTime;
	}
	public void setArticlePushTime(Date articlePushTime) {
		this.articlePushTime = articlePushTime;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getArticleContents() {
		return articleContents;
	}
	public void setArticleContents(String articleContents) {
		this.articleContents = articleContents;
	}
	public String getPaperCoverUrl() {
		return paperCoverUrl;
	}
	public void setPaperCoverUrl(String paperCoverUrl) {
		this.paperCoverUrl = paperCoverUrl;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
