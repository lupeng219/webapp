<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>债权转让及回购协议-佰宝金服-安全透明灵活的互联网金融服务平台</title>
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
.pg-webservice-content .li {
    line-height: 24px;
    margin-bottom: 10px;
}
.pg-webservice-content h2 {
    font-size: 22px;
    margin-bottom: 20px;
}
.pg-webservice-content .li span {
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
    .pg-webservice-content .li span {width: 49px; float:left;}
    .pg-webservice-content .li p { width: 731px;float: left;}
    
    </style>
</head>
<body>
   <!-- container-->
    <div id="pg-webservice">
        <div class="container_12">
            <div class="grid_10 pg-webservice-content">
                <h1 class="text-center">
                    债权转让及回购协议</h1>
                <p class="mt20 mb20">
                    本债权转让及受让协议（下称“本协议”）由以下双方于签署： 
                </p>
                <p class="mtop40 mb20">
                    甲方（出让方）：<span>${result.pui_real_name}</span>
                </p>
                <p class="mt20 mb20">
                    证件类型：<span>
                    <#if result.productContract.licensetype ==1>
                    	营业执照
                    <#elseif result.productContract.licensetype ==2>
                    	身份证
                    </#if>
                </span>
                </p>
                <p class="mt20 mb20">
                    证件号码：<span>${result.productContract.idno}</span>
                </p>
                <p class="mt20 mb20">
                    住所（地址）：<span>${result.productContract.address}</span>
                </p>
                <p class="mt20 mb20">
                    联系方式：<span>${result.pu_mobile}</span>
                </p>
                <p class="mtop40 mb20">
                    乙方（受让方）：<span>${result.lender}</span>
                </p>
                <p class="mt20 mb20">
                    证件类型：<span>
                    <#if result.lpui_cert_type =='IC'>
                    	身份证
                    </#if>
                </span>
                </p>
                <p class="mt20 mb20">
                    证件号码：<span>${result.lpui_cert_no}</span>
                </p>
                <p class="mt20 mb20">
                    住所（地址）：<span>${result.lpui_address}</span>
                </p>
                <p class="mt20 mb20">
                    联系方式：<span>${result.lpu_mobile}</span>
                </p>
                <p class="mtop40 mb20">
                    丙方（居间人）：<span>中融佰诚投资管理有限公司</span>
                </p>
                <p class="mt20 mb20">
                    证件类型：<span>营业执照</span>
                </p>
                <p class="mt20 mb20">
                    证件号码：<span>110105016632432</span>
                </p>
                <p class="mt20 mb20">
                    住所（地址）：<span>北京市朝阳区大屯路金泉时代广场1单元16层</span>
                </p>
                <p class="mt20 mb20">
                    联系方式：<span>010-53347795</span>
                </p>
                <p class="mt20 mb20">
                    法定代表人：<span>聂建军</span>
                </p>
                <div>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left ">甲方拥有资金需求拟通过在丙方平台以获取融资目的，丙方掌握丰富的出资项目资源信息并拥有专业的信用评价和管理服务平台；甲乙双方愿意接受丙方提供的居间服务，由丙方撮合甲方与投资人达成投融资交易，并由丙方提供与投融资交易的履行有关的其他服务。因此，三方根据平等、自愿的原则，达成本协议如下：</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>
                        1.1定义：</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left ">在本协议中，下列词语具有以下含义：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left ">(1)投资人：指在丙方平台实名注册，并通过丙方平台实现资金投资且具有完全民事权利及行为能力的中国境内自然人，包括但不限于乙方。</p>
                        </div>
                        <div class="fn-clear li"><span class="fn-left num-list"></span>
                            <p class="fn-left">(2)融资人：指在丙方平台实名注册，对平台上借款人、权益出让人等资金需求方的统称，指通过丙方促成的、与乙方签署相关协议，从而得到投资人投资资金的自然人、法人以及其他形式的经济组织。
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)原始债务人：指在丙方平台转让的既有债权或收益权项目中与原始债权人签订的债权债务协议中承担债务的一方。
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)融资人基本信息：指融资人根据与丙方另行签署的相关协议和丙方平台规则而向丙方提供的姓名、身份证件号码、住址信息等基本信息，其范围应以丙方平台规则为准。
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(5)融资人信用信息：指丙方自行收集以及通过第三方合作机构获得的融资人的除融资人基本信息之外的其他信息，如融资人的工作情况、收入情况、家庭情况、信用报告、历史偿债情况等。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(6)融资人信息：指融资人基本信息、融资人信用信息以及丙方根据该等信息对融资人做出的信用评级的合称。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(7)融资人信用评级：指丙方根据融资人信息及丙方内部的评级规则对融资人进行的信用评级。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(8)融资协议：指经丙方提供服务从而促成的由乙方或其他投资人（视情况而定）与融资人以电子协议和/或纸质方式的形式订立并自动生成的，约定乙方或其他投资人（视情况而定）向融资人提供一定数额的投资资金，融资人在约定还款日归还或代为归还本金及利息的协议。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(9)债权：指在融资协议项下乙方所拥有的全部本金、利息、逾期罚息、违约金等债权，以人民币计价。</p>
                        </div>
                        <div class="fn-clear  li">
                            <p class="fn-left">(10)既有债权：指由丙方促成的、乙方通过与甲方签署的《债权转让及回购协议》而取得的甲方既有的对原始债务人的债权。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(11)提前还款：指融资协议中约定了融资人的本息偿还周期和金额等相关还款计划，融资人可能在协议规定的偿还周期结束前，在某一期将剩余本金全部提前偿还给乙方，从而使乙方的本金比约定的计划提前收回。</p>
                        </div>
                    </div>
                    <h2>
                        1.2居间服务的内容</h2>
                      <div>
                      	<div class="fn-clear li"><span class="fn-left num-list"></span>
                            <p class="fn-left">甲乙双方自愿成为丙方平台的融资人和投资人，可以通过丙方平台向潜在投资人融资和潜在融资人投资。甲乙双方可以在本平台享受丙方提供的融资投资咨询服务、资信评估、信息公布、信息交互、撮合服务等居间服务。</p>
                        </div>
                      </div>  
                </div>
                <div>
                  	<h2>鉴于：</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">1.甲方有借款需求,且已在佰宝金服网站注册，并将其主体及借款需求信息通过自己或其代理人提供予丙方并由丙方在佰宝金服网站发布；甲方具有经营相应业务的资质，且现合法持有本协议项下债权。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.乙方为丙方运营平台的注册用户，拟通过丙方平台取得债权收益权的受让方，即投资人。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.丙方为一家依法成立并有效存续的互联网金融信息服务企业，丙方运营的平台包含网站平台（域名www.baibao.com）及相关等APP平台。丙方运营的平台具有提供发布金融资讯信息、风险评估、金融交易信息服务等投融资居间服务的能力和资质。为明确协议各方的权利义务，根据《中华人民共和国协议法》等相关规定，各方本着自愿、公平、诚实信用的原则，就债权转让和回购事宜签订本协议，以兹共同遵照履行。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>一、债权收益权转让</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">1.1本协议项下，甲方转让给乙方的其合法持有的债权收益权，是指甲方合法持有的债权/对应收账款所对应的现金收益及其他收益的财产性权利，包括但不限于收取债权收益权本金、收益、违约金、赔偿金等基于该债权/应收账款收益权产生的财产性收益的权利。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">1.2转让收益权的债权/应收账款的情况见附件1《项目详情及回购支付计划》。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">1.3甲方同意按照本协议约定向乙方转让债权/应收账款收益权。乙方同意根据本协议的约定，受让甲方持有的对债务人的债权/应收账款的收益权，并支付债权/应收账款收益权转让价款。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">1.4债权/应收账款收益权的转让：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)债权/应收账款收益权转让日为乙方向甲方支付债权/应收账款收益权转让价款之日，从此日开始计算乙方收益；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)除本协议另有约定外，自债权收益权转让日起，甲方基于债权收益权归乙方所有；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">1.5乙方在此不可撤销地授权丙方委托其指定的第三方支付机构或监管银行于本协议生效时将债权收益权转让价款从乙方托管账户一次性全部划转至甲方账户中，划转完毕即视为债权收益权转让完毕。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>二、回购条款</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.1甲方承担不可撤销的按支付计划履行回购债权收益权的义务；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.2甲方在回购日将应付金额充值至甲方托管账户，并不可撤消的授权丙方委托其合作的第三方支付机构按各方应收款项进行资金划拨。资金的清偿顺序为提前回购手续费（如有）、逾期管理服务费（如有）、平台服务费、提前回购补偿金（如有）、回购价款。回购价款为截至约定回购日的债权/应收账款本金及溢价收益。每个投资人的溢价收益按投资人的投资金额占甲方债权收益权转让价款的比例计算。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.3甲方授权丙方委托其合作的第三方支付机构在甲方接收乙方受让债权/应收账款收益权时从乙方支付债权/应收账款收益权转让价款中扣除应支付给丙方的居间服务费后将剩余款项划转入甲方资金托管账户中，居间服务费按甲方的融资方式对应的标准计算。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.4甲方在回购债权/应收账款收益权时应向各方足额支付应付款项，否则视同甲方逾期。甲方未及时履行其回购义务情形下：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)丙方有权使用甲方交纳的保证金直接支付回购资金而无需甲方另行同意；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)丙方有权要求保证人直接（如有）履行连带担保责任；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)保证金或保证人不足以支付回购资金的，按照丙方风控规则由其他主体代为垫付回购资金的，其他主体有权基于垫付行为向甲方及保证人主张债权。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.5如甲方逾期回购且甲方保证金不足以支付全部回购应付款时，甲方除应向乙方支付约定回购款及丙方相关费用外，还应向乙方或代为垫付回购资金的其他主体支付逾期期间的溢价收益，同时向丙方支付逾期管理服务费。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.6甲方如决定提前回购乙方剩余债权/应收账款收益权，需提前五个工作日通知丙方，经甲丙协商一致并确定最终回购日期。甲方提前回购债权/应收账款收益权的应向乙方支付回购价款，回购价款为所有未付债权/应收账款收益权本金（含到期应还及尚未到期）、截止至提前回购日的应付未付溢价收益、提前回购手续费、提前回购补偿金、违约金（如有）及其他应付款项（如有）。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.7在乙方持有债权/应收账款收益权期间，未经乙方书面同意，甲方不得与原始债务人达成有损债权/应收账款收益权实现的债权减免等的协议或行为。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.8如甲方违反本协议约定，足以影响到乙方受让债权/应收账款债权或触犯丙方风控规则的，乙方有权要求甲方立即提前回购乙方持有的尚未履行的全部债权/应收账款债权。甲方应在收到乙方或丙方回购通知的3个工作日内将回购资金充值至甲方资金托管账户，并授权丙方委托其合作的第三方支付机构按丙方平台规则及资金清偿顺序向各方支付应付款项，以履行其在本协议下的回购责任。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.9乙方在此不可撤消的委托丙方代为提出回购要求、代为处理债权/应收账款回购事宜，即在出现甲方承担回购义务的约定事由后，丙方有权代乙方向甲方提出履行回购责任、向乙方进行清偿的要求，并在甲方同意履行回购义务时，代乙方向甲方处理债权/应收账款收益权转让事宜。此等情形下，甲方应依照约定履行义务，不得以主体是否适格为由进行抗辩。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>三、甲方的陈述与保证</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.1甲方保证向丙方所提供债权/应收账款涉及的资料均为完整、真实、准确、合法、有效之材料；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.2甲方向乙方所转让收益权的债权/应收账款均符合以下全部条件：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)债权/应收账款的形成在甲方正常经营范围内；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)基础协议均真实、合法且有效，不存在任何虚假、隐瞒或遗漏；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)甲方已按照原基础协议约定履行了全部义务并将继续履行基础协议下的义务，乙方除受让基础协议项下的债权/应收账款的收益权外，不承担任何基础协议项下的义务；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)债权/应收账款尚在有效期内、依法可以转让，不存在任何禁止或限制转让情形，也不存在来自原始债务人本身或是担保人方面已经履行或是行使抵销权等任何理由的抗辩；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(5)该债权/应收账款不存在任何抵押、质押或其他任何形式的权利负担，也不存在任何权属争议；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.3甲方未向且不会向除乙方外的任何第三方转让该债权/应收账款或该债权/应收账款的收益权。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.4与本协议有关的所有基础交易均不存在任何争议。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.5甲方和原始债务人在签署本协议之前不存在任何与本协议有关的争议，且日后双方如发生任何争议的均不影响其依据本协议应履行的义务，本协议项下的债权/应收账款债权不会遭致原始债务人、担保人（如有）或其他第三方主张抵销、反诉、赔偿损失或作其他扣减等。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.6甲方应在本协议签署后合理时间内将债权/应收账款收益权转让相关事宜通知原始债务人及其担保人（如有）。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.7甲方变更住所、通讯地址、联系方式、营业执照及法定代表人等工商登记事项的，应在有关事项变更后5日内通知丙方；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.8本协议项下的债权/应收账款的原始债务人发生任何有可能影响债权/应收账款支付情形的，不影响甲方对已转让的债权/应收账款收益权的回购，且甲方会及时向丙方告知。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">3.9丙方同意向甲方提供融资咨询服务，甲方同意接受丙方提供的该项服务。双方同意，丙方向甲方提供融资咨询服务应按如下范围和规则进行：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)在适用法律和技术手段允许和合理的范围内，丙方应对在丙方平台上展示的各项融资人基本信息进行必要的查验，以供乙方在决定是否向融资人投资资金时参考。在乙方与融资人之间债权债务关系尚未完全清偿前，丙方如获知其提供的融资人联络信息发生变更或存在不真实、不准确的情形，应及时以电子邮件（以乙方在丙方平台注册时或者注册后变更用户信息时向丙方平台提供的电子邮箱为准）或其他方式通知乙方；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)丙方将根据内部制定的评级规则对融资人及其各笔特定借款需求等进行信用评级，并以适当方式在丙方平台上公示，以供乙方参考。丙方有权根据其进一步获知的融资人相关信息和/或内部评级规则的调整而调整对融资人及各笔特定借款需求的信用评级。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)甲丙双方同意并确认，丙方不保证甲方的资金借入或融资需求一定能够按照甲方意愿得到满足，丙方根据本协议的约定向甲方提供的所有融资咨询服务仅供甲方决定是否借入资金时予以参考，无论甲方通过丙方平台形成的投融资关系是否存在第三方担保，在任何情况下均不应视为丙方及其关联方对融资人或原始债权人的偿还能力及融资协议的履行作出了任何明示或默示的担保，亦不应视为丙方及其关联方对甲方的本金和/或收益作出了明示或默示的担保或保证。甲方应自行判断其原债权对应的债务人相关信息的真实性、准确性、及时性，自主决定是否通过丙方平台借入资金，并承担由此而导致的一切损失或责任，丙方将其所知的融资人信息的变更情况或在其能力范围内所了解的融资人信息不真实、不准确的情形通知乙方，在任何情况下均不视为丙方对融资人信息的真实、准确、及时和完整性做出任何保证或承诺。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)对于丙方平台向甲方提供的居间服务是否收取服务费及服务费的具体标准和规则将由丙方平台不时公开公布的规则及公告确定。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>四、乙方的陈述与保证</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.1乙方系丙方平台注册用户，具有签署和履行本协议及与本协议有关的其他文件的民事权利能力和行为能力，能够独立承担民事责任。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.2乙方保证其所用于投资的资金来源合法，乙方是该资金的合法所有人，如果第三方对资金归属、合法性问题发生争议，由乙方自行负责解决并承担由此而导致的全部损失和责任。如乙方未能解决，则放弃享有其所投资款项所带来的利息收益，且给甲方或丙方造成损失或不利影响的，乙方应承担违约赔偿责任。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.3乙方对本协议的签署和履行不违反对其有约束力或有影响的法律法规或协议的限制。本协议签署后，即构成对乙方合法、 有效和有约束力的义务。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.4丙方同意向乙方提供投资咨询服务，乙方同意接受丙方提供的该项服务。双方同意，丙方向乙方提供投资咨询服务应按如下范围和规则进行：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)在适用法律和技术手段允许和合理的范围内，丙方应对在丙方平台上展示的各项融资人基本信息进行必要的查验，以供乙方在决定是否向融资人投资资金时参考。在乙方与融资人之间债权债务关系尚未完全清偿前，丙方如获知其提供的融资人联络信息发生变更或存在不真实、不准确的情形，应及时以电子邮件（以乙方在丙方平台注册时或者注册后变更用户信息时向丙方平台提供的电子邮箱为准）或其他方式通知乙方；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)丙方可以选择是否通过丙方平台向乙方提供其自行收集或从其他第三方合作机构获得的除融资人联络信息之外的其他融资人信息，如融资人的工作情况、收入情况、家庭情况、信用报告、历史偿债情况等，以供乙方在自行决定是否向融资人投资资金时参考。乙方应自行判断该等信息的真实性、准确性和完整性；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)丙方将根据内部制定的评级规则对融资人及其各笔特定借款需求等进行信用评级，并以适当方式在丙方平台上公示，以供乙方参考。丙方有权根据其进一步获知的融资人相关信息和/或内部评级规则的调整而调整对融资人及各笔特定借款需求的信用评级；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.5乙丙双方同意并确认，丙方不保证乙方的资金投资或投资需求一定能够按照乙方意愿得到满足，丙方根据本协议的约定向乙方提供的所有投资咨询服务仅供乙方决定是否投资资金时予以参考，无论乙方通过丙方平台形成的投融资关系是否存在第三方担保，在任何情况下均不应视为丙方及其关联方对融资人或原始债务人的偿还能力及融资协议的履行作出了任何明示或默示的担保，亦不应视为丙方及其关联方对乙方的本金和/或收益作出了明示或默示的担保或保证。乙方应自行判断相关信息的真实性、准确性、及时性，自主决定是否投资资金，并承担由此而导致的一切损失或责任，丙方将其所知的融资人信息的变更情况或在其能力范围内所了解的融资人信息不真实、不准确的情形通知乙方，在任何情况下均不视为丙方对融资人信息的真实、准确、及时和完整性做出任何保证或承诺。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.6对于丙方平台向乙方提供的居间服务是否收取居间服务费及服务费的具体标准和规则将由丙方平台不时公开公布的规则及公告确定。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.7丙方同意向乙方提供资金管理服务，乙方同意接受丙方提供的该项服务。双方同意，丙方向乙方提供资金管理服务应按如下范围和规则进行：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)资金保管：乙方应通过丙方平台在丙方合作的第三方平台上以乙方名义开立资金托管账户，账户中托管以下两种情形下的资金：<br/>
                               (a)乙方为了投资资金或投资的目的，按照丙方平台的相关交易规则和本协议的规定向托管账户转入资金；<br/>
                               (b) 融资人向乙方按期偿还本息及根据融资协议约定偿付的逾期罚息、违约金、滞纳金等。上述资金均在托管账户中乙方的个人账户，独立于丙方的自有资金，丙方将严格根据乙方的指示及授权进行资金的操作。除本平台另有规定，上述资金在托管账户托管期间不计利息；
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)资金冻结：乙方同意由丙方按照丙方平台的相关交易规则和本协议的规定冻结乙方托管账户中相应数额的资金，包括但不限于：<br/>
                               (a)在乙方与融资人签署融资协议后，乙方同意并授权丙方在乙方托管账户中冻结等值于拟投资数额的资金。该项冻结在融资协议生效时或失效时解除；<br/>
                               (b)在乙方与既有债权转让方签署《债权转让及回购协议》后，乙方同意并授权丙方在乙方托管账户中冻结等值于债权转让价款数额的资金。该项冻结在《债权转让及回购协议》项下债权金额被丙方平台划转至既有债权转让方时或《债权转让及回购协议》失效时解除；<br/>
                               (c)各类交易中如发生乙方应支付相应费用的，乙方同意并授权丙方在乙方托管账记中冻结等值于拟支付的费用的资金，该项冻结在交易生效支付费用时解除。
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)资金代付：乙方同意并授权丙方按照丙方平台的相关交易规则和本协议的规定，委托其合作的第三方支付机构或者监管银行，从丙方托管账户中代为划扣丙方应支付的相应数额的资金，包括但不限于：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(a)根据丙方与融资人之间的融资协议应向融资人划转的借款本金；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(b)根据乙方与既有债权转让方之间的《债权转让及回购协议》应向转让方支付相应的转让价款；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(c)乙方应支付给各方的相应费用等。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)资金代收：乙方同意并授权丙方按照平台的相关交易规则和本协议的规定委托其合作的第三方支付机构代为收取其在融资协议项下应收回的本金和利息，并将该等代收的本金和利息在扣除相关费用后直接转入乙方托管账户。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(5)资金提取：乙方可在丙方平台的工作时间内通过丙方平台的相应模块向丙方合作的第三方机构提出提现要求，并同时提供一个与乙方个人身份信息相符的有效的中国境内银行账户信息，以提取其届时乙方在托管账户中所有未投资且未冻结且未锁定的资金，第三方支付机构将相应的款项汇入乙方提供的银行账户（根据乙方提供的银行不同，实际汇入时间可能存在差异）。除本条约定外，丙方不接受甲方提出的其他任何提现方式。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(6)资金查询：乙方有权在任何时间使用本人的用户名和密码登录丙方平台查询其在托管账户下资金的情况，包括充值、冻结、锁定、代付、代收和提现记录等。乙方应理解，乙方最终收到款项的服务是由其提供的银行账户开户行提供的，需向该银行请求查证。乙方同意，其登录丙方平台查询的任何信息不能够作为相关操作或投融资交易的证据或依据；如该等信息与丙方保存的记录存在任何不一致，应以丙方所提供的记录为准。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.8乙方了解并同意，丙方提供上述资金管理服务时可能需要与银行或非银行业的第三方支付机构等开展合作。因此，乙方同意：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)丙方不对银行及第三方支付机构进行相应资金划转的时限、准确性、及时性等作出任何承诺或承担任何相关责任，包括但不限于由此产生的利息、货币贬值、银行及第三方支付机构执行划转指令出现错误、银行及第三方支付机构系统故障、银行及第三方支付机构对资金划转的特定限制等导致的损失或责任；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)就本条规定的资金管理服务，乙方应按照银行及第三方支付机构的规定支付相关费用（如有）。就费用支付事项产生的任何争议、纠纷等，均由乙方与银行及（或）第三方支付机构自行解决，丙方不承担因此而产生的任何损失或责任。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">4.9如果丙方发现因系统故障、银行或第三方支付机构执行指令错误或其他任何原因导致的在资金划转过程中出现的错误，无论是否有利于丙方、乙方或融资人等任何一方，丙方均有权在以电子邮件（以乙方在丙方平台注册时或者注册后变更用户信息时向丙方平台提供的电子邮箱为准）或其他方式通知乙方后立即纠正该错误：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)如果该等错误导致乙方实际收到的款项少于应获得的金额，则丙方应将乙方实际收到款项与应收到的款项之间的差额转入乙方资金托管账户；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)如果该等错误导致乙方实际收到的款项多于应获得的金额，则无论错误的性质和原因为何，丙方有权立即予以纠正，乙方应配合丙方进行纠正包括将多转入的款项从乙方资金托管账户中转出，以及要求乙方根据丙方发出的有关纠正错误的通知的具体要求返还多收的款项或进行其他操作。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)乙方理解并同意，因前述处理错误而多付或少付的款项均不计利息，丙方也不承担因前述处理错误而导致的任何损失或责任，但因丙方具有恶意而导致的处理错误除外。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.0乙方同意并确认，其按照本协议发出的任何指示、指令，均为不可撤销、不可逆转的指示或指令，乙方不能以任何理由拒绝付款或要求取消交易。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.1乙方可以选择以下方式实现个人资金投资（“投资”）：
                        (1)  对丙方在丙方平台展示的债权转让需求进行自由选择，自行决定是否受让某一既有投资人拟转让的债权（“受让债权”）。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.2乙方如果选择受让债权，则适用以下规则：<br/>
                                (1)乙方须按照丙方平台的规则，通过对某一特定的待转让债权点击<b>“投标”或“立即抢投”</b>，即表示同意与其他投资人订立《债权转让及回购协议》以受让既有债权；<br/>
                                (2)《债权转让及回购协议》经乙方点击<b>“投标”或“立即抢投”</b>而即时成立并生效，乙方有义务按照《债权转让及回购协议》的约定及时付款给既有债权转让方。就此，乙方授权丙方在《债权转让及回购协议》生效后，立即委托其合作的第三方支付机构从乙方托管账户中划扣债权转让价款，并划转至既有债权转让方的托管账户。
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.3乙方理解并同意：为了保护投资人及融资人的隐私，平台自动生成的投融资相关协议中可能将只出现乙方及融资人的真实姓名、身份证号码和地址，除乙方外的其他投资人信息丙方平台可根据平台规则进行一定的信息屏蔽。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.4为便利、统一地回收本息，乙方委托丙方通过其合作的第三方支付机构代为收取融资人每期偿还的本息，同意并授权丙方委托其合作的第三方支付机构在回款时先行将按平台规则或相关协议规定应扣除的费用划转至相关方，剩余本息划转至乙方托管账户。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.5乙方受让既有债权后有权根据该债权所属项目对应的融资协议要求融资人按照融资协议的约定按期还本付息。在融资人违反其在融资协议项下按期清偿借款本息的义务时，在中国法律允许的范围内，丙方应向乙方提供其所知晓的融资人联络信息，并尽合理的努力采取中国法律所允许的措施协助乙方进行及时的催收和追讨，但丙方不对催收的最终结果向甲方承担责任。乙方为了甲方利益催收和追讨过程中产生的合理成本、费用将先于甲方可获得的本息或其他资金收益而优先向乙方清偿。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.6若乙方投资的该笔投资的融资人未按时足额履行还款或代还款义务，且担保人或担保账户（如有）也未按时足额履行其担保义务，则在此种情况下，乙方不可撤销地授权丙方全权代表其处置该笔债权，处置的方式包括但不限于：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)通过法律途径向融资人及/或担保人进行追偿（包括但不限于代为委托律师提起诉讼或仲裁）；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)委托第三方专业机构进行催收；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)将该笔债权转让予第三方资产管理公司等机构；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)丙方认为最符合甲方利益最大化的其他处置方式。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>五、服务费</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.1按本协议的规定丙方为甲方提供融资居间服务，甲方应向丙方支付居间服务费，具体居间服务费的费率及收费规则如下：<br/>
                                居间服务费=∑单期居间服务费<br/>
                                单期居间服务费=单期融资额×居间服务费率<br/>
                                单期居间服务费在融资人回款时丙方有权从融资人回款金额中扣除划转至丙方资金账户中。
                            </p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">5.2甲方在使用丙方提供的平台服务，达成投融资及债权转让交易过程中涉及的其他费用，包括但不限于身份认证费用、充值手续费、提现手续费、其他认证费用除平台规则有明确规定外均应由甲方自己承担，甲方同意并授权丙方可按相关收费方的要求进行相关费用的代收代付。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>六、声明和保证</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">6.1乙方保证其所用于投资的资金来源合法，乙方是该资金的合法所有权人，如果因第三人对乙方用于投资的资金的来源合法性或归属问题提出异议，由乙方自行解决并承担由此而导致的全部损失和责任。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">6.2乙方确认在签署本协议之前已阅读以下与本协议及融资协议的订立及履行有关的风险提示，并对该等风险有充分理解和预期，乙方自愿承担该等风险可能给乙方带来的一切损失和责任。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)政策风险：国家因宏观政策、财政政策、货币政策、行业政策、地区发展政策等因素引起的系统风险。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)融资人及担保人信用风险：当融资人及担保人（如有）短期或者长期丧失还款能力（包括但不限于融资人收入情况、财产状况发生变化、人身出现意外、发生疾病、死亡等情况），或者融资人及担保人（如有）的还款意愿发生变化时，乙方的投资资金及利息可能无法按时回收甚至无法回收。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)资金流动性风险：乙方按照约定将资金投资给融资人使用，在融资人不主动提前还款的情况下，融资人将按照约定的期限偿还乙方的本金并支付利息，因此资金回收可能需要一定的周期。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)不可抗力：由于丙方及相关第三方的设备、系统故障或缺陷、病毒、黑客攻击、网络故障、网络中断、地震、台风、水灾、海啸、雷电、火灾、瘟疫、流行病、战争、恐怖主义、敌对行为、暴动、罢工、交通中断、停止供应主要服务、电力中断、经济形势严重恶化或其它类似事件导致的风险。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">6.3乙方确认在同意订立本协议前已仔细阅读了本协议的所有条款，对本协议的所有条款及内容已经阅悉，均无异议，并对三方的合作关系、有关权利、义务和责任条款的法律含义达成充分的理解，乙方自愿承受自主投资行为可能所产生的全部风险。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>七、其他权利义务</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.1乙方承诺，对于丙方向乙方提供的各项融资人信息，包括但不限于融资人联络信息、借款需求、担保情况（如有）、收入情况、丙方对融资人的评级情况、丙方提供的其他相关信息等，乙方应保证仅用于投资参考，不得向任何第三人披露。但是，在融资人已经违反融资协议的约定、未按期还本付息时，乙方有权使用融资人联络信息向融资人进行催收，如乙方已经根据中国法律的规定向有管辖权的人民法院提起起诉的情形下，乙方还可以进一步向司法机关披露其获得的融资人信息。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.2对于甲乙双方在丙方提供信用咨询与管理服务过程中了解到的丙方的所有信息，包括但不限于业务运营情况等，甲乙双方不得向任何第三人披露。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.3除根据本协议在甲乙双方债权转让过程中展示甲乙双方的个人信息外，丙方须根据中国法律的规定对甲乙双方个人信息、资产情况和相关资料予以保密。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.4甲乙双方有义务按照丙方的要求提供真实的个人信息，因甲乙双方提供虚假信息而造成的一切法律后果（包括但不限于民事赔偿，行政处罚等）均由甲乙双方自行承担。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.5甲乙双方有义务按照丙方要求操作平台功能以及查收丙方发出的所有信息（包括但不限于平台站内信、手机短信等）。因甲乙双方个人操作不当或疏于查收信息而造成的损失由甲乙双方自行承担。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.6甲乙双方变更账户信息、通讯地址、电话等相关重要信息，须及时通知丙方。因甲乙双方未及时通知丙方而导致的一切损失，由甲乙双方自行承担或进行赔偿。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.7如果乙方出现投资资金的继承或赠与，必须由主张权利的继承人或受赠人向丙方出示经国家行政或司法机关确认的继承或赠与权利归属证明文件，丙方确认后方予协助进行资产的转移，由此而产生的相应税费，由继承人或受赠人根据中国法律的规定自行向相关主管税务机关申报、缴纳，丙方不承担任何代扣代缴的义务及责任，继承人或受赠人违反上述规定导致乙方遭受的任何损失，由乙方全额赔偿。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">7.8丙方应妥善保存与甲乙双方资产相关的全部资料以备查阅，保存期限为本协议存续期间及本协议终止之日起五年。</p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>八、税费的承担</h2>
                    <ol>
                        <div class="fn-clear li">
                            <p class="fn-left">8.1各方依照法律规定各自承担本协议履行过程中发生的税费。任何一方不为对方收益的税费进行扣缴。法律、行政法规及部门规章有其他规定的，按照有关规定办理。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">8.2因履行本协议项下义务而向第三方支出的必要费用（包括但不限于聘请律师、会计师、审计师的费用、公证费等）由甲双乙方承担。</p>
                        </div>
                    </ol>
                </div>
                <div>
                    <h2>九、违约责任</h2>
                    <ol>
                        <div class="fn-clear li">
                            <p class="fn-left">9.1甲方违反本协议中约定的义务具有以下行为的，视为甲方违约：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)本协议生效后，未经乙方或乙方授权人事先书面同意，甲方对外转让、质押，或以任何形式处分相应的债权/应收账款、债权/应收账款收益权、派生收益；或在相应的债权/应收账款、债权/应收账款收益权及派生收益上设定其他任何形式的优先权及其他第三人权利；或采取其它限制、影响债权/应收账款收益权的行为；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)该债权/应收账款被有关机关冻结或者采取其他限制措施的；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)向乙丙双方提交的债权/应收账款文件、材料和信息等有虚假、违法、欺诈或不完整等影响乙方享有债权/应收账款权益行为的；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)未按照本协议约定及时履行债权/应收账款收益权回购的；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(5)违反法律、法规或本协议约定义务的。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">9.2当甲方出现任何违约情形且经乙方或丙方书面催告或仍不纠正时，乙方有权采取或授权丙方协助采取以下一项或多项措施：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)处置质押债权/应收账款；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)向甲方追偿；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)向保证人追索（如有）。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(4)自行处置本协议项下债权/应收账款收益权（包括但不限于自主向任何第三方以任何价款转让），无需征得甲方同意或通知甲方。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">9.3采取上述措施后所得款项仍不足本协议约定的全部回购价款及本协议项下其他应付款项之和的，乙方或丙方有权继续向甲方、保证人追偿。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">9.4当甲方出现任何违约情形时，乙方或丙方有权要求甲方在一定期限内纠正违约行为，并赔偿由此给乙丙双方造成的全部直接经济损失。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">9.5若因甲方自身债务导致应收账款债权遭第三方冻结（或扣划）等并进而给乙方造成损失，甲方应赔偿乙方因此所遭受的全部直接损失。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">9.6乙方违反本协议中约定的义务或者出现其他违约情形的，应当向甲方承担违约责任，给甲方造成损失的，应赔偿甲方直接损失。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">9.7任何一方违反本协议约定义务即构成违约，违约方应承担因违约致使对方产生的费用和损失，包括但不限于调查费、诉讼费、律师费等。</p>
                        </div>
                    </ol>
                </div>
                <div>
                    <h2>十、协议的生效</h2>
                    <ol>
                        <div class="fn-clear li">
                            <p class="fn-left">本协议附件作为协议不可分割的一部分，与本协议具有同等法律效力。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">本协议自各方在丙方平台采用自主点击确认或授权数字签章的方式生成之日起成立并生效，甲乙双方承诺，其于丙方的账户专属各自所有、并仅由本人/本企业控制，该账户及其关联的付款账户所发出的指令均具有本人/本企业签署认可的法律效力。</p>
                        </div>
                    </ol>
                </div>
                <div>
                    <h2>十一、协议的变更、解除和终止</h2>
                    <ol>
                        <div class="fn-clear li">
                            <p class="fn-left">11.1各方协商一致，可以变更或解除本协议。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">11.2发生下列情况之一时，乙方可以书面通知另一方解除本协议：</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(1)另一方丧失实际履约能力，致使本协议目的无法实现的；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(2)另一方严重违约致使本协议目的无法实现的；</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">(3)法律规定的其他导致协议解除的情形。</p>
                        </div>
                    </ol>
                </div>
                <div>
                    <h2>十二、不可抗力</h2>
                    <ol>
                        <div class="fn-clear li">
                            <p class="fn-left">12.1“不可抗力”是指本协议三方不能合理控制、不可预见或即使预见亦无法避免的事件，该事件妨碍、影响或延误任何一方根据本协议履行其全部或部分义务。该事件包括但不限于地震、台风、洪水、火灾、瘟疫、其他天灾、战争、政变、骚乱、罢工或其他类似事件。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">12.2如发生不可抗力事件，遭受该事件的一方应立即用可能的快捷方式通知另一方，并在15日内提供证明文件说明有关事件的细节和不能履行或部分不能履行或需延迟履行本协议的原因。三方应在协商一致的基础上决定是否延期履行本协议、终止本协议，并达成书面合意。</p>
                        </div>
                    </ol>
                </div>
                <div>
                    <h2>十三、管辖及争议解决方式</h2>
                    <div>
                        <div class="fn-clear li">
                            <p class="fn-left">13.1本协议适用中华人民共和国法律。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">13.2各方因履行本协议或与本协议有关的所有纠纷均应当以友好协商的方式解决，如协商不成的，均应向丙方所在地人民法院提起诉讼。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">13.3根据中国有关法律，若本协议任何条款被法院裁决为无效，并不影响本协议其他条款的持续有效和执行。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">13.4本协议未尽事宜，各方可另行签订补充协议，并作为本协议的附件，本协议的附件与本协议具有同等法律效力。<br/>
                                （以下无正文）<br/>
                                甲方（签章）：<span class="tksp" style="display: inline-block;float:none; width:100px">${result.pui_real_name}</span><br/>
                                乙方（签章）：<span class="tksp" style="display: inline-block;float:none; width:100px">${result.lender}</span><br/>
                                丙方（签章）：<span class="tksp" style="display: inline-block;float:none; width:200px">中融佰诚投资管理有限公司</span><br/>
                            </p>
                            <p class="fn-left mt15 mb15">
                                签署日期：<span class="tksp" style="display: inline-block;float:none; width:100px"><#if result.pp_bulkLoanEffectTime??>${result.pp_bulkLoanEffectTime?string("yyyy-MM-dd")}</#if></span></p>
                        </div>
                    </div>
                </div>
                <div>
                    <h2>附件1 项目详情及回购支付计划（见下方）</h2>
                    <ol>
                        <div class="fn-clear li">
                            <p class="fn-left">1.项目详情</p>
                        </div>
                    </ol>
                </div>
                <table cellpadding="0" cellspacing="0" class="bgtable">
                    <tr>
                        <td class="tdtitle">
                            <p>项目信息</p>
                        </td>
                        <td class="tddesc">
                            <p>编号：${result.pp_productNo}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>债权/应收账款基础协议</p>
                        </td>
                        <td class="tddesc">
                            <p>
                                <span>协议类别:《${result.productContract.contractype}》</span>
                                <span style="margin-left: 160px;">编号：${result.productContract.lastproductno}</span>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>转让收益权的债权/应收账款金额</p>
                        </td>
                        <td class="tddesc">
                            <p>${result.ptr_amount}元</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>转让收益权的债权/应收账款到期日</p>
                        </td>
                        <td class="tddesc">
                            <p>${result.dateDue}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>债权/应收账款收益权转让价款</p>
                        </td>
                        <td class="tddesc">
                            <p>${result.ptr_amount}</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>回购溢价率（年化）</p>
                        </td>
                        <td class="tddesc">
                            <p><span class="tksp">${result.pp_comprehensiveRate}</span>%</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                           <#if result.pp_loanRepayment==2>
                            		<p>回购分天数</p>
                            	<#else>
                            		<p>回购分月数</p>
                            	</#if>
                        </td>
                        <td class="tddesc">
                            <p>
								<#if result.pp_loanRepayment==2>
                        		 	 <span>${result.pp_loanTerm}</span>天
                            	<#else>
                            		 <span>${result.pp_loanTerm}</span>个月
                            	</#if>
							</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>回购价款支付方式</p>
                        </td>
                        <td class="tddesc">
                            <p>
                                <#if result.pp_loanRepayment==0>
                                    等额本息
                                <#elseif result.pp_loanRepayment==1>
                                    先息后本
                                <#elseif result.pp_loanRepayment==2>
                                    按天计息
                                <#elseif result.pp_loanRepayment==3>
                                    等额本金
                                <#elseif result.pp_loanRepayment==4>
                                    先息后付
                                </#if>
                            </p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>债权/应收账款收益权转让日</p>
                        </td>
                        <td class="tddesc">
                            <p><#if result.pp_bulkLoanEffectTime??>${result.pp_bulkLoanEffectTime?string("yyyy-MM-dd")}</#if></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>居间服务费</p>
                        </td>
                        <td class="tddesc">
                            <p></p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>逾期回购溢价率（日化）</p>
                        </td>
                        <td class="tddesc">
                            <p>逾期按5‰/日，以逾期当期应付回购价款为基数计算：逾期罚息总额 = 逾期本息总额×对应罚息利率×逾期天数</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>提前回购补偿金率</p>
                        </td>
                        <td class="tddesc">
                            <p><span class="tksp">2</span>%，以未到期的债权/应收账款本金为基础计算，提前回购时一次性支付给投资人</p>
                        </td>
                    </tr>
                    <tr>
                        <td class="tdtitle">
                            <p>风险保证金</p>
                        </td>
                        <td class="tddesc">
                            <p>转让收益权的债权/应收账款金额<span class="tksp">${result.pp_loanManageFeeRate}</span>%</p>
                        </td>
                    </tr>
                </table>
                <div style="margin-top: 10px;">
                    <div>
                        <div class="fn-clear li"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left">注释：</p>
                        </div>
                        <div class="fn-clear li"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left">（1）转让收益权的债权/应收账款金额：指甲方应收账款基础协议所对应的债权/应收账款本金中要转让收益权部分的债权/应收账款金额。</p>
                        </div>
                        <div class="fn-clear li"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left">（2）转让收益权的债权/应收账款到期日：指甲方债权/应收账款基础协议中转让收益权的债权/应收账款的最后一期到期日，此日期应当晚于甲方承诺的最后一期债权/应收账款收益权约定回购日。</p>
                        </div>
                        <div class="fn-clear li"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left">（3）债权/应收账款收益权转让价款：指投资人为获得甲方在丙方平台转让的债权/应收账款收益权需支付的投资总额。</p>
                        </div>
                        <div class="fn-clear li">
                            <p class="fn-left">2.回购支付计划</p>
                        </div>
                    </div>
                </div>
                <table cellpadding="0" cellspacing="0" class="bgtable">
                    <tr>
                        <td class="tddesc">
                            <p>约定回购日期</p>
                        </td>
                        <td class="tddesc">
                            <p>回购价款（元）</p>
                        </td>
                        <td class="tddesc">
                            <p>债权/应收账款本（元）</p>
                        </td>
                        <td class="tddesc">
                            <p>溢价收益（元）</p>
                        </td>
                    </tr>
                    
                	<#if result.tenderProfitList??>
                		<#list result.tenderProfitList as tenderP>
                			<tr>
                    			<td class="tddesc">
		                            <p>${tenderP.ptpProfittime?string("yyyy-MM-dd")}</p>
		                        </td>
		                        <td class="tddesc">
		                            <p>${tenderP.ptpProfit}</p>
		                        </td>
		                        <td class="tddesc">
		                            <p>${tenderP.ptpCapital}</p>
		                        </td>
		                        <td class="tddesc">
		                            <p>${tenderP.ptpInterest}</p>
		                        </td>
	                        </tr>
                		</#list>
                	</#if>
                    
                    <tr>
                        <td class="tddesc">
                            <p>总计</p>
                        </td>
                        <td class="tddesc">
                            <p>${result.capitaAndinterest}</p>
                        </td>
                        <td class="tddesc">
                            <p>${result.capita}</p>
                        </td>
                        <td class="tddesc">
                            <p>${result.interest}</p>
                        </td>
                    </tr>
                </table>
                <div style="margin-top: 10px;">
                    <div>
                        <div class="fn-clear li"><span class="fn-left num-list">&nbsp;</span>
                            <p class="fn-left ">注：回购支付计划有调整的，以平台实际公布调整的为准，各方应及时登陆平台账户查询最新调整变化及平台公布的各项规则及公告。</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
