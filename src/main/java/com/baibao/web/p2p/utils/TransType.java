package com.baibao.web.p2p.utils;
/**
 * 交易类型
 */
public enum TransType {
	DEPOSIT("00","DEPOSIT","充值"),
	DRAW("01", "DRAW","提现"),
	TENDER("02","TENDER","投标"),
	REPAYMENT("03","REPAYMENT","还款"),
	FREEZE("04", "FREEZE","冻结"),
	UNFREEZE("05","UNFREEZE","解冻"),
	TRANSFER_Creditor("14", "TRANSFER_CREDITOR","债权转让"),
	TRANSFER_Settlement("15","TRANSFER_SETTLEMENT","转账-结算担保收益");
	
	private String transCode ;
	private String transType ;
	private String transMome ;
	private TransType(String transCode,String transType,String transMemo){
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
