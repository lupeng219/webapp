package com.baibao.web.p2p.repository;


public interface UsersTestimonialRepository {
	 /**
	  * 根据奖品编号和类型查询奖品数量
	  * @param type
	  * @param testimonialNo
	  * @return
	  */
	public int  searchTestimonial(int type,int testimonialNo);
	/**
	  * 根据奖品编号和类型修改奖品数量
	  * @param type
	  * @param testimonialNo
	  * @return
	  */
	public int updateByTestimonialNo(int type,int testimonialNo,int quantity);
}
