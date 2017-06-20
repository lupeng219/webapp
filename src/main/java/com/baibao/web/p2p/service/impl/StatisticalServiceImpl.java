package com.baibao.web.p2p.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.generator.dao.P2p_visitors_infoMapper;
import com.baibao.web.p2p.service.StatisticalService;
@Service("statisticalService")
public class StatisticalServiceImpl
	implements StatisticalService
{
    private static final Logger log =
    	LoggerFactory.getLogger(StatisticalServiceImpl.class);
	
	@Autowired
	private P2p_visitors_infoMapper visitorsInfoDao;
	
	@Override
	@Transactional
	public void saveVisitorsInfo(
		String ip, String accessResource,
		String accessFrom, String user_agent,
		String custNo, String data)
	{
		log.info("###########进入saveVisitorsInfo 方法");
		
		String country = "";
	    String area = "";
	    String region = "";
	    String city = "";
	    String county = "";
	    String isp = "";
	    
	    boolean formAlibaba = true;
		//查询本地库ip信息
		Map<String, Object> ipinfo =
			visitorsInfoDao.selectIpInfo(ip);
		
		if (null != ipinfo)
		{
			country =(String) ipinfo.get("country");
			area =(String) ipinfo.get("area");
			region =(String) ipinfo.get("region");
			city =(String) ipinfo.get("city");
			county =(String) ipinfo.get("county");
			isp =(String) ipinfo.get("isp");
		} else
		{	 
			String response = "";
			JSONObject json = null;
			
			try
			{
				formAlibaba = true;
				response = getIpDetailInfo(
					ip, user_agent,
					"http://ip.taobao.com/service/getIpInfo.php?ip=");
				log.info("###########淘宝解析ip返回信息###[ "+response+" ]");
			} catch(Exception e)
			{
				try
				{
					formAlibaba = false;
					response = getIpDetailInfo(
						ip, user_agent,
						"http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=");
					log.info("###########新浪解析ip返回信息###[ "+response+" ]");
				} catch(Exception e1)
				{
					log.error("############请求新浪解析ip发生异常", e1);
				}
			}
			 
			json = JSON.parseObject(response);
			log.info(json.toString());

			if (!dealResult(formAlibaba, json))
			{
				try
				{
					formAlibaba = false;
					response = getIpDetailInfo(
						ip, user_agent,
						"http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=");
					log.info("###########新浪解析ip返回信息###[ "+response+" ]");
				} catch(Exception e)
				{
					log.error("############请求新浪解析ip发生异常", e);
				}
			}
			log.info("#######formAlibaba："+formAlibaba);
			
			if (formAlibaba)
			{	 
				 JSONObject o = json.getJSONObject("data");
				 log.info("#######data："+o);
				 country = (String)( o.get("country") == null ? "" : o.get("country") );
				 area = (String)( o.get("area") == null ? "" : o.get("area") );
				 region = (String)( o.get("region") == null ? "" : o.get("region") );
				 city = (String)( o.get("city") == null ? "" : o.get("city") );
				 county = (String)( o.get("county") == null ? "" : o.get("county") );
				 isp = (String)( o.get("isp") == null ? "" : o.get("isp") );
				 log.info("淘宝解析后的region: "+region);
			 } else
			 {	 
				 country = (String)( json.get("country") == null ? "" : json.get("country") );
				 area = (String)( json.get("area") == null ? "" : json.get("area") );
				 region = (String)( json.get("region") == null ? "" : json.get("province") );
				 city = (String)( json.get("city") == null ? "" : json.get("city") );
				 county = (String)( json.get("county") == null ? "" : json.get("county") );
				 isp = (String)( json.get("isp") == null ? "" : json.get("isp") );
				 log.info("新浪解析后的region："+region);
			 }
		}

		log.info("入库region：" + region);
	    String visitTime =
	    	DateUtils.getDateToString(new Date());

	    Map<String, Object> param =
	    	new HashMap<String, Object>();

	    param.put("ip", ip);
	    param.put("accessResource", accessResource);
	    param.put("accessFrom", accessFrom);
	    param.put("accessTime", visitTime);
	    param.put("country", country);
	    param.put("areas", area);
	    param.put("region", region);
	    param.put("city", city);
	    param.put("county", county); 
	    param.put("isp", isp);
	    param.put("custNo", custNo);
	    param.put("data", data);

	    visitorsInfoDao.insertP2p_visitors_info(param);
	}
	
	private boolean dealResult(boolean isFromAlibaba,JSONObject json){
		if(isFromAlibaba){
			if(json.get("code")==null || (Integer)json.get("code")!=0 || json.get("data") == null || (json.get("data") instanceof String)){
				return false;
			}
			return true;
		}
		return true;
	}
	
	private String getIpDetailInfo(String ip,String user_agent,String requestUrl) throws Exception {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = requestUrl + ip;
            URL realUrl = new URL(urlNameString);
            
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
            		user_agent);
          
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	log.error("########请求地址"+requestUrl+"解析ip异常", e);
        	throw e;
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
            	 log.error("getIpDetailInfo",e2);
            }
        }
        return result;
    }

	@Override
	public void updateIpInfo(String ip) {
		log.info("###########进入updateIpInfo 方法");
		String country = "";
	    String area = "";
	    String region = "";
	    String city = "";
	    String county = "";
	    String isp = "";
	    
			 
			 String response = "";
			 JSONObject json = null;
			 try {
				response = getIpDetailInfo(ip,"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)","http://ip.taobao.com/service/getIpInfo.php?ip=");
				log.info("###########淘宝解析ip返回信息###[ "+response+" ]");
				json = JSON.parseObject(response);
				JSONObject o = json.getJSONObject("data");
				log.info("#######data："+o);
				country = (String)( o.get("country") == null ? "" : o.get("country") );
				area = (String)( o.get("area") == null ? "" : o.get("area") );
				region = (String)( o.get("region") == null ? "" : o.get("region") );
				city = (String)( o.get("city") == null ? "" : o.get("city") );
				county = (String)( o.get("county") == null ? "" : o.get("county") );
				isp = (String)( o.get("isp") == null ? "" : o.get("isp") );
				log.info("淘宝解析后的region: "+region);
			    log.info("入库region："+region);
		    
			    Map<String, Object> param = new HashMap<String, Object>();
			    param.put("ip", ip);
			    param.put("country", country);
			    param.put("areas", area);
			    param.put("region", region);
			    param.put("city", city);
			    param.put("county", county); 
			    param.put("isp", isp); 
		    
			    visitorsInfoDao.updateP2p_visitors_info(param);
			} catch (Exception e) {
				log.error("淘宝解析ip异常", e);
			}
		
	}

	@Override
	public List<Map<String, Object>> selectIpForDeal() {
		return visitorsInfoDao.selectIpForDeal();
	}
	
//	public static void main(String[] args) {
//	JSONObject json = JSON.parseObject("{\"code\":0,\"data\":{\"country\":\"\u4e2d\u56fd\",\"country_id\":\"CN\",\"area\":\"\u534e\u4e1c\",\"area_id\":\"300000\",\"region\":\"\u6d59\u6c5f\u7701\",\"region_id\":\"330000\",\"city\":\"\u676d\u5dde\u5e02\",\"city_id\":\"330100\",\"county\":\"\",\"county_id\":\"-1\",\"isp\":\"\u7535\u4fe1\",\"isp_id\":\"100017\",\"ip\":\"183.156.66.163\"}}");
//	dealResult(true, json);
//}
}
