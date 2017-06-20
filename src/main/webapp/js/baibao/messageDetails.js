$(function(){
	//单选
	$(".checkSpan").on("click",function(){
		if($(this).hasClass("checkSpanOn")){
			$(this).removeClass("checkSpanOn");
		}else{
			$(this).addClass("checkSpanOn");
		}
	});
	//全选
	$("#checkAll").click(function(){
		if($(this).hasClass("checkAllOn")){
			$(this).removeClass("checkAllOn");
			$(".checkSpan").removeClass("checkSpanOn");
		}else{
			$(this).addClass("checkAllOn");
			$(".checkSpan").addClass("checkSpanOn");
		}
	});
	//删除
	$("#deleteMsg").on("click",function(){
		var msg=[],list=$(".checkSpanOn");
      	if(list.length==0){
      		return;
      	}
      	for(var i=0;i<list.length;i++) {
  	 		msg.push($(list[i]).data('value'));
      	}
      	var msgs = msg.join(",");
      	$.post(root+"/service/message/deleteMsg",{
      		"msgIds":msgs
  		},function(data){
    		if(data.retCode){
    			window.location.reload();
    		}else{
    			alert(data.retMsg,function(){
    				window.location.reload();
    			});
    			return false;
    		}
  		});
	});
});