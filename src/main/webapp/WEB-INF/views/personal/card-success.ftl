<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>提现-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-recharge.css"/>
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
    <script type="text/javascript" src="${basePath}/js/public/area.js"></script>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />

    <div class="personal-main ">
        <div class="container">
            <div class="recharge-main" id="recharge-main">
                <div class="withfrawals-nav">
                    <h2>更改银行卡申请${status}</h2>
                </div>
                <div class="rechmoney-con">
                    <div class="bang-card mt20">
                        <ul class="bangcard-ui">
                            <li class="ms">
                                <span class="card-desc">
                                    您当次更改银行卡申请${status}。请
                                    <a href="javascript:;;" id="close" style="color: blue;">关闭当前页面。</a>
                                </span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script>
        seajs.use("permainH");
    </script>
    <script type="text/javascript">
$(document).ready(function() {
    $("#close").click(function() {
        window.close();
    });
});
    </script>
</body>
