package com.baibao.web.p2p.comm;

public enum TenderProfitStatus {
	
	//收益状态  10未收益  11已收益 12还款中
	FINISHED("finished","11","已完结"),
	EXPECT("expect","10","预期"),
	INHAND("inhand","12","处理中"),
	
	//收益类型
	//40 本金  41 利息 42 本息和  43 佣金
	PRINCIPAL("Principal","40","本金"),
	INTEREST("Interest","41","利息"),
	PRINCIPALANDINTEREST("PrincipalAndInterest","42","本息和"),
	COMMISSION("Commission","43","佣金");
	
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
    
    private TenderProfitStatus(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static TenderProfitStatus getRepaymentStatus (String index) {  
        for (TenderProfitStatus c : TenderProfitStatus.values()) {  
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
