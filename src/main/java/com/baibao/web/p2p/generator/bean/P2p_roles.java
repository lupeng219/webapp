package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

public class P2p_roles implements Serializable{
   
	private static final long serialVersionUID = 1L;

	private Long prId;

    private String prRolecode;

    private String prRolename;

    private String prRoledesc;

    private String rEnabled;

    public Long getPrId() {
        return prId;
    }

    public void setPrId(Long prId) {
        this.prId = prId;
    }

    public String getPrRolecode() {
        return prRolecode;
    }

    public void setPrRolecode(String prRolecode) {
        this.prRolecode = prRolecode == null ? null : prRolecode.trim();
    }

    public String getPrRolename() {
        return prRolename;
    }

    public void setPrRolename(String prRolename) {
        this.prRolename = prRolename == null ? null : prRolename.trim();
    }

    public String getPrRoledesc() {
        return prRoledesc;
    }

    public void setPrRoledesc(String prRoledesc) {
        this.prRoledesc = prRoledesc == null ? null : prRoledesc.trim();
    }

    public String getrEnabled() {
        return rEnabled;
    }

    public void setrEnabled(String rEnabled) {
        this.rEnabled = rEnabled == null ? null : rEnabled.trim();
    }
}