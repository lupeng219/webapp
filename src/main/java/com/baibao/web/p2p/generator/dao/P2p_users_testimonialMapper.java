package com.baibao.web.p2p.generator.dao;



import org.apache.ibatis.annotations.Param;



public interface P2p_users_testimonialMapper {
	 /**
	  * 根据奖品编号和类型查询奖品数量
	  * @param type
	  * @param testimonialNo
	  * @return
	  */
	public int  searchTestimonial(@Param("type")int type,@Param("testimonialNo")int testimonialNo);
	/**
	  * 根据奖品编号和类型修改奖品数量
	  * @param type
	  * @param testimonialNo
	  * @return
	  */
	public int updateByTestimonialNo(@Param("type")int type,@Param("testimonialNo")int testimonialNo,@Param("quantity")int quantity);

}