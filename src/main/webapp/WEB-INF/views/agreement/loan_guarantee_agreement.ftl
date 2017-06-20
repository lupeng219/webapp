<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>借款保证协议-佰宝金服-安全透明灵活的互联网金融服务平台</title>
<style type="text/css">
html {
    background: none repeat scroll 0 0 #f2f2f2;
    width:100%;
    height: 100%;
    color: #666;
    font: 14px/1.5 "微软雅黑",YaHei,tahoma,arial,"Hiragino Sans GB",宋体;
    font-size:14px;
    text-align:center;
}
* {
    list-style: none;
    text-decoration: none;
}
body{
	width:960px;
    height: 100%;
    text-align:left;
    margin-right:auto;
    margin-left:auto;
}
div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code, form, fieldset, legend, input, textarea, p, blockquote, th, td, hr, button, article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
    margin: 0;
    padding: 0;
}
h1, h2, h3, h4, h5, h6 {
    font-size: 100%;

    font-weight: 500;
}
.container12 {
    margin-left: auto; 
    margin-right: auto;
}
.container12 .grid10 {
    width: 780px;
    margin-left:auto;
    margin-right:auto;
}
.pg-webservice-content {
    background: none repeat scroll 0 0 #fff;
    color: #555;
    padding: 40px 80px;
}
.text-center {
    text-align: center;
}

