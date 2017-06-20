package com.baibao.core.file.fastDfs.client;


/**
 * 
 *
 */
public class FdfsException extends FSException {

	private static final long serialVersionUID = 1L;
	
	public FdfsException(String code) {
		super(code);
	}
	
	public FdfsException(String code, Object[] params) {
		super(code, params);
	}
	
	public FdfsException(Throwable e) {
		super(e);
	}
	
	public FdfsException(String code, Throwable cause) {
		super(code, cause);
	}
}
