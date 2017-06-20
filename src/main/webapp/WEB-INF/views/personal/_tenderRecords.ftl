<style>
    .btn{
        margin-right: 5px;
    }

    .backMnPlan {
        color: #3a84cf;
        background: #fff;
        border: 1px solid #3a84cf;
    }

    .backMnPlan:hover {
       color: #fff;
        background: #3a84cf;
        border: 1px solid #3a84cf; 
    }

    .agreementBtn {
        color: #09afdf;
        background: #fff;
        border: 1px solid #09afdf;
    }

    .agreementBtn:hover {
        color: #fff;
        background: #09afdf;
        border: 1px solid #09afdf;
    }

    .creditTranBtn {
        color: #fd8630;
        background: #fff;
        border: 1px solid #fd8630;
    }

    .creditTranBtn:hover {
        color: #fff;
        background: #fd8630;
        border: 1px solid #fd8630;
    }

    .transCompts {
        padding-left: 10px;
        padding-right: 10px;
    }
   
    
</style>
<div id='transConfirm'>
    <header class='transConfirmHeaher'>
        <h4 class='transConfirmTitle'>转让信息确认</h4>
        <!--<span class='transConfirmCancel'>×</span>-->
    </header>
    <h4 class='transConfirmInfo'>原项目信息 <span class="loanTitle"></span></h4>
    <table class='transConfirmTable' boder="0">
        <tr>
            <td class='font18'><span class="totalAmount"></span>元</td>
            <td class='td-center font18'><span class="comprehensiveRate"></span>%</td>
            <td class='td-last font18'><span class="loanTerm"></span>个月</td>
        </tr>
        <tr>
            <td>投资金额</td>
            <td class='td-center'>预期年化收益</td>
            <td class='td-last'>项目期限</td>
        </tr>
    </table>
    <h4 class='transConfirmInfo'>转让信息</h4>
    <table class='transConfirmTable' boder="0">
        <tr>
            <td class='font18'><span class="transAmount"></span>元</td>
            <td class='td-center font18'><span class="comprehensiveRate"></span>%</td>
            <td class='td-last font18'><span class="transTerm"></span>个月</td>
        </tr>
        <tr>
            <td>转让本金</td>
            <td class='td-center'>预期年化收益</td>
            <td class='td-last'>转让期数</td>
        </tr>
    </table>
    <h4 class='transConfirmInfo'>交易密码</h4>
    <table class='transConfirmTable' boder="0">
        <tr>
            <td style="width: 100%; text-align: center;">
                <input id="tran-password" style="width: 30%;" type="password" maxlength=6 placeholder="请输入交易密码"/>
            </td>
        </tr>
    </table>
    <div class='transConfirmCont'>
        <p>
            转让手续费：<span class="transFee"></span>元
            <span class='remain-pic'>
                <img src="../pictures/icon/ico-Notes.png">
                <i class='remainCo'>转让手续费，保留小数点后2位，并且以四舍五入计算
                    <em class='kong'></em>
                    <em class='shi'></em>
                </i>
            </span>
            <span class='fr'>转让手续费为转让本金的<span class="transRate"></span>%</span>
        </p>
        <div class='transConfirmAgree'>
            <input id="tran-agree" type='checkbox' class='agreeBox'/>同意<a href='${basePath}/service/agreement/contract' class='fben'>《债权转让协议（范本）》</a>
        </div>
    </div>
    <div class='transConfirmBtn'>
        <button id='transConfirmSure'>确认转让</button>
        <button id='transConfirmCancel'>取消</button>
    </div>
</div>
<div id='transCompt'>
     <header class='transConfirmHeaher'>
      <!-- <h4 class='transConfirmTitle'>信息</h4>
        <span class='transComptCancel'>×</span>-->
    </header>
    <div class='transComptPic'>
        <img class="done" src='../pictures/icon/ico-done.png'>
        <img class="fail" src='../pictures/icon/ico-fail.png'>
    </div>
    <p class='transComptW'>恭喜，转让申请成功！</p>
    <p class='transCompts'>转让成功后，佰宝金服会以短信通知您。<br>如果在三个自然日内无人购买。<br>转让项目将自动取消。</p>
    <div class='transComptBtn'>
        <button id='transComptSure'>确认</button>
    </div>
