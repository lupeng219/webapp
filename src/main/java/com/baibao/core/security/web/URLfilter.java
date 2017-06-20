package com.baibao.core.security.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class URLfilter implements Filter{
	
	private static String web_xml_url;
	
	private static String forward;
	

	/**
	 * URL过滤,true为合法 false为非法?
	 * @return
	 */
	public static boolean UrlFile(HttpServletRequest request)
	{
	
		String web_xml[]=web_xml_url.split("\\|");
		StringBuffer str;
		String st[];
		StringBuffer keyName;
		Enumeration enu=request.getParameterNames();
		
		while(enu.hasMoreElements())
		{
			keyName=new StringBuffer((String)enu.nextElement());
			if(request.getParameter(keyName.toString())!=null)
			{
				str=new StringBuffer(request.getParameter(keyName.toString()));
				
				for(int i1=0;i1<web_xml.length;i1++)
				{
					if(str.lastIndexOf(web_xml[i1])!=-1)
					{
						return false;
					}
				}
				if(str.lastIndexOf(">")!=-1||str.lastIndexOf("<")!=-1){
					return false;
				}
			}
			else if(request.getParameterValues(keyName.toString())!=null)
			{
				st=request.getParameterValues(keyName.toString());
				for(int i=0;i<st.length;i++)
				{
					for(int j=0;j<web_xml.length;j++)
					{
						if(st[i].lastIndexOf(web_xml[j])!=-1)
						{
							return false;
						}
					}
					if(st[i].lastIndexOf(">")!=-1||st[i].lastIndexOf("<")!=-1){
						return false;
					}
				}
				
			}
		}
		
		return true;
		
	}

	public void destroy() {
		
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
  		boolean boo=URLfilter.UrlFile((HttpServletRequest)request);
		if(boo==false)
		{
			request.getRequestDispatcher(forward).forward(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
		
		
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		
		this.web_xml_url=filterConfig.getInitParameter("sql");
		this.forward=filterConfig.getInitParameter("forward");
		
	}

	public static String getWeb_xml_url() {
		return web_xml_url;
	}

	public static void setWeb_xml_url(String web_xml_url) {
		URLfilter.web_xml_url = web_xml_url;
	}

	public static String getForward() {
		return forward;
	}

	public static void setForward(String forward) {
		URLfilter.forward = forward;
	}

	

}