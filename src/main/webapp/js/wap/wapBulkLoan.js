$(function(){
	//设置进度
	jinduline();
	function jinduline(){
		$.each($(".list-jinduline"),function(i,n){
			var html =  $(n).find("input[name='jindu']").val();
			if(html=='' || html==null){
				html=0;
			}
			if(html>=100){
				html=100;
			}
			$(n).attr("style","width:"+html+"%");
		});
		
	}
	 var $selectType=$(".selectType"),
     $ui_banklsit=$(".ui-banklsit"),
     $ui_banklsit_li=$(".ui-banklsit li"),
     $typeTxt=$("#typeTxt"),
     $pageNo_a=$(".page-wap a"),
     uri="";
	 
	 $("#typeEm").on("click",function(){
	        $ui_banklsit.slideToggle(120);
	 });
	 $selectType.on("click",function(){
	        $ui_banklsit.slideToggle(120);
	 });
	//隐藏ul
    $(document).on("click",function(event){
        var obj = event.srcElement ? event.srcElement : event.target;
        if(obj.parentNode.id!="ui-banklsit"&&obj.id!="typeTxt"&&obj.id!="typeEm"){
            $("#ui-banklsit").slideUp(120);
        }
    });
    
    $ui_banklsit_li.on("click",function(){
        var dataTemp= $.trim($(this).attr("data-bulkStatus"));
        var htmlTemp= $.trim($(this).html());
        $typeTxt.val(htmlTemp);
        $ui_banklsit.slideUp(120);
        $("input[name='bulkStatus']").val(dataTemp);
        $("#myFromss").submit();
    });
    
    $pageNo_a.on("click",function(){
    	if(!$(this).hasClass("notUse")){
	        var data= $.trim($(this).attr("data-pageno"));
	        if(data){
	        	$("input[name='pageNum']").val(data);
	            $("#myFromss").submit();
	        }else{
	            return false;
	        }
    	}
    });
});