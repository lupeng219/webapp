package com.baibao.core.cache;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baibao.core.exception.BusinessException;


public class LoadSystemConfigServlet extends HttpServlet{

	private static Logger log = LoggerFactory.getLogger(LoadSystemConfigServlet.class); 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		
		//ServletContext application=config.getServletContext();
		//String dbrealpath=application.getRealPath("/WEB-INF/classes/config/xmlproperties/settings.xml");
	
		//String settings = this.getClass().getClassLoader().getResource("/").getPath()+config.getInitParameter("settings");
		SAXReader reader = new SAXReader(); 
		InputStream in = null;
		Document document = null; 
		InputStreamReader in2 = null;
		try {
			//in = new FileInputStream(new File( settings ));
			in2 = new InputStreamReader(LoadSystemConfigServlet.class.getClassLoader().getResourceAsStream("config/xmlproperties/settings.xml"), "utf-8");
			
			document = reader.read(in2); 
            //获取文档的根元素 
            Element root = document.getRootElement(); 
            HashMap<String, Object> map = new HashMap<String, Object>();
            //System.out.println( doGetCategoryElementListMapData(root,map) );
            SystemConfigCache.systemMap = doGetCategoryElementListMapData(root,map);
		} catch (FileNotFoundException e) {
			
			log.error( ">>>>读取settings文件失败,请检查文件格式或者路径是否正确", e);
			e.printStackTrace();
		} catch (Exception e) {
			log.error("init", e);
			
		}finally{
			IOUtils.closeQuietly( in2 );
		}
	}
	/**
	* 获取集合
	* @param root
	* @param name
	* @return
	* @throws Exception
	*/
	public static HashMap<String, Object> doGetCategoryElementListMapData( Element root ,HashMap<String, Object> map  )throws Exception{
			Iterator<?> iter = root.elementIterator();
			while( iter.hasNext() )
			{
				Element element = (Element) iter.next();
				
				String ename  = element.getName().trim();
				String id  = element.attributeValue("id");
				String value  = element.getTextTrim();
				
				try{
					if( ename.equalsIgnoreCase( "category" ) )
					{
						if( id == null || "".equals( id ))
						{
							log.debug( " >>>>> category id must be set " );
							throw new BusinessException(" >>>>> category id must be set ");
						}
						if( !map.containsKey( id )  )
						{
							HashMap<String, Object> submap = new HashMap<String, Object>();
							map.put( id, submap);
							map.put( id, doGetCategoryElementListMapData( element , submap ) );
						}else
						{
							log.debug( " >>>>> duplicate  category id " );
							throw new BusinessException(" >>>>> duplicate  category id ");
						}
					}else{
						if( !map.containsKey( ename ))
						{
							map.put( ename, value);
						}else
						{
							log.debug( " >>>>> duplicate element ename = " + ename );
							throw new BusinessException(" >>>>> duplicate element ename = " + ename );
						}
					}
				}catch(Exception e )
				{
					throw e;
				}
			}
		return map;
	}
}
