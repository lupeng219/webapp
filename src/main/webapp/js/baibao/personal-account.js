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
        var provinceList = get_province_array(),
            htmlStr = "";

        for (var i = 0; i < provinceList.length; i++) {
            htmlStr += '<li>' + provinceList[i] + '</li>';
        }

        $("#provinceList").html(htmlStr);
    };

    //绑卡下拉效果
    $("#loc_bank").on("click", function () {
        $("#bankList").slideToggle(200);
    });

    $("#bankList li").on("click", function () {
        var htmlTemp = $.trim($(this).html());
        var dataTemp = $.trim($(this).attr("data"));

        $("#loc_bank").val(htmlTemp);
        $("#loc_bank").attr("data", dataTemp);
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
        if (obj.parentNode.id != "bankList" && obj.id != "loc_bank") {
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

    /**  模块切换 **/
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

    /**  我的账户 修改信息 **/
    var acountop = oTab.find(".acount-op");
    var zhedie = oTab.find(".zhedie");
    var updatecon = oTab.find(".update-con");

    for (var i = 0; i < acountop.length; i++) {
        acountop[i].index = i;
        acountop[i].onclick = function () {
            updatecon.hide();

            $(this).closest("li").next().find(".update-con").show();
        };
    }

    /**  我的账户 修改信息框折叠 **/
    for (var i = 0; i < zhedie.length; i++) {
        zhedie[i].index = i;
        zhedie[i].onclick = function () {
            for (var i = 0; i < acountop.length; i++) {
                zhedie[i].className = "zhedie periconbg";
                updatecon[i].style.display = "none";
            }

            this.className = "zhedie periconbg";

            updatecon[this.index].style.display = "none";

            clearContent();
            clearStyle();
        };
    }

    /**  银行卡绑定帮助 **/
    $("#question-icon").hover(function () {
        $("#bankbang-help").show();
        $("#bankhelp-jiao").show();
    }, function () {
        $("#bankbang-help").hover(function () {}, function () {
            $("#bankbang-help").hide();
            $("#bankhelp-jiao").hide();
        });
    });

    //***************修改登录密码*******************
    $("#oldPassword").on("blur", function () {
        oldPasswordBlur();
    });
    $("#newPassword").on("blur", function () {
        newPasswordBlur();
    });
    $("#newPasswordSub").on("blur", function () {
        newPasswordSubBlur();
    });

    function oldPasswordBlur() {
        var oldPassword = $.trim($("#oldPassword").val());
        var temp = "";

        if (oldPassword) {
            if (oldPassword.length < 6) {
                temp = resultVer({
                    "success": false,
                    "msg": "密码不正确"
                }, $("#oldPassword"));
            } else {
                temp = resultVer({
                    "success": true,
                    "msg": ""
                }, $("#oldPassword"));
            }
        } else {
            temp = resultVer({
                "success": false,
                "msg": "密码为空"
            }, $("#oldPassword"));
        }

        if (temp) {
            $.ajax({
                type: 'POST',
                async: false,
                url: root + "/service/account/ajaxCheckPassword",
                data: {
                    "oldPassword": oldPassword
                },
                dataType: 'json',
                error: function (data) {
                    alert(data.statusText);
                    temp = false;
                },
                success: function (data) {
                    if (!data.retCode) {
                        resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#oldPassword"));
                    }

                    temp = data.retCode;
                }
            });
        }

        return temp;
    };

    function newPasswordBlur() {
        result = passwordFormat($("#newPassword"), $("#newPasswordSub"));

        var temp = resultVer(result, $("#newPassword"));

        return temp;
    }

    function newPasswordSubBlur() {
        result = passwordSubFormat($("#newPassword"), $("#newPasswordSub"));

        var temp = resultVer(result, $("#newPasswordSub"));

        return temp;
    };

    $("#modify_userPass").on("click", function () {
        if (oldPasswordBlur() && newPasswordBlur() && newPasswordSubBlur()) {
            var oldPassword = $.trim($("#oldPassword").val());
            var newPassword = $.trim($("#newPassword").val());
            var newPasswordSub = $.trim($("#newPasswordSub").val());

            $.post(root + "/service/account/updateLoginPass", {
                "oldPassword": oldPassword,
                "newPassword": newPassword,
                "newPasswordSub": newPasswordSub
            }, function (data) {
                if (data.retCode) {
                    $("#passwordErr").html(data.retMsg);

                    setTimeout(function () {
                        location.reload();
                        $(document).scrollTop(0);
                    }, 800);
                } else {
                    if (data.retType == 'passSub') {
                        resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#newPasswordSub"));
                    } else
                    if (data.retType == 'oldpass') {
                        resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#oldPassword"));
                    } else {
                        $("#passwordErr").html("修改失败");
                    }
                }
            });
        } else {
            return false;
        }
    });

    //***************实名认证*******************
    $("#realName").on("blur", function () {
        realNameBlur();
    });
    $("#idCard").on("blur", function () {
        idCardBlur();
    });

    function realNameBlur() {
        result = realNameFormat($("#realName"));
        var temp = resultVer(result, $("#realName"));

        return temp;
    };

    function idCardBlur() {
        result = idCardFormat($("#idCard"));
        var temp = resultVer(result, $("#idCard"));

        return temp;
    };

    $("#open_account").on("click", function () {
        if (realNameBlur() && idCardBlur()) {
            var realName = $.trim($("#realName").val());
            var idCard = $.trim($("#idCard").val());

            $.post(root + "/service/certification/certificationOperation", {
                "realName": realName,
                "idCard": idCard,
                "channel": "1"
            }, function (data) {
                if (data.retCode) {
                    location.reload();
                } else {
                    $("#openAccountErr").html(data.retMsg);
                    return false;
                }
            });
        } else {
            return false;
        }
    });

    //***************更新交易密码*******************
    $("#oldTradingPassword").on("blur", function () {
        oldTradingPasswordBlur();
    });

    $("#newTradingPassword").on("blur", function () {
        newTradingPasswordBlur();
    });

    $("#newTradingPasswordSub").on("blur", function () {
        newTradingPasswordSubBlur();
    });

    function oldTradingPasswordBlur() {
        result = tradingPasswordFormat($("#oldTradingPassword"));
        var temp = resultVer(result, $("#oldTradingPassword"));

        return temp;
    };

    function newTradingPasswordBlur() {
        result = tradingPasswordFormat($("#newTradingPassword"));
        var temp = resultVer(result, $("#newTradingPassword"));
        console.log(result);

        return temp;
    };

    function newTradingPasswordSubBlur() {
        result = passwordSubFormat(
            $("#newTradingPassword"), $("#newTradingPasswordSub"));

        var temp = resultVer(result, $("#newTradingPasswordSub"));
        return temp;
    };

    $("#set_trading_pass").on("click", function () {
        if ($("#isFirst").val() == 1) {
            if (!oldTradingPasswordBlur()) {
                return false;
            }
        }

        if (newTradingPasswordBlur() && newTradingPasswordSubBlur()) {
            var oldpass = $.trim($("#oldTradingPassword").val());
            var newpass = $.trim($("#newTradingPassword").val());
            var newpassSub = $.trim($("#newTradingPasswordSub").val());

            if (oldpass != "" && oldpass != null) {
                oldpass = encryption(oldpass);
            }

            $.post(root + "/service/account/updateTransPass", {
                "oldpassworld": oldpass,
                "newPassword": encryption(newpass),
                "newPasswordSub": encryption(newpassSub)
            }, function (data) {
                if (data.retCode) {
                    $("#passwordErr").html(data.retMsg);

                    setTimeout(function () {
                        location.reload();
                        $(document).scrollTop(0);
                    }, 800);
                } else {
                    if (data.retType == 'old') {
                        resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#oldTradingPassword"));
                    } else
                    if (data.retType == 'passsub') {
                        resultVer({
                            "success": data.retCode,
                            "msg": data.retMsg
                        }, $("#newTradingPasswordSub"));
                    }
                }
            });
        } else {
            return false;
        }
    });

    //********************电子邮箱**************************
    $("#oldEmail").on("blur", oldEmailBlur);
    $("#newEmail").on("blur", newEmailBlur);
    $("#emailVer").on("blur", emailVerBlur);

    function oldEmailBlur() {
        result = emailFormat($("#oldEmail"));
        var temp = resultVer(result, $("#oldEmail"));

        return temp;
    };

    function newEmailBlur() {
        result = emailFormat($("#newEmail"));
        var temp = resultVer(result, $("#newEmail"));

        return temp;
    };

    function emailVerBlur() {
        result = imagesVerFormat($("#emailVer"));
        var temp = resultVer(result, $("#emailVer"));

        return temp;
    };

    //获取邮箱验证码
    $(".yzm-btn").on("click", function () {
        var $this = $(this),
            isSetEmil = $.trim($("#isSetEmil").val());

        if (isSetEmil == '1') { //修改邮箱获取验证码
            if (oldEmailBlur() && newEmailBlur()) {
                if ($this.attr("data-available") == "true") {
                    $this.attr("data-available", false);

                    showContentLoading();

                    $.post(root + "/service/account/getEmailVer", {
                        "oldEmail": $.trim($("#oldEmail").val()),
                        "newEmail": $.trim($("#newEmail").val())
                    }, function (data) {
                        closeContentLoading();

                        if (data.retCode) {
                            getMobileVerFormat($this);
                        } else {
                            $("#emailVerErr").html(data.retMsg);

                            $this.attr("data-available", true);
                            return false;
                        }
                    });
                }
            }
        } else
        if (isSetEmil == '0') { //设置邮箱获取验证码
            if (newEmailBlur()) {
                if ($this.attr("data-available") == "true") {
                    $this.attr("data-available", false);
                    showContentLoading();

                    $.post(root + "/service/account/getEmailVer", {
                        "newEmail": $.trim($("#newEmail").val())
                    }, function (data) {
                        closeContentLoading();

                        if (data.retCode) {
                            getMobileVerFormat($this);
                        } else {
                            $("#emailVerErr").html(data.retMsg);
                            $this.attr("data-available", true);

                            return false;
                        }
                    });
                }
            }
        }
    });
    //设置邮箱
    $("#set_email").on("click", function () {
        var isSetEmil = $.trim($("#isSetEmil").val());

        if (isSetEmil == '1') { //修改邮箱
            if (oldEmailBlur() && newEmailBlur() && emailVerBlur()) {
                $.post(root + "/service/account/updateEmail", {
                    "oldEmail": $.trim($("#oldEmail").val()),
                    "newEmail": $.trim($("#newEmail").val()),
                    "emailVer": $.trim($("#emailVer").val())
                }, function (data) {
                    if (data.retCode) {
                        $("#emailVerErr").html(data.retMsg);

                        setTimeout(function () {
                            location.reload();
                            $(document).scrollTop(0);
                        }, 800);
                    } else {
                        $("#emailVerErr").html(data.retMsg);

                        return false;
                    }
                });
            }
        } else
        if (isSetEmil == '0') { //设置邮箱
            if (newEmailBlur() && emailVerBlur()) {
                $.post(root + "/service/account/updateEmail", {
                    "newEmail": $.trim($("#newEmail").val()),
                    "emailVer": $.trim($("#emailVer").val())
                }, function (data) {
                    if (data.retCode) {
                        $("#emailVerErr").html(data.retMsg);

                        setTimeout(function () {
                            location.reload();
                            $(document).scrollTop(0);
                        }, 800);
                    } else {
                        $("#emailVerErr").html(data.retMsg);

                        return false;
                    }
                });
            }
        }
    });

    //***********************************现住地址************************************
    $("#newAddress").on("blur", newAddressBlur);

    function newAddressBlur() {
        result = addressFormat($("#newAddress"));
        var temp = resultVer(result, $("#newAddress"));

        return temp;
    };

    $("#set_address").on("click", function () {
        if (newAddressBlur()) {
            $.post(root + "/service/account/updateAddress", {
                "newAddress": $.trim($("#newAddress").val())
            }, function (data) {
                if (data.retCode) {
                    $("#addressVerErr").html(data.retMsg);
                    setTimeout(function () {
                        location.reload();
                        $(document).scrollTop(0);
                    }, 800);
                } else {
                    $("#addressVerErr").html(data.retMsg);

                    return false;
                }
            });
        }
    });

    //***********************************上传头像************************************
    $("#uploadImg").on("change", function () {
        $("#uploadFileName").html($(this).val());
    });

    $("#stateUpload").on("click", function () {
        var temp = $("#uploadImg").val();
        if (!temp) {
            $("#uploadErr").html("未选择图片");

            return false;
        } else {
            var str = temp.substring(temp.lastIndexOf(".") + 1).toUpperCase();

            if (str != "JPG" &&
                str != "GIF" &&
                str != "PNG") {
                $("#uploadErr").html("请上传JPG、GIF或PNG文件");

                return false;
            }
        }

        var options = {
            "url": root + "/service/fileUpLoad/upLoad",
            "type": "POST",
            "dataType": "text",
            "success": function (data) {
                var json = JSON.parse(data);

                var imageId = json.imageId;
                var imgUrl = root + json.imageUrl;

                $("#realWidth").val(json.width);
                $("#realHeight").val(json.height);
                $("#imageId").val(imageId);
                $("#modifyHeadModel").hide();
                $("#imgCropModel").show();
                $("#cropImg").attr("src", imgUrl);
                $("div.jcrop-holder").find("img").attr("src", imgUrl);

                $('#cropImg').Jcrop({
                    minSize: [100, 100],
                    setSelect: [0, 0, 100, 100],
                    aspectRatio: 1 / 1,
                    boundary: 0,
                    onChange: storeCoords,
                    onSelect: storeCoords
                });
            },
            "error": function (err, errmsg) {
                alert("上传失败");

                return false;
            }
        };

        $("#uploadForm").ajaxSubmit(options);
    });

    function storeCoords(c) {
        $('#x').val(c.x);
        $('#y').val(c.y);
        $('#width').val(c.w);
        $('#height').val(c.h);
        $("#imgWidth").val($("#cropImg").css("width").replace("px", ""));
        $("#imgHeight").val($("#cropImg").css("height").replace("px", ""));
    };

    $("#cancelSubResize, #closeCropImg").on("click", function () {
        $("#imgCropModel").hide();
        $("#modifyHeadBack").hide();
    });

    $("#subResize").on("click", function () {
        var w = $("#width").val();
        var h = $("#height").val();

        if (w == 0 || h == 0) {
            alert("请选择剪裁的图片");
            return false;
        }

        var options = {
            "url": root + "/service/fileUpLoad/cropImage",
            "type": "POST",
            "dataType": "json",
            "success": function (data) {
                imgUrl2 = data.imagePath;

                $("#userLogo").attr("src", imgUrl2 + "?" + new Date());
                $("#imgCropModel").hide();
                $("#modifyHeadBack").hide();

                setTimeout(function () {
                    location.reload();
                }, 800);
            },
            "error": function (err, errmsg) {
                alert("上传失败");
                return false;
            }
        };

        $("#imgCropForm").ajaxSubmit(options);
    });

    //我的账户取消按钮
    $(".close-btn").on("click", function () {
        $(this).closest(".update-con").hide();

        clearContent();
        clearStyle();
    });

    //去除文本内容
    function clearContent() {
        $(".acount-txt").val("");
        $(".sctx-txt").val("");
        $("#uploadFileName").html("");
    };

    //验证返回
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

    //去除错误样式
    function clearStyle() {
        $(".err-p").html("");
        $(".alert-err-tip").html("");
        $(".acount-txt").removeClass("txt-err");
        $(".yzm-txt1").removeClass("txt-err");
    };

    //银行卡管理
    $("#bankCode").on("blur", function () {
        bankCodeBlur();
    });

    $("#reserveMobileCode").on("blur ", function () {
        reserveMobileCodeBlur();
    });

    $("#reserveMobileCode").on("input", function () {
        domInputIntEvent($(this));
    });

    $("#mobileVer").on("blur", function () {
        mobileVerBlur();
    });

    function locBankChange() {
        result = selectBankFormat($("#loc_bank"));
        var temp = resultVerTwo(result, $("#loc_bank"));

        return temp;
    }

    function locProvinceChange() {
        result = selectProvinceFormat($("#loc_province"));
        var temp = resultVerTwo(result, $("#loc_province"));

        return temp;
    }

    function locCityChange() {
        result = selectCityFormat($("#loc_province"), $("#loc_city"));
        var temp = resultVerTwo(result, $("#loc_city"));

        return temp;
    }

    function bankCodeBlur() {
        result = bankCodeFormat($("#bankCode"));
        var temp = resultVerTwo(result, $("#bankCode"));

        return temp;
    }

    function reserveMobileCodeBlur() {
        result = mobileFormat($("#reserveMobileCode"));
        var temp = resultVerTwo(result, $("#reserveMobileCode"));

        return temp;
    }

    function mobileVerBlur() {
        result = mobileVerFormat($("#mobileVer"));
        var temp = resultVerTwo(result, $("#mobileVer"));

        return temp;
    };

    //去实名认证
    $("#isNotCert").on("click", function () {
        $(".mkli")[0].click();
        $("#toCert").click();
    });

    //银行卡管理-----获取验证码
    $("#next-step").on("click", function () {
        var $this = $(this);
        var isAvailable = $this.attr("data-available");
        if (isAvailable == "true") {
            $this.attr("data-available", false);

            if (locBankChange() && locProvinceChange() &&
                locCityChange() && bankCodeBlur() && reserveMobileCodeBlur()) {
                showContentLoading();

                $.post(root + "/service/bankCard/bankCardBinding", {
                    "bankCode": $.trim($("#loc_bank").attr("data")),
                    "province": $.trim($("#loc_province").val()),
                    "city": $.trim($("#loc_city").val()),
                    "bankCardNo": $.trim($("#bankCode").val()),
                    "phoneNo": $.trim($("#reserveMobileCode").val()),
                    "channel": "1"
                }, function (data) {
                    closeContentLoading();

                    if (data.retCode) {
                        getMobileVerFormat($this);

                        $("#bang-commit-not").hide();
                        $("#bang-commit").show();
                    } else {
                        $("#mobileVerErr").html(data.retMsg);
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

    $("#bang-commit-not").on("click", function () {
        locBankChange() && locProvinceChange() &&
            locCityChange() && bankCodeBlur() &&
            reserveMobileCodeBlur() && mobileVerBlur();
    });

    $("#bang-commit").on("click", function () {
        var $this = $(this);
        var isAvailable = $this.attr("data-available");

        if (isAvailable == "true") {
            $this.attr("data-available", false);

            if (locBankChange() && locProvinceChange() &&
                locCityChange() && bankCodeBlur() &&
                reserveMobileCodeBlur() && mobileVerBlur()) {
                $.post(root + "/service/bankCard/bankCardBindingAdvance", {
                    "validCode": $.trim($("#mobileVer").val()),
                    "bankCardNo": $.trim($("#bankCode").val()),
                    "channel": "1"
                }, function (data) {
                    if (data.retCode) {
                        alert(data.retMsg, function () {
                            location.reload();
                        });
                    } else {
                        $("#mobileVerErr").html(data.retMsg);
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

    //银行卡管理-----验证返回
    function resultVerTwo(data, element) {
        if (data.success) {
            clearStyleTwo();
            return true;
        } else {
            clearStyleTwo();
            element.closest("li").find(".errbank-p").html(data.msg);
            element.closest("li").find(".alert-err-tip").html(data.msg);

            if (element.hasClass("bank-txt") ||
                element.hasClass("txtpwd") ||
                element.hasClass("ui-txt")) {
                element.addClass("txt-err");
            }

            return false;
        }
    };

    //银行卡管理-----去除错误样式
    function clearStyleTwo() {
        $(".errbank-p").html("");
        $(".alert-err-tip").html("");
        $(".bank-txt").removeClass("txt-err");
        $(".txtpwd").removeClass("txt-err");
        $(".ui-txt").removeClass("txt-err");
    };

    //解绑银行卡
    $("#mobileVer1").on("blur", mobileVerBlur1);

    function mobileVerBlur1() {
        result = mobileVerFormat($("#mobileVer1"));
        var temp = resultVerTwo(result, $("#mobileVer1"));

        return temp;
    }

    $("#unBinging").on("click", function () {
        showProdectWindow();
        clearStyleTwo();
    });

    //获取验证码
    $(".btn-hqyzm1").on("click", function () {
        var $this = $(this);

        var Isclick = $this.attr("data-available");
        if (Isclick == "true") {
            $this.attr("data-available", false);

            $.post(root + "/service/bankCard/unbinding?channel=1", function (data) {
                if (data.retCode) {
                    getMobileVerFormat($this);
                } else {
                    clearStyle();
                    $("#tradeVerErr").html(data.retMsg);
                    $this.attr("data-available", true);

                    return false;
                }
            });
        } else {
            return false;
        }
    });

    $("#submitMobileVer").on("click", function () {
        var $this = $(this);

        if (mobileVerBlur1()) {
            var Isclick = $this.attr("data-available");

            if (Isclick == "true") {
                $this.attr("data-available", false);

                var mobileVer1 = $.trim($("#mobileVer1").val());
                $.post(root + "/service/bankCard/unbindingAdvance", {
                    "validCode": mobileVer1,
                    "channel": 1
                }, function (data) {
                    if (data.retCode) {
                        $("#tradeVerErr").html("").html("解绑成功！");

                        setTimeout(function () {
                            location.reload();
                        }, 800);
                    } else {
                        $("#tradeVerErr").html(data.retMsg);
                        $this.attr("data-available", true);

                        return false;
                    }
                });
            }
        }
    });
});