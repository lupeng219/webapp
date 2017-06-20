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
        result=oldbaibaoPasswordFormat();
        var temp=resultVer(result,$oldPass);
        return temp;
    };
    function newPassBlur(){
    	 result=passwordFormat($newPass,$newPassSub);
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
    function oldbaibaoPasswordFormat(){
    	var oldPassword=$.trim($oldPass.val());
    	var temp="";
    	if(oldPassword){
    		if(oldPassword.length<6){
    			temp={"success":false,"msg":"密码不正确"};
    		}else{
    			temp={"success":true,"msg":""}
    		}
    	}else{
    		temp={"success":false,"msg":"密码为空"}
    	}
        if(temp.success){
	        $.ajax({
	    		type:'POST',
	    	    async:false,
	    	    url:root+"/service/account/ajaxCheckPassword",
	    	    data:{"oldPassword":oldPassword},
	    	    dataType:'json',
	    	    error:function(data){
	    	    	alert(data.statusText);
	    	    	temp=false;
	    	    },
	    	    success:function(data){
	        		temp={"success":data.retCode,"msg":data.retMsg};
	    	    }
	    	});
        }else{
        	return temp;
        }
        return temp;
    };
    $logion_btn.on("click",function(){
        if(oldPassBlur()&&newPassBlur()&&newPassSubBlur()){
            $.post(root+"/service/wapAccount/updateLoginPass",{
                "oldPassword": $.trim($oldPass.val()),
                "newPassword": $.trim($newPass.val()),
                "newPasswordSub": $.trim($newPassSub.val())
            },function(data){
                if(data.retCode){
                	myShow("修改成功!",function(){
                		window.location.href=root+"/service/wapAccount/wapSafecenter";
                	});
                }else{
                    $newPassSubErr.html(data.retMsg);
                    return false;
                }
            });
        }else{
            return false;
        }
    });
});