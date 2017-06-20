package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;

/**
 * 联动
 * @Title: UmpayRepository.java
 * @Package com.baibao.web.p2p.repository
 * @author zhangx
 * @date 2016年2月1日
 */
public interface UmpayRepository {

	/**
	 * 根据客户号查找umId(联动)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public String selectCustAccount(String custNo) throws BusinessException;
	
	/**
	 * 查询代收本息(联动)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getPropertyPandect(String custNo) throws BusinessException;
	
	/**
	 * 查询用户冻结金额(联动)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public BigDecimal getAccountFreeze(String custNo) throws BusinessException;
	
	/**
	 * 查询用户交易记录(联动)
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> getTransactionRecordPage(Map<String, Object> params) throws BusinessException;
	/**
	 *  查询用户交易记录count(联动)
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public Integer getTransactionRecordPageTotal(Map<String, Object> params) throws BusinessException;
	/**
	 * 查询用户银行卡(联动)
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getBankCard(String custNo) throws BusinessException;
	/**
	 * save提现记录(联动)
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> saveWithDrawals(String custNo,BigDecimal money,String umpayUserId) throws BusinessException;
	/**
	 * 更新提现记录
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public int updateWithDrawals(Map<String,String> map) throws BusinessException;
}
