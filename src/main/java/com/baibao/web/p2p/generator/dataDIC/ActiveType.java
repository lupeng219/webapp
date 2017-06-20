	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 活动类型枚举类
	 * @author yangyang
	 *
	 */
public enum ActiveType{
	
	/**注册*/
	regist("regist","10","注册"),
	
	/**邀请好友注册*/
	friendsregist("friendsregist","11","好友注册"),
	
	/**投资赠送*/
	investment("investment","12","投资赠送"),
	
	/**好友投资赠送利息8%*/
	friendsinvestment("friendsinvestment","13","好友投资赠送"),
	
	/**签到*/
	signin("signin","14","签到"),
	
	/**抽奖*/
	luckydraw("luckydraw","15","抽奖"),
	
	/**好友首次投资奖励*/
	fivecash("fivecash","16","好友首次投资奖励");
	
	
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private ActiveType(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static ActiveType getActiveType(String index) {  
        for (ActiveType c : ActiveType.values()) {  
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
