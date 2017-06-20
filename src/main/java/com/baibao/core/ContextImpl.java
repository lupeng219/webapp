package com.baibao.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;



/**
 * 交易计算，上下文内容
 *
 */
public class ContextImpl implements Context , Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean isForBid;
	private String errorMsg;

	private Map<String, Object> data = new HashMap<String, Object>();
	public Object getData(String key) {
		return data.get(key);
	}

	public Map<String, Object> getAllDataMap() {
		return data;
	}

	public void setParam(String key, Object value) {
		data.put(key, value);
		
	}


	@Override
	public String getString(String key) {
		Object str = data.get(key);
		if(str != null){
			return (String)str;
		}
		return null;
	}

	@Override
	public Double getDouble(String key) {
		Object str = data.get(key);
		if(str != null){
			return (Double)str;
		}
		return null;
	}

	@Override
	public Long getLong(String key) {
		Object str = data.get(key);
		if(str != null){
			return (Long)str;
		}
		return null;
	}

	@Override
	public void setMessage(String errorMsg) {
		this.errorMsg = errorMsg;
		
	}

	@Override
	public Boolean isForbid() {
		
		return isForBid;
	}

	@Override
	public void isForBid(Boolean forBig) {
		this.isForBid = forBig;
		
	}

	public static void main(String agrs[])
	{
		System.out.println( StringUtils.isBlank( "1 " ) );
	}

	@Override
	public void putAll(Map<String, Object> map) {
		
		for (Map.Entry<String, Object> entry : map.entrySet())
		{
			 //System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
			setParam( entry.getKey(), entry.getValue());
		}
	}
}
