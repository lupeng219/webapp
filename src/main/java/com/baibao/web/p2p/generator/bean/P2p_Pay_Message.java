package com.baibao.web.p2p.generator.bean;

/**
 * 支付渠道返回描述信息
 * 
 * @author Denny
 * @date 2016年6月23日
 */
public class P2p_Pay_Message {

    private int id;

    /**
     * 支付渠道
     */
    private String pay_channel;

    /**
     * 支付返回 code
     */
    private String pay_code;

    /**
     * 官方描述
     */
    private String pay_text;

    /**
     * 佰宝平台描述
     */
    private String pay_message;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPay_channel()
    {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel)
    {
        this.pay_channel = pay_channel;
    }

    public String getPay_code()
    {
        return pay_code;
    }

    public void setPay_code(String pay_code)
    {
        this.pay_code = pay_code;
    }

    public String getPay_text()
    {
        return pay_text;
    }

    public void setPay_text(String pay_text)
    {
        this.pay_text = pay_text;
    }

    public String getPay_message()
    {
        return pay_message;
    }

    public void setPay_message(String pay_message)
    {
        this.pay_message = pay_message;
    }

    

    
    
}
