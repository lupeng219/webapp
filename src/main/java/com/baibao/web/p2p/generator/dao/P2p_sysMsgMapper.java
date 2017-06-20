package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.p2p_sysMsg;

/**
 * @author lupeng
 * @date: 2016年1月12日下午4:55:17
 */
public interface P2p_sysMsgMapper {

	public List<p2p_sysMsg> findList(Map<String, Object> map);

	public Integer findListCount(Map<String, Object> map);

	public void addInnerSiteMsg(Map<String, Object> params);

	public Map<String, Object> getAllMsg();

	public List<p2p_sysMsg> getMsgByType(Map<String, Object> map);

	public List<p2p_sysMsg> getMsgByTypeForDetail(Map<String, Object> map);

	public int getMsgByTypeForDetailCount(Map<String, Object> param);

	public int setMsgReaded(String sysMsgID);

	public int countNoReadMsg(Map<String, Object> param);

	public int deleteMsg(String id);

	public p2p_sysMsg selectById(String msgId);

}
