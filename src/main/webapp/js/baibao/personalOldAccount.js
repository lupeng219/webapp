$(function(){
	$(".oldtx-btn").on("click",function(){
		window.location.href=root+"/service/asset/skipWithdrawCash";
	});
	
	  $('.op-fenlei').on('click','li',function(){
		  if($(this)[0].className.indexOf("ui-title")>=0){
			  return false;
		  }
		  if($(this)[0].className.indexOf("changeValue")>=0){
			  $("#complete").attr("value",1);
			  $("#fail").attr("value",0);
		  }else{
			  $("#complete").attr("value",0);
			  $("#fail").attr("value",1);
		  }
		  $(this).addClass('current').siblings('li').removeClass('current');
		  var startTime ="";
		  var endTime ="";
		  searchRecord(startTime,endTime);
	    });	
	    
	     $("#searchOldRecord").on("click",function(){
		 searchRecord();
	 });
	     
 	function searchRecord(st,et){
		 var transType=$(".transType").find(".current a").attr("value");
		 var transStatus =$(".transStatus").find(".current a").attr("value");
		 var startTime =$("#startTime").val();
		 var endTime =$("#endTime").val();
		   if(null!=startTime&&startTime!=""&&null!=endTime&&endTime!=""){
	           if(startTime>endTime){
	               alert("结束时间不能早于开始时间！");
	               return false;
	           }
	       }
		   
		   if(null!=st&&st!=""&&null!=et&&et!=""){
			   startTime =st;
			   endTime=et;
	       }
		   showContentLoading();
		   $.post(root+"/service/asset/ajaxPageTransRecord",{
		         "transType": transType,
		         "transStatus": transStatus,
		         "startTime":startTime,
		         "endTime":endTime,
		         "currentPageNo": 1
		     },function(data){
		    	 closeContentLoading();
		         $("#personalOldAccount").html("").html(data);
	        });
		   
	}
});
