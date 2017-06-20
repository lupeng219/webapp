package com.baibao.web.p2p.generator.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.baibao.web.p2p.generator.bean.P2p_bill_plan;

public interface P2p_bill_planMapper
{
	public int updateRepaymentStatus(
		String productNo, Integer seq,
		Integer repaymentStatus, Timestamp repaymentTime, Integer overDueDays);
	
	public int countBillPlan(Map<String, Object> map);
	
	public List<P2p_bill_plan> findBillPlanByProduct(Map<String, Object> map);
}
