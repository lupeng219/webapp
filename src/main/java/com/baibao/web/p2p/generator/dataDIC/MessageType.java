	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 短信模板类型
	 *
	 */
public enum MessageType{
	
	/**
	 * 短信模板类型
	 */
	REGISTER("register", 1486896, "注册"),
	LOGINPASSWORD("retrievePassword", 1486888, "找回登录密码"),
	TRADINGPASSWORD("tradingPassword", 1486894, "找回交易密码"),
	RedMoney("redmoney", 4, "红包现金奖励"),
	INVITATIONREWARE("invitationreward", 5, "邀请奖励"),
	REPAYMENT("repayment", 1486426, "还款"),
	
	WITHDRAW("withdraw", 1486408, "提现"),
	TENDER("tender", 1486412, "投资");
	
	private int index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private MessageType(String name, int index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static MessageType getMessageState(int index) {  
        for (MessageType c : MessageType.values()) {  
        	 if (c.getIndex()== index) {   
                return c;  
            }  
        }  
        return null;  
    }       
    
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public static MessageType getEnumByName(String name) {
        for (MessageType e : MessageType.values()) {
            if (e.name.equals(name)) {
                return e;
            }
        }
        return null;
    }
}
