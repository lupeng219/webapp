package com.baibao.web.p2p.service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;

public interface LoanProductAidService {
	/**
	 * 查询投资记录
	 * @param custNo
	 * @param bulkStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	
	public Paging<P2p_loan_product_aid> queryTenderRecordByCust(String custNo,String bulkStatus,int currentPageNo,
			int pageSize,String beginTime,String endTime);

	
	/**
	 * 根据产品编号查询投资记录
	 * @param custNo
	 * @param bulkStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	
	public Paging<P2p_tender_record> queryTenderRecordByPorductNo(String product,int currentPageNo,
			int pageSize);

	public List<P2p_loan_product_aid> queryLoanProductAidList(Map<String, Object> params);
	/**
	 * 根据客户号查询投资记录
	 * @param custNo
	 * @param bulkLoanStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public Paging<Map<String, Object>>tenderRecordByCustNo(String custNo,String bulkLoanStatus ,int currentPageNo,
			int pageSize);
	/**
	 * 根据产品类型名称查询产品
	 * @param productTypeName
	 * @param showCount
	 * @return
	 */
	public List <P2p_loan_product_aid> queryProductAid(String productTypeNo,Integer showCount);
	/**
	 * 首页查询抵押保证标
	 * @param productTypeName
	 * @param showCount
	 * @return
	 */
	public List <P2p_loan_product_aid> queryProductAidBydybz(String productTypeNo,int ztCount);
	/**
	 * 首页查询资产包
	 * @param queryAssetsPackProductAid
	 * @return
	 */
	public List <P2p_loan_product_aid> queryAssetsPackProductAid(int assetsPackCount);
	
	/**
	 * 首页查询佰宝day
	 * @param queryTermDaysProductAid
	 * @return
	 */
	public List <P2p_loan_product_aid> queryTermDaysProductAid(int termDayCount);
	
	/**
	 * 根据产品号查询产品
	 * @param productNo
	 * @return
	 */
	public P2p_loan_product_aid  queryByProductNo(String productNo);
	
	/**
	 * 分页查询用户借款记录
	 * @param params
	 * @return
	 */
	public Paging<P2p_loan_product_aid> findLoanProductAidPage(String custNo,int bulkStatus,int pageNo,int pageSize);
	
	/**
	 * 分页查询产品列表记录
	 * @param params
	 * @return
	 */
	public Paging<P2p_loan_product_aid> findLoanProductAidListPage(
			String productType,String bulkStatus,Integer loanTerm,
			int pageNo,int pageSize,String type,String ppInvestmentType);
	
	/**
	 * 分页查询产品列表记录
	 * @param params
	 * @return
	 */
	public Paging<P2p_loan_product_aid> findLoanProductAidCreditTransListPage(Integer loanTerm, Integer loanRate, int pageNo, int pageSize);
	
	/**
	 * 查询新手标的
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @param pageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	public Paging<P2p_loan_product_aid> findLoanProductAidListType(String productType,String bulkStatus,Integer loanTerm,int pageNo,int pageSize,String type, String noviceNo);
	
	/**
	 * 查询活动产品列表记录
	 * @param params
	 * @return
	 */
	public List<P2p_loan_product_aid> findActiveProductAidList();
	
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
    
    public List<P2p_loan_product_picture> selectByproductNo(
			Map<String, Object> map) ;
	
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
	 * 等额本息
	 * @param capital 出借金额
	 * @param yearRate 年利率
	 * @param periodsNum 总期数
	 * */
	public List<Map<String, Object>> getProfitByEqual(BigDecimal capital, BigDecimal yearRate, Integer periodsNum);
	
	/**
	 * 先息后本
	 * @param capital 出借金额
	 * @param yearRate 年利率
	 * @param periodsNum 总期数
	 */
	public List<Map<String, Object>> getProfitByAfterPrincipal(BigDecimal capital, BigDecimal yearRate, Integer periodsNum);
	
	/**
	 * 按天计息
	 * @param loanAount
	 * @param yearRate
	 * @param allDays
	 * @return
	 */
	public List<Map<String, Object>> getInteresByDayPlan(BigDecimal loanAount,BigDecimal yearRate, Integer allDays);
	
	 /**
	 * 根据产品编号查询投资记录(old一期项目)
	 * @param custNo
	 * @param bulkStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public Paging<P2p_tender_record> queryOldTenderRecord(String productNo,int currentPageNo,
				int pageSize);
	/**
	 * 根据产品编号查询产品(一期项目)
	 * @param productNo
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getProductNo(String productNo) throws BusinessException;

	/**
	 * 投标记录详情
	 * @param tenderFlowNo
	 * @return
	 */
	public Map<String, Object> findByTenderFlowNo(String tenderFlowNo);
	
	/**
	 * 查询可以债转的产品列表
	 * @param custNo
	 * @param bulkLoanStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public Paging<Map<String, Object>> tenderAssignAbleByCustNo(String custNo,
            String bulkLoanStatus, int currentPageNo, int pageSize);
	
	/**
	 * 查询债转中的产品列表
	 * @param custNo
	 * @param bulkLoanStatus
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public Paging<P2p_loan_product_aid> tenderAssigningByCustNo(String custNo, int currentPageNo, int pageSize);
	
	/**
	 * 查询债转完成的产品列表
	 * @param custNo
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public Paging<P2p_loan_product_aid> tenderAssignFinishByCustNo(String custNo, int currentPageNo, int pageSize);
	
}
