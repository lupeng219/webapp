<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <meta content="email=no" name="format-detection">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/appmodify.css"/>
    <script src="${basePath}/js/public/jquery-1.8.2.js" type="text/javascript"></script>
</head>

<body>
    <section class="wrapper">
        <section class="img">
            <#if status=='成功'>
            <img src="${basePath}/images/icon-successful-modification@3x.png" alt="">
            <#else>
            <img src="${basePath}/images/icon-modify-failed@3x.png" alt="">
            </#if>
        </section>
        <#if status=='成功'>
        <p class="remain-txt">修改成功！</p>
        <p class="subRemain-txt"></p>
        <#else>
        <p class="remain-txt">修改失败！</p>
        <p class="subRemain-txt">${status}</p>
        </#if>
        <section class="Btn">
            <a href="javascript:;" id="closeBtn">完成</a>
        </section>
    </section>
    <script src="${basePath}/js/baibao/setfontsize.js"></script>
    
    <script type="text/javascript">
		$(document).ready(function() {
    		$("#closeBtn").click(function() {
        		if('${devtype}' == "0")
                {
                    toMyWealth();
                }
                else
                {
                    window.robot.toMyWealth();
                }
    		});
		});
    </script>
</body>

</html>