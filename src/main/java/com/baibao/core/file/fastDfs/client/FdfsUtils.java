package com.baibao.core.file.fastDfs.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.DownloadStream;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.UploadStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jodd.servlet.UrlEncoder;
import com.esotericsoftware.minlog.Log;

/**
 * General FastDFS manipulation utilities.
 */
public class FdfsUtils
{
	/**
	 * The logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(FdfsUtils.class);
	/**
	 * The seperator 
	 */
	private static final String FDFS_SEPERATOR = StorageClient2.SPLIT_GROUP_NAME_AND_FILENAME_SEPERATOR;
    /**
     * The inject fdfsTemplate
     */
    private static FdfsTemplate fdfsTemplate = new FdfsTemplate();

	/**
     * Instances should not be constructed in standard programming.
     */
    public FdfsUtils()
    {
        super();
    }
	
    /**
	 * Init the config of FastDFS client 
	 */
	static {
		initFdfs();
	}
    
	private static void initFdfs(){
		logger.debug("FastDFS init the config");
		final String FDFS_CONFIG_FILENAME = "fdfs_client.conf";
		String fileConfig = FDFS_CONFIG_FILENAME;
		try {
			fileConfig = FdfsUtils.class.getResource(FDFS_CONFIG_FILENAME).getPath();
			System.out.println( "fileConfig====" +fileConfig);
			ClientGlobal.init(URLDecoder.decode(fileConfig, "UTF-8"));// URLDecoder.decode()处理路径带空格
		} catch (FileNotFoundException e) {
			logger.error("FastDFS config error: not found the config file!", e);
			throw new FileNotExistException(FDFS_CONFIG_FILENAME);
		} catch (IOException e) {
			logger.error("FastDFS config error: config IO error!", e);
			
		} catch (Exception e) {
			
			
			logger.error("initFdfs", e);
		}
	}

    /**
     * Upload the file to the storage
     * @param file
     * @return
     * @throws FdfsException
     */
    public static String upload(final FdfsFile file) throws FdfsException {
    	return fdfsTemplate.execute(new FdfsCallback<String>() {
			public String doInFdfs(StorageClient2 conn) throws FdfsException {
				String[] parts = new String[2];
				InputStream inStream = file.getInputStream();
				try {
					parts = conn.upload_file(file.getGroup(), file.getSize(), new UploadStream(inStream, file.getSize()), file.getExt(), file.getMeta());
				} catch (IOException e) {
					logger.error("doInFdfs",e);
					throw new FdfsException(FSErrorCode.FILE_FDFS_UPLOAD_ERROR, e);
				} catch (Exception e) {
					
					e.printStackTrace();
					logger.error("doInFdfs",e);
				} finally {
					IOUtils.closeQuietly(inStream);
				}
				
				return UrlEncoder.encode(
					(FDFS_SEPERATOR + parts[0] + FDFS_SEPERATOR + parts[1])
						.replace("/", "!"), "utf-8");
			}
		});
    }
    /**
     * Download the file on the FastDFS storage
     * @param file
     * @throws FdfsException
     */
    public static int download(final FdfsFile file) throws FdfsException {
    	return fdfsTemplate.execute(new FdfsCallback<Integer>() {

			public Integer doInFdfs(StorageClient2 conn) throws FdfsException {
				int retVal = -1;
				try {
					retVal = conn.download_file(getGroupName(file.getUrl()), getFilename(file.getUrl()), new DownloadStream(file.getOutStream()));
				} catch (IOException e) {
					logger.error("doInFdfs", e);
					throw new FdfsException(FSErrorCode.FILE_FDFS_DOWNLOAD_ERROR, e);
				} catch (Exception e) {
					
					
					logger.error("doInFdfs", e);
				} 
				if(retVal != 0){
					throw new FdfsException(FSErrorCode.FILE_FDFS_DOWNLOAD_ERROR);
				}
				return retVal;
			}
		}).intValue();
    }
    /**
     * Delete the file from the FastDFS storage
     * @param file
     * @throws FdfsException
     */
    public static int delete(final FdfsFile file) throws FdfsException {
    	return fdfsTemplate.execute(new FdfsCallback<Integer>() {

			public Integer doInFdfs(StorageClient2 conn) throws FdfsException {
				int retVal = -1;
				try{
					retVal = conn.delete_file(getGroupName(file.getUrl()), getFilename(file.getUrl()));
					if(retVal != 0){
						throw new FdfsException(FSErrorCode.FILE_FDFS_DELETE_ERROR);
					}
				} catch (IOException e) {
					logger.error("doInFdfs", e);
					throw new FdfsException(FSErrorCode.FILE_FDFS_DELETE_ERROR, e);
				} catch (Exception e) {
					
					
					logger.error("doInFdfs", e);
				}
				return retVal;
			}
		}).intValue();
    }
    
