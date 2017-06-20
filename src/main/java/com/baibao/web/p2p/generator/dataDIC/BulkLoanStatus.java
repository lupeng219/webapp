	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 融资状态
	 * @author YY
	 *
	 */
public enum BulkLoanStatus{
	//融资状态:0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
					/**融资状态---待开放*/
	waitopen("waitopen",0,"待开放"),
				
					/**融资状态---开放投标*/
	openproduct("openproduct",1,"开放投标"),
				
					/**融资状态---已满标*/
	alreadyfull("alreadyfull",2,"已满标"),
	
					/**融资状态---流标*/
	flowstandard("flowstandard",3,"流标"),

   					/**融资状态---还款中*/
    repaymenting("repaymenting",4,"还款中"),
    
   					/**融资状态---已结束*/
	completeproduct("completeproduct",5,"已结束");
	
	private int index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private BulkLoanStatus(String name, int index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static BulkLoanStatus getbulkLoanStatus (int index) {  
        for (BulkLoanStatus c : BulkLoanStatus.values()) {  
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
