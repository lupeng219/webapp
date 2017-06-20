$(function(){
	var $selectBank=$("#selectBank"),$selectBankEm=$("#selectBankEm"),$ui_banklist=$("#ui-banklist"),$ui_banklist_li=$("#ui-banklist li"),
		$loc_province=$("#loc_province"),$loc_province_em=$("#loc_province_em"),$ui_provincelist=$("#ui-provincelist"),
		$loc_city=$("#loc_city"),$loc_city_em=$("#loc_city_em"),$ui_citylist=$("#ui-citylist"),
		$newBankCode=$("#newBankCode"),
		$reserveMobile=$("#reserveMobile"),
		$mobileVer=$("#mobileVer"),
		$hqyzm_btn=$(".hqyzm-btn"),
		$logion_btn=$(".logion-btn"),
		result={};
	//初始化
	init();
	function init(){
		var provinceList=get_province_array();
		var htmlTemp="";
		for(var i=0;i<provinceList.length;i++){
			htmlTemp+='<li>'+provinceList[i]+'</li>';
		}
		$ui_provincelist.html(htmlTemp);
	};
	//***********************下拉列表****************************
	//选择银行
	$selectBank.on("click",function(){
		$ui_banklist.slideToggle(120);
	});
	$selectBankEm.on("click",function(){
		$ui_banklist.slideToggle(120);
	});
	$ui_banklist_li.on("click",function(){
        var dataTemp= $.trim($(this).attr("data-bankCode"));
        var htmlTemp= $.trim($(this).html());
        $selectBank.val(htmlTemp);
        $selectBank.attr("data-bankCode",dataTemp);
        $ui_banklist.slideUp(120);
    });
	//选择省份
	$loc_province.on("click",function(){
		$ui_provincelist.slideToggle(120);
	});
	$loc_province_em.on("click",function(){
		$ui_provincelist.slideToggle(120);
	});
	$ui_provincelist.find("li").on("click",function(){
		var htmlTemp= $.trim($(this).html());
		$loc_province.val(htmlTemp);
		addCityList(htmlTemp);
		$ui_provincelist.slideUp(120);
	});
	//选择城市
	$loc_city.on("click",function(){
		var loc_province=$loc_province.val();
		if(loc_province){
			$ui_citylist.slideToggle(120);
		}else{
			$ui_provincelist.slideToggle(120);
		}
	});
	$loc_city_em.on("click",function(){
		var loc_province=$loc_province.val();
		if(loc_province){
			$ui_citylist.slideToggle(120);
		}else{
			$ui_provincelist.slideToggle(120);
		}
	});
	$ui_citylist.on("click","li",function(){
		var htmlTemp= $.trim($(this).html());
		$loc_city.val(htmlTemp);
		$ui_citylist.slideUp(120);
	});
    //填充城市列表
    function addCityList(data){
    	$loc_city.val("");
    	var cityList=get_city_array(data);
		var htmlTemp="";
		for(var i=0;i<cityList.length;i++){
			htmlTemp+='<li>'+cityList[i]+'</li>';
		}
		$ui_citylist.html(htmlTemp);
    };
    //隐藏ul
    $(document).on("click",function(event){
        var obj = event.srcElement ? event.srcElement : event.target;
        if(obj.parentNode.id!="ui-banklist"&&obj.id!="selectBank"&&obj.id!="selectBankEm"){
        	$ui_banklist.slideUp(120);
        }
        if(obj.parentNode.id!="ui-provincelist"&&obj.id!="loc_province"&&obj.id!="loc_province_em"&&obj.id!="loc_city"&&obj.id!="loc_city_em"){
        	$ui_provincelist.slideUp(120);
        }
        if(obj.parentNode.id!="ui-citylist"&&obj.id!="loc_city"&&obj.id!="loc_city_em"){
        	$ui_citylist.slideUp(120);
        }
    });
    
    /******************************************************************************/
    //绑定事件
    $selectBank.on("change",selectBankChange);
    $loc_province.on("change",locProvinceChange);
    $loc_city.on("change",locCityChange);
    $newBankCode.on("blur",newBankCodeBlur);
    $reserveMobile.on("blur",reserveMobileBlur);
    $mobileVer.on("blur",mobileVerBlur);
    //处理事件
    function selectBankChange(){
		result=selectBankFormat($selectBank);
        var temp=resultVer(result,$selectBank);
        return temp;
	};
	function locProvinceChange(){
		result=selectProvinceFormat($loc_province);
		var temp=resultVer(result,$loc_province);
		return temp;
	};
	function locCityChange(){
		result=selectCityFormat($loc_province,$loc_city);
		var temp=resultVer(result,$loc_city);
		return temp;
	};
	function newBankCodeBlur(){
		result=bankCodeFormat($newBankCode);
		var temp=resultVer(result,$newBankCode);
		return temp;
	};
	function reserveMobileBlur(){
		result=mobileFormat($reserveMobile);
		var temp=resultVer(result,$reserveMobile);
		return temp;
	};
	function mobileVerBlur(){
		result=mobileVerFormat($mobileVer);
		var temp=resultVer(result,$mobileVer);
		return temp;
	};
    //返回结果验证
    function resultVer(data,element){
        if(data.success){
            clearStyle();
            return true;
        }else{
            clearStyle();
            element.closest(".txt-cn").find(".err-p").html(data.msg);
            if(element.hasClass("txt")){
                element.addClass("txt-err");
            }
            return false;
        }
    };
    //清楚错误样式
    function clearStyle(){
        $(".err-p").html("");
        $(".txt").removeClass("txt-err");
    };
    //绑卡获取验证码
    $hqyzm_btn.on("click",function(){
    	if(selectBankChange()&&locProvinceChange()&&locCityChange()&&newBankCodeBlur()&&reserveMobileBlur()){
    		if($hqyzm_btn.attr("data-available")=="true"){
    			$hqyzm_btn.attr("data-available",false);
    			showContentLoading();
    			$.post(root+"/service/bankCard/bankCardBinding",{
                    "bankCode": $.trim($selectBank.attr("data-bankCode")),
                    "province":$.trim($loc_province.val()),
                    "city":$.trim($loc_city.val()),
                    "bankCardNo":$.trim($newBankCode.val()),
                    "phoneNo":$.trim($reserveMobile.val()),
                    "channel":"3"
                },function(data){
                	closeContentLoading();
                    if(data.retCode){
                        getMobileVerFormat($hqyzm_btn);
                    }else{
                    	$("#mobileVerErr").html(data.retMsg);
                    	$hqyzm_btn.attr("data-available",true);
                        return false;
                    }
                });
            }else{
                return false;
            }
    	}
    });
    //推进
    $logion_btn.on("click",function(){
    	if(selectBankChange()&&locProvinceChange()&&locCityChange()&&newBankCodeBlur()&&reserveMobileBlur()&&mobileVerBlur()){
        	if($logion_btn.attr("data-available")=="true"){
        		$logion_btn.attr("data-available",false);
        		showContentLoading();
        		$.ajax({
                    type:'POST',
                    async:false,
                    url:root+"/service/bankCard/bankCardBindingAdvance",
                    data:{
                    	"bankCardNo":$.trim($newBankCode.val()),//银行卡号
                    	"validCode":$.trim($mobileVer.val()),//手机验证码
                    	"channel":"3"
                    },
                    dataType:'json',
                    error:function(data){
                    	closeContentLoading();
                        myShow(data.statusText);
                        $logion_btn.attr("data-available",true);
                        return false;
                    },
                    success:function(data){
                    	closeContentLoading();
                        if(data.retCode) {
                        	location.href=root+"/service/wapBankcard/toWapBankCard";
                        }else{
                        	$("#mobileVerErr").html(data.retMsg);
                        	$logion_btn.attr("data-available",true);
                        	return false;
                        }
                    }
        		});
        	}else{
        		return false;
        	}
    	}else{
    		return false;
    	}
    });
});