$(function(){
	//实名认证
    $("#realName").on("blur",realNameBlur);
    $("#idCard").on("blur",idCardBlur);
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
    //验证返回
    function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest("li").find(".errbank-p").html(data.msg);
            element.addClass("txt-err");
            return false;
        }
    };
    //清楚错误提示
    function clearStyle(){
        $(".errbank-p").html("");
        $(".bank-txt").removeClass("txt-err");
    };
    $("#startAuthentication").on("click",function(){
    	var $this=$(this);
    	if(realNameBlur()&&idCardBlur()){
    		if($this.attr("data-available")=="true"){
    			$this.attr("data-available",false);
    			$.post(root+"/service/certification/certificationOperation",{
    				"realName":$.trim($("#realName").val()),
                    "idCard":$.trim($("#idCard").val()),
                    "channel":"1"
                },function(data){
                    if(data.retCode){
                		window.location.reload();
                    }else{
                        resultVer({"success":data.retCode,"msg":data.retMsg},$("#idCard"));
                        $this.attr("data-available",true);
                        return false;
                    }
                });
    		}
    	}else{
    		return false;
    	}
    });
});