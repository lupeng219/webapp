package com.baibao.web.p2p.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.core.exception.BusinessException;
import com.baibao.pay.PayService;
import com.baibao.pay.data.AccountInfoRequest;
import com.baibao.pay.data.PayResponse;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dataDIC.CustAccountStatus;
import com.baibao.web.p2p.repository.BankCardRepository;
import com.baibao.web.p2p.repository.CustAccountRepository;
import com.baibao.web.p2p.repository.UserInfoRepository;
import com.baibao.web.p2p.service.CustAccountService;
import com.baibao.web.p2p.utils.IDCardVerify;

@Service("custAccountService")
public class CustAccountServiceImpl
	implements CustAccountService
{

	private static final Logger logger = LoggerFactory
            .getLogger(CustAccountServiceImpl.class);
            
	@Autowired
	private CustAccountRepository custAccountRepository;
	@Autowired
	private UserInfoRepository userInfoRepository;
//	@Autowired
//	private UsersRepository usersRepository;
//	@Autowired
//	private BaseLog baseLog;
	@Autowired
	private PayService payService;
	@Autowired 
	private BankCardRepository bankCardRepository;

//	@Autowired
//	private UMPayQueryBase uMPayQueryBase;
	
	@Override
	@Transactional(readOnly = false,rollbackFor=Exception.class)
	public Map<String, Object> updateTransPassword(Map<String, Object> map) throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		int i = custAccountRepository.updateTransPassword(map);
		if(i > 0){
			result.put(Const.retCode, true);
			result.put(Const.retMsg, "\u8bbe\u7f6e\u6210\u529f");// 设置成功
		}else{
			result.put(Const.retMsg, "\u8bbe\u7f6e\u5931\u8d25");// 设置失败
			result.put(Const.retCode, false);
		}
		return result;
	}

	@Override
	public P2p_cust_account queryIdentityId(String custNo) {
		P2p_cust_account account = custAccountRepository.queryIdentityId(custNo);
		return account;
	}

	@Override
	@Transactional(readOnly = false,rollbackFor=BusinessException.class)
	public Map<String, Object> certificationOperation(
		Map<String, String> certMap,String custNo)
			throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		P2p_cust_account account = custAccountRepository.queryIdentityId(custNo);
		
		if (account == null)
		{
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "没有该账户系统错误");//没有该账户系统错误
			return result;
		}
		
		String realName = certMap.get("real_name");
		String certNo = certMap.get("cert_no").toUpperCase();
		
		//检查用户是否实名认证
		int attestation =
			userInfoRepository.getRealNameAuthentication(realName, certNo, custNo);
		if (attestation == 1)
		{
			//实名认证信息已绑定其他账户
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "您输入的身份信息已存在,请您重新输入");
			return result;
		}
		
		if (IDCardVerify.Age(certNo) < 18)
		{
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "本网站只接受18周岁以上的具有完全民事行为能力的自然人成为网站用户。");
			return result;
		}
		
		//检查用户是否绑卡
		P2p_bank_card  p2p_bank_card =  bankCardRepository.getBankCardByCustNo(custNo);
		if(p2p_bank_card != null)
		{
		    //已经绑定银行卡后不可再修改实名认证
		    result.put(Const.retCode, false);
		    result.put(Const.retMsg,"绑定银行卡后不可再修改实名认证");
		    return result;
		}
					
		P2p_user_info userInfo = userInfoRepository.getUserInfo(custNo);
		//设置性别和年龄
		userInfo = setSexAndBir(certNo,userInfo);
		if (userInfo != null)
		{
			userInfo.setPuiRealName(realName);
			userInfo.setPuiCertNo(certNo);
			userInfo.setPuiCertType(Const.IC);
			userInfo.setPuiCustno(custNo);
			userInfoRepository.updataUserInfo(userInfo);
		} else
		{
			logger.error("\u7528\u6237\u8be6\u7ec6\u4fe1\u606f\u4e3a\u7a7a");//用户详细信息为空
		}
		
		certMap.put("identity_type", Const.UID);
		certMap.put("cert_type", Const.IC);
		certMap.put("identity_id", account.getPcaAccountno());
		certMap.put("request_time",
			new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		
		logger.info("\u8c03\u7528\u5b9e\u540d\u8ba4\u8bc1\u63a5\u53e3\u5f00\u59cb" + account.getPcaAccountno());//调用实名认证接口开始

		userInfo.setPuiPlataccountiscert(Const.ALREADYCERTIFIED);//认证成功
		userInfoRepository.updataUserInfo(userInfo);

		result.put(Const.retCode, true);
		result.put(Const.retMsg, "\u5b9e\u540d\u8ba4\u8bc1\u6210\u529f");//实名认证成功

		result.put("certMap", certMap);//存入baselog中
		result.put("map", certMap);//存入baselog中

		return result;
	}
	
	
	public P2p_user_info setSexAndBir(String idCard,P2p_user_info baseInfo){
		Integer length=idCard.length();
		Integer year = null;
		Integer month = null;
	    Integer day = null;
		Integer gender = null;
		String birthday=null;
		String monthStr=null;
		String dayStr=null;
		String age=null;
		if(length==15){
			year=Integer.parseInt("19"+idCard.substring(6,8));
			month=Integer.parseInt(idCard.substring(8, 10));
			day=Integer.parseInt(idCard.substring(10, 12));
			gender=Integer.parseInt(idCard.substring(14, 15));
		}else if(length==18){
			year=Integer.parseInt(idCard.substring(6,10));
			month=Integer.parseInt(idCard.substring(10,12));
			day=Integer.parseInt(idCard.substring(12,14));
			gender=Integer.parseInt(idCard.substring(16,17));
		}
		if(month<10){
			monthStr="0"+month;
		}else{
			monthStr=""+month;
		};
		if(day<10){
			dayStr="0"+day;
		}else{
			dayStr=""+day;
		};
		birthday=year+"-"+monthStr+"-"+dayStr;
		if(gender%2==0){
			baseInfo.setPuiSex("2");//女
		}else{
			baseInfo.setPuiSex("1");//男
		};
		baseInfo.setPuiBirthday(birthday);//生日
		age=""+(Calendar.getInstance().get(Calendar.YEAR) - year);
		baseInfo.setPuiAge(age);//年龄
		return baseInfo;
	}

	@Override
	public Map<String, Object> inspectTransPassword(Map<String, Object> map)
			throws BusinessException {
		Map<String, Object> result = new HashMap<String, Object>();
		String password = map.get("password").toString();
		String custNo = map.get("custNo").toString();
		//根据用户编号查询账户信息
		P2p_cust_account account = custAccountRepository.queryIdentityId(custNo);
		if(null != account){
			if(null != account.getPcaPayPassword() && !"".equals(account.getPcaPayPassword())){
				if(password.equals(account.getPcaPayPassword())){
					result.put(Const.retCode, true);
					result.put(Const.retMsg, "\u4ea4\u6613\u5bc6\u7801\u6b63\u786e");//交易密码正确
				}else{
					result.put(Const.retCode, false);
					result.put(Const.retMsg, "\u4ea4\u6613\u5bc6\u7801\u9519\u8bef");//交易密码错误
				}
			}else{
				result.put(Const.retCode, false);
				result.put(Const.retMsg, "\u672a\u8bbe\u7f6e\u4ea4\u6613\u5bc6\u7801");//未设置交易密码
			}
		}else{
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u8d26\u6237\u4fe1\u606f\u4e0d\u5b58\u5728");//账户信息不存在
		}
		return result;
	}

	@Override
	public Map<String, Object> activateNemberOrBindingVerify(String custNo)
		throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		result.put(Const.retCode, true);
		
		P2p_cust_account account = custAccountRepository.queryIdentityId(custNo);
		if (account == null)
		{
			result.put(Const.retCode, false);
			return result;
		}
		
		//验证是否激活会员
		if (account.getPcaStatus().equals(
				CustAccountStatus.NOTACTIVATED.getIndex()))
		{
			//激活会员
			/*Map<String, String> userParams = new HashMap<String, String>();
			
			userParams.put("identity_id", custNo);
			userParams.put("identity_type", Const.UID);
			
			//result = activeMemberHandler.handle(userParams);
			result = payService.activeMember(userParams);
			
			if (result.get(Const.retCode).toString()
					.equals(ControllerRetType.OPT_SUCC.getTransCode()) ||
				result.get("response_code")
					.equals(sinaResponseCode.DUPLICATE_IDENTITY_ID.getIndex()))
			{
				result.clear();
				int custAccountCount = usersRepository.updateCustAccount(custNo);
				if (custAccountCount > 0)
				{
					result = BindingVerify(custNo);
				} else
				{
					logger.error("\u66f4\u65b0\u8d26\u6237\u4f7f\u7528\u72b6\u6001\u51fa\u9519");//更新账户使用状态出错
					result.put(Const.retCode, false);
					return result;
				}
			} else
			{
				result.put("userParams", userParams);//存入baselog中
				result.put(Const.retCode, false);
				
				return result;
			}*/
		} 
		else if (StringUtils.isNotBlank(account.getPcaAccountno()))
		{
			AccountInfoRequest request = new AccountInfoRequest();

			request.setAccountId(account.getPcaAccountno());
			
			PayResponse response = payService.getAccountInfo(request);
			
			if (response.getStatus() != PayResponse.OK)
			{
				result.put(Const.retCode, false);
				result.put(Const.retMsg, response.getMessage());
			}

			//检查是否绑定认证
			/*Map<String, String> custParams = new HashMap<String, String>();
			custParams.put("identity_id", custNo);
			custParams.put("identity_type", Const.UID);
			custParams.put("verify_type", Const.MOBILE);
			
			//result = queryVerifyHandler.handle(custParams);
			result = payService.query_verify(custParams);
			
			if (!result.get(Const.retCode).toString()
					.equals(ControllerRetType.OPT_SUCC.getTransCode())){
				result.clear();
				result = BindingVerify(custNo);
			} else
			{
				result.put(Const.retCode, true);
				return result;
			}*/
		}
		return result;
	}
	
	/*public Map<String, Object> BindingVerify(String custNo){
		Map<String, Object> result = new HashMap<String, Object>();
		P2p_user users = usersRepository.findUserByCustNo(custNo);
		if(users ==null){
			result.put(Const.retCode, false);
			return result;
		}
		Map<String, String> bindingParams = new HashMap<String, String>();
		bindingParams.put("identity_id", custNo);
		bindingParams.put("identity_type", Const.UID);
		bindingParams.put("verify_type", Const.MOBILE);
		bindingParams.put("verify_entity", users.getPuMobile());
		
		//result = bindVerifyHandler.handle(bindingParams);
		result = payService.binding_verify(bindingParams);
		
		if ( result.get(Const.retCode).toString().equals(ControllerRetType.OPT_SUCC.getTransCode()) || result.get("response_code").equals(sinaResponseCode.DUPLICATE_VERIFY.getIndex())){
			result.put(Const.retCode, true);
		}else{
			result.put(Const.retCode, false);
		}
		result.put("bindingParams", bindingParams);//存入baselog中
		return result;
	}*/
}
