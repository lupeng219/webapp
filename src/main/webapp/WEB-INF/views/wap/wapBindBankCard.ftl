<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/mybankcard.css">
</head>
<body>
 	<div class="wrap">
        <header class="op-header">
            <p>添加银行卡</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="form-txt">
            <p class="bankcard-name">开户名 
            	<#if realname??>
           		 <span>${realname}</span>
           		<#else>
           			暂无
           		</#if>
            </p>
            <div class="txt-cn">
                <input type="text" class="txt pointer" placeholder="请选择银行" id="selectBank" data-bankCode="" readonly/>
                <em class="down-icon" id="selectBankEm"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit" style="display:none;" id="ui-banklist">
	                <#if bankTypeList??>
	                	<#list bankTypeList as item>
	                		<li data-bankCode="${item.pbcBankcode}">${item.pbcBankName}</li>
	                	</#list>
	                </#if>
                </ul>
            </div>
            <div class="txt-cn">
                <input type="text" class="txt pointer" placeholder="请选择开户省份" id="loc_province" readonly/>
                <em class="down-icon" id="loc_province_em"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit" style="display:none;" id="ui-provincelist"></ul>
            </div>
            <div class="txt-cn">
                <input type="text" class="txt pointer" placeholder="请选择开户城市" id="loc_city" readonly/>
                <em class="down-icon" id="loc_city_em"></em>
                <p class="err-p"></p>
                <ul class="ui-banklsit" style="display:none;" id="ui-citylist"></ul>
            </div>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入银行卡号" id="newBankCode"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="tel" class="txt" placeholder="请输入银行预留手机号" id="reserveMobile" value="${mobile}"/>
                <p class="err-p"></p>
            </div>
            <div class="txt-cn">
                <input type="text" class="txt" placeholder="请输入手机验证码" id="mobileVer"/>
                <a class="hqyzm-btn" data-available="true">获取验证码</a>
                <p class="err-p" id="mobileVerErr"></p>
            </div>
        </div>
        <div class="form-txt txt-cn">
            <p class="logion-btn"  data-available="true"><a href="javascript:void(0);">确定</a></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/public/area.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapBindBankCard.js"></script>
	<#if error=='1'>
	 	<script> 
	 		myConfirm("您还未进行第三方开户，在绑定银行卡之前，需要进行第三方开户!\n是否立即前往?",function(){
	 			location.href = root +"/service/wapAccount/wapOpenAccount";
	 		},function(){
	 			history.go(-1);
	 		});
	 	</script>
	</#if>
</body>
</html>