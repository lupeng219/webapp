package com.baibao.web.p2p.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.repository.LoanApplyRepository;
import com.baibao.pay.GetUniqueNoService;
import com.baibao.web.p2p.service.LoanApplyService;

@Service("loanApplyService")
public class LoanApplyServiceImpl implements LoanApplyService {
	private static Logger logger = LoggerFactory.getLogger(LoanApplyServiceImpl.class);

	@Autowired
	private LoanApplyRepository loanApplyRepository;
	@Autowired
	private GetUniqueNoService getUniqueNoService;

	
	@Override
	public int insertSelective(P2p_loan_apply record) {
		//获取借款编号
		String productNo = "";
		int count = 0;

		try {
			productNo = getUniqueNoService.getProjectNo();
			record.setPpProductNo(productNo);
			count = loanApplyRepository.insertSelective(record);
		} catch(BusinessException e) {
			 logger.error("insertSelective", e);
		}

		return count;
	}

	@Override
	public P2p_loan_apply searchByPorductNo(String productNo) {
		return loanApplyRepository.searchByPorductNo(productNo);
	}

	@Override
	public Paging<P2p_loan_apply> findLoanApplyRecordsByCust(String custNo,
			String loanApplyStatus, int currentPageNo, int pageSize) throws BusinessException {
		Paging<P2p_loan_apply> pag = new Paging<P2p_loan_apply>(
				currentPageNo, pageSize);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("custNo", custNo);
		params.put("loanApplyStatus", loanApplyStatus);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pageSize);
		pag.setPageList(loanApplyRepository.findLoanApplyRecordsByCust(params));
		pag.setCountTotal(loanApplyRepository.findLoanApplyRecordsByCustTotal(params));
		return pag;
	}
	
}
