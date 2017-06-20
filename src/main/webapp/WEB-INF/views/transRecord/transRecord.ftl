<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
	<title>交易记录-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-records.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-acount.css"/>
    <script src="${basePath}/js/public/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
</head>
<body>
   <#include "./common/common_header.ftl" /> 
   <#include "./common/common_personAccount.ftl" />
   <#include "./common/common_smbanner.ftl"/>
   <div class="personal-main " id='personal-main'>
        <div class="container" style='border:1px solid #eeeded;'>
        	 <div class="tab-header">
	                    <h2 class="tab-title">交易记录</h2>
	                </div>
	            <div class="textrecord" >
	                <div class="op-fenlei ml20 clearfix">
	                    <ul class="records-ui clearfix transType">
	                        <li class="ui-title">交易分类：</li>
	                        <li class="current"><a>全部</a></li>
	                        <li id="tocharge"><a value="10">充值</a></li>
	                        <li id="withdraw"><a value="11">提现</a></li>
	                        <li ><a value="12">投资</a></li>
	                        <li ><a value="50">放款</a></li>
	                        <li ><a value="51">还款</a></li>
	                        <li ><a value="52">手续费</a></li>
	                        <li id="profit"><a value="40">收益</a></li>
	                    </ul>
	                    <ul class="records-ui clearfix transStatus">
	                        <li class="ui-title">交易状态：</li>
	                        <li class="current"><a>全部</a></li>
	                        <li><a value="00">成功</a></li>
	                        <li><a value="01">失败</a></li>
	                        <li><a value="02">处理中</a></li>
	                    </ul>
               			 </div>
                <div class="op-conduct ml20">
                     <div>
                     <input type="hidden"  id="hidednTime"  value="${hidednTime}/>
                    </div>
                    <div class="fl ">
                        <span class="op-title">时间范围</span>
                        <!--时间边框start-->
                        <input type="text" class="biao-time" id="startTime" value="${startTime}"
                        	onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endTime\')}'})"/>
                        <span class="op-title" > - </span>
                        <input type="text" class="biao-time" id="endTime"  value="${endTime}" 
                        onClick="WdatePicker({autoPickDate:'true',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startTime\')}'})"/>
                     <!--时间边框end-->
                       
                    </div>
                    <ul class="find-ui">
                        <li id="today"><a >今天</a></li>
                        <li id="oneMonth"><a >最近1个月</a></li>
                        <li id="threeMonth"><a >3个月</a></li>
                        <li id="oneYear"><a >1年</a></li>
                    </ul>
                    <a class="find-btn ml10" id="searchRecord" href="javascript:void(0);">查 询</a>
               	 </div>
		            <div id="transRecord" class="ml20 pl20 mr20 pr20">
		           		<#include "./transRecord/_transRecordPage.ftl" />
		           	</div>
			</div>
         </div>
    </div>
    <#include "./common/common_footer.ftl" />
	<script type="text/javascript" src="${basePath}/js/baibao/projectWindow.js"></script>
	<script>seajs.use("transRecord");</script>
    <script>seajs.use("permainH");</script>
        
   
</body>
</html>