package com.baibao.web.p2p.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_bank_card;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_bank_typeMapper;
import com.baibao.web.p2p.repository.AccountRepository;
import com.baibao.web.p2p.repository.BankCardRepository;
import com.baibao.web.p2p.repository.UserInfoRepository;
import com.baibao.web.p2p.service.AccountFlowService;

/**
 * 账户信息
 * 
 * @author Denny
 * @date 2016年5月12日
 */
@Service("accountFlowService")
public class AccountFlowServiceImpl implements AccountFlowService {
    @Autowired
    private BankCardRepository bankCardRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private P2p_bank_typeMapper bankTypeDao;

    @Override
    public Map<String, Object> toRecharge(String custNo, String mobile) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        P2p_user_info info = userInfoRepository.getUserInfo(custNo);

        // 检查是否实名认证
        if (null != info && info.getPuiPlataccountiscert().equals(Const.ALREADYCERTIFIED))
        {
            // 已认证用户
            P2p_cust_account account = accountRepository.getCustAccountByIdOrCustNo(custNo);

            // 检查是否绑定银行卡
            P2p_bank_card banCard = bankCardRepository.getBankCardByCustNo(custNo);
            if (banCard != null && Const.ALREADYADVANCE.equals(banCard.getPbcIfadvance()))
            {
                result.put("bankType", bankTypeDao.getBankType(banCard.getPbcBankcode()));
                banCard.setPbcBankcardno(StringUtil.replaceBankNoName(banCard.getPbcBankcardno()));
                result.put("bankCard", banCard);
            } else
            {
                result.put("personalEbank", bankTypeDao.getPersonalEbank());
            }

            // 可用余额
            result.put("balance", account.getPcaAccountBalance());
            // 用户详细
            result.put("info", info);
            // 用户手机号
            result.put("mobile", mobile);

            // 是否设置交易密码
            if (!StringUtil.isEmpty(account.getPcaPayPassword()))
            {
                result.put("isSetPcaPayPassword", 1);// 已设置交易密码
            } else
            {
                result.put("isSetPcaPayPassword", 0);// 未设置交易密码
            }

            result.put("personalHhortcut", bankTypeDao.getPersonalHhortcut());
        } else
        {// 未认证用户
            result.put("realName", info.getPuiRealName());
            result.put("idCard", info.getPuiCertNo());
        }

        return result;
    }

    @Override
    public Map<String, Object> toWithDrawals(String custNo, String mobile) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        P2p_user_info info = userInfoRepository.getUserInfo(custNo);

        // 检查是否实名认证
        if (null != info && info.getPuiPlataccountiscert().equals(Const.ALREADYCERTIFIED))
        {
            P2p_bank_card bankCard = bankCardRepository.getBankCardByCustNo(custNo);
            if (bankCard == null || StringUtil.isEmpty(bankCard.getPbcIfadvance())
                    || bankCard.getPbcIfadvance().equals(Const.NOTADVANCING))
            {// 是否完成推进00未完成 01 已完成
                result.put("personalEbank", bankTypeDao.getPersonalEbank());
                result.put("puiRealName", info.getPuiRealName());
                result.put("mobile", mobile);

                return result;
            }

            result.put("banCard", bankCard);

            P2p_cust_account account = accountRepository.getCustAccountByIdOrCustNo(custNo);

            if (account != null)
            {
                result.put("balance", account.getPcaAccountBalance());
            }

            // 是否设置交易密码
            if (!StringUtil.isEmpty(account.getPcaPayPassword()))
            {
                result.put("isSetPcaPayPassword", 1);// 已设置交易密码
            } else
            {
                result.put("isSetPcaPayPassword", 0);// 未设置交易密码
            }
        } else
        {
            // 未认证用户
            result.put("puiPlataccountiscert", Const.NOTCERTIFIED);
            result.put("realName", info.getPuiRealName());
            result.put("idCard", info.getPuiCertNo());
        }

        return result;
    }
}
