package com.baibao.web.p2p.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.web.p2p.generator.bean.P2p_index_picture;
import com.baibao.web.p2p.repository.IndexPictureRepository;
import com.baibao.web.p2p.service.IndexPictureService;

@Service("indexPictureService")
public class IndexPictureServiceImpl implements IndexPictureService {

	@Autowired
	private IndexPictureRepository indexPictureRepository;
	@Override
	public List<P2p_index_picture> findIndexPicture(String type) {
		
		return indexPictureRepository.findIndexPicture(type);
	}

}
