package com.baibao.core.comm.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.MessageConstraints;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.cache.LoadSystemConfigServlet;


public class HttpClient {
	private static Logger log = LoggerFactory.getLogger(HttpClient.class); 
	
	public static PoolingHttpClientConnectionManager poolConnManager ;
	public static CloseableHttpClient httpClient ;
	static
    {  
         try {  
            SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(null,  
                            new TrustSelfSignedStrategy())  
                    .build();  
            //HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;  
            //SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext,hostnameVerifier);  
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext);  
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()  
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslsf).build();  
            poolConnManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);  
            // Increase max total connection to 200  
            poolConnManager.setMaxTotal( 200 );  
            // Increase default max connection per route to 20  
            poolConnManager.setDefaultMaxPerRoute( 20 );  
            
            SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).setSoTimeout( 6000 ).build();  
            poolConnManager.setDefaultSocketConfig(socketConfig);  
            
            
            MessageConstraints messageConstraints = MessageConstraints.custom()
                    .setMaxHeaderCount(300)
                    .setMaxLineLength(4000)
                    .build();
            // Create connection configuration
            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8)
                .setMessageConstraints(messageConstraints)
                .build();
            poolConnManager.setDefaultConnectionConfig(connectionConfig);
            
            
            poolConnManager.setValidateAfterInactivity(1000);
            
            RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(10000).setConnectTimeout(11000).setSocketTimeout(12000).build();  
            httpClient = HttpClients.custom().setConnectionManager(poolConnManager).setDefaultRequestConfig(requestConfig).build();  
        } catch (Exception e) {  
            log.error("InterfacePhpUtilManager init Exception", e);  
        }  
    }  
    public static CloseableHttpClient getConnection()  
    {  
        return httpClient;  
    }  
    public String post(String url, String jsonStr)  
    {  
        String returnStr = null;  
        //参数检测  
        if(url==null||"".equals(url))  
        {  
            return returnStr;  
        }  
        HttpPost httpPost = new HttpPost(url);
        try {  
              
            long currentTime=System.currentTimeMillis();  
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();  
            nvps.add(new BasicNameValuePair("jsonstr", jsonStr));  
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));  
            CloseableHttpResponse response = httpClient.execute(httpPost);  
            int status = response.getStatusLine().getStatusCode();  
            if (status >= 200 && status < 300) {  
                HttpEntity entity = response.getEntity();  
                String resopnse="";  
                if(entity != null)  
                {  
                    resopnse=EntityUtils.toString(entity,"utf-8");  
                }  
                System.out.println(currentTime+" 接收响应：url"+url+" status="+status);  
                return entity != null ? resopnse : null;  
            } else {  
                HttpEntity entity = response.getEntity();  
                httpPost.abort();  
                System.out.println(currentTime+" 接收响应：url"+url+" status="+status+" resopnse="+EntityUtils.toString(entity,"utf-8"));  
                throw new ClientProtocolException("Unexpected response status: " + status);  
            }  
        } catch (Exception e) {  
            httpPost.abort();  
              
            log.error("post", e);
        }   
        return returnStr;  
    }  
    public static String postSina(String url, String jsonStr)  
    {  
        String returnStr = null;  
        //参数检测  
        if(url==null||"".equals(url))  
        {  
            return returnStr;  
        }  
        HttpPost httpPost = new HttpPost(url);  
        CloseableHttpResponse response = null;
        try {  
            
            StringEntity stringEntity = new StringEntity( jsonStr, "UTF-8" );
            stringEntity.setContentType( "application/x-www-form-urlencoded" );
            
            httpPost.setEntity(stringEntity);  
            response = getConnection().execute(httpPost);  
            
            int status = response.getStatusLine().getStatusCode();  
            if (status >= 200 && status < 300) {  
                HttpEntity entity = response.getEntity();  
                String resopnse="";  
                if(entity != null)  
                {  
                    resopnse=EntityUtils.toString(entity,"utf-8");  
                }  
                System.out.println(" 接收响应：url"+url+" status="+status);  
                System.out.println(URLDecoder.decode(resopnse, "UTF-8"));  
                return entity != null ? resopnse : null;  
            } else {  
                HttpEntity entity = response.getEntity();  
                httpPost.abort();  
                System.out.println(" 接收响应：url"+url+" status="+status+" resopnse="+EntityUtils.toString(entity,"utf-8"));  
                throw new ClientProtocolException("Unexpected response status: " + status);  
            }  
        } catch (Exception e) {  
            
            log.error("postSina",e);
        }finally{
        	httpPost.abort();  
        	if( response != null )
        	{
        		EntityUtils.consumeQuietly( response.getEntity() );
        	}
        }
        return returnStr;  
    }  
    
   public static void main(String agrs[]) throws UnsupportedEncodingException, Exception
   {
//	   String data = Data.sign();//"_input_charset=UTF-8&account_type=SAVING_POT&amount=100&identity_id=987654321&identity_type=UID&out_trade_no=2014000000000000001&partner_id=200004135630&pay_method=quick_pay%255E100%255ECMB%252CpKQ8mSGyZLoXOwv%252BMHRps2VHNr1rqbm4gMdlCMrO3FaAFaRMsABOkJ8kOvxX92MiZZPVdK8Y0Zp3CdooIB4Z1r1zKjKVGCaLFhJnSejI6%252BiQsmEmgU3KFZc1QZFpP0MXXrFHKF3BWgbu1Z%252B2uinZPCYNXnRJx3ZWsu2m%252F4Robck%253D%252CMRZ8zIgTpnV7V0vj%252BaLshk4i6SuVFHT5jBdLn4QWjnW%252F%252Bb%252BWTrdCt2GCq%252BvTsPPKx6sZGiP8OJaUFPFR3zUJiQupvWO0dY1FhU2PAeqZhROrIUYsEPrq3ZskTR2b6K%252BfvjOOSUt5nAYWXX6v%252FSLvlEWobvCS8ncN0sGpU8yAuIM%253D%252CDEBIT%252CC%252CIC%252Ct%252Bcj9xfPdFSa83gaK8AwO%252Bt%252BEAvMdvlTZIE8RVZiHr5250oW2rqPZysEBBPp%252BqToOV42i%252F%252FX0OySXULBfMR1wCSmbYVnjrsQFfNmcAYbOggeoHryA1Jg3WWT7xm47xp4oj3CvyLuixtLXAtx83w%252F8oo%252BNfrpgdm0cZua5B%252BKW2k%253D%252Ctv4neTBW23fZ7ykNYIYJAgotaaQ3ZZ7oz1QwsETqOV0QtSPHzEBrrRHKGEGjw4tI4kzjEGRh0U%252BK%252B6nX6V3H%252F1HuDMbiFn2U3t%252FR7AQScWAOck9xo2PQGlRMhF1YDOTfBScALjGydsX61nyey2yIEi7qomM8p6PiQakYbs2onTw%253D%252C%252C%252C%25E5%258C%2597%25E4%25BA%25AC%252C%25E5%258C%2597%25E4%25BA%25AC&request_time=20160120085833&service=create_hosting_deposit&sign=6a08212d9c1d25527ef9fb34534923ef&sign_type=MD5&sign_version=1.0&summary=SAVING_POT&user_fee=0.00&version=1.0";
//	  for(int i=0;i<=100;i++)
//	  {
//		  postSina("https://testgate.pay.sina.com.cn/mas/gateway.do",data);
//	  }
	  
   }
   
}
