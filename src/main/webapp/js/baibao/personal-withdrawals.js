/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */
$(function () {
    var availableMoneyValue = "";
    var withdrawalsMoney = "";
    var tradingPassword = "";

    $withdrawalsMoney = $("#withdrawalsMoney");
    $tradingPassword = $("#tradingPassword");

    result = {};

    //绑定事件
    $("#reserveMobileCode").on("input", function () {
        domInputIntEvent($(this));
    });

    $withdrawalsMoney.on("input", function () {
        domInputFloatEvent($withdrawalsMoney);
    });

    $withdrawalsMoney.on("blur", function () {
        withdrawalsMoneyBlur();
    });

    $tradingPassword.on("blur", function () {
        tradingPasswordBlur();
    });

    $("#newTransPwd").on("blur", newTransPwdBlur);
    $("#newTransPwdSub").on("blur", newTransPwdSubBlur);

    //事件处理
    function withdrawalsMoneyBlur() {
        result = withdrawalsMoneyFormat($withdrawalsMoney);
        var temp = resultVer(result, $withdrawalsMoney);

        if (temp) { //提现金额
            var withdrawalsMoney = parseFloat($.trim($withdrawalsMoney.val()));
            if (withdrawalsMoney < 50) {
                resultVer({
                    "success": false,
                    "msg": "最小提现金额为50元，请您重新输入"
                }, $withdrawalsMoney);

                temp = !temp;
            }
        }

        return temp;
    };

    function tradingPasswordBlur() {
        if (isSetPcaPayPassword == '0') {
            resultVer({
                "success": false,
                "msg": "请设置交易密码"
            }, $tradingPassword);

            return false;
        }

        result = tradingPasswordFormat($tradingPassword);
        var temp = resultVer(result, $tradingPassword);

        return temp;
    };

    function newTransPwdBlur() {
        result = tradingPasswordFormat($("#newTransPwd"));
        var temp = resultVer(result, $("#newTransPwd"));
        return temp;
    };

    function newTransPwdSubBlur() {
        result = passwordSubFormat($("#newTransPwd"), $("#newTransPwdSub"));
        var temp = resultVer(result, $("#newTransPwdSub"));
        return temp;
    };

    //验证返回
    function resultVer(data, element) {
        if (data.success) {
            clearStyle();
            return true;
        } else {
            clearStyle();

            element.closest("li").find(".err-p").html(data.msg);
            element.closest("li").find(".errbank-p").html(data.msg);
            element.closest("li").find(".alert-err-tip").html(data.msg);
            element.addClass("txt-err");

            return false;
        }
    };

    function clearStyle() {
        $(".err-p").html("");
        $(".errbank-p").html("");
        $(".alert-err-tip").html("");
        $(".rech-txt").removeClass("txt-err");
        $(".bank-txt").removeClass("txt-err");
        $(".txtpwd").removeClass("txt-err");
    };

    /************************************************提现*******************************************************/
    //提交
    $("#withdrawalsSubmit").on("click", function () {
        var $this = $(this);

        var isAvailable = $this.attr("data-available");
        if (isAvailable == "true") {
            $this.attr("data-available", false);

            if (withdrawalsMoneyBlur() && tradingPasswordBlur()) {
                availableMoneyValue = //可用提现金额
                    parseFloat($.trim($("#availableMoneyValue").val()));
                withdrawalsMoney = //提现金额
                    parseFloat($.trim($("#withdrawalsMoney").val()));

                if (availableMoneyValue < withdrawalsMoney) {
                    $("#withdrawalsMoneyErr").html("可用余额不足，请您重新输入");
                    $withdrawalsMoney.addClass("txt-err");
                    $this.attr("data-available", true);

                    return false;
                }

                showContentLoading();
                $.post(root + "/service/account/createHostingWithDraw", {
                    "amount": withdrawalsMoney,
                    "payPassword": encryption($.trim($tradingPassword.val())),
                    "notifyUrl": getNotifyUrl(),
                    "registType": "1"
                }, function (data) {
                    closeContentLoading();

                    if (data.retCode) {
                        showOnlineRechargeModel();

                        var $myForm = $("#myForm");

                        $myForm.attr("action", data.url);
                        $myForm.attr("method", data.method);

                        var buffer = [];

                        for (var name in data.body) {
                            var value = data.body[name];

                            buffer.push("<input type='hidden' name='" + name + "' value='" + value + "'/>");
                        }

                        $myForm.html(buffer.join(""));

                        $myForm.submit();

                        $this.attr("data-available", true);
                        /*alert(data.retMsg, function() {
                            showContentLoading();
                            location.href = root+"/service/asset";
                        });*/
                    } else {
                        if (data.retType == 'pwd') {
                            $("#tradingPasswordErr").html(data.retMsg);
                        } else
                        if (data.retType == 'amount') {
                            $("#withdrawalsMoneyErr").html(data.retMsg);
                        } else
                        if (data.retType == 'unBindingCard') {
                            alert(data.retMsg, function () {
                                location.href = root + "/service/bankCard/toBankCard";
                            });
                        } else {
                            $("#tradingPasswordErr").html("*" + data.retMsg);
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

    //**********************************************设置交易密码*************************************************
    //设置交易密码click显示
    $("#setPayPassword").on("click", function () {
        $("#setPasswordModel").show();
        $(".projectWindowBg").show();
    });

    //设置交易密码
    $("#startSetPassword").on("click", function () {
        var $this = $(this);
        if (newTransPwdBlur() && newTransPwdSubBlur()) {
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);
                var newpass = $.trim($("#newTransPwd").val());
                var newpassSub = $.trim($("#newTransPwdSub").val());

                $.post(root + "/service/account/updateTransPass", {
                    "oldpassworld": "",
                    "newPassword": encryption(newpass),
                    "newPasswordSub": encryption(newpassSub)
                }, function (data) {
                    if (data.retCode) {
                        window.location.reload();
                    } else {
                        resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#newTransPwdSub"));

                        $this.attr("data-available", true);
                        return false;
                    }
                });
            }
        }
    });

    var getNotifyUrl = function () {
        var protocol = location.protocol;
        var host = location.host;
        var paths = location.pathname.split("/");

        paths.length = paths.length - 2;
        paths.push("fuiou", "withdrawnotify.do");

        return protocol + "//" + host + paths.join("/");
    };

    //显示网银充值遮罩
    function showOnlineRechargeModel() {
        $(".projectWindowBg").show();
        $("#onlineRechargeModel").show();
    };

    $("#onlineRechargeSuccess").on("click", function () {
        window.location.href = root + "/service/asset";
    });

    $("#onlineRechargeError").on("click", function () {
        hideProdectWindow();

        alert("提现未成功，请重新操作！", function () {
            window.location.reload();
        });
    });
});