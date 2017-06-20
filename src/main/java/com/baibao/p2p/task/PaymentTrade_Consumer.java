package com.baibao.p2p.task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.pay.PayService;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.controller.eventBus.events.InnerSiteMsgEvent;
import com.baibao.web.p2p.generator.bean.P2p_loan_record;
import com.baibao.web.p2p.generator.dataDIC.BulkLoanStatus;
import com.baibao.web.p2p.repository.LoanProductRepository;
import com.baibao.web.p2p.repository.RepaymentBillRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.RestTemplateService;
/**
 * 结标跑批(投标代付)
 * @Title: PaymentTrade_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月26日
 */
//@Component
public class PaymentTrade_Consumer implements Runnable{
	
	private static final Logger logger = LoggerFactory.getLogger(PaymentTrade_Consumer.class);
	
	@Autowired
	private PaymentTrade_Storage storage;
	@Autowired
	private RestTemplateService restTemplateService;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private PayService payService;
	@Autowired
	private LoanProductRepository loanProductRepository;
	@Autowired
	private TendertProfitRepository tendertProfitRepository;
	@Autowired
	private RepaymentBillRepository repaymentBillRepository;
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private InnerSiteMsgEvent innerSiteMsgEvent;
	
	public PaymentTrade_Consumer(){}
	public PaymentTrade_Consumer( PaymentTrade_Storage storage ) {
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
    	String ptf_transFlowNo = (String) consumeMap.get( "ptf_transFlowNo" );
    	
    	Map<String, Object> sinaRetMap = queryHostingTrade( ptf_transFlowNo );
    	String retCode = (String) sinaRetMap.get( "retCode" );
    	if( null != retCode && ControllerRetType.OPT_SUCC.getTransCode().equalsIgnoreCase( retCode.trim() ))
    	{
    		if ( sinaRetMap != null && sinaRetMap.get("response_code").equals( "APPLY_SUCCESS") ) 
			{
    			String trade_list   = (String) sinaRetMap.get( "trade_list" );
				String trade_status = "";
				String[] trade_array = trade_list.split( "\\^" );
				trade_status = trade_array[ 3 ];
				switch( trade_status )
				{
					case "TRADE_FINISHED"://交易完成，意味着成功。
						updateTradeFlow( ptf_transFlowNo , Const.success );
						break;
					case "WAIT_PAY":
						break;
					case "PAY_FINISHED"://已经付款
						break;
					case "TRADE_FAILED"://交易失败
						updateTradeFlow( ptf_transFlowNo , Const.fail  );
						break;
					case "TRADE_CLOSED":
						updateTradeFlow( ptf_transFlowNo , Const.fail);
						break;
				}
			}
		}*/
	}
	
	@Transactional(rollbackFor=Exception.class)
	private void updateTradeFlow( String paf_transFlowNo,String status )
	{
		try{
			//获得放款记录
			P2p_loan_record loanRecord = tenderRepository.getLoanRecordByFlowNo(paf_transFlowNo);
			//更新结标放款(代付)记录
			tenderRepository.updateSuspiciousPaymentFlow(paf_transFlowNo, status);
			//更新订单状态
			tenderRepository.updateByOrderFlowNo(paf_transFlowNo, status);
			//成功
			if(Const.success.equals(status)){
				//更改产品状态为还款中
				Map<String, Object> param = new HashMap<String, Object>();
				Date date = new Date();
				param.put("pp_productNo", loanRecord.getPtfProductNo());//借款编号
				param.put("bulkLoanEffectTime",date );
				param.put("pp_bulkLoanStatus", BulkLoanStatus.repaymenting.getIndex());//融资状态 0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
				loanProductRepository.updateLoanProductStatus(param);
				loanProductRepository.updateLoanProduct_aidStatus(param);
				tenderRepository.updateByOrderFlowNo(paf_transFlowNo, Const.success);
				//更新收益表状态为未收益
				param.clear();
				param.put("ptp_profitstatus",RepaymentBillStatus.NOREPAYMETN.getIndex());//未收益状态
				param.put("ptp_productNo", loanRecord.getPtfProductNo());
				tendertProfitRepository.updateStatusByProductNo(param);
				//更新还款计划表状态为未还款状态
				param.clear();
				param.put("prb_repaymentStatus","0" );
				param.put("prb_productNo", loanRecord.getPtfProductNo());
				repaymentBillRepository.upadteRepaymentBillStatusByProductNo(param);
				
				//给贷款人发站内信
				//this.PublishInnerSiteMsg(loanRecord.getPtfInCustno(), MsgType.investment_msg.getIndex(), "贷款", DateUtils.getDateToString(loanRecord.getPtfHostResponseTime()), loanRecord.getPtfRepaymentAmount().toString());
			}
		}catch( Exception e  )
		{
			logger.error("updateTradeFlow", e);
		}
		
	}
	/*private Map<String, Object> queryHostingTrade( String ptf_transFlowNo )
	{
    	Map<String, String> params=new HashMap<String, String>();
    	params.put("out_trade_no", ptf_transFlowNo);
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
