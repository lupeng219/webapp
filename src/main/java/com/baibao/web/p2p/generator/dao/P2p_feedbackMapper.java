package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_feedback;

public interface P2p_feedbackMapper {

	/**
	 * 保存意见反馈
	 * @param feedback
	 */
	public void save(P2p_feedback feedback);
}
