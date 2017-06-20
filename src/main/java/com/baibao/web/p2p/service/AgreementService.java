package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;


/**
 * 合同service
 * @Title: AgreementService.java
 * @Package com.baibao.web.p2p.service
 * @author zhangx
 * @date 2016年2月26日
 */
public interface AgreementService
{
	/**
	 * 借款协议
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object>
		loanAgreements(Map<String, Object> map) throws BusinessException; 
	
	/**
	 * 查询标的投标记录(合同)
	 * @param productNo
	 * @return
	 */
	public Paging<Map<String, Object>>
		getBidRecord(String productNo,int currentPageNo, int pageSize);
}
