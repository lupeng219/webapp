<!DOCTYPE html>
<html>
<head>
   	<#include "./common/common_src.ftl">
    <title>消息中心-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/message-center.css"/>
</head>
<body>
   <#include "./common/common_header.ftl" /> 
   <#include "./common/common_personAccount.ftl" />
   <#include "./common/common_smbanner.ftl"/>
   <div class="personal-main ">
        <div class="container"  style='border:1px solid #eeeded;'>
        	<div class="tab-header">
                <span class="tab-title">消息中心</span>
            </div>
            <div class="per-txtcon clearfix" >
              <#if msglist?size!=0>
                <ul class="message-center mt20">
                	<#list msglist as list>
                    <li>
                        <div class="messtitle-con clearfix "><a href="${basePath}/service/message/toMessageDetails?type=${list.type}" class="message-title">${list.title}</a>
                            <#if list.count != "">
                            <span class="newmess-tip">${list.count}</span>
                            </#if>
                            </div>
                        <p class="message-desc">${list.context}<span class="message-time">${list.time}</span></p>
                    </li>
                    </#list>
                </ul>
                <#else>
                <p class="no-record"  style="margin-top:1rem;">暂无消息</p>
               </#if>
               
               			
               
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script>seajs.use("permainH");</script>
</body>
</html>