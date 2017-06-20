<!DOCTYPE html>
<html>
<head lang="en">
   <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/jiaoyijilu.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>交易记录</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
	<!--	<from action ="${basePath}/service/wapRecords/rechargeWithdraw" method="post" id="myFrom">
			<input type="hidden" value="${transType}" name="transType" />
			<input type="hidden" value="${pageNum}" name="pageNum" />
		</from>
	-->
		
        <div class="form-txt ">
            <div class="txt-cn">
                <input type="text" class="txt pointer selectType"
                 <#if result.transType=='10' >value="充值记录"</#if>
                 <#if result.transType=='11' >value="提现记录"</#if>
                 <#if result.transType=='40' >value="收益记录"</#if>
                 id="typeTxt" readonly/>
                 <!-- <#if result.transType=='50' >value="投资记录"</#if> -->
                <em class="down-icon selectType" id="typeEm"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit" style="display:none;" id="ui-banklsit">
                    <li data="10" class="cut">充值记录</li>
                    <li data="11">提现记录</li>
                    <li data="40">收益记录</li>
                   <!-- <li data="50">投资记录</li> -->
                </ul>
            </div>
        </div>
      <!--充值  -->
      <#if (result.transType!='50')>
	        <#if (result.list ?? && result.list?size>0)>
		        <#list result.list as item >
			        <ul class="ui-jiaoyi">
			            <li>
			                <div class="jiaoyi-con">
			                	<#if item.pafTransactiontype=='10'>
			                		 <span class="jiaoyi-type">充值</span>
			                	</#if>
			                	<#if item.pafTransactiontype=='11'>
			                		 <span class="jiaoyi-type">提现</span>
			                	</#if>
			                	<#if result.transType=='40'>
			                		 <span class="jiaoyi-type">收益</span>
			                	</#if>
			                    <span class="jiaoyi-num">
			                    	${item.pafTransactionmoney}元
			                    </span>
			                </div>
			
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-time">
			                    	${item.pafTransactiondatetime?string("yyyy-MM-dd hh:mm:ss")}
			                    </span>
			                </div>
			                 <#if (result.transType=='11') || (result.transType=='10')>
				                 	<div class="jiaoyi-con">
					                    <span class="jiaoyi-lsh"> 流水号：${item.pafTransflowno }</span>
					                    <#if item.pafStatus=='00'>
					                    	<span class="jiaoyi-ok">成功</span>
					                    </#if>
					                    <#if item.pafStatus=='01'>
					                   	 	<span class="jiaoyi-ok">失败</span>
					                    </#if>
					                    <#if item.pafStatus=='02'>
					                   	 	<span class="jiaoyi-ok">处理中</span>
					                    </#if>
				                	</div>
			                 <#else>
			                 		<div class="jiaoyi-con">
					                    <span class="jiaoyi-lsh"> 流水号：${item.pafTransflowno }</span>
					                    <#if item.pafStatus=='00'>
					                    	<span class="jiaoyi-ok">已收益</span>
					                    </#if>
					                    <#if item.pafStatus=='01'>
					                   	 	<span class="jiaoyi-ok">未收益</span>
					                    </#if>
					                    <#if item.pafStatus=='02'>
					                   	 	<span class="jiaoyi-ok">处理中</span>
					                    </#if>
			               			 </div>
			                 </#if>
			            </li>
			        </ul>
		        </#list>
	        </#if>
        </#if>
       <!-- =================================================================-->
      <!--投资  -->
      <!--
	      <#if (result.transType=='50')>
		        <#if (result.list ?? && result.list?size>0)>
			        <#list result.list as item >
				        <ul class="ui-jiaoyi">
				            <li>
				                <div class="jiaoyi-con">
				                    <span class="jiaoyi-type">投资</span>
				                    <span class="jiaoyi-num">
				                    	${item.pafTransactionmoney}元
				                    </span>
				                </div>
				
				                <div class="jiaoyi-con">
				                    <span class="jiaoyi-time">
				                    	${item.pafTransactiondatetime}
				                    </span>
				                </div>
				                
				                <div class="jiaoyi-con">
				                    <span class="jiaoyi-lsh"> 流水号：${item.pafTransflowno }</span>
				                    <#if item.pafStatus=='00'>
				                    	<span class="jiaoyi-ok">成功</span>
				                    </#if>
				                    <#if item.pafStatus=='01'>
				                   	 	<span class="jiaoyi-ok">失败</span>
				                    </#if>
				                    <#if item.pafStatus=='02'>
				                   	 	<span class="jiaoyi-ok">处理中</span>
				                    </#if>
				                </div>
				            </li>
				        </ul>
			        </#list>
		        </#if>
	        </#if>
        -->
        <#if (result.list ?? && result.list?size>0)>
         	<p class="page-wap mt10 mr5">
		       		<input type="hidden" value="${result.transType}" id="transType"/>
		         	<a href="javascript:void(0);" <#if (result.pageNum>=result.endNum)>class="notUse"  </#if>  data-pageNo="${(result.pageNum<result.endNum)?string(result.pageNum+1,result.endNum)}">下一页</a>
		      	  	<a href="javascript:void(0);"<#if (result.pageNum<=1)>class="notUse"  </#if> data-pageNo="${(result.pageNum>1)?string(result.pageNum-1,1)}">上一页</a>
        	</p>
		 <#else>
		    	 <center><p style="color: red">暂无数据</p></center>
		 </#if>
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath}/js/wap/webTransactionRecords.js"></script>
</body>
</html>