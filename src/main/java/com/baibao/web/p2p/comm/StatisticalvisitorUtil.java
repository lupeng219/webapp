package com.baibao.web.p2p.comm;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baibao.core.cache.LoadSystemConfigServlet;
import com.baibao.web.p2p.service.StatisticalService;

/**
 * 统计接口
 * 
 * @author yangyang
 *
 */
@Component
public class StatisticalvisitorUtil
{	
	private static Logger logger =
		LoggerFactory.getLogger(StatisticalvisitorUtil.class);

	@Autowired
	private StatisticalService statisticalService;

	private ThreadPoolExecutor executor = new ThreadPoolExecutor(
		20, 20, 10, TimeUnit.SECONDS,
		new LinkedBlockingDeque<Runnable>(3000),
		new ThreadPoolExecutor.DiscardOldestPolicy());;

	/**
	 * 客户端调用此接口统计访客数据
	 * 
	 * @param request
	 */
	public void getUserInfo(
		HttpServletRequest request, final String custNo)
	{	
		final String ip = getClientIp(request);//获取ip地址
		if (!isIP(ip))
			return;

		final String accessResource = request.getRequestURL().toString();
		final String accessFrom = request.getHeader("Referer");//获取来源
		final String user_agent = request.getHeader("user-agent");//获取客户端信息
	    
		final StringBuilder params = new StringBuilder();
	    
	    for(String key: request.getParameterMap().keySet())
	    {
	    	params.append(key).append("=");
	    	
	    	for(String value: request.getParameterValues(key))
	    	{
	    		params.append(value).append(",");
	    	}

	    	params.append("; ");
	    }
	    
	    executor.execute(new Runnable() {
			@Override
			public void run()
			{
			    statisticalService.saveVisitorsInfo(
			    	ip, accessResource, accessFrom,
			    	user_agent, custNo, params.toString());
			}
	    });
	}

	private String getClientIp(HttpServletRequest request)
	{
		String ipAddress = null;
		
		ipAddress = request.getHeader("x-forwarded-for");

		if (ipAddress == null ||
			ipAddress.length() == 0 ||
			"unknown".equalsIgnoreCase(ipAddress))
		{
			ipAddress = request.getHeader("Proxy-Client-IP");
		}

		if (ipAddress == null || ipAddress.length() == 0 ||
			"unknown".equalsIgnoreCase(ipAddress))
		{
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		
		if (ipAddress == null || ipAddress.length() == 0 ||
			"unknown".equalsIgnoreCase(ipAddress))
		{
			ipAddress = request.getRemoteAddr();
			
			if (ipAddress.equals("127.0.0.1") ||
				"0:0:0:0:0:0:0:1".equals(ipAddress))
			{// 根据网卡取本机配置的IP
				InetAddress inet = null;

				try
				{
					inet = InetAddress.getLocalHost();
				} catch(UnknownHostException e)
				{
					logger.error("getClientIp", e);
				}

				ipAddress = inet.getHostAddress();
			}

		}
		
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15)
		{// "***.***.***.***".length()// = 15
			if (ipAddress.indexOf(",") > 0)
			{
				ipAddress =
					ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}

		return ipAddress;
	}
	
	private boolean isIP(String addr)
    {
		if (addr.length() < 7 ||
			addr.length() > 15 || "".equals(addr))
		{
			return false;
		}

		String rexp = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

		Pattern pat = Pattern.compile(rexp);  
		Matcher mat = pat.matcher(addr);  

		boolean ipAddress = mat.find();

		return ipAddress;
    }
}
