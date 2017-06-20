$(function(){
	var provinceList=[],cityList=[];
	//初始化
	init();
	function init(){
		provinceList=get_province_array();
		var str="";
		for(var i=0;i<provinceList.length;i++){
			str+='<li>'+provinceList[i]+'</li>';
		}
		$("#province-list").html(str);
	};
	//下拉效果
	$("#down-province,#sel-province").on("click",function(){
        $("#province-list").slideToggle(200);
    });
    $("#down-city,#sel-city").on("click",function(){
    	var sel_province=$.trim($("#sel-province").val());
    	if(sel_province){
    		$("#city-list").slideToggle(200);
    	}else{
    		$("#province-list").slideToggle(200);
    	}
    });
    $("#province-list").on("click","li",function(){
    	var valueTemp=$.trim($(this).html());
    	$("#sel-province").val(valueTemp);
    	$("#sel-city").val("");
    	$("#province-list").slideUp(200);
    	if(valueTemp){
    		cityList=get_city_array(valueTemp);
    		var str="";
    		for(var i=0;i<cityList.length;i++){
    			str+='<li>'+cityList[i]+'</li>';
    		}
    		$("#city-list").html(str);
    	}
    });
    $("#city-list").on("click","li",function(){
    	 var valueTemp=$.trim($(this).html());
    	 $("#sel-city").val(valueTemp);
    	 $("#city-list").slideUp(200);
    });
    //关闭下拉
    $(document).on("click",function(event){
        var obj = event.srcElement ? event.srcElement : event.target;
        //关闭省份
        if(obj.parentNode.id!="province-list"&&obj.id!="sel-province"&&obj.id!="down-province"&&obj.id!="sel-city"&&obj.id!="down-city"){
        	$("#province-list").slideUp(200);
        }
        //关闭城市
        if(obj.parentNode.id!="city-list"&&obj.id!="sel-city"&&obj.id!="down-city"){
       	 $("#city-list").slideUp(200);
        }
    });
});