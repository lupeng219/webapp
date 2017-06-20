package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baibao.common.util.StringUtil;
import com.baibao.core.cache.SystemConfigCache;
import com.baibao.core.exception.BusinessException;
import com.baibao.pay.GetUniqueNoService;
import com.baibao.pay.PayService;
import com.baibao.pay.data.BalanceRequest;
import com.baibao.pay.data.BalanceResponse;
import com.baibao.pay.data.HostingCollectRequest;
import com.baibao.pay.data.HostingCollectResponse;
import com.baibao.pay.data.HostingPayRequest;
import com.baibao.pay.data.HostingPayResponse;
import com.baibao.pay.data.PayResponse;
import com.baibao.utils.MapBuilder;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DataDIC;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.comm.RepaymentBillTransStatus;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill_trans;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bill_planMapper;
import com.baibao.web.p2p.generator.dao.P2p_loan_productMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_billMapper;
import com.baibao.web.p2p.generator.dao.P2p_repayment_bill_transMapper;
import com.baibao.web.p2p.generator.dao.P2p_userMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_infoMapper;
import com.baibao.web.p2p.generator.dataDIC.BulkLoanStatus;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.repository.AccountRepository;
import com.baibao.web.p2p.repository.PublicOrderRepository;
import com.baibao.web.p2p.repository.RepaymentBillRepository;
import com.baibao.web.p2p.repository.RepaymentBillTransRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.utils.SMSUtil;
import com.esotericsoftware.minlog.Log;

