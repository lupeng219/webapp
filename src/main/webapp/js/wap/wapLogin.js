$(function(){
	var $userName=$("#userName"),$password=$("#password"),$logion_btn=$(".logion-btn"),result={};
	$userName.on("blur",userNameBlur);
	$password.on("blur",passwordBlur);
	function userNameBlur(){
		result=mobileFormat($userName);
        var temp=resultVer(result,$userName);
        return temp;
	};
	function passwordBlur(){
		password= $.trim($password.val());
        if(!password){
            result={"success":false,"msg":"请输入密码"};
        }else if(password.length<6){
            result={"success":false,"msg":"密码不正确"};
        }else{
        	result={"success":true,"msg":"通过"};
        }
        var temp=resultVer(result,$password);
        return temp;
	};
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
        $(".login-txt").removeClass("txt-err");
    };
    $logion_btn.on("click",function(){
		if(userNameBlur()&&passwordBlur()){
			if($logion_btn.attr("data-available")=="true"){
				$logion_btn.attr("data-available",false);
				$.post(root+"/service/login/userLogin",{
					"puMobile":$.trim($("#userName").val()),
					"puPassword":$.trim($("#password").val())
				},function(data){
					if(data.retCode){
						window.location.href=root+"/service/wapIndex/toWapIndex";
					}else{
						$("#passErr").html(data.retMsg);
						$logion_btn.attr("data-available",true);
						return false;
					}
				});
			}
		}else{
			return false;
		}
	});
	//注册
	$("#register").on("click",function(){
		window.location.href=root+"/service/wapRegister/toWapRegister";
	});
});