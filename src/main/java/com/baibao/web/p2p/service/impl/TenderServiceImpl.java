package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baibao.core.cache.SystemConfigCache;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.CalenderUtil;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.ActiveId;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.UtilTools;
import com.baibao.web.p2p.controller.eventBus.events.InvestmentActivationEvent;
import com.baibao.web.p2p.controller.eventBus.events.LotteryDrawEvent;
import com.baibao.web.p2p.controller.eventBus.events.SendRedEnvelopeEvent;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dao.P2p_userMapper;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.repository.CustAccountRepository;
import com.baibao.web.p2p.repository.PublicOrderRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.TenderService;
import com.baibao.web.p2p.utils.SMSUtil;
import com.baibao.pay.PayService;
import com.baibao.pay.data.BalanceRequest;
import com.baibao.pay.data.BalanceResponse;
import com.baibao.pay.data.HostingCollectRequest;
import com.baibao.pay.data.PayResponse;
import com.baibao.utils.JsonHelper;
import com.baibao.utils.MapBuilder;
import com.baibao.loan.model.LoanProductAid;
import com.baibao.loan.service.TenderRecordManager;

/**
 * <p>版权所有：(C)2013-2018 中融佰诚</p>
 * @时间：2015-12-01
 * @描述：投标记录业务层接口
 */