@Service("repaymentBillService")
public class RepaymentBillServiceImpl
	implements RepaymentBillService
{	
	private static Logger logger =
		LoggerFactory.getLogger(RepaymentBillServiceImpl.class);
	
	@Autowired
	private RepaymentBillRepository repaymentBillRepository;
	
	@Autowired
	private RepaymentBillTransRepository repaymentBillTransRepository;
	
	@Autowired
	private PublicOrderRepository publicOrderRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private  RestTemplate restTemplate;

	@Autowired
	private PayService payService;
	
	@Autowired
	private P2p_repayment_billMapper p2p_repayment_billMapper;
	
	@Autowired
	private P2p_loan_productMapper p2p_loan_productMapper;

	@Autowired 
	private P2p_bill_planMapper p2p_bill_planMapper;

	@Autowired
	private GetUniqueNoService getUniqueNoService;

	@Autowired
	private P2p_repayment_bill_transMapper p2p_repayment_bill_transMapper;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TenderRepository tenderRepository;

	@Autowired
	private P2p_user_infoMapper p2p_user_infoMapper;
	
	@Autowired
	private P2p_userMapper p2p_userMapper;
	
	@Value("${service-tel}")
	private String serviceTel;

	@Override
	public List<P2p_repayment_bill> getByBulkLoanNumber(String productNo)
	{
		return repaymentBillRepository.getByBulkLoanNumber(productNo);
	}
	
	@Override
	public Map<String, BigDecimal> getCustLiabilitiesByCustNo(String custNo)
	{
		return repaymentBillRepository.getCustLiabilitiesByCustNo(custNo);
	}

	/**
	 * 还款详情
	 */
	@Override
	public Map<String, Object> getproductRepayment(Map<String, Object> map)
		throws BusinessException
	{
		//当前要还期数和之前已还或逾期的
		List<Map<String, Object>> productRepaymentListCurrent = 
				new ArrayList<Map<String, Object>>();
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Map<String, Object>> productRepaymentList =
			repaymentBillRepository.getproductRepayment(map);
		
		
		BigDecimal completeTotalPrice = BigDecimal.valueOf(0);//已还款金额
		BigDecimal waitTotalPrice = BigDecimal.valueOf(0);//待还总额
		BigDecimal repaymentTotal = BigDecimal.valueOf(0);//本次还款金额

		//剩余期数
		int surplusNum = 0;
		boolean b = true;
		for(int i = 0; i < productRepaymentList.size(); i++)
		{
			Map<String, Object> map2 = productRepaymentList.get(i);
			//当前要还期数和之前已还或逾期的 start
			if (b) {
				if (map2.containsKey("prb_repaymentTime"))
				{
					try {
						Date date = simpleDateFormat.parse(
								map2.get("prb_repaymentTime").toString());
						if (date.getTime() > System.currentTimeMillis())
						{
							productRepaymentListCurrent.add(map2);
							b = false;
						} else 
							productRepaymentListCurrent.add(map2);
					} catch (Exception e) {
						logger.error(e+"");
					}
				}
				//当前要还期数和之前已还或逾期的 end
				
				if (DataDIC.NOREPAYMENT.getDataCode().equals(
						map2.get("prb_repaymentStatus").toString()))
				{
					//未还款
					waitTotalPrice =
						waitTotalPrice.add(
							new BigDecimal(map2.get("prb_repaymentPrincipal")
								.toString()));
					try
					{
						int fatalism = DateUtils.getBetweenDay(
							simpleDateFormat.parse((String)map2.get("prb_repaymentTime")),
							simpleDateFormat.parse(simpleDateFormat.format(new Date())));
						
						if (fatalism >=0 && fatalism <= 15)
						{
							repaymentTotal =
								repaymentTotal.add(new BigDecimal(
									map2.get("prb_repaymentPrincipal").toString()));
							
							map2.put("currentRp", true);
						} else
						if (fatalism < 0)
						{
							map2.put("currentRp", true);
						} else
						{
							map2.put("currentRp", false);
						}
					} catch(ParseException e)
					{
						 logger.error("getproductRepayment",e);
					}
				} else 
				{
					if (DataDIC.NORMALREPAYMENT.getDataCode().equals(
							map2.get("prb_repaymentStatus").toString()))
						
					{
						//已还款
						completeTotalPrice = completeTotalPrice.add(
							new BigDecimal(map2.get("prb_infactRepaymentPricipal")
								.toString()));
		
						map2.put("currentRp", false);
					} else if (DataDIC.LATEREPAYMENT.getDataCode().equals(
							map2.get("prb_repaymentStatus").toString()))
					{
						//逾期还款
						waitTotalPrice = completeTotalPrice.add(
							new BigDecimal(map2.get("prb_infactRepaymentPricipal")
								.toString()));
					}
				}
			} else 
				surplusNum++;
		}
		
		//查询当前余额
		P2p_cust_account account =
			accountRepository.getCustAccountByIdOrCustNo(
				(String) map.get("custNo"));
		
		BigDecimal balance = account.getPcaAccountBalance();

		result.put("balance", balance);
		result.put("completeTotalPrice", completeTotalPrice);
		result.put("waitTotalPrice", waitTotalPrice);
		result.put("repaymentTotal", repaymentTotal);
		result.put("productRepaymentList", productRepaymentListCurrent);
		result.put("surplusNum", surplusNum);
		return result;
	}
	
	/**
	 * 还款代收操作
	 * @param outTradeNo  还款账单号作为交易流水号
	 * @param identity_id
	 * @param identity_type
	 * @param outTradeCode
	 * @param amount
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PayResponse repaymentCollecting(
		String outTradeNo, String identity_id, String identity_type,
		BigDecimal amount, String custNo)
	{
		/*Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String> params = new HashMap<String, String>();
		
    	params.put("service", "create_hosting_collect_trade");
    	params.put("out_trade_no", outTradeNo);
    	params.put("out_trade_code", "1002");
    	params.put("summary", "还款代收操作");
    	//设置未付款交易的超时时间，一旦超时，该笔交易就会自动被关闭。
    	params.put("trade_close_time", "1m");
    	//支付失败是否可以再次发起支付
    	params.put("can_repay_on_failed", "N");
    	params.put("payer_id", identity_id);
    	params.put("payer_identity_type", identity_type);
    	params.put("amount", amount);*/
    	
		HostingCollectRequest request = new HostingCollectRequest();
		
		request.setPayAccountId(identity_id);
		request.setAmount(amount.multiply(new BigDecimal(100)).longValue());
		request.setTradeNo(outTradeNo);
		request.setReason(HostingCollectRequest.Reason.repay);
		
    	/***存入订单表
    	P2p_public_order   publicOrder = new P2p_public_order();
		
    	publicOrder.setPpoOrderflowno(outTradeNo);
		publicOrder.setPpoCustno(custNo);
		publicOrder.setPpoBussType(Integer.valueOf(Const.repaymentrecharge));
		publicOrder.setPpoOrderTime(new Date());
		publicOrder.setPpoAccountchannel("SINA");
		publicOrder.setPpoStatus(Const.processing);//处理中
		publicOrder.setPpoParams(JsonHelper.formatJson(request));
		publicOrderRepository.insertPublicOrder(publicOrder);*/
    	
		HostingCollectResponse response = payService.hostingCollect(request);

		return response;

    	//result = (Map<String, Object>) createHostingCollectTradeHandler.handle(params, extendPara);
    	/*result = payService.create_hosting_collect_trade(params);

    	return result;*/
    }
	
	@Override
	public int collectingFailOperation(String tradeFlowNo,P2p_repayment_bill bill,
			BigDecimal repaymentAmount,Map<String, Object> map) {
		String response_time = (String) map.get("response_time");
		String out_trade_no = (String) map.get("out_trade_no");
		String response_code = (String) map.get("response_code");
		String response_message = (String) map.get("response_message");
		map.put("response_time", response_time);//响应时间
		map.put("out_trade_no", out_trade_no);//返回的交易流水号
		map.put("response_code", response_code);//返回码
		map.put("response_message", response_message);//返回信息
		map.put("prt_tradeFlowNo", tradeFlowNo);
		map.put("prt_repaybillNo", bill.getPrbRepaybillno());//还款账单编号(如果是批次,则是批次号)
		map.put("prt_productNo", bill.getPrbProductNo());//标的编号
		map.put("prt_repayStatus", RepaymentBillTransStatus.FAIL.getIndex());//还款状态 00 成功  01 失败   02 处理中
		int result = repaymentBillRepository.upadteRepaymentBillTrans(map);
		return result;
	};
	
	
	/**
	 * 计算罚息
	 * @param bill
	 * @return
	 */
	public BigDecimal getPunishedAmount(P2p_repayment_bill bill){
		BigDecimal punishedAmount = new BigDecimal(0);
		return punishedAmount;
	}
	
	/**
	 * 计算债权收益本息和
	 * @param bill
	 * @return
	 */
	private BigDecimal getCreditoAmount(P2p_repayment_bill bill) {
		BigDecimal creditoAmount = new BigDecimal(0);
		return creditoAmount;
	}
	
	/**
	 * 还款代付成功之后更新代付记录状态为成功
	 * @param bill
	 * @param prt_host_response_time
	 * @param prt_host_response_flowNum
	 * @param prt_host_return_code
	 * @param prt_host_return_message
	 * @return
	 */
	
	public int upadteRepaymentBillTrans(String tradeFlowNo,P2p_repayment_bill bill,Map<String, Object> map){
		String response_time = (String) map.get("response_time");
		String out_trade_no = (String) map.get("out_trade_no");
		String response_code = (String) map.get("response_code");
		String response_message = (String) map.get("response_message");
		map.clear();
		map.put("response_time", response_time);//响应时间
		map.put("out_trade_no", out_trade_no);//返回的交易流水号
		map.put("response_code", response_code);//返回码
		map.put("response_message", response_message);//返回信息
		
		map.put("prt_repaybillNo", bill.getPrbRepaybillno());//还款账单编号(如果是批次,则是批次号)
		map.put("prt_productNo", bill.getPrbProductNo());//标的编号
		map.put("prt_repayStatus", RepaymentBillTransStatus.TRANSING.getIndex());//还款状态 00 成功  01 失败   02 处理中
		map.put("prt_tradeFlowNo", tradeFlowNo);
		int result = repaymentBillRepository.upadteRepaymentBillTrans(map);
		return result;
	};
	
	
	/**
	 * 更新还款账单记录状态
	 * @param bill
	 * @param repaymentAmount
	 * @return
	 */
	/*public int upadteRepaymentBillStatus(P2p_repayment_bill bill,BigDecimal repaymentAmount){
		Map<String, Object> map = new HashMap<String, Object>();
		int overDueDays = 0;//逾期天数
		BigDecimal overDueAmount = new BigDecimal(0);//逾期金额
		map.put("prb_repaybillNo", bill.getPrbRepaybillno());//还款账单编号(如果是批次,则是批次号)
		map.put("prb_productNo", bill.getPrbProductNo());//标的编号
		
		//===================
		overDueDays = getOverdueDay(bill.getPrbRepaymenttime(),new Date());
		//设置状态成还款处理中的
		if(overDueDays>0){
			//2逾期还款
			map.put("prb_repaymentStatus", RepaymentBillStatus.INHANDREAPYMENT.getIndex());
		}else{
			//1正常还款
			map.put("prb_repaymentStatus", RepaymentBillStatus.INHANDREAPYMENT.getIndex());
		}
		map.put("prb_infactRepaymentPricipal", repaymentAmount);//实际还款本息
		map.put("prb_infactRepaymentTime", new Date());//实际还款日期
		map.put("prb_overDueDays",overDueDays);//逾期天数
		map.put("prb_overDueAmount", overDueAmount);//逾期金额
		map.put("prb_overDuePunishScore", 0);//逾期催收费用
		//===================
		int result = repaymentBillRepository.upadteRepaymentBillStatus(map);
		return result;
	}*/
	
	/**
	 * 更新账户余额
	 * @param pca_accountNo 第三方那个支付账号
	 * @return
	 */
	private int updateAccountBalance(String pca_accountNo)
	{
		int result = 0;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//查询新浪的余额进行更细
		BigDecimal balanceAmount = new BigDecimal(0);

		BalanceRequest request = new BalanceRequest();

		request.setAccountId(pca_accountNo);

		BalanceResponse response = payService.queryBalance(request);
		if (response.isOk())
		{
			balanceAmount =
				new BigDecimal(response.getAvalidated())
					.divide(new BigDecimal(100));
		}

		/*Map<String, String> queryBalanceParam = new HashMap<String, String>();
		queryBalanceParam.put("identity_id", pca_accountNo);
		queryBalanceParam.put("identity_type", "UID");
		queryBalanceParam.put("account_type", "SAVING_POT");
		queryBalanceParam.put("extend_param", "");
		
		Map<String, Object> retMap = payService.query_balance(queryBalanceParam);
		
		if( null != retMap )
		{	//用户可用余额
			String tempBig = (String) retMap.get("available_balance");
			if(StringUtil.isEmpty(tempBig)){
				balanceAmount =  new BigDecimal(0);
			}else{
				balanceAmount =  new BigDecimal(retMap.get("available_balance").toString());
			}
		}*/

		////////////////////////////查询余额end///////////////////////////////////////////
		map.put("pca_accountNo", pca_accountNo);
		map.put("pca_account_balance", balanceAmount);
		result = repaymentBillRepository.updateAccountBalance(map);
		return result;
	}
	
	/**
	 * 判断是否是最后一期
	 * @param bill
	 * @return
	 */
	private void isLastRepayment(P2p_repayment_bill bill) {
		Integer currentSeq = bill.getPrbRepaymentseq();
		Integer loanTerm = bill.getPpLoanterm();
		if(currentSeq.equals(loanTerm)){
			//是最后一期,更新标的状态为已完成
			int flag = updateLoanProductStatus(bill.getPrbCustno());
		}
	}

	/**
	 * 操作收益人
	 * @param bill
	 * @param repaymentAmount
	 * @return
	 */
	private Map<String, Object>
		profitOperation(P2p_repayment_bill bill, BigDecimal repaymentAmount)
			throws RuntimeException
	{
		//1.查询更具产品编号和当前期数查找所有的收益记录
		List<P2p_tender_profit> allProfit = null;
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("ptp_productNo", bill.getPrbProductNo());//产品编号
		map.put("ptp_loanSeq", bill.getPrbRepaymentseq());//还款期数

		Boolean flag = false;

		BigDecimal profitBig = new BigDecimal(0);
		String tradeFlowNo = null;//核心交易返回流水号

		try
		{
			allProfit = repaymentBillRepository.getAllProfit(map);
			for(P2p_tender_profit profit: allProfit)
			{
				//1.处理中的代付记录
				map.clear();
				map = saveRepaymentBillTransDetails(profit,bill);

				//保存 出错
				if (!(Boolean) map.get(Const.retCode))
				{
					return map;
				}
				
				tradeFlowNo = null;
				tradeFlowNo = (String) map.get("tradeFlowNo");
				
				//2.向收益人进行打钱操作
				profitBig = profit.getPtpProfit();
				map.clear();
				
				PayResponse response = singlePayHostingTrade(
					profit.getPcaAccountNo(), tradeFlowNo,
					profitBig, bill.getPrbCustno());
				
				//判断新浪的状态
				if (response.isOk())
				{
					map.put(Const.retCode, true);
					map.put(Const.retMsg, "操作收益人成功");
				} else
				{
					map.put(Const.retCode, false);
					map.put(Const.retMsg,//还款给收益人失败
						"\u8fd8\u6b3e\u7ed9\u6536\u76ca\u4eba\u5931\u8d25");
					return map;
				}
				
				accountService.getCustAccountByCustNo(profit.getPtpCustno(), true);
			}
		} catch(RuntimeException e)
		{
			e.printStackTrace();
			logger.error("查询收益人失败!",e);

			map.put(Const.retCode, false);
			map.put(Const.retMsg, "操作收益人失败!");
			throw e;
		}

		map.put(Const.retCode, true);
		map.put(Const.retMsg, "操作收益人成功");
		return map;
	}
	
	/**
	 * 计算逾期天数
	 * @param repaymentDate  还款时间
	 * @param currentTime 当前时间
	 * @return
	 */
	/*private int getOverdueDay(Date repaymentDate,Date currentTime){    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
        long between_days = 0l;
        long time1 = 0l;//还款时间long
        long time2 = 0l;//当前时间long
        try {
			repaymentDate=sdf.parse(sdf.format(repaymentDate));
			currentTime=sdf.parse(sdf.format(currentTime));  
			Calendar cal = Calendar.getInstance();    
	        cal.setTime(repaymentDate);    
	        time1 = cal.getTimeInMillis();                 
	        cal.setTime(currentTime);    
	        time2 = cal.getTimeInMillis();         
	        between_days=(time2-time1)/(1000*3600*24);  
		} catch (ParseException e) {
			e.printStackTrace();
		}  
        return Integer.parseInt(String.valueOf(between_days));           
    }*/

	/**
	 * 更新产品的状态为已完成
	 * @param productNo
	 * @return
	 */
	private int updateLoanProductStatus(String productNo)
	{
		int result = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pp_bulkLoanStatus", BulkLoanStatus.completeproduct.getIndex());
		map.put("pp_productNo", productNo);
		
		result = repaymentBillRepository.updateLoanProductStatus(map);
		return result;
	}

	/**
	 * 插入处理中的代付交易记录
	 * @param profit
	 * @return
	 */
	public Map<String, Object> saveRepaymentBillTransDetails(
		P2p_tender_profit profit, P2p_repayment_bill bill)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		MultiValueMap<String, String> postCoreTrans =
			new LinkedMultiValueMap<String, String>();
		
		postCoreTrans.add("transFlag","F");
		postCoreTrans.add("tranCode", "1003");
		postCoreTrans.add("productNo", profit.getPtpProductNo());
		postCoreTrans.add("incomebillNo", profit.getPtpIncomebillNo());
		postCoreTrans.add("tenderTransFlowNo", profit.getPtpTenderFlowNo());
		postCoreTrans.add("repaybillNo", bill.getPrbRepaybillno());
		postCoreTrans.add("custNo", profit.getPtpCustno());
		postCoreTrans.add("accountNo", profit.getPcaAccountNo());
		postCoreTrans.add("repaymentSeq", profit.getPtpLoanseq()+"");
		postCoreTrans.add("repaymentMoney",
			profit.getPtpCapital().add(profit.getPtpInterest())+"");
		
		String returnJSON = "";

		try
		{
			String coreTrans =
				(String) SystemConfigCache.getValue("common", "coreTransUrl");
			returnJSON =
				restTemplate.postForObject(
					coreTrans, postCoreTrans, String.class);
		} catch(Exception e)
		{
			logger.error("-0000", "invoke coreTrans exception ", e);
		}
		
		JSONObject json = null;
		json =(JSONObject) JSON.parse( returnJSON );
		
		if (null != json && "" != json.get(Const.retCode) &&
			json.get(Const.retCode) != null &&
			json.get(Const.retCode).equals("0000"))
		{
			result.put(Const.retCode, true);
			result.put(Const.retMsg, json.get(Const.retMsg));
			result.put("tradeFlowNo", json.get("tradeFlowNo"));
		} else
		{
			if (null != json)
			{
				result.put(Const.retCode, false);
				result.put(Const.retMsg, json.get(Const.retMsg));
			} else
			{
				result.put(Const.retCode, false);
				result.put(Const.retMsg,//核心交易连接失败
					"\u6838\u5fc3\u4ea4\u6613\u8fde\u63a5\u5931\u8d25");
			}
		}

		return result;
	}
	
	 /**
	  * 更新代付记录
	  * @param repayTransFlowNo 收益记录流水号
	  * @param repaybillNo
	  * @param tradeStatus
	  * @param responseTime
	  * @param responseFlowNum
	  * @param prd_host_return_code
	  * @param prd_host_return_message
	  * @return
	  */
	 public int upadteRepaymentBillTransDetails(String repayTransFlowNo,String incomebillNo,
			 String repaybillNo,Map<String, Object> map,Boolean flag) throws RuntimeException{
		String response_time = (String) map.get("response_time");
		String out_trade_no = (String) map.get("out_trade_no");
		String response_code = (String) map.get("response_code");
		String response_message = (String) map.get("response_message");
		String trade_status = (String) map.get("trade_status");
		
		map.clear();
		map.put("response_time", response_time);//响应时间
		map.put("out_trade_no", out_trade_no);//返回的交易流水号
		map.put("response_code", trade_status);//返回码
		map.put("response_message", response_message);//返回信息
		
		map.put("prd_tradeFlowNo", repayTransFlowNo);//交易流水号
		map.put("prd_repaybillNo", repaybillNo);//投资收益编号
		map.put("prd_incomebillNo", incomebillNo);//收益流水号
		
		if(flag){
			map.put("prd_status", RepaymentBillTransStatus.TRANSING.getIndex());//收益状态 00 成功  01 失败   02 处理中
		}else{
			map.put("prd_status", RepaymentBillTransStatus.FAIL.getIndex());//收益状态 00 成功  01 失败   02 处理中
		}
		int result = 0;
		try {
			result = repaymentBillRepository.upadteRepaymentBillTransDetails(map);
		} catch (RuntimeException e) {
			
			logger.error("更新代付记录失败!",e);
			throw e;
		}
		return result;
	 };
	 
	/**
	 * 新浪代付操作
	 * @param accountNo
	 * @param outTradeNo  收益记录流水号
	 * @param amount
	 * @return
	 */
	private PayResponse singlePayHostingTrade(
		String accountNo, String outTradeNo, BigDecimal amount, String custNo)
	{
		/*Map<String, String> params = new HashMap<String, String>();
    	params.put("out_trade_no", outTradeNo);
    	params.put("out_trade_code", "2002");
    	params.put("payee_identity_id", accountNo);
    	params.put("payee_identity_type", "UID");
    	params.put("account_type", "SAVING_POT");
    	params.put("summary", "还款代付操作");
    	params.put("amount", amount);*/
		
		HostingPayRequest request = new HostingPayRequest();
		
		request.setPayeeAccountId(accountNo);
		request.setAmount(amount.multiply(new BigDecimal(100)).longValue());
		request.setTradeNo(outTradeNo);
		request.setReason(HostingPayRequest.Reason.income);

    	/***存入订单表
		P2p_public_order   publicOrder = new P2p_public_order();
		publicOrder.setPpoOrderflowno(outTradeNo);
		publicOrder.setPpoCustno(custNo);
		publicOrder.setPpoBussType(Integer.valueOf(Const.repaymentpay));
		publicOrder.setPpoOrderTime(new Date());
		publicOrder.setPpoAccountchannel("SINA");
		publicOrder.setPpoStatus(Const.processing);//处理中
		publicOrder.setPpoParams(JsonHelper.formatJson(request));
		publicOrderRepository.insertPublicOrder(publicOrder);*/

		HostingPayResponse response = payService.hostingPay(request);
		
		return response;

		//Map<String, Object> result = createSingleHostingPayTradeHandler.handle(params,null);
		/*Map<String, Object> result =
			payService.create_single_hosting_pay_trade(params);
    	
		return result;*/
	}
	 
	 /**
	 * 更新收益记录状态
	 * @param profit
	 * @return
	 */
	public int updateProfitRecord(
		P2p_tender_profit profit, String profitType, String profitstatus)
			throws RuntimeException
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("ptp_incomebillNo", profit.getPtpIncomebillNo());
		map.put("ptp_factCapital", profit.getPtpFactcapital());
		map.put("ptp_factInterest", profit.getPtpFactinterest());
		map.put("ptp_factProfit",
			profit.getPtpFactcapital().add(profit.getPtpFactinterest()));
		map.put("ptp_factProfitTime", new Date());
		map.put("ptp_profitType", profitType);//收益类型  40 本金  41 利息 42 本息和  43 佣金
		map.put("ptp_remark","投资收益" );
		map.put("ptp_profitstatus", profitstatus);//投资收益状态：10未收益  11已收益 12还款中

		int flag = repaymentBillRepository.updateProfitRecord(map);
		return flag;
	}

	@Override
	public List<P2p_repayment_bill> getOldByBulkLoanNumber(String productNo)
	{
		return repaymentBillRepository.getOldByBulkLoanNumber(productNo);
	}

	private BigDecimal queryAvalidatedBalance(
		BalanceRequest.Reason reason, String accountId)
	{
		BalanceRequest balanceRequest = new BalanceRequest();
		
		balanceRequest.setReason(reason);
		balanceRequest.setAccountId(accountId);
		
		BalanceResponse balanceResponse =
			payService.queryBalance(balanceRequest);
		
		return new BigDecimal(balanceResponse.getAvalidated())
			.divide(new BigDecimal(100));
	}
	
	@Override
	@Transactional
	public int repay(
		String custNo, String transPassword, String[] repaybillNos)
	{
		//检查交易密码是否正确
		P2p_cust_account account =
			accountRepository.getCustAccountByIdOrCustNo(custNo);
		if (account != null &&
			!account.getPcaPayPassword().equals(transPassword))
		{
			throw new BusinessException("交易密码错误");
		}
		
		BigDecimal repaymentAmount = new BigDecimal(0);

		String productNo = null;
		
		for(String repaybillNo: repaybillNos)
		{
			P2p_repayment_bill bill =
				repaymentBillRepository.getRepaymentDetails(repaybillNo);
			
			repaymentAmount =
				repaymentAmount.add(bill.getPrbRepaymentprincipal());
			
			productNo = bill.getPrbProductNo();
		}

		BigDecimal balance =
			queryAvalidatedBalance(
				BalanceRequest.Reason.common, account.getPcaAccountno());

		if (balance.compareTo(repaymentAmount) < 0)
		{
			throw new BusinessException("您的余额不足，请充值");
		}

		for(String repaybillNo: repaybillNos)
		{
			operationRepayment(repaybillNo);
			
			P2p_repayment_bill bill =
				repaymentBillRepository.getRepaymentDetails(repaybillNo);			
			
			{
				int allCount = this.p2p_repayment_billMapper.countRepaymentBill(
					new MapBuilder<String, Object>()
						.append("productNo", bill.getPrbProductNo())
						.append("seq", bill.getPrbRepaymentseq())
						.toMap());
				int count = this.p2p_repayment_billMapper.countRepaymentBill(
					new MapBuilder<String, Object>()
						.append("productNo", bill.getPrbProductNo())
						.append("seq", bill.getPrbRepaymentseq())
						.append("status", RepaymentBillStatus.NORMALREPAYMENT.getIndex())
						.toMap());

				if (allCount == count)
				{
					Timestamp now = Utils.now();
					
					p2p_bill_planMapper.updateRepaymentStatus(
						bill.getPrbProductNo(), bill.getPrbRepaymentseq(),
						Integer.parseInt(RepaymentBillStatus.NORMALREPAYMENT.getIndex()),
						now,
						bill.getPrbRepaymenttime().getTime() < now.getTime()?
							Utils.betweenDays(bill.getPrbRepaymenttime(), Utils.now()): 0);
				}
			}
		}

		if (productNo != null)
		{
			int allCount = this.p2p_bill_planMapper.countBillPlan(
				new MapBuilder<String, Object>()
					.append("productNo", productNo)
					.toMap());
			int count = this.p2p_bill_planMapper.countBillPlan(
				new MapBuilder<String, Object>()
					.append("productNo", productNo)
					.append("repaymentStatus",
						RepaymentBillStatus.NORMALREPAYMENT.getIndex())
					.toMap());

			if (allCount == count)
			{
				this.p2p_loan_productMapper.updateProductState(
					new MapBuilder<String, Object>()
					.append("pp_productNo", productNo)
					.append("pp_bulkLoanStatus", Const.hasEnden)
					.toMap());
			}
		}
		accountService.syncFreezedAmont(account.getPcaAccountno(), account.getPcaCustNo());
		return 200;
	}

	/**
	 * 确定还款操作
	 */
	private boolean operationRepayment(String prbRepaybillno)
	{		
		P2p_repayment_bill bill =
			repaymentBillRepository.getRepaymentDetails(prbRepaybillno);

		P2p_user user = p2p_userMapper.findUserByCustNo(bill.getPrbCustno());
		P2p_user_info userInfo =
			p2p_user_infoMapper.getUserInfo(bill.getPrbCustno());

		//查询标的
		P2p_loan_product_aid loanProduct =
			tenderRepository.selectByProductNo(bill.getPrbProductNo());	

		if (bill.getPrbRepaymentstatus() !=
				Integer.parseInt(RepaymentBillStatus.NOREPAYMETN.getIndex()) &&
			bill.getPrbRepaymentstatus() !=
				Integer.parseInt(RepaymentBillStatus.OVERDUEREPAYENT.getIndex()))
		{
			throw new BusinessException(
				String.format("不能还款，该条还款状态为%d",
					bill.getPrbRepaymentstatus()));
		}

		String tradeNo = getUniqueNoService.getRepaymentTransFlow();
		
		{//生成代付记录
			P2p_repayment_bill_trans record = new P2p_repayment_bill_trans();

			record.setPrtTradeflowno(tradeNo);
			record.setPrtRepaybillno(prbRepaybillno);
			record.setPrtProductno(bill.getPrbProductNo());
			record.setPrtRepaymentseq(
				String.valueOf(bill.getPrbRepaymentseq()));
			record.setPrtOutaccountno(bill.getAccountNo());
			record.setPrtOutcustno(bill.getPrbCustno());
			record.setPrtTransamount(
				String.valueOf(bill.getPrbRepaymentprincipal()));
			record.setPrtRepaycategory("0");
			record.setPrtRepaystatus(Const.processing);
			record.setPrtRepaytime(Utils.now());

			p2p_repayment_bill_transMapper.insertSelective(record);
		}

		{//划钱
			PayResponse response = this.repaymentCollecting(
				tradeNo, bill.getAccountNo(), null,
				bill.getPrbRepaymentprincipal(), bill.getPrbCustno());
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			//判断交易状态状态
			if (response.isOk())
			{
				p2p_repayment_bill_transMapper.upadteRepaymentBillTrans(
					new MapBuilder<String, Object>()
						.append("prt_repaybillNo", bill.getPrbRepaybillno())
						.append("prt_productNo", bill.getPrbProductNo())
						.append("prt_tradeFlowNo", tradeNo)
						.append("prt_repayStatus", Const.success)
						.toMap());

				bill.setPrbInfactrepaymenttime(Utils.now());
				bill.setPrbRepaymentstatus(
					Integer.parseInt(
						RepaymentBillStatus.NORMALREPAYMENT.getIndex()));
				
				p2p_repayment_billMapper.updateByPrimaryKeySelective(bill);

				map.put(Const.retCode, true);
				map.put(Const.retMsg, "代收申请成功!");
				map.put("out_trade_no", tradeNo);
				
				{//记录流水
					accountService.saveAccountFlow(
						tradeNo, bill.getPrbCustno(), bill.getAccountNo(),
						String.valueOf(
							bill.getPrbRepaymentprincipal()
								.multiply(new BigDecimal(-1))),
						null, Const.repayment, null, Const.success,
						String.format("还款-%s-第%d期",
							loanProduct.getPpLoantitle(),
							bill.getPrbRepaymentseq()));
				}
				
				try
				{
					SMSUtil.sendMessage(MessageType.REPAYMENT,
						user.getPuMobile(),
						new MapBuilder<String, Object>()
							.append("#name#", userInfo.getPuiRealName())
							/*.append("#loanAmount#",
								String.format("%.2f", loanProduct.getPpLoanamount().doubleValue()))*/
							.append("#repaymentAmount#",
								String.format("%.2f", bill.getPrbRepaymentprincipal().doubleValue()))
							.append("#actualRepaymentAmount#",
								String.format("%.2f", bill.getPrbRepaymentprincipal().doubleValue()))
							.append("#telephone#", serviceTel)
							.toMap());
					
					//【佰宝金服】亲爱的用户#name#，您在佰宝金服借款#loanAmount#元，
					//本期应还款#repaymentAmount#元，收到还款#actualRepaymentAmount#元，
					//本期还款完成，请保持良好的还款记录。如有疑问请你致电#telephone#
				} catch(Exception e)
				{
					Log.error("", e);
				}
			} else
			{//代收申请失败
				if (response.getStatus().intValue() == -500)
				{
					bill.setPrbInfactrepaymenttime(Utils.now());
					bill.setPrbRepaymentstatus(
						Integer.parseInt(
							RepaymentBillStatus.INHANDREAPYMENT.getIndex()));
					
					p2p_repayment_billMapper.updateByPrimaryKeySelective(bill);
				}
				
				collectingFailOperation(
					tradeNo, bill, bill.getPrbRepaymentprincipal(), map);

				map.put(Const.retCode, false);
				map.put(Const.retMsg, map.get("response_message"));

				return false;
			}
		}

		{
			int allCount = this.p2p_repayment_billMapper.countRepaymentBill(
				new MapBuilder<String, Object>()
					.append("productNo", bill.getPrbProductNo())
					.append("seq", bill.getPrbRepaymentseq())
					.toMap());
			int count = this.p2p_repayment_billMapper.countRepaymentBill(
				new MapBuilder<String, Object>()
					.append("productNo", bill.getPrbProductNo())
					.append("seq", bill.getPrbRepaymentseq())
					.append("status", RepaymentBillStatus.NORMALREPAYMENT.getIndex())
					.toMap());

			if (allCount == count)
			{
				p2p_bill_planMapper.updateRepaymentStatus(
					bill.getPrbProductNo(), bill.getPrbRepaymentseq(),
					Integer.parseInt(RepaymentBillStatus.NORMALREPAYMENT.getIndex()),
					Utils.now(),
					Utils.betweenDays(bill.getPrbRepaymenttime(), Utils.now()));
			}
		}

		{
			int allCount = this.p2p_bill_planMapper.countBillPlan(
				new MapBuilder<String, Object>()
					.append("productNo", bill.getPrbProductNo())
					.toMap());
			int count = this.p2p_bill_planMapper.countBillPlan(
				new MapBuilder<String, Object>()
					.append("productNo", bill.getPrbProductNo())
					.append("repaymentStatus",
						RepaymentBillStatus.NORMALREPAYMENT.getIndex())
					.toMap());

			if (allCount == count)
			{
				this.p2p_loan_productMapper.updateProductState(
					new MapBuilder<String, Object>()
					.append("pp_productNo", bill.getPrbProductNo())
					.append("pp_bulkLoanStatus", Const.hasEnden)
					.toMap());
			}
		}

		return true;
	}

	@Override
	public boolean getRepaymentBillByProduct(
		Map<String, Object> map, String[] repaybillNos)
	{	
		Map<String, Object> result = new HashMap<String, Object>();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Map<String, Object>> productRepaymentList =
			repaymentBillRepository.getproductRepayment(map);
		
		for(Map<String, Object> repayment: productRepaymentList)
		{
			Object repaymentTime = repayment.get("prb_repaymentTime");
			if (repaymentTime == null)
				continue;

			result.put(String.valueOf(
				repayment.get("prb_repaybillNo")), repayment);

			try
			{
				long date =
					formater.parse(String.valueOf(repaymentTime)).getTime();
				
				if (date > System.currentTimeMillis())
					break;
			} catch(Exception e)
			{
				logger.error("", e);
			}
		}

		for (String repaybillNo : repaybillNos)
		{
			if (!result.containsKey(repaybillNo))
			{
				return false;
			}
		}
		return true;
	}
}
