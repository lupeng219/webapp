$(function(){
	var $realName=$("#realName"),$idCard=$("#idCard"),$logion_btn=$(".logion-btn"),result={};
	//绑定事件
	$realName.on("blur",realNameBlur);
	$idCard.on("blur",idCardBlur);
    //处理事件
    function realNameBlur(){
        result=realNameFormat($("#realName"));
        var temp=resultVer(result,$("#realName"));
        return temp;
    };
    function idCardBlur(){
        result=idCardFormat($("#idCard"));
        var temp=resultVer(result,$("#idCard"));
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
	//提交
    $logion_btn.on("click",function(){
    	if(realNameBlur()&&idCardBlur()){
    		if($logion_btn.attr("data-available")=="true"){
    			$logion_btn.attr("data-available",false);
    			$.post(root+"/service/certification/certificationOperation",{
                    "realName":$.trim($realName.val()),
                    "idCard":$.trim($idCard.val()),
                    "channel":"3"
                },function(data){
                    if(data.retCode){
						myShow("认证成功",function(){
							location.href=root+"/service/wapAccount/wapAccountIndex";
						});
                    }else{
                        $("#idCardErr").html(data.retMsg);
                        $logion_btn.attr("data-available",true);
                        return false;
                    }
                });
    		}
    	}
    });
});