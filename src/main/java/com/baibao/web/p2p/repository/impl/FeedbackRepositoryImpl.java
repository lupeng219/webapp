package com.baibao.web.p2p.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_feedback;
import com.baibao.web.p2p.generator.dao.P2p_feedbackMapper;
import com.baibao.web.p2p.repository.FeedbackRepository;
@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository {

	@Autowired
	private P2p_feedbackMapper feedbackDao;
	
	@Override
	public void saveFeedback(P2p_feedback feedback) {
		feedbackDao.save(feedback);
	}

}
