package com.baibao.web.p2p.service.job.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.repository.CountRegisterUserRepository;
import com.baibao.web.p2p.service.job.CountRegisterUserService;

@Service("countRegisterUserService")
public class CountRegisterUserServiceImpl implements CountRegisterUserService{

	private static final Logger log = LoggerFactory.getLogger(CountRegisterUserServiceImpl.class);
	
	@Autowired
	private CountRegisterUserRepository countRegisterUserRepository; 
	@Autowired
	private JedisUtil jedisUtil;
	
	@Override
	public Long countRegisterUser() throws Exception {
		Long total = countRegisterUserRepository.getRegisterAllTotal();
		total = total == null?0:total;
		jedisUtil.setValue(Const.PLATFORM_REGISTER_USER, total+"",60*10);
		log.debug(Const.PLATFORM_REGISTER_USER+":"+total);
		return total;
	}

}
