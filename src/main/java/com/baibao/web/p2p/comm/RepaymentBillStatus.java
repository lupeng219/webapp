package com.baibao.web.p2p.comm;

public enum RepaymentBillStatus {
	
	//还款状态 0未还款，1正常还款，2逾期还款，3提前还款
	NOREPAYMETN("noRepayment", "0", "未还款"),
	NORMALREPAYMENT("normalRepayment", "1", "正常还款"),
	OVERDUEREPAYENT("overdueRepayment", "2", "逾期"),
	ADVANCEREPAYMENT("advanceRepayment", "3", "提前还款"),
	INHANDREAPYMENT("inhandRepayment", "4", "还款处理中"),
	TRANS("trans", "6", "已转让"),
	TRANING("traning", "7", "转让中");

	private String index;  //value
    private String name;   //key
    private String desc;   //描述
    
    private RepaymentBillStatus(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static RepaymentBillStatus getRepaymentStatus (String index) {  
        for (RepaymentBillStatus c : RepaymentBillStatus.values()) {  
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
