<!DOCTYPE html>
<html>
<head>
  	<#include "./common/common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/investment-list.css"/>
</head>
<body>
    <#include "./common/common_header.ftl" />
   
    <div class="invest-list-nav">
        <div class="container">
            <ul class="list-nav">
                <li class="current"><a href="${basePath}/service/productList/showProductList">投资列表</a></li>
            </ul>
        </div>
    </div>	
   
    <div class="back-bg">
        <div class="container">
            <!-- 标的信息及投标操作 -->
            <div class="invest-desc-con">
			    <!-- 标的信息及投标操作 已完成-->
            	<div class="invest-desc-con">
                <div class="tzicon ywc-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productMap.loanTitle}</span>
                    <a href="${basePath}/service/agreement/equitableAssignment" class="fr" target="_blank">债转协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productMap.bulkLoanNumber}</span>
                    <span class="sp-desc fr">发布时间：${productMap.bulkLoanStartTime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${productMap.loanAmount}</span>元</p>
	                                <p class="biaomoney-desc">项目总金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productMap.comprehensiveRate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productMap.loanTerm}</span>个月</p>
                                <p class="biaomoney-desc">投资期限</p></li>
                             <li class="l3"><p class="biao-money"><span class="hei">0</span>期</p>
                                <p class="biaomoney-desc">剩余期数</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li><span>还款方式</span>
                             	<#if productMap.loanRepayment=0>
	                           	 	等额本息
	                           	<#elseif productMap.loanRepayment=1>
	        						先息后本
	        					<#elseif productMap.loanRepayment=2>
	        					    按天计息
	        					<#elseif productMap.loanRepayment=3>
	        					    等额本金
                                <#elseif productMap.loanRepayment=4>
                                    到期本息
	                            </#if>
                            </li>
                            <li><span>资金托管</span> 新浪支付</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="invest-desc-con mt25" id="invest-desc-con">
            <div class="pers-mknav-sty mt30">
                <ul class="mknav-ui">
                    <li class="mkli mknav-cut" style="width: 25%;"><span>标的详情</span></li>
                    <li class="mkli" style="width: 25%;"><span>标的图片</span></li>
                    <li class="mkli" style="width: 25%;"><span>投标记录</span></li>
                    <li class="mkli" style="width: 25%;"><span>还款表现</span></li>
                </ul>
            </div>
            <!-- 标的详情 -->
            <div class="biaodesc-xq divtab" style="display:block;">
            	${productMap.loanDesc}
            </div>
            <!-- 标的图片 -->
            <div class="biaodesc-tp divtab">
                <ul class="ui-bdtp clearfix">
                
                <#list pictureList as picture>
                    <li><img src="${picture.plpAddress}"/></li>
                </#list>
                </ul>
            </div>
            <!-- 投资记录 -->
            	<div id="baibao-paging">
            	 <div  class="biaodesc-jl divtab" id="productRecord">
            	    <#include "./productTenderRecord.ftl" />
            	      </div>
            </div>
             
            <!-- 还款表现 -->
            <div class="biaodesc-hk divtab">
                <ul>
                    <li class="jl-title">
                    <span class="strong">合约还款日</span>
                    <span class="strong">状态</span>
                    <span class="strong">应还本息</span>
                    <span class="strong">应付罚息</span>
                    <span class="textRt strong">实际还款日期</span></li>
                   <#list billList as repaymentBill>
                    <li>
	                    <span><#if repaymentBill.prbRepaymenttime??>${repaymentBill.prbRepaymenttime?string('yyyy-MM-dd')} </#if></span>
	                    <span>正常还款</span>
	                    <span>${repaymentBill.prbRepaymentprincipal}元</span>
	                    <span>${repaymentBill.prbOverdueamount}元</span>
	                    <span class="textRt"><#if repaymentBill.prbInfactrepaymenttime??>${repaymentBill.prbInfactrepaymenttime?string('yyyy-MM-dd HH:mm:ss')}</#if></span>
                    </li>
				   </#list>	
                </ul>
            </div>
            </div>
        </div>
    </div>
	<#include "./common/common_footer.ftl" />
	
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
	<script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
	<script>
    	var isSetPcaPayPassword='${isSetPcaPayPassword}';
    	seajs.use("investment");
	</script>
</body>
</html>