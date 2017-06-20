<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>新年活动-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/special/active-new.css"/>
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
	<div class="ui-container" >
	    <div class="new_01"></div>
	    <div class="new_02">
	        <div class="wrap1000">
	            <p>2016年1月22日-2016年2月20日</p>
	        </div>
	    </div>
	    <div class="new_03"></div>
	    <div class="new_04"></div>
	    <div class="new_05">
	        <div class="wrap813">
	            <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>50万及以上</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p>阿芙玫瑰谷酸奶花瓣面膜2瓶<br/>
	                           阿芙大西洋雪松沁爽沐浴露2瓶<br/>
	                           阿芙参华提纯面膜2瓶<br/>
	                           玫瑰花瓣洁面晶2支（哆啦A梦限量版）</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">1612元</p>
	                    </div>
	                </div>
	            </div>
	            <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>30万≤X＜50万</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p>阿芙玫瑰谷酸奶花瓣面膜2瓶<br/>
	                           阿芙大西洋雪松沁爽沐浴露2瓶<br/>
	                           阿芙参华提纯面膜1瓶<br/>
	                           玫瑰花瓣洁面晶1支（哆啦A梦限量版）</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">1209元</p>
	                    </div>
	                </div>
	            </div>
	            <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>20≤X＜30万</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p>阿芙玫瑰谷酸奶花瓣面膜1瓶<br/>
	                           阿芙大西洋雪松沁爽沐浴露1瓶<br/>
	                           阿芙参华提纯面膜1瓶<br/>
	                           玫瑰花瓣洁面晶1支（哆啦A梦限量版）</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">806元</p>
	                    </div>
	                </div>
	            </div>
	             <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>10万≤X＜20万</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p style="padding-top:30px;">阿芙玫瑰谷酸奶花瓣面膜1瓶<br/>
	                           阿芙大西洋雪松沁爽沐浴露1瓶<br/>
	                           玫瑰花瓣洁面晶1支（哆啦A梦限量版）</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">551元</p>
	                    </div>
	                </div>
	            </div>
	             <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>6万≤X＜10万</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p style="padding-top:42px;">阿芙玫瑰谷酸奶花瓣面膜1瓶<br/>
	                           玫瑰花瓣洁面晶1支（哆啦A梦限量版）</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">396元</p>
	                    </div>
	                </div>
	            </div>
	             <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>3万≤X＜6万</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p style="padding-top:60px;">阿芙玫瑰谷酸奶花瓣面膜1瓶</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">248元</p>
	                    </div>
	                </div>
	            </div>
	            <div class="jl-con">
	                <div class="tzjw-con fl">
	                    <p>累计投资金额<br/>1万≤X＜3万</p>
	                </div>
	                <div class="jlcp-con fl">
	                    <div class="txt-jl">
	                        <span>奖励</span>
	                    </div>
	                    <div class="txt-cp">
	                        <p style="padding-top:60px;">玫瑰花瓣洁面晶1支（哆啦A梦限量版）</p>
	                    </div>
	                    <div class="txt-price">
	                        <p>专柜价（合计）</p>
	                        <p class="price">148元</p>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="new_06"></div>
	    <div class="new_07">
	        <div class="wrap813">
	            <a href="javascript:void(0);" id="ljtz"></a>
	        </div>
	    </div>
	</div>
	<#include "./common/common_footer.ftl">
	<script type="text/javascript">
		$("#ljtz").on("click",function(){
			alert("活动已过期");
			return false;
		});
	</script>
</body>
</html>