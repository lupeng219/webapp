package com.baibao.web.p2p.controller.transRecord;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.StatisticalvisitorUtil;
import com.baibao.web.p2p.controller.umpay.UmpayCallbackController;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.transRecord.TransRecordService;

@Controller
@RequestMapping("/transRecord")
public class TransRecordController
{
	private static Logger log = LoggerFactory.getLogger(TransRecordController.class);
	@Autowired
	private TransRecordService transRecordService;
	
	/**
	 * 查询充值、提现、收益、投资、放款、还款、手续费、记录
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping
	public String rechargeWithdraw(Model model,
		Integer transType, String transStatus,
		String startTime, String endTime)
	{
		log.info(String.format("rechargeWithdraw parameter : transType = %s, transStatus = %s, startTime = %s, endTime = %s", 
				transType, transStatus, startTime,endTime));

		if(!StringUtil.isEmpty(startTime)){
			startTime=startTime + " 00:00:00";
		}
		if(!StringUtil.isEmpty(endTime)){
			endTime=endTime + " 23:59:59";
		}
		int currentPageNo = 1;
		int pageSize = 10;
		Map<String, Object> map = new HashMap<String, Object>();
		P2p_user user = SecurityUserHolder.getCurrentUser();
		if(null==user){
			map.put("success", false);
			log.info(String.format("rechargeWithdraw parameter : transType = %s, transStatus = %s, startTime = %s, endTime = %s  --- return : map = %s", 
					transType, transStatus, startTime,endTime,JsonHelper.formatJson(map)));
			return "/transRecord/transRecord";
		}
		String custNo = user.getPuCustNo();
		Paging<P2p_account_flow> page = transRecordService.getByCustNoAndType(custNo,transType,transStatus,startTime,endTime,currentPageNo, pageSize);
		List<P2p_account_flow> list = page.getPageList();
		model.addAttribute("total", (list!=null&&list.size()>0)?list.size():0);
		model.addAttribute("paging", page);
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		model.addAttribute("ajaxPageUrl","transRecord/ajaxPageTransRecord");
		log.info(String.format("rechargeWithdraw parameter : transType = %s, transStatus = %s, startTime = %s, endTime = %s  --- return : model = %s", 
				transType, transStatus, startTime,endTime,JsonHelper.formatJson(model)));
		return "/transRecord/transRecord";
	}
	
	@RequestMapping("/ajaxPageTransRecord")
	public ModelAndView ajaxPageTenderRrcord(HttpServletRequest request,Integer currentPageNo,
			@RequestParam(value="transType",required=false) Integer transType,
			@RequestParam(value="transStatus",required=false) String transStatus,
			@RequestParam(value="startTime", required=false) String startTime,
			@RequestParam(value="endTime",required=false) String endTime){
		log.info(String.format("ajaxPageTenderRrcord parameter : transType = %s, transStatus = %s, startTime = %s, endTime = %s", 
				transType, transStatus, startTime,endTime));
		ModelAndView mav = new ModelAndView("/transRecord/_transRecordPage");
		if(!StringUtil.isEmpty(startTime)){
			startTime=startTime + " 00:00:00";
		}
		if(!StringUtil.isEmpty(endTime)){
			endTime=endTime + " 23:59:59";
		}
		Paging<P2p_account_flow> page = transRecordService.getByCustNoAndType(
				SecurityUserHolder.getCustNo(),transType,transStatus,startTime,endTime,currentPageNo, 10);
		List<P2p_account_flow> list = page.getPageList();
		page.setPageList(list);
		mav.addObject("paging", page);
		mav.addObject("startTime", startTime);
		mav.addObject("endTime", endTime);
		mav.addObject("ajaxPageUrl","transRecord/ajaxPageTransRecord");
		
		log.info(String.format("ajaxPageTenderRrcord parameter : transType = %s, transStatus = %s, startTime = %s, endTime = %s --- return : mav = %s" , 
				transType, transStatus, startTime,endTime,JsonHelper.formatJson(mav)));
		return mav;
	}
}
