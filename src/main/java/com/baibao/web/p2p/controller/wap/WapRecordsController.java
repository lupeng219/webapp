package com.baibao.web.p2p.controller.wap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baibao.core.utils.Paging;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.StatisticalvisitorUtil;
import com.baibao.web.p2p.generator.bean.P2p_account_flow;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.transRecord.TransRecordService;

//@Controller
@RequestMapping("/wapRecords")
public class WapRecordsController {
	
	@Autowired
	private TransRecordService transRecordService;
	/**
	 *充值  提现  收益 记录
	 * @param transType  10 充值 11提现 40 收益
	 * @param startTime
	 * @param endTime
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	/*#RequestMapping(value = "/rechargeWithdraw")*/
	public String rechargeWithdraw(HttpServletRequest request,
			@RequestParam(value="transType",required=false) Integer transType,
			@RequestParam(value="pageNum",required =false)Integer pageNum,
			@RequestParam(value="pageSize",required = false)Integer pageSize,
			Model model){
		
		
		P2p_user user = SecurityUserHolder.getCurrentUser();
		pageNum = pageNum ==null ? 1: pageNum ;
		pageSize = pageSize == null ? 10:pageSize;
		transType = transType == null ? 10:transType;
		
 		Map<String, Object> retMap = new HashMap<String, Object>();
		Paging<P2p_account_flow> page = transRecordService.getByCustNoAndType(user.getPuCustNo(),transType,"","","",pageNum, pageSize);
		List<P2p_account_flow> list = page.getPageList();
		retMap.put("countTotal", (list!=null&&list.size()>0)?list.size():0);
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put("transType", transType);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		retMap.put("pageNum", pageNum);
		model.addAttribute("result", retMap);
		return "/wap/webTransactionRecords";
	}
	
	/**
	 * 投资记录
	 * @param currentPageNo
	 * @param pageSize
	 * @param bulkStatus
	 * @param custNo
	 * @return
	 */
	/*#RequestMapping(value = "/tenderRecord")*/
	public String tenderRecord(HttpServletRequest request,
			@RequestParam(value="pageNum",required =false)Integer pageNum,
			@RequestParam(value="pageSize",required = false)Integer pageSize,
			Model model){
		
		
		P2p_user user = SecurityUserHolder.getCurrentUser();
		pageNum = pageNum ==null ? 1: pageNum ;
	    pageSize = pageSize == null ? 10:pageSize;
	    Map<String, Object> retMap = new HashMap<String, Object>();
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("custNo", user.getPuCustNo());
		Paging<Map<String, Object>>page =transRecordService.tenderRecord(map, pageNum, pageSize);
		List<Map<String, Object>> list = page.getPageList();
		retMap.put("countTotal", (list!=null&&list.size()>0)?list.size():0);
		retMap.put("endNum",page.getEndPageNo() );
		retMap.put("statrNum",page.getStartPageNo());
		retMap.put("list", list);
		retMap.put(Const.retCode, true);
		retMap.put(Const.retMsg, "\u67e5\u8be2\u6210\u529f");//查询成功
		return "/wap/webTransactionRecords";
	}
}
