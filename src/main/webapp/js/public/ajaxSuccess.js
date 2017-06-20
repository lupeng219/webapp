/**
 * 全文监控ajax,获取回调信息，包含登陆页面， 返回
 */
$(function(){
	$(document).ajaxSuccess(function(type, status, url, text) {
		if (text == null || typeof(text) != "string")
			return;
	
		if (text.indexOf("547c8052-8a84-41f5-81db-47e23dd298ce") > -1)
		{
			window.location.href = root + "/service/login";
		}
	});
});