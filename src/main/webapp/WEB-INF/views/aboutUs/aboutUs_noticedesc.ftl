<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>网站公告-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="投资理财, 网络理财, 互联网理财, 佰宝金服, .com"/>
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
                <li><a href="${basePath}/service/aboutUs/news">媒体报道</a></li>
                <li class="current"><a href="${basePath}/service/aboutUs/notice">网站公告</a></li>
                <li><a href="${basePath}/service/aboutUs/staffcare">员工关怀</a></li>
                <li><a href="${basePath}/service/aboutUs/recruitment">招贤纳士</a></li>
                <li><a href="${basePath}/service/aboutUs/contact">联系我们</a></li>
                <li><a href="${basePath}/service/aboutUs/links">友情链接</a></li>
            </ul>

        </div>
    </div>
       <div class="body-color">
        <div class="container">
            <div class="aboutus-con">
               <div class="mtbd-nav"><span>${noticeDesc.articleTitle}</span></div>
                <p class="pt10 clearfix mt-p"><span class="fl"></span> <span class="fr"><#if noticeDesc.articlePushTime??>${noticeDesc.articlePushTime?string('yyyy-MM-dd HH:mm:ss')}</#if></span></p>
                <div class="mtbd-article mt20">
                    <p> ${noticeDesc.articleContents} </p>
                </div>
                <p class="textRt pt15"><a href="${basePath}/service/aboutUs/notice" class="orange">返回列表>></a></p>
            </div>

        </div>
    </div>
	<#include "./common/common_footer.ftl" />
</body>
</html>