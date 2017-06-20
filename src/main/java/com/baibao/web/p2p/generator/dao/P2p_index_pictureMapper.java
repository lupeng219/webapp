package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_index_picture;

public interface P2p_index_pictureMapper {
	
	/**
	 * 得到图片list
	 * @return
	 */
	public List<P2p_index_picture> getAllPictures(String type);
	
	/**
	 * 保存记录
	 * @param map
	 * @return
	 */
	public int savaPicture(Map<String, Object> map);
	
	/**
	 * 更新记录
	 * @param map
	 * @return
	 */
	public int updatePicture(Map<String, Object> map);
	
	/**
	 * 删除首页大图
	 * @param pictureId
	 * @return
	 */
	public int deletePicture(Long pictureId);
	

}
