package com.baibao.core.exception;

/**
 * <p>
 * 版权所有：(C)2013-2018 中融佰诚
 * </p>
 * @时间：2015-5-29
 * @描述：持久化异常类
 */
public class PersistentDataException extends RuntimeException {

	private static final long serialVersionUID = 9116432900703019523L;

	private ErrorCode errorCode;

	public PersistentDataException() {
		super();
	}

	public PersistentDataException(ErrorCode errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}
