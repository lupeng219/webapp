package com.baibao.web.p2p.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2pInitParams;
import com.baibao.web.p2p.generator.bean.P2p_user;

/**
 * @描述：用户基本信息Service层接口
 */
public interface UserService extends UserDetailsService {

	/**
	 * 注册用户接口
	 * 
	 * @param phone
	 * @param phonecode
	 * @param passd
	 * @param repeatPassd
	 * @param reference
	 * @return
	 */
	public Map<String, Object> addUsers(String phone,
			String phonecode, String passd, String reference, String channel,
			String openId) throws BusinessException;

	/**
	 * 验证手机号是否存在
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> checkMobileIsExists(String mobile)
			throws Exception;

	/**
	 * 验证邀请人是否存在
	 * 
	 * @param mobile 邀请人手机号
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> checkInviter(String mobile) throws BusinessException;


	/**
	 * 根据登陆名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public P2p_user getByLoginName(String puMobile);
	/**
	 * 根据客户号查询用户
	 * @param custNo
	 * @return
	 */
	public P2p_user getByLoginCustNo(String custNo);
	/**
	 * 修改登录密码
	 * @param params
	 * @throws RuntimeException
	 */
	public Map<String, Object> updateLoginPassword(Map<String, Object> params) throws RuntimeException;
	
	public int updateHeadUrlByCustNo(Map<String, Object> params) throws RuntimeException; 
	
	public P2p_user findUserByMobile(String mobile) throws RuntimeException;
	
	public int updateUser(P2p_user user) throws RuntimeException;
	
	/**
	 * 更新用户邮箱
	 * @param userEmail
	 * @throws BusinessException
	 */
	public Map<String, Object> updateUserEmail(Map<String, Object> params) throws BusinessException;
	
	/**
	 * 查询加入用户数
	 * @return
	 */
	public long findUserCount();
	/**
	 * 根据名称查询配置参数
	 * @param 
	 * @return
	 */
	public P2pInitParams getSystemByname();
}
