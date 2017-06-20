package com.baibao.web.p2p.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.utils.JsonHelper;
import com.baibao.utils.MapBuilder;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.generator.bean.P2p_article;
import com.baibao.web.p2p.generator.bean.P2p_bill_plan;
import com.baibao.web.p2p.generator.bean.P2p_creditor_pack;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_picture;
import com.baibao.web.p2p.generator.bean.P2p_repayment_bill;
import com.baibao.web.p2p.generator.bean.P2p_tender_profit;
import com.baibao.web.p2p.generator.bean.P2p_tender_record;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.AboutUsService;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.CreditorPackService;
import com.baibao.web.p2p.service.LoanApplyService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.RepaymentBillService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.UserInfoService;

/**
 * 产品列表和产品详情
 * @author admins
 *
 */
@Controller
@RequestMapping("/productList")
public class ProductListController
{
	private static Logger log =
		LoggerFactory.getLogger(ProductListController.class);

	@Autowired
	private LoanProductAidService  loanProductAidService;
	@Autowired
	private LoanApplyService  loanApplyService;
	@Autowired
	private RepaymentBillService  repaymentBillService;
	@Autowired
	private AccountService  accountService;
	@Autowired
	private AboutUsService aboutUsService;
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private CreditorPackService creditorPackService;
	@Autowired
	private TenderProfitService tenderProfitService;
	
	/**
	 * 查询标的列表
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @return
	 */
	@RequestMapping("/showProductList")
	public String showProductList(
		String productType, String bulkStatus,
		Integer loanTerm, Model model)
	{	
		log.info(String.format("showProductList parameter : "
				+ "productType = %s, bulkStatus = %s, loanTerm = %s", 
				productType, bulkStatus, loanTerm));
		
		String ppInvestmentType = "";
		String ppActivityType = "";

		if ("2".equals(productType))
		{
			ppActivityType = "1";
		} else
		{
			ppInvestmentType = productType;
		}
		//productType = productTypeNew
		//productType控制页面的选择条件，原来用于区分产品类型，在1.4.1后统一改为0不做任何区分
		String productTypeNew = "0";
		Paging<P2p_loan_product_aid>  page =
			loanProductAidService.findLoanProductAidListPage(
					productTypeNew, bulkStatus, loanTerm, 1, 8,
				ppActivityType, ppInvestmentType);

		//活动标的查询
		//loanProductAidService.findActiveProductAidList();
		List<P2p_loan_product_aid> activeList =
			new ArrayList<P2p_loan_product_aid>();
		P2p_loan_product_aid noviceExclusive =
			loanProductAidService.queryNoviceExclusive();
		
		if (noviceExclusive != null)
		{
			activeList.add(noviceExclusive);
		}
		
		List<P2p_loan_product_aid> list = page.getPageList();
		
		Paging<P2p_article>  articlePage =
			aboutUsService.queryNoticeList(Const.media, 1, 8);

		model.addAttribute("paging", page);
		model.addAttribute("activeList", activeList);
		model.addAttribute(
			"total", (list.size() > 0)? list.size(): 0);
		model.addAttribute(
			"ajaxPageUrl", "productList/ajaxShowProductList");
		model.addAttribute("productType", productType);
		model.addAttribute("articlePage", articlePage);

		log.info(String.format("showProductList parameter : "
				+ "productType = %s, bulkStatus = %s, loanTerm = %s --- return : mav = %s", 
				productType, bulkStatus, loanTerm, JsonHelper.formatJson(model)));

		return "productList";
	}
	
