package com.baibao.web.p2p.controller.wap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.ebaoquan.EbaoquanUtils;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
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
import com.baibao.web.p2p.service.AgreementService;
import com.baibao.web.p2p.service.LoanApplyService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.TenderService;

//@Controller
@RequestMapping("/wapBulkLoan")
public class WapBidController {
	
	@Autowired
	private BaseLog baseLog;
	private static String pash = Const.basePath+"/service/tender/bondTransfers";
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
	private TenderProfitService tenderProfitService;
	@Autowired
	private TenderRepository tenderRepository;
	@Autowired
	private AgreementService agreementService;
	@Autowired
	private EbaoquanUtils ebaoquanUtils;
	
	
	/**
	 * 产品列表
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @return
	 */
	/*#RequestMapping("/showProductList")*/
	public ModelAndView  showProductList(HttpServletRequest request,
		@RequestParam(value="bulkStatus",required=false) String bulkStatus,
		@RequestParam(value="pageNum",required=false) Integer pageNum,
		@RequestParam(value="pageSize",required=false) Integer pageSize
		){
		ModelAndView mav = new ModelAndView("/wap/wapBulklaon");
		pageNum = (pageNum!=null)?pageNum:1;
		pageSize = (pageSize!=null)?pageSize:5;
		Paging<P2p_loan_product_aid>  page =loanProductAidService.findLoanProductAidListPage(null, bulkStatus, null, pageNum, pageSize,"activityType",null);
		List<P2p_loan_product_aid> activeList = loanProductAidService.findActiveProductAidList();
		List<P2p_loan_product_aid> list =page.getPageList();
		mav.addObject("paging", page);
		mav.addObject("activeList", activeList);
		mav.addObject("total", (list!=null&&list.size()>0)?list.size():0);
		mav.addObject("bulkStatus",bulkStatus);
		mav.addObject("list",list);
		mav.addObject("pageNum", pageNum);
		mav.addObject("pageSize", pageSize);
		mav.addObject("endNum", page.getPageTotal());
		return mav;
	}
	
