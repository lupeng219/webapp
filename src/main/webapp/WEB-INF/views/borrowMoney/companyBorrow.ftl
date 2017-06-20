<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>佰宝金服-借贷-个人借款，轻松接入 一步到位</title>
	<meta name="description" content="理财-上佰宝金服，门槛低，收益可观，选取优质产品，更有专业团队为您保驾护航!"/>
	<meta name="keywords" content="佰宝金服贷款产品,个人贷款,小额贷款,买房贷款,P2P借贷平台"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/company-borrow.css"/>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <div class="invest-list-nav">
        <div class="container">
            <ul class="list-nav">
                <li class="current"><a href="javascript:void(0);">企业借贷</a></li>
            </ul>
            <ul class="list-tongji">
                <li>累计放款 <span>4,828,140.00</span> 元</li>
            </ul>
        </div>
    </div>
    <div class="borrow-banner">
    
    </div>
    <div class="container">
        <div class="borrow-advantage clearfix">
            <div class="sqtj-con">
                <ul class="clearfix">
                    <li class="strong" style="font-size:15px; padding-bottom:5px;">提示：</li>
                    <li>1、申请必备资料：法人代表人、实际控制人、大股东个人征信和个人资料；
				                        企业对公流水对私流水；
				                        资产权属证明；
				                        银行征信报告；
				                        企业基本资料；
				                        公司章程；
				                        财务报表；
				                        审计报告；
				                        与贷款申请相关的其他资料；</li>
                     <li>2、请仔细填写您的真实信息，我们将与您取得联系。</li>
                </ul>
            </div>
            <div class="sqcomp-ui">
                <div class="item-sq">
                	<span class="tip-s">申请人</span>
                	<input type="text" class="txt-company" id="applicant"/>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">申请人手机号</span>
                	<input type="text" class="txt-company" id="applicantMobile"/>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">借款金额</span>
                	<input type="text" class="txt-company" id="loanAmount"/><em class="dw">万元</em>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">借款期限</span>
                	<input type="text" class="txt-company" id="loanTerm"/><em class="dw">个月</em>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">公司名称</span>
                	<input type="text" class="txt-company" id="companyName"/>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">所属行业</span>
                	<input type="text" class="txt-company" id="industry"/>
                    <p class="err-p"></p>
                </div>
               <div class="item-sq">
               		<span class="tip-s">所在省份</span>
                    <div class="city-con">
                        <input class="sel-city" id="sel-province" type="text" readonly/>
                        <a class="down-card" id="down-province"></a>
                        <ul class="city-list" id="province-list" style="display: none;"></ul>
                    </div>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">所在城市</span>
                    <div class="city-con">
                        <input class="sel-city" id="sel-city" type="text"/>
                        <a class="down-card" id="down-city"></a>
                        <ul class="city-list" id="city-list" style="display:none;"></ul>
                    </div>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">成立时间</span>
                	<input type="text" class="txt-company" id="establishTime"/>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">注册资本</span>
                	<input type="text" class="txt-company" id="registeredCapital"/><em class="dw">万元</em>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq" style="min-height:40px;">
                	<span class="tip-s">有无其他贷款</span>
                	<input type="radio" name="hasLoan" class="rdo-dk" value="1"/>&nbsp;有
                    <input type="radio" name="hasLoan" class="rdo-dk" value="0"/>&nbsp;无
                    <p class="err-p"></p>
                </div>
                <div class="item-sq">
                	<span class="tip-s">借款用途</span>
                	<textarea type="text" class="txt-desc" id="loanDesc"></textarea>
                    <p class="err-p"></p>
                </div>
                <div class="item-sq" style="min-height:40px;">
                    <p class="textCt"><a href="javascript:void(0);" class="borrowmoney-btn">立即申请</a></p>
                </div>
            </div>
        </div>
    </div>
	<#include "./common/common_footer.ftl" />
	<script src="${basePath}/js/public/area.js" type="text/javascript"></script>
	<script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
	<script type="text/javascript">
    	seajs.use("companyBorrow");
    </script>
</body>
</html>