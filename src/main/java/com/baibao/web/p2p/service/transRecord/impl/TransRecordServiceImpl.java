package com.baibao.web.p2p.service.transRecord.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.repository.TransRecordRepository;
import com.baibao.web.p2p.service.transRecord.TransRecordService;

@Service("transRecordService")
public class TransRecordServiceImpl implements TransRecordService{

	private static final Logger logger = LoggerFactory.getLogger(TransRecordServiceImpl.class);
	@Autowired
	private TransRecordRepository transRecordRepository;
	
	@Override
	public Paging<P2p_account_flow> getByCustNoAndType(String custNo,Integer transType,String status,String startTime,String endTime,int currentPageNo, int pageSize) 
	{
		Map<String, Object> params = new HashMap<String, Object>();
		
		Paging<P2p_account_flow> pag = new Paging<P2p_account_flow>(currentPageNo, pageSize);
		params.put("custNo", custNo);
		params.put("count", pag.getPageSize());
		params.put("transType", transType);
		params.put("beginWith",pag.getBeginWith());
		params.put("startTime",startTime);
		params.put("endTime",endTime);
		params.put("status",status);
		try
		{		   
    		pag.setPageList(transRecordRepository.allTransFlow(params));
    		pag.setCountTotal(transRecordRepository.allTransFlowTotal(params));		
		}
		catch(Exception e){
			logger.error("error",e);
		}
		return pag;
	}
	
	@Override
	public  List getInvestmentAmount(String custNo,List month) throws BusinessException{
		List investmentAmount = new ArrayList();
		List<Map<String, Object>> p2pTenderRecordList = transRecordRepository.getInvestmentAmount(custNo);
		if(p2pTenderRecordList !=null && p2pTenderRecordList.size()>0){
			for (int i = 0; i < month.size(); i++) {
				Boolean bool = false;
				for (Map<String, Object> map : p2pTenderRecordList) {
					if(map.get("ptr_transTime").equals(month.get(i))){
						investmentAmount.add(map.get("ptr_amount"));
						bool = true;
					}
				}
				if(!bool){
					investmentAmount.add(0);
				}
			}
		}else{
			for (int i = 0; i < month.size(); i++) {
				investmentAmount.add(0);
			}
		}
		return investmentAmount;
	}

	@Override
	public Paging<Map<String, Object>> tenderRecord(Map<String, Object> map,int currentPageNo, int pageSize) {
		Paging<Map<String, Object>> pag = new Paging<Map<String, Object>>(
				currentPageNo,pageSize);
		try {
			map.put("beginWith", pag.getBeginWith());
			map.put("count", pag.getPageSize());
			pag.setPageList(transRecordRepository.tenderRecord(map));
			pag.setCountTotal(transRecordRepository
					.tenderRecordCount(map));
		} catch (BusinessException e) {
			 logger.error("tenderRecord",e);
		}
		return pag;
	}

	@Override
	public Paging<P2p_account_flow> getByCustNoAndTypeApp(String custNo, Integer type, String status, String startTime,
			String endTime, int currentPageNo, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		Paging<P2p_account_flow> pag = new Paging<P2p_account_flow>(currentPageNo, pageSize);
		params.put("custNo", custNo);
		params.put("count", pag.getPageSize());
		params.put("transType", type);
		params.put("beginWith",pag.getBeginWith());
		params.put("startTime",startTime);
		params.put("endTime",endTime);
		params.put("status",status);
		try
		{		   
    		pag.setPageList(transRecordRepository.allTransFlowApp(params));
    		pag.setCountTotal(transRecordRepository.allTransFlowTotalApp(params));		
		}
		catch(Exception e){
			logger.error("error",e);
		}
		return pag;
	}

}
