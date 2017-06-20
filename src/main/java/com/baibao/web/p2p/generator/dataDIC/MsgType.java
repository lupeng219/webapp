	
package com.baibao.web.p2p.generator.dataDIC;

	/**
	 * 站内信息类型(数据字典)
	 * @author yangyang
	 *
	 */
public enum MsgType{
	
	/**充值消息*/
	recharge_msg("recharge","01","充值消息"),
	
	/**提现消息*/
	withdrawal_msg("withdrawal","02","提现消息"),
	
	/**理财消息*/
	investment_msg("investment","03","理财消息"),
	
	/**还款消息*/
	reimbursement_msg("reimbursement","04","还款消息"),
	
	/**活动奖励*/
	activereward_msg("activereward","05","活动奖励");
	
	
	
	private String index;  //value
    private String name;   //key
    private String desc;   //描述
   
    private MsgType(String name, String index,String desc) {  
        this.name = name;  
        this.index = index;  
        this.desc =desc;
    } 
    /**
	 * 通过value获取对象	 
	 */  
	public static MsgType getMsgType(String index) {  
        for (MsgType c : MsgType.values()) {  
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
