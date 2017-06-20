package com.baibao.web.p2p.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baibao.core.Context;
import com.baibao.core.ContextImpl;
import com.baibao.core.cache.SystemConfigCache;
import com.baibao.web.p2p.pay.sina.util.SignUtil;
import com.baibao.web.p2p.pay.sina.util.Tools;

/**
 *  回调通知Controller
 */
@Controller
@RequestMapping("/qzbCallback")
public class CallbackController
{
	private static Logger log = LoggerFactory.getLogger(CallbackController.class);
}
