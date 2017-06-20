package com.baibao.web.p2p.generator.bean;

import java.util.Date;
/**
 * 用户实物表
 * @Title: p2p_users_practicality.java
 * @Package com.baibao.web.p2p.generator.bean
 * @author zhangx
 * @date 2016年3月28日
 */
public class P2p_users_practicality {
    private String pupPracticalityno;//用户实物编号

    private String pupCustno;//用户客户号

    private String pupTestimonialno;//奖品编号

    private Date pupGettime;//获得时间

    private String pupLotterydrawno;//用户抽奖编号

    private Integer pupActiveid;//活动编号

    private Integer pupStatus;//状态(0：未发放1：已发放)

    public String getPupPracticalityno() {
        return pupPracticalityno;
    }

    public void setPupPracticalityno(String pupPracticalityno) {
        this.pupPracticalityno = pupPracticalityno == null ? null : pupPracticalityno.trim();
    }

    public String getPupCustno() {
        return pupCustno;
    }

    public void setPupCustno(String pupCustno) {
        this.pupCustno = pupCustno == null ? null : pupCustno.trim();
    }

    public String getPupTestimonialno() {
        return pupTestimonialno;
    }

    public void setPupTestimonialno(String pupTestimonialno) {
        this.pupTestimonialno = pupTestimonialno == null ? null : pupTestimonialno.trim();
    }

    public Date getPupGettime() {
        return pupGettime;
    }

    public void setPupGettime(Date pupGettime) {
        this.pupGettime = pupGettime;
    }

    public String getPupLotterydrawno() {
        return pupLotterydrawno;
    }

    public void setPupLotterydrawno(String pupLotterydrawno) {
        this.pupLotterydrawno = pupLotterydrawno == null ? null : pupLotterydrawno.trim();
    }

    public Integer getPupActiveid() {
        return pupActiveid;
    }

    public void setPupActiveid(Integer pupActiveid) {
        this.pupActiveid = pupActiveid;
    }

    public Integer getPupStatus() {
        return pupStatus;
    }

    public void setPupStatus(Integer pupStatus) {
        this.pupStatus = pupStatus;
    }
}