<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>我的借款-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-borrow.css"/>
    <style>
        
        
    </style>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl"/>
    <#include "./common/common_smbanner.ftl"/>
    <div class="personal-main ">
        <div class="container">
            <div class="per-txtcon clearfix">
            <h2 class='mbTile'>我的借款</h2>
            <#if myDebt.shouldOverDueAmount==0>
                <table class='calcul-data Noverdue'>
                    <tr>
                        <td class='ftEven'>
                        <div>
                        <span>我的负债</span>
                        <p class="zichan-number"><span>￥${myDebt.totalLiabilities?string(',##0.00')}</span></p>
                        </div>
                        </td>
                        <td class='ftOdd'>
                        <img src='${basePath}/pictures/icon/icon-upto.png'>
                        </td>
                        <td class='ftEven'>
                        <span>待还借款</span>
                        <p class='mt20'><span>￥${myDebt.shouldRepaymentPrincipal?string(',##0.00')} </span></p>
                        </td>
                        <td class='ftOdd'>
                        <img src='${basePath}/pictures/icon/icon-and.png'>
                        </td>
                        <td class='ftEven'>
                        <span>待还利息</span>
                        <p class='mt20'><span>￥${myDebt.shouldRepaymentInterest?string(',##0.00')} </span></p>
                        </td>
                    </tr>
                </table>
            <#else>
                <table class='calcul-data overdue'>
                    <tr>
                        <td class='ftEven'>
                        <div>
                        <span>我的负债</span>
                        <p class="zichan-number"><span>￥${myDebt.totalLiabilities?string(',##0.00')}</span></p>
                        </div>
                        </td>
                        <td class='ftOdd'>
                        <img src='${basePath}/pictures/icon/icon-upto.png'>
                        </td>
                        <td class='ftEven'>
                        <span>待还借款</span>
                        <p class='mt20'><span>￥${myDebt.shouldRepaymentPrincipal?string(',##0.00')} </span></p>
                        </td>
                        <td class='ftOdd'>
                        <img src='${basePath}/pictures/icon/icon-and.png'>
                        </td>
                        <td class='ftEven'>
                        <span>待还利息</span>
                        <p class='mt20'><span>￥${myDebt.shouldRepaymentInterest?string(',##0.00')} </span></p>
                        </td>
                        <td class='ftOdd'>
                        <img src='${basePath}/pictures/icon/icon-and.png'>
                        </td>
                        <td class='ftEven'>
                        <span>逾期费用</span>
                        <p class='mt20'><span>￥${myDebt.shouldOverDueAmount?string(',##0.00')} </span></p>
                        </td>
                    </tr>
                </table>
            </#if>
            <!--
                <div class="zichan-con">
                    <p class="zichan-tel">我的负债</p>
                    <p class="zichan-number" style="color:#474e5d;"><span>￥${myDebt.totalLiabilities}</span></p>
                    <div class="clearfix mt20">
                        <ul class="zichan-ui">
                            <li><em class="ui-dian"></em><span class="ui-title">待还借款</span> <p><span>￥${myDebt.shouldRepaymentPrincipal?string(',##0.00')} </span></p></li>
                            <li><em class="ui-dian"></em><span class="ui-title">待还利息</span> <p><span>￥${myDebt.shouldRepaymentInterest?string(',##0.00')} </span></p></li>
                        </ul>
                    </div>
                </div> -->
            </div>
            <div class="per-txtcon clearfix" id="per-txtcon" style="height:auto;">
                <div class="pers-mknav-sty">
                    <ul class="mknav-ui pers-br">
                        <li class="mkli mknav-cut"><span>还款中</span></li>
                        <li class="mkli"><span>已还清</span></li>
                    </ul>
                </div>
                <!-- 还款中 -->
                <div class="divtab borrow-con">
                    <#include "./personal/_repaymentIn.ftl" />
                </div>
                <!-- 已还清 -->
                <div class="divtab borrow-con" style="display:none;">
                <div id="paidFinished">
                    <#include "./personal/_hasPaidOff.ftl" />
                </div>
                </div>
            </div>
            <div class="per-txtcon clearfix" style="height:auto;">
                <h2 class='mbTile'>借款申请记录</h2>
                <#include "./personal/_borrowRecords.ftl" />
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <input type="hidden" value="${isSetPcaPayPassword}" id="isSetPcaPayPassword"/ >
    <!-- 还款弹框 -->
    <div class="alert-con" id="repaymentModel">
        <div class="widget">
            <div class="widget-head clearfix">
                <div class="fl alert-title">还款帐期</div>
                <div class="fr">
                    <span class="alert-close" title="关闭" id="modelClose">×</span>
                </div>
            </div>
            <div class="widget-content">
               <div class="padd">
                    <ul class="alert-project">
                        <li class="project-title">
                            <span style="margin-left:13px;">还款日</span>
                            <span>应还金额(元)</span>
                            <span>应还本金(元)</span>
                            <span>应还利息(元)</span>
                            <span>逾期费用(元)</span>
                            <span>状态</span>
                        </li>
                    </ul>
                    <ul class="borrow-ui">
                       <li>
                            <span class="ui-title">已还款金额</span>
                            <span class="ui-desc" id="completeTotalPrice"></span>元
                       </li>
                       <!--
                       <li>
                            <span class="ui-title">待还金额</span>
                            <span class="ui-desc" id="waitTotalPrice"></span>元
                       </li>
                       -->
                       <li>
                            <span class="ui-title">本次还款金额</span>
                            <span class="ui-desc" id="repaymentTotal"></span>元
                            <span  title="本期还款金额=本金+利息+逾期" style='padding-left:5px;'><img src='${basePath}/pictures/icon/ico-Prompt.png'</span>
                       </li>
                       <li>
                            <span class="ui-title">剩余未到期数</span>
                            <span class="ui-desc" id="surplusNum"></span>期
                       </li>
                       <li>
                            <span class="ui-title">我的可用余额</span>
                            <span class="ui-desc" id="balance"></span>元
                            <a href="${basePath}/service/account/torecharge" class="ui-desc">充值</a>
                       </li>
                    </ul>
                    <ul class="borrow-ui">
                       <li style="height:39px;">
                            <div class="clearfix">
                                <span class="ui-title">交易密码</span>
                                <input type="password" class="borrow-txt" maxLength="6" id="transPassword"/>
                                <button class="btn btn-warning ml10" id="sureRepayment" data-available="true">还款</button>
                            </div>
                            <p class="err-p"></p>
                       </li>
                   </ul>
               </div>
            </div>
        </div>
    </div>

    <div id="template" style="display: none">
        <li id="repayment-record">
            <input id="checkbox" type="checkbox" class="fl borrowCheck">
            <span id="datetime"></span>
            <span id="principal"></span>
            <span id="capital"></span>
            <span id="interest"></span>
            <span id="overdue"></span>
            <span id="status"></span>
        </li>
    </div>
    
    <!-- 设置交易密码 -->
    <#include "./personal/_setTransPassword.ftl" />
    
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
    <script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
    <script>
        seajs.use("personal-borrow");
        var alertHgh=$("#repaymentModel").height(),alertWth=$("#repaymentModel").width();
        var screenWidth = $(window).width(), screenHeigth = $(window).height();
        var Wth=screenWidth-alertWth,Hgh=screenHeigth-alertHgh;

        $("#repaymentModel").css({
            "top":Hgh/2+"px",
            "left":Wth/2+"px"
        })
    </script>
</body>
</html>
