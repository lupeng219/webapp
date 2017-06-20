<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
	<title>提现-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-recharge.css"/>
</head>
<body>
   <#include "./common/common_header.ftl" /> 
   <#include "./common/common_personAccount.ftl" />
   <div class="personal-main ">
        <div class="container">
            <div class="recharge-main" id="recharge-main">
                <div class="withfrawals-nav">
                    <h2>提 现</h2>
                </div>
                <div class="rechmoney-con">
                    <ul class="rechmoney-ui">
                        <li style="height:58px;"><span class="rech-title">可用余额</span>
                            <span class="rech-money"><span>${result.realAmount}</span>元</span>
                            <input type="hidden" value="${result.realAmount?string("#########.00")}" id="availableMoney"/>
                        </li>
                        <li>
                            <div class="clearfix">
                                <span class="rech-title">提现银行卡</span>
                                <div class="withfrawals_card">
                                	<#if result.bankType??>
                                		<img src="${basePath}/images/banklogo/${result.bankType}.png"/>
                                	<#else>
                                    	<img src="${basePath}/images/banklogo/noBankCard.png"/>
		                        	</#if>
                                </div>
                            </div>
                            <p class="err-p"></p>
                        </li>
                        <li>
                            <div class="clearfix"><span class="rech-title">提现金额</span>
                                <input type="text" placeholder="请输入提现金额" class="rech-txt" id="withdrawalsMoney" maxlength="10"/>
                                <span class="pl10">元</span> <span class="pl30 red">*起提金额50元，每日累计申请提现金额不能超过100万元!</span></div>
                            <p class="err-p" id="withdrawalsMoneyErr"></p>
                        </li>
                        <li style="height:58px;">
                        	<div class="clearfix">
	                        	<span class="rech-title">实扣金额</span>
	                            <span class="rech-money"><span class="">0.00</span>元</span>
	                            <span class="pl30 red">*提现费用每笔三元,由佰宝金服平台为您支付!</span>
                            </div>
                            <p class="err-p" id="resultErr"></p>
                        </li>
                        <li class="mt10">
                        	<span class="rech-title">&nbsp;</span>
                        	<#if result.bankType ==null>
                        		<a href="javascript:void(0);" class="rechmoney-btn-not">提 现</a>
                        	<#else>
                        		<a href="javascript:void(0);" class="rechmoney-btn" id="withdrawalsSubmit" data-available="true">提 现</a>
                        	</#if>
                        </li>
                    </ul>
                    <div class="wxts-con">
                        <ul>
                            <li class="font16 strong">温馨提示</li>
                            <li>1. 为保障您的账户资金安全，只可向您名下的借记卡提现，否则提现申请将不予受理。</li>
                            <li>2. 如果您填写的提现信息不正确可能会导致提现失败。</li>
                            <li>3. 收到您的提现请求后，佰宝金服将在1-3个工作日（双休日或法定节假日顺延）处理您的提现申请，请您注意查收。</li>
                            <li>4. 平台禁止信用卡套现、虚假交易、洗钱等行为，一经发现并确认，将终止该账户的使用。</li>
                            <li class="red">注：联动财务同事于工作日的10点，14点、16点，定时对用户发起的提现请求进行受理，16点以后提交的提现申请，将于第二个工作日10点审核。若遇节假日顺延。每周一因要审核周五、周六、周日三天的付款申请，因此略有延时。</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <form id="myForm" action="${basePath}/service/account/toUmpayJump" method="get" target="_blank">
		<input type="hidden" name="url" id="myUrl">
	</form>
    <#include "./common/common_footer.ftl" />
    <!-- 联动提现遮罩 -->
    <div class="alert-con" style="width:350px;display:none;" id="withdrawalsModel">
        <div class="widget">
            <div class="widget-head clearfix">
                <div class="fl alert-title">提现提示</div>
            </div>
            <div class="widget-content">
                <div class="padd">
                    <p class="tipp">
                    	提现完成前，请不要关闭此提现验证窗口。<br>
                    	提现完成后，请根据您提现的情况点击下面按钮。
                    </p>
                    <p class="op-btn" style="margin-top:15px;">
                        <button class="btn btn-primary" id="withdrawalsSuccess">提现成功</button>
                        <button class="btn btn-default ml10" id="withdrawalsError">提现遇到问题</button>
                    </p>
                </div>
            </div>
        </div>
    </div>
    <script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
	<script>seajs.use("skipWithdrawCash");
        var alertHgh=$("#withdrawalsModel").height(),alertWth=$("#withdrawalsModel").width();
        var screenWidth = $(window).width(), screenHeigth = $(window).height();
        var Wth=screenWidth-alertWth,Hgh=screenHeigth-alertHgh;

        $("#withdrawalsModel").css({
            "top":Hgh/2+"px",
            "left":Wth/2+"px"
        })
    </script>
</body>
</html>