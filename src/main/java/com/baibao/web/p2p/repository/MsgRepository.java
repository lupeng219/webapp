package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.p2p_sysMsg;

/**
 * @author lupeng
 * @date: 2016年1月13日上午10:12:00
 */
public interface MsgRepository {

	List<p2p_sysMsg>findList(Map<String, Object>map);
	
	Integer findListCount(Map<String, Object>map);
	
	void addInnerSiteMsg(Map<String, Object> params)throws Exception;
	
	Map<String, Object> getAllMsg();
	
	List<p2p_sysMsg> getMsgByType(String Type,String custNo);
	
	List<p2p_sysMsg> getMsgByTypeForDetail(String type,String custNo,Integer cursor, Integer count);
	
	Integer getMsgByTypeForDetailCount(String type,String custNo,Integer cursor, Integer count);
	
	int  setMsgReaded(String sysMsgID);
	
	int countNoReadMsg(String index, String custNo);
	void deleteMsg(String id) throws Exception;

	p2p_sysMsg selectById(String msgId);
}
