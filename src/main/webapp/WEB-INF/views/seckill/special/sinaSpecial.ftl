<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/special/sinaPay.css"/>
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
    <div class="sinawrap"  style="padding-bottom: 60px;">
        <div class="sina01"></div>
        <div class="sina02">
            <div class="sina-con">
                <p class="sina-title" style="padding-top:145px;">什么是新浪支付存钱罐？</p>
                <p class="sina-desc">新浪支付（存钱罐）隶属于新浪旗下，是新浪联手汇添富基金主推的名为“存钱罐”第三方支付机构，同时也具有账户余额增值功能。</p>
            </div>
        </div>
        <div class="sina-con">
            <div class="type-con">
                <div class="w198">
                    <p class="red-d">新浪支付存钱罐</p>
                    <p class="red-t">更规范</p>
                </div>
                <div class="w758">
                    <p class="sina-title textCt pt35">[专人专户 　资金专款专用]</p>
                    <p class="sina-ds pt20">1、严格遵守银监会对资金托管的要求，杜绝平台自建资金池。</p>
                    <p class="sina-ds">2、用户资金全程由新浪支付存钱罐托管，与有融网平台完全隔离。</p>
                    <p class="sina-ds">3、投资和还款资金开设独立账户，实行专人专户，专款专用。</p>
                </div>
            </div>
            <div class="type-con mt30">
                 <div class="w198">
                    <p class="red-d">新浪支付存钱罐</p>
                    <p class="red-t">更安全</p>
                </div>
                <div class="w758">
                    <p class="sina-title textCt pt35">[完美护航 　银行级别保障]</p>
                    <p class="sina-ds pt20">1、中国支付清算协会会员，已通过Symantec认证、PCIDSS认证。</p>
                    <p class="sina-ds">2、采用VeriSign SSL证书（128位）加密保护客户资料。</p>
                    <p class="sina-ds">3、多级安全策略，全程SSL加密，实时安全提醒。</p>
                </div>
            </div>
            <div class="type-con mt30">
                <div class="w198">
                    <p class="red-d">新浪支付存钱罐</p>
                    <p class="red-t">更丰富</p>
                </div>
                <div class="w758">
                    <p class="sina-title textCt pt35">[功能丰富 　乐享极致体验]</p>
                    <p class="sina-ds pt20">1、集多项功能为一体，一个账户，多种体验。</p>
                    <p class="sina-ds">2、高危操作提醒功能，随时随地，掌握账户动态。</p>
                    <p class="sina-ds">3、注册即开通，化繁为简，带来完美极致体验。</p>
                </div>
            </div>
            <div class="type-con mt30">
                <div class="w198">
                    <p class="red-d">新浪支付存钱罐</p>
                    <p class="red-t">更零活</p>
                </div>
                <div class="w758">
                    <p class="sina-title textCt pt35">[资金零活 　收益每天结]</p>
                    <p class="sina-ds pt20">1、一分钱起存，资金极速到账。</p>
                    <p class="sina-ds">2、天天计息，收益享不停。</p>
                    <p class="sina-ds">3、账户资金7*24小时随时存取。</p>
                </div>
            </div>
            <div class="type-con mt30">
                <div class="w198">
                    <p class="red-d">新浪支付存钱罐</p>
                    <p class="red-t">更高收益</p>
                </div>
                <div class="w758">
                    <p class="sina-title textCt pt35">[货基支持 　闲置资金不站岗]</p>
                    <p class="sina-ds pt20">1、新浪支付存钱罐是一款具备货基收益的产品。</p>
                    <p class="sina-ds">2、账户闲置资金可获得每日收益，真正实现资金不站岗。</p>
                    <p class="sina-ds">3、七日年化收益率3.238%，超银行活期存款的16倍。</p>
                </div>
            </div>
            <p class="table-title">收益时间表</p>
            <table class="tab-ant" cellpadding="0" cellspacing="0">
                <tr class="tr-title">
                    <td>购买时间</td>
                     <td>开始计算收益时间</td>
                     <td style="border-right:0;">首次显示收益时间</td>
                </tr>
                <tr>
                    <td>周一15:00—周二15:00前</td>
                     <td>周三</td>
                     <td style="border-right:0;">周四</td>
                </tr>
                <tr>
                    <td>周二15:00—周三15:00前</td>
                     <td>周四</td>
                     <td style="border-right:0;">周五</td>
                </tr>
                <tr>
                    <td>周三15:00—周四15:00前</td>
                     <td>周五（可享受周六周日收益）</td>
                     <td style="border-right:0;">下周一（显示周五周六周日三天收益）</td>
                </tr>
                <tr>
                    <td>周四15:00—周五15:00前</td>
                     <td>下周一（不享受周六周日收益）</td>
                     <td style="border-right:0;">下周二</td>
                </tr>
                <tr>
                    <td>周五15:00—下周一15:00前</td>
                     <td>下周二</td>
                     <td style="border-right:0;">下周三</td>
                </tr>
            </table>
            <p class="wxts-p">温馨提示：新浪支付托管升级——还本付息提前到账，账户余额早享收益</p>
            <p class="textCt pt40"><img src="${basePath}/images/special/cqg_09.jpg"/> </p>
            <p class="red-t pt40">更完美的合作</p>
            <p class="red-16 pt40">佰宝金服和新浪支付存钱罐达成战略合作协议，让用户的资金托管更安全</p>
            <p class="red-16">真正实现资金隔离，杜绝资金池风险</p>
            <p class="red-16">托管资金不站岗，不投也能赚收益</p>
            <p class="textCt pt40">
                <a href="${basePath}/service/piggyBank" class="find-btn">查看我的存钱罐</a>
                <a href="${basePath}/service/piggyBank/showMemberInfosSina" class="yanzheng">去新浪支付查询验证</a>
            </p>
        </div>
    </div>
    <#include "./common/common_footer.ftl">
</body>
</html>