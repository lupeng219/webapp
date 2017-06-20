package com.baibao.core.file.fastDfs.client;



public class FSException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5553395975535617883L;
	
	private String code;
	private Object[] params;
	
	public FSException(String code){
		//super(SpringContextUtil.getMessage(code));
		this.code = code;
	}
	
	public FSException(String code, Object[] params){
		//super(SpringContextUtil.getMessage(code, params));
		this.code = code;
		this.params = params;
	}
	
	public FSException(Throwable e) {
		super(e);
	}
	
	public FSException(String code, Throwable cause) {
		//super(SpringContextUtil.getMessage(code), cause);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
	
}
