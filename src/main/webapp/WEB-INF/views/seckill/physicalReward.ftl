<!DOCTYPE html>
<html>
<head>
   	<#include "./common/common_src.ftl">
	<title>实物奖励-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-active.css"/>
</head>
<body>
   <#include "./common/common_header.ftl" /> 
   <#include "./common/common_personAccount.ftl" />
   <div class="personal-main ">
        <div class="container">
            <div class="per-txtcon clearfix" id="per-txtcon">
                <div class="per-mknav">
                    <span class="mk-title">实物奖励</span>
                </div>
                <div class="main-coupons-list clearfix">
                    <ul class="records-project">
                        <li class="project-title">
                        	<span style="width:15%;" class="xuhao">序号</span>
                            <span style="width:25%;">奖品编号</span>
                            <span style="width:15%;">奖品名称</span>
                            <span style="width:18%;">中奖时间</span>
                            <span style="width:15%;">状态</span>
                        </li>
                        
                         <li>
                         <#if paging.pageList?size !=0>
                        <#list paging.pageList as reward>
                        <span style="width:10%;" class="xuhao">${reward_index+1}</span>
                        <span style="width:30%;">${reward.pup_practicalityNo}</span>
                        <span style="width:15%;">${reward.put_name}</span>
                        <span style="width:18%;">${reward.pup_getTime}</span>
                        <span style="width:15%;">
                        <#if reward.pup_status='0'>
                                                未发放
                        <#else>
                                                已发放
                        </#if>
                        </span>
                        </#list>
                        <#else>
                          <p class="no-text">暂无数据</p>
                        </#if>
                        </li>
                    </ul>
                  
                </div>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script src="${basePath}/js/public/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</body>
</html>
