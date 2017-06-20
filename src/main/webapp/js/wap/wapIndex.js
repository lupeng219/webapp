$(function(){
	$(".wapsum-1").on("click",function(){
		window.location.href=root+"/service/wapBulkLoan/ProductListByType?type="+1;
	});
	$(".wapsum-2").on("click",function(){
		var type = $(this).find("#type").val();
		var bulkLoanNumber = $(this).find("#bulkLoanNumber").val();
		//window.location.href=root+"/service/webBulkLoan/getDetails?bulkLoanNumber="+bulkLoanNumber+"&type="+type;
	});
});