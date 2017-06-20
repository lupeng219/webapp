	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 新浪响应码
	 *
	 */
public enum sinaResponseCode{
	
	/**
	 * 新浪响应码
	 */
	DUPLICATE_IDENTITY_ID("DUPLICATE_IDENTITY_ID","DUPLICATE_IDENTITY_ID","用户标识信息重复"),
	DUPLICATE_VERIFY("DUPLICATE_VERIFY","DUPLICATE_VERIFY","会员认证信息重复");
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private sinaResponseCode(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static sinaResponseCode getRegistType(int index) {  
        for (sinaResponseCode c : sinaResponseCode.values()) {  
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
