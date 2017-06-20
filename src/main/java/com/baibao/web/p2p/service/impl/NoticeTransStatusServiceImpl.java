package com.baibao.web.p2p.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.CalenderUtil;
import com.baibao.web.p2p.service.NoticeTransStatusService;

@Service("noticeTransStatusService")
public class NoticeTransStatusServiceImpl implements NoticeTransStatusService{

	//@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public Map<String, Object> queryTransFlow( Map<String, Object> param ) {
		
		return sqlSession.selectOne("IOTransFlow.queryTransFlow",param);
	}

	@Override
	public int modifyTransFlowStatus( Map<String, Object> param ) {
		
		return sqlSession.update("IOTransFlow.updateTransFlow",param);
	}

	@Override
	public Map<String, Object> queryOTransFlow(Map<String, Object> map)
			throws BusinessException {
		
		return sqlSession.selectOne("IOTransFlow.queryOTransFlow",map);
	}

	@Override
	public int modifyOTransFlowStatus(Map<String, Object> map)
			throws BusinessException {
		
		return sqlSession.update("IOTransFlow.updateOTransFlow",map);
	}

	@Override
	public Map<String, Object> queryInvestor_repayment(String order)
			throws BusinessException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("batchNo", order);
		return sqlSession.selectOne("IOTransFlow.queryInvestor_repayment",params);
	}

	@Override
	public int updateInvestor_repayment(String order,String repayStatus ,String hostFlow )
			throws BusinessException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IR_batchNo", order);
		params.put("IR_repayStatus", repayStatus);
		params.put("TR_host_response_time", CalenderUtil.generatorCurrentDate(CalenderUtil.PATTERN_yyyyMMddhhmmss));
		params.put("TR_host_response_flowNum", hostFlow);
		params.put("TR_host_return_code", "");
		params.put("TR_host_return_message", "");
		return sqlSession.update("IOTransFlow.updateInvestor_repayment",params);
	}

	@Override
	public Map<String, Object> queryInvestor_repayment_detail( String order) throws BusinessException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("repayTransFlowNo", order);
		return sqlSession.selectOne("IOTransFlow.queryInvestor_repayment_detail",params);
	}
	@Override
	public int updateInvestor_repayment_detail( String order,String repayStatus ,String hostFlow )throws BusinessException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("repayTransFlowNo", order);
		params.put("repayStatus", repayStatus);
		params.put("TRD_host_response_time", CalenderUtil.generatorCurrentDate(CalenderUtil.PATTERN_yyyyMMddhhmmss));
		params.put("TRD_host_response_flowNum", hostFlow);
		params.put("TRD_host_return_code", "");
		params.put("TRD_host_return_message", "");
		return sqlSession.update("IOTransFlow.updateInvestor_repayment_detail",params);
	}

	@Override
	public List<Map<String, Object>> queryAllInvestor_repayment_detailByBatchNo(String batchNo) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("batchNo", batchNo);
		return sqlSession.selectList("IOTransFlow.queryAllInvestor_repayment_detailByBatchNo",params);
	}
}
