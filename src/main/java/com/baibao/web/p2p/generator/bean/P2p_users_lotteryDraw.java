package com.baibao.web.p2p.generator.bean;

import java.util.Date;
/**
 * 用户抽奖来源表
 * @Title: p2p_users_lotteryDraw.java
 * @Package com.baibao.web.p2p.generator.bean
 * @author zhangx
 * @date 2016年3月28日
 */
public class P2p_users_lotteryDraw {
    private String pulLotterydrawno; //用户抽奖编号

    private String pulCustno;//用户客户号

    private String pulSourcetype;//来源类型(1：登录(每天1次)2：投资(最多2次))

    private Date pulGettime;//获得时间(登录时间、投标时间)

    private String pulTenderflowno;//投标流水

    private Integer pulStatus;//使用状态(0：未使用1：已使用)

    public String getPulLotterydrawno() {
        return pulLotterydrawno;
    }

    public void setPulLotterydrawno(String pulLotterydrawno) {
        this.pulLotterydrawno = pulLotterydrawno == null ? null : pulLotterydrawno.trim();
    }

    public String getPulCustno() {
        return pulCustno;
    }

    public void setPulCustno(String pulCustno) {
        this.pulCustno = pulCustno == null ? null : pulCustno.trim();
    }

    public String getPulSourcetype() {
        return pulSourcetype;
    }

    public void setPulSourcetype(String pulSourcetype) {
        this.pulSourcetype = pulSourcetype == null ? null : pulSourcetype.trim();
    }

    public Date getPulGettime() {
        return pulGettime;
    }

    public void setPulGettime(Date pulGettime) {
        this.pulGettime = pulGettime;
    }

    public String getPulTenderflowno() {
        return pulTenderflowno;
    }

    public void setPulTenderflowno(String pulTenderflowno) {
        this.pulTenderflowno = pulTenderflowno == null ? null : pulTenderflowno.trim();
    }

    public Integer getPulStatus() {
        return pulStatus;
    }

    public void setPulStatus(Integer pulStatus) {
        this.pulStatus = pulStatus;
    }
}