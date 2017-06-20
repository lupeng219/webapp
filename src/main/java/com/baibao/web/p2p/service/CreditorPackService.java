package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;

/**
 * 借款人信息
 * @author jiangp
 * @date 2015年10月16日
 */
public interface CreditorPackService {
 
	/**
	 * 查询借款人信息
	 * @param productNo
	 * @return
	 * @throws Exception
	 */
	public Paging<P2p_creditor_pack>
		getUserByProductNo(String productNo, int currentPageNo, int pageSize)
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
