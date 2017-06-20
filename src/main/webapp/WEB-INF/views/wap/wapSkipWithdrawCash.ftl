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
	        <#if result.bankNum?exists>
	            <div class="my-bankcard clearfix">
	                <div class="bank-img">
	                    <img src="${basePath}/images/banklogo/${result.bankType}.png"/>
	                    <p class="bank-num">${result.bankNum[0..3]}&nbsp;****&nbsp;****&nbsp;${result.bankNum[(result.bankNum?length)-4..(result.bankNum?length)-1]}</p>
	                </div>
	                <div class="opbank-con">
	                    <a class="disphone-pay">移动支付</a>
	                </div>
	            </div>
			</#if>
        </div>
  		<div class="form-txt ">
            <p class="bankcard-name">可用金额<span>${result.realAmount}元</span></p>
            <#if result.realAmount ??>
            	<input type="hidden" value="${result.realAmount?string("##########.00")}" id="availablemoney"/>
            <#else>
            	<input type="hidden" value="0" id="availablemoney"/>
            </#if>
            <p class="bankcard-name" style="border-bottom:0;">提现费用:<span class="" style="color: red;">0.00元</span></p>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入提现金额(元)" id="money"/>
                <p class="err-p" id="moneyErr"></p>
            </div>
           <!-- <div class="txt-cn">
                <input type="password" class="txt" placeholder="请输入交易密码" id="transPass"/>
                <p class="err-p" id="transPassErr"></p>
            </div> -->
            <p class="logion-btn" data-available="true" style="margin-top:0;"><a href="javascript:void(0);">确认提现</a></p>
        </div>
        <form id="myForm" action="${basePath}/service/account/toUmpayJump" method="post" target="_blank">
			<input type="hidden" name="url" id="myUrl">
		</form>
  		<#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <div id="tiXian" style="display:none; z-index: 9999; width: 100%; height: 100%; margin: 0px; padding: 0px; font-size: 1rem;  border: none; position: fixed; top: 0px; left: 0px; overflow: hidden;">
		<div style="z-index: 2; width: 90%; max-width: 500px; min-height: 80px; margin: 0px auto; padding: 0px; position: absolute; left: 0px; right: 0px; top: 40%; border-radius: 5px; text-align: center; background: rgb(255, 255, 255);">
			<p style="margin: 0.8rem 1rem; padding: 0px; color: rgb(121, 121, 121); font-size: 1rem; line-height: 1.3rem; text-align: center; overflow-y: auto; overflow-x: hidden;">提现是否成功？</p>
			<button onclick="window.location.href='${basePath}/service/wapAccount/wapAccountOldIndex';" style="color: rgb(255, 255, 255); border: none; font-size: 0.9rem; border-radius: 4px; padding: 0.5rem 1.3rem; margin: 0.9rem auto; cursor: pointer; background: rgb(174, 222, 244);">成&nbsp;功</button>
			<span>&nbsp;&nbsp;</span>
			<button onclick="window.location.reload();" style="color: rgb(255, 255, 255); border: none; font-size: 0.9rem; border-radius: 4px; padding: 0.5rem 1.3rem; margin: 0.9rem auto; cursor: pointer; background: rgb(203, 208, 210);">失&nbsp;败</button>
		</div>
		<div style="z-index: 1; width: 100%; height: 100%; margin: 0px; padding: 0px; position: absolute; top: 0px; left: 0px; background: rgba(0, 0, 0, 0.4);"></div>
	</div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapSkipWithdrawCash.js"></script>
 	<#if result.bankNum==null>
	 	<script> 
	 		myConfirm("您还未绑卡!",function(){
	 			history.go(-1);
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
</body>
</html>