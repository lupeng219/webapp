package com.baibao.web.p2p.controller.app;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.AreaUtil;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.core.utils.mail.MailUtil;
import com.baibao.web.p2p.comm.ActiveId;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.controller.eventBus.events.LotteryDrawEvent;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_bank_type;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.AccountFlowService;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.web.p2p.service.CustAccountService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.UmpayService;
import com.baibao.web.p2p.service.UserInfoService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.service.transRecord.TransRecordService;
import com.baibao.web.p2p.utils.AppCallLogUtil;

/**
 * 账户信息
 * 
 * @author Denny
 * @date 2016年6月22日
 */
@Controller
@RequestMapping("appAccount")
public class AppAccountController
{
	private static final Logger logger =
		LoggerFactory.getLogger(AppAccountController.class);
	
	@Autowired
	private JedisUtil jedisUtil;
	
	@Autowired
	private TenderProfitService tenderProfitService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	@Autowired
	private TransRecordService transRecordService;
	@Autowired
	private LoanProductAidService loanProductChildService;
	@Autowired
    private BankCardService bankCardService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
    private CustAccountService custAccountService;
	@Autowired
	private UmpayService umpayService;
	@Autowired
	private BaseLog baseLog;
	@Autowired
	private LotteryDrawEvent lotteryDrawEvent;

	@Autowired
	private P2p_bank_typeMapper bankTypeDao;
	
	@Autowired
    private AccountFlowService accountFlowService;
	
	
	/**
	 * app -账户信息
	 * @param custNo
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/findAccount" ,method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> account(
		HttpServletRequest request, String custNo)
	{
		AppCallLogUtil.printMsg(request, "appAccount.findAccount","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		custNo = jedisUtil.getValue(custNo);
		
		if (StringUtils.isEmpty(custNo))
		{
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);// 用户未登录
			return retMap;
		}
		
		try
		{
			P2p_cust_account account =
				accountService.getCustAccountByCustNo(custNo, true);
			if(account==null){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误 
				return retMap;
			}
			P2p_user user = userService.getByLoginCustNo(custNo);
			if(user==null){
			    retMap.put(Const.retCode, false);
	            retMap.put(Const.retMsg, "\u7528\u6237\u672a\u767b\u5f55");// 用户未登录
	            return retMap;
			}
			BigDecimal balance = account.getPcaAccountBalance();   //可用余额
			if(balance==null){
			    balance = new BigDecimal(0);
			}
			params.put("status", Const.success);
			if(StringUtils.isBlank(user.getPuHeadUrl())){
				retMap.put("headUrl", "");
			}else{
				retMap.put("headUrl", this.getUserHeadUrl(request, user.getPuHeadUrl()));
			}
			//手机号
			String retphone = user.getPuMobile();
			if(StringUtil.isNotEmpty(retphone)){
                retMap.put("allphone", retphone);
                retphone=retphone.substring(0,3)+"****"+retphone.substring(7, 11);
                retMap.put("retphone", retphone);
            }else{
                retMap.put("allphone", "");
                retMap.put("retphone", "");
            }
			//是否实名认证
			P2p_user_info info = userInfoService.getByCustNo(custNo);
            if(info!=null){
                retMap.put("isCert", info.getPuiPlataccountiscert());
                retMap.put("puiRealName", info.getPuiRealName());
                retMap.put("puiCertNo", info.getPuiCertNo());
            }else{
                retMap.put("isCert","1");
                retMap.put("puiRealName", "");
                retMap.put("puiCertNo", "");
            }
            //验证邮箱
            String isSetEmail = "1";
            if(StringUtil.isNotEmpty(user.getPuMail())){
                isSetEmail = "0";//已设置
                retMap.put("mail",user.getPuMail());
            }
            retMap.put("isSetEmail", isSetEmail);
            //是否设置交易密码
            String transactionPassword = "1";    
            if(!StringUtil.isEmpty(account.getPcaPayPassword())){
                transactionPassword = "0";
            }
            retMap.put("transactionPassword",transactionPassword );
            
			params.put("custNo", user.getPuCustNo());
			params.put("accountBalance", balance);
			Map<String, Object> ret =  accountService.assetPandect(params);
			
			retMap.put("accumulatedIncome",ret.get("accumulatedIncome") );//待收本息
			retMap.put("investmentTotal", ret.get("investTotal"));//投资总额investTotal
			retMap.put("allMoney", ret.get("propertyTotal")); //总的资产propertyTotal
			retMap.put("accountBalance",balance );
			params.clear();
			params.put("custNo", custNo);
			List<String> expectStatus = Arrays.asList("0","7");
			params.put("status", expectStatus);
			BigDecimal expectProfit = accountService.profitSum(params);
			List<String> factStatus = Arrays.asList("1");
			params.put("status", factStatus);
			BigDecimal factProfit = accountService.profitSum(params);
			retMap.put("expectProfit",expectProfit ); //待收利息
			retMap.put("factProfit",factProfit );//已收利息
			retMap.put(Const.retCode, true);
			retMap.put("activitySign","0" );//活动标识，用来判断有没有新活动上线  1有新活动0没活动
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			//获取银行卡名称和简称
            List<P2p_bank_type> list = getBankInfo(request);
            retMap.put("bankTypeList",list);  //银行卡列表
            	
            //获取银行卡名称和简称
            P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
            if(null != bankCard && "01".equals(bankCard.getPbcIfadvance())){
                //已绑卡
                retMap.put("hasBankCard", true);
            }else{
                //未绑卡
                retMap.put("hasBankCard", false);
            }
            
			//抽奖次数验证
			lotteryDrawEvent.setActiveId(ActiveId.ACTIVEID_DZP);
			lotteryDrawEvent.setPulCustno(custNo);
			lotteryDrawEvent.setPulSourcetype("1");//1 登录  2 投资
		} catch (Exception e) {
			logger.error("app账户接口出错,接口名appAccount/findAccount",e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误 
			return retMap;
		}
		return retMap;
	}
	
	private String getUserHeadUrl(HttpServletRequest request, String headUrl){
	    String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        return basePath + "/service/file/" + headUrl;
	}
	
	/**
	 *充值  提现  收益 记录
	 * @param transType  10 充值 11提现12投标 40收益
	 * @param startTime
	 * @param endTime
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "rechargeWithdraw",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>rechargeWithdraw(HttpServletRequest request,@RequestParam(value="transType",required=false) Integer transType,
			@RequestParam(value="currentPageNo",required =false)Integer currentPageNo,
			@RequestParam(value="pageSize",required = false)Integer pageSize,
			@RequestParam(value="custNo",required = true) String custNo){
		 AppCallLogUtil.printMsg(request, "appAccount.rechargeWithdraw","transType","currentPageNo","pageSize","custNo");
		 currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		 pageSize = pageSize == null ? 10:pageSize;
 		 Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		};
		Paging<P2p_account_flow> page = transRecordService.getByCustNoAndTypeApp(custNo,transType,"","","",currentPageNo, pageSize);
		List<P2p_account_flow> list = page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 投资记录
	 * @param currentPageNo
	 * @param pageSize
	 * @param bulkStatus
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value = "/tenderRecord", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> tenderRecord(HttpServletRequest request,Integer currentPageNo,Integer pageSize,
			String custNo){
		 AppCallLogUtil.printMsg(request, "appAccount.tenderRecord","currentPageNo","pageSize","custNo");
		 currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		 pageSize = pageSize == null ? 10:pageSize;
		 Map<String, Object> retMap = new HashMap<String, Object>();
		 Map<String, Object> map = new HashMap<String, Object>();
		 custNo = jedisUtil.getValue(custNo);
		 if(StringUtil.isEmpty(custNo)){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
				return retMap;
			};
		map.put("custNo", custNo);
		Paging<Map<String, Object>>page =transRecordService.tenderRecord(map, currentPageNo, pageSize);
		List<Map<String, Object>> list = page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 我的账户切换至旧版
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException 
	 */
	
