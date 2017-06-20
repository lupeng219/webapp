	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 借款申请状态
	 * @author YY
	 *
	 */
public enum LoanApplyStatus{
	
				
					/**借款申请状态---初审待审*/
	waitfristaudi("waitfristaudi","21","初审待审"),
	
					/**借款申请状态---初审拒绝*/
	refusefristaudi("refusefristaudi","22","初审拒绝"),
	
					/**借款申请状态---复审待审*/
	waitsecondaudi("waitsecondaudi","31","复审待审"),
	
					/**借款申请状态---复审拒绝*/
	refusesecondaudi("refusesecondaudi","32","复审拒绝"),
					/**借款申请状态---待放款审批*/
	waitloanaccount("waitloanaccount","41","已完成");
	
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private LoanApplyStatus(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static LoanApplyStatus getloanApplyStatus (String index) {  
        for (LoanApplyStatus c : LoanApplyStatus.values()) {  
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
