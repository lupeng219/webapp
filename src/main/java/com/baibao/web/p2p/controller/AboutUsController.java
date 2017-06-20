package com.baibao.web.p2p.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.utils.Paging;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.bean.P2p_article;
import com.baibao.web.p2p.service.AboutUsService;
import com.baibao.web.p2p.service.ActiveService;


/**
 * <p>版权所有：(C)2013-2018 中融佰诚</p>
 * 
 */
@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {
	
	private static Logger log = LoggerFactory.getLogger(AboutUsController.class);
	@Autowired
	private AboutUsService aboutUsService;
	@Autowired
	private ActiveService activeService;
	
	
	/**
	 * 公司简介
	 * @return
	 */
	@RequestMapping("/company")
	public String aboutWe(HttpServletRequest request){
		return "/aboutUs/aboutUs_company";
	}

	/**
	 * 管理团队
	 * @return
	 */
	/*#RequestMapping("/team")*/
	public String team(HttpServletRequest request){
		return "/aboutUs/aboutUs_team";
	}
	
	/**
	 * 资质荣誉
	 * @return
	 */
	/*#RequestMapping("/qualification")*/
	public String qualification(HttpServletRequest request){
		return "/aboutUs/aboutUs_qualification";
	}
	
	/**
	 * 媒体报道
	 * @return
	 */
	/*#RequestMapping("/news")*/
	public ModelAndView news(HttpServletRequest request, ModelAndView mav ){
		//ModelAndView mav  = new ModelAndView("/aboutUs/aboutUs_news");
		try{
			Paging<P2p_article> page  = aboutUsService.queryNoticeList(Const.media,1, 5);
			List<P2p_article> pageList =page.getPageList();
			mav.addObject("paging", page);
			mav.addObject("total", (pageList!=null&&pageList.size()>0)?pageList.size():0);
			mav.addObject("ajaxPageUrl", "aboutUs/newsAjax");
			
			mav.setViewName( "/aboutUs/aboutUs_news" );
		}catch(Exception e){
			
			log.error("error",e);
		}
		return mav ;
		
	}
	/**
	 * 媒体报道分页
	 * @return
	 */
	/*#RequestMapping("/newsAjax")*/
	public ModelAndView newsAjax(HttpServletRequest request,Integer currentPageNo){
		log.info(String.format("newsAjax parameter : currentPageNo = %d", currentPageNo));
		ModelAndView mav  = new ModelAndView("/aboutUs/_page_news");
		try{
			Paging<P2p_article> page  = aboutUsService.queryNoticeList(Const.media,currentPageNo, 5);
			List<P2p_article> pageList =page.getPageList();
			mav.addObject("paging", page);
			mav.addObject("total", (pageList!=null&&pageList.size()>0)?pageList.size():0);
			mav.addObject("ajaxPageUrl", "aboutUs/newsAjax");
		}catch(Exception e){
			
			log.error("error",e);
		}
		log.info(String.format("newsAjax parameter : currentPageNo = %d --- return : mav = %s", 
				currentPageNo, JsonHelper.formatJson(mav)));
		return mav ;
	}
	
	/**
	 * 媒体详情页
	 * @param noticeId
	 * @return
	 */
	/*#RequestMapping("/newsDesc")*/
	public ModelAndView newsDesc(HttpServletRequest request,Long noticeId){
		ModelAndView mav  = new ModelAndView("/aboutUs/aboutUs_newsdesc");
		try{
			P2p_article  newsDesc =  aboutUsService.queryNoticeById(noticeId);
			mav.addObject("newsDesc", newsDesc);
		}catch(Exception e){
			
			log.error("error",e);
		}
		return mav;
	}
	
	/**
	 * 网站公告
	 * @return
	 */
	/*#RequestMapping("/notice")*/
	public ModelAndView notice(HttpServletRequest request){
		ModelAndView mav  = new ModelAndView("/aboutUs/aboutUs_notice");
		try{
			Paging<P2p_article> page  = aboutUsService.queryNoticeList(Const.notice,1, 10);
			List<P2p_article> pageList =page.getPageList();
			mav.addObject("paging", page);
			mav.addObject("total", (pageList!=null&&pageList.size()>0)?pageList.size():0);
			mav.addObject("ajaxPageUrl", "aboutUs/noticeAjax");
		}catch(Exception e){
			
			log.error("error",e);
		}
		return mav ;
	}
	
	/**
	 * 网站公告分页
	 * @return
	 */
	/*#RequestMapping("/noticeAjax")*/
	public ModelAndView noticeAjax(HttpServletRequest request,Integer currentPageNo){
		ModelAndView mav  = new ModelAndView("/aboutUs/_page_notice");
		try{
			Paging<P2p_article> page  = aboutUsService.queryNoticeList(Const.notice,currentPageNo, 10);
			List<P2p_article> pageList =page.getPageList();
			mav.addObject("paging", page);
			mav.addObject("total", (pageList!=null&&pageList.size()>0)?pageList.size():0);
			mav.addObject("ajaxPageUrl", "aboutUs/noticeAjax");
		}catch(Exception e){
			
			log.error("error",e);
		}
		return mav ;
	}
	/**
	 * 公告详情
	 * @param noticeId
	 * @return
	 */
	/*#RequestMapping("/noticeDesc")*/
	public ModelAndView noticeDesc(HttpServletRequest request,Long noticeId){
		ModelAndView mav  = new ModelAndView("/aboutUs/aboutUs_noticedesc");
		try{
			P2p_article  noticeDesc =  aboutUsService.queryNoticeById(noticeId);
			mav.addObject("noticeDesc", noticeDesc);
		}catch(Exception e){
			
			log.error("error", e);
		}
		return mav;
	}
	
	
	/**
	 * 员工关怀
	 * @return
	 */
	/*#RequestMapping("/staffcare")*/
	public String staffcare(HttpServletRequest request){
		return "/aboutUs/aboutUs_staffcare";
	}
	
	/**
	 * 员工关怀详情
	 * @return
	 */
	/*#RequestMapping("/staffcareDetails")*/
	public String staffcareDetails(HttpServletRequest request){
		return "/aboutUs/aboutUs_staffcare_desc";
	}
	
	
	/**
	 * 招贤纳士
	 * @return
	 */
	@RequestMapping("/recruitment")
	public String recruitment(HttpServletRequest request){
		return "/aboutUs/aboutUs_recruitment";
	}
	
	/**
	 * 联系我们
	 * @return
	 */
	@RequestMapping("/contact")
	public String contact(HttpServletRequest request){
		return "/aboutUs/aboutUs_contact";
	}
	
	/**
	 * 友情链接
	 * @return
	 */
	/*#RequestMapping("/links")*/
	public String links(HttpServletRequest request){
		return "/aboutUs/aboutUs_links";
	}
	
	/**
	 * 活动时间轴
	 * @return
	 */
	/*#RequestMapping("/activeTimeAxis")*/
	public ModelAndView activeTimeAxis(HttpServletRequest request,ModelAndView model){
			List<Map<String, Object>>  activeList =activeService.showActiveList(null);
			for(Map<String, Object> active:activeList){
				String  startTime =(String) active.get("pae_starTime");
			    String  endTime =(String) active.get("pae_endTime");
			    String  isEnable =(String) active.get("pae_isEnable");
			    Date startDate =DateUtils.strToDate(startTime);
				Date endDate =DateUtils.strToDate(endTime);
				Boolean isbetween = DateUtils.isBetweenDate(startDate, endDate, new Date());
				int flag =DateUtils.compare_date(startDate,new Date());
				if(flag==1){
					active.put("status", "敬请期待");
				}else{
					if(isEnable.equals("1")&&isbetween==true){
						active.put("status", "进行中");
					}else{
						active.put("status", "已结束");
					}
				}
				
			}
			
			model.addObject("activeList",activeList);
			model.setViewName("/aboutUs/aboutUs_activeTimeAxis");
		
		return model;
	}
	
	/**
	 * 风控--安全保障
	 * @return
	 */
	/*#RequestMapping("/safetyAssurance")*/
	public String safetyAssurance(HttpServletRequest request){
		return "/aboutUs/safetyAssurance";
	}
	/**
	 * 新手指引--出借指南
	 * @param request
	 * @return
	 */
	@RequestMapping("/loanShow")
	public String loanShow(HttpServletRequest request){
		return "/aboutUs/loanShow";
	}
	/**
	 * 新手指引--安全保障
	 * @param request
	 * @return
	 */
	@RequestMapping("/safetyGuarantee")
	public String safetyGuarantee(HttpServletRequest request){
		return "/aboutUs/safetyGuarantee";
	}
	/**
	 * 新手指引--法律法规
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/lawRule")*/
	public String lawRule(HttpServletRequest request){
		return "/aboutUs/lawRule";
	}
	/**
	 * 新手指引--收益说明
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/incomeExplain")*/
	public String incomeExplain(HttpServletRequest request){
		return "/aboutUs/incomeExplain";
	}
	/**
	 * 帮助中心
	 * @return
	 */
	/*#RequestMapping("/helpCenter")*/
	public String helpCenter(HttpServletRequest request){
		return "/aboutUs/helpCenter";
	}
	
	/**
	 * 公司简介
	 * @return
	 */
	@RequestMapping("/aboutUs_zc")
	public String aboutUs_zc(HttpServletRequest request){
		return "/aboutUs/aboutUs_zc";
	}

	/**
	 * 帮助中心
	 * @return
	 */
	@RequestMapping("/_help_center")
	public String help_center(HttpServletRequest request){
		return "/aboutUs/_help_center";
	}
	
	/**
	 * 新手指引
	 * @return
	 */
	@RequestMapping("/aboutUs_guide")
	public String aboutUs_guide(HttpServletRequest request){
		return "/aboutUs/aboutUs_guide";
	}
}
