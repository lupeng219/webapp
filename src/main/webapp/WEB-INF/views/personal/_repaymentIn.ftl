
<div id="repaymentInPage">
    <ul class="borrow-project" style="margin-left: 40px;margin-right: 40px;">
         <li class="borrow-title">
            <span style="text-align:right;padding-left:0;">借款金额</span>
            <span style="width:6%;text-align:right;position:relative;">年利率</span>
            <span style="width:12%;text-align:right">剩余期数</span>
            <span style="text-align:right">下个还款日</span>
            <span style="text-align:right">还款金额</span>
            <span style="text-align:right">状态</span>
            <span style="width:18%;text-align:center">操作</span>
         </li>
         <#if (repaymentInpaging??)&&(repaymentInpaging.pageListMap?size>0)>
	       	 <#list repaymentInpaging.pageListMap as repaymentIn>
		       	 <li class="li-data">
		       	 	<!--<a href="${basePath}/service/productList/productDetails?productNo=${repaymentIn.pp_ProductNo}" target="_blank" title="${repaymentIn.pp_loanTitle}" class="ellipsis2">${repaymentIn.pp_loanTitle}</a>-->
		           	<#if repaymentIn.pp_loanAmount==null>
		           	<span style="text-align:right;padding-left:0;">0元</span>
		           	<#else>
		            <span style="text-align:right;padding-left:0;">${repaymentIn.pp_loanAmount?string(',###.00')}元</span>
		            </#if>
		            <#if repaymentIn.pp_investmentType == 3>
		            	<span style="width:6%;text-align:right">详见合同</span>
		            <#else>
		            	<span style="width:6%;text-align:right">${repaymentIn.pp_comprehensiveRate}%</span>
		            </#if>
		            <span style="width:12%;text-align:right">${repaymentIn.repaymentBillCount}<!--/${repaymentIn.termCount}--></span>
		            <span style="text-align:right"><#if repaymentIn.prb_repaymentTime??>${repaymentIn.prb_repaymentTime?string("yyyy-MM-dd")}</#if></span>
		            <span style="text-align:right"><#if repaymentIn.prb_repaymentPrincipal??>${repaymentIn.prb_repaymentPrincipal?string(',###.00')}</#if>元</span>
		            <span style="text-align:right">
		            	<#switch repaymentIn.prb_repaymentStatus> 
							<#case 0>还款中<#break> 
							<#case 2>逾期<#break> 
							<#case 4>处理中<#break> 
						</#switch>
		            </span>
                    <#if repaymentIn.pp_investmentType!=3>
		            <span style="width:18%;text-align:center">
		                <!--
		            	<#if repaymentIn.prb_repaymentStatus==4>
		            		<button class="btn" style="color:#7C7C7C;cursor:no-drop;" title="处理中...">还款</button>
	            		<#else>
	            			<button class="btn btn-warning repaymentBtn" data-available="true" data-productNo="${repaymentIn.pp_ProductNo}">还款</button>
		            	</#if>
		            	-->
		        	</span>
                   </#if>
		        </li>
	        </#list>
        
            <#else>
            
                <p class="fl no-record" style="padding:40px 0">暂无数据</p>
            
            </#if>
    </ul>
         <#if (repaymentInpaging??)&&(repaymentInpaging.pageListMap?size>0)>
        <div class="baibao-pageye">
            <ul class="clearfix">
                <li><a href="javascript:ajaxPageRepayment(1)" class="prev-first"></a></li>
                <li><a href="javascript:void(0)" class="prev-on repayon"></a></li>
                <#list repaymentInpaging.startPageNo..repaymentInpaging.fenge as page>
                <li><a href="javascript:ajaxPageRepayment(${page})" <#if page==repaymentInpaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
                </#list>
               <#if repaymentInpaging.pageNo<repaymentInpaging.pageTotal-1>
                <#if 3<repaymentInpaging.pageTotal>
                <li style="padding:3px"><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
                </#if>
                <li><a href="javascript:ajaxPageRepayment(${repaymentInpaging.pageTotal})" <#if repaymentInpaging.pageTotal==repaymentInpaging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
                    ${repaymentInpaging.pageTotal}
                </a></li>
                </#if>
                <li><a href="javascript:void(0)" class="prev-next repaynext"></a></li>
                <li><a href="javascript:ajaxPageRepayment(${repaymentInpaging.pageTotal})" class="prev-last"></a></li>
            
            </ul>
        </div>
        </#if>
</div>
<script type="text/javascript">
    $(function(){
        var pageTotal = ${repaymentInpaging.pageTotal};
        var pageNo = ${repaymentInpaging.pageNo};
        $(".repayon").on("click",function(){
            if(pageNo-1<1){ajaxPageRepayment(1);}
            else{ajaxPageRepayment(pageNo-1);}
        });
        $(".repaynext").on("click",function(){
            if(pageNo+1>pageTotal){ajaxPageRepayment(pageTotal);}
            else{ajaxPageRepayment(pageNo+1);}
        });
    });
    function ajaxPageRepayment(pageNo){
        var params = {"currentPageNo":pageNo};
        $.ajax({
            type:"POST",
            url:root+"/service/${repaymentInPageUrl}?refresh="+new Date().getTime(),
            data:params,
            datatype:"html",
            beforeSend:function(){
            },
            success:function(data){
                $("#repaymentInPage").html(data);
            },
            complete:function(XMLHttpRequest, textStatus){
               $("#baibao-paging").html(XMLHttpRequest.responseText);
            },
            error:function(){
                
            }         
        });
    };

</script>
