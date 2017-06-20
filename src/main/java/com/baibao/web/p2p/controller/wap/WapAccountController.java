package com.baibao.web.p2p.controller.wap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.web.p2p.service.UmpayService;
import com.baibao.web.p2p.service.UserInfoService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.common.util.PropertiesUtil;

//@Controller
@RequestMapping("/wapAccount")
public class WapAccountController
{	
	private static Logger logger =
		LoggerFactory.getLogger(WapAccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private BankCardService bankCardService;
	
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	@Autowired
	private UmpayService umpayService;

	@Autowired
	private P2p_bank_typeMapper bankTypeDao;

	@Autowired
	private BaseLog baseLog;

	/**
	 * 个人中心
	 * @param request
	 * @param model
	 * @return
	 */
	/*#RequestMapping("/wapAccountIndex")*/
	public String wapAccountIndex(HttpServletRequest request,Model model){
		P2p_user currentUser = SecurityUserHolder.getCurrentUser();
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		String custNo = currentUser.getPuCustNo();
		try {
			//查询账户余额
			P2p_cust_account account = accountService.getCustAccountByCustNo(custNo,true);
			//再次查询登陆用户
			P2p_user user = userService.getByLoginCustNo(custNo);
			//账户余额
			BigDecimal balance = account.getPcaAccountBalance();   //可用余额
			params.put("status", 10);
			if(user==null){
				retMap.put("headUrl", "");
			}else{
				//用户头像
				retMap.put("headUrl", PropertiesUtil.getSysConfigParams("FASTDFS_SERVER")+user.getPuHeadUrl());
			}
			params.put("custNo", user.getPuCustNo());
			params.put("accountBalance", balance);
			Map<String, Object> ret =  accountService.assetPandect(params);
			retMap.put("investmentTotal", ret.get("investTotal"));//投资总额
			retMap.put("allMoney", ret.get("propertyTotal")); //总的资产
			retMap.put("accountBalance",balance );
			retMap.put(Const.retCode, true);
			retMap.put("activitySign","0" );//活动标识，用来判断有没有新活动上线  1有新活动0没活动
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			model.addAttribute("result", retMap);
		} catch (Exception e) {
			logger.error("wap账户接口出错,接口名wapAccount/wapAccountIndex", e);
		}
		return "/wap/wapAccountIndex";
	}
	
	
	/**
	 * 充值 - 页面展示
	 * @param model
	 * @return
	 */
	/*#RequestMapping("/toWapRecharge")*/
	public String toRecharge(HttpServletRequest request,Model model){
		P2p_user user = SecurityUserHolder.getCurrentUser();
		P2p_cust_account account = null;
		String error = null;//0:未开户，1:未实名,2:未绑定银行卡,3:未设置交易密码
		try {
			//检查是否开户成功
			account = accountService.getCustAccountByCustNo(user.getPuCustNo(),true);
			//账户记录为空
			if(account!=null){
				//新浪支付账户为空，则去进行实名认证
				if(StringUtil.isEmpty(account.getPcaAccountno())){
					//未开户
					error = "0";
					model.addAttribute("error", error);
					return "/wap/wapRecharge";
				}
			}else{
				//未开户
				error = "0";
				model.addAttribute("error", error);
				return "/wap/wapRecharge";
			}
			//检查是否进行实名认证
			P2p_user_info info = userInfoService.getByCustNo(user.getPuCustNo());
			if(null!=info && info.getPuiPlataccountiscert().equals("0")){
				//检查是否绑定银行卡
				P2p_bank_card banCard = bankCardService.getBankCardByCustNo(user.getPuCustNo());
				if(banCard!=null && "01".equals(banCard.getPbcIfadvance())){
					model.addAttribute("bankType", bankTypeDao.getBankType(banCard.getPbcBankcode()));
					model.addAttribute("bankCard", banCard);
					//用户手机号
					model.addAttribute("mobile", banCard.getPbcPhoneNo());
				}else{
					model.addAttribute("personalEbank", bankTypeDao.getPersonalEbank());
					//未绑卡
					error = "2";
					model.addAttribute("error", error);
					return "/wap/wapRecharge";
				}
				// 可用余额
				model.addAttribute("balance", account.getPcaAccountBalance());
				//用户详细
				model.addAttribute("info", info);
				//是否设置交易密码
				if(!StringUtil.isEmpty(account.getPcaPayPassword())){
					model.addAttribute("payPassword", account.getPcaPayPassword());//已设置交易密码
				}else{
					model.addAttribute("payPassword", "");;//未设置交易密码
					//未设置交易密码
					error = "3";
					model.addAttribute("error", error);
					return "/wap/wapRecharge";
				}
			}else{
				//未实名认证
				error = "1";
				model.addAttribute("error", error);
				return "/wap/wapRecharge";
			}
			model.addAttribute(
				"personalHhortcut", bankTypeDao.getPersonalHhortcut());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/wap/wapRecharge";
	}
	
	/**
	 * 提现页面
	 * @param request
	 * @param response
	 * @return
	 */
	/*#RequestMapping("/toWapwithdrawals")*/
	public String toWithDrawals(HttpServletRequest request,
			HttpServletResponse response,
			Model model){
		P2p_user user = SecurityUserHolder.getCurrentUser();
		P2p_cust_account account = null;
		String error = null;//0:未开户，1:未实名,2:未绑定银行卡,3:未设置交易密码
		try {
			//检查是否开户成功
			account = accountService.getCustAccountByCustNo(user.getPuCustNo(),true);
			//账户记录为空
			if(account!=null){
				//新浪支付账户为空，则去进行实名认证
				if(StringUtil.isEmpty(account.getPcaAccountno())){
					//未开户
					error = "0";
					model.addAttribute("error", error);
					return "/wap/wapToMention";
				}
			}else{
				//未开户
				error = "0";
				model.addAttribute("error", error);
				return "/wap/wapToMention";
			}
			//检查是否进行实名认证
			P2p_user_info info = userInfoService.getByCustNo(user.getPuCustNo());
			if(null!=info && info.getPuiPlataccountiscert().equals("0")){
				//检查是否绑定银行卡
				P2p_bank_card banCard = bankCardService.getBankCardByCustNo(user.getPuCustNo());
				if(banCard!=null && "01".equals(banCard.getPbcIfadvance())){
					model.addAttribute("bankType",bankTypeDao.getBankType(banCard.getPbcBankcode()));
					model.addAttribute("bankCard", banCard);
				}else{
					model.addAttribute("personalEbank",bankTypeDao.getPersonalEbank());
					//未绑卡
					error = "2";
					model.addAttribute("error", error);
					return "/wap/wapToMention";
				}
				// 可用余额
				model.addAttribute("balance", account.getPcaAccountBalance());
				//是否设置交易密码
				if(!StringUtil.isEmpty(account.getPcaPayPassword())){
					model.addAttribute("payPassword", account.getPcaPayPassword());//已设置交易密码
				}else{
					model.addAttribute("payPassword", "");;//未设置交易密码
					//未设置交易密码
					error = "3";
					model.addAttribute("error", error);
					return "/wap/wapToMention";
				}
			}else{
				//未实名认证
				error = "1";
				model.addAttribute("error", error);
				return "/wap/wapToMention";
			}
			model.addAttribute("personalHhortcut",bankTypeDao.getPersonalHhortcut());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "/wap/wapToMention";
	};
	
	/**
	 * 开户页面
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapOpenAccount")*/
	public String wapSecuritySettings(HttpServletRequest request){
		return "/wap/wapOpenAccount";
	}
	
	
	
	/**
	 * 安全中心
	 * @return
	 */
	/*#RequestMapping("/wapSafecenter")*/
	public String wapSafecenter(HttpServletRequest request,Model model){
		P2p_user user = SecurityUserHolder.getCurrentUser();
		user = userService.getByLoginCustNo(user.getPuCustNo());
		model.addAttribute("mobile", user.getPuMobile());
		if(StringUtil.isNotEmpty(user.getPuMail())){
			model.addAttribute("mail", "1");
		}
		try {
			P2p_cust_account custAccount = accountService.getCustAccountByCustNo(user.getPuCustNo(),false);
			if(StringUtil.isEmpty(custAccount.getPcaAccountno())){
				//是否开户开户
				model.addAttribute("isOpen", "1");
			}else{
				model.addAttribute("isOpen", "0");
			}
			String isFirst = "0";
			//交易密码
			if(!StringUtil.isEmpty(custAccount.getPcaPayPassword())){
				isFirst = "1";
			}
			model.addAttribute("isFirst", isFirst);
			String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
			P2p_user_info info = userInfoService.getByCustNo(custNo);
			//是否实名认证
			if(null != info){
				String certNo = info.getPuiCertNo();
				String hiddenCertNo = "";
				if(null != certNo && !"".equals(certNo)){
					hiddenCertNo = certNo.substring(0,4) + " ***** ***** " + certNo.substring(certNo.length()-4);
				}
				model.addAttribute("realName", info.getPuiRealName());
				model.addAttribute("hiddenCertNo", hiddenCertNo);
				model.addAttribute("isCert", info.getPuiPlataccountiscert());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/wap/wapSafecenter";
	}
	
	
	
	/**
	 * 修改密码
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapModifyLoginPassword")*/
	public String wapModifyPassword(HttpServletRequest request){
		return "/wap/wapModifyLoginPassword";
	};
	
	/**
	 * 修改交易密码
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapModifyTransPassword")*/
	public String wapModifyTransPassword(HttpServletRequest request){
		P2p_user user = SecurityUserHolder.getCurrentUser();
		P2p_cust_account custAccount;
		try {
			custAccount = accountService.getCustAccountByCustNo(user.getPuCustNo(),false);
			//交易密码
			String isFirst = "0";
			if(!StringUtil.isEmpty(custAccount.getPcaPayPassword())){
				isFirst = "1";
			}
			request.setAttribute("isFirst", isFirst);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "/wap/wapModifyTransPassword";
	}
	
	
	/**
	 * 我的账户 - 登录密码修改 
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @param newPasswordSub 确认新密码
	 * @param client
	 * @return
	 */
	@RequestMapping("/updateLoginPass")
	@ResponseBody
	public Map<String, Object> modifyLoginPass(String oldPassword,String newPassword,String newPasswordSub){
		Map<String, Object> result = new HashMap<String, Object>();
		if(StringUtil.isEmpty(oldPassword) || StringUtil.isEmpty(oldPassword) || StringUtil.isEmpty(newPasswordSub)){
			result.put(Const.retCode, Boolean.FALSE);
			result.put(Const.retMsg,"\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return result;
		}
		if(!newPassword.equals(newPasswordSub)){
			result.put(Const.retCode, Boolean.FALSE);
			result.put(Const.retMsg, "\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4");// 两次密码不一致
			result.put(Const.retType, "passSub");
			return result;
		}
		P2p_user user = SecurityUserHolder.getCurrentUser();
		oldPassword = md5PasswordEncoder.encodePassword(oldPassword, user.getPuCustNo());
		if(!oldPassword.equals(user.getPuPassword())){
			result.put(Const.retCode, Boolean.FALSE);
			result.put(Const.retMsg, "\u539f\u5bc6\u7801\u9519\u8bef");// 原密码错误
			result.put(Const.retType, "oldpass");
			return result;
		}else{
			result.put("password", md5PasswordEncoder.encodePassword(newPassword, user.getPuCustNo()));
			result.put("custNo", user.getPuCustNo());
			result.put("registType", RegistType.WAP.getIndex());
			result = userService.updateLoginPassword(result);
		}
		
		baseLog.writer(user.getPuCustNo(),"",result.toString(),BusinessType.CHANGEPASSWORD.getDesc(), RegistType.WAP.getName(), "/updateLoginPass");
		return result;
	}
	
	
	/**
	 * 帮助中心
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapHelpCenter")*/
	public String wapHelpCenter(HttpServletRequest request){
		return "/wap/wapHelpCenter";
	};
	
	
	/**
	 * 修改交易密码
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/wapModifyMail")*/
	public String wapModifyMail(HttpServletRequest request){
		P2p_user user = SecurityUserHolder.getCurrentUser();
		try {
			user = userService.getByLoginCustNo(user.getPuCustNo());
			//设置邮箱
			String isFirst = "0";
			if(!StringUtil.isEmpty(user.getPuMail())){
				//修改邮箱
				isFirst = "1";
			}
			request.setAttribute("isFirst", isFirst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/wap/wapModifyMail";
	}
	
	
	/**
	 * 旧版个人中心
	 * @param request
	 * @param model
	 * @return
	 */
	/*#RequestMapping("/wapAccountOldIndex")*/
	public ModelAndView wapAccountOldIndex(HttpServletRequest request,HttpServletResponse response)  throws BusinessException{
		ModelAndView model = new ModelAndView("/wap/wapAccountOldIndex");
		String custNo = SecurityUserHolder.getCustNo();
		//可用余额、冻结金额、合计充值、资产总计、合计提现 
		Map<String, Object> result = umpayService.selectCustAccount(custNo);
		//交易记录
		model.addObject("startTime", "");
		model.addObject("endTime", "");
		model.addObject("ajaxPageUrl","asset/ajaxPageTransRecord");
		model.addObject("result",result);
		return model;
	}
	
	/**
	 * 交易记录
	 * @param currentPageNo
	 * @param transType
	 * @param transStatus
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws BusinessException
	 */
	/*#RequestMapping("/wapOldTransRecord")*/
	public ModelAndView ajaxPageTransRecord(HttpServletRequest request,Integer currentPageNo,
			@RequestParam(value="transType",required=false) Integer transType,
			@RequestParam(value="transStatus",required=false) Integer transStatus,
			@RequestParam(value="startTime", required=false) String startTime,
			@RequestParam(value="endTime",required=false) String endTime)throws BusinessException{
		ModelAndView model = new ModelAndView("/wap/wapOldTransRecords");
		String custNo = SecurityUserHolder.getCustNo();
		int pageSize = 10;
		currentPageNo = (currentPageNo!=null)?currentPageNo:1;
		transType = (transType!=null)?transType:1;
		//交易记录
		Paging<Map<String, Object>> paging = null;
		paging = umpayService.getTransactionRecordPage(custNo, transType, transStatus, startTime, endTime, currentPageNo, pageSize);
		List<Map<String, Object>> list = paging.getPageList();
		model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
		model.addObject("list", list);
		model.addObject("transType", transType);
		model.addObject("pageNum", currentPageNo);
		model.addObject("endNum", paging.getPageTotal());
		return model;
	}
	
	
	/**
	 * 联动提现页面跳转
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	/*#RequestMapping("/skipWithdrawCash")*/
	public ModelAndView skipWithdrawCash(HttpServletRequest request,HttpServletResponse response) throws BusinessException{
		ModelAndView model = new ModelAndView("/wap/wapSkipWithdrawCash");
		String custNo = SecurityUserHolder.getCustNo();
		Map<String, Object> result = umpayService.getPresentPage(custNo); 
		model.addObject("result",result);
		return model;
	}
	
	
	/**
	 * 联动提现
	 * @param request
	 * @param response
	 * @return
	 * @throws BusinessException
	 */
	/*#RequestMapping("/umpayWithdrawCash")*/
	@ResponseBody
	public Map<String, Object> umpayWithdrawCash(HttpServletRequest request,HttpServletResponse response,@RequestParam("withdrawalsMoney") String withdrawalsMoney) throws BusinessException{
		Map<String, Object> result = new HashMap<String, Object>();
		P2p_user user = SecurityUserHolder.getCurrentUser();
		if(StringUtil.isEmpty(withdrawalsMoney)){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return result;
		}else if("0".equals(withdrawalsMoney)){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u63d0\u73b0\u91d1\u989d\u5927\u4e8e"+0);// 提现金额大于
			return result;
		}
		result = umpayService.withdrawCashApp(user.getPuCustNo(), withdrawalsMoney);
		baseLog.writer(user.getPuCustNo(),"",result.toString(),"旧版提现", RegistType.WAP.getName(), "/umpayWithdrawCash");
		return result;
	}
}
