package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;

public interface P2p_creditor_packMapper {
	
	/**
	 * 查询资产包里借款人信息	
	 * @param productNo 产品编号
	 * @return
	 * @throws Exception
	 */
	List<P2p_creditor_pack> findByProductNo(Map<String, Object> params)
			throws BusinessException;
	
	/**
	 * 查询资产包里借款人信息	
	 * @param productNo 产品编号
	 * @return
	 * @throws Exception
	 */
	List<P2p_creditor_pack> selectByProductNo(Map<String, Object> params)
			throws BusinessException;

	/**
	 * 查询资产包里借款人信息总数
	 * @param productNo 产品编号
	 * @return
	 * @throws Exception
	 */
	int selectCountByProductNo(Map<String, Object> params)
			throws BusinessException;
	
}