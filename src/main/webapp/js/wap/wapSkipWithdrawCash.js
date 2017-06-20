$(function(){
	var $availablemoney=$("#availablemoney"),
		$money=$("#money"),
		$transPass=$("#transPass"),
		$logion_btn = $(".logion-btn"),
		result={};
	//绑定事件
	$money.on("input",function(){domInputFloatEvent($money);});
	$money.on("blur",moneyBlur);
	$transPass.on("blur",transPassBlur);
	//处理事件
	function moneyBlur(){
		result=withdrawalsMoneyFormat($money);
    	var temp=resultVer(result,$money);
    	return temp;
	};
	function transPassBlur(){
		result=tradingPasswordFormat($transPass);
    	var temp=resultVer(result,$transPass);
    	return temp;
	};
	//处理返回
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
    //提现提交
    $logion_btn.on("click",function(){
        var bankNum=$(".bank-num").html();
        if(!bankNum){
            $("#moneyErr").html("请先绑定银行卡");
            return false;
        }
        if(moneyBlur()){
        	availableMoneyValue= parseFloat($.trim($("#availablemoney").val()));//可用提现金额
            withdrawalsMoney=parseFloat($.trim($money.val()));//提现金额
            if(!availableMoneyValue){
        		resultVer({"success":false,"msg":"无可用提现余额"},$money);
        		return false;
        	}
            if(availableMoneyValue<withdrawalsMoney){
                resultVer({"success":false,"msg":"可用余额不足"},$money);
                return false;
            }
            if($logion_btn.attr("data-available")=="true"){
            	$logion_btn.attr("data-available",false);
            	showContentLoading();
            	$.post(root+"/service/wapAccount/umpayWithdrawCash",{
                    "withdrawalsMoney":withdrawalsMoney
                },function(data){
                	closeContentLoading();
                    if(data.retCode){
                    	$("#myUrl").val(data.url);
        	    		$("#myForm").submit();
        	    		$("#tiXian").show();
                    }else{
                    	$("#moneyErr").html(data.retMsg);
                    	$logion_btn.attr("data-available",true);
                        return false;
                    }
                });
            }
        }
    });
});