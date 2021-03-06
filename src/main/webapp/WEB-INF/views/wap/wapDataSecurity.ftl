<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>数据保全-佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/wapDataSecurity.css">
</head>
<body>
 	<div class="wrap">
        <header class="op-header textCt">
            <p>数据保全</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <#if Session["CURRENT_LOGIN_USER"]?exists>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>
        <div class="content">
        	<img src="${basePath}/images/wap/dataSecurityTitle.jpg"/>
        	<div class="txt">
        		<h1>佰宝金服交易电子数据保全<br>将交易协议锁进保险箱</h1>
        		<p>中融佰诚投资管理有限公司联手易保全电子数据保全中心，为投资者提供交易凭证保全服务，交易凭证
（担保函、担保协议等信息）一旦保全，其内容、生成时间等信息将被加密固定，且生成唯一的保全证书供
下载。事后任何细微修改，都会导致保全证书函数值变化，有效防止人为篡改。如发生司法纠纷，保全证书
持有人，可以通过易保全电子数据保全中心提供的认证证书向法院或仲裁机构提供有效、可靠的证据，从而
获得举证的优势地位。</p>
				<h2>一、电子数据保全是什么</h2>
				<p>电子数据在线保全是指对以电子数据形式（包括文字、图形、字母、数字、三维标志、颜色组合声音以及上
述要素的组合等下同）存在的各类电子数据信息，运用专利技术进行运算、加密固定，载明保全生成的标准
时间、运算值、档案编号等，以防止被人篡改，确保电子数据的原始性、客观性的程序及方法。</p>
				<h2>二、易保全电子数据保全中心提供什么？</h2>
				<h3>1、提供受法律认可的电子数据认证证书服务</h3>
				<p>国家专利局、CNAS中国国家实验室资格认证，让易保全电子数据保全中心出具的电子认证证书，受法律认可！</p>
				<h3>2、CFCA身份认证、电子签章服务</h3>
				<p>提供CFCA身份认证、电子签章，让身份认证更可靠。</p>
				<h3>3、一站式存取证服务</h3>
				<p>电子数据保全中心打通保全存证、司法鉴定、法律服务等环节，真正做到一站式服务。</p>
				<img src="${basePath}/images/wap/dataSecurity.jpg"/>
				<h2>三、投标完成后如何保存协议？</h2>
				<p>投标成功后并确定该标为“还款中”状态，即可在个人中心找到协议，并下载保存到个人电脑中。
进入“个人中心”-“我的理财”，找到所投资的对应标的，点击右侧“查看协议”则进入一下页面，点击
“下载协议”按钮，也可点击“查看数据保全证书”</p>
				<h2>四、常见问题</h2>
				<h4>Q： 投资者如何检验保全证书真伪？</h4>
				<p>A：投资者拿到保全证书后，可以登录www.ebaoquan.org，录入证书上的备案号及上传被保全文件（如电
子协议）进行真伪验证，或者从收到证书生成的邮件中，点击“查看我的保全证书”，进入证书页面使用验证功能。</p>
				<h4>Q： 电子数据保全是否具有法律效力？</h4>
				<p>A： 最新修正的《刑法诉讼法》、《民事诉讼法》均将电子数据列为证据的一种，电子数据保全中心提供的
保全证书，可作为司法人员和律师分析、认定案件事实的有效证据，让受保者在司法纠纷中占据有利地位，
根据受保护者需要，电子数据保全中心还可以为受保者需要，电子数据保全中心还可以为受保者提供合作机
构出具的公证书或司法鉴定书.</p>
				<h4>Q：为什么选择电子数据保全？</h4>
				<p>A：相较传统取证手段，电子数据保全具有低成本、高效率、保密（系统仅仅在本地生成数据的数字摘要，
绝无泄露隐私、商业秘密、内容的风险！）合法、权威等优势，并且可以通过事先存证来预防和化解纠纷，
是互联网投资者保护交易证据安全的首选。</p>
				<p>易保全电子数据中心是以电子数据第三方保全为核心的平台，面向金融、电商、医疗、通讯等行业提供专业
定制化的保全服务。该平台目前已获得三项专利，6项国家CNAS资格认证，与司法鉴定中心、公证处实行对
接，实时进行保全的信息同步，是国内最大的电子数据保全平台。</p>
        	</div>
        </div>
        <div class="wap-footer" id="wap-footer" style="margin-top:1rem;">
		    <p class="kfrx-p">客服热线：<a href="tel://400-882-2170" style="color:#acb2c8;">400-882-2170</a></p>
		    <p class="footer-btn">
		        <a href="${basePath}/service/wapIndex/download">下载客户端</a>
		        <a href="${basePath}/service/wapLogin/wapAboutWe">关于我们</a>
		        <a href="${basePath}/service/index/index?type=pc">电脑版</a>
		    </p>
		    <p class="kfrx-p">中融佰诚投资管理有限公司 </p>
		    <p class="kfrx-p1"> © 2016 baibao.com 京ICP证 140570号</p>
		</div>
    </div>
</body>
</html>