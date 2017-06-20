<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
	<title>修改交易密码-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <#include "./common/common_src.ftl" />
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/back-password.css"/>
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
    <style>
      
   
        .backpwd-ui{
            padding-bottom: 50px;
        }
        .back-txt{
            margin-bottom: 24px;
            
        }
    </style>
</head>
<body>

    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />
    <div class="personal-main ">
        <div class="container">
            <div class="per-txtcon clearfix">
                <div class="backPwd-title">
                    <h2 class="backPwd">找回交易密码</h2>
                </div>
                <div class="setting-step-con">
                    <div class="step-list-con step-total-3 step-current-1">
                        <ul class="step-list clearfix">
                            <li class="step-item current-step">
                                <span class="step-index ">1</span>
                                <span>验证身份</span>
                            </li>
                            <li class="step-item">
                                <span class="step-index ">2</span>
                                <span>重置交易密码</span>
                            </li>
                            <li class="step-item">
                                <span class="step-index">3</span>
                                <span>完成</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="backPwd-con">
                    <!-- 修改交易密码  第一步 验证身份 -->
                    <ul class="backpwd-ui">
                        <li><span class="back-title">已验证手机号</span>
                            <p class="back-desc">${Session.CURRENT_LOGIN_USER.puMobile?substring(0,3)}****${Session.CURRENT_LOGIN_USER.puMobile?substring(7,11)}</p>
                        </li>
                        <li>
                            <div class="clearfix" style='width: 600px;'><span class="back-title">手机验证码</span>
                                <input type="text" class="back-txt" id="mobileVer" maxlength="6" placeholder='请输入手机验证码' onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') "/>
                                <a href="javascript:void(0);" class="btn-hqyzm" data-available="true">获取验证码</a></div> <!-- 点击获取验证码，按钮置灰，class名追加btn-hqyzm-hui，倒计时 -->
                            <p class="err-p" id="errOne"></p>
                        </li>
                        <li><span class="back-title">&nbsp;</span>
                            <a href="javascript:void(0);" class="btn-nextStep fl" id="backSubmitOne">下一步</a>
                        </li>
                    </ul>
                    <!-- 修改交易密码  第二步 重置交易密码-->
                    <ul class="backpwd-ui" style="display:none;">
                        <li>
                            <div class="clearfix"><span class="back-title">新密码</span>
                                <input type="password" class="back-txt" id="tradingPassword" placeholder="请输入由6位数字组成的密码" maxlength="6"/>
                            </div>
                            <p class="err-p"></p>
                        </li>
                         <li>
                            <div class="clearfix"><span class="back-title">确认新密码</span>
                                <input type="password" class="back-txt" id="tradingPasswordSub" placeholder="请输入重复密码" maxlength="6"/>
                            </div>
                            <p class="err-p" id="errTwo"></p>
                        </li>
                        <li><span class="back-title">&nbsp;</span>
                            <a href="javascript:void(0);" class="btn-nextStep fl" id="backSubmitTwo">修 改</a>
                        </li>
                    </ul>
                    <!-- 修改交易密码  第三步 成功-->
                    <div class="backpwd-ui backpwd-ok" style="display:none;">
                            <div class="updateok-img"></div>
                            <p class="update-ok">恭喜,交易密码重置成功！</p>
                             <p class="update-tip">请牢记新的交易密码</p>
                           <p> <a href="${basePath}/service/account" class="btn-nextStep">返回账户设置</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<#include "./common/common_footer.ftl" />
	<script>seajs.use("backPassword-jiaoyi");</script>
</body>
</html>