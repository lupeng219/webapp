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
            <p>修改登录密码</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt">
            <div class="txt-cn">
                <input type="password" class="txt" placeholder="输入旧密码" id="oldPass"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="password" class="txt" placeholder="输入新密码,同时含字母和数字的6-20个字符" id="newPass"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="password" class="txt" placeholder="再次输入新密码" id="newPassSub"/>
                <p class="err-p" id="newPassSubErr"></p>
            </div>
        </div>
        <div class="form-txt txt-cn">
            <p class="logion-btn"><a href="javascript:void(0);">确定</a></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath}/js/wap/wapModifyLoginPassword.js"></script>
</body>
</html>