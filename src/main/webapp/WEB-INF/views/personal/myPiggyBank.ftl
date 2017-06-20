<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
	<title>我的存钱罐-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
	<meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
	<meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-recharge.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/my-money.css"/>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />
    <div class="personal-main ">
        <div class="container">
        	<#if result.isRealName??&&result.isRealName==true>
	            <div class="per-txtcon clearfix" style="padding:0; width:1118px;">
	                <img src="${basePath}/images/mymoney1.jpg" width="1118" height="320"/>
	                <div class="sina-renzheng">
	                    <ul class="fl">
	                        <li>姓名：	${result.puiRealName}</li>
	                        <li>身份证号码：	${result.PuiCertNo?substring(0,3)+"****"+result.PuiCertNo?substring(14,18)}</li>
	                        <li>您的新浪支付存钱罐账号：	${result.custNo}</li>
	                    </ul>
	                    <a href="${basePath}/service/piggyBank/showMemberInfosSina" class="sina-rzbtn fr" target="view_window">去新浪支付查询验证</a>
	                </div>
	                <div class="sina-money">
	                    <ul class="fl">
	                        <li><p><span>${result.availableBalance}</span>元</p>
	                            <p>存钱罐余额</p></li>
	                        <li><p><span>${result.totalRevenue}</span>元</p>
	                            <p>累计收益</p></li>
	                        <li><p><span>${result.earningsYesterday}</span>元</p>
	                            <p>昨日收益</p></li>
	                        <!--li><p><span>0.</span>00元</p>
	                            <p>近一周收益</p></li-->
	                        <li><p><span>${result.januaryEarnings}</span>元</p>
	                            <p>近一月收益</p></li>
	                    </ul>
	                    <div class="cztx-btn fr">
	                        <a href="${basePath}/service/account/torecharge" class="cz-btn">充 值</a>
	                        <a href="${basePath}/service/account/towithdrawals" class="tx-btn">提 现</a>
	                    </div>
	                </div>
	            </div>
	            <div class="per-txtcon" id="chartContainer" style="padding:20px 25px;height:300px;"></div>
	            <div class="per-txtcon">
	                <div class="per-mknav">
	                    <span class="mk-title">收益时间表</span>
	                </div>
	                <div class="clearfix mt20">
	                    <table class="tab-ant" cellpadding="0" cellspacing="0">
	                        <tr class="tr-title">
	                            <td>购买时间</td>
	                            <td>开始计算收益时间</td>
	                            <td style="border-right:0;">首次显示收益时间</td>
	                        </tr>
	                        <tr>
	                            <td>周一15:00—周二15:00前</td>
	                            <td>周三</td>
	                            <td style="border-right:0;">周四</td>
	                        </tr>
	                        <tr>
	                            <td>周二15:00—周三15:00前</td>
	                            <td>周四</td>
	                            <td style="border-right:0;">周五</td>
	                        </tr>
	                        <tr>
	                            <td>周三15:00—周四15:00前</td>
	                            <td>周五（可享受周六周日收益）</td>
	                            <td style="border-right:0;">下周一（显示周五周六周日三天收益）</td>
	                        </tr>
	                        <tr>
	                            <td>周四15:00—周五15:00前</td>
	                            <td>下周一（不享受周六周日收益）</td>
	                            <td style="border-right:0;">下周二</td>
	                        </tr>
	                        <tr>
	                            <td>周五15:00—下周一15:00前</td>
	                            <td>下周二</td>
	                            <td style="border-right:0;">下周三</td>
	                        </tr>
	                    </table>
	                </div>
	            </div>
			<#else>
				<div class="recharge-main">
	        		<h2 class="main-title">实名认证</h2>
	            	<div class="quick-recharge">
	                	<div class="rechmoney-con">
	                        <div class="bang-card mt20">
	                            <ul class="bangcard-ui">
	                                <li class="ms">
	                                    <div class="clearfix">
		                                    <span class="card-title">真实姓名</span>
		                                    <input type="text" class="bank-txt" id="realName" autocomplete="off" value="${result.realName}"/>
	                                    </div>
	                                    <p class="errbank-p"></p>
	                                </li>
	                                <li class="ms">
	                                    <div class="clearfix">
		                                    <span class="card-title">身份证号</span>
		                                    <input type="text" class="bank-txt" id="idCard" autocomplete="off" value="${result.idCard}"/>
	                                    </div>
	                                    <p class="errbank-p"></p>
	                                </li>
	                                <li class="ms">
	                                    <span class="card-title"> &nbsp;</span>
	                                    <a href="javascript:void(0);" class="rechmoney-btn" id="startAuthentication" data-available="true">实名认证</a>
	                                </li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	        	</div>
        	</#if>
        </div>
    </div>
	<#include "./common/common_footer.ftl" />
	<#if result.isRealName??&&result.isRealName==true>
		<script type="text/javascript" src="${basePath}/js/public/echarts-all.js"></script>
		<script type="text/javascript">
			var myChart = echarts.init(document.getElementById('chartContainer'));
			var yieldRate = [];  
	        var month = [];
	        $.ajaxSettings.async = false;
			// 加载数据  
		    $.post(root+"/service/piggyBank/getYieldrate", {}, function(data) {
		    	yieldRate = data.yieldRate;
		        month = data.date;
		    },"json"); 
	        var option = {
	        	backgroundColor:'#fff',
	        	title:{
	        		show:true,
	        		text:'七日年化收益率',
	        		x:'left',
	        		y:'top',
	        		textStyle:{
	        			fontSize:20
	        		}
	        	},
	        	tooltip : {
		        trigger: 'axis'
		    	},
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    grid:{
			    	x:60,
			    	x2:60
			    },
			    calculable : true,
			    xAxis : [
			        {	
			            type : 'category',
			            boundaryGap : false,
			            data : month
			        }
			    ],
			    yAxis : [
			        {	
			        	name:'收益率(%)',
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'收益率(%)',
			            type:'line',
			            data:yieldRate
			        }
			    ]
			};
	        myChart.setOption(option);
		</script>
	<#else>
		<script>
	    	seajs.use("myPiggyBank");
		</script>
	</#if>
</body>
</html>