<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/investment-list.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/AssetPackaging.css"/>
</head>
<body>
    <#include "./common/common_header.ftl" />
   <!-- <div class="invest-list-nav">
        <div class="container">
            <ul class="list-nav">
                <li class="current"><a href="${basePath}/service/productList/showProductList">投资列表</a></li>
            </ul>
        </div>
    </div>  
    -->
    <div class="back-bg">
        <div class="container">
            <!-- 标的信息及投标操作 -->
            <div class="invest-desc-con">
            <#if productDetail.ppBulkloanstatus=1 >
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl" id='_Loantitle'>${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span> 
                    <span class="sp-desc fr" id="productNo" value="${productDetail.ppProductno}">项目编号：${productDetail.ppProductno}</span>
                   
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="pink">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l3"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                            <#if productDetail.ppLoanrepayment=2>
                                天
                            <#else>
                                个月
                            </#if>
                            </p>
                            <p class="biaomoney-desc">投资期限</p></li>
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
                                到期本息
                                </#if>
                            </li>
                            <li>
                                <span>剩余时间</span> 
                                <span id="t_d" style="width: auto;">00天</span>
                                <span id="t_h" style="width: auto;">00时</span>
                                <span id="t_m" style="width: auto;">00分</span> 
                                <span id="t_s" style="width: auto;">00秒</span>
                            </li>
                            <li>
                                <span>投标进度</span>
                                <em class="hui-line bor_radius10">
                                    <em class="lan-line" style="width:${productDetail.ppLoanamountexist*100/productDetail.ppLoanamount}%"> </em>
                                </em>
                                <span class="line-num"><#if productDetail.ppLoanamountexist*100/productDetail.ppLoanamount<1>
                                    <#if productDetail.ppLoanamountexist*100/productDetail.ppLoanamount==0>
                                        0%
                                    <#else>
                                        1%
                                    </#if>
                                    <#else>
                                        ${(productDetail.ppLoanamountexist*100/productDetail.ppLoanamount)?floor}%
                                    </#if>
                                </span>
                            </li>
                        </ul>
                    </div>
                    <div class="investbiao-tb">
                        <ul class="tb-biao-op">
                            <li>
                                <p class="biao-money">
                                    <span class="pink"> ${productDetail.ppLoanamount-productDetail.ppLoanamountexist}</span>元
                                </p>
                                <p class='inverst_Residual'>可投金额</p>
                            </li>
                            
                            <li class="clearfix">
                                <#if islogin=false>  
                                    <span class="fl">
                                        可用余额
                                        <span class="fr" style="margin-left:164px">
                                            <a href="${basePath}/service/login" class="lan">登录</a>后可见
                                        </span>
                                    </span>
                                <#elseif islogin=true >
                                    <span class="fl">可用余额￥${custBlance}</span>
                                    <span class="fr">
                                        <a href="${basePath}/service/account/torecharge" class="lan">充值</a>
                                    </span>
                                </#if>
                            </li>
                            <li class="li-txt-con">
                                <input type="text" autocomplete="off"
                                    placeholder="输入金额须为${productDetail.ppTenderincreaseamount}的整数倍"
                                    class="txt-number bor_radius3" id="bulkLoanAmount"/>
                                <input type="hidden"
                                    placeholder="${productDetail.ppTenderincreaseamount}"
                                    class="txt-number" id="increase"/>

                                <input type="hidden" id="sessionId"/>
                                <p class="err-tip"></p><em>元</em>
                            </li>
                            <li class="li-tb">
                                <a href="javascript:void(0);" class="btn-invest-tb bor_radius3"
                                    id="tender" data-available="true" data-login="${islogin}">立即投资
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            <#elseif productDetail.ppBulkloanstatus=2>
                  <!-- 标的信息及投标操作 已满标-->
                  <div class="invest-desc-con">
                <div class="tzicon ymb-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1">
                                <p class="biao-money"><span class="orange">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p>
                            </li>
                            <li class="l2">
                                <p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p>
                            </li>
                            <li class="l2">
                                <p class="biao-money">
                                    <span class="hei">${productDetail.ppLoanterm}</span>
                                    <#if productDetail.ppLoanrepayment==2>
                                      天
                                    <#else>
                                      个月
                                    </#if>                          
                                </p>
                                <p class="biaomoney-desc">投资期限</p>
                            </li>
                            <li class="l4">
                                <span class="hei-time">${productDetail.ppBulkloandealseconds}</span>
                                <p class="biaomoney-desc">满标用时</p>
                            </li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:23px;'>
                                <span>计息方式</span> 
                                <#if productDetail.ppLoanrepayment=0>
                                 等额本息
                                <#elseif productDetail.ppLoanrepayment=1>
                                 先息后本
                                <#elseif productDetail.ppLoanrepayment=2>
                                 按天计息
                                <#elseif productDetail.ppLoanrepayment=3>
                                 等额本金
                                <#elseif productDetail.ppLoanrepayment=4>
                                 到期本息
                                </#if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
          <#elseif productDetail.ppBulkloanstatus=4>
            <!-- 标的信息及投标操作 还款中-->
            <div class="invest-desc-con">
                <div class="tzicon hkz-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1">
                                <p class="biao-money"><span class="orange">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p>
                            </li>
                            <li class="l2">
                                <p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p>
                            </li>
                            <li class="l2">
                                <p class="biao-money">
                                    <span class="hei">${productDetail.ppLoanterm}</span>
                                    <#if productDetail.ppLoanrepayment ==2>
                                        天
                                    <#else>
                                        个月
                                    </#if>
                                </p>
                                <p class="biaomoney-desc">投资期限</p>
                            </li>
                            <li class="l3" style='margin-left:42px;'>
                                <p class="biao-money"><span class="hei">${surplusTerm}</span>期</p>
                                <p class="biaomoney-desc">剩余期数</p>
                            </li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:23px;'><span>计息方式</span>
                             <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            到期本息
                            </#if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <#elseif productDetail.ppBulkloanstatus=5>
                <!-- 标的信息及投标操作 已完成-->
            <div class="invest-desc-con">
                <div class="tzicon ywc-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间：${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1">
                                <p class="biao-money"><span class="orange">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p>
                            </li>
                            <li class="l2">
                                <p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p>
                            </li>
                            <li class="l2">
                                <p class="biao-money">
                                    <span class="hei">${productDetail.ppLoanterm}</span>
                                    <#if productDetail.ppLoanrepayment ==2>
                                      天
                                    <#else>
                                      个月
                                    </#if>
                                </p>
                                <p class="biaomoney-desc">投资期限</p>
                            </li>
                            <li class="l3">
                                <p class="biao-money"><span class="hei">0</span>期</p>
                                <p class="biaomoney-desc">剩余期数</p>
                            </li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li>
                                <span>计息方式</span>
                                <#if productDetail.ppLoanrepayment=0>
                                 等额本息
                                <#elseif productDetail.ppLoanrepayment=1>
                                先息后本
                                <#elseif productDetail.ppLoanrepayment=2>
                                按天计息
                                <#elseif productDetail.ppLoanrepayment=3>
                                等额本金
                                <#elseif productDetail.ppLoanrepayment=4>
                                到期本息
                                </#if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            </#if>
            </div>

            <div class="invest-desc-con mt25" id="invest-desc-con">
                <div class="pers-mknav-sty">
                    <ul class="mknav-ui mknav-ui-fto">
                        <li class="mkli mknav-cut"><span>标的详情</span></li>
                        <li class="mkli"><span>标的组成</span></li>
                        <li class="mkli"><span>投资记录</span></li>
                         <li class="mkli"><span>回款计划</span></li>
                        <!--
                        <li class="mkli productImgTitle" style="width: 25%;"><span>标的图片</span></li>-->
                    </ul>
                </div>
                <!-- 标的详情 -->
                <div class="biaodesc-xq divtab" style="display:block;margin:0;" id="" >
                     <div class="contentContain">
					 	<h4 class="introTitle pt28 pb20 bd1">项目进度</h4>
						<div class="progressMap">
							<li>
								<img src="${basePath}/pictures/icon/icon-Start-interest.png" class="w80h80">
								<p class="progressTitle">开始计息</p>
								<p class="progressDate">${interestTime?string('yyyy年MM月dd日')}</p>
								<p class="msdetail">预计日期
									<img src="${basePath}/pictures/icon/btn-explain.png" class="btnExplain">
									<i class='remainCo'>以项目满标起息日期为准。
										<em class='kong'></em>
										<em class='shi'></em>
                					</i>
								</p>
							</li>
							<img src="${basePath}/pictures/icon/icon-next.png" class="guideGo">
							<li>
								<img src="${basePath}/pictures/icon/icon-Project-maturity.png" class="w80h80">
								<p class="progressTitle">项目到期</p>
								<p class="progressDate">${productEndTime?string('yyyy年MM月dd日')}</p>
								<p class="msdetail">预计日期
									<img src="${basePath}/pictures/icon/btn-explain.png" class="btnExplain">
									<i class='remainCo'>以项目满标起息日期为准。
										<em class='kong'></em>
										<em class='shi'></em>
                					</i>			
								</p>
							</li>
							<img src="${basePath}/pictures/icon/icon-next.png" class="guideGo">
							<li>
								<img src="${basePath}/pictures/icon/icon-Principal-account.png" class="w80h80">
								<p class="progressTitle">本息至平台账户</p>
								<p class="progressDate">${arrivalTime?string('yyyy年MM月dd日')}</p>
								<p class="msdetail">预计日期
									<img src="${basePath}/pictures/icon/btn-explain.png" class="btnExplain">
									<i class='remainCo'>以项目满标起息日期为准。
										<em class='kong'></em>
										<em class='shi'></em>
                					</i>
								</p>
							</li>
						</div>
						<h4 class="introTitle pt40 pb24">什么是佰宝聚利？</h4>
						<p class="mcExplain">佰宝聚利是佰宝金服推出的，对经过佰宝金服资产安全保障系统严格审核并提供全面保护的优质借款项目进行投资的理财计划。遵循小额分散原则，年化收益率<span>${productDetail.ppComprehensiverate}</span>%，时间期限<span>${productDetail.ppLoanterm}</span>个月，更好的满足您多样化的理财需求。</p>
						<h4 class="introTitle pt28 pb20">佰宝聚利安全吗？</h4>
						<p class="mcExplain">佰宝聚利适用于平台质量保障服务转款，带给您安全稳健高收益的理财新体验。</p>
						<h4 class="introTitle pt28 pb20">佰宝聚利有费用吗？</h4>
						<p class="mcExplain">投资佰宝聚利无任何费用。</p>
						<h4 class="introTitle pt28 pb20">风控师意见</h4>
						<p class="mcExplain">经过严格的准入条件和全面的尽职调查，该借款项目真实，证照齐全，风险可控，予以通过。</p>
					 </div>
					 <div class="riskTip">
					 	<h4 class="TipTitle">风险提示</h4>
						<p class="TipCont">佰宝金服作为信息发布平台，未以任何明示或暗示的方式对投资人提供任何担保或承诺保本保息。佰宝金服提供的各种信息及资料仅供参考，投资人应根据其自身投资偏好及风险承受能力独立判断并作出决策。投资人据此进行交易的，产生的责任与风险由投资人自行承担，佰宝金服不承担任何责任。</p>
						<p class="TipCont">投资有风险，任何保障措施均有其局限性：<br/>
						（1）风险准备金的提取比例是有限的，其余额可能低于逾期项目金额进而导致无法足额代偿；<br/>
						（2）战争、自然灾害、骚乱、罢工、政策变更等不可抗力亦可能严重影响资金安全。</p>
					 </div>
                </div>
                <!-- 标的组成 -->
                <div class="biaodesc-xq divtab " style="line-height:26px;" id="assetCredit" >
                     <#include "./productCreditorPack.ftl" /> 
                </div>
                <!-- 投资记录 -->
                <div id="baibao-paging">
                     <div  class="biaodesc-jl divtab" id="productRecord">
                        <#include "./productTenderRecords.ftl" />
                     </div>
                </div>
                
                <!-- 还款表现 -->
                <div class="biaodesc-hk divtab">
                 <#if islogin=true>
                    <ul>
                        <li class="jl-title" style="background:#eeeeee"><span class="strong">预计回款时间</span>
                        <span class="strong">状态</span><span class="strong">预计回款本息</span><span class="textCt strong">实际回款日期</span></li>
                        <#if notCurrentUser == "1">
                            <#if 0!=listBillPlan?size>
                                <#list listBillPlan as billPlan>
                                    <#if billPlan.pbpProfitInterest != null && billPlan.pbpProfitCapital != null>
                                    <li>
                                        <span>
                                            <#if billPlan.pbpDatetime??>
                                                ${billPlan.pbpDatetime?string('yyyy-MM-dd')}
                                            </#if>
                                        </span>
                                        <span>
                                            <#if billPlan.pbpProfitStatus=0>
                                                未回款
                                            <#elseif billPlan.pbpProfitStatus=1>
                                                已回款
                                            <#elseif billPlan.pbpProfitStatus=2>
                                                回款中
                                            </#if>
                                        </span>
                                        <span class="pink">${(billPlan.pbpProfitCapital + billPlan.pbpProfitInterest)?string(',##0.00')}元</span>
                                        <span class="textCt">
                                            <#if billPlan.pbpProfitTime == null>
                                                --
                                            <#elseif billPlan.pbpProfitTime??>
                                                ${billPlan.pbpProfitTime?string('yyyy-MM-dd')}
                                            </#if>
                                        </span>
                                    </li>
                                    </#if>
                                </#list>    
                            <#else>
                                <li style="height:80px"><p class="fl no-record" style="padding:30px 0 40px 0">暂无数据</p></li>
                            </#if>
                        <#else>
                            <#if 0!=billList?size>
                                <#list billList as tenderProfit>
                                    <li>
                                        <span>
                                        <#if tenderProfit.ptpProfittime??>
                                            ${tenderProfit.ptpProfittime?string('yyyy-MM-dd')} 
                                        </#if></span>
                                        <span>
                                            <#if tenderProfit.ptpProfitstatus=0>未回款
                                            <#elseif tenderProfit.ptpProfitstatus=1>已回款
                                            <#elseif tenderProfit.ptpProfitstatus=2>回款中
                                            </#if>
                                        </span>
                                        <span class="pink">${tenderProfit.ptpFactprofit}元</span>
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
                                <li style="height:80px"><p class="fl no-record" style="padding:30px 0 40px 0">暂无数据</p></li>
                            </#if>
                         </#if>
                    </ul>
                     <#elseif islogin=false>
                    <div class="NoUser">
                        <span class="NoUserCen">
                            <span>请</span>
                            <span>
                                <a href="${basePath}/service/login" class="lan">登录</a>/
                                <a class="lan" href="${basePath}/service/register">注册</a>
                            </span>
                            <span>后查看</span>
                        </span>
                    </div>
                </#if>
                </div>
                <!-- 标的图片 -->
               
                <div class="biaodesc-tp divtab">
                    <ul class="ui-bdtp clearfix ">
                       <!--测试<li><img  src="${basePath}/pictures/loanShow/icon-Recharge.png"/> </li>
                        <li><img  src="${basePath}/pictures/loanShow/icon-Recharge.png"/> </li>
                        <li><img  src="${basePath}/pictures/loanShow/icon-Recharge.png"/> </li>
                        <li><img  src="${basePath}/pictures/loanShow/icon-Recharge.png"/> </li>--> 
                    <#list pictureList as picture>
                        <li><img data-url="${picture.plpAddress}" class="pictureImg" src=""/></li>
                    </#list>
                    </ul>
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
                    document.getElementById("t_s").innerHTML = s + "秒";
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
                       <#if productDetail.pp_inviteCode == "BBJF">
                            <li>
                            <span class="alert-tip">邀请码：</span>
                            <input class="alert-invest" type="password" maxlength="6" >
                            <p class="alert-err"></p>
                            </li>
                           </#if>
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
    <script type='text/javascript'>
        var isSetPcaPayPassword='${isSetPcaPayPassword}';
        seajs.use("investment"); 
        $("#main-nav .nLi").eq(1).addClass("current").siblings().removeClass("current");
		var $msdetail = $(".msdetail"),
			$remainCo=$(".remainCo");
		$msdetail.hover(function(){
			$(this).parent().find(".remainCo").css('display','block');
    	},function(){
        	$(this).parent().find(".remainCo").css('display','none');
    	});
    </script>
</body>
</html>
