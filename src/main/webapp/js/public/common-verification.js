/**
 * Created by chen on 2015/10/13.
 */
var common_result = {
    success: true,
    msg: ""
};
//用户名验证
function userNameFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "用户名不能为空";
    } else if (!objValue.match("^[A-Za-z0-9]+$")) {
        common_result.success = false;
        common_result.msg = "用户名由字母a-z或数字组成";
    } else if (objValue.length < 6 || objValue.length > 16) {
        common_result.success = false;
        common_result.msg = "用户名为6-16位之间";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//手机号验证
function mobileFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "手机号不能为空";
    } else if (!objValue.match("^1[0-9]{2}[0-9]{8}|^14[0-9]{1}[0-9]{8}|^15[0-9]{1}[0-9]{8}|^17[0-9]{1}[0-9]{8}|^18[0-9]{1}[0-9]{8}")) {
        common_result.success = false;
        common_result.msg = "手机号不正确";
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
    /*var regUpper = /[A-Z]/;*/
    var regLower = /[a-zA-Z]/;
    var regStr = /[0-9]/;
    var complex = 0;
    var regyz = /((?=[\x21-\x7e]+)[^A-Za-z0-9])/;
    if (regLower.test(objValue)) {
        ++complex;
    }
    /*if (regUpper.test(objValue)) {
        ++complex;
    }*/
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
        common_result.msg = "密码最少为8位字符，需同时包含字母和数字，但不可包含特殊字符";
    } else if (objSubValue && objValue != objSubValue) {
        common_result.success = false;
        common_result.msg = "请修改重复密码";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//wap中密码验证
function passwordFormatWap(element, elementSub) {
    var objValue = $.trim(element.val()); //密码
    var objSubValue = "";
    elementSub ? objSubValue = $.trim(elementSub.val()) : objSubValue = "";
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "密码不能为空";
    } else if (!objValue.match("^(?=.*?[a-zA-Z])(?=.*?[0-9])[a-zA-Z0-9]{6,20}$")) {
        common_result.success = false;
        common_result.msg = "密码为同时包含字母和数字6-20位字符";
    } else if (objSubValue && objValue != objSubValue) {
        common_result.success = false;
        common_result.msg = "请修改重复密码";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//重复密码验证
function passwordSubFormat(element, elementSub) {
    var objValue = element.val(); //密码
    var objSubValue = elementSub.val(); //重复密码
    if (!objSubValue) {
        common_result.success = false;
        common_result.msg = "重复密码不能为空";
    } else if (objValue != objSubValue) {
        common_result.success = false;
        common_result.msg = "两次输入的密码不一致";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//邀请人手机号验证
function friendMobileFormat(element) {
    var objValue = $.trim(element.val());
    if (objValue) {
        if (!objValue.match("^1[0-9]{2}[0-9]{8}|^15[0-9]{1}[0-9]{8}|^17[0-9]{1}[0-9]{8}|^18[0-9]{1}[0-9]{8}")) {
            common_result.success = false;
            common_result.msg = "邀请人手机号不正确";
        } else {
            common_result.success = true;
        }
    } else {
        common_result.success = true;
    }
    return common_result;
};
//真实姓名验证
function realNameFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "真实姓名不能为空";
    } else if (!objValue.match("^[\u4E00-\u9FA5]{2,}(?:·[\u4E00-\u9FA5]{1,})*$")) {
        common_result.success = false;
        common_result.msg = "姓名格式错误";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//身份证号验证
function idCardFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "身份证号不能为空";
    } else if (!objValue.match("^[1-9]([0-9]{16}|[0-9]{13})[xX0-9]$")) {
        common_result.success = false;
        common_result.msg = "身份证号不正确";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否选择银行验证
function selectBankFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请选择银行";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否填写省份验证
function locProvinceFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请填写省份";
    } else if (!objValue.match("^[\u4e00-\u9fa5]{2,10}$")) {
        common_result.success = false;
        common_result.msg = "省份由2-10位汉字组成";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否填写城市验证
function locCityFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请填写城市";
    } else if (!objValue.match("^[\u4e00-\u9fa5]{2,10}$")) {
        common_result.success = false;
        common_result.msg = "城市由2-10位汉字组成";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否填写地区验证
function locCountyFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请填写县区";
    } else if (!objValue.match("^[\u4e00-\u9fa5]{2,10}$")) {
        common_result.success = false;
        common_result.msg = "县区由2-10位汉字组成";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否选择省份验证
function selectProvinceFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请选择省份";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否选择城市验证
function selectCityFormat(element, elementSub) {
    var objValue = $.trim(element.val());
    var objValueSub = $.trim(elementSub.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请先选择省份";
    } else if (!objValueSub) {
        common_result.success = false;
        common_result.msg = "请选择城市";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//是否选择地区验证
function selectCountyFormat(element, elementOne, elementTwo) {
    var objValue = $.trim(element.val());
    var objValueOne = $.trim(elementOne.val());
    var objValueTwo = $.trim(elementTwo.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "请先选择省份";
    } else if (!objValueOne) {
        common_result.success = false;
        common_result.msg = "请先选择城市";
    } else if (!objValueTwo) {
        common_result.success = false;
        common_result.msg = "请选择县区";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//银行卡号验证
function bankCodeFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "银行卡号不能为空";
    } else if (!objValue.match("^[0-9]{16,19}$")) {
        common_result.success = false;
        common_result.msg = "银行卡号不正确";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//交易密码验证
function tradingPasswordFormat(element) {
    var objValue = element.val();
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "交易密码不能为空";
    } else if (!objValue.match("^[0-9]{6}$")) {
        common_result.success = false;
        common_result.msg = "交易密码由6位数字组成";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//充值金额验证
function rechargeMoneyFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "充值金额不能为空";
    } else if (!objValue.match("^[0-9]+([.][0-9]{0,2}){0,1}$")) {
        common_result.success = false;
        common_result.msg = "充值金额错误，只能输入数字，最多输入两位小数";
    } else if (objValue > 1000000) {
        common_result.success = false;
        common_result.msg = "单次充值金额需在1百万以内";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//提现金额验证
function withdrawalsMoneyFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "提现金额不能为空";
    } else if (!objValue.match("^[0-9]+([.][0-9]{0,2}){0,1}$")) {
        common_result.success = false;
        common_result.msg = "提现金额错误，只能输入数字，最多输入两位小数";
    } else if (parseFloat(objValue) > 50000) {
        common_result.success = false;
        common_result.msg = "提现单笔限额为50000元";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//借款金额验证
function loanAmountFormat(element) {
    var objValue = $.trim(element.val());
    objValue = parseFloat(objValue);
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "借款金额不能为空";
    } else if (objValue < 1 || objValue > 1000) {
        common_result.success = false;
        common_result.msg = "借款金额请输入1-1000之间的数字";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//借款期限验证
function loanTermFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "借款期限不能为空";
    } else if (!objValue.match("^[1-9]+[0-9]{0,1}$")) {
        common_result.success = false;
        common_result.msg = "借款期限错误，请输入1-12的正整数";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//图片验证码验证
function imagesVerFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "验证码不能为空";
    } else if (objValue.length > 6) {
        common_result.success = false;
        common_result.msg = "验证码不正确";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//收货人验证
function consigneeFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "收货人姓名不能为空";
    } else if (!objValue.match("^[\u4e00-\u9fa5]{2,10}$")) {
        common_result.success = false;
        common_result.msg = "收货人姓名由2-10位汉字组成";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//详细地址验证
function addressFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "详细地址不能为空";
    } else if (objValue.length > 50) {
        common_result.success = false;
        common_result.msg = "详细地址长度请控制在50位以内";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//汽车型号验证
function carModelFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "汽车型号不能为空";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//车辆登记地验证
function vehicleRegistrationFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "车辆登记地不能为空";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//小区名称验证
function cellNameFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "小区名称不能为空";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//建筑面积验证
function grossAreaFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "建筑面积不能为空";
    } else if (!objValue.match("^[0-9]+([.][0-9]{0,2}){0,1}$")) {
        common_result.success = false;
        common_result.msg = "建筑面积错误，只能输入数字，最多输入两位小数";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//借款用途验证
function loanPurposeFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "借款用途不能为空";
    } else if (objValue.length <= 10) {
        common_result.success = false;
        common_result.msg = "您输入的借款用途描述不够详细";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//电子邮箱验证
function emailFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "电子邮箱不能为空";
    } else if (!objValue.match("^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$")) {
        common_result.success = false;
        common_result.msg = "电子邮箱格式不正确";
    } else {
        common_result.success = true;
    }
    return common_result;
};
//地址验证
function addressFormat(element) {
    var objValue = $.trim(element.val());
    if (!objValue) {
        common_result.success = false;
        common_result.msg = "地址不能为空";
    } else {
        common_result.success = true;
    }
    return common_result;
};


//监听int类型input事件
function domInputIntEvent(element) {
    var temp = parseInt($.trim(element.val()));
    if (temp) {
        element.val(temp);
    } else {
        element.val("");
    }
};
//监听float类型input事件
function domInputFloatEvent(element) {
    var temp = $.trim(element.val());
    if (!temp.match("^[0-9]+([.][0-9]{0,2}){0,1}$")) {
        temp = parseFloat(temp);
        if (temp.toString().indexOf('.') > -1) {
            temp = temp.toString().substring(0, temp.toString().indexOf('.') + 3);
        }
    }
    if (temp) {
        element.val(temp);
    } else {
        element.val("");
    }
};


//获取手机验证码
function getMobileVerFormat(element) {
    var timeNum = 60;
    var tempHtml = element.html();
    element.html(timeNum + "s重新发送");
    element.css({
        "background": "#d2d2d2"
    });
    var timer = setInterval(function () {
        if (timeNum <= 1) {
            clearInterval(timer);
            element.html(tempHtml);
            element.attr("data-available", true);
            element.css({
                "background": "#09afdf"
            });
        } else {

            --timeNum;
            element.html(timeNum + "s重新发送");

        }
    }, 1000);
};


//cookie操作
function setCookie(name, value, day) {
    if (null != value) {
        value = encodeURI(value);
    }
    if (day) {
        $.cookie(name, value, {
            expires: day,
            path: "/"
        });
    } else {
        $.cookie(name, value, {
            path: "/"
        });
    }
}

function getCookie(name) {
    var cookieValue = decodeURI(($.cookie(name) || ""), "utf-8");
    return cookieValue;
}
//sessionStorage的操作
session = {
    get: function (key) {
        return sessionStorage.getItem(key);
    },
    set: function (key, val) {
        return sessionStorage.setItem(key, val);
    },
    del: function (key) {
        return sessionStorage.removeItem(key);
    }
};


//手机浏览器判断
function is_weixn() {
    var ua = navigator.userAgent.toLowerCase();
    if (ua.match(/MicroMessenger/i) == "micromessenger") {
        return true;
    } else {
        return false;
    }
};

function is_android() {
    var u = navigator.userAgent,
        app = navigator.appVersion;
    var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
    return isAndroid;
};

function isMobile() {
    var ua = navigator.userAgent;
    var ipad = ua.match(/(iPad).*OS\s([\d_]+)/),
        isIphone = !ipad && ua.match(/(iPhone\sOS)\s([\d_]+)/),
        isAndroid = ua.match(/(Android)\s+([\d.]+)/),
        isMobile = isIphone || isAndroid;
    return isMobile;
}

function isIpad() {
    var ua = navigator.userAgent;
    var ipad = ua.match(/(iPad).*OS\s([\d_]+)/);
    return ipad;
}