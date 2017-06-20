package com.baibao.web.p2p.utils;

public enum ControllerRetType {

	OPT_SUCC("0000","","操作成功"),
	OPT_FAIL("0001","","操作失败"),
	LOGIN_FAIL("1000","login","登陆失败"),
	LOGINOUT_FAIL("1001","login","退出失败"),
	NOLOGIN("1002", "login","未登陆"),
	UNSECURITY("1003", "action","没有权限"),
	SESSION_TIMEOUT("1004", "session","登陆超时"),
	MODIFY_PASSWORD_FAIL("1005", "modifyPassword","修改密码失败"),
	
	TENDER_FAIL("1006","tender","投标失败"),
	BALANCE_CHECK("1007","tender","余额不足"),
    CHECK_LOGINOUT("1008","ifLogin","未登录"),
    PARAMETER_EXCEPTION("1009","illegalParameter","参数不合法"),
    SIGN_EXCEPTION("1010","signException","签名异常"),
    EXCEED_MAX_TRADE_PAY_EXCEPTION("1011","exceedMaxTradePayException","批量代付最大交易笔数为300笔"),
    EXCEED_MAX_SINGLE_SPLIT_LIST_PAY_EXCEPTION("1012","exceedMaxSplitListPayException","单笔代付最大分账笔数为10笔"),
    AUTH_YES("00","auth_yes","已认证"),
    AUTH_NO("01","auth_no","没有认证"),
    
    CHECK_SIGN_FAIL("2000","check_sign_fail","验签失败"),
    DUPLICATE_VERIFY("2001","duplicate_verify","会员认证信息重复"),
    REALNAME_CONFIRM_FAILED("2002","rename_confirm_failed","实名认证不通过")
    ;
	
	private String transCode ;
	private String transType ;
	private String transMome ;
	private ControllerRetType(String transCode,String transType,String transMemo){
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
		System.out.println( TransType.FREEZE.getTransCode() );
	}
}
