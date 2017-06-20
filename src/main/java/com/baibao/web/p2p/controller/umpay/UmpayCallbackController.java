package com.baibao.web.p2p.controller.umpay;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.exception.BusinessException;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.DataDIC;
import com.baibao.web.p2p.service.UmpayService;

/**
 *  回调通知Controller
 */
@Controller
@RequestMapping("/umpayCallback")
public class UmpayCallbackController {

	private static Logger log = LoggerFactory.getLogger(UmpayCallbackController.class);
	@Autowired
	private UmpayService umpayService;
	
	/***
	 * 个人客户提现Ret通知
	 * 
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/ret/cust_withdrawals")*/
	public ModelAndView custWithdrawals_Ret(HttpServletRequest request)  throws Exception{
		log.info("custWithdrawals_Ret parameter : 提现通知开始");//提现通知开始
		ModelAndView view = new ModelAndView();
		Map ht = getMapByParameter(request);
		try {
			// 验签
			com.umpay.api.paygate.v40.Plat2Mer_v40.getPlatNotifyData(ht);
		} catch (Exception e) {
			log.error("custWithdrawals_Ret", e);
			// 跳转至错误页面
			throw new BusinessException("支付通讯异常");  
		}
		view.setViewName("redirect:/service/asset/switcholdaccount");
		log.info(String.format("custWithdrawals_Ret parameter : 提现通知开始 --- return : view = %s", 
        		JsonHelper.formatJson(view)));

		return view;
	}
	/*#RequestMapping("/ret/cust_withdrawalsApp")*/
	public ModelAndView custWithdrawals_RetApp(HttpServletRequest request)  throws Exception{
		return withdraw_apply_retApp(request);
	}
	@SuppressWarnings("rawtypes")
	public ModelAndView withdraw_apply_retApp(HttpServletRequest request)  throws Exception{
		log.info("withdraw_apply_retApp parameter :");
		Map ht = getMapByParameter(request);
		try {
			// 验签
			com.umpay.api.paygate.v40.Plat2Mer_v40.getPlatNotifyData(ht);
			// 跳转到处理完成页面
		} catch (Exception e) {
			log.error("withdraw_apply_retApp", e);
			// 跳转至错误页面
			throw new BusinessException("支付通讯异常");  
		}
		ModelAndView view=new ModelAndView("/error/ret");
		log.info(String.format("withdraw_apply_retApp parameter :  --- return : view = %s", 
        		JsonHelper.formatJson(view)));
		return view;
	}
	/***
	 * 个人客户提现Notify通知
	 * 
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/notify/cust_withdrawals")*/
	public String custWithdrawals_Notify(HttpServletRequest request) {
		log.info("custWithdrawals_Notify parameter :");
		Map ht = getMapByParameter(request);
		Map reqData = new HashMap();
		Map resData = new HashMap();
		try {
			reqData = com.umpay.api.paygate.v40.Plat2Mer_v40.getPlatNotifyData(ht);
			resData.put("ret_code", "0000");
		} catch (Exception e) {
			resData.put("ret_code", "1111");
			log.error("custWithdrawals_Notify", e);
		}
		if ("0000".equals(reqData.get("ret_code")) && "0000".equals(resData.get("ret_code"))) {
			try {
				// 商户请求时提交的order_id
				String order_id = request.getParameter("order_id");
				// 交易状态 3-失败 4-成功 
				String trade_state = request.getParameter("trade_state");
				if(trade_state !=null){
					Map<String,String> pamart = new HashMap<String,String>();
					if(trade_state.equals("4")){
						trade_state = DataDIC.TRANSUCC.getDataCode();
					}else{
						trade_state = DataDIC.TRANFAIL.getDataCode();
					}
					pamart.put("getState", trade_state);
					pamart.put("transeOder", order_id);
					int count = umpayService.updateWithdrawCash(pamart);
				}
			} catch (Exception e) {
				
				log.error("custWithdrawals_Notify", e);
			}
		}
		String merNotifyResData = merNotifyResData(request, resData);
		log.info(String.format("custWithdrawals_Notify parameter :  --- return : merNotifyResData = %s", 
				merNotifyResData));
		
		return merNotifyResData;
	}
	
	/**
	 * 把request里的参数装配到map中
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map getMapByParameter(HttpServletRequest request) {
		log.info("getMapByParameter parameter :");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("getMapByParameter", e);
		}
		log.debug(request.getRequestURL() + "begin");
		log.debug("===================================");
		Map ht = new HashMap();
		String name = "", values = "";
		for (Enumeration names = request.getParameterNames(); names
				.hasMoreElements(); ht.put(name, values)) {
			name = (String) names.nextElement();
			values = request.getParameter(name);
			try {
				values = new String(values.getBytes("iso-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.error("getMapByParameter", e);
				values = null;
			}
			log.info(name + ":" + values);
		}
		log.debug("===================================");
		log.debug(request.getRequestURL() + "end");
		log.info(String.format("getMapByParameter parameter :  --- return : ht = %s", 
				JsonHelper.formatJson(ht)));
		return ht;
	}
	/**
	 * 生成响应内容
	 * 
	 * @param resData
	 * @return
	 */
	protected String merNotifyResData(HttpServletRequest request, Map resData) {
		log.info("merNotifyResData parameter :resData = %s ",JsonHelper.formatJson(resData));
		
		initResData(request, resData);
		String data = com.umpay.api.paygate.v40.Mer2Plat_v40.merNotifyResData(resData);
		request.setAttribute("data", data);
		
		log.info("merNotifyResData parameter : resData = %s --- return : " ,JsonHelper.formatJson(resData) );
		return "/WEB-INF/views/umpay/notify";
	}
	
	/**
	 * 生成响应回应的必须内容
	 * 
	 * @param request
	 * @param resData
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map initResData(HttpServletRequest request, Map resData) {
		log.info("initResData parameter :resData = %s ",JsonHelper.formatJson(resData));
		if (request.getParameter("mer_id") != null) {
			resData.put("mer_id", request.getParameter("mer_id"));
		}
		if (request.getParameter("sign_type") != null) {
			resData.put("sign_type", request.getParameter("sign_type"));
		}
		if (request.getParameter("version") != null) {
			resData.put("version", request.getParameter("version"));
		}
		if (request.getParameter("order_id") != null) {
			resData.put("order_id", request.getParameter("order_id"));
		}
		if (request.getParameter("mer_date") != null) {
			resData.put("mer_date", request.getParameter("mer_date"));
		}
		log.info("initResData parameter : --- return : resData = %s ",JsonHelper.formatJson(resData));
		return resData;
	}
}
