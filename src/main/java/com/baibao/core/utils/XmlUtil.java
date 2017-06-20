/**
 * 
 */
package com.baibao.core.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**  
 *  
 * @author bottle  
 */

public class XmlUtil {


	private static final String DEFAULT_ENCODING = "UTF-8";
	 /**
     * java 转换成xml
     * @Title: toXml
     * @param obj 对象实例
     * @return String xml字符串
	 * @throws JAXBException 
	 * @throws Exception 
     */
	public static String toXml(Object obj) throws JAXBException
	{
		return toXml(obj, DEFAULT_ENCODING);
	}
	/**
	 * java 转换成 xml
	 * @param obj 对象实例
	 * @param encoding 编码类型
	 * @return String xml字符串
	 * @throws JAXBException
	 */
    public static String toXml(Object obj,String encoding) throws JAXBException{
    	StringWriter writer=new StringWriter();
    	JAXBContext ctx=JAXBContext.newInstance(obj.getClass());
    	Marshaller marshaller=ctx.createMarshaller();
    	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
    	marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
    	marshaller.marshal(obj, writer);
    	return writer.toString();
    }
    
    
    /**
     *  将传入xml文本转换成Java对象
     * @Title: toBean
     * @Description: 
     * @param xmlStr
     * @param cls  xml对应的class类
     * @return T   xml对应的class类的实例对象
     *
     * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
     * @throws JAXBException 
     */
    public static <T> T  toBean(String xmlStr,Class<T> cls) throws JAXBException{
    	JAXBContext ctx=JAXBContext.newInstance(cls);
    	return (T) ctx.createUnmarshaller().unmarshal(new StringReader(xmlStr));
    } 
	
}