	@RequestMapping(value="/switcholdaccount",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> switchOldAccount(HttpServletRequest request,HttpServletResponse response,String custNo) throws BusinessException{
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);// 用户未登录
			return retMap;
		}
		//可用余额、冻结金额、合计充值、资产总计、合计提现 
		Map<String, Object> result = umpayService.selectCustAccount(custNo);
		retMap.put("result",result);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 联动提现页面跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/skipWithdrawCash")
	@ResponseBody
	public Map<String, Object> skipWithdrawCash(HttpServletRequest request,HttpServletResponse response,String custNo) throws BusinessException{
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);// 用户未登录
			return retMap;
		}
		Map<String, Object> result = umpayService.getPresentPage(custNo); 
		if(null==result.get("bankType")){
			retMap.put("bankurl", "");
		}else{
			retMap.put("bankurl", Const.basePath+"/images/banklogo/"+result.get("bankType")+".png");
		}
		retMap.put("bankNum", result.get("bankNum"));
		retMap.put("realAmount",result.get("realAmount"));
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	
	/**
	 * 联动提现
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping("/umpayWithdrawCash")
	@ResponseBody
	public Map<String, Object> umpayWithdrawCash(HttpServletRequest request,HttpServletResponse response,@RequestParam("withdrawalsMoney") String withdrawalsMoney,String custNo) throws BusinessException{
		Map<String, Object> result = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(withdrawalsMoney) || StringUtils.isEmpty(custNo)){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, Const.noLoginMsg);// 参数不符合规范
			return result;
		}
		result = umpayService.withdrawCashApp(custNo, withdrawalsMoney);
		return result;
	}
	/**
	 * 旧版交易记录
	 * @param transType 1充值 2 提现 3 投标 4 收益
	 * @param currentPageNo
	 * @param pageSize
	 * @param custNo
	 * @return
	 */
	@RequestMapping("/oldTransactionRecord")
	@ResponseBody
	public Map<String, Object>oldTransactionRecord(HttpServletRequest request,
			@RequestParam(value="transType",required=false) Integer transType,
			@RequestParam(value="currentPageNo",required =false)Integer currentPageNo,
			@RequestParam(value="pageSize",required = false)Integer pageSize,
			@RequestParam(value="custNo",required = true) String custNo,
			@RequestParam(value="version",required = false)String version) throws BusinessException{
		
		 Map<String, Object> retMap = new HashMap<String, Object>();
		 currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		 pageSize = pageSize == null ? 10:pageSize;
		 custNo = jedisUtil.getValue(custNo);
		 if(StringUtil.isEmpty(custNo)){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
				return retMap;
			};
		if(StringUtil.isNotEmpty(version)){
			if("1".equals(version)){
				Paging<Map<String, Object>> paging = umpayService.getTransactionRecordPage(custNo, transType, null, null, null, currentPageNo, pageSize);
				List<Map<String, Object>> list = paging.getPageList();
				retMap.put("countTotal", paging.getCountTotal());
				retMap.put("endNum",paging.getEndPageNo() );
				retMap.put("statrNum",paging.getStartPageNo());
				retMap.put("list", list);
				retMap.put(Const.retCode, true);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			}
		}else{
			Paging<Map<String, Object>> paging = umpayService.getTransactionRecordPage(custNo, transType, null, null, null, currentPageNo, pageSize);
			List<Map<String, Object>> list = paging.getPageList();
			if (request.getHeader("user-agent") != null) {
					String header = request.getHeader("user-agent").toLowerCase();
				if(header.indexOf("iphone")<0 && header.indexOf("ios")<0){
					if(transType==4){
						if(list!=null){
							for(Map<String, Object> map :list){
								if("1".equals(map.get("chargeStatus").toString())){
									map.put("chargeStatus", "0");
								}else if("0".equals(map.get("chargeStatus").toString())){
									map.put("chargeStatus", "1");
								}
							}
							
						}
					}
				}
			}else{
				if(transType==4){
					if(list!=null){
						for(Map<String, Object> map :list){
							if("1".equals(map.get("chargeStatus").toString())){
								map.put("chargeStatus", "0");
							}else if("0".equals(map.get("chargeStatus").toString())){
								map.put("chargeStatus", "1");
							}
						}
						
					}
				}
			}
			retMap.put("countTotal", paging.getCountTotal());
			retMap.put("endNum",paging.getEndPageNo() );
			retMap.put("statrNum",paging.getStartPageNo());
			retMap.put("list", list);
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		}
		return retMap;
	}
	/**
	 * 绑定银行卡(作废)
	 * @param request
	 * @return  鹿朋
	 */
	@RequestMapping(value="/bankCardBinding",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> bankCardBinding(
		@RequestParam("bankCode") String bankCode,
		@RequestParam("bankCardNo") String bankCardNo,
		@RequestParam("province") String province,
		@RequestParam("city") String city,
		@RequestParam("phoneNo") String phoneNo,
		@RequestParam("custNo")String custNo){
	
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			 custNo = jedisUtil.getValue(custNo);
			if(StringUtils.isEmpty(bankCode) || StringUtils.isEmpty(bankCardNo) || StringUtils.isEmpty(province) || StringUtils.isEmpty(city) || StringUtils.isEmpty(phoneNo) || StringUtils.isEmpty(custNo)){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
				return retMap;
			}
			result.put("bankCode", bankCode);
			result.put("bankCardNo", bankCardNo);
			result.put("province", province);
			result.put("city", city);
			result.put("phoneNo", phoneNo);
			result.put("custNo", custNo);
			retMap = bankCardService.bankCardBinding(result);
			baseLog.writer(custNo,result.toString(),retMap.toString(),BusinessType.BINDBANKCARD.getDesc(), RegistType.APP.getName(), "/bankCardBinding");
		} catch (Exception e) {
			logger.error("\u64cd\u4f5c\u5f02\u5e38+接口名是appAccount/bankCardBinding",e );//操作异常
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u83b7\u53d6\u77ed\u4fe1\u9a8c\u8bc1\u7801\u5931\u8d25");//获取验证码失败
			return retMap;
		}
		return retMap;
	}
