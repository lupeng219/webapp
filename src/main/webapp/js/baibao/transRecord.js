/**
 * Created by chen on 2015/10/28.
 */
$(function(){
	  $('.op-fenlei').on('click','li',function(){
	  
		  if($(this)[0].className.indexOf("ui-title")>=0){
			  return false;
		  }
		  
		  $(this).addClass('current').siblings('li').removeClass('current');
		  
		  var startTime ="";
		  var endTime ="";
		  var time =$('.find-ui').find(".current").attr("id");
		  if(time=="today"){
			  startTime =CurentDate()+" 00:00:00";
			  endTime =CurentTime();
		  }else if(time=="oneMonth"){
			  startTime =getLastMonth();
			  endTime =CurentTime();
		  }else if(time=="threeMonth"){
			  startTime =getLastThreeMonth();
			  endTime =CurentTime();
		  }else if(time=="oneYear"){
			  startTime =getLastYear();
			  endTime =CurentTime();
		  }
		  searchRecord(startTime,endTime);
	    });
	  $('.find-ui').on('click','li',function(){
		  $(this).addClass('current').siblings('li').removeClass('current');
	  });
	  
	 $("#searchRecord").on("click",function(){
		 $('.find-ui').find(".current").removeClass('current');
		 searchRecord();
	 });
	 
	 $("#today").on("click",function(){
		var endTime =CurentTime();
		var startTime =CurentDate()+" 00:00:00";
		$("#startTime").val("");
		$("#endTime").val("");
		searchRecord(startTime,endTime);
		
	 });
	 
	 $("#oneMonth").on("click",function(){
			var endTime =CurentTime();
			var startTime =getLastMonth();
			$("#startTime").val("");
			$("#endTime").val("");
			searchRecord(startTime,endTime);
		 });
	 
	 $("#threeMonth").on("click",function(){
			var endTime =CurentTime();
			var startTime =getLastThreeMonth();
			$("#startTime").val("");
			$("#endTime").val("");
			searchRecord(startTime,endTime);
		 });
	 $("#oneYear").on("click",function(){
			var endTime =CurentTime();
			var startTime =getLastYear();
			$("#startTime").val("");
			$("#endTime").val("");
			searchRecord(startTime,endTime);
		 });
	 
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
			   $.post(root+"/service/transRecord/ajaxPageTransRecord",{
			         "transType": transType,
			         "transStatus": transStatus,
			         "startTime":startTime,
			         "endTime":endTime,
			         "currentPageNo": 1
			     },function(data){
			    	 closeContentLoading();
			         $("#transRecord").html("").html(data);
		        });
			   
		}
		
		function CurentTime()
		   { 
		       var now = new Date();
		       var year = now.getFullYear();       //年
		       var month = now.getMonth() + 1;     //月
		       var day = now.getDate();            //日
		       var hh = now.getHours();            //时
		       var mm = now.getMinutes();          //分
		       var ss =now.getSeconds();     //获取当前秒数(0-59)
		       var clock = year + "-";
		      
		       if(month < 10)
		           clock += "0";
		      
		       clock += month + "-";
		      
		       if(day < 10)
		           clock += "0";
		          
		       clock += day + " ";
		      
		       if(hh < 10)
		           clock += "0";
		          
		       clock += hh + ":";
		       if (mm < 10) clock += '0'; 
		       clock += mm +":"; 
		       if(ss<10)  clock+='0'
		       clock += ss 
		       return(clock); 
		   } 
		
		function CurentDate()
		   { 
		       var now = new Date();
		       var year = now.getFullYear();       //年
		       var month = now.getMonth() + 1;     //月
		       var day = now.getDate();            //日
		       var clock = year + "-";
		       if(month < 10)
		           clock += "0";
		       clock += month + "-";
		       if(day < 10)
		           clock += "0";
		       clock += day + " ";
		       return(clock); 
		   } 
		
		
		//获得上个月这一天的日期
		 function getLastMonth(){
			 var date = new Date();
		    var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);
			 var strYear = date.getFullYear();  
			 var strDay = date.getDate();  
			 var strMonth = date.getMonth()+1;
			 var hh = date.getHours();            //时
		    var mm = date.getMinutes();
		    var ss = date.getSeconds();
		    
			 if(strYear%4 == 0 && strYear%100 != 0){
				daysInMonth[2] = 29;
			 }
			 if(strMonth - 1 == 0)
			 {
				strYear -= 1;
				strMonth = 12;
			 }
			 else
			 {
				strMonth -= 1;
			 }
		    strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];
			 if(strMonth<10)  
			 {  
				strMonth="0"+strMonth;  
			 }
			 if(strDay<10)  
			 {  
				strDay="0"+strDay;  
			 }
			 strDay+=" "
			 if(hh < 10)
				 strDay += "0";
			 strDay +=hh + ":";
		       if (mm < 10) strDay += '0'; 
		       strDay += mm+":";
		       if(ss<10)   strDay =+'0'
		       strDay += ss;
			 datastr = strYear+"-"+strMonth+"-"+strDay;
			 return datastr;
		 }
		 
			 //获得上三个月这一天的日期
		 function getLastThreeMonth(){
			 var date = new Date();
		    var daysInMonth = new Array([0],[31],[28],[31],[30],[31],[30],[31],[31],[30],[31],[30],[31]);
			 var strYear = date.getFullYear();  
			 var strDay = date.getDate();  
			 var strMonth = date.getMonth()+1;
			 var hh = date.getHours();            //时
		    var mm = date.getMinutes();
		    var ss = date.getSeconds();
		    
			 if(strYear%4 == 0 && strYear%100 != 0){
				daysInMonth[2] = 29;
			 }
			 if(strMonth - 3 == 0)
			 {
				strYear -= 1;
				strMonth = 12;
			 }
			 else
			 {
				strMonth -= 3;
			 }
		    strDay = daysInMonth[strMonth] >= strDay ? strDay : daysInMonth[strMonth];
			 if(strMonth<10)  
			 {  
				strMonth="0"+strMonth;  
			 }
			 if(strDay<10)  
			 {  
				strDay="0"+strDay;  
			 }
			 strDay+=" "
			 if(hh < 10)
				 strDay += "0";
			 strDay +=hh + ":";
		       if (mm < 10) strDay += '0'; 
		       strDay += mm+":";
		       if(ss<10)   strDay =+'0'
		       strDay += ss;
			 datastr = strYear+"-"+strMonth+"-"+strDay;
			 return datastr;
		 }
		 
		 
		 function getLastYear(){
			     var date = new Date();
			     var strYear = date.getFullYear() - 1;    
			     var strDay = date.getDate();    
			     var strMonth = date.getMonth()+1;
			     var hh = date.getHours();            //时
			     var mm = date.getMinutes();
			     var ss = date.getSeconds();
			     if(strMonth<10)    
			     {    
			        strMonth="0"+strMonth;    
			     }  
			     if(strDay<10)    
			     {    
			        strDay="0"+strDay;    
			     }
			     strDay+=" "
					 if(hh < 10)
						 strDay += "0";
					 strDay +=hh + ":";
				        if (mm < 10) strDay += '0'; 
				        strDay += mm+":";
				        if(ss<10)   strDay =+'0'
				        strDay += ss;
					 datastr = strYear+"-"+strMonth+"-"+strDay;
			     datastr = strYear+"-"+strMonth+"-"+strDay;  
			     return datastr;  
			  }  
