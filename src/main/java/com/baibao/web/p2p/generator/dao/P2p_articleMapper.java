package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;
import com.baibao.web.p2p.generator.bean.P2p_article;

public interface P2p_articleMapper {

	/**
	 * 查询发布文章列表
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> articleList(Map<String, Object>map);
	Integer articleListCount(Map<String, Object>map);
	
	/**
	 * 根据ID查询文章内容
	 * @param id
	 * @return
	 */
	P2p_article getArticleByID(Long id);
	
	/**
	 * 查询公告列表
	 * @param param
	 * @return
	 */
	public List<P2p_article> queryNoticeList(Map<String, Object> param);
	/**
	 * 查询公告条数
	 * @param param
	 * @return
	 */
	public int queryNoticeListTotal(Map<String, Object> param);
	
}
