$(function(){
	$("#Personout").on("click",function(){
		myConfirm("您确定要退出吗?",function(){
 			location.href = root +"/service/login/logout";
 		},function(){
 			return false;
 		});
	});
});