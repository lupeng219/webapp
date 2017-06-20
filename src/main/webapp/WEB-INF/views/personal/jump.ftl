<html>
    <head>
        <#include "./common/common_src.ftl" />
        <title>充值-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
        <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
        <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    </head>
    <body>
        <form id="myForm" action="${result.url}" method="${result.method}" target="_self">
            <#if result.body?exists>
                <#list result.body?keys as key>
                    <input type="hidden" name="${key}" value="${result.body[key]}"/>
                </#list>
            </#if>
        </form>
        
        <script type="text/javascript">
$(document).ready(function() {
    $("#myForm").submit();
});
        </script>
    </body>
</html>
