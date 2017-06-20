package com.baibao.web.p2p.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.web.p2p.generator.bean.P2p_smsRecord;
import com.baibao.web.p2p.repository.SmsRecordRepository;
import com.baibao.web.p2p.service.SmsRecordService;

/**
 * 短信记录
 * @author admins
 *
 */
@Service("smsRecordService")
public class SmsRecordServiceImpl implements SmsRecordService {
	
	@Autowired
	private SmsRecordRepository smsRecordRepository;

	@Override
	public int saveSmsRecord(P2p_smsRecord smsRecord) {
		
		return smsRecordRepository.saveSmsRecord(smsRecord);
	}
	
	
	
	
	

}