</div>
<ul class="conduct-project" style="margin-left:20px;margin-right: 20px;">
    <li>
        <span class="project-title" style="width:11%;">项目名称</span>
        <span class="project-title" style="text-align:right">预期年化收益</span>
        <span class="project-title" style="text-align:right">投资金额</span>
        <span class="project-title" style="width:15%;text-align:right" >投资时间</span>
        <span class="project-title" style="text-align:right">项目期限</span>
        <span class="project-title" style="text-align:right">状态</span>
        <span class="project-title" style="width:22%; text-align:center">操作</span>
    </li>
    <#if (paging??)&&(0<paging.pageList?size)>
        <#list paging.pageList as loanProduct>
            <li class="investmentList" >
                <input type="hidden" value="${loanProduct.ptrTenderFlowNo}" class="ptrTenderFlowNo">
                <span style="width:11%;">
                	<#if loanProduct.ppInvestmentType == 2>
	                    <a class="loanTitle" title="${loanProduct.ppLoantitle}"
	                        href="${basePath}/service/productList/creditTransDetail?productNo=${loanProduct.ppProductno}">
	                        <#if loanProduct.ppLoantitle?length gt 10>
	                            ${loanProduct.ppLoantitle?substring(0,10)}...
	                        <#else>
	                            ${loanProduct.ppLoantitle}
	                        </#if>
	                    </a> 
                    <#else>
	                    <a class="loanTitle" title="${loanProduct.ppLoantitle}"
	                        href="${basePath}/service/productList/productDetails?productNo=${loanProduct.ppProductno}">
	                        <#if loanProduct.ppLoantitle?length gt 10>
	                            ${loanProduct.ppLoantitle?substring(0,10)}...
	                        <#else>
	                            ${loanProduct.ppLoantitle}
	                        </#if>
	                    </a> 
                    </#if>
                </span>
                <span style="text-align:right">${loanProduct.ppComprehensiverate}%</span>
                <span style="text-align:right;color:#F55669">${loanProduct.ptr_amount?string(',###.00')}元</span>
                <span style="width:15%;text-align:right">${loanProduct.ptr_transTime?string("yyyy-MM-dd HH:mm:ss")}</span>
                <span style="text-align:right">
                    <#if loanProduct.ppLoanrepayment ==2>
                        ${loanProduct.ppLoanterm}天
                   	<#elseif loanProduct.ppLoanrepayment == 5>
                   		${loanProduct.ppLoanterm}天
                    <#else>
                        ${loanProduct.ppLoanterm}个月
                    </#if>
                </span>
                <span style="text-align:right">
                    <#if loanProduct.tenderStatus == null || loanProduct.tenderStatus == 10>
                        <#if loanProduct.ppBulkloanstatus=='1'>
                            投资中
                        <#elseif loanProduct.ppBulkloanstatus=='4'>
                            还款中
                        <#elseif loanProduct.ppBulkloanstatus=='2'>
                            已满标
                        <#elseif loanProduct.ppBulkloanstatus=='5'>
                            已完成
                        </#if>
                    <#else>
                        <#if loanProduct.tenderStatus == 11>
                            转让中
                        <#elseif loanProduct.tenderStatus == 12>
                            已转让
                        </#if>
                    </#if>
                </span>
                <span style="width:22%;text-align:center">
                    <#if loanProduct.ppBulkloanstatus==4||loanProduct.ppBulkloanstatus==5>
                        <button class="btn backMnPlan getProfit">回款计划</button>
                        <button class="btn agreementBtn getUrl" data-flowno="${loanProduct.ptrTenderFlowNo}">协议</button>

                        <#if loanProduct.lockAssignationStatus == 1 &&
                            (loanProduct.tenderStatus == null || loanProduct.tenderStatus == "10")
                            && loanProduct.ptp_capital &gt; 1000.00 && loanProduct.isTransfer == 1>
                        <button class="btn creditTranBtn"
                            data-flowno="${loanProduct.ptrTenderFlowNo}">转让</button>
                        </#if>
                      

                        <form id="myForm${loanProduct.ptrTenderFlowNo}"
                            action="${basePath}/service/agreement/contract"
                            method="get" target="_blank">
                            <input type="hidden" name="tenderFlowNo" id="tenderflowNo"
                                value="${loanProduct.ptrTenderFlowNo}">
                        </form>
                    <#else>
                        暂无数据
                    </#if>
                </span>
            </li>
        </#list>    
