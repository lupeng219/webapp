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
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;
import com.baibao.web.p2p.generator.dao.P2p_activityMapper;
import com.baibao.web.p2p.repository.ActiveRepository;
import com.baibao.web.p2p.repository.CustAccountRepository;
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
public class ActivebB2cTrans_Consumer implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(Account_Consumer.class);
	
	@Autowired
	private ActivebB2cTrans_Storage storage;
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
	@Autowired
	private CustAccountRepository custAccountRepository;
	@Autowired
	private ActiveRepository activeRepository;
	@Autowired
	private P2p_activityMapper p2p_activityMapper;
	
	public ActivebB2cTrans_Consumer(){}
	public ActivebB2cTrans_Consumer( ActivebB2cTrans_Storage storage ) {
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
    	String part_transFlowNo = (String) consumeMap.get( "part_transFlowNo" );//交易单号
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("part_transFlowNo",part_transFlowNo);
    	Map<String, Object> sinaRetMap = queryHostingTrade( part_transFlowNo);
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
							//成功，更新代付状态为成功
							map.put("part_status",Const.success);
							p2p_activityMapper.updateActiveB2cTrans(map);
							//更新账户余额
							// custAccountRepository.updateAccountBalance(result.get("prt_inAccountNo")+"",result.get("prt_inCustNo")+"");
							map.clear();
							P2p_user_warehouse warehouse = tenderRepository.selectBytransFlowNoPay(part_transFlowNo);
							if(warehouse!=null){
								map.put("state", "3");
								map.put("puw_whNo", warehouse.getPuwWhno());
								tenderRepository.updateByPuw_whNo(map);
								//更新仓库流水
								map.put("state", Const.success);
								map.put("time",new Date() );
								map.put("puwf_whNo",warehouse.getPuwWhno());
								tenderRepository.updateBywhNo(map);
							}else{
								P2p_users_redenvelope usersredenve = tenderRepository.queryBytransFlowNoPay(part_transFlowNo);
								if(usersredenve!=null){
									map.put("pur_status", "3");
									map.put("pur_redenvelopeNo", usersredenve.getPurRedenvelopeno());
									map.put("time", new Date());
									tenderRepository.updateredenvelo(map);
									//更新仓库流水
									map.put("state", Const.success);
									map.put("time",new Date() );
									map.put("puwf_whNo", usersredenve.getPurRedenvelopeno());
									tenderRepository.updateBywhNo(map);
								}
							}
							//更新订单表
							tenderRepository.updateByOrderFlowNo(part_transFlowNo, Const.success);
							break;
						case "WAIT_PAY":
							break;
						case "PAY_FINISHED":
							break;
						case "TRADE_FAILED":
							map.put("part_status",Const.fail);
							break;
						case "TRADE_CLOSED":
							map.put("part_status",Const.fail);
							break;
					}
				}
			}else{
				if(sinaRetMap!=null&&"ORDER_NOT_EXIST".equals(sinaRetMap.get("response_code"))){
					map.put("part_status",Const.fail);
					p2p_activityMapper.updateActiveB2cTrans(map);
				}
			}*/
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
