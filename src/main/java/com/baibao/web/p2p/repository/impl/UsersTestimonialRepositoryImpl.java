package com.baibao.web.p2p.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.baibao.web.p2p.generator.dao.P2p_users_testimonialMapper;
import com.baibao.web.p2p.repository.UsersTestimonialRepository;
@Repository
public class UsersTestimonialRepositoryImpl implements UsersTestimonialRepository {

	@Autowired
	private P2p_users_testimonialMapper  p2p_users_testimonialMapper;
	
	@Override
	public int searchTestimonial(int type, int testimonialNo) {
		return p2p_users_testimonialMapper.searchTestimonial(type, testimonialNo);
	}

	@Override
	public int updateByTestimonialNo(int type, int testimonialNo, int quantity) {
		return p2p_users_testimonialMapper.updateByTestimonialNo(type, testimonialNo, quantity);
	}

}
