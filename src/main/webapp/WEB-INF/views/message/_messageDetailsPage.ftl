<#if paging.pageList?size!=0>
	<div class="container">
    <#list paging.pageList as list>
    	<div class="ml20 clearfix">
    		<span class="checkSpan" data-value="${list.id}"></span>
    		<div class="messagedesc-con fl">
                <div class="mess-con">
                    <div class="messdesc-con">
                        <p>尊敬的用户${list.firstLine}:
                       ${list.context}</p>
                        <p>感谢您对我们的关注与支持。</p>
                        <p style="text-align:right">佰宝金服</p>
                    </div>
                    <div class="mess-sty"></div>
                </div>
                <p class="messdesc-time">${list.time}</p>
            </div>
        </div>
	</#list>
	</div>
	<div class="delhov mt20 ml20">
		<input id="messageType" type="hidden" value="${type}"/>
		<span class="checkAll" id="checkAll"></span>
		<label>全选</label>&nbsp;&nbsp;&nbsp;&nbsp
		<a id="deleteMsg" style="cursor: pointer;font-size:14px;" class="pink">删除</a>
	</div>
</#if>     
<div class="baibao-pageye" style="margin-right:35px;margin-top:-15px;margin-bottom:45px">
	<ul class="clearfix">
		<li><a href="javascript:ajaxPage(1)" class="prev-first"></a></li>
	    <li><a href="javascript:void(0)" class="prev-on"></a></li>
	    <#list paging.startPageNo..paging.endPageNo as page>
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
			var type = $("#messageType").attr("value");
			var params = {"currentPageNo":pageNo,"type":type};
			$.ajax({
	            type:"POST",
	            url:root+"/service/${ajaxPageUrl}?refresh="+new Date().getTime(),
	            data:params,
	            datatype:"html",
	            beforeSend:function(){//$("#msg").html("logining");
	            },
	            success:function(data){
	            	 $("#messageRecord").html("");
	            },
	            complete:function(XMLHttpRequest, textStatus){
	               //alert(XMLHttpRequest.responseText);
	               //alert(textStatus);
	               $("#messageRecord").html(XMLHttpRequest.responseText);
	            },
	            error:function(){
	            	
	            }         
	        });
		}
	</script>
</div>