$(function(){
	var $mobile=$("#mobile"),
		$imgVer=$("#imgVer"),
		$verification=$("#verification"),
		$hqyzm_btn=$(".hqyzm-btn"),
		$logion_btn=$(".logion-btn"),
		result={};
	//绑定事件
	$mobile.on("input", function(){domInputIntEvent($mobile);});
	$mobile.on("blur",mobileBlur);
	$imgVer.on("blur", imgVerBlur);
	$verification.on("blur",verificationBlur);
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
        	    	if(data.retCode){
            			resultVer({"success":false,"msg":"该手机号不存在"},$mobile);
            			temp=false;
            		}else{
            			temp=true;
            		}
        	    	
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
	//获取验证码
	$hqyzm_btn.on("click",function(){
		if(mobileBlur()&&imgVerBlur()){
			if($hqyzm_btn.attr("data-available")=="true"){
				$hqyzm_btn.attr("data-available",false);
				$.post(root+"/service/wapLogin/getPhoneVar", {
		            'mobile':$.trim($mobile.val()),
		            'imgVer':$.trim($imgVer.val())
		        }, function(data) {
		            if (data.retCode) {
		            	getMobileVerFormat($hqyzm_btn);
		            }else{
		            	$("#verificationErr").html(data.retMsg);
		            	$hqyzm_btn.attr("data-available",true);
		            	return false;
		            }
		        });
			}else{
				return false;
			}
		}else{
			return false;
		}
	});
	//下一步按钮提交事件--到设置交易密码
	$logion_btn.on("click",function(){
		if(mobileBlur()&&imgVerBlur()&&verificationBlur()){
			if($logion_btn.attr("data-available")=="true"){
				$logion_btn.attr("data-available",false);
				var postData = {
					"userMobile":$.trim($mobile.val()),
					"imgVer":$.trim($imgVer.val()),
					"validateCode":$.trim($verification.val())
				};
				$.post(root+"/service/wapLogin/testingverifyCode",postData,function(data){
					if(data.retCode){
						window.location.href = root+"/service/wapLogin/wapFindPassWordTwo";
					}else{
						$("#verificationErr").html(data.msg);
						$logion_btn.attr("data-available",true);
						return false;
					}
				});
			}else{
				return false;
			}
		}else{
			return false;
		}
	});
});