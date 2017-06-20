package com.baibao.web.p2p.controller.piggyBank;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.service.PiggyBankService;


/**
 * <p>版权所有：(C)2013-2018 中融佰诚</p>
 * 
 */
@Controller
@RequestMapping("/piggyBank")
public class PiggyBankController {
	
	private static Logger log = LoggerFactory.getLogger(PiggyBankController.class);
	
	@Autowired
	private PiggyBankService piggyBankService;
	
	@Autowired
	private JedisUtil jedisUtil;
	
	/**
	 * 个人中心-我的存钱罐
	 * @param request
	 * @return
	 */
	@RequestMapping
	public ModelAndView myPiggyBank(HttpServletRequest request){
		ModelAndView model =new ModelAndView("personal/myPiggyBank");
		String custNo = SecurityUserHolder.getCustNo();
		//查询用户信息
		Map<String, Object> result = piggyBankService.getEssentialInformation(custNo);
		model.addObject("result",result);
		return model;
	}
	
	/**
	 * 构建7天收益率
	 * @return
	 * @throws BusinessException 
	 * @throws Exception 
	 */
	@RequestMapping("/getYieldrate")
	@ResponseBody
	private Map<String, Object> getYieldrate(){
		Map<String, Object> yieldrateMap = JSONObject.toJavaObject(JSONObject.parseObject(jedisUtil.getValue(Const.YIELDRATE)), Map.class);
		if(yieldrateMap==null){
			try {
				yieldrateMap =  piggyBankService.getYieldrate();
				jedisUtil.setValue(Const.YIELDRATE, JSON.toJSONString(yieldrateMap),60*60);
			} catch (Exception e) {
				log.error("getYieldrate", e);
			}
		}
		return yieldrateMap;
	}
	
	/**
	 * 新浪页面查询用户信息
	 * @param bankCode
	 * @param amount
	 * @return
	 */
	/*#RequestMapping("/showMemberInfosSina")*/
	public String showMemberInfosSina(HttpServletRequest request) throws BusinessException{
		String custNo = SecurityUserHolder.getCustNo();
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result=	piggyBankService.showMemberInfosSina(custNo);
			request.setAttribute("result", result.get("redirect_url"));
		} catch (Exception e) {
			log.error("showMemberInfosSina", e);
		}
		return "/personal/jumpInfo";
	}
}
