<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>借款协议列表-佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/xieyi.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/hetong.css"/>
    <script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
    <style>
    	html a{color: #2ea7e0;}
    	#downAll{float: right;margin-right: 30px;margin-bottom: 2px;}
    </style>
</head>
<body>
<#include "./common/common_header.ftl">

    <div id="pg-webservice">
        <div class="container_12">
            <div class="grid_10 pg-webservice-content">
            	<h3 class="textCt">借款协议列表</h3>
            	<!--p>
            		<a href="javascript:void(0);" id="downAll" data-flowno=${productNo}>全部下载</a>
            	</p-->
            	<div id="borrowContract">
	           		<#include "./agreement/_borrowContractList.ftl" />
	           	</div>
            </div>
            
        </div>
       
    </div>
    <#include "./common/common_footer.ftl">
<script type="text/javascript">
	$(function(){
		hetongClick();
        var clientH=$("#pg-webservice").height();
          if(clientH<300){
            $("#pg-webservice").height(400)
          }  
        
	});
	
	function hetongClick(){
		$("#downAll").on("click",function(){
			var productNo = $(this).data("flowno");
			showContentLoading();
			$.ajax({
	            type:"POST",
	            url:root+"/service/agreement/createagreementList?refresh="+new Date().getTime(),
	            data:{"productNo":productNo},
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
</script>
</body>
</html>