	/**
	 * 查询标的列表 分页
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ajaxShowProductList")
	public String ajaxShowProductList(
		String productType, String bulkStatus,
		Integer loanTerm, Integer currentPageNo, Model model)
	{
		
		log.info(String.format("ajaxShowProductList parameter : "
			+ "productType = %s, bulkStatus = %s, loanTerm = %s, currentPageNo = %s", 
			productType, bulkStatus, loanTerm, currentPageNo));
		
		String ppInvestmentType = "";
		String ppActivityType = "";
		if ("2".equals(productType))
		{			
			ppActivityType = "1";
		} else
		{
			ppInvestmentType = productType;
		}

		Paging<P2p_loan_product_aid>  page =
			loanProductAidService.findLoanProductAidListPage(
				productType, bulkStatus, loanTerm,
				currentPageNo, 8,
				ppActivityType, ppInvestmentType);

		List<P2p_loan_product_aid> list = page.getPageList();
		
		model.addAttribute("paging", page);
		model.addAttribute(
			"total", (CollectionUtils.isEmpty(list))? list.size(): 0);
		model.addAttribute(
			"ajaxPageUrl","productList/ajaxShowProductList");
		
		log.info(String.format("ajaxShowProductList parameter : "
			+ "productType = %s, bulkStatus = %s, loanTerm = %s, currentPageNo = %s --- "
			+ "return : mav = %s", 
			productType, bulkStatus, loanTerm, currentPageNo, JsonHelper.formatJson(model)));

		return "_productListPage";
	}

	/**
	 * 查询新手标的列表
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @return
	 */
	@RequestMapping("/showProductListByType")
	public String showProductListByType(
		String productType, String bulkStatus,
		Integer loanTerm, Model model)
	{	
		log.info(String.format("showProductListByType parameter : "
			+ "productType = %s, bulkStatus = %s, loanTerm = %s",
			productType, bulkStatus, loanTerm));

		Paging<P2p_loan_product_aid> page =
			loanProductAidService.findLoanProductAidListPage(
				productType, bulkStatus,
				loanTerm, 1, 8, null, null);

		List<P2p_loan_product_aid> activeList =
			loanProductAidService.findActiveProductAidList();
		List<P2p_loan_product_aid> list = page.getPageList();

		model.addAttribute("paging", page);
		model.addAttribute("activeList", activeList);
		model.addAttribute("total",
			CollectionUtils.isEmpty(list)? list.size(): 0);
		model.addAttribute(
			"ajaxPageUrl","productList/ajaxShowProductList");
		model.addAttribute("productType",productType);
		
		log.info(String.format("showProductListByType parameter : "
			+ "productType = %s, bulkStatus = %s, loanTerm = %s --- return mav = %s",
			productType, bulkStatus, loanTerm, JsonHelper.formatJson(model)));

		return "productList";
	}

