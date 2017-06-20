package com.baibao.web.p2p.controller;

import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.core.file.fastDfs.client.FdfsFile;
import com.baibao.core.file.fastDfs.client.FdfsUtils;

@RequestMapping("/file")
@Controller
public class FileController
{
	private static Logger logger = LoggerFactory.getLogger(FileController.class); 
	
	@ResponseBody
	@RequestMapping("/{path}")
	public ResponseEntity<byte[]> getFile(@PathVariable String path)
		throws Exception
	{
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "image/png");
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    
	    if(StringUtils.isBlank(path)){
	        return new ResponseEntity<byte[]>(
	                output.toByteArray(), headers, HttpStatus.OK);
	    }

		FdfsFile file = new FdfsFile(URLDecoder.decode(path, "utf-8"), output);

		FdfsUtils.download(file);

		logger.info(String.format("getFile parameter : path = %s --- return "
				,  path));
		return new ResponseEntity<byte[]>(
			output.toByteArray(), headers, HttpStatus.OK);
	}
}
