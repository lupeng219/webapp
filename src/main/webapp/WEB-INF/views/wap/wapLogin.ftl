<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/login-regsiter.css">
</head>
<body>
<div class="wrap">
        <header class="op-header">
            <p>登录</p>
            <a onclick="javascript:history.go(-1);" class="out-icon"></a>
        </header>
        <div class="form-txt">
            <div class="txt-cn">
                <input type="tel" class="txt login-txt" placeholder="请输入您的手机号" id="userName"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="password" class="txt login-txt" placeholder="请输入密码" id="password"/>
                <p class="err-p" id="passErr"></p>
            </div>
        </div>
        <div class="form-txt ">
            <p class="logion-btn" data-available="true"><a>登录</a></p>
        </div>
        <p class="desc1-con ">
            <span class="fl">没有账号？ <a href="${basePath}/service/wapRegister/toWapRegister" id="register">立即注册</a></span>
            <a href="${basePath}/service/wapLogin/wapFindPassWordOne" class="fr">忘记密码？</a>
        </p>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapLogin.js"></script>
</body>
</html>