@Service("tenderService")
public class TenderServiceImpl
	implements TenderService
{
	private static Logger log =
		LoggerFactory.getLogger(TenderServiceImpl.class);

	@Autowired
	private PayService payService;

	@Autowired
	private  RestTemplate restTemplate;
	
	@Autowired
	private TenderRepository tenderRepository;
	
	@Autowired
	private CustAccountRepository custAccountRepository;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private P2p_userMapper p2p_userMapper;

	@Autowired
	private TenderRecordManager tenderRecordManager;
	
	@Value("${service-tel}")
	private String serviceTel;

	private static final String[] _sina_pay_status = {Const.retCode,"PROCESSING"};
	private static final String[] _sina_trade_status = {"WAIT_PAY","PAY_FINISHED","TRADE_FINISHED"};
	private static final String[] _sina_pay_fail_status = {"FAILED"};
	private static final String[] _sina_trade_fail_status = {"TRADE_FAILED","TRADE_CLOSED"};
	
	private static final List<String> _sina_pay_fail_status_list = Arrays.asList( _sina_pay_fail_status );
	private static final List<String> _sina_trade_fail_status_list = Arrays.asList( _sina_trade_fail_status );
	
	private static final List<String> _sina_pay_status_list = Arrays.asList( _sina_pay_status );
	private static final List<String> _sina_trade_status_list = Arrays.asList( _sina_trade_status );

	@Override
	@Transactional
	public Map<String, Object> tender(
		String custNo, String productNo,
		BigDecimal loanAmount, String _TOKEN_SESSION,
		String channel, String password,String inviteCode)
	{
		Map<String, Object> retMap = null;

		try
		{
			retMap = tenderHandler(
				custNo, productNo, loanAmount, channel, password ,inviteCode);
		} catch(Exception e)
		{
			retMap = new HashMap<String, Object>();
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "投资失败");
			log.error("tender",e);
		}
		return retMap;
	}

	@Transactional
	public  Map<String, Object> tenderHandler(
		String custNo, String productNo, BigDecimal loanAmount,
		String channel,String password,String inviteCode)
			throws BusinessException
	{
		loanAmount =
			loanAmount.setScale(2, RoundingMode.HALF_UP);

		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put(Const.retCode, true);
		
		P2p_cust_account account = custAccountRepository.queryIdentityId(custNo);
		if (StringUtils.isBlank(account.getPcaPayPassword()))
		{
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "交易密码为空");//交易密码为空
			return retMap;
		}
		
		if (!account.getPcaPayPassword().equals(password))
		{
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "交易密码错误，请重新输入");
			return retMap;
		}
		
		JSONObject json = null;
		P2p_loan_product_aid loanProduct = null;
		
		//查询指定支付渠道的账户信息。
		Map<String, Object> custAcountParams = new HashMap<String, Object>();
		
		custAcountParams.put("custNo", custNo);
		custAcountParams.put("type", "1"); // 1富友
		custAcountParams.put("status", "10"); // status 10  使用中 11冻结

		P2p_cust_account custAccount =
			tenderRepository.getByCustNoAndType(custAcountParams);
		String accountNo = custAccount.getPcaAccountno(); //富友支付账户

		P2p_user user =
			p2p_userMapper.findUserByCustNo(custAccount.getPcaCustNo());

		String retMsg = "";
		try
		{
		    //查询标的
			loanProduct = tenderRepository.selectByProductNo( productNo );			
			// 保存投标记录状态默认为处理中 并且更新已融资金额
			if (loanProduct == null)
			{
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "没有该标的");
				return retMap;
			}
			
			//项目邀请码
			if(loanProduct.getPp_inviteCode() != null && !loanProduct.getPp_inviteCode().equals(inviteCode))
			{			   			    
			    retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, "渠道投资码错误，请重新输入");
                return retMap;
			}
			
			
			try
			{
				retMsg = invokeCoreTrans(
					productNo, custNo, loanAmount, accountNo, channel);
			} catch(Exception e)
			{
				log.error("tenderHandler",e);
				throw new BusinessException("核心通讯异常");
			}
			
			json = (JSONObject) JSON.parse(retMsg);
			
			if (null != json && "" != json.get("retCode") &&
				json.get("retCode") != null &&
				json.get("retCode").equals("0000")) 
			{
				String ptrTenderFlowNo =
					(String) json.get("ptrTenderFlowNo");// 投标流水号
				Map<String, Object> tendMap = null;
				
				try
				{				
					HostingCollectRequest request = new HostingCollectRequest();
					
					request.setPayAccountId(accountNo);
					request.setAmount(
						loanAmount.multiply(new BigDecimal(100)).longValue());
					request.setTradeNo(ptrTenderFlowNo);
					request.setReason(HostingCollectRequest.Reason.invest);
					
					log.info(String.format("pay request: %s", JsonHelper.formatJson(request)));
					/***
					 * 
					 * 调用三方支付接口
					 * 
					 */
					PayResponse response = payService.hostingCollect(request);
					log.info(String.format("pay response: %s", JsonHelper.formatJson(response)));

					if (response.isOk()) 
					{
						{//更新投资表
							tenderRepository.updateByOrderFlowNo(
								ptrTenderFlowNo, Const.success);

							tenderRepository.updateSuspiciousTenderFlow(
								ptrTenderFlowNo, Const.success);
						}
						
						{//记录流水
							accountService.saveAccountFlow(
								ptrTenderFlowNo, custNo, accountNo,
								String.valueOf(
									loanAmount.multiply(new BigDecimal(-1))),
								null, Const.tender, null, Const.success,
								String.format("%s", loanProduct.getPpLoantitle()));
						}
						
						
						{//发短信
							SMSUtil.sendMessage(MessageType.TENDER,
								user.getPuMobile(),
								new MapBuilder<String, Object>()
									.append("#productName#", loanProduct.getPpLoantitle())
									.append("#price#",
										String.format("%.2f",
											loanAmount.doubleValue()))
									.append("#telephone#", serviceTel)
									.toMap());
							
							//【佰宝金服】亲爱的用户您好，您已成功投资“#productName#”#price#元。如有疑问请你致电#telephone#
						}
					} else
					{
						String msgMs = invokeCoreTrans_back(
							tendMap, productNo, custNo, ptrTenderFlowNo);

						/*{//更新投资表
							tenderRepository.updateByOrderFlowNo(
								ptrTenderFlowNo, Const.fail);
							tenderRepository.updateSuspiciousTenderFlow(
								ptrTenderFlowNo, Const.fail);
						}*/
						
						JSONObject jsonMs = (JSONObject) JSON.parse(msgMs);
						
						retMap.put(Const.retCode, false);
						retMap.put(Const.retMsg, "投资失败");// +">>>>>"+jsonMs.get("retCode")投资失败
						
						log.info("客户：" + custNo + ".............投资失败回退:" +
							jsonMs.get("retCode") + ":" + jsonMs.get(Const.retMsg));
						
						return retMap;
					}
				} catch (Exception e) 
				{
					log.error("tenderHandler",e);
					
					String msgMs = invokeCoreTrans_back(
						tendMap,productNo, custNo, ptrTenderFlowNo);
					JSONObject jsonMs = (JSONObject) JSON.parse(msgMs);
					
					log.info("客户：" + custNo + ".............投资失败回退:" + 
						jsonMs.get("retCode") + ":"+ jsonMs.get(Const.retMsg));
					
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg,"投资失败");//投资失败
					
					return retMap;
				} 
				
				if (tendMap != null &&
					tendMap.get("response_code").equals( "APPLY_SUCCESS")) 
				{
					//流水号
					retMap.put("ptrTenderFlowNo", ptrTenderFlowNo);
					retMap.put(Const.retCode, true);
					retMap.put(Const.retMsg, "投标成功");// 投标成功
					
					log.info("客户：custNo.............投标成功");
				}
			} else
			{
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, json.get(Const.retMsg) == null ?
					"投资失败,请稍后再试!" :
					json.get(Const.retMsg));//  投资失败,请稍后再试!
				return retMap;
			}
			
			//查询余额begin
			try
			{
				BalanceRequest request = new BalanceRequest();
				
				request.setAccountId(accountNo);
				
				BalanceResponse response = payService.queryBalance(request);
				if (response.isOk())
				{
					BigDecimal balance_Amount = 
						new BigDecimal(response.getAvalidated())
							.divide(new BigDecimal(100));
					BigDecimal freezed_Amount =
						new BigDecimal(response.getFreezed())
							.divide(new BigDecimal(100));
					
					tenderRepository.updateBalanceAndFreeze(
						custNo, balance_Amount.toString(),
						freezed_Amount.toString());
				}
			} catch( Exception e )
			{   
				log.error("查询三方账户余额错误", e);
			}
			////////////////////////////查询余额end///////////////////////////////////////////
		} catch (Exception e)
		{
			retMap.put(Const.retCode, false);
			if (StringUtil.isEmpty(retMsg))
				retMsg = e.getMessage();
			
			retMap.put(Const.retMsg,"投资失败");//投资失败
			log.error("tenderHandler",e);
		}

		return retMap;
	}

	/**
	 * 投标验证
	 */
	@Override
	public Map<String, Object> checkTender(
		HttpServletRequest request, String custNo, String ppProductNo,
		BigDecimal loanAmount, String _TOKEN_SESSION)
	{
		Map<String, Object> map = new HashMap<String, Object>();

		loanAmount =
			loanAmount.setScale(2, RoundingMode.HALF_UP);

		try
		{
			Map<String, Object> custAcountParams = new HashMap<String, Object>();
			
			custAcountParams.put("custNo", custNo);
			custAcountParams.put("type", "1");// 1.富友账户
			custAcountParams.put("status", "10");// status 10 使用中
			
			P2p_cust_account custAccount =
				tenderRepository.getByCustNoAndType(custAcountParams);
			P2p_loan_product_aid loanProduct =
				tenderRepository.selectByProductNo(ppProductNo);
			
			if (custAccount == null)
			{
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "投资之前请绑定银行卡。");// 
				return map;
			}
			
			if (StringUtils.isBlank(custAccount.getPcaPayPassword()))
			{
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "未设置支付密码");
				return map;
			}
			
			if (loanProduct.getPpCustno().equals(custNo))
			{
				map.put(Const.retCode, false);
				
				if (loanProduct.getPpInvestmentType().intValue() == Const.IFTHESTANDARD)
				{
					map.put(Const.retMsg, "出让人不能投资自己的转让项目");
				} else
				{
					map.put(Const.retMsg, "借款人不能投资自己的项目");
				}
				
				return map;
			}

			if (loanProduct == null || loanProduct.getPpBulkloanstatus() != 1)
			{
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "该标的不可投！");
				return map;
			}
			
			//新手标，在全局中只可投一次
			if (loanProduct == null || loanProduct.getPpActivityType() == 1)
			{ 
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("activityType",Const.activityType );
				params.put("custNo", custNo);
				int ret = tenderRepository.checkRecord(params);
				if (ret>0){
					map.put(Const.retCode, false);
					map.put(Const.retMsg, "新手专享只能投一次");
					return map;
				}
			}
			
			//债转标的，检查原始借款记录，并且债转忽略投标金额是起头金额的整数倍判断。
			if (Const.IFTHESTANDARD == loanProduct.getPpInvestmentType())
			{
				P2p_loan_product_aid originProduct =
					tenderRepository.selectByProductNo(
						loanProduct.getPlpAssignProductNo());
				
				if (originProduct.getPpCustno().equals(custNo))
				{
					map.put(Const.retCode, false);
	                map.put(Const.retMsg, "借款人不能投资自己的项目");
					return map;
				}
			} else
			{
				BigDecimal incrementAmount =
					loanProduct.getPpTenderincreaseamount();
				if (loanAmount != null &&
					loanAmount.divideAndRemainder(incrementAmount)[1].compareTo(BigDecimal.ZERO) != 0)
				{
					map.put(Const.retCode, false);
					map.put(Const.retMsg,
						"投标金额必须是" + incrementAmount + "的倍数");// xx
	
					return map;
				}
			}

			if (custAccount.getPcaAccountBalance().compareTo(loanAmount) == -1)
			{
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "可用余额不足，请您重新输入");// 
				return map;
			}
			
			BigDecimal loanAmountExistBD = loanProduct.getPpLoanamountexist();
			if (null == loanAmountExistBD)
			{
				loanAmountExistBD = new BigDecimal("0.00");
			}

			BigDecimal surplus =//剩余可投金额
				loanProduct.getPpLoanamount().subtract(loanAmountExistBD);
			
			if (surplus.compareTo(loanAmount) == -1)
			{
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "您输入的金额大于剩余可投金额，请重新输入");//
				return map;
			}

			if (loanProduct.getPpTendermaxamount().compareTo(loanAmount) == -1)
			{
				map.put(Const.retCode, false);
				map.put(Const.retMsg,
					"不得超过最大投资额" + loanProduct.getPpTendermaxamount() + "元");

				return map;
			}
			
			if (surplus.compareTo(loanProduct.getPpTerderminamount()) == 1)
			{
				if (loanProduct
						.getPpTerderminamount().compareTo(loanAmount) == 1)
				{
					map.put(Const.retCode, false);
					map.put(Const.retMsg,
						"不得低于最小投资额" + loanProduct.getPpTerderminamount() + "元");

					return map;
				}
			}
			
			String sessionId =
				(String) request.getSession(true).getAttribute("_TOKEN_SESSION");
			map.put("loanTitle", loanProduct.getPpLoantitle());
			map.put("comprehensiveRate", loanProduct.getPpComprehensiverate());
			map.put("loanTerm", loanProduct.getPpLoanterm());
			map.put("loanRepayment", loanProduct.getPpLoanrepayment());
			map.put("loanAmount", loanAmount);
			map.put("loanWay", "");
			map.put("realBulkLoanAmount", loanAmount);
			map.put("sessionId", sessionId);
			map.put(Const.retCode, true);
		} catch(Exception e)
		{
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "系统异常，请稍后再试！"); 
			e.printStackTrace();
			
			log.error("checkTender", e);
		}

		return map;
	}

	public String invokeCoreTrans(
		String productNo, String custNo,
		BigDecimal loanAmount, String accountNo, String channel)
	{
		//RestTemplate restTemplate = new RestTemplate(); // org.springframework.web.client.RestTemplate
		MultiValueMap<String, String> postCoreTrans =
			new LinkedMultiValueMap<String, String>();

		postCoreTrans.add("tranCode", "1002");
		postCoreTrans.add("productNo", productNo);
		postCoreTrans.add("amount", loanAmount.toString());
		postCoreTrans.add("custNo", custNo);
		postCoreTrans.add("accountNo", accountNo);
		postCoreTrans.add("channel", channel);
		postCoreTrans.add("transFlag", "Y");

		String returnJSON = "";
		
		try
		{
			String coreTrans =
				(String) SystemConfigCache.getValue("common", "coreTransUrl");
			returnJSON =
				restTemplate.postForObject(
					coreTrans, postCoreTrans, String.class);

			log.info(
				String.format("coreTrans result: %s", returnJSON));
			
			return returnJSON;
		} catch(Exception e)
		{
			log.error("-0000 invoke coreTrans exception ", e);
		}

		return returnJSON;
	}

	public String invokeCoreTrans_back(
		Map<String, Object> tendMap, String productNo,
		String custNo, String ptrTenderFlowNo)
	{
		//RestTemplate restTemplate = new RestTemplate(); // org.springframework.web.client.RestTemplate
		MultiValueMap<String, String> postCoreTrans =
			new LinkedMultiValueMap<String, String>();
		
		postCoreTrans.add("tranCode", "1002");
		postCoreTrans.add("productNo", productNo);
		postCoreTrans.add("ptrTenderFlowNo", ptrTenderFlowNo);
		postCoreTrans.add("ppoOrderFlowNo", ptrTenderFlowNo);
		postCoreTrans.add("custNo", custNo);
		postCoreTrans.add("transFlag", "N");
		
		if (tendMap != null)
		{
			postCoreTrans.add("retCode",(String)
				((tendMap.get("retCode") == null)?
					"": tendMap.get("retCode"))); // 第三方状态码
			postCoreTrans.add("ptrHostResponseTime",// 第三方响应时间
				(tendMap.get("response_time") == null)?
					CalenderUtil.generatorCurrentDate(null):
					(CalenderUtil.generatorCurrentDate(
						(String) tendMap.get("response_time")))); 
			postCoreTrans.add(// 第三方返回码
				"ptrHostReturnCode", (String) tendMap.get("response_code"));
			postCoreTrans.add("ptrHostReturnMessage",
				(String) ((tendMap.get("response_message") == null)?
					"": tendMap.get("response_message")));// 第三方返回信息

		}

		String returnJSON = "";

		try
		{
			String coreTrans =(String)
				SystemConfigCache.getValue("common", "coreTransUrl");
			returnJSON =
				restTemplate.postForObject(
					coreTrans, postCoreTrans, String.class);

			return returnJSON;
		} catch(Exception e)
		{
			log.error("-9999", "invoke coreTrans back exception " + e);
		}

		return returnJSON;
	}
	
	@Override
	public BigDecimal getAllTenderAmount()
	{
		return tenderRepository.getAllTenderAmount();
	}
	
	@Override
	public int getAllProductCount()
	{
		return tenderRepository.getAllProductCount();
	}
	
	@Override
	public int queryOverDueTotal()
	{
		return tenderRepository.queryOverDueTotal();
	}

	@Override
	public int queryTenderPeopleTotal()
	{
		return tenderRepository.getAllTenderPeopleCount();
	}

	@Override
	public int selectTotalByPorductNo(Map<String, Object> map)
	{
		return tenderRepository.selectTotalByPorductNo(map);
	}

	@Override
	@Transactional
	public boolean creditTrans(String tenderFlowNo)
	{
		try
		{
			LoanProductAid aid = 
				tenderRecordManager.creditTrans(tenderFlowNo);

			if (aid != null)
				return true; 
		} catch(Exception e)
		{
			log.error("", e);
		}

		return false;
	}
}