	/**
	 * 显示产品详情
	 * @param productNo
	 * @return
	 */
	@RequestMapping("/productDetails")
	public String productDetails(String productNo, Model model)
	{
		log.info(String.format("productDetails parameter : "
			+ "productNo = %s", productNo));

		String view = null;

		try
		{
			P2p_loan_product_aid  productDetail =
				loanProductAidService.queryByProductNo(productNo);

			if (productDetail.getPp_inviteCode() != null)
			{
			    productDetail.setPp_inviteCode(Const.PROJECT_NO);
			}
			
			
			if (productDetail.getPpInvestmentType() == Const.ASSETSPACK)
			{
				view = "AssetPackaging";
				//interestTime 计息时间
				//productEndTime 项目到期时间
				//arrivalTime 本息到账时间
				if (productDetail.getPpBulkloaneffecttime() == null)
				{//没有实际满标时间 手动计算项目到期时间
					model.addAttribute("interestTime", 
							productDetail.getPpBulkloanendtime());
					Timestamp date = Utils.offsetTimestamp(Utils.now(), 
							productDetail.getPpLoanterm(), Calendar.MONTH);
					model.addAttribute("productEndTime", 
							date);
					model.addAttribute("arrivalTime", 
							date);
				} else { //有实际满标时间 从投资记录表中取最后一期时间
					model.addAttribute("interestTime", 
							productDetail.getPpBulkloaneffecttime());
					List<P2p_bill_plan> listBillPlan =
							tenderProfitService.findBillPlanByProduct(
								new MapBuilder<String, Object>()
									.append("productNo", productNo)
									.toMap());
					if (listBillPlan != null && listBillPlan.size() > 0)
					{
						P2p_bill_plan billPlan = 
								listBillPlan.get(listBillPlan.size()-1);
						model.addAttribute("productEndTime", 
								billPlan.getPbpDatetime());
						model.addAttribute("arrivalTime", 
								billPlan.getPbpDatetime());
					}
				}
			} else
			{
				view = "productDetails";
			}
			
			P2p_loan_apply  loanApply =
				loanApplyService.searchByPorductNo(productNo);
			
			Paging<P2p_tender_record> page = null;
			List<P2p_tender_record> list = null;
			
			//判断是否是一期数据
			page =
				loanProductAidService.queryTenderRecordByPorductNo(
					productNo, 1, 8);
			list = page.getPageList();

			Map<String, Object> paramMap =
				new HashMap<String, Object>();

			paramMap.put("productNo", productNo);
			
			List<P2p_loan_product_picture> pictureList =
				loanProductAidService.selectByproductNo(paramMap);

			//账单剩余期数
			int surplusTerm = 0;
			List<P2p_tender_profit> tenderProfitList =
				new ArrayList<P2p_tender_profit>();

			P2p_user user = Utils.getCurrentUser();
			
			model.addAttribute("islogin", user != null);
			
			if (user != null)
			{			
				//判断是否是一期数据
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("productNo", productNo);
				map.put("custNo", user.getPuCustNo());

				tenderProfitList =
					tenderProfitService.getTenderProfitByProductNo(map);
				
				if (CollectionUtils.isNotEmpty(tenderProfitList))
				{
					Set<Integer> seqSeq = new HashSet<Integer>();

					for(P2p_tender_profit tenderProfit: tenderProfitList)
					{
						if (!tenderProfit.getPtpProfitstatus()
							.equals(RepaymentBillStatus.NORMALREPAYMENT.getIndex()))
						{
							seqSeq.add(tenderProfit.getPtpLoanseq());
						}
					}
					
					surplusTerm = seqSeq.size();
				} else
				{
					surplusTerm =
						tenderProfitService.getBillPlanCountByProductNo(productNo);
					
					List<P2p_bill_plan> listBillPlan =
						tenderProfitService.findBillPlanByProduct(
							new MapBuilder<String, Object>()
								.append("productNo", productNo)
								.toMap());

					model.addAttribute("listBillPlan", listBillPlan);
					model.addAttribute("notCurrentUser","1");
				}

				P2p_cust_account custAccount =
					accountService.getCustAccountByCustNo(
						user.getPuCustNo(), false);
				if (custAccount != null)
				{
					model.addAttribute(
						"custBlance", custAccount.getPcaAccountBalance());

					//已设置交易密码
					model.addAttribute("isSetPcaPayPassword",
						StringUtils.isNotEmpty(
							custAccount.getPcaPayPassword())? 1: 0);
				}
			} else {
				surplusTerm =
						tenderProfitService.getBillPlanCountByProductNo(productNo);
			}

			Paging<P2p_creditor_pack> pageCreditorPack = null;
			
			pageCreditorPack =
				creditorPackService.getUserByProductNo(productNo, 1, 8);
			List<P2p_creditor_pack> listCreditorPack =
				pageCreditorPack.getPageList();
			//姓名和身份证号替换
			if (productDetail.getPpInvestmentType() != Const.ASSETSPACK)
			{
				if (CollectionUtils.isNotEmpty(listCreditorPack))
				{
					P2p_creditor_pack userInfo = listCreditorPack.get(0);
					
					userInfo.setPcpRealName(userInfo.fetchMaskRealName());
					userInfo.setPcpCertNo(userInfo.fetchMaskPcpCertNo());
					
					model.addAttribute("userInfo", userInfo);
				}
			} else
			{
				for(P2p_creditor_pack p2p_creditor_pack: listCreditorPack)
				{
					p2p_creditor_pack.setPcpRealName(
						p2p_creditor_pack.fetchMaskRealName());
					p2p_creditor_pack.setPcpCertNo(
						p2p_creditor_pack.fetchMaskPcpCertNo());
				}
			}

			pageCreditorPack.setPageList(listCreditorPack);
			
			model.addAttribute("pageCreditorPack", pageCreditorPack);
			model.addAttribute("total",
				CollectionUtils.isEmpty(list)? list.size(): 0);
			model.addAttribute("pictureList",pictureList);
			model.addAttribute("paging", page);
			model.addAttribute("productDetail", productDetail);
			model.addAttribute("loanApply", loanApply);
			model.addAttribute("NowTime", new Date());
			model.addAttribute(
				"ajaxPageUrl", "productList/ajaxPageTenderRecords");
			model.addAttribute("creditorPackAjaxPageUrl",
				"productList/ajaxPageCreditorPacks");
			model.addAttribute("billList",tenderProfitList);
			model.addAttribute("surplusTerm",surplusTerm);
		} catch(Exception e)
		{	
			log.error("error", e);
		}

		log.info(String.format("productDetails parameter : "
			+ "productNo = %s --- return : mav = %s",
			productNo, JsonHelper.formatJson(model)));

		return view;
	}
	