	/**
	 * 新手产品列表
	 * @param currentPageNo
	 * @param pageSize
	 * @param type  1为新手标
	 * @return
	 */
	/*#RequestMapping("/ProductListByType")*/
	public ModelAndView ProductListByType(HttpServletRequest request,
		@RequestParam(value = "pageNum",required =false)Integer currentPageNo,
		@RequestParam(value = "pageSize",required =false)Integer pageSize,
		@RequestParam(value = "type",required=false) String type,
		@RequestParam(value="bulkStatus",required=false) String bulkStatus){
		ModelAndView mav = new ModelAndView("/wap/wapBulklaon");
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		pageSize = pageSize == null ? 10:pageSize;
		Map<String, Object> retMap = new HashMap<String, Object>();
		Paging<P2p_loan_product_aid>  page =loanProductAidService.findLoanProductAidListType("", bulkStatus, null, currentPageNo,pageSize,type, null);
		List<P2p_loan_product_aid> list =page.getPageList();
		retMap.put("countTotal", page.getCountTotal());
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		mav.addObject("paging", page);
		mav.addObject("total", (list!=null&&list.size()>0)?list.size():0);
		mav.addObject("list",list);
		mav.addObject("pageNum", currentPageNo);
		mav.addObject("pageSize", pageSize);
		mav.addObject("endNum", page.getPageTotal());
		mav.addObject("bulkStatus",bulkStatus);
		mav.addObject("type", type);
		return mav;
	}
	/**
	 * 显示产品详情
	 * @param productNo
	 * @param custNo
	 * @return
	 */
	/*#RequestMapping("/wapProductDetails")*/
	public String wapProductDetails(HttpServletRequest request, 
			@RequestParam("productNo") String productNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		P2p_user currentUser = SessionUtils.getCurrentUser(request);
		retMap.put("currentUser", currentUser);
		try {
			P2p_cust_account account = null;
			if(currentUser!=null){
				String custNo = currentUser.getPuCustNo();
				account = accountService.getCustAccountByCustNo(custNo,true);
				// 可用余额
				if(account!=null){
					retMap.put("balance", account.getPcaAccountBalance());
					//是否设置交易密码
					if(!StringUtil.isEmpty(account.getPcaPayPassword())){
						retMap.put("transactionPassword", 0);//已设置交易密码
					}else{
						retMap.put("transactionPassword", 1);//未设置交易密码
					}
				}else{
					retMap.put("balance", "0.00");
				};
			}else{
				retMap.put("balance", "0.00");
			}
			
			P2p_loan_product_aid  productDetail=loanProductAidService.queryByProductNo(productNo);
			P2p_loan_apply  loanApply = loanApplyService.searchByPorductNo(productNo);
			List<P2p_repayment_bill> billList =repaymentBillService.getByBulkLoanNumber(productNo);
			paramMap.put("productNo", productNo);
			List<P2p_loan_product_picture>productPicture =loanProductAidService.selectByproductNo(paramMap);
			int surplusTerm=0;
			for(P2p_repayment_bill bill:billList){
				if(bill.getPrbRepaymentstatus()==0){
					surplusTerm++;
				}
			}
			retMap.put("productPicture", productPicture);//图片
			retMap.put("base",surplusTerm ); //剩余基数
			retMap.put("billList",billList); //还款表现
			retMap.put("loanTitle", productDetail.getPpLoantitle());//借款申请标题
			retMap.put("loanAmountExist",productDetail.getPpLoanamountexist() );//标的已投总额
			retMap.put("comprehensiveRate",productDetail.getPpComprehensiverate() );//借款年利率
			retMap.put("loanTerm", productDetail.getPpLoanterm());//借款期限
			//标的状态
			int bulkLoanStatus = productDetail.getPpBulkloanstatus();
			retMap.put("bulkLoanStatus", bulkLoanStatus);
			BigDecimal jindu =new BigDecimal(0);
			//借款进度
			if(2==bulkLoanStatus ||  4==bulkLoanStatus || 5==bulkLoanStatus){
				jindu= new BigDecimal(1);
			}else{
				jindu = productDetail.getPpLoanamountexist().divide(productDetail.getPpLoanamount(),6,BigDecimal.ROUND_HALF_UP);
			}
			retMap.put("jindu",jindu );//借款进度
			//还款方式
			Integer fangshi = productDetail.getPpLoanrepayment();
			if(0==fangshi){
				retMap.put("loanRepayment", "等额本息");
			}else if(1==fangshi){
				retMap.put("loanRepayment", "每月付息，到期还本");
			}else if(2==fangshi){
				retMap.put("loanRepayment", "按天计息");
			}
			if(1==bulkLoanStatus){
				//标的可投金额
				retMap.put("loanAmountAvailable",productDetail.getPpLoanamount().subtract(productDetail.getPpLoanamountexist()));
			}
			//满标用时
			retMap.put("bulkLoanDealSeconds", productDetail.getPpBulkloandealseconds());
			//协议
			retMap.put("url",pash);
			retMap.put("agreement", "债转协议(范本)");
			retMap.put("loanAmount",productDetail.getPpLoanamount() );//项目总金额
			retMap.put("startTime",productDetail.getPpBulkloanstarttime() );//投标开始时间
			retMap.put("endTime", productDetail.getPpBulkloanendtime());//投标结束时间
			retMap.put("NowTime", new Date());//投标结束时间
			retMap.put("terderMinAmount", productDetail.getPpTerderminamount());//最小投标金额
			retMap.put("tenderMaxAmount", productDetail.getPpTendermaxamount());//最大投资金额
			retMap.put("tenderIncreaseAmount",productDetail.getPpTenderincreaseamount());//递增金额
			retMap.put("safeMehtod","本金+利息" );//保障方式
			retMap.put("loanDesc", loanApply.getPpLoandesc());//项目描述
			retMap.put("ppLoanrepayment", productDetail.getPpLoanrepayment());//项目描述
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			retMap.put("productNo", productNo);
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
		}
		request.setAttribute("result", retMap);
		return "/wap/wapProductDetails";
	}
	
	
	/**
	 * 显示一期的产品详情
	 * @param productNo
	 * @param custNo
	 * @return
	 */
	/*#RequestMapping("/wapProductDetail")*/
	public String wapProductDetail(HttpServletRequest request, 
			@RequestParam("productNo") String productNo){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		P2p_user currentUser = SessionUtils.getCurrentUser(request);
		retMap.put("currentUser", currentUser);
		try {
			P2p_cust_account account = null;
			if(currentUser!=null){
				String custNo = currentUser.getPuCustNo();
				account = accountService.getCustAccountByCustNo(custNo,true);
				// 可用余额
				if(account!=null){
					retMap.put("balance", account.getPcaAccountBalance());
					//是否设置交易密码
					if(!StringUtil.isEmpty(account.getPcaPayPassword())){
						retMap.put("transactionPassword", 0);//已设置交易密码
					}else{
						retMap.put("transactionPassword", 1);//未设置交易密码
					}
				}else{
					retMap.put("balance", "0.00");
				};
			}else{
				retMap.put("balance", "0.00");
			}
			//查询标的信息
			Map<String, Object> productMap = loanProductAidService.getProductNo(productNo);
			List<P2p_repayment_bill> billList =repaymentBillService.getByBulkLoanNumber(productNo);
			paramMap.put("productNo", productNo);
			List<P2p_loan_product_picture>productPicture =loanProductAidService.selectByproductNo(paramMap);
			int surplusTerm=0;
			for(P2p_repayment_bill bill:billList){
				if(bill.getPrbRepaymentstatus()==0){
					surplusTerm++;
				}
			}
			retMap.put("productPicture", productPicture);//图片
			retMap.put("base",surplusTerm ); //剩余基数
			retMap.put("billList",billList); //还款表现
			retMap.put("loanTitle", productMap.get("loanTitle")+"");//借款申请标题
			retMap.put("loanAmountExist",productMap.get("loanAmount")+"");//标的已投总额
			retMap.put("comprehensiveRate",productMap.get("comprehensiveRate")+"");//借款年利率
			retMap.put("loanTerm", productMap.get("loanTerm")+"");//借款期限
			//借款进度
			retMap.put("jindu",new BigDecimal(1) );//借款进度
			//还款方式
			Integer fangshi = (Integer) productMap.get("loanRepayment");
			if(0==fangshi){
				retMap.put("loanRepayment", "等额本息");
			}else if(1==fangshi){
				retMap.put("loanRepayment", "每月付息，到期还本");
			}else if(2==fangshi){
				retMap.put("loanRepayment", "按天计息");
			}
			retMap.put("url",pash);
			retMap.put("agreement", "债转协议(范本)");
			retMap.put("loanAmount",productMap.get("loanAmount")+"");//项目总金额
			retMap.put("NowTime", new Date());//投标结束时间
			retMap.put("safeMehtod","本金+利息" );//保障方式
			retMap.put("loanDesc", productMap.get("loanDesc"));//项目描述
			retMap.put(Const.retCode, true);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
			retMap.put("productNo", productNo);
			retMap.put("bulkLoanStatus", "5");
			retMap.put("ppLoanrepayment", productMap.get("loanRepayment"));
			
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u67e5\u8be2\u5931\u8d25");//查询失败
		}
		request.setAttribute("result", retMap);
		return "/wap/wapProductDetail";
	}
	
