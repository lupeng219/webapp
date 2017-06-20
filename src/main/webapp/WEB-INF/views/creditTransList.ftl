<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/investment-list.css"/>
     <link rel="stylesheet" type="text/css" href="${basePath}/css/creditTransList.css"/>
</head>
<body>
	<#include "./common/common_header.ftl" />
    <div style='background:#f2f2f2;padding: 1px;'>
      <div class="container">
    	  <div class="clearfix">
            <div class="fl mt20" style='width:100%;'>
                <div class="invest-biaolist inverst-bor" style="padding:15px 0px 20px 0px;background: #fff;">
                    <!--预期年化-->
                    <ul class="ui-tz-bdlx productType ">
                        <li class="title pl40">预期年化</li>
                        <li class="cut"><a href="javascript:void(0)">全部</a></li>
                        <li><a href="javascript:void(0)" value="1">13%-15%</a></li>
                        <li><a href="javascript:void(0)" value="2">12%-13%</a></li>
                        <li><a href="javascript:void(0)" value="3">10%-12%</a></li>
                        <li><a href="javascript:void(0)" value="4">10%以下</a></li>
                       
                    </ul>
                    <!--投资期限-->
                    <ul class="ui-tz-bdlx productTerm">
                        <li class="title pl40">投标期限</li>
                        <li class="cut"><a href="javascript:void(0)">全部</a></li>
                        <li><a href="javascript:;" value="1">3个月以下</a></li>
                        <li><a href="javascript:;" value="2">3-6个月</a></li>
                        <li><a href="javascript:;" value="3">6-9个月</a></li>
                        <li><a href="javascript:;" value="4">9个月以上</a></li>
                    </ul>
                   
                </div>
       
		        <div  class="invest-biaolist mt20 clearfix"  id="productListPage">
            	    
            	    <#include "./_creditTransListPage.ftl" />
     				
		        </div>
        </div>
      </div>  
    </div>
    </div>
    </div>
    <#include "./common/common_footer.ftl" />
	<script>
        seajs.use("creditTransList");
        seajs.use("permainH");
    </script>
</body>
</html>