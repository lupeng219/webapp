	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 奖品种类
	 * @author yangyang
	 *
	 */
public enum PrizeType{
	
	/**红包*/
	redenvelope("redenvelope","1000","红包"),
	
	/**礼券*/
	giftcertificates("giftcertificates","1001","礼券"),
	
	/**积分*/
	integral("integral","1002","积分"),
	
	/**现金*/
	cash("cash","1003","现金");
	
	
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private PrizeType(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static PrizeType getPrizeType(String index) {  
        for (PrizeType c : PrizeType.values()) {  
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
