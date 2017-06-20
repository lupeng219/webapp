package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

public class P2p_activity_elements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long pae_activeId;//活动编号*
	
	private String pae_activeType;//活动类型*
	
	private String pae_activeName;//活动名称*
	
	private String pae_activeChannel;//活动所属渠道*
	
	private String pae_effectTime;//通过活动获得的奖品的过期时间*

	private String pae_starTime;//活动起始时间*
	
	private String pae_endTime;//活动终止时间*
	
	private String pae_isEnable;//活动是否启用*
	
	private String pae_desc;//活动描述*
	
	private String pae_goodsType;//商品种类*
	
	private String pae_showPic;//活动展示图片
	
	private String pae_deatilPic;//活动详情图片
	
	private String pae_linkAddress;//活动连接地址
	
	public Long getPae_activeId() {
		return pae_activeId;
	}

	public void setPae_activeId(Long pae_activeId) {
		this.pae_activeId = pae_activeId;
	}
    
	public String getPae_activeType() {
		return pae_activeType;
	}

	public void setPae_activeType(String pae_activeType) {
		this.pae_activeType = pae_activeType;
	}

	public String getPae_activeName() {
		return pae_activeName;
	}

	public void setPae_activeName(String pae_activeName) {
		this.pae_activeName = pae_activeName;
	}
    
	public String getPae_activeChannel() {
		return pae_activeChannel;
	}

	public void setPae_activeChannel(String pae_activeChannel) {
		this.pae_activeChannel = pae_activeChannel;
	}

	public String getPae_effectTime() {
		return pae_effectTime;
	}

	public void setPae_effectTime(String pae_effectTime) {
		this.pae_effectTime = pae_effectTime;
	}

	public String getPae_starTime() {
		return pae_starTime;
	}

	public void setPae_starTime(String pae_starTime) {
		this.pae_starTime = pae_starTime;
	}

	public String getPae_endTime() {
		return pae_endTime;
	}

	public void setPae_endTime(String pae_endTime) {
		this.pae_endTime = pae_endTime;
	}

	public String getPae_isEnable() {
		return pae_isEnable;
	}

	public void setPae_isEnable(String pae_isEnable) {
		this.pae_isEnable = pae_isEnable;
	}

	public String getPae_desc() {
		return pae_desc;
	}

	public void setPae_desc(String pae_desc) {
		this.pae_desc = pae_desc;
	}

	public String getPae_goodsType() {
		return pae_goodsType;
	}

	public void setPae_goodsType(String pae_goodsType) {
		this.pae_goodsType = pae_goodsType;
	}

	public String getPae_showPic() {
		return pae_showPic;
	}

	public void setPae_showPic(String pae_showPic) {
		this.pae_showPic = pae_showPic;
	}

	public String getPae_deatilPic() {
		return pae_deatilPic;
	}

	public void setPae_deatilPic(String pae_deatilPic) {
		this.pae_deatilPic = pae_deatilPic;
	}

	public String getPae_linkAddress() {
		return pae_linkAddress;
	}

	public void setPae_linkAddress(String pae_linkAddress) {
		this.pae_linkAddress = pae_linkAddress;
	}

}
