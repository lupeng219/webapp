package com.baibao.web.p2p.repository;

import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;

public interface LoanProductAidRepository {

	 /**
     * 查询用户投资记录(分页)
     * @param params
     * @return
     */
    public List<P2p_loan_product_aid> queryTenderRecordByCust(Map<String, Object> params);
    
    public Integer getCustTenderRecordTotal(Map<String, Object> params);
    /**
     * 查询产品投资记录
     * @param params
     * @return
     */
    public List<P2p_tender_record> queryTenderRecordByPorductNo(Map<String, Object> params);
    
    public Integer selectTotalByPorductNo(Map<String, Object> params);
    
    /**
     * 关联查询产品表
     * @param params
     * @return
     */
    public List<P2p_loan_product_aid> queryProductAid(Map<String, Object> params);
    
    public P2p_loan_product_aid queryByProductNo(String productNo);
    
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
     * 查询新手标的
     * @param params
     * @return
     */
    public List<P2p_loan_product_aid> findLoanListByActivityType(Map<String, Object> params);
    
    public int findLoanListByActivityTypeCount(Map<String, Object> params);
    
    public List<P2p_loan_product_aid> findActiveProductAidList();
    /**
     * 根据客户号查询投标记录
     * @param map
     * @return
     */
    List<Map<String, Object>>tenderRecordByCustNo(Map<String, Object>map);
    int tenderRecordByCustNoCount(Map<String, Object>map);
	/**
	 * <!--App首页展示活动标 -->
	 * @return
	 */
    public Map<String, Object>queryPorductAidActiveApp();
    /**
     * App首页展示可投标(资产包)
     * @return
     */
    public Map<String, Object>queryPorductAidApp();
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
    /**
     * 查询产品图片
     * @param map
     * @return
     */
    List<P2p_loan_product_picture> selectByproductNo(Map<String, Object>map) ;
    
    /**
     * 首页抵押保障标查询
     * @return
     */
    public List<P2p_loan_product_aid> queryProductAidBydybz(Map<String, Object> map);

    /**
     * 首页查询资产包
     * @param map
     * @return
     */
    public List<P2p_loan_product_aid> queryAssetsPackProductAid(Map<String, Object> map);
    
    /**
     * 首页查询佰宝day
     * @param map
     * @return
     */
    public List<P2p_loan_product_aid> queryTermDaysProductAid(Map<String, Object> map);
    
    /**
     * 修改产品标的状态
     * @param productNo
     * @return
     */
    int updateProductLoanStatus(String productNo,String loanStatus);
    
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
     * 查询产品投资记录(一期项目)
     * @param params
     * @return
     */
    public List<P2p_tender_record> queryOldTenderRecord(Map<String, Object> params);
	
	 /**
     * 查询产品投资记录总条数(一期项目)
     * @param params
     * @return
     */
    public Integer selectOldTotal(Map<String, Object> params);
	
	/**
	 * 根据产品编号查询产品(一期项目)
	 * @param productNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getProductNo(String productNo) throws BusinessException;
	
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
	 * 投标记录详情
	 * @param tenderFlowNo
	 * @return
	 */
	public Map<String, Object> findByTenderFlowNo(String tenderFlowNo);
	
	/**
	 * 用户债转中列表
	 * @param params
	 * @return
	 */
	public List<P2p_loan_product_aid> tenderAssigning(Map<String, Object> params);
	
	/**
	 * 用户债转中总数
	 * @param map
	 * @return
	 */
	public int tenderAssigningCount(Map<String, Object> map);
	
	/**
     * 用户债转完成列表
     * @param params
     * @return
     */
	public List<P2p_loan_product_aid> tenderAssignFinish(Map<String, Object> params);
	
	/**
     * 用户债转完成总数
     * @param map
     * @return
     */
	public int tenderAssignFinishCount(Map<String, Object> map);
}
