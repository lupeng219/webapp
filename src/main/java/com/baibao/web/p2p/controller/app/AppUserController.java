package com.baibao.web.p2p.controller.app;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.file.fastDfs.client.FdfsFile;
import com.baibao.core.file.fastDfs.client.FdfsUtils;
import com.baibao.core.utils.Base64;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.FileSystem;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.generator.bean.P2pInitParams;
import com.baibao.web.p2p.generator.bean.P2p_cust_account;
import com.baibao.web.p2p.generator.bean.P2p_system_params;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.AccountService;
import com.baibao.web.p2p.service.CustAccountService;
import com.baibao.web.p2p.service.UserService;
import com.baibao.web.p2p.utils.AppCallLogUtil;
import com.esotericsoftware.minlog.Log;

/**
 * @author lupeng
 * @date: 2016年1月4日下午2:34:32
 */
@Controller
@RequestMapping("appUser")
public class AppUserController {
	
	private static final Logger logger = LoggerFactory
            .getLogger(AppUserController.class);
	
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustAccountService custAccountService;
	@Autowired
	private UserService userService;
	@Autowired
	private BaseLog baseLog;
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @param data
	 * @param custNo
	 * @return
	 */
	@RequestMapping("/upLoad")
	@ResponseBody
	public Map<String, Object> upLoad(HttpServletRequest request,HttpServletResponse response,String data,String custNo){
		AppCallLogUtil.printMsg(request, "appUser.upLoad","custNo","data");
		Map<String, Object> retMap=new HashMap<String, Object>();
		if( StringUtils.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return retMap;
		}
		custNo =jedisUtil.getValue(custNo);
		if (StringUtils.isEmpty(custNo))
        {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);// 用户未登录
            return retMap;
        }
		
		File tempFile = null;
		try
        {
            byte[] decode = Base64.decode(data);
            
            tempFile = File.createTempFile("cropImage", "tmp");
            FileSystem.writeBytes(tempFile, decode);
            
            String fastdfsPath = null;
            NameValuePair[] meta = new NameValuePair[] {
                new NameValuePair("fileName", tempFile.getName())
            };
            
            FdfsFile fdfsFile = new FdfsFile(tempFile.length(), tempFile.getName(), new FileInputStream(tempFile), meta);
            fastdfsPath = FdfsUtils.upload(fdfsFile);
            
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("url", fastdfsPath);
            params.put("custNo", custNo);
            userService.updateHeadUrlByCustNo(params);
            retMap.put("headUrl", this.getUserHeadUrl(request, fastdfsPath));
            retMap.put(Const.retCode,true );
            retMap.put(Const.retMsg,"\u4e0a\u4f20\u6210\u529f");//上传成功
            baseLog.writer(custNo,params.toString(),retMap.toString(),BusinessType.UPLOADAVATAR.getDesc(), RegistType.APP.getName(), "/upLoad");
        }
        catch (Exception e)
        {
            retMap.put(Const.retCode, false );
            retMap.put(Const.retMsg,"\u4e0a\u4f20\u5931\u8d25");//上传失败
            logger.error("upLoad", e);
        }
        finally
        {
            tempFile.delete();
        }
		return retMap;
		