</ul>
<div class="baibao-pageye" style="margin:40px 20px 40px 0px;">
<ul class="clearfix">
    <li>
        <a href="javascript:ajaxPage(1)" class="prev-first"></a>
    </li>
    <li>
        <a href="javascript:void(0)" class="prev-on"></a>
    </li>
    <#list paging.startPageNo..paging.fenge as page>
        <li>
            <a href="javascript:ajaxPage(${page})"
                <#if page==paging.pageNo>
                    class="prev-o prev-cut"
                <#else>
                    class="prev-o"
                </#if>>
            ${page}
            </a>
        </li>
    </#list>

    <#if paging.pageNo<paging.pageTotal-1>
        <#if 3<paging.pageTotal>
            <li style="padding:3px"><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
        </#if>
            <li>
                <a href="javascript:ajaxPage(${paging.pageTotal})"
                    <#if paging.pageTotal==paging.pageNo>
                        class="prev-o prev-cut"
                    <#else>
                        class="prev-o"
                    </#if>>
                ${paging.pageTotal}
                </a>
            </li>
        </#if>
        <li>
            <a href="javascript:void(0)" class="prev-next"></a>
        </li>
        <li>
            <a href="javascript:ajaxPage(${paging.pageTotal})" class="prev-last"></a>
        </li>
    <#else>
        <li>
            <p class="fl no-record" style="padding:40px 0">暂无数据</p>
        </li>
    </#if>
</ul>

