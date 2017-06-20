<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>资产总览-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-center.css"/>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />
    <#include "./common/common_smbanner.ftl"/>
    <div class="personal-main">
        <div class="container" style='border:1px solid #eeeded;'>
            <div class="tab-header">
                <span class="tab-title">资产总览</span>
            </div>
            <div class="tab-content">
                <table class="personal-table">
                    <tr>
                        <td>
                            <span class="tab-tip">可用金额</span>
                            <p class="tab-text">
                                <span class="tab-money">${assetPandect.accountBalance?string(',##0.00')}</span>元
                            </p>
                            <div class="personal-btns">
                                <a class="red-btn" href="${basePath}/service/account/torecharge">充值</a>
                                <a class="blue-btn" href="${basePath}/service/account/towithdrawals">提现</a>
                            </div>
                        </td>
                        <td>
                            <span class="tab-tip">投资中金额</span>
                            <p class="tab-text">
                                <span class="tab-money">${assetPandect.investTotal?string(',##0.00')}</span>元
                            </p>
                            <div class="personal-btns">
                                <a class="gray-btn" href="${basePath}/service/personalInvestment">详情</a>
                            </div>
                        </td>
                        <td>
                            <span class="tab-tip">奖励金额</span>
                            <p class="tab-text">
                                <span class="tab-money">${assetPandect.activityReward?string(',##0.00')}</span>元
                            </p>
                        </td>
                        <td>
                            <span class="tab-tip">待收本息</span>
                            <p class="tab-text">
                                <span class="tab-money">${assetPandect.accumulatedIncome?string(',##0.00')}</span>元
                            </p>
                        </td>
                        <td>
                            <span class="tab-tip">资产总额</span>
                            <p class="tab-text">
                                <span class="tab-money">${assetPandect.propertyTotal?string(',##0.00')}</span>元
                            </p>
                        </td>
                    </tr>
                </table>
            </div>

            <div class="tab-header">
                <span class="tab-title">投资收益曲线</span>
            </div>
            <div class="tab-content" style='position:relative;'>
                <p class='tabCt-subnav'><span class='InvestAmount'>投资金额</span><span class='IncomeAmount'>收益金额</span></p>
                <div id="chartContainer" style="height: 300px;"></div>
            </div>
        </div>
    </div>

    <#include "./common/common_footer.ftl" />
    <script type="text/javascript" src="${basePath}/js/public/echarts-all.js"></script>
    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('chartContainer'));
        var investmentAmount = [];  
        var incomeAmount = [];  
        var month = [];
        $.ajaxSettings.async = false;
        // 加载数据  
        $.post(root+"/service/asset/getTmentIncome", {}, function(data) {
            investmentAmount = data.investmentAmount;  
            incomeAmount = data.incomeAmount; 
            month = data.month;
        },"json"); 
        var option = {
            backgroundColor:'#fff',
            title:{
                show:true,
                text:'',
                x:'left',
                y:'top'
            },
            tooltip : {
                trigger: 'axis'
            },
            grid:{
                x:60,
                x2:60
            },
            calculable : true,
            xAxis : [
                {   
                    type : 'category',
                    boundaryGap : false,
                    data : month
                }
            ],
            yAxis : [
                {   
                    name:'收益金额（元）',
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'投资金额',
                    type:'line',
                    //stack: '总量',
                    data:investmentAmount
                },
                {
                    name:'收益金额',
                    type:'line',
                    //stack: '总量',
                    data:incomeAmount
                }
            ]
        };
        myChart.setOption(option);
    </script>
</body>
</html>
