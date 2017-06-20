$(function(){
	var $mobile=$("#mobile"),
    	$imgVer=$("#imgVer"),
    	$verification=$("#verification"),
    	$password=$("#password"),
    	result={};
	$mobile.on("input", function(){domInputIntEvent($mobile);});
    $mobile.on("blur", function(){mobileBlur();});
    $imgVer.on("blur", function(){imgVerBlur();});
    $verification.on("blur", function(){verificationBlur();});
    $password.on("blur", function(){passwordBlur();});
    function mobileBlur(){
        result=mobileFormat($mobile);
        var temp=resultVer(result,$mobile);
        if(temp){
        	$.ajax({
        		type:'POST',
        	    async:false,
        	    url:root+"/service/register/ajaxCheckMobile",
        	    data:{"mobile":$mobile.val()},
        	    dataType:'json',
        	    error:function(data){
        	    	alert(data.statusText);
        	    	temp=false;
        	    },
        	    success:function(data){
        	    	if(!data.retCode){
            			resultVer({"success":data.retCode,"msg":data.retMsg},$mobile);
            		}
        	    	temp=data.retCode;
        	    }
        	});
        }
        return temp;
    };
    function imgVerBlur(){
    	result=imagesVerFormat($imgVer);
        var temp=resultVer(result,$imgVer);
        return temp;
    };
    function verificationBlur(){
        result=mobileVerFormat($verification);
        var temp=resultVer(result,$verification);
        return temp;
    };
    function passwordBlur(){
        result=passwordFormat($password);
        var temp=resultVer(result,$password);
        return temp;
    };
    function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest("li").find(".regerr-tip").html("* "+data.msg);
            return false;
        }
    };
    function clearStyle(){
        $(".regerr-tip").html("");
    };
    $(".hqyzm-btn").on("click",function(){
    	result=mobileFormat($mobile);
        var temp=resultVer(result,$mobile);
        if(!temp){return;}
        mobileVe = mobileVerFormat($imgVer);
    	var varmobileVe = resultVer(mobileVe,$imgVer);
        if(varmobileVe){
        	var $this=$(this);
        	var isAvailable=$this.attr("data-available");
            if(isAvailable=="true"){
                $this.attr("data-available",false);
                $.post(root+"/service/register/getValidateCode",{
                    "mobile": $.trim($mobile.val()),
                    "imgVer":$imgVer.val()
                },function(data){
                    if(data.retCode){
                        getMobileVerFormat($this);
                    }else{
                        clearStyle();
                        if(data.codeORmobile){
        	    			resultVer({"success":data.retCode,"msg":data.retMsg},$imgVer);
        	    		}else{
        	    			resultVer({"success":data.retCode,"msg":data.retMsg},$mobile);
        	    		}
                        $this.attr("data-available",true);
                        return false;
                    }
                });
            }else{
                return false;
            }
        }
    });
    $(".reg-btn").on("click",function(){
        var $this=$(this);
        var isAvailable=$this.attr("data-available");
        if(isAvailable=="true"){
        	$this.attr("data-available",false);
        	if(mobileBlur()&&imgVerBlur()&&verificationBlur()&&passwordBlur()){
                $.post(root+"/service/register/regist",{
                    "mobile": $.trim($mobile.val()),
                    "verification": $.trim($verification.val()),
                    "passd": $.trim($password.val())
                },function(data){
                    if(data.retCode){
                    	$.post(root+"/service/login/userLogin",{
                            "puMobile":$.trim($mobile.val()),
                            "puPassword":$.trim($password.val())
                        },function(data){
                        	if(data.retCode){
                        		window.location.reload();
                        	}else{
                        		window.location.href=root+"/service/login";
                        	}
                        });
                    }else{
                        if(data.type == 'mobile'){
                        	resultVer({"success":data.retCode,"msg":data.retMsg},$mobile);
                        }else if(data.type == 'password'){
                        	resultVer({"success":data.retCode,"msg":data.retMsg},$passwordSub);
                        }else if(data.type == 'valdatecode'){
                        	resultVer({"success":data.retCode,"msg":data.retMsg},$verification);
                        }else{
                        	$("#passwordErr").html(data.retMsg);
                        }
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
    //验证码
    $("#checkCodeImg").on("click",function(){
    	var src = $(this).attr("src");
    	var r=Math.random();
    	if(src.indexOf("?")>=0){
    		src=src.substring(0,src.indexOf("?"));
    	}
    	$(this).attr("src",src+"?r="+r);
    });
});