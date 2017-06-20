package com.baibao.web.p2p.controller.bankCardManagement;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_bank_type;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.web.p2p.service.CustAccountService;

/**
 * 绑卡
 * 
 * @author Denny
 * @date 2016年6月22日
 */
@Controller
@RequestMapping("/bankCard")
public class BankCardController {
	
	private static final Logger logger = LoggerFactory
            .getLogger(BankCardController.class);
	
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
    private BankCardService bankCardService;
	@Autowired
    private CustAccountService custAccountService;	
	@Autowired
	private BaseLog baseLog;
	
	
	/**
	 * 绑定银行卡（绑卡第一步）
	 * @param request
	 * @return
	 */
	@RequestMapping("/bankCardBinding")
	@ResponseBody
	public Map<String, Object> bankCardBinding(
		@RequestParam("bankCode") String bankCode,
		@RequestParam("bankCardNo") String bankCardNo,
		@RequestParam("province") String province,
		@RequestParam("city") String city,
		@RequestParam("phoneNo") String phoneNo,
		@RequestParam("channel") String channel){
		logger.info(String.format("bankCardBinding parameter : bankCode = %s ,bankCardNo = %s,province = %s,"
				+ "city = %s,phoneNo = %s,channel = %s", 
				bankCode,bankCardNo,province,city,phoneNo,channel));
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String custNo = SecurityUserHolder.getCustNo();
			if(StringUtils.isEmpty(bankCode) || StringUtils.isEmpty(bankCardNo) || StringUtils.isEmpty(province) || StringUtils.isEmpty(city) || StringUtils.isEmpty(phoneNo)){
				result.put(Const.retCode, false);
				result.put(Const.retMsg, "参数不符合规范");//参数不符合规范
				logger.info(String.format("bankCardBinding parameter : bankCode = %s ,bankCardNo = %s,province = %s,"
						+ "city = %s,phoneNo = %s,channel = %s --- return : result = %s", 
						bankCode,bankCardNo,province,city,phoneNo,channel,JsonHelper.formatJson(result)));
				return result;
			}
			
			params.put("bankCode", bankCode);
			params.put("bankCardNo", bankCardNo);
			params.put("province", province);
			params.put("city", city);
			params.put("phoneNo", phoneNo);
			params.put("custNo", custNo);
								
			result = bankCardService.bankCardBinding(params);
			baseLog.writer(custNo,"",result.toString(),BusinessType.BINDBANKCARD.getDesc(),RegistType.getName(Integer.parseInt(channel)),"/bankCard/bankCardBinding");
		} catch (Exception e) {
			logger.error("操作异常",e );//操作异常
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "获取验证码失败");//获取验证码失败
		}
		logger.info(String.format("bankCardBinding parameter : bankCode = %s ,bankCardNo = %s,province = %s,"
				+ "city = %s,phoneNo = %s,channel = %s --- return : result = %s", 
				bankCode,bankCardNo,province,city,phoneNo,channel,JsonHelper.formatJson(result)));
		return result;
	}
	
	/**
	 * 绑定银行卡推进（绑卡第二步）
	 * @param request
	 * @return
	 * @author liuchangyan
	 */
	@RequestMapping("/bankCardBindingAdvance")
	@ResponseBody
	public Map<String, Object> bankCardBindingAdvance(HttpServletRequest request,
		@RequestParam("bankCardNo") String bankCardNo,
		@RequestParam("channel") String channel,
		String bankCode, String bankName, String city,
		String cityid, String phoneNo, String province)
	{
		logger.info(String.format("bankCardBindingAdvance parameter : bankCardNo = %s ,channel = %s,bankCode = %s,"
				+ "bankName = %s,city = %s,cityid = %s,phoneNo = %s,province = %s", 
				bankCardNo,channel,bankCode,bankName,city,cityid,phoneNo,
				province));
		Map<String, Object> result = new HashMap<String, Object>();
		String custNo = SecurityUserHolder.getCustNo();
		if (StringUtil.isEmpty(bankCardNo))
		{
			result.put(Const.retCode, false);
			result.put(Const.retMsg,
				"参数不符合规范");//参数不符合规范
			logger.info(String.format("bankCardBindingAdvance parameter : bankCardNo = %s ,channel = %s,bankCode = %s,"
					+ "bankName = %s,city = %s,cityid = %s,phoneNo = %s,province = %s，--- return : result = %s", 
					bankCardNo,channel,bankCode,bankName,city,cityid,phoneNo,
					province,JsonHelper.formatJson(result)));
			return result;
		}

		try
		{
			//调用绑卡推进接口需要的参数
			Map<String, Object> params = new HashMap<String, Object>();

			params.put("custNo", custNo);
			params.put("bankCardNo", bankCardNo);
			params.put("bankCode", bankCode);
			params.put("bankName", bankName);
			params.put("province", province);
			params.put("city", city);
			params.put("cityid", cityid);
			params.put("phoneNo", phoneNo);

			/*
			String custNo = params.get("custNo").toString();
			String bankCardNo = params.get("bankCardNo").toString();
			String bankCode = params.get("bankCode").toString();
			String province = params.get("province").toString();
			String city = params.get("city").toString();
			String phoneNo = params.get("phoneNo").toString();
			 */

			result = bankCardService.bankCardBinding(params);
			SessionUtils.putAttrInSession(request, "isBindAccountNo", 1);
			baseLog.writer(custNo,params.toString(),
				result.toString(), BusinessType.BINDBANKCARDADVANCE.getDesc(),
				RegistType.getName(Integer.parseInt(channel)),
				"/bankCard/bankCardBindingAdvance");
		} catch (Exception e) {
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "绑卡失败");//绑卡失败
			logger.error("绑卡失败",e);//绑卡失败
		}
		logger.info(String.format("bankCardBindingAdvance parameter : bankCardNo = %s ,channel = %s,bankCode = %s,"
				+ "bankName = %s,city = %s,cityid = %s,phoneNo = %s,province = %s，--- return : result = %s", 
				bankCardNo,channel,bankCode,bankName,city,cityid,phoneNo,
				province,JsonHelper.formatJson(result)));
		return result;
	}
	
	/**
	 * 校验交易密码是否正确
	 * @param request
	 * @return
	 * @author liuchangyan
	 */
	
	@RequestMapping("/verifyTradePwd")
	@ResponseBody
	public Map<String, Object> verifyTradePwd(@RequestParam("pwd") String pwd){
		logger.info(String.format("verifyTradePwd parameter : pwd = %s ", 
				pwd));
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtil.isEmpty(pwd)){
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
		}
		try {
			String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
			map.put("password", pwd);
			map.put("custNo", custNo);
			map = custAccountService.inspectTransPassword(map);
		} catch (Exception e) {
			logger.error("\u6821\u9a8c\u4ea4\u6613\u5bc6\u7801\u51fa\u9519",e);//校验交易密码出错
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u6821\u9a8c\u4ea4\u6613\u5bc6\u7801\u51fa\u9519！");//校验交易密码出错
		}
		logger.info(String.format("verifyTradePwd parameter : pwd = %s ，--- return : map = %s", 
				pwd,JsonHelper.formatJson(map)));
		return map;
	}
	
	/**
	 * 解绑银行卡校验
	 * @param request
	 * @return
	 * @author liuchangyan
	 */
	@RequestMapping("/unbinding")
	@ResponseBody
	public Map<String, Object> unbinding(String channel){
		logger.info(String.format("unbinding parameter : channel = %s ", 
				channel));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
			P2p_cust_account account = custAccountService.queryIdentityId(custNo);
			P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
			if(null == bankCard){
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "\u94f6\u884c\u5361\u4e0d\u5b58\u5728");//银行卡不存在
				logger.info(String.format("unbinding parameter : channel = %s ，--- return : map = %s", 
						channel,JsonHelper.formatJson(map)));
				return map;
			}
			Map<String, String> params=new HashMap<String, String>();
			if(null != account){
				params.put("identity_id", account.getPcaAccountno());//用户标识信息
			}
			params.put("identity_type", Const.UID.toString());//用户标识类型
			params.put("card_id", bankCard.getPbccardId());//卡ID
			params.put("advance_flag", "Y");//是否推进
			if(null == bankCard.getPbcIssafecard() || "".equals(bankCard.getPbcIssafecard())){
				//map = unbindingbankCard(params,custNo);
				map.put(Const.retCode, false);
				logger.info(String.format("unbinding parameter : channel = %s ，--- return : map = %s", 
						channel,JsonHelper.formatJson(map)));
				return map;
			}else{
				//非安全卡字段不为空，取值N或者Y
				if("N".equals(bankCard.getPbcIssafecard())){
					//如果为非安全卡可以解绑
					map = unbindingbankCard(params,custNo,bankCard.getPbcBankcardno());
				}else if("Y".equals(bankCard.getPbcIssafecard())){
					//为安全卡
					//如果账户余额大于0，不能解绑
					if(account.getPcaAccountBalance().compareTo(BigDecimal.ZERO) == 1){
						map.put(Const.retCode, false);
						map.put(Const.retMsg, "\u8bf7\u5148\u5c06\u8d26\u6237\u4f59\u989d\u63d0\u73b0\u518d\u89e3\u7ed1");//请先将账户余额提现再解绑
						logger.info(String.format("unbinding parameter : channel = %s ，--- return : map = %s", 
								channel,JsonHelper.formatJson(map)));
						return map;
					}else{
						map = unbindingbankCard(params,custNo,bankCard.getPbcBankcardno());
					}
				}
			}
			baseLog.writer(custNo,params.toString(),map.toString(),BusinessType.BINDTHEBANKCARD.getDesc(),RegistType.getName(Integer.parseInt(channel)),"/bankCard/unbinding");
		} catch (Exception e) {
			logger.error("\u89e3\u7ed1\u51fa\u9519",e);//解绑出错
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "\u89e3\u7ed1\u51fa\u9519");//解绑出错
		}
		logger.info(String.format("unbinding parameter : channel = %s ，--- return : map = %s", 
				channel,JsonHelper.formatJson(map)));
		return map;
	}
	
	
	/**
	 * 解绑操作
	 * @param request
	 * @return
	 * @author 
	 */
	public Map<String, Object> unbindingbankCard(Map<String, String> params,
			String custNo,String cardNo){
		logger.info(String.format("unbindingbankCard parameter : params = %s ,custNo = %s,cardNo = %s", 
				JsonHelper.formatJson(params),custNo,custNo));
		Map<String, Object> map = new HashMap<String, Object>();
		map = bankCardService.unbindingbankCardNew(params,custNo,cardNo);
		logger.info(String.format("unbindingbankCard parameter : params = %s ,custNo = %s,cardNo = %s,--- return : map = %s", 
				JsonHelper.formatJson(params),custNo,custNo,JsonHelper.formatJson(map)));
		return map;
	}
	
	/**
	 * 解绑推进操作
	 * @param request
	 * @return
	 * @author zhanghui
	 */
	@RequestMapping("/unbindingAdvance")
	@ResponseBody
	public Map<String, Object> unbindingbankCardAdvance(@RequestParam("validCode") String validCode,@RequestParam("channel") String channel){
		logger.info(String.format("unbindingbankCardAdvance parameter : validCode = %s ,channel = %s ", 
				validCode,channel));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
			P2p_cust_account account = custAccountService.queryIdentityId(custNo);
			P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
			if(bankCard==null||account==null){
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "\u89e3\u7ed1\u5361\u5931\u8d25");//解绑卡失败
				logger.info(String.format("unbindingbankCardAdvance parameter : validCode = %s ,channel = %s --- return : map = %s", 
						validCode,channel,JsonHelper.formatJson(map)));
				return map;
			}
			//调用绑卡推进接口需要的参数
			Map<String, String> params=new HashMap<String, String>();
			params.put("identity_id", account.getPcaAccountno());//用户标识信息
			params.put("identity_type", Const.UID);//用户标识类型
			params.put("valid_code", validCode);
			map = bankCardService.unbindingbankCardAdvance(params,custNo,bankCard.getPbcBankcardno());
			baseLog.writer(custNo,params.toString(),map.toString(),BusinessType.BINDBANKCARDADVANCE.getDesc(),RegistType.getName(Integer.parseInt(channel)),"/bankCard/unbindingAdvance");
		} catch (Exception e) {
			
			logger.error("unbindingbankCardAdvance", e);
		}
		logger.info(String.format("unbindingbankCardAdvance parameter : validCode = %s ,channel = %s --- return : map = %s", 
				validCode,channel,JsonHelper.formatJson(map)));
		return map;
	}
	
	
	
	
}