/***我的账户 - 电子邮箱strat*/
	
	/**
	 * 我的账户 - 发送邮箱验证码
	 * @param oldEmail 原邮箱
	 * @param newEmail 新邮箱
	 * @return
	 */
	@RequestMapping("/getEmailVer")
	@ResponseBody
	public Map<String, Object> getEmailVer(HttpServletRequest request,
			@RequestParam(value = "oldEmail",required=false) String oldEmail,
			@RequestParam(value = "newEmail",required=true) String newEmail,
			@RequestParam(value = "custNo",required = true) String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.getEmailVer","custNo","oldEmail","newEmail");
		Map<String, Object> result = new HashMap<String, Object>();
		try{ 
			custNo = jedisUtil.getValue(custNo);
			if(StringUtils.isEmpty(custNo)){
				result.put(Const.retCode, false);
				result.put(Const.retMsg, Const.noLoginMsg);// 参数不符合规范
				return result;
			}
			P2p_user user = userService.getByLoginCustNo(custNo);
			if(StringUtil.isNotEmpty(user.getPuMail())){
				if(!user.getPuMail().equals(oldEmail)){
					result.put(Const.retCode, false);
					result.put(Const.retMsg, "\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u539f\u90ae\u7bb1\u5730\u5740");//请输入正确的原邮箱地址
					return result;
				}
			}
			result=sendEmail(request, newEmail);
		} catch (Exception e) {
			logger.error("getEmailVer" + e);
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u65b0\u7535\u5b50\u90ae\u7bb1\u4e0d\u6b63\u786e");//新电子邮箱不正确
		}
		return result;
	}
	
	/**
	 * 发送邮件
	 * @param userEmail 邮箱地址
	 */
	@RequestMapping("/sendEmail")
	public @ResponseBody Map<String, Object> sendEmail(HttpServletRequest request,String userEmail){
		AppCallLogUtil.printMsg(request, "appAccount.sendEmail","userEmail");
		Map<String, Object> result = new HashMap<String, Object>();
		Long validateSendTime=(Long) SessionUtils.getAttrFromSession(request,"validateSendTime");
		Boolean flag = false;
		String head = "绑定邮箱验证";
		String msg=RandomStringUtils.randomNumeric(6);
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("msg",msg);
		try {
			if(null!=validateSendTime&&!"".equals(validateSendTime)){
				long differ = System.currentTimeMillis() - validateSendTime;
				// 大于60秒
				if(differ>=60000){
					flag = MailUtil.sendMail(userEmail, head, "findPassword.ftl", paramMap);
					if(flag){
						SessionUtils.putAttrInSession(request,"validateSendTime",System.currentTimeMillis());
						jedisUtil.setValue("validataCodeMsg"+userEmail,msg,60 * 10);
						System.err.println(jedisUtil.getValue("validataCodeMsg"));
						result.put(Const.retCode,true);
						result.put(Const.retMsg,"\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\u81f3\u60a8\u7684\u90ae\u7bb1\uff0c\u8bf7\u67e5\u6536");//验证码已发送至您的邮箱，请查收
						return result;
					}else{
						result.put(Const.retCode,false);
						result.put(Const.retMsg,"\u53d1\u9001\u5931\u8d25");//发送失败
						return result;
					}
				}else{
					result.put(Const.retCode,false);
					result.put(Const.retMsg,"\u5df2\u53d1\u9001\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85\u0021");//已发送，请耐心等待!
					return result;
				}
			}else{
				flag = MailUtil.sendMail(userEmail, head, "findPassword.ftl", paramMap);
				if(flag){
					SessionUtils.putAttrInSession(request,"validateSendTime",System.currentTimeMillis());
					jedisUtil.setValue("validataCodeMsg"+userEmail,msg,60 * 10);
					result.put(Const.retCode,true);
					result.put(Const.retMsg,"\u9a8c\u8bc1\u7801\u5df2\u53d1\u9001\u81f3\u60a8\u7684\u90ae\u7bb1\uff0c\u8bf7\u67e5\u6536");//验证码已发送至您的邮箱，请查收
					return result;
				}else{
					result.put(Const.retCode,false);
					result.put(Const.retMsg,"\u53d1\u9001\u5931\u8d25");//发送失败
					return result;
				}
			}
		} catch (Exception e) {
			logger.error("sendEmail", e);
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u53d1\u9001\u90ae\u4ef6\u5931\u8d25");//发送邮件失败
		}
		return result;
	}
	
	/**
	 * 我的账户 - 更改用户邮箱
	 * @param oldEmail 原邮箱
	 * @param newEmail 新邮箱
	 * @param emailVer 邮箱验证码
	 * @return
	 */
	@RequestMapping("/updateEmail")
	@ResponseBody
	public Map<String, Object> updateEmail(HttpServletRequest request,
			@RequestParam(value = "oldEmail",required=false) String oldEmail,
			@RequestParam(value = "newEmail",required=true) String newEmail,
			@RequestParam(value = "emailVer",required=true) String emailVer,
			@RequestParam(value = "custNo",required = true)String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.updateEmail","oldEmail","newEmail","emailVer","custNo");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			custNo = jedisUtil.getValue(custNo);
			if(StringUtils.isEmpty(custNo)){
				result.put(Const.retCode, false);
				result.put(Const.retMsg, Const.noLoginMsg);// 参数不符合规范
				return result;
			}
			P2p_user user = userService.getByLoginCustNo(custNo);
			if(StringUtil.isNotEmpty(user.getPuMail())){
				if(!oldEmail.equals(user.getPuMail())){
					result.put(Const.retCode, false);
					result.put(Const.retMsg, "\u8bf7\u8f93\u5165\u6b63\u786e\u7684\u539f\u90ae\u7bb1\u5730\u5740");//请输入正确的原邮箱地址
					return result;
				}
			}
			String tempCode = jedisUtil.getValue("validataCodeMsg"+newEmail);
			if(StringUtils.isBlank(tempCode)){
			    result.put(Const.retCode, false);
                result.put(Const.retMsg, "\u90ae\u7bb1\u9a8c\u8bc1\u7801\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");//邮箱验证码超时，请重新获取
                return result;
			}
			if(!tempCode.equals(emailVer)){
				result.put(Const.retCode, false);
				result.put(Const.retMsg, "\u90ae\u7bb1\u9a8c\u8bc1\u7801\u9519\u8bef\u002c\u8bf7\u60a8\u91cd\u65b0\u8f93\u5165");//邮箱验证码错误,请您重新输入
				return result;
			}
			//更新用户邮箱（邮箱，邮箱绑定时间）
			result.put("mail", newEmail);
			result.put("custNo", user.getPuCustNo());
			result = userService.updateUserEmail(result);
			if((Boolean)result.get(Const.retCode)){
			    result.put(Const.retMsg, "\u4fdd\u5b58\u6210\u529f");//保存成功
            }
		} catch (Exception e) {
			logger.error("updateEmail", e);
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u66f4\u65b0\u5931\u8d25");//更新失败
		}
		return result;
	}
	
	/***我的账户 - 电子邮箱end*/
	
	/**
	 * 绑定银行卡
	 * @param request
	 * @return
	 * @author 鹿朋
	 */
	@RequestMapping(value = "/bankCardBindingAdvance",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> bankCardBindingAdvance(
			HttpServletRequest request,
	        @RequestParam("bankCode") String bankCode,
	        @RequestParam("bankCardNo") String bankCardNo,
	        @RequestParam("province") String province,
	        @RequestParam("city") String city,
	        @RequestParam("phoneNo") String phoneNo,
	        @RequestParam("custNo")String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.bankCardBindingAdvance","bankCode","bankCardNo","province","city","phoneNo","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            custNo = jedisUtil.getValue(custNo);
            if(StringUtils.isEmpty(custNo)){
                retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
                return retMap;
            }
            if(StringUtils.isEmpty(bankCode) || StringUtils.isEmpty(bankCardNo) || StringUtils.isEmpty(province) || StringUtils.isEmpty(city) || StringUtils.isEmpty(phoneNo)){
                retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
                return retMap;
            }
            result.put("bankCode", bankCode);
            result.put("bankCardNo", bankCardNo);
            result.put("province", province);
            result.put("city", city);
            result.put("cityid", AreaUtil.getCityCode(city));
            result.put("phoneNo", phoneNo);
            result.put("custNo", custNo);
            retMap = bankCardService.bankCardBinding(result);
            baseLog.writer(custNo,result.toString(),retMap.toString(),BusinessType.BINDBANKCARD.getDesc(), RegistType.APP.getName(), "/bankCardBindingAdvance");
        } catch (Exception e) {
            logger.error("\u64cd\u4f5c\u5f02\u5e38+接口名是appAccount/bankCardBinding",e );//操作异常
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, "\u7ed1\u5361\u5931\u8d25");//绑卡失败
            return retMap;
        }
        return retMap;
	    
	    
	    /**
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(validCode) || StringUtil.isEmpty(bankCardNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		try {
			//调用绑卡推进接口需要的参数
			Map<String, String> params=new HashMap<String, String>();
			params.put("valid_code", validCode);
			params.put("bankCardNo",bankCardNo);
			
			retMap = bankCardService.bankCardBindingAdvance(params);
		} catch (Exception e) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u7ed1\u5361\u5931\u8d25");//绑卡失败
			logger.error("\u7ed1\u5361\u5931\u8d25+接口名appAccount/bankCardBindingAdvance",e);//绑卡失败
			return retMap;
		}
		return retMap;
		**/
	}
	/**
	 * 刷新银行卡信息
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value="refreshCard",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object>refreshCard(HttpServletRequest request,String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.refreshCard","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		try {
			custNo = jedisUtil.getValue(custNo);
			if(StringUtils.isEmpty(custNo)){
                retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, Const.noLoginMsg);
                return retMap;
            }
			P2p_cust_account custAccount = custAccountService.queryIdentityId(custNo);
			if(custAccount==null){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
				return retMap;
			}
	        bankCardService.refreshCard(custAccount.getPcaAccountno(),custNo);
	        P2p_bank_card p2p_card = bankCardService.getBankCardByCustNo(custNo);
	        if(p2p_card!=null){
	        	p2p_card.setPbcBankcardno(StringUtil.replaceBankNoName(p2p_card.getPbcBankcardno()));
	        	p2p_card.setBankLogo(this.getBankLogoUrl(request, p2p_card.getPbcBankcode()));
	        }
	        retMap.put("bankCardInfo",p2p_card );
	        retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		} catch (Exception e) {
		    logger.error("app接口出错,接口名appAccount/refreshCard", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
		}
		return retMap;
	}
	/**
	 * 解绑银行卡校验
	 * @param request
	 * @param version (接口版本号  (接口版本号1对应app版本号 2.3)(接口版本号null对应app版本号 2.2))
	 * @return
	 * @author lupeng
	 */
	@RequestMapping(value="/unbinding",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> unbinding(HttpServletRequest request,String pwd,String custNo,String version){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		}
		if(StringUtil.isNotEmpty(version)){
			if("1".equals(version)){
				try {
					custNo = jedisUtil.getValue(custNo);
					if(StringUtils.isEmpty(custNo)){
		                retMap.put(Const.retCode, false);
		                retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
		                return retMap;
		            }
					baseLog.writer(custNo,"",retMap.toString(),BusinessType.BINDTHEBANKCARD.getDesc(), RegistType.APP.getName(), "/unbinding");
					P2p_cust_account account = custAccountService.queryIdentityId(custNo);
					P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
					if(null == bankCard){
						retMap.put(Const.retCode, false);
						retMap.put(Const.retMsg, "\u94f6\u884c\u5361\u4e0d\u5b58\u5728");//银行卡不存在
						return retMap;
					}
					Map<String, String> params=new HashMap<String, String>();
					if(null != account){
						params.put("identity_id", account.getPcaAccountno());//用户标识信息
					}else{
						retMap.put(Const.retCode, false);
						retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
						return retMap;
					}
					params.put("identity_type", Const.UID.toString());//用户标识类型
					params.put("card_id", bankCard.getPbccardId());//卡ID
					params.put("advance_flag", "Y");//是否推进
					if(null == bankCard.getPbcIssafecard() || "".equals(bankCard.getPbcIssafecard())){
						//retMap = unbindingbankCardNew(params,custNo,bankCard.getPbcBankcardno());
						retMap.put(Const.retCode, false);
						return retMap;
					}else{
						//非安全卡字段不为空，取值N或者Y
						if("N".equals(bankCard.getPbcIssafecard())){
							//如果为非安全卡可以解绑
							retMap = unbindingbankCardNew(params,custNo,bankCard.getPbcBankcardno());
						}else if("Y".equals(bankCard.getPbcIssafecard())){
							//为安全卡
							//如果账户余额大于0，不能解绑
							if(account.getPcaAccountBalance().compareTo(BigDecimal.ZERO) == 1){
								retMap.put(Const.retCode, false);
								retMap.put(Const.retMsg, "\u8bf7\u5148\u5c06\u8d26\u6237\u4f59\u989d\u63d0\u73b0\u518d\u89e3\u7ed1");//请先将账户余额提现再解绑
								return retMap;
							}else{
								retMap = unbindingbankCardNew(params,custNo,bankCard.getPbcBankcardno());
							}
						}
					}
				} catch (Exception e) {
					logger.error("\u89e3\u7ed1\u51fa\u9519,接口名appAccount/unbinding",e);//解绑出错
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u89e3\u7ed1\u51fa\u9519");//解绑出错
					return retMap;
				}
			}
		}else{
			try {
				custNo = jedisUtil.getValue(custNo);
				if(StringUtils.isEmpty(custNo)){
	                retMap.put(Const.retCode, false);
	                retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
	                return retMap;
	            }
				retMap.put("password", pwd);
				retMap.put("custNo", custNo);
				retMap = custAccountService.inspectTransPassword(retMap);
				baseLog.writer(custNo,"",retMap.toString(),BusinessType.BINDTHEBANKCARD.getDesc(), RegistType.APP.getName(), "/unbinding");
				if(!(Boolean)retMap.get(Const.retCode)){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg,retMap.get(Const.retMsg));//交易密码错误
					return retMap;
				}
				P2p_cust_account account = custAccountService.queryIdentityId(custNo);
				P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
				if(null == bankCard){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u94f6\u884c\u5361\u4e0d\u5b58\u5728");//银行卡不存在
					return retMap;
				}
				Map<String, String> params=new HashMap<String, String>();
				if(null != account){
					params.put("identity_id", account.getPcaAccountno());//用户标识信息
				}
				params.put("identity_type", Const.UID.toString());//用户标识类型
				params.put("card_id", bankCard.getPbccardId());//卡ID
				if(null == bankCard.getPbcIssafecard() || "".equals(bankCard.getPbcIssafecard())){
					//retMap = unbindingbankCard(params,custNo);
					retMap.put(Const.retCode, false);
					return retMap;
				}else{
					//非安全卡字段不为空，取值N或者Y
					if("N".equals(bankCard.getPbcIssafecard())){
						//如果为非安全卡可以解绑
						retMap = unbindingbankCard(params,custNo);
					}else if("Y".equals(bankCard.getPbcIssafecard())){
						//为安全卡
						//如果账户余额大于0，不能解绑
						if(account.getPcaAccountBalance().compareTo(BigDecimal.ZERO) == 1){
							retMap.put(Const.retCode, false);
							retMap.put(Const.retMsg, "\u8bf7\u5148\u5c06\u8d26\u6237\u4f59\u989d\u63d0\u73b0\u518d\u89e3\u7ed1");//请先将账户余额提现再解绑
							return retMap;
						}else{
							retMap = unbindingbankCard(params,custNo);
						}
					}
				}
			} catch (Exception e) {
				logger.error("\u89e3\u7ed1\u51fa\u9519,接口名appAccount/unbinding",e);//解绑出错
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u89e3\u7ed1\u51fa\u9519");//解绑出错
				return retMap;
			}
		}
		return retMap;
	}
	
	
	/**
	 * 解绑操作
	 * @param request
	 * @return
	 * @author liuchangyan
	 */
	public Map<String, Object> unbindingbankCard(Map<String, String> params,
			String custNo){
		Map<String, Object> map = new HashMap<String, Object>();
		map = bankCardService.unbindingbankCard(params,custNo);
		return map;
	}
	/**
	 * 解绑操作(带有推进功能)
	 * @param request
	 * @return
	 * @author 
	 */
	public Map<String, Object> unbindingbankCardNew(Map<String, String> params,
			String custNo,String cardNo){
		Map<String, Object> map = new HashMap<String, Object>();
		map = bankCardService.unbindingbankCardNew(params,custNo,cardNo);
		return map;
	}
	/**
	 * 解绑推进操作
	 * @param request
	 * @return
	 * @author lupeng
	 */
	@RequestMapping("/unbindingAdvance")
	@ResponseBody
	public Map<String, Object> unbindingbankCardAdvance(
			@RequestParam("validCode") String validCode,
			@RequestParam("custNo") String custNo){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			custNo = jedisUtil.getValue(custNo);
			if(StringUtils.isEmpty(custNo)){
			    map.put(Const.retCode, false);
			    map.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
                return map;
            }
			P2p_cust_account account = custAccountService.queryIdentityId(custNo);
			P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
			if(bankCard==null||account==null){
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "\u89e3\u7ed1\u5361\u5931\u8d25");//解绑卡失败
				return map;
			}
			//调用绑卡推进接口需要的参数
			Map<String, String> params=new HashMap<String, String>();
			params.put("identity_id", account.getPcaAccountno());//用户标识信息
			params.put("identity_type", Const.UID);//用户标识类型
			params.put("valid_code", validCode);
			map = bankCardService.unbindingbankCardAdvance(params,custNo,bankCard.getPbcBankcardno());
		} catch (Exception e) {
			logger.error("\u89e3\u7ed1\u51fa\u9519,接口名appAccount/unbindingAdvance",e);//解绑出错
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u89e3\u7ed1\u51fa\u9519");//解绑出错
			return map;
			
		}
		
		return map;
	}
	
	/**
	 * 校验交易密码是否正确
	 * @param request
	 * @return
	 * @author lupeng
	 */
	
	@RequestMapping(value = "/verifyTradePwd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> verifyTradePwd(HttpServletRequest request,@RequestParam("pwd") String pwd,@RequestParam("custNo") String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.findAccount","custNo","pwd");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		if(StringUtil.isEmpty(pwd)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
		}
		try {
			retMap.put("password", pwd);
			retMap.put("custNo", custNo);
			retMap = custAccountService.inspectTransPassword(retMap);
		} catch (Exception e) {
			logger.error("\u6821\u9a8c\u4ea4\u6613\u5bc6\u7801\u51fa\u9519"+"接口名称appAccount/verifyTradePwd",e);//校验交易密码出错
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u6821\u9a8c\u4ea4\u6613\u5bc6\u7801\u51fa\u9519！");//校验交易密码出错
			return retMap;
		}
		return retMap;
	}
	
	/**
	 * 我的账户
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value = "safecenter", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>safecenter(HttpServletRequest request,String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.safecenter","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		}
		try {
			P2p_user user = userService.getByLoginCustNo(custNo);
			if(user==null){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
				return retMap;
			}
			String phone = user.getPuMobile();
			phone=phone.substring(0,3)+"****"+phone.substring(7, 11);
			retMap.put("phone", phone);
			
			String headUrl = user.getPuHeadUrl();
			if(StringUtil.isEmpty(headUrl)){
				retMap.put("headUrl","");
			}else{
				retMap.put("headUrl", this.getUserHeadUrl(request, user.getPuHeadUrl()));
			}
			//验证邮箱
			String isSetEmail = "1";
			if(StringUtil.isNotEmpty(user.getPuMail())){
				isSetEmail = "0";//已设置
				retMap.put("mail",user.getPuMail());
			}
			retMap.put("isSetEmail", isSetEmail);
			//是否设置交易密码
			P2p_cust_account custAccount = accountService.getCustAccountByCustNo(custNo,false);
			String transactionPassword = "1";    
			if(!StringUtil.isEmpty(custAccount.getPcaPayPassword())){
				transactionPassword = "0";
			}
			retMap.put("transactionPassword",transactionPassword );
			//是否实名认证
			P2p_user_info info = userInfoService.getByCustNo(custNo);
			if(null!=info){
				retMap.put("isCert", info.getPuiPlataccountiscert());
			}else{
				retMap.put("isCert","1");
			}
			//获取银行卡名称和简称
			//List<Map<String, Object>> list = getBankInfo();
			//retMap.put("bankTypeList",list);  //银行卡列表
			P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
			if(null != bankCard && "01".equals(bankCard.getPbcIfadvance())){
//				String bankCardName = bankCard.getPbcBankcardname();
//				if(!StringUtil.isEmpty(bankCardName)){
//					String name = "**" + bankCardName.substring(bankCardName.length()-1);
//					retMap.put("hiddenCardName",name); //持卡人姓名
//				}
//				String bankCardNo= bankCard.getPbcBankcardno();
//				String hiddenBankCardNo =  bankCardNo.substring(bankCardNo.length()-4);
//				retMap.put("bankurl", Const.basePath+"/images/banklogo/"+bankCard.getPbcBankcode()+".png");
//				retMap.put("hiddenCardno",hiddenBankCardNo); //银行卡号
				//已绑卡
				retMap.put("hasBankCard",true);
//				String retphone = bankCard.getPbcPhoneNo();
//				retphone=retphone.substring(0,3)+"****"+retphone.substring(7, 11);
//				retMap.put("phone", retphone);
			}else{
				//未绑卡
				retMap.put("hasBankCard",false);
			}
		} catch (Exception e) {
			logger.error("app安全中心出错,接口名appAccount/safecenter", e);
			retMap.put(Const.retCode,false );
			retMap.put(Const.retMsg,"\u67e5\u8be2\u5931\u8d25" );//查询失败
			e.printStackTrace();
			return retMap;
		}
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
		
	}
	public List<P2p_bank_type> getBankInfo(HttpServletRequest request){
		List<P2p_bank_type> list = new ArrayList<P2p_bank_type>() ;
		for(P2p_bank_type bankType : bankTypeDao.getPersonalEbank()){
			if(bankType.getSupportQuickPay()){
				bankType.setBankLogo(this.getBankLogoUrl(request, bankType.getBankCode()));
				list.add(bankType);
			}
		}
		return list;
	}
	
	/**
	 * 资金管理----------->>>充值页面
	 * @param request
	 * @param custNo
	 * @return
	 */
	@RequestMapping(value="/toRechargeApp",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> toRecharge(HttpServletRequest request,String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.toRechargeApp","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		}
		P2p_user user = userService.getByLoginCustNo(custNo);
		if(user==null){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
			return retMap;
		}
		Map<String, Object> result = accountFlowService.toRecharge(custNo, user.getPuMobile());
		if(result.isEmpty()){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
			return retMap;
		}
		Object userInfo = result.get("info");
		if(userInfo!=null){
		    boolean hasBankCard = false;
	        if(result.get("bankCard")!=null){
	            hasBankCard = true;
	        }
	        P2p_bank_card bankCard = (P2p_bank_card)result.get("bankCard");
            if(bankCard!=null){
                String bankCardName = bankCard.getPbcBankcardname();
                if(!StringUtil.isEmpty(bankCardName)){
                    String name = "**" + bankCardName.substring(bankCardName.length()-1);
                    bankCard.setPbcBankcardname(name);
                }
                String bankcardno = bankCard.getPbcBankcardno();
                bankCard.setPbcBankcardno(bankcardno.substring(bankcardno.length()-4));
                P2p_bank_type bank =  bankTypeDao.getBankType(bankCard.getPbcBankcode());
                if(bank!=null){
                	StringBuilder sb = new StringBuilder();
                	sb.append("单笔限额");
                	NumberFormat numberFormat1 = NumberFormat.getNumberInstance();
                	sb.append(numberFormat1.format(bank.getSingleLimit()));
                	sb.append("元,");
                	sb.append("单日限额");
                	sb.append(numberFormat1.format(bank.getSingleDayLimit()));
                	sb.append("元");
                	retMap.put("unionPayRechargeLimit", sb.toString());
                	retMap.put("banklogo", this.getBankLogoUrl(request, bankCard.getPbcBankcode()));
                }else{
                	retMap.put("unionPayRechargeLimit", "");
                	retMap.put("banklogo", "");
                }
            }
            //获取银行卡名称和简称
            List<P2p_bank_type> list = getBankInfo(request);
            retMap.put("bankTypeList",list);  //银行卡列表
            retMap.put("bankCard", bankCard);
	        retMap.put("isCert","0" );
	        retMap.put("hasBankCard", hasBankCard);
	        retMap.put("balance", result.get("balance"));
	        retMap.put(Const.retCode, true);
            retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
		}else{
		    retMap.put("isCert","1" );
		    retMap.put(Const.retCode, true);
            retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
		}
		
		return retMap;
		
		/**
		try {
			//检查是否进行实名认证
			P2p_user_info info = userInfoService.getByCustNo(custNo);
			if(null!=info && info.getPuiPlataccountiscert().equals("0")){
				retMap.put("isCert","0" );
				P2p_cust_account account = accountService.getCustAccountByCustNo(custNo,true);
				//检查是否绑定银行卡
				P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
				if(bankCard!=null && "01".equals(bankCard.getPbcIfadvance())){
					String retphone = bankCard.getPbcPhoneNo();
					retphone=retphone.substring(0,3)+"****"+retphone.substring(7, 11);
					retMap.put("phone", retphone);
					retMap.put("hasBankCard", true);
					retMap.put("bankType",bankTypeDao.getBankType(bankCard.getPbcBankcode()));
					String bankCardName = bankCard.getPbcBankcardname();
					if(!StringUtil.isEmpty(bankCardName)){
						String name = "**" + bankCardName.substring(bankCardName.length()-1);
						retMap.put("hiddenCardName",name); //持卡人姓名
					}
					String bankCardNo= bankCard.getPbcBankcardno();
					String hiddenBankCardNo =  bankCardNo.substring(bankCardNo.length()-4);	
					retMap.put("bankurl", Const.basePath+"/images/banklogo/"+bankCard.getPbcBankcode()+".png");
					retMap.put("hiddenCardno",hiddenBankCardNo); //银行卡号
					for(P2p_bank_type banktype: bankTypeDao.getAll()){
						if ((banktype.getBankCode()).equals(bankCard.getPbcBankcode()))
						{
							retMap.put("bankDesc", banktype.getBankDesc());//银行名称
							retMap.put("singleLimit",banktype.getSingleLimit());//单笔限额
							retMap.put("singleDayLimit", banktype.getSingleDayLimit());//单日限额
							retMap.put("singleMinimum", banktype.getSingleMinimum());//单笔最低限额
						}
					}
				}else{
					retMap.put("hasBankCard", false);
				}
				// 可用余额
				retMap.put("balance", account.getPcaAccountBalance());
				//是否设置交易密码
				if(!StringUtil.isEmpty(account.getPcaPayPassword())){
					retMap.put("transactionPassword", 0);//已设置交易密码
				}else{
					retMap.put("transactionPassword", 1);//未设置交易密码
				}
				//获取银行卡名称和简称
				List<Map<String, Object>> list = getBankInfo();
				retMap.put("bankTypeList",list);  //银行卡列表
				retMap.put(Const.retCode, true);
				retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
			}else{
				retMap.put(Const.retCode, true);
				retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
				retMap.put("isCert","1" );
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("跳转充值页面出错,接口名appAccount/toRechargeApp", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg,"\u7cfb\u7edf\u9519\u8bef");//系统错误
			return retMap;
		}
		retMap.put("unionPayRechargeLimit", "单笔限额2000元,单日限额5000元");//银联充值限额
		return retMap;
		**/
	}
	
	private String getBankLogoUrl(HttpServletRequest request, String backCode){
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        return basePath + "/images/banklogo/" + backCode + ".png";
    }
	
	/**
	 * 充值 - 绑定支付
	 * @param amount
	 * @param transChannel
	 * @return
	 */
	@RequestMapping(value = "/bindingRecharge", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> bindingRecharge(String amount,String payPassword,String custNo, HttpServletRequest request) {
		AppCallLogUtil.printMsg(request, "appAccount.bindingRecharge","custNo","amount","payPassword");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		if(StringUtil.isEmpty(amount)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return retMap;
		}
		String path = request.getContextPath();
		String notifyUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/service/fuiou/apppaynotify.do";
//		String notifyUrl = "http://192.168.1.245:8080/service/fuiou/apppaynotify.do";
		Map<String, Object> result = accountService.onlineBankPayment(custNo, amount, null,
                RegistType.APP.getIndex(), Const.onlineBankingRecharge, notifyUrl);

		baseLog.writer(custNo, "", "", BusinessType.CYBERBANKRECHARGE.getDesc(),
                 RegistType.APP.getName(), "/account/bindingRecharge");
		return result;
		
		/**
		retMap.put("amount", amount);
		//retMap.put("payPassword", payPassword);
		retMap.put("custNo", custNo);
		retMap.put("registType", RegistType.APP.getIndex());
		retMap.put("rechargeType", Const.bindingRecharge);
		try {
			retMap = accountService.bindingPayment(retMap);
			baseLog.writer(custNo,"",retMap.toString(),BusinessType.SHORTCUTRECHARGE.getDesc(), RegistType.APP.getName(), "/bindingRecharge");	
		} catch (BusinessException e) {
			logger.error("App绑卡支付失败,接口名appAccount/bindingRecharge", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u5145\u503c\u5931\u8d25");//充值失败
			e.printStackTrace();
			return retMap;
		}
		return retMap;
		**/
	}
	/**
	 * 充值 - 绑定支付推进
	 * @param validateCode
	 * @return
	 */
	@RequestMapping(value = "/advanceHostingPay" , method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> advanceHostingPay(HttpServletRequest request,String validateCode,String transFlowNo,String custNo,String amount){
		AppCallLogUtil.printMsg(request, "appAccount.advanceHostingPay","validateCode","transFlowNo","custNo","amount");
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		if(StringUtil.isEmpty(validateCode)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return retMap;
		}
		try {
			result.put("amount", amount);
			result.put("custNo", custNo);
			result.put("registType", RegistType.APP.getIndex());
			result.put("rechargeType", Const.bindingRecharge);
			result.put("validateCode", validateCode);
			result.put("transFlowNo", transFlowNo);
			retMap = accountService.advanceHostingPay(result);
			baseLog.writer(custNo,result.toString(),retMap.toString(),BusinessType.SHORTCUTRECHARGEADVANCE.getDesc(), RegistType.APP.getName(), "/advanceHostingPay");
		} catch (Exception e) {
			logger.error("App绑卡支付推进失败,接口名appAccount/advanceHostingPay", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u5145\u503c\u5931\u8d25");//充值失败
			e.printStackTrace();
			return retMap;
		}
		return retMap;
	}
	/**
	 * 手机银联充值
	 * @param bankCode
	 * @param amount
	 * @return
	 */
	@RequestMapping("/appOnlineBankRecharge")
	public String appOnlinePaymentPhone(
		HttpServletRequest request, String amount, String custNo,
		String notifyUrl)
			throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		
		if (StringUtil.isEmpty(amount) || StringUtil.isEmpty(custNo))
		{
			return "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303";
		}
		
		try
		{
			String bankCode = "UPOP";//银联在线支付
			
			result = accountService.onlineBankPayment(
				custNo, amount, bankCode,RegistType.APP.getIndex(),
				Const.onlineBankingRecharge, notifyUrl);
			
			baseLog.writer(custNo, "", "",
				BusinessType.CYBERBANKRECHARGE.getDesc(),
				RegistType.APP.getName(),
				"/appAccount/appOnlineBankRecharge");
		} catch(Exception e)
		{
			e.printStackTrace();
			logger.error("appOnlinePaymentPhone", e);
		}

		request.setAttribute("result", result);
		return "/personal/jump";
	}
	/**
	 * 提现页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/towithdrawals", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> toWithDrawals(HttpServletRequest request,HttpServletResponse response,String custNo){
		AppCallLogUtil.printMsg(request, "appAccount.towithdrawals","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);// 参数不符合规范
			return retMap;
		}
		
		P2p_user user = userService.getByLoginCustNo(custNo);
		if(user==null){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
			return retMap;
		}
		Map<String, Object> result = accountFlowService.toWithDrawals(user.getPuCustNo(), user.getPuMobile());
		if(result.isEmpty()){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
			return retMap;
		}
		String iscert = (String)result.get("puiPlataccountiscert");
		if(Const.NOTCERTIFIED.equals(iscert)){
		    // 未认证用户
		    retMap.put("isCert","1" );
            retMap.put(Const.retCode, true);
            retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
		}else{
		    // 已认证用户
		    boolean hasBankCard = false;
            if(result.get("banCard")!=null){
                hasBankCard = true;
            }
            retMap.put("isCert","0" );
            retMap.put("hasBankCard", hasBankCard);
            P2p_bank_card bankCard = (P2p_bank_card)result.get("banCard");
            if(bankCard!=null){
                String bankCardName = bankCard.getPbcBankcardname();
                if(!StringUtil.isEmpty(bankCardName)){
                    String name = "**" + bankCardName.substring(bankCardName.length()-1);
                    bankCard.setPbcBankcardname(name);
                }
                String bankcardno = bankCard.getPbcBankcardno();
                bankCard.setPbcBankcardno(bankcardno.substring(bankcardno.length()-4));
                retMap.put("banklogo", this.getBankLogoUrl(request, bankCard.getPbcBankcode()));
            }else{
            	//获取银行卡名称和简称
                List<P2p_bank_type> list = getBankInfo(request);
                retMap.put("personalEbank",list);  //银行卡列表
            	retMap.put("banklogo", this.getBankLogoUrl(request, ""));
            }
            retMap.put("bankCard", bankCard);
            retMap.put("balance", result.get("balance")==null ? 0 : result.get("balance"));
            int transactionPassword = 1;
            if(result.get("isSetPcaPayPassword")!=null){
            	if((int)result.get("isSetPcaPayPassword")==1){
                    transactionPassword = 0;
                }
            }
            retMap.put("transactionPassword", transactionPassword);
            retMap.put(Const.retCode, true);
            retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
		}
		return retMap;
		
		/**
		try {
			
			P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
			if(bankCard == null || StringUtil.isEmpty(bankCard.getPbcIfadvance())
					|| bankCard.getPbcIfadvance().equals("00")){
				retMap.put("hasBankCard",false );
			}else{
				String bankCardName = bankCard.getPbcBankcardname();
				if(!StringUtil.isEmpty(bankCardName)){
					String name = "**" + bankCardName.substring(bankCardName.length()-1);
					retMap.put("hiddenCardName",name); //持卡人姓名
				}
				String bankCardNo= bankCard.getPbcBankcardno();
				String hiddenBankCardNo =  bankCardNo.substring(bankCardNo.length()-4);
				retMap.put("bankurl", Const.basePath+"/images/banklogo/"+bankCard.getPbcBankcode()+".png");
				retMap.put("hiddenCardno",hiddenBankCardNo); //银行卡号
				for(P2p_bank_type banktype: bankTypeDao.getAll())
				{
					if ((banktype.getBankCode()).equals(bankCard.getPbcBankcode()))
					{
						retMap.put("bankDesc", banktype.getBankDesc());//银行名称
						retMap.put("singleLimit",banktype.getSingleLimit());//单笔限额
						retMap.put("singleDayLimit", banktype.getSingleDayLimit());//单日限额
						retMap.put("singleMinimum", banktype.getSingleMinimum());//单笔最低限额
					}
				}
				retMap.put("hasBankCard",true );
				P2p_cust_account account = accountService.getCustAccountByCustNo(custNo,true);
				// 可用余额
				retMap.put("balance", account.getPcaAccountBalance());
				//是否设置交易密码
				if(!StringUtil.isEmpty(account.getPcaPayPassword())){
					retMap.put("transactionPassword", 1);//已设置交易密码
				}else{
					retMap.put("transactionPassword", 0);//未设置交易密码
				}
			}
		} catch (Exception e) {
			logger.error("提现页面出错 接口名appAccount/towithdrawals", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u63d0\u73b0\u5931\u8d25");//提现失败
			e.printStackTrace();
			return retMap;
		}
		return retMap;
		**/
	}
	/**
	 * 申请提现
	 * @param transChannel
	 * @param amount
	 * @return
	 */
	@RequestMapping(value="/createHostingWithDraw",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> hostingWithDraw( String amount,String payPassword,String custNo, HttpServletRequest request){
		AppCallLogUtil.printMsg(request, "appAccount.createHostingWithDraw","custNo","amount","payPassword");
	    Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> parameter = new HashMap<String, Object>();
        
		custNo = jedisUtil.getValue(custNo);
		if(StringUtils.isEmpty(custNo)){
		    result.put(Const.retCode, false);
		    result.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return result;
        }
		
		if (StringUtil.isEmpty(amount) || StringUtil.isEmpty(payPassword))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
            return result;
        }

        if (new BigDecimal(amount).compareTo(new BigDecimal(50)) < 0)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u6700\u5c0f\u63d0\u73b0\u91d1\u989d\u4e3a\u0035\u0030\u5143\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");// 最小提现金额为50元，请重新输入
            return result;
        }
        
        try
        {
            String path = request.getContextPath();
            String notifyUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/service/fuiou/appwithdrawnotify.do";
            
            parameter.put("amount", amount);
            parameter.put("payPassword", payPassword);
            parameter.put("custNo", custNo);
            parameter.put("registType", RegistType.APP.getIndex());
            parameter.put("notifyUrl", notifyUrl);

            result = accountService.createHostingWithDraw(parameter);
        } catch (Exception e)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u63d0\u73b0\u5931\u8d25");// 提现失败
            logger.error("createHostingWithDraw", e);
        }

        baseLog.writer(custNo, parameter.toString(), result.toString(), BusinessType.WITHDRAWDEPOSIT.getDesc(),
                RegistType.APP.getName(), "/account/createHostingWithDraw");

        return result;
		
		/**
		try {
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("amount", amount);
			parameter.put("payPassword", payPassword);
			parameter.put("custNo", custNo);
			parameter.put("registType", RegistType.APP.getIndex());
			retMap = accountService.createHostingWithDraw(parameter);
			baseLog.writer(custNo,parameter.toString(),retMap.toString(),BusinessType.WITHDRAWDEPOSIT.getDesc(), RegistType.APP.getName(), "/createHostingWithDraw");
		} catch (Exception e) {
			logger.error("提现出错,接口名字appAccount/createHostingWithDraw", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u63d0\u73b0\u5931\u8d25");//提现失败
			e.printStackTrace();
			return retMap;
		}
		return retMap;
		**/
	}
	
	/**
     * 修改银行卡
     * @param transChannel
     * @param amount
     * @return
     */
    @RequestMapping(value="/changeCard",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> changeCard(String custNo, HttpServletRequest request){
    	AppCallLogUtil.printMsg(request, "appAccount.changeCard","custNo");
        Map<String, Object> result = new HashMap<String, Object>();
        
        custNo = jedisUtil.getValue(custNo);
        if(StringUtil.isEmpty(custNo)){
            result.put(Const.retCode, false);
            result.put(Const.retMsg, Const.noLoginMsg);// 参数不符合规范
            return result;
        }
        
        try
        {
            String path = request.getContextPath();
            String notifyUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/service/fuiou/appchangecardnotify.do";
            result = accountService.changeCard(custNo, notifyUrl, RegistType.APP);
        }
        catch (Exception e)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u4fee\u6539\u94f6\u884c\u5361\u5931\u8d25"); // 修改银行卡失败
            logger.error("changeCard", e);
        }
        
        baseLog.writer(custNo, "", result.toString(), BusinessType.BINDBANKCARD.getDesc(),
                RegistType.APP.getName(), "/account/changeCard");

        return result;
    }
}
