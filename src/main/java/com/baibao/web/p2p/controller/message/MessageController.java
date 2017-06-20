package com.baibao.web.p2p.controller.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.MsgType;
import com.baibao.web.p2p.service.MsgService;

/**
 * 消息中心
 * @date 2016年1月27日
 */
@Controller
@RequestMapping("/message")
public class MessageController {
	private static Logger log = LoggerFactory.getLogger(MessageController.class);
	@Autowired
	MsgService msgService;
	/**
	 * 消息中心
	 * @param request
	 * @return
	 */
	@RequestMapping("/toMessageCenter")
	public String toMessageCenter(HttpServletRequest request) {
		log.info("toMessageCenter parameter : ");
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		List<Map<String, Object>> list = null;
		list = msgService.getAllMsg(user.getPuCustNo());
		request.setAttribute("msglist", list);
		log.info("toMessageCenter parameter : ---return : ");
		return "message/messageCenter";
	}
	
	/**
	 * 消息详情
	 * @param request
	 * @return
	 */
	@RequestMapping("/toMessageDetails")
	public ModelAndView toMessageDetails(HttpServletRequest request,
			String type,Integer cursor, Integer count) {
		log.info(String.format("toMessageDetails parameter :  type = %s, cursor = %s, count = %s",
				type,cursor,count));
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		cursor =cursor ==null ? 1: cursor ;
		count = count == null ? 5:count;
		ModelAndView  model = new ModelAndView("message/messageDetails");
		Paging<Map<String, Object>> page = msgService.getMsgByType(type,user.getPuCustNo(),cursor,5);
		List<Map<String, Object>> list = page.getPageList();
		model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
		model.addObject("paging", page);
		model.addObject("ajaxPageUrl","message/ajaxShowDetailsMessage");
		model.addObject("type",type);
		model.addObject("title", MsgType.getMsgType(type).getDesc());
		log.info(String.format("toMessageDetails parameter :  type = %s, cursor = %s, count = %s --- return : model = %s",
				type,cursor,count,JsonHelper.formatJson(model)));
		return model;
	}
	
	/**
	 * 消息详情分页
	 * @param request
	 * @param type
	 * @param currentPageNo
	 * @return
	 */
	@RequestMapping("/ajaxShowDetailsMessage")
	public ModelAndView  ajaxShowDetailsMessage(HttpServletRequest request,String type,
		@RequestParam("currentPageNo")Integer currentPageNo
		){
		log.info(String.format("ajaxShowDetailsMessage parameter :  type = %s, currentPageNo = %s",
				type,currentPageNo));
		P2p_user user  =(P2p_user) request.getSession().getAttribute(Const.CURRENT_LOGIN_USER);
		ModelAndView model = new ModelAndView("message/_messageDetailsPage");
		if(user!=null){
			Paging<Map<String, Object>> page = msgService.getMsgByType(type,user.getPuCustNo(),currentPageNo,5);
			List<Map<String, Object>> list = page.getPageList();
			model.addObject("paging", page);
			model.addObject("total", (list!=null&&list.size()>0)?list.size():0);
			model.addObject("ajaxPageUrl","message/ajaxShowDetailsMessage");
			model.addObject("type",type);
			model.addObject("title", MsgType.getMsgType(type).getDesc());
		}
		log.info(String.format("ajaxShowDetailsMessage parameter :  type = %s, currentPageNo = %s --- return : model = %s",
				type,currentPageNo,JsonHelper.formatJson(model)));
		return model;
	}
	
	
	
	@RequestMapping("/deleteMsg")
	public @ResponseBody Map<String, Object> deleteMsg(HttpServletRequest request,String msgIds){
		log.info(String.format("deleteMsg parameter :  msgIds = %s",
				msgIds));
		
		Map<String, Object> result = new HashMap<String, Object>();
		String msgId[] = msgIds.split(",");
		int i = 0;
		for (String id : msgId) {
			if(StringUtil.isEmpty(id))
				continue;
			try {
				 msgService.deleteMsg(id);
				 i++;
			} catch (Exception e) {
				log.error("deleteMsg", e);
				break;
			}
		}
		if(i != msgId.length){
			result.put(Const.retCode,false);
			result.put(Const.retMsg,"删除站内信失败");
			return result;
		}
		result.put(Const.retCode,true);
		result.put(Const.retMsg,"删除成功");
		log.info(String.format("deleteMsg parameter :  msgIds = %s --- return : result = %s",
				msgIds,JsonHelper.formatJson(result)));
		return result;
	}
}
