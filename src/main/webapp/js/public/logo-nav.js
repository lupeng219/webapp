/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */

var isFirstOpen=true;
window.onscroll = function(){
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    var top_div = document.getElementById( "main-nav" );
    if(top_div){
    	if( t >= 300) {
            if(isFirstOpen){
            	$("body").css("padding-top","75px");
            	top_div.style.position = "fixed";
                top_div.style.boxShadow = "0 0 11px rgba(0,0,0,.22)";
                $(top_div).hide();
                $(top_div).slideDown();
                isFirstOpen=!isFirstOpen;
            }
        } else {
        	$("body").css("padding-top","0px");
        	top_div.style.position = "relative";
            top_div.style.boxShadow = "none";
            isFirstOpen=true;
        }
    }
};
