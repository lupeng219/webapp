<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
    <title>用户注册-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/reg-login.css"/>
</head>
<body>
  <!--  <div class="reg-nav">
        <div class="container">
            <div class="reg-logo fl mt5">
                <a href="${basePath}">
                    <img src="${basePath}/images/log-logo.jpg"/>
                </a>
            </div>
            <h1 class="dp-inlineblock fl">欢迎注册</h1>
        </div>
    </div>
    -->
      <#include "./common/common_header.ftl" />
    <div class="log-main clientH">
        <div class="container">
         <div class="log-main-title clearfix">
                    <h1>新会员注册</h1>
                    <!--
                    <p>已有账号？ <a href="${basePath}/service/login">立即登录</a></p>
                    -->
           </div>
            <div class="reglog-txtcon">
               <div class='sideImg'></div>
                <ul class="reg-main-ui">
                    <li>
                        <div class="clearfix"><span class="reg-tip">手机号码</span>
                            <input type="text" class="reg-txt" id="mobile" maxlength="11" placeholder='请输入手机号码'/>
                            <p><span>*</span> 此手机号将用于登录，请正确输入！</p></div>
                        <p class="regerr-tip" id="mobile-regerr-tip"></p></li>
                    </li>
                    <li>
                        <div class="clearfix"><span class="reg-tip">验证码</span>
                            <input type="text" class="reg-txt" id="imgVer" style="width: 150px;" maxlength="5" placeholder='请输入验证码'/>
                            <img src="${basePath}/scaptcha" id="checkCodeImg" class="fl ml10" style="border: none;width:90px;height:39px;">
                            <a href="javascript:void(0);" class="fl ml10 mt10" id="changeCodeBtn">
                            	<img src="${basePath}/pictures/reg-login/update-yzm.png" />
                        	</a>
                        </div>
                        <p class="regerr-tip"></p></li>
                    </li>
                    <li>
                        <div class="clearfix"><span class="reg-tip">手机验证码</span>
                            <input type="text" class="reg-txt" id="verification" maxlength="6" placeholder='请输入手机验证码'/>
                            <a href="javascript:void(0);" class="hqyzm-btn" data-available="true">获取验证码</a>
                            <p><span></span></p></div>
                        <p class="regerr-tip" id='_verification'></p></li>
                    </li>
                    <li>
                        <div class="clearfix"><span class="reg-tip">登录密码</span>
                            <input type="password" class="reg-txt" id="password"  maxlength="20" placeholder='请输入登录密码' />
                            <p><span>*</span> 8-20位字符,密码由字母a-zA-Z及数字组成。</p></div>
                        <p class="regerr-tip"></p></li>
                    </li>
                    <li>
                        <div class="clearfix">
                        	<#if inviteCode?exists>
                        	<span class="reg-tip">邀请码</span>
                        		<input type="text" class="reg-txt" id="friendInviteCode" value="${inviteCode}" disabled="disabled" readOnly/>
                        	<#else>
                        	<span class="reg-tip">邀请人手机号</span>
                        		<input type="text" class="reg-txt" id="friendMobile" value="" maxlength="11" placeholder='请输入邀请人手机号'/>
                        		<p>非必填</p>
                        	</#if>
                        
                        </div>
                        <p class="regerr-tip" id="friendErr"></p>
                    </li>
                    <li class="mt10" style="height:40px;"><span class="reg-tip">&nbsp;</span>
                        <em class="cbo-xieyi iconbg discbo-xieyi"><!--<img src="${basePath}/pictures/reg-login/checkbox-unselected.png" id="agreement" data-value="false"/>--></em>
                        <p class="check-p">
                  	      	我已阅读并同意
                        <a href="${basePath}/service/agreement/registerAgreement" target="_blank">《佰宝金服用户隐私与注册服务协议》</a></p>
                    </li>
                    <li><span class="reg-tip">&nbsp;</span>
                        <a href="javascript:void(0);" class="reg-btn" data-available="true">立即注册</a>
                    </li>
                </ul>
                <div class=""></div>
            </div>
        </div>
    </div>
    
    <#include "./common/common_footer.ftl">
    
    <script>seajs.use("register");seajs.use("permainH");</script>
   <script src="${basePath}/js/public/reg-log-changeImg.js" type="text/javascript"></script>
    
</body>
</html>