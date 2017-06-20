package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_log;

public interface LogService {

	public Map<String, Object> saveLog(P2p_log log) throws RuntimeException;
	
}
