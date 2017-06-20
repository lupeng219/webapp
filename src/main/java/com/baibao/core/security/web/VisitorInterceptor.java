 package com.baibao.core.security.web;


import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.StatisticalvisitorUtil;


public class VisitorInterceptor
	extends HandlerInterceptorAdapter
{
	private static final Logger log =
		LoggerFactory.getLogger(VisitorInterceptor.class);
	private Set<String> mappingURL;//需要拦截的路径

	public void setMappingURL(Set<String> mappingURL)
	{
		this.mappingURL = mappingURL;
	}
	
	@Autowired
	private JedisUtil jedisUtil;

	@Autowired
	protected StatisticalvisitorUtil util;
	 
	@Override
	public void afterCompletion(
		final HttpServletRequest request,
        final HttpServletResponse response,
        Object handler, Exception e)
			throws Exception
	{
		String url = request.getRequestURI();
		String custNo = SecurityUserHolder.getCustNo();
		
		if (custNo == null)
		{
			custNo = request.getParameter("custNo");
			
			if (custNo != null)
				custNo = jedisUtil.getValue(custNo);
		}
		 
		log.info("#visitor url:"+url, ", " + custNo);
		log.info(request.getHeader("accept"));

		util.getUserInfo(request, custNo);
	 }
}
