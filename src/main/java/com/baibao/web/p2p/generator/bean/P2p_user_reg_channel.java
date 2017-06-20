package com.baibao.web.p2p.generator.bean;

public class P2p_user_reg_channel {
	
    private String pucCustno;//客户号

    private String pucChannel;// 1:pc 2:app 3:wx 4:h5

    private String pucWxopenid;// 微信openId
    
    public String getPucCustno() {
        return pucCustno;
    }

    public void setPucCustno(String pucCustno) {
        this.pucCustno = pucCustno == null ? null : pucCustno.trim();
    }

    public String getPucChannel() {
        return pucChannel;
    }

    public void setPucChannel(String pucChannel) {
        this.pucChannel = pucChannel == null ? null : pucChannel.trim();
    }

    public String getPucWxopenid() {
        return pucWxopenid;
    }

    public void setPucWxopenid(String pucWxopenid) {
        this.pucWxopenid = pucWxopenid == null ? null : pucWxopenid.trim();
    }

}