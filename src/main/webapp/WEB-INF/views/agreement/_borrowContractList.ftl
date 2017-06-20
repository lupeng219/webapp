<table cellpadding="0" cellspacing="0" class="xytable" style="margin-left:20px;">
    <tr class="trtitle">
        <td class="tdtitle">
            <p>手机号</p>
        </td>
        <td class="tddescxy">
            <p>真实姓名</p>
        </td>
        <td class="tddescxy">
            <p>借出金额（元）</p>
        </td>
        <td class="tddescxy">
            <p>协议</p>
        </td>
    </tr>
    <input type="hidden" value="${productNo}" id="productNo">
    <#if Paging??>
    	<#list Paging.pageList as re>
    		<tr class="trtitle">
                <td class="tdtitle">
                    <p>${re.pu_mobile[0..2]}****${re.pu_mobile[7..10]}</p>
                    
                </td>
                <td class="tddescxy">
                    <p>${re.pui_real_name}</p>
                </td>
                <td class="tddescxy">
                    <p>${re.ptr_amount}</p>
                </td>
                <td class="tddescxy">
                    <p>
                    	<button class="btn btn-warning ml5 getUrl" data-flowNo=${re.ptr_tenderFlowNo}>查看协议</botton>
                    	<form id="myForm${re.ptr_tenderFlowNo}" action="${basePath}/service/personalInvestment/ajaxGetUrl" method="post" target="_blank">
			        		<input type="hidden" name="tenderflowNo" id="tenderflowNo" value="${re.ptr_tenderFlowNo}">
						</form>
                    </p>
                </td>
            </tr>
    	</#list>
    </#if>
</table>
<div class="baibao-pageye" style="margin-top:15px;margin-bottom:0;">
	<ul class="clearfix">
		<li><a href="javascript:void(0)" class="prev-on"></a></li>
	    <#list Paging.startPageNo..Paging.endPageNo as page>
	    	<li><a href="javascript:ajaxPage(${page})" <#if page==Paging.pageNo>class="prev-o prev-cut"<#else>class="prev-o"</#if>>${page}</a></li>
	    </#list>
	    <li><a href="javascript:void(0)" class="prev-next"></a></li>
	</ul>
	<script type="text/javascript">
	
		 $("#borrowContract").on("click",".getUrl",function(){
		 	var ptrTenderFlowNo = $(this).data('flowno');
    	 	$("#myForm" + ptrTenderFlowNo).submit();
    	 });
	
	
	
		$(function(){
			var pageTotal = ${Paging.pageTotal};
			var pageNo = ${Paging.pageNo};
			$(".prev-on").on("click",function(){
				if(pageNo-1<1){ajaxPage(1);}
				else{ajaxPage(pageNo-1);}
			});
			$(".prev-next").on("click",function(){
				if(pageNo+1>pageTotal){ajaxPage(pageTotal);}
				else{ajaxPage(pageNo+1);}
			});
			subhetongClick();
		});
		
		
		function subhetongClick(){
			$(".hetong").on("click",function(){
				var type = $(this).data("type");
				var tenderFlowNo = $(this).data("flowno");
				showContentLoading();
				$.ajax({
		            type:"POST",
		            url:root+"/service/agreement/createagreementZip?refresh="+new Date().getTime(),
		            data:{"type":type,"tenderFlowNo":tenderFlowNo},
		            datatype:"html",
		            beforeSend:function(){
		            },
		            success:function(data){
		            	closeContentLoading();
		            },
		            complete:function(XMLHttpRequest, textStatus){
		            	closeContentLoading();
		                window.location.href = root+"/service/agreement/downloadAgreementZip";
		            },
		            error:function(){
		            	closeContentLoading();
		            }  
		        });
			});
		};
	
		function ajaxPage(pageNo){
		 	var productNo = $("#productNo").val();
		 	var pageSize  = ${Paging.pageSize};
			var params = {"productNo":productNo,"currentPageNo":pageNo,"pageSize":pageSize};
			$.ajax({
	            type:"POST",
	            url:root+"/service/agreement/ajaxPagegetBorrowContractList?refresh="+new Date().getTime(),
	            data:params,
	            datatype:"html",
	            beforeSend:function(){},
	            success:function(data){
	            	$("#borrowContract").html("");
	            },
	            complete:function(XMLHttpRequest, textStatus){
	               $("#borrowContract").html(XMLHttpRequest.responseText);
	            },
	            error:function(){}         
	        });
		}
	</script>
</div>