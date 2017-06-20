<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/wap/wapRedEnvelopeRecord.css">
</head>
<body>
    <div class="wrap">
        <header class="op-header">
            <p>我的红包</p>
           	<a href="javascript:history.go(-1);" class="out-icon"></a>
            <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
        </header>
        <div class="content">
        	<c:if test="${not empty giftUserWelfareList }">
        	<div style="min-height:18rem;">
        		<c:forEach items="${giftUserWelfareList}" var="g">
        			<div class="inlineDiv">
        				<c:if test="${g.uw_state == 1}">
	               			<img src="${root}/images/webStation/redEnvelope/wsy_${g.uw_parvalue}.png"/>
	               			<p class="effectiveTime validity-wsy">有效期至<span>
	               				<fmt:parseDate value="${g.uw_effectTime}" var="yearMonth" pattern="yyyyMMddHHmmss"/>
                            	<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM-dd" />
	               			</span></p>
	               		</c:if>
        				<c:if test="${g.uw_state == 2 || g.uw_state == 3}">
	               			<img src="${root}/images/webStation/redEnvelope/ysy_${g.uw_parvalue}.png"/>
	               		</c:if>
        				<c:if test="${g.uw_state == 4}">
	               			<img src="${root}/images/webStation/redEnvelope/ygq_${g.uw_parvalue}.png"/>
	               			<p class="effectiveTime validity-ygq">有效期至<span>
	               				<fmt:parseDate value="${g.uw_effectTime}" var="yearMonth" pattern="yyyyMMddHHmmss"/>
                            	<fmt:formatDate value="${yearMonth}" pattern="yyyy-MM-dd" />
	               			</span></p>
	               		</c:if>
	        		</div>
               	</c:forEach>
        	</div>
            </c:if>
            <c:if test="${empty giftUserWelfareList }">
      			<p class="textCt bigFont16">暂无数据</p>
        	</c:if>
        	<div class="content-txt">
       			<p class="rule-title">温馨提示：</p>
				1.每笔投资只能激活一个投资返现红包；<br>
				2.优先匹配金额较大的红包；<br>
				3.返现金额将直接发放至佰宝金服投资账户中；<br>
				4.红包不适用于理财金体验标；<br>
				5.如有疑问详询平台在线客服或拨打全国热线400-882-2170。
        	</div>
        </div>
        <%@ include file="./common/web_common_footer.jsp"%>
    </div>
</body>
</html>