<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
	<title>旧版账户-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-records.css"/>
    <script src="${basePath}/js/public/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
	<#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />    
    <div class="personal-main ">
        <div class="container">
            <p class="tab-oldAccount"><a href="${basePath}/service/asset">切换新版账户</a> </p>
            <div class="per-txtcon clearfix">
                <div class="zichan-con">
                    <a href="javascript:void(0);" class="oldtx-btn">提 现</a>
                    <p class="zichan-tel">可用余额</p>
                    <p class="zichan-number"><span>￥${result.realAmount?string(',##0.00')}</span></p>
                    <div class="clearfix mt20">
                        <ul class="zichan-ui">
                            <li><em class="ui-dian"></em><span class="ui-title">冻结金额</span> <p><span>￥${result.bidAmount?string(',##0.00')}</span></p> </li>
                            <li><em class="ui-dian"></em><span class="ui-title">待收本息</span> <p><span>￥${result.principal?string(',##0.00')}</span></p></li>
                            <li><em class="ui-dian"></em><span class="ui-title">资产总计</span> <p><span>￥${result.allCount?string(',##0.00')}</span></p></li>
                        </ul>
                    </div>
                </div>

            </div>
            <div class="per-txtcon clearfix">
                <div class="records-title">
                    <h2 class="records-title">交易记录</h2>

                </div>
                <div class="op-fenlei clearfix">
                    <ul class="records-ui clearfix transType">
                        <li class="ui-title">交易分类：</li>
                        <li class="current"><a>全部</a></li>
                        <li><a value="1">充值</a></li>
                        <li><a value="2">提现</a></li>
                        <li><a value="3">投标</a></li>
                        <li class="changeValue"><a value="4">收益</a></li>
                    </ul>
                    <ul class="records-ui clearfix transStatus">
                        <li class="ui-title">交易状态：</li>
                        <li class="current"><a>全部</a></li>
                        <li><a value="0" id="complete">已完成</a></li>
                        <li><a value="2">处理中</a></li>
                        <li><a value="1" id="fail">失败</a></li>
                    </ul>
                </div>
                <div class="op-conduct">
                    <div class="fl ">
                        <span class="op-title">时间范围</span>
                        <input type="text" class="biao-time" id="startTime" value="${startTime}" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd'})"/>
                        <span class="op-title"> - </span>
                        <input type="text" class="biao-time" id="endTime"  value="${endTime}" onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd'})"/>
                    </div>
                    <a class="find-btn ml20" id="searchOldRecord" href="javascript:void(0);">查 询</a>
                </div>
                 <div id="personalOldAccount">
           	<#include "./personal/_personalOldAccountPage.ftl" />
           	</div>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script type="text/javascript" src="${basePath}/js/baibao/projectWindow.js"></script>
	<script>
    	seajs.use("personalOldAccount");
	</script>
	</body>
</html>