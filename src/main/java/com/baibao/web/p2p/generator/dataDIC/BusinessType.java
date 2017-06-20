	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 业务类型
	 *
	 */
public enum BusinessType{
	
	/**
	 * 业务类型
	 */
	LOGINSUCCESS("loginSuccess","1","登录"),
	REGISTER("register","2","注册"),
	SHORTCUTRECHARGE("shortcutRecharge","3","快捷充值"),
	SHORTCUTRECHARGEADVANCE("shortcutrechargeadvance","4","快捷充值推进"),
	CYBERBANKRECHARGE("cyberBankRecharge","5","网银充值"),
	WITHDRAWDEPOSIT("withdrawDeposit","6","提现"),
	TENDER("tender","7","投标"),
	RETRIEVEPASSWORD("retrievePassword","8","找回登录密码"),
	CHANGEPASSWORD("changePassword","9","修改登录密码"),
	REALNAMEAUTHENTICATION("realNameAuthentication","10","实名认证"),
	GETBACKTRANSACTIONPASSWORD("getBackTransactionPassword","11","找回交易密码"),
	INTERCALATETRANSACTIONPASSWORD("intercalateTransactionPassword","12","设置交易密码"),
	UPDATETRANSACTIONPASSWORD ("updateTransactionPassword","13","修改交易密码"),
	BINDBANKCARD("bindBankCard","14","绑定银行卡"),
	BINDBANKCARDADVANCE("bindbankcardadvance","15","绑定银行卡推进"),
	BINDTHEBANKCARD("bindTheBankCard","16","解绑银行卡"),
	UPLOADAVATAR("uploadAvatar","17","上传头像"),
	PERSONALLOANS("personalloans","18","个人借贷"),
	CORPORATELENDING("corporatelending","19","企业借贷");
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private BusinessType(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static BusinessType getRegistType(int index) {  
        for (BusinessType c : BusinessType.values()) {  
        	 if (c.getIndex().equals(index)) {   
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
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
