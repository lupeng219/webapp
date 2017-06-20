package com.baibao.web.p2p.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.baibao.web.p2p.generator.bean.P2p_article;
import com.baibao.web.p2p.generator.dao.P2p_articleMapper;
import com.baibao.web.p2p.repository.AboutUsRepository;

@Repository
public class AboutUsRepositoryImpl implements AboutUsRepository {

	@Autowired
	private P2p_articleMapper p2p_articleMapper;
	@Override
	public List<P2p_article> queryNoticeList(Map<String, Object> params) {
		
		return p2p_articleMapper.queryNoticeList(params);
	}
	@Override
	public int queryNoticeListTotal(Map<String, Object> params) {
		
		return p2p_articleMapper.queryNoticeListTotal(params);
	}
	@Override
	public P2p_article queryNoticeById(Long noticeId) {
		
		return p2p_articleMapper.getArticleByID(noticeId);
	}

	
}
