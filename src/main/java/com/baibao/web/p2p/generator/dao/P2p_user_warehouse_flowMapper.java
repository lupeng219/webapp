package com.baibao.web.p2p.generator.dao;

import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_user_warehouse_flow;


public interface P2p_user_warehouse_flowMapper {
	

	P2p_user_warehouse_flow  selectByState (Map<String, Object>map);
	
	int insertInfo(Map<String, Object>map);
	
	void updateBywhNo(Map<String, Object>map);
}
