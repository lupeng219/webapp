	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 红包状态
	 * @author yangyang
	 *
	 */
public enum RedEnvelopeType{
	
	/**未使用*/
	noUseStatus("noUseStatus",0,"未使用"),
	
	/**已使用*/
	usedStatus("usedStatus",1,"已使用"),
	
	/**已过期*/
	overTimeStatus("overTimeStatus",2,"已过期"),
	
	/**已赠送*/
	presented("overTimeStatus",2,"已过期"),
	
	/**处理中*/
	processing("processing",4,"处理中");
	
	
	private int index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private RedEnvelopeType(String name, int index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static RedEnvelopeType getRedEnvelopeType(int index) {  
        for (RedEnvelopeType c : RedEnvelopeType.values()) {  
        	 if (c.getIndex() == index) {   
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
		
	
}
