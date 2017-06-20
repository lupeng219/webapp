$(function(){
	init();
	function init(){
		var first=session.get("msgFirst");
		if(first=="true"){
			session.set("msgFirst",false);
			window.location.reload();
		}
	};
	//查看消息详情
	$(".sub span").on("click",function(){
		var value=$(this).closest(".sub").find("input").val();
		window.location.href=root+"/service/wapMessages/wapMsgDetails?msgIds="+value;
	});
	//编辑
	$(".bianji").on("click",function(){
		$(this).hide();
		$(".quxiao").show();
		$(".sub input").show();
		$(".bottons").show();
	});
	//取消
	$(".quxiao").on("click",function(){
		$(this).hide();
		$(".bianji").show();
		$(".sub input").hide();
		$(".bottons").hide();
		$(".sub input").attr("checked",false);
	});
	//设为已读
	$("#toRead").on("click",function(){
		if($(".sub input:checked").length!=0){
			var temp="";
			$(".sub input:checked").each(function(){
				temp+=$(this).val()+",";
			});
			if(temp){
				temp=temp.substring(0, temp.length-1);
			}
			showContentLoading();
			$.post(root+"/service/wapMessages/wapReadMsg",{
				"msgIds":temp
			},function(data){
				closeContentLoading();
				if(data.retCode){
					window.location.reload();
				}else{
					myShow(data.retMsg);
					return false;
				}
			});
		}else{
			myShow("未选中任何记录！");
			return false;
		}
	});
	//删除
	$("#toDelete").on("click",function(){
		if($(".sub input:checked").length!=0){
			var temp="";
			$(".sub input:checked").each(function(){
				temp+=$(this).val()+",";
			});
			if(temp){
				temp=temp.substring(0, temp.length-1);
			}
			showContentLoading();
			$.post(root+"/service/wapMessages/wapDeleteMsg",{
				"msgIds":temp
			},function(data){
				closeContentLoading();
				if(data.retCode){
					window.location.reload();
				}else{
					myShow(data.retMsg);
					return false;
				}
			});
		}else{
			myShow("未选中任何记录！");
			return false;
		}
	});
	//分页查询
	$(".page-wap a").on("click",function(){
		if($(this).hasClass("notUse")){
			return false;
		}
		var currentPageNo=$(this).data("pageno");
		window.location.href=root+"/service/wapMessages/wapFindmsg?currentPageNo="+currentPageNo;
	});
});