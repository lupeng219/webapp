package com.baibao.web.p2p.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.alibaba.fastjson.JSONObject;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.pay.GetUniqueNoService;
import com.baibao.pay.PayService;
import com.baibao.pay.data.AccountInfoRequest;
import com.baibao.pay.data.AccountInfoResponse;
import com.baibao.pay.data.ActiveAccountRequest;
import com.baibao.pay.data.ActiveAccountResponse;
import com.baibao.pay.data.BankCard;
import com.baibao.pay.data.ModifyAccountRequest;
import com.baibao.pay.data.PayRequest;
import com.baibao.pay.data.PayResponse;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_bank_type;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_public_order;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.pay.sina.util.GsonUtil;
import com.baibao.web.p2p.repository.BankCardRepository;
import com.baibao.web.p2p.repository.CustAccountRepository;
import com.baibao.web.p2p.repository.Pay_MessageRepository;
import com.baibao.web.p2p.repository.PublicOrderRepository;
import com.baibao.web.p2p.repository.UserInfoRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.web.p2p.service.BankCardService;
import com.baibao.web.p2p.service.RestTemplateService;

import jodd.bean.BeanUtil;

@Service("bankCardService")
public class BankCardServiceImpl implements BankCardService {

    private static final Logger logger = LoggerFactory.getLogger(BankCardServiceImpl.class);

    public static final String IDENTITY_TYPE = "UID";// 用户标识类型
    public static final String VERIFY_MODE = "SIGN";// 卡认证方式
    public static final String SERVICE_FIRST = "binding_bank_card";
    public static final String SERVICE_SECOND = "binding_bank_card_advance";
    public static final String CARD_TYPE = "DEBIT";// 卡类型
    public static final String CERT_TYPE = "IC";// 证件类型-身份证
    public static final String ACCOUNT_B = "00";// 账户类型-企业
    public static final String ACCOUNT_C = "01";// 账户类型-个人

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private BankCardRepository BankCardRepository;
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private BankCardRepository bankCardRepository;
    @Autowired
    private CustAccountRepository custAccountRepository;
    @Autowired
    private RestTemplateService restTemplateService;
    @Autowired
    private GetUniqueNoService getUniqueNoService;
    @Autowired
    private PublicOrderRepository publicOrderRepository;
    @Autowired
    private PayService payService;
    @Autowired
    private Pay_MessageRepository pay_MessageRepository;

    @Autowired
    private P2p_bank_typeMapper bankTypeDao;

    @Override
    // @Transactional(readOnly = false)
    public Map<String, Object> bankCardBinding(Map<String, Object> params)
    	throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, String> bankparams = new HashMap<String, String>();

        String custNo = params.get("custNo").toString();
        String bankCardNo = params.get("bankCardNo").toString();
        String bankCode = params.get("bankCode").toString();
        String province = params.get("province").toString();
        String city = params.get("city").toString();
        String cityid = params.get("cityid").toString();
        String phoneNo = params.get("phoneNo").toString();

        // 查询用户是否绑定银行卡(推进完成的)
        P2p_bank_card p2pBankCard = null;
        //TODO: 富友一步绑卡，不会出现半步情况
//        P2p_bank_card p2pBankCard = BankCardRepository.getBankCardByCustNo(custNo);
//
//        if (null != p2pBankCard && p2pBankCard.getPbcIfadvance() != null && p2pBankCard.getPbcIfadvance().equals("01"))
//        {
//            result.put(Const.retCode, false);
//            result.put(Const.retMsg, "/已经添加过银行卡");// 已经添加过银行卡
//
//            logger.error("已经添加过银行卡");// 已经添加过银行卡
//
//            return result;
//        }

        // 查询添加银行卡
        P2p_bank_type bankType = bankTypeDao.getBankType(bankCode);

