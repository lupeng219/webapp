package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_bank_type;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.generator.dao.p2p_bank_cardMapper;
import com.baibao.web.p2p.generator.dataDIC.InvestStatus;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.pay.data.BalanceRequest;
import com.baibao.pay.data.BalanceResponse;
import com.baibao.pay.data.DepositRequest;
import com.baibao.pay.data.DepositResponse;
import com.baibao.pay.data.PayResponse;
import com.baibao.pay.data.RedirectRequest;
import com.baibao.pay.data.RedirectResponse;
import com.baibao.pay.data.WithdrawRequest;
import com.baibao.pay.data.WithdrawResponse;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.repository.AccountRepository;
import com.baibao.web.p2p.repository.PublicOrderRepository;
import com.baibao.web.p2p.repository.RepaymentBillRepository;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.pay.GetUniqueNoService;
import com.baibao.web.p2p.service.RestTemplateService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;

@Service("accountService")
public class AccountServiceImpl
	implements AccountService
{
	private static final Logger logger =
		LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private PayService payService;
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private p2p_bank_cardMapper bankCardMapper;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private GetUniqueNoService getUniqueNoService;
	@Autowired
	private RestTemplateService restTemplateService;
	@Autowired
	private PublicOrderRepository publicOrderRepository;
	@Autowired
	private TendertProfitRepository tendertProfitRepository;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private RepaymentBillRepository repaymentBillRepository;
	@Autowired
	private ActiveService activeService;

	@Autowired
	private P2p_bank_typeMapper bankTypeDao;

	@Override
	public Map<String, Object> bindingPayment(Map<String, Object> parameter)
		throws BusinessException
	{
		Map<String, Object> params = new HashMap<String, Object>();
		
		String amount = parameter.get("amount").toString();
		String custNo = parameter.get("custNo").toString();
		
		String payPassword= null;
		
		if (RegistType.PC.getIndex()
				.equals(parameter.get("registType").toString()) ||
			RegistType.WAP.getIndex()
				.equals(parameter.get("registType").toString()))
		{
			 payPassword = parameter.get("payPassword").toString();
		}
		
		try
		{
			P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(custNo);
			if (account != null)
			{
				if (RegistType.PC.getIndex()
						.equals(parameter.get("registType").toString()) ||
					RegistType.WAP.getIndex()
						.equals(parameter.get("registType").toString()))
				{
					if (StringUtils.isEmpty(account.getPcaPayPassword()))
					{
						params.put(Const.retCode, false);
						params.put(Const.retMsg, //未设置交易密码
							"未设置交易密码");
						return params;
					}
					
					if (!account.getPcaPayPassword().equals(payPassword))
					{
						params.put(Const.retCode, false);
						params.put(Const.retMsg, //交易密码错误
							"交易密码错误");
						return params;
					}
				}
				
				P2p_bank_card bank = bankCardMapper.getBankCardByCustNo(custNo);
				if (bank != null)
				{
					P2p_bank_type bankType =
						bankTypeDao.getBankType(bank.getPbcBankcode());
					if (bankType != null)
					{
						BigDecimal bigAmount = new BigDecimal(amount);
						
						if (bank.getPbcIssafecard().equals("Y"))
						{
							//安全卡
							if (bankType.getSupportQuickPay().equals(true))
							{
								Integer singleLimit =
									bankType.getSingleLimit(); //单笔最大限额
								String singleMinimum = //单笔最低限额
									String.valueOf(bankType.getSingleMinimum());
								if (bigAmount.compareTo(new BigDecimal(singleLimit))==1)
								{
									params.put(Const.retCode, false);
									params.put(Const.retMsg, //充值金额必须小于等于
										"充值金额必须小于等于" + singleLimit);
									return params;
								}
							
								if (bigAmount.compareTo(
										new BigDecimal(singleMinimum)) == -1)
								{
									params.put(Const.retCode, false);
									params.put(Const.retMsg, //充值金额必须大于等于
										"充值金额必须大于等于" + singleMinimum);
									return params;
								}
							} else
							{
								params.put(Const.retCode, false);
								params.put(Const.retMsg, //支付方式不支持，请您绑定其他银行的银行卡进行充值。
									"支付方式不支持，请您绑定其他银行的银行卡进行充值");
								return params;
							}
						} else
						{
							//非安全卡
							Integer firstBindLimit = bankType.getFirstBindLimit();

							if (bigAmount.compareTo(
									new BigDecimal(firstBindLimit)) == 1)
							{
								params.put(Const.retCode, false);
								params.put(Const.retMsg, //充值金额必须小于等于
									"充值金额必须小于等于" + firstBindLimit);
								return params;
							}
						}
					}

					String transFlowNo =
						getUniqueNoService.getPaymentTransFlow();//获取充值交易订单号
					/*Map<String, Object> AccountResult = accountRepository.saveAccountFlow(transFlowNo, custNo, account.getPcaAccountno(), amount,
							registType, Const.recharge,rechargeType);*/
					
					//组装接口参数
					/*Map<String, String> reqParams = new HashMap<String, String>();
					reqParams.put("out_trade_no", transFlowNo);//交易订单号
					reqParams.put("summary", "绑定充值");//摘要
					reqParams.put("identity_id", account.getPcaAccountno()); //用户标识信息
					reqParams.put("identity_type", Const.UID);//用户标识类型
					reqParams.put("amount", amount);//金额
					reqParams.put("account_type", Const.SAVING_POT); //账户类型(默认“存钱罐”账户)
					reqParams.put("pbc_cardid", bank.getPbccardId());*/
					DepositRequest request = new DepositRequest();
					
					request.setAccountId(account.getPcaAccountno());
					request.setAmount(Long.parseLong(amount) * 100);
					request.setTradeNo(transFlowNo);
					request.setNotifyUrl(
						String.valueOf(parameter.get("notifyUrl")));
					
					/***存入订单表
					P2p_public_order  publicOrder = new P2p_public_order();
					
					publicOrder.setPpoOrderflowno(transFlowNo);
					publicOrder.setPpoCustno(custNo);
					publicOrder.setPpoBussType(Integer.valueOf(Const.recharge));
					publicOrder.setPpoOrderTime(new Date());
					publicOrder.setPpoAccountchannel("SINA");
					publicOrder.setPpoStatus(Const.processing);//处理中
					publicOrder.setPpoParams(JsonHelper.formatJson(request));
					
					publicOrderRepository.insertPublicOrder(publicOrder);*/
					
					//Map<String, Object> result = hostingDepositHandler.handle(reqParams,extendPara);//绑卡充值
					//Map<String, Object> result = payService.create_hosting_deposit(reqParams);
					DepositResponse response = payService.deposit(request);
					
					params.put("reqParams", request);
					params.put("result", response);

					if (response.isOk())
					{
						// 缓存支付推进ticket
						//jedisUtil.setValue(Const.pay_tciket.concat(custNo), result.get("ticket").toString(), 15 * 60);
						params.put("transFlowNo", transFlowNo);
						params.put(Const.retCode, true);
						
						params.put("url", response.getTargetUrl());
						params.put("method", response.getTargetMethod());
						params.put("type", response.getTargetType());
						params.put("body", response.getTargetBody());

						return params;
					} else
					{//获取验证码失败
						params.put(Const.retCode, false);
						params.put(Const.retMsg, response.getMessage());
					}
				}
			}
		} catch(BusinessException e)
		{
			logger.error("bindingPayment",e);
			params.put(Const.retCode,false);
			throw e;
		}

		return params;
	}
	
	@Transactional(readOnly = false)
	private void updateIsSafeBankCard(P2p_bank_card bank)
		throws RuntimeException
	{
		if (bank.getPbcIssafecard() == null ||
			bank.getPbcIssafecard().equals("N"))
		{
			bank.setPbcIssafecard("Y");
			
			try
			{
				bankCardMapper.updateIsSafeCardById(bank);
			} catch(RuntimeException e)
			{
				//更新安全卡标识出错
				logger.error("\u66f4\u65b0\u5b89\u5168\u5361\u6807\u8bc6\u51fa\u9519", e);
				throw e;
			}
		}
	}

	/**
	 * 保存充值和提现流水信息
	 * @param transFlowNo 流水号
	 * @param custNo	      客户号
	 * @param payCustNo   第三方支付帐号
	 * @param amount	      金额
	 * @param transChannel 交易渠道
	 * @param statusName   状态名字
	 * @param transType    交易类型(充值、提现)
	 * @param result
	 * @throws Exception
	 */
	@Transactional
	public int saveAccountFlow(
		String transFlowNo, String custNo,
		String payCustNo, String amount, String transChannel,
		String transType, String rechargeType, String status,
		String remark)
			throws RuntimeException
	{
		try
		{
			//保存充值或提现流水
			Map<String, Object> result =
				accountRepository.saveAccountFlow(transFlowNo, custNo, 
					payCustNo, amount, transChannel,
					transType, rechargeType, status, remark);
			if (!Boolean.valueOf(result.get(Const.retCode).toString()))
				return 0;
			
			return 1;
		} catch(RuntimeException e)
		{//保存充值提现流水出错
			logger.error("\u4fdd\u5b58\u5145\u503c\u63d0\u73b0\u6d41\u6c34\u51fa\u9519", e);
			throw e;
		}
	}

	@Override
	public Map<String, Object> advanceHostingPay(Map<String, Object> parameter)
		throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();

		String amount = parameter.get("amount").toString();
		String custNo = parameter.get("custNo").toString();
		
		String validateCode = parameter.get("validateCode").toString();
		String transFlowNo = parameter.get("transFlowNo").toString();
		String registType = parameter.get("registType").toString();
		String rechargeType = parameter.get("rechargeType").toString();
		
		String code = jedisUtil.getValue(Const.pay_tciket.concat(custNo));
		if (StringUtil.isEmpty(code))
		{//验证码超时，请重新获取
			result.put(Const.retMsg,
				"验证码超时，请重新获取");
			result.put(Const.retCode, false);

			return result;
		}

		Map<String, String> params = new HashMap<String, String>();
		
		//获取充值交易推进订单号
		String transFlowPushNo =  getUniqueNoService.getPaymentTransFlow();

		params.put("out_advance_no", transFlowPushNo);
		params.put("ticket", code);
		params.put("validate_code", validateCode);

		/****查询流水是否存在**/
		P2p_account_flow accountFlow =
			accountRepository.getAccountFlow(transFlowNo);
		if (accountFlow == null)
		{
			/***存入流水表*/
			P2p_public_order order =
				publicOrderRepository.selectByPrimaryKey(transFlowNo);
			if (order != null)
			{
				String ppoparams = order.getPpoParams();
				JSONObject json = JSONObject.parseObject(ppoparams);
				amount =(String) json.get("amount");
			}

			accountRepository.saveAccountFlow(
				transFlowNo, custNo, custNo, amount,
				registType, Const.recharge, rechargeType, null, "充值");
		}
		
		/***存入订单表
		JSONObject jsonParams = (JSONObject) JSONObject.toJSON(params);

		P2p_public_order publicOrder = new P2p_public_order();

		publicOrder.setPpoOrderflowno(transFlowPushNo);
		publicOrder.setPpoCustno(custNo);
		publicOrder.setPpoBussType(Integer.valueOf(Const.rechargepush));
		publicOrder.setPpoOrderTime(new Date());
		publicOrder.setPpoAccountchannel("SINA");
		publicOrder.setPpoStatus(Const.processing);//处理中
		publicOrder.setPpoParams(jsonParams.toString());
		publicOrder.setPpoParentFlowNo(transFlowNo);

		publicOrderRepository.insertPublicOrder(publicOrder);*/
		
		//result = advanceHostingPayHandler.handle(params);
		//result = payService.advance_hosting_pay(params);
		
		result.put("params", params);
		//if (result != null && result.get(Const.retCode).toString().equals(ControllerRetType.OPT_SUCC.getTransCode())) {
		if (true)
		{
			/***更新流水表"处理中"*/
			accountRepository.updateSuspiciousFlow(
				transFlowNo, Const.processing);

			/**更新订单表状态为"成功"*/
			publicOrderRepository.updateByOrderFlowNo(
				transFlowPushNo, Const.success);

			/**查询银行卡是否为安全卡*/
			P2p_bank_card  bankCard =
				bankCardMapper.getBankCardByCustNo(custNo);
			if (bankCard != null)
			{
				if (bankCard.getPbcIssafecard() == null ||
					bankCard.getPbcIssafecard().equals("N"))
				{
					bankCard.setPbcIssafecard("Y");
					
					try
					{
						bankCardMapper.updateIsSafeCardById(bankCard);
					} catch (Exception e)
					{//更新安全卡标识出错
						logger.error(
							"\u66f4\u65b0\u5b89\u5168\u5361\u6807\u8bc6\u51fa\u9519", e);
					}
				}
			}
			
			result.put(Const.retMsg, //充值申请提交成功
				"\u5145\u503c\u7533\u8bf7\u63d0\u4ea4\u6210\u529f");
			result.put(Const.retCode, true);
			
			return result;
		} else
		{
			/**更新订单表状态为"失败"*/
			publicOrderRepository.updateByOrderFlowNo(transFlowPushNo, Const.fail);
			result.put(Const.retMsg, result.get("response_message").toString());
			result.put(Const.retCode, false);
			return result;
		}
	}

	@Override
	public Map<String, Object>
			createHostingWithDraw(Map<String, Object> parameter)
		throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();

		String amount = parameter.get("amount").toString();
		String payPassword = parameter.get("payPassword").toString();
		String custNo = parameter.get("custNo").toString();
		String registType = parameter.get("registType").toString();//交易渠道
		String userFee = Const.userFee;//扣款金额
		
		try
		{
			P2p_bank_card bank = bankCardMapper.getBankCardByCustNo(custNo);
			
			if (bank != null &&
				bank.getPbcIfadvance().equals(Const.ALREADYADVANCE))
			{//已推进
				P2p_cust_account custAccount =
					getCustAccountByCustNo(custNo, false);

				//实际提现金额 = 提现金额 + 扣款金额
				BigDecimal accountBalance =
					custAccount.getPcaAccountBalance().subtract(
						new BigDecimal(userFee));
				if (accountBalance.compareTo(new BigDecimal(amount)) == -1)
				{
					result.put(Const.retCode, false);
					result.put(Const.retMsg, //可用余额不足
						"\u53ef\u7528\u4f59\u989d\u4e0d\u8db3");
					result.put(Const.retType, "amount");

					return result;
				}
				
				if (!custAccount.getPcaPayPassword().equals(payPassword))
				{
					result.put(Const.retCode, false);
					result.put(Const.retMsg, //交易密码错误，请您重新输入
						"\u4ea4\u6613\u5bc6\u7801\u9519\u8bef\uff0c\u8bf7\u60a8\u91cd\u65b0\u8f93\u5165");
					result.put(Const.retType, "pwd");
					
					return result;
				}
			} else
			{
				result.put(Const.retCode, false);
				result.put(Const.retMsg, //未绑定银行卡
					"\u672a\u7ed1\u5b9a\u94f6\u884c\u5361");
				result.put("type", "unBindingCard");

				return result;
			}
			
			//获取提现交易订单号
			String withDrawTransFlow =
				getUniqueNoService.getWithDrawTransFlow();
			
			/* 存入流水表初始状态为"待处理" */
			Map<String, Object> AccountResult =
				accountRepository.saveAccountFlow(
					withDrawTransFlow, custNo, bank.getPbcAccountno(),
					"-" + amount,
					registType, Const.withdrawals, "", null, "提现到银行卡");
			if (Boolean.valueOf(AccountResult.get(Const.retCode).toString()))
			{
				WithdrawRequest request = new WithdrawRequest();
				if (RegistType.APP.getIndex().equals(registType))
                {
                    request.setReason(WithdrawRequest.Reason.app);
                }
				request.setAccountId(bank.getPbcAccountno());
				request.setAmount(
					new BigDecimal(amount)
						.multiply(new BigDecimal(100)).longValue());
				request.setTradeNo(withDrawTransFlow);
				request.setNotifyUrl(
					String.valueOf(parameter.get("notifyUrl")));

				WithdrawResponse response = payService.withdraw(request);
				
				if (response.isOk())
				{
					accountRepository.updateSuspiciousFlow(
						withDrawTransFlow, Const.processing);
					result.put(Const.retCode, true);
					result.put(Const.retMsg, "提现申请提交成功");

					result.put("url", response.getTargetUrl());
					result.put("method", response.getTargetMethod());
					result.put("type", response.getTargetType());
					result.put("postBody", response.getTargetBody());
					result.put("body", response.getBody());
				} else
				{
					logger.error("调用提现接口失败");
					
					result.put(Const.retCode, false);
					result.put(Const.retMsg, response.getMessage()); //提现失败
				}
			} else
			{
				logger.error("保存提现记录失败");
				
				result.put(Const.retCode, false);
				result.put(Const.retMsg, "提现失败");//提现失败
			}
		} catch(BusinessException e)
		{
			logger.error("createHostingWithDraw",e);
			result.put(Const.retCode, false);
			throw e;
		}

		return result;
	}

	@Override
	public Map<String, Object> onlineBankPayment(
		String custNo, String amount, String bankCode,
		String registType, String rechargeType, String notifyUrl)
			throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		try
		{					    
		    // 充值金额必须大于等于50
            BigDecimal bigAmount = new BigDecimal(amount);

            if (bigAmount.compareTo(new BigDecimal(50)) == -1)
            {
                logger.error(registType + "_operation 充值金额需大于等于50元");
                result.put(Const.retCode, false);
                result.put(Const.retMsg, "充值金额需大于等于50元");
                return result;
            }
		    
		    		    
			P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(custNo);
			String transFlowNo = getUniqueNoService.getPaymentTransFlow();
	    	Map<String, Object> AccountResult =
	    		accountRepository.saveOnlineBankAccountFlow(
	    			transFlowNo, custNo, account.getPcaAccountno(), amount,
	    			registType, Const.recharge, rechargeType, "充值到帐户余额");
			if (Boolean.valueOf(AccountResult.get(Const.retCode).toString()))
			{
				/*params.put("out_trade_no", transFlowNo);
		    	params.put("summary", "网银充值");
		    	params.put("identity_id", account.getPcaAccountno());
		    	params.put("identity_type", Const.UID);
		    	params.put("amount", amount);
		    	params.put("account_type", Const.SAVING_POT);
		    	params.put("bank_code", bankCode);*/
		    			    	
				DepositRequest request = new DepositRequest();
				if (RegistType.APP.getIndex().equals(registType))
                {
                    request.setReason(DepositRequest.Reason.app);
                }

				request.setAccountId(account.getPcaAccountno());
				request.setAmount(
					new BigDecimal(amount)
						.multiply(new BigDecimal(100)).longValue());
				request.setTradeNo(transFlowNo);
				request.setNotifyUrl(notifyUrl);

		    	/***存入订单表
				P2p_public_order publicOrder = new P2p_public_order();
				
				publicOrder.setPpoOrderflowno(transFlowNo);
				publicOrder.setPpoCustno(custNo);
				publicOrder.setPpoBussType(
					Integer.valueOf(Const.cyberBankRecharge));
				publicOrder.setPpoOrderTime(new Date());
				publicOrder.setPpoAccountchannel("SINA");
				publicOrder.setPpoStatus(Const.processing);//处理中
				publicOrder.setPpoParams(JsonHelper.formatJson(request));
				
				publicOrderRepository.insertPublicOrder(publicOrder);*/

				DepositResponse response =
					rechargeType.equals(Const.onlineBankingRecharge)?
						payService.recharge(request):
						payService.deposit(request);
	        	
				if (response.isOk())
				{
	        		result.put(Const.retCode, true);

	        		for(String key: response.getBody().keySet())
	        		{
	        			response.getBody().put(
	        				key, String.valueOf(response.getBody().get(key)));
	        		}
	        		
	        		result.put("url", response.getTargetUrl());
	        		result.put("method", response.getTargetMethod());
					result.put("type", response.getTargetType());
					result.put("postBody", response.getTargetBody());
					result.put("body", response.getBody());
	        		
	        		return result;
	        	} else
	        	{
	        		logger.error(//调用网银充值接口失败
	        			"调用网银充值接口失败");

	        		result.put(Const.retCode, false);
	        		result.put(//网银充值失败
	        			Const.retMsg, response.getMessage());
	        	}
			} else
			{
				logger.error(//保存网银充值记录失败
					"保存网银充值记录失败");
				
				result.put(Const.retCode, false);
        		result.put(Const.retMsg, //网银充值失败
        			"网银充值失败");
			}
		} catch(BusinessException e)
		{
			logger.error("onlineBankPayment",e);
			result.put(Const.retCode, false);
			throw e;
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public P2p_cust_account
		getCustAccountByCustNo(String custNo, boolean isRequestSina)
			throws BusinessException
	{
		P2p_cust_account custAccount =
			accountRepository.getCustAccountByIdOrCustNo(custNo);
		
		if (isRequestSina)
		{
			BalanceRequest request = new BalanceRequest();
			
			request.setAccountId(custAccount.getPcaAccountno());
			
			BalanceResponse response = payService.queryBalance(request);
			if (response.getStatus() == PayResponse.OK)
			{
				BigDecimal balance =
					new BigDecimal(response.getAvalidated())
						.divide(new BigDecimal(100));
				
				custAccount.setPcaAccountBalance(balance);
			}

			accountRepository.updateBalanceAndRechargeByCustNoAccountNo(
				custAccount.getPcaAccountBalance(),
				custAccount.getPcaCustNo(),
				custAccount.getPcaAccountno());
		}
		
		return custAccount;
	}

	@Override
	public List<Map<String, Object>> querySuspiciousFlow()
		throws BusinessException
	{
		return accountRepository.querySuspiciousFlow();
	}

	@Override
	public int updateSuspiciousFlow(String paf_transFlowNo, String status)
		throws BusinessException
	{	
		return accountRepository.updateSuspiciousFlow(paf_transFlowNo, status);
	}

	@Override
	public Map<String, Object> assetPandect(Map<String, Object> map)
		throws BusinessException
	{
		//资产总计 = 累计收益 + 可用余额 + 我的投资 + 活动奖励
		//资产总计 = 待收本息+ 可用余额 + 再投金额 + 活动奖励
		Map<String, Object> params = new HashMap<String, Object>();
		
		// 待收本息（累计收益）
		BigDecimal accumulatedIncome = new BigDecimal(0);

		String custNo = map.get("custNo").toString();

		params.put("custNo", custNo);
		params.put("status",//未收益
			RepaymentBillStatus.NOREPAYMETN.getIndex());
		
		//实际收益利息fact_interest、未收益本息和capital_and_interest、预期本金capital
		Map<String, BigDecimal> result =
			tendertProfitRepository.getCustAllProfitByCustNoAndStatus(params);
		if (result != null)
		{
			accumulatedIncome = 
				(result.get("ptp_factProfit") == null?
					accumulatedIncome:
					result.get("ptp_factProfit"));

			result.clear();
		}

		BigDecimal accountBalance =
			new BigDecimal(map.get("accountBalance").toString());//可用余额
		
		BigDecimal investTotal =
			tenderRepository.getPtrAmount(custNo);//再投金额（投资总额）
		investTotal = investTotal == null?
			new BigDecimal(0): investTotal;
		
		BigDecimal activityReward  =
			activeService.getSumReward(custNo);// 活动奖励
		activityReward =
			activityReward == null?
				new BigDecimal(0): activityReward;
		activityReward =
			activityReward.setScale(2, RoundingMode.HALF_DOWN);
		
		BigDecimal propertyTotal =
			accumulatedIncome
				.add(accountBalance).add(investTotal)
				.add(activityReward);//资产总计
		
		propertyTotal =
			propertyTotal.setScale(2,RoundingMode.HALF_DOWN);
		
		params.put("accumulatedIncome", accumulatedIncome);
		params.put("activityReward", activityReward);
		params.put("accountBalance", accountBalance);
		params.put("investTotal", investTotal);
		params.put("propertyTotal", propertyTotal);

		return params;
	}

	@Override
	public Map<String, Object> myDebt(String custNo) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, BigDecimal> repaymentBill = repaymentBillRepository.getCustLiabilitiesByCustNo(custNo);
		BigDecimal shouldRepaymentPrincipal = new BigDecimal(0);// 应还本金
		BigDecimal shouldRepaymentInterest = new BigDecimal(0);// 应还利息
		BigDecimal shouldOverDueAmount = new BigDecimal(0);//逾期费用
		BigDecimal totalLiabilities = new BigDecimal(0);// 总的负债
		
		if(repaymentBill!=null){
			shouldRepaymentPrincipal = repaymentBill.get("shouldRepaymentPrincipal");
			shouldRepaymentInterest = repaymentBill.get("shouldRepaymentInterest");
			shouldOverDueAmount = repaymentBill.get("shouldOverDueAmount");
			totalLiabilities = repaymentBill.get("totalLiabilities");
		}
		params.put("shouldRepaymentPrincipal", shouldRepaymentPrincipal);
		params.put("shouldRepaymentInterest", shouldRepaymentInterest);
		params.put("shouldOverDueAmount", shouldOverDueAmount);
		params.put("totalLiabilities", totalLiabilities);
		return params;
	}

	@Override
	public Map<String, Object> changeCard(String custNo, String notifyUrl, RegistType registType)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		try
		{			
			P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(custNo);

			RedirectRequest request = new RedirectRequest();
			
			if (RegistType.APP==registType)
            {
                request.setReason(RedirectRequest.Reason.app);
            }
			request.setMethod(RedirectRequest.Method.modifyCard);
			request.setAccountId(account.getPcaAccountno());
			request.setNotifyUrl(notifyUrl);
			
			RedirectResponse response = payService.redirect(request);
			
    		result.put(Const.retCode, true);

    		for(String key: response.getBody().keySet())
    		{
    			response.getBody().put(
    				key, String.valueOf(response.getBody().get(key)));
    		}
    		
    		result.put("url", response.getTargetUrl());
    		result.put("method", response.getTargetMethod());
			result.put("type", response.getTargetType());
			result.put("postBody", response.getTargetBody());
			result.put("body", response.getBody());
		} catch(BusinessException e)
		{
			logger.error("onlineBankPayment",e);
			result.put(Const.retCode, false);
			throw e;
		}
		
		return result;
	}

	@Override
	public Map<String, Object> changePhone(String custNo, String notifyUrl)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		try
		{			
			P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(custNo);

			RedirectRequest request = new RedirectRequest();
			
			request.setMethod(RedirectRequest.Method.modifyPhone);
			request.setAccountId(account.getPcaAccountno());
			request.setNotifyUrl(notifyUrl);
			
			RedirectResponse response = payService.redirect(request);
			
    		result.put(Const.retCode, true);

    		for(String key: response.getBody().keySet())
    		{
    			response.getBody().put(
    				key, String.valueOf(response.getBody().get(key)));
    		}
    		
    		result.put("url", response.getTargetUrl());
    		result.put("method", response.getTargetMethod());
			result.put("type", response.getTargetType());
			result.put("postBody", response.getTargetBody());
			result.put("body", response.getBody());
		} catch(BusinessException e)
		{
			logger.error("onlineBankPayment",e);
			result.put(Const.retCode, false);
			throw e;
		}
		
		return result;
	}
	
	@Override
	public Map<String, Object> changePassword(String custNo, String notifyUrl)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		try
		{			
			P2p_cust_account account =
				accountRepository.getCustAccountByIdOrCustNo(custNo);

			RedirectRequest request = new RedirectRequest();
			
			request.setMethod(RedirectRequest.Method.modifyPassword);
			request.setAccountId(account.getPcaAccountno());
			request.setNotifyUrl(notifyUrl);
			
			RedirectResponse response = payService.redirect(request);
			
    		result.put(Const.retCode, true);

    		for(String key: response.getBody().keySet())
    		{
    			response.getBody().put(
    				key, String.valueOf(response.getBody().get(key)));
    		}
    		
    		result.put("url", response.getTargetUrl());
    		result.put("method", response.getTargetMethod());
			result.put("type", response.getTargetType());
			result.put("postBody", response.getTargetBody());
			result.put("body", response.getBody());
		} catch(BusinessException e)
		{
			logger.error("onlineBankPayment",e);
			result.put(Const.retCode, false);
			throw e;
		}
		
		return result;
	}
	
	@Override
	public void syncFreezedAmont(String accountNo, String custNo) {
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
			logger.error("查询三方账户余额错误", e);
		}

	}

	@Override
	public BigDecimal profitSum(Map<String, Object> map) {
		BigDecimal	profit =  tendertProfitRepository.profitSum(map);
		return profit = profit == null?new BigDecimal(0):profit;
	}
}
