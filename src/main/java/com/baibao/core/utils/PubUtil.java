package com.baibao.core.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.util.StringUtils;



public class PubUtil
{
	
	/**
	 * 把服务器目录写入到临时文件中
	 * @param imgName
	 * @return
	 * @throws IOException
	 */
	public static String readImage(String imgName,String userName)
	{

		return "";
	}
	
	/**
	 * 按手机号中间4位替换为*
	 * @param mobile
	 * @return
	 */
	public static String getRuleMobile(String mobile)
	{
		if(mobile.indexOf("-") == -1 && mobile.length() == 11)
		//括号表示  组   被替换的部分   $n 表示  第n组的内容
			return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		else
			return mobile.substring(0,mobile.length() - 4) + "****";
	}
	
	/**
	 * 隐藏邮箱中的字符串
	 * @param mail
	 * @return
	 */
	public static String getRuleEmail(String mail)
	{
		if(StringUtils.hasText(mail))
		{
			return "";
		}
		return mail.substring(0, 5) + "****" + mail.substring(mail.indexOf("@"));
	}
	
	/**
	 * 隐藏身份证中间10位
	 * @param card
	 * @return
	 */
	public static String getRuleCard(String card)
	{
		//括号表示  组   被替换的部分   $n 表示  第n组的内容
		if(card.length() == 15)
		{
			return card.replaceAll("(\\d{4})\\d{7}(\\w{4})", "$1*$2");
		}
		else
		{
			return card.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1****$2");
		}
		
	}

	/**
	 * 字符串编码
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encodeStr(String str) throws UnsupportedEncodingException
	{
		return URLEncoder.encode(URLEncoder.encode(str,"UTF-8"),"UTF-8");
	}

	/**
	 * @param key 说明，如”BorrowType“，所有值参考LoadConfigServlet类中的Class[] clazz数组
	 * @param id  需要对比的值，只能是int或者string
	 * @return 返回一个实体，实际运用过程中要把返回的值强转一下。
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
//	public static Object getObject(String key,Object id) throws Exception
//	{
//		List<Object> list = (List<Object>)Global.get(key + "s");
//		return getObject(list ,id);
//	}
	

	/**
	 * 根据id取到list中的对象
	 * @param list
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Object getObject(List list,Object id) throws Exception
	{
		for (Object obj : list)
		{
			if(obj instanceof HashMap)
			{
				Method method = HashMap.class.getDeclaredMethod("get", new Class[]{Object.class} );
				Object tempid =  method.invoke(obj, "id");
				if(id instanceof Integer)
				{
					if((Integer)tempid == (Integer) id)
					{
						return obj;
					}
				}
				else 
				{
					if(String.valueOf(tempid).equals(String.valueOf(id)))
					{
						return obj;
					}
				}
			}
			else
			{
				Field field = obj.getClass().getDeclaredField("id");
				field.setAccessible(true);
				if(id instanceof Integer)
				{
					if( (Integer)field.get(obj) == (Integer) id )
					{
						return obj;
					}
				}
				else 
				{
					if(String.valueOf(field.get(obj)).equals(String.valueOf(id)))
					{
						return obj;
					}
				}
			}
		}
		return null;
	}
	public static Object getObject(Map map,Object id) throws Exception
	{
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext())
		{
			Map.Entry entity =  (Map.Entry) iterator.next();
			Object key = entity.getKey();
			Object value = entity.getValue();
			if(value instanceof String)
			{
				if(String.valueOf(key).equals(String.valueOf(id)))
				{
					return entity;
				}
			}
			else if(value instanceof Map)
			{
				Iterator it = ((Map)value).entrySet().iterator();
				while (it.hasNext())
				{
					Map.Entry entity2 =  (Map.Entry) it.next();
					if(String.valueOf(entity2.getKey()).equals(String.valueOf(id)))
					{
						return entity2;
					}
				}
			}
			else
			{
				Field field = value.getClass().getDeclaredField("id");
				field.setAccessible(true);
				if(id instanceof Integer)
				{
					if((Integer)field.get(value) == (Integer) id)
					{
						return value;
					}
				}
				else 
				{
					if(String.valueOf(field.get(value)).equals(String.valueOf(id)))
					{
						return value;
					}
				}
			}
		}
		return null;
	}
	
	
	
	
	public static String getBasePath(HttpServletRequest request)
	{
		String port = "";
		if (System.getProperty("os.name").toLowerCase().startsWith("win"))
		{
			port += ":";
			port += request.getServerPort();
		}
		String basePath = request.getScheme() + "://" + request.getServerName() + port
		+ request.getContextPath() + "/";
		
		return basePath;
	}
	public static void main(String[] args) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException, IOException
	{
//		System.out.println(((BorrowType)getObject("BorrowType", 10)).getBorrowTypeName());
//		System.out.println(getObjName("City", "652800"));/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
		System.out.println(!StringUtils.hasText(null));
		System.out.println("ROLE_LENDER".contains("ROLE_LENDER"));
		String mail = "c@163.com";
		System.out.println(mail.substring(0, 5) + "****" + mail.substring(mail.indexOf("@")));
		
	}
	
	/**
	 * 枚举类必须定义在com.buc.base.包下
	 * 根据code得到枚举
	 * @param enumStr	枚举字符串，
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static Object getEnum(String enumStr,String code) throws Exception
	{
		Class clazz = Class.forName("com.buc.base." + enumStr);
		Object[] objects = clazz.getEnumConstants();
		for (int i = 0; i < objects.length; i++)
		{
			Field[] fields = objects[i].getClass().getDeclaredFields();
			for (int j = 0; j < fields.length; j++)
			{
				fields[j].setAccessible(true);
				if(code.equals(fields[j].get(objects[i]) + ""))
				{
					return objects[i];
				}
				
			}
			
		}
		return null;
	}
	
	/**
	 * 根据code得到枚举名称
	 * @param enumStr
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String getEnumName(String enumStr,String code) throws Exception
	{
		Object obj = getEnum(enumStr, code);
		Field[] fileds = obj.getClass().getDeclaredFields();
		for (int i = 0; i < fileds.length; i++)
		{
			if(fileds[i].getName().contains("Mome"))
			{
				fileds[i].setAccessible(true);
				return (String) fileds[i].get(obj);
			}
		}
		
		return "";
	}
}
