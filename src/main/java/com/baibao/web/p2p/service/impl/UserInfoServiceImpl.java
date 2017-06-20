package com.baibao.web.p2p.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_user_info;
import com.baibao.web.p2p.repository.UserInfoRepository;
import com.baibao.web.p2p.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public int save(P2p_user_info userInfo) throws BusinessException{
		return userInfoRepository.save(userInfo);
	}
	
	@Override
	public P2p_user_info getByCustNo(String custNo)
			throws BusinessException {
		return userInfoRepository.getUserInfo(custNo);
	}

	@Override
	public int updataUserInfo(P2p_user_info userInfo)
			throws BusinessException {
		return userInfoRepository.updataUserInfo(userInfo);
	}

	@Override
	public int getRealNameAuthentication(String realName,String certNo, String custNo)
			throws BusinessException {
		return userInfoRepository.getRealNameAuthentication(realName,certNo, custNo);
	}

}
