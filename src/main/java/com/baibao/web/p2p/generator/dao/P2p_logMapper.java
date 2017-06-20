package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_log;

public interface P2p_logMapper {

	public int saveLog(P2p_log log) throws RuntimeException; 
	
}
