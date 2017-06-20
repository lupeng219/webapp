package com.baibao.web.p2p.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_record;
import com.baibao.web.p2p.generator.bean.P2p_user_warehouse;
import com.baibao.web.p2p.generator.bean.P2p_users_redenvelope;

public interface TenderRepository {

	 /**
     * 根据流水修改投资流水表信息
     * @param params
     * @return
     */
	 int  updateByTenderFlowNo(Map<String, Object> params);
	 /**
	  * 某标投资个数
	  * @param params
	  * @return
	  */
	 int  selectTotalByPorductNo(Map<String, Object> params);
	 /**
	     * 根据订单流水号更新订单状态
	     * @param orderFlowNo
	     * @return
	     */
	 int updateByOrderFlowNo(@Param("orderFlowNo")String orderFlowNo,@Param("ppoStatus")String ppoStatus);
	 
	 
	 /**
		 * 查询第三方信息
		 * @param map
		 * @return
		 */
	 public P2p_cust_account getByCustNoAndType(Map<String, Object> map);
	 
	 
	 /**
		 * 根据产品编号获得产品
		 * @param productNo
		 * @return
		 */
	 public P2p_loan_product_aid selectByProductNo(String productNo);
	 
	 
	 /**
		 * 更新账户余额和冻结金额
		 * @param map
		 * @return
		 */
	 public int updateBalanceAndFreeze(@Param("custNo")String custNo,@Param("balance")String balance,@Param("freeze")String freeze);
		

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
	    public int updateSuspiciousTenderFlow( String flowNo, String status );

	    
	    /**
	     * 累计投资总额
	     * @return
	     */
	    public BigDecimal  getAllTenderAmount();
	    
	    /**
		 * 全网累计交易笔数(产品数量)
		 * @return
		 */
		public int  getAllProductCount();
		
		/**
		 * 查询平台逾期总数
		 */
		
		public int queryOverDueTotal();
		
		/**
		 * 查询平台投资总人数
		 */
		
		public int getAllTenderPeopleCount();
		

	    
	    /**
	     * 根据客户号查询投标金额
	     * @param custNo
	     * @return
	     * @throws BusinessException
	     */
	    public BigDecimal getPtrAmount(String custNo) throws BusinessException;
	    
	    /**
	     * 修改可疑的结标代付流水
	     * @param params
	     * @return
	     */
	    public int updateSuspiciousPaymentFlow( String flowNo, String status );

	    
	    /**
	     * 修改产品的最终状态
	     * @param params
	     * @return
	     */
		public int updateLoanProductStatus(String paf_transFlowNo, String status);

		
		/**
		 * 获得产品编号
		 * @param paf_transFlowNo
		 * @return
		 */
		public P2p_loan_record getLoanRecordByFlowNo(String paf_transFlowNo);
		
		 /**
	     * 根据流水号查询投资流水表 （回调使用）  
	     * @param params
	     * @return
	     */
	    public Map<String, Object> findByTenderFlowNo( Map<String, Object> params );
	    
	    public int checkRecord ( Map<String, Object> params );
	    /**
	     * 修改仓库表发放状态
	     * @param params
	     */
	    void updateByPuw_whNo(Map<String, Object> params);
	    /**
	     * 查询仓库表的产品id
	     * @param flowNo
	     * @return
	     */
	    P2p_users_redenvelope selectBytransFlowNoAction(String flowNo);
	    
	    P2p_user_warehouse selectBytransFlowNo(String flowNo);
	    
	    P2p_user_warehouse selectBytransFlowNoPay(String flowNo);
	    
	    P2p_users_redenvelope queryBytransFlowNoPay(String flowNo);
	    /**
	     * 修改仓库流水表状态
	     * @param params
	     */
	    void updateBywhNo(Map<String, Object> params);
	    /**
	     * 修改红包表状态
	     * @param map
	     * @return
	     */
	    int updateredenvelo(Map<String, Object>map);
	    
	    /**
	     * 根据客户号查询用户投标总额(一期+二期)
	     * @param custNo
	     * @return
	     * @throws BusinessException
	     */
	    public BigDecimal queryTenderSum(String custNo) throws BusinessException;
}
