package com.baibao.web.p2p.controller.pay;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.utils.JaxbHelper;
import com.baibao.utils.JsonHelper;
import com.baibao.utils.Utils;
import com.baibao.web.p2p.controller.tender.TenderController;
import com.baibao.web.p2p.service.FuyouPayService;
import com.baibao.web.p2p.utils.AppCallLogUtil;
import com.baibao.web.p2p.utils.MobileUtils;

@Controller
public class FuyouController
{
	private static final Logger log = LoggerFactory.getLogger(FuyouController.class);
	
	@Autowired
	protected FuyouPayService fuyouPayService;

	@RequestMapping("/fuiou/phonechgn.do")
	public String phonechgn(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, String new_mobile, String signature,
		Model model)
	{
		log.info(String.format("phonechgn parameter : resp_code = %s, resp_desc = %s,mchnt_cd = %s, mchnt_txn_ssn = %s, login_id = %s, new_mobile = %s, signature = %s, model = %s", 
				resp_code, resp_desc,mchnt_cd, mchnt_txn_ssn,login_id, new_mobile,signature,JsonHelper.formatJson(model)));	
		FuyouResponse<CommonAnswer> result =
			fuyouPayService.changePhone(
				resp_code, resp_desc,
				mchnt_cd, mchnt_txn_ssn,
				login_id, new_mobile, signature);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));

		model.addAttribute("result", result);
		model.addAttribute("status", result.getMessage());
		
		log.info(String.format("phonechgn parameter : resp_code = %s, resp_desc = %s,mchnt_cd = %s, mchnt_txn_ssn = %s, login_id = %s, new_mobile = %s, signature = %s --- return : model = %s", 
				resp_code, resp_desc,mchnt_cd, mchnt_txn_ssn,login_id, new_mobile,signature,JsonHelper.formatJson(model)));	
		return "/personal/phone-success";
	}

	@RequestMapping("/fuiou/cardchgn.do")
	public String cardchgn(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn, String signature,
		Model model)
	{
		log.info(String.format("cardchgn parameter : resp_code = %s, resp_desc = %s,mchnt_cd = %s, mchnt_txn_ssn = %s, signature = %s, model = %s", 
				resp_code, resp_desc,mchnt_cd, mchnt_txn_ssn,signature,JsonHelper.formatJson(model)));	
		FuyouResponse<CommonAnswer> result =
			fuyouPayService.changeCard(
				resp_code, resp_desc,
				mchnt_cd, mchnt_txn_ssn, signature);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));

		model.addAttribute("result", result);
		model.addAttribute("status", result.getMessage());
		log.info(String.format("cardchgn parameter : resp_code = %s, resp_desc = %s,mchnt_cd = %s, mchnt_txn_ssn = %s, signature = %s --- return : model = %s", 
				resp_code, resp_desc,mchnt_cd, mchnt_txn_ssn,signature,JsonHelper.formatJson(model)));	
		return "/personal/card-success";
	}
	
	@ResponseBody
	@RequestMapping("/fuiou/depositNofity.fn")
	public ResponseEntity<String> depositNofity(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, String rem, Long amt, String signature,
		HttpServletRequest request)
	{
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, rem=%s, amt=%s, signature=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn, login_id,
			rem, amt, signature));

		for(String key: request.getParameterMap().keySet())
		{
			log.info(String.format("%s=%s",
				key, Utils.joinStr(
					request.getParameterMap().get(key), ", ")));
		}
		
		HttpHeaders headers = new HttpHeaders();

		String body = JaxbHelper.formatXml(
			fuyouPayService.depositNofity(
				resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
				login_id, rem, amt, signature));

		headers.add("Content-Type", "text/xml; charset=utf-8"); 

		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping("/fuiou/rechargeNofity.fn")
	public ResponseEntity<String> rechargeNofity(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, String rem, Long amt, String signature,
		HttpServletRequest request)
	{
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, rem=%s, amt=%s, signature=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn, login_id,
			rem, amt, signature));

		for(String key: request.getParameterMap().keySet())
		{
			log.info(String.format("%s=%s",
				key, Utils.joinStr(
					request.getParameterMap().get(key), ", ")));
		}
		
		HttpHeaders headers = new HttpHeaders();

		String body = JaxbHelper.formatXml(
			fuyouPayService.depositNofity(
				resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
				login_id, rem, amt, signature));

		headers.add("Content-Type", "text/xml; charset=utf-8"); 

		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
	}
	
	@RequestMapping("/fuiou/paynotify.do")
	public String paynotify(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, String rem, Long amt, String signature,
		Model model)
	{
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, rem=%s, amt=%s, signature=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn, login_id,
			rem, amt, signature));

		FuyouResponse<CommonAnswer> result =
			fuyouPayService.depositNofity(
				resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
				login_id, rem, amt, signature);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));
        

		model.addAttribute("result", result);
		model.addAttribute("status", result.getMessage());

		return "/personal/recharge-success";
	}

	@RequestMapping("/fuiou/quickpaynotify.do")
	public String quickpaynotify(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, String rem, Long amt, String signature,
		Model model)
	{
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, rem=%s, amt=%s, signature=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn, login_id,
			rem, amt, signature));

		FuyouResponse<CommonAnswer> result =
			fuyouPayService.appDepositNofity(
				resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
				login_id, amt, signature);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));
        

		model.addAttribute("result", result);
		model.addAttribute("status", result.getMessage());

		return "/personal/recharge-success";
	}
	
	@ResponseBody
	@RequestMapping("/fuiou/withdrawNofity.fn")
	public ResponseEntity<String> withdrawNofity(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, Long amt,
		String signature, HttpServletRequest request)
	{
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, amt=%s, signature=%s",
				resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
				login_id, amt, signature));

		for(String key: request.getParameterMap().keySet())
		{
			log.info(String.format("%s=%s",
				key, Utils.joinStr(
					request.getParameterMap().get(key), ", ")));
		}
		
		HttpHeaders headers = new HttpHeaders();

		String body = JaxbHelper.formatXml(
			fuyouPayService.withdrawNofity(
				resp_code, resp_desc, mchnt_cd,
				mchnt_txn_ssn, login_id, amt, signature, true));

		headers.add("Content-Type", "text/xml; charset=utf-8"); 

		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
	}

	@RequestMapping("/fuiou/withdrawnotify.do")
	public String withdrawnotify(
		String resp_code, String resp_desc,
		String mchnt_cd, String mchnt_txn_ssn,
		String login_id, Long amt,
		String signature, HttpServletRequest request, Model model)
	{
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, amt=%s, signature=%s, params=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
			login_id, amt, signature,
			AppCallLogUtil.dumpRequest(request)));

		FuyouResponse<CommonAnswer> result =
			fuyouPayService.withdrawNofity(
				resp_code, resp_desc, mchnt_cd,
				mchnt_txn_ssn, login_id, amt, signature, false);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));
        

		model.addAttribute("result", result);
		model.addAttribute("status", result.getMessage());

		return "/personal/withdraw-success";
	}
	
	@RequestMapping("/fuiou/apppaynotify.do")
    public String apppaynotify(
        String resp_code, String resp_desc,
        String mchnt_cd, String mchnt_txn_ssn,
        String login_id, String rem, Long amt, String signature, HttpServletRequest request,
        Model model)
    {
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, amt=%s, signature=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
			login_id, amt, signature));

        FuyouResponse<CommonAnswer> result =
            fuyouPayService.appDepositNofity(
                resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
                login_id, amt, signature);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));
        
        model.addAttribute("result", result);
        model.addAttribute("status", result.getMessage());
        model.addAttribute("devtype", MobileUtils.isMobile(request));

        return "/personal/app-recharge";
    }
	
	@RequestMapping("/fuiou/appwithdrawnotify.do")
    public String appwithdrawnotify(
        String resp_code, String resp_desc,
        String mchnt_cd, String mchnt_txn_ssn,
        String login_id, Long amt,
        String signature, HttpServletRequest request, Model model)
    {
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, amt=%s, signature=%s, params=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
			login_id, amt, signature,
			AppCallLogUtil.dumpRequest(request)));

        FuyouResponse<CommonAnswer> result =
            fuyouPayService.withdrawNofity(
                resp_code, resp_desc, mchnt_cd,
                mchnt_txn_ssn, login_id, amt, signature,false);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));
        
        model.addAttribute("result", result);
        model.addAttribute("status", result.getMessage());
        model.addAttribute("devtype", MobileUtils.isMobile(request));

        return "/personal/app-withdraw";
    }
	
	@RequestMapping("/fuiou/appchangecardnotify.do")
    public String appchangecardnotify(
            String resp_code, String resp_desc,
            String mchnt_cd, String mchnt_txn_ssn, String signature, HttpServletRequest request,
            Model model)
    {
		log.info(String.format("resp_code=%s, resp_desc=%s, mchnt_cd=%s, mchnt_txn_ssn=%s, login_id=%s, amt=%s, signature=%s",
			resp_code, resp_desc, mchnt_cd, mchnt_txn_ssn,
			signature));

	    FuyouResponse<CommonAnswer> result =
            fuyouPayService.changeCard(
                resp_code, resp_desc,
                mchnt_cd, mchnt_txn_ssn, signature);

        log.info(String.format(
        	"response=%s", JsonHelper.formatJson(result)));

        model.addAttribute("result", result);
        model.addAttribute("status", result.getMessage());
        model.addAttribute("devtype", MobileUtils.isMobile(request));

        return "/personal/app-card";
    }
}
