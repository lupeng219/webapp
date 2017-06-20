    		<p><b>&nbsp;&nbsp;</b></p>
    		<ul class="inviteRecord">
    			<li class="recordTitle">
    				<!-- <span>序号</span> -->
    				<span>邀请用户</span>
    				<span>奖励金额</span>
    				<span class="registerTime" >发放时间</span>
    			</li>
    			<#if (list?? && list?size>0) >
	    			<#list list as item >
		    			<li>
		    			<!--	<span>${item_index+1}</span> -->
		    				<span>${item.pu_mobile}</span>
		    				<span>${item.puw_parvalue}元</span>
		    				<span class="registerTime">${item.puw_getTime}</span>
		    				<!--<span>${item.puwParvalue}</span>
		    				<#if item.puwState ==0>
		    					<span>未使用</span>
		    				<#elseif item.puwState == 1>
		    					<span>已使用</span>
		    				<#elseif item.puwState == 2>
		    					<span>已过期</span>
		    				<#else>
		    					<span>未使用</span>
		    				</#if>-->
		    			</li>
	    			</#list>
    			</#if>
    		</ul>
    		<#if list?? && (list?size>0) >
	            <p class="page-wap mt20">
	                <a href="javascript:void(0);" <#if (pageNum>=endNum)>class="notUse"</#if>  data-pageNo="${(pageNum<endNum)?string(pageNum+1,endNum)}">下一页</a>
	      	  		<a href="javascript:void(0);" <#if (pageNum<=1)>class="notUse"</#if> data-pageNo="${(pageNum>1)?string(pageNum-1,1)}">上一页</a>
	            </p>
	        <#else>
	        	<p class="no-record">暂无数据</p>
            </#if>
    	</div>
    	<script type="text/javascript">
			$(function(){
				$(".page-wap a").on("click",function(){
					if($(this).hasClass("notUse")){
						return false;
					}
					var pageNo=$(this).data("pageno");
					var params = {"pageNum":pageNo};
					$.ajax({
			            type:"POST",
			            url:root+"/service/wapActivity/ajaxRecomTender?refresh="+new Date().getTime(),
			            data:params,
			            datatype:"html",
			            beforeSend:function(){//$("#msg").html("logining");
			            },
			            success:function(data){
			            	$(".investments").html(data);
			            },
			            complete:function(XMLHttpRequest, textStatus){
			               //alert(XMLHttpRequest.responseText);
			               //alert(textStatus);
			              $(".investments").html(XMLHttpRequest.responseText);
			            },
			            error:function(){
			            	
			            }         
			        });
			     });
			});
		</script>
