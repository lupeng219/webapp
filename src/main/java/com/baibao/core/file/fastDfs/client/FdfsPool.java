package com.baibao.core.file.fastDfs.client;

import org.apache.commons.pool.PoolableObjectFactory;

/**
 * FastDFS client-tracker 连接池
 * @author wanggl
 */
public class FdfsPool extends GenericPool<StorageClient2> {
	
	// ----------------------------------------------------------------Constructors
	public FdfsPool() {
		this(new FdfsPoolConfig(), new FdfsPoolableObjectFactory());
	}
	
	public FdfsPool(FdfsPoolConfig poolConfig) {
		this(poolConfig, new FdfsPoolableObjectFactory());
	}
	
	@SuppressWarnings("rawtypes")
	public FdfsPool(FdfsPoolConfig poolConfig, PoolableObjectFactory factory) {
		super(poolConfig, factory);
	}
}
