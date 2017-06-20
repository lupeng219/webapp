package com.baibao.web.p2p.utils;

public enum DBStatus {

	LOGIN_SUCC("9000-y","login","登陆成功"),
	LOGIN_FAIL("9000-n","login","登陆失败"),
	LOGINOUT_SUCC("9001-y","login","退出成功"),
	LOGINOUT_FAIL("9001-n","login","退出失败"),
	NOLOGIN("9999", "login","未登陆"),
	UNSECURITY("9002", "action","没有权限"),
	SESSION_TIMEOUT("9003", "session","登陆超时"),
	
	 REGIST_VALIDATA_FALY("1004-n","regist","后台验证失败"),
	 REGIST_VALIDATA_SUCC("0000","regist","注册成功"),
	 
	MODIFY_PASSWORD_SUCC("0000 ","modifyPassword","修改密码成功"),
	MODIFY_PASSWORD_FAIL("1002-n", "modifyPassword","修改密码失败"),
	
	TENDER_SUCC("1003-1","tender","投标成功"),
	TENDER_FAIL("1003-2","tender","投标失败"),
	BALANCE_CHECK("9001","tender","余额不足"),
	
	Request_Exception("8001-e","controller","未知异常"),
	BBS_REQ_SUCC("0000","bbs","成功"),
	BBS_REQ_FALY("8001-n","bbs","失败"),
    ;
	
	private String transCode ;
	private String transType ;
	private String transMome ;
	private DBStatus(String transCode,String transType,String transMemo){
		this.transCode = transCode;
		this.transType = transType;
		this.transMome = transMemo;
	}
	
	public String getTransCode(){
		return this.transCode;
	}
	public String getTransType(){
		return this.transType;
	}
	public String getTransMemo()
	{
		return this.transMome;
	}
	
	public static void main(String agrs[])
	{
		
	}
}
