$(function(){
	var $withdrawalsMoney=$("#withdrawalsMoney"),
		$withdrawalsSubmit=$("#withdrawalsSubmit"),
		result={};
	//绑定事件
	$withdrawalsMoney.on("input",function(){domInputFloatEvent($withdrawalsMoney);});
	$withdrawalsMoney.on("blur",withdrawalsMoneyBlur);
	//处理事件
	function withdrawalsMoneyBlur(){
		result=withdrawalsMoneyFormat($withdrawalsMoney);
        var temp=resultVer(result,$withdrawalsMoney);
        return temp;
	};
	//验证返回
	function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest("li").find(".err-p").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };
    function clearStyle(){
        $(".err-p").html("");
        $(".rech-txt").removeClass("txt-err");
    };
    //提交
    $withdrawalsSubmit.on("click",function(){
    	if(withdrawalsMoneyBlur()){
    		var availableMoney=parseFloat($("#availableMoney").val());
        	var withdrawalsMoney=parseFloat($withdrawalsMoney.val());
        	if(!availableMoney){
        		$("#withdrawalsMoneyErr").html("无可用提现余额");
        		return false;
        	}
        	if(withdrawalsMoney>availableMoney){
        		$("#withdrawalsMoneyErr").html("提现余额大于可用余额");
        		return false;
        	}
        	if($withdrawalsSubmit.attr("data-available")=="true"){
        		showContentLoading();
            	$.ajax({
            		type:'POST',
            	    async:false,
            	    url:root+"/service/asset/umpayWithdrawCash",
            	    data:{
            	    	"withdrawalsMoney":withdrawalsMoney
                    },
            	    dataType:'json',
            	    error:function(data){
            	    	closeContentLoading();
            	    	alert(data.statusText);
            	    	$withdrawalsSubmit.attr("data-available",true);
            	    	return false;
            	    },
            	    success:function(data){
            	    	closeContentLoading();
            	    	if(data.retCode){
            	    		showWithdrawalsModel();
            	    		$("#myUrl").val(data.url);
            	    		$("#myForm").submit();
                		}else{
                			$("#resultErr").html(data.retMsg);
                			$withdrawalsSubmit.attr("data-available",true);
                			return false;
                		}
            	    }
            	});
        	}
    	}
    });
    //显示联动提现遮罩
    function showWithdrawalsModel(){
    	$(".projectWindowBg").show();
    	$("#withdrawalsModel").show();
    };
    function hideProdectWindow(){
    	
    };
    $("#withdrawalsSuccess").on("click",function(){
    	window.location.href=root+"/service/asset/switcholdaccount";
    });
    $("#withdrawalsError").on("click",function(){
    	hideProdectWindow();
    	alert("提现未成功，请稍后再试！",function(){
    		window.location.reload();
    	});
    });
});