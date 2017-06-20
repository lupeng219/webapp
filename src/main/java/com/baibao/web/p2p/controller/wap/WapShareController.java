package com.baibao.web.p2p.controller.wap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * APP客户端分享
 */
@Controller
@RequestMapping("/wapShare")
public class WapShareController {

    private static Logger log = LoggerFactory.getLogger(WapShareController.class);
    
    /**
     * APP下载_用户注册页
     * @param request
     * @return
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        return "/wap/shareRegister";
    };
    
    @RequestMapping("/download")
    public String download(HttpServletRequest request){
        return "/wap/shareDownload";
    };
}
