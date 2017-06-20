$(function(){
	var $mobile=$("#mobile"),
		$imgVer=$("#imgVer"),
		$verification=$("#verification"),
		$password=$("#password"),
		$invitingMobile=$("#yqrsjh"),
		$checkCodeImg=$("#checkCodeImg"),
		result={};
	//绑定事件
	$mobile.on("input", function(){domInputIntEvent($mobile);});
	$invitingMobile.on("input", function(){domInputIntEvent($invitingMobile);});
	$mobile.on("blur",mobileBlur);
	$imgVer.on("blur", imgVerBlur);
	$verification.on("blur",verificationBlur);
	$password.on("blur",passwordBlur);
	$invitingMobile.on("blur", invitingMobileBlur);
	//处理事件
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
        	    	myShow(data.statusText);
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
		result=passwordFormatWap($password);
        var temp=resultVer(result,$password);
        return temp;
	};
	function invitingMobileBlur(){
		if($invitingMobile.attr("data")=="1"){
			return true;
		}
		result=friendMobileFormat($invitingMobile);
        var temp=resultVer(result,$invitingMobile);
        if(temp&&$invitingMobile.val()){
        	$.ajax({
        		type:'POST',
        	    async:false,
        	    url:root+"/service/register/getCheckInviter",
        	    data:{"mobile":$invitingMobile.val()},
        	    dataType:'json',
        	    error:function(data){
        	    	myShow(data.statusText);
        	    	temp=false;
        	    },
        	    success:function(data){
        	    	if(!data.retCode){
            			resultVer({"success":data.retCode,"msg":data.retMsg},$invitingMobile);
            		}
        	    	temp=data.retCode;
        	    }
        	});
        }
        return temp;
	};
	function changeImgVer(){
		var src = $checkCodeImg.attr("src");
    	var r=Math.random();
    	if(src.indexOf("?")>=0){
    		src=src.substring(0,src.indexOf("?"));
    	}
    	$checkCodeImg.attr("src",src+"?r="+r);
	};
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
    //更换图片验证码
    $checkCodeImg.on("click",function(){
    	changeImgVer();
    });
	//获取手机验证码
	$(".hqyzm-btn").on("click",function(){
		var $this=$(this);
		result=mobileFormat($mobile);
        var temp=resultVer(result,$mobile);
        if(temp&&imgVerBlur()){
            if($this.attr("data-available")=="true"){
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
        	    			changeImgVer();
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
	//注册提交
	$(".logion-btn").on("click",function(){
		var $this=$(this);
		//检查手机号是否存在
		if(mobileBlur()&&verificationBlur()&&passwordBlur()&&invitingMobileBlur()){
			var length=$(".disread").length;
			if(length==0){
				if($this.attr("data-available")=="true"){
					$this.attr("data-available",false);
					var invitingMobile = $.trim($invitingMobile.val());
					$.post(root+"/service/wapRegister/wapRegister",{
						"mobile":$.trim($mobile.val()),
						"passd":$.trim($password.val()),
						"verification":$.trim($verification.val()),
						"friendMobile":invitingMobile,
					},function(data){
						if(data.retCode){
	                    	$.post(root+"/service/login/userLogin",{
	                            "puMobile":$.trim($mobile.val()),
	                            "puPassword":$.trim($password.val())
	                        },function(data){
	                        	if(data.retCode){
	                        		window.location.href=root+"/service/wapIndex/toWapIndex";
	                        	}else{
	                        		window.location.href=root+"/service/wapLogin/toWapLogin";
	                        	}
	                        });
	                    }else{
	                        if(data.type == 'mobile'){
	                        	resultVer({"success":data.retCode,"msg":data.retMsg},$mobile);
	                        }else if(data.type == 'password'){
	                        	resultVer({"success":data.retCode,"msg":data.retMsg},$passwordSub);
	                        }else if(data.type == 'friend'){
	                        	resultVer({"success":data.retCode,"msg":data.retMsg},$friendMobile);
	                        }else if(data.type == 'valdatecode'){
	                        	resultVer({"success":data.retCode,"msg":data.retMsg},$verification);
	                        }else{
	                        	$("#yqrsjhErr").html(data.retMsg);
	                        }
	                        $this.attr("data-available",true);
	                        return false;
	                    }
					});
				}
			}else{
				$("#yqrsjhErr").html("请你认真阅读并同意《佰宝金服注册协议》");
				return false;
			}
		}
	});
	//控制同意协议复选框事件
	$("#isAgree").on("click",function(){
		if($(this).hasClass("disread")){
			$(this).removeClass("disread").addClass("isread");
		}else{
			$(this).removeClass("isread").addClass("disread");
		}
	});
	//佰宝金服协议
	$("#agreement").on("click",function(){
		window.location.href=root+"/service/wapRegister/registerAgreement";
	});
	//登录
	$("#login").on("click",function(){
		window.location.href=root+"/service/wapLogin/toWapLogin";
	});
});