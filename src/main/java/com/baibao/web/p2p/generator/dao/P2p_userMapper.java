package com.baibao.web.p2p.generator.dao;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user;

public interface P2p_userMapper {
	
	/**
	 * 通过登陆名进行登陆
	 * @return
	 */
	public P2p_user getByLoginName(String puMobile);
	
	/**
	 * 根据手机号查询用户开户
	 * @param mobile
	 * @return
	 * @throws RuntimeException
	 */
	public P2p_user findUserByMobile(String mobile) throws RuntimeException;
	
	/**
	 * 根据邀请码查询用户开户
	 * @param mobile
	 * @return
	 * @throws RuntimeException
	 */
	public P2p_user findUserByInviteCode(String inviteCode) throws RuntimeException;
	
	
	/**
	 * 根据客户号查询用户开户
	 * @param custNo
	 * @return
	 * @throws RuntimeException
	 */
	public P2p_user findUserByCustNo(String custNo) throws RuntimeException;
	/**
	 * 查询手机号是否别占用
	 * @param pu_mobile
	 * @return
	 * @throws RuntimeException
	 */
	int  checkUserByMobileOrCustNoOrEmail(String custno) throws RuntimeException;
	/**
	 * 查询邀请码是否存在
	 * @param pu_mobile
	 * @return
	 * @throws RuntimeException
	 */
	int  checkUserByInviteCode(String inviteCode) throws RuntimeException;
	
	
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 * @throws RuntimeException
	 */
	int saveUser(P2p_user user) throws BusinessException;
	
	/**
	 * 修改登录密码
	 * @param params
	 * @throws RuntimeException
	 */
	public int updateLoginPassword(Map<String, Object> params) throws RuntimeException;
	
	/**
	 * 更新用户头像地址
	 * @param params
	 * @return
	 * @throws RuntimeException
	 */
	public int updateHeadUrlByCustNo(Map<String, Object> params) throws RuntimeException; 
	
	public int updateUser(P2p_user user);
	
	/**
	 * 更新用户邮箱
	 * @param params
	 * @return
	 * @throws RuntimeException
	 */
	public int updateUserEmail(Map<String, Object> params) throws RuntimeException; 
	
	/**
	 * 统计平台总人数
	 * @return
	 */
	public Long getRegisterAllTotal();
	
	/**
	 * 得到用户好友客户号
	 * @param custNo
	 * @return
	 */
	public String getUserFriends(String custNo);
}
