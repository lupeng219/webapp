package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;
/**
 * 借款人信息
 * @author admins
 */
public interface CreditorPackRepository {

	
	/**
	 * 根据产品编号查询借款人信息
	 * @param params 
	 * @return
	 * @throws RuntimeException
	 */
	public List<P2p_creditor_pack> findUserByProductNo(Map<String, Object> params) throws RuntimeException;
	
	/**
	 * 根据产品编号查询借款人总数
	 * @param params
	 * @return
	 * @throws RuntimeException
	 */
	public Integer selectCountByProductNo(Map<String, Object> params) throws RuntimeException;
}
