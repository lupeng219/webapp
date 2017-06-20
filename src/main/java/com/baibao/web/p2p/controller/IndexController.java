package com.baibao.web.p2p.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_article;
import com.baibao.web.p2p.generator.bean.P2p_index_picture;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_mobile_app;
import com.baibao.web.p2p.service.AboutUsService;
import com.baibao.web.p2p.service.ActiveService;
import com.baibao.web.p2p.service.IndexPictureService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.MobileAppService;
import com.baibao.web.p2p.service.PiggyBankService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.TenderService;
import com.baibao.web.p2p.service.UserService;

import rop.utils.spring.CollectionUtils;

/**
 * 平台首页
 * 
 * @date 2015年10月19日
 */
@Controller
@RequestMapping("/index")
public class IndexController
{	
	@Autowired
	private MobileAppService mobileAppService;

	private static Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private JedisUtil jedisUtil;
	
	@Autowired
	private LoanProductAidService loanProductAidService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AboutUsService aboutUsService;
	
	@Autowired
	private IndexPictureService  indexPictureService;
	
	@Autowired
	private TenderProfitService tenderProfitService;
	
	@Autowired
	private TenderService  tenderService;
	
	@Autowired
	private ActiveService  activeService;
	
	@Autowired
	private PiggyBankService piggyBankService;
	
	/**
	 * 跳转到首页
	 * 
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(
		HttpServletRequest request, HttpServletResponse response)
	{
		
		log.info("index parameter : ");
		
		String userCount ="";
		String type = request.getParameter("type");
		
		/*if (!"pc".equals(type))
		{
			//手机浏览器请求
			Boolean flag = IsMobile.JudgeIsMoblie(request);
			if (flag)
			{
				return new ModelAndView("redirect:/service/wapIndex/toWapIndex");
			}
		}*/
		
