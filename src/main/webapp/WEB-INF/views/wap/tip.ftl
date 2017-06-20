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

    <style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

ul,
ol,
li {
    list-style: none;
}

a {
    text-decoration: none;
    border: none;
    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
    -webkit-tap-highlight-color: transparent;
    outline: none；
}

html,
body {
    width: 100%;
    height: 100%;
}

.wrapper {
    width: 100%;
    height: 100%;
    overflow: hidden;
    position: relative;
}

.remain {
    color: #333333;
    font-size: .28rem;
    line-height: .36rem;
    width: 54%;
    margin: 1.56rem auto 1.4rem;
    text-align: center;
}

.pic {
    width: 5.54rem;
    height: 4.88rem;
    margin: 0 auto;
    background: url(${basePath}/pictures/errPic.png) no-repeat;
    background-size: contain;
}
    </style>
    <title>佰宝金服</title>
</head>

<body>
    <div class="wrapper">
        <p class="remain">
            请您使用电脑浏览器访问<br/>
            获得极致理财体验
        </p>
        <div class="pic">

        </div>
    </div>

    <script type="text/javascript">
(function (doc, win) {
    var docEl = doc.documentElement, //获取html标签
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);
    </script>
</body>

</html>
