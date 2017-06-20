package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 投资记录表
 * @author zy
 *
 */
public class P2p_tender_record implements Serializable{
    
	private static final long serialVersionUID = 1L;

	//private Long ptrId;

    private String ptrTenderflowno; //投资单号

    private String ptrAccountno; //支付账户

    private String ptrProductno;//产品编号

    private String ptrCustno;//用户编号

    private BigDecimal ptrAmount;//投资金额

    private Date ptrTranstime;//投资时间

    private String ptrStatus;// 投资类型：10 ：正常投资  11 已作为债权转出  12 已被债权人购买

    private String ptrChannel;//交易渠道:10 pc,11 苹果 , 12安卓, 13 H5 

    private String ptrTradestatus;//交易状态   10:交易成功 11：交易失败  12 处理中;对应新浪最终交易状态

    private String ptrPaystatuscode;//第三方交易状态码

    private Date ptrHostResponseTime;//第三方响应时间

    private String ptrHostResponseFlowno;//第三方返回流水号

    private String ptrHostReturnCode;//第三方返回码

    private String ptrHostReturnMessage;//第三方返回信息

    private String ptrDealstatus;//00无需处理,01已处理 该状态只有在订单失败的时候处理被锁定的标的金额用到,订单为成功时，不必关心该字段

    private String ptrBackstatus;//00无,01是 ,是否需要退款: 该状态只有在代付失败时需要退款用到,代付订单为成功时，不必关心该字段

    private String ptrRemark;//备注
    
    //临时字段号 用户名  nickname
    private String  pu_mobile;
    


	public String getPu_mobile() {
		return pu_mobile;
	}

	public void setPu_mobile(String pu_mobile) {
		this.pu_mobile = pu_mobile;
	}

    public String getPtrTenderflowno() {
        return ptrTenderflowno;
    }

    public void setPtrTenderflowno(String ptrTenderflowno) {
        this.ptrTenderflowno = ptrTenderflowno == null ? null : ptrTenderflowno.trim();
    }

    public String getPtrAccountno() {
        return ptrAccountno;
    }

    public void setPtrAccountno(String ptrAccountno) {
        this.ptrAccountno = ptrAccountno == null ? null : ptrAccountno.trim();
    }

    public String getPtrProductno() {
        return ptrProductno;
    }

    public void setPtrProductno(String ptrProductno) {
        this.ptrProductno = ptrProductno == null ? null : ptrProductno.trim();
    }

    public String getPtrCustno() {
        return ptrCustno;
    }

    public void setPtrCustno(String ptrCustno) {
        this.ptrCustno = ptrCustno == null ? null : ptrCustno.trim();
    }

    public BigDecimal getPtrAmount() {
        return ptrAmount;
    }

    public void setPtrAmount(BigDecimal ptrAmount) {
        this.ptrAmount = ptrAmount;
    }

    public Date getPtrTranstime() {
        return ptrTranstime;
    }

    public void setPtrTranstime(Date ptrTranstime) {
        this.ptrTranstime = ptrTranstime;
    }

    public String getPtrStatus() {
        return ptrStatus;
    }

    public void setPtrStatus(String ptrStatus) {
        this.ptrStatus = ptrStatus == null ? null : ptrStatus.trim();
    }

    public String getPtrChannel() {
        return ptrChannel;
    }

    public void setPtrChannel(String ptrChannel) {
        this.ptrChannel = ptrChannel == null ? null : ptrChannel.trim();
    }

    public String getPtrTradestatus() {
        return ptrTradestatus;
    }

    public void setPtrTradestatus(String ptrTradestatus) {
        this.ptrTradestatus = ptrTradestatus == null ? null : ptrTradestatus.trim();
    }

    public String getPtrPaystatuscode() {
        return ptrPaystatuscode;
    }

    public void setPtrPaystatuscode(String ptrPaystatuscode) {
        this.ptrPaystatuscode = ptrPaystatuscode == null ? null : ptrPaystatuscode.trim();
    }

    public Date getPtrHostResponseTime() {
        return ptrHostResponseTime;
    }

    public void setPtrHostResponseTime(Date ptrHostResponseTime) {
        this.ptrHostResponseTime = ptrHostResponseTime;
    }

    public String getPtrHostResponseFlowno() {
        return ptrHostResponseFlowno;
    }

    public void setPtrHostResponseFlowno(String ptrHostResponseFlowno) {
        this.ptrHostResponseFlowno = ptrHostResponseFlowno == null ? null : ptrHostResponseFlowno.trim();
    }

    public String getPtrHostReturnCode() {
        return ptrHostReturnCode;
    }

    public void setPtrHostReturnCode(String ptrHostReturnCode) {
        this.ptrHostReturnCode = ptrHostReturnCode == null ? null : ptrHostReturnCode.trim();
    }

    public String getPtrHostReturnMessage() {
        return ptrHostReturnMessage;
    }

    public void setPtrHostReturnMessage(String ptrHostReturnMessage) {
        this.ptrHostReturnMessage = ptrHostReturnMessage == null ? null : ptrHostReturnMessage.trim();
    }

    public String getPtrDealstatus() {
        return ptrDealstatus;
    }

    public void setPtrDealstatus(String ptrDealstatus) {
        this.ptrDealstatus = ptrDealstatus == null ? null : ptrDealstatus.trim();
    }

    public String getPtrBackstatus() {
        return ptrBackstatus;
    }

    public void setPtrBackstatus(String ptrBackstatus) {
        this.ptrBackstatus = ptrBackstatus == null ? null : ptrBackstatus.trim();
    }

    public String getPtrRemark() {
        return ptrRemark;
    }

    public void setPtrRemark(String ptrRemark) {
        this.ptrRemark = ptrRemark == null ? null : ptrRemark.trim();
    }
}