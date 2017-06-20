package com.baibao.p2p.task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.dataDIC.MsgType;
import com.baibao.web.p2p.repository.AccountFlowRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;
/**
 * 充值、提现跑批
 * @Title: Account_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月26日
 */
//@Component
public class Account_Consumer implements Runnable{

	@Autowired
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(Account_Consumer.class);
	@Autowired
	private Account_Storage storage;
	@Autowired
	private PayService payService;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private InnerSiteMsgEvent innerSiteMsgEvent;
	@Autowired
	private AccountFlowRepository accountFlowRepository;
	public Account_Consumer() {
    }
	
	public Account_Consumer(Account_Storage storage) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	//TimeUnit.MILLISECONDS.sleep(500);//正式环境去掉，因为联调环境调用频率1s3次
            	consumerHandler( );
            }
        } catch (Exception ex) {
        	
        	logger.error( "Consumer Interrupted" ,ex);
        }
    }
	
	public void consumerHandler()
	{
		/**
		 * 发送新浪查询
		
    	Map<String, Object> consumeMap = storage.consume();
    	String paf_transFlowNo = (String) consumeMap.get( "paf_transFlowNo" );
    	String paf_accountNo = (String) consumeMap.get( "paf_accountNo" );
    	String paf_transactionType = (String)consumeMap.get("paf_transactionType");
    	
    	Map<String, Object> sinaRetMap = new HashMap<String, Object>();
    	//判断流水是充值还是提现
    	String pam = "";
    	if(paf_transactionType.equals(Const.recharge)){
    		sinaRetMap = queryHostingDeposit( paf_transFlowNo, paf_accountNo );
    		pam = "deposit_list";
    	}else{
    		sinaRetMap = queryHostingWithdraw( paf_transFlowNo, paf_accountNo );
    		pam = "withdraw_list";
    	}
    	
    	String retCode = (String) sinaRetMap.get( "retCode" );
    	if( null != retCode && ControllerRetType.OPT_SUCC.getTransCode().equalsIgnoreCase( retCode.trim() ))
    	{
    		if ( sinaRetMap != null && !sinaRetMap.get("response_code").equals("") ) 
			{
				String list   = (String) sinaRetMap.get( pam );
				if(list !=null){
					String[] deposit_array = list.split( "\\^" );
					String trade_FlowNo = deposit_array[ 0 ];
					String trade_status = deposit_array[ 2 ];
					switch( trade_status )
					{
						case "SUCCESS":
							updateTradeFlow( trade_FlowNo , Const.success );
							break;
						case "PROCESSING":
							break;
						case "FAILED":
							updateTradeFlow( trade_FlowNo ,Const.fail );
							break;
					}
				}
			}
		}else{
			if ( sinaRetMap != null && !sinaRetMap.get("response_code").equals("")) {
				if(sinaRetMap.get("response_code").equals("ORDER_NOT_EXIST")){//订单不存在
					updateTradeFlow( paf_transFlowNo , "01" );
				}
			}
		}*/
	}
	
	private void updateTradeFlow( String paf_transFlowNo,String status )
	{
		try{
			//更新订单表和账户流水(充值，提现) 
			tenderRepository.updateByOrderFlowNo(paf_transFlowNo, status);
			accountService.updateSuspiciousFlow(paf_transFlowNo, status);
		}catch(Exception e)
		{
			logger.error("updateTradeFlow" , e);
		}
		
	}

	//托管充值查询
	/*private Map<String, Object> queryHostingDeposit(String paf_transFlowNo, String identity_id)
	{
    	Map<String, String> params=new HashMap<String, String>();
    	params.put("identity_id", identity_id);
    	params.put("identity_type", Const.UID);
    	params.put("account_type", Const.SAVING_POT);
    	params.put("out_trade_no", paf_transFlowNo);
    	
    	//Map<String, Object> retMap = queryHostingDepositHandler.handle(params);
    	Map<String, Object> retMap = payService.query_hosting_deposit(params);
    	
    	return retMap;
    }
	//托管提现查询
	private Map<String, Object> queryHostingWithdraw(String paf_transFlowNo,String identity_id){
		Map<String, String> params=new HashMap<String, String>();
    	params.put("identity_id", identity_id);
    	params.put("identity_type", Const.UID);
    	params.put("account_type", Const.SAVING_POT);
    	params.put("out_trade_no", paf_transFlowNo);
    	
    	//Map<String, Object> retMap = queryHostingWithdraw.handle(params);
    	Map<String, Object> retMap = payService.query_hosting_withdraw(params);
    	
    	return retMap; 
	}*/
	/**
	 * 发布详情
	 * @param custNo 客户号
	 * @param flowNo 流水号
	 * @param msgType 站内信息类型名称
	 * @param businessMsg 业务类型（充值、提现、投资、还款、活动）
	 * @param time 交易时间
	 * @param money 交易金额
	 */
	private void PublishInnerSiteMsg(
		String custNo, String msgType, String businessMsg, String time, String money)
	{
		String mobile = userRepository.findUserByCustNo(custNo).getPuMobile();
		innerSiteMsgEvent.setCustNo(custNo);
		innerSiteMsgEvent.setSysMsgType(msgType);
		innerSiteMsgEvent.setSysMsgPubTime(DateUtils.getDateToString(new Date()));
		innerSiteMsgEvent.setSysMsgContent("尊敬的用户 "+mobile.substring(0, 3)+"****"+mobile.substring(7, 11)+":您于"+time+"成功"+businessMsg+money+"元");
	}
}
