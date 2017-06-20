package com.baibao.web.p2p.generator.bean;

import java.io.Serializable;

/**
 * 产品图片管理表
 * @author zy
 *
 */
public class P2p_loan_product_picture implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long plpPictureid;

    private String plpProductno;

    private String plpAddress;

    private String plpDescription;
    
    private String plpProductCover;

    
    public String getPlpProductCover() {
		return plpProductCover;
	}

	public void setPlpProductCover(String plpProductCover) {
		this.plpProductCover = plpProductCover;
	}

	public Long getPlpPictureid() {
        return plpPictureid;
    }

    public void setPlpPictureid(Long plpPictureid) {
        this.plpPictureid = plpPictureid;
    }

    public String getPlpProductno() {
        return plpProductno;
    }

    public void setPlpProductno(String plpProductno) {
        this.plpProductno = plpProductno == null ? null : plpProductno.trim();
    }

    public String getPlpAddress() {
        return plpAddress;
    }

    public void setPlpAddress(String plpAddress) {
        this.plpAddress = plpAddress == null ? null : plpAddress.trim();
    }

    public String getPlpDescription() {
        return plpDescription;
    }

    public void setPlpDescription(String plpDescription) {
        this.plpDescription = plpDescription == null ? null : plpDescription.trim();
    }
}