package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

/**
 * 访客来源表数据库操作接口
 * @author yangyang
 *
 */

public interface P2p_visitors_infoMapper {

	void insertP2p_visitors_info(Map<String, Object> param);

	Map<String, Object> selectIpInfo(String ip);

	void updateP2p_visitors_info(Map<String, Object> param);

	List<Map<String, Object>> selectIpForDeal();
   
	
	
	
}