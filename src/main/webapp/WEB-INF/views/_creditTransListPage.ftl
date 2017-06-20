<div class='content'>
    <h4 class='contList-title'>债权转让列表</h4>
    <table class='credit-tran' border="0">
                        <tr class='t-head' style='background:#ecfbff;'>
                            <td style='width:290px; padding-left:40px;'>项目名称</td>
                            <td style='width:125px;'>预期年化收益</td>
                            <td style='width:176px;'>转让金额</td>
                            <td style='width:104px;'>剩余期数</td>
                            <td class='td-last' style='width:130px;'>操作</td>
                        </tr>
                        <#list paging.pageList as productChild>
                         <tr>
                            <td class='td-first'><a href='${basePath}/service/productList/creditTransDetail?productNo=${productChild.ppProductno}'>${productChild.ppLoantitle}</a></td>
                            <td class='red'>${productChild.ppComprehensiverate?string("###.##")}%</td>
                            <td>${(productChild.ppLoanamount)?string(',##0.00')}元</td>
                            <td>${productChild.ppLoanterm}</td>
                            <#if productChild.ppBulkloanstatus=1>
                                <td class='td-last'><a href="${basePath}/service/productList/creditTransDetail?productNo=${productChild.ppProductno}" class="btn-tbiao mt10">立即投资</a></td>
                            <#else>
                                 <td class='td-last'><a href="${basePath}/service/productList/creditTransDetail?productNo=${productChild.ppProductno}" class="btn-mbiao mt10">已转让</a></td>
                            </#if>
                        </tr>
                        </#list>
                    </table>
<div>

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
				var params = {"currentPageNo":pageNo,"productType":productType,"loanTerm":loanTerm};
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
      
