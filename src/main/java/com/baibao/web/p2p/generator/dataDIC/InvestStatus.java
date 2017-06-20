	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 来源类型
	 *
	 */
public enum InvestStatus{
	
	/**
	 * 注册来源类型
	 */
	NOGAIN("noGain","01","未收益"),
	ALREADYGAINS("alreadyGains","00","已收益"),
	INHAND("inHand","02","处理中");
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private InvestStatus(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static InvestStatus getRegistType(int index) {  
        for (InvestStatus c : InvestStatus.values()) {  
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