        if (bankType == null)
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "银行不存在");

            logger.error("银行不存在");// 银行不存在

            return result;
        }

        /** 组装绑定银行卡数据 */
        P2p_cust_account account = custAccountRepository.queryIdentityId(custNo);
        if (account == null)
        {
            result.put(Const.retCode, false);
            logger.error("用户账户表不存在");// 用户账户表不存在
            return result;
        }

        PayRequest request = null;

        //判断是否，已经绑定支付渠道。
        if (StringUtils.isBlank(account.getPcaAccountno()))
        {
            ActiveAccountRequest activeRequest = new ActiveAccountRequest();

            P2p_user_info userinfo = userInfoRepository.getUserInfo(account.getPcaCustNo());
            //P2p_user user = usersRepository.findUserByCustNo(account.getPcaCustNo());

            activeRequest.setCustomName(userinfo.getPuiRealName());
            activeRequest.setCertId(userinfo.getPuiCertNo());
            activeRequest.setPhone(phoneNo);

            request = activeRequest;
        } else
        {
            AccountInfoRequest accountInfoRequest = new AccountInfoRequest();

            accountInfoRequest.setAccountId(account.getPcaAccountno());

            AccountInfoResponse accountInfoResponse = payService.getAccountInfo(accountInfoRequest);

            accountInfoResponse.setPhone(phoneNo);

            request = JsonHelper.convert(accountInfoResponse, ModifyAccountRequest.class);
        }

        request.setTradeNo(getUniqueNoService.getActiveAccountFlow());

        /*
         * P2p_bank_card p2pBankCard = new P2p_bank_card(); String accountNo =
         * ""; if( null != account ) { //支付账号 accountNo =
         * account.getPcaAccountno(); p2pBankCard.setPbcAccountno(accountNo);
         * //卡属性 if(null != account.getPcaAccounttype()){
         * if(ACCOUNT_B.equals(account.getPcaAccounttype())){
         * //"00"表示账号类型为企业，则卡属性为对公 bankparams.put("card_attribute",
         * BankCardAttribute.B.name());
         * p2pBankCard.setPbcCardAttribute(BankCardAttribute.B.name()); }else
         * if(ACCOUNT_C.equals(account.getPcaAccounttype())){
         * //"01"表示账号类型为个人，则卡属性为对私 bankparams.put("card_attribute",
         * BankCardAttribute.C.name());
         * p2pBankCard.setPbcCardAttribute(BankCardAttribute.C.name()); } } }
         * else { result.put(Const.retCode, false);
         * logger.error("\u7528\u6237\u8d26\u6237\u8868\u4e0d\u5b58\u5728");//
         * 用户账户表不存在 return result; }
         */

        P2p_bank_card oldBankCard = p2pBankCard;

        p2pBankCard = new P2p_bank_card();

        // 银行简称和名称
        p2pBankCard.setPbcBankcode(bankCode);
        p2pBankCard.setPbcBankName(bankType.getBankDesc());
        // 银行卡号
        p2pBankCard.setPbcBankcardno(bankCardNo);
        // 省市名称
        p2pBankCard.setPbcProvinceName(province);
        p2pBankCard.setPbcCityName(city);
        // 预留手机
        p2pBankCard.setPbcPhoneNo(phoneNo);
        // 卡类型
        p2pBankCard.setPbcCardType(CARD_TYPE);
        // 证件类型
        p2pBankCard.setPbcCertType(CERT_TYPE);
        // 用户编号
        p2pBankCard.setPbcCustno(custNo);

        BankCard bankCard = new BankCard();

        bankCard.setBankId(bankType.getBankCode());
        bankCard.setBankName(bankType.getBankDesc());

        bankCard.setCardNumber(bankCardNo);
        bankCard.setCityId(cityid);

        BeanUtil.setProperty(request, "bankCard", bankCard);

        // 查询用户详细信息
        P2p_user_info userInfo = userInfoRepository.getUserInfo(custNo);
        if (null != userInfo)
        {
            // 证件号码
            p2pBankCard.setPbcCertNo(userInfo.getPuiCertNo());
            // 户名
            p2pBankCard.setPbcBankcardname(userInfo.getPuiRealName());
        } else
        {
            result.put(Const.retCode, false);
            logger.error("用户基本信息表不存在");// 用户基本信息表不存在
            return result;
        }

        /*** 存入订单表 
        JSONObject jsonParams = (JSONObject) JSONObject.toJSON(bankparams);

        P2p_public_order publicOrder = new P2p_public_order();

        publicOrder.setPpoOrderflowno(request.getTradeNo());
        publicOrder.setPpoCustno(custNo);
        publicOrder.setPpoBussType(Integer.valueOf(Const.bindcard));
        publicOrder.setPpoOrderTime(new Date());
        publicOrder.setPpoAccountchannel("FUYOU");
        publicOrder.setPpoStatus(Const.processing);// 处理中
        publicOrder.setPpoParams(jsonParams.toString());

        publicOrderRepository.insertPublicOrder(publicOrder);*/

        logger.info("调用绑卡接口开始");// 调用绑卡接口开始

        PayResponse payResponse = null;

        if (request instanceof ActiveAccountRequest)
        {
            ActiveAccountResponse activeAccountResponse = payService.activeAccount((ActiveAccountRequest) request);

            if (activeAccountResponse.isOk())
            {
                account.setPcaAccountno(activeAccountResponse.getAccountId());

                custAccountRepository.updateByPrimaryKeySelective(account);
            } else
            {
                result.put(Const.retCode, false);
                
                String message = pay_MessageRepository.getPayChannelMessage(String.valueOf( activeAccountResponse.getStatus()));                
                result.put(Const.retMsg, String.format("绑卡异常：%s （%d）", message,activeAccountResponse.getStatus() ));

                return result;
            }

            payResponse = activeAccountResponse;
        } else if (request instanceof ModifyAccountRequest)
        {
            payResponse = payService.modifyAccount((ModifyAccountRequest) request);
        }

        // 认证方式
        p2pBankCard.setPbcAccountno(account.getPcaAccountno());
        p2pBankCard.setPbcVerifyMode(VERIFY_MODE);

        int count = 0;
        if (null == oldBankCard)
        {
            count = bankCardRepository.saveBankCard(p2pBankCard);
        } else
        {
            count = bankCardRepository.updateBankcardBycustNo(p2pBankCard);
        }

        if (payResponse.getStatus() == PayResponse.OK)
        {
            P2p_bank_card p2pBankCardupdate = new P2p_bank_card();

            p2pBankCardupdate.setPbcBankcardno(bankCardNo);
            p2pBankCardupdate.setPbcIfadvance(Const.ALREADYADVANCE);
            p2pBankCardupdate.setPbccardId("");
            p2pBankCardupdate.setPbcResponseCode(String.valueOf(payResponse.getStatus()));
            p2pBankCardupdate.setPbcIssafecard("Y");

            count = bankCardRepository.updateBankcardByNo(p2pBankCardupdate);

            if (count == 0)
            {
                logger.error("更新银行卡信息时出现异常");// 更新银行卡信息时出现异常
                throw new BusinessException("更新银行卡信息时出现异常");// 更新银行卡信息时出现异常
            }

            result.put(Const.retCode, true);
            result.put(Const.retMsg, "绑卡成功");// 绑卡成功
        } else
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, payResponse.getMessage());
            
            throw new BusinessException("添加银行卡出现异常");
        }

        result.put("bankparams", bankparams);
        result.put("sinaRetMap", bankparams);

        return result;
    }

    /**
     * 调用绑卡推进接口
     * 
     * @param request
     * @return
     * @author liuchangyan
     */
    @Override
    // @Transactional(readOnly = false)
    public Map<String, Object> bankCardBindingAdvance(Map<String, String> params) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        String bankCardNo = params.get("bankCardNo");
        String ticket = jedisUtil.getValue(bankCardNo);
        if (StringUtil.isEmpty(ticket))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "短信验证码已超时，请重新获取");// 短信验证码已超时，请重新获取
            return result;
        }

        result.put(Const.retCode, true);
        result.put(Const.retMsg, "绑卡成功");// 绑卡成功

        /*
         * params.put("ticket",ticket); logger.info(
         * "\u8c03\u7528\u7ed1\u5361\u63a8\u8fdb\u63a5\u53e3\u5f00\u59cb");
         * 
         * //Map<String, Object> map =
         * bindingBankCardAdvanceHandler.handle(params); Map<String, Object> map
         * = payService.binding_bank_card_advance(params);
         * 
         * logger.info(
         * "\u8c03\u7528\u7ed1\u5361\u63a8\u8fdb\u63a5\u53e3\u7ed3\u675f");
         * 
         * //调用接口返回值 String retCode = ""; String cardId = ""; String
         * response_code = ""; String response_message = ""; if(null != map &&
         * null != map.get("retCode")){ retCode = ((map.get("retCode"))
         * instanceof String) ? (String)map.get("retCode") : "";
         * 
         * } if(null != map && null != map.get("response_code")){ response_code
         * = ((map.get("response_code")) instanceof String) ?
         * (String)map.get("response_code") : "";
         * 
         * } if(null != map && null != map.get("response_message")){
         * response_message = ((map.get("response_message")) instanceof String)
         * ? (String)map.get("response_message") : "";
         * 
         * } if(ControllerRetType.OPT_SUCC.getTransCode().equals(retCode)){
         * cardId = ((map.get("card_id")) instanceof String) ?
         * (String)map.get("card_id") : ""; P2p_bank_card bankCard = new
         * P2p_bank_card(); bankCard.setPbcBankcardno(bankCardNo); String
         * dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new
         * Date()); bankCard.setPbcInputtime(dateStr); //完成推进
         * bankCard.setPbcIfadvance(Const.ALREADYADVANCE); //完成认证
         * bankCard.setPbcResponseCode(response_code);
         * bankCard.setPbccardId(cardId); int count
         * =bankCardRepository.updateBankcardByNo(bankCard); int num=0;
         * P2p_bank_card bc
         * =bankCardRepository.getBankCardByBankCardNo(bankCard.getPbcBankcardno
         * ()); if(null!=bc&&bc.getPbccardId()!=null&&bc.getPbccardId()!=""&&bc.
         * getPbcIfadvance()!=null&&bc.getPbcIfadvance()!=""){ num=1; }
         * if(count==1&&num==1){ result.put(Const.retCode, true);
         * result.put(Const.retMsg, "\u7ed1\u5361\u6210\u529f");//绑卡成功 return
         * result; }else{ result.put(Const.retCode, false);
         * result.put(Const.retMsg, "\u7ed1\u5361\u5931\u8d25");//绑卡失败 return
         * result; }
         * 
         * }else{ result.put(Const.retCode, false);
         * if(StringUtil.isEmpty(response_message)){ response_message =
         * "\u7ed1\u5361\u5931\u8d25";//绑卡失败 }
         * result.put(Const.retMsg,response_message); } result.put("params",
         * params); result.put("map", map);
         */
        return result;
    }

    @Override
    public P2p_bank_card getBankCardByCustNo(String custNo) throws Exception
    {
        return bankCardRepository.getBankCardByCustNo(custNo);
    }

    @Override
    public P2p_bank_card getBankCardByBankCardNo(String bankCardNo)
    {
        return bankCardRepository.getBankCardByBankCardNo(bankCardNo);
    }

    // @Transactional
    @Override
    public Map<String, Object> unbindingbankCardNew(Map<String, String> params, String custNo, String bankCardNo)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();

        result.put(Const.retCode, false);
        result.put(Const.retMsg, "\u7ed1\u5361\u64cd\u4f5c\u5931\u8d25");// 绑卡操作失败

        /*
         * try {
         * logger.info("\u8c03\u7528\u89e3\u7ed1\u63a5\u53e3\u5f00\u59cb");//
         * 调用解绑接口开始
         * 
         * //map = unbindingBankCardHandler.handle(params); //map =
         * payService.unbinding_bank_card(params);
         * 
         * logger.info("\u8c03\u7528\u89e3\u7ed1\u63a5\u53e3\u7ed3\u675f");//
         * 调用解绑接口结束 String retCode=""; if(null != map && null !=
         * map.get("retCode")){ retCode = ((map.get("retCode")) instanceof
         * String) ? (String)map.get("retCode") : ""; } String ticket = "";
         * String cardId = "";
         * if(ControllerRetType.OPT_SUCC.getTransCode().equals(retCode)){
         * 
         * ticket = ((map.get("ticket")) instanceof String) ?
         * (String)map.get("ticket") : ""; cardId = ((map.get("card_id"))
         * instanceof String) ? (String)map.get("card_id") : "";
         * //存入redis，绑卡推进时使用 jedisUtil.setValue(bankCardNo, ticket,60*15);//
         * 15分钟缓存 // bankCardRepository.deleteBankCardByCustNo(custNo);
         * result.put(Const.retCode, true); result.put(Const.retMsg,
         * "\u64cd\u4f5c\u6210\u529f");//操作成功 }else{ result.put(Const.retCode,
         * false); result.put(Const.retMsg,
         * map.get("response_message")==null?"":map.get("response_message")); }
         * } catch (Exception e) {
         * logger.error("\u7ed1\u5361\u64cd\u4f5c\u5931\u8d25",e);//绑卡操作失败
         * result.put(Const.retCode, false); result.put(Const.retMsg,
         * "\u7ed1\u5361\u64cd\u4f5c\u5931\u8d25");//绑卡操作失败 }
         * result.put("params", params); result.put("map", map);
         */

        return result;
    }

    public String getUserCustNo() throws BusinessException
    {
        MultiValueMap<String, String> postCoreTrans = new LinkedMultiValueMap<String, String>();

        postCoreTrans.add("tranCode", "1001");
        postCoreTrans.add("tranType", "100101");

        try
        {
            String returnJSON = restTemplateService.postForEntity(postCoreTrans);
            Map<String, Object> result = GsonUtil.fronJson2Map(returnJSON);

            return (String) result.get("custNo");
        } catch (Exception e)
        {
            logger.error("getUserCustNo", e);
            throw new BusinessException("获取客户号异常" + e);
        }
    }

    @Override
    public Map<String, Object> unbindingbankCardAdvance(Map<String, String> params, String custNo, String bankCardNo)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put(Const.retCode, false);
        result.put(Const.retMsg, "\u7ed1\u5361\u64cd\u4f5c\u5931\u8d25");// 绑卡操作失败

        /*
         * String ticket = jedisUtil.getValue(bankCardNo);
         * if(StringUtil.isEmpty(ticket)){ result.put(Const.retCode, false);
         * result.put(Const.retMsg,
         * "\u77ed\u4fe1\u9a8c\u8bc1\u7801\u5df2\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6"
         * );//短信验证码已超时，请重新获取 return result; } params.put("ticket",ticket);
         * 
         * //Map<String, Object> map =
         * unbindingBankCardAdvanceHandler.handle(params); Map<String, Object>
         * map = payService.unbinding_bank_card_advance(params);
         * 
         * //调用接口返回值 String retCode = ""; String response_message = ""; if(null
         * != map && null != map.get("retCode")){ retCode =
         * ((map.get("retCode")) instanceof String) ? (String)map.get("retCode")
         * : "";
         * 
         * } if(null != map && null != map.get("response_message")){
         * response_message = ((map.get("response_message")) instanceof String)
         * ? (String)map.get("response_message") : "";
         * 
         * } if(ControllerRetType.OPT_SUCC.getTransCode().equals(retCode)){
         * bankCardRepository.deleteBankCardByCustNo(custNo);
         * result.put(Const.retCode, true); result.put(Const.retMsg,
         * "\u89e3\u7ed1\u6210\u529f");//解绑成功 return result; }else{
         * result.put(Const.retCode, false);
         * if(StringUtil.isEmpty(response_message)){ response_message =
         * "\u89e3\u7ed1\u5931\u8d25";//解绑失败 } result.put(Const.retMsg,
         * response_message); }
         */

        return result;
    }

    @Override
    public Map<String, Object> unbindingbankCard(Map<String, String> params, String custNo)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();

        result.put(Const.retCode, true);
        result.put(Const.retMsg, "\u7ed1\u5361\u6210\u529f");// 绑卡成功

        /*
         * try {
         * logger.info("\u8c03\u7528\u89e3\u7ed1\u63a5\u53e3\u5f00\u59cb");//
         * 调用解绑接口开始
         * 
         * //map = unbindingBankCardHandler.handle(params); map =
         * payService.unbinding_bank_card(params);
         * 
         * logger.info("\u8c03\u7528\u89e3\u7ed1\u63a5\u53e3\u7ed3\u675f");//
         * 调用解绑接口结束 String retCode=""; if(null != map && null !=
         * map.get("retCode")){ retCode = ((map.get("retCode")) instanceof
         * String) ? (String)map.get("retCode") : ""; }
         * if(ControllerRetType.OPT_SUCC.getTransCode().equals(retCode)){
         * bankCardRepository.deleteBankCardByCustNo(custNo);
         * result.put(Const.retCode, true); result.put(Const.retMsg,
         * "\u64cd\u4f5c\u6210\u529f");//操作成功 }else{ result.put(Const.retCode,
         * false); result.put(Const.retMsg,
         * map.get("response_message")==null?"":map.get("response_message")); }
         * } catch (Exception e) {
         * logger.error("\u7ed1\u5361\u64cd\u4f5c\u5931\u8d25",e);//绑卡操作失败
         * result.put(Const.retCode, false); result.put(Const.retMsg,
         * "\u7ed1\u5361\u64cd\u4f5c\u5931\u8d25");//绑卡操作失败 }
         * result.put("params", params); result.put("map", map);
         */

        return result;
    }
    
    
    @Override
    @Transactional
    public boolean refreshCard(String accountno, String custNo)
    	throws BusinessException 
    {
        boolean result = false;
        
        AccountInfoRequest request = new AccountInfoRequest();
        request.setAccountId(accountno);
        
        //本地有效银行卡
        P2p_bank_card p2p_card =
        	bankCardRepository.getBankCardByCustNo(custNo);

        if (p2p_card == null)
        	throw new BusinessException("您还没有绑卡");

        //富友当前银行卡
        AccountInfoResponse response =
        	payService.getAccountInfo(request);
        BankCard card = response.getBankCard();

        if (card == null)
        	throw new BusinessException("富友同步银行信息失败");
        
        //富友和本地卡片信息不一致时，更新本息card信息
        if (!card.getCardNumber().equals(p2p_card.getPbcBankcardno()) ||
        	!card.getBankId().equals(p2p_card.getPbcBankcode()))
        {//更新时清空类型，这个字段目前没有。为了避免以后存在数据二义性。
            p2p_card.setPbcBankcardno(card.getCardNumber());                                  
            p2p_card.setPbcBankcode(card.getBankId()); 
            
            P2p_bank_type bankType =
            	this.bankTypeDao.getBankType(p2p_card.getPbcBankcode());
            p2p_card.setPbcBankName(bankType.getBankDesc());
            
            int count =
            	bankCardRepository.updateBankcardBycustNo(p2p_card);
            result = (count == 1);
        }
                
        return result;       
    }
    

}
