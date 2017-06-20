/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */

$(function () {
    /**  ģ���л� **/
    var oTab = $("#invest-desc-con");
    var aH3 = oTab.find(".mkli");
    var aDiv = oTab.find(".divtab");
    for (var i = 0; i < aH3.length; i++) {
        aH3[i].index = i;
        aH3[i].onclick = function () {
            for (var i = 0; i < aH3.length; i++) {
                $(aH3[i]).removeClass("mknav-cut");
                $(aDiv[i]).hide();
            }
            $(this).addClass("mknav-cut");
            $(aDiv[this.index]).show();
            if ($(this).hasClass("productImgTitle")) {
                var lenght = $(".pictureImg").length;
                if (lenght != 0) {
                    setTimeout(function () {
                        for (var k = 0; k < lenght; k++) {
                            $($(".pictureImg")[k]).attr("src", $($(".pictureImg")[k]).data("url"));
                        }
                    }, 0);
                }
            }

        };
    }
    //**********************************投标控制************************************
    $("#bulkLoanAmount").on("input", function () {
        domInputIntEvent($(this));
    });
    $("#bulkLoanAmount").on("blur", bulkLoanAmountBlur);

    function bulkLoanAmountBlur() {
        var data = $.trim($("#bulkLoanAmount").val());
        var dataInt = parseInt($.trim($("#bulkLoanAmount").val()));
        var increase = parseInt($.trim($("#increase").attr("placeholder")).replace(",", ""));;
        if (!data) {
            $(".err-tip").html("投标金额为空");
            return false;
        } else if (!data.match("^[1-9][0-9]*$")) {
            $(".err-tip").html("投标金额输入错误");
            return false;
        } else if (!(dataInt % increase == 0)) {
            $(".err-tip").html("投资金额必须是最小投资金额" + increase + "的整数倍");
            return false;
        } else {
            $(".err-tip").html("");
            return true;
        }
    };
    $("#tender").on("click", function () {
        var $this = $(this);
        var dataInt = parseInt($.trim($("#bulkLoanAmount").val()));
        var productNo = $("#productNo").attr("value");
        var isLogin = $this.attr("data-login");
        if (isLogin == "true") {
            //添加设置交易密码判断----未设置交易密码
            if (isSetPcaPayPassword == '0') {
                showSetPasswordModel();
                return false;
            }
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);

                if (bulkLoanAmountBlur()) {
                    $.post(root + "/service/tender/checkTender", {
                        'productNo': productNo,
                        'loanAmount': dataInt,
                        'channel': "pc",
                        '_TOKEN_SESSION': $('#sessionId').val()
                    }, function (data) {
                        if (data.retCode) {
                            $(".projectWindowBg").show();
                            $("#tenderBox").css("display", "block");
                            $('#sessionId').attr("value", data.sessionId);
                            //在这里弹框或跳到另一页面确定投标并且获取前台传来的值
                            $('#productTitle').html(data.loanTitle);
                            $('#comprehensiveRate').html(data.comprehensiveRate + "%");
                            if (data.loanRepayment == 0) {
                                $('#loanRepayment').html("等额本息");
                                $('#loanTerm').html(data.loanTerm + "个月");
                            }
                            if (data.loanRepayment == 1) {
                                $('#loanRepayment').html("先息后本");
                                $('#loanTerm').html(data.loanTerm + "个月");
                            }
                            if (data.loanRepayment == 2) {
                                $('#loanRepayment').html("按天计息");
                                $('#loanTerm').html(data.loanTerm + "天");
                            }
                            if (data.loanRepayment == 3) {
                                $('#loanRepayment').html("等额本金");
                                $('#loanTerm').html(data.loanTerm + "个月");
                            }
                            if (data.loanRepayment == 4) {
                                $('#loanRepayment').html("到期本息");
                                $('#loanTerm').html(data.loanTerm + "个月");
                            }
                            if (data.loanRepayment == 5) {
                            	$('#loanRepayment').html("到期本息");
                                $('#loanTerm').html(data.loanTerm + "天");
                            }

                            $('.loanAmount').html(data.loanAmount);
                            $(document).scrollTop(0);
                        } else {
                            $this.attr("data-available", true);
                            $(".err-tip").html(data.retMsg);
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
        } else {
            $(".err-tip").html("请先登录");
            return false;
        }
    });
    //关闭弹窗
    $("#closeBox,#cancelBtn").on("click", function () {
        close_Window();
    });

    function close_Window() {
        $("#tenderBox").css("display", "none");
        $("#tender").attr("data-available", true);
        $(".alert-txt").val("");
        $(".projectWindowBg").hide();
    };
    $(".alert-txt").on("blur", function () {
        var password = $.trim($(".alert-txt").val());
        if (password != null || password != "") {
            $(".alert-err").html("");
        }
    });
    //确定投资按钮
    $("#sureTenderBtn").on("click", function () {
        var dataInt = parseInt($.trim($("#bulkLoanAmount").val()));
        var password = $.trim($(".alert-txt").val());
        var inviteCode = $.trim($(".alert-invest").val());
        var productNo = $("#productNo").attr("value");
        if (password == null || password == "") {
            $(".alert-err").html("*请输入交易密码");
            return;
        }
        showContentLoading();
        $.post(root + "/service/tender/sureTender", {
            'password': encryption(password),
            'productNo': productNo,
            'loanAmount': dataInt,
            'inviteCode': inviteCode,
            'channel': "10",
            '_TOKEN_SESSION': $('#sessionId').val()
        }, function (data) {
            close_Window();
            closeContentLoading();
            if (data.retCode) {
                alert("投资成功", function () {
                    location.reload();
                    $("#bulkLoanAmount").val("");
                });
            } else {
                alert(data.retMsg, function () {
                    location.reload();
                });
            }
        });
    });

    //**********************************************设置交易密码*************************************************
    $("#newTransPwd").on("blur", newTransPwdBlur);
    $("#newTransPwdSub").on("blur", newTransPwdSubBlur);

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
    //显示设置交易密码弹窗
    function showSetPasswordModel() {
        $(".projectWindowBg").show();
        $("#setPasswordModel").show();
    };
    //设置交易密码
    $("#startSetPassword").on("click", function () {
        var $this = $(this);
        if (newTransPwdBlur() && newTransPwdSubBlur()) {
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);
                var newpass = $.trim($("#newTransPwd").val()),
                    newpassSub = $.trim($("#newTransPwdSub").val());
                $.post(root + "/service/account/updateTransPass", {
                    "oldpassworld": "",
                    "newPassword": encryption(newpass),
                    "newPasswordSub": encryption(newpassSub)
                }, function (data) {
                    if (data.retCode) {
                        window.location.reload();
                    } else {
                        resultVer({
                            "retCode": data.retCode,
                            "msg": data.retMsg
                        }, $("#newTransPwdSub"));
                        $this.attr("data-available", true);
                        return false;
                    }
                });
            }
        }
    });

    function resultVer(data, element) {
        if (data.success) {
            clearStyle();
            return true;
        } else {
            clearStyle();
            element.closest("li").find(".alert-err-tip").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };

    function clearStyle() {
        $(".alert-err-tip").html("");
        $(".txtpwd").removeClass("txt-err");
    };

});