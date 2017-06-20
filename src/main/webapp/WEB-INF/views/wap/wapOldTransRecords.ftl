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
            <p>旧版交易记录</p>
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
                 <#if transType??>
                 	 <#if transType=='1' >value="充值记录"</#if>
	                 <#if transType=='2' >value="提现记录"</#if>
	                 <#if transType=='3' >value="投资记录"</#if>
	                 <#if transType=='4' >value="收益记录"</#if>
                 <#else>
                 		value="请选择"
                 </#if>
                 id="typeTxt" readonly/>
                 <!-- <#if result.transType=='50' >value="投资记录"</#if> -->
                <em class="down-icon selectType" id="typeEm"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit" style="display:none;" id="ui-banklsit">
                    <li data="1" class="cut">充值记录</li>
                    <li data="2">提现记录</li>
                    <li data="3">投资记录</li>
                    <li data="4">收益记录</li>
                </ul>
            </div>
        </div>
      <!--充值  -->
	        <#if (list ?? && list?size>0)>
		        <#list list as item >
			        <ul class="ui-jiaoyi">
			            <li>
			                <div class="jiaoyi-con">
			                	<#if item.remarks=='1'>
			                		 <span class="jiaoyi-type">充值</span>
			                	</#if>
			                	<#if item.remarks=='2'>
			                		 <span class="jiaoyi-type">提现</span>
			                	</#if>
			                	<#if item.remarks=='3'>
			                		 <span class="jiaoyi-type">投资</span>
			                	</#if>
			                	<#if item.remarks=='4'>
			                		 <span class="jiaoyi-type">收益</span>
			                	</#if>
			                    <span class="jiaoyi-num">
			                    	${item.chargeMoney}元
			                    </span>
			                </div>
			
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-time">
			                    	${item.chargeTime?string("yyyy-MM-dd hh:mm:ss")}
			                    </span>
			                </div>
			                 	<div class="jiaoyi-con">
				                    <span class="jiaoyi-lsh"> 流水号：${item.chargeFlowNo }</span>
				                    <#if item.chargeStatus=='0'>
				                    	<span class="jiaoyi-ok">成功</span>
				                    </#if>
				                    <#if item.chargeStatus=='1'>
				                   	 	<span class="jiaoyi-ok">失败</span>
				                    </#if>
				                    <#if item.chargeStatus=='2'>
				                   	 	<span class="jiaoyi-ok">处理中</span>
				                    </#if>
			                	</div>
			            </li>
			        </ul>
		        </#list>
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
        <#if (list ?? && list?size>0)>
         	<p class="page-wap mt10 mr5">
		       		<input type="hidden" value="${transType}" id="transType"/>
		         	<a href="javascript:void(0);" <#if (pageNum>=endNum)>class="notUse"  </#if>  data-pageNo="${(pageNum<endNum)?string(pageNum+1,endNum)}">下一页</a>
		      	  	<a href="javascript:void(0);"<#if (pageNum<=1)>class="notUse"  </#if> data-pageNo="${(pageNum>1)?string(pageNum-1,1)}">上一页</a>
        	</p>
		 <#else>
		    	 <center><p style="color: red">暂无数据</p></center>
		 </#if>
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath}/js/wap/wapOldTransRecords.js"></script>
</body>
</html>