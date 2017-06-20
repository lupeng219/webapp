package com.baibao.web.p2p.service;

import com.baibao.web.p2p.generator.bean.P2p_smsRecord;

public interface SmsRecordService {

	/**
	 * 保存发送短信记录
	 * @param smsRecord
	 * @return
	 */
	public int saveSmsRecord(P2p_smsRecord smsRecord);
}
