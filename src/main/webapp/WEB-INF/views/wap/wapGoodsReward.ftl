<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/wapInviteFriends.css"/>
</head>
<body>
 	<div class="wrap">
        <header class="op-header">
            <p>实物记录</p>
           <a href="javascript:history.go(-1);" class="out-icon"></a>
           <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="content">
        	<!-- <div class="tabList bor_radius3 hiddenCon">
                <a class="tab active fl" href="javascript:void(0);" data-mode="1">实物记录</a>
            </div> -->
      	<form id="myForm" action="${basePath}/service/wapMessages/wapGoodsReward" method="post">
      		<input type="hidden" value="${pageNum}" name="pageNum" id="pageNum"/>
      	</form>
      	<!-- 实物记录 -->
      	<div class="friends">
      		    		<p><b>&nbsp;&nbsp;</b></p>
    		<ul class="physicalRecord">
    			<li class="recordTitle">
    				<span>活动名称</span>
    				<span>奖品名称</span>
    				<span class="registerTime" >获取时间</span>
    				<span>发放状态</span>
    				
    			</li>
    			<#if (list?? && list?size>0) >
	    			<#list list as item >
		    			<li>
		    				<span>${item.pae_activeName}</span>
		    				<span class="ellipsis2" title="${item.put_name}">${item.put_name}</span>
		    				<span class="registerTime">${item.pup_getTime?string("yyyy-MM-dd")}</span>
		    				<#if item.pup_status ==0>
		    					<span>未发放</span>
		    				<#elseif item.pup_status == 1>
		    					<span>已发放</span>
		    				</#if>
		    			</li>
	    			</#list>
    			</#if>
    		</ul>
    		<#if list?? && (list?size>0) >
	        <#else>
	        	<p class="no-record">暂无数据</p>
            </#if>
    	</div>
      	</div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    
</body>
</html>