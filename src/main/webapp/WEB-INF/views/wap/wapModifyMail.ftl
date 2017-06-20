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
            <p>邮箱设置</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt">
        	<#if isFirst=='1'>
	            <div class="txt-cn">
	                <input type="text" class="txt" placeholder="输入旧邮箱" id="oldPass"/>
	                <p class="err-p"></p>
	            </div>
            </#if>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="输入新邮箱" id="newPass"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="输入验证码" id="newPassSub"/>
                <a class="hqyzm-btn" data-available="true">获取验证码</a>
                <p class="err-p" id="newPassSubErr"></p>
                <input type="hidden" value="${isFirst}" id="isFirst">
            </div>
        </div>
        <div class="form-txt txt-cn">
            <p class="logion-btn"><a href="javascript:void(0);">确定</a></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath}/js/wap/wapModifyMail.js"></script>
</body>
</html>