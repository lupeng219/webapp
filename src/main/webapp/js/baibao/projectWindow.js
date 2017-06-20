$(".alert-close,.alert-cancel").on("click",function(){
	$(".projectWindowBg").hide();
	$(this).closest(".alert-con").hide();
	$(this).closest(".alert-con").find(".btn-primary").attr("data-available",true);
	if($(this).closest(".alert-con").find("input").length!=0){
		$(this).closest(".alert-con").find("input").val("");
	}
	if($(this).closest(".alert-con").find("select").length!=0){
		$(this).closest(".alert-con").find("select").val("");
	}
	if($(this).closest(".alert-con").find(".alert-err-tip").length!=0){
		$(this).closest(".alert-con").find(".alert-err-tip").html("");
	}
	if($(this).closest(".alert-con").find(".txtpwd").length!=0){
		$(this).closest(".alert-con").find(".txtpwd").removeClass("txt-err");
	}
});
function showProdectWindow(){
	$(".projectWindowBg").show();
	$(".alert-con").show();
};
function hideProdectWindow(){
	$(".projectWindowBg").hide();
	$(".alert-con").hide();
};
function showContentLoading(){
	$("#contentLoading").show();
};
function closeContentLoading(){
	$("#contentLoading").hide();
};
 var alertHgh=$("#tenderBox").height(),alertWth=$("#tenderBox").width();
    var screenWidth = $(window).width(), screenHeigth = $(window).height();
    var Wth=screenWidth-alertWth,Hgh=screenHeigth-alertHgh;

    $("#tenderBox").css({
        "top":Hgh/2+"px",
        "left":Wth/2+"px"
    })
