package com.baibao.web.p2p.controller.wap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.common.util.PropertiesUtil;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.RepaymentBillStatus;
import com.baibao.web.p2p.generator.bean.P2p_index_picture;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.service.AboutUsService;
import com.baibao.web.p2p.service.IndexPictureService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.web.p2p.service.TenderProfitService;
import com.baibao.web.p2p.service.UserService;

//@Controller
@RequestMapping("/wapIndex")
public class WapIndexController {
	
	private static Logger log = LoggerFactory.getLogger(WapIndexController.class);
	
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
	
	/**
	 * wap首页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/toWapIndex")*/
	public ModelAndView toWapIndex(HttpServletRequest request,Model model){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		ModelAndView mav = new ModelAndView("/wap/wapIndex");
		try {
			//轮番图
			List<P2p_index_picture> pictureList =indexPictureService.findIndexPicture(Const.h5);
			for (P2p_index_picture p2p_index_picture : pictureList) {
				p2p_index_picture.setInterimPathUrl(PropertiesUtil.getSysConfigParams("FASTDFS_SERVER") + p2p_index_picture.getPathUrl());
			}
			model.addAttribute("indexPicture", pictureList);
			//总收益
			String profitType=RepaymentBillStatus.NORMALREPAYMENT.getIndex();
			BigDecimal tenderProfit =  tenderProfitService.tenderProfit(profitType);
			model.addAttribute("tenderProfit", tenderProfit);
			//活动标
			paramMap = loanProductAidService.queryPorductAidActiveApp();
			if(paramMap!=null && paramMap.size()>0){
				model.addAttribute("productList", paramMap);
			}else{//非活动标但是是可投标
				paramMap = loanProductAidService.queryPorductAidApp();
				model.addAttribute("productList", paramMap);
			}
			//新人专享标的
			P2p_loan_product_aid noviceExclusive =loanProductAidService.queryNoviceExclusive();
			model.addAttribute("noviceExclusive", noviceExclusive);
			
			//注册的总人数
			String userCount ="";
			if(jedisUtil.getValue(Const.PLATFORM_REGISTER_USER, 0+"")==""||jedisUtil.getValue(Const.PLATFORM_REGISTER_USER, 0+"")==null){
				Long longUserCount =userService.findUserCount();
				if(longUserCount !=null){
					userCount = longUserCount.toString();
				}
				jedisUtil.setValue(Const.PLATFORM_REGISTER_USER, userCount, 60*15);//15分钟缓存
			}
			model.addAttribute("userCount",  jedisUtil.getValue(Const.PLATFORM_REGISTER_USER, 0+""));
			
		} catch (Exception e) {
			log.error("", e);
		}
		return mav;
	}
	
	/**
	 * APP下载页
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/download")*/
	public String download(HttpServletRequest request){
		return "/wap/downloadIndex";
	};
}
