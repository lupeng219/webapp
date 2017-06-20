package com.baibao.web.p2p.umpay.cons;

/**
 * 交易类型
 * @author Wang.Sheng
 *
 */
public enum UMPayBusiType {	
	BusiType1("1"),//	充值成功,
	BusiType2("2"),//	提现完成,
	BusiType3("3"),//	提现冻结,
	BusiType4("4"),//	转入,
	BusiType5("5"),//	转出,
	BusiType6("6"),//	基金收益,
	BusiType7("7"),//	投标,
	BusiType8("8"),//	债权购买,
	BusiType9("9"),//	偿还本息,
	BusiType10("10"),//	流标返款,
	BusiType11("11"),//	平台收费,
	BusiType12("12"),//	平台放款,
	BusiType13("13"),//	回收本息,
	BusiType14("14"),//	出售债权,
	BusiType15("15"),//	撤资后返款,
	BusiType16("16"),//	逾期收费,
	BusiType17("17"),//	绑卡,
	BusiType18("18"),//	换卡
	BusiType19("19");//	平台向个人用户转账
	
	private String type ;
	private UMPayBusiType(String type){
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
