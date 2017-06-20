<!DOCTYPE html>
<html>
<head lang="en">
	<#include "./wap/common/wap_common_src.ftl" />
    <title>我的红包-佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/wapRedEnvelopes.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>优惠券</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
          	<#if Session.CURRENT_LOGIN_USER ??>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>
		
		<div class="content">
            <div class="tabList bor_radius3 hiddenCon">
                <a class="tab active fl" href="javascript:void(0);" data-mode="1">未使用</a>
                <a class="tab fl" href="javascript:void(0);" data-mode="2">已使用</a>
                <a class="tab fl" href="javascript:void(0);" data-mode="3" style="width:33.34%;">已失效</a>
            </div>
            <div class="couponList">
            	<!-- 未使用 -->
            	<div class="couponMode" id="mode1">
            		<#if noUseList?? && (noUseList?size>0)>
	            		<#list noUseList as item >
	            			<!-- 红包 -->
	        					<div class="couponSub">
			            			<img src="${basePath}/images/wap/voucher/wsy-xj.png" alt="红包"/>
			            			<div class="couponMoney">${item.puwParvalue}<span>元</span></div>
			            			<div class="couponTitle">
			            				<p>红<br>包</p>
			        				</div>
			            			<div class="couponTime">
			            				<p>
			            					有效期至：${item.puwEffecttime?string("yyyy-MM-dd")}<br>
			            					使用规则：单次投资≥${item.pur_rule}元<br>
			            					发放规则：投资后48小时内到账
			            				</p>
			            			</div>
	        					</div>
	            		</#list>
	            	<#else>
	            		<div class="couponSub">
			            		<center>暂无数据</center>
	            		</div>
	            	</#if>
            	</div>
            	<!-- 已使用 -->
            	<div class="couponMode" id="mode2" style="display:none;">
            		<#if usedList?? && (usedList?size>0)>
	            		<#list usedList as item>
	            				<div class="couponSub">
			            			<img src="${basePath}/images/wap/voucher/ysy-xj.png" alt="红包"/>
			            			<div class="couponMoney">${item.puwParvalue}<span>元</span></div>
			            			<div class="couponTitle">
			            				<p>红<br>包</p>
			        				</div>
			            			<div class="couponTime">
			            				<p>
			            					有效期至：${item.puwEffecttime?string("yyyy-MM-dd")}<br>
			            					使用规则：单次投资≥${item.pur_rule}元<br>
			            					发放规则：投资后48小时内到账
			            				</p>
			            			</div>
	        					</div>
	            		</#list>
	            	<#else>
	            		<div class="couponSub">
			            		<center>暂无数据</center>
	            		</div>
	            	</#if>
            	</div>
            	<!-- 已失效 -->
            	<div class="couponMode" id="mode3" style="display:none;">
            		<#if usedList?? && (usedList?size>0)>
	            		<#list overTimeList as item>
	            				<div class="couponSub">
			            			<img src="${basePath}/images/wap/voucher/ysx-xj.png" alt="红包"/>
			            			<div class="couponMoney">${item.puwParvalue}<span>元</span></div>
			            			<div class="couponTitle">
			            				<p>红<br>包</p>
			        				</div>
			            			<div class="couponTime">
			            				<p>
			            					有效期至：${item.puwEffecttime?string("yyyy-MM-dd")}<br>
			            					使用规则：单次投资≥${item.pur_rule}元<br>
			            					发放规则：投资后48小时内到账
			            				</p>
			            			</div>
	        					</div>
	            		</#list>
	            	<#else>
	            		<div class="couponSub">
			            		<center>暂无数据</center>
	            		</div>
	            	</#if>
            	</div>
            </div>
        </div>
        
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript" charset="utf-8" src="${basePath }/js/wap/wapRedEnvelopes.js"></script>
</body>
</html>