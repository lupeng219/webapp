$(function(){
    $(".position").on("click",function(){
    	$(this).closest("li").siblings().find(".zxns_desc").slideUp(200);
    	$(this).closest("li").find(".zxns_desc").slideToggle(200);
    });
});

