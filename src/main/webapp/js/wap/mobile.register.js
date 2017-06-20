(function ($) {
    $(function () {
            var myscroll;

            /*只能输入数字*/
            Num(".phone-number");
            Num(".verification-code");
            Num(".invite-num");
            /*只允许输入数字*/
            function Num(Num) {
                $(Num).on('keyup', function () {
                    var tmptxt = $(this).val();
                    $(this).val(tmptxt.replace(/\D/g, ''));
                })
            }
            /*密码显示*/
            $(".psd-ifshow").on('click', function () {
                    if ($(".password").attr("type") == "password") {
                        $(".password").attr("type", "text");
                        $(this).addClass("psd-show").removeClass("psd-unshow");
                    } else {
                        $(".password").attr("type", "password");
                        $(this).addClass("psd-unshow").removeClass("psd-show");
                    }
                })
                /*点击获取验证码*/
            var $mobile = $(".phone-number"),
                $this = $(this),
                $password = $(".password"),
                $friendMobile = $(".friendMobile"),
                $verification = $("#verification");

            //获取手机验证码
            function getMobileVerFormat(element) {
                var timeNum = 60;
                var tempHtml = element.html();
                element.html(timeNum + "s重新发送");
                element.css({
                    "background": "#eeeeee",
                    "color": "#666666"
                });
                var timer = setInterval(function () {
                    if (timeNum <= 1) {
                        clearInterval(timer);
                        element.html(tempHtml);
                        element.attr("data-available", true);
                        element.css({
                            "background": "#14cca6",
                            "color": "#ffffff"
                        });
                    } else {

                        --timeNum;
                        element.html(timeNum + "s后重新获取");

                    }
                }, 1000);
            };
            //手机号验证
            var common_result = {
                success: true,
                msg: ""
            };

            //邀请人手机号验证
            function friendMobileFormat(element) {
                var objValue = $.trim(element.val());
                if (objValue) {
                    if (!objValue.match("^1[0-9]{2}[0-9]{8}|^15[0-9]{1}[0-9]{8}|^17[0-9]{1}[0-9]{8}|^18[0-9]{1}[0-9]{8}")) {
                        common_result.success = false;
                        common_result.msg = "您输入的推荐人手机号不存在，请重新输入";
                    } else {
                        common_result.success = true;
                    }
                } else {
                    common_result.success = true;
                }
                return common_result;
            };

            function mobileFormat(element) {
                var objValue = $.trim(element.val());
                if (!objValue) {
                    common_result.success = false;
                    common_result.msg = "手机号不能为空";
                } else if (!objValue.match("^14[0-9]{1}[0-9]{8}|^13[0-9]{1}[0-9]{8}|^15[0-9]{1}[0-9]{8}|^16[0-9]{1}[0-9]{8}|^17[0-9]{1}[0-9]{8}|^18[0-9]{1}[0-9]{8}")) {
                    common_result.success = false;
                    common_result.msg = "请输入正确的手机号";
                } else {
                    common_result.success = true;
                }
                return common_result;
            };
          //手机验证码验证
            function mobileVerFormat(element) {
                var objValue = $.trim(element.val());
                if (!objValue) {
                    common_result.success = false;
                    common_result.msg = "手机验证码不能为空";
                } else if (objValue.length > 6) {
                    common_result.success = false;
                    common_result.msg = "手机验证码不正确";
                } else {
                    common_result.success = true;
                }
                return common_result;
            };
            //密码验证
            function passwordFormat(element, elementSub) {
                var objValue = $.trim(element.val()); //密码
                var objSubValue = "";
                var regLower = /[a-zA-Z]/;
                var regStr = /[0-9]/;
                var complex = 0;
                var regyz = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
                if (regLower.test(objValue)) {
                    ++complex;
                }
                if (regStr.test(objValue)) {
                    ++complex;
                }
                if (!regyz.test(objValue)) {
                    ++complex;
                }
                elementSub ? objSubValue = $.trim(elementSub.val()) : objSubValue = "";
                if (!objValue) {
                    common_result.success = false;
                    common_result.msg = "密码不能为空";
                } else if (complex < 3 || objValue.length < 8) {
                    common_result.success = false;
                    common_result.msg = "请输入8位及以上字母加数字";
                } else if (objSubValue && objValue != objSubValue) {
                    common_result.success = false;
                    common_result.msg = "请修改重复密码";
                } else {
                    common_result.success = true;
                }
                return common_result;
            };


            function resultVer(data, element) {
                if (data.success == true) {
                    clearStyle();
                    return true;
                } else {
                    clearStyle();
                    element.closest("li").find(".err-remain").html(data.msg);
                    return false;
                }
            };

            function clearStyle() {
                $(".err-remain").html("");
            };

            function mobileBlur() {
                result = mobileFormat($mobile);
                var temp = resultVer(result, $mobile);
                return temp;
            };

            function passwordBlur() {
                result = passwordFormat($password);
                console.log(result)
                var temp = resultVer(result, $password);
                return temp;
            };

            /*点击获取验证码*/
            $(".hqyzm-btn").on("click", function () {
            	
            	
                result = mobileFormat($mobile);
                var temp = resultVer(result, $mobile);

                if (!temp) {
                    return;
                }
                var $this = $(this);
                var isAvailable = $this.attr("data-available");
                if (isAvailable == "true") {
                    $this.attr("data-available", false);
                    $.post("/service/AppRegister/verificationCode", {
                        "phone": $.trim($mobile.val()),
                        "style": "register"

                    }, function (data) {
                        if (data.retCode) {
                            getMobileVerFormat($this);
                        } else {
                            clearStyle();

                            resultVer({
                                "success": data.retCode,
                                "msg": data.retMsg
                            }, $mobile);
                        }
                        $this.attr("data-available", true);
                        return false;

                    });
                } else {
                    return false;
                }

            });
            function verificationBlur(){
                result=mobileVerFormat($verification);
                var temp=resultVer(result,$verification);
                return temp;
            };
            function friendMobileBlur() {
                result = friendMobileFormat($friendMobile);
                var temp = resultVer(result, $friendMobile);
                return temp;
            };
            $(".reg-btn").on("click", function () {

                var $this = $(this);
                var isAvailable = $this.attr("data-available");
                if (isAvailable == "true") {
                    $this.attr("data-available", false);
                    if (mobileBlur() && passwordBlur() && friendMobileBlur() && verificationBlur()) {
                        var $ckbox = $(".ckbox");
                        if (!$ckbox.attr("checked")) {
                            $("#friendErr").html("请勾选我已阅读并同意《佰宝金服用户隐私与注册服务协议》");
                            $this.attr("data-available", true);
                            return false;
                        }
                        var friends = $friendMobile.val() || "";
                        $.post("/service/AppRegister/register", {
                            "phone": $.trim($mobile.val()),
                            "code": $.trim($verification.val()),
                            "password": $.trim($password.val()),
                            "invitingMobile": friends
                        }, function (data) {

                            if (data.retCode) {
                                window.location.href = "/service/wapShare/download";
                            } else {
                                if (data.type == 'phone') {
                                    resultVer({
                                        "success": data.retCode,
                                        "msg": data.retMsg
                                    }, $mobile);
                                } else if (data.type == 'password') {
                                    resultVer({
                                        "success": data.retCode,
                                        "msg": data.retMsg
                                    }, $password);
                                } else if (data.type == 'friend') {
                                    resultVer({
                                        "success": data.retCode,
                                        "msg": data.retMsg
                                    }, $friendMobile);
                                } else if (data.type == 'valdatecode') {
                                    resultVer({
                                        "success": data.retCode,
                                        "msg": data.retMsg
                                    }, $verification);
                                } else {
                                    $("#friendErr").html(data.retMsg);
                                }
                                $this.attr("data-available", true);
                                return false;
                            }
                        });
                    } else {
                        $this.attr("data-available", true);
                        return false;
                    }
                } else {
                    return false;
                }
            });
        })
        /*滚动*/

})(Zepto);