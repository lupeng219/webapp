/**
 * Created by chen on 2015/10/28.
 */
$(function () {
    var $realName = $("#realName"),
        $mobile = $("#mobile"),
        $sel_province = $("#sel-province"),
        $sel_city = $("#sel-city"),
        $carModel = $("#carModel"),
        $vehicleRegistration = $("#vehicleRegistration"),
        $cellName = $("#cellName"),
        $grossArea = $("#grossArea"),
        $loanAmount = $("#loanAmount"),
        $loanTerm = $("#loanTerm"),
        $loanPurpose = $("#loanPurpose");
    cityList = [],
        result = {};
    //tab切换
    $(".list-nav li").on("click", function () {
        if ($(this).hasClass("current")) {
            return false;
        } else {
            var data = $(this).attr("data"),
                i = 1;
            $(this).addClass("current");
            $(this).siblings().removeClass("current");
            while (i <= 2) {
                if ((i + "") == data) {
                    $("#borrowTab" + i).show();
                } else {
                    $("#borrowTab" + i).hide();
                }
                i++;
            };
        };
    });
    //下拉效果
    $("#down-province,#sel-province").on("click", function () {
        $("#province-list").slideToggle(200);
    });
    $("#down-city,#sel-city").on("click", function () {
        var sel_province = $("#sel-province").val();
        if (sel_province) {
            $("#city-list").slideToggle(200);
        } else {
            $("#province-list").slideDown(200);
        };
    });
    $("#province-list li").on("click", function () {
        var valueTemp = $.trim($(this).html()),
            mortgageMode = $("input[name='mortgageMode']:checked").val();
        $("#sel-province").val(valueTemp);
        $("#sel-city").val("");
        $("#province-list").slideUp(200);
        if (mortgageMode == "2" && valueTemp == "山西") {
            $("#city-list").html('<li>太原</li>');
        } else {
            cityList = get_city_array(valueTemp);
            var str = "";
            for (var i = 0; i < cityList.length; i++) {
                str += '<li>' + cityList[i] + '</li>';
            }
            $("#city-list").html(str);
        };
    });
    $("#city-list").on("click", "li", function () {
        var valueTemp = $.trim($(this).html());
        $("#sel-city").val(valueTemp);
        $("#city-list").slideUp(200);
    });
    //关闭下拉
    $(document).on("click", function (event) {
        var obj = event.srcElement ? event.srcElement : event.target;
        //关闭省份
        if (obj.parentNode.id != "province-list" && obj.id != "sel-province" && obj.id != "down-province" && obj.id != "sel-city" && obj.id != "down-city") {
            $("#province-list").slideUp(200);
        }
        //关闭城市
        if (obj.parentNode.id != "city-list" && obj.id != "sel-city" && obj.id != "down-city") {
            $("#city-list").slideUp(200);
        }
    });
    //抵押方式切换
    $("input[name='mortgageMode']").on("click", function () {
        var temp = $("input[name='mortgageMode']:checked").val();
        var lenght = $("input[name='mortgageMode']").length;
        for (var i = 1; i <= lenght; i++) {
            if ((i + "") == (temp + "")) {
                $(".mode" + i).show();
            } else {
                $(".mode" + i).hide();
            }
        }
        $("#sel-province").val("");
        $("#sel-city").val("");
    });
    //绑定事件
    $realName.on("blur", realNameBlur);
    $mobile.on("input", function () {
        domInputIntEvent($mobile);
    });
    $mobile.on("blur", mobileBlur);
    $sel_province.on("change", selProvinceChange);
    $sel_city.on("change", selCityChange);
    $carModel.on("blur", carModelBlur);
    $vehicleRegistration.on("blur", vehicleRegistrationBlur);
    $cellName.on("blur", cellNameBlur);
    $grossArea.on("input", function () {
        domInputFloatEvent($grossArea);
    });
    $grossArea.on("blur", grossAreaBlur);
    $loanAmount.on("input", function () {
        domInputFloatEvent($loanAmount);
    });
    $loanAmount.on("blur", loanAmountBlur);
    $loanTerm.on("input", function () {
        domInputIntEvent($loanTerm);
    });
    $loanTerm.on("blur", loanTermBlur);
    $loanPurpose.on("blur", loanPurposeBlur);
    //处理事件
    function realNameBlur() {
        result = realNameFormat($realName);
        var temp = resultVer(result, $realName);
        return temp;
    };

    function mobileBlur() {
        result = mobileFormat($mobile);
        var temp = resultVer(result, $mobile);
        return temp;
    };

    function selProvinceChange() {
        result = selectProvinceFormat($sel_province);
        var temp = resultVer(result, $sel_province);
        return temp;
    };

    function selCityChange() {
        result = selectCityFormat($sel_province, $sel_city);
        var temp = resultVer(result, $sel_city);
        return temp;
    };

    function carModelBlur() {
        result = carModelFormat($carModel);
        var temp = resultVer(result, $carModel);
        return temp;
    };

    function vehicleRegistrationBlur() {
        result = vehicleRegistrationFormat($vehicleRegistration);
        var temp = resultVer(result, $vehicleRegistration);
        return temp;
    };

    function cellNameBlur() {
        result = cellNameFormat($cellName);
        var temp = resultVer(result, $cellName);
        return temp;
    };

    function grossAreaBlur() {
        result = grossAreaFormat($grossArea);
        var temp = resultVer(result, $grossArea);
        return temp;
    };

    function loanAmountBlur() {
        result = loanAmountFormat($loanAmount);
        var temp = resultVer(result, $loanAmount);
        return temp;
    };

    function loanTermBlur() {
        result = loanTermFormat($loanTerm);
        var temp = resultVer(result, $loanTerm);
        return temp;
    };

    function loanPurposeBlur() {
        result = loanPurposeFormat($loanPurpose);
        var temp = resultVer(result, $loanPurpose);
        return temp;
    };
    //处理返回
    function resultVer(data, element) {
        if (data.success) {
            clearStyle();
            return true;
        } else {
            clearStyle();
            element.closest(".item-sq").find(".err-p").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };

    function clearStyle() {
        $(".err-p").html("");
        $(".txt-company").removeClass("txt-err");
        $(".txt-desc").removeClass("txt-err");
    };
    /****************************************************申请*******************************************************/
    $(".borrowmoney-btn").on("click", function () {
        var $this = $(this);
        var mortgageMode = $("input[name='mortgageMode']:checked").val();
        if (mortgageMode == "1") { //车抵押
            /*if(realNameBlur()&&mobileBlur()&&selProvinceChange()&&selCityChange()&&carModelBlur()&&vehicleRegistrationBlur()&&loanAmountBlur()&&loanTermBlur()&&loanPurposeBlur()){*/
            if (realNameBlur() && mobileBlur() && loanAmountBlur() && loanTermBlur()) {
                if ($this.attr("data-available") == "true") {
                    $this.attr("data-available", false);
                    showContentLoading();
                    $.post(root + "/service/borrowMoney/insertLoanApply", {
                        "realName": $.trim($realName.val()),
                        "mobile": $.trim($mobile.val()),
                        "mortgageMode": mortgageMode,
                        "sel_province": $.trim($sel_province.val()),
                        "sel_city": $.trim($sel_city.val()),
                        "carModel": $.trim($carModel.val()),
                        "vehicleRegistration": $.trim($vehicleRegistration.val()),
                        "loanAmount": $.trim($loanAmount.val()),
                        "loanTerm": $.trim($loanTerm.val()),
                        "loanPurpose": $.trim($loanPurpose.val()),
                        "productType": "1"
                    }, function (data) {
                        closeContentLoading();
                        if (data.retCode) {
                            alert("借款申请成功！", function () {
                                window.location.href = root + "/service/personalBorrow";
                            });
                        } else {
                            $("#last-err-p").html(data.retMsg);
                            $this.attr("data-available", true);
                            return false;
                        }
                    });
                }
            }
        } else if (mortgageMode == "2") { //房抵押
            /*if (realNameBlur() && mobileBlur() && selProvinceChange() && selCityChange() && cellNameBlur() && grossAreaBlur() && loanAmountBlur() && loanTermBlur() && loanPurposeBlur()) {*/
            if (realNameBlur() && mobileBlur() && loanAmountBlur() && loanTermBlur()) {
                if ($this.attr("data-available") == "true") {
                    $this.attr("data-available", false);
                    showContentLoading();
                    $.post(root + "/service/borrowMoney/insertLoanApply", {
                        "realName": $.trim($realName.val()),
                        "mobile": $.trim($mobile.val()),
                        "mortgageMode": mortgageMode,
                        "sel_province": $.trim($sel_province.val()),
                        "sel_city": $.trim($sel_city.val()),
                        "cellName": $.trim($cellName.val()),
                        "grossArea": $.trim($grossArea.val()),
                        "loanAmount": $.trim($loanAmount.val()),
                        "loanTerm": $.trim($loanTerm.val()),
                        "loanPurpose": $.trim($loanPurpose.val()),
                        "productType": "1"
                    }, function (data) {
                        closeContentLoading();
                        if (data.retCode) {
                            alert("借款申请成功！", function () {
                                showContentLoading();
                                window.location.href = root + "/service/personalBorrow";
                            });
                        } else {
                            $("#last-err-p").html(data.retMsg);
                            $this.attr("data-available", true);
                            return false;
                        }
                    });
                }
            }
        } else if (mortgageMode == "0") { //信用
            /*if (realNameBlur() && mobileBlur() && selProvinceChange() && selCityChange() && cellNameBlur() && grossAreaBlur() && loanAmountBlur() && loanTermBlur() && loanPurposeBlur()) {*/
            if (realNameBlur() && mobileBlur() && loanAmountBlur() && loanTermBlur()) {
                if ($this.attr("data-available") == "true") {
                    $this.attr("data-available", false);
                    showContentLoading();
                    $.post(root + "/service/borrowMoney/insertLoanApply", {
                        "realName": $.trim($realName.val()),
                        "mobile": $.trim($mobile.val()),
                        "mortgageMode": mortgageMode,
                        "sel_province": $.trim($sel_province.val()),
                        "sel_city": $.trim($sel_city.val()),
                        "cellName": $.trim($cellName.val()),
                        "grossArea": $.trim($grossArea.val()),
                        "loanAmount": $.trim($loanAmount.val()),
                        "loanTerm": $.trim($loanTerm.val()),
                        "loanPurpose": $.trim($loanPurpose.val()),
                        "productType": "3"
                    }, function (data) {
                        closeContentLoading();
                        if (data.retCode) {
                            alert("借款申请成功！", function () {
                                showContentLoading();
                                window.location.href = root + "/service/personalBorrow";
                            });
                        } else {
                            $("#last-err-p").html(data.retMsg);
                            $this.attr("data-available", true);
                            return false;
                        }
                    });
                }
            }
        }
    });
    /*************************************************如何借入*****************************************************/
    $(".toBorrow").on("click", function () {
        $(".list-nav li").get(0).click();
        window.location.href = "#top";
    });
});