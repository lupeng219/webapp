package com.baibao.web.p2p.controller.borrowMoney;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.generator.bean.P2p_loan_apply;
import com.baibao.web.p2p.generator.bean.P2p_user;
import com.baibao.web.p2p.generator.dataDIC.LoanApplyStatus;
import com.baibao.web.p2p.service.LoanApplyService;

import rop.thirdparty.org.apache.commons.lang3.StringUtils;
@Controller
@RequestMapping("/borrowMoney")
public class BorrowMoneyController {
	private static Logger logger = LoggerFactory.getLogger(BorrowMoneyController.class); 
	
	@Autowired
	private LoanApplyService loanApplyService;

	/**
	 * 个人借贷页
	 * @return
	 */
	@RequestMapping
	public String personBorrow(HttpServletRequest request){
		return "borrowMoney/personBorrow";
	}
	
	/**
	 * 借款
	 * @param request
	 * @param realName
	 * @param mobile
	 * @param mortgageMode
	 * @param sel_province
	 * @param sel_city
	 * @param carModel
	 * @param vehicleRegistration
	 * @param loanAmount
	 * @param loanTerm
	 * @param loanPurpose
	 * @param cellName
	 * @param grossArea
	 * @param productType 1抵押，2债券，3信用
	 * @return
	 */
	@RequestMapping(value = "/insertLoanApply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  insertLoanApply(HttpServletRequest request,
			@RequestParam("realName") String realName,
			@RequestParam("mobile") String mobile,
			@RequestParam("mortgageMode") String mortgageMode,
			@RequestParam("sel_province") String sel_province,
			@RequestParam("sel_city") String sel_city,
			@RequestParam(value="carModel",required=false) String carModel,
			@RequestParam(value="vehicleRegistration",required=false) String vehicleRegistration,
			@RequestParam("loanAmount") BigDecimal loanAmount,
			@RequestParam("loanTerm") Integer loanTerm,
			@RequestParam("loanPurpose") String loanPurpose,
			@RequestParam(value="cellName",required=false) String cellName,
			@RequestParam(value="grossArea",required=false) String grossArea,
			@RequestParam(value="productType",required=false) String productType
		){
		logger.info(String.format("insertLoanApply parameter : realName = %s ,mobile = %s,mortgageMode = %s,"
				+ "sel_province = %s,sel_city = %s,carModel = %s,vehicleRegistration = %s,loanAmount = %s，"
				+ "loanTerm = %s，loanPurpose = %s，cellName = %s,grossArea = %s,productType = %s ", 
    			realName,mobile,mortgageMode,sel_province,sel_city,carModel,vehicleRegistration,loanAmount,
    			loanTerm,loanPurpose,cellName,grossArea,productType));
		Map<String, Object> map = new HashMap<String, Object>();
		P2p_user user = SecurityUserHolder.getCurrentUser();
		if(null==user){
			map.put(Const.retCode, false);
			logger.info(String.format("insertLoanApply parameter : realName = %s ,mobile = %s,mortgageMode = %s,"
					+ "sel_province = %s,sel_city = %s,carModel = %s,vehicleRegistration = %s,loanAmount = %s，"
					+ "loanTerm = %s，loanPurpose = %s，cellName = %s,grossArea = %s,productType = %s --- return : map = %s", 
	    			realName,mobile,mortgageMode,sel_province,sel_city,carModel,vehicleRegistration,loanAmount,
	    			loanTerm,loanPurpose,cellName,grossArea,productType,JsonHelper.formatJson(map)));
			return map;
		}
		String custNo = user.getPuCustNo();
		P2p_loan_apply  loanApply = new P2p_loan_apply();
		loanApply.setPpCustno(custNo);//客户号
		loanApply.setPpPrincipalname(realName);
		loanApply.setPpLoanapplymobile(mobile);
		loanApply.setPpProvince(sel_province);
		loanApply.setPpCity(sel_city);
		loanApply.setPpModelcar(carModel);
		loanApply.setPpLoanamount(loanAmount.multiply(new BigDecimal(10000)));
		loanApply.setPpLoanterm(loanTerm);
		loanApply.setPpLoanpurpose(loanPurpose);
		loanApply.setPpCellName(cellName);
		loanApply.setPpBuiltupArea(grossArea);
		loanApply.setPpVehicleRegistration(vehicleRegistration);
		loanApply.setPpBorrowerType(Const.personalApply);
		loanApply.setPpLoanapplytime(new Date());//借款时间
		loanApply.setPpApplytype(Integer.parseInt(Const.externalApplication));//外部发标
		loanApply.setPpLoanapplystatus(LoanApplyStatus.waitfristaudi.getIndex());
		if (!StringUtils.isEmpty(productType)) {//产品类型
			if (Const.dybzProductTypeNo.equals(productType)) {
				loanApply.setPpProducttype(Const.dybzProductTypeNo);
			} else if (Const.zqzrProductTypeNo.equals(productType)) {
				loanApply.setPpProducttype(Const.dybzProductTypeNo);
			} else if (Const.creditProductTypeNo.equals(productType)) {
				loanApply.setPpProducttype(Const.creditProductTypeNo);
			}
		} else {
			map.put(Const.retCode, false);
			map.put(Const.retMsg, "抵押方式不能空");
			logger.info(String.format("insertLoanApply parameter : realName = %s ,mobile = %s,mortgageMode = %s,"
					+ "sel_province = %s,sel_city = %s,carModel = %s,vehicleRegistration = %s,loanAmount = %s，"
					+ "loanTerm = %s，loanPurpose = %s，cellName = %s,grossArea = %s,productType = %s --- return : map = %s", 
	    			realName,mobile,mortgageMode,sel_province,sel_city,carModel,vehicleRegistration,loanAmount,
	    			loanTerm,loanPurpose,cellName,grossArea,productType,JsonHelper.formatJson(map)));
			return map;
		}
		loanApply.setMortgageMode(mortgageMode);
		try{
			int count = loanApplyService.insertSelective(loanApply);
			if(count==0){
				map.put(Const.retCode, false);
				map.put(Const.retMsg, "操作失败");//操作失败
				logger.info(String.format("insertLoanApply parameter : realName = %s ,mobile = %s,mortgageMode = %s,"
						+ "sel_province = %s,sel_city = %s,carModel = %s,vehicleRegistration = %s,loanAmount = %s，"
						+ "loanTerm = %s，loanPurpose = %s，cellName = %s,grossArea = %s,productType = %s --- return : map = %s", 
		    			realName,mobile,mortgageMode,sel_province,sel_city,carModel,vehicleRegistration,loanAmount,
		    			loanTerm,loanPurpose,cellName,grossArea,productType,JsonHelper.formatJson(map)));
				return map;
			}
		}catch(Exception e){
			logger.error("insertLoanApply", e);
			map.put(Const.retMsg, "操作失败");//操作失败
			logger.info(String.format("insertLoanApply parameter : realName = %s ,mobile = %s,mortgageMode = %s,"
					+ "sel_province = %s,sel_city = %s,carModel = %s,vehicleRegistration = %s,loanAmount = %s，"
					+ "loanTerm = %s，loanPurpose = %s，cellName = %s,grossArea = %s,productType = %s --- return : map = %s", 
	    			realName,mobile,mortgageMode,sel_province,sel_city,carModel,vehicleRegistration,loanAmount,
	    			loanTerm,loanPurpose,cellName,grossArea,productType,JsonHelper.formatJson(map)));
			return map;
		}
		map.put(Const.retCode, true);
		logger.info(String.format("insertLoanApply parameter : realName = %s ,mobile = %s,mortgageMode = %s,"
				+ "sel_province = %s,sel_city = %s,carModel = %s,vehicleRegistration = %s,loanAmount = %s，"
				+ "loanTerm = %s，loanPurpose = %s，cellName = %s,grossArea = %s,productType = %s --- return : map = %s", 
    			realName,mobile,mortgageMode,sel_province,sel_city,carModel,vehicleRegistration,loanAmount,
    			loanTerm,loanPurpose,cellName,grossArea,productType,JsonHelper.formatJson(map)));
		return map ;
	}
	/**
	 * 企业借贷页
	 * @return
	 */
	/*#RequestMapping(value = "/companyBorrow", method = RequestMethod.GET)*/
	public String companyBorrow(HttpServletRequest request){
		return "borrowMoney/companyBorrow";
	}
	
	
	/**
	 * 保存企业申请信息
	 * @param request
	 * @param realName
	 * @param mobile
	 * @param loanAmount
	 * @param loanTerm
	 * @param companyName
	 * @param ownedIndustry
	 * @param city
	 * @param setUpTime
	 * @param registeredCapital
	 * @param otherLoans
	 * @param loanpurpose
	 * @return
	 */
	@RequestMapping(value = "/insertEnterpriseApply", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object>  insertEnterpriseApply(HttpServletRequest request,
			@RequestParam("realName") String realName,
			@RequestParam("mobile") String mobile,
			@RequestParam("loanAmount") BigDecimal loanAmount,
			@RequestParam("loanTerm") Integer loanTerm,
			@RequestParam("companyName") String companyName,
			@RequestParam("ownedIndustry") String ownedIndustry,
			@RequestParam("city") String city,
			@RequestParam("setUpTime") String setUpTime,
			@RequestParam("registeredCapital") String registeredCapital,
			@RequestParam("otherLoans") String otherLoans,
			@RequestParam("loanpurpose") String	loanpurpose
		){
		logger.info(String.format("insertEnterpriseApply parameter : realName = %s ,mobile = %s,loanAmount = %s,"
				+ "loanTerm = %s,companyName = %s,ownedIndustry = %s,city = %s,setUpTime = %s，"
				+ "registeredCapital = %s，otherLoans = %s，loanpurpose = %s", 
    			realName,mobile,otherLoans,loanTerm,companyName,ownedIndustry,city,setUpTime,
    			registeredCapital,otherLoans,loanpurpose));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Map<String, Object> map = new HashMap<String, Object>();
		P2p_user user = SecurityUserHolder.getCurrentUser();
		if(null==user){
			map.put(Const.retCode, false);
			logger.info(String.format("insertEnterpriseApply parameter : realName = %s ,mobile = %s,loanAmount = %s,"
					+ "loanTerm = %s,companyName = %s,ownedIndustry = %s,city = %s,setUpTime = %s，"
					+ "registeredCapital = %s，otherLoans = %s，loanpurpose = %s --- return : map = %s", 
	    			realName,mobile,otherLoans,loanTerm,companyName,ownedIndustry,city,setUpTime,
	    			registeredCapital,otherLoans,loanpurpose,JsonHelper.formatJson(map)));
			return map;
		}
		try {
			String custNo = user.getPuCustNo();
			P2p_loan_apply  loanApply = new P2p_loan_apply();
			loanApply.setPpCustno(custNo);//客户号
			loanApply.setPpPrincipalname(realName);
			loanApply.setPpLoanapplymobile(mobile);
			loanApply.setPpCity(city);
			loanApply.setPpSetUpTime(sdf.parse(setUpTime));
			loanApply.setPpLoanamount(loanAmount);
			loanApply.setPpLoanterm(loanTerm);
			loanApply.setPpRegisteredCapital(registeredCapital);
			loanApply.setPpOtherLoans(otherLoans);
			loanApply.setPpLoanpurpose(loanpurpose);
			loanApply.setPpBorrowerType(Const.enterpriseApply);
			loanApply.setPpLoanapplytime(new Date());//借款时间
			loanApply.setPpApplytype(Integer.parseInt(Const.externalApplication));//外部发标
			loanApply.setPpLoanapplystatus(LoanApplyStatus.waitfristaudi.getIndex());
			try{
				int count = loanApplyService.insertSelective(loanApply);
				if(count==0){
					map.put(Const.retCode, false);
					map.put(Const.retMsg, "\u64cd\u4f5c\u5931\u8d25");//操作失败
					logger.info(String.format("insertEnterpriseApply parameter : realName = %s ,mobile = %s,loanAmount = %s,"
							+ "loanTerm = %s,companyName = %s,ownedIndustry = %s,city = %s,setUpTime = %s，"
							+ "registeredCapital = %s，otherLoans = %s，loanpurpose = %s --- return : map = %s", 
			    			realName,mobile,otherLoans,loanTerm,companyName,ownedIndustry,city,setUpTime,
			    			registeredCapital,otherLoans,loanpurpose,JsonHelper.formatJson(map)));
					return map;
				}
			}catch(Exception e){
				logger.error("insertEnterpriseApply", e);
				map.put(Const.retMsg, "\u64cd\u4f5c\u5931\u8d25");//操作失败
				logger.info(String.format("insertEnterpriseApply parameter : realName = %s ,mobile = %s,loanAmount = %s,"
						+ "loanTerm = %s,companyName = %s,ownedIndustry = %s,city = %s,setUpTime = %s，"
						+ "registeredCapital = %s，otherLoans = %s，loanpurpose = %s --- return : map = %s", 
		    			realName,mobile,otherLoans,loanTerm,companyName,ownedIndustry,city,setUpTime,
		    			registeredCapital,otherLoans,loanpurpose,JsonHelper.formatJson(map)));
				return map;
			}
			
		} catch (ParseException e1) {
			logger.error("insertEnterpriseApply", e1);
		}
		map.put(Const.retCode, true);
		logger.info(String.format("insertEnterpriseApply parameter : realName = %s ,mobile = %s,loanAmount = %s,"
				+ "loanTerm = %s,companyName = %s,ownedIndustry = %s,city = %s,setUpTime = %s，"
				+ "registeredCapital = %s，otherLoans = %s，loanpurpose = %s --- return : map = %s", 
    			realName,mobile,otherLoans,loanTerm,companyName,ownedIndustry,city,setUpTime,
    			registeredCapital,otherLoans,loanpurpose,JsonHelper.formatJson(map)));
		return map ;
	}
}
