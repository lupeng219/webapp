/**
 * Created by chen on 2015/10/28.
 */
$(function () {
    var result = {};
    var $mobile = $("#mobile"),
        $imgVer = $("#imgVer"),
        $mobileVer = $("#mobileVer"),
        $password = $("#password"),
        $passwordSub = $("#passwordSub"),
        $errOne = $("#errOne"),
        $errTwo = $("#errTwo"),
        $errThree = $("#errThree"),
        $backpwd_ui = $(".backpwd-ui"),
        $step_item = $(".step-list .step-item");

    $mobile.on("input", function () {
        domInputIntEvent($mobile);
    });
    //$mobile.on("blur", mobileBlur);
    //$imgVer.on("blur", imgVerBlur);
    $mobileVer.on("blur", mobileVerBlur);
    $password.on("blur", passwordBlur);
    $passwordSub.on("blur", passwordSubBlur);

    function mobileBlur() {
        result = mobileFormat($mobile);
        var temp = resultVer(result, $mobile);
        return temp;
    };

    function imgVerBlur() {
        result = imagesVerFormat($imgVer);
        var temp = resultVer(result, $imgVer);
        return temp;
    };

    function mobileVerBlur() {
        result = mobileVerFormat($mobileVer);
        var temp = resultVer(result, $mobileVer);
        return temp;
    };

    function passwordBlur() {
        result = passwordFormat($password, $passwordSub);
        var temp = resultVer(result, $password);
        return temp;
    };

    function passwordSubBlur() {
        result = passwordSubFormat($password, $passwordSub);
        var temp = resultVer(result, $passwordSub);
        return temp;
    };

    $("#backSubmitOne").on("click", function () {
        if (imgVerBlur() && mobileBlur()) {
            $.post(root + "/service/login/testingImageCode", {
                "imgVer": $.trim($imgVer.val()),
                "mobile": $.trim($mobile.val())

            }, function (data) {
                if (data.retCode) {
                    $("#phoneNo").html($.trim($mobile.val()));
                    showHide(2);
                } else
                {
                    if (data.errorType == "code")
                    {
                        resultVer({
                            success: false,
                            msg: data.retMsg
                        }, $imgVer);
                        $errOne.html(data.retMsg);
                    } else if (data.errorType == "mobile")
                    {
                        resultVer({
                            success: false,
                            msg: data.retMsg
                        }, $mobile);
                        $errTwo.html(data.retMsg);
                        
                    }
                    return false;
                }
            });
        } else {
            return false;
        }
    });

    //获取手机验证码
    $("#getPhoneVar").on("click", function () {
        var $this = $(this);
        var isAvailable = $this.attr("data-available");
        if (isAvailable == "true") {
            $this.attr("data-available", false);
            $.post(root + "/service/login/getPhoneVar", {
                'userMobile': $.trim($mobile.val())
            }, function (data) {
                if (!data.retCode) {
                    if (data.retType != "" && data.retType == 'unVerified') {
                        $("#errTwo").html(data.retMsg);
                        setTimeout(function () {
                            location.reload();
                        }, 1000);
                    } else {
                        $("#errTwo").html(data.retMsg);
                        //	                	clearInterval(timer);
                        //	                	$("#getPhoneVar").html("获取手机验证码");
                        //	                	flag=true;
                        $this.attr("data-available", true);
                        return false;
                    }
                } else {
                    getMobileVerFormat($this);
                }
            });
        } else {
            return false;
        }
    });

    $("#backSubmitTwo").on("click", function () {
        if (mobileVerBlur()) {
            $.post(root + "/service/login/testingverifyCode", {
                'userMobile': $.trim($mobile.val()),
                "validateCode": $.trim($mobileVer.val())
            }, function (data) {
                if (data.retCode) {
                    showHide(3);
                } else {
                    $errTwo.html(data.retMsg);
                    return false;
                }
            });

        } else {
            return false;
        }
    });
    $("#backSubmitThree").on("click", function () {
        if (passwordBlur() && passwordSubBlur()) {
            $.post(root + "/service/login/updatePassword", {
                "password": $.trim($password.val()),
                "passwordSub": $.trim($passwordSub.val())
            }, function (data) {
                if (data.retCode) {
                    showHide(4);
                } else {
                    $errThree.html(data.retMsg);
                    return false;
                }
            });
        } else {
            return false;
        }
    });




    function resultVer(data, element) {
        if (data.success) {
            clearStyle();
            return true;
        } else {
            clearStyle();
            element.closest("li").find(".err-p").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };

    function clearStyle() {
        $(".err-p").html("");
        $(".back-txt").removeClass("txt-err");
    };

    function showHide(data) {
        data = data - 1;
        for (var i = 0; i < $backpwd_ui.length; i++) {
            if (i == data) {
                $backpwd_ui[i].style.display = "block";
                $step_item[i].className = "step-item current-step";
            } else {
                $backpwd_ui[i].style.display = "none";
                $step_item[i].className = "step-item";
            }
        }
    }

    //验证码
    $("#checkCodeImg").on("click", function () {
        var src = $(this).attr("src");
        var r = Math.random();
        if (src.indexOf("?") >= 0) {
            src = src.substring(0, src.indexOf("?"));
        }
        $(this).attr("src", src + "?r=" + r);
    });
    $("#changeCodeBtn").on("click", function () {
        var src = $("#checkCodeImg").attr("src");
        var r = Math.random();
        if (src.indexOf("?") >= 0) {
            src = src.substring(0, src.indexOf("?"));
        }
        $("#checkCodeImg").attr("src", src + "?r=" + r);
    });
});