<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>数据保全-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/special/dataSecurity.css"/>
</head>
<body>
	<div class="topbar border-b" id="top">
	    <div class="container">
	        <div class="fl">
	            <ul class="topui ml10">
	            	<li><a href="${basePath}" class="ml10">首页</a></li>
	                <li><em class="phone-icon iconbg"></em> <a href="${basePath}/service/dissertation/appSpecial" class="ml10">移动客户端</a></li>
	            </ul>
	        </div>
	        <div class="fr">
	            <ul class="topui">
	            	<#if Session["CURRENT_LOGIN_USER"]?exists>
					<li><a href="${basePath}/service/asset">欢迎回来 ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</a></li>
					<li><a href="${basePath}/service/login/logout">[退出]</a></li>
					<#else>
	                <li><a href="${basePath}/service/login">您好，请登录</a></li>
	                <li><a href="${basePath}/service/register">免费注册</a></li>
					</#if>
	                <li><a href="http://crm2.qq.com/page/portalpage/wpa.php?uin=4006888129&aty=0&a=0&curl=&ty=1" target="_blank">在线客服</a></li>
	                <li style="position:relative;">关注我们 
	                	<em class="wx-icon iconbg" style="cursor:pointer;"></em>
	                	<a href="http://weibo.com/baibao?from=myfollow_all" target="_blank"><em class="wb-icon iconbg"></em></a>
	                	<div class="twoDimensional" style="display: none;">
			                <div class="erwm">
			                    <img src="${basePath}/images/erweima.jpg">
			                </div>
			            </div>
			            <script type="text/javascript">
			            	$(".wx-icon").hover(function(){
						        $(".twoDimensional").show();
						    },function(){
						        $(".twoDimensional").hide();
						    });
			            </script>
	            	</li>
	            </ul>
	        </div>
	    </div>
	</div>
    <div class="data-banner"></div>
    <div class="data-content">
        <h1>佰宝金服交易电子数据保全，将交易协议锁进保险箱</h1>
        <p class="data-desc">中融佰诚投资管理有限公司联手易保全电子数据保全中心，为投资者提供交易凭证保全服务，交易凭证（担保函、担保协议等信息）一旦保全，其内容、生成时间等信息将被加
                             密固定，且生成唯一的保全证书供下载。事后任何细微修改，都会导致保全证书函数值变化，有效防止人为篡改。如发生司法纠纷，保全证书持有人，可以通过易保全电子数据保全
                             中心提供的认证证书向法院或仲裁机构提供有效、可靠的证据，从而获得举证的优势地位。</p>

        <h2>一、电子数据保全是什么</h2>
        <p class="data-desc">
            电子数据在线保全是指对以电子数据形式（包括文字、图形、字母、数字、三维标志、颜色组合声音以及上述要素的组合等下同）存在的各类电子数据信息，运用专利技术进行运算、
            加密固定，载明保全生成的标准时间、运算值、档案编号等，以防止被人篡改，确保电子数据的原始性、客观性的程序及方法。
        </p>

        <h2>二、易保全电子数据保全中心提供什么？</h2>
        <p class="data-desc" style="color:#23b0f0;">1、提供受法律认可的电子数据认证证书服务</p>
        <p class="data-desc">国家专利局、CNAS中国国家实验室资格认证，让易保全电子数据保全中心出具的电子认证证书，受法律认可！</p>
        <p class="data-desc mt20" style="color:#23b0f0;">2、CFCA身份认证、电子签章服务</p>
        <p class="data-desc">提供CFCA身份认证、电子签章，让身份认证更可靠。</p>
        <p class="data-desc mt20" style="color:#23b0f0;">3、一站式存取证服务</p>
        <p class="data-desc">国家专利局电子数据保全中心打通保全存证、司法鉴定、法律服务等环节，真正做到一站式服务。</p>
        <div class="clearfix">
            <ul class="data-ui">
                <li style="width:360px;"><img src="${basePath}/images/special/sjbq_04.gif"/>
                    <p class="textCt">获得国家颁发司法鉴定证书，拥有司法鉴定资格</p></li>
                <li style="width:360px;"><img src="${basePath}/images/special/sjbq_06.gif"/>
                    <p class="textCt">公证机构执业证</p></li>
                <li style="width:205px;"><img src="${basePath}/images/special/sjbq_16.png"/>
                    <p class="textCt">电子数据保全证书</p></li>
            </ul>
        </div>
        <h2>三、投标完成后如何保存协议？</h2>
        <p class="data-desc">
            投标成功后并确定该标为“还款中”状态，即可在个人中心找到协议，并下载保存到个人电脑中。
            进入“个人中心”-“我的理财”，找到所投资的对应标的，点击右侧“查看协议”则进入一下页面，点击“下载协议”按钮，也可点击“查看数据保全证书”。
        </p>

        <h2>四、常见问题</h2>
        <p class="data-desc" style="color:#23b0f0;">
            Q： 投资者如何检验保全证书真伪？
        </p>
        <p class="data-desc  mt20">A：投资者拿到保全证书后，可以登录www.ebaoquan.org，录入证书上的备案号及上传被保全文件（如电子协议）进行真伪验证，或者从收到证书生成的邮件中，点击“查看我的
                                   保全证书”，进入证书页面使用验证功能。</p>
        <p class="data-desc  mt20" style="color:#23b0f0;">
            Q： 电子数据保全是否具有法律效力？
        </p>
        <p class="data-desc  mt20">A： 最新修正的《刑法诉讼法》、《民事诉讼法》均将电子数据列为证据的一种，电子数据保全中心提供的保全证书，可作为司法人员和律师分析、认定案件事实的有效证据，让受
                                   保者在司法纠纷中占据有利地位，根据受保护者需要，电子数据保全中心还可以为受保者需要，电子数据保全中心还可以为受保者提供合作机构出具的公证书或司法鉴定书。</p>
        <p class="data-desc  mt20" style="color:#23b0f0;">
            Q：为什么选择电子数据保全？
        </p>
        <p class="data-desc  mt20">A：相较传统取证手段，电子数据保全具有低成本、高效率、保密（系统仅仅在本地生成数据的数字摘要，绝无泄露隐私、商业秘密、内容的风险！）合法、权威等优势，并且可以
                                   通过事先存证来预防和化解纠纷，是互联网投资者保护交易证据安全的首选。</p>
        <p class="data-desc mt20">
           易保全电子数据中心是以电子数据第三方保全为核心的平台，面向金融、电商、医疗、通讯等行业提供专业定制化的保全服务。该平台目前已获得三项专利，6项国家CNAS资格认
证，与司法鉴定中心、公证处实行对接，实时进行保全的信息同步，是国内最大的电子数据保全平台。
        </p>
    </div>
    <#include "./common/common_footer.ftl">
</body>
</html>