                <ul class="records-project">
                    <li class="project-title">
                    	<span class="xuhao">序号</span>
                        <span>流水号</span>
                        <span>申请时间</span>
                        <span class="xuhao">金额</span>
                        <span class="xuhao">状态</span>
                        <span class="xuhao">备注</span>
                    </li>
                    <#if (paging.pageList?size >0)&&(paging??)>
		              	<#list paging.pageList as flow>
		              		 <li>
		              		 	<span class="xuhao">${flow_index+1}</span>
		                        <span>${flow.chargeFlowNo}</span>
		                        <span><#if flow.chargeTime??>${flow.chargeTime?string("yyyy-MM-dd HH:mm:ss")}</#if></span>
		                        <span class="xuhao"><#if flow.chargeMoney=="0">0.00元<#else>${flow.chargeMoney?string('###,##0.00')}元</#if></span>
		                        <span class="xuhao">
		                        	<#if flow.remarks ==4>
		                        		<#if flow.chargeStatus ==0>未收益</#if>
			                        	<#if flow.chargeStatus ==1>已收益</#if>
			                        	<#if flow.chargeStatus ==2>处理中</#if>
			                        <#else>
			                        	<#if flow.chargeStatus ==0>成功</#if>
			                        	<#if flow.chargeStatus ==1>失败</#if>
			                        	<#if flow.chargeStatus ==2>处理中</#if>
		                        	</#if>
		                        	
		                        </span>
		                        <span class="xuhao">
		                        	<#if flow.remarks ==1>充值</#if>
		                        	<#if flow.remarks ==2>提现</#if>
		                        	<#if flow.remarks ==3>投标</#if>
		                        	<#if flow.remarks ==4>收益</#if>
		                        </span>
		                   </li>
	                	</#list>
	              	<#else>
						<li>
							<p class="fl no-record">暂无数据</p>
						</li>
				   	</#if>
                </ul>
                <div class="baibao-pageye">
					<ul class="clearfix">
					    <li><a href="javascript:void(0)" class="prev-on"><</a></li>
					    <#list paging.startPageNo..paging.endPageNo as page>
					    <li><a href="javascript:ajaxPage(${page})" <#if page==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
					    </#list>
					    <li><a href="javascript:void(0)" class="prev-next">></a></li>
					</ul>
				</div>
            </div>
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
			var params = {"currentPageNo":pageNo,"transType":transType,"transStatus":transStatus,"startTime":startTime,"endTime":endTime};
			$.ajax({
	            type:"POST",
	            url:root+"/service/${ajaxPageUrl}?refresh="+new Date().getTime(),
	            data:params,
	            datatype:"json",
	            beforeSend:function(){//$("#msg").html("logining");
	            },
	            success:function(data){
	            	 $("#personalOldAccount").html("");
	            },
	            complete:function(XMLHttpRequest, textStatus){
	               //alert(XMLHttpRequest.responseText);
	               //alert(textStatus);
	               $("#personalOldAccount").html(XMLHttpRequest.responseText);
	            },
	            error:function(){
	            	
	            }         
	        });
		}
	</script>
	