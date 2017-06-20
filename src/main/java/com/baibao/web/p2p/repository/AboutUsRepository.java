package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_article;

public interface AboutUsRepository {

	public List<P2p_article> queryNoticeList(Map<String, Object> param);
	
	public int  queryNoticeListTotal(Map<String, Object> param);
	
	public P2p_article  queryNoticeById(Long noticeId);
	
}
