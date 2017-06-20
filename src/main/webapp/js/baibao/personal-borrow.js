/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */

$(function () {
    /**  tab切换 **/
    var oTab = $("#per-txtcon");
    var aH3 = oTab.find(".mkli");
    var aDiv = oTab.find(".divtab");

    for (var i = 0; i < aH3.length; i++) {
        aH3[i].index = i;
        aH3[i].onclick = function () {
            for (var i = 0; i < aH3.length; i++) {
                aH3[i].className = "mkli";
                aDiv[i].style.display = "none";
            }

            this.className = "mkli mknav-cut";
            aDiv[this.index].style.display = "block";
        };
    }

    //绑定事件
    var result = {};

    $("#transPassword").on("blur", transPasswordBlur);
    $("#newTransPwd").on("blur", newTransPwdBlur);
    $("#newTransPwdSub").on("blur", newTransPwdSubBlur);

    function transPasswordBlur() {
        result = tradingPasswordFormat($("#transPassword"));

        var temp = resultVer(result, $("#transPassword"));
        return temp;
    }

    function newTransPwdBlur() {
        result = tradingPasswordFormat($("#newTransPwd"));

        var temp = resultVer(result, $("#newTransPwd"));
        return temp;
    }

    function newTransPwdSubBlur() {
        result = passwordSubFormat($("#newTransPwd"), $("#newTransPwdSub"));

        var temp = resultVer(result, $("#newTransPwdSub"));
        return temp;
    };

    function resultVer(data, element) {
        clearStyle();

        if (data.success)
            return true;

        element.closest("li").find(".err-p").html(data.msg);
        element.closest("li").find(".alert-err-tip").html(data.msg);
        element.addClass("txt-err");

        return false;
    }

    function clearStyle() {
        $(".err-p").html("");
        $(".alert-err-tip").html("");
        $(".borrow-txt").removeClass("txt-err");
        $(".txtpwd").removeClass("txt-err");
    };

    //显示设置交易密码弹窗
    function showSetPasswordModel() {
        $(".projectWindowBg").show();
        $("#setPasswordModel").show();
    }

    /** 还款按钮--显示还款弹窗  **/
    /*
    $("#repaymentInPage").on("click", ".repaymentBtn", function () {
        var $this = $(this);
        currentDataProductNo = $.trim($this.attr("data-productNo"));
        var isSetPcaPayPassword = $.trim($("#isSetPcaPayPassword").val());

        if (isSetPcaPayPassword != '1') {
            showSetPasswordModel();
            return false;
        }

        if ($this.attr("data-available") == "true") {
            $this.attr("data-available", false);

            $.post(root + "/service/personalBorrow/productRepayment", {
                "productNo": $.trim($this.attr("data-productNo"))
            }, function (data) {

                if (data.retCode) {
                    repaymentWindowData(
                        data.productRepaymentMap, data.sessionId);

                    $(".projectWindowBg").show();
                    $("#repaymentModel").show();
                    var repaymentTotal = 0;

                    $(".borrowCheck:checked").each(function () {
                        var amount = $(this).data("principal");
                        repaymentTotal += amount;
                    });

                    $("#repaymentTotal").text(Number(repaymentTotal).toFixed(2));
                    $("#waitTotalPrice").html(Number(repaymentTotal).toFixed(2));
                } else {
                    alert(data.retMsg, function () {
                        window.location.reload();
                    });
                }
            });
        }
    });
	*/
    function repaymentWindowData(data, sessionId) {
        if (data.productRepaymentList.length > 0) {
            $("#repaymentModel .alert-project li.project-title").siblings().remove();

            var $list = $("#repaymentModel .alert-project");

            var statusStr = {
                0: "未还款",
                1: "正常还款",
                2: "逾期",
                3: "提前还款",
                4: "处理中",
                5: "处理中"
            };
            data.productRepaymentList.every(function (item) {
                var $record = $("#template #repayment-record").clone();

                var $checkBox = $record.find("#checkbox");

                $checkBox.val(item.prb_repaybillNo);
                $checkBox.data("principal", item.prb_repaymentPrincipal);

                if (item.prb_repaymentStatus == 1) {
                    $checkBox.attr("disabled", true);
                } else {
                    $checkBox.attr("checked", true);
                    $checkBox.attr("disabled", true);
                }
                console.log(item);
                $record.find("#datetime").text(item.prb_repaymentTime);
                $record.find("#principal").text(item.prb_repaymentPrincipal.toFixed(2));
                $record.find("#capital").text(item.prb_repaymentCapital.toFixed(2));
                $record.find("#interest").text(item.prb_repaymentInterest.toFixed(2));
                $record.find("#overdue").text(item.prb_overDueAmount.toFixed(2));
                $record.find("#status").text(
                    statusStr[item.prb_repaymentStatus]);

                $list.append($record);

                return true;
            });

            for (var i = 0; i < data.productRepaymentList.length; i++) {

                if (data.productRepaymentList[i].prb_repaymentStatus == 0) {


                } else if (data.productRepaymentList[i].prb_repaymentStatus == 1) {
                    $("#checkbox:eq(" + i + ")").attr("disabled", "true");
                }
            }
            /*var tempHtml = "";
            
            for(var i = 0; i < data.productRepaymentList.length; i++)
            {
                tempHtml += '<li>';

                if (data.productRepaymentList[i].currentRp)
                {
                    tempHtml +=
                        '<input type="checkbox" checked class="fl borrowCheck" value="' +
                            data.productRepaymentList[i].prb_repaybillNo + '" />';
                } else
                {
                    tempHtml +=
                        '<input type="checkbox" class="fl borrowCheck" value="' +
                            data.productRepaymentList[i].prb_repaybillNo + '" disabled />';
                }
                
                tempHtml += '<input type="hidden" id="sessionId" value="' + sessionId + '"/>';
                tempHtml += '<span>' + data.productRepaymentList[i].prb_repaymentTime + '</span>';
                tempHtml += '<span>' + data.productRepaymentList[i].prb_repaymentPrincipal + '</span>';
                tempHtml += '<span>' + data.productRepaymentList[i].prb_repaymentCapital + '</span>';
                tempHtml += '<span>' + data.productRepaymentList[i].prb_repaymentInterest + '</span>';
                tempHtml += '<span>' + data.productRepaymentList[i].prb_overDueAmount + '</span>';
        
                switch(data.productRepaymentList[i].prb_repaymentStatus)
                {
                    case 0:
                        tempHtml += '<span>未还款</span>';
                        break;
                    case 1:
                        tempHtml += '<span>正常还款</span>';
                        break;
                    case 2:
                        tempHtml += '<span>逾期还款</span>';
                        break;
                    case 3:
                        tempHtml += '<span>提前还款</span>';
                        break;
                    case 4:
                        tempHtml += '<span>处理中</span>';
                        break;
                    default:
                        tempHtml += '<span></span>';
                }

                tempHtml += '</li>';
            }*/
        }

        if (data.completeTotalPrice) {
            $("#completeTotalPrice").html(data.completeTotalPrice);
        } else {
            $("#completeTotalPrice").html(0);
        }

        /*if (data.waitTotalPrice) {
            $("#waitTotalPrice").html(data.waitTotalPrice);
        } else {
            $("#waitTotalPrice").html(0);
        }*/
        surplusNum

        if (data.surplusNum) {
            $("#surplusNum").html(data.surplusNum);
        } else {
            $("#surplusNum").html(0);
        }

        if (data.repaymentTotal) {
            $("#repaymentTotal").html(data.repaymentTotal);
        } else {
            $("#repaymentTotal").html(0);
        }

        if (data.balance) {
            $("#balance").html(data.balance);
        } else {
            $("#balance").html(0);
        }
    };

    //关闭弹窗
    $("#modelClose").on("click", function () {
        modelCloseClick();
    });

    function modelCloseClick() {
        $(".projectWindowBg").hide();
        $("#repaymentModel").hide();
        $("#repaymentModel .alert-project li.project-title").siblings().remove();
        $(".repaymentBtn").attr("data-available", true);

        clearStyle();
    };

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

    //"/service/personalBorrow/repaymentPay"
    //"/service/personalBorrow/validateRepayment"
    //$(".borrowCheck:checked")[i].value

    //确认还款
    $("#sureRepayment").on("click", function () {
        var $this = $(this);
        var repaybillNos = [];
        var transPassword = $("#transPassword").val();

        $(".borrowCheck:checked").each(function () {
            var repaybillNo = $(this).val();

            repaybillNos.push(repaybillNo);
        });

        if (repaybillNos.length == 0) {
            alert("请选择需要还款的帐单。");
            return;
        }

        if (transPassword.trim() == null || transPassword.trim() == '') {
            alert("请输入交易密码");
            return;
        }

        $this.attr("disabled", true);

        $.post(root + "/service/personalBorrow/repay", {
            transPassword: encryption(transPassword),
            repaybillNos: repaybillNos,
            currentProductNo: currentDataProductNo
        }).done(function (data) {
            if (data.retCode) {
                alert("还款成功。");

                window.location.reload();
                return;
            }

            alert(data.retMsg);
            $this.removeAttr("disabled");
        });
    });
});