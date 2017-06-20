package com.baibao.web.p2p.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.core.utils.mail.MailUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.MessageType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.AccountFlowService;
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

/**
 * 我的账户
 * 
 * @author Denny
 * @date 2016年6月12日
 */
@Controller
@RequestMapping("/account")
public class AccountManageController {
    private static Logger log = LoggerFactory.getLogger(AccountManageController.class);
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
    private AccountFlowService accountFlowService;
    @Autowired
    private BaseLog baseLog;
    @Autowired
    private P2p_bank_typeMapper bankTypeDao;

    /**
     * 我的账户
     * 
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping()
    public String toPersonalAccount(HttpServletRequest request, HttpServletResponse response, Model model)
    {
    	log.info(String.format("toPersonalAccount parameter : model = %s", 
    			JsonHelper.formatJson(model)));
        String custNo = SecurityUserHolder.getCustNo();
        try
        {
            P2p_user user = userService.getByLoginCustNo(custNo);

            // 验证邮箱
            String isSetEmil = "0";
            if (StringUtil.isNotEmpty(user.getPuMail()))
            {
                isSetEmil = "1";// 已设置
                model.addAttribute("puEmil", user.getPuMail());
            }

            model.addAttribute("isSetEmil", isSetEmil);
            // 验证交易密码
            P2p_cust_account custAccount = accountService.getCustAccountByCustNo(user.getPuCustNo(), false);

            String isFirst = "0";
            if (!StringUtil.isEmpty(custAccount.getPcaPayPassword()))
                isFirst = "1";

            model.addAttribute("isFirst", isFirst);

            // 获取银行卡名称和简称
            model.addAttribute("bankList", bankTypeDao.getPersonalEbank());
            P2p_user_info info = userInfoService.getByCustNo(user.getPuCustNo());

            // 查询银行卡
            P2p_bank_card bankCard = bankCardService.getBankCardByCustNo(user.getPuCustNo());

            // 查询账户
            P2p_cust_account custAcc = accountService.getCustAccountByCustNo(user.getPuCustNo(), true);
            if (null != info)
            {
                String hiddenCertNo = "";

                if (info.getPuiPlataccountiscert().equals(Const.ALREADYCERTIFIED))
                {
                    hiddenCertNo = info.getPuiCertNo().substring(0, 4) + " ***** ***** "
                            + info.getPuiCertNo().substring(info.getPuiCertNo().length() - 4);
                }

                model.addAttribute("realName", info.getPuiRealName());
                model.addAttribute("hiddenCertNo", hiddenCertNo);
                model.addAttribute("isCert", info.getPuiPlataccountiscert());
                model.addAttribute("pui_address", info.getPuiAddress());
                model.addAttribute("pca_balance", custAcc.getPcaAccountBalance());
            }

            // 如果银行卡为空，说明未绑定过银行卡
            // 银行卡不为空，判断“是否完成推进”字段，如果此字段为“00未完成”，则显示第一步之前填过的信息;否则显示第三步
            if (null != bankCard && Const.ALREADYADVANCE.equals(bankCard.getPbcIfadvance()))
            {
                String bankCardName = bankCard.getPbcBankcardname();
                if (!StringUtil.isEmpty(bankCardName))
                {
                    String name = "**" + bankCardName.substring(bankCardName.length() - 1);

                    model.addAttribute("hiddenCardName", name);
                }
                String bankCardNo = bankCard.getPbcBankcardno();
                String hiddenBankCardNo = "**** **** **** " + bankCardNo.substring(bankCardNo.length() - 4);
                model.addAttribute("bankType", bankTypeDao.getBankType(bankCard.getPbcBankcode()));
                model.addAttribute("hiddenCardno", hiddenBankCardNo);
                // 已绑卡
                model.addAttribute("hasBankCard", true);
            } else
            {
                if (info.getPuiRealName() != null && info.getPuiCertNo() != null)
                {
                    model.addAttribute("realName", info.getPuiRealName());
                    model.addAttribute("idCard", info.getPuiCertNo());
                }

                // 未绑卡
                model.addAttribute("hasBankCard", false);
                model.addAttribute("mobile", user.getPuMobile());
            }
        } catch (Exception e)
        {
            log.error("toPersonalAccount", e);
        }
        log.info(String.format("toPersonalAccount return model = %s", JsonHelper.formatJson(model)));
        return "/personal/personalAccount";
    }

    /**
     * 充值 - 页面展示
     * 
     * @param model
     * @return
     */
    @RequestMapping("/torecharge")
    public String toRecharge(HttpServletRequest request, Model model) throws BusinessException
    {
    	log.info(String.format("toRecharge parameter : model = %s", JsonHelper.formatJson(model)));
        try
        {
            P2p_user user = SecurityUserHolder.getCurrentUser();

            Map<String, Object> result = accountFlowService.toRecharge(user.getPuCustNo(), user.getPuMobile());

            model.addAttribute("result", result);
            log.info(String.format("toRecharge return : result = %s", 
            		result));
        } catch (Exception e)
        {
            log.error("toRecharge", e);
        }
        log.info(String.format("toRecharge parameter : model = %s --- return : /personal/recharge", JsonHelper.formatJson(model)));
        return "/personal/recharge";
    }

