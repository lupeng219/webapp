<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>注册邀请送现金奖励-佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/wapInviteSpecial.css">
</head>
<body>
 	<div class="wrap">
        <header class="op-header">
            <p>注册邀请送现金奖励</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <#if Session["CURRENT_LOGIN_USER"]?exists>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>
        <div class="content">
        	<div class="sub">
        		<img src="${basePath }/images/wap/specialTitle.png" class="specialTitle"/>
        	</div>
        	<div class="sub">
        		<div class="subTitle clearfix">
        			<img src="${basePath }/images/wap/subTitleBack.png"/>
        			<p>
	        			<span class="one">1</span>
	        			<span class="two">重大礼</span>
	        			<span class="three">注册或登录即送521元红包</span>
        			</p>
        		</div>
        		<p class="txt">新老用户均送红包，注册或登录521元红包马上送达，投资完成后会激活红包，奖励金额立即到账，赶快来领取吧！</p>
        	</div>
        	<div class="sub rules bor_radius4">
        		<p>
        		1、领取后可在“个人中心”-“我的活动”-“我的优惠券”中查看；<br>
				2、红包使用有效期为领取之日起30天内，30天后未激活则红包自动失效；<br>
				3、平台的新手专享标不可激活红包；<br>
				4、激活后的红包金额将由佰宝金服平台发放，可继续投资也可提现。
				</p>
        	</div>
        	<div class="sub buttons">
        		<button class="bor_radius4" id="ljzc-btn">立即注册</button>
        	</div>
        	<div class="sub" style="margin-top:1.1rem;">
        		<div class="subTitle clearfix">
        			<img src="${basePath }/images/wap/subTitleBack.png"/>
        			<p>
	        			<span class="one">2</span>
	        			<span class="two">重大礼</span>
	        			<span class="three">邀请好友送现金奖励</span>
        			</p>
        		</div>
        		<p class="txt">平台升级奖励也升级！邀请好友投资也能赚钱啦，好友每次投资邀请人都可获得奖励，投资金额越多次数越多，邀请人的收益越多，利用好人脉积累出财富！</p>
        	</div>
        	<div class="sub rules bor_radius4">
        		<p>
        		1、邀请好友注册后，并在90天内首次投资≥1000元，邀请人可获得10元现金奖励+投资奖励，90天内首次投资≥2000元，邀请人可获得20元现金奖励+投资奖励；<br>
				2、投资奖励：被邀请好友每次投资后，邀请人可获得投资收益的8%*投资期限（月）的现金奖励，多投多送，邀请人所获奖励分期发放；<br>
				3、邀请好友成功后，此类奖励为现金，可投资也可提现；<br>
				4、存钱罐不适用于此奖励，即被邀请人的资金未投资标的；<br>
				老平台的用户同样享受此活动，自活动上线之日起，被邀请人投资后，邀请人均可有收益，邀请好友越多拿到越多收益，和好友一起“赚”起来！
				</p>
        	</div>
        	<div class="sub buttons">
        		<button class="bor_radius4" id="msyhy-btn">立即邀请</button>
        	</div>
        </div>
        <div class="wap-footer" id="wap-footer" style="margin-top:0;">
		    <p class="kfrx-p">客服热线：<a href="tel://400-882-2170" style="color:#acb2c8;">400-882-2170</a></p>
		    <p class="footer-btn">
		        <a href="${basePath}/service/wapIndex/download">下载客户端</a>
		        <a href="${basePath}/service/wapLogin/wapAboutWe">关于我们</a>
		        <a href="${basePath}/service/index/index?type=pc">电脑版</a>
		    </p>
		    <p class="kfrx-p">中融佰诚投资管理有限公司 </p>
		    <p class="kfrx-p1"> © 2016 baibao.com 京ICP证 140570号</p>
		</div>
		<div class="projectWindowBg" style="display:none;"></div>
		<div id="contentLoading" style="display:none;position:fixed;z-index:99999;width:100%;height:100%;top:0;bottom:0;left:0;right:0;
			overflow: hidden;text-align:center;">
			<img src="${basePath}/images/loading.gif" style="margin-left:auto;margin-right:auto;width:30px;height:30px;"/>
		</div>
		<script type="text/javascript">
			var marginTop=document.documentElement.clientHeight/2-15;
			$("#contentLoading img").css("margin-top",marginTop+"px");
		</script>
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapInviteSpecial.js"></script>
</body>
</html>