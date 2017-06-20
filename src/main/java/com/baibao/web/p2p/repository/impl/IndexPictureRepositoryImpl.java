package com.baibao.web.p2p.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.bean.P2p_index_picture;
import com.baibao.web.p2p.generator.dao.P2p_index_pictureMapper;
import com.baibao.web.p2p.repository.IndexPictureRepository;

@Repository
public class IndexPictureRepositoryImpl implements IndexPictureRepository {

	@Autowired
	private P2p_index_pictureMapper  indexPictureMapper;
	
	
	@Override
	public List<P2p_index_picture> findIndexPicture(String type) {
		
		return indexPictureMapper.getAllPictures(type);
	}

}
