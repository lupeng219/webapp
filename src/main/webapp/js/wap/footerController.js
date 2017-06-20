function autoController(){
	$("#wap-footer").css("margin-top","16px");
	var clientHeight=document.documentElement.clientHeight,
		contentHeight=$(".wrap").outerHeight(true);
	if(clientHeight>contentHeight){
		$("#wap-footer").css("margin-top",(clientHeight-contentHeight+16)+"px");
	}
};
autoController();
$(window).resize(function() {
	setTimeout(autoController(), 0);
});