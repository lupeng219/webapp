package com.baibao.web.p2p.generator.bean;

import java.util.Date;

public class P2p_user_warehouse {
   
	private String puwWhno;//商品编号

    private String puwCustno;//客户号

    private String puwCode;//商品种类

    private String puwParvalue;//面值

    private String puwGettime;//获得时间

    private String puwEffecttime;//过期时间

    private Integer puwActiveid;//活动编号

    private String puwState;//使用状态
    
    //临时字段
    private String friendCustName; //客户真实姓名
    
    private Date registrationTime; //客户注册时间
    
    private String paraName; //商品种类对应的值
    
    private String metric;//单位
    

    public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getFriendCustName() {
		return friendCustName;
	}

	public void setFriendCustName(String friendCustName) {
		this.friendCustName = friendCustName;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getPuwWhno() {
        return puwWhno;
    }

    public void setPuwWhno(String puwWhno) {
        this.puwWhno = puwWhno == null ? null : puwWhno.trim();
    }

    public String getPuwCustno() {
        return puwCustno;
    }

    public void setPuwCustno(String puwCustno) {
        this.puwCustno = puwCustno == null ? null : puwCustno.trim();
    }

    public String getPuwCode() {
        return puwCode;
    }

    public void setPuwCode(String puwCode) {
        this.puwCode = puwCode == null ? null : puwCode.trim();
    }

    public String getPuwParvalue() {
        return puwParvalue;
    }

    public void setPuwParvalue(String puwParvalue) {
        this.puwParvalue = puwParvalue == null ? null : puwParvalue.trim();
    }

    public String getPuwGettime() {
        return puwGettime;
    }

    public void setPuwGettime(String puwGettime) {
        this.puwGettime = puwGettime == null ? null : puwGettime.trim();
    }

    public String getPuwEffecttime() {
        return puwEffecttime;
    }

    public void setPuwEffecttime(String puwEffecttime) {
        this.puwEffecttime = puwEffecttime == null ? null : puwEffecttime.trim();
    }

    public Integer getPuwActiveid() {
        return puwActiveid;
    }

    public void setPuwActiveid(Integer puwActiveid) {
        this.puwActiveid = puwActiveid;
    }

    public String getPuwState() {
        return puwState;
    }

    public void setPuwState(String puwState) {
        this.puwState = puwState == null ? null : puwState.trim();
    }
}