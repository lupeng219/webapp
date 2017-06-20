<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>APP下载页</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/appDownload.css">
</head>
<body>
	<div class="wrap" id="content">
        <div class="appbg">
            <img src="${basePath}/images/wap/d_022.jpg"/>
            <img src="${basePath}/images/wap/applogo.png" id="back"/>
            <ul>
                <li id="andriodBtn"><img src="${basePath}/images/wap/d_07.png"></li>
                <li id="iosBtn"><img src="${basePath}/images/wap/d_06.png"></li>
            </ul>
        </div>
    </div>
    <div class="wrap page">
        <img id="andriodImg" src="${basePath}/images/wap/android.png">
        <img id="iosImg" src="${basePath}/images/wap/ios.png">
    </div>
    <script>
        $(".wrap").css("minHeight",document.documentElement.clientHeight+"px");
    </script>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/appDownload.js"></script>
</body>
</html>