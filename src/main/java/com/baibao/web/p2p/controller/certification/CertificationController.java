package com.baibao.web.p2p.controller.certification;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baibao.core.exception.BusinessException;
import com.baibao.utils.JsonHelper;
import com.baibao.web.p2p.comm.BaseLog;
import com.baibao.web.p2p.comm.Const;
import com.baibao.web.p2p.comm.SecurityUserHolder;
import com.baibao.web.p2p.comm.SessionUtils;
import com.baibao.web.p2p.generator.dataDIC.BusinessType;
import com.baibao.web.p2p.generator.dataDIC.RegistType;
import com.baibao.web.p2p.service.CustAccountService;

@Controller
@RequestMapping("/certification")
public class CertificationController {
    private static final Logger logger = LoggerFactory.getLogger(CertificationController.class);

    @Autowired
    private CustAccountService custAccountService;
    @Autowired
    private BaseLog baseLog;

    /**
     * 我的账户 - 实名认证
     */
    @RequestMapping("/certificationOperation")
    public @ResponseBody Map<String, Object> certificationOperation(HttpServletRequest request,
            @RequestParam("realName") String realName, @RequestParam("idCard") String idCard,
            @RequestParam("channel") String channel)
    {
        
    	logger.info(String.format("certificationOperation parameter : realName = %s ,idCard = %s,channel = %s", 
    			realName,idCard,channel));
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isEmpty(realName) || StringUtils.isEmpty(idCard))
        {
            result.put(Const.retCode, false);
            result.put(Const.retMsg, "\u53c2\u6570\u4e0d\u7b26\u5408\u89c4\u8303");// 参数不符合规范
            logger.info(String.format("certificationOperation parameter : realName = %s ,idCard = %s,channel = %s --- return : result = %s", 
        			realName,idCard,channel,JsonHelper.formatJson(result)));
            return result;
        }
                
        String custNo = SecurityUserHolder.getCurrentUser().getPuCustNo();
        Map<String, String> params = new HashMap<String, String>();
        params.put("real_name", realName);
        params.put("cert_no", idCard);
        
        try
        {
            result = custAccountService.activateNemberOrBindingVerify(custNo);
            if ((Boolean) result.get(Const.retCode))
            {
                result = custAccountService.certificationOperation(params, custNo);
                if ((Boolean) result.get(Const.retCode))
                {
                    SessionUtils.putAttrInSession(request, "isRealName", '0');
                    SessionUtils.putAttrInSession(request, "isRealNameAuth", 1);
                }
            }
            baseLog.writer(custNo, params.toString(), result.toString(), BusinessType.REALNAMEAUTHENTICATION.getDesc(),
                    RegistType.getName(Integer.parseInt(channel)), "/certification/certificationOperation");
            
        } catch (BusinessException e)
        {
            baseLog.writer(custNo, params.toString(), result.toString(), BusinessType.REALNAMEAUTHENTICATION.getDesc(),
                    RegistType.getName(Integer.parseInt(channel)), "/certification/certificationOperation");
            result.put("retCode", false);
            result.put("retMsg", "\u5b9e\u540d\u8ba4\u8bc1\u5931\u8d25");// 实名认证失败
            logger.error("certificationOperation", e);
        }
        logger.info(String.format("certificationOperation parameter : realName = %s ,idCard = %s,channel = %s --- return : result = %s", 
    			realName,idCard,channel,JsonHelper.formatJson(result)));
        return result;
    }

}