.mtop40 {
    margin-top: 40px;
}
.mb20 {
    margin-bottom: 20px;
}
.mt20 {
    margin-top: 20px;
}
.textInd {
    text-indent: 2em;
}
.pg-webservice-content > div, .pg-webservice-content .attach > div {
    margin-top: 30px;
}
ol, ul {
    list-style: outside none none;
}
.fn-clear:after {
    clear: both;
    content: " ";
    display: block;
    font-size: 0;
    height: 0;
    visibility: hidden;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
}
.pg-webservice-content li {
    line-height: 24px;
    margin-bottom: 10px;
}
.pg-webservice-content h2 {
    font-size: 22px;
    margin-bottom: 20px;
}
.pg-webservice-content li span {
    display: block;
    width: 40px;
}
.fn-left {
    float: left;
}
.pg-webservice-content > div, .pg-webservice-content .attach > div {
    margin-top: 30px;
}
.pg-webservice-content h2 {
    font-size: 22px;
    margin-bottom: 20px;
}
.pg-webservice-content li p {
    width: 740px;
}
.fn-left, .fn-right {
    display: inline;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
}
.bgtable {
    width: 97%;
    border: 1px solid #555;
    margin-left: 40px;
}
.bgtable tr td {
    height: 38px;
    border-bottom: 1px solid #555;
    border-right: 1px solid #555;
}
.bgtable .tdtitle {
    width: 20%;
    text-align: center;
}
.bgtable .tddesc {
    padding-left: 10px;
}
.mt30, .mt {
    margin-top: 30px;
}
.pl40 {
    padding-left: 40px;
}
.mt10 {
    margin-top: 10px;
}
	.mtop40{ margin-top:40px;}
	.textInd{ text-indent:2em;}
	.strong{font-weight:bold;}
	.plt40{ padding-left:40px;}
	.red{ color:#f8586a;}
	.tksp{ display:inline-block; border-bottom:1px solid #555; padding:0px 15px;}
	.tddescxy{  width:24%;}
	.trtitle td{ text-align:center;}
	.trdesc td p{ text-align:center;}
	.xytable{width:100%;}
</style>
</head>
<body>
    <!-- container-->
    <div id="pg-webservice">
        <div class="container_12">
            <div class="grid_10 pg-webservice-content">
                <h1 class="text-center" style="font-size:24px">
                    借款保证协议</h1>

                <p class="mt20 mb20">
                    甲方（出借人）：
                </p>
                <table cellpadding="0" cellspacing="0" class="xytable">
                    <tr class="trtitle">
                        <td class="tdtitle" style="width: 20%;">
                            <p>
                                姓名</p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                                投标来源</p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                                借出金额</p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                                借款期限</p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                                应收本息</p>
                        </td>
                    </tr>
                    <tr class="trtitle">
                        <td class="tdtitle" style="width: 20%;">
                            <p>
                            ${result.pui_real_name}
                            </p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                            	<#if result.ptr_channel=="10">
                            	PC
                            	<#elseif result.ptr_channel=="11">
                            	IOS
                            	<#elseif result.ptr_channel=="12">
                            	Android
                            	<#elseif result.ptr_channel=="13">
                            	H5
                            	</#if>
                            </p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                             <#if result.ptr_amount??>${result.ptr_amount?string("#,##0.00")}</#if>
                            </p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                            ${result.pp_loanTerm}
                            <#if result.pp_loanRepayment=="2">
                                                            天
                             <#else>
                                                            月                                 
                            </#if>
                            </p>
                        </td>
                        <td class="tddescxy" style="width: 20%;">
                            <p>
                                <p><#if result.ptp_factInterest??>${result.ptp_factInterest?string("#,##0.00")}</#if></p>
                            </p>
                        </td>
                    </tr>

                </table>
                <p class=" mt10 mb20 plt40">
                    注：因计算中存在四舍五入，最后一期应收本息与之前略有不同；
                </p>
                <p class="mtop40 mb20 ">
                    乙方（借款人）：<span></span>
                </p>
                <p class="mt20 mb20">
                    真实姓名：<span>${result.loan_real_name}</span>
                </p>
                <p class="mt20 mb20">
                    身份证号：<span>${result.pui_cert_no}</span>
                </p>
                <p class="mt20 mb20">
                    联系电话：<span>${result.pu_mobile}</span>
                </p>
                <p class="mtop40 mb20 ">
                    丙方（保证人）：<span></span>
                </p>
                <p class="mt20 mb20">
                    真实姓名：<span>${result.productContract.bailName}</span>
                </p>
                <p class="mt20 mb20">
                    身份证号：<span>${result.productContract.bailIDNumber}</span>
                </p>
                <p class="mt20 mb20">
                    联系电话：<span>${result.productContract.bailContactNumber}</span>
                </p>
                <p class="mtop40 mb20 ">
                    丁方（佰宝金服网站平台）：中融佰诚投资管理有限公司
                </p>
                <p class="mt20 mb20">
                    联系地址：北京市朝阳区金泉时代广场写字楼1单元16层
                </p>
                <p class="mt20 mb20">
                    鉴于：
                </p>
                <p class="mt20 mb20">
                    1.1&nbsp;&nbsp;&nbsp;&nbsp;丁方是一家在   市合法成立并有效存续的有限责任公司，拥有www.baibao.com 网贷平台（下称“网贷平台”或“平台”）的经营权，并为各主体在网贷平台上达成的交易提供信用咨询服务和信息服务；
                </p>
                <p class="mt20 mb20">
                    1.2&nbsp;&nbsp;&nbsp;&nbsp;乙方有借款需求,且已在网贷平台注册，并将其主体及借款需求信息通过自己或其代理人提供予丁方并由丁方在网贷平台发布；
                </p>
                <p class="mt20 mb20">
                    1.3&nbsp;&nbsp;&nbsp;&nbsp;甲方已在网贷平台注册,同意以其自有资金进行出借；
                </p>
                <p class="mt20 mb20">
                    1.4&nbsp;&nbsp;&nbsp;&nbsp;甲乙双方均同意通过网贷平台进行网上点击操作从而签署电子协议和/或线下签署书面协议的方式达成借款交易；
                </p>
                <p class="mt20 mb20">
                    1.5&nbsp;&nbsp;&nbsp;&nbsp;丙方依据中国法律具有保证人主体资格，依法具有完全的代偿能力，可以对外提供保证担保。
                </p>
                <p class="mtop20 mb20">
                    据此，各方经协商一致，达成如下协议，以资共同遵照履行：
                </p>

                <h2>
                    第一条          借款详情
                </h2>
                <table cellpadding="0" cellspacing="0" class="bgtable">
                    <tr>
                        <td class="tdtitle">
                            <p>
                                借款本金数额</p>
                        </td>
                        <td class="tddesc">
                            <p>
                                （各出借人借款本金数额详见本协议文首表格）
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>
                                借款年利率</p>
                        </td>
                        <td class="tddesc">
                            <p>
                                <span class="tksp"><#if result.pp_comprehensiveRate !=0>${result.pp_comprehensiveRate}</#if></span>%
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>
                                借款期限</p>
                        </td>
                        <td class="tddesc">
                           <p>
                            <span class="tksp"><#if result.pp_bulkLoanEffectTime??>${result.pp_bulkLoanEffectTime?string("yyyy")}</#if></span>年
								<span class="tksp"><#if result.pp_bulkLoanEffectTime??>${result.pp_bulkLoanEffectTime?string("MM")}</#if></span>月
								<span class="tksp"><#if result.pp_bulkLoanEffectTime??>${result.pp_bulkLoanEffectTime?string("dd")}</#if></span>日起，至
								<span class="tksp"><#if result.loanEndDate??>${result.loanEndDate?string("yyyy")}</#if></span>年
								<span class="tksp"><#if result.loanEndDate??>${result.loanEndDate?string("MM")}</#if></span>月
								<span class="tksp"><#if result.loanEndDate??>${result.loanEndDate?string("dd")}</#if></span>日止
							</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>
                                每期偿还本息数额及还款日</p>
                        </td>
                        <td class="tddesc">
                            <p>
							<#if result.tenderProfitList??>
                        		<#list result.tenderProfitList as tenderp>
                        			 <p>
                        				<span>${tenderp.ptpProfit}</span>,
                        				<span>${tenderp.ptpProfittime?string("yyyy-MM-dd")}</span>
                        			</p>
                        		</#list>
                        	</#if>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>
                                还款期数</p>
                        </td>
                        <td class="tddesc">
                            <p>
                                <span class="tksp">${result.periods}</span>期</p>
                        </td>
                    </tr>

                    <tr>
                        <td class="tdtitle">
                            <p>
                                <span class=" ">风险备用金</span></p>
                        </td>
                        <td class="tddesc">
                            <p>
                                每期偿还本息数额及还款日<span class="tksp">${result.pp_riskManageAmountRate}</span>%
                            </p>
                        </td>
                    </tr>
                </table>
                <p class="mt10 mb20 plt40 strong">
                    注：前述还款期限、还款日均根据本协议成立生效之日起确定。
                </p>
                <div>
                    <h2>
                        第二条          协议的订立及支付
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">2.1</span>
                            <p class="fn-left">
                                各方同意并确认，各方通过自行或授权其代理人根据网贷平台有关规则和说明，在网贷平台通过点击相关按钮签署电子协议和/或线下签署书面协议的形式进行借款申请和投标操作等方式确认签署本协议。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">2.2</span>
                            <p class="fn-left">
                               各方在网贷平台进行借款申请操作和投标操作之前，均需仔细阅读并确认同意本协议各条款以及同意本协议的签署。各方通过上述方式签署本协议且各甲方同意出借资金总额达到乙方借款金额、丁方对本协议的签署程序、所涉内容进行复核、担保/反担保措施进行落实并确认通过时本协议即成立,并将本协议在网贷平台保存。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">2.3</span>
                            <p class="fn-left">
                                甲方同意并授权丁方按本协议及网贷平台有关规则的约定对出借款项和相关费用进行划扣和支付，并由丁方代为收取乙方支付的借款本息及有关费用。甲方在此授权丁方于本协议成立后将已充值至甲方网贷平台账户的出借资金划付至乙方的网贷平台账户，完成本协议项下资金的出借。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第三条          各方权利和义务
                    </h2>
                    <ol>
                        <li class="fn-clear strong "><span class="fn-left num-list">3.1</span>
                            <p class="fn-left">
                                甲方的权利和义务
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.1</span>
                            <p class="fn-left">
                                甲方应保证其向网贷平台提供的信息、资料均为合法、真实、有效，不存在任何虚假、遗漏和隐瞒；同时，甲方保证其所用于出借的资金来源合法且是该资金的合法所有人，并非任何非法活动所得，也非汇集他人之资金或甲方受托管理之财产；如果第三人对资金归属、合法性问题发生争议，由甲方负责解决并自行承担相关责任；在该等争议解决（以取得生效的判决、裁决或行政命令、通知为标志）之前，丁方有权根据政府机关、司法机关或仲裁机关出具且生效的命令、判决、裁定或其他法律文件拒绝向甲方支付丁方代其领受的相关款项。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.2</span>
                            <p class="fn-left">
                               甲方享有其出借款项所带来的利息收益，并应自行承担并缴付就该等利息收益应当缴付之税费（如有）。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.3</span>
                            <p class="fn-left">
                               如根据本协议约定的顺序清偿时，乙方还款不足以偿还约定本金、利息及逾期罚息等应付全部款项的，甲方同意各自按照其借出款项比例收取还款。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.4</span>
                            <p class="fn-left">
                               就任一甲方在本协议项下对乙方的部分或全部债权，任一甲方均有权根据自己的意愿对外转让，但要符合丁方相关规则及程序，并应承担债权转让而产生的相关费用。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.5</span>
                            <p class="fn-left">
                              如乙方违反本协议项下对甲方负有的任何义务，甲方有权要求丁方提供其已获得的乙方信息、资料。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.6</span>
                            <p class="fn-left">
                               甲方承诺对依据本协议获得的乙方信息、资料予以保密，除用于本协议目的进行资金出借与催收外，不得向外转让或披露。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.1.7</span>
                            <p class="fn-left">
                                本协议和法律法规规定的其他权利义务。
                            </p>
                        </li>
                    </ol>
                    <ol>
                        <li class="fn-clear strong "><span class="fn-left num-list">3.2</span>
                            <p class="fn-left">
                                乙方权利和义务
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.1</span>
                            <p class="fn-left">
                                乙方保证其向丙方、丁方提供的信息、资料均为真实、合法、有效，且不存在任何虚假、遗漏和隐瞒。若乙方违反本协议任何约定，丙方、丁方有权根据本协议及有关条款对乙方的信息和资料予以合理的披露。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.2</span>
                            <p class="fn-left">
                               除按照本协议约定进行使用外，乙方不得将本协议项下之借款用于其他任何用途。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.3</span>
                            <p class="fn-left">
                                乙方必须按期足额向甲方归还每期应还本金和利息，一次性向丁方按期足额支付相关平台服务费、风险备用金，并支付与乙方逾期或提前还款有关的其它费用。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.4</span>
                            <p class="fn-left">
                                乙方有权了解其在丁方的信用评审进度及结果。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.5</span>
                            <p class="fn-left">
                               乙方不得将本协议项下的任何权利义务转让给任何其他方。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.6</span>
                            <p class="fn-left">
                                乙方确认甲方可以根据自己的意愿对其根据本协议形成的对乙方的部分或全部债权进行转让，并特此同意甲方届时转让债权无需事前通知乙方；债权转让完成时，该等转让信息将在乙方网贷平台账户显示；
                                该等债权转让通知一经在乙方网贷平台账户显示，即视为甲方已将债权转让事宜通知乙方，乙方不得以任何理由对此提出异议或抗辩。同时乙方承诺将采取必要措施配合债权的一次或多次转让或届时债权人债权的实现。在债权转让后，甲方在本协议项下的权利和义务全部自动转移到债权受让人名下，乙方应按照本协议的约定向债权受让人支付每期应还借款本息。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.7</span>
                            <p class="fn-left">
                               乙方同意，甲方和丙方、丁方有权使用其自行收集或乙方提供的乙方资料和信息用于包括但不限于如下用途：
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.7.1</span>
                            <p class="fn-left">
                                     &nbsp;&nbsp;为了提供本协议项下的服务，丙方和丁方向有关的合作机构提供必要之资料；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.7.2</span>
                            <p class="fn-left">
                               &nbsp;&nbsp; 用于进行催收、解决争议、对纠纷进行调停等；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.7.3</span>
                            <p class="fn-left">
                               &nbsp;&nbsp; 本协议或法律法规规定的其他用途。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.8</span>
                            <p class="fn-left">
                                乙方同意并确认，若乙方未能及时按本协议向甲方清偿该等借款本金、利息及其他有关费用等，在丙方代乙方向甲方清偿该等借款本金、利息及其他有关费用等款项并书面通知乙方后两日内，乙方无条件向丙方清偿该等借款本金、利息、复利、罚息、违约金、赔偿金、实现债权的费用（包括但不限于律师费、诉讼费、执行费、保全费、鉴定费、交通费、住宿费等费用）和所有其他本协议约定之应付费用等，乙方无任何异议。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.9</span>
                            <p class="fn-left">
                               乙方同意及确认：若乙方未能及时按本协议向丁方支付平台服务费，在收到丁方通知后两日内仍未履行，丙方无条件代乙方向丁方清偿平台服务费、滞纳金、逾期保费及其它费用。丙方代偿后，乙方视该等款项为对丙方的欠款，应于两日内向丙方偿付，乙方无任何异议。甲乙丙丁四方约定，乙方逾期未支付的本协议项下的所有款项均视为乙方对甲丙丁方之欠款，甲丙丁各方均可向乙方直接以欠款进行追偿。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.10</span>
                            <p class="fn-left">
                               &nbsp; 乙方出现下列情况，应在发生下列情况之日起三日内书面通知甲方和丁方：
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.10.1</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;与乙方有牵连的重大违纪、违法、犯罪或被索赔事件；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.10.2</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;乙方身体健康、财务状况发生恶化；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.10.3</span>
                            <p class="fn-left">
                               &nbsp;&nbsp;&nbsp;&nbsp;与乙方有关的婚姻、家庭析产及遗产纠纷；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.10.4</span>
                            <p class="fn-left">
                              &nbsp;&nbsp;&nbsp;&nbsp;乙方或乙方所有、控股或参股的企业出现或即将出现被解散、卷入重大诉讼或仲裁、人民法院受理以乙方所有、控股或参股的企业为被申请人的破产申请及其他法律纠纷；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.10.5</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;其他可能影响乙方财务状况和偿债能力的情况
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11</span>
                            <p class="fn-left">
                               &nbsp;乙方在发生下列任一情况之前，必须书面通知丙方和丁方,并如实提交有关资料。经丁方审查后认为不影响反担保保证协议项下债权的实现并且书面同意之后，乙方才能付诸实施：
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11.1</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;在反担保保证协议有效期内，乙方再向第三方提供任何形式的担保的情况；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11.2</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;乙方所有、控股或参股的企业实行承包、租赁、联营、托管；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11.3</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;乙方所有、控股或参股的企业实行股份制改造、合并、兼并、分立；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11.4</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;乙方所有、控股或参股的企业自行解散、撤销、转产、清盘、歇业；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11.5</span>
                            <p class="fn-left">
                               &nbsp;&nbsp;&nbsp;&nbsp; 乙方转让本反担保保证协议项下权利、义务；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.11.6</span>
                            <p class="fn-left">
                                &nbsp;&nbsp;&nbsp;&nbsp;其他需要丙方和丁方书面同意的事项。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.12</span>
                            <p class="fn-left">
                                &nbsp;乙方承诺：如对丙方的反担保既有保证人又有物的担保的，乙方承诺不以丙方先行使担保物权以实现债权进行抗辩，始终对丙方享有的债权承担连带清偿责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.13</span>
                            <p class="fn-left">
                               &nbsp;主协议无效、被撤销或解除的，乙方对其应承担的民事责任，向甲丙丁方承担连带责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.14</span>
                            <p class="fn-left">
                                &nbsp;借款期间，乙方不得向第三方提供超出其自身负担能力的担保，不得将财产抵押或质押给第三方。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.15</span>
                            <p class="fn-left">
                                &nbsp;发生下列情况之一的，乙方必须提前承担反担保责任：
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.15.1</span>
                            <p class="fn-left">
                               &nbsp;&nbsp;&nbsp;&nbsp; 乙方违反本协议的约定或者发生其他严重违约的行为；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.15.2</span>
                            <p class="fn-left">
                               &nbsp;&nbsp;&nbsp;&nbsp; 本协议履行期间乙方或乙方被宣告破产、被解散、撤自变更企业注册内容、卷入或即将卷入重大的诉讼或仲裁程序及发生其他足以影响其偿债能力的事件。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.2.16</span>
                            <p class="fn-left">
                                &nbsp;本协议和法律法规规定的其他权利义务。
                            </p>
                        </li>
                    </ol>
                    <ol>
                        <li class="fn-clear strong "><span class="fn-left num-list">3.3</span>
                            <p class="fn-left">
                                丙方的权利和义务
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.1</span>
                            <p class="fn-left">
                                丙方有足够的能力承担保证责任，并不因任何指令、财力状况的改变、与任何单位签订的任何协议而减轻或免除所承担的保证责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list strong">3.3.2</span>
                            <p class="fn-left">
                                丙方完全了解乙方的借款用途，为本借款保证协议，丙方提供担保保证完全出于自愿，丙方在本协议项下的全部意思表示真实。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.3</span>
                            <p class="fn-left">
                               丙方愿意以拥有的全部个人财产承担无限连带担保责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.4</span>
                            <p class="fn-left">
                                丙方保证对其财产拥有完全的所有权。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.5</span>
                            <p class="fn-left">
                                丙方代乙方向甲方清偿的借款本金、利息、复利、罚息、违约金、损害赔偿金、实现债权的费用（包括但不限于律师费、诉讼费、执行费、保全费、鉴定费、交通费、住宿费等费用）；对乙方应向丁方支付的平台服务费、滞纳金、其它费用，以及丙方代乙方偿还上述款项所发生的其他费用承担担保责任后有权利向乙方追偿。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.6</span>
                            <p class="fn-left">
                               就本协议所担保对象及其担保范围，如还有其他反担保人保证或其他担保形式的，各反担保人承担连带保证责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.7</span>
                            <p class="fn-left">
                                如本协议所担保的债务存在其他保证的，除丙方以外的保证人均不分份额向甲方承担连带保证责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.8</span>
                            <p class="fn-left">
                                丙方为实现担保权利而产生的费用，包括但不限于诉讼费、律师费、咨询费、差旅费等均由乙方负担。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.9</span>
                            <p class="fn-left">
                                本协议项下债权的担保期间：自本协议项下约定的债务履行期限届满之日起两年。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.10</span>
                            <p class="fn-left">
                                &nbsp;未经丁方同意，丙方不得将本协议项下的任何权利义务转让给任何其他方。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.3.11</span>
                            <p class="fn-left">
                                &nbsp;本协议和法律法规规定的其他权利义务。
                            </p>
                        </li>

                    </ol>
                    <ol>
                        <li class="fn-clear strong "><span class="fn-left num-list">3.3</span>
                            <p class="fn-left">
                                丁方的权利和义务
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.4.1</span>
                            <p class="fn-left">
                                丁方有权根据乙方提供的各项信息及丁方独立获得的信息评定乙方在丁方处所拥有的个人和/或企业信用等级，并根据对乙方个人和/或企业信息的评审结果，决定是否审核通过并将乙方的借款需求向甲方进行推荐。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.4.2</span>
                            <p class="fn-left">
                               甲方在此同意并确认：向乙方出借相应款项时，委托丁方在本协议成立后将该笔借款直接划付至乙方账户。甲方授权并委托丁方代其收取本协议文首所约定的出借人每月应收本息，代收后划付至甲方的网贷平台账户，乙方对此表示认可。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.4.3</span>
                            <p class="fn-left">
                                丁方有权就为本协议借款所提供的服务向乙方收取平台服务费及本协议约定的其他费用。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.4.4</span>
                            <p class="fn-left">
                                甲乙丙三方同意丁方有权协助甲方在必要时对乙方进行借款的违约提醒、催收、执行担保物的工作，包括但不限于电话通知、短信通知、微信通知、上门通知、发律师函、向乙方提起诉讼、处置担保物、向保证人追偿等。甲方在此确认委托丁方为其进行以上工作，并授权丁方可以将此工作委托给其他方进行。乙方对前述委托的提醒、催收、起诉、处置担保物、向保证人追偿等事项已明确知晓并应积极配合，同时应承担因自身逾期还款而产生的催收、起诉、处置担保物、向保证人追偿等相关费用。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.4.5</span>
                            <p class="fn-left">
                                丁方接受甲乙丙三方的委托行为所产生的法律后果由相应委托方承担。如因乙方或甲方或丙方其他非因丁方所能预见/控制的原因（包括但不限于技术问题）造成的延误或错误，丁方不承担任何责任。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">3.4.6</span>
                            <p class="fn-left">
                                丁方应对甲乙丙三方的信息保密；但发生本协议其他条款约定的丁方可以进行披露的情形，或相关权力部门要求（包括但不限于法院、仲裁机构、金融监管机构等）披露的，丁方有权披露。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第四条          平台服务费用
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">4.1</span>
                            <p class="fn-left">
                               对于丁方向乙方提供的撮合本协议项下借款交易达成之管理和居间撮合服务、信用评估服务、尽职实地调查服务、担保措施代办服务而收取的对价（以下统称“平台服务费”），乙方同意在本协议生效时向丁方支付本协议第一条所约定借款本金总额的 【   %】(即人民币（大写）                元)作为平台服务费，该“平台服务费”由甲乙双方授权并委托丁方根据本协议规定在划扣出借本金时一次性扣除支付给丁方，扣除后视为乙方已缴纳。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">4.2</span>
                            <p class="fn-left">
                               对于本协议项下交易达成后丁方为乙方提供的还款管理、持续的信用与信息服务，在第一条约定的借款期限内，乙方应在第1条约定的还款日向丁方支付每月借款本息。利息系由甲方为乙方提供出借资金而收取的对价。乙方在此确认对平台服务费和利息的计算和收取方式表示理解和认可。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">4.3</span>
                            <p class="fn-left">
                                如乙方和丁方协商一致调整平台服务费时，无需经过甲方和丙方同意。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第五条          违约责任
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">5.1</span>
                            <p class="fn-left">
                               协议各方均应严格履行协议义务，非经各方协商一致或依照本协议约定，任何一方不得解除本协议。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.2</span>
                            <p class="fn-left">
                                任何一方违约，违约方应承担因违约使得其他各方产生的费用和损失，包括但不限于调查、诉讼费、律师费等。如违约方为乙方的，甲方有权立即解除本协议，并要求乙方立即偿还未偿还的本金、利息、罚息。此时，乙方还应向丁方支付所有应付的平台服务费。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.3</span>
                            <p class="fn-left">
                                乙方在此承诺并确认，本协议提前解除时，若乙方在网贷平台的账户里有任何资金余款，丙方和丁方有权按照本条约定的清偿顺序将乙方的余款用于清偿，并要求乙方支付因此产生的相关费用。乙方的每期还款均应按照如下顺序清偿：罚息；逾期利息；逾期本金；届期但未逾期的利息；届期但未逾期的本金。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.4</span>
                            <p class="fn-left">
                               乙方应严格履行还款义务，如乙方逾期还款，则应按照下述条款向甲方支付逾期罚息，且对于乙方发生的逾期款项，均应按照本条规定分别计算罚息后加总。自逾期开始之后，逾期本金的正常利息停止计算。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left">
                                罚息总额 = 逾期本息总额×对应罚息利率×逾期天数；
                            </p>
                        </li>
                        <table cellpadding="0" cellspacing="0" class="bgtable">
		                    <tr>
		                        <td class="tdtitle">
		                            <p>
		                                逾期天数</p>
		                        </td>
		                        <td class="tddesc" style="width: 35%;">
		                            <p>
		                                1日— 7日
		                            </p>
		                        </td>
		                        <td class="tddesc">
		                            <p>
		                                7日及以上（不包含7日）
		                            </p>
		                        </td>
		                    </tr>
		                    <tr>
		                        <td class="tdtitle">
		                            <p>
		                                罚息利率</p>
		                        </td>
		                        <td class="tddesc" style="width: 35%;">
		                            <p>
		                                3‰
		                            </p>
		                        </td>
		                        <td class="tddesc">
		                            <p>
		                                5‰
		                            </p>
		                        </td>
		                    </tr>
		                </table>
                        <li class="fn-clear"><span class="fn-left num-list">5.5</span>
                            <p class="fn-left">
                                除本协议另有约定外，如果乙方逾期支付任何一期还款超过三日或甲丙丁三方发现乙方出现逃避、拒绝沟通或拒绝承认欠款事实、故意转让资产、信用情况恶化等危害或可能危害本协议项下甲方权利实现的情形，则甲方在此授权丁方有权向乙方发出书面通知要求乙方在本协议项下的全部借款本息于通知发出日或通知记载的其他日期（“提前到期日”）提前到期，同时：
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.5.1</span>
                            <p class="fn-left">
                                乙方应立即清偿本协议下尚未偿付的全部本金、利息、罚息及根据本协议产生的其他全部费用；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.5.2</span>
                            <p class="fn-left">
                               丁方有权将乙方的“逾期记录”、“恶意行为”或“不良情况”提供给中国人民银行个人信用信息基础数据库及信贷征信主管部门批准建立的个人信用数据库，以供有关单位、部门或个人依法查询和使用；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.5.3</span>
                            <p class="fn-left">
                               丁方有权将乙方违约失信的相关信息及乙方其他信息向包括但不限于媒体、用人单位、公安机关、检察机关、法律机关及有关逾期款项催收服务机构披露。对此丙方不承担任何责任；
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.5.4</span>
                            <p class="fn-left">
                               丁方有权以各种通讯手段(包括但不限于：电话、短信、微信等各种通讯手段)告知乙方的近亲属、朋友乙方的欠款信息，并在丁方网贷平台或其他报纸、网贷平台上发布乙方的欠款信息，信息内容包括但不限于乙方的姓名、身份证号码、住址、工作单位、照片、欠款金额、逾期时间及违约责任等。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.5.5</span>
                            <p class="fn-left">
                               在乙方还清全部本金、利息、平台服务费、罚息之前，罚息的计算不停止。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">5.5.6</span>
                            <p class="fn-left">
                               本借款协议中的所有甲方与乙方之间的借款、丙方与甲方的保证担保均是相互独立的，一旦乙方逾期未归还借款本息，甲方中的任何一方和/或丙方(向甲方履行了保证义务后)均有权单独向乙方追索或者提起诉讼。如乙方逾期支付平台服务费或应付丁方的其他费用或提供虚假信息的，丁方亦可单独向乙或者丙方追索或者提起诉讼。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第六条          提前还款
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">6.1</span>
                            <p class="fn-left">
                                乙方可在借款期间任何时候申请于某一还款日提前偿还全部剩余借款。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">6.2</span>
                            <p class="fn-left">
                                乙方提前清偿全部剩余借款时，应向甲方支付当期应还本息，剩余本金及提前还款手续费，其中，提前还款手续费为剩余本金的【      %】。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">6.3</span>
                            <p class="fn-left">
                                乙方提前清偿全部剩余借款时，丁方已收取的平台服务费以及其他费用（如有）不予退还。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第七条          款项垫付
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left textInd">
                               各方在此确认，乙方在本协议项下应付借款本息，在乙方逾期的情况下，丙方应履行担保责任先向甲方垫付还款金额。丙方不能履行保证责任代乙方偿还借款情况下，启用丁方之风险备用金计划（点击查阅风险备用金计划规则）。丙方根据保证担保约定对甲方进行偿付之后，即取得甲方对乙方享有之相应债权，丙方和丁方有权行使本协议规定的甲方之各项权利。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第八条          法律适用及争议解决
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">8.1</span>
                            <p class="fn-left">
                              本协议的签订、履行、终止、解释均适用中华人民共和国法律。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">8.2</span>
                            <p class="fn-left">
                                本协议在履行过程中，如发生任何争执或纠纷，甲乙丙丁四方应友好协商解决；若协商不成，应向丁方注册地有管辖权的人民法院提起诉讼。
                            </p>
                        </li>
                    </ol>
                </div>
                <div>
                    <h2>
                        第九条          附则
                    </h2>
                    <ol>
                        <li class="fn-clear"><span class="fn-left num-list">9.1</span>
                            <p class="fn-left">
                                本协议根据第二条的规定成立时，本协议第二、八、九条即生效；本协议其他条款于甲方的出借资金由丁方在确认本协议成立后根据甲方授权划付至乙方网贷平台账户（乙方即可支配）时即生效。在乙方将本协议项下的全部本金、利息、逾期罚息及其他所有相关费用全部偿还完毕后，本协议自动终止。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">9.2</span>
                            <p class="fn-left">
                                各方可以书面协议方式对本协议作出修改和补充。经过各方签署的有关本协议的修改协议和补充协议是本协议组成部分，具有与本协议同等的法律效力。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">9.3</span>
                            <p class="fn-left">
                                本协议及其修改或补充采用通过网贷平台以电子和/或书面文本形式制成，可以有一份或者多份并且每一份具有同等法律效力，并永久保存在丁方为此设立的专用服务器上备查和保管。协议各方均认可这两种形式的协议效力。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">9.4</span>
                            <p class="fn-left">
                                如果本协议中的任何一条或多条违反适用的法律法规而被认定、判断为无效或不具有强制执行效力，该等无效、不具有强制执行效力的条款并不影响本协议其他条款的效力。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">9.5</span>
                            <p class="fn-left">
                                本协议签订之日起至借款本息和有关费用全部清偿之日止，甲方的手机号码或者电子邮件地址发生变更的，应当在变更后立即至网贷平台进行信息修改操作的方式通知丁方；乙方的下列信息如发生变更的，其应当在相关信息发生变更三日内将更新后的信息提供给丁方：本人的家庭联系人及紧急联系人、本人的工作单位、居住地址、住所电话、手机号码、电子邮箱、银行账户的变更。若因任何一方不及时提供上述变更信息而带来的损失或额外费用应由该方自行承担。
                            </p>
                        </li>
                        <li class="fn-clear"><span class="fn-left num-list">9.6</span>
                            <p class="fn-left">
                                各方同意，本协议项下的借款或债权发生转让时，为便于各方明确责任主体更好地履行本协议，丁方将按照附件一所列格式制作债权转让交易记录并作为本协议的附件。
                            </p>
                        </li>
						
                    </ol>
                </div>
                <p class="mt40 mb20">
                    （以下无正文）
                </p>
                 <p class="mt20 mb20">
                    甲方（签字或盖章）： ${result.pui_real_name}
                </p>
                <p class="mt20 mb20">
                    乙方（签字或盖章）：${result.loan_real_name}
                </p>
                <p class="mt20 mb20">
                    丙方（签字或盖章）：张小平
                </p>
                <p class="mt20 mb20">
                    丁方（签字或盖章）：中融佰诚投资管理有限公司
                </p>
                <p class="mt20 mb20">
                    时间：<#if result.pp_bulkLoanEffectTime??>${result.pp_bulkLoanEffectTime?string("yyyy-MM-dd")}</#if>
                </p>
            </div>
        </div>
    </div>
</body>
</html>
