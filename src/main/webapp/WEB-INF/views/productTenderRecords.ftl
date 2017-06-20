
<style>
.zshu li span:not(.strong):not(:first-child) {
	margin-left: -4px;
}

</style>
<!-- 投标记录 -->
<!--<p class="tzpeople-sum "><span>加入人次 ${paging.countTotal} 人</span> <span class="pl30">投标总额 ${productDetail.ppLoanamountexist}元</span></p>-->
<div class="zshu">
<ul>
    <li class="jl-title" style="background:#eeeeee;"><span class="strong">序号</span><span class="strong">投资人</span><span class="strong">投资金额</span><span class="strong">投资时间</span></li>
   	<#list paging.pageList as record>
        <li <#if record?index%2!=0>class="jl-title"</#if>>
      		<span>${record_index+1}</span>
      		<span>   
          		<#if record.pu_mobile="">
          			****
          		<#elseif record.pu_mobile!="">
          			${record.pu_mobile?substring(0,3)}****${record.pu_mobile?substring(7,11)}
          		</#if>
      		</span>
      		<span class="pink">${record.ptrAmount?string(',##0.00')}元</span>
      		<span ><#if record.ptrTranstime??>${record.ptrTranstime?string("yyyy-MM-dd HH:mm:ss")}</#if></span>
  		</li>
    </#list>
</ul>
</div>
	<div class="clearfix">
	 <#if 0!=paging.pageList?size>
    <div class="baibao-pageye baibao-pageye-info" style="margin-top:50px;color:#ffffff" >
		<ul class="clearfix" >
			<li ><a href="javascript:ajaxPage(1)" style="" class="prev-first"></a></li>
		    <li><a href="javascript:void(0)" class="prev-on tenderon" ></a></li>
		    <#list paging.startPageNo..paging.fenge as page>
		   
		    <li><a href="javascript:ajaxPage(${page})" style="margin-top:-10px"  <#if page==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
		 
		    </#list>
		    <#if paging.pageNo<paging.pageTotal-2>
			<#if 3<paging.pageTotal>
			<li ><img src="${basePath}/pictures/page/shenglvu.png"></img></li>
			</#if>
			<li><a href="javascript:ajaxPage(${paging.pageTotal})" <#if paging.pageTotal==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>
				${paging.pageTotal}
			</a></li>
			</#if>
		    
		    <li><a href="javascript:void(0)" class="prev-next tendernext"></a></li>
		    <li ><a href="javascript:ajaxPage(${paging.pageTotal})" class="prev-last"></a></li>
		</ul>
		<style>
		.baibao-pageye ul li a{margin-top:14px}
		</style>
		<script type="text/javascript">
			$(function(){
				var pageTotal = ${paging.pageTotal};
				var pageNo = ${paging.pageNo};
				$(".tenderon").on("click",function(){
					if(pageNo-1<1){ajaxPage(1);}
					else{ajaxPage(pageNo-1);}
				});
				$(".tendernext").on("click",function(){
					if(pageNo+1>pageTotal){ajaxPage(pageTotal);}
					else{ajaxPage(pageNo+1);}
				});
			});
			function ajaxPage(pageNo){
				var type='${type}';
			    var productNo ='${productDetail.ppProductno}';
				var params = {"currentPageNo":pageNo,"productNo":productNo};
				showContentLoading();
				$.ajax({
		            type:"POST",
		            url:root+"/service/${ajaxPageUrl}?refresh="+new Date().getTime(),
		            data:params,
		            datatype:"html",
		            beforeSend:function(){//$("#msg").html("logining");
		            },
		            success:function(data){
		            	closeContentLoading();
		            	$("#productRecord").html("");
		            	$(".baibao-pageye-info").html(data);
		            },
		            complete:function(XMLHttpRequest, textStatus){
		               //alert(XMLHttpRequest.responseText);
		               //alert(textStatus);
		               closeContentLoading();
		               $("#productRecord").html(XMLHttpRequest.responseText);
		            },
		            error:function(){
		            	
		            }         
		        });
			}
		</script>
	</div>
	 <#else>
			<p class="fl no-record" style="padding-top:30px" >暂无数据</p>
      </#if>
</div>