package com.baibao.core.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class QZBExceptionHandler
	implements HandlerExceptionResolver
{
	private static final  Logger log =
		LoggerFactory.getLogger(QZBExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(
		HttpServletRequest request, HttpServletResponse response,
		Object handler, Exception exception)
	{	
		UUID id = UUID.randomUUID();

		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("exception", "错误编号：" + id + " 系统处理错误！");

        log.error("platform exception:" + id + "#######", exception);

        return new ModelAndView("/error/exception", model);  
	}
}
