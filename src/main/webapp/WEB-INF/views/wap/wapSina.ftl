<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>新浪存钱罐-佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/zt-sina-gai.css">
</head>
<body>
 	<div class="wrap">
        <header class="op-header textCt">
            <p>新浪存钱罐</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <#if Session["CURRENT_LOGIN_USER"]?exists>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>
        <div class="baibao-banner">
            <img src="${basePath}/images/wap/xlzf_01.png"/>
        </div>
        <div class="g-content">
            <div class="baibao-sina">
                <p class="font1_2">什么是新浪支付存钱罐？</p>
                <p class="font0_8 pt10">新浪支付（存钱罐）隶属于新浪旗下，是新浪联手汇添富基金主推的名为“存钱罐”第三方支付机构，同时也具有账户余额增值功能。</p>
                <div class="sina-con clearfix">
                    <div class=" sina-desc">
                        <p class="sina-t-t">[专人专户 资金专款专用]</p>
                        <ul>
                            <li>1、严格遵守银监会对资金托管的要求，杜绝平台自建资金池。</li>
                            <li>2、用户资金全程由新浪支付存钱罐托管，与有融网平台完全隔离。</li>
                            <li>3、投资和还款资金开设独立账户，实行专人专户，专款专用。</li>
                        </ul>
                    </div>
                </div>
                <div class="sina-con clearfix">
                    <div class=" sina-desc">
                        <p class="sina-t-t">[功能丰富 乐享极致体验]</p>
                        <ul>
                            <li>1、集多项功能为一体，一个账户，多种体验。</li>
                            <li>2、高危操作提醒功能，随时随地，掌握账户动态。</li>
                            <li>3、注册即开通，化繁为简，带来完美极致体验。</li>
                        </ul>
                    </div>
                </div>
                <div class="sina-con clearfix">
                    <div class="sina-desc">
                        <p class="sina-t-t">[资金灵活 收益每天结]</p>
                        <ul>
                            <li>1、 一分钱起存，资金极速到账。</li>
                            <li>2、天天计息，收益享不停。</li>
                            <li>3、账户资金7*24小时随时存取。</li>
                        </ul>
                    </div>
                </div>
                <div class="sina-con clearfix">
                    <div class=" sina-desc">
                        <p class="sina-t-t">[货基支持 闲置资金不站岗]</p>
                        <ul>
                            <li>1、新浪支付存钱罐是一款具备货基收益的产品。</li>
                            <li>2、账户闲置资金可获得每日收益，真正实现资金不站岗。</li>
                            <li>3、七日年化收益率3.238%，超银行活期存款的16倍。</li>
                        </ul>
                    </div>
                </div>
                <p class="sysjb-title textCt font1_2">收益时间表</p>
                <table class="sysjb-table font0_8" cellpadding="0" cellspacing="0">
                    <thead>
                    <tr>
                        <th>购买时间</th>
                        <th>开始计算收益时间</th>
                        <th>首次显示收益时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>周一15:00—周二15:00前</td>
                        <td>周三</td>
                        <td>周四</td>
                    </tr>
                    <tr>
                        <td>周二15:00—周三15:00前</td>
                        <td>周四</td>
                        <td>周五</td>
                    </tr>
                    <tr>
                        <td>周三15:00—周四15:00前</td>
                        <td>周五</td>
                        <td>下周一</td>
                    </tr>
                    <tr>
                        <td>周四15:00—周五15:00前</td>
                        <td>下周一</td>
                        <td>下周二</td>
                    </tr>
                    <tr>
                        <td>周五15:00—下周一15:00前</td>
                        <td>下周二</td>
                        <td>下周三</td>
                    </tr>
                    </tbody>
                </table>
                <p class="font0_8 pb20 pt5">温馨提示：新浪支付托管升级——还本付息提前到账，账户余额早享收益</p>
            </div>
        </div>
        <div class="baibao-banner ">
            <img src="${basePath}/images/wap/xlzf_07.png"/>
        </div>
        <div class="g-content">
            <p class="textCt sina-wmhz font2 pt10">更完美的合作</p>
            <p class="textCt sina-wm-d">佰宝金服和新浪支付存钱罐达成战略合作协议<br/>让用户的资金托管更安全<br/>真正实现资金隔离，杜绝资金池风险<br/>托管资金不站岗，不投也能赚收益</p>
            <p class="textCt">
            	<a href="${basePath}/service/piggyBank/showMemberInfosSina" class="qxlcz-btn">
            		<img src="${basePath}/images/wap/qxlcz_10.png"/>
            	</a>
            </p>
        </div>
        <div class="wap-footer" id="wap-footer" style="margin-top:0;">
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