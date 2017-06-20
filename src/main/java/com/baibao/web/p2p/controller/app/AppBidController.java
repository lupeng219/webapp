package com.baibao.web.p2p.controller.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.common.util.PropertiesUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.CalenderUtil;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.loan.model.LoanProductAid;
import com.baibao.loan.model.TenderRecord;
import com.baibao.loan.service.TenderRecordManager;
import com.baibao.utils.JsonHelper;
import com.baibao.utils.MapBuilder;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.UtilTools;
import com.baibao.web.p2p.ebaoquan.EbaoquanUtils;
import com.baibao.web.p2p.generator.bean.P2p_bill_plan;
import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_index_picture;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.repository.TenderRepository;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.AgreementService;
import com.baibao.web.p2p.service.CreditorPackService;
import com.baibao.web.p2p.service.IndexPictureService;
import com.baibao.web.p2p.service.LoanApplyService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.TenderService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.AppCallLogUtil;
import com.esotericsoftware.minlog.Log;

/**
 * @author lupeng
 * @date: 2016年1月9日上午9:33:57
 * 标的
 */
@Controller
@RequestMapping("/appBulkLoan")
public class AppBidController {
	
	private static String pash = Const.basePath+"/service/agreement/equitableAssignment";
	private static String pashTwo = Const.basePath +"/service/agreement/loanGuaranteeAgreement";
	private static final Logger logger = LoggerFactory
            .getLogger(AppBidController.class);
	
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private IndexPictureService  indexPictureService;
	@Autowired
	private TenderProfitService tenderProfitService;
	@Autowired
	private LoanProductAidService  loanProductAidService;
	@Autowired
	private LoanApplyService  loanApplyService;
	@Autowired
	private RepaymentBillService  repaymentBillService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private TenderService tenderService;
	@Autowired
	private BaseLog baseLog;
	@Autowired 
	private ActiveService activeService;
	@Autowired
	private AgreementService agreementService;
	@Autowired
	private EbaoquanUtils ebaoquanUtils;
	@Autowired
	private CreditorPackService creditorPackService;
	@Autowired
    private TenderRecordManager tenderRecordManager;
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "/toIndex",method= RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> toIndex(HttpServletRequest request,String custNo){
		AppCallLogUtil.printMsg(request, "appBulkLoan.toIndex","custNo");
 		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			//轮翻图
			List<P2p_index_picture> pictureList =indexPictureService.findIndexPicture(Const.app);
			if(pictureList!=null){
				for (P2p_index_picture p2p_index_picture : pictureList) {
					p2p_index_picture.setInterimPathUrl(PropertiesUtil.getSysConfigParams("FASTDFS_SERVER")+"/service/file/" + p2p_index_picture.getPathUrl());
				}
			}
			retMap.put("indexPicture", pictureList);
			//总收益
			//String profitType = Const.success;
			//BigDecimal tenderProfit =  tenderProfitService.tenderProfit(profitType);
			BigDecimal tenderProfit =tenderProfitService.getFrofitTotal();
			tenderProfit =tenderProfit==null?new BigDecimal(0):tenderProfit;
			retMap.put("tenderProfit",tenderProfit );
			//活动标
			/**
			paramMap = LoanProductAidService.queryPorductAidActiveApp();
			if(paramMap!=null && paramMap.size()>0){
				if(("4").equals(paramMap.get("pp_bulkLoanStatus").toString()) || ("5").equals(paramMap.get("pp_bulkLoanStatus").toString()) || ("2").equals(paramMap.get("pp_bulkLoanStatus").toString())){
					paramMap.put("progress",new BigDecimal(1));
				}
				retMap.put("productList",paramMap );
			}else{//非活动标但是是可投标
				paramMap = LoanProductAidService.queryPorductAidApp();
				if(paramMap!=null && paramMap.size()>0){
					if(("4").equals(paramMap.get("pp_bulkLoanStatus").toString()) || ("5").equals(paramMap.get("pp_bulkLoanStatus").toString()) || ("2").equals(paramMap.get("pp_bulkLoanStatus").toString())){
						paramMap.put("progress",new BigDecimal(1));
					}
				}
				retMap.put("productList",paramMap );
			}
			**/
			//推荐标(资产包)
			paramMap = loanProductAidService.queryPorductAidApp();
            if(paramMap!=null && paramMap.size()>0){
                paramMap.put("progress",this.progressRound(new BigDecimal(paramMap.get("pp_loanAmountExist").toString()), new BigDecimal(paramMap.get("pp_loanAmount").toString()), Integer.valueOf(paramMap.get("pp_bulkLoanStatus").toString())));
            }
            retMap.put("productList",paramMap );
            //推荐标(直投标)
            Map<String, Object> directMap = loanProductAidService.queryPorductAidAppDirect();
            if(directMap!=null && directMap.size()>0){
                directMap.put("progress",this.progressRound(new BigDecimal(directMap.get("pp_loanAmountExist").toString()), new BigDecimal(directMap.get("pp_loanAmount").toString()), Integer.valueOf(directMap.get("pp_bulkLoanStatus").toString())));
            }
            retMap.put("productListDirect",directMap );
            //推荐标(按天计息标)
            Map<String, Object> dayMap = loanProductAidService.queryPorductAidAppDay();
            if(dayMap!=null && dayMap.size()>0){
                dayMap.put("progress",this.progressRound(new BigDecimal(dayMap.get("pp_loanAmountExist").toString()), new BigDecimal(dayMap.get("pp_loanAmount").toString()), Integer.valueOf(dayMap.get("pp_bulkLoanStatus").toString())));
            }
            retMap.put("productListDay",dayMap );
            //债转标的个数(可投个数)
            Integer attornCount = loanProductAidService.queryPorductAidAppAttornCount();
            attornCount = attornCount==null?0:attornCount;
            retMap.put("attornCount",attornCount );
            //新人专享
			P2p_loan_product_aid noviceExclusive =loanProductAidService.queryNoviceExclusive();
			if(noviceExclusive!=null){
			    noviceExclusive.setProgress(this.progressRound(noviceExclusive.getPpLoanamountexist(), noviceExclusive.getPpLoanamount(), noviceExclusive.getPpBulkloanstatus()));
			}
			retMap.put("noviceExclusiveList", noviceExclusive);
			//注册的总人数
			String userCount ="0";
			Long longUserCount =userService.findUserCount();
			if(longUserCount !=null){
				userCount = longUserCount.toString();
			}
			
			retMap.put("userCount", userCount);
			if(StringUtil.isNotEmpty(custNo)){
				custNo=jedisUtil.getValue(custNo);
				P2p_user user = userService.getByLoginCustNo(custNo);
				if(user!=null){
					String  inviteCode=user.getPuInviteCode();
					retMap.put("invitationUrl",Const.basePath+"/service/wapRegister/toWapRegister?code="+inviteCode );
					retMap.put("shareIllustrates","中融佰诚-高收益等你来拿！！安全稳定放心，快来加入吧！");
				}
			}

		} catch (Exception e) {
			logger.error("app报错：/appBulkLoan/toIndex:", e);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
			retMap.put(Const.retCode, false);
			return retMap;
		}
		retMap.put("switch",false);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		retMap.put(Const.retCode, true);
		return retMap;
	}
	/**
	 * 产品列表
	 * @param currentPageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	@RequestMapping("/ProductList")
	@ResponseBody
	public Map<String, Object>ProductList(HttpServletRequest request,
		@RequestParam(value = "currentPageNo",required =false)Integer currentPageNo,
		@RequestParam(value = "pageSize",required =false)Integer pageSize
		){
		AppCallLogUtil.printMsg(request, "appBulkLoan.ProductList", "currentPageNo","pageSize");
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		pageSize = pageSize == null ? 10:pageSize;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Paging<P2p_loan_product_aid>  page = loanProductAidService.
				findLoanProductAidListPage("", null, null, 
						currentPageNo,pageSize,"activityType",null);
		List<P2p_loan_product_aid> list =page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 新手产品列表
	 * @param currentPageNo
	 * @param pageSize
	 * @param type
	 * @return
	 */
	@RequestMapping("/ProductListByType")
	@ResponseBody
	public Map<String, Object>ProductListByType(HttpServletRequest request,
		@RequestParam(value = "currentPageNo",required =false)Integer currentPageNo,
		@RequestParam(value = "pageSize",required =false)Integer pageSize,
		@RequestParam(value = "type",required=false) String type){
		AppCallLogUtil.printMsg(request, "appBulkLoan.ProductListByType", "currentPageNo","pageSize","type");
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		pageSize = pageSize == null ? 10:pageSize;
		
		if(StringUtils.isBlank(type)){
		    type = String.valueOf(Const.DIRECTBIDDING);
		}
		
        
		Paging<P2p_loan_product_aid>  page =loanProductAidService.findLoanProductAidListType("", null, null, currentPageNo,pageSize,type, null);
		List<P2p_loan_product_aid> list = page.getPageList();
		if(CollectionUtils.isEmpty(list)){
		    list = new ArrayList<P2p_loan_product_aid>();
		}
		
		
		// 处理完成度
		for(P2p_loan_product_aid product : list){
		    product.setProgress(this.progressRound(product.getPpLoanamountexist(), product.getPpLoanamount(), product.getPpBulkloanstatus()));
   		    //债转标，开放投标状态，计算倒计时
//		    if(Const.IFTHESTANDARD==product.getPpInvestmentType()){
//                if(Integer.valueOf(Const.openTender)==product.getPpBulkloanstatus().intValue()){
//                    long endtime = product.getPpBulkloanendtime().getTime();
//                    long currtime = System.currentTimeMillis();
//                    long countdown = endtime-currtime;
//                    if(countdown<0){
//                        countdown = 0;
//                    }
//                    product.setAssignCountdown(countdown);
//                }else{
//                    product.setAssignCountdown(0L);
//                }
//            }
		}
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	
	private String progressRound(BigDecimal loanAmountExist, BigDecimal loanAmount, Integer loanstatus)
    {
	    if(2==loanstatus ||  4==loanstatus || 5==loanstatus){
	        return new BigDecimal("100").toString();
	    }
	    if(loanAmountExist.doubleValue()==0){
	        return new BigDecimal("0.00").toString();
	    }
	    BigDecimal val = loanAmountExist.divide(loanAmount, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));

	    BigDecimal one = new BigDecimal("1");
	    BigDecimal result = val.divide(one,2,BigDecimal.ROUND_HALF_UP);
	    if(result.doubleValue()<0.01){
	        return new BigDecimal("0.01").toString();
	    }
	   
	    return  result.toString();
    }
	
	/**
	 * 显示产品详情
	 * @param productNo
	 * @param custNo
	 * @return
	 */
	@RequestMapping("/productDetailsApp")
	@ResponseBody
	public Map<String, Object> productDetailsApp(HttpServletRequest request, 
			@RequestParam("productNo") String productNo){
		AppCallLogUtil.printMsg(request, "appBulkLoan.productDetailsApp","productNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		try {
			P2p_loan_product_aid  productDetail=loanProductAidService.queryByProductNo(productNo);
			P2p_loan_apply  loanApply = loanApplyService.searchByPorductNo(productNo);
			if(productDetail==null || loanApply==null){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
				return retMap;
			}
			//			List<P2p_repayment_bill> billList =repaymentBillService.getByBulkLoanNumber(productNo);
			/**
			 * 增加到期时间计算    productExpireTime
			 * 产品在不同pp_bulkLoanStatus计算到期时间 投标结束时间+标的期限or查询数据库
			 * 判断按天计息和按月计息
			 */
			Date productExpireTime = new Date();
			if(Const.IFTHESTANDARD == productDetail.getPpInvestmentType()){
				productExpireTime = tenderProfitService.findLastPtpProfittime(productDetail.getPlpAssignProductNo());
			}
			else if(Const.openTender.equals(productDetail.getPpBulkloanstatus().toString())
				|| Const.fullMark.equals(productDetail.getPpBulkloanstatus().toString()) 
				|| Const.flowStandard.equals(productDetail.getPpBulkloanstatus().toString()))
			{
				
				if(Const.DIRECTBIDDING == productDetail.getPpInvestmentType() 
						&& Const.TerminabilityDays == productDetail.getPpLoanrepayment())
				{
					productExpireTime = CalenderUtil.getCalculationDate(productDetail.getPpBulkloanendtime(),
							productDetail.getPpLoanterm(),Calendar.DATE);
				}else
				{
					 productExpireTime = CalenderUtil.getCalculationDate(productDetail.getPpBulkloanendtime(),
							productDetail.getPpLoanterm(),Calendar.MONTH);
				}
			} else
			{
				productExpireTime = tenderProfitService.findLastPtpProfittime(productNo);
			}
			retMap.put("productExpireTime", productExpireTime);//到期时间
			////////end
			List<P2p_bill_plan> listBillPlan = null;
			String pNo = productNo;
			if(Const.IFTHESTANDARD==productDetail.getPpInvestmentType()){
			    listBillPlan = tenderProfitService.findBillPlanByProduct(
	                    new MapBuilder<String, Object>()
	                        .append("productNo", productDetail.getPlpAssignProductNo())
	                        .append("repaymentStatus", 0).toMap());
			}else{
			    listBillPlan = tenderProfitService.findBillPlanByProduct(
                        new MapBuilder<String, Object>().append("productNo", pNo).toMap());
			}
			
			paramMap.put("productNo", pNo);
			List<P2p_loan_product_picture>productPicture =loanProductAidService.selectByproductNo(paramMap);
			if(productPicture!=null){
				for(P2p_loan_product_picture pic : productPicture){
					pic.setPlpAddress(PropertiesUtil.getSysConfigParams("FASTDFS_SERVER")+"/service/file/"+pic.getPlpAddress());
				}
			}
			int ProductCount =0;
			if(Const.ASSETSPACK==productDetail.getPpInvestmentType()){
				ProductCount =  creditorPackService.selectCountByProductNo(paramMap);
			}
			int investmentCount = tenderService.selectTotalByPorductNo(paramMap);
			int surplusTerm=0;
			for(P2p_bill_plan bill : listBillPlan){
				if(bill.getPbpRepaymentStatus()==0){
					surplusTerm++;
				}
			}
			retMap.put("investmentCount", investmentCount);//投标人数
			retMap.put("productCount",ProductCount);//标的组成个数
			retMap.put("productPicture", productPicture);//图片
			retMap.put("base",surplusTerm ); //剩余基数
			retMap.put("billList",listBillPlan); //还款表现
			retMap.put("loanTitle", productDetail.getPpLoantitle());//借款申请标题
			retMap.put("loanAmountExist",productDetail.getPpLoanamountexist() );//标的已投总额
			retMap.put("comprehensiveRate",productDetail.getPpComprehensiverate() );//借款年利率
			retMap.put("loanTerm", productDetail.getPpLoanterm());//借款期限
			//标的状态
			int bulkLoanStatus = productDetail.getPpBulkloanstatus();
			retMap.put("bulkLoanStatus", bulkLoanStatus);
			//借款进度
			retMap.put("jindu", this.progressRound(productDetail.getPpLoanamountexist(), productDetail.getPpLoanamount(), productDetail.getPpBulkloanstatus()) );
			//还款方式
//			Integer fangshi = productDetail.getPpLoanrepayment();
//			if(0==fangshi){
//				retMap.put("loanRepayment", "等额本息");
//			}else if(1==fangshi){
//				retMap.put("loanRepayment", "每月付息，到期还本");
//			}else if(2==fangshi){
//				retMap.put("loanRepayment", "按天计息");
//			}
			retMap.put("loanRepayment", productDetail.getPpLoanrepayment().toString());
			if(1==bulkLoanStatus){
				//标的可投金额
				retMap.put("loanAmountAvailable",productDetail.getPpLoanamount().subtract(productDetail.getPpLoanamountexist()));
			}else{
			    retMap.put("loanAmountAvailable",0);
			}
			//满标用时
			retMap.put("bulkLoanDealSeconds", productDetail.getPpBulkloandealseconds());
			//协议
			if("1".equals(productDetail.getPpInvestmentType())){
				retMap.put("url",pashTwo );
				retMap.put("agreement", "借款保证协议(范本)");
			}else{
				retMap.put("url",pash);
				retMap.put("agreement", "债转协议(范本)");
			}
			retMap.put("loanAmount",productDetail.getPpLoanamount() );//项目总金额
			retMap.put("startTime",productDetail.getPpBulkloanstarttime() );//投标开始时间
			retMap.put("endTime", productDetail.getPpBulkloanendtime());//投标结束时间
			retMap.put("terderMinAmount", productDetail.getPpTerderminamount());//最小投标金额
			retMap.put("tenderMaxAmount", productDetail.getPpTendermaxamount());//最大投资金额
			retMap.put("tenderIncreaseAmount",productDetail.getPpTenderincreaseamount());//递增金额
			retMap.put("investmentType",productDetail.getPpInvestmentType());//投资类型
			String initeCode = "";
			if(StringUtils.isNotBlank(productDetail.getPp_inviteCode())){
			    initeCode = "BBJR";
			}
			retMap.put("inviteCode",initeCode);//邀请码  如果存在，往前台发送'BBJR', 不存在为 null 
			retMap.put("safeMehtod","本金+利息" );//保障方式
			retMap.put("loanDesc", loanApply.getPpLoandesc());//项目描述
			retMap.put("plpAssignProductNo", productDetail.getPlpAssignProductNo());//原始转让项目编号
            retMap.put("plpAssignTenderNo", productDetail.getPlpAssignTenderNo());//原始投资编号
            
			//债转标，获得最后一期收益时间
            Object profitTime = null;
			if(Const.IFTHESTANDARD==productDetail.getPpInvestmentType()){
			    String assingTenderNo = productDetail.getPlpAssignTenderNo();
	            if(StringUtils.isNotBlank(assingTenderNo)){
	                List<Map<String, Object>> tenderProfitList = tenderProfitService.paymentPlanByTenderFlowNo(assingTenderNo);
	                if(CollectionUtils.isNotEmpty(tenderProfitList)){
	                    Map<String, Object> tenderProfit = tenderProfitList.get(tenderProfitList.size()-1);
	                    if(tenderProfit!=null){
	                        profitTime = tenderProfit.get("ptp_profitTime");
	                    }
	                }
	            }
			}
			retMap.put("profitTime", profitTime);
			
			//可债转的冻结期数
			retMap.put("plpLockAssignationSeq", productDetail.getPlpLockAssignationSeq()==null ? 32767 : productDetail.getPlpLockAssignationSeq());
			
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		} catch (Exception e) {
		    logger.error("app报错：/appBulkLoan/productDetailsApp:", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
		}
		return retMap;
	}
	/**
	 * 资产包的组成
	 * @param request
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/creditorPacks")
	@ResponseBody
	public Map<String,Object> ajaxPageCreditorPacks(HttpServletRequest request,
			@RequestParam("productNo") String productNo,
			@RequestParam("currentPageNo")Integer currentPageNo){
		AppCallLogUtil.printMsg(request, "appBulkLoan.creditorPacks","productNo","currentPageNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
			Paging<P2p_creditor_pack> page = null;
			page = creditorPackService.getUserByProductNo(productNo, currentPageNo, 10);
			List<P2p_creditor_pack> list = page.getPageList();
			/**
			 * 替换姓名和身份证号
			 */
			for (P2p_creditor_pack p2p_creditor_pack : list) {
				p2p_creditor_pack.setPcpRealName(
						p2p_creditor_pack.fetchMaskRealName());
				p2p_creditor_pack.setPcpCertNo(
						p2p_creditor_pack.fetchMaskPcpCertNo());
			}
			page.setPageList(list);
			retMap.put("countTotal", page.getCountTotal());
			retMap.put("endNum",page.getEndPageNo() );
			retMap.put("statrNum",page.getStartPageNo());
			retMap.put("list", list);
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		} catch (Exception e) {
		    logger.error("app报错：/appBulkLoan/creditorPacks:", e);
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询失败
		}
		return retMap;
	}
	
	/**
	 * 查询投标记录
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/tenderRecord")
	@ResponseBody
	public Map<String, Object>TenderRecord(HttpServletRequest request,@RequestParam("productNo") String productNo,@RequestParam("currentPageNo")Integer currentPageNo,@RequestParam("pageSize")Integer pageSize){
		AppCallLogUtil.printMsg(request, "appBulkLoan.tenderRecord","productNo","currentPageNo","pageSize");
		Map<String, Object> retMap = new HashMap<String, Object>();
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		pageSize = pageSize == null ? 10:pageSize;
		Paging<P2p_tender_record> page =loanProductAidService.queryTenderRecordByPorductNo(productNo, currentPageNo, pageSize);
		List<P2p_tender_record> list = page.getPageList();
		page.setPageList(list);
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 产品详情(一期)
	 * @param request
	 * @param productNo
	 * @return
	 */
	@RequestMapping("/productDetailOne")
	@ResponseBody
	public Map<String, Object> productDetail(HttpServletRequest request,
			@RequestParam("productNo") String productNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			//查询标的信息
			Map<String, Object> productMap = loanProductAidService.getProductNo(productNo);
			if(productMap!=null){
				
				retMap.put("loanTitle",productMap.get("loanTitle") );//借款申请标题
				retMap.put("loanAmountExist",productMap.get("loanAmount") );//标的已投总额
				retMap.put("comprehensiveRate", productMap.get("comprehensiveRate"));//借款年利率
				retMap.put("loanTerm", productMap.get("loanTerm") );//借款期限
				retMap.put("bulkLoanStatus", Integer.parseInt("5"));//状态
				retMap.put("jindu",new BigDecimal(1) );//借款进度
				//还款方式
				Integer fangshi = (Integer) productMap.get("loanRepayment");
				if(0==fangshi){
					retMap.put("loanRepayment", "等额本息");
				}else if(1==fangshi){
					retMap.put("loanRepayment", "每月付息，到期还本");
				}
				retMap.put("url",pash);
				retMap.put("agreement", "债转协议(范本)");
				retMap.put("loanAmount",productMap.get("loanAmount") );//项目总金额
				retMap.put("startTime",productMap.get("bulkLoanStartTime"));//投标开始时间
				retMap.put("endTime",productMap.get("bulkLoanEndTime") );//结束时间
				retMap.put("terderMinAmount", BigDecimal.valueOf(Long.parseLong(productMap.get("terderMinAmount").toString())));//最小投标金额
				retMap.put("tenderMaxAmount", BigDecimal.valueOf(Long.parseLong(productMap.get("tenderMaxAmount").toString())));//最大投资金额
				retMap.put("tenderIncreaseAmount",BigDecimal.valueOf(Long.parseLong(productMap.get("tenderIncreaseAmount").toString())));//递增金额
				retMap.put("safeMehtod","本金+利息" );//保障方式
				retMap.put("loanDesc", productMap.get("loanDesc") );//项目描述
				retMap.put("base", "0");
				retMap.put("bulkLoanDealSeconds", productMap.get("bulkLoanDealSeconds"));//满标用时
				
			}
			//查询还款记录
			List<P2p_repayment_bill> billList = repaymentBillService.getOldByBulkLoanNumber(productNo);
			retMap.put("billList", billList); //还款表现
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		} catch (Exception e) {
		    logger.error("app报错：/appBulkLoan/productDetailOne:", e);
		}
		return retMap;
	}
	/**
	 * 查询投标记录(一期)
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/tenderRecordOne")
	@ResponseBody
	public Map<String, Object>TenderRecordOne(@RequestParam("productNo") String productNo,@RequestParam("currentPageNo")Integer currentPageNo,@RequestParam("pageSize")Integer pageSize){
		Map<String, Object> retMap = new HashMap<String, Object>();
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		 pageSize = pageSize == null ? 10:pageSize;
		 Paging<P2p_tender_record> page = loanProductAidService.queryOldTenderRecord(productNo,currentPageNo, pageSize);
		List<P2p_tender_record> list = page.getPageList();
		page.setPageList(list);
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	
	/**
	 * 查询个人的投标记录(投标中)
	 * @param custNo
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("tenderRecordByCustNo")
	@ResponseBody
	public Map<String, Object>TenderRecordByCustNo(HttpServletRequest request,String custNo,Integer currentPageNo,Integer pageSize){
		AppCallLogUtil.printMsg(request, "appBulkLoan.tenderRecordByCustNo","custNo","currentPageNo","pageSize");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		};
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
	    pageSize = pageSize == null ? 10:pageSize;
		String bulkLoanStatus = "1"; //产品状态  0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
		Paging<Map<String, Object>> page = loanProductAidService.tenderRecordByCustNo(custNo,bulkLoanStatus,currentPageNo,pageSize);
		List<Map<String, Object>> list = page.getPageList();
		page.setPageList(list);
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 *  查询个人的投标记录(还款中)
	 * @param custNo
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("tenderRecovery")
	@ResponseBody
	public Map<String, Object>tenderRecovery(HttpServletRequest request,String custNo,Integer currentPageNo,Integer pageSize){
		AppCallLogUtil.printMsg(request, "appBulkLoan.tenderRecovery","custNo","currentPageNo","pageSize");
		List<Map<String, Object>> summary_list = new ArrayList<Map<String, Object>>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		};
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
	    pageSize = pageSize == null ? 10:pageSize;
		String bulkLoanStatus = "4"; //产品状态  0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
		Paging<Map<String, Object>> page = loanProductAidService.tenderRecordByCustNo(custNo,bulkLoanStatus,currentPageNo,pageSize);
		List<Map<String, Object>> list = page.getPageList();
		BigDecimal tenderProfit = new BigDecimal(0);
		BigDecimal interest = new BigDecimal(0);
		Map<String, Object> map = null;
		Map<String, Object> maps = null;
		if(list!=null && list.size()>0){
			for(Map<String, Object> listparm :list ){
				map = new HashMap<String, Object>();
				map.put("pp_loanTitle", listparm.get("pp_loanTitle"));//标题
				map.put("ptr_productNo",listparm.get("ptr_productNo"));//产品编号
				map.put("pp_comprehensiveRate",listparm.get("pp_comprehensiveRate"));//利率
				map.put("pp_loanTerm",listparm.get("pp_loanTerm"));//期限
				map.put("pp_loanRepayment",listparm.get("pp_loanRepayment"));//还款方式
				map.put("pp_investmentType",listparm.get("pp_investmentType"));//投资类型
				map.put("ptr_tenderFlowNo", listparm.get("ptr_tenderFlowNo"));//投标流水
				map.put("ptr_amount", listparm.get("ptr_amount"));//投资金额
				map.put("ptr_transTime", listparm.get("ptr_transTime"));//投资时间
				map.put("ptr_status", listparm.get("ptr_status")==null ? 10 : listparm.get("ptr_status"));//投资类型
				map.put("bulkLoanStatus" ,4);//标的状态
				//根据投标流水号查询出数据保全合同id
//				try {
//					Long preservationId = agreementService.getEbaoquanPreservationId(listparm.get("ptr_tenderFlowNo")+"");
//					if(preservationId == null){
//						map.put("url", "");
//					}else{
//						maps = ebaoquanUtils.ContractFileViewUrlSample(preservationId);
//						map.put("url", maps.get("viewUrl").toString());
//					}
//				} catch (Exception e) {
//						map.put("url", "");
//				}
				//查询收益详情
				try {
					tenderProfit = tenderProfitService.tenderProfitByTenderFlowNo((String)listparm.get("ptr_tenderFlowNo"));
					tenderProfit = tenderProfit==null?new BigDecimal(0):tenderProfit;
					interest = tenderProfitService.tenderInterestByTenderFlowNo((String)listparm.get("ptr_tenderFlowNo"),"0");
					interest = interest ==null?new BigDecimal(0):interest;
				} catch (BusinessException e) {
					e.printStackTrace();
					logger.error("tenderRecovery", e);
				}
				map.put("capital_Interest", tenderProfit);
				map.put("interest", interest);
				summary_list.add(map);
			}
			
		}
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", summary_list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 *  查询个人的投标记录(已完成)
	 * @param custNo
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("tenderFinished")
	@ResponseBody
	public Map<String, Object>tenderFinished(HttpServletRequest request,String custNo,Integer currentPageNo,Integer pageSize){
		AppCallLogUtil.printMsg(request, "appBulkLoan.tenderFinished","custNo","currentPageNo","pageSize");
		List<Map<String, Object>> summary_list = new ArrayList<Map<String, Object>>();
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
			return retMap;
		};
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
	    pageSize = pageSize == null ? 10:pageSize;
		String bulkLoanStatus = "5"; //产品状态  0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
		Paging<Map<String, Object>> page = loanProductAidService.tenderRecordByCustNo(custNo,bulkLoanStatus,currentPageNo,pageSize);
		List<Map<String, Object>> list = page.getPageList();
		BigDecimal tenderProfit = new BigDecimal(0);
		BigDecimal interest = new BigDecimal(0);
		Map<String, Object> map = null;
		if(list!=null && list.size()>0){
			for(Map<String, Object> listparm :list ){
				map = new HashMap<String, Object>();
				map.put("pp_loanTitle", listparm.get("pp_loanTitle"));//标题
				map.put("ptr_productNo",listparm.get("ptr_productNo"));//产品编号
				map.put("pp_comprehensiveRate",listparm.get("pp_comprehensiveRate"));//利率
                map.put("pp_loanTerm",listparm.get("pp_loanTerm"));//期限
                map.put("pp_loanRepayment",listparm.get("pp_loanRepayment"));//还款方式
                map.put("pp_investmentType",listparm.get("pp_investmentType"));//投资类型
				map.put("ptr_tenderFlowNo", listparm.get("ptr_tenderFlowNo"));//投标流水
				map.put("ptr_transTime", listparm.get("ptr_transTime"));//投资时间
				map.put("ptr_amount", listparm.get("ptr_amount"));//投资金额
				map.put("ptr_status", listparm.get("ptr_status")==null ? 10 : listparm.get("ptr_status"));//投资类型
				map.put("bulkLoanStatus", 5);
				//根据投标流水号查询出数据保全合同id
//				try {
//					Long preservationId = agreementService.getEbaoquanPreservationId(listparm.get("ptr_tenderFlowNo")+"");
//					if(preservationId == null){
//						map.put("url", "");
//					}else{
//						maps = ebaoquanUtils.ContractFileViewUrlSample(preservationId);
//						map.put("url", maps.get("viewUrl").toString());
//					}
//				} catch (Exception e) {
//						map.put("url", "");
//				}
//				//查询收益详情
				try {
					tenderProfit = tenderProfitService.tenderFactProfitByTenderFlowNo((String)listparm.get("ptr_tenderFlowNo"));
					tenderProfit = tenderProfit==null?new BigDecimal(0):tenderProfit;
					interest = tenderProfitService.tenderInterestedByTenderFlowNo((String)listparm.get("ptr_tenderFlowNo"));
					interest = interest ==null?new BigDecimal(0):interest;
				} catch (BusinessException e) {
					logger.error("tenderFinished", e);
				}
				map.put("capital_Interest", tenderProfit);
				map.put("interest", interest);
				summary_list.add(map);
			}
			
		}
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", summary_list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return retMap;
	}
	/**
	 * 得到某个借款的还款详情
	 * @param custNo
	 * @param tenderFlowNo
	 * @return
	 */
	@RequestMapping(value="/getRepayments",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRepayments(HttpServletRequest request,String custNo,String tenderFlowNo){
		AppCallLogUtil.printMsg(request, "appBulkLoan.getRepayments","custNo","tenderFlowNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		if(StringUtil.isEmpty(tenderFlowNo)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		};
		List<Map<String, Object>>list = tenderProfitService.paymentPlanByTenderFlowNo(tenderFlowNo);
		retMap.put("list", list);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		retMap.put(Const.retCode, true);
		return retMap;
		
	}
	/**
	 * 投标(马上投标)
	 * @param appId
	 * @param bulkLoanNumber
	 * @return
	 */
	@RequestMapping( value = "/begainTender",method =RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> begainTender(HttpServletRequest request,String custNo,String productNo,String inviteCode){
		AppCallLogUtil.printMsg(request, "appBulkLoan.begainTender","custNo","productNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, Const.noLoginMsg);//用户未登录
			return retMap;
		}
		if(StringUtil.isEmpty(productNo)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		};
		try {
			P2p_loan_product_aid loanProduct = tenderRepository.selectByProductNo(productNo);
			if(loanProduct==null){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
				return retMap;
			}
			//项目邀请码
            if(loanProduct.getPp_inviteCode() != null && !loanProduct.getPp_inviteCode().equals(inviteCode))
            {                           
                retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, "渠道投资码错误，请重新输入");
                return retMap;
            }
			if (loanProduct.getPpCustno().equals(custNo)) {
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u501f\u6b3e\u4eba\u4e0d\u80fd\u6295\u8d44\u81ea\u5df1\u7684\u9879\u76ee");// 借款人不能投资自己的项目
				return retMap;
			}
			//债转标，原始标借款人不能投资
			if(Const.IFTHESTANDARD == loanProduct.getPpInvestmentType()){
			    String assingProdectNo = loanProduct.getPlpAssignProductNo();
                if(StringUtils.isBlank(assingProdectNo)){
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "当前债转标原始标信息未找到");
                    return retMap;
                }
                P2p_loan_product_aid assingLoanProduct = tenderRepository.selectByProductNo(assingProdectNo);
                if(assingLoanProduct==null){
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "当前债转标原始标信息未找到");
                    return retMap;
                }
                if(assingLoanProduct.getPpCustno().equals(custNo)) {
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "\u501f\u6b3e\u4eba\u4e0d\u80fd\u6295\u8d44\u81ea\u5df1\u7684\u9879\u76ee");// 借款人不能投资自己的项目
                    return retMap;
                }
			}
			if (loanProduct == null || loanProduct.getPpBulkloanstatus() != 1) {
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u8BE5\u6807\u7684\u4E0D\u53EF\u6295\uFF01");// 该标的不可投！
				return retMap;
			}
			
			if( loanProduct == null || loanProduct.getPpActivityType()==1){ //新手标 可投一次
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("activityType",Const.activityType );
				params.put("custNo", custNo);
				int ret = tenderRepository.checkRecord(params);
				if (ret>0){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u65b0\u624b\u6807\u53ea\u53ef\u6295\u8d44\u4e00\u6b21");// 新手标只可投资一次
					return retMap;
				}
			}
			
			P2p_cust_account account = accountService.getCustAccountByCustNo(custNo,true);
			if(account==null){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u67e5\u8be2\u9519\u8bef");//查询错误
				return retMap;
			}
			// 可用余额
			retMap.put("balance", account.getPcaAccountBalance());
			//是否设置交易密码
			if(!StringUtil.isEmpty(account.getPcaPayPassword())){
				retMap.put("transactionPassword", 0);//已设置交易密码
			}else{
				retMap.put("transactionPassword", 1);//未设置交易密码
			}
		} catch (BusinessException e) {
			logger.error("app报错：/appBulkLoan/begainTender:", e);
		}
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f" );//查询成功
		return retMap;
	}
	/**
	 * 进行投标交易 (立即投标)
	 * @param request
	 * @param custNo
	 * @param productNo
	 * @param bulkLoanAmount
	 * @param password
	 * @param channel 交易渠道:10 pc,11 苹果 , 12安卓, 13 H5 
	 * @return
	 */
	@RequestMapping(value="/verifyAccountTransPassword",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String, Object> verifyAccountTransPassword(HttpServletRequest request,
							String custNo, String productNo,BigDecimal bulkLoanAmount,String password,String channel,String inviteCode){
		AppCallLogUtil.printMsg(request, "appBulkLoan.verifyAccountTransPassword","custNo","productNo","bulkLoanAmount","password","channel");
		Map<String, Object> retMap = new HashMap<String, Object>();
		custNo = jedisUtil.getValue(custNo);
		if(StringUtil.isEmpty(custNo)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        }
		if(StringUtil.isEmpty(custNo) || StringUtil.isEmpty(productNo) || null == bulkLoanAmount) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		};
		try {
			baseLog.writer(custNo,"","",BusinessType.TENDER.getDesc(), RegistType.APP.getName(), "/verifyAccountTransPassword");
			P2p_loan_product_aid  loanProduct=loanProductAidService.queryByProductNo(productNo);
			if (loanProduct == null || loanProduct.getPpBulkloanstatus() != 1) {
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u8BE5\u6807\u7684\u4E0D\u53EF\u6295\uFF01");// 该标的不可投！
				return retMap;
			}
			
			// 借款人不能投资自己的项目
			if (loanProduct.getPpCustno().equals(custNo)) {
                retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, "\u501f\u6b3e\u4eba\u4e0d\u80fd\u6295\u8d44\u81ea\u5df1\u7684\u9879\u76ee");
                return retMap;
            }
            //债转标，原始标借款人不能投资
            if(Const.IFTHESTANDARD == loanProduct.getPpInvestmentType()){
                String assingProdectNo = loanProduct.getPlpAssignProductNo();
                if(StringUtils.isBlank(assingProdectNo)){
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "当前债转标原始标信息未找到");
                    return retMap;
                }
                P2p_loan_product_aid assingLoanProduct = tenderRepository.selectByProductNo(assingProdectNo);
                if(assingLoanProduct==null){
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "当前债转标原始标信息未找到");
                    return retMap;
                }
                if(assingLoanProduct.getPpCustno().equals(custNo)) {
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "\u501f\u6b3e\u4eba\u4e0d\u80fd\u6295\u8d44\u81ea\u5df1\u7684\u9879\u76ee");// 借款人不能投资自己的项目
                    return retMap;
                }
            }
            //新手标验证
            if( loanProduct == null || loanProduct.getPpActivityType()==1){ //新手标 可投一次
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("activityType",Const.activityType );
                params.put("custNo", custNo);
                int ret = tenderRepository.checkRecord(params);
                if (ret>0){
                    retMap.put(Const.retCode, false);
                    retMap.put(Const.retMsg, "\u65b0\u624b\u6807\u53ea\u53ef\u6295\u8d44\u4e00\u6b21");// 新手标只可投资一次
                    return retMap;
                }
            }
			
			BigDecimal loanAmountExistBD = loanProduct.getPpLoanamountexist();
			if( null == loanAmountExistBD )
			{
				loanAmountExistBD = new BigDecimal("0.00");
			}
			BigDecimal surplus = loanProduct.getPpLoanamount().subtract( loanAmountExistBD );//剩余可投金额
			
			if( surplus.compareTo(bulkLoanAmount ) == -1 ){
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u60a8\u8f93\u5165\u7684\u91d1\u989d\u5927\u4e8e\u5269\u4f59\u53ef\u6295\u91d1\u989d\uff0c\u8bf7\u60a8\u91cd\u65b0\u8f93\u5165");//您输入的金额大于剩余可投金额，请您重新输入
				return retMap;
			}
			
			if(Const.IFTHESTANDARD!=loanProduct.getPpInvestmentType()){
			    BigDecimal incrementAmount =loanProduct.getPpTenderincreaseamount();
	            if (bulkLoanAmount != null && bulkLoanAmount.divideAndRemainder(incrementAmount)[1] != BigDecimal.ZERO) {
	                retMap.put(Const.retCode, false);
	                retMap.put("retMsg", "\u6295\u8d44\u91d1\u989d\u5fc5\u987b\u662f\u6700\u5c0f\u6295\u8d44\u91d1\u989d" + incrementAmount + "\u5143\u7684\u6574\u6570\u500d"); //投资金额必须是最小投资金额xxx元的整数倍
	                return retMap;
	            }
	            if (loanProduct.getPpTendermaxamount().compareTo(bulkLoanAmount) == -1) {
	                retMap.put(Const.retCode, false);
	                retMap.put(Const.retMsg, "\u4e0d\u5f97\u8d85\u8fc7\u6700\u5927\u6295\u8d44\u989d"+loanProduct.getPpTendermaxamount()+"\u5143");// 不得超过最大投资额
	                return retMap;
	            }
	            
	            if (loanProduct.getPpTerderminamount().compareTo(bulkLoanAmount) == 1) {
	                retMap.put(Const.retCode, false);
	                retMap.put(Const.retMsg, "\u4e0d\u5f97\u4f4e\u4e8e\u6700\u5c0f\u6295\u8d44\u989d"+loanProduct.getPpTerderminamount()+"\u5143");// 不得低于最小投资额
	                return retMap;
	            }
			}
			
			P2p_cust_account account = accountService.getCustAccountByCustNo(custNo,true);
			if (account.getPcaAccountBalance().compareTo(bulkLoanAmount) == -1)
            {
			    retMap.put(Const.retCode, false);
			    retMap.put(Const.retMsg, "可用余额不足，请您重新输入");// 
                return retMap;
            }
			
			if(jedisUtil.getValue(custNo+"TOKEN")==null){
				jedisUtil.setValue(custNo+"TOKEN", "full");
			}else{
				retMap.put(Const.retMsg, "稍后重试");
				retMap.put(Const.retCode,false);
				return retMap;
			}
			//retMap = tenderService.tender(custNo,productNo, bulkLoanAmount, "",channel,password);
			//邀请码
			retMap = tenderService.tender(custNo,productNo, bulkLoanAmount, "",channel,password,inviteCode);
			
			baseLog.writer(custNo,"",retMap.toString(),BusinessType.TENDER.getDesc(), RegistType.APP.getName(), "/verifyAccountTransPassword");
			if((Boolean)retMap.get(Const.retCode)==true){
				retMap.put(Const.retMsg, "\u6295\u6807\u6210\u529f");//投标成功
				retMap.put(Const.retCode,true);
				return retMap;
			}
		} catch (Exception e) {
			logger.error("app报错：/appBulkLoan/verifyAccountTransPassword:", e);
			retMap.put(Const.retCode,false);
			retMap.put(Const.retMsg, "系统异常，请稍后再试");
		}finally{
			jedisUtil.del(custNo+"TOKEN");
		}	
 		return retMap;
	}
	
	/**
     * 理财计算器计算收益
     * @param cjje 出借金额
     * @param nhll 年化收益
     * @param jkqx 借款期限
     * @param hkfs 还款方式
     * @return
     */
	@RequestMapping( value = "/getProfit",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getProfit(
    	HttpServletRequest request,
    	Integer cjje, Double nhll,Integer jkqx,Integer hkfs)
	{
		AppCallLogUtil.printMsg(request,
			"appBulkLoan.getProfit", "cjje", "nhll", "jkqx", "hkfs");
	    Map<String, Object> retMap = new HashMap<String, Object>();
	    
	    BigDecimal amount = new BigDecimal(cjje);
        BigDecimal yearRate =
        	new BigDecimal(nhll).divide(new BigDecimal(100));
        
        if (hkfs == null)
        {
            hkfs = 0;
        } else
        if (hkfs == 4)
        {
            hkfs = 1;  //一次性到期返本付息，计算方法使用“先息后本”
        }
        
        List<Map<String, Object>> list =
        	new ArrayList<Map<String, Object>>();
        if (hkfs == 0)
        {//等额本息
            list = loanProductAidService.getProfitByEqual(amount, yearRate, jkqx);
        } else
        if (hkfs == 1)
        {//先息后本
            list = loanProductAidService.getProfitByAfterPrincipal(amount, yearRate, jkqx);
        } else
        if (hkfs == 5)
        {
            list = loanProductAidService.getInteresByDayPlan(amount, yearRate, jkqx);
        }
        
        // 计算应收利息
        BigDecimal lx = new BigDecimal(0);
        for(Map<String, Object> m: list)
        {
            String capitalInt = m.get("capitalInt").toString();
            
            m.put("capitalInt",
            	new BigDecimal(capitalInt)
            		.setScale(2, BigDecimal.ROUND_HALF_UP));
            m.put("interest",
            	new BigDecimal(m.get("interest").toString())
            		.setScale(2, BigDecimal.ROUND_HALF_UP));
            m.put("capital",
            	new BigDecimal(m.get("capital").toString())
            		.setScale(2, BigDecimal.ROUND_HALF_UP));
            
            BigDecimal b = new BigDecimal(m.get("interest").toString());
            
            lx = lx.add(b);
        }
        
        retMap.put(Const.retCode, true);
        retMap.put(Const.retMsg, "查询成功");

        retMap.put("cjje", amount.setScale(2));
        retMap.put("yslx",
        	lx.setScale(2, BigDecimal.ROUND_HALF_UP));// 应收利息
        retMap.put("jkqx", jkqx);
        retMap.put("hkfs", hkfs);
        retMap.put("result", list);

        return retMap;
	}
	
	/**
     * 我的投资_可债转列表
     * @param custNo
     * @return
     */
    @RequestMapping("tenderAssignAble")
    @ResponseBody
    public Map<String, Object>tenderAssignAble(HttpServletRequest request,String custNo){
        AppCallLogUtil.printMsg(request, "appBulkLoan.tenderAssignAble","custNo");
        List<Map<String, Object>> summary_list = new ArrayList<Map<String, Object>>();
        Map<String, Object> retMap = new HashMap<String, Object>();
        custNo = jedisUtil.getValue(custNo);
        if(StringUtil.isEmpty(custNo)) {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        };
        String bulkLoanStatus = "4"; //产品状态  0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
        Paging<Map<String, Object>> page = loanProductAidService.tenderAssignAbleByCustNo(custNo,bulkLoanStatus,1,100);
        List<Map<String, Object>> list = page.getPageList();
        Map<String, Object> map = null;
        if(list!=null && list.size()>0){
            for(Map<String, Object> listparm : list){
                if("11".equals((String)listparm.get("ptr_status"))){
                    continue;
                }
                String tenderFlowNo = (String)listparm.get("ptr_tenderFlowNo");
                List<Map<String, Object>> tenderProfitList = tenderProfitService.paymentPlanByTenderFlowNo(tenderFlowNo);
                int finishedTerm = 0;  //已收益期数
                int stillTerm = 0;  //未收益期数
                BigDecimal residual = new BigDecimal(0);  //剩余本金
                for(Map<String, Object> profitMap : tenderProfitList){
                    String profitstatus = (String)profitMap.get("ptp_profitstatus");
                    if("0".equals(profitstatus)){
                        stillTerm++;
                        residual = residual.add(new BigDecimal(profitMap.get("ptp_capital").toString()));
                    }else{
                        finishedTerm++;
                    }
                }
                Integer lockAssignationSeq = (Integer)listparm.get("lockAssignationSeq");
                if(lockAssignationSeq==null){
                    lockAssignationSeq = Integer.valueOf(Short.MAX_VALUE);
                }
                //已收益期数大于可债转的冻结期数
                if(finishedTerm<lockAssignationSeq){
                    continue;
                }
                //未收益期数大于1期
                if(stillTerm<=1){
                    continue;
                }
                //剩余本金大于1000
                if(residual.doubleValue()<=1000){
                    continue;
                }
                
                map = new HashMap<String, Object>();
                map.put("pp_loanTitle", listparm.get("pp_loanTitle"));//标题
                map.put("ptr_productNo",listparm.get("ptr_productNo"));//产品编号
                map.put("pp_comprehensiveRate",listparm.get("pp_comprehensiveRate"));//利率
                map.put("pp_loanTerm",listparm.get("pp_loanTerm"));//期限
                map.put("pp_investmentType",listparm.get("pp_investmentType"));//投资类型
                map.put("ptr_tenderFlowNo", listparm.get("ptr_tenderFlowNo"));//投标流水
                map.put("ptr_amount", listparm.get("ptr_amount"));//投资金额
                map.put("ptr_transTime", listparm.get("ptr_transTime"));//投资时间
                map.put("residual", residual);//剩余本金
                map.put("stillTerm",stillTerm);//剩余期数
                //转让手续费
//                BigDecimal amount = new BigDecimal(listparm.get("ptr_amount").toString());
                BigDecimal assignationFeeRate = (BigDecimal)listparm.get("assignationFeeRate");
                if(assignationFeeRate==null){
                    assignationFeeRate = new BigDecimal(0);
                }
                map.put("assignationFeeRate",assignationFeeRate);//债转费率
                BigDecimal assignatioFee = residual.multiply(assignationFeeRate).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                map.put("assignatioFee",assignatioFee);
                summary_list.add(map);
            }
        }
        retMap.put("countTotal", summary_list.size());
        retMap.put("list", summary_list);
        retMap.put(Const.retCode, true);
        retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
        return retMap;
    }
    
    /**
     * 我的投资_债转中列表
     * @param custNo
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("tenderAssigning")
    @ResponseBody
    public Map<String, Object>tenderAssigning(HttpServletRequest request,String custNo,Integer currentPageNo,Integer pageSize){
        AppCallLogUtil.printMsg(request, "appBulkLoan.tenderAssigning","custNo","currentPageNo","pageSize");
        List<Map<String, Object>> summary_list = new ArrayList<Map<String, Object>>();
        Map<String, Object> retMap = new HashMap<String, Object>();
        custNo = jedisUtil.getValue(custNo);
        logger.info("####### tenderAssigning custNo ###### :"+custNo);
        if(StringUtil.isEmpty(custNo)) {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        };
        currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
        pageSize = pageSize == null ? 10:pageSize;
        Paging<P2p_loan_product_aid> page = loanProductAidService.tenderAssigningByCustNo(custNo,currentPageNo,pageSize);
        List<P2p_loan_product_aid> list = page.getPageList();
        Map<String, Object> map = null;
        if(list!=null && list.size()>0){
            for(P2p_loan_product_aid productAid : list){
                map = new HashMap<String, Object>();
                map.put("pp_loanTitle", productAid.getPpLoantitle());//标题
                map.put("ptr_productNo",productAid.getPpProductno());//产品编号
                map.put("pp_comprehensiveRate",productAid.getPpComprehensiverate());//利率
                map.put("pp_loanTerm",productAid.getPpLoanterm());//期限
                map.put("pp_investmentType",productAid.getPpInvestmentType());//投资类型
                map.put("ptr_tenderFlowNo", productAid.getPtrTenderFlowNo());//投标流水
                map.put("ptr_amount", productAid.getPpLoanamount());//投资金额
                map.put("ptr_transTime", productAid.getPtr_transTime());//投资时间
                map.put("stillTerm",productAid.getPpLoanterm());//剩余期数
                map.put("assignationFeeRate",productAid.getAssignationFeeRate()==null? 0 : productAid.getAssignationFeeRate());//债转费率
                //债转标开放购买倒计时，单位毫秒
//                long endtime = productAid.getPpBulkloanendtime().getTime();
//                long currtime = System.currentTimeMillis();
//                long countdown = endtime-currtime;
//                if(countdown<0){
//                    countdown = 0;
//                }
//                map.put("assignCountdown",countdown);
                map.put("ppBulkloanstarttime", productAid.getPpBulkloanstarttime());
                map.put("ppBulkloanendtime", productAid.getPpBulkloanendtime());
                summary_list.add(map);
            }
        }
        retMap.put("countTotal", page.getCountTotal());
        retMap.put("endNum",page.getEndPageNo() );
        retMap.put("statrNum",page.getStartPageNo());
        retMap.put("list", summary_list);
        retMap.put(Const.retCode, true);
        retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
        return retMap;
    }
    
    /**
     * 我的投资_债转完成列表
     * @param custNo
     * @param currentPageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("tenderAssignFinish")
    @ResponseBody
    public Map<String, Object>tenderAssignFinish(HttpServletRequest request,String custNo,Integer currentPageNo,Integer pageSize){
        AppCallLogUtil.printMsg(request, "appBulkLoan.tenderAssignFinish","custNo","currentPageNo","pageSize");
        List<Map<String, Object>> summary_list = new ArrayList<Map<String, Object>>();
        Map<String, Object> retMap = new HashMap<String, Object>();
        custNo = jedisUtil.getValue(custNo);
        if(StringUtil.isEmpty(custNo)) {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        };
        currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
        pageSize = pageSize == null ? 10:pageSize;
        Paging<P2p_loan_product_aid> page = loanProductAidService.tenderAssignFinishByCustNo(custNo,currentPageNo,pageSize);
        List<P2p_loan_product_aid> list = page.getPageList();
        Map<String, Object> map = null;
        if(list!=null && list.size()>0){
            for(P2p_loan_product_aid productAid : list){
                map = new HashMap<String, Object>();
                map.put("pp_loanTitle", productAid.getPpLoantitle());//标题
                map.put("ptr_productNo",productAid.getPpProductno());//产品编号
                map.put("pp_comprehensiveRate",productAid.getPpComprehensiverate());//利率
                map.put("pp_loanTerm",productAid.getPpLoanterm());//期限
                map.put("pp_investmentType",productAid.getPpInvestmentType());//投资类型
                map.put("ptr_tenderFlowNo", productAid.getPtrTenderFlowNo());//投标流水
                map.put("ptr_amount", productAid.getPpLoanamount());//投资金额
                map.put("ptr_transTime", productAid.getPtr_transTime());//投资时间
                map.put("stillTerm",productAid.getPpLoanterm());//剩余期数
                map.put("assignationFeeRate",productAid.getAssignationFeeRate());//债转费率
                map.put("ppBulkloaneffecttime",productAid.getPpBulkloaneffecttime());//结算时间
                summary_list.add(map);
            }
        }
        retMap.put("countTotal", page.getCountTotal());
        retMap.put("endNum",page.getEndPageNo() );
        retMap.put("statrNum",page.getStartPageNo());
        retMap.put("list", summary_list);
        retMap.put(Const.retCode, true);
        retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
        return retMap;
    }
    
    /**
     * 执行债转
     * @param request
     * @param tenderFlowNo
     * @param password
     * @return
     */
    @RequestMapping("assignation")
    @ResponseBody
    public Map<String, Object> assignation(
    	HttpServletRequest request,
    	String custNo, String tenderFlowNo, String password)
    {
        AppCallLogUtil.printMsg(request,
        	"appBulkLoan.assignation","custNo","tenderFlowNo","password");
        
        Map<String, Object> retMap = new HashMap<String, Object>();
        
        custNo = jedisUtil.getValue(custNo);
        
        if (StringUtil.isEmpty(custNo)) 
        {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
            return retMap;
        };
        
        P2p_cust_account account =
        	accountService.getCustAccountByCustNo(custNo, false);

        if (!account.getPcaPayPassword().equals(password))
        {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, "交易密码不正确 ");

            return retMap;
        }

        TenderRecord tenderRecord = tenderRecordManager.get(tenderFlowNo);
        if (tenderRecord == null || !custNo.equals(tenderRecord.getCustNo()))
        {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, "没有找到指定投资记录");
            return retMap;
        }
        
        try
        {
            LoanProductAid aid =
            	tenderRecordManager.creditTrans(tenderFlowNo);

            retMap.put(Const.retCode, true);
            retMap.put(Const.retMsg, "恭喜，转让申请成功!");

            retMap.put("endtime", aid.getEndTime());
        } catch(Exception e) {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, e.getMessage());
        }

        Log.info(String.format("assignation %s",
        	JsonHelper.formatJson(retMap)));

        return retMap;
    }
    
}
