package com.baibao.core.security.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;  
/**
 * 作用：
 * 1，过滤跨站脚本
 * 2，防止框架钓鱼漏洞可以被恶意攻击者通过构造参数
 *
 */
public final class RequestWrapper
	extends HttpServletRequestWrapper
{            
    public RequestWrapper(HttpServletRequest servletRequest)
	{    
        super(servletRequest);    
    }    
        
    public String[] getParameterValues(String parameter)
    {    
    	String[] values = super.getParameterValues(parameter);    
    	if (values == null) 
    	{    
    		return null;    
        }    
      
    	int count = values.length;    
    	String[] encodedValues = new String[count];    
    	
    	for(int i = 0; i < count; i++)
    	{    
             encodedValues[i] = cleanXSS(values[i]);    
    	}

    	return encodedValues;     
    }    
        
    public String getParameter(String parameter)
    {    
          String value = super.getParameter(parameter);    
          if (value == null)
             return null;
                 
          return cleanXSS(value);    
    }    
        
    public String getHeader(String name)
    {    
        String value = super.getHeader(name);    
        if (value == null)    
            return null;    
        
        return cleanXSS(value);    
    }    

    private String cleanXSS(String value)
    {
    	value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");    
        value = value.replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;");    
        value = value.replaceAll("‘", "&#39;");              
        value = value.replaceAll("eval(.*)", "");    
        value = value.replaceAll("[\"\'][\\s]*javascript:(.*)[\"\']", "\"\"");    
        value = value.replaceAll("script", "");    
        value = value.replaceAll("html", "");    
        value = value.replaceAll("body", "");    
        value = value.replaceAll("javascript", "");    
        value = value.replaceAll("jscript", "");    
        value = value.replaceAll("vbscript", "");

        return value;
    }    
}