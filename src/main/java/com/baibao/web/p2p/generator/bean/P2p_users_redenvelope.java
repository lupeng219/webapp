package com.baibao.web.p2p.generator.bean;

import java.util.Date;
/**
 * 用户红包表
 * @Title: p2p_users_redenvelope.java
 * @Package com.baibao.web.p2p.generator.bean
 * @author zhangx
 * @date 2016年3月28日
 */
public class P2p_users_redenvelope {
    private String purRedenvelopeno;//用户红包编号(301:注册送 302：大转盘红包)

    private String purCustno;//用户客户号

    private String purMoney;//红包金额

    private Date purGettime;//获得时间

    private Date purEffecttime;//到期时间

    private String purLotterydrawno;//用户抽奖编号

    private Integer purActiveid;//活动编号

    private Integer purStatus;//红包状态 ("0" 未使用，"1"已使用，"2"已过期，"3"已赠送，"4"处理中)

    private String purRule;//红包使用规则

    public String getPurRedenvelopeno() {
        return purRedenvelopeno;
    }

    public void setPurRedenvelopeno(String purRedenvelopeno) {
        this.purRedenvelopeno = purRedenvelopeno == null ? null : purRedenvelopeno.trim();
    }

    public String getPurCustno() {
        return purCustno;
    }

    public void setPurCustno(String purCustno) {
        this.purCustno = purCustno == null ? null : purCustno.trim();
    }

    public String getPurMoney() {
        return purMoney;
    }

    public void setPurMoney(String purMoney) {
        this.purMoney = purMoney == null ? null : purMoney.trim();
    }

    public Date getPurGettime() {
        return purGettime;
    }

    public void setPurGettime(Date purGettime) {
        this.purGettime = purGettime;
    }

    public Date getPurEffecttime() {
        return purEffecttime;
    }

    public void setPurEffecttime(Date purEffecttime) {
        this.purEffecttime = purEffecttime;
    }

    public String getPurLotterydrawno() {
        return purLotterydrawno;
    }

    public void setPurLotterydrawno(String purLotterydrawno) {
        this.purLotterydrawno = purLotterydrawno == null ? null : purLotterydrawno.trim();
    }

    public Integer getPurActiveid() {
        return purActiveid;
    }

    public void setPurActiveid(Integer purActiveid) {
        this.purActiveid = purActiveid;
    }

    public Integer getPurStatus() {
        return purStatus;
    }

    public void setPurStatus(Integer purStatus) {
        this.purStatus = purStatus;
    }

    public String getPurRule() {
        return purRule;
    }

    public void setPurRule(String purRule) {
        this.purRule = purRule == null ? null : purRule.trim();
    }
}