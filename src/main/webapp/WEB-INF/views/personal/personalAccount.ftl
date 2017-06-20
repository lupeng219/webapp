<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>我的账户-佰宝金服-安全透明灵活的互联网金融服务理财平台</title>
    <meta name="description" content="安全理财首选佰宝金服，期限灵活，不设资金池，第三方托管，专业风控，是您值得信赖的理财专家。"/>
    <meta name="keywords" content="佰宝金服app,网络理财,个人理财,投资理财,p2p安全理财"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-acount.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/jquery.Jcrop.min.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/back-password.css"/>
    <script type="text/javascript" src="${basePath}/js/public/jquery.Jcrop.min.js"></script>
    <script src="${basePath}/js/public/decode.js" type="text/javascript"></script>
    <script type="text/javascript" src="${basePath}/js/public/jquery.autocomplete.min.js"></script>
    <script type="text/javascript" src="${basePath}/js/public/area.js"></script>
    <script type="text/javascript" src="${basePath}/js/public/common-verification.js"></script>
</head>
<body>
    <#include "./common/common_header.ftl" />
    <#include "./common/common_personAccount.ftl" />
    <#include "./common/common_smbanner.ftl"/>
    <div class="personal-main " style='padding-bottom:50px;'>
        <div class="container">
            <div class="clearfix" style="background-color: white;    padding-bottom: 50px; margin-bottom: 20px;" id="per-txtcon">
                <!-- 我的账户 开始 -->
                <div class="tab-header">
                    <span class="tab-title">我的帐户</span>
                </div>
                <div class="myacount-con clearfix divtab" style="display:block;">
                    <ul class="acount-ui" id="acountUl" style="margin-top: 0px;">
                        <li class="lev"><span class="acount-title">手机号</span><span class="acount-desc">${Session.CURRENT_LOGIN_USER.puMobile?substring(0,3)}****${Session.CURRENT_LOGIN_USER.puMobile?substring(7,11)}</span><span class="acount-disop">已绑定</span></li>
                        <li class="lev"><span class="acount-title">登录密码</span><span class="acount-desc">已设置</span><span class="acount-op">修改</span></li>
                        <li class="l1">
                            <div class="update-con clearfix">
                                <p class="textCt hui">为了您的账户安全，请定期更换登录密码，并确保登录密码设置与交易密码不同</p>
                                <div class="acdesc">

                                    <ul class="acdesc-ui mt30">
                                        <li><span class="acdesc-title">原密码：</span>
                                            <input type="password" class="acount-txt" id="oldPassword" placeholder='请输入原密码'/>
                                            <p class="err-p"></p>
                                        </li>
                                        <li><span class="acdesc-title">新密码：</span>
                                            <input type="password" class="acount-txt" id="newPassword" placeholder='请输入新密码'/>
                                            <p class="err-p"></p>
                                        </li>
                                        <li><span class="acdesc-title">确认密码：</span>
                                            <input type="password" class="acount-txt" id="newPasswordSub" placeholder='请输入确认密码'/>
                                            <p class="err-p" id="passwordErr"></p>
                                        </li>
                                        <li><span class="acdesc-title"></span>
                                            <a href="javascript:void(0);" class="okcommit-btn mt10" id="modify_userPass">确 定</a>
                                            <a href="javascript:void(0);" class="close-btn mt10 ml15">取 消</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="zhedie periconbg"></div>
                            </div>
                        </li>
                        <li class="lev">
                            <span class="acount-title">实名认证</span>
                            <#if isCert == 0>
                                <span class="acount-desc" id="isCert">${realName}&nbsp;&nbsp;${hiddenCertNo}</span>
                            <#elseif isCert == 1 || isCert == null>
                                <span class="acount-desc" id="isCert">未认证</span>
                            </#if>
                            <#if isCert == 0 && hasBankCard == false>
                                <span class="acount-op" id="toCert">修改</span>
                            <#elseif isCert == 0 && hasBankCard == true> <!-- 已绑卡不得修改实名 -->
                                <span class="acount-disop">已实名</span>
                            <#elseif isCert == 1 || isCert == null>
                                <span class="acount-op" id="toCert">去认证</span>
                            </#if>
                        </li>
                        <li class="l1 ">
                            <div class="update-con clearfix tr-th">
                                <div class="acdesc fl">
                                    <ul class="acdesc-ui mt10">
                                        <li><span class="acdesc-title">真实姓名：</span>
                                            <input type="text" class="acount-txt" id="realName" value="${realName}" placeholder='请输入姓名'/>
                                            <p class="err-p"></p>
                                        </li>
                                        <li><span class="acdesc-title">身份证号：</span>
                                            <input type="text" class="acount-txt" id="idCard" value="${idCard}" placeholder='请输入身份证号'/>
                                            <p class="err-p" id="openAccountErr"></p>
                                        </li>
                                        <li><span class="acdesc-title"></span>
                                            <a href="javascript:void(0);" class="okcommit-btn mt10" id="open_account">确 定</a>
                                            <a href="javascript:void(0);" class="close-btn mt10 ml15">取 消</a></li>
                                    </ul>
                                </div>
                                <div class="fr">
                                    <ul class="wxts-ui">
                                        <li>温馨提示：</li>
                                        <li>1.实名信息将用来检验您的银行卡等信息，请填写您本人的真实信息</li>
                                        <li>2.实名认证后才可进行充值、投资、提现等资金操作</li>
                                    </ul>
                                </div>
                                <div class="zhedie periconbg"></div>
                            </div>
                        </li>
                        <li class="lev"><span class="acount-title">交易密码</span>
                            <#if isFirst==1>
                                <span class="acount-desc">已设置</span>
                            <#elseif isFirst==0>
                                <span class="acount-desc">未设置</span>
                            </#if>
                            <#if isFirst==1>
                                <span class="acount-op mr5">修改</span>/
                                <a href="${basePath}/service/account/findtranspassword" class="forget-pwd ml5">找回</a>
                            <#elseif isFirst==0>
                                <span class="acount-op">设置</span>
                            </#if>
                        </li>
                        <li class="l1">
                            <div class="update-con clearfix">
                                <p class="textCt hui">为了您的账户安全，请定期更换交易密码，并确保交易密码设置与登录密码不同</p>
                                <div class="acdesc">
                                    <ul class="acdesc-ui mt30">
                                        <input type="hidden" value="${isFirst}" id="isFirst"/><!--是否是第一次设置交易密码-->
                                        <!-- 当点击修改的时候 显示原密码框 -->
                                        <#if isFirst==1 >
                                            <li><span class="acdesc-title">原密码：</span>
                                                <input type="password" class="acount-txt" id="oldTradingPassword" maxlength="6" placeholder='请输入原密码'/>
                                                <p class="err-p"></p>
                                            </li>
                                            <li><span class="acdesc-title">新密码：</span>
                                                <input type="password" class="acount-txt" id="newTradingPassword" maxlength="6" placeholder='请输入新密码'/>
                                                <p class="err-p"></p>
                                            </li>
                                            <li><span class="acdesc-title">确认密码：</span>
                                                <input type="password" class="acount-txt" id="newTradingPasswordSub" maxlength="6" placeholder='请输入确认密码'/>
                                                <p class="err-p" id="setTradingPasswordErr"></p>
                                            </li>
                                        <#elseif isFirst==0>
                                            <li><span class="acdesc-title">交易密码：</span>
                                                <input type="password" class="acount-txt" id="newTradingPassword" maxlength="6" placeholder='请输入交易密码' />
                                                <p class="err-p"></p>
                                            </li>
                                            <li><span class="acdesc-title">确认密码：</span>
                                                <input type="password" class="acount-txt" id="newTradingPasswordSub" maxlength="6" placeholder='请输入确认密码'/>
                                                <p class="err-p" id="setTradingPasswordErr"></p>
                                            </li>
                                        </#if>
                                        <li><span class="acdesc-title"></span>
                                            <a href="javascript:void(0);" class="okcommit-btn mt10" id="set_trading_pass">确 定</a>
                                            <a href="javascript:void(0);" class="close-btn mt10 ml15">取 消</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="zhedie periconbg"></div>
                            </div>
                        </li>
                        <!-- 设置邮箱  -->
                        <li class="lev">
                            <span class="acount-title">电子邮箱</span>
                            <#if isSetEmil==1>
                                <span class="acount-desc">${puEmil[0..2]}****${puEmil[puEmil?index_of("@")..puEmil?length-1]}</span>
                            <#elseif isSetEmil==0>
                                <span class="acount-desc">未设置</span>
                            </#if>
                            <#if isSetEmil==1>
                                <span class="acount-op">修改</span>
                            <#elseif isSetEmil==0>
                                <span class="acount-op">设置</span>
                            </#if>
                        </li>
                        <li class="l1">
                            <div class="update-con clearfix em-sh">
                                <p class="textCt hui">此邮箱可订阅平台发布的最新活动信息，请填写常用邮箱。</p>
                                <div class="acdesc">
                                    <ul class="acdesc-ui mt30">
                                        <input type="hidden" value="${isSetEmil}" id="isSetEmil"/>
                                        <!-- 当点击修改的时候 显示原邮箱框 -->
                                        <#if isSetEmil==1>
                                            <li>
                                                <span class="acdesc-title">原邮箱：</span>
                                                <input type="email" class="acount-txt" id="oldEmail" placeholder='请输入原邮箱'/>
                                                <p class="err-p"></p>
                                            </li>
                                            <li>
                                                <span class="acdesc-title">新邮箱：</span>
                                                <input type="email" class="acount-txt" id="newEmail" placeholder='请输入新邮箱'/>
                                                <p class="err-p"></p>
                                            </li>
                                            <li>
                                                <span class="acdesc-title">验证码：</span>
                                                <input type="text" class="yzm-txt1" id="emailVer" maxLength="6" placeholder='请输入验证码'/>
                                                <span class="yzm-btn ml5" data-available="true">获取验证码</span>
                                                <p class="err-p" id="emailVerErr"></p>
                                            </li>
                                        <#elseif isSetEmil==0>
                                            <li>
                                                <span class="acdesc-title">邮箱地址：</span>
                                                <input type="email" class="acount-txt" id="newEmail" placeholder='请输入邮箱地址'/>
                                                <p class="err-p"></p>
                                            </li>
                                            <li>
                                                <span class="acdesc-title">验证码：</span>
                                                <input type="text" class="yzm-txt1" id="emailVer" maxLength="6" placeholder='请输入验证码'/>
                                                <span class="yzm-btn ml5" data-available="true">获取验证码</span>
                                                <p class="err-p" id="emailVerErr"></p>
                                            </li>
                                        </#if>
                                        <li>
                                            <span class="acdesc-title"></span>
                                            <a href="javascript:void(0);" class="okcommit-btn mt10" id="set_email">确 定</a>
                                            <a href="javascript:void(0);" class="close-btn mt10 ml15">取 消</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="zhedie periconbg"></div>
                            </div>
                        </li>
                        <!-- 收货地址  -->
                        <li class="lev">
                            <span class="acount-title">收货地址</span>
                            <#if pui_address!="">
                                <span class="acount-desc">
                                    <span class="ellipsis2" style="max-width:260px;" title="${pui_address}">${pui_address}</span>
                                </span>
                            <#else>
                                <span class="acount-desc">未设置</span>
                            </#if>
                            <#if pui_address!="">
                                <span class="acount-op">修改</span>
                            <#else>
                                <span class="acount-op">设置</span>
                            </#if>
                        </li>
                        <li class="l1">
                            <div class="update-con clearfix">
                                <p class="textCt hui">此地址用于平台活动发放奖品，请填写正确地址。</p>
                                <div class="acdesc">
                                    <ul class="acdesc-ui mt30">
                                        <#if pui_address!="">
                                            <li>
                                                <span class="acdesc-title">原收货地址：</span>
                                                <span class="ellipsis2" style="max-width:260px;" title="${pui_address}">${pui_address}</span>
                                            </li>
                                        </#if>
                                        <li>
                                            <span class="acdesc-title">收货地址：</span>
                                            <input type="text" class="acount-txt" id="newAddress" placeholder='请输入收货地址'/>
                                            <p class="err-p" id="addressVerErr"></p>
                                        </li>
                                        <li>
                                            <span class="acdesc-title"></span>
                                            <a href="javascript:void(0);" class="okcommit-btn mt10" id="set_address">确 定</a>
                                            <a href="javascript:void(0);" class="close-btn mt10 ml15">取 消</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="zhedie periconbg"></div>
                            </div>
                        </li>
                        <!-- 设置头像 -->                        
                        <li class="lev"><span class="acount-title">头像</span><span class="acount-desc"><#if Session.CURRENT_LOGIN_USER.puHeadUrl==null>未上传<#else>已上传</#if></span><span class="acount-op"><#if Session.CURRENT_LOGIN_USER.puHeadUrl==null>上传<#else>修改</#if></span></li>
                        <li class="l1 ">
                            <div class="update-con clearfix tr-HI">
                                <div class=" fl ml20">
                                    <div class="act-txcon">
                                        <#if head_url?exists>
                                        <img alt="用户头像" src="${basePath}/service/file/${head_url}" width="145px" height="145px">
                                        <#else>
                                        <img alt="用户头像" src="${basePath}/images/icon-head.png" width="145px" height="145px">
                                        </#if>
                                    </div>
                                </div>
                                <div class="fl sctx-op">
                                    <div class="txsc-con">
                                        <div style="border:1px solid #aaa;width: 454px;height: 33px;line-height: 33px;border-radius: 4px;" id="uploadFileName"></div>
                                        <form action="." enctype="multipart/form-data" method="post" id="uploadForm">
                                            <input class="sctx-txt" type="file" id="uploadImg"  name="fileName"/>
                                        </form>
                                        <a href="javascript:void(0);" class="sctx-btn">选择文件</a>
                                    </div>
                                    <p class="err-p pt5" style="padding-left:0px;" id="uploadErr"></p>
                                    <p class="pt10 hui">您可以上传JPG、GIF或PNG文件上传图片最大4M</p>
                                    <p class="pt15"><a href="javascript:void(0);" class="okcommit-btn mt10" id="stateUpload">上 传</a>
                                        <a href="javascript:void(0);" class="close-btn mt10 ml15">取 消</a></p>
                                </div>
                                <div class="zhedie periconbg"></div>
                            </div>
                        </li>
                    </ul>
                </div>
                <!-- 我的账户 结束 -->
                
                <!-- 上传头像开始 -->
                <div id="imgCropModel" style="display:none;background:white;width: 550px;height: 400px;position:fixed;z-index:4444;overflow: hidden;margin: 0;padding: 0;left: 0;right:0;top:20%;margin-left:auto;margin-right:auto;border: 1px solid #e0e0e0">
                    <div style="width: 100%;height:40px;line-height: 40px;background: #e1e1e1;float: left;margin: 0;padding: 0;">
                        <span style="margin-left: 15px;font-size: 16px">编辑图片</span>
                        <span style="float: right;margin-right: 15px;font-size: 20px;cursor: pointer;" id="closeCropImg">×</span>
                    </div>
                    <div style="width: 100%;max-height: 300px;overflow: hidden;float: left;margin: 0;">
                        <form action="${basePath }/service/fileUpLoad/cropImage" method="post" id="imgCropForm">
                            <img src="" style="border: none;max-height: 300px;max-width: 550px;margin: 0;padding: 0;" id="cropImg"/>
                            <input id="x" name="x" type="hidden" value="0">
                            <input id="y" name="y" type="hidden" value="0">
                            <input id="width" name="width" type="hidden" value="100">
                            <input id="height" name="height" type="hidden" value="100">
                            <input id="imgWidth" name="imgWidth" type="hidden" value="0">
                            <input id="imgHeight" name="imgHeight" type="hidden" value="0">
                            <input id="realHeight" name="realHeight" type="hidden" value="0">
                            <input id="realWidth" name="realWidth" type="hidden" value="0">
                            <input id="imageId" name="imageId" type="hidden" value="0">
                        </form>
                    </div>
                    <div style="width: 100%;height: 30px;line-height: 30px;float: left;margin: 0;padding: 0;margin-top: 20px;">
                        <input type="button" value="取消" id="cancelSubResize" style="float: right;color: #676D70;font-size: 16px;border-radius: 15px;height: 30px;
                min-width: 60px;text-align: center;font-size: 16px;cursor:pointer;border:none;background-color: #dbdbdb;margin: 0 10px;"/>
                        <input type="button" value="使用" id="subResize" style="float: right;color: #ffffff;font-size: 16px;border-radius: 15px;height: 30px;
                min-width: 60px;text-align: center;font-size: 16px;cursor:pointer;border:none;background-color: #2ea7e0;margin: 0 10px;"/>
                    </div>
                </div>
                <!-- 上传头像结束 -->
            </div>
        </div>
       
    </script>
    </div>
    <#include "./common/common_footer.ftl" />
    <script type="text/javascript" src="${basePath}/js/baibao/projectWindow.js"></script>
    <script type="text/javascript">
        seajs.use("personal-account");

    </script>
    
</body>
</html>
