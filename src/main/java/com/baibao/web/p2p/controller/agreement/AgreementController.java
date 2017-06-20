package com.baibao.web.p2p.controller.agreement;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.baibao.core.cache.SystemConfigCache;
import com.baibao.cache.utils.JedisUtil;
import com.baibao.core.exception.BusinessException;
import com.baibao.core.utils.Paging;
import com.baibao.core.utils.StringUtil;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.DateUtils;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.bean.P2p_loan_product_aid;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.service.AgreementService;
import com.baibao.web.p2p.service.ContractService;
import com.baibao.web.p2p.service.LoanProductAidService;
import com.baibao.common.util.HtmlToPdfUtil;
import com.baibao.common.util.ZipUtil;

/**
 * 协议控制
 * @date 2016年1月27日
 */
@Controller
@EnableWebMvc
@RequestMapping("/agreement")
public class AgreementController
{	
	private static Logger logger =
		LoggerFactory.getLogger(AgreementController.class);
	
	@Autowired
	private AgreementService agreementService;
	
	@Autowired
	private LoanProductAidService loanProductAidService;

	@Autowired
	private ContractService contractService;
	
	@Autowired
	private JedisUtil jedisUtil;
	
	/**
	 * 注册协议--《中融佰诚网站注册服务协议》
	 * @param request
	 * @return
	 */
	@RequestMapping("/registerAgreement")
	public String registerAgreement(HttpServletRequest request)
	{
		return "/agreement/registerAgreement";
		
	}
	
	/**
	 * 债权转让协议
	 * 
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/equitableAssignment")*/
	public String equitableAssignment(HttpServletRequest request)
	{
		return "/agreement/bondTransfer_agreement";
	}
	/**
	 * app使用的协议
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/bondTransfers")*/
	public String bondTransfers(HttpServletRequest request)
	{
		return "/agreement/bondTransfer_agreement";
	}
	
	/**
	 * 借款协议
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/loanAgreement")*/
	public String loanAgreement(HttpServletRequest request)
	{
		return "/agreement/loan_agreement";
	}
	
	/**
	 * 借款保证协议
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/loanGuaranteeAgreement")*/
	public String loanGuaranteeAgreement(HttpServletRequest request)
	{
		return "/agreement/loan_guarantee_agreement";
	}

	/**
	 * 借款协议数据
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/loanAgreements")*/
	public ModelAndView loanAgreements(
		HttpServletRequest reques,
		@RequestParam(value = "tenderFlowNo") String tenderFlowNo)
	{
		logger.info(String.format("loanAgreements parameter : tenderFlowNo = %s ", 
				tenderFlowNo));
		Map<String, Object> map = new HashMap<String, Object>();

		if (StringUtil.isNotEmpty(tenderFlowNo))
		{
			map.put("tenderFlowNo", tenderFlowNo);
			try
			{
				map = agreementService.loanAgreements(map);
			} catch(BusinessException e)
			{
				logger.error("loanAgreements", e);
			}
		}

		  ModelAndView modelAndView = new ModelAndView("/agreement/loan_agreement", "result", map);
		  logger.info(String.format("loanAgreements parameter : tenderFlowNo = %s --- return : modelAndView = %s", 
					tenderFlowNo,JsonHelper.formatJson(modelAndView)));
		  return modelAndView;
	}

	/**
	 * 借款人合同列表
	 * @param request
	 * @return
	 */
	/*#RequestMapping("/getBorrowContractList")*/
	public ModelAndView getBorrowContractList(
		HttpServletRequest request,
		String productNo, Integer currentPageNo, Integer pageSize)
	{
		logger.info(String.format("getBorrowContractList parameter : productNo = %s,currentPageNo = %s ,pageSize = %s", 
				productNo,currentPageNo,pageSize));
		currentPageNo =currentPageNo ==null ? 1: currentPageNo ;
		pageSize = pageSize == null ? 10: pageSize;
		
		Paging<Map<String, Object>> Paging =
			agreementService.getBidRecord(productNo, currentPageNo, pageSize);
		ModelAndView mav =
			new ModelAndView("/agreement/borrowContractList", "Paging", Paging);
		
		mav.addObject("productNo", productNo);
		logger.info(String.format("getBorrowContractList parameter : productNo = %s,currentPageNo = %s ,pageSize = %s  --- return : mav = %s", 
				productNo,currentPageNo,pageSize,JsonHelper.formatJson(mav)));
		return mav;
	}

