package com.baibao.web.p2p.service;

import java.util.List;
import java.util.Map;

import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_feedback;
import com.baibao.web.p2p.generator.bean.p2p_sysMsg;

/**
 * @author lupeng
 * @date: 2016年1月13日上午10:09:08
 */
public interface MsgService {

	
	//public Paging<p2p_sysMsg> getByCustNoAndType(String custNo,Integer type,String status,String startTime,String endTime,int currentPageNo, int pageSize);
	public Paging<p2p_sysMsg> findList(Integer cursor, Integer count,String custNo );
	
	public List<Map<String, Object>> getAllMsg(String custNo);

	public void deleteMsg(String id)throws Exception; 
	
	public Paging<Map<String, Object>> getMsgByType(String type,String custNo,Integer cursor, Integer count); 
	
	public int setMsgReaded(String id)throws Exception;
	//Integer findListCount(Integer cursor, Integer count);
	
	public p2p_sysMsg selectById(String msgId);
	/**
	 * 保存意见反馈
	 * @param feedback
	 */
	public void saveFeedback(String custNo,String phone,String content);
}
