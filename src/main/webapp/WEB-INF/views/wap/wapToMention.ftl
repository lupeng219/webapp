<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/withdrawals.css">
    <script type="text/javascript" src="${basePath }/js/public/decode.js"></script>
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>提现</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt ">
	        <#if bankCard?exists>
	            <div class="my-bankcard clearfix">
	                <div class="bank-img">
	                    <img src="${basePath}/images/banklogo/${bankType.bankCode}.png"/>
	                    <p class="bank-num">${bankCard.pbcBankcardno[0..3]}&nbsp;****&nbsp;****&nbsp;${bankCard.pbcBankcardno[(bankCard.pbcBankcardno?length)-4..(bankCard.pbcBankcardno?length)-1]}</p>
	                </div>
	                <div class="opbank-con">
	                    <a class="disphone-pay">移动支付</a>
	                </div>
	            </div>
			</#if>
        </div>
  		<div class="form-txt ">
  			<#if balance ?? && balance!="">
  				<p class="bankcard-name">可用金额<span>${balance?string(',##0.00')}元</span></p>
  			<#else>
  				<p class="bankcard-name">可用金额<span>0.00元</span></p>
  			</#if>
            <#if balance ??>
            	<input type="hidden" value="${balance?string("###")}" id="availablemoney"/>
            <#else>
            	<input type="hidden" value="0" id="availablemoney"/>
            </#if>
            <p class="bankcard-name" style="border-bottom:0;">提现费用:<span class="" style="color: red;">0.00元</span></p>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入提现金额(元)" id="money"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="password" class="txt" placeholder="请输入交易密码" id="transPass"/>
                <p class="err-p" id="transPassErr"></p>
            </div>
            <p class="logion-btn" data-available="true" style="margin-top:0;"><a href="javascript:void(0);">确认提现</a></p>
        </div>
  		<#include "./wap/common/wap_common_footer.ftl" />
    </div>
    
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapToMention.js"></script>
 	<#if error=='0'>
	 	<script> 
	 		myConfirm("您还未进行第三方开户，在充值之前，需要进行第三方开户!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapAccount/wapOpenAccount";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
	<#if error=='1'>
	 	<script> 
	 		myConfirm("您还未实名认证，在提现之前，需要进行实名认证!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapAccount/wapOpenAccount";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
	<#if error=='2'>
	 	<script> 
	 		myConfirm("您还未绑卡，在提现之前，需要进行绑卡!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapBankcard/toWapBankCard";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
	<#if error=='3'>
	 	<script> 
	 		myConfirm("您还未设置交易密码，在提现之前，需要设置交易密码!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapAccount/wapModifyTransPassword";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
 
</body>
</html>