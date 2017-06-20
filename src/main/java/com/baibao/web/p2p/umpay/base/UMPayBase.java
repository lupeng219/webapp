package com.baibao.web.p2p.umpay.base;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baibao.core.comm.http.HttpClientUtil;
import com.umpay.api.exception.ReqDataException;
import com.umpay.api.exception.RetDataException;
import com.umpay.api.paygate.v40.Plat2Mer_v40;

/**
 * 联动优势接口对接 基类
 * @author Wang.Sheng
 *
 */
@Component
public class UMPayBase {
	
	private static Logger log = LoggerFactory.getLogger(UMPayBase.class);
	
	private static Configuration config = null;
	
	/**
	 * 商户编号
	 * 7099060
	 */	
	public static String mer_id = "7001060";
	
	/**
	 * 商户 后台 通知 地址前缀
	 * 商户后台通知地址格式: 地址前缀+service
	 */	
	protected static String notify_prefix_url = "https://www.quanziben.com/service/umpayCallback/notify/";
	
	/**
	 * 商户 前台 通知  地址前缀
	 * 商户前台通知地址格式: 地址前缀+service
	 */	
	protected static String ret_prefix_url = "https://www.quanziben.com/service/umpayCallback/ret/";
	
	/**
	 * 读取系统初始化配置文件
	 */
	static{
		try {
			log.debug("读取支付模块配置..........[开始]");
			config = getUMPayConfiguration();
			mer_id = config.getString("mer_id");
			log.debug("商户ID:"+mer_id);
			notify_prefix_url = config.getString("notify_prefix_url");
			log.debug("后台通知地址Prefix设定:"+notify_prefix_url);
			ret_prefix_url = config.getString("ret_prefix_url");
			log.debug("前台通知地址Prefix设定:"+ret_prefix_url);
			log.debug("读取支付模块配置完成..........[完成]");
		} catch (ConfigurationException e) {
			log.error("读取支付模块配置异常：异常如下:", e);
		}
	}
	
	/**
	 * 获取配置文件中的配置内容
	 * @return
	 * @throws ConfigurationException
	 */
	public static PropertiesConfiguration getUMPayConfiguration() throws ConfigurationException{
		return new PropertiesConfiguration("config/system/umpay_setting.properties");
	}

	/**
	 * 签名方式
	 */
	protected static final String sign_type = "RSA";
	
	/**
	 * 字符编码格式
	 */
	protected static final String charset = "UTF-8";
	
	/**
	 * 响应数据格式
	 */
	protected static final String res_format = "HTML";
	
	/**
	 * 版本号
	 */
	protected static final String version = "1.0";
	
	/**
	 * 生成通用的，每次请求中都会携带的公共参数
	 * @param service
	 * @return
	 */
	protected Map<String,String> generateRequestBaseMap(String service){
		Map<String,String> map = new HashMap<String,String>();
		map.put("service",service);
	    map.put("sign_type",sign_type);
	    map.put("charset",charset);
	    map.put("res_format",res_format);
	    map.put("mer_id",mer_id);
	    map.put("version",version);
	    return map;
	}
	
	
	/**
	 * 从请求中获取响应，并将响应中到的结果解析出来，以Map<String,String>的形式返回。
	 * @param requestURL  请求地址
	 * @return
	 * @throws ReqDataException 
	 */
	@SuppressWarnings("unchecked")
	protected Map<String,String> analyseResponseResult(String requestURL) throws ReqDataException {
		//发起请求，获取响应
		String responseStr = HttpClientUtil.sendGetRequest(requestURL);		
		try {
			Map<String,String> retMsg = Plat2Mer_v40.getResData(responseStr);
			//log.info("返回结果解析，Start....");
			for (String key : retMsg.keySet()) {
				//log.info(key+" : "+retMsg.get(key));
			}
			//log.info("返回结果解析，End....");
			return retMsg;
		} catch (RetDataException e) {
			 log.error("analyseResponseResult",e);
			throw new ReqDataException(e.getMessage());
		}
	}
	
}