	/**
	 * 分页查询标的详情记录
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ajaxPageCreditorPacks")
	public String ajaxPageCreditorPacks(
		String productNo, Integer currentPageNo, Model model)
	{	
		log.info(String.format("ajaxPageCreditorPacks parameter : "
				+ "productNo = %s, currentPageNo = %s",
				productNo, currentPageNo));

		Paging<P2p_creditor_pack> page = null;
		
		P2p_user user = Utils.getCurrentUser();
		
		P2p_loan_product_aid  productDetail =
			loanProductAidService.queryByProductNo(productNo);
		page = creditorPackService.getUserByProductNo(
			productNo, currentPageNo, 8);

		List<P2p_creditor_pack> list = page.getPageList();

		/**
		 * 替换姓名和身份证号
		 */
		for (P2p_creditor_pack p2p_creditor_pack: list)
		{
			p2p_creditor_pack.setPcpRealName(
				p2p_creditor_pack.fetchMaskRealName());
			p2p_creditor_pack.setPcpCertNo(
				p2p_creditor_pack.fetchMaskPcpCertNo());
		}
		
		page.setPageList(list);
		
		model.addAttribute("pageCreditorPack", page);
		model.addAttribute(
			"creditorPackAjaxPageUrl","productList/ajaxPageCreditorPacks");
		model.addAttribute("total",
			CollectionUtils.isEmpty(list)? list.size(): 0);
		model.addAttribute("productDetail", productDetail);
		
		log.info(String.format("ajaxPageCreditorPacks parameter : "
			+ "productNo = %s, currentPageNo = %s --- return : mav = %s",
			productNo, currentPageNo, JsonHelper.formatJson(model)));