		/**
		//获得tomcate的路径
		String path=request.getSession().getServletContext().getRealPath("/");
		//构造图片存储临时文件夹注意系统的差异
		String temp_folder=path+File.separator+"imgTemps";
		// 构造图片存储临时文件夹注意系统的差异
		String a = temp_folder + File.separator + "decodesss.jpg";
		//创建临时路径
		OutputStream out = null;
		File files=new File(temp_folder);
		if(!files.exists()){
			files.mkdirs();
		}
		File file=new File(a);
		byte[] decode = Base64.decode(data);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			out = new FileOutputStream(file);
			out.write(decode);
			out.flush();
			out.close();
			//将本地图片上传到fastdfs服务器上
			NameValuePair[] meta = new NameValuePair[1];
			meta[0] = new NameValuePair("fileName", file.getName());
			FdfsFile fdfsFile = new FdfsFile(file.length(), file.getName(), new FileInputStream(file), meta);
			String fastdfsPath = FdfsUtils.upload(fdfsFile);
			//retMap.put("imagePath", PropertiesUtil.getSysConfigParams("FASTDFS_SERVER")+fastdfsPath);
			Map<String, Object> params=new HashMap<String, Object>();
			//params.put("url",PropertiesUtil.getSysConfigParams("FASTDFS_SERVER")+fastdfsPath );
			params.put("url",fastdfsPath );
			params.put("custNo", custNo);
			retMap.put(Const.retCode,true );
			retMap.put(Const.retMsg,"\u4e0a\u4f20\u6210\u529f");//上传成功
			userService.updateHeadUrlByCustNo(params);
			baseLog.writer(custNo,params.toString(),retMap.toString(),BusinessType.UPLOADAVATAR.getDesc(), RegistType.APP.getName(), "/upLoad");
			return retMap;
		} catch (IOException e) {
			retMap.put(Const.retCode,true );
			retMap.put(Const.retMsg,"\u4e0a\u4f20\u5931\u8d25");//上传失败
			logger.error("upLoad", e);
			return retMap;
		}finally{
				try {
					if(out!=null){
						out.close();
					};
					if (files.exists()) {
						deleteFileThere(files);
					}
				} catch (IOException e) {
					logger.error("upLoad", e);
			}
		}
		*/
	}
	private String getUserHeadUrl(HttpServletRequest request, String headUrl){
	    String scheme = request.getScheme();
        String serverName = request.getServerName();
        int port = request.getServerPort();
        String path = request.getContextPath();
        String basePath = scheme + "://" + serverName + ":" + port + path;
        return basePath + "/service/file/" + headUrl;
	}
	/**
	 * 删除文件目录
	 * 
	 * @param file
	 */
	public void deleteFileThere(File file) {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File files[] = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					this.deleteFileThere(files[i]);
				}
				file.delete();
			}
		} else {
		    logger.error("所删除的文件不存在!");
		}
	}
	/**
	 * 我的账户 - 修改交易密码  
	 * @param oldpassworld 原交易密码
	 * @param newPassword 新密码
	 * @param newPasswordSub 确认新密码
	 * @param custNo 客户号
	 * @return
	 */
	@RequestMapping("/updateTransPass")
	@ResponseBody
	public Map<String, Object> updateTransPassword(HttpServletRequest request,String oldpassworld,String newPassword,String newPasswordSub,String custNo){
		AppCallLogUtil.printMsg(request, "appUser.upLoad","oldpassworld","newPassword","newPasswordSub","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtils.isEmpty(custNo) || StringUtils.isEmpty(newPassword) || StringUtil.isEmpty(newPasswordSub)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return retMap;
		}
		try {
			custNo =jedisUtil.getValue(custNo); 
			if(StringUtils.isEmpty(custNo)){
                retMap.put(Const.retCode, false);
                retMap.put(Const.retMsg, Const.noLoginMsg);//参数不符合规范
                return retMap;
            }
			P2p_cust_account custAccount = accountService.getCustAccountByCustNo(custNo, false);
			if(!StringUtil.isEmpty(custAccount.getPcaPayPassword())){
				if(StringUtil.isEmpty(oldpassworld)){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u8bf7\u8f93\u5165\u539f\u4ea4\u6613\u5bc6\u7801");// 请输入原交易密码
					retMap.put(Const.retType, "old");
					return retMap;
				}
				if(!oldpassworld.equals(custAccount.getPcaPayPassword())){
					retMap.put(Const.retCode, false);
					retMap.put(Const.retMsg, "\u8bf7\u60a8\u8f93\u5165\u6b63\u786e\u7684\u539f\u4ea4\u6613\u5bc6\u7801");// 请您输入正确的原交易密码
					retMap.put(Const.retType, "old");
					return retMap;
				}
			}
			baseLog.writer(custNo,"","",BusinessType.UPDATETRANSACTIONPASSWORD.getDesc(), RegistType.APP.getName(), "/updateTransPass");
			return updateTransPwd(retMap, newPassword, newPasswordSub, custNo, custAccount);
			
		} catch (Exception e) {
			logger.error("保存交易密码错误****接口appUser/updateTransPass", e);
			e.printStackTrace();
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u4fdd\u5b58\u5931\u8d25");//保存失败
		}
		return retMap;
	}
	/**
	 * 我的账户 - 找回交易密码 - 保存交易密码  {第二步}
	 * @param newPassword 新密码
	 * @param newPasswordSub 确认新密码
	 * @param custNo 
	 * @return
	 */
	@RequestMapping("/resetTransPassword")
	@ResponseBody
	public Map<String, Object> resetTransPassword(HttpServletRequest request,String phone, String code, String newPassword,String newPasswordSub,String custNo){
		AppCallLogUtil.printMsg(request, "appUser.resetTransPassword","phone","code","newPassword","newPasswordSub","custNo");
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(StringUtils.isEmpty(custNo)){
			retMap.put(Const.retCode, false);
			retMap.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
			return retMap;
		}
		
		custNo =jedisUtil.getValue(custNo); 
		if (StringUtils.isEmpty(custNo))
        {
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, Const.noLoginMsg);// 用户未登录
            return retMap;
        }
		String getCode = jedisUtil.getValue(phone);
        if(StringUtil.isEmpty(getCode)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, "\u9a8c\u8bc1\u7801\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u83b7\u53d6");//验证码超时，请重新获取
            return retMap;            
        }
        if(!getCode.equalsIgnoreCase(code)){
            retMap.put(Const.retCode, false);
            retMap.put(Const.retMsg, "短信验证码错误,请您重新输入");
            return retMap;
        }
	    try {
			baseLog.writer(custNo,"","",BusinessType.GETBACKTRANSACTIONPASSWORD.getDesc(), RegistType.APP.getName(), "/resetTransPassword");
			P2p_cust_account custAccount = accountService.getCustAccountByCustNo(custNo, false);
			return updateTransPwd(retMap, newPassword, newPasswordSub, custNo, custAccount);
		} catch (Exception e) {
			logger.error("找回交易密码错误****接口appUser/resetTransPassword", e);
			retMap.put(Const.retMsg, "\u627e\u56de\u4ea4\u6613\u5bc6\u7801\u9519\u8bef");//找回交易密码错误
			retMap.put(Const.retCode, false);
		}
	    return retMap;
	}
	/**
	 * 交易密码方法
	 * @throws Exception
	 */
	private Map<String, Object> updateTransPwd(Map<String, Object> result,String newPassword,String newPasswordSub,
			String custNo,P2p_cust_account custAccount) throws Exception{
		if(!newPassword.equals(newPasswordSub)){
			result.put(Const.retCode, false);
			result.put(Const.retMsg, "\u4e24\u6b21\u4ea4\u6613\u5bc6\u7801\u4e0d\u4e00\u81f4");// 两次交易密码不一致
			result.put(Const.retType, "passsub");
			return result;
		}
		result.put("custNo", custNo);
		result.put("paypassword", newPassword);
		result.put("accountNo", custAccount.getPcaAccountno());
		result.put("registType", RegistType.APP.getIndex());
		result = custAccountService.updateTransPassword(result);
		if((boolean) result.get(Const.retCode)){
			result.put(Const.retMsg,"\u4fdd\u5b58\u6210\u529f");//保存成功
		}
		return result;
	}
	
	@RequestMapping("/contactus")
    public String contactus(HttpServletRequest request){
	    return "/app/contactus";
	}
	
	@RequestMapping("/security")
    public String security(HttpServletRequest request){
        return "/app/security";
    }
	@RequestMapping("/helpCenterApp")
    public String helpCenterApp(HttpServletRequest request){
        return "/app/helpCenterApp";
    }
	
	@RequestMapping("/helpCenterIntro")
    public String helpCenterIntro(HttpServletRequest request){
        return "/app/helpCenterIntro";
    }
	@RequestMapping("/helpCenterEdeS")
    public String helpCenterEdeS(HttpServletRequest request){
        return "/app/helpCenterEdeS";
    }
	@RequestMapping("/helpCenterNoun")
    public String helpCenterNoun(HttpServletRequest request){
        return "/app/helpCenterNoun";
    }
	@RequestMapping("/helpCenterFAQ")
    public String helpCenterFAQ(HttpServletRequest request){
        return "/app/helpCenterFAQ";
    }
	@RequestMapping("/beginerGuide")
    public String beginerGuide(HttpServletRequest request){
        return "/app/beginerGuide";
    }
	@RequestMapping("/initParams")
	@ResponseBody
    public Map<String, Object> initParams(HttpServletRequest request){
		AppCallLogUtil.printMsg(request,"systemParams");
		Map<String, Object> retMap = new HashMap<String, Object>();
		try {
			P2pInitParams p2pInitParams = userService.getSystemByname();
			retMap.put("initParams", p2pInitParams);
			retMap.put(Const.retMsg,"\u67e5\u8be2\u6210\u529f");//查询成功
			retMap.put(Const.retCode, true);
		} catch (Exception e) {
			Log.error("初始化参数查询错误***接口appUser/initParams",e);
			retMap.put(Const.retMsg,"\u6682\u65e0\u6570\u636e");//暂无数据
			retMap.put(Const.retCode, false);
		}
		return retMap;
    }
}
