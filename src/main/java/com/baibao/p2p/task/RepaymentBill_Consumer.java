package com.baibao.p2p.task;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans;
import com.baibao.web.p2p.generator.dao.P2p_repayment_billMapper;
import com.baibao.web.p2p.repository.LoanProductAidRepository;
import com.baibao.web.p2p.repository.RepaymentBillRepository;
import com.baibao.web.p2p.repository.RepaymentBillTransDetailRepository;
import com.baibao.web.p2p.repository.RepaymentBillTransRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
/**
 * 还款账单状态
 * @Title: RepaymentBill_Consumer.java
 * @Package com.baibao.p2p.task
 * @author zhangx
 * @date 2016年1月26日
 */
//@Component
public class RepaymentBill_Consumer
	implements Runnable
{	
	private static final Logger logger =
		LoggerFactory.getLogger(RepaymentBill_Consumer.class);
	
	@Autowired
	private RepaymentBill_Storage storage;
	@Autowired
	private RepaymentBillRepository repaymentBillRepository;
	@Autowired
	private RepaymentBillTransRepository repaymentBillTransRepository;
	@Autowired
	private RepaymentBillTransDetailRepository repaymentBillTransDetailRepository;
	@Autowired
	private TendertProfitRepository tendertProfitRepository;
	@Autowired
	private LoanProductAidRepository loanProductAidRepository;
	@Autowired
	private P2p_repayment_billMapper p2p_repayment_billMapper;
	
	public RepaymentBill_Consumer()
	{ }

	public RepaymentBill_Consumer(RepaymentBill_Storage storage)
	{
        this.storage = storage;
    }

	public void run()
	{
        try
        {
            while(true)
            {
            	consumerHandler();
            }
        } catch (Exception ex)
        {
        	logger.error("Consumer Interrupted", ex);
        }
    }
	public void consumerHandler()
	{
		try
		{
		   	Map<String, Object> consumeMap = storage.consume();
	    	
		   	//账单编号
		   	String prb_repaybillNo =(String) consumeMap.get("prb_repaybillNo");
	    	
		   	//账单当前还款期数
		   	String repaymentSeq =
		   		consumeMap.get( "prb_repaymentSeq" ).toString();
		   	//账单产品编号
	    	String productNo =(String) consumeMap.get("prb_productNo");
	    	
	    	logger.info("还款账单状态跑批开始" + prb_repaybillNo);
	    	
	    	P2p_repayment_bill_trans billTrans =
	    		repaymentBillTransRepository.selectByRepaybillno(prb_repaybillNo);
	    	if (billTrans != null)
	    	{
	    		logger.info("还款账单状态跑批*待收成功*" + billTrans);
	    		int count =
	    			tendertProfitRepository.getNotprofitCount(productNo, repaymentSeq);
	    		if (count == 0)
	    		{
	    			logger.info("还款账单状态跑批*代付成功*" + count);
	    			repaymentBillRepository.updateRepaymentBillStatusAndDate(
	    				prb_repaybillNo,"1",new Date());
	    			logger.info("还款账单状态跑批*更新还款账单表*");
	    			
	    			//查询应还账单表总期数
	    			int repaymentBillCount =
	    				p2p_repayment_billMapper.quertRepaymentSeqCount(productNo);
	    			if (Integer.parseInt(repaymentSeq) == repaymentBillCount)
	    			{
	    				loanProductAidRepository.updateProductLoanStatus(productNo, Const.hasEnden);
	    				logger.info("还款账单状态跑批**最后一期更新还款标的状态");
	    			}
	    		}
	    	}
	    	logger.info("还款账单状态跑批结束**");
		} catch (Exception e) {
			
			logger.error("consumerHandler",e);
		}
 
    	
    }
	
}
