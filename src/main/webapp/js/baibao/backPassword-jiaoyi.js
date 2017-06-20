/**
 * Created by chen on 2015/10/28.
 */
$(function(){
    var result={};
    var $mobileVer=$("#mobileVer"),
        $tradingPassword=$("#tradingPassword"),
        $tradingPasswordSub=$("#tradingPasswordSub"),
        $errOne=$("#errOne"),
        $errTwo=$("#errTwo"),
        $backpwd_ui=$(".backpwd-ui"),
        $step_item=$(".step-list .step-item");
    $mobileVer.on("blur",mobileVerBlur);
    $tradingPassword.on("blur",tradingPasswordBlur);
    $tradingPasswordSub.on("blur",tradingPasswordSubBlur);

    function mobileVerBlur(){
        result=mobileVerFormat($mobileVer);
        var temp=resultVer(result,$mobileVer);
        return temp;
    };
    function tradingPasswordBlur(){
        result=tradingPasswordFormat($tradingPassword);
        var temp=resultVer(result,$tradingPassword);
        return temp;
    };
    function tradingPasswordSubBlur(){
        result=passwordSubFormat($tradingPassword,$tradingPasswordSub);
        var temp=resultVer(result,$tradingPasswordSub);
        return temp;
    };

    //获取手机验证码
    $(".btn-hqyzm").on("click",function(){
        var $this=$(this);
        var isAvailable=$this.attr("data-available");
        if(isAvailable=="true"){
            $this.attr("data-available",false);
            $.post(root+"/service/account/getTranspwdValidateCode",function(data){
                if(data.retCode){
                    getMobileVerFormat($this);
                }else{
                    clearStyle();
                    $errOne.html(data.retMsg);
                    $this.attr("data-available",true);
                    return false;
                }
            });
        }else{
            return false;
        }
    });
    $("#backSubmitOne").on("click",function(){
        if(mobileVerBlur()){
            $.post(root+"/service/account/checktranspwdvalidatecode",{
                "code": $.trim($mobileVer.val())
            },function(data){
                if(data.retCode){
                    showHide(2);
                }else{
                    $errOne.html(data.retMsg);
                    return false;
                }
            });
        }else{
            return false;
        }
    });
    $("#backSubmitTwo").on("click",function(){
        if(tradingPasswordBlur()&&tradingPasswordSubBlur()){
            $.post(root+"/service/account/resetTransPassword",{
                "newPassword": encryption($.trim($tradingPassword.val())),
                "newPasswordSub": encryption($.trim($tradingPasswordSub.val()))
            },function(data){
                if(data.retCode){
                    showHide(3);
                }else{
                    $errTwo.html(data.retMsg);
                    return false;
                }
            });
        }
    });

    function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest("li").find(".err-p").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };
    function clearStyle(){
        $(".err-p").html("");
        $(".back-txt").removeClass("txt-err");
    };
    function showHide(data){
        data=data-1;
        for(var i=0;i<$backpwd_ui.length;i++){
            if(i==data){
                $backpwd_ui[i].style.display="block";
                $step_item[i].className="step-item current-step";
            }else{
                $backpwd_ui[i].style.display="none";
                $step_item[i].className="step-item";
            }
        }
    }
});