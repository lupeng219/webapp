	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 是否枚举类
	 * @author YY
	 *
	 */
public enum BooleanType{
	
					/**是否类型---是*/
	is("true","1","是"),
				
					/**是否类型---否*/
	no("false","0","否");
				
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private BooleanType(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static BooleanType getBooleanType(String index) {  
        for (BooleanType c : BooleanType.values()) {  
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
