package com.baibao.web.p2p.repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user_info;

public interface UserInfoRepository {

	/**
	 * 保存用户信息
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public int save(P2p_user_info userInfo) throws BusinessException;
	
	/**
	 * 根据用户编号获取用户信息
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
    P2p_user_info getUserInfo(String custNo) throws RuntimeException;;
    
    /**
	 * 更新用户详细信息
	 * @param userInfo
	 * @throws RuntimeException
	 */  
	int updataUserInfo(P2p_user_info userInfo) throws RuntimeException;
	
	/**
	 * 根据姓名、身份证号检查实名认证信息是否已绑定其他账户
	 * @param realName 姓名
	 * @param certNo 身份证号
	 * @param custNo 当前用户
	 * @return int
	 * @throws RuntimeException
	 */
	int getRealNameAuthentication(String realName,String certNo, String custNo) throws RuntimeException;
	
}
