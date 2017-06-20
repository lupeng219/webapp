package com.baibao.core.file.fastDfs.client;
public interface FSErrorCode {

	/**
	 * 系统错误，切片获取参数名称失败
	 */
	public static final String SYSTEM_ASPECT_PARAMETER_NAME = "990001";
	
	/**
	 * 文件不存在
	 */
	public static final String FILE_NOT_EXIST = "010001";

	/**
	 * 不支持的转换
	 */
	public static final String FILE_CONVERT_NOT_SUPPORT = "010002";

	/**
	 * 不支持的文件类型
	 */
	public static final String FILE_TYPE_NOT_SUPPORT = "010003";

	/**
	 * 不支持为此文件类型生成缩略图
	 */
	public static final String FILE_THUMBNAILS_NOT_SUPPORT = "010004";
	
	/**
	 * 连接池中操作出错
	 */
	public static final String FILE_FDFS_GET_RESOURCE_FORM_POOL_ERROR = "010005";
	public static final String FILE_FDFS_RETURN_RESOURCE2POOL_ERROR = "010006";
	public static final String FILE_FDFS_INVALIDATE_RESOURCE_ERROR = "010007";
	public static final String FILE_FDFS_DESTROY_POOL_ERROR = "010008";
	/**
	 * 上传、下载、删除服务器上的文件出错
	 */
	public static final String FILE_FDFS_UPLOAD_ERROR = "010009";
	public static final String FILE_FDFS_DOWNLOAD_ERROR = "010010";
	public static final String FILE_FDFS_DELETE_ERROR = "010011";
	/**
	 * 获取服务器上文件信息出错
	 */
	public static final String FILE_FDFS_GETINFO_ERROR = "010012";
	
	
}
