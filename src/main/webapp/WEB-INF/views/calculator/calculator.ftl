<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>理财计算器-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/calculator.css"/>
</head>
<body>
	<div class="bghui" style="margin-top:-0px">
	<#include "./common/common_header.ftl">
    <div class="container clientH" >
        <div class="caltor-con clearfix bgwhite">
            <h2 class="J_tit bgclan" style='background:#ebfbff;'>理财计算器 </h2>
            <div class="jui-num">
                <ul class="caltor-ui clearfix mt10">
                    <li>
                    	<span class="stel">出借金额</span>
                    	<input type="text" class="caltxt" name="cjje"/>
                    	<p class="unit">元</p>
                        <p class="err-tip"></p>
                        <div class="ui-poptip ui-poptip-orange" style="z-index: 99; position: absolute; left: 347px; top: 2px;display: none;">
                            <div class="ui-poptip-container">
                                <div class="ui-poptip-arrow ui-poptip-arrow-10">
                                    <em></em>
                                    <span></span>
                                </div>
                                <div class="ui-poptip-content" style="width: auto; height: auto;" data-role="content">出借金额50的倍数</div>
                            </div>
                        </div>
                    </li>
                    <li>
                    	<span class="stel">年化利率</span>
                    	<input type="text" class="caltxt" name="nhll"/>
                    	<p class="unit">%</p>
                        <p class="err-tip"></p>
                        <div class="ui-poptip ui-poptip-orange" style="z-index: 99; position: absolute; left: 347px; top: 2px; display:none;">
                            <div class="ui-poptip-container">
                                <div class="ui-poptip-arrow ui-poptip-arrow-10">
                                    <em></em>
                                    <span></span>
                                </div>
                                <div class="ui-poptip-content" style="width: auto; height: auto;" data-role="content">利率范围5%-24%</div>
                            </div>
                        </div>
                    </li>
                    <li id="jkqxMode1">
                    	<span class="stel">借款期限</span>
                    	<input type="text" class="caltxt" name="jkqx1"/>
                    	<p class="unit hk-type">个月</p>
                        <p class="err-tip"></p>
                        <div class="ui-poptip ui-poptip-orange" style="z-index: 99; position: absolute; left: 347px; top: 2px; display:none;">
                            <div class="ui-poptip-container">
                                <div class="ui-poptip-arrow ui-poptip-arrow-10" id="ems">
                                    <em></em>
                                    <span></span>
                                </div>
                                <div class="ui-poptip-content" style="width: auto; height: auto;" data-role="content">可填1到36任意整数月份</div>
                            </div>
                        </div>
                    </li>
					<li style="display:none;" id="jkqxMode2">
                    	<span class="stel">借款期限</span>
                    	<input type="text" class="caltxt" name="jkqx2"/>
                    	<p class="unit hk-type">天</p>
                        <p class="err-tip"></p>
                        <div class="ui-poptip ui-poptip-orange" style="z-index: 99; position: absolute; left: 347px; top: 2px; display:none;">
                            <div class="ui-poptip-container">
                                <div class="ui-poptip-arrow ui-poptip-arrow-10" id="ems">
                                    <em></em>
                                    <span></span>
                                </div>
                                <div class="ui-poptip-content" style="width: auto; height: auto;" data-role="content">可填任意整数天数</div>
                            </div>
                        </div>
                    </li>
                    <li>
                    	<span class="stel">还款方式</span>
                        
                    	<div class="caltxt caltxt-pr" style="width:261px;height:40px;" name="hkfs">
	                        
	                    </div>
                        <div class='cal_sub'>
                                <p value="0">每月付息，到期还本</p>
                                <p value="1">等额本息</p>
                                <p value="2" style='border-bottom:none;'>按天计息</p>
                                
                        </div>  
                    </li>
                </ul>
                <p class="textCt pt40">
                	<a href="javascript:void(0);" class="cal-btn" data-available="true">开始计算</a>
            	</p>
            </div>
            <div id="resultdiv"></div>
            <div class="clearfix cal-desc mt10">
            	<p><span>等额本息：</span>即借款人每月以相等的金额偿还借款本息，也是银行房贷等采用的方法。因计算中存在四舍五入，最后一期还款金额与之前略有不同。</p>
                <p><span>每月付息，到期还本：</span>即借款人每月偿还固定利息，最后一期偿还全部本金。</p>
                <p><span>注：</span>因计算器采用了以50元为一份的计算方式，计算结果仅供参考，具体情况以账户中显示的信息为准。</p>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl">
    </div>
    <script type='text/javascript'>
        seajs.use("calculator");
        
        $(".caltxt-pr").on('click',function(e){
            var ev=e||window.event;
            
            $('.cal_sub').slideDown(200);
            return false;
            ev.stopPropagation();
        })
        $('.cal_sub').on('click','p',function(){
            var scont=$(this).html();
            var Index=$(this).index();
            $(".caltxt-pr").html(scont);
            $('.cal_sub').slideUp(200);
            if(Index==2){
                $("#jkqxMode2").css({'display':'block'});
                $("#jkqxMode1").css({'display':'none'});
            }else{
                $("#jkqxMode1").css({'display':'block'});
                $("#jkqxMode2").css({'display':'none'});
            }
    
        })
        $(document).click(function(){
            $('.cal_sub').slideUp(200);

        });
     
        
    </script>
</body>
</html>