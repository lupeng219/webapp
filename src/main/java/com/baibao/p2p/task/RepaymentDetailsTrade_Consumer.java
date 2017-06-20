package com.baibao.p2p.task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.dataDIC.MsgType;
import com.baibao.web.p2p.repository.RepaymentBillTransDetailRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.RestTemplateService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;
/**
 * 还款代付
 * @Title: RepaymentDetailsTrade_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月26日
 */
//@Component
public class RepaymentDetailsTrade_Consumer implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(RepaymentDetailsTrade_Consumer.class);
	
	@Autowired
	private RepaymentDetailsTrade_Storage storage;
	@Autowired
	private RestTemplateService restTemplateService;
	@Autowired
	private RepaymentBillTransDetailRepository repaymentBillTransDetailRepository;
	@Autowired
	private PayService payService;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private TendertProfitRepository tendertProfitRepository;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private InnerSiteMsgEvent innerSiteMsgEvent;
	
	public RepaymentDetailsTrade_Consumer(){}
	public RepaymentDetailsTrade_Consumer( RepaymentDetailsTrade_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	//TimeUnit.MILLISECONDS.sleep(500);//正式环境去掉，因为联调环境调用频率1s3次
            	consumerHandler( );
            }
        } catch (Exception ex) {
        	logger.error( "Consumer Interrupted", ex);
        }
    }
	public void consumerHandler()
	{
		/**
		 * 发送新浪查询
		
    	Map<String, Object> consumeMap = storage.consume();
    	String prd_tradeFlowNo = (String) consumeMap.get( "prd_tradeFlowNo" );//交易单号
    	Map<String, Object> sinaRetMap = queryHostingTrade( prd_tradeFlowNo);
    	String retCode = (String) sinaRetMap.get( "retCode" );
    	if( null != retCode && ControllerRetType.OPT_SUCC.getTransCode().equalsIgnoreCase( retCode.trim() ))
    	{
    		if ( sinaRetMap != null && sinaRetMap.get("response_code").equals( "APPLY_SUCCESS") ) 
			{
    			String repayment_details_list   = (String) sinaRetMap.get( "trade_list" );
				String trade_status = "";
					String[] trade_array = repayment_details_list.split( "\\^" );
					trade_status = trade_array[ 3 ];
					switch( trade_status )
					{
						case "TRADE_FINISHED":
							updateTradeFlow( prd_tradeFlowNo , Const.success );
							break;
						case "WAIT_PAY":
							break;
						case "PAY_FINISHED":
							break;
						case "TRADE_FAILED":
							updateTradeFlow( prd_tradeFlowNo , Const.fail  );
							break;
						case "TRADE_CLOSED":
							updateTradeFlow( prd_tradeFlowNo , Const.fail);
							break;
					}
				}
			}*/
    	}
	
	@Transactional(rollbackFor=Exception.class)
	private void updateTradeFlow( String prd_tradeFlowNo,String prd_status )
	{
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("prd_tradeFlowNo", prd_tradeFlowNo);
		params.put("prd_status", prd_status);
		try{
			if(Const.success.equals(prd_status)){
				P2p_tender_profit profit = tendertProfitRepository.getByTradeFlowNo(prd_tradeFlowNo);
				tendertProfitRepository.updateProfitRecord(profit, RepaymentBillStatus.NORMALREPAYMENT.getIndex());//已收益
				
				//给投资人发站内信
				//this.PublishInnerSiteMsg(profit.getPtpCustno(), MsgType.investment_msg.getIndex(), "收回", DateUtils.getDateToString(profit.getPtpFactprofittime()), profit.getPtpFactprofit().toString());
			}
			repaymentBillTransDetailRepository.updatePrdStatus(params);
			tenderRepository.updateByOrderFlowNo(prd_tradeFlowNo, prd_status);
		}catch( Exception e  )
		{
			logger.error("updateTradeFlow", e);
		}
		
	}
	/*private Map<String, Object> queryHostingTrade( String prd_tradeFlowNo )
	{
    	Map<String, String> params=new HashMap<String, String>();
    	params.put("out_trade_no", prd_tradeFlowNo);
    	Map<String, Object> retMap = payService.query_hosting_trade(params);
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
	private void PublishInnerSiteMsg(String custNo,String msgType,String businessMsg,String time,String money){
			
			String mobile = userRepository.findUserByCustNo(custNo).getPuMobile();
			innerSiteMsgEvent.setCustNo(custNo);
			innerSiteMsgEvent.setSysMsgType(msgType);
			innerSiteMsgEvent.setSysMsgPubTime(DateUtils.getDateToString(new Date()));
			innerSiteMsgEvent.setSysMsgContent("尊敬的用户 "+mobile.substring(0, 3)+"****"+mobile.substring(7, 11)+":您于"+time+"成功"+businessMsg+money+"元");
	}
}
