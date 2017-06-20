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
            <p>重置密码</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
        </header>
        <div class="form-txt">
            <div class="txt-cn">
                <input type="password" class="txt" placeholder="输入密码，同时包含字母和数字的6-20位字符" id="password"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="password" class="txt" placeholder="请再次输入密码" id="rePassword"/>
                <p class="err-p" id="rePasswordErr"></p>
            </div>
            <input type="hidden" id="mobile" value="${mobile}"/>
        </div>
        <div class="form-txt txt-cn">
            <p class="logion-btn" data-available="true"><a>确定</a></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapFindPassWordTwo.js"></script>
</body>
</html>