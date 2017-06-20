<!DOCTYPE html>
<html>
<head>
    <#include "./common/common_src.ftl" />
    <title>找回登陆密码-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/personal-common.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/back-password.css"/>
</head>
<body>
	<#include "./common/common_header.ftl">
	
    <div class="personal-main ">
        <div class="container">
        	<div class="backPwd-title">
        		 <h2 class="backPwd">找回登录密码</h2>
     		</div>
            <div class="backPwdper-txtcon clearfix">
                <div class="setting-step-con-login">
                    <div class="step-list-con step-total-3-login step-current-1">
                        <ul class="step-list clearfix">
                            <li class="step-item current-step">
                                <span class="step-index">1</span>
                                <span>填写账户名</span>
                            </li>
                            <li class="step-item">
                                <span class="step-index ">2</span>
                                <span>验证身份</span>
                            </li>
                            <li class="step-item" >
                                <span class="step-index ">3</span>
                                <span>重置登录密码</span>
                            </li>
                            <li class="step-item">
                                <span class="step-index ">4</span>
                                <span>完成</span>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="backPwd-con">
                    <!-- 修改登陆密码  第一步 填写账户名 -->
                    <ul class="backpwd-ui">
                        <li>
                            <div class="clearfix whtext"><span class="back-title">手机号码</span>
                                <input type="text" class="back-txt" id="mobile" placeholder='请输入手机号码'/>
                            </div>
                            <p class="err-p fl"></p>
                        </li>
                        <li>
                            <div class="clearfix mt20"><span class="back-title ">验证码</span>
                                <input type="text" class="back-txt yzm-txt" id="imgVer" placeholder='请输入验证码'/>
                                <img src="${basePath}/scaptcha" id="checkCodeImg" class="fl ml10" width="70" height="33"/>
                                <a href="javascript:void(0);" class="fl ml10 mt5" id="changeCodeBtn"><img src="${basePath}/pictures/reg-login/update-yzm.png"/> </a>
                            </div>
                            <p class="err-p" id="errOne"></p>
                        </li>
                        <li><span class="back-title">&nbsp;</span>
                            <a href="javascript:void(0);" class="btn-nextStep fl" id="backSubmitOne">下一步</a>
                        </li>
                    </ul>
                    <!-- 修改登陆密码  第二步 验证身份 -->
                    <ul class="backpwd-ui" style="display:none;">
                        <li>
                            <span class="back-title">已验证手机号</span>
                            <p class="back-desc" id="phoneNo"></p>
                        </li>
                        <li>
                            <div class="clearfix whtext" ><span class="back-title">手机验证码</span>
                                <input type="text" class="back-txt" id="mobileVer" placeholder='请输入手机验证码' onkeyup="this.value=this.value.replace(/[^\d]/g,'') " onafterpaste="this.value=this.value.replace(/[^\d]/g,'') " maxlength='6'/>
                                <a href="javascript:void(0);" id="getPhoneVar" class="btn-hqyzm" data-available="true">获取验证码</a></div>
                            <!-- 点击获取验证码，按钮置灰，class名追加btn-hqyzm-hui，倒计时 -->
                            <p class="err-p fl" id="errTwo" ></p>
                        </li>
                        <li>
                         <div class="clearfix mt20">
                        	<span class="back-title">&nbsp;</span>
                            <a href="javascript:void(0);" class="btn-nextStep fl " id="backSubmitTwo">下一步</a>
                        </div>
                        </li>
                        
                    </ul>
                    <!-- 修改登陆密码  第三步 重置登陆密码-->
                    <ul class="backpwd-ui" style="display:none;">

                        <li>
                            <div class="clearfix whtext" ><span class="back-title">新密码</span>
                                <input type="password" class="back-txt" id="password" placeholder='请输入新密码'/>
                            </div>
                            <p class="err-p fl"></p>
                        </li>
                        <li>
                            <div class="clearfix mt20"><span class="back-title">确认新密码</span>
                                <input type="password" class="back-txt" id="passwordSub" placeholder='请输入确认密码'/>
                            </div>
                            <p class="err-p fl" id="errThree"></p>
                        </li>
                        <li>
                         <div class="clearfix mt20">
                      	 <span class="back-title">&nbsp;</span>
                            <a href="javascript:void(0);" class="btn-nextStep fl" id="backSubmitThree">修 改</a>
                            </div>
                        </li>
                    </ul>
                    <!-- 修改交易密码  第四步 成功-->
                    <div class="backpwd-ui backpwd-ok mb40" style="display:none;">
                        <div class="updateok-img"></div>
                        <p class="update-ok">恭喜,登录密码重置成功！</p>
                        <p class="update-tip">请牢记新的登录密码</p>
                        <p ><a href="${basePath}/service/login" class="btn-nextStep" >返回登录</a></p>
                    </div>
                    
               
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl" />
    <script>seajs.use("backLoginPassword");</script>
</body>
</html>