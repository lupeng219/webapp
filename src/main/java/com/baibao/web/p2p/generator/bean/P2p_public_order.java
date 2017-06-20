package com.baibao.web.p2p.generator.bean;

import java.util.Date;

public class P2p_public_order
{
	private String ppoOrderflowno;
	
	private String ppoCustno;
	private String ppoTargetno;
	
	private Integer ppoBussType;
	private String ppoBussDesc;
	
	private Date ppoOrderTime;
	
	private String ppoAccountchannel;
	
	private String ppoStatus;
	
	private String ppoParams;
	private String ppoResponse;
	
	private String ppoParentFlowNo;
    

    public String getPpoParentFlowNo() {
		return ppoParentFlowNo;
	}

	public void setPpoParentFlowNo(String ppoParentFlowNo) {
		this.ppoParentFlowNo = ppoParentFlowNo;
	}

	public String getPpoOrderflowno() {
        return ppoOrderflowno;
    }

    public void setPpoOrderflowno(String ppoOrderflowno) {
        this.ppoOrderflowno = ppoOrderflowno == null ? null : ppoOrderflowno.trim();
    }

    public String getPpoCustno() {
        return ppoCustno;
    }

    public void setPpoCustno(String ppoCustno) {
        this.ppoCustno = ppoCustno == null ? null : ppoCustno.trim();
    }

    public Integer getPpoBussType() {
        return ppoBussType;
    }

    public void setPpoBussType(Integer ppoBussType) {
        this.ppoBussType = ppoBussType;
    }

    public Date getPpoOrderTime() {
        return ppoOrderTime;
    }

    public void setPpoOrderTime(Date ppoOrderTime) {
        this.ppoOrderTime = ppoOrderTime;
    }

    public String getPpoAccountchannel() {
        return ppoAccountchannel;
    }

    public void setPpoAccountchannel(String ppoAccountchannel) {
        this.ppoAccountchannel = ppoAccountchannel == null ? null : ppoAccountchannel.trim();
    }

    public String getPpoStatus() {
        return ppoStatus;
    }

    public void setPpoStatus(String ppoStatus) {
        this.ppoStatus = ppoStatus == null ? null : ppoStatus.trim();
    }

    public String getPpoParams() {
        return ppoParams;
    }

    public void setPpoParams(String ppoParams) {
        this.ppoParams = ppoParams == null ? null : ppoParams.trim();
    }

	public String getPpoTargetno() {
		return ppoTargetno;
	}

	public void setPpoTargetno(String ppoTargetno) {
		this.ppoTargetno = ppoTargetno;
	}

	public String getPpoBussDesc() {
		return ppoBussDesc;
	}

	public void setPpoBussDesc(String ppoBussDesc) {
		this.ppoBussDesc = ppoBussDesc;
	}

	public String getPpoResponse() {
		return ppoResponse;
	}

	public void setPpoResponse(String ppoResponse) {
		this.ppoResponse = ppoResponse;
	}
}