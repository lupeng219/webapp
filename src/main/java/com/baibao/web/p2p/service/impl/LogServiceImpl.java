package com.baibao.web.p2p.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.web.p2p.generator.bean.P2p_log;
import com.baibao.web.p2p.repository.LogRepository;
import com.baibao.web.p2p.service.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {
	private static Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

	@Autowired
	private LogRepository logRepository;
	
	@Transactional(readOnly = false)
	@Override
	public Map<String, Object> saveLog(P2p_log log) throws RuntimeException {
		try {
			return logRepository.saveLog(log);
		} catch (RuntimeException e) {
			logger.error("saveLog",e);
			throw e;
		}
	}

}
