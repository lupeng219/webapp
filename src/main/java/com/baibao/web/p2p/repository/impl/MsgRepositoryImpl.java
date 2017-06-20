package com.baibao.web.p2p.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.p2p_sysMsg;
import com.baibao.web.p2p.generator.dao.P2p_sysMsgMapper;
import com.baibao.web.p2p.repository.MsgRepository;

/**
 * @author lupeng
 * @date: 2016年1月13日上午10:12:18
 */
@Repository
public class MsgRepositoryImpl  implements MsgRepository{
	
	@Autowired
	private P2p_sysMsgMapper sysMsgDao;
	
	@Override
	public List<p2p_sysMsg>findList(Map<String, Object>map){
		return sysMsgDao.findList(map);
		
	}

	@Override
	public Integer findListCount(Map<String, Object> map) {
		return sysMsgDao.findListCount(map);
	}

	@Override
	public void addInnerSiteMsg(Map<String, Object> params)throws Exception {
		sysMsgDao.addInnerSiteMsg(params);
	}

	@Override
	public Map<String, Object> getAllMsg() {
		return sysMsgDao.getAllMsg();
	}

	@Override
	public List<p2p_sysMsg> getMsgByType(String type,String custNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("custNo", custNo);
		return sysMsgDao.getMsgByType(param);
	}

	@Override
	public List<p2p_sysMsg> getMsgByTypeForDetail(String type,String custNo,Integer cursor, Integer count) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("custNo", custNo);
		param.put("beginWith",cursor );
		param.put("count",count );
		return sysMsgDao.getMsgByTypeForDetail(param);
	}

	@Override
	public int setMsgReaded(String sysMsgID) {
		return sysMsgDao.setMsgReaded(sysMsgID);
		
	}

	@Override
	public int countNoReadMsg(String type, String custNo) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("custNo", custNo);
		return sysMsgDao.countNoReadMsg(param);
	}
	
	@Override
	public void deleteMsg(String id) throws Exception {
		int i = 0;
		i = sysMsgDao.deleteMsg(id);
		if(i != 1)
			throw new BusinessException("删除站内信失败");
	}
	
	@Override
	public Integer getMsgByTypeForDetailCount(String type, String custNo,
			Integer cursor, Integer count) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", type);
		param.put("custNo", custNo);
		return sysMsgDao.getMsgByTypeForDetailCount(param);
		
	}

	@Override
	public p2p_sysMsg selectById(String msgId) {
		return sysMsgDao.selectById(msgId);
	}
}
