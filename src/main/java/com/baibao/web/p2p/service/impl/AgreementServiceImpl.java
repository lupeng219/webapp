package com.baibao.web.p2p.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.repository.LoanProductAidRepository;
import com.baibao.web.p2p.repository.TendertProfitRepository;
import com.baibao.web.p2p.repository.TransRecordRepository;
import com.baibao.web.p2p.service.AgreementService;

/**
 * 合同实现类
 * @Title: AgreementServiceImpl.java
 * @Package com.baibao.web.p2p.service.impl
 * @author zhangx
 * @date 2016年2月26日
 */
@Service(value = "agreementService")
public class AgreementServiceImpl
	implements AgreementService
{
	private static Logger logger = LoggerFactory.getLogger(AgreementServiceImpl.class);
	
	@Autowired
	private LoanProductAidRepository loanProductAidRepository;
	@Autowired
	private TendertProfitRepository tendertProfitRepository;
	@Autowired
	private TransRecordRepository transRecordRepository;

	@Override
	public Map<String, Object> loanAgreements(Map<String, Object> map)
			throws BusinessException
	{
		Map<String, Object> result = new HashMap<String, Object>();
		
		//查询标的相关信息
		result = loanProductAidRepository.loanAgreements(map);
		
		BigDecimal principalAndInterest = new BigDecimal(0);//实际收益本息
		
		int periods = 0;//还款期数
	
		//收益记录
		List<P2p_tender_profit> tenderProfitList =
			tendertProfitRepository.findTenderProfitListByTenderFlowNo(map);
		for(P2p_tender_profit p2p_tender_profit: tenderProfitList)
		{
			++periods;

			principalAndInterest =
				principalAndInterest.add(p2p_tender_profit.getPtpFactprofit());
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		String end = "";
		
		try
		{
			startDate = formatter.parse(
				result.get("pp_bulkLoanEffectTime").toString());
			if (Integer.parseInt(
					result.get("pp_loanRepayment").toString()) ==
						Const.THEINTERESTPAIDBYTHEDAY)
			{//按天计息
				end = DateUtils.FatalismOperation(
					startDate, Integer.parseInt(
						result.get("pp_loanTerm").toString()));
			} else
			{//等额本息、先息后本
				end = DateUtils.MonthOperation(
					startDate, Integer.parseInt(
						result.get("pp_loanTerm").toString()));
			}

			result.put("dateDue", end);
		} catch(ParseException e)
		{
			logger.error("loanAgreements",e);
		}
		
		result.put("periods", periods);
		result.put("principalAndInterest", principalAndInterest);
		result.put("tenderProfitList", tenderProfitList);

		return result;
	}

	@Override
	public Paging<Map<String, Object>>
		getBidRecord(String productNo, int currentPageNo, int pageSize)
	{
		Paging<Map<String, Object>> pag =
			new Paging<Map<String, Object>>(currentPageNo,pageSize);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("beginWith", pag.getBeginWith());//开始条数
		map.put("count", pag.getPageSize());//每页显示条数
		map.put("productNo", productNo);//产品编号
		pag.setPageList(transRecordRepository.getBidRecord(map));
		pag.setCountTotal(transRecordRepository.getBidRecordCount(map));

		return pag;
	}
}
