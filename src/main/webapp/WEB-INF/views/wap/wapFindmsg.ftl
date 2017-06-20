<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/wapFindmsg.css">
</head>
<body>
	<div class="wrap">
        <header class="op-header">
            <p>消息中心</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <#if result.list ?? && (result.list?size>0) >
	            <a class="bianji">编辑</a>
	            <a class="quxiao">取消</a>
            </#if>
        </header>
        <div class="content">
        	<div>
        		<#list result.list as item>
        			<#if item.isRead==1>
        				<div class="sub">
		        			<input type="checkbox" value="${item.sysMsgID}"/>
		        			<span>${item.sysMsgContent}。</span>
        				</div>
        			<#else>
        				<!-- unread表示未读 -->
        				<div class="sub unread">
			        		<input type="checkbox" value="${item.sysMsgID}"/>
			        		<span>${item.sysMsgContent}。</span>
        				</div>
        			</#if>
        		</#list>
        		<div class="bottons">
        			<a id="toRead">设为已读</a><a id="toDelete">删除</a>
        		</div>
        	</div>
        	<p class="page-wap">
                 <#if result.list ?? && (result.list?size>0) >
		            <p class="page-wap">
		                <a href="javascript:void(0);" <#if (pageNum>=endNum)>class="notUse"</#if>  data-pageNo="${(pageNum<endNum)?string(pageNum+1,endNum)}">下一页</a>
		      	  		<a href="javascript:void(0);" <#if (pageNum<=1)>class="notUse"</#if> data-pageNo="${(pageNum>1)?string(pageNum-1,1)}">上一页</a>
		            </p>
		        <#else>
		        	<center><p style="color: red">暂无数据</p></center>
	            </#if>
            </p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapFindmsg.js"></script>
</body>
</html>