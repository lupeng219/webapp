package com.baibao.web.p2p.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.file.fastDfs.client.FdfsFile;
import com.baibao.core.file.fastDfs.client.FdfsUtils;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.FileSystem;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_cust_logon;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.CustLogonService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.common.util.PropertiesUtil;

@Controller
@RequestMapping("/fileUpLoad")
public class LoadHeadUrlController
{	
	private static Logger logger =
		LoggerFactory.getLogger(LoadHeadUrlController.class); 

	@Autowired
	private UserService userService;

	@Autowired
	private JedisUtil jedisUtil;
	
	@Autowired
	private BaseLog baseLog;
	 @Autowired
	 private CustLogonService logonService;
	@ResponseBody
	@RequestMapping("/show")
	public ResponseEntity<byte[]> show(String imageId)
	{
		byte[] data = jedisUtil.getBuffer(imageId);
		String type = jedisUtil.getValue(imageId + "-type");

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.parseMediaType(type));

		return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping("/upLoad")
	public Map<String, Object> upLoad(
		MultipartHttpServletRequest request, HttpServletResponse response)
		throws Exception
	{
		String custno = SecurityUserHolder.getCustNo();

		Map<String, Object> result = new HashMap<String, Object>();

		if (request.getFileMap().size() == 0)
			return result;

		MultipartFile partFile =
			(MultipartFile) request.getFileMap().values().toArray()[0];
		
		byte[] data = FileSystem.readBytes(partFile.getInputStream());

		String id = Utils.randomId("upLoad");

		jedisUtil.setBuffer(id,  data, 3600);
		jedisUtil.setValue(id + "-type", partFile.getContentType(), 3600);

		BufferedImage source = ImageIO.read(new ByteArrayInputStream(data));
		
		int width = source.getWidth();
		int height = source.getHeight();

		result.put("imageId", id);
		result.put("imageUrl",
			String.format("/service/fileUpLoad/show?imageId=%s",
				URLEncoder.encode(id, "utf-8")));
		result.put("width", width);
		result.put("height", height);

		return result;
	}

	/**
	 * 裁剪图片
	 * @param request
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param imgWidth
	 * @param imgHeight
	 * @param realHeight
	 * @param realWidth
	 * @return
	 */
	@RequestMapping("/cropImage")
	public @ResponseBody Map<String, Object> cropImage(
		HttpServletRequest request, String imageId,
		Integer x, Integer y, Integer width, Integer height,
		Integer imgWidth, Integer imgHeight,
		Integer realHeight, Integer realWidth)
		throws Exception
	{
		P2p_user user = SecurityUserHolder.getCurrentUser();
		P2p_cust_logon logon = logonService.getCustLogonByCustNo(user.getPuCustNo());
		user.setPuLastlogintime(logon.getPclLastLoginsucc());// 最后登录时间
		//图片缩放比例后的大小
		Integer tempw = realWidth * width / imgWidth;
		Integer temph = realHeight * height / imgHeight;
		Integer tempx = realWidth * x / imgWidth;
		Integer tempy = realHeight * y / imgHeight;

		byte[] data = jedisUtil.getBuffer(imageId);
		
		File tempFile = File.createTempFile("cropImage", "tmp");
		
		//裁剪图片
		try
		{
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			Thumbnails.of(new ByteArrayInputStream(data)).sourceRegion(
				tempx, tempy, tempw, temph).size(tempw, temph)
				.toOutputStream(output);

			FileSystem.writeBytes(tempFile, output.toByteArray());
		} catch(IOException e)
		{
			logger.error("cropImage", e);
		}

		//将裁剪后的图片上传到fastdfs上
		String fastdfsPath = null;

		try
		{
			NameValuePair[] meta = new NameValuePair[] {
				new NameValuePair("fileName", tempFile.getName())
			};
			
			FdfsFile fdfsFile =
				new FdfsFile(tempFile.length(), tempFile.getName(),
					new FileInputStream(tempFile), meta);
			
			fastdfsPath = FdfsUtils.upload(fdfsFile);
		} catch (IOException e) {
			logger.error("cropImage", e);
		}

		Map<String, Object> head_map = new HashMap<String, Object>();

		head_map.put("url", fastdfsPath);
		head_map.put("custNo", user.getPuCustNo());

		int i = userService.updateHeadUrlByCustNo(head_map);
		if (i > 0)
		{
			user.setPuHeadUrl(fastdfsPath);
			
			SessionUtils.setCurrentUser(request, user);

			SessionUtils.putAttrInSession(
				request, "head_url", user.getPuHeadUrl());

			tempFile.delete();

			head_map.put("imagePath", fastdfsPath);

			jedisUtil.del(imageId);
		}

		return head_map;
	}
}
