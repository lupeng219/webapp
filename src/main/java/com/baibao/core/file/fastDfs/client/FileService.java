package com.baibao.core.file.fastDfs.client;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import org.apache.commons.fileupload.FileItemStream;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wguangl
 */
public interface FileService {
	
	/**
	 * 上传
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public String upload(MultipartFile file) throws IOException;
	
	public String upload(MultipartFile file, String fname) throws IOException;
	
	public String upload(File file, String fname) throws IOException;

	/**
	 * 下载
	 * @param path
	 * @param outputStream
	 */
	public void download(String path, OutputStream outputStream);

	/**
	 * 删除
	 * @param path
	 */
	public void delete(String path);
	
	public String uploadBaidu(FileItemStream file, String fname) throws IOException;
	
}
