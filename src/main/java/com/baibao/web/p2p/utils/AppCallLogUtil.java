package com.baibao.web.p2p.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.baibao.cache.utils.JedisUtil;


public class AppCallLogUtil
{	
	private static Logger logger =
		LoggerFactory.getLogger(AppCallLogUtil.class);

	public static String dumpRequest(HttpServletRequest request)
	{
		StringBuilder builder = new StringBuilder();

		for(Map.Entry<String, String[]> entry:
			request.getParameterMap().entrySet())
		{
			String name = entry.getKey();
			String[] values = entry.getValue();

			builder.append(name).append("=");

			int index = 0;
			
			for(String value: values)
			{
				if (index++ != 0)
					builder.append("|");

				builder.append(value);
			}

			builder.append(", ");
		}

		return builder.toString();
	}

	public static void printMsg(
		HttpServletRequest request, String method, String ...msg)
	{
		try
		{
			if (msg.length > 0)
			{
				StringBuilder sb = new StringBuilder ( "" );
				for(String s :msg){
					 sb.append(s);
					 sb.append("=");
					 sb.append(request.getParameter(s));
					 sb.append(",");
				}
				String param =sb.toString();
				param= param.substring(0,param.length()-1);
				StringBuilder printmsg = new StringBuilder ( "" );  
				printmsg.append("Call--");
				printmsg.append(method);
				printmsg.append("--param[");
				printmsg.append(param);
				printmsg.append("]--");
				printmsg.append("source[");
				printmsg.append("BAIBAO-Version=");
				printmsg.append(request.getHeader("BAIBAO-Version"));
				printmsg.append(",BAIBAO-OSVersion=");
				printmsg.append(request.getHeader("BAIBAO-OSVersion"));
				printmsg.append(",BAIBAO-IMEI=");
				printmsg.append(request.getHeader("BAIBAO-IMEI"));
				printmsg.append(",BAIBAO-OS=");
				printmsg.append(request.getHeader("BAIBAO-OS"));
				printmsg.append(",BAIBAO-Channel=");
				printmsg.append(request.getHeader("BAIBAO-Channel"));
				printmsg.append("]");
				logger.info(printmsg.toString());
			} else
			{
				StringBuilder printmsg = new StringBuilder ( "" );  
				printmsg.append("Call--");
				printmsg.append(method);
				printmsg.append("---source[");
				printmsg.append("BAIBAO-Version=");
				printmsg.append(request.getHeader("BAIBAO-Version"));
				printmsg.append(",BAIBAO-OSVersion=");
				printmsg.append(request.getHeader("BAIBAO-OSVersion"));
				printmsg.append(",BAIBAO-IMEI=");
				printmsg.append(request.getHeader("BAIBAO-IMEI"));
				printmsg.append(",BAIBAO-OS=");
				printmsg.append(request.getHeader("BAIBAO-OS"));
				printmsg.append(",BAIBAO-Channel=");
				printmsg.append(request.getHeader("BAIBAO-Channel"));
				printmsg.append("]");
				logger.info(printmsg.toString());
			}
		} catch(Exception e)
		{
			 logger.error(method, e);
		}
	}
	
}
