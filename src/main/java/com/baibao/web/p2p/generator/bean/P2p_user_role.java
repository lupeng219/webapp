package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

public class P2p_user_role implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long purId;

    private String purRolecode;

    private String purCustno;

    public Long getPurId() {
        return purId;
    }

    public void setPurId(Long purId) {
        this.purId = purId;
    }

    public String getPurRolecode() {
        return purRolecode;
    }

    public void setPurRolecode(String purRolecode) {
        this.purRolecode = purRolecode == null ? null : purRolecode.trim();
    }

    public String getPurCustno() {
        return purCustno;
    }

    public void setPurCustno(String purCustno) {
        this.purCustno = purCustno == null ? null : purCustno.trim();
    }
}