package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_log;
import com.baibao.web.p2p.generator.dao.P2p_logMapper;
import com.baibao.web.p2p.repository.LogRepository;

@Repository
public class LogRepositoryImpl implements LogRepository {

	@Autowired
	private P2p_logMapper logMapper;

	@Override
	public Map<String, Object> saveLog(P2p_log log) throws RuntimeException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Const.retCode, false);
		if (StringUtils.isEmpty(log.getCustno())) {
			return result;
		}
		int i = logMapper.saveLog(log);
		if (i > 0) {
			result.put(Const.retCode, true);
		}
		return result;
	}

}
