package com.baibao.web.p2p.repository;

import java.util.List;

import com.baibao.web.p2p.generator.bean.P2p_index_picture;

public interface IndexPictureRepository {

	
	public List<P2p_index_picture> findIndexPicture(String type);
}
