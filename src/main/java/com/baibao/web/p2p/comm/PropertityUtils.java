package com.baibao.web.p2p.comm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertityUtils {
	private static Logger logger = LoggerFactory.getLogger(PropertityUtils.class); 
	
	public static String getPropertityValue( String filename, String propertityName ){
		String result = null;
		Properties prop = new Properties();
		InputStream in = PropertityUtils.class.getResourceAsStream( "/" + filename + ".properties" );
		try {
			prop.load(in);
			result = prop.getProperty( propertityName, "" );
			
			
		}
		catch (Exception e) {
			logger.error("getPropertityValue", e);
		}
		finally{
			if( in != null ){
				try {
					in.close();
				} catch (IOException e) {
					logger.error("getPropertityValue", e);
				}
			}
		}
		
		return result;
		
	}
	
	public static void setPropertityValue( String filename, String propertityName, String value ){
		Properties prop = new Properties();
		
		URL propUrl = PropertityUtils.class.getResource( "/" + filename + ".properties" );
		
		if( propUrl != null ){
			File file = new File( propUrl.getPath() );		
			
			if( file.exists() ){
				FileInputStream fis = null; 
				FileOutputStream fos = null;
				try {
					fis = new FileInputStream( file );			
					prop.load(fis);
					prop.setProperty( propertityName, value );
					if( fis != null ){
						try {
							fis.close();
						} catch (IOException e) {
							logger.error("setPropertityValue", e);
						}
					}
					fos = new FileOutputStream( file );
					prop.store( fos, "" );
				}
				catch (Exception e) {	
					logger.error("setPropertityValue", e);
				}
				finally{
					if( fos != null ){
						try {
							fos.close();
						} catch (IOException e) {
							logger.error("setPropertityValue", e);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		PropertityUtils.setPropertityValue( "notifyList", "test", "123" );
		String a=PropertityUtils.getPropertityValue("system/system", "bbjf.userLogoUrl");
		System.out.print(a);
	}
}
