<div class="body-color">
    <div class="container">
	    <div class="aboutus-con">
	        <p class="ui-desc-title">媒体报道</p>
        	<#if paging.pageList??>
		        <#list paging.pageList as media>
			        <div class="ui-mtbd clearfix">
			         	<div class="ui-mtbd-con">
			         		<a href="${basePath}/service/aboutUs/newsDesc?noticeId=${media.articleID}">
			         			<img src="${media.paperCoverUrl}"/>
		         			</a>
	         			</div>
			            <div class="ui-mtbd-desc">
			                <p class="mtbd-name"><a href="${basePath}/service/aboutUs/newsDesc?noticeId=${media.articleID}">${media.articleTitle}</a></p>
			                <p class="gltd-time">${media.articlePushTime}　　${media.articleAuthor}</p>
			                <p class="gltd-desc">${media.introduction}......<a href="${basePath}/service/aboutUs/newsDesc?noticeId=${media.articleID}">[详情]</a></p>
			            </div>
		            </div>
		        </#list>
        	</#if>
	        <div class="clearfix">
	            <#include "./common/common_paging.ftl" />  
	    	</div>
	    </div>
	</div>
</div>