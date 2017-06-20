$(function(){
	var first=true;
	$(".tabList .tab").on("click",function(){
		if($(this).hasClass("active")){
			return false;
		}
		$(this).addClass("active");
		$(this).siblings().removeClass("active");
		var mode=$(this).data("mode"),
			length=$(".tabList .tab").length;
		for(var i=1;i<=length;i++){
			if(i==mode){
				$("#mode"+i).show();
			}else{
				$("#mode"+i).hide();
			}
		}
		autoController();
	});
});