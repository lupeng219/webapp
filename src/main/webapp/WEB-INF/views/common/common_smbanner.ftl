<div class='smBanner'>
    <div class='ct-content'>
        <div class='headIcon'>
            <a href="javascript:;">
                <#if Session.head_url??>
                    <img  class="head-icon" alt="用户头像" src="${basePath}/service/file/${head_url}">
                <#else>
                    <div class="Nhead-icon"></div>
                </#if>
            </a>
        </div>
        <div class='hd-userInfo'>
            <h2>${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</h2>
            <h3>
                <#if Session["CURRENT_LOGIN_USER"]?exists>
                    <p class='hd-phone-icon'>
                        <span>您已经绑定手机号：<i>

                               ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}

                        </i></span>
                    </p>
                </#if> 
                <#if Session?exists>
                <#if Session.isBindAccountNo == 0 || Session.isBindAccountNo == '' >
                    <p class='user-href hd-Nuser-icon'>
                        <span>银行卡，您还未绑定银行卡。</span>
                    </p>
                <#else>
                    <p class='hd-user-icon'>
                        <span>您已绑定银行卡</span>
                    </p>
                </#if>
                 <#if Session.isEmailAuth == 0 || Session.isEmailAuth == ''>
                    <p class='email-href hd-Nemail-icon'>
                        <span>您还未绑定邮箱</span> 
                    </p>
                <#else>
                    <p class='email-href hd-email-icon'>
                        <span>您已经绑定邮箱</span> 
                    </p>
                </#if>
                    
                </#if>
                    
                    
                
            </h3>
        </div>
        <p class='lastLoginT'>
            上次登录时间：
            <span>
                <#if Session["CURRENT_LOGIN_USER"]?exists>
                    <#if Session.CURRENT_LOGIN_USER.puLastlogintime?exists>
                        ${Session.CURRENT_LOGIN_USER.puLastlogintime?string("yyyy-MM-dd HH:mm:ss")}
                    </#if>
                </#if>
            </sapn>
        </p>
    </div>
</div>
<script type='text/javascript'>
    console.log(${Session.CURRENT_LOGIN_USER.user.puLastlogintime})
    $(".hd-userInfo").on('mouseover','h3 p',function(){
        $(this).find("span").show();
    }).on('mouseleave','h3 p',function(){
        $(this).find("span").hide();
    });
 
    $(".email-href").on('click',function(){
        var ptname=window.location.pathname;
       
        if(ptname==root +"/service/account"){
            $(".em-sh").show();
            $(".tr-th").hide();
            $(".tr-HI").hide();
            
        }else{
             window.location.href=root +"/service/account#email";
         }
       
       
    })
    $(".user-href").on('click',function(){
         window.location.href=root +"/service/account/torecharge";
    })
    $(".headIcon").on("click",function(){
        var ptname=window.location.pathname;
        if(ptname==root +"/service/account"){
            $(".tr-HI").show();
            $(".tr-th").hide();
            $(".em-sh").hide();
        }else{
             window.location.href=root +"/service/account#headicon";
               
         
        }
    })
  
   
    $(function(){
        $(".tr-HI").hide();
        $(".em-sh").hide();
        $(".tr-th").hide()
       if(window.location.href.indexOf("email")>-1){
            $(".em-sh").show();
            Adcls()
       }else if(window.location.href.indexOf("user")>-1){
            $(".tr-th").show(); 
            Adcls()
       }else if(window.location.href.indexOf("headicon")>-1){
            $(".tr-HI").show();
            Adcls()
              
       } 
    })
    function Adcls(){
         $("#personNav .menuLi").eq(1).addClass("current");
    }

    
   
</script>