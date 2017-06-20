package com.baibao.web.p2p.generator.dao;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;

public interface P2p_loan_product_aidMapper {

    int insert(P2p_loan_product_aid record);
    /**
     * 查询用户投资记录
     * @param params
     * @return
     */
    public List<P2p_loan_product_aid> queryTenderRecordByCust(Map<String, Object> params);
    
    public Integer getCustTenderRecordTotal(Map<String, Object> params);
    
    public List <P2p_loan_product_aid> queryPorductAid(Map<String, Object> params);
    
    public P2p_loan_product_aid queryByProductNo(String productNo);
    // <!--App首页展示活动标 -->
    public Map<String, Object>queryPorductAidActiveApp();
    //App首页展示可投标
    public Map<String, Object>queryPorductAidApp();
    /**
     * 分页查询用户借款记录
     * @param params
     * @return
     */
    public List<Map<String, Object>> findLoanProductAidPage(Map<String, Object> params);
    
    /**
     * 分页查询用户借款记录count
     * @param params
     * @return
     */
    public int findLoanProductAidTotal(Map<String, Object> params);
    
    public List<P2p_loan_product_aid> findLoanProductAidListPage(Map<String, Object> params);
    
    public int getLoanProductAidListTotal(Map<String, Object> params);
    
    public List<P2p_loan_product_aid> findLoanProductAidCreditTransListPage(Map<String, Object> params);
    
    public int getLoanProductAidCreditTransListTotal(Map<String, Object> params);
    
    /**
     *查询新手标的
     * @param params
     * @return
     */
    public List<P2p_loan_product_aid>findLoanListByActivityType(Map<String, Object> params);
    public int findLoanListByActivityTypeCount (Map<String, Object> params);
    /**
	 * 根据产品编号获得产品
	 * @param productNo
	 * @return
	 */
	public P2p_loan_product_aid selectByProductNo(String productNo);
	
	/**
	 * 更新标的状态
	 * @param map
	 * @return
	 */
	public int updateLoanProduct_aidStatus(Map<String, Object> map);
	
	public List<P2p_loan_product_aid> findActiveProductAidList();
	
	public List<P2p_loan_product_aid> queryProductAidBydybz(Map<String, Object> map);
	/**
	 * 查询首页资产包
	 * @param map
	 * @return
	 */
	public List<P2p_loan_product_aid> queryAssetsPackProductAid(Map<String, Object> map);
	
	/**
	 * 查询首页佰宝day
	 * @param map
	 * @return
	 */
	public List<P2p_loan_product_aid> queryTermDaysProductAid(Map<String, Object> map);
	
	/**
	 * 更新标的状态
	 * @param map
	 * @return
	 */
	public int updateLoanProductStatus(Map<String, Object> map);
	/**
	 * 查询新手体验标
	 * @return
	 */
	public P2p_loan_product_aid queryNoviceExclusive();
	
	/**
	 * 查询新手体验标
	 * @return
	 */
	public List<P2p_loan_product_aid> queryNoviceExclusives();
	
	/**
	 * 查询债权转让协议
	 * @param map
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getequitableAssignments(Map<String, Object> map) throws BusinessException;
	
	/**
	 * 查询借款保证协议
	 * @param map
	 * @return
	 */
	public Map<String, Object> loanGuaranteeAgreements(Map<String, Object> map);
	
	/**
	 * 查询借款协议
	 * @param map
	 * @return
	 */
	public Map<String, Object> loanAgreements(Map<String, Object> map);

	/**
	 * 根据产品编号查询产品(一期项目)
	 * @param productNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getProductNo(String productNo) throws BusinessException;
	
	 /**
	 * 全网累计交易笔数(产品数量)
	 * @return
	 */
	public int  getAllProductCount();
	
	public List<P2p_loan_product_aid> tenderAssigning(Map<String, Object> params);
	
	public Integer tenderAssigningCount(Map<String, Object>map);

	public List<P2p_loan_product_aid> tenderAssignFinish(Map<String, Object> params);
	
	public Integer tenderAssignFinishCount(Map<String, Object>map);
    /**
     * App首页展示可投标(直投)
     * @return
     */
    public Map<String, Object>queryPorductAidAppDirect();
    /**
     * App首页展示可投标(按天计息)
     * @return
     */
    public Map<String, Object>queryPorductAidAppDay();
    /**
     * app首页展示债转标的个数(可投)
     * @return
     */
    public Integer queryPorductAidAppAttornCount();
	
}