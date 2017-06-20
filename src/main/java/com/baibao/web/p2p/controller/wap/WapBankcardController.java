package com.baibao.web.p2p.controller.wap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_bank_type;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.generator.dataDIC.CustAccountStatus;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.web.p2p.service.CustAccountService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.UserInfoService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.service.transRecord.TransRecordService;
import com.baibao.web.p2p.utils.SMSUtil;

//@Controller
@RequestMapping("/wapBankcard")
public class WapBankcardController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private BankCardService bankCardService;
	@Autowired
	private TenderProfitService tenderProfitService;
	@Autowired
	private UserService userService;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	@Autowired
	private CustAccountService custAccountService;
	@Autowired
	private RepaymentBillService repaymentBillService;
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private LoanProductAidService loanProductAidService;
	@Autowired
	private SMSUtil sMSUtil;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TransRecordService transRecordService;
	@Autowired
	private P2p_bank_typeMapper bankTypeDao;

	/*#RequestMapping("/toWapBankCard")*/
	public String toH5BankCard(HttpServletRequest request,HttpServletResponse response,Model model){
		//获得当前登陆用户
		P2p_user user = SecurityUserHolder.getCurrentUser();
		try {
			//查询第三方数据
			P2p_cust_account custAccount = accountService.getCustAccountByCustNo(user.getPuCustNo(),false);
			String isFirst = "0";
			//如果支付密码不是
			if(!StringUtil.isEmpty(custAccount.getPcaPayPassword())){
				isFirst = "1";
			}
			model.addAttribute("isFirst", isFirst);
			//获取银行卡名称和简称
			List<P2p_bank_card> list = getBankInfo();
			model.addAttribute("bankList",list);
			String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
			P2p_user_info info = userInfoService.getByCustNo(custNo);
			//查询银行卡
			P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(custNo);
			model.addAttribute("bankCard", bankCard);
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
			//如果银行卡为空，说明未绑定过银行卡
			//银行卡不为空，判断“是否完成推进”字段，如果此字段为“00未完成”，则显示第一步之前填过的信息;否则显示第三步
			if(null != bankCard && "01".equals(bankCard.getPbcIfadvance())){
				String bankCardName = bankCard.getPbcBankcardname();
				if(!StringUtil.isEmpty(bankCardName)){
					String name = "**" + bankCardName.substring(bankCardName.length()-1);
					model.addAttribute("hiddenCardName",name);
				}
				String bankCardNo= bankCard.getPbcBankcardno();
				String hiddenBankCardNo = "**** **** **** " + bankCardNo.substring(bankCardNo.length()-4);
				model.addAttribute("bankType", bankCard.getPbcBankcode());
				model.addAttribute("bankType",bankTypeDao.getBankType(bankCard.getPbcBankcode()));
				model.addAttribute("hiddenCardno",hiddenBankCardNo);
				//已绑卡
				model.addAttribute("hasBankCard",true);
			}else{
				//未绑卡
				model.addAttribute("hasBankCard",false);
				model.addAttribute("mobile",user.getPuMobile());
			}
			/*if(!StringUtil.isEmpty(user.getPuHeadUrl())){
				model.addAttribute("head_url", PropertiesUtil.getSysConfigParams("FASTDFS_SERVER")+user.getPuHeadUrl());
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/wap/wapBankCard";
	}
	
	/**
	 * wap 绑定银行卡页面
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/toWapBindBankCard")*/
	public String toWapBindBankCard(HttpServletRequest request,Model model) throws BusinessException{
		P2p_user currentUser = SecurityUserHolder.getCurrentUser();
		P2p_user_info info = null;
		P2p_bank_card bankCard = null;
		P2p_cust_account custAccount = null;
		try {
			custAccount = accountService.getCustAccountByCustNo(currentUser.getPuCustNo(),false);
			String error = null;
			//没有进行开户
			if(CustAccountStatus.NOTACTIVATED.getIndex().equals(custAccount.getPcaStatus())){
				error = "1";
			}
			info = userInfoService.getByCustNo(currentUser.getPuCustNo());
			//未实名认证
			if(Const.NOTCERTIFIED.equals(info.getPuiPlataccountiscert())){
				error = "1";
			}
			//银行类型
			List<P2p_bank_card> bankTypeList =  getBankInfo();
			model.addAttribute("realname", info.getPuiRealName());
			model.addAttribute("bankTypeList", bankTypeList);
			model.addAttribute("error", error);
			model.addAttribute("mobile", currentUser.getPuMobile());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/wap/wapBindBankCard";
	}
	
	//获得银行卡列表
	public List<P2p_bank_card>  getBankInfo()
	{
		List<P2p_bank_card> list = new ArrayList<P2p_bank_card>();
		for(P2p_bank_type bankType : bankTypeDao.getAll())
		{
			P2p_bank_card card = new P2p_bank_card();
			card.setPbcBankName(bankType.getBankDesc());
			card.setPbcBankcode(bankType.getBankCode());
			list.add(card);
		}
		return list;
	}
}
