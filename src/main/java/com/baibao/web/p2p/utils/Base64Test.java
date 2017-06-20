
package com.baibao.web.p2p.utils;




import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.cache.utils.JedisUtil;

import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  
  
public class Base64Test   
{  
	private static Logger logger = LoggerFactory.getLogger(Base64Test.class);

    public static void main(String[] args)  
    {  
        //String strImg = GetImageStr();
    	String strImg = "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";
        System.out.println(strImg);  
        GenerateImage(strImg);  
    }  
    //图片转化成base64字符串  
    public static String GetImageStr()  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = "d://test.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
        	 logger.error("GetImageStr",e);  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
      
    //base64字符串转化成图片  
    public static boolean GenerateImage(String imgStr)  
    {   //对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
               }  
                }  
            //生成jpeg图片  
            String imgFilePath = "d://222.jpg";//新生成的图片  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
        	 logger.error("GenerateImage",e);
            return false;  
            
        }  
    }  
}
