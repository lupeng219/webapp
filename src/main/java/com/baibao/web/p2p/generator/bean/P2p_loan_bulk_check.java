package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;
import java.util.Date;

public class P2p_loan_bulk_check implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long plbcCheckid;

    private Long plbcProductid;

    private String plbcEmployeeno;

    private Date plbcExaminedatetime;

    private String plbcExaminetype;

    private String plbcExaminestate;

    public Long getPlbcCheckid() {
        return plbcCheckid;
    }

    public void setPlbcCheckid(Long plbcCheckid) {
        this.plbcCheckid = plbcCheckid;
    }

    public Long getPlbcProductid() {
        return plbcProductid;
    }

    public void setPlbcProductid(Long plbcProductid) {
        this.plbcProductid = plbcProductid;
    }

    public String getPlbcEmployeeno() {
        return plbcEmployeeno;
    }

    public void setPlbcEmployeeno(String plbcEmployeeno) {
        this.plbcEmployeeno = plbcEmployeeno == null ? null : plbcEmployeeno.trim();
    }

    public Date getPlbcExaminedatetime() {
        return plbcExaminedatetime;
    }

    public void setPlbcExaminedatetime(Date plbcExaminedatetime) {
        this.plbcExaminedatetime = plbcExaminedatetime;
    }

    public String getPlbcExaminetype() {
        return plbcExaminetype;
    }

    public void setPlbcExaminetype(String plbcExaminetype) {
        this.plbcExaminetype = plbcExaminetype == null ? null : plbcExaminetype.trim();
    }

    public String getPlbcExaminestate() {
        return plbcExaminestate;
    }

    public void setPlbcExaminestate(String plbcExaminestate) {
        this.plbcExaminestate = plbcExaminestate == null ? null : plbcExaminestate.trim();
    }
}