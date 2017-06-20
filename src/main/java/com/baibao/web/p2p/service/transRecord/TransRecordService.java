package com.baibao.web.p2p.service.transRecord;


import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;


public interface TransRecordService {
	
	public Paging<P2p_account_flow> getByCustNoAndType(String custNo,Integer type,String status,String startTime,String endTime,int currentPageNo, int pageSize);
	public Paging<P2p_account_flow> getByCustNoAndTypeApp(String custNo,Integer type,String status,String startTime,String endTime,int currentPageNo, int pageSize);
	/**
	 * 每月投资总额
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public  List getInvestmentAmount(String custNo,List month) throws BusinessException;
	
	public Paging<Map<String, Object>> tenderRecord(Map<String, Object>map,int currentPageNo, int pageSize);
}
