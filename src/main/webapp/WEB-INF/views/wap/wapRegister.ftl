<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/h5-login-regsiter.css">
</head>
<body>
	<div class="wrap">
        <header class="op-header">
            <p>注册</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
        </header>
        <div class="baibao-banner">
            <img src="${basePath }/images/wap/baibao-h5img1.png"/>
            <img src="${basePath }/images/wap/baibao-h5img2.png"/>
        </div>
        <div class="g-content">
            <div class="baibao-reg">
                <div class="txt-cn">
                    <input type="tel" class="txt" placeholder="请输入您的手机号" id="mobile"/>
                	<p class="err-p"></p>
                </div>
                <div class="txt-cn">
                    <input type="text" class="txt" placeholder="请输入验证码" id="imgVer" style="width:55%;display: inline-block;"/>
	                <img src="${basePath }/scaptcha" id="checkCodeImg">
	                <p class="err-p"></p>
                </div>
                <div class="txt-cn">
                    <input type="text" class="txt" placeholder="请输入手机验证码" id="verification"/>
                	<a class="hqyzm-btn" data-available="true">获取验证码</a>
                	<p class="err-p"></p>
                </div>
                <div class="txt-cn">
                    <input type="password" class="txt" placeholder="请输入密码，同时包含字母和数字6-20位字符" id="password"/>
                	<p class="err-p"></p>
                </div>
                <div class="txt-cn">
	            	<#if invitingMobile??>
	            		<input type="text" class="txt" placeholder="请输入邀请码" id="yqrsjh" value="${invitingMobile }" data="1" readOnly/>
	        		<#else>
	        			<input type="text" class="txt" placeholder="请输入邀请人手机号" id="yqrsjh" value="${invitingMobile }" data="0" />
	        			<span class="distip">非必填</span>
	        			<p class="err-p" id="yqrsjhErr"></p>
	            	</#if>
		        </div>
                <p class="desc-con hiddenCon"><em class="isread" id="isAgree"></em>
		            <span class="fl">同意<a href="javascript:void(0);" id="agreement">《佰宝金服注册协议》</a></span>
		            <span class="fr">已有账号?<a href="javascript:void(0);" id="login">立即登录</a></span>
		        </p>
                <div class="txt-cn">
                    <p class="logion-btn" data-available="true"><a href="javascript:void(0);">立即注册领取红包</a></p>
                </div>
            </div>
        </div>
        <div class="baibao-banner">
            <img src="${basePath }/images/wap/baibao-h5img4.png"/>
        </div>
        <div class="wap-footer" id="wap-footer" style="margin-top:0;">
		    <p class="kfrx-p">客服热线：<a href="tel://400-882-2170" style="color:#acb2c8;">400-882-2170</a></p>
		    <p class="footer-btn">
		        <a href="${basePath}/service/wapIndex/download">下载客户端</a>
		        <a href="${basePath}/service/wapLogin/wapAboutWe">关于我们</a>
		        <a href="${basePath}/service/index/index?type=pc">电脑版</a>
		    </p>
		    <p class="kfrx-p">中融佰诚投资管理有限公司 </p>
		    <p class="kfrx-p1"> © 2016 baibao.com 京ICP证 140570号</p>
		</div>
		<div class="projectWindowBg" style="display:none;"></div>
		<div id="contentLoading" style="display:none;position:fixed;z-index:99999;width:100%;height:100%;top:0;bottom:0;left:0;right:0;
			overflow: hidden;text-align:center;">
			<img src="${basePath}/images/loading.gif" style="margin-left:auto;margin-right:auto;width:30px;height:30px;"/>
		</div>
		<script type="text/javascript">
			var marginTop=document.documentElement.clientHeight/2-15;
			$("#contentLoading img").css("margin-top",marginTop+"px");
		</script>
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapRegister.js"></script>
</body>
</html>