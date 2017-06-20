package com.baibao.web.p2p.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.bean.P2p_user_reg_channel;
import com.baibao.web.p2p.generator.bean.p2p_user_friends;
import com.baibao.web.p2p.generator.dao.P2p_cust_accountMapper;
import com.baibao.web.p2p.generator.dao.P2p_userMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_friendsMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_infoMapper;
import com.baibao.web.p2p.generator.dao.P2p_user_reg_channelMapper;
import com.baibao.web.p2p.generator.dataDIC.CustAccountStatus;
import com.baibao.web.p2p.repository.UsersRepository;

@Repository
public class UsersRepositoryImpl implements UsersRepository {
    private static Logger logger = LoggerFactory.getLogger(UsersRepositoryImpl.class);

    @Autowired
    private P2p_cust_accountMapper custAccountMapper;
    @Autowired
    private Md5PasswordEncoder passwordEncode;
    @Autowired
    private P2p_userMapper userMapper;
    @Autowired
    private P2p_user_infoMapper userInfoMapper;
    @Autowired
    private P2p_user_reg_channelMapper regChannelMapper;
    @Autowired
    private P2p_user_friendsMapper p2p_user_friendsMapper;
    @Autowired
    private BaseLog baseLog;

    /**
     * 保存用户注册信息(用户登录信息、用户详细信息、用户注册渠道信息、邀请信息)
     * @param phone 手机号
     * @param passd 登录密码
     * @param friendMobile 推荐人手机号
     * @param channel 注册来源
     * @param openId
     * @param custNo 客户号
     * @return
     * @throws BusinessException
     */
    @Override
    public Map<String, Object> saveRegisterInfo(
    	String phone, String passd, String friendMobile,
    	String channel, String openId, String custNo)
    		throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result.put(Const.retCode, false);
        result.put(Const.retMsg, "保存注册信息失败");

        // 保存登录信息
        P2p_user user = new P2p_user();

        user.setPuCustNo(custNo);

        String password =
        	passwordEncode.encodePassword(passd, custNo);

        user.setPuPassword(password);
        user.setPuMobile(phone);
        user.setPuEnabled(0);
        user.setPuAccountNonExpired(0);
        user.setPuAccountNonLocked(0);
        user.setPuCredentialsNonExpired(0);
        user.setPuInviteCode(//佰宝金服邀请码
        	Const.INVITE_CODE + getFixLenthStringContinChar(7));

        int userCount = userMapper.saveUser(user);

        // 插入用户详细信息记录
        Date date = new Date();
        P2p_user_info userInfo = new P2p_user_info();

        userInfo.setPuiCustno(custNo);
        userInfo.setPuiMobilebindtime(date);
        userInfo.setPuiRegistrationTime(date);
        userInfo.setPuiPlataccountiscert(Const.NOTCERTIFIED);// 是否认证

        int userInfoCount = userInfoMapper.save(userInfo);

        // 保存注册渠道信息
        P2p_user_reg_channel regChannel = new P2p_user_reg_channel();

        regChannel.setPucCustno(custNo);
        regChannel.setPucChannel(channel);
        regChannel.setPucWxopenid(openId);

        int regChannelCount = regChannelMapper.saveRegChannel(regChannel);

        // 保存第三方账户信息
        BigDecimal amount = new BigDecimal("0.00");
        P2p_cust_account cusAccount = new P2p_cust_account();

        cusAccount.setPcaCustNo(custNo);
        cusAccount.setPcaAccountno(null);
        cusAccount.setPcaAccountOpenTime(new Date());
        cusAccount.setPcaAccounttype("01");     // 00 企业 01 个人
        cusAccount.setPcaCustodyType("1");      // 1.富友
        cusAccount.setPcaAccountBalance(amount);
        cusAccount.setPcaAccountFreeze(amount);
        cusAccount.setPcaStatus(CustAccountStatus.NOTACTIVATED.getIndex());// 10使用中 11冻结 12未激活

        int custAccountCount = custAccountMapper.save(cusAccount);
        
        // 保存邀请信息
        int userFriendsCount = 0;

        if (StringUtil.isNotEmpty(friendMobile))
        {
            p2p_user_friends userFriends = new p2p_user_friends();
            P2p_user frienduser = new P2p_user();

            if (friendMobile.startsWith(Const.PROJECT_NO))
            {
                frienduser = userMapper.findUserByInviteCode(friendMobile);
            } else
            {
                frienduser = userMapper.findUserByMobile(friendMobile);                
            }

            //根据邀请人客户号查询邀请人类型
            String userTypeByCustNO =
            	userInfoMapper.getUserTypeByCustNO(
            		frienduser.getPuCustNo());

            userFriends.setPufCustNo(frienduser.getPuCustNo());     // 邀请人客户号
            userFriends.setPufCustName(frienduser.getUsername());   // 邀请人姓名
            userFriends.setPufFriendCustNo(custNo);                 // 被邀请人客户号
            userFriends.setPufFriendCustName(phone);                // 被邀请人姓名
            userFriends.setPufUserType(userTypeByCustNO);           // 邀请人类型

            userFriendsCount =
            	p2p_user_friendsMapper.saveUserFriends(userFriends);
        } else
        {
            userFriendsCount = 1;
        }

        if (userCount > 0 &&
        	userInfoCount > 0 &&
        	regChannelCount > 0 &&
        	custAccountCount > 0 &&
        	userFriendsCount > 0)
        {
            result.put(Const.retCode, true);
            result.put(Const.retMsg, "保存注册信息成功");
        }

