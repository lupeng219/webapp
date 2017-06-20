<!DOCTYPE html>
<html>
<head lang="en">
	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/investment.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>投标列表</p>
             <a href="javascript:history.go(-1);" class="out-icon"></a>
          	 <#if Session.CURRENT_LOGIN_USER ??>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>
		
		<div class="form-txt">
            <div class="tztxt-cn1 bor_radius3 hiddenCon">
                <a class="tab <#if type ==1>active </#if>fl" href="${basePath}/service/wapBulkLoan/ProductListByType?type=1">新手专享</a>
                <a class="tab <#if type !=1>active </#if> fl" href="${basePath}/service/wapBulkLoan/showProductList">投资项目</a>
            </div>
        </div>
        
	
        <div class="form-txt ">
       
        <form action=<#if type==1>"${basePath}/service/wapBulkLoan/ProductListByType"</#if> 
        <#if type!=1>"${basePath}/service/wapBulkLoan/showProductList"</#if> 
        method="post" id="myFromss">
        	<input type="hidden" value="${bulkStatus}" name="bulkStatus"/>
        	<input type="hidden" value="${pageNum}" name="pageNum"/>
        	<input type="hidden" value="${pageSize}" name="pageSize"/>
        	<input type="hidden" value="${type}" name="type" id="type"/>
        </from>
            <div class="tztxt-cn">
                <input type="text" class="tztxt selectType" placeholder="请选择查询类型" id="typeTxt" readonly="readonly"
	        		<#if bulkStatus==1>value="可投标"</#if>
	                <#if bulkStatus==2>value="已满标"</#if>
	                <#if bulkStatus==4>value="还款中"</#if>
	                <#if bulkStatus==5>value="已完成"</#if>
                />
                <em class="down-icon" id="typeEm"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit" style="display:none;" id="ui-banklsit">
                    <li data-bulkStatus="1">可投标</li>
                    <li data-bulkStatus="2">已满标</li>
                    <li data-bulkStatus="4">还款中</li>
                    <li data-bulkStatus="5">已完成</li>
                </ul>
            </div>
        </div>
        <div class="touzi-wrap">
        	<#if list ?? && (list?size>0) >
        		<#list list as item>
		            <div class="touzi-con">
		                <p class="touzi-title-con">
		                    <span class="touzi-title">${item.ppLoantitle}</span>
		                    <span class="list-jindu">
		                    <#if item.ppBulkloanstatus==1>
			                      <#if ((item.progress*100)>0) && ((item.progress*100)<=1)>
			                        	<span class="list-jinduline">1%
			                        	<input type="hidden" value="1" name="jindu"/>
			                        	</span>
			                       <#else>
			                       		<span class="list-jinduline">${(item.progress*100)?floor}%
			                       			<input type="hidden" value="${(item.progress*100)?floor}" name="jindu"/>
			                       		</span>
			                       </#if>
		                      <#else>
		                      		<span class="list-jinduline">100%
			                       			<input type="hidden" value="100" name="jindu"/>
			                       	</span>
		                      </#if>
		                    </span>
		                </p>
		                <ul class="ui-listbiao">
		                    <li><p class="list-t">金额(元)</p>
		                        <p class="list-d">${item.ppLoanamount}</p></li>
		                    <li><p class="list-t">期限</p>
		                        <p class="list-d">${item.ppLoanterm}<#if item.ppLoanrepayment==2>天<#else>个月</#if></p></li>
		                    <li><p class="list-t">年利率</p>
		                        <p class="list-d">${item.ppComprehensiverate}%</p></li>
		                    <li style="border:0;">
		                    	<p class="list-t">还款方式</p>
		                    	<#if item.ppLoanrepayment==1>
		                    		 <p class="list-d">先息后本</p>
		                    	<#elseif item.ppLoanrepayment==0>
		                    		 <p class="list-d">等额本息</p>
	                    		 <#elseif item.ppLoanrepayment==2>
		                    		 <p class="list-d">按天计息</p>
                                 <#elseif item.ppLoanrepayment==3>
                                     <p class="list-d">等额本金</p>
                                 <#elseif item.ppLoanrepayment==3>
                                     <p class="list-d">先息后本</p>
		                    	</#if>
		                    </li>
		                </ul>
		                <#if item.type ==1>
		                	<#if item.ppBulkloanstatus==1> <a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${item.ppProductno}"><p class="logion-btn" style="color: white;">我要投标</p></a></#if>
		                	<#if item.ppBulkloanstatus==2> <a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${item.ppProductno}"><p class="logion-btn manbiao-btn" style="color: white;">已满标</p></a></#if>
		                	<#if item.ppBulkloanstatus==4> <a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${item.ppProductno}"><p class="logion-btn manbiao-btn" style="color: white;">还款中</p></a></#if>
		                	<#if item.ppBulkloanstatus==5> <a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${item.ppProductno}"><p class="logion-btn manbiao-btn" style="color: white;">已完成</p></a></#if>
		                <#elseif item.type ==2>
		                	<#if item.ppBulkloanstatus==5> <a href="${basePath}/service/wapBulkLoan/wapProductDetail?productNo=${item.ppProductno}"><p class="logion-btn manbiao-btn" style="color: white;">已完成</p></a></#if>
		                </#if>
		            </div>
		         </#list>
            </#if>
            <#if list ?? && (list?size>0) >
	            <p class="page-wap">
	                <a href="javascript:void(0);" <#if (pageNum>=endNum)>class="notUse"</#if>  data-pageNo="${(pageNum<endNum)?string(pageNum+1,endNum)}">下一页</a>
	      	  		<a href="javascript:void(0);" <#if (pageNum<=1)>class="notUse"</#if> data-pageNo="${(pageNum>1)?string(pageNum-1,1)}">上一页</a>
	            </p>
	        <#else>
	        	<center><p style="color: red">暂无数据</p></center>
            </#if>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapBulkLoan.js"></script>
</body>
</html>