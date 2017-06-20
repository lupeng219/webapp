package com.baibao.p2p.task;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.baibao.core.utils.CalenderUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.controller.eventBus.events.FriendsInvestmentEvent;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentEvent;
import com.baibao.web.p2p.generator.bean.P2p_activity_elements;
import com.baibao.web.p2p.generator.dataDIC.ActiveType;
import com.baibao.web.p2p.generator.dataDIC.MsgType;
import com.baibao.web.p2p.repository.ActiveRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.RestTemplateService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;
/**
 * 投资跑批
 * @Title: TenderTrade_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月26日
 */
//@Component
public class TenderTrade_Consumer implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(TenderTrade_Consumer.class);
	
	@Autowired
	private TenderTrade_Storage storage;
	@Autowired
	RestTemplateService restTemplateService;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private PayService payService;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private InnerSiteMsgEvent innerSiteMsgEvent;
	@Autowired
	private ActiveRepository activeRepository;
	@Autowired
	private InvestmentEvent investmentEvent;
	@Autowired
	private FriendsInvestmentEvent friendsInvestmentEvent;
	
	
	
	public TenderTrade_Consumer(){}
	public TenderTrade_Consumer( TenderTrade_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	//TimeUnit.MILLISECONDS.sleep(500);//正式环境去掉，因为联调环境调用频率1s3次
            	consumerHandler();
            }
        } catch (Exception ex) {
        	logger.error("Consumer Interrupted", ex);
        }
    }
	public void consumerHandler()
	{
		/**
		 * 发送新浪查询
		
    	Map<String, Object> consumeMap = storage.consume();
    	String ptr_tenderFlowNo = (String) consumeMap.get( "ptr_tenderFlowNo" );//投资单号
    	String ptr_productNo = (String) consumeMap.get( "ptr_productNo" );//产品编号
    	String ptr_custNo = (String) consumeMap.get( "ptr_custNo" );//投资客户号
    	
    	Map<String, Object> sinaRetMap = queryHostingTrade( ptr_tenderFlowNo);
    	String retCode = (String) sinaRetMap.get( "retCode" );
    	if( null != retCode && ControllerRetType.OPT_SUCC.getTransCode().equalsIgnoreCase( retCode.trim() ))
    	{
    		if ( sinaRetMap != null && sinaRetMap.get("response_code").equals( "APPLY_SUCCESS") ) 
			{
    			String trade_list   = (String) sinaRetMap.get( "trade_list" );
				String trade_status = "";
				String[] trade_array = trade_list.split( "\\^" );
				if(trade_array != null){
					trade_status = trade_array[ 3 ];
					switch( trade_status )
					{
						case "TRADE_FINISHED":
							updateTradeFlow( ptr_tenderFlowNo , Const.success );
							
							//给投资人发站内信
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("ptrTenderFlowNo", ptr_tenderFlowNo);
							Map<String, Object> ptr = tenderRepository.findByTenderFlowNo(map);
							this.PublishInnerSiteMsg((String)ptr.get("ptr_custNo"), MsgType.investment_msg.getDesc(), "投资", DateUtils.getDateToString(new Date(((Timestamp)ptr.get("ptr_transTime")).getTime())), ((BigDecimal)ptr.get("ptr_amount")).toString());
							this.InvestmentActive((String)ptr.get("ptr_custNo"), ((BigDecimal)ptr.get("ptr_amount")).toString());
							this.friendsInvestmentActive((String)ptr.get("ptr_custNo"), ((BigDecimal)ptr.get("ptr_amount")).toString(), ptr_tenderFlowNo);
							break;
						case "WAIT_PAY":
							break;
						case "PAY_FINISHED":
							break;
						case "TRADE_FAILED":
							updateTradeFlow( ptr_tenderFlowNo , Const.fail );
							invokeCoreTrans_back( sinaRetMap,ptr_productNo,ptr_custNo,ptr_tenderFlowNo);
							break;
						case "TRADE_CLOSED":
							updateTradeFlow( ptr_tenderFlowNo , Const.fail );
							invokeCoreTrans_back( sinaRetMap,ptr_productNo,ptr_custNo,ptr_tenderFlowNo);
							break;
					}
				}
			}
		}*/
	}
	
	@Transactional(rollbackFor=Exception.class)
	private void updateTradeFlow( String paf_transFlowNo,String status )
	{
		try{
			//更新订单表和投资表(收款)
			tenderRepository.updateByOrderFlowNo(paf_transFlowNo, status);
			tenderRepository.updateSuspiciousTenderFlow(paf_transFlowNo, status);
		}catch( Exception e  )
		{
			logger.error("updateTradeFlow", e);
		}
		
	}
	/*private Map<String, Object> queryHostingTrade( String ptr_tenderFlowNo)
	{
    	Map<String, String> params=new HashMap<String, String>();
    	params.put("out_trade_no", ptr_tenderFlowNo);
    	Map<String, Object> retMap = payService.query_hosting_trade(params);
    	return retMap;
    }*/
	
	public String invokeCoreTrans_back(Map<String, Object> tendMap,String ptr_productNo, String ptr_custNo, String trade_FlowNo) {
		MultiValueMap<String, String> postCoreTrans = new LinkedMultiValueMap<String, String>();
		postCoreTrans.add("tranCode", "1002");
		postCoreTrans.add("productNo", ptr_productNo);
		postCoreTrans.add("ptrTenderFlowNo", trade_FlowNo);
		postCoreTrans.add("custNo", ptr_custNo);
		postCoreTrans.add("transFlag", "N");
		postCoreTrans.add("ptrHostResponseTime",tendMap.get("response_time") == null ? CalenderUtil.generatorCurrentDate(null): (CalenderUtil.generatorCurrentDate((String) tendMap.get("response_time")))); // 第三方响应时间
		postCoreTrans.add("ptrHostReturnCode", (String) tendMap.get("response_code"));// 第三方返回码
		postCoreTrans.add("ptrHostReturnMessage",(String) (tendMap.get("response_message") == null ? "" : tendMap.get("response_message")));// 第三方返回信息

		String returnJSON = "";
		try {
			returnJSON = restTemplateService.postForEntity( postCoreTrans );
			return returnJSON;
		} catch (Exception e) {
			logger.error("invoke coreTrans exception ", e);
		}
		return returnJSON;
	}
	
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
	/**
	 * 投资活动
	 * @param custNo
	 * @param amount
	 */
	private void InvestmentActive(String custNo,String amount){
		P2p_activity_elements active =  activeRepository.getActiveByType(ActiveType.investment.getIndex());
		if(active != null){
			
			investmentEvent.setActiveId(active.getPae_activeId().toString());
			investmentEvent.setEffectTime(active.getPae_effectTime());
			investmentEvent.setCustNo(custNo);
			investmentEvent.setGoodsType(active.getPae_goodsType());
			investmentEvent.setAmount(amount);
			investmentEvent.setActiveStarTime(active.getPae_starTime());
			investmentEvent.setAmount(amount);
		}
	}
	
	/**
	 * 好友投资奖励
	 * @param puCustNo
	 * @param investAmount
	 * @param tenderFlowNo
	 * @param projectNo
	 * @param projectTerm
	 */
	private void friendsInvestmentActive(String puCustNo,String investAmount,String tenderFlowNo){
		P2p_activity_elements active =  activeRepository.getActiveByType(ActiveType.friendsinvestment.getIndex());
		if(active != null){
			friendsInvestmentEvent.setActiveId(active.getPae_activeId().toString());
			friendsInvestmentEvent.setActivity(active);
			friendsInvestmentEvent.setInvestAmount(investAmount);
			friendsInvestmentEvent.setTenderFlowNo(tenderFlowNo);
			friendsInvestmentEvent.setPuCustNo(puCustNo);
		}
	}
}
