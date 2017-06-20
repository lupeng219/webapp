<head lang="en">
	<#include "./wap/common/wap_common_src.ftl" />
	<link rel="stylesheet" type="text/css" href="${basePath}/css/wap/investment.css">
</head>
<ul class="toubiao-ui">
	<#if (result.list ??) && (result.list?size>0)>
		<#list  result.list as item >
		   <li>
			   	<p class="toubiao-p">
			   		<span class="toubiao-person">
			   			${item.pu_mobile?substring(0,3)}****${item.pu_mobile?substring(8,11)}
			   		</span>
			   		<span class="toubiao-num">
			   			${item.ptrAmount}元
			   		</span>
			   	</p>
			    <p class="toubiao-time">
				    <#if item.ptrTranstime??>
				    	${item.ptrTranstime?string('yyyy-MM-dd HH:mm:ss')}
				    <#else>
				    	暂无数据
				    </#if>
			    </p>
		   </li>
		</#list>
			<p class="page-wap-two mt20">
                <a href="javascript:void(0);" <#if (result.pageNum>=result.endNum)>class="notUse"</#if>  data-pageNo="${(result.pageNum<result.endNum)?string(result.pageNum+1,result.endNum)}">下一页</a>
      	  		<a href="javascript:void(0);" <#if (result.pageNum<=1)>class="notUse"</#if> data-pageNo="${(result.pageNum>1)?string(result.pageNum-1,1)}">上一页</a>
            </p>
     <#else>
     	<li><p class="toubiao-p"><span class="toubiao-person">暂无数据</span></p></li>
     </#if>
</ul>