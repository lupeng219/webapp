<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/mybankcard.css">
    <script type="text/javascript" src="${basePath }/js/public/decode.js"></script>
</head>
<body>
 	<div class="wrap">
        <header class="op-header">
            <p>我的银行卡</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <!-- 添加银行卡 -->
        <#if hasBankCard == false >
	        <a class="setting-title" style="color:black;" href="${basePath }/service/wapBankcard/toWapBindBankCard">
		        <ul class="ui-bankcard">
		            <li>+ 添加银行卡</li>
		        </ul>
	        </a>
        </#if>
        <#if hasBankCard == true> 
	        <!-- 已绑银行卡 -->
	        <div class="form-txt ">
	            <div class="my-bankcard clearfix">
	                <div class="bank-img">
	                    <img src="${basePath}/images/banklogo/${bankCard.pbcBankcode}.png"/>
	                    <p class="bank-num">${bankCard.pbcBankcardno[0..3]}&nbsp;****&nbsp;****&nbsp;${bankCard.pbcBankcardno[(bankCard.pbcBankcardno?length)-4..(bankCard.pbcBankcardno?length)-1]}</p>
	                </div>
	                <div class="opbank-con">
	                    <a href="javascript:void(0);" class="update-bank" id="deleteBank">解绑</a>
	                    <a class="disphone-pay">移动支付</a>
	                    <input type="hidden" value="${isFirst}" name="isFirst" id="isFirst"/>
	                </div>
	            </div><br/>
	            <div>
	            	<span>【温馨提示】：此银行卡将用于您账户的充值和提现，账户资金余额为0时即可进行解绑。</span>
	            </div>
	        </div>
		</#if>
		<#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <!-- 解绑弹窗 -->
    <div class="alertModel" style="display:none;">
    	<div class="alertModelContent">
    		<input type="number" class="alertModelInput" placeholder="请输入手机验证码" id="mobileVer"/>
    		<a href="javascript:void(0);" id="hqyzm-btn-del" data-available="true">获取验证码</a>
    		<p class="alertModelError" id="mobileVerErr"></p>
    	</div>
    	<button class="alertModelSubmit" id="deleteStart">确&nbsp;定</button>
    	<button class="alertModelCancel" id="notDelete">取&nbsp;消</button>
	</div>
   
	<script>
		$("#deleteBank").on("click",function(){
			var isFirst=$("#isFirst").val();
			$(".projectWindowBg").show();
			$(".alertModel").show();
			$(".alertModel .alertModelError").html("");
			$(".alertModel .alertModelInput").val("");
		});
		$("#hqyzm-btn-del").on("click",function(){
	    	var $this = $(this);
	    	if($this.attr("data-available")=="true") {
	    		$this.attr("data-available", false);
	    		showContentLoading();
	    		$.post(root+"/service/bankCard/unbinding?channel=3", function(data){
	    			closeContentLoading();
	    			if(data.retCode) {
	    				getMobileVerFormat($this);
	    			}else{
	    				$("#mobileVerErr").html(data.retMsg);
	    				$this.attr("data-available", true);
	    				return false;
	    			}
	    		});
	    	}
		});
		$("#deleteStart").on("click",function(){
			var temp=mobileVerFormat($("#mobileVer"));
			if(temp.success){
				var mobileVer=$.trim($("#mobileVer").val());
				showContentLoading();
            	$.post(root+"/service/bankCard/unbindingAdvance",{
            		"validCode": mobileVer,
            		"channel":3
            	},function(data){
            		closeContentLoading();
                	if(data.retCode){
                		 $(".projectWindowBg").hide();
						 $(".alertModel").hide();
						 myShow("解绑成功",function(){
						 	location.reload();
						 });
                	}else{
                		 $("#mobileVerErr").html(data.retMsg);
                         return false;
                	}
                });
			}else{
				$("#mobileVerErr").html(temp.msg);
				return false;
			}
		});
		$("#notDelete").on("click",function(){
			$(".projectWindowBg").hide();
			$(".alertModel").hide();
		});
	</script>
</body>
</html>