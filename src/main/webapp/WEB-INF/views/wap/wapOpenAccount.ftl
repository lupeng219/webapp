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
            <p>实名认证</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt">
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入真实姓名" id="realName"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入身份证号码" id="idCard"/>
                <p class="err-p" id="idCardErr"></p>
            </div>
            <p class="wxts-p">温馨提示：对接银行金融认证系统，不涉及个人隐私泄露，保障用户的资金安全和权益。</p>
        </div>
        <div class="form-txt txt-cn" style="height:2.6rem;">
            <p class="logion-btn" data-available="true"><a href="javascript:void(0);">开通</a></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapOpenAccount.js"></script>
</body>
</html>