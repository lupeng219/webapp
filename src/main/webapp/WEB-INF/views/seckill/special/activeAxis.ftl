<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/jquery.fullPage.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/special/activitySet.css"/>
</head>
<body>
	<div class="topbar border-b" id="top">
	    <div class="container">
	        <div class="fl">
	            <ul class="topui ml10">
	            	<li><a href="${basePath}" class="ml10">首页</a></li>
	                <li><em class="phone-icon iconbg"></em> <a href="${basePath}/service/dissertation/appSpecial" class="ml10">移动客户端</a></li>
	            </ul>
	        </div>
	        <div class="fr">
	            <ul class="topui">
	            	<#if Session["CURRENT_LOGIN_USER"]?exists>
					<li><a href="${basePath}/service/asset">欢迎回来 ${Session.CURRENT_LOGIN_USER.puMobile[0..2]}****${Session.CURRENT_LOGIN_USER.puMobile[7..10]}</a></li>
					<li><a href="${basePath}/service/login/logout">[退出]</a></li>
					<#else>
	                <li><a href="${basePath}/service/login">您好，请登录</a></li>
	                <li><a href="${basePath}/service/register">免费注册</a></li>
					</#if>
	                <li><a href="http://crm2.qq.com/page/portalpage/wpa.php?uin=4006888129&aty=0&a=0&curl=&ty=1" target="_blank">在线客服</a></li>
	                <li style="position:relative;">关注我们 
	                	<em class="wx-icon iconbg" style="cursor:pointer;"></em>
	                	<a href="http://weibo.com/baibao?from=myfollow_all" target="_blank"><em class="wb-icon iconbg"></em></a>
	                	<div class="twoDimensional" style="display: none;">
			                <div class="erwm">
			                    <img src="${basePath}/images/erweima.jpg">
			                </div>
			            </div>
			            <script type="text/javascript">
			            	$(".wx-icon").hover(function(){
						        $(".twoDimensional").show();
						    },function(){
						        $(".twoDimensional").hide();
						    });
			            </script>
	            	</li>
	            </ul>
	        </div>
	    </div>
	</div>
    <div class="active-wrap">
        <ul class="fixnav" id="menu">
            <li data-menuanchor="page1" class="active"><a href="#page1">领取 红包</a></li>
            <li data-menuanchor="page2"><a href="#page2">幸运 抽奖</a></li>
            <li data-menuanchor="page3"><a href="#page3">邀好友得现金</a></li>
        </ul>
        <div id="dowebok">
            <div class="pcact con1 section">
            	<div class="sub">
					<img src="${basePath}/images/special/ban1-1.png"/>
					<#if Session["CURRENT_LOGIN_USER"]?exists>
						<a class="receive" href="${basePath}/service/active/toMyActive" target="_blank"> >>>领取红包</a>
					</#if>
					<div class="from-txt">
						<ul>
							<li>
								<input type="tel" class="reg-txt bor_radius3" placeholder="请输入您的手机号" id="mobile" maxlength="11"/>
								<p class="regerr-tip" id="mobileErr"></p>
							</li>
							<li>
								<input type="text" class="reg-txt bor_radius3" placeholder="请输入图片验证码" id="imgVer" maxlength="6" style="width:112px;"/>
								<img src="${basePath}/scaptcha" id="checkCodeImg" class="ml10 bor_radius3" style="width:68px;height:32px;cursor:pointer;">
								<p class="regerr-tip"></p>
							</li>
							<li>
								<input type="text" class="reg-txt bor_radius3" placeholder="请输入手机验证码" id="verification" maxlength="6"/>
								<a href="javascript:void(0);" class="hqyzm-btn" data-available="true">获取验证码</a>
								<p class="regerr-tip"></p>
							</li>
							<li>
								<input type="password" class="reg-txt bor_radius3" placeholder="请输入您的登录密码" id="password" maxlength="20"/>
								<p class="regerr-tip" id="passwordErr"></p>
							</li>
							<li class="mt5">
								<a href="javascript:void(0);" class="reg-btn" data-available="true">领取521元红包</a>
							</li>
						</ul>
					</div>        	
            	</div>
            </div>
            <div class="pcact con3 section">
                <div class="shuoming">
                    <p><span class="strong">说明：</span>活动期间每日登陆佰宝金服均可获得一次抽奖机会；每日每次投资也可获得一次抽奖机会，单日最多两次，活动抽取的红包请在"个人中心"-"我的优惠券"中查看。</p>
                </div>
                <div class="chouj-con">
                    <p class="con3-tel">幸运转盘抽iPhone 6S</p>
                    <div class="dzp-con">
                        <ul id="lottery">
                        	<li>
	                        	<span class="img-con jp0">
	                        		<img src="${basePath}/images/special/bh1.png"/>
	                            	<em></em>
	                        	</span>
	                        </li>
	                        <li>
	                        	<span class="img-con jp1">
	                        		<img src="${basePath}/images/special/afhfp.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
	                        <li>
	                        	<span class="img-con jp2">
	                        		<img src="${basePath}/images/special/hb10.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
	                        <li>
	                        	<span class="img-con jp3">
	                        		<img src="${basePath}/images/special/yddy.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
	                        <li>
	                            <div style="width:133px;">
	                            	<span class="img-con jp11">
	                            		<img src="${basePath}/images/special/ihone6s.png"/>
	                            		<em></em>
	                        		</span>
	                                <span class="img-con mt15 jp10">
	                                	<img src="${basePath}/images/special/hb30.png"/>
	                                	<em></em>
	                            	</span>
	                        	</div>
	                        </li>
	                        <li class="btn-bg">
	                            <p class="textCt">
	                            	<#if Session["CURRENT_LOGIN_USER"]?exists>
	                            		<#if custNoCount gt 0>
			                            	<a href="javascript:void(0);" class="dzp-btn"></a>
	                            		<#else>
	                            			<a class="dzp-btn-not"></a><!-- 无抽奖机会 -->
	                            		</#if>
	                            	<#else>
	                            		<a href="${basePath}/service/login" class="dzp-btn-login" target="_blank"></a>
	                            	</#if>
	                            </p>
	                            <#if Session["CURRENT_LOGIN_USER"]?exists>
		                            <p class="txt-tzjh">您还有<span>${custNoCount}</span>次抽奖机会</p>
		                            <p class="txt-des"><a href="${basePath}/service/active/physicalReward" target="_blank">【查看实物奖励】</a></p>
	                            </#if>
	                        </li>
	                        <li>
	                            <div style="width:133px;">
	                            	<span class="img-con jp4">
	                            		<img src="${basePath}/images/special/hb20.png"/>
	                            		<em></em>
	                        		</span>
	                                <span class="img-con mt15 jp5">
	                                	<img src="${basePath}/images/special/zlyc.png"/>
	                                	<em></em>
	                            	</span>
	                        	</div>
	                        </li>
	                        <li>
	                        	<span class="img-con jp9">
	                        		<img src="${basePath}/images/special/hj.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
	                        <li>
	                        	<span class="img-con jp8">
	                        		<img src="${basePath}/images/special/xxcy.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
	                        <li>
	                        	<span class="img-con jp7">
	                        		<img src="${basePath}/images/special/hb60.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
	                        <li>
	                        	<span class="img-con jp6">
	                        		<img src="${basePath}/images/special/jksh.png"/>
	                        		<em></em>
	                    		</span>
	                		</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="pcact con4 section">
            	<#if Session["CURRENT_LOGIN_USER"]?exists>
            		<a href="${basePath}/service/active/inviteFriends" class="ljyq-btn" target="_blank">
	                    <img src="${basePath}/images/special/ljyq-btn.png"/>
	                </a>
            	<#else>
            		<a href="${basePath}/service/login" class="ljyq-btn" target="_blank">
	                    <img src="${basePath}/images/special/ljyq-btn.png"/>
	                </a>
            	</#if>
            </div>
        </div>
    </div>
    <!-- 显示用户奖品弹窗 -->
    <div class="hj-alert" style="display:none;" id="dzp-alert">
	    <div class="dzp-alert">
	        <p class="alert-p"></p>
	    </div>
	    <div class="dzp-alert-xie" style="display:none;"></div>
    </div>
    
    <script src="${basePath}/js/public/jquery.fullPage.min.js" type="text/javascript"></script>
    <script>
    	$(function(){
    		$('#dowebok').fullpage({
            	css3: true,
            	anchors: ['page1', 'page2', 'page3'],
				menu: '#menu'
            });
            var click=false;
            var lottery={
				index:-1,	//当前转动到哪个位置，起点位置
				count:0,	//总共有多少个位置
				timer:0,	//setTimeout的ID，用clearTimeout清除
				speed:20,	//初始转动速度
				times:0,	//转动次数
				cycle:50,	//转动基本次数：即至少需要转动多少次再进入抽奖环节
				prize:-1,	//中奖位置
				prizeName:"",	//奖品名称
				init:function(id){
					if($("#"+id).find("img").length>0) {
						$lottery = $("#"+id);
						$units = $lottery.find("img");
						this.obj = $lottery;
						this.count = $units.length;
						$lottery.find(".jp"+this.index+" em").addClass("cut-ceng");
					};
				},
				roll:function(){
					var index = this.index;
					var count = this.count;
					var lottery = this.obj;
					$(lottery).find(".jp"+this.index+" em").removeClass("cut-ceng");
					index += 1;
					if(index>count-1) {
						index = 0;
					};
					$(lottery).find(".jp"+index+" em").addClass("cut-ceng");
					this.index=index;
					return false;
				},
				stop:function(index){
					this.prize=index;
					return false;
				}
			};
			function roll(){
				lottery.times += 1;
				lottery.roll();
				if (lottery.times > lottery.cycle+10 && lottery.prize==lottery.index) {
					clearTimeout(lottery.timer);
					var tempPrize=lottery.prize;
					lottery.prize=-1;
					lottery.times=0;
					setTimeout(function(){
						click=false;
						if(tempPrize==8){//谢谢参与
							$("#dzp-alert .dzp-alert").hide();
							$("#dzp-alert .dzp-alert-xie").show();
							$(".projectWindowBg").show();
							$("#dzp-alert").show();
						}else{
							$("#dzp-alert p").html("您抽中了"+ lottery.prizeName +"！！！");
							$(".projectWindowBg").show();
							$("#dzp-alert").show();
						}
					},200);
				}else{
					if (lottery.times<=lottery.cycle) {
						lottery.speed -= 10;
					}else{
						if (lottery.times > lottery.cycle+10 && ((lottery.prize==0 && lottery.index==7) || lottery.prize==lottery.index+1)) {
							lottery.speed += 110;
						}else{
							lottery.speed += 20;
						}
					}
					if (lottery.speed<40) {
						lottery.speed=40;
					};
					lottery.timer = setTimeout(roll,lottery.speed);
				}
				return false;
			};
            lottery.init('lottery');
            $(".dzp-btn").click(function(){
				if (click) {
					return false;
				}else{
					$.ajax({
			    		type:'POST',
			    	    url:root+"/service/active/lotteryDraw",
			    	    dataType:'json',
			    	    error:function(data){
			    	    	alert("服务器繁忙，请稍后重试！");
			    	    	click=false;
			    	    	return false;
			    	    },
			    	    success:function(data){
			    	    	if(parseInt(data.prizeNo)==12){
			    	    		alert("您今天的抽奖次数已用完!");
			    	    		return false;
			    	    	}else{
			    	    		lottery.speed=100;
								roll();
								click=true;
				    	    	lottery.prize=parseInt(data.prizeNo);
				    	    	lottery.prizeName=data.prizeName;
			    	    	}
			    	    }
			    	});
					return false;
				}
			});
			$("#dzp-alert .dzp-alert,#dzp-alert .dzp-alert-xie").on("click",function(){
				window.location.reload();
			});
        });
    </script>
    <script>seajs.use("special/activeAxis");</script>
    <script>
		var _hmt = _hmt || [];
		(function() {
		  var hm = document.createElement("script");
		  hm.src = "//hm.baidu.com/hm.js?45f8c1ed715ba48affb13a4b11f3ba68";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>