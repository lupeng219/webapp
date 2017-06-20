package com.baibao.web.p2p.utils;

import javax.servlet.http.HttpServletRequest;

public class MobileUtils {

    public static final int DEV_TYPE_IOS = 0;
    public static final int DEV_TYPE_ANDROID = 1;
    public static final int DEV_TYPE_OTHER = 2;

    /**
     * 获取到useragent
     * 
     * @return
     */
    public static String getUserAgent(HttpServletRequest request)
    {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) userAgent = "";
        return userAgent;
    }

    /**
     * 根据useragent判断是否是手机访问
     * 
     * @param userAgent
     * @return
     */
    public static int isMobile(HttpServletRequest request)
    {
        String userAgent = getUserAgent(request);
        int devType = MobileUtils.DEV_TYPE_OTHER;

        if (userAgent.indexOf("iPhone") > -1 || // iPhone
                userAgent.indexOf("iPod") > -1 || // || // iPod
                userAgent.indexOf("iPad") > -1 // iPad
        )
        {
            devType = MobileUtils.DEV_TYPE_IOS;
        }
        if (userAgent.indexOf("Android") > -1)
        {
            devType = MobileUtils.DEV_TYPE_ANDROID;
        }
        if (userAgent.indexOf("Eric") > -1 || // Ericsson WAP phones and
        // emulators
                userAgent.indexOf("WapI") > -1 || // Ericsson WapIDE 2.0
                userAgent.indexOf("MC21") > -1 || // Ericsson MC218
                userAgent.indexOf("AUR") > -1 || // Ericsson R320
                userAgent.indexOf("R380") > -1 || // Ericsson R380
                userAgent.indexOf("UP.B") > -1 || // UP.Browser
                userAgent.indexOf("WinW") > -1 || // WinWAP browser
                userAgent.indexOf("UPG1") > -1 || // UP.SDK 4.0
                userAgent.indexOf("upsi") > -1 || // another kind of UP.Browser
                userAgent.indexOf("QWAP") > -1 || // unknown QWAPPER browser
                userAgent.indexOf("Jigs") > -1 || // unknown JigSaw browser
                userAgent.indexOf("Java") > -1 || // unknown Java based browser
                userAgent.indexOf("Alca") > -1 || // unknown Alcatel-BE3 browser
                // (UP based)
                userAgent.indexOf("MITS") > -1 || // unknown Mitsubishi browser
                userAgent.indexOf("MOT-") > -1 || // unknown browser (UP based)
                userAgent.indexOf("My S") > -1 || // unknown Ericsson devkit
                // browser
                userAgent.indexOf("WAPJ") > -1 || // Virtual WAPJAG
                // www.wapjag.de
                userAgent.indexOf("fetc") > -1 || // fetchpage.cgi Perl script
                // from www.wapcab.de
                userAgent.indexOf("ALAV") > -1 || // yet another unknown UP
                // based browser
                userAgent.indexOf("Wapa") > -1 || // another unknown browser
                // (Web based "Wapalyzer")
                userAgent.indexOf("UCWEB") > -1 || // another unknown browser
                // (Web based "Wapalyzer")
                userAgent.indexOf("BlackBerry") > -1 || // another unknown
                // browser (Web based
                // "Wapalyzer")
                userAgent.indexOf("J2ME") > -1 || // another unknown browser
                // (Web based "Wapalyzer")
                userAgent.indexOf("Oper") > -1 || // 这个是iphone的
                userAgent.indexOf("Noki") > -1) // Noki
        {
            devType = MobileUtils.DEV_TYPE_OTHER;
        }
        return devType;
    }

}
