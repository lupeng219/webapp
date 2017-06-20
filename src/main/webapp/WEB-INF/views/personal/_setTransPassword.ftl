<div class="alert-con" style="width:400px;display:none;transform:none"id="setPasswordModel">
    <div class="widget">
        <div class="widget-head clearfix">
            <div class="fl alert-title">设置交易密码
            </div>
            <div class="fr">
                <span class="alert-close" title="关闭"><img src="${basePath}/pictures/btn-close.png"/></span>
            </div>
        </div>
        <div class="widget-content">
            <div class="padd">
                <ul>
                    <li class="mt5">
                    	<span class="ui-sp">新密码</span>
                    	<input type="password" class="txtpwd" id="newTransPwd" maxLength="6"/>
                    	<p class="alert-err-tip"></p>
            		</li>
                    <li>
                    	<span class="ui-sp">确认密码</span>
                    	<input type="password" class="txtpwd" id="newTransPwdSub" maxLength="6"/>
                    	<p class="alert-err-tip"></p>
                	</li>
                </ul>
                <p class="op-btn">
                    <button class="btn btn-primary" id="startSetPassword" data-available="true">确定</button>
                    <button class="btn btn-default ml10 alert-cancel">取消</button>
                </p>
            </div>
        </div>
    </div>
</div>
<script type='text/javascript'>
    var alertHgh=$("#setPasswordModel").height(),alertWth=$("#setPasswordModel").width();
    var screenWidth = $(window).width(), screenHeigth = $(window).height();
    var Wth=screenWidth-alertWth,Hgh=screenHeigth-alertHgh;

    $("#setPasswordModel").css({
        "top":Hgh/2+"px",
        "left":Wth/2+"px"
    })
</script>
