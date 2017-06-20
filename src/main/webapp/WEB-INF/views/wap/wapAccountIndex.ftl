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
           <a href="${basePath}/service/wapIndex/toWapIndex" class="index">首页</a>
        </header>
        <div class="hkxx-con">
            <ul class="hkxx-ui">
                <li><p class="hkxx-desc">资产总额(元)</p>
                    <p class="hkxx-desc"><span class="sum-number">${result.allMoney?string(',##0.00')}</span></p></li>
                <li><p class="hkxx-desc">可用余额(元)</p>
                    <p class="hkxx-desc"><span class="sum-number">${result.accountBalance?string(',##0.00')}</span></p></li>
            </ul>
            <p class="cztx-btn">
	             <a href="${basePath}/service/wapAccount/toWapRecharge">充 值</a>
	             <a href="${basePath}/service/wapAccount/toWapwithdrawals">提 现</a> 
            </p>
        </div>
        <div class="hkxxdesc-con">
            <ul class="hkxxdesc-ui">
            	<li class="hkxxdesc-desc"><a href="${basePath}/service/wapAccount/wapAccountOldIndex" class="s-tip fl">切换旧版账户<span class="s-tip fr"> > </span></a></li>
            	<!-- li class="hkxxdesc-desc"><a href="${basePath}/service/wapIndex/toWapIndex" class="s-tip fl">首页<span class="s-tip fr"> > </span></a></li -->
				<li class="hkxxdesc-desc"><a href="${basePath}/service/wapBulkLoan/showProductList" class="s-tip fl">投资列表<span class="s-tip fr"> > </span></a></li>
				<!--<li class="hkxxdesc-desc"><a href="${basePath}/service/webBulkLoan/noviceArea" class="s-tip fl">新手专区<span class="s-tip fr"> > </span></a></li>-->
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapRecords/rechargeWithdraw" class="s-tip fl">交易记录<span class="s-tip fr"> > </span></a></li>
              	<li class="hkxxdesc-desc"><a href="${basePath}/service/wapBulkLoan/tenderRecordByCustNo" class="s-tip fl">我的理财<span class="s-tip fr"> > </span></a></li>
              	<!--<li class="hkxxdesc-desc"><a href="${basePath}/service/webSeckill/redEnvelopeRecordH5" class="s-tip fl">红包奖励<span class="s-tip fr"> > </span></a></li>-->
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapBankcard/toWapBankCard" class="s-tip fl">银行卡<span class="s-tip fr"> > </span></a></li>
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapAccount/wapSafecenter" class="s-tip fl">安全设置<span class="s-tip fr"> > </span></a></li>
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapActivity/wapInviteFriends" class="s-tip fl">邀请好友<span class="s-tip fr"> > </span></a></li>
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapActivity/wapRedEnvelopes" class="s-tip fl">优惠券<span class="s-tip fr"> > </span></a></li>
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapMessages/wapGoodsReward" class="s-tip fl">实物记录<span class="s-tip fr"> > </span></a></li>
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapMessages/wapFindmsg" class="s-tip fl">消息中心<span class="s-tip fr"> > </span></a></li>
                <li class="hkxxdesc-desc"><a href="${basePath}/service/wapAccount/wapHelpCenter" class="s-tip fl">帮助中心<span class="s-tip fr"> > </span></a></li>
			
			</ul>
        </div>
        <div style="width:100%;">
        	<button class="safeExit bor_radius4" id="Personout">安全退出</button>
        </div>
		<#include "./wap/common/wap_common_footer.ftl" />
		<script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapAccountIndex.js"></script>
    </div>
</body>
</html>