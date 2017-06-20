<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>媒体报道- 理财-就选佰宝金服，互联网专业投资平台，优质金融服务 。.com</title>
	<meta name="description" content="佰宝金服平台公告，最新最详细的平台动态悉数发布，以真诚透明为目标，保证相关数据真实有效。"/>
	<meta name="keywords" content="互联网金融,  网络理财, 互联网理财,佰宝金服,科技金融,互联网金融,全球资产配置,智能投顾,.com"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/about-us.css"/>
</head>
<body>
  	<#include "./common/common_header.ftl" />
      <div class="invest-list-nav">
        <div class="container">
             <ul class="list-nav">
                <li><a href="${basePath}/service/aboutUs/company">公司简介</a></li>
                <li><a href="${basePath}/service/aboutUs/team">管理团队</a></li>
                <li><a href="${basePath}/service/aboutUs/qualification">资质荣誉</a></li>
                <li><a href="${basePath}/service/aboutUs/activeTimeAxis">往期活动</a></li>
                <li class="current"><a href="${basePath}/service/aboutUs/news">媒体报道</a></li>
                <li><a href="${basePath}/service/aboutUs/notice">网站公告</a></li>
                <li><a href="${basePath}/service/aboutUs/staffcare">员工关怀</a></li>
                <li><a href="${basePath}/service/aboutUs/recruitment">招贤纳士</a></li>
                <li><a href="${basePath}/service/aboutUs/contact">联系我们</a></li>
                <li><a href="${basePath}/service/aboutUs/links">友情链接</a></li>
            </ul>

        </div>
    </div>
    <div class="body-color">
        <div class="container">
        	<#if newsDesc??>
            <div class="aboutus-con">
                <div class="mtbd-nav"><span>${newsDesc.articleTitle}</span></div>
                <p class="pt10 clearfix mt-p"><span class="fl">${newsDesc.articleTitle}</span> <span class="fr"><#if newsDesc.articlePushTime??>${newsDesc.articlePushTime?string('yyyy-MM-dd HH:mm:ss')}</#if></span></p>
                <div class="mtzx-imgcon"><img src="${newsDesc.paperCoverUrl}"/></div>
                <div class="mtbd-article mt20">
                    <p>${newsDesc.articleContents} </p>
                </div>
                <p class="textRt pt15"><a href="${basePath}/service/aboutUs/news" class="orange">返回列表>></a></p>
            </div>
		</#if>
        </div>
    </div>
    
<#include "./common/common_footer.ftl" />
</body>
</html>