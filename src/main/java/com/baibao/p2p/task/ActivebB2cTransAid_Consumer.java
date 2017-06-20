package com.baibao.p2p.task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;
import com.baibao.web.p2p.generator.dao.P2p_activityMapper;
import com.baibao.web.p2p.repository.ActiveRepository;
import com.baibao.web.p2p.repository.RepaymentBillTransRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.RestTemplateService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;
/**
 * 活动转账代收
 * @Title: RepaymentTrade_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年3月18日
 */
//@Component
public class ActivebB2cTransAid_Consumer implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(ActivebB2cTransAid_Consumer.class);
	
	@Autowired
	private ActivebB2cTransAid_Storage storage;
	@Autowired
	private RestTemplateService restTemplateService;
	@Autowired
	private PayService payService;
	@Autowired
	private RepaymentBillTransRepository repaymentBillTransRepository;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private InnerSiteMsgEvent innerSiteMsgEvent;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private P2p_activityMapper p2p_activityMapper;
	
	public ActivebB2cTransAid_Consumer(){}
	public ActivebB2cTransAid_Consumer( ActivebB2cTransAid_Storage storage ) {
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
    	String part_transFlowNo = (String) consumeMap.get( "part_transFlowNo" );
    	Map<String, Object> sinaRetMap = queryHostingTrade( part_transFlowNo );
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("part_transFlowNo",part_transFlowNo);
    	String retCode = (String) sinaRetMap.get( "retCode" );
    	if( null != retCode && ControllerRetType.OPT_SUCC.getTransCode().equalsIgnoreCase( retCode.trim() ))
    	{
    		if ( sinaRetMap != null && sinaRetMap.get("response_code").equals( "APPLY_SUCCESS") ) 
			{
    			String trade_list   = (String) sinaRetMap.get( "trade_list" );
				String trade_status = "";
					String[] trade_array = trade_list.split( "\\^" );
					if(trade_array != null){
						part_transFlowNo = trade_array[ 0 ];
						trade_status = trade_array[ 3 ];
						switch( trade_status )
						{
							case "TRADE_FINISHED":
								map.put("part_status",Const.success);
								int count = p2p_activityMapper.updateActiveB2cTransAid(map);
								//发送站内信
								//this.PublishInnerSiteMsg(bill.getPrbCustno(), MsgType.reimbursement_msg.getIndex(), "还款",DateUtils.getDateToString(bill.getPrbInfactrepaymenttime()), bill.getPrbInfactrepaymentpricipal().toString());
								break;
							case "WAIT_PAY":
								break;
							case "PAY_FINISHED":
								break;
							case "TRADE_FAILED":
								map.put("part_status",Const.fail);
								p2p_activityMapper.updateActiveB2cTransAid(map);
								P2p_user_warehouse warehouse = tenderRepository.selectBytransFlowNo(part_transFlowNo);
								if(warehouse!=null){//更新红包表
									map.put("state", "1");
									map.put("puw_whNo", warehouse.getPuwWhno());
									tenderRepository.updateByPuw_whNo(map);
								}else{
									P2p_users_redenvelope usersredenve = tenderRepository.selectBytransFlowNoAction(part_transFlowNo);
									if(usersredenve!=null){
										map.put("pur_status", "1");
										map.put("pur_redenvelopeNo", usersredenve.getPurRedenvelopeno());
										tenderRepository.updateredenvelo(map);
									}
									
								}
								break;
							case "TRADE_CLOSED":
								map.put("part_status",Const.fail);
								p2p_activityMapper.updateActiveB2cTransAid(map);
								warehouse = tenderRepository.selectBytransFlowNo(part_transFlowNo);
								if(warehouse!=null){//更新红包表
									map.put("state", "1");
									map.put("puw_whNo", warehouse.getPuwWhno());
									tenderRepository.updateByPuw_whNo(map);
								}else{
									P2p_users_redenvelope usersredenve = tenderRepository.selectBytransFlowNoAction(part_transFlowNo);
									if(usersredenve!=null){
										map.put("pur_status", "1");
										map.put("pur_redenvelopeNo", usersredenve.getPurRedenvelopeno());
										tenderRepository.updateredenvelo(map);
									}
								}
								break;
						}
					}
				}
			}else{
				if(sinaRetMap!=null&&"ORDER_NOT_EXIST".equals(sinaRetMap.get("response_code"))){
					map.put("part_status",Const.fail);
					p2p_activityMapper.updateActiveB2cTransAid(map);
					P2p_user_warehouse  warehouse = tenderRepository.selectBytransFlowNo(part_transFlowNo);
					if(warehouse!=null){//更新红包表
						map.put("state", "1");
						map.put("puw_whNo", warehouse.getPuwWhno());
						tenderRepository.updateByPuw_whNo(map);
					}else{
						P2p_users_redenvelope usersredenve = tenderRepository.selectBytransFlowNoAction(part_transFlowNo);
						if(usersredenve!=null){
							map.put("pur_status", "1");
							map.put("pur_redenvelopeNo", usersredenve.getPurRedenvelopeno());
							tenderRepository.updateredenvelo(map);
						}
					}
				}
			}*/
    	}

	/*private Map<String, Object> queryHostingTrade( String part_transFlowNo )
	{
    	Map<String, String> params=new HashMap<String, String>();
    	try {
    		params.put("out_trade_no", part_transFlowNo);
        	Map<String, Object> retMap = payService.query_hosting_trade(params);
        	return retMap;
		} catch (Exception e) {
			logger.error("queryHostingTrade", e);
			return null;
		}
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