		return "productCreditorPack";
	}
	
	/**
	 * 分页查询投标记录
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ajaxPageTenderRecords")
	public String ajaxPageTenderRecords(
		String productNo, Integer currentPageNo, Model model)
	{	
		log.info(String.format("ajaxPageTenderRecords parameter : "
			+ "productNo = %s, currentPageNo = %s",
			productNo, currentPageNo));

		Paging<P2p_tender_record> page = null;
		P2p_loan_product_aid  productDetail =
			loanProductAidService.queryByProductNo(productNo);
		page =
			loanProductAidService.queryTenderRecordByPorductNo(
				productNo, currentPageNo, 8);
		
		List<P2p_tender_record> list = page.getPageList();
		
		page.setPageList(list);
		
		model.addAttribute("paging", page);
		model.addAttribute(
			"ajaxPageUrl", "productList/ajaxPageTenderRecords");
		model.addAttribute("total",
			CollectionUtils.isEmpty(list)? list.size(): 0);
		model.addAttribute("productDetail", productDetail);

		log.info(String.format("ajaxPageTenderRecords parameter : "
			+ "productNo = %s, currentPageNo = %s --- return : mav = %s",
			productNo, currentPageNo, JsonHelper.formatJson(model)));

		return "productTenderRecords";
	}
	
	/**
	 * 显示产品详情(一期项目)
	 * @param productNo
	 * @return
	 */
	@RequestMapping("/productDetail")
	public String productDetail(
		String productNo, Model model)
	{	
		log.info(String.format(
			"productDetail parameter : productNo = %s",
			productNo));

		try
		{
			Paging<P2p_tender_record> page = null;
			List<P2p_tender_record> list = null;
			
			//查询标的信息
			Map<String, Object> productMap =
				loanProductAidService.getProductNo(productNo);
			
			//查询投标记录
			page = loanProductAidService.queryOldTenderRecord(
				productNo, 1, 8);
			
			//查询还款记录
			List<P2p_repayment_bill> billList =
				repaymentBillService.getOldByBulkLoanNumber(productNo);

			list = page.getPageList();

			model.addAttribute("total",
				CollectionUtils.isEmpty(list)? list.size(): 0);
			model.addAttribute("productMap",productMap);
			model.addAttribute("paging", page);
			model.addAttribute("billList",billList);
			model.addAttribute(
				"ajaxPageUrl","productList/ajaxPageTenderRecord");
		} catch(Exception e)
		{
			log.error("productDetail", e);
		}
		
		log.info(String.format("productDetail parameter : "
				+ "productNo = %s --- return : mav = %s",
				productNo, JsonHelper.formatJson(model)));

		return "productDetail";
	}

	/**
	 * 分页查询投标记录(一期项目)
	 * @param productNo
	 * @param currentPageNo
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping("/ajaxPageTenderRecord")
	public String ajaxPageTenderRecord(
		String productNo, Integer currentPageNo, Model model)
	{	
		log.info(String.format("ajaxPageTenderRecord parameter : "
				+ "productNo = %s, currentPageNo = %s",
				productNo, currentPageNo));

		Paging<P2p_tender_record> page = null;
		//查询标的信息
		Map<String, Object> productMap = null;

		try
		{
			productMap = loanProductAidService.getProductNo(productNo);
			page = loanProductAidService.queryOldTenderRecord(
				productNo, currentPageNo, 8);
			
			List<P2p_tender_record> list = page.getPageList();
			
			page.setPageList(list);

			model.addAttribute("paging", page);
			model.addAttribute(
				"ajaxPageUrl", "productList/ajaxPageTenderRecord");
			model.addAttribute(
				"total", CollectionUtils.isEmpty(list)? list.size(): 0);
			model.addAttribute("productMap", productMap);
		} catch(Exception e)
		{	
			log.error("ajaxPageTenderRecord", e);
		}
		
		log.info(String.format("ajaxPageTenderRecord parameter : "
			+ "productNo = %s, currentPageNo = %s --- return : mav = %s",
			productNo, currentPageNo, JsonHelper.formatJson(model)));

		return "productTenderRecord";
	}
	
	
	/**
	 * 理财计算器
	 * @return
	 */
	@RequestMapping("/toCalculator")
	public String toCalculator(Model model)
	{
		log.info("toCalculator parameter : ");
		
		log.info(String.format(
			"toCalculator parameter : --- return : mav = %s",
			JsonHelper.formatJson(model)));
		return "calculator/calculator";
	}
	
	/**
	 * 理财计算器计算收益
	 * @param cjje 出借金额
	 * @param nhll 年化收益
	 * @param jkqx 借款期限
	 * @param hkfs 还款方式
	 * @return
	 */
	@RequestMapping("/getProfit")
	public String getProfit(
		Integer cjje, Double nhll, Integer jkqx, Integer hkfs,
		Model model)
	{	
		log.info(String.format("getProfit parameter : cjje = %s, nhll = %s, jkqx = %s, hkfs = %s", 
				cjje, nhll, jkqx, hkfs));

		BigDecimal amount = new BigDecimal(cjje);
		BigDecimal yearRate =
			new BigDecimal(nhll).divide(new BigDecimal(100));
		
		model.addAttribute("cjje", amount.setScale(2));
		
		List<Map<String, Object>> list =
			new ArrayList<Map<String, Object>>();
		if (hkfs == 0)
		{//先息后本
			list = loanProductAidService.getProfitByAfterPrincipal(
				amount, yearRate, jkqx);
		} else
		if (hkfs == 1)
		{//等额本息
			list = loanProductAidService.getProfitByEqual(
				amount, yearRate, jkqx);
		} else
		if (hkfs == 2)
		{
			list = loanProductAidService.getInteresByDayPlan(
				amount, yearRate, jkqx);
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

			BigDecimal b =
				new BigDecimal(m.get("interest").toString());

			lx = lx.add(b);
		}

		model.addAttribute(// 应收利息
			"yslx", lx.setScale(2, BigDecimal.ROUND_HALF_UP));
		model.addAttribute("jkqx", jkqx);
		model.addAttribute("hkfs", hkfs);
		model.addAttribute("result", list);
		
		log.info(String.format("getProfit parameter : cjje = %s, nhll = %s, jkqx = %s, hkfs = %s --- return : mav = %s", 
			cjje, nhll, jkqx, hkfs, JsonHelper.formatJson(model)));

		return "calculator/_calculresult";
	}
	
	/**
	 * 标的详情--债转
	 * @param request
	 * @return
	 */
	@RequestMapping("/creditTransDetail")
	public String creditTransDetail(
		String productNo, Model model)
	{
		log.info(String.format("creditTransDetail parameter : "
				+ "productNo = %s",
				productNo));

		String view = null;

		try
		{
			P2p_loan_product_aid productDetail =
				loanProductAidService.queryByProductNo(productNo);
			if(productDetail.getPp_inviteCode() != null)
			{
			    productDetail.setPp_inviteCode(Const.PROJECT_NO);
			}
			if (productDetail.getPpInvestmentType() == Const.IFTHESTANDARD)
			{
				view = "creditTransDetail";
			} else
				view = "unkown";
			
			P2p_loan_apply  loanApply =
				loanApplyService.searchByPorductNo(productNo);
			
			Paging<P2p_tender_record> page = null;
			List<P2p_tender_record> list = null;
			
			//判断是否是一期数据
			page =
				loanProductAidService.queryTenderRecordByPorductNo(
					productNo, 1, 8);
			list = page.getPageList();

			//标的图片
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("productNo", productDetail.getPlpAssignProductNo());
			List<P2p_loan_product_picture> pictureList =
				loanProductAidService.selectByproductNo(paramMap);

			//账单剩余期数
			int surplusTerm = 0;
			List<P2p_tender_profit> tenderProfitList = new ArrayList<P2p_tender_profit>();
			P2p_user user = Utils.getCurrentUser();

			model.addAttribute("islogin", user != null);
			
			if (user != null)
			{			
				if (productDetail.getPpBulkloanstatus() == 1 ||
					productDetail.getPpBulkloanstatus() == 2)
				{//投标、已满标查原标的收益
					tenderProfitList =
						tenderProfitService.getTenderProfitByProductNo(
							new MapBuilder<String, Object>()
								.append("tenderFlowNo", productDetail.getPlpAssignTenderNo())
								.append("profitStatus", RepaymentBillStatus.TRANS.getIndex())
								.toMap());
					surplusTerm = tenderProfitList.size();
					
				} else
				{
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("productNo", productDetail.getPpProductno());
					tenderProfitList =
							tenderProfitService.getTenderProfitByProduct(map);
					
					if (CollectionUtils.isNotEmpty(tenderProfitList))
					{
						Set<Integer> seqSeq = new HashSet<Integer>();

						for(P2p_tender_profit tenderProfit: tenderProfitList)
						{
							if (!tenderProfit.getPtpProfitstatus()
								.equals(RepaymentBillStatus.NORMALREPAYMENT.getIndex()))
							{
								seqSeq.add(tenderProfit.getPtpLoanseq());
							}
						}
						surplusTerm = seqSeq.size();
					}
				}

				P2p_cust_account custAccount =
					accountService.getCustAccountByCustNo(user.getPuCustNo(), false);
				if (custAccount != null)
				{
					model.addAttribute(
						"custBlance", custAccount.getPcaAccountBalance());

					//已设置交易密码
					model.addAttribute("isSetPcaPayPassword",
						StringUtils.isNotEmpty(
							custAccount.getPcaPayPassword())? 1: 0);
				}
			} 

			Paging<P2p_creditor_pack> pageCreditorPack = null;

			pageCreditorPack =
				creditorPackService.getUserByProductNo(
					productDetail.getPlpAssignProductNo(), 1, 8);
			
			List<P2p_creditor_pack> listCreditorPack =
				pageCreditorPack.getPageList();
			//姓名和身份证号替换
			if (productDetail.getPpInvestmentType() != Const.ASSETSPACK)
			{
				if (CollectionUtils.isNotEmpty(listCreditorPack))
				{
					P2p_creditor_pack userInfo = listCreditorPack.get(0);
					
					userInfo.setPcpRealName(userInfo.fetchMaskRealName());
					userInfo.setPcpCertNo(userInfo.fetchMaskPcpCertNo());
					
					model.addAttribute("userInfo", userInfo);
				}
			} else
			{
				for(P2p_creditor_pack p2p_creditor_pack: listCreditorPack)
				{
					p2p_creditor_pack.setPcpRealName(
						p2p_creditor_pack.fetchMaskRealName());
					p2p_creditor_pack.setPcpCertNo(
						p2p_creditor_pack.fetchMaskPcpCertNo());
				}
			}

			pageCreditorPack.setPageList(listCreditorPack);
			
			model.addAttribute("pageCreditorPack", pageCreditorPack);
			model.addAttribute("total",
				CollectionUtils.isEmpty(list)? list.size(): 0);
			model.addAttribute("pictureList",pictureList);
			model.addAttribute("paging", page);
			model.addAttribute("productDetail", productDetail);
			model.addAttribute("loanApply", loanApply);
			model.addAttribute("NowTime", new Date());
			model.addAttribute(
				"ajaxPageUrl", "productList/ajaxPageTenderRecords");
			model.addAttribute("creditorPackAjaxPageUrl",
				"productList/ajaxPageCreditorPacks");
			model.addAttribute("billList",tenderProfitList);
			model.addAttribute("surplusTerm",surplusTerm);
		} catch(Exception e)
		{	
			log.error("error", e);
		}

		log.info(String.format("productDetails parameter : "
			+ "productNo = %s --- return : mav = %s",
			productNo, JsonHelper.formatJson(model)));

		return view;		
	}
	
	
	/**
	 * 查询标的列表-债转
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @return
	 */
	@RequestMapping("/creditTransList")
	public String creditTransList(
		Integer loanTerm, Integer loanRate, Model model)
	{
		log.info(String.format("creditTransList parameter : "
				+ "loanTerm = %s, loanRate = %s", loanTerm, loanRate));

		Paging<P2p_loan_product_aid>  page =
			loanProductAidService.
				findLoanProductAidCreditTransListPage(
					loanTerm, loanRate, 1, 15);

		//活动标的查询
		List<P2p_loan_product_aid> activeList = 
			new ArrayList<P2p_loan_product_aid>();

			P2p_loan_product_aid noviceExclusive =
				loanProductAidService.queryNoviceExclusive();
		
		if (noviceExclusive != null)
		{
			activeList.add(noviceExclusive);
		}
		
		List<P2p_loan_product_aid> list = page.getPageList();
		
		Paging<P2p_article> articlePage = aboutUsService.
				queryNoticeList(Const.media,1,15);
		
		model.addAttribute("paging", page);
		model.addAttribute("activeList", activeList);
		model.addAttribute("total",
			CollectionUtils.isEmpty(list)? list.size(): 0);
		model.addAttribute(
			"ajaxPageUrl",
			"productList/ajaxShowCreditTransProductList");
		model.addAttribute("articlePage", articlePage);
		
		log.info(String.format("creditTransList parameter : "
			+ " loanTerm = %s --- return : mav = %s", 
			loanTerm, JsonHelper.formatJson(model)));

		return "creditTransList";
	}
	
	/**
	 * 查询标的列表-债转 分页
	 * @param productType
	 * @param bulkStatus
	 * @param loanTerm
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ajaxShowCreditTransProductList")
	public String ajaxShowCreditTransProductList(
		Integer loanTerm, Integer loanRate,
		Integer currentPageNo, Model model)
	{
		log.info(String.format("ajaxShowCreditTransProductList parameter : "
			+ " loanTerm = %s, currentPageNo = %s", 
			loanTerm, currentPageNo));

		Paging<P2p_loan_product_aid>  page =loanProductAidService.
				findLoanProductAidCreditTransListPage(loanTerm, loanRate, currentPageNo, 15);
		
		List<P2p_loan_product_aid> list =page.getPageList();
		
		model.addAttribute("paging", page);
		model.addAttribute("total",
			CollectionUtils.isEmpty(list)?list.size(): 0);
		model.addAttribute(
			"ajaxPageUrl", "productList/ajaxShowCreditTransProductList");
		
		log.info(String.format("ajaxShowCreditTransProductList parameter : "
			+ "loanTerm = %s, currentPageNo = %s --- "
			+ "return : mav = %s", 
			loanTerm, currentPageNo,
			JsonHelper.formatJson(model)));

		return "_creditTransListPage";
	} 	
}
