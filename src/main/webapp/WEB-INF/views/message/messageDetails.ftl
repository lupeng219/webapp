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
  
   <div class="personal-main ">
        <div class="container">
            <div class="per-txtcon clearfix" >
                <div class="tab-header">
                    <h2 class="tab-title">${title}</h2>
                    <a  href="${basePath}/service/message/toMessageCenter" class="return-list">返回消息列表</a>
                </div>
               <div id="messageRecord">
                	<#include "./message/_messageDetailsPage.ftl" /> 
                </div>
               
            </div>
        </div>
    </div>
   
   
   
   
    <#include "./common/common_footer.ftl" />
    <script>seajs.use("messageDetails");</script>
</body>
</html>