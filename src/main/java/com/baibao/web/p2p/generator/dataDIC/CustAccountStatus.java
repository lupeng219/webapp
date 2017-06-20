	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 账户状态
	 *
	 */
public enum CustAccountStatus{
	
	/**
	 * 账户状态
	 */
	BESTOW("bestow","10","使用中"),
	FREEZE("freeze","11","冻结"),
	NOTACTIVATED ("notActivated ","12","未激活");
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private CustAccountStatus(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static CustAccountStatus getRegistType(int index) {  
        for (CustAccountStatus c : CustAccountStatus.values()) {  
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
