
<div class="divtab borrow-con">
    <ul class="conduct-project paid-off paidOFF">
        <li class="project-title">
            <span class='t_r mb_earn'>借款金额</span>
            <span class='t_r' style='position:relative;'>年利率</span>
            <span class='t_r'>还款金额</span>
            <span class='t_r'>状态</span>
            <!--<span style="text-align:center">操作</span>-->
        </li>
        <#if (hasPaidOffpaging??)&&(hasPaidOffpaging.pageListMap?size>0)>
       	<#list hasPaidOffpaging.pageListMap as hasPaidOff>
	        <li class="li-data">
	        	<!--<a style="width:18%" href="${basePath}/service/tender/productDetails?productNo=${repaymentIn.pp_ProductNo}" title="${hasPaidOff.pp_loanTitle}" class="ellipsis2">${hasPaidOff.pp_loanTitle}</a>-->
	            <span class='t_r'>${hasPaidOff.pp_loanAmount?string(',###.00')}元</span>
	            <#if hasPaidOff.pp_investmentType == 3>
	            	<span class='t_r'>详见合同</span>
	            <#else>
	            	<span class='t_r'>${hasPaidOff.pp_comprehensiveRate}%</span>
	            </#if>
	            <span class='t_r'><#if hasPaidOff.prb_repaymentPrincipal?? >${hasPaidOff.prb_repaymentPrincipal?string(',###.00')}元</#if></span>
	            <span class='t_r'>已还清</span>  
	            <!--<span style="text-align:center;">
	                <a class="btn btn-warning ml5 contract" href="${basePath}/service/agreement/getBorrowContractList?productNo=${hasPaidOff.pp_ProductNo}"" target="_blank">查看协议</a>
	            </span>-->
	    	</li>
    	</#list>
    	<#else>
			
				<p class="fl no-record" style="padding:40px 0">暂无数据</p>
			
    	</#if>
    </ul>
     <#if (hasPaidOffpaging??)&&(hasPaidOffpaging.pageListMap?size>0)>
	<div class="baibao-pageye">
		<ul class="clearfix">
		    <li><a href="javascript:ajaxPageHasPaid(1)" class="prev-first"></a></li>
			<li><a href="javascript:void(0)" class="prev-on hason"></a></li>
			<#list hasPaidOffpaging.startPageNo..hasPaidOffpaging.fenge as page>
			<li><a href="javascript:ajaxPageHasPaid(${page})" <#if page==hasPaidOffpaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
			${page}
			</a></li>
			</#list>
			<#if hasPaidOffpaging.pageNo<hasPaidOffpaging.pageTotal-1>
			<#if 3<hasPaidOffpaging.pageTotal>
			<li style="padding:3px"><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
			</#if>
			<li><a href="javascript:ajaxPageHasPaid(${hasPaidOffpaging.pageTotal})" <#if hasPaidOffpaging.pageTotal==hasPaidOffpaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
				${hasPaidOffpaging.pageTotal}
			</a></li>
			</#if>
			<li><a href="javascript:void(0)" class="prev-next hasnex"></a></li>
			<li><a href="javascript:ajaxPageHasPaid(${hasPaidOffpaging.pageTotal})" class="prev-last"></a></li>
		</ul>
	</div>
	</#if>
</div>
<script type="text/javascript">
	$(function(){
		var pageTotal = ${hasPaidOffpaging.pageTotal};
		var pageNo = ${hasPaidOffpaging.pageNo};
		$(".hason").on("click",function(){
			if(pageNo-1<1){ajaxPageHasPaid(1);}
			else{ajaxPageHasPaid(pageNo-1);}
		});
		$(".hasnex").on("click",function(){
			if(pageNo+1>pageTotal){ajaxPageHasPaid(pageTotal);}
			else{ajaxPageHasPaid(pageNo+1);}
		});
	});
	function ajaxPageHasPaid(pageNo){
		var params = {"currentPageNo":pageNo};
		$.ajax({
            type:"POST",
            url:root+"/service/${hasPaidOffPageUrl}?refresh="+new Date().getTime(),
            data:params,
            datatype:"html",
            beforeSend:function(){
            },
            success:function(data){
            	$("#paidFinished").html(data);
            },
            complete:function(XMLHttpRequest, textStatus){
               $("#paidFinished").html(XMLHttpRequest.responseText);
            },
            error:function(){
            	
            }         
        });
	};
</script>