package com.baibao.core.exception;
/**
 * <p>版权所有：(C)2013-2018 中融佰诚</p>
 * @时间：2015-5-29
 * @描述：错误码枚举类
 */
public enum ErrorCode {

	DB_OPERATE_ERROR(1101,"数据库操作异常");
	
	private ErrorCode(Integer errorCode, String message){
		this.errorCode = errorCode;
		this.message = message;
	};
	private ErrorCode(Integer errorCode){
		this.errorCode = errorCode;
	};
	private Integer errorCode;
	private String message;
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
