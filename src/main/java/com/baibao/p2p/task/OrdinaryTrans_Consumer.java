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

import com.baibao.core.utils.CalenderUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.repository.RepaymentBillTransDetailRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.RestTemplateService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;
/**
 * 普通转账代付
 * @Title: RepaymentDetailsTrade_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月26日
 */
//@Component
public class OrdinaryTrans_Consumer implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(OrdinaryTrans_Consumer.class);
	
	@Autowired
	private OrdinaryTrans_Storage storage;
	@Autowired
	private RestTemplateService restTemplateService;
	@Autowired
	private RepaymentBillTransDetailRepository repaymentBillTransDetailRepository;
	@Autowired
	private PayService payService;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private InnerSiteMsgEvent innerSiteMsgEvent;
	@Autowired
	private TenderRepository tenderRepository;
	
	public OrdinaryTrans_Consumer(){}
	public OrdinaryTrans_Consumer( OrdinaryTrans_Storage storage ) {
        this.storage = storage;
    }
	public void run() {
        try {
            while (true) {
            	//TimeUnit.MILLISECONDS.sleep(500);//正式环境去掉，因为联调环境调用频率1s3次
            	consumerHandler( );
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
    	String prd_tradeFlowNo = (String) consumeMap.get( "prt_transFlowNo" );//交易单号
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
							updateOrdinaryTrans( sinaRetMap ,prd_tradeFlowNo, Const.success );
							break;
						case "WAIT_PAY":
							break;
						case "PAY_FINISHED":
							break;
						case "TRADE_FAILED":
							updateOrdinaryTrans( sinaRetMap ,prd_tradeFlowNo, Const.fail  );
							break;
						case "TRADE_CLOSED":
							updateOrdinaryTrans( sinaRetMap ,prd_tradeFlowNo,Const.fail);
							break;
					}
				}
			}*/
    	}
	
	@Transactional(rollbackFor=Exception.class)
	private void updateOrdinaryTrans( Map<String, Object> tendMap,String prt_tradeFlowNo,String prd_status )
	{
		try{
			String ptrHostResponseTime = tendMap.get("response_time") == null ? CalenderUtil.generatorCurrentDate(null): (CalenderUtil.generatorCurrentDate((String) tendMap.get("response_time"))); //第三方返回码
			String ptrHostReturnCode = (String) tendMap.get("response_code"); // 第三方响应时间
			String ptrHostReturnMessage = (String) (tendMap.get("response_message") == null ? "" : tendMap.get("response_message"));// 第三方返回信息
			repaymentBillTransDetailRepository.updateOrdinaryTransByFlowNo(prt_tradeFlowNo, prd_status, ptrHostResponseTime, ptrHostReturnCode, ptrHostReturnMessage);
			if(Const.success.equals(prd_status)){
				Map<String, Object>map = new HashMap<String, Object>();
				P2p_user_warehouse warehouse = tenderRepository.selectBytransFlowNoPay(prt_tradeFlowNo);
				if(warehouse!=null){//更新仓库表
					map.put("state", "3");
					map.put("puw_whNo", warehouse.getPuwWhno());
					tenderRepository.updateByPuw_whNo(map);
					//更新仓库流水
					map.put("state", Const.success);
					map.put("time",new Date() );
					map.put("puwf_whNo",warehouse.getPuwWhno());
					tenderRepository.updateBywhNo(map);
				}
			}
		}catch( Exception e  )
		{
			logger.error("updateOrdinaryTrans", e);
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
