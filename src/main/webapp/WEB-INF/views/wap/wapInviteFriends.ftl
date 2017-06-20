<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/wapInviteFriends.css"/>
    <link href="${basePath}/js/public/jiaThis/jiathis_share.css" rel="stylesheet" type="text/css">
</head>
<body>
 	<div class="wrap">
        <header class="op-header">
            <p>邀请好友</p>
           <a href="javascript:history.go(-1);" class="out-icon"></a>
           <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="content">
        	<div style="padding:10px;padding-bottom:50px;">
        		<p style="height:36px;line-height:36px;">分享给好友：</p>
	        	<div class="jiathis_style_32x32 sylogo">
                    <a class="jiathis_button_weixin"></a>
                    <a class="jiathis_button_tsina"></a>
                    <a class="jiathis_button_tqq"></a>
                    <a class="jiathis_button_renren"></a>
                    <a class="jiathis_button_qzone"></a>
                </div>
        	</div>
        	<div class="tabList bor_radius3 hiddenCon">
                <a class="tab active fl" href="javascript:void(0);" data-mode="1">邀请好友记录</a>
                <a class="tab fl" href="javascript:void(0);" data-mode="2">投资推荐记录</a>
            </div>
      		
      	<!-- 邀请好友 -->
      	<div style="padding:10px;" class="friends">
      		<#include "./wap/_inviteFriends.ftl" />
      	</dvi>
      	<div style="padding:10px;display:none;" class="investments">
      		<#include "./wap/_recomTender.ftl" />
      	</div>
      	<#if code??>
    		<input type="hidden" id="inviteUrl" value="${basePath}/service/wapRegister/toWapRegister?code=${code}"/>
   		<#else>
   			<input type="hidden" id="inviteUrl" value="${basePath}/service/wapRegister/toWapRegister"/>
   		</#if>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script>
   		var jiathis_config={ 
   			url:$.trim($("#inviteUrl").val()), 
   			title: "佰宝金服，特惠标活动1个月年化利率12%！", 
   			summary:"佰宝金服年化利率在12%以上，是国内领先的多元化个人理财平台，通过大数据驱动金融，实现立体的风控模式，从而保障投资人的资金安全性，力求打造一个安全、诚信、互惠互利的互联网金融平台。"
   		};
     </script>
     <script src="${basePath}/js/wap/wapInviteFriends.js" type="text/javascript"></script>
     <script src="${basePath}/js/public/jiaThis/jia.js?uid=1427202355645606" type="text/javascript"></script>
</body>
</html>