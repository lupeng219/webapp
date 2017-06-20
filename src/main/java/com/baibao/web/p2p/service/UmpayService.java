package com.baibao.web.p2p.service;

import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;


/**
 * 联动service(所有联动方法)
 * @Title: UmpayService.java
 * @Package com.baibao.web.p2p.service
 * @author zhangx
 * @date 2016年2月1日
 */
public interface UmpayService  {

	/**
	 *	用户信息(联动)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> selectCustAccount(String custNo) throws BusinessException;
	/**
	 * 交易记录(联动)
	 * @return
	 * @throws BusinessException
	 */
	public Paging<Map<String, Object>> getTransactionRecordPage(String custNo,Integer transType,Integer status,String startTime,String endTime,int currentPageNo, int pageSize) throws BusinessException;
	/**
	 * 提现页面数据(联动)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getPresentPage(String custNo) throws BusinessException;
	/**
	 * 用户提现
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> withdrawCash(String custNo,String withdrawalsMoney) throws BusinessException;
	/**
	 * App提现
	 * @param custNo
	 * @param withdrawalsMoney
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> withdrawCashApp(String custNo,String withdrawalsMoney) throws BusinessException;
	/**
	 * 更新提现记录
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public int updateWithdrawCash(Map<String,String> map) throws BusinessException;
}
