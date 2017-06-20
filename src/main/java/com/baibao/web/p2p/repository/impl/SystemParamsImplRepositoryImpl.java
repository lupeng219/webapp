package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_system_params;
import com.baibao.web.p2p.generator.dao.P2p_system_paramsMapper;
import com.baibao.web.p2p.repository.SystemParamsRepository;
@Repository
public class SystemParamsImplRepositoryImpl implements SystemParamsRepository {
	@Autowired
	private P2p_system_paramsMapper p2p_system_paramsMapper;

	@Override
	public P2p_system_params getSystemByname(String name) {
		 P2p_system_params system_params = p2p_system_paramsMapper.queryParamsBynames(name);
		return system_params;
	}	
}
