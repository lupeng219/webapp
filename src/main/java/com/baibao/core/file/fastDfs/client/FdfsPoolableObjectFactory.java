package com.baibao.core.file.fastDfs.client;

import java.io.IOException;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PoolableObjectFactory custom impl.
 */
public class FdfsPoolableObjectFactory extends BasePoolableObjectFactory<StorageClient2> {
	// ----------------------------------------------------------- Static Variables
	/**
	 * The logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FdfsPoolableObjectFactory.class);
	
    // ----------------------------------------------------------- Constructors
	public FdfsPoolableObjectFactory() {
		super();
	}
	
	// ----------------------------------------------------------- Pool invoke Methods
	/**
	 * Creates an instance that can be served by the pool.
	 * Instances returned from this method should be in the
	 * same state as if they had been.
	 */
	@Override
	public StorageClient2 makeObject() throws Exception {
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = null;
		try {
			trackerServer = trackerClient.getConnection();
		} catch (IOException e) {
			logger.warn("FastDFS create the connection throws IO error, 'trackerServer=null' for fail");
			logger.error("makeObject", e);
		}
		StorageClient2 client = new StorageClient2(trackerServer, null);
		return client;
	}
	
	/**
	 * Destroys an instance no longer needed by the pool.
	 */
	@Override
	public void destroyObject(StorageClient2 client) throws Exception  {
		logger.debug("FastDFS destroy the Storage-Tracker connection");
		if(client != null ){
			TrackerServer server = client.getTrackerServer();
			if( null != server){
				try {
					server.close();
				} catch (IOException e) {
					logger.warn("FastDFS destroy the connection throws IO error");
					logger.error("destroyObject", e);
				}
			}
			server = null;
		}
	}
}