    /**
     * Return the FileInfo of the file on the FastDFS storage
     * @param url
     * @return
     * @throws FdfsException
     */
    public static FileInfo getFileInfo(final FdfsFile file) throws FdfsException {
    	return fdfsTemplate.execute(new FdfsCallback<FileInfo>() {
    		
	    	public FileInfo doInFdfs(StorageClient2 conn) throws FdfsException {
	    		FileInfo info = null;
	    		try {
	    			info = conn.get_file_info(getGroupName(file.getUrl()), getFilename(file.getUrl()));
	    			if(info == null){
	    				throw new FileNotExistException(file.getUrl());
	    			}
	    			return info;
				} catch (IOException e) {
					logger.error("doInFdfs", e);
					throw new FdfsException(FSErrorCode.FILE_FDFS_GETINFO_ERROR, e);
				} catch (Exception e) {
					logger.error("doInFdfs", e);
					throw new FdfsException(FSErrorCode.FILE_FDFS_GETINFO_ERROR, e);
				} 
	    	}
	    });
    }
    
    /**
     * Return the metaList of what we upload to the FastDFS company with the file 
     * @param file
     * @return
     * @throws FdfsException
     */
    public static NameValuePair[] getMetaList(final FdfsFile file) throws FdfsException {
    	
    	return fdfsTemplate.execute(new FdfsCallback<NameValuePair[]>() {
    		
	    	public NameValuePair[] doInFdfs(StorageClient2 conn) throws FdfsException {
	    		try {
	    			NameValuePair[] metaList = conn.get_metadata(getGroupName(file.getUrl()), getFilename(file.getUrl()));
	    			return metaList;
				} catch (IOException e) {
					logger.error("doInFdfs", e);
					return null;
				} catch (Exception e) {
					
					logger.error("doInFdfs", e);
					return null;
				} 
	    	}
	    });
    }
    /**
     * 根据服务器的文件地址获取所在组名
     * @param url
     * @return
     */
	public static String getGroupName(String url)
	{
		try
		{
			url = URLDecoder.decode(url, "utf-8").replace("!","/");
		} catch(Exception e)
		{ }

		return StringUtils.substring(
			url, 1, StringUtils.indexOf(url, FDFS_SEPERATOR, 1));
	}
	
	/**
	 * 根据服务器的文件地址获取远程服务器的文件名（不含GroupName部分）
	 * @param url
	 * @return
	 */
	public static String getFilename(String url)
	{
		try
		{
			url = URLDecoder.decode(url, "utf-8").replace("!","/");
		} catch(Exception e)
		{ }

		return StringUtils.substring(
			url, StringUtils.indexOf(url, FDFS_SEPERATOR, 1) + 1);
	}	

	public static void main(String[] args) throws Exception {
//		File file = new File("G:\\1111.png");
//		NameValuePair[] meta = new NameValuePair[1];
//		meta[0] = new NameValuePair("fileName", file.getName());
//		FdfsFile fdfsfile = new FdfsFile(file.length(), file.getName(), new FileInputStream(file), meta);
//		String url = upload(fdfsfile);
//		System.out.println("Upload server location:" + url);
//
		File file1 = new File("d:\\3.jpg");
		FileOutputStream out = new FileOutputStream(file1);
		FdfsFile fdfsFile1 = new FdfsFile("/group1/M00/00/00/CgoUFVUqcvyAVAH1AAKBgFoDxgY262.png", out);
		int ret = download(fdfsFile1);
		out.close();
		String print = (ret == 0) ? "Download success!" : "Download failed!";
		System.out.println(print);
////		
		
//		FdfsFile fdfsFile2 = new FdfsFile("/group1/M00/00/00/CgoUFlUqcOmAIN1VAAKBgFoDxgY352.png");
//		int ret1 = delete(fdfsFile2);
//		String print1 = (ret1 == 0) ? "Delete success!" : "Delete failed!";
//		System.out.println(print1);
		
//		FdfsFile fdfsFile2 = new FdfsFile("/group1/M00/00/00/CgoUFlUqcOmAIN1VAAKBgFoDxgY352.png");
//		int ret1 = delete(fdfsFile2);
//		String print1 = (ret1 == 0) ? "Delete success!" : "Delete failed!";
//		System.out.println(print1);
//		
		
//		System.out.println("1:" + Thread.currentThread().getContextClassLoader().getResource(""));  
//		System.out.println("3:" + ClassLoader.getSystemResource(""));  
//		System.out.println("6:" + new File("/").getAbsolutePath());  
//		System.out.println("7:" + System.getProperty("user.dir"));  
//		System.out.println("8:" + System.getProperty("file.encoding"));//获取文件编码  
	}
}
