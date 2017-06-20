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
            <p>投标</p>
           <a href="javascript:history.go(-1);" class="out-icon"></a>
           <#if Session["CURRENT_LOGIN_USER"]?exists>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>

        <div class="form-txt">
            <div class="investment-con">
                <p class="biao-title-con">
                	<span class="biao-title ui-tiptitle ellipsis2" title="${result.loanTitle}" style="max-width:80%;">${result.loanTitle}</span>
                    <span class="biao-state">
                    	<#if result.bulkLoanStatus==1> (投标中)</#if>
                    	<#if result.bulkLoanStatus==2> (已满标)</#if>
                    	<#if result.bulkLoanStatus==4> (还款中)</#if>
                    	<#if result.bulkLoanStatus==5> (已完成)</#if>
                    </span>
                </p>
                <#if result.bulkLoanStatus==1>
	                <ul class="ui-investment clearfix">
	                	<li><span class="ui-tiptitle">借款标题</span> <span class="ui-tiptitle ellipsis2" title="${result.loanTitle}" style="width:50%;">${result.loanTitle}</span></li>
	                    <li><span class="ui-tiptitle">金额</span> ${result.loanAmount}元</li>
	                   	<#if result.ppLoanrepayment==2>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}天</li>
	                    <#else>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}个月</li>
	                    </#if>
	                    <li><span class="ui-tiptitle">年利率</span> ${result.comprehensiveRate}%</li>
	                    <li><span class="ui-tiptitle">还款方式</span> ${result.loanRepayment}</li>
	                    <li>
	                    	<span class="ui-tiptitle">投标进度</span>
	                    	<span class="jindu">
		                        <span class="jinduline">
		                        	<#if ((result.jindu*100)>0 && (result.jindu*100)<=1)>
		                        		<input type="hidden" value="1" name="jindu">
		                        		1%
		                        	<#else>
		                        		${(result.jindu*100)?floor}%
		                        		<input type="hidden" value="${(result.jindu*100)?floor}" name="jindu">
		                        	</#if>
		                        	
		                        </span>
	                    	</span>
	                    </li>
	                    <li>
	                    	<span class="ui-tiptitle">剩余时间</span>
	                    	<span id="t_d" class="bigFont13">00天</span>
							<span id="t_h" class="bigFont13">00时</span>
							<span id="t_m" class="bigFont13">00分</span> 
							<span id="t_s" class="bigFont13">00秒</span>
	                   </li>
	                </ul>
	            </#if>
	            <#if result.bulkLoanStatus==2>
	                <ul class="ui-investment clearfix">
	                	<li><span class="ui-tiptitle">借款标题</span> ${result.loanTitle}</li>
	                    <li><span class="ui-tiptitle">金额</span> ${result.loanAmount}元</li>
	                    <#if result.ppLoanrepayment==2>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}天</li>
	                    <#else>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}个月</li>
	                    </#if>
	                    <li><span class="ui-tiptitle">年利率</span> ${result.comprehensiveRate}%</li>
	                    <li><span class="ui-tiptitle">还款方式</span> ${result.loanRepayment}</li>
	                   <!-- <li><span class="ui-tiptitle">月还本息</span> ${result.capital_Interest}元</li>-->
	                    <li>
	                    	<span class="ui-tiptitle">满标用时</span>${result.bulkLoanDealSeconds}
	                   	</li>
	                </ul>
	            </#if>
	             <#if result.bulkLoanStatus==4>
	                <ul class="ui-investment clearfix">
	                	<li><span class="ui-tiptitle">借款标题</span> ${result.loanTitle}</li>
	                    <li><span class="ui-tiptitle">金额</span> ${result.loanAmount}元</li>
	                    <#if result.ppLoanrepayment==2>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}天</li>
	                    <#else>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}个月</li>
	                    </#if>
	                    <li><span class="ui-tiptitle">年利率</span> ${result.comprehensiveRate}%</li>
	                    <li><span class="ui-tiptitle">还款方式</span> ${result.loanRepayment}</li>
	                   <!-- <li><span class="ui-tiptitle">月还本息</span> ${result.capital_Interest}元</li>-->
	                    <!-- <li>
	                    	<span class="ui-tiptitle">下一个还款日</span>${result.RepaymentTime}
	                   </li>-->
	                   <li>
	                    	<span class="ui-tiptitle">剩余期数</span>${result.base}
	                   </li>
	                </ul>
	            </#if>
	             <#if result.bulkLoanStatus==5>
	                <ul class="ui-investment clearfix">
	                	<li><span class="ui-tiptitle">借款标题</span> ${result.loanTitle}</li>
	                    <li><span class="ui-tiptitle">金额</span> ${result.loanAmount}元</li>
	                    <#if result.ppLoanrepayment==2>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}天</li>
	                    <#else>
	                    	<li><span class="ui-tiptitle">期限</span> ${result.loanTerm}个月</li>
	                    </#if>
	                    <li><span class="ui-tiptitle">年利率</span> ${result.comprehensiveRate}%</li>
	                    <li><span class="ui-tiptitle">还款方式</span> ${result.loanRepayment}</li>
	                </ul>
	            </#if>
            </div>
            <div class="investment-con">
                <div class="txt-cn">
                    <p class="investment-money">
                    	<#if result.loanAmountAvailable ??>
                    		剩余金额：
                    		<span class="red-num">${result.loanAmountAvailable}元</span>
                    	<#else>
                    		剩余金额：
                    		<span class="red-num">0元</span>
                    	</#if>
                   </p>
                </div>
                <#if result.terderMinAmount??>
	                <div class="txt-cn">
	                    <p class="investment-money">
                    		起投金额：
                    		<span class="red-num">${result.terderMinAmount}元</span>
	                   </p>
	                </div>
                </#if>
                <#if result.currentUser ??>
                	<#if result.bulkLoanStatus==1>
		               <div class="txt-cn">
		                    <p class="investment-money">
		                    		可用余额：
		                    		<span id="balance">${result.balance}元</span>
		                    		 <a href="${basePath}/service/wapAccount/toWapRecharge">充值</a>
		                    </p>
		               </div>
	                  <div class="txt-cn" style="margin-bottom:15px">
		                    <input type="number" class="txt" placeholder="输入金额必须为 ${result.tenderIncreaseAmount} 元的整数倍" id="bulkLoanAmount"/>
		              </div>
		              <div class="txt-cn">
		                    <input type="password" class="txt" placeholder="请输入交易密码"  id="transPassword"/>
		              </div>
	                  <div class="txt-cn">
	                    <p class="logion-btn" data-use="true"><a>投 标</a></p>
               		  </div>
               		</#if>
               	<#else>
               		<div class="txt-cn">
	                    <p class="investment-money">
	                    	可用余额：<span class="blue-num" style="cursor: pointer;">登录后可见</span>
	                    </p>
	                </div>
                 </#if>
            </div>
            <div class="investment-con">
            	<input type="hidden" id="productNo" value="${result.productNo}">
                <ul class="ui-tab">
                    <li class="current"><span>标的详情</span></li>
                    <li><span>投标记录</span></li>
                </ul>
                <!-- 标的详情 -->
                <div class="txtdesc-cn">
                   ${result.loanDesc}
                </div>
                <!-- 投标记录 -->
                <div class="txtdesc-cn bidrecord" style="display: none;" data-type="bidrecord">
                    <ul class="toubiao-ui">
                    </ul>
                </div>
            </div>
        </div>
       <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <#if result.bulkLoanStatus==1>
	<script  type="text/javascript"> 
			var time;
		 	var NowTime = '${result.NowTime?string('yyyy-MM-dd HH:mm:ss')}';
		 	var str = '${result.endTime?string('yyyy-MM-dd HH:mm:ss')}'.replace(/-/g,"/").replace(".0","");
		 	var EndTime= new Date(str);
		 	NowTime=new Date(NowTime.replace(/-/g,"/").replace(".0",""));
		 	var t =EndTime.getTime() - NowTime.getTime();
			function getTime(){
			  if(t>0){
			        var d=Math.floor(t/1000/60/60/24);
			        var h=Math.floor(t/1000/60/60%24);
			        var m=Math.floor(t/1000/60%60);
			        var s=Math.floor(t/1000%60);
			        document.getElementById("t_d").innerHTML = d + "天";
			        document.getElementById("t_h").innerHTML = h + "时";
			        document.getElementById("t_m").innerHTML = m + "分";
			        document.getElementById("t_s").innerHTML = s + "秒";
		       }
			}
			getTime();
		   time=setInterval(function(){
			   t = t - 1000;
			   getTime();
		   },1000);
	</script>
	</#if>
    <script type="text/javascript" src="${basePath}/js/public/jquery_1.7.2.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath}/js/wap/wapProductDetails.js"></script>
</body>
</html>