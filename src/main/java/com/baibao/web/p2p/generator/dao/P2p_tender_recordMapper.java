package com.baibao.web.p2p.generator.dao;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.generator.bean.P2p_tender_recordExample;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface P2p_tender_recordMapper {
    int countByExample(P2p_tender_recordExample example);

    int deleteByExample(P2p_tender_recordExample example);

    int deleteByPrimaryKey(Long ptrId);

    int insert(P2p_tender_record record);

    int insertSelective(P2p_tender_record record);

    List<P2p_tender_record> selectByExample(P2p_tender_recordExample example);

    P2p_tender_record selectByPrimaryKey(String tenderFlowNo);

    int updateByExampleSelective(@Param("record") P2p_tender_record record, @Param("example") P2p_tender_recordExample example);

    int updateByExample(@Param("record") P2p_tender_record record, @Param("example") P2p_tender_recordExample example);

    int updateByPrimaryKeySelective(P2p_tender_record record);

    int updateByPrimaryKey(P2p_tender_record record);
  
    int checkRecord(Map<String, Object> params);
    /**
     * 根据流水修改投资流水表信息
     * @param params
     * @return
     */
    int  updateByTenderFlowNo(Map<String, Object> params);
    /**
     * 查询产品投资记录
     * @param params
     * @return
     */
    public List<P2p_tender_record> queryTenderRecordByPorductNo(Map<String, Object> params);
    /**
     * 查询投资个数
     * @param params
     * @return
     */
    public int selectTotalByPorductNo(Map<String, Object> params);
    
    /**
     * 查询可疑状态的投资
     * @param params
     * @return
     */
    public List<Map<String, Object>> querySuspiciousTenderFlow();
    /**
     * 修改可疑的投资流水
     * @param params
     * @return
     */
    public int updateSuspiciousTenderFlow(Map<String, Object> params);
    /**
     * 投资记录
     * @param params
     * @return
     */
    public List<Map<String, Object>>tenderRecord(Map<String, Object> params);
    Integer tenderRecordCount(Map<String, Object> params);
    
    /**
	 * 每月投资总额
	 * @param custNo
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> getInvestmentAmount(String custNo) throws BusinessException;

	
	/**
	 * 全网累计投资总额
	 * @return
	 */
	public BigDecimal  getAllTenderAmount();
	/**
	 * 全网累计投资笔数
	 * @return
	 */
	public int  getAllTenderCount();
	
	/**
	 * 查询平台投资总人数
	 */
	
	public int getAllTenderPeopleCount();
	
	/**
	 * 根据客户号查询投资总额
	 * @return
	 */
	public BigDecimal getAmountBycustNo(Map<String, Object>map) throws BusinessException;
	/**
     * 根据客户号查询投标金额
     * @param custNo
     * @return
     * @throws BusinessException
     */
    public BigDecimal getPtrAmount(String custNo) throws BusinessException;
    /**
     * 根据客户号查询个人产品投资记录
     * @param map
     * @return
     * @throws BusinessException
     */
    public List<Map<String, Object>> tenderRecordByCustNo(Map<String, Object>map);
   
    public  Integer tenderRecordByCustNoCount(Map<String, Object>map);
    
    /**
     * 根据流水号查询投资流水表 （回调使用）  
     * @param params
     * @return
     */
    public Map<String, Object> findByTenderFlowNo( Map<String, Object> params );
    
	/**
	 * 统计时间段内的投资额
	 * @param String
	 * @return
	 */
	public Map<String, Object> statisticalTendAmountPeriodOfTime(Map<String, Object> p);
	
	/**
	 * 根据投资编号的到产品详情
	 * @param String
	 * @return
	 */
	public Map<String, Object> getProductByTenderFlowNo(String tenderFlowNo);
	
	/**
     * 查询投标记录(一期项目)
     * @param params
     * @return
     */
	public List<P2p_tender_record> queryOldTenderRecord(Map<String, Object> params);
	
	/**
	 * 查询投标记录数(一期项目)
	 * @param params
	 * @return
	 */
	public Integer selectOldTotal(Map<String, Object> params);
	
	/**
	 * 查询标的投标记录(合同)
	 * @param productNo
	 * @return
	 */
	public List<Map<String, Object>> getBidRecord(Map<String, Object> map);
	
	/**
	 * 查询标的投标记录Count(合同)
	 * @param productNo
	 * @return
	 */
	public int getBidRecordCount(Map<String, Object> map);
	
	/**
     * 根据客户号查询用户投标总额(一期+二期)
     * @param custNo
     * @return
     * @throws BusinessException
     */
    public BigDecimal queryTenderSum(String custNo) throws BusinessException;
	
}