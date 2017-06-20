        <ul class="records-project">
                    <li class="project-title">
                    	<span style="width:6%;">序号</span>
                        <span style="width:18%;">交易时间</span>
                        <span style="width:20%;">交易金额</span>
                        <span style="width:12%;">交易类型</span>
                        <span style="width:11%;">状态</span>
                        <span style="width:21%;">备注</span> 
                    </li>
        </ul>  
       	 <div class="changeColor" >       
        	<ul class="records-project" style="margin-top:0px">         
                <#if paging.pageList??>
	              <#list paging.pageList as accountFlow>
					<li>
						<span style="width:6%;">${accountFlow_index+1}</span>
                        <span style="width:18%;"><#if accountFlow.pafTransactiondatetime??>${accountFlow.pafTransactiondatetime?string("yyyy-MM-dd HH:mm:ss")}</#if></span>
                        <span style="width:20%;" class="pink"><#if accountFlow.pafTransactionmoney=="0">0.00元<#else>${accountFlow.pafTransactionmoney?string('###,##0.00')}元</#if></span>
				        <span style="width:12%;">
                        <#if accountFlow.pafTransactiontype=="10">
                        充值
                        <#elseif accountFlow.pafTransactiontype=="11">
                        提现
                        <#elseif accountFlow.pafTransactiontype=="12">
                        投资
                        <#elseif accountFlow.pafTransactiontype=="50">
                        放款
                        <#elseif accountFlow.pafTransactiontype=="51">
                        还款
                        <#elseif accountFlow.pafTransactiontype=="52">
                        手续费
                        <#elseif accountFlow.pafTransactiontype=="40">
                        收益
                        </#if>
                        </span>
				        <span style="width:11%;">
				        	<#if accountFlow.pafStatus=="00">
				         		成功
				        	<#elseif accountFlow.pafStatus=="01">
				        		失败
				        	<#elseif accountFlow.pafStatus=="02">
				        		处理中
				        	</#if>
				        </span>
				        <span style="width:21%;" class='bzinfo'
				            title="${accountFlow.pafRemark}">
				            ${accountFlow.pafRemark}
				        </span>
				    </li>
				</#list>
			  <#else>
				<li>
					<p class="fl no-record">暂无数据</p>
				</li>
			  </#if>
            </ul>
            </div>   
            <#if 0!=paging.pageList?size>
            <div id="baibao-paging" class="baibao-pageye">
			<div class="baibao-pageye" >
			<ul class=" clearfix">
				<li><a href="javascript:ajaxPage(1)" class="prev-first"></a></li>
			    <li><a href="javascript:void(0)" class="prev-on"></a></li>
			    <#list paging.startPageNo..paging.fenge as page>
			    <li><a href="javascript:ajaxPage(${page})" <#if page==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
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
			</div>
			</div>
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
				var startTime =$("#startTime").val();
				var endTime =$("#endTime").val();
				var transType=$(".transType").find(".current a").attr("value");
				var transStatus =$(".transStatus").find(".current a").attr("value");
				var time =$('.find-ui').find(".current").attr("id");
					  if(time=="today"){
						  startTime =CurentDate()+" 00:00:00";
						  endTime =CurentTime();
					  }else if(time=="oneMonth"){
						  startTime =getLastMonth();
						  endTime =CurentTime();
					  }else if(time=="threeMonth"){
						  startTime =getLastThreeMonth();
						  endTime =CurentTime();
					  }else if(time=="oneYear"){
						  startTime =getLastYear();
						  endTime =CurentTime();
					  }
					var params = {"currentPageNo":pageNo,"transType":transType,"transStatus":transStatus,"startTime":startTime,"endTime":endTime};
					$.ajax({
			            type:"POST",
			            url:root+"/service/${ajaxPageUrl}?refresh="+new Date().getTime(),
			            data:params,
			            datatype:"html",
			            beforeSend:function(){//$("#msg").html("logining");
			            },
			            success:function(data){
			            	 $("#transRecord").html("");
			            },
			            complete:function(XMLHttpRequest, textStatus){
			               //alert(XMLHttpRequest.responseText);
			               //alert(textStatus);
			               $("#transRecord").html(XMLHttpRequest.responseText);
			            },
			            error:function(){
			            	
			            }         
			        });
				}
                   
				</script>
			 <#else>
			<p class="fl no-record" style="padding-top:30px" >暂无数据</p>
      </#if>

<script type='text/javascript'>       
/*var len = $(".bzinfo").size();

for(var i = 0;i < len; i++)
{
    $(".bzinfo").eq(i).on('mouseover',function(){
        var cont=$(this).html();
         
         $(this).attr('title',$.trim(cont));
    });
}*/
</script>