package com.baibao.web.p2p.repository.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.generator.dao.P2p_user_infoMapper;
import com.baibao.web.p2p.repository.UserInfoRepository;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository{

	@Autowired
	private P2p_user_infoMapper userInfoMapper;
	
	@Override
	public int save(P2p_user_info userInfo) throws BusinessException {
		if(userInfo == null){
			return 0;
		}
		return userInfoMapper.save(userInfo);
	}

	@Override
	public P2p_user_info getUserInfo(String custNo) throws RuntimeException {
		if(StringUtils.isEmpty(custNo)){
			return null;
		}
		return userInfoMapper.getUserInfo(custNo);
	}

	@Override
	public int updataUserInfo(P2p_user_info userInfo) throws RuntimeException {
		if(userInfo == null){
			return 0;
		}
		return userInfoMapper.updataUserInfo(userInfo);
	}

	@Override
	public int getRealNameAuthentication(String realName,String certNo, String custNo)
			throws RuntimeException {
		if(StringUtils.isEmpty(realName) || StringUtils.isEmpty(certNo)){
			return 1;
		}
		return userInfoMapper.getRealNameAuthentication(realName,certNo, custNo);
	}

}
