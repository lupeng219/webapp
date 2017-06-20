/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */
$(function () {
    var profitListTitle = ["收益当前期数", "预期收益本金", "预期收益利息", "预期收益时间", "实际收益利息", "实际收益时间", "收益状态"];
    var str1 = "",
        str2 = "";
    //	 for(var i=0;i<profitListTitle.length;i++){
    //		 if(i==0){
    //			 str1+='<li class="profitList"><span class="profitList-title">'+profitListTitle[i]+'</span>';
    //		 }else{
    //			 str1+='<span class="profitList-title">'+profitListTitle[i]+'</span>';
    //		 }
    //	 }

    str1 = '<li class="profitList" style="display: list-item;">';
    str1 += '<span class="profitList-title" style="padding-left:2%;width: 13%; text-align:left;">回款当前期数</span>';
    str1 += '<span class="profitList-title" style="width: 10%;padding-left:2% ; text-align:right;">预期回款本金</span>';
    str1 += '<span class="profitList-title" style="width: 9.5%;padding-left:2% ; text-align: right;">预期回款利息</span>';
    str1 += '<span class="profitList-title" style="width: 14.5%;padding-left: 2%;text-align: right;">预期回款本息</span>';
    str1 += '<span class="profitList-title" style=" width: 11.5%;padding-left:2%;text -align:right;">预期回款时间</span>';
    str1 += '<span class="profitList-title" style="padding-left: 2%;text-align: right; width: 9.5%;">实际回款时间</span>';
    str1 += '<span class="profitList-title" style="width: 14%;padding-left: 2%;text-align: center;">回款状态</span>';

    $("#down-card,#biao-state-sel").on("click", function () {
        $("#biaostate-list").slideToggle(200);
    });
    $("#biaostate-list li").on("click", function () {
        var dataTemp = $.trim($(this).attr("data"));
        var valueTemp = $.trim($(this).html());
        $("#biao-state-sel").val(valueTemp);
        $("#biao-state-sel").attr("data", dataTemp);
        $("#biaostate-list").slideUp(200);
    });
    //隐藏ul
    $(document).on("click", function (event) {
        var obj = event.srcElement ? event.srcElement : event.target;
        //状态列表隐藏
        if (obj.parentNode.id != "biaostate-list" && obj.id != "biao-state-sel" && obj.id != "down-card") {
            $("#biaostate-list").slideUp(200);
        }
    });
    $(".conduct-project .investmentList span .loanTitle").on("click", function (event) {
        if (event.stopPropagation) {
            event.stopPropagation();
        } else {
            event.returnValue = false;
        }
    });
    $("#baibao-paging").on("click", ".conduct-project .investmentList span .getProfit", function (event) {
        var $this = $(this).closest("li");
        if ($this.next().hasClass("profitList")) {
            $this.next().siblings(".profitList").hide();
            $this.next().slideToggle(80);
            $this.siblings(".investmentList").children().removeClass("active");
            if ($this.find(".active").length > 0) {
                $this.children().removeClass("active");
            } else {
                $this.children().addClass("active");
            }
        } else {
            str2 = "";
            $this.siblings(".investmentList").children().removeClass("active");
            $this.siblings(".profitList").hide();
            //******************添加数据*********************
            var ptrTenderFlowNo = $this.find(".ptrTenderFlowNo").val();
            if (ptrTenderFlowNo) {
                $.ajax({
                    url: root + '/service/personalInvestment/ajaxGetTenderProitRecord',
                    type: 'post',
                    async: false, //使用同步的方式,true为异步方式
                    data: {
                        "tenderflowNo": ptrTenderFlowNo
                    }, //这里使用json对象
                    dataType: 'json',
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                str2 += '<span style="padding-right:2%;width: 13%;text-align:center;">' + data[i].ptpLoanseq + '</span>'
                                str2 += '<span style="width: 10%;padding-left:2% ; text-align:right;">' + commafy((data[i].ptpCapital).toFixed(2)) + '元</span>'
                                str2 += '<span style="width: 9.5%;padding-left: 2%;text-align: right;">' + commafy((data[i].ptpInterest).toFixed(2)) + '元</span>'
                                str2 += '<span class="exfx" style="width: 14.5%;padding-left: 2%;text-align: right;">' + commafy(((data[i].ptpCapital + data[i].ptpInterest).toFixed(2))) + '元</span>';

                                if (data[i].ptpProfittime) {
                                    var time = timeFormat(data[i].ptpProfittime);
                                    str2 += '<span style="width: 10%;padding-left: 2%; text-align:right;">' + time + '</span>';
                                } else {
                                    str2 += '<span style="width: 15%;padding-left: 2%; text-align:right;"></span>';
                                }



                                if (data[i].ptpFactprofittime == null)
                                {
                                    str2 += '<span style="width: 11%;padding-left: 2%;text-align: center;">--</span>'
                                } else
                                {
                                    str2 += '<span style="width: 11%;padding-left: 2%;text-align: right;">' +
                                        timeFormat(data[i].ptpFactprofittime) + '</span>'
                                }

                                if (data[i].ptpProfitstatus == "0")
                                {
                                    str2 += '<span style=" width: 14%;padding-left: 2%;text-align: center;">未回款</span>';
                                } else
                                if (data[i].ptpProfitstatus == "1")
                                {
                                    str2 += '<span style=" width: 14%;padding-left: 2%;text-align: center;">已回款</span>';
                                } else
                                if (data[i].ptpProfitstatus == "7")
                                {
                                    str2 += '<span style=" width: 14%;padding-left: 2%;text-align: center;">转让中</span>';
                                } else
                                if (data[i].ptpProfitstatus == "6")
                                {
                                    str2 += '<span style=" width: 14%;padding-left: 2%;text-align: center;">已转让</span>';
                                } else
                                {
                                    str2 += '<span style=" width: 14%;padding-left: 2%;text-align: center;">处理中</span>';
                                }


                            }
                            //	             			str2+='<span style=" width: 19%;padding-left: 2%;text-align: center;">未收益</span>'
                            //	             			for(var i=0;i<data.length;i++){
                            //	             				str2+='<span>'+data[i].ptpLoanseq+'</span>';
                            //	             				str2+='<span>'+data[i].ptpCapital+'元</span>';
                            //	             				str2+='<span>'+data[i].ptpInterest+'元</span>';
                            //	             				if(data[i].ptpProfittime){
                            //	             					var time=timeFormat(data[i].ptpProfittime);
                            //	             					str2+='<span>'+time+'</span>';
                            //	             				}else{
                            //	             					str2+='<span></span>';
                            //	             				}
                            //	             				str2+='<span>'+data[i].ptpFactinterest+'元</span>';
                            //	             				if(data[i].ptpFactprofittime){
                            //	             					var time=timeFormat(data[i].ptpFactprofittime);
                            //	             					str2+='<span>'+time+'</span>';
                            //	             				}else{
                            //	             					str2+='<span>未收益</span>';
                            //	             				}
                            //             					if(data[i].ptpProfitstatus=="01"){
                            //             						str2+='<span>未收益</span>';
                            //             					}else if(data[i].ptpProfitstatus=="00"){
                            //             						str2+='<span>已收益</span>';
                            //             					}else if(data[i].ptpProfitstatus=="02"){
                            //             						str2+='<span>处理中</span>';
                            //             					}else{
                            //             						str2+='<span>未收益</span>';
                            //             					}
                            //		                   	}
                            str2 += '</li>';
                            $this.after(str1 + str2);
                            $this.children().addClass("active");

                        } else {
                            alert("该投资单尚未生成收益");
                            return;
                        }
                    },
                    fail: function () {
                        alert('无法查看收益详情');
                        return false;
                    }
                });
            }
        }

    });

    $("#baibao-paging").on("click", ".getUrl", function () {
        var ptrTenderFlowNo = $(this).data('flowno');
        $("#myForm" + ptrTenderFlowNo).submit();
        /* var ptrTenderFlowNo = $(this).data('flowno');
    	 $.ajax({
          	url:root+'/service/personalInvestment/ajaxGetUrl',
          	type:'post',
          	async:true,//使用同步的方式,true为异步方式
          	data:{"tenderflowNo":ptrTenderFlowNo},//这里使用json对象
          	dataType:'json',
          	success:function(data){
          		if(data.retCode){
          			$("#myForm").submit();
          			//window.open(data.viewUrl);
          		}else{
          			alert("合同暂未生成，请稍后再试。");
          			return;
          		}
          	},
          	error:function(){
          		alert('合同暂未生成，请稍后再试。');
          		return false;
          	}
          });*/
    });

    function timeFormat(time) {
        var date = new Date(time);
        if (date) {
            var year = date.getFullYear();
            var month = date.getMonth() + 1; //js从0开始取 
            var day = date.getDate();
            if (month < 10) {
                month = "0" + month;
            }
            if (day < 10) {
                day = "0" + day;
            }
            return year + "-" + month + "-" + day;
        } else {
            return "";
        }
    };
});
