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
            <p>充值</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt">
        	<div class="tabList bor_radius3 hiddenCon">
                <a class="tab active fl" href="javascript:void(0);" data-modal="1">快捷充值</a>
                <a class="tab fl" href="javascript:void(0);" data-modal="2">银联支付</a>
            </div>
            <div id="modal1">
	        	<#if bankCard?exists>
		            <div class="my-bankcard clearfix">
		                <div class="bank-img">
		                    <img src="${basePath}/images/banklogo/${bankType.bankCode}.png"/>
		                    <p class="bank-num">${bankCard.pbcBankcardno[0..3]}&nbsp;****&nbsp;****&nbsp;${bankCard.pbcBankcardno[(bankCard.pbcBankcardno?length)-4..(bankCard.pbcBankcardno?length)-1]}</p>
		                    <input type="hidden" value="${bankCard.pbcBankcardno}" id="bankno"/>
		                </div>
		                <div class="opbank-con">
		                    <span class="disphone-pay">移动支付</span>
		                </div>
		            </div>
		            <div class="txt-cn" style="margin-top:0.2rem;">
		                <input type="text" class="txt" placeholder="请输入充值金额(元)" id="money" value=""/>
		                <p class="err-p"></p>
		            </div>
		            <div class="txt-cn">
		                <input type="password" class="txt" placeholder="请输入交易密码" id="transPass" value=""/>
		                <p class="err-p"></p>
		            </div>
		            <div class="txt-cn">
		                <input type="text" class="txt" placeholder="手机号码" id="mobile" value="${mobile?substring(0,3)}****${mobile?substring(7,11)}" readonly="readonly" />
		                <p class="err-p"></p>
		            </div>
		            <div class="txt-cn">
		                <input type="text" class="txt" placeholder="请输入手机验证码" id="verification"/>
		                <a class="hqyzm-btn" data-available="true">获取验证码</a>
		                <p class="err-p"></p>
		            </div>
		            <p class="chongzhi-p" style="margin-top:0;">充值费率为0.0%，由第三方平台收取</p>
		            <#if bankType.singleLimit?exists>
		            	<p class="chongzhi-p">充值限额：单笔限额${bankType.singleLimit }元，每日累计限额${bankType.singleDayLimit }元</p>
		            	<input type="hidden" value="${bankType.singleLimit?string("###") }" id="singleLimit"/>
		            	<input type="hidden" value="${bankType.singleDayLimit?string("###") }" id="singleDayLimit"/>
		            </#if>
		            <p class="logion-btn" data-available="true"><a href="javascript:void(0);">确认充值</a></p>
	       		</#if>
       		</div>
       		<div id="modal2" style="display:none;">
	           <!-- <div class="txt-cn" style="margin-top:1rem;">
	                <input type="text" class="txt selectBank" placeholder="请选择充值银行" id="bankTxt-online" data-bank="" readonly="readonly"/>
	                <em class="down-icon selectBank" id="bankEm"></em>
	                <ul class="ui-banklsit " id="ui-banklsit" style="display: none;">
	                    <li data-bank="1">北京银行</li>
	                    <li data-bank="4">中国银行</li>
	                    <li data-bank="5">交通银行</li>
	                </ul>
	                <p class="err-p"></p>
	            </div> -->
                <div class="txt-cn" style="margin-top:1rem;">
	                <input type="number" class="txt" placeholder="请输入充值金额(元)" id="money-online" value=""/>
	                <p class="err-p"></p>
	            </div>
	            <p class="logion-btn-online" data-available="true"><a href="javascript:void(0);">充 值</a></p>
       		</div>
        </div>
		<#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <input type="hidden" value="" id="transFlowNo"/>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapRecharge.js"></script>
 
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
	 		myConfirm("您还未实名认证，在充值之前，需要进行实名认证!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapAccount/wapOpenAccount";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
	<#if error=='2'>
	 	<script> 
	 		myConfirm("您还未绑卡，在充值之前，需要进行绑卡!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapBankcard/toWapBankCard";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
	<#if error=='3'>
	 	<script> 
	 		myConfirm("您还未设置交易密码，在充值之前，需要设置交易密码!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapAccount/wapModifyTransPassword";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
</body>
</html>