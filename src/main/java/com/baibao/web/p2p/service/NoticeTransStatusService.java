package com.baibao.web.p2p.service;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;

/**
 * 处理通知类型：代收，代付，批次等
 * @author wgl
 *
 */
public interface NoticeTransStatusService {


	/**
	 * 查询订单
	 * @return
	 */
	public Map<String, Object> queryTransFlow( Map<String, Object> map ) throws BusinessException;
	
	/**
	 * 修改订单状态
	 * @return
	 */
	public int modifyTransFlowStatus( Map<String, Object> map ) throws BusinessException;
	/**
	 * 查询订单
	 * @return
	 */
	public Map<String, Object> queryOTransFlow( Map<String, Object> map ) throws BusinessException;
	/**
	 * 修改订单状态
	 * @return
	 */
	public int modifyOTransFlowStatus( Map<String, Object> map ) throws BusinessException;
	
	/**
	 * 查询订单 还款批次表
	 * @return
	 */
	public Map<String, Object> queryInvestor_repayment( String order ) throws BusinessException;
	
	/**
	 * 修改订单状态 还款批次表
	 * @return
	 */
	public int updateInvestor_repayment( String order,String repayStatus ,String hostFlow  ) throws BusinessException;
	/**
	 * 查询订单 还款批次明细表
	 * @return
	 */
	public Map<String, Object> queryInvestor_repayment_detail( String order  ) throws BusinessException;
	/**
	 * 修改订单状态 还款批次明细表
	 * @return
	 */
	public int updateInvestor_repayment_detail( String order,String repayStatus ,String hostFlow ) throws BusinessException;
	/**
	 * 查询某个批次的还款中所有的明细状态 借款人还款
	 * @return
	 */
	public List<Map<String, Object>> queryAllInvestor_repayment_detailByBatchNo( String batchNo ) throws BusinessException;
	
}
