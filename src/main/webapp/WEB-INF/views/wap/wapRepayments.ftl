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
            <p>回款记录</p>
           <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <p class="huikuan-title-con">
            <span class="touzi-title ellipsis2" style="max-width:82%;" title="${result.pp_loanTitle}">${result.pp_loanTitle}</span>
            <#if result.bulkLoanStatus=='4'>
            	 <span class="touzi-state fr">还款中</span>
            <#else>
            	 <span class="touzi-state fr">已完成</span>
            </#if>
        </p>
        <div class="touzi-wrap">
            <div class="hkxx-con">
                <ul class="hkxx-ui">
                    <li style="width:100%;">
                    	<p class="hkxx-desc">待收本息</p>
                        <p class="hkxx-desc">
                       	 	<span class="sum-number">${result.capital_Interest}</span>元
                        </p>
                      </li>
                    <li><p class="hkxx-desc">投资本金</p>
                        <p class="hkxx-desc">
                        	<span class="sum-number">${result.ptr_amount}</span>元
                        </p></li>
                    <li><p class="hkxx-desc">可获利息</p>
                        <p class="hkxx-desc"><span class="sum-number">${result.capital_Interest-result.ptr_amount}</span>元</p></li>
                </ul>
            </div>
            <div class="hkxxdesc-con">
                <ul class="hkxxdesc-ui">
                    <li class="hkxxdesc-title"><span class="s-tip">${result.count}期</span><span class="s-tips">待收本金+利息</span><span class="s-tip">状态</span></li>
         			  <#list result.list as item >
	                    <li class="hkxxdesc-desc">
	                    	<span class="s-tip">${item.ptp_profitTime?string("yyyy-MM-dd")}</span><span class="s-tips"><span class="num-size">${item.ptp_capital}+<span class="num-color">${item.ptp_interest}</span></span>元</span><span class="s-tip blue"><#if item.ptp_profitstatus=='01'>未回款</#if><#if item.ptp_profitstatus=='02'>还款中</#if><#if item.ptp_profitstatus=='00'>已回款</#if></span>
	                    </li>
               		</#list>
                </ul>
             </div>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
</body>
</html>