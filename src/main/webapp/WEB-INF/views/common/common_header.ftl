<!--
<div class="topbar border-b" id="top">
    <div class="container">
        <div class="fl">
            <ul class="topui ml10">
                <li><em class="phone-icon iconbg"></em> <a href="${basePath}/service/dissertation/appSpecial" class="ml10">移动客户端</a></li>
                <li><img src="${basePath}/pictures/top/icon-time.png" style="vertical-align:middle;margin-bottom:3px;" align="absmiddle" width="15px" height="15px" /> 服务时间 9:00-18:00</li>
            </ul>
        </div>
        <div class="fr">
            <ul class="topui">
            	<#if Session["CURRENT_LOGIN_USER"]?exists>
				<li><a href="${basePath}/service/asset">欢迎回来 ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</a></li>
				<li><a href="${basePath}/service/login/logout">[退出]</a></li>
				<#else>
                <li><a href="${basePath}/service/login">您好，请<span style="color:#3c7281">登录</span></a></li>
                <li><a href="${basePath}/service/register">免费注册</a></li>
				</#if>
				<li><img src="${basePath}/pictures/top/icon--service.png" style="vertical-align:middle;margin-bottom:3px;" align="absmiddle" width="15px" height="15px" /> 客户热线: 400-882-2170</li>
				<li><a href="http://old.baibao.com/" style="color:#4993c8;">【切换旧版】</a></li>
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
-->
<div class="main-nav" id="main-nav">
    <div class="container">
        <div class="main-nav-logo fl">
            <a href="${basePath}/">
                <img src="${basePath}/pictures/index/logo.png" style="vertical-align:middle;margin-top:40px;"/>
            </a>
        </div>
        <div class="nav-box fl">
            <ul class="nav clearfix" id="nav">
                <li class="nLi on"><a href="${basePath}/">首页</a></li>
                <li class="nLi" style="margin-left: 20px;">
                	<a href="${basePath}/service/productList/showProductList">我要投资</a>
                </li>
                <li class="nLi" style="margin-left: 20px;"><a href="${basePath}/service/productList/creditTransList">转让专区</a></li>
                <li class="nLi" style="margin-left: 20px;"><a href="${basePath}/service/borrowMoney">我要借款</a>
                    <!-- ul class="sub" style="display:none;">
                        <li>
                            <a href="${basePath}/service/borrowMoney">个人借贷</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/borrowMoney/companyBorrow">企业借贷</a>
                        </li>
                    </ul>-->
                </li><!-- safetyAssurance-->
               
                <li class="nLi" style="margin-left: 20px;"><a href="${basePath}/service/aboutUs/loanShow">新手引导</a></li>
                <li class="nLi" style="margin-left: 20px;"><a href="${basePath}/service/aboutUs/_help_center">帮助中心</a>
                <li class="nLi" id="us" style="margin-left: 20px;"><a href="${basePath}/service/aboutUs/company?change=us">关于我们</a>
                   <!-- <ul class="sub" style="display:none;">
                        <li>
                            <a href="${basePath}/service/aboutUs/company">公司简介</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/aboutUs_zc">董事长致辞</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/recruitment">招贤纳士</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/contact">联系我们</a>
                        </li>
                      
                        <li>
                            <a href="${basePath}/service/aboutUs/team">管理团队</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/qualification">资质荣誉</a>
                        </li>
                        <li>
                        	<a href="${basePath}/service/aboutUs/activeTimeAxis">往期活动</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/news">媒体报道</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/notice">网站公告</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/staffcare">员工关怀</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/recruitment">招贤纳士</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/contact">联系我们</a>
                        </li>
                        <li>
                            <a href="${basePath}/service/aboutUs/links">友情链接</a>
                        </li>
                        
                    </ul>
                    -->
                </li>
            </ul>
            <script type="text/javascript">
                jQuery("#nav").slide({type: "menu", titCell: ".nLi", targetCell: ".sub", effect: "slideDown", delayTime: 200, triggerTime: 0, defaultPlay: true, returnDefault: true, easing: "swing"});
            </script>
        </div>
        <#if Session["CURRENT_LOGIN_USER"]?exists>
            <div class='Ylogin'>
                <div id='hylogin'>
                    <p class='Y_login'><a href="${basePath}/service/asset">${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</a></p>
                    <p class='Y_login _Ylogin' id='_Ylogin'><a href="${basePath}/service/asset">我的资产</a></p>
                </div>
                <p class='Y_logout'><a href="${basePath}/service/login/logout">退出</a></p>
            </div>
           <!--旧版已经去掉-->
           <!--
                <div class="main-nav-userInfoWrap fr" style='display:none;'>
                    <div class="main-nav-userinfo" style="width:150px;">
                        <a href="${basePath}/service/asset">
                            <#if Session.head_url??>
                                <img  class="userimg-mask" alt="用户头像" src="${basePath}/service/file/${head_url}" width="145px" height="145px">
                            <#else>
                                <div class="userimg-mask iconbg"></div>
                            </#if>
                        </a>
                        <p><a href="${basePath}/service/asset">我的资产</a> <em class="iconbg jdown"></em></p>
                        <ul class="clearfix userinfo-ui">
                            <li><a href="${basePath}/service/asset"><span class="fl">资产总览</span> </a></li>
                            <li><a href="${basePath}/service/account"><span class="fl">我的账户</span> </a></li>
                            <li><a href="${basePath}/service/transRecord"><span class="fl">交易记录</span></a></li>
                            <li><a href="${basePath}/service/personalInvestment"><span class="fl" >我的理财</span></a></li>
                            <li><a href="${basePath}/service/personalBorrow"><span class="fl">我的借款</span></a></li>
                            <li><a href="${basePath}/service/message/toMessageCenter"><span class="fl">消息中心</span></a></li>
                        </ul>
                    </div>
                </div>
            -->
        </#if>
        <#if !Session["CURRENT_LOGIN_USER"]?exists>
            <div class='Nlogin'>
                <p class='N_login'><a href="${basePath}/service/login">登录</a></p>
                <p class='N_register'><a href="${basePath}/service/register">注册</a></p>
            </div>
            <!--
                <div class="main-nav-userInfoWrap fr" style='display:none;'>
                    <div class="main-nav-userinfo" style="width:150px;">
                    <#if Session.head_url??>
                     <img  class="userimg-mask iconbg" alt="用户头像" src="${basePath}/service/file/${head_url}" width="145px" height="145px">
                     <#else>
                     <div class="userimg-mask iconbg"></div>
                    </#if>
                        <p><a href="${basePath}/service/login">我的资产</a><em class="iconbg jdown"></em></p>
                        <ul class="clearfix userinfo-ui">
                            <li style="border-bottom:1px solid #E4E5E6;"><a href="${basePath}/service/login" style="text-align:center;font-size: 14px;color: #333333;width: 90px;">资产总览</a></li>
                            <li style="border-bottom:1px solid #E4E5E6;"><a href="${basePath}/service/login" style="text-align:center;font-size: 14px;color: #333333;width: 90px;">我的理财</a></li>
                            <li style="border-bottom:1px solid #E4E5E6;"><a href="${basePath}/service/login" style="text-align:center;font-size: 14px;color: #333333;width: 90px;">交易记录</a></li>
                            <li><a href="${basePath}/service/login" style="text-align:center;font-size: 14px;color: #333333;width: 90px;">消息中心</a></li>
                        </ul>
                    </div>
                </div>
            -->
        </#if>
    </div>
</div>
<script type='text/javascript'>
    
    $(".main-nav-userinfo").hover(
        function(){
               var $div = $(".main-nav-userinfo");
               t = setInterval(function(){
                      $div.find(".userinfo-ui").slideDown(200)
               },200);
             },function(){
            clearInterval(t);
            $(this).find(".userinfo-ui").slideUp();
        });
        
        $("#hylogin").hover(function () {
            $("#_Ylogin").slideToggle("fast");
        });
    
</script>