    /**
     * 充值 - 绑定支付
     * 
     * @param amount
     * @param transChannel
     * @return
     */
    @RequestMapping("/bindingRecharge")
    @ResponseBody
    public Map<String, Object> bindingRecharge(String amount, String payPassword, String registType, String notifyUrl)
    {
    	log.info(String.format("bindingRecharge parameter : amount = %s, "
    			+ "payPassword = %s, registType = %s, notifyUrl = %s", 
    			amount, payPassword, registType, notifyUrl));
    	
        Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();

        if (StringUtil.isEmpty(amount) || StringUtil.isEmpty(payPassword) || StringUtil.isEmpty(registType)
                || StringUtil.isEmpty(notifyUrl))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 参数不符合规范
                    "参数不符合规范");
            log.info(String.format("bindingRecharge parameter : amount = %s, payPassword = %s, "
            		+ "registType = %s, notifyUrl = %s --- return : result = %s", 
        			amount, payPassword, registType, notifyUrl, JsonHelper.formatJson(result)));
            return result;
        }
        // 充值金额必须大于等于0
        BigDecimal bigAmount = new BigDecimal(amount);
        if (bigAmount.compareTo(new BigDecimal(0)) != 1)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 充值金额必须大于等于0
                    "充值金额必须大于等于0");
            log.info(String.format("bindingRecharge parameter : amount = %s, payPassword = %s, "
            		+ "registType = %s, notifyUrl = %s --- return : result = %s", 
        			amount, payPassword, registType, notifyUrl, JsonHelper.formatJson(result)));
            return result;
        }

        String custNo = SecurityUserHolder.getCustNo();

        params.put("amount", amount);
        params.put("payPassword", payPassword);
        params.put("custNo", custNo);
        params.put("registType", registType);
        params.put("rechargeType", Const.bindingRecharge);
        params.put("notifyUrl", notifyUrl);

        try
        {
            result = accountService.bindingPayment(params);
        } catch (BusinessException e)
        {
            result.put(Const.retCode, false);
            log.error("bindingRecharge", e);
        }

        baseLog.writer(custNo, params.toString(), result.toString(), BusinessType.SHORTCUTRECHARGE.getDesc(),
                RegistType.getName(Integer.parseInt(registType)), "/account/bindingRecharge");
        
        log.info(String.format("bindingRecharge parameter : amount = %s, payPassword = %s, "
        		+ "registType = %s, notifyUrl = %s --- return : result = %s", 
    			amount, payPassword, registType, notifyUrl, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 充值 - 绑定支付推进
     * 
     * @param validateCode
     * @return
     */
    @RequestMapping("/advanceHostingPay")
    @ResponseBody
    public Map<String, Object> advanceHostingPay(String validateCode, String transFlowNo, String amount,
            String registType)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();

        log.info(String.format("advanceHostingPay parameter : validateCode = %s, "
        		+ "transFlowNo = %s, amount = %s, registType = %s", 
        		validateCode, transFlowNo, amount, registType));
        
        String custNo = SecurityUserHolder.getCustNo();

        if (StringUtil.isEmpty(validateCode))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "参数不符合规范");// 参数不符合规范
            
            log.info(String.format("advanceHostingPay parameter : validateCode = %s, "
            		+ "transFlowNo = %s, amount = %s, registType = %s --- return : result = %s", 
            		validateCode, transFlowNo, amount, registType, JsonHelper.formatJson(result)));
            
            return result;
        }

        try
        {
            params.put("amount", amount);
            params.put("custNo", custNo);
            params.put("registType", registType);
            params.put("rechargeType", Const.bindingRecharge);
            params.put("validateCode", validateCode);
            params.put("transFlowNo", transFlowNo);

            result = accountService.advanceHostingPay(params);
        } catch (Exception e)
        {
            result.put(Const.retCode, false);
            log.error("advanceHostingPay", e);
        }

        baseLog.writer(custNo, params.toString(), result.toString(), BusinessType.SHORTCUTRECHARGEADVANCE.getDesc(),
                RegistType.getName(Integer.parseInt(registType)), "/account/advanceHostingPay");

        log.info(String.format("advanceHostingPay parameter : validateCode = %s, "
        		+ "transFlowNo = %s, amount = %s, registType = %s --- return : result = %s", 
        		validateCode, transFlowNo, amount, registType, JsonHelper.formatJson(result)));
        
        return result;
    }

    /**
     * 网银充值参数验证
     * 
     * @param bankCode
     * @param amount
     * @return
     */
    @RequestMapping("/onlineVerification")
    @ResponseBody
    public Map<String, Object> onlineVerification(String bankCode, String amount) throws Exception
    {
        Map<String, Object> result = new HashMap<String, Object>();
        
        log.info(String.format("onlineVerification parameter : bankCode = %s, amount = %s", 
        		bankCode, amount));
        if (StringUtil.isEmpty(bankCode) || StringUtil.isEmpty(amount))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 参数不符合规范
                    "参数不符合规范");
        } else
        {
            // 充值金额必须大于等于0
            BigDecimal bigAmount = new BigDecimal(amount);

            if (bigAmount.compareTo(new BigDecimal(0)) != 1)
            {
                result.put(Const.retCode, false);
                result.put(Const.retMsg, // 充值金额必须大于等于0
                        "充值金额必须大于等于" + "0");

                return result;
            }

            result.put(Const.retCode, true);
        }
        log.info(String.format("onlineVerification parameter : bankCode = %s, amount = %s --- return : result = %s", 
        		bankCode, amount, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 网银充值
     * 
     * @param bankCode
     * @param amount
     * @return
     */
    @RequestMapping("/onlineBankRecharge")
    public String onlinePayment(
    	@RequestParam(required = false, defaultValue = "recharge")
    	String rechargeType, String bankCode, String amount,
    	String notifyUrl, Model model)
            throws BusinessException
    {
    	log.info(String.format("onlinePayment parameter : rechargeType = %s, bankCode = %s, "
    			+ "amount = %s, notifyUrl = %s", 
    			rechargeType, bankCode, amount, notifyUrl));
    	
        P2p_user user = SecurityUserHolder.getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            result = accountService.onlineBankPayment(
            	SecurityUserHolder.getCustNo(), amount, bankCode,
                RegistType.PC.getIndex(), rechargeType,
                notifyUrl);

            baseLog.writer(user.getPuCustNo(), "", "", BusinessType.CYBERBANKRECHARGE.getDesc(),
                    RegistType.PC.getName(), "/account/onlineBankRecharge");
        } catch (Exception e)
        {
            log.error("onlinePayment", e);
        }

        model.addAttribute("result", result);
        log.info(String.format("onlinePayment parameter : rechargeType = %s, bankCode = %s, "
    			+ "amount = %s, notifyUrl = %s --- return : result = %s", 
    			rechargeType, bankCode, amount, notifyUrl, JsonHelper.formatJson(result)));
        return "/personal/jump";
    }

    /**
     * 手机网银充值
     * 
     * @param bankCode
     * @param amount
     * @return
     */
    @RequestMapping("/wapOnlineBankRecharge")
    public String onlinePaymentPhone(HttpServletRequest request, String amount, String notifyUrl)
            throws BusinessException
    {
        P2p_user user = SecurityUserHolder.getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("onlinePaymentPhone parameter : amount = %s, notifyUrl = %s", 
        		amount, notifyUrl));
        try
        {
            String bankCode = "UPOP";// 银联在线支付

            result = accountService.onlineBankPayment(SecurityUserHolder.getCustNo(), amount, bankCode,
                    RegistType.WAP.getIndex(), Const.onlineBankingRecharge, notifyUrl);

            baseLog.writer(user.getPuCustNo(), "", "", BusinessType.CYBERBANKRECHARGE.getDesc(),
                    RegistType.WAP.getName(), "/account/onlineBankRecharge");
        } catch (Exception e)
        {
            log.error("onlinePaymentPhone", e);
        }

        request.setAttribute("result", result);
        log.info(String.format("onlinePaymentPhone parameter : amount = %s, notifyUrl = %s --- "
        		+ "return : %s", 
        		amount, notifyUrl, JsonHelper.formatJson(result)));
        return "/personal/jump";
    }

    /**
     * 提现页面
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/towithdrawals")
    public String toWithDrawals(HttpServletRequest request, HttpServletResponse response, Model model)
            throws BusinessException
    {
    	log.info(String.format("toWithDrawals parameter : model = %s", 
        		 JsonHelper.formatJson(model)));
        try
        {
            P2p_user user = SecurityUserHolder.getCurrentUser();

            Map<String, Object> result = accountFlowService.toWithDrawals(user.getPuCustNo(), user.getPuMobile());

            result.put("userFee", new BigDecimal(Const.userFee));

            model.addAttribute("result", result);
            
            log.info(String.format("toWithDrawals parameter : model = %s --- return : result = %s", 
              		 JsonHelper.formatJson(model), JsonHelper.formatJson(result)));
        } catch (Exception e)
        {
            log.error("toWithDrawals", e);
        }
        
        return "/personal/withdrawals";
    }

    /**
     * 申请提现
     * 
     * @param transChannel
     * @param amount
     * @return
     */
    @RequestMapping("/createHostingWithDraw")
    @ResponseBody
    public Map<String, Object> hostingWithDraw(String amount, String payPassword, String registType, 
    		String notifyUrl)
    {
    	
    	log.info(String.format("hostingWithDraw parameter : amount = %s, payPassword = %s, "
    			+ "registType = %s, notifyUrl = %s", 
    			amount, payPassword, registType, notifyUrl));
    	
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> parameter = new HashMap<String, Object>();

        String custNo = SecurityUserHolder.getCustNo();

        if (StringUtil.isEmpty(amount) || StringUtil.isEmpty(payPassword) || StringUtil.isEmpty(notifyUrl))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 参数不符合规范
                    "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");
            log.info(String.format("hostingWithDraw parameter : amount = %s, payPassword = %s, "
        			+ "registType = %s, notifyUrl = %s --- return : result = %s", 
        			amount, payPassword, registType, notifyUrl, JsonHelper.formatJson(result)));
            return result;
        }

        if (new BigDecimal(amount).compareTo(new BigDecimal(50)) < 0)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 暂不支持50元以下提现业务
                    "\u6682\u4e0d\u652f\u6301\u0035\u0030\u5143\u4ee5\u4e0b\u63d0\u73b0\u4e1a\u52a1");
            
            log.info(String.format("hostingWithDraw parameter : amount = %s, payPassword = %s, "
        			+ "registType = %s, notifyUrl = %s --- return : result = %s", 
        			amount, payPassword, registType, notifyUrl, JsonHelper.formatJson(result)));
            return result;
        }

        try
        {
            parameter.put("amount", amount);
            parameter.put("payPassword", payPassword);
            parameter.put("custNo", custNo);
            parameter.put("registType", registType);
            parameter.put("notifyUrl", notifyUrl);

            result = accountService.createHostingWithDraw(parameter);
        } catch (Exception e)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u63d0\u73b0\u5931\u8d25");// 提现失败
            log.error("hostingWithDraw", e);
        }

        baseLog.writer(custNo, parameter.toString(), result.toString(), BusinessType.WITHDRAWDEPOSIT.getDesc(),
                RegistType.getName(Integer.parseInt(registType)), "/account/createHostingWithDraw");
        
        log.info(String.format("hostingWithDraw parameter : amount = %s, payPassword = %s, "
    			+ "registType = %s, notifyUrl = %s --- return : result = %s", 
    			amount, payPassword, registType, notifyUrl, JsonHelper.formatJson(result)));
        return result;
    }

    /*** 我的账户 - 登录密码start */
    /**
     * 我的账户 -登录密码修改 - 检查原密码是否正确
     * 
     * @param oldPassword
     *            原密码
     * @return
     */
    @RequestMapping("/ajaxCheckPassword")
    @ResponseBody
    public Map<String, Object> ajaxCheckPassword(String oldPassword)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("ajaxCheckPassword parameter : oldPassword = %s", 
        		oldPassword));
        if (StringUtil.isEmpty(oldPassword))
        {// 参数不符合规范
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");
            
            log.info(String.format("ajaxCheckPassword parameter : oldPassword = %s --- "
            		+ "return result = %s", 
            		oldPassword, JsonHelper.formatJson(result)));
            return result;
        }

        P2p_user user = SecurityUserHolder.getCurrentUser();
        oldPassword = md5PasswordEncoder.encodePassword(oldPassword, user.getPuCustNo());

        if (!oldPassword.equals(user.getPuPassword()))
        {// 原密码错误
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u539f\u5bc6\u7801\u9519\u8bef");
            result.put(Const.retType, "oldpass");
        } else
        {
            result.put(Const.retCode, true);
        }
        log.info(String.format("ajaxCheckPassword parameter : oldPassword = %s --- "
        		+ "return result = %s", 
        		oldPassword, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 登录密码修改
     * 
     * @param oldPassword
     *            原密码
     * @param newPassword
     *            新密码
     * @param newPasswordSub
     *            确认新密码
     * @param client
     * @return
     */
    @RequestMapping("/updateLoginPass")
    @ResponseBody
    public Map<String, Object> modifyLoginPass(String oldPassword, String newPassword, String newPasswordSub)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("modifyLoginPass parameter : oldPassword = %s, "
        		+ "newPassword = %s, newPasswordSub = %s", 
        		oldPassword, newPassword, newPasswordSub));
        if (StringUtil.isEmpty(oldPassword) || StringUtil.isEmpty(oldPassword) || StringUtil.isEmpty(newPasswordSub))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303"); // 参数不符合规范

            log.info(String.format("modifyLoginPass parameter : oldPassword = %s, "
            		+ "newPassword = %s, newPasswordSub = %s --- return : result = %s", 
            		oldPassword, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
            return result;
        }

        if (!newPassword.equals(newPasswordSub))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 两次密码不一致
                    "\u4e24\u6b21\u5bc6\u7801\u4e0d\u4e00\u81f4");
            result.put(Const.retType, "passSub");
           
            log.info(String.format("modifyLoginPass parameter : oldPassword = %s, "
            		+ "newPassword = %s, newPasswordSub = %s --- return : result = %s", 
            		oldPassword, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
            return result;
        }

        P2p_user user = SecurityUserHolder.getCurrentUser();
        oldPassword = md5PasswordEncoder.encodePassword(oldPassword, user.getPuCustNo());
        if (!oldPassword.equals(user.getPuPassword()))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 原密码错误
                    "\u539f\u5bc6\u7801\u9519\u8bef");
            result.put(Const.retType, "oldpass");
            
            log.info(String.format("modifyLoginPass parameter : oldPassword = %s, "
            		+ "newPassword = %s, newPasswordSub = %s --- return : result = %s", 
            		oldPassword, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
            return result;
        } else
        {
            result.put("password", md5PasswordEncoder.encodePassword(newPassword, user.getPuCustNo()));

            result.put("custNo", user.getPuCustNo());
            result.put("registType", RegistType.PC.getIndex());

            result = userService.updateLoginPassword(result);
        }

        baseLog.writer(user.getPuCustNo(), "", "", BusinessType.CHANGEPASSWORD.getDesc(), RegistType.PC.getName(),
                "/account/updateLoginPass");
        
        log.info(String.format("modifyLoginPass parameter : oldPassword = %s, "
        		+ "newPassword = %s, newPasswordSub = %s --- return : result = %s", 
        		oldPassword, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 修改交易密码 - 验证原交易密码
     * 
     * @param oldpassworld
     *            原交易密码
     * @return
     */
    public Map<String, Object> ajaxCheckOldpassworld(String oldpassworld)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("ajaxCheckOldpassworld parameter : oldpassworld = %s", 
        		oldpassworld));
        if (StringUtil.isEmpty(oldpassworld))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "请输入原交易密码");
            result.put(Const.retType, "old");
            log.info(String.format("ajaxCheckOldpassworld parameter : oldpassworld = %s --- return result = %s", 
            		oldpassworld, JsonHelper.formatJson(result)));
            return result;
        }

        P2p_user user = SecurityUserHolder.getCurrentUser();
        try
        {
            P2p_cust_account custAccount = accountService.getCustAccountByCustNo(user.getPuCustNo(), false);

            if (!oldpassworld.equals(custAccount.getPcaPayPassword()))
            {// 原交易密码错误
                result.put(Const.retCode, false);
                result.put(Const.retMsg, "\u539f\u4ea4\u6613\u5bc6\u7801\u9519\u8bef");
                result.put(Const.retType, "old");
                
                log.info(String.format("ajaxCheckOldpassworld parameter : oldpassworld = %s --- return result = %s", 
                		oldpassworld, JsonHelper.formatJson(result)));
                return result;
            }
        } catch (Exception e)
        {
            log.error("ajaxCheckOldpassworld", e);
        }
        log.info(String.format("ajaxCheckOldpassworld parameter : oldpassworld = %s --- return result = %s", 
        		oldpassworld, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 修改交易密码
     * 
     * @param oldpassworld
     *            原交易密码
     * @param newPassword
     *            新密码
     * @param newPasswordSub
     *            确认新密码
     * @return
     */
    @RequestMapping("/updateTransPass")
    @ResponseBody
    public Map<String, Object> updateTransPassword(String oldpassworld, String newPassword, String newPasswordSub)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("updateTransPassword parameter : oldpassworld = %s,"
        		+ " newPassword = %s, newPasswordSub = %s", 
        		oldpassworld, newPassword, newPasswordSub));
        P2p_user user = SecurityUserHolder.getCurrentUser();

        try
        {
            P2p_cust_account custAccount = accountService.getCustAccountByCustNo(user.getPuCustNo(), false);
            if (!StringUtil.isEmpty(custAccount.getPcaPayPassword()))
            {
                baseLog.writer(user.getPuCustNo(), "", "", BusinessType.UPDATETRANSACTIONPASSWORD.getDesc(),
                        RegistType.PC.getName(), "/account/updateTransPass");

                if (StringUtil.isEmpty(oldpassworld))
                {
                    result.put(Const.retCode, false);
                    result.put(Const.retMsg, // 请输入原交易密码
                            "// 请输入原交易密码");
                    result.put(Const.retType, "old");
                    
                    log.info(String.format("updateTransPassword parameter : oldpassworld = %s,"
                    		+ " newPassword = %s, newPasswordSub = %s --- return result : %s", 
                    		oldpassworld, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
                    return result;
                }

                if (!oldpassworld.equals(custAccount.getPcaPayPassword()))
                {
                    result.put(Const.retCode, false);
                    result.put(Const.retMsg, // 原交易密码错误
                            "原交易密码错误");
                    result.put(Const.retType, "old");
                    
                    log.info(String.format("updateTransPassword parameter : oldpassworld = %s,"
                    		+ " newPassword = %s, newPasswordSub = %s --- return result : %s", 
                    		oldpassworld, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
                    return result;
                }
            } else
            {
                baseLog.writer(user.getPuCustNo(), "", "", BusinessType.INTERCALATETRANSACTIONPASSWORD.getDesc(),
                        RegistType.PC.getName(), "/account/updateTransPass");
            }
            result = updateTransPwd(result, newPassword, newPasswordSub, user, custAccount);
            
            log.info(String.format("updateTransPassword parameter : oldpassworld = %s,"
            		+ " newPassword = %s, newPasswordSub = %s --- return result : %s", 
            		oldpassworld, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
            return result;
        } catch (Exception e)
        {
            log.error("updateTransPassword", e);
            result.put(Const.retCode, false);
        }
        log.info(String.format("updateTransPassword parameter : oldpassworld = %s,"
        		+ " newPassword = %s, newPasswordSub = %s --- return result : %s", 
        		oldpassworld, newPassword, newPasswordSub, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 找回交易密码
     * 
     * @return
     */
    @RequestMapping("/findtranspassword")
    public String tofindtranspwd(HttpServletRequest request)
    {
    	log.info("updateTransPassword parameter : ");
        P2p_user user = SecurityUserHolder.getCurrentUser();

        baseLog.writer(user.getPuCustNo(), "", "", BusinessType.GETBACKTRANSACTIONPASSWORD.getDesc(),
                RegistType.PC.getName(), "/account/findtranspassword");
        log.info("updateTransPassword return : ");
        return "/personal/findTransPassword";
    }

    /**
     * 我的账户 - 找回交易密码 - 发送验证码
     * 
     * @param mobile
     * @return
     */
    @RequestMapping("/getTranspwdValidateCode")
    @ResponseBody
    public Map<String, Object> sendValidateCode(HttpServletRequest request)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info("sendValidateCode parameter : ");
        result.put(Const.retCode, true);

        P2p_user user = SecurityUserHolder.getCurrentUser();

        String mobile = user.getPuMobile();

        if (StringUtil.isEmpty(mobile))
        {
            result.put(Const.retCode, false);
            log.info(String.format("sendValidateCode parameter : --- return : result = %s", 
            		JsonHelper.formatJson(result)));
            return result;
        }

        try
        {
            result = sMSUtil.sendValidateCode(request, MessageType.TRADINGPASSWORD.getIndex(), mobile);
        } catch (Exception e)
        {
            result.put(Const.retCode, false);
            log.error("sendValidateCode", e);
        }
        log.info(String.format("sendValidateCode parameter : --- return : result = %s", 
        		JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 找回交易密码 - 验证短信验证码
     * 
     * @param code
     * @return
     */
    @RequestMapping("/checktranspwdvalidatecode")
    @ResponseBody
    public Map<String, Object> checktransvalidateCode(String code)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        
        log.info(String.format("checktransvalidateCode parameter : code = %s", 
        		code));
        result.put(Const.retCode, true);

        if (StringUtil.isEmpty(code))
        {
            result.put(Const.retMsg, // 请输入验证码
                    "\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801");
            result.put(Const.retCode, false);
            log.info(String.format("checktransvalidateCode parameter : code = %s --- return : result = %s", 
            		code, JsonHelper.formatJson(result)));
            return result;
        }

        P2p_user user = SecurityUserHolder.getCurrentUser();
        if (StringUtil.isEmpty(user.getPuMobile()))
        {
            result.put(Const.retCode, false);
            
            log.info(String.format("checktransvalidateCode parameter : code = %s --- return : result = %s", 
            		code, JsonHelper.formatJson(result)));
            return result;
        }

        String validatecode = jedisUtil.getValue(user.getPuMobile());
        if (StringUtil.isEmpty(validatecode))
        {
            result.put(Const.retMsg, // 验证码已失效，请重新获取
                    "\u9a8c\u8bc1\u7801\u5df2\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");
            result.put(Const.retCode, false);
            
            log.info(String.format("checktransvalidateCode parameter : code = %s --- return : result = %s", 
            		code, JsonHelper.formatJson(result)));
            return result;
        }

        if (!validatecode.equals(code))
        {
            result.put(Const.retMsg, // 验证码错误
                    "\u9a8c\u8bc1\u7801\u9519\u8bef");
            result.put(Const.retCode, false);
            
            log.info(String.format("checktransvalidateCode parameter : code = %s --- return : result = %s", 
            		code, JsonHelper.formatJson(result)));
            return result;
        }

        // 是否已验证标识
        jedisUtil.setValue(Const.SEND_VALIDATE_CODE_DATE.concat(user.getPuCustNo()), "verified", 60 * 10);
        
        log.info(String.format("checktransvalidateCode parameter : code = %s --- return : result = %s", 
        		code, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 找回交易密码 - 保存交易密码
     * 
     * @param newPassword
     *            新密码
     * @param newPasswordSub
     *            确认新密码
     * @return
     */
    @RequestMapping("/resetTransPassword")
    @ResponseBody
    public Map<String, Object> resetTransPassword(String newPassword, String newPasswordSub)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("resetTransPassword parameter : newPassword = %s, newPasswordSub = %s", 
        		newPassword, newPasswordSub));
        try
        {
            P2p_user user = SecurityUserHolder.getCurrentUser();

            String isVerified = jedisUtil.getValue(Const.SEND_VALIDATE_CODE_DATE.concat(user.getPuCustNo()));
            if (!StringUtil.isEmpty(isVerified) && isVerified.equals("verified"))
            {
                P2p_cust_account custAccount = accountService.getCustAccountByCustNo(SecurityUserHolder.getCustNo(),
                        false);
                result = updateTransPwd(result, newPassword, newPasswordSub, user, custAccount);
                
                log.info(String.format("resetTransPassword parameter : newPassword = %s, newPasswordSub = %s --- return : result = %s", 
                		newPassword, newPasswordSub, JsonHelper.formatJson(result)));
                return result;
            } else
            {// 验证已失效，请重新找回
                result.put(Const.retMsg, "\u9a8c\u8bc1\u5df2\u5931\u6548\uff0c\u8bf7\u91cd\u65b0\u627e\u56de");
                result.put(Const.retCode, false);
                result.put("type", "invalid");
                
                log.info(String.format("resetTransPassword parameter : newPassword = %s, newPasswordSub = %s --- return : result = %s", 
                		newPassword, newPasswordSub, JsonHelper.formatJson(result)));
                return result;
            }
        } catch (Exception e)
        {
            log.error("resetTransPassword", e);
        }

        result.put(Const.retCode, false);
        
        log.info(String.format("resetTransPassword parameter : newPassword = %s, newPasswordSub = %s --- return : result = %s", 
        		newPassword, newPasswordSub, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 交易密码方法
     * 
     * @throws Exception
     */
    private Map<String, Object> updateTransPwd(Map<String, Object> result, String newPassword, String newPasswordSub,
            P2p_user user, P2p_cust_account custAccount) throws Exception
    {
    	log.info(String.format("updateTransPwd parameter : result = %s, newPassword = %s,"
    			+ " newPasswordSub = %s, user = %s, custAccount = %s", 
        		JsonHelper.formatJson(result), newPassword, newPasswordSub, JsonHelper.formatJson(user), JsonHelper.formatJson(custAccount)));
        if (!newPassword.equals(newPasswordSub))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 两次交易密码不一致
                    "\u4e24\u6b21\u4ea4\u6613\u5bc6\u7801\u4e0d\u4e00\u81f4");
            result.put(Const.retType, "passsub");
            
            log.info(String.format("updateTransPwd parameter : result = %s, newPassword = %s,"
        			+ " newPasswordSub = %s, user = %s, custAccount = %s --- return : result = %s", 
            		JsonHelper.formatJson(result), newPassword, newPasswordSub, JsonHelper.formatJson(user), 
            		JsonHelper.formatJson(custAccount), JsonHelper.formatJson(result)));
            return result;
        }

        result.put("custNo", user.getPuCustNo());
        result.put("paypassword", newPassword);
        result.put("registType", RegistType.PC.getIndex());

        result = custAccountService.updateTransPassword(result);

        log.info(String.format("updateTransPwd parameter : result = %s, newPassword = %s,"
    			+ " newPasswordSub = %s, user = %s, custAccount = %s --- return : result = %s", 
        		JsonHelper.formatJson(result), newPassword, newPasswordSub, JsonHelper.formatJson(user), 
        		JsonHelper.formatJson(custAccount), JsonHelper.formatJson(result)));
        return result;
    }

    /*** 我的账户 - 电子邮箱strat */

    /**
     * 我的账户 - 发送邮箱验证码
     * 
     * @param oldEmail
     *            原邮箱
     * @param newEmail
     *            新邮箱
     * @return
     */
    @RequestMapping("/getEmailVer")
    @ResponseBody
    public Map<String, Object> getEmailVer(HttpServletRequest request,
            @RequestParam(value = "oldEmail", required = false) String oldEmail,
            @RequestParam(value = "newEmail", required = true) String newEmail)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        log.info(String.format("getEmailVer parameter : oldEmail = %s, newEmail = %s", 
        		oldEmail, newEmail));
        try
        {
            P2p_user user = SecurityUserHolder.getCurrentUser();
            if (StringUtil.isNotEmpty(user.getPuMail()))
            {
                if (!oldEmail.equals(user.getPuMail()))
                {
                    result.put(Const.retCode, false);
                    result.put(Const.retMsg, // 原电子邮箱不正确
                            "原电子邮箱不正确");
                    
                    log.info(String.format("getEmailVer parameter : oldEmail = %s, newEmail = %s --- return : result = %s", 
                    		oldEmail, newEmail, JsonHelper.formatJson(result)));
                    return result;
                }
            }

            result = sendEmail(request, newEmail);
        } catch (Exception e)
        {
            log.error("getEmailVer", e);
            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 新电子邮箱不正确
                    "新电子邮箱不正确");
        }
        log.info(String.format("getEmailVer parameter : oldEmail = %s, newEmail = %s --- return : result = %s", 
        		oldEmail, newEmail, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 发送邮件
     * 
     * @param userEmail
     *            邮箱地址
     */
    @RequestMapping("/sendEmail")
    public @ResponseBody Map<String, Object> sendEmail(HttpServletRequest request, String userEmail)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        log.info(String.format("sendEmail parameter : userEmail = %s", 
        		userEmail));
        Long validateSendTime = (Long) SessionUtils.getAttrFromSession(request, "validateSendTime");

        Boolean flag = false;
        String head = "绑定邮箱验证";
        String msg = RandomStringUtils.randomNumeric(6);

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("msg", msg);

        try
        {
            if (null != validateSendTime && !"".equals(validateSendTime))
            {
                long differ = System.currentTimeMillis() - validateSendTime;
                // 大于60秒
                if (differ >= 60000)
                {
                    flag = MailUtil.sendMail(userEmail, head, "findPassword.ftl", paramMap);
                    if (flag)
                    {
                        SessionUtils.putAttrInSession(request, "validateSendTime", System.currentTimeMillis());
                        SessionUtils.putAttrInSession(request, "validataCodeMsg", msg);
                        result.put(Const.retCode, true);
                        result.put(// 发送成功
                                Const.retMsg, "发送成功");
                        log.info(String.format("sendEmail parameter : userEmail = %s --- return : result = %s", 
                        		userEmail, JsonHelper.formatJson(result)));
                        return result;
                    } else
                    {
                        result.put(Const.retCode, false);
                        result.put(Const.retMsg, "发送失败");// 发送失败
                        
                        log.info(String.format("sendEmail parameter : userEmail = %s --- return : result = %s", 
                        		userEmail, JsonHelper.formatJson(result)));
                        return result;
                    }
                } else
                {
                    result.put(Const.retCode, false);
                    result.put(Const.retMsg, // 已发送，请耐心等待!
                            "已发送，请耐心等待!");
                    
                    log.info(String.format("sendEmail parameter : userEmail = %s --- return : result = %s", 
                    		userEmail, JsonHelper.formatJson(result)));
                    return result;
                }
            } else
            {
                flag = MailUtil.sendMail(userEmail, head, "findPassword.ftl", paramMap);
                if (flag)
                {
                    SessionUtils.putAttrInSession(request, "validateSendTime", System.currentTimeMillis());
                    SessionUtils.putAttrInSession(request, "validataCodeMsg", msg);

                    result.put(Const.retCode, true);
                    result.put(Const.retMsg, "发送成功");// 发送成功

                    log.info(String.format("sendEmail parameter : userEmail = %s --- return : result = %s", 
                    		userEmail, JsonHelper.formatJson(result)));
                    return result;
                } else
                {
                    result.put(Const.retCode, false);// 发送失败
                    result.put(Const.retMsg, "发送失败");
                    
                    log.info(String.format("sendEmail parameter : userEmail = %s --- return : result = %s", 
                    		userEmail, JsonHelper.formatJson(result)));
                    return result;
                }
            }
        } catch (Exception e)
        {
            log.error("sendEmail", e);

            result.put(Const.retCode, false);
            result.put(Const.retMsg, // 发送邮件失败
                    "发送邮件失败");
        }
        log.info(String.format("sendEmail parameter : userEmail = %s --- return : result = %s", 
        		userEmail, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 更改用户邮箱
     * 
     * @param oldEmail
     *            原邮箱
     * @param newEmail
     *            新邮箱
     * @param emailVer
     *            邮箱验证码
     * @return
     */
    @RequestMapping("/updateEmail")
    @ResponseBody
    public Map<String, Object> updateEmail(HttpServletRequest request,
            @RequestParam(value = "oldEmail", required = false) String oldEmail,
            @RequestParam(value = "newEmail", required = true) String newEmail,
            @RequestParam(value = "emailVer", required = true) String emailVer)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        log.info(String.format("updateEmail parameter : oldEmail = %s, newEmail = %s, emailVer = %s", 
        		oldEmail, newEmail, emailVer));
        try
        {
            P2p_user user = SecurityUserHolder.getCurrentUser();

            if (StringUtil.isNotEmpty(user.getPuMail()))
            {
                if (!oldEmail.equals(user.getPuMail()))
                {
                    result.put(Const.retCode, false);
                    result.put(Const.retMsg, // 原邮箱错误
                            "\u539f\u90ae\u7bb1\u9519\u8bef");
                    
                    log.info(String.format("updateEmail parameter : oldEmail = %s, newEmail = %s, emailVer = %s --- return : result = %s", 
                    		oldEmail, newEmail, emailVer, JsonHelper.formatJson(result)));
                    return result;
                }
            }

            String tempCode = (String) SessionUtils.getAttrFromSession(request, "validataCodeMsg");
            if (!emailVer.equals(tempCode))
            {
                result.put(Const.retCode, false);
                result.put(Const.retMsg, // 邮箱验证码错误
                        "\u90ae\u7bb1\u9a8c\u8bc1\u7801\u9519\u8bef");

                log.info(String.format("updateEmail parameter : oldEmail = %s, newEmail = %s, emailVer = %s --- return : result = %s", 
                		oldEmail, newEmail, emailVer, JsonHelper.formatJson(result)));
                return result;
            }

            // 更新用户邮箱（邮箱，邮箱绑定时间）
            result.put("mail", newEmail);
            result.put("custNo", user.getPuCustNo());

            result = userService.updateUserEmail(result);

            if (Boolean.valueOf(result.get(Const.retCode).toString()))
            {
                SessionUtils.putAttrInSession(request, "userPuMail", newEmail);
                SessionUtils.putAttrInSession(request, "isEmailAuth", 1);
            }
        } catch (Exception e)
        {
            log.error("updateEmail", e);
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u66f4\u65b0\u5931\u8d25");// 更新失败
        }
        
        log.info(String.format("updateEmail parameter : oldEmail = %s, newEmail = %s, emailVer = %s --- return : result = %s", 
        		oldEmail, newEmail, emailVer, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 我的账户 - 更改用户现住地址
     * 
     * @param newAddress
     *            现住地址
     * @return
     */
    @RequestMapping("/updateAddress")
    @ResponseBody
    public Map<String, Object> updateAddress(HttpServletRequest request,
            @RequestParam(value = "newAddress", required = true) String newAddress)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("updateAddress parameter : newAddress = %s", 
        		newAddress));
        try
        {
            String custNo = SecurityUserHolder.getCustNo();
            P2p_user_info info = userInfoService.getByCustNo(custNo);

            info.setPuiAddress(newAddress);

            int i = userInfoService.updataUserInfo(info);

            if (i > 0)
            {
                result.put(Const.retCode, true);
                result.put(Const.retMsg, // 更新用户信息成功
                        "\u66f4\u65b0\u7528\u6237\u4fe1\u606f\u6210\u529f");
            } else
            {
                result.put(Const.retCode, false);
                result.put(Const.retMsg, // 更新失败
                        "\u66f4\u65b0\u5931\u8d25");
            }
        } catch (Exception e)
        {
            log.error("updateAddress", e);
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u66f4\u65b0\u5931\u8d25");// 更新失败
        }
        
        log.info(String.format("updateAddress parameter : newAddress = %s --- return : result = %s", 
        		newAddress, JsonHelper.formatJson(result)));
        return result;
    }

    /**
     * 网银充值处理中页面
     * 
     * @param request
     * @param response
     * @return
     */
    /*#RequestMapping("/inHand")*/
    public String inHand(HttpServletRequest request, HttpServletResponse response)
    {
        return "/personal/inHand";
    }

    /**
     * 网银充值跳转空白页
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/toJump")
    public String toJump(HttpServletRequest request, HttpServletResponse response)
    {
        return "/personal/jump";
    }

    /**
     * 联动跳转页
     * 
     * @param request
     * @param response
     * @return
     */
    /*#RequestMapping("/toUmpayJump")*/
    public String toUmpayJump(HttpServletRequest request, @RequestParam("url") String url)
    {
    	log.info(String.format("toUmpayJump parameter : url = %s", 
    			url));
        request.setAttribute("url", url);
        
        log.info(String.format("toUmpayJump parameter : url = %s --- return : /personal/umpayJump", 
    			url));
        return "/personal/umpayJump";
    }
    
    @RequestMapping("/changeThirdPassword")
    public String changeThirdPassword(String nofityUrl, Model model)
        throws BusinessException
    {
    	log.info(String.format("changeThirdPassword parameter : nofityUrl = %s, model = %s", 
    			nofityUrl, JsonHelper.formatJson(model)));
        P2p_user user = SecurityUserHolder.getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            result = accountService.changePassword(
            	user.getPuCustNo(), nofityUrl);
        } catch (Exception e)
        {
            log.error("changeCard", e);
        }

        model.addAttribute("result", result);
        log.info(String.format("changeThirdPassword parameter : nofityUrl = %s, model = %s --- return : model = %s", 
    			nofityUrl, JsonHelper.formatJson(model), JsonHelper.formatJson(model)));
        return "/personal/jump";
    }
    
    @RequestMapping("/changeCard")
    public String changeCard(String notifyUrl, Model model)
        throws BusinessException
    {
        P2p_user user = SecurityUserHolder.getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();
        log.info(String.format("changeCard parameter : notifyUrl = %s, model = %s", 
        		notifyUrl, JsonHelper.formatJson(model)));
        try
        {
            result = accountService.changeCard(user.getPuCustNo(), notifyUrl, null);
        } catch (Exception e)
        {
            log.error("changeCard", e);
        }

        model.addAttribute("result", result);
        log.info(String.format("changeCard parameter : notifyUrl = %s, model = %s --- return : model = %s", 
        		notifyUrl, JsonHelper.formatJson(model), JsonHelper.formatJson(model)));
        return "/personal/jump";
    }
    
    
    @ResponseBody
    @RequestMapping("/refreshCard")    
    public Map<String,Object> refreshCard() 
    {
    	
    	log.info("refreshCard parameter : ");
    	
        Map<String,Object> result = new HashMap<String,Object>();
        
        String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
        P2p_cust_account custAccount = custAccountService.queryIdentityId(custNo);
        
        boolean flag  = this.bankCardService.refreshCard(custAccount.getPcaAccountno(),custNo);
        
        result.put("retCode", flag);
        
        log.info(String.format("refreshCard parameter : --- return : result = %s", 
        		 JsonHelper.formatJson(result)));
        return result;
    }
    
    
    
    @RequestMapping("/changePhone")
    public String changePhone(String notifyUrl, Model model)
        throws BusinessException
    {
        P2p_user user = SecurityUserHolder.getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();

        log.info(String.format("changePhone parameter : notifyUrl = %s, model = %s", 
        		notifyUrl, JsonHelper.formatJson(model)));
        try
        {
            result = accountService.changePhone(user.getPuCustNo(), notifyUrl);
        } catch (Exception e)
        {
            log.error("changeCard", e);
        }

        model.addAttribute("result", result);
        log.info(String.format("changePhone parameter : notifyUrl = %s, model = %s --- return : model = %s", 
        		notifyUrl, JsonHelper.formatJson(model), JsonHelper.formatJson(model)));
        return "/personal/jump";
    }
    
    @RequestMapping("/changePassword")
    public String changePassword(String notifyUrl, Model model)
        throws BusinessException
    {
        P2p_user user = SecurityUserHolder.getCurrentUser();
        Map<String, Object> result = new HashMap<String, Object>();
        
        log.info(String.format("changePassword parameter : notifyUrl = %s, model = %s", 
        		notifyUrl, JsonHelper.formatJson(model)));
        try
        {
            result = accountService.changePassword(
            	user.getPuCustNo(), notifyUrl);
        } catch (Exception e)
        {
            log.error("changeCard", e);
        }

        model.addAttribute("result", result);

        log.info(String.format("changePassword parameter : notifyUrl = %s, model = %s --- return : model = %s", 
        		notifyUrl, JsonHelper.formatJson(model), JsonHelper.formatJson(model)));
        return "/personal/jump";
    }
}
