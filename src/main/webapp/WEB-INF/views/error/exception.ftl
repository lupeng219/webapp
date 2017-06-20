<!DOCTYPE html>
<html>
<head>
    <title>出错了</title>
    <#include "./common/common_src.ftl">
    <link href="${basePath }/css/err.css" rel="stylesheet" type="text/css" />
</head>
<body style="background:#F1F2F3">
    
    <#include "./common/common_header.ftl">
	<div class="container clientH">
	   <div class="clearfix err-bg">
	       <div class="ml20" style="text-align: center;">
	           <img src="${basePath}/pictures/exception/icon-UFO.png" style="width:240px;"/>
	       </div>
	       <div class="err-txt" style="text-align: center;">
	           <p>您访问的页面被不明星球的物种劫走了……</p>
	           <p>
	           <img src="${basePath}/pictures/exception/icon-home.png" style="margin-bottom:3px;"/>
	           <a href="${basePath}">
	           <span>回主页</span></a>
	           
	           <img src="${basePath}/pictures/exception/icon-Reload.png" style="margin-left:5px;margin-bottom:3px;"/>
	           <a href="javascript:history.go(-1);">
	           <span>上一步</span></a>
	           </p>
	       </div>
	   </div>
	</div>
	<#include "./common/common_footer.ftl" />

</body>
</html>