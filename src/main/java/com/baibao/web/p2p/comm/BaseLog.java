package com.baibao.web.p2p.comm;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.baibao.core.cache.LoadSystemConfigServlet;
import com.baibao.web.p2p.generator.bean.P2p_log;
import com.baibao.web.p2p.service.LogService;

@Component("baseLog")
public class BaseLog
{
	@Autowired
	private LogService logService;


	private ThreadPoolExecutor executor = new ThreadPoolExecutor(
		20, 20, 10, TimeUnit.SECONDS,
		new LinkedBlockingDeque<Runnable>(3000),
		new ThreadPoolExecutor.DiscardOldestPolicy());;

		
	/**
	 * 记录用户操作日志
	 * @param custNo 客户号
	 * @param operationData 操作内容
	 * @param operationResult 操作结果
	 * @param operationDec 业务类型
	 * @param operationChannel 客户端类型
	 * @param Operationjoggle 客户端类型
	 */
	public void writer(
		final String custNo, final String operationData,
		final String operationResult, final String operationDec,
		final String operationChannel, final String Operationjoggle)
	{
		try
		{
			executor.execute(new Runnable() {
				@Override
				public void run()
				{
					try
					{
						P2p_log log = new P2p_log();
				
						log.setCustno(custNo);//客户号
						log.setOperationTime(new Date());//操作时间
						log.setOperationIp(getIpAddres());//操作ip
						log.setOperationData(operationData);//操作内容
						log.setOperationResult(operationResult);//操作结果
						log.setOperationDec(operationDec);//业务类型
						log.setOperationChannel(operationChannel);//客户端类型
						log.setOperationjoggle(Operationjoggle);//接口名称
	
						if (log != null)
						{
							logService.saveLog(log);
						}
					} catch(Exception e)
					{
						e.printStackTrace();
					}
				}				
			});
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected static String getIpAddres()
	{
		HttpServletRequest request = 
		((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
			.getRequest();
		
		String ip = request.getHeader("x-forwarded-for");
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		
		if (ip != null)
			ip = ip.split(",")[0];

		return ip;
	}
}