		ModelAndView mav = new ModelAndView("index");
		try
		{
			//轮播图
			List<P2p_index_picture> pictureList =
				JSON.parseArray(
					jedisUtil.getValue(Const.INDEXPICTURE),
					P2p_index_picture.class);

			if (pictureList == null)
			{
				pictureList = indexPictureService.findIndexPicture(Const.pc);

				for(P2p_index_picture p2p_index_picture: pictureList)
				{
					p2p_index_picture.setInterimPathUrl(
						p2p_index_picture.getPathUrl());
				}

				jedisUtil.setValue(
					Const.INDEXPICTURE, JSON.toJSONString(pictureList));
			}
			
			if (CollectionUtils.isEmpty(pictureList))
				pictureList = null;
			
			//新人专享
			P2p_loan_product_aid noviceExclusive =
				loanProductAidService.queryNoviceExclusive();
				
			List<P2p_loan_product_aid> list =
				loanProductAidService.queryNoviceExclusives();
			
			//散标列表
			int ztCount=4;
			List <P2p_loan_product_aid>  productLsit =
				loanProductAidService.queryProductAidBydybz(
					Const.dybzProductTypeNo,ztCount);
			
			if (CollectionUtils.isEmpty(productLsit))
				productLsit = null;
			
			//资产包列列表Const.ASSETSPACK
			int assetsPackCount=3;
			List <P2p_loan_product_aid>  assetsPackLsit =
					loanProductAidService.queryAssetsPackProductAid(assetsPackCount);
			if (CollectionUtils.isEmpty(assetsPackLsit))
				assetsPackLsit = null;
			
			//债转标列表
			int zzCount = 5;
			List <P2p_loan_product_aid>  productListZqzr =
					loanProductAidService.queryProductAidBydybz(
						Const.zqzrProductTypeNo,zzCount);
			if (CollectionUtils.isEmpty(productListZqzr))
				productListZqzr = null;
			
			//佰宝day
			int termDaysCount=1;
			List <P2p_loan_product_aid>  termDaysList =
					loanProductAidService.queryTermDaysProductAid(termDaysCount);
			P2p_loan_product_aid termDaysObj = null;
			if (!CollectionUtils.isEmpty(termDaysList))
				termDaysObj = termDaysList.get(0);
				
			
			//网站公告
			List<P2p_article> articleList =
				JSON.parseArray(
					jedisUtil.getValue(Const.ANNOUNCEMENT), P2p_article.class);
			if (articleList == null)
			{
				articleList = aboutUsService.queryNoticeList(Const.notice);
				jedisUtil.setValue(
					Const.ANNOUNCEMENT, JSON.toJSONString(articleList));
			}

			if (CollectionUtils.isEmpty(articleList))
				articleList = null;
			
			//平台注册总人数
			if (StringUtils.isEmpty(
					jedisUtil.getValue(Const.PLATFORM_REGISTER_USER)))
			{
				Long longUserCount = userService.findUserCount();

				if (longUserCount != null)
				{
					userCount = longUserCount.toString();
				}

				jedisUtil.setValue(
					Const.PLATFORM_REGISTER_USER, userCount, 60*10);//10分钟缓存
			}

			//平台投资总额
			if (StringUtils.isEmpty(
					jedisUtil.getValue(Const.PLATFORM_TENDER_AMOUNT_TOTAL)))
			{
				BigDecimal allTenderAmount =
					tenderService.getAllTenderAmount();
				allTenderAmount =
					(allTenderAmount == null)?
						BigDecimal.valueOf(0):
						allTenderAmount;
						
				jedisUtil.setValue(
					Const.PLATFORM_TENDER_AMOUNT_TOTAL,
					allTenderAmount.toString(), 60*10);
			}
			
			//平台收益总额
			if (StringUtils.isEmpty(
					jedisUtil.getValue(Const.PLATFORM_PROFIT_AMOUNT_TOTAL)))
			{
				BigDecimal frofitTotal = tenderProfitService.getFrofitTotal();
				frofitTotal =
					(frofitTotal == null)? BigDecimal.valueOf(0): frofitTotal;
				
				jedisUtil.setValue(
					Const.PLATFORM_PROFIT_AMOUNT_TOTAL,
					frofitTotal.toString(), 60*10);
			}

			//平台交易总笔数
			if (StringUtils.isEmpty(
					jedisUtil.getValue(Const.PLATFORM_TRADE_COUNT_TOTAL)))
			{
				int tradeCount = tenderService.getAllProductCount();

				jedisUtil.setValue(
					Const.PLATFORM_TRADE_COUNT_TOTAL,
					String.valueOf(tradeCount), 60*10);
			}

			//平台逾期总笔数
			if (StringUtils.isEmpty(
					jedisUtil.getValue(Const.PLATFORM_OVERDUE_COUNT_TOTAL)))
			{
				int overDueCount = tenderService.queryOverDueTotal();
				
				jedisUtil.setValue(
					Const.PLATFORM_OVERDUE_COUNT_TOTAL,
					String.valueOf(overDueCount), 60 * 10);
			}
			//平台投资总人数
			if (StringUtils.isEmpty(
					jedisUtil.getValue(Const.PLATFORM_TENDER_PEOPLE_COUNT_TOTAL)))
			{
				int tenderPeopleCount = tenderService.queryTenderPeopleTotal();

				jedisUtil.setValue(
					Const.PLATFORM_TENDER_PEOPLE_COUNT_TOTAL,
					String.valueOf(tenderPeopleCount), 60 * 10);
			}

			//活动展示
			Integer count=2;//活动列表展示条数
			List<Map<String,Object>> activityList =
				activeService.showActiveList(count);
			
			//七日年化收益率
//			Map<String,Object> yieldrateMap = JSONObject.toJavaObject(JSONObject.parseObject(jedisUtil.getValue(Const.YIELDRATE)), Map.class);
//			if(yieldrateMap==null){
//				try {
//					yieldrateMap =  piggyBankService.getYieldrate();
//					jedisUtil.setValue(Const.YIELDRATE, JSON.toJSONString(yieldrateMap),60*60);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			List yieldRate = JSON.parseArray(yieldrateMap.get("yieldRate").toString());
//			float averageRate=0;
//			for(int i=0; i<yieldRate.size(); i++){
//				averageRate+=Float.parseFloat(yieldRate.get(i).toString());
//			}
//			averageRate=averageRate/7;
//			DecimalFormat fnum=new DecimalFormat("##0.00");
//			String averageRateStr=fnum.format(averageRate); 
			
			mav.addObject("activityList", activityList);//活动展示
			mav.addObject("pictureList", pictureList );//轮播图
			mav.addObject("noviceExclusive", noviceExclusive);
			mav.addObject("noviceExclusives", list);
			mav.addObject("productLsit", productLsit);
			mav.addObject("assetsPackLsit", assetsPackLsit);
			mav.addObject("productListZqzr", productListZqzr);
			mav.addObject("termDaysObj", termDaysObj);
			mav.addObject("userCount", userCount);
			mav.addObject("noticeList", articleList);
			mav.addObject("noticeString", JSON.toJSONString(articleList));
			mav.addObject(
				Const.PLATFORM_REGISTER_USER,
				jedisUtil.getValue(Const.PLATFORM_REGISTER_USER, "0"));
			mav.addObject("allTenderAmount",
				jedisUtil.getValue(Const.PLATFORM_TENDER_AMOUNT_TOTAL, "0"));
			mav.addObject("frofitTotal",
				jedisUtil.getValue(Const.PLATFORM_PROFIT_AMOUNT_TOTAL, "0"));
			mav.addObject("tradeCount",
				jedisUtil.getValue(Const.PLATFORM_TRADE_COUNT_TOTAL, "0"));
			mav.addObject("overDueCount",
				jedisUtil.getValue(Const.PLATFORM_OVERDUE_COUNT_TOTAL, "0"));
			mav.addObject("tenderPeopleCount",
				jedisUtil.getValue(Const.PLATFORM_TENDER_PEOPLE_COUNT_TOTAL, "0"));
			
//			mav.addObject(Const.PLATFORM_REGISTER_USER,  "0");
//			mav.addObject("allTenderAmount", "0");
//			mav.addObject("frofitTotal", "0");
//			mav.addObject("tradeCount", "0");
//			mav.addObject("overDueCount",  "0");
//			mav.addObject("tenderPeopleCount", "0");

			mav.addObject("averageRate", 123.23f);
		}catch(Exception e){
		   log.error("error", e);
		}
		
		log.info(String.format("index parameter : --- return : mav = %s", JsonHelper.formatJson(mav)));
		return mav;
	}
	
	/**
	 * android在线升级
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/downloanApp",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> download(HttpServletRequest request,HttpServletResponse response){
		
		log.info("download parameter : ");
		
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			P2p_mobile_app apps = mobileAppService.findAll();
			if(null!=apps){
				result.put("name", apps.getName());
				result.put("version", apps.getVersion());
				result.put("url", apps.getUrl());
				result.put("remarks", apps.getRemarks());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("success", true);
		result.put("msg", "执行成功");
		
		log.info(String.format("download parameter : --- return : result = %s", 
				JsonHelper.formatJson(result)));
		return result;
	}
	
	
	@RequestMapping("/toIndex")
	@ResponseBody
	public Map<String,Object> toIndex(HttpServletRequest request){
		
		log.info("toIndex parameter : ");
		
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", true);
		result.put("msg", "执行成功");
		
		log.info(String.format("toIndex parameter : --- return : result = %s", 
				JsonHelper.formatJson(result)));
		return result;
	}
	
}
