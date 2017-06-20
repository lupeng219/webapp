package com.baibao.core.file.fastDfs.client;

import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 抽象的对象池，提供对象池的一些基本操作
 *
 */
public abstract class GenericPool<T> {
	
	private static final Logger logger =  LoggerFactory.getLogger(GenericPool.class);
	
	@SuppressWarnings("rawtypes")
	protected GenericObjectPool innerPool = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public GenericPool(GenericObjectPool.Config poolConfig, PoolableObjectFactory factory) {
        this.innerPool = new GenericObjectPool(factory, poolConfig);
    }
	/**
	 * get an object from the innerPool.
	 */
    @SuppressWarnings("unchecked")
    public T getResource() {
        try {
            return (T) innerPool.borrowObject();
        } catch (Exception e) {
        	logger.error("getResource", e);
            throw new FdfsException(FSErrorCode.FILE_FDFS_GET_RESOURCE_FORM_POOL_ERROR, e);
        }
    }

	/**
	 * Returns the specified object to the underlying innerPool.
	 */
    @SuppressWarnings("unchecked")
	public void releaseResource(final T resource) {
        try {
            innerPool.returnObject(resource);
        } catch (Exception e) {
        	logger.error("releaseResource", e);
            throw new FdfsException(FSErrorCode.FILE_FDFS_RETURN_RESOURCE2POOL_ERROR, e);
        }
    }
    
    /**
     * Destroy the broken connection 
     */
	@SuppressWarnings("unchecked")
	public void destroyResource(final T resource) {
        try {
            innerPool.invalidateObject(resource);
        } catch (Exception e) {
        	logger.error("destroyResource", e);
            throw new FdfsException(FSErrorCode.FILE_FDFS_INVALIDATE_RESOURCE_ERROR, e);
        }
    }
    
    /**
     * Closing the Pool 
     */
    public void destroy() {
		logger.debug("Closing Pool");
        try {
            innerPool.close();
        } catch (Exception e) {
        	logger.error("destroy", e);
            throw new FdfsException(FSErrorCode.FILE_FDFS_DESTROY_POOL_ERROR, e);
        }
    }

}
