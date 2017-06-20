<!DOCTYPE html>
<html>
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/index.css">
</head>
<body>
    <div class="wrap">
        <header class="index-header" style="position: relative;">
            <img src="${basePath }/images/wap/2baibao-logo.jpg" class="logo"/>
            <#if Session["CURRENT_LOGIN_USER"]?exists>
                 <a href="${basePath }/service/wapAccount/wapAccountIndex" class="fr mr40">
                 	 ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}
             	 </a>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon1"></a>
		    <#else>
		    	 <a href="${basePath}/service/wapRegister/toWapRegister" class="mr20">注册</a>
            	 <a href="${basePath}/service/wapLogin/toWapLogin" class="mr5">登录</a>
		    </#if>
        </header>
        <div class="index-wrap">
            <div class="wap-banner">
            	<ul>
            		<#list indexPicture as item>
	            		<li class="bannerLi">
	            			<#if item.activityUrl?exists>
	            				<a href="${basePath}${item.activityUrl}" target="_blank">
	            					<img src="${item.interimPathUrl}"/>
	            				</a>
	            			<#else>
	            				<a href="javascript:void(0);">
	            					<img src="${item.interimPathUrl}"/>
	            				</a>
	            			</#if>
	            		</li>
	            	</#list>
            	</ul>
            	<a class="prev" href="javascript:void(0)"></a>
            	<a class="next" href="javascript:void(0)"></a>
            </div>
            <script type="text/javascript">
            	jQuery(".wap-banner").slide({mainCell:"ul",effect:"leftLoop",autoPlay:true,delayTime:500,pnLoop:true,mouseOverStop:true});
            </script>
            <div class="wap-sum">
                <div class="wapsum-1" onclick="window.location.href='${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${noviceExclusive.ppProductno}'">
                    <p class="sum-title">新手专享</p>
                    <ul>
                    	<li>
                    		<p class="list-t">年化收益</p>
                    		<p class="list-d"><span style="color:#ec3a17;">${noviceExclusive.ppComprehensiverate}%</span></p>
                        </p>
                		</li>
                    	<li>
							<p class="list-t">期限</p>
							<p class="list-d">
								${noviceExclusive.ppLoanterm}<#if noviceExclusive.ppLoanrepayment=2>天<#else>个月</#if>
							</p>
						</li>
                    	<li>
                    		<p class="list-t">项目总额(元)</p>
                    		<p class="list-d">${noviceExclusive.ppLoanamount}</p>
                    	</li>
                    </ul>
                </div>
            </div>

            <div class="touzi-con">
                <div class="tjxm-icon"></div>
                <p class="touzi-title-con">
                	<a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${productList.pp_productNo}" title="${productList.pp_loanTitle}">
                    	<span class="touzi-title">${productList.pp_loanTitle}</span>
                	</a>
                </p>
                <p class="nll-sty"><span>${(productList.pp_comprehensiveRate)}%</span></p>
                <ul class="ui-listbiao">
                    <li><p class="list-t">项目总额(元)</p>
                        <p class="list-d">
                        	${productList.pp_loanAmount}
                        </p>
                    </li>
                    <li><p class="list-t">期限</p>
                        <p class="list-d">${productList.pp_loanTerm}<#if productList.pp_loanRepayment==2>天<#else>个月</#if></p></li>

                    <li style="border:0;">
                    	<p class="list-t">起投金额(元)</p>
                    	<p class="list-d">${productList.pp_terderMinAmount}</p>
                    </li>
                </ul>
               	
               	<#if productList.pp_bulkLoanStatus==1>
	               	<p class="logion-btn">
		               	<a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${productList.pp_productNo}" class="clearfix" style="width:100%;">
		               		立即投资
		               	</a>
	               	</p>
           	    </#if>
           	    <#if productList.pp_bulkLoanStatus==2>
       	    		<p class="logion-btn manbiao-btn">
		               	<a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${productList.pp_productNo}" class="clearfix" style="width:100%;">
		               	已满标
		               	</a>
               		</p>
           	    </#if>
           	    <#if productList.pp_bulkLoanStatus==4>
       	    		<p class="logion-btn manbiao-btn">
		               	<a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${productList.pp_productNo}" class="clearfix" style="width:100%;">
		               		还款中
		               	</a>
               		</p>
           	    </#if>
       	        <#if productList.pp_bulkLoanStatus==5>
   	        		<p class="logion-btn manbiao-btn">
		               	<a href="${basePath}/service/wapBulkLoan/wapProductDetails?productNo=${productList.pp_productNo}" class="clearfix" style="width:100%;">
		               			已完成
		               	</a>
               		</p>
           	    </#if>
                <p style="text-align:center;margin-top: 20px;"><a href="${basePath}/service/wapBulkLoan/showProductList ">查看更多</a></p>
            </div>
        </div>
		<#include "./wap/common/wap_common_footer.ftl" />
		<!-- script type="text/javascript" src="${basePath}/js/wap/wapIndex.js"></script -->
		<script type="text/javascript">
			var startX,startY,moveEndX,moveEndY,X,Y;
			$(".bannerLi").on("touchstart", function(e){
				e.preventDefault();
				startX=e.originalEvent.changedTouches[0].pageX;
				startY=e.originalEvent.changedTouches[0].pageY;
			});
			$(".bannerLi").on("touchend",function(e){
				e.preventDefault();
				moveEndX=e.originalEvent.changedTouches[0].pageX;
				moveEndY=e.originalEvent.changedTouches[0].pageY;
				X=moveEndX-startX;
				Y=moveEndY-startY;
				if(Math.abs(X)>Math.abs(Y)&&X>0){
					$(".prev").click();
					/* alert("left 2 right"); */
				}else if(Math.abs(X)>Math.abs(Y)&&X<0){
					$(".next").click();
					/* alert("right 2 left"); */
				}else if(Math.abs(Y)>Math.abs(X)&&Y>0){
					/* alert("top 2 bottom"); */
				}else if(Math.abs(Y)>Math.abs(X)&&Y<0){
					/* alert("bottom 2 top"); */
				}else{
					/* alert("just touch"); */
					window.location.href=$(this).find("a").attr("href");
				}
			});
		</script>
    </div>
</body>
</html>