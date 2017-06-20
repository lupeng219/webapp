	
package com.baibao.web.p2p.generator.dataDIC;

/**
 * 	
 * @author Denny
 * @date 2016年6月21日
 * @see  访问来源
 * 
 */
public enum RegistType{
	
	/**
	 * 注册来源类型
	 */
	PC("pc","1","电脑端"),
	APP("app","2","手机端"),
	WAP("wap","3","wap端"),
	WECHAT("wechat","4","微信端");
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private RegistType(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static RegistType getRegistType(int index) {  
        for (RegistType c : RegistType.values()) {  
        	 if (c.getIndex().equals(index)) {   
                return c;  
            }  
        }  
        return null;  
    }
	
	public static String getName(int index){
		String indexStr = String.valueOf(index);
		 for (RegistType c : RegistType.values()) {  
			 if (c.getIndex().equals(indexStr)) {   
	                return c.getName();  
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
