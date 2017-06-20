$(function(){
	//tab切换
	$(".tabList .tab").on("click",function(){
		var $this=$(this);
		if($this.hasClass("active")){
			return false;
		}
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
		var modal=$(this).data("modal"),
			length=$(".tabList .tab").length;
		for(var i=1;i<=length;i++){
			if(i==modal){
				$("#modal"+i).show();
			}else{
				$("#modal"+i).hide();
			}
		}
		autoController();
	});
	//*********************************************************快捷充值*****************************************************
	var $money=$("#money"),
		$transPass=$("#transPass"),
		$verification=$("#verification"),
		$this=$(".hqyzm-btn"),
		$hqyzm_btn=$(".hqyzm-btn"),
		$logion_btn=$(".logion-btn"),
		result={};
	//绑定事件
	$money.on("input",function(){domInputFloatEvent($money);});
	$money.on("blur",moneyBlur);
	$transPass.on("blur",transPassBlur);
	$verification.on("blur",verificationBlur);
	//处理事件
	function moneyBlur(){
		result=rechargeMoneyFormat($money);
        var temp=resultVer(result,$money);
        if(temp){
        	var moneyTemp=$.trim($money.val());
        	var singlelimit="";
        	if($("#singleLimit")){
        		singlelimit=$.trim($("#singleLimit").val());
        	}
        	if(parseFloat(moneyTemp)>parseFloat(singlelimit)){
        		resultVer({"success":false,"msg":"充值金额大于银行卡快捷充值单笔限额"},$money);
        		temp=false;
        	}
        }
        return temp;
	};
	function transPassBlur(){
        result=tradingPasswordFormat($transPass);
        var temp=resultVer(result,$transPass);
        return temp;
	};
	function verificationBlur(){
		result=mobileVerFormat($verification);
    	var temp=resultVer(result,$verification);
    	return temp;
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
    //提交充值-----获取验证码
    $hqyzm_btn.on("click",function(){
    	if(moneyBlur()&&transPassBlur()){
    		if($hqyzm_btn.attr("data-available")=="true"){
    			$hqyzm_btn.attr("data-available",false);
    			showContentLoading();
    			$.post(root+"/service/account/bindingRecharge",{
        			"amount":$.trim($money.val()),
        			"payPassword":encryption($transPass.val()),
        			"registType":"3"
        		},function(data){
        			closeContentLoading();
        			if(data.retCode){
        				getMobileVerFormat($this);
        				$("#transFlowNo").val(data.transFlowNo);
        			}else{
        				resultVer({"success":data.retCode,"msg":data.retMsg},$verification);
        				$hqyzm_btn.attr("data-available",true);
        				return false;
        			}
        		});
    		}
    	}
    });
    //充值推进
    $logion_btn.on("click",function(){
    	if(moneyBlur()&&transPassBlur()&&verificationBlur()){
    		if($logion_btn.attr("data-available")=="true"){
    			$logion_btn.attr("data-available",false);
    			showContentLoading();
    			$.post(root+"/service/account/advanceHostingPay",{
                	"validateCode":$.trim($verification.val()),
                	"transFlowNo":$.trim($("#transFlowNo").val()),
                	"amount":$.trim($money.val()),
                	"registType":"3"
                },function(data){
                	closeContentLoading();
                    if(data.retCode){
                    	myShow(data.retMsg,function(){
                    		window.location.href=root+"/service/wapAccount/wapAccountIndex";
                    	});
                    }else{
                    	resultVer({"success":data.retCode,"msg":data.retMsg},$verification);
                        $this.attr("data-available",true);
                        return false;
                    }
                });
    		}
    	}
    });
    
	 //*********************************************************网银充值*****************************************************
	 var $selectBank=$(".selectBank"),
	    $ui_banklsit=$("#ui-banklsit"),
	    $ui_banklsit_li=$ui_banklsit.find("li"),
	    $bankTxtOnline=$("#bankTxt-online"),
	    $moneyOnline=$("#money-online"),
	    $logionBtnOnline=$(".logion-btn-online");
	 $selectBank.on("click",function(){
	        $ui_banklsit.slideToggle(120);
	 });
	 //隐藏ul
     $(document).on("click",function(event){
	     var obj = event.srcElement ? event.srcElement : event.target;
	     if(obj.parentNode.id!="ui-banklsit"&&obj.id!="bankTxt-online"&&obj.id!="bankEm"){
	    	 $ui_banklsit.slideUp(120);
         }
     });
     $ui_banklsit_li.on("click",function(){
         var dataTemp= $.trim($(this).data("bank")),
         	 htmlTemp= $.trim($(this).html());
         $bankTxtOnline.val(htmlTemp).attr("data-bank",dataTemp);
	     $ui_banklsit.slideUp(120);
     });
     //绑定
     $bankTxtOnline.on("change",selectBankChange);
     $moneyOnline.on("blur",moneyOnlineBlur);
     function selectBankChange(){
    	 result=selectBankFormat($bankTxtOnline);
         var temp=resultVer(result,$bankTxtOnline);
         return temp;
     };
     function moneyOnlineBlur(){
    	 result=rechargeMoneyFormat($moneyOnline);
         var temp=resultVer(result,$moneyOnline);
         if(temp){
         	var moneyTemp=$.trim($moneyOnline.val());
         	if(parseFloat(moneyTemp)<=0){
         		resultVer({"success":false,"msg":"充值金额错误"},$moneyOnline);
         		temp=false;
         	}
         	if(parseFloat(moneyTemp)>2000){
         		resultVer({"success":false,"msg":"充值金额不能大于2000元"},$moneyOnline);
         		temp=false;
         	}
         }
         return temp;
     };
     //网银充值
     $logionBtnOnline.on("click",function(){
     	if(moneyOnlineBlur()){
     		var amount = $.trim($moneyOnline.val());
     		window.location.href=root+'/service/account/wapOnlineBankRecharge?amount='+amount;
     		/*
     		if($logionBtnOnline.attr("data-available")=="true"){
     			$logionBtnOnline.attr("data-available",false);
     			showContentLoading();
     			$.ajax({
                	url:root+'/service/account/wapOnlineBankRecharge',
                	type:'post',
                	async:false,//使用同步的方式,true为异步方式
                	data:{
                		"bankOnline":$.trim($bankTxtOnline.data("bank")),
                     	"amount":$.trim($moneyOnline.val())
                 	},
                	dataType:'json',
                	success:function(data){
                		closeContentLoading();
                		if(data.retCode){
//                			showOnlineRechargeModel();
//                			$("#myBankCode").val(bankCode);
//                			$("#myAmount").val(amount);
//                			$("#myForm").submit();
                			$logionBtnOnline.attr("data-available",true);
                		}else{
                			myShow('充值失败');
                			$logionBtnOnline.attr("data-available",true);
                			return false;
                		}
                	},
                	error:function(){
                		closeContentLoading();
                		myShow('充值失败');
                		$logionBtnOnline.attr("data-available",true);
                		return false;
                	}
                });
     		}
     	*/}
     });
});