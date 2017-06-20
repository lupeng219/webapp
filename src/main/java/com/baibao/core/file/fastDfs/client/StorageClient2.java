package com.baibao.core.file.fastDfs.client;

import org.csource.fastdfs.StorageClient1;

import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerServer;
/**
 * Subclass of org.csource.fastdfs.StorageClient1.
 */
public class StorageClient2 extends StorageClient1 {
	// ----------------------------------------------------------------- Constructors
	public StorageClient2(){
		super();
	}
	
	public StorageClient2(TrackerServer trackerServer, StorageServer storageServer){
		super(trackerServer, storageServer);
	}
	
	/**
	 * Returns the trackerServer that the storageClient connect with, for the sake of operating the trackerServer connection,eg:trackerServer.close();
	 */
	public TrackerServer getTrackerServer(){
		return trackerServer;
	}
}
