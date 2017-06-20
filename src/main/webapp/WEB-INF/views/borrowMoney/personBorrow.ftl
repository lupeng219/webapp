<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>佰宝金服-借贷-个人借款，轻松接入 一步到位</title>
	<meta name="description" content="理财-上佰宝金服，门槛低，收益可观，选取优质产品，更有专业团队为您保驾护航!"/>
	<meta name="keywords" content="佰宝金服贷款产品,个人贷款,小额贷款,买房贷款,P2P借贷平台"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/borrow-money.css"/>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <!--
      <div class="invest-list-nav">
        <div class="container">
            <ul class="list-nav">
                <li class="current" data="1"><a href="javascript:void(0);">我要借入</a></li>
                <li data="2"><a href="javascript:void(0);">如何借入</a></li>
            </ul>
        </div>
    </div>
    -->
    <!-- 借款申请  -->
    <div id="borrowTab1" style="background: rgba(0, 0, 0, 0) url('http://localhost:8080/front-app/pictures/borrowmoney/backgound.png') no-repeat;background-size: cover;" class='clientH'>
    	<div style="width:100%;margin: 0 auto;">
	    <div style="width:1000px;margin: 0 auto;">
	    <table>
	    	<tr>
	    	<td style="width: 600px;">
	    	<div style="position:absolute;top: 200px;text-align: center">
	    		<p style="font-size:50px;margin-left:100px;color:#ca5e30 ">诚信为本 / 服务大众</p>
	    		<div style="margin-left:100px;margin-top:50px;">
	    			<div style="width:100px;float:left;">
		    			<img src="${basePath}/pictures/borrowmoney/icon-Lend-quickly.png" />
		    			<p style="color:#848484;margin-top:50px;font-size:18px;">出借迅速</p>
	    			</div>
	    			<div style="width:100px;float:left;margin-left: 15px;">
	    				<img src="${basePath}/pictures/borrowmoney/icon-High-borrowing.png"  />
	    				<p style="color:#848484;margin-top:50px;font-size:18px;">借款额高</p>
	    			</div>
	    			<div style="width:100px;float:left;margin-left: 15px;">
	    				<img src="${basePath}/pictures/borrowmoney/iucon-Flexible-term.png"/>
	    				<p style="color:#848484;margin-top:50px;font-size:18px;">期限灵活</p>
	    			</div>
	    			<div style="width:100px;float:left;margin-left: 15px;">
	    				<img src="${basePath}/pictures/borrowmoney/icon-Safe-use.png" />
	    				<p style="color:#848484;margin-top:50px;font-size:18px;">使用安全</p>
	    			</div>
	    		</div>
	    		
	    	</div>
	    	</td>
	    	<td style="width: 400px;">
	        <div class="borrow-advantage clearfix" style="margin-left: 100px;height:506px;">
	        <!--
	            <div class="sqtj-con">
	                <ul class="clearfix">
	                    <li class="strong" style="font-size:15px; padding-bottom:5px;">提示：</li>
	                    <li>1、由于业务原因，佰宝金服平台目前只开放【北京】、【山西】的汽车抵押贷业务和【北京】、【山西太原】的房产抵押业务；</li>
	                    <li>2、请仔细填写您的真实信息，我们将与您取得联系。</li>
	                </ul>
	            </div>
	            -->
	            <div class="sqcomp-ui">
	                <div class="item-sq" style=" margin-top: 20px;">
	                	<p style="text-align: left;"><span class="tip-s">借款人:</span></p>
	                	<input type="text" class="txt-company" id="realName" value=""/>
	                    <p class="err-p"></p>
	                </div>
	                <div class="item-sq">
	                	<p style="text-align: left"><span class="tip-s">手机号:</span></p>
	                	<input type="text" class="txt-company" id="mobile" maxLength="11" readonly value="${Session.CURRENT_LOGIN_USER.puMobile}"/>
	                    <p class="err-p"></p>
	                </div>
	                <div class="item-sq" style="min-height:30px;margin-bottom: 12px;margin-top: 12px;">
	                	<span class="tip-s" style="width:60px">抵押方式</span>
                        <label>
	                    <input type="radio" name="mortgageMode" class="rdo-dk" value="0" checked/>&nbsp;信用
                        </label>
                        <label>
	                	<input type="radio" name="mortgageMode" class="rdo-dk" value="1"/>&nbsp;车抵押
                        </label>
                        <label>
	                    <input type="radio" name="mortgageMode" class="rdo-dk" value="2"/>&nbsp;房抵押
                        </label>
                        
	                    <p class="err-p"></p>
	                </div>
	                
	                <!-- 选择车抵押 显示 -->
	                
	
	                <!-- 选择房抵押 显示 -->
	               
	                <div class="item-sq">
	                	<p style="text-align: left;"><span class="tip-s">借款金额:</span></p>
	                	<input type="text" class="txt-company" id="loanAmount" maxLength="4"/><em class="dw">万</em>
	                    <p class="err-p"></p>
	                </div>
	                <div class="item-sq">
	                	<p style="text-align: left;"><span class="tip-s">借款期限:</span></p>
	                	<input type="text" class="txt-company" id="loanTerm" maxLength="2"/><em class="dw">个月</em>
	                    <p class="err-p"></p>
	                </div>
	                
	                <div class="item-sq" style="min-height:40px;">
	                    <p class="textCt" style="margin-top:10px;"><a href="javascript:void(0);" data-available="true" class="borrowmoney-btn"><img src='../pictures/borrowmoney/btn-apply.png'>立即申请</a></p>
	                </div>
	            </div>
	        </div>
	        </td>
	        </tr>
	        </table>
	    </div>	
    </div>
    </div>
    <!-- 如何借入 -->
    <div class="clearfix" id="borrowTab2" style="display:none;">
        <div class="how1"></div>
        <div class="how2">
            <div class="ct-btn">
                <a href="javascript:void(0);" class="toBorrow"></a>
            </div>
        </div>
        <div class="how3"></div>
        <div class="how4"></div>
        <div class="how5">
            <div class="ct-btn">
                <a href="javascript:void(0);" class="toBorrow"></a>
            </div>
        </div>
        <div class="how6"></div>
        <div class="how7"></div>
        <div class="how8"></div>
    </div>
    
	<#include "./common/common_footer.ftl" />
	<script src="${basePath}/js/public/area.js" type="text/javascript"></script>
	<script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
	<script type="text/javascript">
    	seajs.use("borrowMoney");
        seajs.use("permainH");
    </script>
</body>
</html>