<script type="text/javascript">
    $(function() {
        var pageTotal = ${paging.pageTotal};
        var pageNo = ${paging.pageNo};

        $(".prev-on").on("click", function() {
            if (pageNo - 1 < 1)
            {
                ajaxPage(1);
            } else
            {
                ajaxPage(pageNo - 1);
            }
        });

        $(".prev-next").on("click", function() {
            if (pageNo + 1 > pageTotal)
            {
                ajaxPage(pageTotal);
            } else
            {
                ajaxPage(pageNo + 1);
            }
        });
    });

    function ajaxPage(pageNo)
    {
        var params = {
            "currentPageNo": pageNo
        };

        if ($("#beginTime").val())
        {
            params.beginTime = $("#beginTime").val();
        }

        if ($("#endTime").val())
        {
            params.endTime = $("#endTime").val();
        }

        if ($("#biao-state-sel").val())
        {
            params.bulkStatus = $("#biao-state-sel").attr("data");
        }

        $.ajax({
            type:"POST",
            url: root + "/service/${ajaxPageUrl}?refresh=" + new Date().getTime(),
            data: params,
            datatype: "html",
            beforeSend: function() {
                showContentLoading();
            },
            success: function(data) {
                closeContentLoading();
                $(".baibao-pageye").html(data);
            },
            complete: function(XMLHttpRequest, textStatus) {
               $("#baibao-paging").html(XMLHttpRequest.responseText);
            },
            error: function() {
            }         
        });
    }

    var products = ${products};

    var findProduct = function(tenderFlowNo) {
        for(var index in products)
        {
            var product = products[index];

            if (product.ptrTenderFlowNo == tenderFlowNo)
                return product;
        }

        return null;
    };

    /*转让弹框*/
    var $transConfirm = $("#transConfirm"), 
        $transConfirmSure = $("#transConfirmSure"),
        $transCompt = $("#transCompt"),
        $cover=$("#coverMask");
    
    function show() {
        $cover.css({"width":"100%","height":"100%","display":"block"});
    };

    function hide() {
        $cover.css({"display":"none"});        
        $transConfirm.css('display', 'none');
        $transCompt.css('display', 'none');
    }

    $(".creditTranBtn").on('click', function() {
        var $this = $(this);
		
        var product = findProduct($this.data("flowno"));
        if (product == null)
            return;

        $transConfirm.data("productno", product.ppProductno);
        $transConfirm.data("tenderFlowNo", product.ptrTenderFlowNo);

        //$transConfirm.find(".loanTitle").text(product.ppLoantitle);
        $transConfirm.find(".totalAmount").text(commafy(product.ptr_amount.toFixed(2)));
        $transConfirm.find(".comprehensiveRate").text(product.ppComprehensiverate);
        $transConfirm.find(".loanTerm").text(product.ppLoanterm);

        $transConfirm.find(".transAmount").text(commafy(product.ptp_capital.toFixed(2)));
        $transConfirm.find(".transTerm").text(product.ptp_profitTerm);

        $transConfirm.find(".transFee").text(
            ((product.ptp_capital * product.assignationFeeRate) / 100).toFixed(2));
        $transConfirm.find(".transRate").text(product.assignationFeeRate);
	
		$transConfirm.find(".transConfirmAgree a")
			.attr("href", "${basePath}/service/agreement/contract?code=crdtran&tenderFlowNo=" + product.ptrTenderFlowNo);
	
        $transConfirm.find("#tran-password").val("");
        $transConfirm.find("#tran-agree").removeAttr("checked");

        show();
        $transConfirm.css('display','block');
    });

    $transConfirmSure.on('click', function() {
        var tenderFlowNo = $transConfirm.data("tenderFlowNo");
        var password = $transConfirm.find("#tran-password").val();
        var agree = $transConfirm.find("#tran-agree").attr("checked");

        if (password.length < 6)
        {
            alert("请输入6位交易密码。");
            return;
        }

        if (agree == null)
        {
            alert("请接受债权转让协议。");
            return;
        }

        $.post("${basePath}/service/tender/assignation.do", {
            tenderFlowNo: tenderFlowNo,
            password: encryption(password)
        }).then(function(response) {
            var title = "恭喜，转让申请成功！";
            var message = '转让成功后，佰宝金服会以短信通知您。<br>如果在前无人购买。<br>转让项目将自动取消。';
            $transConfirm.css('display', 'none');
            $transCompt.css('display', 'block');
            
            if (response.retCode != 0)
            {
                message="";
                if (response.retMsg != null)
                {
                    title = response.retMsg;
                } else
                {
                    title = "网络请求失败。";
                }

                $transCompt.addClass("error");
            } else
            {
                $transCompt.removeClass("error");
                message = '转让成功后，佰宝金服会以短信通知您。<br>如果在'+formatDate(response.result.endTime)+'前无人购买，<br>转让项目将自动取消。';
            }

            $transCompt.find(".transComptW").text(title);
            $transCompt.find(".transCompts").html(message);
        });
    });
/*
    $("#transCompt").on('click', function() {
         hide();
    });
*/
    $(".transConfirmCancel, #transConfirmCancel").on('click',function(){
         hide();    
    });

    $(".transComptCancel, #transComptSure").on('click', function() {
         hide();
         
         location.reload();
    });

    var $remainPic = $(".remain-pic"),
        $remainCo=$(".remainCo");
    $remainPic.hover(function(){
        $remainCo.css('display','block');
    },function(){
        $remainCo.css('display','none');
    })
    
    var formatDate = function(timestamp) {
	    var date = new Date(timestamp);
	    var month=new Array(12)
            month[0]="01"
            month[1]="02"
            month[2]="03"
            month[3]="04"
            month[4]="05"
            month[5]="06"
            month[6]="07"
            month[7]="08"
            month[8]="09"
            month[9]="10"
            month[10]="11"
            month[11]="12";
       var day=date.getDate();
           if (day >= 10 ) 
           { 
            day = day ; 
           } 
           else
           { 
            day = "0" + day ; 
           };
	    return date.getFullYear() + "-" + month[date.getMonth()] + "-" + day + " " + 
	        "00:00:00";
	};
	 
</script>
</div>