        return result;
    }

    @Override
    public Map<String, Object> checkMobileIsExists(String mobile) throws RuntimeException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.retCode, true);
        int ret = userMapper.checkUserByMobileOrCustNoOrEmail(mobile);
        if (ret > 0)
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "\u8be5\u624b\u673a\u53f7\u5df2\u88ab\u6ce8\u518c");// 该手机号已被注册
            return map;
        }
        return map;
    }

    @Override
    public Map<String, Object> checkUserNameIsExists(String userName) throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Const.retCode, true);
        try
        {
            int ret = userMapper.checkUserByMobileOrCustNoOrEmail(userName);
            if (ret > 0)
            {
                map.put(Const.retCode, false);
                map.put(Const.retMsg, "该用户名已被注册");// 该用户名已被注册
                return map;
            }
            return map;
        } catch (Exception e)
        {
            logger.error("checkUserNameIsExists", e);
            throw new BusinessException("数据库操作异常");// 数据库操作异常
        }
    }

    @Override
    public Map<String, Object> checkInviter(String mobile) throws RuntimeException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        int ret = userMapper.checkUserByMobileOrCustNoOrEmail(mobile);
        map.put(Const.retCode, true);
        if (ret < 1)
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "您输入的推荐人手机号不存在，请重新输入");// \u60a8\u8f93\u5165\u7684\u9080\u8bf7\u4eba\u624b\u673a\u53f7\u4e0d\u5b58\u5728 
            return map;
        }
        return map;
    }

    @Override
    public Map<String, Object> updateLoginPassword(Map<String, Object> params) throws RuntimeException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Const.retCode, true);
        if (params == null || params.size() <= 0)
        {
            result.put(Const.retCode, false);
            return result;
        }
        if (params.get("custNo") == null || StringUtils.isEmpty(params.get("custNo").toString()))
        {
            result.put(Const.retCode, false);
            return result;
        }
        if (params.get("password") == null || StringUtils.isEmpty(params.get("password").toString()))
        {
            result.put(Const.retCode, false);
            return result;
        }
        int i = userMapper.updateLoginPassword(params);
        if (i <= 0)
        {
            result.put(Const.retCode, false);
        }
        return result;
    }

    @Override
    public P2p_user getByLoginName(String puMobile) throws RuntimeException
    {
        if (StringUtils.isEmpty(puMobile))
        {
            return null;
        }
        return userMapper.getByLoginName(puMobile);
    }

    @Override
    public P2p_user findUserByMobile(String reference) throws RuntimeException
    {
        if (StringUtils.isEmpty(reference))
        {
            return null;
        }
        return userMapper.findUserByMobile(reference);
    }

    @Override
    public Map<String, Object> updateHeadUrlByCustNo(Map<String, Object> params) throws RuntimeException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Const.retCode, false);
        if (params == null)
        {
            return result;
        }
        if (params.get("url") == null || params.get("custNo") == null)
        {
            return result;
        }
        int i = userMapper.updateHeadUrlByCustNo(params);
        if (i > 0)
        {
            result.put(Const.retCode, true);
        }
        return result;
    }

    @Override
    public Map<String, Object> updateUser(P2p_user user) throws RuntimeException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Const.retCode, false);

        int i = userMapper.updateUser(user);
        if (i > 0)
        {
            result.put(Const.retCode, true);
        }
        return result;
    }

    @Override
    public long findUserCount()
    {
        return userMapper.getRegisterAllTotal();
    }

    @Override
    public P2p_user findUserByCustNo(String custNo) throws RuntimeException
    {
        return userMapper.findUserByCustNo(custNo);
    }

    @Override
    public int updateCustAccount(String custNo) throws BusinessException
    {
        if (StringUtil.isEmpty(custNo))
        {
            return 0;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("custNo", custNo);
        map.put("pcaStatus", CustAccountStatus.BESTOW.getIndex());
        return custAccountMapper.updateCustAccount(map);
    }

    /*
     * 返回长度为strLength的随机数，不足则在前面补0
     */
    private static String getFixLenthStringContinChar(int length)
    {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 36;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度
        char[] str =
        { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < length)
        {
            // 生成随机数，取绝对值，防止生成负数，
            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < str.length)
            {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }

    @Override
    public Map<String, Object> checkInviteCode(String inviteCode) throws RuntimeException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        int ret = userMapper.checkUserByInviteCode(inviteCode);
        map.put(Const.retCode, true);
        if (ret < 1)
        {
            map.put(Const.retCode, false);
            map.put(Const.retMsg, "您输入的邀请码不存在");// \u60a8\u8f93\u5165\u7684\u9080\u8bf7\u7801\u4e0d\u5b58\u5728
            return map;
        }
        return map;
    }

    @Override
    public Map<String, Object> updateUserEmail(Map<String, Object> params) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtil.isEmpty((String) params.get("custNo")) || StringUtil.isEmpty((String) params.get("mail")))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u7528\u6237\u4fe1\u606f\u5f02\u5e38");// 用户信息异常
        }
        int i = userMapper.updateUserEmail(params);
        if (i > 0)
        {
            result.put(Const.retCode, true);
            result.put(Const.retMsg, "\u66f4\u65b0\u6210\u529f");// 更新成功
        } else
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u66f4\u65b0\u5931\u8d25");// 更新失败
        }
        return result;
    }

}
