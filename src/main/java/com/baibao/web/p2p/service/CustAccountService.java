package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;

public interface CustAccountService
{
	public P2p_cust_account queryIdentityId(String custNo);
	
	public Map<String, Object>
		certificationOperation(Map<String, String> map,String custNo)
			throws BusinessException;
	
	/**
	 * 更新交易密码
	 * @param map
	 */
	public Map<String, Object> updateTransPassword(Map<String, Object> map)
		throws Exception;
	
	/**
	 * 检查交易密码
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> inspectTransPassword(Map<String, Object> map)
		throws BusinessException;
	
	/**
	 * 检查创建激活会员和绑定认证信息
	 * @param custNo 客户号
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> activateNemberOrBindingVerify(String custNo)
		throws BusinessException;
}
