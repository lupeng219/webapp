<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="投资理财, 互联网金融,  互联网理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/acitve-time.css"/>
</head>
<body>
  	<#include "./common/common_header.ftl" />
    <div class="invest-list-nav">
        <div class="container">
             <ul class="list-nav">
                <li><a href="${basePath}/service/aboutUs/company">公司简介</a></li>
                <li><a href="${basePath}/service/aboutUs/team">管理团队</a></li>
                <li><a href="${basePath}/service/aboutUs/qualification">资质荣誉</a></li>
                <li class="current"><a href="${basePath}/service/aboutUs/activeTimeAxis">往期活动</a></li>
                <li><a href="${basePath}/service/aboutUs/news">媒体报道</a></li>
                <li><a href="${basePath}/service/aboutUs/notice">网站公告</a></li>
                <li><a href="${basePath}/service/aboutUs/staffcare">员工关怀</a></li>
                <li><a href="${basePath}/service/aboutUs/recruitment">招贤纳士</a></li>
                <li><a href="${basePath}/service/aboutUs/contact">联系我们</a></li>
                <li><a href="${basePath}/service/aboutUs/links">友情链接</a></li>
            </ul>
        </div>
    </div>
	<div class=" sjz-wrap">
        <div class="container">
            <div class="timeline-con">
                <div class="f-pos-r">
                    <div class="top-jiao"></div>
                    <ul>
                         <#list activeList as active >
                         <#if active_index%2==0>
                        <li>
                            <div class="active-con con1">
                                <div class="active-time fl">
                                    <span><#if active.pae_starTime??>${active.pae_starTime?date?string("yyyy/MM/dd")}</#if></span>
                                    <span>-</span>
                                    <span><#if active.pae_endTime??>${active.pae_endTime?date?string("yyyy/MM/dd")}</#if></span>
                                    <#if active.status=="进行中">
	                                    <a class="jxz-d activeButton">${active.status}</a>
	                                <#else>
	                                    <a class="yjs-d activeButton">${active.status}</a>
	                                </#if>
                                </div>
                                <div class="active-jindu fl">
	                                <#if active.status=="进行中">
	                                    <i class="jxz-icon"></i>
	                                 <#else>
	                                    <i class="yjs-icon"></i>
	                                </#if>
                                </div>
                                <div class="active-img fl">
                                    <div class="a-img">
                                        <div class="img-j"></div>
                                          <a href="${basePath}${active.pae_linkAddress}"><img src="${active.pae_deatilPic}" width="100%" height="100%"/></a>

                                    </div>
                                </div>
                            </div>
                        </li>
                        <#else>
                        <li>
                            <div class="active-con con2">
                                <div class="active-img fl">
                                    <div class="a-img">
                                        <div class="img-j"></div>
                                         <a href="${basePath}${active.pae_linkAddress}"><img src="${active.pae_deatilPic}" width="100%" height="100%"/></a>

                                    </div>
                                </div>
                                <div class="active-jindu fl">
                                    <#if active.status=="进行中">
	                                    <i class="jxz-icon"></i>
	                                <#else>
	                                    <i class="yjs-icon"></i>
	                                </#if>
                                </div>
                                <div class="active-time fl">
                                    <span><#if active.pae_starTime??>${active.pae_starTime?date?string("yyyy/MM/dd")}</#if></span>
                                    <span>-</span>
                                    <span><#if active.pae_endTime??>${active.pae_endTime?date?string("yyyy/MM/dd")}</#if></span>
                                    <#if active.status=="进行中">
	                                    <a class="jxz-d activeButton">${active.status}</a>
	                                <#else>
	                                    <a class="yjs-d activeButton">${active.status}</a>
	                                </#if>
                                </div>
                            </div>
                        </li>
                        </#if>
                       </#list>
                    </ul>
                </div>
            </div>
        </div>
    </div>
	<#include "./common/common_footer.ftl" />
</body>
</html>