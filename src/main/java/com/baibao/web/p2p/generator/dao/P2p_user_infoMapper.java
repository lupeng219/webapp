package com.baibao.web.p2p.generator.dao;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user_info;


public interface P2p_user_infoMapper {
    
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
    P2p_user_info getUserInfo(String custNo);
    
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
	 * @return int
	 * @throws RuntimeException
	 */
	int  getRealNameAuthentication(@Param(value = "realName") String realName,@Param(value = "certNo") String certNo, @Param(value = "custNo") String custNo) throws RuntimeException;
	
	/**
	 * 根据客户号查询客户类型
	 * @param custNo
	 * @return
	 */
	String getUserTypeByCustNO(String custNo) throws RuntimeException;
	
	
	
}