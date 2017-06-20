package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.Context;




public interface TransactionService {

	/**
	 * 
	 * @param user 用户信息
	 * @param transType :                           
	 * @param isProject
	 * @throws Exception
	 */
	public Map<String, Object>  addTrans(Context context) throws Exception;
	
	
}
