package com.baibao.web.p2p.service;

import java.util.List;

import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_article;

public interface AboutUsService {

	/**
	 * 分页查询公告列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Paging<P2p_article> queryNoticeList(String articleType,int pageNo,int pageSize);
	
	/**
	 * 根据id查询公告
	 * @param noticeId
	 * @return
	 */
	public P2p_article  queryNoticeById(Long noticeId);
	
	/**
	 * 查询（网站公告、媒体报道、最新动态)
	 * @param articleType 类型
	 * @return
	 */
	public List<P2p_article> queryNoticeList(String articleType);
}
