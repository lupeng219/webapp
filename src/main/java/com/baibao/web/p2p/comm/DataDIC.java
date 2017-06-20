package com.baibao.web.p2p.comm;
/**
 * 数据字典
 */
public enum DataDIC {
	/**
	 * 交易类型
	 */
	DEPOSIT("0","DEPOSIT","充值"),
	DRAW("1", "DRAW","提现"),
	TENDER("2","TENDER","投标"),
	LOAN("3","LOAN","放款"),
	REPAYMENT("4","REPAYMENT","偿还本息"),
	BACKAMOUNT("5","BACKAMOUNT","回收本息"),
	FREEZE("6", "FREEZE","冻结"),
	UNFREEZE("7","UNFREEZE","解冻"),
	CHARGEFEE("8","CHARGEFEE","平台收费"),
	
	/** 还款账单中还款状态-未还款 */
	NOREPAYMENT("0","NOREPAYMENT","未还款"),
	/** 还款账单中还款状态-正常还款 */
	NORMALREPAYMENT("1","NORMALREPAYMENT","正常还款"),
	/** 还款账单中还款状态-逾期还款 */
	LATEREPAYMENT("2","LATEREPAYMENT","逾期还款"),
	/** 还款账单中还款状态-提前还款 */
	EARLYREPAYMENT("3","EARLYREPAYMENT","提前还款"),
	
	/**
	 * 还款明细表(付款)
	 * 还款交易表（收款）      
	 * 中的还款状态
	 */
	REAPYMENTSUCC("00","NOREPAYMENT","00 成功"),
	REPAYMENTFIAL("01","NORMALREPAYMENT","01 失败"),
	REPAYMENTSING("02","LATEREPAYMENT","02 处理中"),
	
	
	/**
	 * 投资和债权收益状态
	 */
	NOINCOME("10","NOINCOME","未收益"),
	INCOME("11","INCOME","已收益"),
	INCOMEING("12","INCOMEING","还款中"),


	
	/**
	 * 非新浪交易状态
	 */
	TRANSUCC("0","transSucc","成功"),
	TRANFAIL("1","transFail","失败"),
	TRANSING("2","transSucc","处理中"),
	TRANSINGLE("3","","漏单已处理"),
	/**
	 * 三方支付
	 */
	PAYTRUST("1","UMPAY","联动"),
	SINA("0","sinapay","新浪"),
	
	/**
	 * 活动
	 */
	REGISTERSEND("0","REGISTERSEND","注册送基金活动"),
	INVITEFRINDS("1","INVITEFRINDS","邀请好友注册送基金活动"),
	
	/**
	 * 新浪交易码
	 */
	COLLECTINVESTMENTCAPITAL("1001","COLLECTINVESTMENTCAPITAL","代收投资金"),
	COLLECTREPAYMENTCAPITAL("1002","COLLECTREPAYMENTCAPITAL","代收还款金"),
	PAYLOANACAPITAL("2001","PAYLOANACAPITAL","代付借款金"),
	PAYPROFITCAPIAL("2002","PAYPROFITCAPIAL","代付（本金/收益）金"),
	
	/**
	 * 新浪交易状态
	 */
	WAITPAY("1001","WAIT_PAY","等待付款(系统不会异步通知)"),
	PAYFINISHED("1002","PAY_FINISHED","已付款(系统会异步通知)"),
	TRADEFAILED("1003","TRADE_FAILED","交易失败(系统会异步通知)"),
	TRADEFINISHED("1004","TRADE_FINISHED","交易结束(系统会异步通知)"),
	TRADECLOSED("1005","TRADE_CLOSED","交易关闭（合作方通过调用交易取消接口来关闭）(系统会异步通知)"),
		
	/**
	 * 新浪支付状态
	 */
	SUCCESS("1001","SUCCESS","成功(系统会异步通知)"),
	FAILED("1002","FAILED","失败(系统会异步通知)"),
	PROCESSING("1003","PROCESSING","处理中(系统不会异步通知)"),
		
	
	/**
	 * 还款类型
	 */
	ORIGINALSINGLE("0","ORIGINALSINGLE","0原始单"),
	CREDITORSINGLE("1","CREDITORSINGLE","1债权单");

	private String dataCode ;
	private String dataType ;
	private String transMome ;
	private DataDIC(String transCode,String transType,String transMemo){
		this.dataCode = transCode;
		this.dataType = transType;
		this.transMome = transMemo;
	}
	
	public String getDataCode(){
		return this.dataCode;
	}
	public String getDataType(){
		return this.dataType;
	}
	public String getTransMemo()
	{
		return this.transMome;
	}
	
	public static void main(String agrs[])
	{
		System.out.println( DataDIC.FREEZE.getDataCode() );
	}
}
