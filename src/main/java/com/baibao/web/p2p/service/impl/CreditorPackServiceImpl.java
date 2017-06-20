package com.baibao.web.p2p.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.repository.CreditorPackRepository;
import com.baibao.web.p2p.service.CreditorPackService;

@Service("creditorPackService")
public class CreditorPackServiceImpl
	implements CreditorPackService
{
	private static final Logger logger =
		LoggerFactory.getLogger(CreditorPackServiceImpl.class);

	@Autowired
	private CreditorPackRepository creditorPackRepository;

	@Override
	public Paging<P2p_creditor_pack>
	getUserByProductNo(String productNo, int currentPageNo, int pageSize)
			throws BusinessException
	{
		Map<String, Object> params = new HashMap<String, Object>();
		Paging<P2p_creditor_pack> pag = new Paging<P2p_creditor_pack>(
				currentPageNo, pageSize);
		params.put("productNo", productNo);
		params.put("beginWith", pag.getBeginWith());
		params.put("count", pag.getPageSize());
		
		pag.setPageList(creditorPackRepository.
				findUserByProductNo(params));
		pag.setCountTotal(creditorPackRepository
				.selectCountByProductNo(params));
		
		return pag;
	}

	@Override
	public int selectCountByProductNo(Map<String, Object> params) throws BusinessException {
		return creditorPackRepository
				.selectCountByProductNo(params);
	}
}
