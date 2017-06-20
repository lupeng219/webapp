package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_smsRecord;

public interface P2p_smsRecordMapper {
	
	/**
	 * 保存发送短信记录
	 * @param smsRecord
	 */
	public int saveSmsRecord(P2p_smsRecord smsRecord);
	
}
