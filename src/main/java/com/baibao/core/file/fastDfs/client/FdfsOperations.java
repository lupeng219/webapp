package com.baibao.core.file.fastDfs.client;




/**
 * FastDFS一些基本操作
 * @author wanggl
 */
public interface FdfsOperations {
	/**
	 * Execute the action specified by the given action object
	 * @param action callback object that specifies the Fdfs action
	 * @return a result object returned by the action, or <code>null</code>
	 * @throws FdfsException in case of Fdfs errors
	 */
	<T> T execute(FdfsCallback<T> action) throws FdfsException;
}
