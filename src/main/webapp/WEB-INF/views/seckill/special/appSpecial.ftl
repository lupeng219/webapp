<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/special/baibao-weixin.css"/>
</head>
<body>
	<div class="topbar border-b" id="top">
	    <div class="container">
	        <div class="fl">
	            <ul class="topui ml10">
	            	<li><a href="${basePath}" class="ml10">首页</a></li>
	                <li><em class="phone-icon iconbg"></em> <a href="${basePath}/service/dissertation/appSpecial" class="ml10">移动客户端</a></li>
	            </ul>
	        </div>
	        <div class="fr">
	            <ul class="topui">
	            	<#if Session["CURRENT_LOGIN_USER"]?exists>
					<li><a href="${basePath}/service/asset">欢迎回来 ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</a></li>
					<li><a href="${basePath}/service/login/logout">[退出]</a></li>
					<#else>
	                <li><a href="${basePath}/service/login">您好，请登录</a></li>
	                <li><a href="${basePath}/service/register">免费注册</a></li>
					</#if>
	                <li><a href="http://crm2.qq.com/page/portalpage/wpa.php?uin=4006888129&aty=0&a=0&curl=&ty=1" target="_blank">在线客服</a></li>
	                <li style="position:relative;">关注我们 
	                	<em class="wx-icon iconbg" style="cursor:pointer;"></em>
	                	<a href="http://weibo.com/baibao?from=myfollow_all" target="_blank"><em class="wb-icon iconbg"></em></a>
	                	<div class="twoDimensional" style="display: none;">
			                <div class="erwm">
			                    <img src="${basePath}/images/erweima.jpg">
			                </div>
			            </div>
			            <script type="text/javascript">
			            	$(".wx-icon").hover(function(){
						        $(".twoDimensional").show();
						    },function(){
						        $(".twoDimensional").hide();
						    });
			            </script>
	            	</li>
	            </ul>
	        </div>
	    </div>
	</div>
    <div class="ui-container">
        <div class="app-01"></div>
        <div class="app-02"></div>
        <div class="app-03"></div>
        <div class="app-04"></div>
        <div class="app-05">
            <div class="app-cont">
                <div class="btns">
                    <a href="javascript:void(0);" class="iphone-btn"></a>
                    <a href="javascript:void(0);" class="android-btn"></a>
                </div>
                <div class="ewmcont">
                    <img src="${basePath}/images/special/download-ewm.png" />
                </div>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl">
    <script>seajs.use("special/appSpecial");</script>
</body>
</html>