	/**
	 * 获取合同内容
	 */
	@ResponseBody
	@RequestMapping(value = "/contract")
	public ResponseEntity<String> contract(
		String productNo, String tenderFlowNo,
		String custNo, String code)
	{
		logger.info(String.format("contract parameter : productNo = %s,tenderFlowNo = %s ,custNo = %s ", 
				productNo,tenderFlowNo,custNo));

		if (StringUtils.isNotBlank(code))
		{
			if (code.equals("crdtran"))
				code = "ifthestandard-product";
		}
		
		String content =
			contractService.applyProductContract(
				productNo, tenderFlowNo, custNo, code);
		
		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(
			MediaType.parseMediaType("text/html; charset=utf-8"));
		logger.info(String.format("contract parameter : productNo = %s,tenderFlowNo = %s ,custNo = %s  --- return : ", 
				productNo,tenderFlowNo,custNo));
		return new ResponseEntity<String>(content, headers, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/contractPdf")
	public ResponseEntity<byte[]> contractPdf(
		String productNo, String tenderFlowNo,
		String custNo, String code)
	{
		logger.info(String.format("contract parameter : productNo = %s,tenderFlowNo = %s ,custNo = %s ", 
				productNo,tenderFlowNo,custNo));
		if (custNo == null)
		{
			P2p_user currentUser = SecurityUserHolder.getCurrentUser();
			
			if (currentUser != null)
				custNo = currentUser.getPuCustNo();
		}

		String key = String.format("%s-%s", productNo, tenderFlowNo);

		byte[] pdf = jedisUtil.getBuffer(key);
		if (pdf == null || pdf.length == 0)
		{
			if (StringUtils.isNotBlank(code))
			{
				if (code.equals("crdtran"))
					code = "ifthestandard-product";
			}

			String content =
				contractService.applyProductContract(
					productNo, tenderFlowNo, custNo, code);

			pdf = contractService.convertPdf(content);

			jedisUtil.setBuffer(key, pdf);
		}

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		logger.info(String.format("contract parameter : productNo = %s,tenderFlowNo = %s ,custNo = %s  --- return : ", 
				productNo,tenderFlowNo,custNo));
		return new ResponseEntity<byte[]>(pdf, headers, HttpStatus.OK);
	}
	
	
	@RequestMapping("/ajaxPagegetBorrowContractList")
	public ModelAndView ajaxPagegetBorrowContractList(
		HttpServletRequest request, String productNo,
		Integer currentPageNo, Integer pageSize)
	{
		logger.info(String.format("ajaxPagegetBorrowContractList parameter : productNo = %s,currentPageNo = %s ,pageSize = %s", 
				productNo,currentPageNo,pageSize));
		currentPageNo = (currentPageNo == null)? 1: currentPageNo;
		pageSize = (pageSize == null)? 10: pageSize;
	
		Paging<Map<String, Object>> Paging =
			agreementService.getBidRecord(productNo, currentPageNo, pageSize);
		
		ModelAndView mav = new ModelAndView("/agreement/_borrowContractList");
		
		mav.addObject("Paging", Paging);
		mav.addObject("productNo", productNo);
		logger.info(String.format("ajaxPagegetBorrowContractList parameter : productNo = %s,currentPageNo = %s ,pageSize = %s  --- return : mav = %s", 
				productNo,currentPageNo,pageSize,JsonHelper.formatJson(mav)));
		return mav;
	}

	/*#RequestMapping("/createagreementList")*/
	@ResponseBody
	public Map<String, Object> getList(
		HttpServletRequest request, String productNo)
	{
		logger.info(String.format("ajaxPagegetBorrowContractList parameter : productNo = %s", 
				productNo));
		Map<String, Object> result = new HashMap<String, Object>();
		Paging<Map<String, Object>> page =
			agreementService.getBidRecord(productNo, 1, Integer.MAX_VALUE);
		
		List<Map<String, Object>> list = page.getPageList();
		
		P2p_loan_product_aid product =
			loanProductAidService.queryByProductNo(productNo);
		try
		{
			String hetongAddress = String.valueOf(
				SystemConfigCache.getValue("common", "quanzibe_hetongAddress"));
			String path = hetongAddress + productNo;
			String zipName = path.concat(".zip");
			String type = product.getPpProducttypeNo();
			String tenderFlowNo = null;
			
			for(Map<String, Object> map : list)
			{
				tenderFlowNo = null;
				tenderFlowNo = String.valueOf(map.get("ptr_tenderFlowNo"));
			}
			
			com.baibao.common.util.ZipUtil.createZip(zipName, path);
			
			SessionUtils.putAttrInSession(
				request, "agreementbulkloannumber", zipName);
			SessionUtils.putAttrInSession(
				request, "agreement_tenderFlowNo", productNo);
			SessionUtils.putAttrInSession(
				request, "down_type", "zip");
		} catch(IOException e)
		{
			logger.error("getList", e);
		}

		result.put("retCode", true);
		logger.info(String.format("ajaxPagegetBorrowContractList parameter : productNo = %s --- return : result = %s", 
				productNo,JsonHelper.formatJson(result)));
		return result;
	}

	private  String getRequestURL(String type, String tenderFlowNo)
	{	
		StringBuffer requestURL = new StringBuffer(Const.basePath);
		
		//不同的合同 类型跳转到不同的地址路径
		if ("2".equals(type))
		{//债权转让协议数据
			requestURL.append(
				"/service/agreement/equitableAssignments?tenderFlowNo=" + tenderFlowNo);
		} else
		if ("0".equals(type))
		{//借款协议数据
			requestURL.append(
				"/service/agreement/loanAgreements?tenderFlowNo=" + tenderFlowNo);
		} else
		if ("1".equals(type))
		{//借款保证协议数据
			requestURL.append(
				"/service/agreement/loanGuaranteeAgreements?tenderFlowNo=" + tenderFlowNo);
		}

		return requestURL.toString();
	}
	
	
	/*#RequestMapping("/downloadAgreementZip")*/
	public void download(
		HttpServletRequest request,HttpServletResponse response)
		throws Exception
	{
		logger.info("downloadAgreementZip parameter:");
		Object filename = SessionUtils.getAttrFromSession(request, "agreementbulkloannumber");
		Object flowNo = SessionUtils.getAttrFromSession(request, "agreement_tenderFlowNo");
		Object downType = SessionUtils.getAttrFromSession(request, "down_type");
		
		String application = "application/" + downType;
		
		File file = new File(filename.toString());
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try
		{
			response.setCharacterEncoding("UTF-8");
			
			Long fileLength = file.length();
			
			response.setContentType(application);
			response.setHeader("Content-disposition",
				"attachment; filename="+ URLEncoder.encode(flowNo.toString(), "UTF-8")+"."+downType);
			response.setContentLength(fileLength.intValue());
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			
			byte[] buff = new byte[2048];
			int bytesRead;
			
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
			{
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e)
		{
			logger.error("download", e);
		} finally
		{
			if (bis != null)
			{
				try
				{
					bis.close();
				} catch(IOException e)
				{
					logger.error("download", e);
				}
			}
			if (bos != null)
			{
				try
				{
					bos.close();
				} catch(IOException e)
				{
					logger.error("download", e);
				}
			}

			SessionUtils.removeFromSession(request, "agreementbulkloannumber");
			SessionUtils.removeFromSession(request, "agreement_tenderFlowNo");
			SessionUtils.removeFromSession(request, "down_type");			
		}
	}
}
