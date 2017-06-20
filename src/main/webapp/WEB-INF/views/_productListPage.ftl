                  <#setting number_format="#">
                   <div class="changeColor"> 
                  	<ul >
                  <#list paging.pageList as productChild>
                  		<li>
                  		<#if productChild.type ==1>
                  			<div class="invest-biao-con clearfix" onclick="window.location.href='${basePath}/service/productList/productDetails?productNo=${productChild.ppProductno}'";>
                  		<#elseif productChild.type ==2>
                  			<div class="invest-biao-con clearfix" onclick="window.location.href='${basePath}/service/productList/productDetail?productNo=${productChild.ppProductno}'";>
                  		</#if>
                    	
                        <div class="biao-title-con1">
                             <p class="biao-title ellipsis"><a href="javascript:void(0);" title="${productChild.ppLoantitle}">${productChild.ppLoantitle}</a></p>
                            <span class="biao-bzcon"> <#if productChild.ppLoanrepayment=0>
                           	 等额本息
                           	<#elseif productChild.ppLoanrepayment=1>
        					先息后本
        					<#elseif productChild.ppLoanrepayment=2>
        					按天计息
        					<#elseif productChild.ppLoanrepayment=3>
        					等额本金
                            <#elseif productChild.ppLoanrepayment=4>
                                                        先息后本
                            <#elseif productChild.ppLoanrepayment = 5>
                            	到期本息
                            </#if></span>
                        </div>
                        <div class="biao-desc-con">
                            <p class="pt5">
                            	预期年化收益 <span class="font18 red"><span class="font36"><#if productChild.ppComprehensiverate??>${productChild.ppComprehensiverate?string("###.##")}</#if></span>%</span>
                        		<span class="pl28">起投金额 ${productChild.ppTerderminamount?string.number}元</span>
                        	</p>
                            <p><span>投资总额 ${productChild.ppLoanamount?string.number}元</span>
                                <span class=" pl15">投资期限 <span class="red">${productChild.ppLoanterm}</span>
                                	<#if productChild.ppLoanrepayment=2>
                                		天
                                	<#elseif productChild.ppLoanrepayment = 5>
                                		天
                                	<#else>
                                		个月
                                	</#if>
                                </span>
                            </p>
                        </div>
                        <div class="biao-jindu-con">
                            <div class="rings biao-ring">
                            	<#if productChild.ppBulkloanstatus='2' || productChild.ppBulkloanstatus='4' || productChild.ppBulkloanstatus="5">
                            	<p>100%</p>
                            	<#else>
                            	<p><#if productChild.ppLoanamountexist*100/productChild.ppLoanamount<1>
                            	<#if productChild.ppLoanamountexist*100/productChild.ppLoanamount==0>
                            	0%
                            	<#else>
                            	1%
                            	</#if>
                            	<#else>
                            	${(productChild.ppLoanamountexist*100/productChild.ppLoanamount)?floor}%</#if></p>
                            	</#if>
                                
                            </div>
                        </div>
                        <div class="biao-tbbtn-con">
 							<#if productChild.ppBulkloanstatus=0>
 								<a href="javascript:void(0);" class="btn-tbiao mt20">待开放</a>
                          	<#elseif productChild.ppBulkloanstatus=1>
        					 	<a href="javascript:void(0);" class="btn-tbiao mt20">立即投资</a>
                         	<#elseif productChild.ppBulkloanstatus=2>
        					 	<a href="javascript:void(0);" class="btn-mbiao mt20">已满标</a>
    					 	<#elseif productChild.ppBulkloanstatus=3>
			                    <a href="javascript:void(0);" class="btn-mbiao mt20">流标</a>
    					 	<#elseif productChild.ppBulkloanstatus=4>
        					    <a href="javascript:void(0);" class="btn-mbiao mt20">还款中</a>                  
    					 	<#elseif productChild.ppBulkloanstatus=5>
        					    <a href="javascript:void(0);" class="btn-mbiao mt20">已完成</a>
    					    </#if>          
                        </div>
                    </div>
                   </li> 
					</#list>
				</ul>
			</div>		
	<#if (paging??)&&(0<paging.pageList?size)>
    <div id="baibao-paging" class="baibao-pageye">
       <div class="baibao-pageye">
			<ul class="clearfix">
			<li><a href="javascript:ajaxPage(1)" class="prev-first"></a></li>
			<li><a href="javascript:void(0)" class="prev-on"></a></li>
			<#list paging.startPageNo..paging.fenge as page>
			<li><a href="javascript:ajaxPage(${page})" <#if page==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
			${page}
			</a></li>
			</#list>
			<#if paging.pageNo<paging.pageTotal-1>
			<#if 3<paging.pageTotal>
			<li style="padding:3px"><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
			</#if>
			<li><a href="javascript:ajaxPage(${paging.pageTotal})" <#if paging.pageTotal==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
				${paging.pageTotal}
			</a></li>
			</#if>
			<li><a href="javascript:void(0)" class="prev-next"></a></li>
			<li><a href="javascript:ajaxPage(${paging.pageTotal})" class="prev-last"></a></li>
			</ul>
			<script type="text/javascript">
			$(function(){
				var pageTotal = ${paging.pageTotal};
				var pageNo = ${paging.pageNo};
				$(".prev-on").on("click",function(){
					if(pageNo-1<1){ajaxPage(1);}
					else{ajaxPage(pageNo-1);}
				});
				$(".prev-next").on("click",function(){
					if(pageNo+1>pageTotal){ajaxPage(pageTotal);}
					else{ajaxPage(pageNo+1);}
				});
			});
			function ajaxPage(pageNo){
			 	var productType =$(".productType").find(".cut a").attr("value");
			 	var loanTerm=$(".productTerm").find(".cut a").attr("value");
			 	var bulkStatus =$(".productStatus").find(".cut a").attr("value");
				var params = {"currentPageNo":pageNo,"productType":productType,"loanTerm":loanTerm,"bulkStatus":bulkStatus};
				$.ajax({
		            type:"POST",
		            url:root+"/service/${ajaxPageUrl}?refresh="+new Date().getTime(),
		            data:params,
		            datatype:"html",
		            beforeSend:function(){//$("#msg").html("logining");
		            },
		            success:function(data){
		            	$("#productListPage").html("");
		            	$(".baibao-pageye").html(data);
		            },
		            complete:function(XMLHttpRequest, textStatus){
		               //alert(XMLHttpRequest.responseText);
		               //alert(textStatus);
		               $("#productListPage").html(XMLHttpRequest.responseText);
		               jinDu();
		            },
		            error:function(){
		            	
		            }         
		        });
                $(document).scrollTop(0);
                
			}
					</script>
			</div>
        </div>
      <#else>
			<p class="fl no-record investnorecord" >暂无数据</p>
      </#if>
      