	/**
	 * 查询投标记录
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	/*#RequestMapping("/wapTenderRecord")*/
	public String TenderRecord(HttpServletRequest request,
			@RequestParam("productNo") String productNo,
			@RequestParam(value="pageNum",required=false)Integer pageNum,
			@RequestParam(value="pageSize",required=false)Integer pageSize){
		Map<String, Object> retMap = new HashMap<String, Object>();
		pageNum =pageNum ==null ? 1: pageNum ;
		 pageSize = pageSize == null ? 10:pageSize;
		Paging<P2p_tender_record> page =loanProductAidService.queryTenderRecordByPorductNo(productNo, pageNum, pageSize);
		List<P2p_tender_record> list = page.getPageList();
		retMap.put("pageNum", pageNum);
		retMap.put("endNum",page.getPageTotal() );
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		request.setAttribute("result", retMap);
		return "/wap/wapTenderRecord";
	}
	
	
	/**
	 * 查询投标记录(一期项目)
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	/*#RequestMapping("/wapTenderRecords")*/
	public String ajaxPageTenderRecord(HttpServletRequest request,
			@RequestParam("productNo") String productNo,
			@RequestParam(value="pageNum",required=false)Integer pageNum,
			@RequestParam(value="pageSize",required=false)Integer pageSize){
		Map<String, Object> retMap = new HashMap<String, Object>();
		Paging<P2p_tender_record> page = null;
		pageNum = pageNum!=null?pageNum:1;
		pageSize = pageSize!=null?pageSize:10;
		page =loanProductAidService.queryOldTenderRecord(productNo, pageNum, pageSize);
		List<P2p_tender_record> list = page.getPageList();
		page.setPageList(list);
		retMap.put("pageNum", pageNum);
		retMap.put("endNum",page.getPageTotal() );
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		request.setAttribute("result", retMap);
		return "/wap/wapTenderRecords";
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
	/*#RequestMapping(value="/verifyAccountTransPassword",method=RequestMethod.POST)*/
	@ResponseBody
	public  Map<String, Object> verifyAccountTransPassword(HttpServletRequest request,
						String productNo,
						BigDecimal bulkLoanAmount,
						String password,
						String channel){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtil.isEmpty(productNo) || null == bulkLoanAmount || StringUtil.isEmpty(password) || StringUtil.isEmpty(channel)) {
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");//参数不符合规范
			return retMap;
		};
		P2p_user user = SecurityUserHolder.getCurrentUser();
		if(user==null){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u7528\u6237\u672a\u767b\u5f55");//用户未登录
			return retMap;
		}
		
		String custNo = user.getPuCustNo();
		P2p_cust_account account = null;
		try {
			//========================
			account = accountService.getCustAccountByCustNo(custNo,true);
			// 可用余额
			BigDecimal balance = account.getPcaAccountBalance();
			retMap.put("balance", account.getPcaAccountBalance());
			if (balance != null && balance.compareTo(bulkLoanAmount)<0) {
				retMap.put(Const.retCode, false);
				retMap.put("retMsg", "\u4f59\u989d\u4e0d\u8db3");// 余额不足
				return retMap;
			}
			//=========================
			P2p_loan_product_aid  loanProduct=loanProductAidService.queryByProductNo(productNo);
			if (loanProduct.getPpCustno().equals(custNo)) {
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u6295\u6807\u4eba\u4e0d\u5f97\u4e3a\u501f\u6b3e\u4eba");// 投标人不得为借款人
				return retMap;
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
					retMap.put(Const.retMsg, "\u65b0\u624b\u4e13\u4eab\u53ea\u80fd\u6295\u4e00\u6b21");// 新手专享只能投一次
					return retMap;
				}
			}
			BigDecimal incrementAmount =loanProduct.getPpTenderincreaseamount();
			if (bulkLoanAmount != null && bulkLoanAmount.divideAndRemainder(incrementAmount)[1] != BigDecimal.ZERO) {
				retMap.put(Const.retCode, false);
				retMap.put("retMsg", "\u6295\u6807\u91d1\u989d\u5fc5\u987b\u662f" + incrementAmount + "\u7684\u500d\u6570");// 投标金额必须是xx的倍数
				return retMap;
			}
			
			if (loanProduct != null && loanProduct.getPpTendermaxamount().compareTo(bulkLoanAmount) == -1) {
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u4e0d\u5f97\u8d85\u8fc7\u6700\u5927\u6295\u8d44\u989d"+loanProduct.getPpTendermaxamount()+"\u5143");// 不得超过最大投资额
				return retMap;
			}
			
			if (loanProduct != null && loanProduct.getPpTerderminamount().compareTo(bulkLoanAmount) == 1) {
				retMap.put(Const.retCode, false);
				retMap.put(Const.retMsg, "\u4e0d\u5f97\u4f4e\u4e8e\u6700\u5c0f\u6295\u8d44\u989d"+loanProduct.getPpTerderminamount()+"\u5143");// 不得低于最小投资额
				return retMap;
			}
			
			//retMap = tenderService.tender(custNo,productNo, bulkLoanAmount, "",channel,password);
			//增加邀请码
			retMap = tenderService.tender(custNo,productNo, bulkLoanAmount, "",channel,password,"");
			
		} catch (Exception e) {
			e.printStackTrace();
			retMap.put(Const.retCode,false);
			retMap.put(Const.retMsg, "系统异常，请稍后再试");
		}
		baseLog.writer(user.getPuCustNo(),"",retMap.toString(),BusinessType.TENDER.getDesc(), RegistType.WAP.getName(), "/verifyAccountTransPassword");
 		return retMap;
	}
	
	/**
	 * 查询个人的投标记录(投标中)
	 * @param custNo
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	/*#RequestMapping("/tenderRecordByCustNo")*/
	public String tenderRecordByCustNo(HttpServletRequest request,
			Integer pageNum,
			Integer pageSize,
			Model model,
			String bulkLoanStatus){
		List<Map<String, Object>> summary_list = new ArrayList<Map<String, Object>>();
		P2p_user user = SecurityUserHolder.getCurrentUser();
		Map<String, Object> retMap = new HashMap<String, Object>();
		pageNum =pageNum ==null ? 1: pageNum ;
	    pageSize = pageSize == null ? 10:pageSize;
	    //产品状态  0待开放，1 开放投标， 2已满标， 3流标，4还款中，5已结束
	    bulkLoanStatus = (StringUtil.isEmpty(bulkLoanStatus))?"1":bulkLoanStatus;
	    //10020160106094348qro7k2
		Paging<Map<String, Object>> page = loanProductAidService.tenderRecordByCustNo(user.getPuCustNo(),bulkLoanStatus,pageNum,pageSize);
		List<Map<String, Object>> list = page.getPageList();
		BigDecimal tenderProfit = new BigDecimal(0);//收益本息
		if("1".equals(bulkLoanStatus)){
			//投标中的
			list = page.getPageList();
			retMap.put("list", list);
		}else if("4".equals(bulkLoanStatus)){
			//还款中的
			Map<String, Object> map = null;
			if(list!=null && list.size()>0){
				for(Map<String, Object> listparm :list ){
					map = new HashMap<String, Object>();
					map.put("pp_loanTitle", listparm.get("pp_loanTitle"));//标题
					map.put("ptr_productNo",listparm.get("ptr_productNo"));//产品编号
					map.put("ptr_tenderFlowNo", listparm.get("ptr_tenderFlowNo"));//投标流水
					map.put("ptr_amount", listparm.get("ptr_amount"));//投资金额
					//查询收益详情
					try {
						tenderProfit = tenderProfitService.tenderProfitByTenderFlowNo((String)listparm.get("ptr_tenderFlowNo"));
						tenderProfit = tenderProfit==null?new BigDecimal(0):tenderProfit;
					} catch (BusinessException e) {
						e.printStackTrace();
					}
					map.put("capital_Interest", tenderProfit);
					summary_list.add(map);
				}
				
			}
			retMap.put("list", summary_list);
		}else if("5".equals(bulkLoanStatus)){
			//已完成的
			Map<String, Object> map = null;
			if(list!=null && list.size()>0){
				for(Map<String, Object> listparm :list ){
					map = new HashMap<String, Object>();
					map.put("pp_loanTitle", listparm.get("pp_loanTitle"));//标题
					map.put("ptr_productNo",listparm.get("ptr_productNo"));//产品编号
					map.put("ptr_tenderFlowNo", listparm.get("ptr_tenderFlowNo"));//投标流水
					map.put("ptr_amount", listparm.get("ptr_amount"));//投资金额
					//查询收益详情
					try {
						tenderProfit = tenderProfitService.tenderFactProfitByTenderFlowNo((String)listparm.get("ptr_tenderFlowNo"));
						tenderProfit = tenderProfit==null?new BigDecimal(0):tenderProfit;
					} catch (BusinessException e) {
						e.printStackTrace();
					}
					map.put("capital_Interest", tenderProfit);
					summary_list.add(map);
				}
				
			}
			retMap.put("list", summary_list);
		}
		retMap.put("endNum",page.getPageTotal() );
		retMap.put("pageNum", pageNum);
		retMap.put("bulkLoanStatus", bulkLoanStatus);
		model.addAttribute("result", retMap);
		return "/wap/wapBulkLoaningCreditor";
	}
	
	
	/**
	 * 得到某个借款的还款详情
	 * @param custNo
	 * @param tenderFlowNo
	 * @return
	 */
	/*#RequestMapping(value="/wapGetRepayments",method=RequestMethod.POST)*/
	public String getRepayments(HttpServletRequest request,
			String tenderFlowNo,
			String pp_loanTitle,
			String bulkLoanStatus){
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap = loanProductAidService.findByTenderFlowNo(tenderFlowNo);
		retMap.put("ptr_amount", retMap.get("ptr_amount"));
		
		List<Map<String, Object>> list = tenderProfitService.paymentPlanByTenderFlowNo(tenderFlowNo);
		retMap.put("list", list);
		retMap.put("tenderFlowNo", tenderFlowNo);
		retMap.put("pp_loanTitle", pp_loanTitle);
		//查询收益详情
		BigDecimal tenderProfit =  new BigDecimal(0);
		try {
			tenderProfit = tenderProfitService.tenderProfitByTenderFlowNo(tenderFlowNo);
			tenderProfit = tenderProfit==null?new BigDecimal(0):tenderProfit;
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		retMap.put("capital_Interest", tenderProfit);
		retMap.put("bulkLoanStatus", bulkLoanStatus);
		retMap.put("count", (list!=null && list.size()>0)?list.size():0);
		request.setAttribute("result", retMap);
		return "/wap/wapRepayments";
		
	}
}
