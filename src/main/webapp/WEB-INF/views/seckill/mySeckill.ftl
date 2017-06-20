<!DOCTYPE html>
<html>
<head>
   	<#include "./common/common_src.ftl">
	<title>我的优惠券-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-active.css"/>
    <style>
    	.invite{
    		position: absolute;
			left:1px;
			top:-30px;
			font-size:14px;
    	}
    </style>
</head>
<body>
   <#include "./common/common_header.ftl" /> 
   <#include "./common/common_personAccount.ftl" />
   <div class="personal-main" style="padding-top:43px;">
        <div class="container" style="position: relative;">
        	<a class="invite" href="${basePath}/service/active/inviteFriends">邀请好友得奖励</a>
            <!-- 优惠券 -->
            <div class="per-txtcon clearfix" id="per-txtcon" style="padding-bottom:20px;">
                <h2 class="main-title">优惠券</h2>
                <div class="pers-mknav-sty clearfix">
                    <ul class="mknav-ui">
                        <li class="mkli mknav-cut" style="width:33.3%;"><span>未使用</span></li>
                        <li class="mkli" style="width:33.3%;"><span>已使用</span></li>
                        <li class="mkli" style="width:33.3%;"><span>已失效</span></li>
                    </ul>
                </div>
                <!-- 未使用 -->
                <div class="main-coupons-list">
                 <ul class="ui-coupons-list">
                 <#if noUseList?size!=0>
                   <#list noUseList as warehouse>
                        <li class="coupon-item money-coupon">
                            <div class="coupon-title">
                                <h2>
                                	红包
                                </h2>
                            </div>
                            <div class="coupon-desc">
                                <p class="coupon-reward"><span>${warehouse.puwParvalue}</span>元</p>
                                <p class="coupon-rule">使用规则：单次投资≥${warehouse.pur_rule}</p>
                                <p class="coupon-rule">返现规则：投资后48小时内到账</p>
                                <p class="coupon-rule">有效期至：${warehouse.puwEffecttime?string('yyyy-MM-dd')}</p>
                                <em class="coupon-used">
                                <#if warehouse.puwState=="0">
                                                                 未使用
                                <#elseif warehouse.puwState=="1">
                                                                 已使用
                                <#elseif warehouse.puwState=="2">
                                                                 已过期
                                <#elseif warehouse.puwState=="3">
                                                                 已使用
                                </#if>
                                </em>
                            </div>
                        </li>
                   </#list>
                   <#else>
                    <div>
                     <p class="color-gray-text">您没有未使用的优惠券</p>
                   </div>
                   </#if>
                  </ul>
                </div>
                <!-- 已使用 -->
                <div class="main-coupons-list" style="display:none;">
                    <ul class="ui-coupons-list">
                     <#if usedList?size!=0>
                   <#list usedList as warehouse>
                        <li class="coupon-item money-coupon">
                            <div class="coupon-title">
                                <h2>
                                	 红包
                                </h2>
                            </div>
                            <div class="coupon-desc">
                                <p class="coupon-reward"><span>${warehouse.puwParvalue}</span>元</p>
                                <p class="coupon-rule">使用规则：单次投资≥${warehouse.pur_rule}</p>
                                <p class="coupon-rule">发放规则：投资后48小时内到账</p>
                                <p class="coupon-rule">有效期至：${warehouse.puwEffecttime?string('yyyy-MM-dd')}</p>
                                <em class="coupon-used">
                                <#if warehouse.puwState=="0">
                                                                 未使用
                                <#elseif warehouse.puwState=="1">
                                                                 已使用
                                <#elseif warehouse.puwState=="2">
                                                                 已过期
                                <#elseif warehouse.puwState=="3">
                                                                 已使用
                                </#if>
                                </em>
                            </div>
                        </li>
                   </#list>
                   <#else>
                    <div>
                     <p class="color-gray-text">您没有已使用的优惠券</p>
                   </div>
                   </#if>
                    </ul>
                </div>
                <!-- 已失效 -->
                <div class="main-coupons-list" style="display:none;">
                    <ul class="ui-coupons-list">
                        <#if overTimeList?size!=0>
                   <#list overTimeList as warehouse>
                        <li class="coupon-item money-coupon">
                            <div class="coupon-title">
                                <h2>
                               		  红包
                                </h2>
                            </div>
                            <div class="coupon-desc">
                                <p class="coupon-reward"><span>${warehouse.puwParvalue}</span>元</p>
                                <p class="coupon-rule">使用规则：单次投资≥${warehouse.pur_rule}</p>
                                <p class="coupon-rule">发放规则：投资后48小时内到账</p>
                                <p class="coupon-rule">有效期至：${warehouse.puwEffecttime?string('yyyy-MM-dd')}</p>
                                <em class="coupon-used">
                                 <#if warehouse.puwState=="0">
                                                                 未使用
                                <#elseif warehouse.puwState=="1">
                                                                 已使用
                                <#elseif warehouse.puwState=="2">
                                                                 已过期
                                <#elseif warehouse.puwState=="3">
                                                                 已使用
                                </#if>
                                </em>
                            </div>
                        </li>
                   </#list>
                   <#else>
	                   <div >
	                     <p class="color-gray-text">您没有已失效的优惠券</p>
	                   </div>
                   </#if>
                   </ul>
                </div>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script>seajs.use("personal-active");</script>
</body>
</html>
