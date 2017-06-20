<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>邀请好友送现金奖励-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/special/yhysxj.css"/>
</head>
<body>
	<div class="topbar border-b" id="top">
	    <div class="container">
	        <div class="fl">
	            <ul class="topui ml10">
	            	<li><a href="${basePath}" class="ml10">首页</a></li>
	                <li><em class="phone-icon iconbg"></em> <a href="${basePath}/service/dissertation/appSpecial" class="ml10">移动客户端</a></li>
	            </ul>
	        </div>
	        <div class="fr">
	            <ul class="topui">
	            	<#if Session["CURRENT_LOGIN_USER"]?exists>
					<li><a href="${basePath}/service/asset">欢迎回来 ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</a></li>
					<li><a href="${basePath}/service/login/logout">[退出]</a></li>
					<#else>
	                <li><a href="${basePath}/service/login">您好，请登录</a></li>
	                <li><a href="${basePath}/service/register">免费注册</a></li>
					</#if>
	                <li><a href="http://crm2.qq.com/page/portalpage/wpa.php?uin=4006888129&aty=0&a=0&curl=&ty=1" target="_blank">在线客服</a></li>
	                <li style="position:relative;">关注我们 
	                	<em class="wx-icon iconbg" style="cursor:pointer;"></em>
	                	<a href="http://weibo.com/baibao?from=myfollow_all" target="_blank"><em class="wb-icon iconbg"></em></a>
	                	<div class="twoDimensional" style="display: none;">
			                <div class="erwm">
			                    <img src="${basePath}/images/erweima.jpg">
			                </div>
			            </div>
			            <script type="text/javascript">
			            	$(".wx-icon").hover(function(){
						        $(".twoDimensional").show();
						    },function(){
						        $(".twoDimensional").hide();
						    });
			            </script>
	            	</li>
	            </ul>
	        </div>
	    </div>
	</div>
	<div class="active-wrap">
        <div class="hyzc-bg1"></div>
        <div class="hyzc-bg2"></div>
        <div class="hyzc-bg3"></div>
        <div class="hyzc-con">
            <div class="clearfix">
                <p class="pt40 mt20"><img src="${basePath}/images/special/azcshb_06.png"/></p>
                <p class="shb-p pl35">新老用户均送红包，注册或登录521元红包马上送达，投资完成后会激活红包，奖励金额立即到账，赶快来领取吧！</p>
                <div class="shb-con">
                    <div class="shb-title"></div>
                    <div class="benbaobao"></div>
                    <ul>
                        <li>1、领取后可在“个人中心”-“我的活动”-“我的优惠券”中查看；</li>
                        <li>2、红包使用有效期为领取之日起30天内，30天后未激活则红包自动失效；</li>
                        <li>3、平台的新手专享标不可激活红包；</li>
                        <li>4、激活后的红包金额将由佰宝金服平台发放，可继续投资也可提现。</li>
                    </ul>
                </div>
                <p class="textCt">
                    <a href="${basePath}/service/register" class="ljzc-btn"></a>
                </p>
            </div>
            <div class="clearfix">
                <p><img src="${basePath}/images/special/azcshb_10.png"/></p>
                <p class="yhy-p pl35">平台升级奖励也升级！邀请好友投资也能赚钱啦，好友每次投资邀请人都可获得奖励，投资金额越多次数越多，邀请人的收益越多，利用好人脉积累出财富！</p>
                <div class="yhy-con">
                    <div class="yhy-title"></div>
                    <ul>
                        <li>1、邀请好友注册后，并在90天内首次投资≥1000元，邀请人可获得10元现金奖励+投资奖励，90天内首次投资≥2000元，邀请人可获得20元现金奖励+投资奖励；</li>
                        <li>2、投资奖励：被邀请好友每次投资后，邀请人可获得投资收益的8%*投资期限（月）的现金奖励，多投多送，邀请人所获奖励分期发放；</li>
                        <li>3、邀请好友成功后，此类奖励为现金，可投资也可提现；</li>
                        <li>4、存钱罐不适用于此奖励，即被邀请人的资金未投资标的；</li>
                        <li>老平台的用户同样享受此活动，自活动上线之日起，被邀请人投资后，邀请人均可有收益，邀请好友越多拿到越多收益，和好友一起“赚”起来！</li>
                    </ul>
                </div>
                <p class="textCt"><a href="${basePath}/service/active/inviteFriends" class="msyhy-btn"></a></p>
            </div>
            <div class="clearfix">
                <span class="jlxz-nav">其他邀请方式</span>
                <p class="yhy-p" style="margin-bottom:25px;">一、好友注册时在“邀请人手机号”栏输入被邀请人的手机号</p>
                <img src="${basePath}/images/special/azcshb_13.png" style="border:1px dashed #f47e00;"/>
                 <p class="yhy-p" style="margin-bottom:25px;">二、通过“个人中心”-“我的活动”-“邀请好友”分享或复制自己的链接，好友通过此类方式注册成功</p>
                <img src="${basePath}/images/special/azcshb_17.png" style="border:1px dashed #f47e00;"/>
            </div>
            <p class="jsq">本活动解释权归中融佰诚投资管理有限公司</p>
        </div>
    </div>
    <#include "./common/common_footer.ftl">
</body>
</html>