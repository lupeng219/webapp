<!DOCTYPE html>
<html>
<head lang="en">
	<#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/securityCenter.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>安全设置</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="container">
            <ul class="ui-securityCenter">
                <li>
                
                	<#if isCert=='1' || isCert==null || isOpen==null || isOpen=='1'>
                    	<a href="${basePath}/service/wapAccount/wapOpenAccount" class="clearfix" style="width: 100%">
                    	<em class="err-icon"></em>
                    	<span class="setting-title">第三方托管账户</span>
                    	<span class="setting-op">未开通 ></span>
                    	</a>
                  	<#else>
                  		<a href="javascript:void(0);" class="clearfix" style="width: 100%">
                    	<em class="ok-icon"></em>
                    	<span class="setting-title">第三方托管账户</span>
                    	<span class="setting-op">已开通 </span>
                    	</a>
                    </#if>
                </li>
                <li><em class="ok-icon"></em>
                    <span class="setting-title">绑定手机</span><span class="setting-op">${mobile?substring(0,4)}***${mobile?substring(7,11)}</span></li>
                <li>
                	<a href="${basePath}/service/wapAccount/wapModifyLoginPassword" class="clearfix" style="width:100%;">
                		<em class="ok-icon"></em>
                		<span class="setting-title">登录密码</span>
                		<span class="setting-op">点击修改 ></span>
               		</a>
           		</li>
                
                <li>
                	<#if (isFirst!=1 || isFirst ==null)>
		        		<a href="${basePath}/service/wapAccount/wapModifyTransPassword" class="clearfix" style="width: 100%">
		        		<em class="err-icon"></em>
		                <span class="setting-title">交易密码</span>
		                	<span class="setting-op">设置 ></span>
		                </a>
		            <#else>
		            	<a href="${basePath}/service/wapAccount/wapModifyTransPassword" class="clearfix" style="width: 100%">
		        		<em class="ok-icon"></em>
		                <span class="setting-title">交易密码</span>
		                	<span class="setting-op">修改</span>
		                </a>
	                </#if>
                </li>
                <li>
                	<#if mail!='1' || mail ==null>
		        		<a href="${basePath}/service/wapAccount/wapModifyMail" class="clearfix" style="width: 100%">
		        		<em class="err-icon"></em>
		                <span class="setting-title">邮箱设置</span>
		                	<span class="setting-op">设置 ></span>
		                </a>
		            <#else>
		            	<a href="${basePath}/service/wapAccount/wapModifyMail" class="clearfix" style="width: 100%">
		        		<em class="ok-icon"></em>
		                <span class="setting-title">邮箱设置</span>
		                	<span class="setting-op">修改</span>
		                </a>
	                </#if>
                </li>
            </ul>
        </div>
		<#include "./wap/common/wap_common_footer.ftl" />
    </div>
</body>
</html>