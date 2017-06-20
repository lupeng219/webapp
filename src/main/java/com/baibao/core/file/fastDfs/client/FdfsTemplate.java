package com.baibao.core.file.fastDfs.client;




/**
 * FastDFS Helper
 */
public class FdfsTemplate implements FdfsOperations{
	
	// ----------------------------------------------------- Instance Variables
	/**
	 * The pool used to pool StorageClient2 objects
	 */
	private static FdfsPool pool = new FdfsPool();
	
	// --------------------------------------------------------- Constructor
	/**
	 * Create a new FdfsTemplate instance. 
	 */
	public FdfsTemplate() {
		//NOOP
	}
	
	/**
	 * Execute the action by the given action object
	 */
	public <T> T execute(FdfsCallback<T> action) throws FdfsException {
		StorageClient2 client = null;
		try{
			client = pool.getResource();
			T result = action.doInFdfs(client);
			return result;
		}finally {
			if(client != null){
				pool.releaseResource(client);
			}
		}
	}
}
