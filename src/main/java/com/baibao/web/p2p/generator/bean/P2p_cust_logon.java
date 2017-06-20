package com.baibao.web.p2p.generator.bean;

import java.util.Date;

/**
 * 登录控制表
 * @author jiangp
 * @date 2015年10月27日
 */
public class P2p_cust_logon {

	private String pclCustNo;//客户号
	private Date pclFirstLogin;//首次登陆时间
	private Date pclLastLoginsucc;//最后登录成功的时间
	private Date pclLastLoginfail;//最后登录失败的时间
	private Integer pclDayLoginfailNum;//当日失败次数
	private Integer pclLoginsuccNum;//成功登陆次数
	private Date pclFreeDate;//冻结日期
	public String getPclCustNo() {
		return pclCustNo;
	}
	public void setPclCustNo(String pclCustNo) {
		this.pclCustNo = pclCustNo;
	}
	public Date getPclFirstLogin() {
		return pclFirstLogin;
	}
	public void setPclFirstLogin(Date pclFirstLogin) {
		this.pclFirstLogin = pclFirstLogin;
	}
	public Date getPclLastLoginsucc() {
		return pclLastLoginsucc;
	}
	public void setPclLastLoginsucc(Date pclLastLoginsucc) {
		this.pclLastLoginsucc = pclLastLoginsucc;
	}
	public Date getPclLastLoginfail() {
		return pclLastLoginfail;
	}
	public void setPclLastLoginfail(Date pclLastLoginfail) {
		this.pclLastLoginfail = pclLastLoginfail;
	}
	public Integer getPclDayLoginfailNum() {
		return pclDayLoginfailNum;
	}
	public void setPclDayLoginfailNum(Integer pclDayLoginfailNum) {
		this.pclDayLoginfailNum = pclDayLoginfailNum;
	}
	public Integer getPclLoginsuccNum() {
		return pclLoginsuccNum;
	}
	public void setPclLoginsuccNum(Integer pclLoginsuccNum) {
		this.pclLoginsuccNum = pclLoginsuccNum;
	}
	public Date getPclFreeDate() {
		return pclFreeDate;
	}
	public void setPclFreeDate(Date pclFreeDate) {
		this.pclFreeDate = pclFreeDate;
	}
	
}
