<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/myaccount.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>我的账户</p>
           <a href="javascript:history.go(-1);" class="out-icon"></a>
        </header>
        <div class="hkxx-con">
            <ul class="hkxx-ui">
                <li><p class="hkxx-desc">资产总额(元)</p>
                    <p class="hkxx-desc"><span class="sum-number">${result.allCount?string(',##0.00')}</span></p></li>
                <li><p class="hkxx-desc">可用余额(元)</p>
                    <p class="hkxx-desc"><span class="sum-number">${result.realAmount?string(',##0.00')}</span></p></li>
            </ul>
            <p class="cztx-btn">
	            <!-- <a href="${basePath}/service/wapAccount/toWapRecharge">充 值</a> -->
	             <a href="${basePath}/service/wapAccount/skipWithdrawCash">提 现</a> 
            </p>
        </div>
        <div class="hkxxdesc-con">
            <ul class="hkxxdesc-ui">
				<li class="hkxxdesc-desc"><a href="${basePath}/service/wapAccount/wapAccountIndex" class="s-tip fl">切换新版<span class="s-tip fr"> > </span></a></li>
            	<li class="hkxxdesc-desc"><a href="${basePath}/service/wapAccount/wapOldTransRecord" class="s-tip fl">交易记录<span class="s-tip fr"> > </span></a></li>
			</ul>
        </div>
       <!-- <div style="width:100%;">
        	<button class="safeExit bor_radius4" id="Personout">安全退出</button>
        </div> -->
		<#include "./wap/common/wap_common_footer.ftl" />
    </div>
</body>
</html>