/**
 * Created by chen on 2015/11/3.
 */
$(function(){
    var $selectType=$(".selectType"),
        $ui_banklsit=$(".ui-banklsit"),
        $ui_banklsit_li=$(".ui-banklsit li"),
        $typeTxt=$("#typeTxt"),
        $pageNo_a=$(".page-wap a"),
        uri="";
    //下拉
    $selectType.on("click",function(){
        $ui_banklsit.slideToggle(120);
    });
    $ui_banklsit_li.on("click",function(){
        var dataTemp= $.trim($(this).attr("data"));
        var htmlTemp= $.trim($(this).html());
        $typeTxt.val(htmlTemp);
        $ui_banklsit.slideUp(120);
        statusUrl(dataTemp);
        window.location.href=uri+"?cursor=1";
    });
    //隐藏ul
    $(document).on("click",function(event){
        var obj = event.srcElement ? event.srcElement : event.target;
        if(obj.parentNode.id!="ui-banklsit"&&obj.id!="typeTxt"&&obj.id!="typeEm"){
            $("#ui-banklsit").slideUp(120);
        }
    });
    function statusUrl(data){
        switch (data){
            case "1":uri=root+"/service/webRecords/recharge";break;         	//充值记录接口地址
            case "2":uri=root+"/service/webRecords/withdrawCash";break;         //提现记录接口地址
            case "3":uri=root+"/service/webRecords/investmentList";break;       //投资记录接口地址
            case "4":uri=root+"/service/webRecords/profitList";break;         	//收益记录接口地址
            default:uri=root+"/service/webRecords/recharge";					//默认为充值记录接口地址
        };
    };
    $pageNo_a.on("click",function(){
    	if(!$(this).hasClass("notUse")){
    		var data= $.trim($(this).attr("data-pageNo"));
            var status=$("#types").val();
            if(data){
                statusUrl(status);
                window.location.href=uri+"?cursor="+data;
            }else{
                return false;
            }
    	}
    });
});