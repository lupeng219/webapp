package com.baibao.web.p2p.comm;

public enum RepaymentBillTransStatus {
	
	//还款状态 00 成功  01 失败   02 处理中
	SUCCESS("success","00","成功"),
	FAIL("fail","01","失败"),
	TRANSING("fransing","02","处理中");
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
    
    private RepaymentBillTransStatus(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static RepaymentBillTransStatus getRepaymentStatus (String index) {  
        for (RepaymentBillTransStatus c : RepaymentBillTransStatus.values()) {  
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
