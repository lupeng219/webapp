/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */
$(function () {
    //初始化开户省份
    var provinceList = "",
        cityList = "";

    init();

    function init() {
        var provinceList = get_province_array();
        var htmlStr = "";

        for (var i = 0; i < provinceList.length; i++) {
            htmlStr += '<li>' + provinceList[i] + '</li>';
        }

        $("#provinceList").html(htmlStr);
    };

    //绑卡下拉效果
    $("#personBank").on("click", function () {
        $("#bankList").slideToggle(200);
    });
    $("#bankList li").on("click", function () {
        var htmlTemp = $.trim($(this).html());
        var dataTemp = $.trim($(this).data("code"));

        $("#personBank").val(htmlTemp);
        $("#personBank").data("code", dataTemp);
        $("#bankList").slideUp(100);
    });

    $("#loc_province").on("click", function () {
        $("#provinceList").slideToggle(200);
    });

    $("#provinceList").on("click", "li", function () {
        var htmlTemp = $.trim($(this).html());

        $("#loc_province").val(htmlTemp);
        $("#loc_city").val("");
        $("#provinceList").slideUp(100);

        if (htmlTemp) {
            cityList = get_city_array(htmlTemp);
            var htmlStr = "";

            for (var i = 0; i < cityList.length; i++) {
                htmlStr += '<li>' + cityList[i] + '</li>';
            }

            $("#cityList").html(htmlStr);
        } else {
            $("#cityList").html("");
        }
    });

    $("#loc_city").on("click", function () {
        $("#cityList").slideToggle(200);
    });

    $("#cityList").on("click", "li", function () {
        var htmlTemp = $.trim($(this).html());

        $("#loc_city").val(htmlTemp);
        $("#cityList").slideUp(100);
    });

    //隐藏ul
    $(document).on("click", function (event) {
        var obj = event.srcElement ? event.srcElement : event.target;

        //银行列表隐藏
        if (obj.parentNode.id != "bankList" && obj.id != "personBank") {
            $("#bankList").slideUp(200);
        }

        //省份列表隐藏
        if (obj.parentNode.id != "provinceList" && obj.id != "loc_province") {
            $("#provinceList").slideUp(200);
        }

        //城市列表隐藏
        if (obj.parentNode.id != "cityList" && obj.id != "loc_city") {
            $("#cityList").slideUp(200);
        }
    });
    /*********************************************************************************************/
    var result = {};

    /**  网银、快捷 充值切换 **/
    var oTab = $("#recharge-main");
    var aH3 = oTab.find(".mkli");
    var aDiv = oTab.find(".quick-recharge");

    for (var i = 0; i < aH3.length; i++) {
        aH3[i].index = i;
        aH3[i].onclick = function () {
            for (var i = 0; i < aH3.length; i++) {
                aH3[i].className = "mkli";
                aDiv[i].style.display = "none";
            }

            this.className = "mkli mknav-cut";
            aDiv[this.index].style.display = "block";

            clearContent();
            clearStyle();
        };
    }

    //查看更多
    $("#bank-more").on("click", function () {
        $("#bank-more").hide();
        $("#banks-list .bank-li").show();
    });

    $("#onlinebank-more").on("click", function () {
        $("#onlinebank-more").hide();
        $("#onlines-list .bank-li").show();
    });

    //绑定input事件，监听输入
    $("#quickRechargeMoney").on("input", function () {
        domInputFloatEvent($(this));
    });

    $("#onlineRechargeMoney").on("input", function () {
        domInputFloatEvent($(this));
    });

    $("#reserveMobileCode").on("input", function () {
        domInputIntEvent($(this));
    });

    //******************绑定blur事件*********************
    //快捷充值
    $("#bankCode").on("blur", bankCodeBlur);
    $("#reserveMobileCode").on("blur", reserveMobileCodeBlur);
    $("#bindCardVer").on("blur", bindCardVerBlur);
    $("#newTransPwd").on("blur", newTransPwdBlur);
    $("#newTransPwdSub").on("blur", newTransPwdSubBlur);
    $("#validateCode").on("blur", validateCodeBlur);

    //网银充值
    $("#onlineRechargeMoney").on("blur", onlineRechargeMoneyBlur);

    //实名认证
    $("#realName").on("blur", realNameBlur);
    $("#idCard").on("blur", idCardBlur);

    //事件处理函数--true表示快捷充值，false表示网银充值
    function isSelectBank(isQuickPay) {
        if (isQuickPay) {
            var bankName = $.trim($("#personBank").val());
            if (bankName == "") {
                resultVer({
                    "success": false,
                    "msg": "请先选择银行"
                }, $("#personBank"));

                return false;
            } else {
                resultVer({
                    "success": true,
                    "msg": ""
                }, $("#personBank"));

                return true;
            }
        } else {
            var temp = $("#onlines-list .bank-li.active").length;
            if (temp == 0) {
                resultVer({
                    "success": false,
                    "msg": "请先选择银行"
                }, $("#onlineRechargeMoney"));

                return false;
            } else {
                resultVer({
                    "success": true,
                    "msg": ""
                }, $("#onlineRechargeMoney"));

                return true;
            }
        }
    };

    function quickTransPwdBlur() {
        if (isSetPcaPayPassword == '0') {
            resultVer({
                "success": false,
                "msg": "请设置交易密码"
            }, $("#transPwd"));

            return false;
        }

        result = tradingPasswordFormat($("#transPwd"));

        var temp = resultVer(result, $("#transPwd"));
        return temp;
    };

    function locProvinceChange() {
        result = selectProvinceFormat($("#loc_province"));
        var temp = resultVer(result, $("#loc_province"));

        return temp;
    };

    function locCityChange() {
        result = selectCityFormat($("#loc_province"), $("#loc_city"));
        var temp = resultVer(result, $("#loc_city"));

        return temp;
    };

    function bankCodeBlur() {
        result = bankCodeFormat($("#bankCode"));
        var temp = resultVer(result, $("#bankCode"));

        return temp;
    };

    function reserveMobileCodeBlur() {
        result = mobileFormat($("#reserveMobileCode"));
        var temp = resultVer(result, $("#reserveMobileCode"));

        return temp;
    };

    function bindCardVerBlur() {
        result = imagesVerFormat($("#bindCardVer"));
        var temp = resultVer(result, $("#bindCardVer"));

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

    function validateCodeBlur() {
        result = imagesVerFormat($("#validateCode"));
        var temp = resultVer(result, $("#validateCode"));

        return temp;
    };

    function onlineRechargeMoneyBlur() {
        result = rechargeMoneyFormat($("#onlineRechargeMoney"));
        var temp = resultVer(result, $("#onlineRechargeMoney"));

        return temp;
    };

    function realNameBlur() {
        result = realNameFormat($("#realName"));
        /*var temp = resultVer(result, $("#realName"));*/
        var temp = recordRst(result, "#realName");
        return temp;


    };

    function idCardBlur() {
        result = idCardFormat($("#idCard"));
        /* 
        var temp = resultVer(result, $("#idCard"));*/
        var temp = recordRst(result, "#idCard");
        return temp;


    };
    //实名、卡验证返回
    function recordRst(result, element) {
        if (result.success) {
            clearStyle();
            return true;
        } else {
            $(element).parent().find(".errbank-p").html(result.msg);
            return false;
        }
    }
    //验证返回
    function resultVer(data, element) {
        if (data.success) {
            clearStyle();
            return true;
        } else {
            clearStyle();
            element.closest("li").find(".errbank-p").html(data.msg);
            element.closest("li").find(".alert-err-tip").html(data.msg);
            element.addClass("txt-err");

            return false;
        }
    };

    //清楚错误提示和内容
    function clearStyle() {
        $(".errbank-p").html("");
        $(".alert-err-tip").html("");
        $(".bank-txt").removeClass("txt-err");
        $(".txtpwd").removeClass("txt-err");
    };

    function clearContent() {
        $(".bank-txt").val("");
    };

    //银行卡选择
    $(".banks-list .bank-li").on("click", function () {
        $(this).addClass("active");
        $(this).siblings().removeClass("active");

        if ($(this).closest("#banks-list").length) {
            quickRechargeBankLimit($(this));
        } else {
            onlineRechargeBankLimit($(this));
        }
    });

    //快捷充值替换支付额度
    function quickRechargeBankLimit($this) {
        $(".rech-quota-table").show();

        //替换支付额度
        //单笔限额
        var singleLimit = parseInt($this.attr("data-singleLimit")) / 10000;
        //首次支付限额
        var firstBindLimit =
            parseInt($this.attr("data-firstBindLimit")) / 10000;
        //单日限额
        var singleDayLimit = parseInt($this.attr("data-singleDayLimit")) / 10000;
        //最低限额
        var singleMinimum = $this.attr("data-singleMinimum");

        $("#singleLimit").html(singleLimit + "万（元）");
        $("#firstBindLimit").html(firstBindLimit + "万（元）");
        $("#singleDayLimit").html(singleDayLimit + "万（元）");
        $("#singleMinimum").html(singleMinimum + "（元）");
    }

    //网银充值替换支付额度
    function onlineRechargeBankLimit($this) {}

    //*********************************************弹窗****************************************************
    //显示设置交易密码弹窗
    function showSetPasswordModel() {
        $(".projectWindowBg").show();
        $("#setPasswordModel").show();
    };

    //关闭设置交易密码弹窗并隐藏设置交易密码按钮
    function closePasswordModel() {
        isSetPcaPayPassword = 1;
        $("#setPasswordModel").hide();
        $(".projectWindowBg").hide();
        $("#setPayPassword").hide();

    };

    //显示网银充值遮罩
    function showOnlineRechargeModel() {
        $(".projectWindowBg").show();
        $("#onlineRechargeModel").show();
    };

    //**********************************绑卡*******************************************
    $("#startbindCard-not").on("click", function () {
        isSelectBank(true) && locProvinceChange() &&
            locCityChange() && bankCodeBlur() &&
            reserveMobileCodeBlur() && bindCardVerBlur();
    });

    $("#startbindCard").on("click", function () {
        var $this = $(this);
        if (isSelectBank(true) && locProvinceChange() &&
            locCityChange() && bankCodeBlur() &&
            reserveMobileCodeBlur()) {
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);
                $("#maskCover").show();
                $("#loadingGif").show();
                $.post(root + "/service/bankCard/bankCardBindingAdvance", {
                    "bankCardNo": $.trim($("#bankCode").val()),
                    "bankName": $.trim($("#personBank").val()),
                    "bankCode": $.trim($("#personBank").data("code")),
                    "province": $.trim($("#loc_province").val()),
                    "city": $.trim($("#loc_city").val()),
                    "cityid": get_city_id($.trim($("#loc_city").val())),
                    "phoneNo": $.trim($("#reserveMobileCode").val()),
                    "channel": "1"
                }, function (data) {
                    $("#maskCover").hide();
                    $("#loadingGif").hide();
                    if (data.retCode) {
                        location.reload();
                    } else {
                        /*resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#bindCardVer"));*/
                        $("#bk-err-remain").html(data.retMsg);

                        $this.attr("data-available", true);
                        return false;
                    }
                });
            }
        }
    });

    //**********************************快捷充值*******************************************
    //设置交易密码click显示
    $("#setPayPassword").on("click", function () {
        showSetPasswordModel();
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
                        closePasswordModel();
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

    //****************************************************网银充值****************************************
    $("#startOnlineRecharge").on("click", function () {
        var $this = $(this);

        if (onlineRechargeMoneyBlur()) {
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);

                var amount = $.trim($("#onlineRechargeMoney").val());
                if (amount < 100) {
                    $("#onlineRechargeMoney").val('');
                    $this.attr("data-available", true);
                    alert('最小充值金额为100元，请您重新输入');
                    return false;
                }
                var bankCode =
                    $("#onlines-list").find(".active").attr("data-bank");

                showContentLoading();

                $.ajax({
                    url: root + '/service/account/onlineVerification',
                    type: 'post',
                    async: false, //使用同步的方式,true为异步方式
                    data: {
                        'bankCode': "1001",
                        'amount': amount
                    }, //这里使用json对象
                    dataType: 'json',
                    success: function (data) {
                        closeContentLoading();

                        if (data.retCode) {
                            showOnlineRechargeModel();

                            var $form = $("#myForm");
                            var rgType;


                            /*$("#myRechargeType").val($("#rechargeType").val());*/

                            if ($("#rg-type").html() == "网银充值")
                            {
                                rgType = "recharge";

                                $("#myNotifyUrl").val(getNotifyUrl("paynotify.do"));
                            } else
                            if ($("#rg-type").html() == "快捷充值")
                            {
                                rgType = "deposit";

                                $("#myNotifyUrl").val(getNotifyUrl("quickpaynotify.do"));
                            }
                            
                            $("#myRechargeType").val(rgType);
                            $("#myBankCode").val(bankCode);
                            $("#myAmount").val(amount);

                            $form.attr("action", root + "/service/account/onlineBankRecharge");
                            $form.submit();

                            $this.attr("data-available", true);
                        } else {
                            alert('充值失败');

                            $this.attr("data-available", true);
                            return false;
                        }
                        console.log($("#myRechargeType").val());
                    },
                    fail: function () {
                        closeContentLoading();

                        alert('充值失败');
                        $this.attr("data-available", true);
                        return false;
                    }
                });
            }
        }
    });

    $("#onlineRechargeSuccess").on("click", function () {
        window.location.href = root + "/service/asset";
    });

    $("#onlineRechargeError").on("click", function () {
        hideProdectWindow();

        alert("充值未成功，请重新充值！", function () {
            window.location.reload();
        });
    });

    //****************************************************实名认证****************************************************
    $("#startAuthentication").on("click", function () {
        var $this = $(this);
        if (realNameBlur() && idCardBlur()) {
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);

                $.post(root + "/service/certification/certificationOperation", {
                    "realName": $.trim($("#realName").val()),
                    "idCard": $.trim($("#idCard").val()),
                    "channel": "1"
                }, function (data) {
                    if (data.retCode) {
                        window.location.reload();
                    } else {
                        $("#sat-err-remain").html(data.retMsg);
                        $this.attr("data-available", true);
                        return false;
                    }
                });
            }
        } else {
            return false;
        }
    });

    $("#changeCard").on("click", function () {
        var $form = $("#myForm");

        $("#myNotifyUrl").val(getNotifyUrl("cardchgn.do"));

        $form.attr("action", root + "/service/account/changeCard");
        $form.submit();
    });

    $("#changePhone").on("click", function () {
        var $form = $("#myForm");

        $("#myNotifyUrl").val(getNotifyUrl("phonechgn.do"));

        $form.attr("action", root + "/service/account/changePhone");
        $form.submit();
    });

    $("#changePassword").on("click", function () {
        var $form = $("#myForm");

        $("#myNotifyUrl").val(getNotifyUrl("passwdchgn.do"));

        $form.attr("action", root + "/service/account/changePassword");
        $form.submit();
    });
});

var getNotifyUrl = function (method) {
    var protocol = location.protocol;
    var host = location.host;
    var paths = location.pathname.split("/");

    if (method == null)
        method = "paynotify.do";

    paths.length = paths.length - 2;
    paths.push("fuiou", method);

    return protocol + "//" + host + paths.join("/");
};