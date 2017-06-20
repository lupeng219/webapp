<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>充值-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-recharge.css"/>
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
    <script type="text/javascript" src="${basePath}/js/public/area.js"></script>
    <style>
    .errbank-p {
        line-height: 14px;
        padding-top: 3px;
    }
    .pl10{
        padding-left:0px;
        text-align:left !important;
    }
    .stel{
        float:left;
        line-height:40px;
    }
    #rechargeType{
        width: 200px;
        height: 40px;
        border-radius: 4px;
        padding-left: 20px;
        margin-left: 120px;
        border: 1px solid #ccc;
        background: url("${basePath}/images/down.jpg") no-repeat scroll right center transparent;
        position:relative;
    }
    
    .cz_sub{
        position:absolute;
        left:0;
        top:40px;
        border:1px solid #ccc;
        border-radius:4px;
        overflow:hidden;
        z-index:999;
        display:none;
    }
    .cz_sub>p{
        width: 203px;
        height: 40px;
        line-height: 40px;
        padding-left: 16px;
        border-bottom: 1px solid #ccc;
        background: #fff;
    }
    #rg-type{
        line-height:40px;
        text-align:center;
    }
    #realName,#idCard{
        vertical-align:middle;
        height:28px\9;
        padding-top:10px\9 ;
    }
    :root #realName,#idCard{
        height:38px\9;
        padding-top:0px\9;
    }
    #onlineRechargeMoney {
        height: 26px\9;
        padding-top: 12px\9;
    } 
    :root #onlineRechargeMoney {
        height: 40px\9;
        padding-top: 0px\9;
    }  
