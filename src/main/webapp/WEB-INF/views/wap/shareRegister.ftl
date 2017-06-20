<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta content="yes" name="apple-mobile-web-app-capable">
    <meta content="black" name="apple-mobile-web-app-status-bar-style">
    <meta content="telephone=no" name="format-detection">
    <meta content="email=no" name="format-detection">
    <title>注册</title>
    <link rel="stylesheet" href="${basePath}/css/wap/jquery.mCustomScrollbar.min.css">
    <link rel="stylesheet" href="${basePath}/css/wap/mobile.register.css">
</head>

<body>
    <section class="wrapper">
        <section class="content mCustomScrollbar">
            <section class="banner">
                <img src="${basePath }/images/wap/register-banner.png" alt="">
            </section>
            <form action="" class="fm">
                <li>
                    <section class="phone">
                        <p>
                            <input type="tel" class="phone-number" placeholder="请输入手机号码" maxlength="11">
                        </p>
                        <p>
                            <input type="tel" class="verification-code" id="verification" placeholder="请输入手机验证码" maxlength="6">
                            <a href="javascript:void(0);" class="hqyzm-btn" data-available="true">获取验证码</a>
                        </p>
                    </section>
                    <h6 class="err-remain"></h6>
                </li>
                <li>
                    <p class="psd">
                        <input type="password" placeholder='请输入8位及以上字母加数字' class='password' maxlength="20">
                        <a href="javascript:;" class="psd-ifshow"></a>
                    </p>
                    <h6 class="err-remain" style='height:.82rem'></h6>
                </li>
                <li>
                    <p class="invite-number">
                        <input type="tel" placeholder='请输入推荐人手机号（非必填）' class='invite-num friendMobile' maxlength="11">
                    </p>
                    <h6 class="err-remain"></h6>
                </li>
                <h6 class="agreement">
                    <a href="javascript:;" class="ckbx"><input type="checkbox" class="ckbox" checked></a>
                    <span>我已阅读并同意</span>
                    <a href="${basePath }/service/agreement/registerAgreement" class="agreement-cont">《佰宝金服网站服务协议》</a>
                </h6>
                <h6 class="err-remain" id="friendErr"></h6>
                <p class="regist">
                    <a href="javascript:;" class="register-btn reg-btn" data-available="true">完成</a>
                </p>
                <p class="mt4"></p>
            </form>
        </section>
    </section>
    <script src="${basePath }/js/wap/setfontsize.js"></script>

    <script src="${basePath }/js/wap/zepto.min.js"></script>
    <script src="${basePath }/js/wap/jquery-2.1.0.min.js"></script>
    <script src="${basePath }/js/wap/jquery.mCustomScrollbar.min.js"></script>
    <script src="${basePath }/js/wap/mobile.register.js"></script>
</body>

</html>