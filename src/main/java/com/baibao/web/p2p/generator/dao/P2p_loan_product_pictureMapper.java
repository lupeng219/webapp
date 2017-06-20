package com.baibao.web.p2p.generator.dao;

import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_pictureExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_loan_product_pictureMapper {
    int countByExample(P2p_loan_product_pictureExample example);

    int deleteByExample(P2p_loan_product_pictureExample example);

    int deleteByPrimaryKey(Long plpPictureid);

    int insert(P2p_loan_product_picture record);

    int insertSelective(P2p_loan_product_picture record);

    List<P2p_loan_product_picture> selectByExample(P2p_loan_product_pictureExample example);

    P2p_loan_product_picture selectByPrimaryKey(Long plpPictureid);

    int updateByExampleSelective(@Param("record") P2p_loan_product_picture record, @Param("example") P2p_loan_product_pictureExample example);

    int updateByExample(@Param("record") P2p_loan_product_picture record, @Param("example") P2p_loan_product_pictureExample example);

    int updateByPrimaryKeySelective(P2p_loan_product_picture record);

    int updateByPrimaryKey(P2p_loan_product_picture record);
    
    /**
     * 查询产品图片
     * @param map
     * @return
     */
    List<P2p_loan_product_picture> selectByproductNo(Map<String, Object>map);
    
}