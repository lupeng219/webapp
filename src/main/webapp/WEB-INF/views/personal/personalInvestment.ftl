<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>我的投资-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-conduct.css"/>
    <script src="${basePath}/js/public/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
    <div id='coverMask'></div>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />
    <#include "./common/common_smbanner.ftl"/>
    <div class="personal-main " style='padding-bottom:60px;'>
        <div class="container">
            <div class="per-txtcon clearfix">
                <div class="clearfix" style="height:100%">
                    <div class='tab-header'>
                        <h2 class='tab-title'>我的投资</h2>
                    </div>
                    <table style="height:100%">
                    <tr><td style="border-right:1px dashed #000" valign="top">
                    <div class="zichan-con">
                        <!--<p class="zichan-tel">今日收益</p>
                        <p class="zichan-number"><span>${dayWaitInterest?string.currency}</span></p>-->
                        <div class="clearfix mt20">
                            <ul class="zichan-ui" style='width:100%;'>
                                <li>
                                   <em class="ui-dian ui-dian-red"></em> <span class="ui-title">本月收益</span><p><span>${monthTotalInterest?string.currency} </span></p>
                                </li>
                                <li>
                                   <em class="ui-dian ui-dian-red"></em><span class="ui-title">累计收益</span><p><span>${totalIncome?string.currency} </span></p>
                                </li>
                            </ul>

                        </div>
                    </div>
                    </td><td valign="top">
                    <div class="zichan-con">
                        <p class="zichan-tel">我的投资金额</p>
                        <p class="zichan-number" style="color:#333;"><span>${financingAmount?string.currency}</span></p>
                    <!--    <div class="clearfix mt20">
                            <ul class="zichan-ui">
                                <li><em class="ui-dian"></em><span class="ui-title">本月已到期</span><p><span>${monthPrincipal?string.currency} </span></p> <a>(共${monthMatureCount}笔)</a></li>
                            </ul>
                        </div>
                        -->
                    </div>
                    </td>
                    </tr>
                    </table>
                </div>

            </div>
            <div class="per-txtcon clearfix" style="height:auto;">
                <div class="op-conduct" style="margin-left: 30px;margin-right: 30px;float:left;">
                    <div class="fl">
                        <span class="op-title">标的状态</span>
                        <div class="biao-state">
                            <input type="text" class="biao-state-sel" id="biao-state-sel" data="" readonly />
                            <a class="down-card" id="down-card"></a>
                            <ul class="biaostate-list" id="biaostate-list" style="display:none;">
                                <li data="00">所有</li>
                                <li data="1">投资中</li>
                                <li data="4">还款中</li>
                                <li data="2">已满标</li>
                                <li data="5">已完成</li>
                            </ul>
                        </div>
                    </div>
                    <div class="fl pl35">
                        <span class="op-title">时间范围</span>
                        <input type="text" class="biao-time" id="beginTime" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})"/>
                        <span class="op-title"> - </span>
                        <input type="text" class="biao-time" id="endTime" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'beginTime\')}'})"/>
                    </div>
                    <a class="find-btn ml20" href="javascript:ajaxPage(1);">查 询</a>
                </div>
                <div id="baibao-paging" style="margin-left: 30px;margin-right: 30px;width:95%;float:left;">
                    <#include "./personal/_tenderRecords.ftl" />
                </div>
            </div>
        </div>
    </div>
    
    <#include "./common/common_footer.ftl" />
    <script type="text/javascript" src="${basePath}/js/public/decode.js"></script>
    <script type="text/javascript" src="${basePath}/js/baibao/projectWindow.js"></script>
    <script>
        seajs.use("personal-conduct");
    </script>
</body>
</html>
