<!DOCTYPE html>
<html>
<head>
   	<#include "./common/common_src.ftl">
	<title>邀请好友-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-active.css"/>
    <style>
    	.records-project li span, .records-project li a {
			width: 20%;
			padding-left:0;
			text-align:center;
		}
    	.records-project.reward li span, .records-project.reward li a {
			width: 9%;
			padding-left:2%;
			text-align:left;
			white-space:nowrap; 
			overflow:hidden; 
			text-overflow:ellipsis;
		}
		.linkMobile{
			display:inline !important;
			float:none !important;
			cursor:pointer;
		}
    </style>
</head>
<body>
   <#include "./common/common_header.ftl" /> 
   <#include "./common/common_personAccount.ftl" />
   <div class="personal-main ">
        <div class="container">
           	<!-- 邀请奖励 -->
            <div class="per-txtcon clearfix content">
                <h2 class="social-title">邀请好友</h2>
                <div class="pers-mknav-sty clearfix">
                    <ul class="mknav-ui">
                        <li class="mkli mknav-cut" style="width:50%;"><span>邀请好友成为会员</span></li>
                        <li class="mkli" style="width:50%;"><span>推荐投资奖励</span></li>
                    </ul>
                </div>
                <!-- 邀请好友及记录  -->
                <div class="main-coupons-list">
                	<div class="jiathis_style_32x32 social-list clearfix">
	                    <a class="jiathis_button_tsina social-item sns-weibo">分享到新浪微博</a>
	                    <a class="jiathis_button_weixin social-item sns-weixin">分享到微信</a>
	                    <a class="jiathis_button_qzone social-item sns-qqkj">分享到QQ空间</a>
	                    <a class="jiathis_button_cqq social-item sns-qq">分享到QQ</a>
	                    <a class="jiathis_button_tqq social-item sns-tengxun">分享到腾讯微博</a>
	                    <a class="jiathis_button_douban social-item sns-douban">分享到豆瓣</a>
	                </div>
	                <div class="invitation-link-con clearfix">
	                    <span class="invitation-link">${basePath}/service/invite/${inviteCode}</span>
	                    <input type="hidden" id="copyUrlInput" value="${basePath}/service/invite/${inviteCode}"/>
	                    <a class="link-btn" id="copyButton">复制邀请链接</a>
	                </div>
	                <ul class="ui-invitation-rules">
	                    <li>注意：</li>
	                    <li>1、请不要发送邀请信给不熟悉的人士,避免给别人带来不必要的困扰。</li>
	                    <li>2、请把下边的链接地址发给您的好友，这样他就成了您的推广用户。</li>
	                </ul>
	                <!-- 邀请记录 -->
		            <div id="friendRecord"  class="clearfix" style="padding:0 42px;">
		             	<#include "./seckill/_friendRecordPage.ftl" /> 
		           	</div>
                </div>
                <!-- 推荐投资奖励  -->
                <div class="main-coupons-list" style="display:none;margin-top:10px;">
                	<ul class="ui-invitation-rules" style="padding-left:10px;">
	                    <li>注意：</li>
	                    <li>1、查询功能不支持查询今天的信息。</li>
	                    <li>2、当天数据次日凌晨自动更新，当前显示的数据不包含当天信息。</li>
	                </ul>
	                 <div id="friendTenderRecord"  class="clearfix" style="padding:0 10px;">
                	<#include "./seckill/_invitationAwardPage.ftl" /> 
                	</div>
                </div>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script>
   		var jiathis_config={ 
   			url:$.trim($("#copyUrlInput").val()), 
   			title: "佰宝金服，特惠标活动1个月年化利率12%！", 
   			summary:"佰宝金服年化利率在12%以上，是国内领先的多元化个人理财平台，通过大数据驱动金融，实现立体的风控模式，从而保障投资人的资金安全性，力求打造一个安全、诚信、互惠互利的互联网金融平台。",
   			pic:"${basePath}/images/yhy.jpg"
   		};
 	</script>
    <script src="${basePath}/js/public/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <script src="${basePath}/js/public/jquery.zclip.js" type="text/javascript"></script>
    <script src="${basePath}/js/public/jiaThis/jia.js?uid=1427202355645606" type="text/javascript"></script>
    <script>seajs.use("inviteFriends");</script>
</body>
</html>
