package com.baibao.web.p2p.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_article;
import com.baibao.web.p2p.repository.AboutUsRepository;
import com.baibao.web.p2p.service.AboutUsService;

@Service("aboutUsService")
public class AboutUsServiceImpl implements AboutUsService {

	@Autowired
	private AboutUsRepository aboutUsRepository;
	
	@Override
	public Paging<P2p_article> queryNoticeList(String articleType, int pageNo, int pageSize) {
		
		Paging<P2p_article> pag = new Paging<P2p_article>(
				pageNo, pageSize);
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("articleType", articleType);
		params.put("begin", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		pag.setPageList(aboutUsRepository.queryNoticeList(params));
		pag.setCountTotal(aboutUsRepository.queryNoticeListTotal(params));
		return pag;
	}

	@Override
	public P2p_article queryNoticeById(Long noticeId) {
		
		return aboutUsRepository.queryNoticeById(noticeId);
	}

	@Override
	public List<P2p_article> queryNoticeList(String articleType) {
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("articleType", articleType);
		params.put("begin", 0);
		params.put("count", 3);
		List<P2p_article>  articleList = aboutUsRepository.queryNoticeList(params);
		return articleList;
	}

}
