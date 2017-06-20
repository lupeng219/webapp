<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/jiaoyijilu.css">
    <style>
    	.touzi-list {
			font-size: 0.8rem;
			height: 2rem;
			line-height: 1.8rem;
		}
		.hkjh-a,.ckht-a{
			line-height: 1.4rem;
		}
    </style>
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>投资记录</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
		
		<form action = "${basePath}/service/wapBulkLoan/tenderRecordByCustNo" method="post" id="myFrom">
			<input type="hidden" value="${result.pageNum}" name="pageNum" />
			<input type="hidden" value="${result.bulkLoanStatus}" name="bulkLoanStatus" />
		</form>
		<form action = "${basePath}/service/wapBulkLoan/wapGetRepayments" method="post" id="myFromTwo">
			<input type="hidden" value="${item.ptr_tenderFlowNo}" name="tenderFlowNo"/>
    		<input type="hidden" value="${item.pp_loanTitle}" name="pp_loanTitle"/>
    		<input type="hidden" value="${result.bulkLoanStatus}" name="bulkLoanStatus"/>
    		<input type="hidden" value="${item.ptr_amount}" name="ptr_amount"/>
    		<input type="hidden" value="${item.capital_Interest}" name="capital_Interest"/>
		</form>
        <div class="form-txt ">
            <div class="txt-cn">
                <input type="text" class="txt selectType" placeholder="请选择查询类型" id="typeTxt"  readonly="readonly"
                	<#if result.bulkLoanStatus=='1'>value="投资中"</#if>
                	<#if result.bulkLoanStatus=='4'>value="回收中"</#if>
                	<#if result.bulkLoanStatus=='5'>value="已完成"</#if>
                />
                <em class="down-icon selectType" id="typeEm"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit " id="ui-banklsit" style="display: none;">
                    <li data-type="1">投资中</li>
                    <li data-type="4">回收中</li>
                    <li data-type="5">已完成</li>
                </ul>
            </div>
        </div>
        <div class="touzi-wrap">
        	<#if (result.list ?? && result.list?size>0) >
					<#list result.list as item >
			            <div class="touzi-con">
			                <p class="touzi-title-con">
			                    <span class="touzi-title ellipsis2" style="cursor:pointer;max-width:100%;" onclick="window.location.href='${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${item.ptr_productNo }'" title="${item.pp_loanTitle }">${item.pp_loanTitle }</span>
			                </p>
			                <p class="touzi-list">
			                	<span class="fl">
			                		投资本金<span class="touzi-benjin pl10">${item.ptr_amount}</span>元
			                	</span>
			                	<#if result.bulkLoanStatus=='1'>
			                		<span class="touzi-state fr">投标中</span>
			                	</#if>
			                	<#if result.bulkLoanStatus=='4'>
			                    	<a href="javascript:void(0);" class="hkjh-a" 
			                    		data-one="${item.ptr_tenderFlowNo}"
			                    		data-two="${item.pp_loanTitle}"
			                    	>
			                    		回款计划
			                    	</a>
			                    </#if>
			                    <#if result.bulkLoanStatus=='5'>
			                    	<a href="javascript:void(0);" class="hkjh-a"
			                    		data-one="${item.ptr_tenderFlowNo}"
			                    		data-two="${item.pp_loanTitle}"
			                    	>
			                    		回款计划
			                    	</a>
			                    </#if>
			                </p>
			                <p class="touzi-list">
				                <#if result.bulkLoanStatus=='1'>
				                	 <span class="pr10">借款编号</span>${item.ptr_productNo}
				                </#if>
				                <#if result.bulkLoanStatus=='4'>
				                	 <span class="pr10">应收本息</span> ${item.capital_Interest}元
				                </#if>
				                <#if result.bulkLoanStatus=='5'>
				                	 <span class="pr10">应收本息</span>${item.capital_Interest}元
				                </#if>
				                <#if result.bulkLoanStatus=='4'>
			                		<a href="javascript:void(0);" class="ckht-a"
			                    		data-one="${item.ptr_tenderFlowNo}"
			                    	>
			                    		查看协议
			                    	</a>
			                	</#if>
			                	<#if result.bulkLoanStatus=='5'>
			                		<a href="javascript:void(0);" class="ckht-a"
			                    		data-one="${item.ptr_tenderFlowNo}"
			                    	>
			                    		查看协议
			                    	</a>
			                	</#if>
			                </p>
			            </div>
			          </#list>
			          <p class="page-wap">
			          	<input type="hidden" value="${result.bulkLoanStatus}" id="bulkLoanStatus"/>
		            	<a href="javascript:void(0);" <#if (result.pageNum>=result.endNum)>class="notUse"</#if>  data-pageNo="${(result.pageNum<result.endNum)?string(result.pageNum+1,result.endNum)}">下一页</a>
		      	  		<a href="javascript:void(0);"<#if result.pageNum<=1>class="notUse" </#if> data-pageNo="${(result.pageNum>1)?string(result.pageNum-1,1)}">上一页</a>
	            	</p>
	        	</#if>
	       <#if !(result.list ?? && result.list?size>0) >
	       	<center><p style="color: red">暂无数据</p></center>
	       </#if>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" src="${basePath}/js/wap/wapBulkLoaningCreditor.js"></script>
</body>
</html>