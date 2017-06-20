package com.baibao.web.p2p.repository;

import com.baibao.web.p2p.generator.bean.P2p_feedback;

public interface FeedbackRepository {


	/**
	 * 保存意见反馈
	 * @param feedback
	 */
	public void saveFeedback(P2p_feedback feedback);
}
