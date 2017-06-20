<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/wapFindmsg.css">
</head>
<body>
	<div class="wrap">
        <header class="op-header">
            <p>消息详情</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="content">
        	<p class="details">${sysMsg.sysMsgContent}<br><span class="fr mt5">${sysMsg.sysMsgPubTime?string("yyyy-MM-dd hh:mm:ss")}</span></p>
        </div>
        <#include "./wap/common/wap_common_footer.ftl" />
    </div>
    <script type="text/javascript">
		session.set("msgFirst",true);
    </script>
</body>
</html>