package com.baibao.web.p2p.generator.bean;
/**
 * 辅助表-使用红包记录表
 * @Title: p2p_users_redenvelope_friendTender.java
 * @Package com.baibao.web.p2p.generator.bean
 * @author zhangx
 * @date 2016年3月28日
 */
public class P2p_users_redenvelope_friendTender {
    private String purfRedenvelopeno;//用户红包编号(301:注册送 302：大转盘红包)

    private String purfCustno;//用户客户号

    private String purfProjectno;//标的号

    private String purfTenderflowno;//投资流水号

    private String purfProjectTerm;//标的期限

    public String getPurfRedenvelopeno() {
        return purfRedenvelopeno;
    }

    public void setPurfRedenvelopeno(String purfRedenvelopeno) {
        this.purfRedenvelopeno = purfRedenvelopeno == null ? null : purfRedenvelopeno.trim();
    }

    public String getPurfCustno() {
        return purfCustno;
    }

    public void setPurfCustno(String purfCustno) {
        this.purfCustno = purfCustno == null ? null : purfCustno.trim();
    }

    public String getPurfProjectno() {
        return purfProjectno;
    }

    public void setPurfProjectno(String purfProjectno) {
        this.purfProjectno = purfProjectno == null ? null : purfProjectno.trim();
    }

    public String getPurfTenderflowno() {
        return purfTenderflowno;
    }

    public void setPurfTenderflowno(String purfTenderflowno) {
        this.purfTenderflowno = purfTenderflowno == null ? null : purfTenderflowno.trim();
    }

    public String getPurfProjectTerm() {
        return purfProjectTerm;
    }

    public void setPurfProjectTerm(String purfProjectTerm) {
        this.purfProjectTerm = purfProjectTerm == null ? null : purfProjectTerm.trim();
    }
}