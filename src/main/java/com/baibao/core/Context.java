package com.baibao.core;

import java.util.Map;

public interface Context {
	
	public Object getData(String key);
	
	public Map<String, Object> getAllDataMap();
		
	public void setParam(String key,Object entry);

	public void putAll(Map<String, Object> map);
	
	public String getString(String key);
	
	public Double getDouble(String key);
	
	public Long getLong(String key);
	
	public void setMessage(String errorMsg);
	
	public Boolean isForbid();
	
	public void isForBid(Boolean forBig);
}
