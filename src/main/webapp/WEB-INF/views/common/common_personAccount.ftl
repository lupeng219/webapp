<div class="invest-list-nav">
    <div class="container">
        <ul class="list-nav" id="personNav">
            <li class="menuLi"><a href="${basePath}/service/asset">资产总览</a></li>
            <li class="menuLi"><a href="${basePath}/service/account">我的账户</a></li>
            <li class="menuLi"><a href="${basePath}/service/transRecord">交易记录</a></li>
            <li class="menuLi"><a href="${basePath}/service/personalInvestment">我的投资</a></li>
            <li class="menuLi"><a href="${basePath}/service/personalBorrow">我的借款</a></li>
            <li class="menuLi"><a href="${basePath}/service/message/toMessageCenter">消息中心</a></li>
        </ul>
        <script type="text/javascript">
            jQuery("#personNav").slide({type: "menu", titCell: ".menuLi", targetCell: ".sub", effect: "slideDown", delayTime: 200, triggerTime: 0, defaultPlay: true, returnDefault: true, easing: "swing"});
        </script>
        <div class="fr per-gonggao txtScroll-top hiddenCon" style="height:43px;">
            <em class="pergg-icon periconbg"></em>
            <div class="pergg-desc bd">
                <div class="tempWrap" style="overflow:hidden; position:relative; height:120px">
                    <ul class="infoList" style="position: relative; top:0; padding: 0px; margin: 0px;">
                        <!-- li style="height: 43px;">
                            <a href="">关于佰宝金服银行卡提现的问题</a>
                        </li>
                        <li style="height: 43px;">
                            <a href="">9月12-13日各银行升级公告</a>
                        </li>
                        <li style="height: 43px;">
                            <a href="">反法西斯战争胜利70周年放假通... </a>
                        </li -->
                    </ul>
                    <script type="text/javascript">
                        var noticeString=session.get("noticeString");
                        if(noticeString){
                            noticeString=JSON.parse(noticeString);
                            var html="";
                            for(var i=0;i<noticeString.length;i++){
                                html+='<li style="height: 43px;"><a href="'+root+'/service/aboutUs/noticeDesc?noticeId='+noticeString[i].articleID+'">'+noticeString[i].articleTitle+'</a></li>';
                            }
                            $(".infoList").html(html);
                        }
                    </script>
                </div>
            </div>
        </div>
        <script  type="text/javascript">
            jQuery(".txtScroll-top").slide({
                mainCell: ".bd ul",
                autoPage: true,
                effect: "topLoop",
                autoPlay: true,
                vis: 1,
                delayTime: 400
            });
        </script>
    </div>
</div>
<div class="yjtc posAb" style="display: none;top:-96px;" id="person_tishi">
    <ul class="yjtc_kd">
        <li id="person_tishi_phone" class="color_6 mtop15">已绑定<br>${currentUser.mobile }</li>
        <li id="person_tishi_ren" class="color_6 mtop15">已实名<br>${baseInfo.real_name }</li>
    </ul>
</div>
