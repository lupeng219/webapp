package com.baibao.core.security.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baibao.web.p2p.comm.IsMobile;

/**
 * 作用：
 * 1，过滤跨站脚本
 * 2，防止框架钓鱼漏洞可以被恶意攻击者通过构造参数
 * 需要在web.xml中增加以代码片段
 * <filter>
		<filter-name>XSS</filter-name>
		<filter-class>com.nci.filter.CrossScriptingFilter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>XSS</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
 *
 */
public class CrossScriptFilter
	implements Filter
{
	private FilterConfig filterConfig;
	
    public void init(FilterConfig filterConfig)
    	throws ServletException
    {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
        this.filterConfig = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    	throws IOException, ServletException
    {
    	/*HttpServletRequest httpReq =(HttpServletRequest) request;
    	HttpServletResponse httpRes =(HttpServletResponse) response;

    	/*String root = httpReq.getContextPath();
    	String path = httpReq.getRequestURI().substring(root.length());
    	
    	if (IsMobile.JudgeIsMoblie(httpReq) &&
    		(path.startsWith("/service") || path.equals("/")) &&
    		!(path.startsWith("/service/wap") ||
    		  path.startsWith("/service/app") ||
    		  path.startsWith("/service/App") ||
    		  path.startsWith("/service/agreement")))
    	{
    		httpRes.sendRedirect(root + "/service/waptip");
    	}*/

       	chain.doFilter(request, response);
    }
}

