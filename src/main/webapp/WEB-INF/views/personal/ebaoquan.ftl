<html>
<head>
	<#include "./common/common_src.ftl" />
	<script type="text/javascript" src="${basePath}/js/baibao/projectWindow.js"></script>
</head>
<body onload="init('${uri}');">
	<div id="contentLoading" style="display:none;position:fixed;z-index:99999;width:100%;height:100%;top:0;bottom:0;left:0;right:0;
		overflow: hidden;text-align:center;">
		<img src="${basePath}/images/loading.gif" style="margin:auto;margin-top:20%;"/>
	</div>
	<script type="text/javascript">
		function init(uri){
			if(uri){
				showContentLoading();
				window.location.href=uri;
			}else{
				alert("暂无生成协议，请稍后再试！",function(){
					window.close();
				});
			}
		};
	</script>
</body>
</html>