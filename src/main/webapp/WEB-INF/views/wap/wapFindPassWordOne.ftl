<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/login-regsiter.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>找回密码</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
        </header>
        <div class="form-txt">
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入您的手机号" id="mobile"/>
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
                <p class="err-p" id="verificationErr"></p>
            </div>
        </div>
        <div class="form-txt txt-cn">
            <p class="logion-btn" data-available="true"><a>下一步</a></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapFindPassWordOne.js"></script>
</body>
</html>