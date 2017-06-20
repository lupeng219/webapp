<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <meta content="email=no" name="format-detection">
    <link rel="stylesheet" type="text/css" href="${basePath}/css/apprecharge.css"/>
    <script src="${basePath}/js/public/jquery-1.8.2.js" type="text/javascript"></script>
    <title>Document</title>
</head>

<body>
    <section class="wrapper">
        <section class="img">
            <#if status=='成功'>
            <img src="${basePath}/images/icon-recharge-success@3x.png" alt="">
            <#else>
            <img src="${basePath}/images/icon-recharge-failure@3x.png" alt="">
            </#if>
        </section>
        <#if status=='成功'>
            <p class="remain-txt">充值成功！</p>
            <p class="subRemain-txt"></p>
        <#else>
            <p class="remain-txt">充值失败！</p>
        	<p class="subRemain-txt">${status}</p>
        </#if>
        <section class="rechargeBtn">
        	<#if status=='成功'>
            <a href="javascript:;" id="closeBtn">立即投资</a>
            <#else>
            <a href="javascript:;" id="errorBtn">继续充值</a>
            </#if>
        </section>
    </section>
    <script src="${basePath}/js/baibao/setfontsize.js"></script>
    
    <script type="text/javascript">
        <#if status=='成功'>
		$(document).ready(function() {
    		$("#closeBtn").click(function() {
        		if('${devtype}' == "0")
                {
                    toInvestList();
                }
                else
                {
                    window.robot.toInvestList();
                }
    		});
		});
		<#else>
		$(document).ready(function() {
    		$("#errorBtn").click(function() {
        		if('${devtype}' == "0")
                {
                    finishPage();
                }
                else
                {
                    window.robot.finishPage();
                }
    		});
		});
		</#if>
    </script>
</body>

</html>