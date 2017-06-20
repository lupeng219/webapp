$(function(){
	var $password=$("#password"),
		$rePassword=$("#rePassword"),
		$mobile=$("#mobile"),
		$logion_btn=$(".logion-btn"),
		$rePasswordErr=$("#rePasswordErr"),
		result={};
	//绑定事件
	$password.on("blur",passwordBlur);
	$rePassword.on("blur",rePasswordBlur);
	//处理事件
	function passwordBlur(){
		result=passwordFormatWap($password);
        var temp=resultVer(result,$password);
        return temp;
	};
	function rePasswordBlur(){
		result=passwordSubFormat($password,$rePassword);
        var temp=resultVer(result,$rePassword);
        return temp;
	}
	//处理事件结果
	function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest(".txt-cn").find(".err-p").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };
    function clearStyle(){
        $(".err-p").html("");
        $(".txt").removeClass("txt-err");
    };
    //提交
    $logion_btn.on("click",function(){
		if(passwordBlur()&&rePasswordBlur()){
			$.ajax({
	    		type:'POST',
	    	    url:root+"/service/wapLogin/updatePassword",
	    	    data:{
	                'password':$.trim($password.val()),
	                'passwordSub':$.trim($rePassword.val()),
	            },
	    	    dataType:'json',
	    	    error:function(data){
	    	    	myShow(data.statusText);
	    	    	return false;
	    	    },
	    	    success:function(data){
	    	    	if(data.retCode){
	    	    		myShow("修改成功!",function(){
	    	    			window.location.href=root+"/service/wapLogin/toWapLogin";
	    	    		});
	    	    	}else{
	    	    		$rePasswordErr.html(data.msg);
	    	    		return false;
	    	    	}
	    	    }
	    	});
		}else{
			return false;
		}
	});
});