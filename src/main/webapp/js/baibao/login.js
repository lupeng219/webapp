/**
 * Created by chen on 2015/10/14.
 */
$(function(){
    var userName="",password="",$userName=$("#userName"),$password=$("#password");
    init();
    function init(){
        userName=getCookie("login_user_name");
        if(userName){
            $("#userName").val(userName);
            if($(".yhm-lock").hasClass("yhm-unlock")){
            	$(".yhm-lock").removeClass("yhm-unlock");
            }
            $("#password").val("").focus();
        }else{
        	if(!$(".yhm-lock").hasClass("yhm-unlock")){
        		$(".yhm-lock").addClass("yhm-unlock");
        	}
        	$("#password").val("");
            $("#userName").focus();
        }
    };
    $userName.on("blur",function(){userNameBlur();});
    $password.on("blur",function(){passwordBlur();});
    function userNameBlur(){
        userName= $.trim($userName.val());
        clearStyle();
        if(!userName){
            userNameAddStyle("请输入手机号码");
            return false;
        }else if(userName.length<6){
            userNameAddStyle("用户名或密码不正确");
            return false;
        }
        return true;
    };
    function passwordBlur(){
        password= $.trim($password.val());
        clearStyle();
        if(!password){
            passwordAddStyle("请输入密码");
            return false;
        }else if(password.length<6){
            passwordAddStyle("用户名或密码不正确");
            return false;
        }
        return true;
    };
    function clearStyle(){
        $(".err-tip").html("");
        $(".login-txt").removeClass("login-txterr");
        $(".name-icon").removeClass("disname-icon");
        $(".pass-icon").removeClass("dispass-icon");
    };
    function userNameAddStyle(str){
        $("#userNameErr").html(str);
        $userName.addClass("login-txterr");
        $(".name-icon").addClass("disname-icon");
    };
    function passwordAddStyle(str){
        $("#passwordErr").html(str);
        $password.addClass("login-txterr");
        $(".pass-icon").addClass("dispass-icon");
    };
    //是否记住用户名效果
    $(".yhm-lock").on("click",function(){
        $(this).toggleClass("yhm-unlock");
    });
    $("#password").keydown(function(e){ 
        var curKey = e.which; 
        if(curKey == 13){ 
            $(".ljdl-btn").click(); 
        } 
    });
    //回车时，默认是登陆
    function on_return(){
	    if(window.event.keyCode == 13){
	    	 $(".ljdl-btn").click();
	    }
    }
    $(".ljdl-btn").on("click",function(){
        var $this=$(this);
        var isAvailable=$this.attr("data-available");
        var unLength=$(".yhm-unlock").length;
        if(isAvailable=="true"){
            $this.attr("data-available",false);
            if(userNameBlur()&&passwordBlur()){
                $.post(root+"/service/login/userLogin",{
                    "puMobile":$.trim($userName.val()),
                    "puPassword":$.trim($password.val())
                },function(data){
                    if(data.retCode){
                        if(unLength==0){
                            setCookie("login_user_name",$.trim($userName.val()),7);
                        }else{
                            setCookie("login_user_name",null);
                        }
                        $this.attr("data-available",true);
                        window.location.href=root+"/";
                    }else{
                        $("#passwordErr").html(data.retMsg);
                        $this.attr("data-available",true);
                        return false;
                    }
                });
            }else{
                $this.attr("data-available",true);
                return false;
            }
        }else{
            return false;
        }
    });
});