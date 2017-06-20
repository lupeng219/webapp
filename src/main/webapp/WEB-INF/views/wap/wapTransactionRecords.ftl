<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/jiaoyijilu.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>交易记录</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath }/service/webaccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt">
            <div class="txt-cn">
            	<#if result.type==1>
            		<input type="text" class="txt pointer selectType" value="充值记录" id="typeTxt" readonly/>
        		<#elseif result.type==2>
        			<input type="text" class="txt pointer selectType" value="提现记录" id="typeTxt" readonly/>
        		<#elseif result.type==3>
        			<input type="text" class="txt pointer selectType" value="投标记录" id="typeTxt" readonly/>
        		<#elseif result.type==4>
        			<input type="text" class="txt pointer selectType" value="收益记录" id="typeTxt" readonly/>
            	</#if>
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
      	<#if result.type==1>
        	<#if result.rechargeList?exists>
        		<#list result.rechargeList as item>
			        <ul class="ui-jiaoyi">
			            <li>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-type">充值</span>
			                    <span class="jiaoyi-num">${item.chargeMoney?string("###,###,###,###.00")}元</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-time">${item.chargeTime?string("yyyy-MM-dd HH:mm:ss")}</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-lsh"> 流水号：${item.chargeFlowNo }</span>
			                    <#if item.chargeStatus==0>
			                    	<span class="jiaoyi-ok">成功</span>
		                    	<#elseif item.chargeStatus==1>
			                    	<span class="jiaoyi-ok">失败</span>
		                    	<#elseif item.chargeStatus==2>
			                    	<span class="jiaoyi-ok">处理中</span>
			                    </#if>
			                </div>
			            </li>
			        </ul>
        		</#list>
        	</#if>
        </#if>
        <!--提现  -->
        <#if result.type==2>
         	<#if result.withdrawCashList?exists>
        		<#list result.withdrawCashList as item>
			        <ul class="ui-jiaoyi">
			            <li>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-type">提现</span>
			                    <span class="jiaoyi-num">${item.getAmount?string("###,###,###,###.00")}"元</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-time">${item.getDate?string("yyyy-MM-dd HH:mm:ss")}</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-lsh"> 流水号：${item.withDrawFlowNo }</span>
			                    <#if item.getState==0>
			                    	<span class="jiaoyi-ok">成功</span>
		                    	<#elseif item.getState==1>
		                    		<span class="jiaoyi-ok">失败</span>
		                    	<#elseif item.getState==2>
		                    		<span class="jiaoyi-ok">处理中</span>
			                    </#if>
			                </div>
			            </li>
			        </ul>
        		</#list>
        	</#if>
        </#if>
        <!--投资  -->
        <#if result.type==3>
         	<#if result.investmentList?exists>
        		<#list result.investmentList as item>
			        <ul class="ui-jiaoyi">
			            <li>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-type">投资</span>
			                    <span class="jiaoyi-num">${item.bidAmount?string("###,###,###,###.00")}元</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-time">${item.bidTime?string("yyyy-MM-dd HH:mm:ss")}</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-lsh"> 流水号：${item.buklFlowNo }</span>
			                    <#if item.bulkStatus==0>
			                    	<span class="jiaoyi-ok">成功</span>
		                    	<#elseif item.bulkStatus==1>
			                    	<span class="jiaoyi-ok">失败</span>
		                    	<#elseif item.bulkStatus==2>
			                    	<span class="jiaoyi-ok">处理中</span>
			                    </#if>
			                </div>
			            </li>
			        </ul>
        		</#list>
        	</#if>
        </#if>
        <!--收益  -->
        <#if result.type==4>
         	<#if result.profitList?exists>
        		<#list result.profitList as item>
			        <ul class="ui-jiaoyi">
			            <li>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-type">收益</span>
			                    <span class="jiaoyi-num">${item.infactEarnInterest?string("###,###,###,###.00")}元</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-time">${item.infactRepaymentTime?string("yyyy-MM-dd HH:mm:ss")}</span>
			                </div>
			                <div class="jiaoyi-con">
			                    <span class="jiaoyi-lsh"> 流水号：${item.bidEarnFlowNo }</span>
			                    <#if item.repaymentStatus==0>
			                    	<span class="jiaoyi-ok">未收益</span>
		                    	<#elseif item.repaymentStatus==1>
			                    	<span class="jiaoyi-ok">成功</span>
		                    	<#elseif item.repaymentStatus==2>
			                    	<span class="jiaoyi-ok">处理中</span>
			                    </#if>
			                </div>
			            </li>
			        </ul>
        		</#list>
        	</#if>
        </#if>
        <#if result.msg=='暂时没有数据!'>
        	<center><p style="color: red">暂时没有数据</p></center>
    	<#else>
    		<p class="page-wap mt10 mr5">
	       		<input type="hidden" value="${result.type}" id="types"/>
	         	<a href="javascript:void(0);" <#if result.cursor>=result.endNum>class="notUse"</#if> data-pageNo="${result.cursor<result.endNum?result.cursor+1:result.endNum}">下一页</a>
	      	  	<a href="javascript:void(0);" <#if result.cursor<=1>class="notUse"</#if> data-pageNo="${result.cursor>1?result.cursor-1:1}">上一页</a>
	        </p>
        </#if>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapTransactionRecords.js"></script>
</body>
</html>