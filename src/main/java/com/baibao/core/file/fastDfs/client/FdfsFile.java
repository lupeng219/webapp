package com.baibao.core.file.fastDfs.client;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.lang.StringUtils;
import org.csource.common.NameValuePair;
/**
 * FastDFS 文件参数对象：抽象用于支持各种不同类型的File
 */
public class FdfsFile {
	
	public static final String FDFS_DEFAULT_GROUP = "baibao";
	private long size;
	private String name;
	private String ext;
	private String url;
	private String group = FDFS_DEFAULT_GROUP;
	private NameValuePair[] meta = null;
	private InputStream inputStream;
	private OutputStream outStream;
	
	public FdfsFile( long size, String name, InputStream inputStream){
		this(size, name, FDFS_DEFAULT_GROUP, inputStream, null);
	}
	
	public FdfsFile( long size, String name, String group, InputStream inputStream){
		this(size, name, group, inputStream, null);
	}
	
	public FdfsFile( long size, String name, InputStream inputStream, NameValuePair[] meta){
		this(size, name, FDFS_DEFAULT_GROUP, inputStream, meta);
	}
	
	public FdfsFile(long size, String name, String group, InputStream inputStream, NameValuePair[] meta){
		this.size = size;
		this.name = name;
		this.ext = StringUtils.substringAfterLast(name, ".").toLowerCase();
		this.group = group;
		this.meta = meta;
		this.inputStream = inputStream;
	}
	
	public FdfsFile(String url){
		this(url, null);
	}
	
	public FdfsFile(String url, OutputStream outStream){
		this.url = url;
		this.outStream = outStream;
	}
	
	public long getSize() {
		return size;
	}
	
	public void setSize(long size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExt() {
		return ext;
	}
	
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public NameValuePair[] getMeta() {
		return meta;
	}
	
	public void setMeta(NameValuePair[] meta) {
		this.meta = meta;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public OutputStream getOutStream() {
		return outStream;
	}
}
