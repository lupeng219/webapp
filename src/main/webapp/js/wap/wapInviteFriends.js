$(function(){
	$(".seckill-btn").on("click",function(){
		if(is_weixn()){
			if(is_android()){
				$("#content").hide();
				$("#iosImg").hide();
				$("#andriodImg").show();
				$(".page").show();
			}else{
				$("#content").hide();
				$("#andriodImg").hide();
				$("#iosImg").show();
				$(".page").show();
			}
		}else{
			alert("请关注微信账号'佰宝金服'或'中融佰诚'，开始邀请好友。");
			return false;
		}
	});
	
	function is_weixn(){  
	    var ua = navigator.userAgent.toLowerCase();  
	    if(ua.match(/MicroMessenger/i)=="micromessenger") {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}
	function is_android(){
		var u = navigator.userAgent, app = navigator.appVersion;
		var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Linux') > -1; //android终端或者uc浏览器
		return isAndroid;
	}
	
	//分页查询
	/*$(".page-wap a").on("click",function(){
		if($(this).hasClass("notUse")){
			return false;
		}
		var currentPageNo=$(this).data("pageno");
		window.location.href=root+"/service/wapActivity/wapInviteFriends?pageNum="+currentPageNo;
	});*/
	
	//tab进行切换
	$(".tab").on("click",function(){
		$(".tab").removeClass("active");
		$(this).addClass("active");
		var mode = $(this).data("mode");
		if(mode==1){
			$(".friends").show();
			$(".investments").hide();
			//===========start=============
			var params = {"pageNum":1};
			$.ajax({
		        type:"POST",
		        url:root+"/service/wapActivity/ajaxInviteFriends?refresh="+new Date().getTime(),
		        data:params,
		        datatype:"html",
		        beforeSend:function(){//$("#msg").html("logining");
		        },
		        success:function(data){
		        	$(".friends").html(data);
		        },
		        complete:function(XMLHttpRequest, textStatus){
		           //alert(XMLHttpRequest.responseText);
		           //alert(textStatus);
		          $(".friends").html(XMLHttpRequest.responseText);
		        },
		        error:function(){
		        	
		        }         
		    });
			//==========end================
		}else if(mode==2){
			$(".investments").show();
			$(".friends").hide();
			//===========start=============
			var params = {"pageNum":1};
			$.ajax({
		        type:"POST",
		        url:root+"/service/wapActivity/ajaxRecomTender?refresh="+new Date().getTime(),
		        data:params,
		        datatype:"html",
		        beforeSend:function(){//$("#msg").html("logining");
		        },
		        success:function(data){
		        	$(".investments").html(data);
		        },
		        complete:function(XMLHttpRequest, textStatus){
		           //alert(XMLHttpRequest.responseText);
		           //alert(textStatus);
		          $(".investments").html(XMLHttpRequest.responseText);
		        },
		        error:function(){
		        	
		        }         
		    });
			//==========end================
		}
	});
});

