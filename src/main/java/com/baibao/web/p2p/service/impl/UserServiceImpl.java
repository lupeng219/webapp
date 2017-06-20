package com.baibao.web.p2p.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.fabric.xmlrpc.base.Data;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2pInitParams;
import com.baibao.web.p2p.generator.bean.P2p_system_params;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.repository.SystemParamsRepository;
import com.baibao.web.p2p.repository.UserInfoRepository;
import com.baibao.web.p2p.repository.UsersRepository;
import com.baibao.pay.GetUniqueNoService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.pay.PayService;
import com.baibao.web.p2p.utils.ControllerRetType;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private PayService payService;

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private SystemParamsRepository systemParamsRepository;
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private BaseLog baseLog;
    @Autowired
    private GetUniqueNoService getUniqueNoService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String puMobile) throws UsernameNotFoundException
    {
        try
        {
            P2p_user loginUser = usersRepository.getByLoginName(puMobile);
            if (loginUser == null)
                throw new UsernameNotFoundException("\u7528\u6237\u4e0d\u5b58\u5728");// 用户不存在

            // 添加权限
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            loginUser.setAuthorities(authorities);

            return loginUser;
        } catch (Exception e)
        {
            logger.error("loadUserByUsername", e);
        }

        return null;
    }

    @Override
    public P2p_user getByLoginName(String puMobile)
    {
        return usersRepository.getByLoginName(puMobile);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Map<String, Object> addUsers(
    	String phone, String phonecode, String passd, String friendMobile,
        String channel, String openId)
        	throws BusinessException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> mapRetCode = new HashMap<String, Object>();

        map.put(Const.retCode, true);
        map.put(Const.retMsg, "注册成功");// 注册成功
        
        // 检查注册字段
        if (StringUtil.isEmpty(phone) ||
        	StringUtil.isEmpty(phonecode) ||
        	StringUtil.isEmpty(passd))
        {
            mapRetCode.put(Const.retCode, false);
            mapRetCode.put(Const.retMsg, "参数不符合规范");// 参数不符合规范

            return mapRetCode;
        }

        // 检查手机号是否已经注册
        mapRetCode = usersRepository.checkMobileIsExists(phone);
        if (!Boolean.valueOf(mapRetCode.get(Const.retCode).toString()))
        {
            mapRetCode.put("type", "mobile");
            return mapRetCode;
        }

        // 检查短信验证码
        String code = jedisUtil.getValue(phone);
        if (StringUtil.isNotEmpty(code))
        {
            if (!code.equals(phonecode))
            {
                mapRetCode.put(Const.retCode, false);
                mapRetCode.put(Const.retMsg, "短信验证码错误,请您重新输入");
                mapRetCode.put("type", "valdatecode");

                return mapRetCode;
            }
        } else
        {
            mapRetCode.put(Const.retCode, false);
            mapRetCode.put(Const.retMsg,
                    "\u9a8c\u8bc1\u7801\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");//验证码超时，请重新获取
            mapRetCode.put("type", "valdatecode");

            return mapRetCode;
        }

        // 检查邀请人是否存在
        if (StringUtil.isNotEmpty(friendMobile))
        {
            //公司员工( 经纪人or销售 )
            if (friendMobile.toUpperCase()
            		.startsWith(Const.INVITE_CODE))
            {
                mapRetCode =
                	usersRepository.checkInviteCode(
                		friendMobile.toUpperCase());

                if (!Boolean.valueOf(mapRetCode.get(Const.retCode).toString()))
                {
                    mapRetCode.put("type", "friend");
                    return mapRetCode;
                }
            } else
            {
                mapRetCode = usersRepository.checkInviter(friendMobile);

                if (!Boolean.valueOf(mapRetCode.get(Const.retCode).toString()))
                {
                    mapRetCode.put("type", "friend");
                    return mapRetCode;
                }
            }
        }

        // 生成客户编号
        String custNo = getUniqueNoService.getCustNo();

        map.put("custNo", custNo);

        // 保存注册信息
        //Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> result = usersRepository.saveRegisterInfo(
        	phone, passd, friendMobile, channel, openId, custNo);

        if (!Boolean.valueOf(result.get(Const.retCode).toString()))
        {
            logger.error("\u7528\u6237\u6ce8\u518c\u4fe1\u606f\u4fdd\u5b58\u5931\u8d25");// 用户注册信息保存失败
            throw new BusinessException("\u7528\u6237\u6ce8\u518c\u4fe1\u606f\u4fdd\u5b58\u5931\u8d25");// 用户注册信息保存失败
        }
        result.clear();

        usersRepository.updateCustAccount(custNo);

        return map;
    }

    @Override
    public Map<String, Object> checkMobileIsExists(String mobile) throws Exception
    {
        return usersRepository.checkMobileIsExists(mobile);
    }

    @Override
    public Map<String, Object> checkInviter(String mobile) throws BusinessException
    {
        return usersRepository.checkInviter(mobile);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Map<String, Object> updateLoginPassword(Map<String, Object> params)
    {
        Map<String, Object> result = new HashMap<String, Object>();

        try
        {
            result = usersRepository.updateLoginPassword(params);

            if (Boolean.valueOf(result.get(Const.retCode).toString()))
            {
                result.put(Const.retMsg, "\u4fee\u6539\u6210\u529f");// 修改成功
            }
        } catch (Exception e)
        {
            // baseLog.writer(BusinessType.changePassword.getIndex(),
            // params.get("registType").toString(), Const.errorOperation);
            logger.error("修改登录密码时出错", e);// 修改登录密码时出错
        }
        return result;
    }

    @Override
    @Transactional(readOnly = false)
    public int updateHeadUrlByCustNo(Map<String, Object> params) throws RuntimeException
    {
        try
        {
            Map<String, Object> result = usersRepository.updateHeadUrlByCustNo(params);
            if (!Boolean.valueOf(result.get(Const.retCode).toString()))
            {
                throw new RuntimeException("更新头像地址失败");// 更新头像地址失败
            }
        } catch (RuntimeException e)
        {
            logger.error("updateHeadUrlByCustNo", e);
            throw e;
        }
        return 1;
    }

    @Override
    public P2p_user findUserByMobile(String mobile) throws RuntimeException
    {
        return usersRepository.findUserByMobile(mobile);
    }

    @Override
    @Transactional(readOnly = false)
    public int updateUser(P2p_user user) throws RuntimeException
    {
        Map<String, Object> result = usersRepository.updateUser(user);

        if (!Boolean.valueOf(result.get(Const.retCode).toString()))
        {
            logger.error("更新登录信息出现错误");
            throw new RuntimeException("更新登录信息出现错误");
        }

        return 1;
    }

    @Override
    public long findUserCount()
    {
        return usersRepository.findUserCount();
    }

    @Override
    public P2p_user getByLoginCustNo(String custNo)
    {
        return usersRepository.findUserByCustNo(custNo);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Map<String, Object> updateUserEmail(Map<String, Object> params) throws BusinessException
    {
        Map<String, Object> result = new HashMap<String, Object>();

        result = usersRepository.updateUserEmail(params);

        if (Boolean.valueOf(result.get(Const.retCode).toString()))
        {
            P2p_user_info userInfo = userInfoRepository.getUserInfo((String) params.get("custNo"));

            userInfo.setPuiEmailbindtime(new Date());

            int i = userInfoRepository.updataUserInfo(userInfo);

            if (i > 0)
            {
                result.put(Const.retCode, true);
                result.put(Const.retMsg, "\u7535\u5b50\u90ae\u7bb1\u66f4\u65b0\u6210\u529f");// 电子邮箱更新成功
            } else
            {
                result.put(Const.retCode, false);
                result.put(Const.retMsg, "\u7535\u5b50\u90ae\u7bb1\u66f4\u65b0\u5931\u8d25");// 电子邮箱更新失败
            }
        }

        return result;
    }

	@Override
	public P2pInitParams getSystemByname() {
		String [] arr = new String[]{
				Const.CONTACTUS, Const.SECURITY,Const.CONTRACT, 
				Const.REGISTERAGREEMENT, Const.HELPCENTERAPP,Const.TELEPHONE,Const.BEGINERGUIDE };
		P2p_system_params params = null;
		P2pInitParams initParams = new P2pInitParams();
		for (String str : arr) {
			params = (P2p_system_params)jedisUtil.getObject(str);
			if (params == null) {
				params = systemParamsRepository.getSystemByname(str);
				if(params == null){
					throw new BusinessException();
				}
				jedisUtil.setObject(str, params, 60*60*24);
			}
			if (params.getName().equals(Const.CONTACTUS)) {
				initParams.setContactus(params.getValue());
			} else if (params.getName().equals(Const.SECURITY)){
				initParams.setSecurity(params.getValue());
			}else if (params.getName().equals(Const.CONTRACT)){
				initParams.setContract(params.getValue());
			}else if (params.getName().equals(Const.REGISTERAGREEMENT)){
				initParams.setRegisterAgreement(params.getValue());
			}else if (params.getName().equals(Const.HELPCENTERAPP)){
				initParams.setHelpCenterApp(params.getValue());
			}else if (params.getName().equals(Const.TELEPHONE )){
				initParams.setTelephone(params.getValue());
			}else if (params.getName().equals(Const.BEGINERGUIDE )){
				initParams.setBeginerGuide(params.getValue());
			}
		}
		return initParams;
	}
}
