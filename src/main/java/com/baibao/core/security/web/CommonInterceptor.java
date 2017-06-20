package com.baibao.core.security.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.baibao.core.security.RandomUtil;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_user;

/**
 * <p>
 * 防止重复提交过滤器
 * </p>
 *
 */
public class CommonInterceptor
	extends HandlerInterceptorAdapter
{
    private static final Logger LOG = LoggerFactory.getLogger(CommonInterceptor.class);
   
    private List<String> mappingURL;//需要拦截的路径

    @Override
    public boolean preHandle(
    	HttpServletRequest request, HttpServletResponse response, Object handler)
    	throws Exception
    {
    	String scheme = request.getScheme();
		String serverName = request.getServerName();
		
		int port = request.getServerPort();
		
		String path = request.getContextPath();
		//String basePath = scheme + "://" + serverName + ":" + port + path;
		
		request.setAttribute("basePath", path);
		
		// 获取当前请求的URL
    	String url = request.getRequestURL().toString();    
    	
    	if (mappingURL == null ||
    		mappingURL.size() == 0 ||
    		!(mappingURL.contains(url)))
    		return true;
   
    	String clinetToken = request.getParameter("_TOKEN_SESSION");
    	
    	P2p_user user = SecurityUserHolder.getCurrentUser();
    	
    	LOG.error("token test,[user:" + user + ",url:"+ request.getServletPath() + "]");
        
    	if (user != null)
    	{
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
 
            SubmitToken annotation = method.getAnnotation(SubmitToken.class);
            if (annotation != null)
            {
                boolean setToken = annotation.setToken();
                if (setToken)
                {
                    request.getSession(false).setAttribute("_TOKEN_SESSION", RandomUtil.random(64));
                }
 
                boolean checkToken = annotation.checkToken();
                if (checkToken)
                {
                    if (isRepeatSubmit(request))
                    {
                    	request.getSession(false).setAttribute("msg", "请勿重复提交");
                    	Map<String, String> map = new HashMap<String, String>();
                    	map.put("msg", "请勿重复提交");
                    	responseOutWithJson(response,map);
                        LOG.warn("please don't repeat submit,[user:" + user.getUsername() + ",url:" + request.getServletPath() + "]");
                        return false;
                    }
                    request.getSession(false).removeAttribute("_TOKEN_SESSION");
                }
            }
        }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request)
    {
        String serverToken =
        	(String) request.getSession(false).getAttribute("_TOKEN_SESSION");

        if (serverToken == null)
            return true;

        String clinetToken = request.getParameter("_TOKEN_SESSION");
        if (clinetToken == null)
            return true;

        if (!serverToken.equals(clinetToken))
            return true;

        return false;
    }

    public void setMappingURL(List<String> mappingURL)
    {
		this.mappingURL = mappingURL;
	}
	
	/** 
	 * 
	 * 以JSON格式输出 
	 * @param response 
	 */  
	protected void responseOutWithJson(
		HttpServletResponse response, Map<String, String> responseObject)
	{  
	    //将实体对象转换为JSON Object转换  
	    JSONObject responseJSONObject = new JSONObject( );
	    responseJSONObject.putAll( responseObject );
	    response.setCharacterEncoding("UTF-8");  
	    response.setContentType("application/json; charset=utf-8");  
	    PrintWriter out = null;  
	    
	    try
	    {  
	        out = response.getWriter();  
	        out.append(responseJSONObject.toString());  
	    } catch(IOException e)
	    {  
	        e.printStackTrace();  
	        LOG.error("responseOutWithJson", e);
	    } finally
	    {  
	        if (out != null) 
	            out.close();
	    }  
	}  
}