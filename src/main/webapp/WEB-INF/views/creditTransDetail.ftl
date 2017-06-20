<!DOCTYPE html>
<html>
<head>
  	<#include "./common/common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/investment-list.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/creditTransList.css"/>
    <style>
        .biaodesc-hk ul li span{
             width: 224px;
        }
        .biao-money>span{
            margin-left:-6px;
        }
        .l1{
            margin-left:30px !important;
        }
    </style>
</head>
<body>
    <#include "./common/common_header.ftl" />
   
  
   
    <div class="back-bg">
        <div class="container">
            <!-- 标的信息及投标操作 -->
        <div class="invest-desc-con">
            <#if productDetail.ppBulkloanstatus=1 >
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">债权转让协议（范本）</a>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span> 
                    <span class="sp-desc fr" id="productNo" value="${productDetail.ppProductno}">项目编号：${productDetail.ppProductno}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="pink">${(productDetail.ppLoanamount)?string(',##0.00')}</span>元</p>
                                <p class="biaomoney-desc">转让金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l3"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                            </p>
                            <p class="biaomoney-desc">剩余期数</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li><span>计息方式</span> 
                              <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                            </#if>
                            </li>
                            <li><span>剩余时间</span> 
                            <span id="t_d" style="width: auto;">00天</span>
                            <span id="t_h" style="width: auto;">00时</span>
                            <span id="t_m" style="width: auto;">00分</span> 
                            </li>
                           
                        </ul>
                        <a href="${basePath}/service/productList/productDetails?productNo=${productDetail.plpAssignProductNo}" class="checkDetail">查看原项目详情<img src="${basePath}/pictures/index/btn-more-blue.png"/></a>
                    </div>
                    <div class="investbiao-tb">
                        <ul class="tb-biao-op">
                            <li><p class="biao-money"><span class="pink"> ${(productDetail.ppLoanamount)?string(',##0.00')}</span>元</p>
                                <p class='inverst_Residual'>转让金额  </p></li>
                            
                            <li class="clearfix">
                                <#if islogin=false>  
                                    <span class="fl">可用余额<span class="fr" style="margin-left:164px"><a href="${basePath}/service/login" class="lan"> 登录</a>后可见</span></span>
                                <#elseif islogin=true >
                                    <span class="fl">可用余额￥${custBlance}</span>
                                    <span class="fr"><a href="${basePath}/service/account/torecharge" class="lan">充值</a></span>
                                </#if>
                            </li>
                            <input type="hidden"  autocomplete="off" value="${productDetail.ppLoanamount?c}" class="txt-number bor_radius3" id="bulkLoanAmount"/>
                            <input type="hidden" placeholder="${productDetail.ppTenderincreaseamount}"class="txt-number" id="increase"/>
                            <input type="hidden" id="sessionId"/>
                            <p class="err-tip" style='position: absolute;top: 224px;'></p>
                            <li class="li-tb" style='margin-top:46px;'><a href="javascript:void(0);" class="btn-invest-tb bor_radius3" id="tender" data-available="true" data-login="${islogin}">立即投资</a></li>
                            <li class='remn'>转让项目只可一次性全额购买</li>
                        </ul>
                    </div>
                </div>
            <#elseif productDetail.ppBulkloanstatus=2>
                  <!-- 标的信息及投标操作 已满标-->
                  <div class="invest-desc-con">
                <div class="tzicon ymb-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">债权转让协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${(productDetail.ppLoanamount)?string(',##0.00')}</span>元</p>
                                <p class="biaomoney-desc">转让金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                                                
                           </p>
                          
                                                   
                                <p class="biaomoney-desc">剩余期数</p></li>
                            <li class="l4"><span class="hei-time">${productDetail.ppBulkloandealseconds}</span>
                                <p class="biaomoney-desc">转让用时</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:30px;'><span>计息方式</span> 
                            <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                            </#if></li>
                            

                        </ul>
                        <a href="${basePath}/service/productList/productDetails?productNo=${productDetail.plpAssignProductNo}" class="checkDetail">查看原项目详情<img src="${basePath}/pictures/index/btn-more-blue.png"/></a>
                    </div>

                </div>
            </div>
          <#elseif productDetail.ppBulkloanstatus=4>
             <!-- 标的信息及投标操作 还款中-->
             <div class="invest-desc-con">
                <div class="tzicon ymb-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">债权转让协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${(productDetail.ppLoanamount)?string(',##0.00')}</span>元</p>
                                <p class="biaomoney-desc">转让金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                                                
                           </p>
                           
                                                   
                                <p class="biaomoney-desc">剩余期数</p></li>
                            <li class="l4"><span class="hei-time">${productDetail.ppBulkloandealseconds}</span>
                                <p class="biaomoney-desc">转让用时</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:30px;'><span>计息方式</span> 
                            <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                            </#if></li>
                            

                        </ul>
                        <a href="${basePath}/service/productList/productDetails?productNo=${productDetail.plpAssignProductNo}" class="checkDetail">查看原项目详情<img src="${basePath}/pictures/index/btn-more-blue.png"/></a>
                    </div>

                </div>
            </div>
            <#elseif productDetail.ppBulkloanstatus=5>
                <!-- 标的信息及投标操作 已完成-->
             <div class="invest-desc-con">
                <div class="tzicon ymb-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">债权转让协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${(productDetail.ppLoanamount)?string(',##0.00')}</span>元</p>
                                <p class="biaomoney-desc">转让金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                                               个月                          
                           </p>
                                           
                                <p class="biaomoney-desc">剩余期数</p></li>
                            <li class="l4"><span class="hei-time">${productDetail.ppBulkloandealseconds}</span>
                                <p class="biaomoney-desc">转让用时</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:30px;'><span>计息方式</span> 
                            <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                            </#if></li>
                            

                        </ul>
                        <a href="${basePath}/service/productList/productDetails?productNo=${productDetail.plpAssignProductNo}" class="checkDetail">查看原项目详情<img src="${basePath}/pictures/index/btn-more-blue.png"/></a>
                    </div>

                </div>
            </div>
            </#if>
        </div>

        <div class="invest-desc-con mt25" id="invest-desc-con">
            <div class="pers-mknav-sty">
                <ul class="mknav-ui">
                    <li class="mkli mknav-cut" style="width: 33.33%;"><span>项目详情</span></li>
                    <li class="mkli" style="width: 33.33%;"><span>项目图片</span></li>
                    <li class="mkli" style="width: 33.34%;"><span>回款计划</span></li>
                    
                </ul>
            </div>
            <!-- 标的详情 -->
            <div class="biaodesc-xq divtab " style="display:block;line-height:26px;">
                        <!--${productDetail.pp_loanDesc}-->
                        <!--最新展示页死数据-->
                        <div class='show-datas'>
                            <h3>借款人信息</h3>
                            <ul>
                                <li style='height:40px;line-height:40px;'>姓名<span>${userInfo.pcpRealName}</span></li>
                                <li class='base-info'>基础信息</li>
                                <li>
                                    <p>年龄<span class='sub_info'>${userInfo.pcpAge}</span></p>
                                    <p>学历<span class='sub_info'>${userInfo.pcpEducation}</span></p>
                                    <p>婚姻<span class='sub_info'>${userInfo.pcpMateria}</span></p>
                                    <br>
                                    <p>身份证号<span class='sub_info'>${userInfo.pcpCertNo}</span></p>
                                    <p style='width:700px'>户口所在地<span class='sub_info'>${userInfo.pcpNativePlace}</span></p>
                                </li>
                                <li  class='base-info'>住址信息</li>
                                <li  style='height:40px;line-height:40px;'>家庭住址<span>${userInfo.pcpAddress}</span></li>
                                <li class='base-info'>工作信息</li>
                                <li>
                                    <p>工作年限<span class='sub_info'>${userInfo.pcpWorkAge}年</span></p>
                                    <p>职业<span class='sub_info'>${userInfo.pcpWorkPosition}</span></p>
                                    <p>月收入<span class='sub_info'>${userInfo.pcpMonthSalary}元</span></p>
                                </li>
                            </ul>
                            <h3 class='bwMoneyUse-title'>借贷用途</h3>
                            <div class='bwMoneyUse'>
                            	${userInfo.pcpRemark}
                            </div>
                        </div>
            </div>
            <!-- 标的图片 -->
            <div class="biaodesc-tp divtab">
                <ul class="ui-bdtp clearfix">
                	<#list pictureList as picture>
                        <li><img data-url="${basePath}/service/file/${picture.plpAddress}" class="pictureImg" src="${basePath}/service/file/${picture.plpAddress}"/></li>
                    </#list>
                </ul>
            </div>
            <!-- 投资记录 -->
            <div id="baibao-paging">
            	 
            </div>
             
            <!-- 还款表现 -->
            <div class="biaodesc-hk divtab w206">
                 <#if islogin=true>
                    <ul>
                        <li class="jl-title" style="background:#eeeeee">
                            <span class="strong">预计回款时间</span>
                            <span class="strong">状态</span>
                            <span class="strong">预计回款本息</span>
                            <span class="textCt strong">实际回款日期</span></li>
                        </li>
                        <#if notCurrentUser == "1">
                            <#if 0!=listBillPlan?size>
                                 <#list listBillPlan as billPlan>
                                    <li>
                                        <span>
                                            <#if billPlan.pbpDatetime??>
                                                ${billPlan.pbpDatetime?string('yyyy-MM-dd')}
                                            </#if>
                                        </span>
                                        <span>
                                            <#if billPlan.pbpProfitStatus=0>未回款
                                            <#elseif billPlan.pbpProfitStatus=1>已回款
                                            <#elseif billPlan.pbpProfitStatus=2>回款中
                                            <#elseif tenderProfit.ptpProfitstatus=6>已转让
                                            <#elseif tenderProfit.ptpProfitstatus=7>转让中
                                            </#if>
                                        </span>
                                        <span class="pink">
                                            ${(billPlan.pbpProfitCapital + billPlan.pbpProfitInterest)?string(',##0.00')}元
                                        </span>
                                        <span class="textCt">
		                                    <#if billPlan.pbpProfitTime == null>
		                                        --
		                                    <#elseif billPlan.pbpProfitTime??>
		                                        ${billPlan.pbpProfitTime?string('yyyy-MM-dd')}
		                                    </#if>
	                                    </span>


                                    </li>
                                 </#list> 
                            <#else>
                                <li style="height:80px">
                                    <p class="fl no-record" style="padding:30px 0 40px 0">暂无数据</p>
                                </li>
                            </#if>
                        <#else>
                            <#if 0!=billList?size>
                                <#list billList as tenderProfit>
                                    <li>
                                        <span>
                                            <#if tenderProfit.ptpProfittime??>
                                                ${tenderProfit.ptpProfittime?string('yyyy-MM-dd')}
                                            </#if>
                                        </span>
                                        <span>
                                            <#if tenderProfit.ptpProfitstatus=0>未回款
                                            <#elseif tenderProfit.ptpProfitstatus=1>已回款
                                            <#elseif tenderProfit.ptpProfitstatus=2>回款中
                                            <#elseif tenderProfit.ptpProfitstatus=6>已转让
                                            <#elseif tenderProfit.ptpProfitstatus=7>转让中
                                            </#if>
                                        </span>
                                        <span class="pink">${tenderProfit.ptpFactprofit?string(',##0.00')}元</span>
                                        <span class="textCt">
				                            <#if tenderProfit.ptpFactprofittime??>
				                                ${tenderProfit.ptpFactprofittime?string('yyyy-MM-dd')}
				                            <#else>
				                                	--
				                            </#if>
			                            </span>
                                    </li>
                               </#list> 
                            <#else>
                                <li style="height:80px">
                                    <p class="fl no-record" style="padding:30px 0 40px 0">暂无数据</p>
                                </li>
                            </#if>
                        </#if>
                    </ul>
                 <#elseif islogin=false>
                    <div class="NoUser">
                        <span class="NoUserCen">
                            <span>
                                请</span><span><a href="${basePath}/service/login" class="lan">登录</a>/<a class="lan" href="${basePath}/service/register">注册</a></span><span>后查看
                            </span>
                        </span>
                    </div>
                </#if>
            </div>
            </div>
        </div>
    </div>
    <#if productDetail.ppBulkloanstatus=1 >
        <script language="javascript" type="text/javascript"> 
            var time;
            var NowTime = '${NowTime?string('yyyy-MM-dd HH:mm:ss')}';
            var str = '${productDetail.ppBulkloanendtime?string('yyyy-MM-dd HH:mm:ss')}'.replace(/-/g,"/").replace(".0","");
            var EndTime= new Date(str);
            NowTime=new Date(NowTime.replace(/-/g,"/").replace(".0",""));
            var t =EndTime.getTime() - NowTime.getTime();
            function getTime(){
              if(t>0){
                    var d=Math.floor(t/1000/60/60/24);
                    var h=Math.floor(t/1000/60/60%24);
                    var m=Math.floor(t/1000/60%60);
                    var s=Math.floor(t/1000%60);
                    document.getElementById("t_d").innerHTML = d + "天";
                    document.getElementById("t_h").innerHTML = h + "时";
                    document.getElementById("t_m").innerHTML = m + "分";
                   //document.getElementById("t_s").innerHTML = s + "秒";
               }
            }
            getTime();
           time=setInterval(function(){
               t = t - 1000;
               getTime();
           },1000);
        </script>
    </#if>
	<#include "./common/common_footer.ftl" />
	
	<!-- 投标弹框 -->
    <div id="tenderBox" class="alert-con" id="tb-alert" style="width:450px;">
        <div class="widget">
            <div class="widget-head clearfix">
                <div class="fl alert-title">立即投资
                </div>
                <div class="fr">
                    <span id="closeBox" class="alert-close" title="关闭">×</span>
                </div>
            </div>
            <div class="widget-content">
                <div class="padd">
                    <ul class="alert-ui">
                         <li class="ldesc">
                            <span class="alert-tip">借款标题：</span>
                            <span id="productTitle" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">预期年化收益：</span>
                            <span id="comprehensiveRate" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">投资期限：</span>
                            <span id="loanTerm" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">计息方式：</span>
                            <span id="loanRepayment" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">投资金额：</span>
                            <span <span id="loanAmount" class="alert-desc loanAmount"></span>元</span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip ">交易金额：</span>
                            <span class="alert-desc"><span class="tb-number loanAmount"></span>元</span>
                        </li>
                        <li>
                            <span class="alert-tip">交易密码：</span>
                            <input class="alert-txt" type="password" maxlength="6">
                            <p class="alert-err"></p>
                        </li>
                        <li>
                            <span class="alert-tip">&nbsp;</span>
                            <button id="sureTenderBtn" class="btn btn-primary">确定</button>
                            <button id="cancelBtn" class="btn btn-default ml10">取消</button>
                        </li>
                    </ul>
    
                </div>
            </div>
        </div>
    </div>
    <!-- 设置交易密码 -->
    <#include "./personal/_setTransPassword.ftl" />
	
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
	<script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
	<script>
    	var isSetPcaPayPassword='${isSetPcaPayPassword}';
    	seajs.use("creditTransDetail");
        $(".nav .nLi").eq(2).addClass("current");
	</script>
</body>
</html>