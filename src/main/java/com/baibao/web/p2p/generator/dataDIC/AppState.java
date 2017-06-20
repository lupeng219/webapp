	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 审批状态枚举类
	 * @author YY
	 *
	 */
public enum AppState{
	
					/**初审状态*/
	firstaudit("firstaudit","0","初审"),
				
					/**终审状态*/
	secondaudit("secondaudit","1","终审"),
				
					/**放款待审核*/
	loanaudit("loanaudit","2","放款待审批");
	
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private AppState(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static AppState getAppState(String index) {  
        for (AppState c : AppState.values()) {  
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
