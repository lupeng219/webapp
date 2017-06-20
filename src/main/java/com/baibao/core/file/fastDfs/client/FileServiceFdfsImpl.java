/**
 * 
 */
package com.baibao.core.file.fastDfs.client;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;





import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.io.IOUtils;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



/**
 */
@Service("fastDfsFileClientService")
public class FileServiceFdfsImpl implements FileService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String FDFS_META_FILENAME = "fileName";

	public String upload(File file) throws IOException {
		return upload(file, file.getName());
	}
	public String uploadBaidu(FileItemStream file, String fname) throws IOException {
		NameValuePair[] meta = new NameValuePair[1];
		meta[0] = new NameValuePair(FDFS_META_FILENAME, fname);
		return FdfsUtils.upload(new FdfsFile(1, fname, file.openStream(), meta));
	}
	public String upload(File file, String fname) throws IOException {
		NameValuePair[] meta = new NameValuePair[1];
		meta[0] = new NameValuePair(FDFS_META_FILENAME, fname);
		return FdfsUtils.upload(new FdfsFile(file.length(), fname, new FileInputStream(file), meta));
	}

	public String upload(MultipartFile file, String fname) throws IOException {
		NameValuePair[] meta = new NameValuePair[1];
		meta[0] = new NameValuePair(FDFS_META_FILENAME, fname);
		return FdfsUtils.upload(new FdfsFile(file.getSize(), fname, file.getInputStream(), meta));
	}

	public String upload(MultipartFile file) throws IOException {
		return upload(file, file.getOriginalFilename());
	}

	public void download(String path, File destFile) throws FileNotFoundException {
		download(path, new FileOutputStream(destFile));
	}
	
	public void download(String path, OutputStream outputStream) {
		try {
			FdfsUtils.download(new FdfsFile(path, outputStream));
		} finally {
			IOUtils.closeQuietly(outputStream);
		}
	}

	public void delete(String path) {
		FdfsUtils.delete(new FdfsFile(path));
	}




}
