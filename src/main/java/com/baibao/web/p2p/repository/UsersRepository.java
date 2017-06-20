package com.baibao.web.p2p.repository;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user;
/**
 * 入库数据组装校验
 * @author jiangp
 * @date 2015年11月20日
 */
public interface UsersRepository {

	/**
	 * 保存用户注册信息(用户登录信息、用户详细信息、用户注册渠道信息、用户邀请信息)
	 * @param phone 手机号
	 * @param passd 登录密码
	 * @param friendMobile 推荐人手机号
	 * @param channel 注册来源
	 * @param openId
	 * @param custNo 客户号
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> saveRegisterInfo(String phone,
			String passd, String friendMobile, String channel,
			String openId, String custNo) throws BusinessException;
	
	/**
	 * 检查手机号是否已注册
	 * @param mobile 手机号
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, Object> checkMobileIsExists(String mobile) throws RuntimeException;
	
	/**
	 * 验证用户名是否存在
	 * @param userName 用户名
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, Object> checkUserNameIsExists(String userName) throws BusinessException;
	
	
	/**
	 * 验证邀请人是否存在
	 * @param mobile 邀请人手机号
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> checkInviter(String mobile) throws RuntimeException;
	
	/**
	 * 根据邀请码验证邀请人是否存在
	 * @param inviteCode 邀请码
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> checkInviteCode(String inviteCode) throws RuntimeException;
	
	/**
	 * 修改登录密码
	 * @param params
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, Object> updateLoginPassword(Map<String, Object> params) throws RuntimeException;
	
	/**
	 * 根据登录名查询登录用户
	 * @param loginName
	 * @return
	 * @throws RuntimeException
	 */
	public P2p_user getByLoginName(String puMobile) throws RuntimeException;
	/**
	 * 根据客户号查询登录用户
	 * @param custNo
	 * @return
	 * @throws RuntimeException
	 */
	public P2p_user findUserByCustNo(String custNo) throws RuntimeException;
	
	public P2p_user findUserByMobile(String reference) throws RuntimeException;
	
	public Map<String, Object> updateHeadUrlByCustNo(Map<String, Object> params) throws RuntimeException;
	
	public Map<String, Object> updateUser(P2p_user user) throws RuntimeException;
	
	public long findUserCount();
	
	/**
	 * 根据客户号更新账户使用状态
	 * @param custNo 客户号
	 * @return
	 * @throws BusinessException
	 */
	public int updateCustAccount(String custNo) throws BusinessException;
	
	/**
	 * 根据客户号更新用户邮箱
	 * @param custNo 客户号
	 * @return
	 * @throws RuntimeException
	 */
	public Map<String, Object> updateUserEmail(Map<String, Object> params) throws BusinessException;
}
