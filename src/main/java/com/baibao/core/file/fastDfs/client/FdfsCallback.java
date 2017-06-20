package com.baibao.core.file.fastDfs.client;




/**
 * FastDFS回调函数
 * @author wanggl
 */
public interface FdfsCallback<T> {

	T doInFdfs(StorageClient2 conn) throws FdfsException;
}
