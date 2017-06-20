package com.baibao.web.p2p.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.bean.P2p_feedback;
import com.baibao.web.p2p.generator.bean.p2p_sysMsg;
import com.baibao.web.p2p.generator.dataDIC.MsgType;
import com.baibao.web.p2p.repository.FeedbackRepository;
import com.baibao.web.p2p.repository.MsgRepository;
import com.baibao.web.p2p.service.MsgService;

/**
 * @author lupeng
 * @date: 2016年1月13日上午10:09:31
 */
@Service
public class MsgServiceImpl  implements  MsgService{

	private static final Logger logger = LoggerFactory.getLogger(MsgServiceImpl.class);
	@Autowired
	private MsgRepository msgRepository;
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public Paging<p2p_sysMsg> findList(Integer cursor, Integer count,String custNo) {
		Map<String, Object>map = new HashMap<String, Object>();
		Paging<p2p_sysMsg> pag = new Paging<p2p_sysMsg>(
				cursor, count);
		map.put("beginWith", pag.getBeginWith());
		map.put("count", count);
		map.put("custNo", custNo);
		try{
			pag.setPageList( msgRepository.findList(map));
			pag.setCountTotal(msgRepository.findListCount(map));
			}catch(Exception e){ 
				logger.error("error",e);
			}
		 return pag;
	}
	@Override
	public List<Map<String, Object>> getAllMsg(String custNo) {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		for(MsgType m : MsgType.values()) {
			List<p2p_sysMsg> msg = msgRepository.getMsgByType(m.getIndex(),custNo);
			String context = "",time = "";
			String count = "";
			int num = msgRepository.countNoReadMsg(m.getIndex(),custNo);
			if(num>0){
				count += num;
			}
			if(msg != null && msg.size()>0){
				context = msg.get(0).getSysMsgContent();
				time = DateUtils.getDateToString(msg.get(0).getSysMsgPubTime());
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("title", m.getDesc());//标题
				map.put("context", context);//内容
				map.put("time",time);//发布时间
				map.put("count", count);//内容
				map.put("type", m.getIndex());//类型值
				list.add(map);
			}
		}
		return list;
	}
	@Override
	public Paging<Map<String, Object>> getMsgByType(String type,String custNo,Integer cursor, Integer count) {
		Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
				cursor, count);
		List<p2p_sysMsg> list = msgRepository.getMsgByTypeForDetail(type,custNo,pag.getBeginWith(), pag.getPageSize());
		pag.setCountTotal(msgRepository.getMsgByTypeForDetailCount(type, custNo, cursor, count));
		List<Map<String, Object>> reList = new ArrayList<Map<String, Object>>();
		if(list !=null && list.size()>0){
			for(p2p_sysMsg li : list){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("time", DateUtils.getDateToString(li.getSysMsgPubTime()));
				map.put("context", li.getSysMsgContent().substring(18, li.getSysMsgContent().length()));
				map.put("firstLine", li.getSysMsgContent().substring(6, 17));
				map.put("isread", li.getIsRead());
				map.put("id", li.getSysMsgID());
				reList.add(map);
				msgRepository.setMsgReaded(li.getSysMsgID());
			}
		}
		pag.setPageList(reList);
		return pag;
	}
	
	@Override
	public void deleteMsg(String id) throws Exception {
		msgRepository.deleteMsg(id);
	}
	@Override
	public int setMsgReaded(String id) {
		return  msgRepository.setMsgReaded(id);
	}
	@Override
	public p2p_sysMsg selectById(String msgId) {
		return msgRepository.selectById(msgId);
	}
	@Override
	public void saveFeedback(String custNo,String phone,String content) {
		P2p_feedback feedback = new P2p_feedback();
		Date date  = new Date();
		feedback.setPf_custNo(custNo);
		feedback.setPf_phone(phone);
		feedback.setPf_content(content);
		feedback.setPf_time(date);
		feedbackRepository.saveFeedback(feedback);		
	}
	
}
