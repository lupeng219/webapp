package com.baibao.web.p2p.generator.bean;


/**
 * 用户好友关系
 * @Title: p2p_user_friends.java
 * @Package com.baibao.web.p2p.generator.bean
 * @author zhangx
 * @date 2016年1月29日
 */
public class p2p_user_friends{

	private String pufCustNo; //邀请人客户号
	private String pufCustName; //邀请人姓名
	private String pufFriendCustNo; //被邀请人客户号
	private String pufFriendCustName; //被邀请人姓名
	private String pufUserType;//邀请人类型:0普通用户1员工2销售3渠道
	public String getPufCustNo() {
		return pufCustNo;
	}
	public void setPufCustNo(String pufCustNo) {
		this.pufCustNo = pufCustNo;
	}
	public String getPufCustName() {
		return pufCustName;
	}
	public void setPufCustName(String pufCustName) {
		this.pufCustName = pufCustName;
	}
	public String getPufFriendCustNo() {
		return pufFriendCustNo;
	}
	public void setPufFriendCustNo(String pufFriendCustNo) {
		this.pufFriendCustNo = pufFriendCustNo;
	}
	public String getPufFriendCustName() {
		return pufFriendCustName;
	}
	public void setPufFriendCustName(String pufFriendCustName) {
		this.pufFriendCustName = pufFriendCustName;
	}
	public String getPufUserType() {
		return pufUserType;
	}
	public void setPufUserType(String pufUserType) {
		this.pufUserType = pufUserType;
	}
	

}
