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
    <div style='background:#f2f2f2;padding: 1px;'>
      <div class="container">
    	  <div class="clearfix">
            <div class="fl mt20" style='width:100%;'>
                <div class="invest-biaolist inverst-bor" style="padding:15px 0px 20px 0px;background: #fff;">
                    <!--产品类型-->
                    <ul class="ui-tz-bdlx productType ">
                        <li class="title pl40">产品类型</li>
                        <#if productType?exists&&productType==1>
                        <li><a href="javascript:void(0)">全部</a></li>
                        <li><a value="2" href="javascript:void(0)">新手标</a></li>
                        <li class="cut"><a value="1" href="javascript:void(0)">佰宝盈</a></li>
                        <li><a value="3" href="javascript:void(0)">佰宝聚利</a></li>
						<li><a value="4" href="javascript:void(0)">佰日鑫</a></li>
                       <#elseif productType==3>
                        <li><a href="javascript:void(0)">全部</a></li>
                        <li><a value="2" href="javascript:void(0)">新手标</a></li>
                      	<li><a value="1" href="javascript:void(0)">佰宝盈</a></li>
                        <li  class="cut"><a value="3" href="javascript:void(0)">佰宝聚利</a></li>
						<li><a value="4" href="javascript:void(0)">佰日鑫</a></li>
                        <#elseif productType==2>
                        <li><a href="javascript:void(0)">全部</a></li>
                      	<li  class="cut"><a value="2" href="javascript:void(0)">新手标</a></li>
                      	<li><a value="1" href="javascript:void(0)">佰宝盈</a></li>
                        <li><a value="3" href="javascript:void(0)">佰宝聚利</a></li>
						<li><a value="4" href="javascript:void(0)">佰日鑫</a></li>
						<#elseif productType==4>
                        <li><a href="javascript:void(0)">全部</a></li>
                      	<li><a value="2" href="javascript:void(0)">新手标</a></li>
                      	<li><a value="1" href="javascript:void(0)">佰宝盈</a></li>
                        <li><a value="3" href="javascript:void(0)">佰宝聚利</a></li>
						<li class="cut"><a value="4" href="javascript:void(0)">佰日鑫</a></li>
                        <#else>
                        <li class="cut"><a href="javascript:void(0)">全部</a></li>
                        <li><a value="2" href="javascript:void(0)">新手标</a></li>
                       	<li><a value="1" href="javascript:void(0)">佰宝盈</a></li>
                        <li><a value="3" href="javascript:void(0)">佰宝聚利</a></li>
						<li><a value="4" href="javascript:void(0)">佰日鑫</a></li>
						
                        </#if >
                    </ul>
                    <!--投标期限-->
                    <ul class="ui-tz-bdlx productTerm">
                        <li class="title pl40">投标期限</li>
                        <li class="cut"><a href="javascript:void(0)">全部</a></li>
                        <li><a value="1" href="javascript:void(0)">1个月内</a></li>
                        <li><a value="3" href="javascript:void(0)">1-3个月</a></li>
                        <li><a value="6" href="javascript:void(0)">4-6个月</a></li>
                        <li><a value="12" href="javascript:void(0)">7-24个月</a></li>
                    </ul>
                    <!--投标状态-->
                    <ul class="ui-tz-bdlx productStatus">
                        <li class="title pl40" >投标状态</li>
                        <li class="cut"><a href="javascript:void(0)">全部</a></li>
                        <li><a value="1"  href="javascript:void(0)">可投标</a></li>
                        <li><a value="4" href="javascript:void(0)">还款中</a></li>
                        <li><a value="5" href="javascript:void(0)">已完成</a></li>
                    </ul>
                </div>
       
      
       
		         <div  class="invest-biaolist mt20 clearfix"  id="productListPage">
            	    
            	    	<#include "./_productListPage.ftl" />
     				
		         </div>
        </div>
      </div>  
   </div>
    </div>
    <#include "./common/common_footer.ftl" />
	<script>
        seajs.use("productList");
        seajs.use("permainH");
        $(".nav .nLi").eq(1).addClass("current");
    </script>
</body>
</html>