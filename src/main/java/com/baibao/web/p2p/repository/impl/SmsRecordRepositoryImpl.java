package com.baibao.web.p2p.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_smsRecord;
import com.baibao.web.p2p.generator.dao.P2p_smsRecordMapper;
import com.baibao.web.p2p.repository.SmsRecordRepository;
@Repository("smsRecordRepository")
public class SmsRecordRepositoryImpl implements SmsRecordRepository {
	
	@Autowired
	private P2p_smsRecordMapper smsRecordMapper;

	@Override
	public int saveSmsRecord(P2p_smsRecord smsRecord) {
		return smsRecordMapper.saveSmsRecord(smsRecord);
	}
}
