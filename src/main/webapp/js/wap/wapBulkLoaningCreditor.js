$(function(){
	 var $selectType=$(".selectType"),
     $ui_banklsit=$(".ui-banklsit"),
     $ui_banklsit_li=$(".ui-banklsit li"),
     $typeTxt=$("#typeTxt"),
     $pageNo_a=$(".page-wap a"),
     uri="";
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
        var dataTemp= $.trim($(this).attr("data-type"));
        var htmlTemp= $.trim($(this).html());
        $typeTxt.val(htmlTemp);
        $ui_banklsit.slideUp(120);
        $("input[name='bulkLoanStatus']").val(dataTemp);
        $("input[name='pageNum']").val(null);
        $("#myFrom").submit();
    });
    
    function statusUrl(data){
    	switch (data) {
			case "1":
				//投资中
				uri = root+"/service/webBulkLoan/getBulkLoaningCreditor";break;
			case "2":
				//回收中
				uri = root+"/service/webBulkLoan/getCreditor";break;
			case "3":
				//已结清
				uri = root+"/service/webBulkLoan/getRepaidCreditor";break;
			default:
				break;
		}
    }
    
    $(".page-wap a").on("click",function(){
    	if(!$(this).hasClass("notUse")){
    		var bulkLoanStatus = $("#bulkLoanStatus").val();
        	var pageNum = $(this).attr("data-pageno");
        	$("input[name='bulkLoanStatus']").val(bulkLoanStatus);
            $("input[name='pageNum']").val(pageNum);
            $("#myFrom").submit();
    	};
    });
    
    //回款计划单机事件
    $(".hkjh-a").on("click",function(){
    	var tenderFlowNo = $(this).data("one");
    	var pp_loanTitle = $(this).data("two");
    	$("input[name='tenderFlowNo']").val(tenderFlowNo);
    	$("input[name='pp_loanTitle']").val(pp_loanTitle);
    	$("#myFromTwo").submit();
    });
    
    //查看合同点击事件
    $(".ckht-a").on("click",function() {
    	var tenderflowNo = $(this).data("one");
    	showContentLoading();
    	$.post(root+"/service/wapBulkLoan/ajaxGetUrl",{
    		"tenderflowNo":tenderflowNo
		},function(data){
			closeContentLoading();
    		if(data){
    			window.location.href=data;
    		}else{
    			myShow("暂无生成合同，请稍后再试！");
    			return false;
    		}
    	});
    });
});