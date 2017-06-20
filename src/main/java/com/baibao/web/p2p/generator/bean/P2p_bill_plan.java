package com.baibao.web.p2p.generator.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 帐期
 */
public class P2p_bill_plan
{
	private Long pbpId;
	/** 产品编号 */
	private String pbpProductNo;
	/** 帐期数 */
	private Integer pbpSeq;
	/** 合约还款日期 */
	private Timestamp pbpDatetime;
	/** 逾期天数 */
	private Integer pbpOverDueDays;

	private BigDecimal pbpRepaymentCapital;
	private BigDecimal pbpRepaymentInterest;
	
	private Timestamp pbpRepaymentTime;
	/** 还款状态 0未还款，1已还款，2逾期 */
	private Integer pbpRepaymentStatus;

	private BigDecimal pbpProfitCapital;
	private BigDecimal pbpProfitInterest;
	
	/** 实际返利时间 */
	private Timestamp pbpProfitTime;
	/** 返利状态 0未返利，1已返利，2逾期 */
	private Integer pbpProfitStatus;

	public Long getPbpId() {
		return pbpId;
	}
	public void setPbpId(Long pbpId) {
		this.pbpId = pbpId;
	}
	public String getPbpProductNo() {
		return pbpProductNo;
	}
	public void setPbpProductNo(String pbpProductNo) {
		this.pbpProductNo = pbpProductNo;
	}
	public Integer getPbpSeq() {
		return pbpSeq;
	}
	public void setPbpSeq(Integer pbpSeq) {
		this.pbpSeq = pbpSeq;
	}
	public Timestamp getPbpDatetime() {
		return pbpDatetime;
	}
	public void setPbpDatetime(Timestamp pbpDatetime) {
		this.pbpDatetime = pbpDatetime;
	}
	public Integer getPbpOverDueDays() {
		return pbpOverDueDays;
	}
	public void setPbpOverDueDays(Integer pbpOverDueDays) {
		this.pbpOverDueDays = pbpOverDueDays;
	}
	public Timestamp getPbpRepaymentTime() {
		return pbpRepaymentTime;
	}
	public void setPbpRepaymentTime(Timestamp pbpRepaymentTime) {
		this.pbpRepaymentTime = pbpRepaymentTime;
	}
	public Integer getPbpRepaymentStatus() {
		return pbpRepaymentStatus;
	}
	public void setPbpRepaymentStatus(Integer pbpRepaymentStatus) {
		this.pbpRepaymentStatus = pbpRepaymentStatus;
	}
	public Timestamp getPbpProfitTime() {
		return pbpProfitTime;
	}
	public void setPbpProfitTime(Timestamp pbpProfitTime) {
		this.pbpProfitTime = pbpProfitTime;
	}
	public Integer getPbpProfitStatus() {
		return pbpProfitStatus;
	}
	public void setPbpProfitStatus(Integer pbpProfitStatus) {
		this.pbpProfitStatus = pbpProfitStatus;
	}
	public BigDecimal getPbpRepaymentCapital() {
		return pbpRepaymentCapital;
	}
	public void setPbpRepaymentCapital(BigDecimal pbpRepaymentCapital) {
		this.pbpRepaymentCapital = pbpRepaymentCapital;
	}
	public BigDecimal getPbpRepaymentInterest() {
		return pbpRepaymentInterest;
	}
	public void setPbpRepaymentInterest(BigDecimal pbpRepaymentInterest) {
		this.pbpRepaymentInterest = pbpRepaymentInterest;
	}
	public BigDecimal getPbpProfitCapital() {
		return pbpProfitCapital;
	}
	public void setPbpProfitCapital(BigDecimal pbpProfitCapital) {
		this.pbpProfitCapital = pbpProfitCapital;
	}
	public BigDecimal getPbpProfitInterest() {
		return pbpProfitInterest;
	}
	public void setPbpProfitInterest(BigDecimal pbpProfitInterest) {
		this.pbpProfitInterest = pbpProfitInterest;
	}
}
