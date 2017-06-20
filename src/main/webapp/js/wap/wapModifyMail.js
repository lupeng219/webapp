/**
 * Created by chen on 2015/11/4.
 */
$(function(){
    var $oldPass=$("#oldPass"),
        $newPass=$("#newPass"),
        $newPassSub=$("#newPassSub"),
        $hqyzmbtn=$(".hqyzm-btn"),
        $this=$(".hqyzm-btn"),
        $newPassSubErr=$("#newPassSubErr"),
        $logion_btn=$(".logion-btn"),
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
        result=oldbaibaoPasswordFormat($newPass);
        var temp=resultVer(result,$newPass);
        return temp;
    };
    function newPassSubBlur(){
        result=imagesVerFormat($newPassSub);
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
    function oldbaibaoPasswordFormat(element){
    	common_result = emailFormat(element);
        return common_result;
    };
    //==========
    $hqyzmbtn.on("click",function(){
    	var isFirst=$.trim($("#isFirst").val());
    	if(isFirst=='1'){
    		if(oldPassBlur()&&newPassBlur()){
    			if($this.attr("data-available")=="true"){
    				$this.attr("data-available",false);
    				showContentLoading();
    				$.post(root+"/service/account/getEmailVer",{
    					"oldEmail":$.trim($oldPass.val()),
    					"newEmail":$.trim($newPass.val())
    				},function(data){
    					closeContentLoading();
    					if(data.retCode){
    						getMobileVerFormat($this);
    					}else{
    						$newPassSubErr.html(data.retMsg);
    						$this.attr("data-available",true);
    	                    return false;
    					}
    				});
    			}
    		}
    	}else{
    		//设置邮箱获取验证码
    		if(newPassBlur()){
    			if($this.attr("data-available")=="true"){
    				$this.attr("data-available",false);
    				showContentLoading();
    				$.post(root+"/service/account/getEmailVer",{
    					"newEmail":$.trim($newPass.val())
    				},function(data){
    					closeContentLoading();
    					if(data.retCode){
    						getMobileVerFormat($this);
    					}else{
    						$newPassSubErr.html(data.retMsg);
    						$this.attr("data-available",true);
    	                    return false;
    					}
    				});
    			}
    		}
    	
    	}
    });
    
    
  //设置邮箱
    $logion_btn.on("click",function(){
    	var isFirst=$.trim($("#isFirst").val());
    	if(isFirst=='1'){//修改邮箱
    		if(oldPassBlur()&&newPassBlur()&&newPassSubBlur()){
    			$.post(root+"/service/account/updateEmail",{
					"oldEmail":$.trim($oldPass.val()),
					"newEmail":$.trim($newPass.val()),
					"emailVer":$.trim($newPassSub.val())
				},function(data){
					if(data.retCode){
						$newPassSubErr.html(data.retMsg);
	                    setTimeout(function(){window.location.href=root+"/service/wapAccount/wapSafecenter";},800);
					}else{
						$newPassSubErr.html(data.retMsg);
	                    return false;
					}
				});
    		}
    	}else if(isFirst=='0'){//设置邮箱
    		if(newPassBlur()&&newPassSubBlur()){
    			$.post(root+"/service/account/updateEmail",{
					"newEmail":$.trim($newPass.val()),
					"emailVer":$.trim($newPassSub.val())
				},function(data){
					if(data.retCode){
						$newPassSubErr.html(data.retMsg);
	                    setTimeout(function(){window.location.href=root+"/service/wapAccount/wapSafecenter";},800);
					}else{
						$newPassSubErr.html(data.retMsg);
	                    return false;
					}
				});
    		}
    	}
    });
    
});