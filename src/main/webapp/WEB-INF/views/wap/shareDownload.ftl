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
    <link rel="stylesheet" href="${basePath}/css/wap/mobile.download.css">
</head>

<body>
    <section class="wrapper">
        <p class="iphone">
            <span class="iphone-pic"></span>
        </p>
        <p class="dbtn">
            <a href="javascript:;" class="download-btn"></a>
        </p>
        <div class="iosBg" style="display:none;">
			<div class="finger"></div>
        </div>
    </section>
    <script src="${basePath }/js/wap/setfontsize.js"></script>

    <script src="${basePath }/js/wap/zepto.min.js"></script>
    <script type="text/javascript">
        var u = navigator.userAgent;
        var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1 || u.indexOf('Linux') > -1; //android终端
        var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端

        $(".dbtn").on('click', function () {
            if (isAndroid) {
                $(".download-btn").attr('href', 'https://www.baibaojinfu.com/service/AppMsg/appDownload');
            } else if (isiOS) {
                $(".download-btn").attr('href', 'https://itunes.apple.com/us/app/bai-bao-jin-fu/id1144001791?l=zh&ls=1&mt=8');
            }

        });
        window.onload = function () {
            if (isWeiXin()) {
           
                if (isAndroid) {
                    window.location.href = 'http://a.app.qq.com/o/simple.jsp?pkgname=com.credithundred.bbjf';
                } else if (isiOS) {
                    $(".iosBg").show();
                }
            }
        }

        function isWeiXin() {
            var ua = window.navigator.userAgent.toLowerCase();
            if (ua.match(/MicroMessenger/i) == 'micromessenger') {
                return true;
            } else {
                return false;
            }
        }
    </script>
</body>

</html>