$(function(){
	/*$(".content img").on("load",function(){
		autoController();
	});
	$(window).resize(function() {
		setTimeout(autoController, 10);
	});*/
	$("#ljzc-btn").on("click",function(){
		window.location.href=root+"/service/wapRegister/toWapRegister";
	});
	$("#msyhy-btn").on("click",function(){
		window.location.href=root+"/service/wapActivity/wapInviteFriends";
	});
});