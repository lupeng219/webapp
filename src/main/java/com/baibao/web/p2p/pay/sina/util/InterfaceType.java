package com.baibao.web.p2p.pay.sina.util;
/*
    @Author bottle
 */
public enum InterfaceType {
	
	 
	 BINDING_VERIFY("绑定认证信息","binding_verify","binding_verify"),
	 BINDING_BANK_CARD("绑定银行卡","binding_bank_card","binding_bank_card"),
	 BINDING_BANK_CARD_ADVANCE("绑定银行卡推进","binding_bank_card_advance","binding_bank_card_advance"),
	 QUERY_BANK_CARD("查询银行卡","query_bank_card","query_bank_card"),
	 CREATE_HOSTING_DEPOSIT("托管充值","create_hosting_deposit","create_hosting_deposit"),
	 ADVANCE_HOSTING_PAY("支付推进","advance_hosting_pay","advance_hosting_pay"),
	 QUERY_BALANCE("查询余额/基金份额","query_balance","query_balance"),
	 BALANCE_FREEZE("冻结余额","balance_freeze","balance_freeze"),
	 BALANCE_UNFREEZE("解冻余额","balance_unfreeze","balance_unfreeze"),
	 CREATE_HONSTING_WITHDRAW("托管提现","create_hosting_withdraw","create_hosting_withdraw"),
	 CREATE_HOSTING_COLLECT_TRADE("代收","create_hosting_collect_trade","create_hosting_collect_trade"),
	 CREATE_SINGLE_HOSTING_PAY_TRADE("代付","create_single_hosting_pay_trade","create_single_hosting_pay_trade"),
	 CREATE_BATCH_HOSTING_PAY_TRADE("批量代付","create_batch_hosting_pay_trade","create_batch_hosting_pay_trade"),
	 QUERY_HOSTING_TRADE("托管交易查询","query_hosting_trade","query_hosting_trade"),
	 CREATE_HOSTING_REFUND("托管退款","create_hosting_refund","create_hosting_refund"),
	 QUERY_HOSTING_REFUND("托管退款查询","query_hosting_refund","query_hosting_refund"),
	 QUERY_HOSTING_DEPOSIT("托管充值查询","query_hosting_deposit","query_hosting_deposit"),
	 QUERY_HOSTING_WITHDRAW("托管提现查询","query_hosting_withdraw","query_hosting_withdraw"),
	 QUERY_ACCOUNT_DETAILS("查询交易明细","query_account_details","query_account_details"),
	 UNBINDING_BANK_CARD("解绑银行卡","unbinding_bank_card","Unbinding_bank_card"),
	 UNBINDING_BANK_CARD_ADVANCE("解绑银行卡推进","unbinding_bank_card_advance","Unbinding_bank_card_advance"),
	 UNBINGDING_VERIFY("解绑认证信息","unbinding_verify","unbinding_verify"),
	 CREATE_HOSTING_TRANSFER("转账","create_hosting_transfer","create_hosting_transfer"),
	 CREATE_P2P_HOSTING_BORROWING_TARGET("标的录入","create_p2p_hosting_borrowing_target","create_p2p_hosting_borrowing_target")
	 
	 
	 ;
     private String serviceName;
     private String serviceCode;
     private String description;
     
     private InterfaceType(String serviceName,String serviceCode,String description){
    	 this.serviceName=serviceName;
    	 this.serviceCode=serviceCode;
    	 this.description=description;
     }

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
      
	
}
