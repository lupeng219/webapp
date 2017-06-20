$(function () {
    var cjjeNumber = "", //出借金额
        nhllNumber = "", //年化利率
        jkqxNumber = "", //借款期限
        repaymentMethod = "", //还款方式
        $cjje = $("input[name='cjje']"),
        $nhll = $("input[name='nhll']"),
        $jkqx = $("input[name='jkqx1']"),
        $jkqx2 = $("input[name='jkqx2']"),
        $hkfs = $(".cal_sub p"),
        result = {
            success: true,
            msg: ""
        };
    //绑定事件
    $cjje.on("blur", cjjeBlur);
    $nhll.on("blur", nhllBlur);
    $jkqx.on("blur", jkqxBlur);
    $jkqx2.on("blur", jkqx2Blur);
    $hkfs.on("click", hkfsChange);
    $nhll.on('keyup', function (e) {
        var $amountInput = $(this);

        event = window.event || event;
        if (event.keyCode == 37 | event.keyCode == 39) {
            return;
        }

        $amountInput.val($amountInput.val().replace(/[^\d.]/g, "").

            replace(/^\./g, "").replace(/\.{2,}/g, ".").

            replace(".", "$#$").replace(/\./g, "").replace("$#$", ".").replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'));
    })
    $jkqx.on('keyup', function () {
            var tmptxt = $(this).val();
            $(this).val(tmptxt.replace(/\D|^0/g, ''));
        })
        //处理事件
    function cjjeBlur() {
        cjjeNumber = $.trim($cjje.val());
        if (!cjjeNumber) {
            result.success = false;
            result.msg = "出借金额不能为空";
        } else if (!cjjeNumber.match("^[1-9][0-9]*$")) {
            result.success = false;
            result.msg = "出借金额须为整数,且不可为0";
        } else if (parseInt(cjjeNumber) % 50 != 0) {
            result.success = false;
            result.msg = "出借金额范围须为50的倍数";
        } else {
            result.success = true;
        }
        var temp = resultVer(result, $cjje);
        return temp;
    };

    function nhllBlur() {
        nhllNumber = $.trim($nhll.val());
        if (!nhllNumber) {
            result.success = false;
            result.msg = "年化利率不能为空";
        }
        /* else if (!nhllNumber.match("^[0-9]*$")) {
                    result.success = false;
                    result.msg = "年化利率须为整数";
                }*/
        else if (parseInt(nhllNumber) > 24 || parseInt(nhllNumber) < 5) {
            result.success = false;
            result.msg = "年化利率范围须为5%-24%之间";
        } else {
            result.success = true;
        }
        var temp = resultVer(result, $nhll);
        return temp;
    };

    function jkqxBlur() {
        jkqxNumber = $.trim($jkqx.val());
        if (!jkqxNumber) {
            result.success = false;
            result.msg = "借款期限不能为空";
        } else if (!jkqxNumber.match("^[0-9]*$")) {
            result.success = false;
            result.msg = "借款期限须为整数";
        } else if (parseInt(jkqxNumber) > 36 || parseInt(jkqxNumber) < 1) {
            result.success = false;
            result.msg = "借款期限范围须为1-36个月之间";
        } else {
            result.success = true;
        }
        var temp = resultVer(result, $jkqx);
        return temp;
    };

    function jkqx2Blur() {
        jkqxNumber = $.trim($jkqx2.val());
        if (!jkqxNumber) {
            result.success = false;
            result.msg = "借款期限不能为空";
        } else if (!jkqxNumber.match("^[0-9]*$")) {
            result.success = false;
            result.msg = "借款期限须为整数";
        } else {
            result.success = true;
        }
        var temp = resultVer(result, $jkqx2);
        return temp;
    };

    function hkfsChange() {
        repaymentMethod = $.trim($(this).index());
        return repaymentMethod;
        console.log(repaymentMethod)
        if (repaymentMethod == '2') {
            $("#jkqxMode1").hide();
            $("#jkqxMode2").show();
        } else {
            $("#jkqxMode2").hide();
            $("#jkqxMode1").show();
        }
    };
    //处理返回
    function resultVer(data, element) {
        if (data.success) {
            clearStyle();
            return true;
        } else {
            clearStyle();
            element.closest("li").find(".err-tip").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };

    function clearStyle() {
        $(".err-tip").html("");
        $(".caltxt").removeClass("txt-err");
    };
    //控制提示效果
    $("input[class='caltxt']").on("focus", function () {
        $(this).parent().find(".ui-poptip").show();
    });
    $("input[class='caltxt']").on("blur", function () {
        $(this).parent().find(".ui-poptip").hide();
    });
    //提交
    $(".cal-btn").on("click", function () {
        var $this = $(this);
        if (cjjeBlur() && nhllBlur()) {
            repaymentMethod = repaymentMethod;
            if (repaymentMethod == "2") {
                if (!jkqx2Blur()) {
                    return false;
                }
                jkqxNumber = $.trim($jkqx2.val());
            } else {
                if (!jkqxBlur()) {
                    return false;
                }
                jkqxNumber = $.trim($jkqx.val());
            }
            if ($this.attr("data-available") == "true") {
                $this.attr("data-available", false);
                cjjeNumber = $.trim($cjje.val());
                nhllNumber = $.trim($nhll.val());
                /*console.log(cjjeNumber);
                console.log(nhllNumber);
                console.log(jkqxNumber);
                console.log(repaymentMethod);*/
                $.post(root + "/service/productList/getProfit", {
                    "cjje": cjjeNumber,
                    "nhll": nhllNumber,
                    "jkqx": jkqxNumber,
                    "hkfs": repaymentMethod
                }, function (data) {
                    $("#resultdiv").html(data);
                    $this.attr("data-available", true);
                });
            }
        } else {
            return false;
        }

    });
});