package com.baibao.web.p2p.service;

import java.util.Map;

public interface NoticeService {

	public Map<String, Object> queryTransFlowNo( String transFlow ,String transFlowType );
	
	public int updateTransFlowNo( String transFlow , String transFlowType ,String status,String payFlow);
	
	
	
}
