<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>登录-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/reg-login.css"/>
</head>
<body>
<!--
    <div class="reg-nav">
        <div class="container">
            <div class="reg-logo fl mt5">
                <a href="${basePath}/">
                    <img src="${basePath}/images/log-logo.jpg"/>
                </a>
            </div>
            <h1 class="dp-inlineblock fl">欢迎登录</h1>
        </div>
    </div>
    -->
    <#include "./common/common_header.ftl" />
    <div class="login-bgcon">
        <div class="login-con">
            <div class="loginbg-txt mt50">
                <!--<h1>专业金融服务平台</h1>
                <h2>预期年化收益在<span class="pink font72" style="">12</span><span class="red">%</span></span>以上</h2>
                <ul class="ewm-ui">
                    <li><img src="${basePath}/images/baibao4-ewm.png"/>
                        <p>佰宝金服手机客户端</p></li>
                    <li><img src="${basePath}/images/ewm_03.jpg"/>
                        <p>佰宝金服微信服务号</p></li>
                </ul>-->
            </div>
            <div class="login-txtconbg">
                <h1>登 录</h1>
                <!-- 登陆页面标识-->
                <span style="display:none;">547c8052-8a84-41f5-81db-47e23dd298ce</span>
                <div style="padding:0 30px 0px 30px;">
                    <div class="login-txt-con mt10">
                       <div class="loginbg_img">
                       	<img src="${basePath}/pictures/reg-login/icon-user-name.png" id="changeImg" data-value="false"  >
                       </div>
                        <input type="text" class="login-txt"  placeholder="请输入手机号码" id="userName" maxlength="11" onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " />
                        <em class="name-icon iconbg"></em>
                        <p class="err-tip" id="userNameErr"></p>
                    </div>
                    <div class="login-txt-con">
                    	<div class="loginbg_img" >
                    		<img src="${basePath}/pictures/reg-login/icon-password.png" id="changeImg" data-value="false" >
                    	</div>
                        <input type="password" class="login-txt"  placeholder="请输入密码" id="password" maxlength="20" onkeyup="this.value=$.trim($(this).val())" />
                      	
                        <em class="pass-icon iconbg"></em>
                        <p class="err-tip" id="passwordErr"></p>
                    </div>
                    <p class="yhmlock-p"><em class="yhm-lock iconbg"><img src="${basePath}/pictures/reg-login/checkbox-unselected.png" id="agreement" data-value="false" style="margin-right:10px"/></em>
                    <span class="fl"><!--<input type="Checkbox" name="rmUsername" value="username">-->记住用户名</span>
                    <a href="${basePath}/service/login/backLoginPassword" class="fr">忘记密码</a></p>
                    <a href="javascript:void(0);" class="ljdl-btn" data-available="true">立即登录</a>
                    <p class="mfzc-p">没有账号？ <a href="${basePath}/service/register">免费注册</a> </p>
                </div>
            </div>
        </div>
    </div>
	<#include "./common/common_footer.ftl" />
    <script>seajs.use("login");</script>
	<script type="text/javascript">
		
		$("#index-sider").remove();
		
	</script>
    <script src="${basePath}/js/public/reg-log-changeImg.js" type="text/javascript"></script>
</body>
</html>