<!-- 投标记录 
<p class="tzpeople-sum "><span>加入人次 ${paging.countTotal} 人</span> <span class="pl30">投标总额 ${productMap.loanAmountExist}元</span></p>
-->
<ul>
    <li class="jl-title"><span class="strong">序号</span><span class="strong">投标人</span><span class="strong">投标金额</span><span class="textRt strong">投标时间</span></li>
   	<#list paging.pageList as record>
        <li <#if record?index%2!=0>class="jl-title"</#if>>
      		<span>${record_index+1}</span>
      		<span>  
          		<#if record.pu_mobile="">
          			****
          		<#elseif record.pu_mobile!="">
          			${record.pu_mobile?substring(0,2)}***${record.pu_mobile?substring(8,11)}
          		</#if>
      		</span>
      		<span>${record.ptrAmount?string(',##0.00')}元</span>
      		<span class="textRt"><#if record.ptrTranstime??>${record.ptrTranstime?string("yyyy-MM-dd HH:mm:ss")}</#if></span>
  		</li>
    </#list>
</ul>
<div class="clearfix">
    <div class="baibao-pageye-info" style="margin:5px 0;">
		<ul class="clearfix">
		    <li><a href="javascript:void(0)" class="prev-on"><</a></li>
		    <#list paging.startPageNo..paging.endPageNo as page>
		    <li><a href="javascript:ajaxPage(${page})" <#if page==paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
		    </#list>
		    <li><a href="javascript:void(0)" class="prev-next">></a></li>
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
				var type='${type}';
			    var productNo ='${productMap.bulkLoanNumber}';
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
</div>
	