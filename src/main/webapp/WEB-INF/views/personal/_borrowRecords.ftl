<div id="loanApplicationPage">
	<ul class="conduct-project" style="margin-left: 40px;margin-right: 40px;">
	    <li class="project-title">
	    	<span>借款人手机号</span>
	    	<span style="width: 6%;text-align:right;">借款期限</span>
	        <span style="text-align:right;">借款金额</span>
	        <span style="text-align:right;">申请时间</span>
	        <span style="text-align:center;margin-left:50px;">状态</span>
	    </li>
	    <#if (loanApplicationpaging??)&&(loanApplicationpaging.pageList?size>0)>
	    <#list loanApplicationpaging.pageList as loanApply>
	    <li class="li-data">
	    	<span>${loanApply.puMobile}</span>
	    	<span style="width: 6%;text-align:right;">${loanApply.ppLoanterm}个月</span>
	        <span style="text-align:right;">${loanApply.ppLoanamount?string(',###.00')}元</span>
	        <span style="text-align:right;">${loanApply.ppLoanapplytime?string("yyyy-MM-dd HH:mm:ss")}</span>
	        <span style="text-align:center;margin-left:50px;">
	        	<#if loanApply.ppLoanapplystatus=21>
	        		未回访
	        	<#else>
	        		已回访
	        	</#if>
	        </span>
	    </li>
	    </#list>
	    <#else>
				<p class="fl no-record" style="padding:40px 0">暂无数据</p>
	    </#if>
	</ul>
	 <#if (loanApplicationpaging??)&&(loanApplicationpaging.pageList?size>0)>
	<div class="baibao-pageye" style="margin:40px 40px 40px 0px;">
		<ul class="clearfix">
			<li><a href="javascript:ajaxPage(1)" class="prev-first"></a></li>
		    <li><a href="javascript:void(0)" class="prev-on boron"></a></li>
		    <#list loanApplicationpaging.startPageNo..loanApplicationpaging.endPageNo as page>
		    <li><a href="javascript:ajaxPage(${page})" <#if page==loanApplicationpaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
		    </#list>
		    <#if loanApplicationpaging.pageNo<loanApplicationpaging.pageTotal-1>
			<#if 3<loanApplicationpaging.pageTotal>
			<li style="padding:3px"><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
			</#if>
			<li><a href="javascript:ajaxPage(${loanApplicationpaging.pageTotal})" <#if loanApplicationpaging.pageTotal==loanApplicationpaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
				${loanApplicationpaging.pageTotal}
			</a></li>
			</#if>
			<li><a href="javascript:void(0)" class="prev-next bornext"></a></li>
			<li><a href="javascript:ajaxPage(${loanApplicationpaging.pageTotal})" class="prev-last"></a></li>
			</ul>
	</div>
	</#if>
</div>
<script type="text/javascript">
	$(function(){
		var pageTotal = ${loanApplicationpaging.pageTotal};
		var pageNo = ${loanApplicationpaging.pageNo};
		$(".boron").on("click",function(){
			if(pageNo-1<1){ajaxPage(1);}
			else{ajaxPage(pageNo-1);}
		});
		$(".bornext").on("click",function(){
			if(pageNo+1>pageTotal){ajaxPage(pageTotal);}
			else{ajaxPage(pageNo+1);}
		});
	});
	function ajaxPage(pageNo){
		var params = {"currentPageNo":pageNo};
		$.ajax({
            type:"POST",
            url:root+"/service/${loanApplicationPageUrl}?refresh="+new Date().getTime(),
            data:params,
            datatype:"html",
            beforeSend:function(){
            },
            success:function(data){
            	$("#loanApplicationPage").html(data);
            },
            complete:function(XMLHttpRequest, textStatus){
               $("#baibao-paging").html(XMLHttpRequest.responseText);
            },
            error:function(){
            	
            }         
        });
	}
</script>