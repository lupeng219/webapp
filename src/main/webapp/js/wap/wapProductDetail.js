$(function(){
	jinduline();
	function jinduline(){
		var html = $("input[name='jindu']").val();
		$(".jinduline").attr("style","width:"+html+"%");
	}
	$(".blue-num").on("click",function(){
		window.location.href=root+"/service/wapLogin/toWapLogin";
	});
	
	$(".ui-tab li").on("click",function(){
		var productNo = $("#productNo").val();
		var cursor = $("#cursor").val();
		$(".ui-tab li").removeClass("current");
		$(this).addClass("current");
		var index = $(this).index();
		$(".investment-con").find(".txtdesc-cn").css('display','none');
		var $this = $($(".investment-con").find(".txtdesc-cn")[index]);
		$this.css('display','block');
		var postData = {
				"productNo":productNo,
				"pageNum":1
		};
		if($this.attr("data-type")=="bidrecord"){
			$.post(root+"/service/wapBulkLoan/wapTenderRecords",postData,function(data){
				$this.html(data);
			});
		}
	});
	//进行投标操作
	$(".logion-btn").click("click",function(){
		var $this=$(this);
		if($this.attr("data-use")=="true"){
			$this.attr("data-use",false);
			var myFun = function(element){
				$this.attr("data-use",true);
				//element
				element.focus();
			};
			var balance=parseInt($.trim($("#balance").html()));
			isNaN(balance)?balance=0:balance=balance;
			if(balance==0){
				myShow("对不起您的余额不足!",myFun);
				return false;
			}
			if(null==$("#bulkLoanAmount").val()||$("#bulkLoanAmount").val()=="" || $("#bulkLoanAmount").val() ==0){
				myShow("请输入投标金额!",myFun($("#bulkLoanAmount")));
				return false;
			};
			
			if(null==$("#transPassword").val()||$("#transPassword").val()==""){
				myShow("请输入交易密码!",myFun($("#transPassword")));
				return false;
			}else if($("#transPassword").val().length!=6){
				myShow("请输入6位数的交易密码!",function(){
					$("#transPassword").val("");
					$("#transPassword").focus();
					$this.attr("data-use",true);
				});
				return false;
			}
			showContentLoading();
			$.post(root+"/service/wapBulkLoan/verifyAccountTransPassword", {
				"productNo":$("#productNo").val(),
				"bulkLoanAmount":$("#bulkLoanAmount").val(),
				"password":encryption($("#transPassword").val()),
				"channel":"4"
	        }, function(data) {
	           closeContentLoading();
	           if(data.retCode){
	        	   myShow("投标成功!",function(){window.location.reload(true);});
	           }else{
	        	   myShow(data.retMsg,myFun);
	        	  return false;
	           }
	        });
		}else{
			return false;
		}
    });
	
	$(".page-wap-two a").die().live("click",function(){
    	if(!$(this).hasClass("notUse")){
	        var pageNum= $.trim($(this).attr("data-pageNo"));
	        var productNo = $("#productNo").val();
	        var postData = {
	        		"productNo":productNo,
	        		"pageNum":pageNum
	        };
	        if(pageNum){
	        	$.post(root+"/service/wapBulkLoan/wapTenderRecords",postData,function(data){
	        		$(".bidrecord").html(data);
	        	})
	        }else{
	            return false;
	        }
    	}
    });
});