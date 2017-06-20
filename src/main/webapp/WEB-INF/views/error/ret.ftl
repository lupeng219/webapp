<!DOCTYPE html>
<html>
<head>
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <#include "./common/common_src.ftl">
    <link href="${basePath }/css/err.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">     
		function countDown(secs,surl){     
		 
		 var jumpTo = document.getElementById('jumpTo');
		 jumpTo.innerHTML=secs;  
		 if(--secs>0){     
		     setTimeout("countDown("+secs+",'"+surl+"')",1000);     
		     }     
		 else{       
		     location.href=surl;     
		     }     
		 }     
	</script> 
</head>

<body onload="robot.callAndroidMethod();">
	 	 <div>
			   <p class="textCt mt80">操作成功，请返回...</p><br /><br />
			  <center><span id="jumpTo" class="textCt mt80">3</span>秒后自动跳转</center>
	    </div>
	<script type="text/javascript">
		countDown(3,'${basePath}/service/wapAccount/wapAccountIndex');
	</script>  
</body>
</html>