<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl">
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
    <meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/index.css"/>
</head>
<body>
    <#include "./common/common_header.ftl">
    <!-- 轮播图 开始 -->
    <#if pictureList??>
    <div class="in-banner slideBox">
        <div class="baibao_slider_nav hd">
            <ul class="slider_nav_pointer">
                <#list pictureList as picture>
                    <#if item_index>
                        <li class="on"><a></a></li>
                    <#else>
                        <li class=""><a></a></li>
                    </#if>
                </#list>
            </ul>
        </div>
        <div class="banner_ad bd">
            <ul style="position: relative;">
                <#list pictureList as picture>
                    <li style="background: url(${basePath}/service/file/${picture.interimPathUrl}) center center no-repeat;">
                        <#if picture.activityUrl!="">
                            <a href="${picture.activityUrl}" style="display:inline-block;width:100%;height:100%;" target="_blank"></a>
                        </#if>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        jQuery(".slideBox").slide({mainCell: ".bd ul", effect: "fold", autoPlay: true, trigger: "mouseover", delayTime: 500, interTime:3000, pnLoop: true, easing: "swing", mouseOverStop: true});
    </script>
    </#if>
   
    <!-- 轮播图 结束 -->
   
    <div style='background:#f2f2f2;padding: 1px;'>
    <#if noticeList??>
    <div class="container" style="width:1000px;margin: 0 auto; height:140px;">
        <!-- 网站公告 开始 -->
    
                 <div class="day-wzgg txtScroll-top hiddenCon">
            <em class="gg-icon iconbg"></em>
            <div class="gg-desc bd">
                <div class="tempWrap" style="overflow:hidden; position:relative; height:50px">
                    <ul class="infoList" style="position: relative; top:0; padding: 0px; margin: 0px;">
                        <#if noticeList??>
                            <#list noticeList as notice>
                                <li style="height: 50px;">
                                    <a href="${basePath}/service/aboutUs/noticeDesc?noticeId=${notice.articleID}"><#if notice.articleTitle?length gt 25>${notice.articleTitle?substring(0,25)}...<#else>${notice.articleTitle}</#if> </a>
                                    <span>${notice.articlePushTime?string('yyyy-MM-dd HH:mm:ss')}</span>
                                </li>
                            </#list>
                        <#else>
                             暂无公告
                        </#if>
                    </ul>
                </div>
            </div>
           
            
        </div>
         
    
        <script type="text/javascript">
            jQuery(".txtScroll-top").slide({
                mainCell: ".bd ul",
                autoPage: true,
                effect: "topLoop",
                autoPlay: true,
                vis: 1,
                delayTime: 400
            });
        </script>
    </div>
   
     </#if>
   
     
    <div class="container">
        <!-- 新手专享 -->
      
        <#if noviceExclusive??>
            <div class="clearfix boxs xszx-con" class='mt30'>
               <div class="cboxs-02 pd_newcomer">
                    <div class="mt15 font30">新手独享</div>
                    <div class='mt10 font30'>高额收益</div>
                    <div class="mt15"><img src="${basePath}/pictures/index/icon-line.png"/></div>
                    <div class="mt15 font20">新手专区</div>
                    <a href="${basePath}/service/productList/showProductList?productType=2" class="boxs-more more1">查看更多<img src="${basePath}/pictures/index/btn-more.png"/></a>
                </div>
                <div>
                    <div class="invest-biao">
                        <img src='${basePath}/pictures/index/icon-Yield-curve.png' class='new-zx'/>
                        <#if noviceExclusive??>
                        <div class="biao-title-con w886">
                            <p class="biao-title ellipsis" style="max-width:220px;">
                                <a href="${basePath}/service/productList/productDetails?productNo=${noviceExclusive.ppProductno}" title="${noviceExclusive.ppLoantitle}">${noviceExclusive.ppLoantitle}</a>
                            </p>
                            <span class="biao-bzcon" style='margin-left:10px;margin-top:12px;'>
                                <#if noviceExclusive.ppLoanrepayment=0>
                                等额本息
                                <#elseif noviceExclusive.ppLoanrepayment=1>
                                先息后本
                                <#elseif noviceExclusive.ppLoanrepayment=2>
                                按天计息
                                <#elseif noviceExclusive.ppLoanrepayment=3>
                                等额本金
                                <#elseif noviceExclusive.ppLoanrepayment=4>
                                先息后本
                                </#if>
                            </span>
                        </div>
                        <div class="biao-desc-con">
                            <p class="pt5">
                                <span class='red'>
                                    <span>${noviceExclusive.ppComprehensiverate}</span>%</span>
                                </span>
                                <span class='bt_rm'>预期年化收益</span>

                                <!--<span class="pl28">起投金额  ${noviceExclusive.ppTerderminamount}元</span>-->
                            </p>
                            <p class="pt5">
                                <span class="colo34">
                                    <span>${noviceExclusive.ppLoanterm}</span>
                                    <#if noviceExclusive.ppLoanrepayment=2>
                                        天
                                    <#else>
                                        个月
                                    </#if>
                                </span>
                                <span  class='bt_rm'>投资期限</span>    
                            </p>
                            <p class="pt5">
                                <span class="red">
                                    <span>${noviceExclusive.ppLoanamount}</span>元
                                </span>
                                <span  class='bt_rm'>投资总额</span>    
                            </p>

                            <div class="pt5" style='background:none;'>
                                <div class="biao-jindu-con" style='margin-left:74px;margin-top:4px;'>
                                <div class="rings biao-ring">
                                    <#if noviceExclusive.ppBulkloanstatus ==2 || noviceExclusive.ppBulkloanstatus ==4 || noviceExclusive.ppBulkloanstatus ==5>
                                        <p style='line-height:82px;'>100%</p>
                                    <#else>
                                         <p style='line-height:82px;'><#if noviceExclusive.ppLoanamountexist*100/noviceExclusive.ppLoanamount<1>
                                         <#if noviceExclusive.ppLoanamountexist*100/noviceExclusive.ppLoanamount==0 >0%
                                         <#else>
                                         1%
                                         </#if>
                                         <#else>
                                         ${(noviceExclusive.ppLoanamountexist*100/noviceExclusive.ppLoanamount)?floor}%</#if></p>
                                    </#if>
                                </div>
                            </div>
                            <div class="biao-tbbtn-con" style='padding-left: 68px; margin-top:16px;'>
                                    <a href="${basePath}/service/productList/productDetails?productNo=${noviceExclusive.ppProductno}" class="<#if noviceExclusive.ppBulkloanstatus==0||noviceExclusive.ppBulkloanstatus==1>btn-tbiao<#else>btn-mbiao</#if> mt20">
                                    <#if noviceExclusive.ppBulkloanstatus=0>
                                     待开放
                                    <#elseif noviceExclusive.ppBulkloanstatus=1>
                                     立即投资
                                        <#elseif noviceExclusive.ppBulkloanstatus=2>
                                     已满标
                                        <#elseif noviceExclusive.ppBulkloanstatus=3>
                                     流标                    
                                        <#elseif noviceExclusive.ppBulkloanstatus=4>
                                     还款中                    
                                        <#elseif noviceExclusive.ppBulkloanstatus=5>
                                     已完成
                                      </#if>                  
                                    </a>
                                </div>
                            </div>
                        </div>

                        </#if>
                    </div>
                </div>
            </div>
        </#if>
        <!--佰宝聚利开始-->
        <#if assetsPackLsit??>
            <div class="clearfix boxs packass mt30">
               <div class="cboxs-01 Asset_Packaging">
                    <div class='mt25 font30'>多重保障</div>
                    <div class='mt10 font30'>极度分散</div>
                    <div class='pt15'><img src="${basePath}/pictures/index/icon-line.png"/></div>
                    <div class='pt15 font20'>佰宝聚利</div>
                    <!--<p class="boxs-pd" style="color: #09afdf">预期最高年化收益</p>-->
                    <div class="boxs-rate1">
                        <div class="xline iconbg"></div>
                       <p class='font14'>预期年化收益8%-12%</p>
                    </div>

                    <a href="${basePath}/service/productList/showProductList?productType=3" class="boxs-more more1">查看更多<img src="${basePath}/pictures/index/btn-more.png"/></a>
                </div>
            <div>
                <div class="invest-biao b-bte1">
                <#list assetsPackLsit as assetsPackLsit>
                    <div class='packass-list'>
                        <p><a href='${basePath}/service/productList/productDetails?productNo=${assetsPackLsit.ppProductno}'>${assetsPackLsit.ppLoantitle}</a></p>
                        <h4 class='red'><span>${assetsPackLsit.ppComprehensiverate}</span>%</h4>
                        <h6>金额<span>${assetsPackLsit.ppLoanamount}</span>元</h6>
                        <h6>投资期限<span class='red'> ${assetsPackLsit.ppLoanterm}</span>
                        <#if assetsPackLsit.ppLoanrepayment=2>
                        天
                         <#else>
                         个月
                        </#if>
                        </h6>
                        <a href="${basePath}/service/productList/productDetails?productNo=${assetsPackLsit.ppProductno}" class="<#if assetsPackLsit.ppBulkloanstatus==0||assetsPackLsit.ppBulkloanstatus==1>btn-tbiao<#else>btn-mbiao</#if> mt10 w180">
                             <#if assetsPackLsit.ppBulkloanstatus=0>
                             待开放
                            <#elseif assetsPackLsit.ppBulkloanstatus=1>
                             立即投资
                             <#elseif assetsPackLsit.ppBulkloanstatus=2>
                             已满标
                                <#elseif assetsPackLsit.ppBulkloanstatus=3>
                             流标                    
                                <#elseif assetsPackLsit.ppBulkloanstatus=4>
                             还款中                    
                                <#elseif assetsPackLsit.ppBulkloanstatus=5>
                             已完成 
                              </#if>           
                            </a>
                    </div>
                   
                    </#list>
                </div>
            </div>
        </div>
            </#if>
        <!--佰宝聚利结束-->
        <!-- 全民宝 -->
        <#if productLsit??>
        <div class="clearfix boxs" >
            <div class="cboxs-01 pd_qmb">
                <div class='mt25 font30'>投资精选</div>
                <div class='mt10 font30'>灵活便捷</div>
                <div class='mt15'><img src="${basePath}/pictures/index/icon-line.png"/></div>
                <div class='pt15 font20'>佰宝盈</div>
                <!--<p class="boxs-pd" style="color: #09afdf">预期最高年化收益</p>-->
                <div class="boxs-rate1">
                    <div class="xline iconbg"></div>
                    <p class='font14'>预期年化收益8%-12%</p>
                </div>
                
                <a href="${basePath}/service/productList/showProductList?productType=1" class="boxs-more more1">查看更多<img src="${basePath}/pictures/index/btn-more.png"/></a>
            </div>
            <div class="cboxline-01">
                <em class="hot-icon iconbg"></em>
                <#list productLsit as loanProduct>
                <div class="main-biao-desc" >
                    <p class="biao-title ml20"> <a href="${basePath}/service/productList/productDetails?productNo=${loanProduct.ppProductno}" class="mt10">${loanProduct.ppLoantitle}</a></p>
                    <div class="clearfix">
                        <div class="fl biao-left ml20">
                            <span class="biao-bzcon">
                            <#if loanProduct.ppLoanrepayment=0>
                            等额本息
                            <#elseif loanProduct.ppLoanrepayment=1>
                            先息后本
                            <#elseif loanProduct.ppLoanrepayment=2>
                            按天计息
                            <#elseif loanProduct.ppLoanrepayment=3>
                            等额本金
                            <#elseif loanProduct.ppLoanrepayment=4>
                            先息后本
                            </#if>
                            </span>
                            <p class="mt35 Annual_yield">
                                年化收益 <span class="font14 red"><span class="font42">${loanProduct.ppComprehensiverate}</span>%</span>
                                <span class='pl18 Annual_yield'>起投金额 ${loanProduct.ppTerderminamount}元</span>   
                            </p>
                            <p><span class='Annual_yield'>投资总额  ${loanProduct.ppLoanamount}元</span>
                                <span class="pl15 Annual_yield">投资期限
                                    <span class="font14 red">${loanProduct.ppLoanterm}</span>
                                    <#if loanProduct.ppLoanrepayment=2>
                                        天
                                    <#else>
                                        个月
                                    </#if>
                                </span>
                            </p>
                        </div>
                        <div class="fr biao-right">
                            <div class="rings biao-ring">
                                <#if loanProduct.ppBulkloanstatus=2 || loanProduct.ppBulkloanstatus='4' || loanProduct.ppBulkloanstatus="5">
                                 <p>100%</p>
                                 <#else>
                                 <p><#if loanProduct.ppLoanamountexist*100/loanProduct.ppLoanamount<1>
                                 <#if loanProduct.ppLoanamountexist*100/loanProduct.ppLoanamount==0>
                                 0%
                                 <#else>
                                 1% 
                                 </#if>
                                 <#else>
                                 ${(loanProduct.ppLoanamountexist*100/loanProduct.ppLoanamount)?floor}%</#if></p>
                                </#if>
                               
                            </div>
                            <a href="${basePath}/service/productList/productDetails?productNo=${loanProduct.ppProductno}" class="<#if loanProduct.ppBulkloanstatus==0||loanProduct.ppBulkloanstatus==1>btn-tbiao<#else>btn-mbiao</#if> mt10">
                             <#if loanProduct.ppBulkloanstatus=0>
                             待开放
                            <#elseif loanProduct.ppBulkloanstatus=1>
                             立即投资
                                <#elseif loanProduct.ppBulkloanstatus=2>
                             已满标
                                <#elseif loanProduct.ppBulkloanstatus=3>
                             流标                    
                                <#elseif loanProduct.ppBulkloanstatus=4>
                             还款中                    
                                <#elseif loanProduct.ppBulkloanstatus=5>
                             已完成
                              </#if>                  
                            </a>
                        </div>
                    </div>
                </div>
                
                </#list>
            </div>
            
        </div>
        </#if>
		<!--佰日鑫开始-->
		<#if termDaysObj??>
			<div class="clearfix boxs xszx-con" class='mt30'>
               <div class="cboxs-02 pd_newcomer">
                    <div class="mt15 font30">按天计息</div>
                    <div class='mt10 font30'>极致体验</div>
                    <div class="mt15"><img src="${basePath}/pictures/index/icon-line.png"/></div>
                    <div class="mt15 font20">佰日鑫</div>
                    <a href="${basePath}/service/productList/showProductList?productType=4" class="boxs-more more1">查看更多<img src="${basePath}/pictures/index/btn-more.png"/></a>
                </div>
                <div>
                    <div class="invest-biao">
                        <div class="biao-title-con w886 ml14">
                            <p class="biao-title ellipsis pl10" style="max-width:220px;">
                                <a href="${basePath}/service/productList/productDetails?productNo=${termDaysObj.ppProductno}" title="${termDaysObj.ppLoantitle}">${termDaysObj.ppLoantitle}</a>
                            </p>
                            <span class="biao-bzcon" style='margin-left:10px;margin-top:12px;'>
                                <#if termDaysObj.ppLoanrepayment=0>
                                等额本息
                                <#elseif termDaysObj.ppLoanrepayment=1>
                                先息后本
                                <#elseif termDaysObj.ppLoanrepayment=2>
                                按天计息
                                <#elseif termDaysObj.ppLoanrepayment=3>
                                等额本金
                                <#elseif termDaysObj.ppLoanrepayment=4>
                                先息后本
                                <#elseif termDaysObj.ppLoanrepayment=5>
                               到期本息
                                </#if>
                            </span>
                        </div>
                        <div class="biao-desc-con">
                            <p class="pt5">
                                <span class='red'>
                                    <span>${termDaysObj.ppComprehensiverate}</span>%</span>
                                </span>
                                <span class='bt_rm'>预期年化收益</span>

                                <!--<span class="pl28">起投金额  ${termDaysObj.ppTerderminamount}元</span>-->
                            </p>
                            <p class="pt5">
                                <span class="colo34">
                                    <span>${termDaysObj.ppLoanterm}</span>
                                    <#if termDaysObj.ppLoanrepayment=2>
                                        天
                                    <#elseif termDaysObj.ppLoanrepayment = 5 >
                                        天
                                    <#else>
                                        个月
                                    </#if>
                                </span>
                                <span  class='bt_rm'>投资期限</span>    
                            </p>
                            <p class="pt5">
                                <span class="red">
                                    <span>${termDaysObj.ppLoanamount}</span>元
                                </span>
                                <span  class='bt_rm'>金额</span>    
                            </p>

                            <div class="pt5" style='background:none;'>
                                <div class="biao-jindu-con" style='margin-left:74px;margin-top:4px;'>
                                <div class="rings biao-ring">
                                    <#if termDaysObj.ppBulkloanstatus ==2 || termDaysObj.ppBulkloanstatus ==4 || termDaysObj.ppBulkloanstatus ==5>
                                        <p style='line-height:82px;'>100%</p>
                                    <#else>
                                         <p style='line-height:82px;'>
                                         <#if termDaysObj.ppLoanamountexist*100/termDaysObj.ppLoanamount<1>
                                         	<#if termDaysObj.ppLoanamountexist*100/termDaysObj.ppLoanamount==0 >
                                         		0%
                                         	<#else>
                                         		1%
                                         	</#if>
                                         <#else>
                                         	${(termDaysObj.ppLoanamountexist*100/termDaysObj.ppLoanamount)?floor}%
                                         </#if>
                                         </p>
                                    </#if>
                                </div>
                            </div>
                            <div class="biao-tbbtn-con" style='padding-left: 68px; margin-top:16px;'>
                                    <a href="${basePath}/service/productList/productDetails?productNo=${termDaysObj.ppProductno}" class="<#if termDaysObj.ppBulkloanstatus==0||termDaysObj.ppBulkloanstatus==1>btn-tbiao<#else>btn-mbiao</#if> mt20">
                                    <#if termDaysObj.ppBulkloanstatus=0>
                                     待开放
                                    <#elseif termDaysObj.ppBulkloanstatus=1>
                                     立即投资
                                    <#elseif termDaysObj.ppBulkloanstatus=2>
                                     已满标
                                    <#elseif termDaysObj.ppBulkloanstatus=3>
                                     流标                    
                                    <#elseif termDaysObj.ppBulkloanstatus=4>
                                     还款中                    
                                    <#elseif termDaysObj.ppBulkloanstatus=5>
                                     已完成
                                    </#if>                  
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </#if>
		<!--佰日鑫结束-->
        <#if productListZqzr??>
        <!--债转开始-->
            <div class="clearfix boxs  mt30" style='border-bottom: 1px solid #e1e1e1;'>
               <div class="cboxs-01 creditTrans">
                    <div class='mt25 font30'>自主投资</div>
                    <div class='mt10 font30'>期限灵活</div>
                    <div class='pt15'><img src="${basePath}/pictures/index/icon-line.png"/></div>
                    <div class='pt15 font20'>转让专区</div>
                    <a href="${basePath}/service/productList/creditTransList" class="boxs-more more1">查看更多<img src="${basePath}/pictures/index/btn-more.png"/></a>
                </div>
            
                <div class="invest-biao b-bte1" style='border-bottom:none;'>
                    <table class='credit-tran' border="0">
                        <tr class='t-head' style='background:#ecfbff;'>
                            <td style='width:290px; padding-left:24px;'>项目名称</td>
                            <td style='width:155px;'>预期年化收益</td>
                            <td style='width:176px;'>转让本金</td>
                            <td style='width:84px;'>剩余期数</td>
                            <td class='td-last' style='width:130px;'>操作</td>
                        </tr>
                        <#list productListZqzr as loanProductZqzr>
                        <tr>
                            <td class='td-first'><a href='${basePath}/service/productList/creditTransDetail?productNo=${loanProductZqzr.ppProductno}'>${loanProductZqzr.ppLoantitle}</a></td>
                            <td class='red fon16 fontHel'>${loanProductZqzr.ppComprehensiverate}%</td>
                            <td class='fon16 fontHel'>${loanProductZqzr.ppLoanamount}元</td>
                            <td class='fon16 fontHel'>${loanProductZqzr.ppLoanterm}</td>
                            <#if loanProductZqzr.ppBulkloanstatus=1>
                                <td class='td-last'><a href="${basePath}/service/productList/creditTransDetail?productNo=${loanProductZqzr.ppProductno}"class="btn-tbiao mt10">立即投资</a></td>
                            <#else>
                                 <td class='td-last'><a href="${basePath}/service/productList/creditTransDetail?productNo=${loanProductZqzr.ppProductno}"class="btn-mbiao mt10" style='height:32px;line-height:32px;padding:0'>已转让</a></td>
                            </#if> 
                        </tr>
                        </#list>
                    </table>
                </div>
            
        </div>
        </#if>
        <!--债转结束-->
        
        <!-- 钱来乐 -->
        <div class="clearfix boxs mb30" style="border: 0px;">

        </div>
    </div>
    </div>
    <#include "./common/common_footer.ftl">
    
   
    <script type="text/javascript">
        var noticeString=${noticeString};
        if(noticeString){
            session.set("noticeString",JSON.stringify(noticeString));
        }
    </script>
</body>
</html>
