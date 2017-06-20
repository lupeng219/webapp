package com.baibao.web.p2p.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.dao.P2p_userMapper;
import com.baibao.web.p2p.repository.CountRegisterUserRepository;
@Repository
public class CountRegisterUserRepositoryImpl implements CountRegisterUserRepository {

	@Autowired
	private P2p_userMapper userMapper; 
	
	@Override
	public Long getRegisterAllTotal() {
		
		return userMapper.getRegisterAllTotal();
	}

}
