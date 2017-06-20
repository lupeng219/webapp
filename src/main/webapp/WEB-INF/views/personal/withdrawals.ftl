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
                <#if result.puiPlataccountiscert?exists&&result.puiPlataccountiscert=='1'>
                    <div class="rechmoney-con">
                        <ul class="rechmoney-ui">
                            <li class='r_trueName'>
                                您尚未实名认证，提现前请先<a href="${basePath}/service/account/torecharge">填写实名认证信息</a>。
                            </li>
                        </ul>
                    </div>
                <#elseif result.banCard?exists>
                    <div class="withfrawals-nav">
                        <h2>提 现</h2>
                    </div>
                    <div class="rechmoney-con">
                        <ul class="rechmoney-ui">
                            <li style="height:58px;"><span class="rech-title">可用余额</span>
                                <span class="rech-money"><span id="availableMoney">${result.balance}</span>元</span>
                                <input type="hidden" id="availableMoneyValue" value="${result.balance?string('#.##')}"/>
                            </li>
                            <li>
                                <div class="clearfix relative"><span class="rech-title">提现金额</span>
                                    <input type="text" class="rech-txt" id="withdrawalsMoney" maxLength="10" autocomplete="off" placeholder="请输入提现金额"/>
                               <p class="err-p" id="withdrawalsMoneyErr"></p>
                            </li>
<!--
                            <li>
                                <div class="clearfix">
                                    <span class="rech-title">提现银行卡</span>
                                    <span class="rech-txt">${result.banCard.pbcBankName}</span>
                                </div>
                                <p class="err-p" id="withfrawals_card_err"></p>
                            </li>
-->
                            <li style="height:58px;">
                                <span class="rech-title">持卡人</span>
                                <span class="card-desc">${result.banCard.pbcBankcardname}</span>
                            </li>
                            <li style="height:58px;">
                                <span class="rech-title">开户银行</span>
                                <span class="card-desc">${result.banCard.pbcBankName}</span>
                            </li>
                            <li style="height:58px;">
                                <span class="rech-title">银行卡号</span>
                                <span class="card-desc" style='width: 206px;'>${result.banCard.pbcBankcardno}</span>
                                <span class='refresh-icon'></span>
                                <span>如果您修改过银行卡，请点击更新按钮以获取最新绑定银行卡</span>
                            </li>
                            <li style="height:58px;"><span class="rech-title">手续费</span>
                                <span class="rech-money"><span class="">${result.userFee?string('0.00')}</span>元</span>
                            </li>
                            <li><span class="rech-title">交易密码</span>
                                <input type="password" class="rech-txt mr20" id="tradingPassword" maxlength="6" autocomplete="off" placeholder="请输入交易密码"/>
                                <#if result.isSetPcaPayPassword=='1'>
                                    <a href="${basePath}/service/account/findtranspassword" class='forget_pw'>忘记密码</a>
                                    <#else>
                                    <a href="javascript:void(0);" id="setPayPassword" class="setTransPass-btn">设置交易密码</a>
                                </#if>
                                <p class="err-p" id="tradingPasswordErr"></p>
                            </li>
                            <li class='fl mr64'><span class="rech-title">&nbsp;</span>
                                <a href="javascript:void(0);" class="rechmoney-btn" id="withdrawalsSubmit" data-available="true">提 现</a>
                                
                            </li>
                            <!--<li class='tt_remain gy666'>注：15:00前提现，T+1到账；15:00后提现，T+2到账；</li>-->
                            <h4 class='bt_remain' style='border:none;'><p style='display:none;'>温馨提示：提现金额单笔限额5万，单日限额50万，最小提现金额50元！<p></h4>
                        </ul>
                        
                    </div>
                <#else>
                    <div class="rechmoney-con">
                        <ul class="rechmoney-ui">
                            <li style="">
                                您尚未第三方支付开户，提现前请先<a href="${basePath}/service/account/torecharge">第三方支付开户</a>。
                            </li>
                        </ul>
                    </div>
                </#if>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <!-- 设置交易密码 -->
    <#include "./personal/_setTransPassword.ftl" />

    <form id="myForm" rem-action="${basePath}/service/account/onlineBankRecharge" rem-method="post" target="_blank">
    </form>

    <!-- 网银提现遮罩 -->
    <div class="alert-con" style="width: 350px; display:none;" id="onlineRechargeModel">
        <div class="widget">
            <div class="widget-head clearfix">
                <div class="fl alert-title">提现提示</div>
            </div>
            <div class="widget-content">
                <div class="padd">
                    <p class="tipp">
                        提现完成前，请不要关闭此提现验证窗口。<br>
                        提现完成后，请根据您支付的情况点击下面按钮。
                    </p>
                    <p class="op-btn" style="margin-top:15px;">
                        <button class="btn btn-primary" id="onlineRechargeSuccess">提现成功</button>
                        <button class="btn btn-default ml10" id="onlineRechargeError">提现遇到问题</button>
                    </p>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
    <script>
        var isSetPcaPayPassword='${result.isSetPcaPayPassword}';
        seajs.use("personal-withdrawals");
        seajs.use("permainH");
        $(".refresh-icon").on('click',function(){
            $.post(root+"/service/account/refreshCard",{		        
		     },function(data){
		    	if (data.retCode) {
		    	    alert('银行卡信息更新成功'); 
                	window.location.reload(); 
                }else
                {
                   alert('银行卡信息未更改');
                }
		     });
        });
        var alertHgh=$("#onlineRechargeModel").height(),alertWth=$("#onlineRechargeModel").width();
        var screenWidth = $(window).width(), screenHeigth = $(window).height();
        var Wth=screenWidth-alertWth,Hgh=screenHeigth-alertHgh;

        $("#onlineRechargeModel").css({
            "top":Hgh/2+"px",
            "left":Wth/2+"px"
        })
    </script>
</body>
</html>
