<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/investment-list.css"/>
    <style>
        .tb-biao-op{
           margin-left:60px;
        }
        .back-bg{
         padding-bottom:200px !important;
        }
        .biaodesc-hk ul li span{
             width: 224px;
        }
        .biao-money>span{
            margin-left:-6px;
        } 
    </style>
</head>
<body>
    <#include "./common/common_header.ftl" />
   <!-- <div class="invest-list-nav">
        <div class="container">
            <ul class="list-nav">
                <li class="current"><a href="${basePath}/service/productList/showProductList">投资列表</a></li>
            </ul>
        </div>
    </div>  
    -->
    <div class="back-bg">
        <div class="container">
            <!-- 标的信息及投标操作 -->
            <div class="invest-desc-con">
            <#if productDetail.ppBulkloanstatus=1 >
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span> 
                    <span class="sp-desc fr" id="productNo" value="${productDetail.ppProductno}">项目编号：${productDetail.ppProductno}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="pink">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l3"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                            <#if productDetail.ppLoanrepayment=2>
                                天
                            <#elseif productDetail.ppLoanrepayment=5>
                            天
                            <#else>
                                个月
                            </#if>
                            </p>
                            <p class="biaomoney-desc">投资期限</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li><span>计息方式</span> 
                              <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            到期本息
                            <#elseif productDetail.ppLoanrepayment=5>
                            到期本息
                            </#if>
                            </li>
                            <li><span>剩余时间</span> 
                            <span id="t_d" style="width: auto;">00天</span>
                            <span id="t_h" style="width: auto;">00时</span>
                            <span id="t_m" style="width: auto;">00分</span> 
                            <span id="t_s" style="width: auto;">00秒</span>
                            </li>
                            <li><span>投标进度</span>
                                <em class="hui-line bor_radius10">
                                    <em class="lan-line" style="width:${productDetail.ppLoanamountexist*100/productDetail.ppLoanamount}%"> </em>
                                </em>
                                <span class="line-num"><#if productDetail.ppLoanamountexist*100/productDetail.ppLoanamount<1>
                                <#if productDetail.ppLoanamountexist*100/productDetail.ppLoanamount==0>
                                0%
                                <#else>
                                1%
                                </#if>
                                <#else>
                                ${(productDetail.ppLoanamountexist*100/productDetail.ppLoanamount)?floor}%</#if></span>
                            </li>
                        </ul>
                    </div>
                    <div class="investbiao-tb">
                        <ul class="tb-biao-op">
                            <li><p class="biao-money"><span class="pink"> ${productDetail.ppLoanamount-productDetail.ppLoanamountexist}</span>元</p>
                                <p class='inverst_Residual'>可投金额</p></li>
                            
                            <li class="clearfix">
                                <#if islogin=false>  
                                    <span class="fl">可用余额<span class="fr" style="margin-left:164px"><a href="${basePath}/service/login" class="lan"> 登录</a>后可见</span></span>
                                <#elseif islogin=true >
                                    <span class="fl">可用余额￥${custBlance}</span>
                                    <span class="fr"><a href="${basePath}/service/account/torecharge" class="lan">充值</a></span>
                                </#if>
                            </li>
                            <li class="li-txt-con">
                                <input type="text" autocomplete="off" placeholder="输入金额须为${productDetail.ppTenderincreaseamount}的整数倍" class="txt-number bor_radius3" id="bulkLoanAmount"/>
                                <input type="hidden" placeholder="${productDetail.ppTenderincreaseamount}"class="txt-number" id="increase"/>
                                <input type="hidden" id="sessionId"/>
                                <p class="err-tip"></p><em>元</em>
                            </li>
                            <li class="li-tb"><a href="javascript:void(0);" class="btn-invest-tb bor_radius3" id="tender" data-available="true" data-login="${islogin}">立即投资</a></li>
                        </ul>
                    </div>
                </div>
            <#elseif productDetail.ppBulkloanstatus=2>
                  <!-- 标的信息及投标操作 已满标-->
                  <div class="invest-desc-con">
                <div class="tzicon ymb-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                            <#if productDetail.ppLoanrepayment==2>
                                                          天                       
                           <#elseif productDetail.ppLoanrepayment=5>
                            	天
                            <#else>
                                                          个月                          
                            </#if>
                            </p>                   
                                <p class="biaomoney-desc">投资期限</p></li>
                            <li class="l4"><span class="hei-time">${productDetail.ppBulkloandealseconds}</span>
                                <p class="biaomoney-desc">满标用时</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:23px;'><span>计息方式</span> 
                            <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=5>
                           到期本息
                            </#if></li>
                        </ul>
                    </div>

                </div>
            </div>
          <#elseif productDetail.ppBulkloanstatus=4>
             <!-- 标的信息及投标操作 还款中-->
            <div class="invest-desc-con">
                <div class="tzicon hkz-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间： ${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2">
                                <p class="biao-money">
                                    <span class="hei">${productDetail.ppLoanterm}</span>
                                    <#if productDetail.ppLoanrepayment ==2>
                                        天
                                    <#elseif productDetail.ppLoanrepayment ==5>
                                        天
                                    <#else>
                                        个月
                                    </#if>
                                </p>
                                <p class="biaomoney-desc">投资期限</p>
                            </li>
                            <li class="l3" style='margin-left:42px;'><p class="biao-money"><span class="hei">${surplusTerm}</span>期</p>
                                <p class="biaomoney-desc">剩余期数</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li style='float:none;margin-left:23px;'><span>计息方式</span>
                             <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=5>
                            到期本息
                            </#if>
                            </li>
                           

                        </ul>
                    </div>

                </div>
            </div>
            <#elseif productDetail.ppBulkloanstatus=5>
                <!-- 标的信息及投标操作 已完成-->
            <div class="invest-desc-con">
                <div class="tzicon ywc-icon"></div>
                <div class="invest-desc-title">
                    <span class="sp-desc-title fl">${productDetail.ppLoantitle}</span>
                    <a href="${basePath}/service/agreement/contract?productNo=${productDetail.ppProductno}" class="fr" target="_blank">借款协议（范本）</a>
                    <span class="sp-desc fr">项目编号：${productDetail.ppProductno}</span>
                    <span class="sp-desc fr">发布时间：${productDetail.ppBulkloanstarttime?string('yyyy-MM-dd HH:mm:ss')}</span>
                </div>
                <div class="clearfix">
                    <div class="investbiao-desc1">
                        <ul class="ui-biao-desc clearfix">
                            <li class="l1"><p class="biao-money"><span class="orange">${productDetail.ppLoanamount}</span>元</p>
                                <p class="biaomoney-desc">项目总金额</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppComprehensiverate}</span>%</p>
                                <p class="biaomoney-desc">预期年化收益</p></li>
                            <li class="l2"><p class="biao-money"><span class="hei">${productDetail.ppLoanterm}</span>
                            <#if productDetail.ppLoanrepayment ==2>
                                        天
                            <#elseif productDetail.ppLoanrepayment ==5>
                                        天
                                    <#else>
                                        个月
                                    </#if>
                            </p>
                                <p class="biaomoney-desc">投资期限</p></li>
                             <li class="l3"><p class="biao-money"><span class="hei">0</span>期</p>
                                <p class="biaomoney-desc">剩余期数</p></li>
                        </ul>
                        <ul class="ui-biao-t">
                            <li><span>计息方式</span>
                             <#if productDetail.ppLoanrepayment=0>
                             等额本息
                            <#elseif productDetail.ppLoanrepayment=1>
                            先息后本
                            <#elseif productDetail.ppLoanrepayment=2>
                            按天计息
                            <#elseif productDetail.ppLoanrepayment=3>
                            等额本金
                            <#elseif productDetail.ppLoanrepayment=4>
                            先息后本
                             <#elseif productDetail.ppLoanrepayment=5>
                            到期本息
                            </#if>
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>
            </#if>
            </div>

            <div class="invest-desc-con mt25" id="invest-desc-con">
                <div class="pers-mknav-sty">
                    <ul class="mknav-ui mknav-ui-fto">
                        <li class="mkli mknav-cut" style="width: 25%;"><span>标的详情</span></li>
                        <li class="mkli productImgTitle" style="width: 25%;"><span>标的图片</span></li>
                        <li class="mkli" style="width: 25%;"><span>投资记录</span></li>
                        <li class="mkli" style="width: 25%;"><span>回款计划</span></li>
                        
                    </ul>
                </div>
                <!-- 标的详情 -->
                <div class="biaodesc-xq divtab " style="display:block;line-height:26px;">
                        <!--最新展示页死数据-->
                        <div class='show-datas'>
                            <h3>借款人信息</h3>
                            <ul>
                                <li style='height:40px;line-height:40px;'>姓名<span>${userInfo.pcpRealName}</span></li>
                                <li class='base-info'>基础信息</li>
                                <li>
                                    <p>年龄<span class='sub_info'>${userInfo.pcpAge}</span></p>
                                    <p>学历<span class='sub_info'>${userInfo.pcpEducation}</span></p>
                                    <p>婚姻<span class='sub_info'>${userInfo.pcpMateria}</span></p>
                                    <br>
                                    <p>身份证号<span class='sub_info'>${userInfo.pcpCertNo}</span></p>
                                    <p style='width:700px'>户口所在地<span class='sub_info'>${userInfo.pcpNativePlace}</span></p>
                                </li>
                                <li  class='base-info'>住址信息</li>
                                <li  style='height:40px;line-height:40px;'>家庭住址<span>${userInfo.pcpAddress}</span></li>
                                <li class='base-info'>工作信息</li>
                                <li>
                                    <p>工作年限<span class='sub_info'>${userInfo.pcpWorkAge}年</span></p>
                                    <p>职业<span class='sub_info'>${userInfo.pcpWorkPosition}</span></p>
                                    <p>月收入<span class='sub_info'>${userInfo.pcpMonthSalary}元</span></p>
                                </li>
                            </ul>
                            <h3 class='bwMoneyUse-title'>借贷用途</h3>
                            <div class='bwMoneyUse'>
                            ${userInfo.pcpRemark}
                            </div>
                        </div>
                        
                        
                    <!--  <ul>
                          <li><p class="db-title">借款描述</p>
                              <p class="db-desc">宏银融资租赁(上海)有限公司根据承租人的需求，出资购买承租人所需的眼科设备，然后出租给承租人，承租人则分期向宏银融资租赁(上海)有限公司支付租金，在协议期间内租赁物所有权归宏银融资租赁(上海)有限公司，承租人拥有使用权。宏银融资租赁(上海)有限公司把每月收取租金的权益，以应收账款收益权转让的形式，转让给投资人。总融资金额为700万元，本次为融资租赁007-A债权转让金额5万元。</p></li>
                          <li><p class="db-title">资金用途</p>
                              <p class="db-desc">本次项目融资用于补充流动资金。</p></li>
                          <li><p class="db-title">还款来源 </p>
                              <p class="db-desc">第一还款来源，承租企业经营状况良好，盈利水平稳定， 2014年医疗收入为7569万元，2015年截至3月底，医疗收入2666.8万元。 第二还款来源，北京远程视界眼科医院管理有限公司提供回购担保。</p></li>
                          <li><p class="db-title">融资租赁机构简介</p>
                              <p class="db-desc">宏银融资租赁（上海）有限公司以直租方式向厂家采购的总价值556.473万元的机器设备，该批设备由北京远程视界眼科医院管理有限公司出售，包含光相干断层扫描仪、数字眼底照相机（造影照相一体机）、YZ25系列双目间接检眼镜、超声眼科专用诊断仪（角膜测厚仪）、脉冲Nd:YAG激光泪道治疗机、眼科Nd:YAG激光治疗仪、裂隙灯显微镜（可配合532激光）YZ11系列检眼镜、超声眼科专用诊断仪（UBM显
                                                 微镜）、电脑验光/角膜曲率仪等设备及其配件。</p></li>
                          <li><p class="db-title">出租物评估意见</p>
                              <p class="db-desc">宏银融资租赁(上海)有限公司，于2014年8月18日在上海自贸区成功注册，注册资本2.1亿元人民币。总部位于北京市，在上海深圳等多地设有业务代表处。其业务范围为直接融资租赁、售后回租、厂商租赁、杠杆租赁、联合租赁、委托租赁、转租赁、
                                                 资产并购、投资等。公司由一家外资公司-兆佳实业发展有限公司(香港)，一家内资公司-上海仙沃实业有限公司(上海)共同出资组建。他们通过其丰富的社会资源在业务扩展等方面为公司发展提供支持。公司凭借专业的业务团队、良好的企业文化和快速的业务处理能力，积极开展以融资租凭、资产管理、融资咨询等为核心的各项业务，致力于为企业和个人提供专业化、全方位的融资服务。。</p></li>
                          <li><p class="db-title">风险控制措施</p>
                              <p class="db-desc">1、本项目为直租业务，租赁物总价值为556.473万元，上述556.473万元的租赁物设备全部归在宏银融资租赁(上海)有限公司名下，作为承租人的履约担保；待承租企业在租赁期间内完整履行约定后，宏银融资租赁(上海)有限公司将租赁物所有权移交给承租企业。<br/>
                                                 2、收取承租企业保证金。<br/>
                                                 3、购买该设备财产保险，第一受益人为宏银融资租赁(上海)有限公司。<br/>
                                                 4、北京远程视界眼科医院管理有限公司提供回购担保。</p></li>
                          <li><p class="db-title">涉诉、信用信息</p>
                              <p class="db-desc">经人法网，企业信息查询网融资租赁机构，承租企业无不良信用记录。根据信用报告查询企业法定代表人及其配偶无不良信用记录。</p></li>
                      </ul> -->
                      
                  <!--  <table cellpadding="0" cellspacing="0" class="bdms-table">
                        <tr>
                            <td class="td-title">借款描述</td>
                            <td class="td-desc">宏银融资租赁(上海)有限公司根据承租人的需求，出资购买承租人所需的眼科设备，然后出租给承租人，承租人则分期向宏银融资租赁(上海)有限公司支付租金，在协议期间内租赁物所有权归宏银融资租赁(上海)有限公司，承租人拥有使用权。宏银融资租赁(上海)有限公司把每月收取租金的权益，以应收账款收益权转让的形式，转让给投资人。总融资金额为700万元，本次为融资租赁007-A债权转让金额5万元。</td>
                        </tr>
                        <tr>
                            <td class="td-title">资金用途</td>
                            <td class="td-desc">本次项目融资用于补充流动资金。</td>
                        </tr>
                        <tr>
                            <td class="td-title">还款来源</td>
                            <td class="td-desc">第一还款来源，承租企业经营状况良好，盈利水平稳定， 2014年医疗收入为7569万元，2015年截至3月底，医疗收入2666.8万元。 第二还款来源，北京远程视界眼科医院管理有限公司提供回购担保。</td>
                        </tr>
                        <tr>
                            <td class="td-title">融资租赁机构简介</td>
                            <td class="td-desc">宏银融资租赁（上海）有限公司以直租方式向厂家采购的总价值556.473万元的机器设备，该批设备由北京远程视界眼科医院管理有限公司出售，包含光相干断层扫描仪、数字眼底照相机（造影照相一体机）、YZ25系列双目间接检眼镜、超声眼科专用诊断仪（角膜测厚仪）、脉冲Nd:YAG激光泪道治疗机、眼科Nd:YAG激光治疗仪、裂隙灯显微镜（可配合532激光）YZ11系列检眼镜、超声眼科专用诊断仪（UBM显
                                                微镜）、电脑验光/角膜曲率仪等设备及其配件。
                            </td>
                        </tr>
                        <tr>
                            <td class="td-title">出租物评估意见</td>
                            <td class="td-desc">宏银融资租赁(上海)有限公司，于2014年8月18日在上海自贸区成功注册，注册资本2.1亿元人民币。总部位于北京市，在上海深圳等多地设有业务代表处。其业务范围为直接融资租赁、售后回租、厂商租赁、杠杆租赁、联合租赁、委托租赁、转租赁、
                                                资产并购、投资等。公司由一家外资公司-兆佳实业发展有限公司(香港)，一家内资公司-上海仙沃实业有限公司(上海)共同出资组建。他们通过其丰富的社会资源在业务扩展等方面为公司发展提供支持。公司凭借专业的业务团队、良好的企业文化和快速的业务处理能力，积极开展以融资租凭、资产管理、融资咨询等为核心的各项业务，致力于为企业和个人提供专业化、全方位的融资服务。
                            </td>
                        </tr>
                        <tr>
                            <td class="td-title">风险控制措施</td>
                            <td class="td-desc">1、本项目为直租业务，租赁物总价值为556.473万元，上述556.473万元的租赁物设备全部归在宏银融资租赁(上海)有限公司名下，作为承租人的履约担保；待承租企业在租赁期间内完整履行约定后，宏银融资租赁(上海)有限公司将租赁物所有权移交给承租企业。<br/>
                                                2、收取承租企业保证金。<br/>
                                                3、购买该设备财产保险，第一受益人为宏银融资租赁(上海)有限公司。<br/>
                                                4、北京远程视界眼科医院管理有限公司提供回购担保。
                            </td>
                        </tr>
                        <tr>
                            <td class="td-title">涉诉、信用信息</td>
                            <td class="td-desc">经人法网，企业信息查询网融资租赁机构，承租企业无不良信用记录。根据信用报告查询企业法定代表人及其配偶无不良信用记录。</td>
                        </tr>
                    </table>-->
                </div>
                <!-- 标的图片 -->
                <div class="biaodesc-tp divtab">
                    <ul class="ui-bdtp clearfix ">
                    <#list pictureList as picture>
                        <li><img data-url="${basePath}/service/file/${picture.plpAddress}" class="pictureImg" src="${basePath}/service/file/${picture.plpAddress}"/></li>
                    </#list>
                    </ul>
                </div>
                
                <!-- 投资记录 -->
                    <div id="baibao-paging">
                     <div  class="biaodesc-jl divtab" id="productRecord">
                        <#include "./productTenderRecords.ftl" />
                          </div>
                </div>
                
                <!-- 还款表现 -->
                <div class="biaodesc-hk divtab w206">
                 <#if islogin=true>
                    <ul>
                        <li class="jl-title" style="background:#eeeeee"><span class="strong">预计回款时间</span><span class="strong">状态</span><span class="strong">预计回款本息</span><span class="textCt strong">实际回款日期</span></li>
                        <#if notCurrentUser == "1">
                            <#if 0!=listBillPlan?size>
                             <#list listBillPlan as billPlan>
                                    <li><span><#if billPlan.pbpDatetime??>
                                    ${billPlan.pbpDatetime?string('yyyy-MM-dd')} </#if></span>
                                    <span><#if billPlan.pbpProfitStatus=0>未回款
                                    <#elseif billPlan.pbpProfitStatus=1>已回款
                                    <#elseif billPlan.pbpProfitStatus=2>回款中
                                    <#elseif billPlan.ptpProfitstatus=6>已转让
                                    <#elseif billPlan.ptpProfitstatus=7>转让中
                                    </#if></span>
                                    <span class="pink">${(billPlan.pbpProfitCapital + billPlan.pbpProfitInterest)?string(',##0.00')}元</span>
                                    <span class="textCt">
                                    <#if billPlan.pbpProfitTime == null>
                                        --
                                    <#elseif billPlan.pbpProfitTime??>
                                        ${billPlan.pbpProfitTime?string('yyyy-MM-dd')}
                                    </#if>
                                    </span></li>
                           </#list> 
                             <#else>
                            <li style="height:80px"><p class="fl no-record" style="padding:30px 0 40px 0">暂无数据</p></li>
                             </#if>
                        <#else>
                            <#if 0!=billList?size>
                             <#list billList as tenderProfit>
                            <li><span><#if tenderProfit.ptpProfittime??>
                            ${tenderProfit.ptpProfittime?string('yyyy-MM-dd')} </#if></span>
                            <span><#if tenderProfit.ptpProfitstatus=0>未回款
                            <#elseif tenderProfit.ptpProfitstatus=1>已回款
                            <#elseif tenderProfit.ptpProfitstatus=2>回款中
                            <#elseif tenderProfit.ptpProfitstatus=6>已转让
                            <#elseif tenderProfit.ptpProfitstatus=7>转让中
                            </#if></span>
                            <span class="pink">${tenderProfit.ptpFactprofit}元</span>
                            <span class="textCt">
	                            <#if tenderProfit.ptpFactprofittime??>
	                                ${tenderProfit.ptpFactprofittime?string('yyyy-MM-dd')}
	                            <#else>
	                               	 --
	                            </#if>
                            </span></li>
                           </#list> 
                             <#else>
                            <li style="height:80px"><p class="fl no-record" style="padding:30px 0 40px 0">暂无数据</p></li>
                             </#if>
                        </#if>
                    </ul>
                     <#elseif islogin=false>
                    <div class="NoUser">
                     <span class="NoUserCen"><span>请</span><span><a href="${basePath}/service/login" class="lan">登录</a>/<a class="lan" href="${basePath}/service/register">注册</a></span><span>后查看</span></span>
                    </div>
                </#if>
                </div>
                
             
                
            </div>
        </div>
    </div>
    <#if productDetail.ppBulkloanstatus=1 >
        <script language="javascript" type="text/javascript"> 
            var time;
            var NowTime = '${NowTime?string('yyyy-MM-dd HH:mm:ss')}';
            var str = '${productDetail.ppBulkloanendtime?string('yyyy-MM-dd HH:mm:ss')}'.replace(/-/g,"/").replace(".0","");
            var EndTime= new Date(str);
            NowTime=new Date(NowTime.replace(/-/g,"/").replace(".0",""));
            var t =EndTime.getTime() - NowTime.getTime();
            function getTime(){
              if(t>0){
                    var d=Math.floor(t/1000/60/60/24);
                    var h=Math.floor(t/1000/60/60%24);
                    var m=Math.floor(t/1000/60%60);
                    var s=Math.floor(t/1000%60);
                    document.getElementById("t_d").innerHTML = d + "天";
                    document.getElementById("t_h").innerHTML = h + "时";
                    document.getElementById("t_m").innerHTML = m + "分";
                    document.getElementById("t_s").innerHTML = s + "秒";
               }
            }
            getTime();
           time=setInterval(function(){
               t = t - 1000;
               getTime();
           },1000);
        </script>
    </#if>
    <#include "./common/common_footer.ftl" />
    
    <!-- 投标弹框 -->
    <div id="tenderBox" class="alert-con" id="tb-alert" style="width:450px;">
        <div class="widget">
            <div class="widget-head clearfix">
                <div class="fl alert-title">立即投资
                </div>
                <div class="fr">
                    <span id="closeBox" class="alert-close" title="关闭">×</span>
                </div>
            </div>
            <div class="widget-content">
                <div class="padd">
                    <ul class="alert-ui">
                         <li class="ldesc">
                            <span class="alert-tip">借款标题：</span>
                            <span id="productTitle" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">预期年化收益：</span>
                            <span id="comprehensiveRate" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">投资期限：</span>
                            <span id="loanTerm" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">计息方式：</span>
                            <span id="loanRepayment" class="alert-desc"></span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip">投资金额：</span>
                            <span <span id="loanAmount" class="alert-desc loanAmount"></span>元</span>
                        </li>
                         <li class="ldesc">
                            <span class="alert-tip ">交易金额：</span>
                            <span class="alert-desc"><span class="tb-number loanAmount"></span>元</span>
                        </li>
                       <#if productDetail.pp_inviteCode == "BBJF">
                         <li>
                            <span class="alert-tip">邀请码：</span>
                            <input class="alert-invest" type="password" maxlength="6">
                            <p class="alert-err"></p>
                        </li>
                         </#if> 
                        
                        <li>
                            <span class="alert-tip">交易密码：</span>
                            <input class="alert-txt" type="password" maxlength="6">
                            <p class="alert-err"></p>
                        </li>
                        <li>
                            <span class="alert-tip">&nbsp;</span>
                            <button id="sureTenderBtn" class="btn btn-primary">确定</button>
                            <button id="cancelBtn" class="btn btn-default ml10">取消</button>
                        </li>
                    </ul>
    
                </div>
            </div>
        </div>
    </div>
    <!-- 设置交易密码 -->
    <#include "./personal/_setTransPassword.ftl" />
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
    <script src="${basePath}/js/baibao/projectWindow.js" type="text/javascript"></script>
    <script>
        var isSetPcaPayPassword='${isSetPcaPayPassword}';
        seajs.use("investment");
       $("#main-nav .nLi").eq(1).addClass("current").siblings().removeClass("current");
    </script>
    
</body>
</html>
