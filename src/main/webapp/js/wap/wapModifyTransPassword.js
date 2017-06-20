/**
 * Created by chen on 2015/11/4.
 */
$(function(){
    var $oldPass=$("#oldPass"),
        $newPass=$("#newPass"),
        $newPassSub=$("#newPassSub"),
        $logion_btn=$(".logion-btn"),
        $newPassSubErr=$("#newPassSubErr"),
        result={};
    var common_result={
        success:true,
        msg:""
    };
    $oldPass.on("blur",oldPassBlur);
    $newPass.on("blur",newPassBlur);
    $newPassSub.on("blur",newPassSubBlur);
    function oldPassBlur(){
        result=oldbaibaoPasswordFormat($oldPass);
        var temp=resultVer(result,$oldPass);
        return temp;
    };
    function newPassBlur(){
        result=oldbaibaoPasswordFormat($newPass,$newPassSub);
        var temp=resultVer(result,$newPass);
        return temp;
    };
    function newPassSubBlur(){
        result=passwordSubFormat($newPass,$newPassSub);
        var temp=resultVer(result,$newPassSub);
        return temp;
    };
    //返回结果验证
    function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest(".txt-cn").find(".err-p").html(data.msg);
            if(element.hasClass("txt")){
                element.addClass("txt-err");
            }
            return false;
        }
    };
    //清楚错误样式
    function clearStyle(){
        $(".err-p").html("");
        $(".txt").removeClass("txt-err");
    };
    //密码验证
    function oldbaibaoPasswordFormat(element,elementSub){
        var objValue=$.trim(element.val());//密码
        var objSubValue="";
        elementSub?objSubValue=$.trim(elementSub.val()):objSubValue="";
        if(!objValue){
            common_result.success=false;
            common_result.msg="密码为空";
        }else if(objValue.match(".*?[\u4E00-\u9FFF]+.*")){
            common_result.success=false;
            common_result.msg="密码不可包括中文";
        }else if(!objValue.match("^[0-9]{6}$")){
            common_result.success=false;
            common_result.msg="交易密码由6位数字组成";
        }else if(objSubValue&&objValue!=objSubValue){
            common_result.success=false;
            common_result.msg="请修改重复密码";
        }else{
            common_result.success=true;
        }
        return common_result;
    };
    $logion_btn.on("click",function(){
    	//oldPassBlur()&
    	var tempOldPass = null;
    	var data;
    	if($("#oldPass").length>0){
    		if(!oldPassBlur()){
    			return false;
    		}else{
    			tempOldPass = encryption($oldPass.val())
    		}
    	}
        if(newPassBlur()&&newPassSubBlur()){
            $.post(root+"/service/account/updateTransPass",{
                "oldpassworld": tempOldPass,
                "newPassword": encryption($newPass.val()),
                "newPasswordSub": encryption($newPassSub.val())
            },function(data){
                if(data.retCode){
                	myShow("修改成功!",function(){
                		window.location.href=root+"/service/wapAccount/wapSafecenter";
                	});
                }else{
                    $newPassSubErr.html(data.msg);
                    return false;
                }
            });
        }else{
            return false;
        }
    });
});