</style>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />
    <div id='maskCover' style='display:none'></div>
    <div id='loadingGif' style='display:none'>
        <img src='${basePath}/pictures/icon/loading.gif'>
        <p>玩命加载中...</p>
    </div>
    <div class="personal-main">
        <div class="container">
            <#if result.info == null || result.info.puiPlataccountiscert == '1'>
                <div class="tab-header">
                    <span class="tab-title">实名认证</span>
                </div>
                <div class="tab-content" style='height:606px'>
                    <li class="field-line">
                        <span class="field-name">真实姓名</span>
                        <input type="text" placeholder='请输入真实姓名' maxlength="15" class="field-control" id="realName" autocomplete="off" value="${result.realName}" />
                        <div class="errbank-p"></div>
                    </li>
                    <li class="field-line">
                        <span class="field-name">身证份号</span>
                        <input type="text" class="field-control" id="idCard" autocomplete="off" value="${result.idCard}" maxlength='18' placeholder='请输入身份证号'/>
                        <div class="errbank-p"></div>
                    </li>
                    <li class="field-line" style='margin-top:62px;position:relative;'>
                        <p id='sat-err-remain'></p>
                        <div class="field-name"></div>
                        <a href="javascript:void(0);" class="field-control commit-btn" id="startAuthentication" data-available="true">实名认证</a>
                    </li>
                </div>
            </#if>

            <#if result.info?exists&&result.info.puiPlataccountiscert=='0'>
                <div class="tab-content" id="recharge-main" style="padding-top: 0px;height:606px">
                    <div class="pers-mknav-sty clearfix">
                        <ul class="mknav-ui">
                          
                            <#if result.bankCard?exists>
                            <li class="mkli"><span>第三方（富友）支付帐号</span></li>
                            <li class="mkli mknav-cut"><span>帐号充值</span></li>
                            <#else>
                            <li class="mkli mknav-cut"><span>第三方（富友）支付帐号</span></li>
                            </#if>
                        </ul>
                    </div>
						
                        <#if result.bankCard?exists>
							<div class="quick-recharge tab-typewriter" id="quick-recharge" style="display:none;">
                            <div class="rechmoney-con">
                                <div class="bang-card mt20">
                                    <ul class="bangcard-ui">
                                        <li class="ms">
                                            <span class="card-title">开户状态</span>
                                            <span class="card-desc">已开户</span>
                                        </li>
                                        <li class="ms">
                                            <span class="card-title">开户姓名</span>
                                            <span class="card-desc">${result.bankCard.pbcBankcardname}</span>
                                          
                                        </li>
                                        
                                        <li class="ms">
                                            <span class="card-title">账户余额</span>
                                            <span class="rech-money">${result.balance}元</span>
                                        </li>
                                        <li class="ms">
                                            <span class="card-title">开户银行</span>
                                            <span class="card-desc">${result.bankCard.pbcBankName}</span>
                                        </li>
                                        <li class="ms">
                                            <span class="card-title">银行卡号</span>
                                            <span class="card-desc">${result.bankCard.pbcBankcardno}</span>
                                            <span class='refresh-icon lineH30'></span>
                                            <span>如果您修改过银行卡，请点击更新按钮以获取最新绑定银行卡</span>
                                        </li>
                                        <!--
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title" title='用途：体现，修改密码'>第三方预留手机号</span>
                                                <a href="javascript:void(0);" id="changePhone" class="card-title blue pl10">更改</a>
                                            </div>
                                            <p class="errbank-p  er-ramn"></p>
                                        </li>
                                        -->
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title" title='用途：体现，修改密码'>支付密码</span>
                                                <a href="javascript:void(0);" id="changePassword" class="card-title blue pl10">更改</a>
                                            </div>
                                            <p class="errbank-p  er-ramn"></p>
                                        </li>
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title">交易密码</span>
                                                <#if result.isSetPcaPayPassword=='0'>
                                                    <a href="javascript:void(0);" id="setPayPassword" class="card-title blue pl10">设置交易密码</a>
                                                <#else>
                                                    <span class="card-desc">已设置</span>
                                                </#if>
                                            </div>
                                            <p class="errbank-p"></p>
                                        </li>
                                        <li class="ms" style='margin-top:40px;position:relative;'>
                                            <p id='bk-err-remain'></p>
                                            <span class="card-title"> &nbsp;</span>
                                            <a href="javascript:void(0);" class="rechmoney-btn" 
                                                id="changeCard"
                                                data-available="true">更改银行卡</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
							</div>
							<!--后加-->
							<div class="quick-recharge tab-typewriter" id="online-recharge" style="display:block;">
                        <div class="rechmoney-con">
                            <div class="bang-card mt20">
                                <ul class="bangcard-ui">

                                    <li  class="input-title" style='margin-top: 24px;padding-bottom:24px;'>
                                        <span class="stel">充值方式</span>

                                        <div name="ckfs" id="rechargeType" class="form-control czst">
                                            <span id='rg-type'></span>
                                            <div class='cz_sub'>
                                                <!--<p id='recharge'>网银充值</p>-->
                                                <p id='deposit' style='border-bottom:none;'>快捷充值</p>
                                            </div>
                                        </div>
                                        
                                    </li>
                                    <li class="input-title">请输入您的充值金额</li>
                                    <li style="margin-top: 24px;padding-bottom:24px;position:relative;">
                                        <div class="input-money input-group">
                                            <input type="text" id="onlineRechargeMoney" autocomplete="off" placeholder='请输入充值金额'/>
                                            <span class="input-text" style="text-align: right;">元</span>
                                            
                                        </div>
                                        <p class="errbank-p" style='position:relative;padding-left:0 !important;'></p>
                                    </li>
                                    <li style="margin-top: 10px; color: #bfbfbf; font-size: 14px;">
                                        佰宝金服将为您支付充值手续费。
                                    </li>
                                    <li style="margin-top: 40px;">
                                        <a href="javascript:void(0);" class="rechmoney-btn"
                                            style="background-color: #f8586a;"
                                            id="startOnlineRecharge" data-available="true">充 值</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <!--结束-->
                        <#else>
							<div class="quick-recharge tab-typewriter" id="online-recharge" style="display:block;">
                            <div class="rechmoney-con">
                                <div class="bang-card">
                                    <ul class="bangcard-ui">
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title">开户名</span>
                                                <span class="card-desc" id="cardName">${result.info.puiRealName}</span>
                                            </div>
                                        </li>
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title">开户省份</span>
                                                <input id="loc_province" class="bank-txt select-txt" type="text" style="cursor:pointer;" autocomplete="off" readOnly/>
                                                <ul id="provinceList" class="analogSelect"></ul>
                                            </div>
                                            <p class="errbank-p er-remain"></p>
                                        </li>
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title">开户城市</span>
                                                <input id="loc_city" class="bank-txt select-txt" type="text" style="cursor:pointer;" autocomplete="off" readOnly/>
                                                <ul id="cityList" class="analogSelect"></ul>
                                            </div>
                                            <p class="errbank-p er-remain"></p>
                                        </li>
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title">开户银行</span>
                                                <input id="personBank" class="bank-txt select-txt"
                                                    type="text" style="cursor:pointer;" autocomplete="off" readOnly/>
                                                <ul id="bankList" class="analogSelect">
                                                    <#list result.personalEbank as bank>
                                                        <li data-code="${bank.bankCode}">${bank.bankDesc}</li>
                                                    </#list>
                                                </ul>
                                            </div>
                                            <p class="errbank-p  er-remain"></p>
                                        </li>
                                        <li class="ms">
                                            <div class="clearfix">
                                                <span class="card-title">银行卡号</span>
                                                <input type="text" class="bank-txt" id="bankCode" maxLength="19" autocomplete="off"/>
                                               
                                            </div>
                                            <span class="errbank-p er-remain"></span>
                                        </li>
                                        <li class="ms" style="display:none">
                                            <div class="clearfix">
                                                <span class="card-title">预留手机号</span>
                                                <#if result.mobile?exists>
                                                    <input type="hidden" class="bank-txt" id="reserveMobileCode" maxLength="11" value="${result.mobile}" autocomplete="off"/>
                                                <#else>
                                                    <input type="hidden" class="bank-txt" id="reserveMobileCode" maxLength="11" autocomplete="off"/>
                                                </#if>
                                                <span style="margin-left:12px;line-height:32px;color='#666'"><i class='red'>*</i>此手机号为您在银行开户预留手机号</span>
                                            </div>
                                            <p class="errbank-p  er-remain"></p>
                                        </li>
                                        <li class="ms" style='margin-top:40px;position:relative;'>
                                             <p id='bk-err-remain'></p>
                                            <span class="card-title"> &nbsp;</span>
                                            <a href="javascript:void(0);" class="rechmoney-btn" 
                                                id="startbindCard"
                                                data-available="true">开户</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                         </div>
                         </div>
                        </#if>
                    <#if result.bankCard?exists>
                    
                    </#if>
                </div>
            </#if>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <input type="hidden" value="${result.transFlowNo}" id="transFlowNo"/>
    <form id="myForm" action="${basePath}/service/account/onlineBankRecharge" method="post" target="_blank">
        <input type="hidden" name="rechargeType" id="myRechargeType">
        <input type="hidden" name="bankCode" id="myBankCode">
        <input type="hidden" name="amount" id="myAmount">
        <input type="hidden" name="notifyUrl" id="myNotifyUrl">
    </form>
    <!-- 设置交易密码 -->
    <#include "./personal/_setTransPassword.ftl" />
    <!-- 网银充值遮罩 -->
    <div class="alert-con" style="width:350px;display:none;" id="onlineRechargeModel">
        <div class="widget">
            <div class="widget-head clearfix">
                <div class="fl alert-title">充值提示</div>
            </div>
            <div class="widget-content">
                <div class="padd">
                    <p class="tipp">
                        充值完成前，请不要关闭此充值验证窗口。<br>
                        充值完成后，请根据您支付的情况点击下面按钮。
                    </p>
                    <p class="op-btn" style="margin-top:15px;">
                        <button class="btn btn-primary" id="onlineRechargeSuccess">充值成功</button>
                        <button class="btn btn-default ml10" id="onlineRechargeError">充值遇到问题</button>
                    </p>
                </div>
            </div>
        </div>
    </div>
    
    <script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
    <script>
     
        var bankCard='${result.bankCard}',isSetPcaPayPassword='${result.isSetPcaPayPassword}';
        seajs.use("personal-recharge");
        seajs.use("permainH");
        $("#rg-type").html("网银充值");
        $("#rechargeType").on('click',function(e){
            var ev=e||window.event;
            
            $('.cz_sub').slideDown(200);
            return false;
            ev.stopPropagation();
        })
        $('.cz_sub').on('click','p',function(){
            var scont=$(this).html();
            var Index=$(this).index();
            $("#rg-type").html(scont);
            $('.cz_sub').slideUp(200);
            return false;
            
    
        })
        $(document).click(function(){
            $('.cz_sub').slideUp(200);

        });
       
       
        $(".refresh-icon").click(function(){
     
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
