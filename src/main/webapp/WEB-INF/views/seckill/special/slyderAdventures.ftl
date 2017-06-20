<!DOCTYPE html>
<html>
<head>
	<#include "./common/common_src.ftl">
	<title>幸运大转盘-佰宝金服-安全透明灵活的互联网金融服务平台</title>
	<meta name="description" content="佰宝金服理财平台致力于搭建一个公开透明、合规便捷、安全高效的互联网金融平台，借助强大的互联网技术及卓越的风控能力，为您的理财之路保驾护航。"/>
	<meta name="keywords" content="佰宝金服,baibao,中融佰诚,,佰宝金服app"/>
	<link rel="stylesheet" type="text/css" href="${basePath}/css/special/actives.css"/>
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
        <div class="dzp-01"></div>
        <div class="dzp-02"></div>
        <div class="dzp-03">
            <div class="container">
                <p class="lplist">iPhone6s、阿芙护肤品、健康手环、移动电源、红酒、大红包</p>
                <p class="lpdesc">奖品送不停, 活动期间，每天登录即有抽奖机会，奖励多多，收益多多！</p>
            </div>
            <div class="cont clearfix">
                <div class="dzp-con fl">
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
                            		<a href="${basePath}/service/login" class="dzp-btn-login"></a>
                            	</#if>
                            </p>
                            <#if Session["CURRENT_LOGIN_USER"]?exists>
	                            <p class="txt-tzjh mt10">您还有<span>${custNoCount}</span>次抽奖机会</p>
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
                <div class="dzp-zjjl fr">
                	<div class="sub">
	                    <ul>
	                    	<#list spoilList as item>
	                    		<li>${item.pu_mobile[0..2]}****${item.pu_mobile[7..10]} <span>获得</span> <span class="ellipsis fr" style="width:89px;">${item.put_name}</span></li>
	                    	</#list>
	                    </ul>
                    </div>
                </div>
            	<script>
					$(".dzp-zjjl").slide({
						mainCell:"ul",
						autoPage:true,
						effect:"topLoop",
						autoPlay:true,
						scroll:1,
						vis:10,
						easing:"swing",
						interTime:1600,
						delayTime:400,
						mouseOverStop:false
					});
            	</script>
            </div>
            <div class="cont">
                <p class="dzp-title">活动细则</p>
                <ol class="dzp-jlgz">
                    <li>用户每日登录后即可获得一次抽奖机会，此项每人每日最多获1次抽奖机会；</li>
                    <li>用户每日投资一次可获得一次抽奖机会，此项每人每日最多获2次抽奖机会。</li>
                </ol>
                <p class="dzp-title">奖励发放与使用</p>
                <ol class="dzp-jlgz">
                    <li>抽取到实物奖励时系统会提示获奖者填写相关的邮寄方式，活动结束后一周内发放实物奖励，请保持手机畅通便于收取快递；</li>
                    <li>用户抽中红包后，红包即刻到账，投资后即可激活红包并获得现金奖励；</li>
                    <li>获取红包后可在“个人中心”-“我的活动”-“我的优惠券”中查看；</li>
                    <li>红包有效期为领取之日起30天内有效，30天后未激活则红包失效；</li>
                    <li>如有疑问请拨打佰宝金服客服电话：010-57492584。</li>
                </ol>
                <p class="jsq-p">本活动解释权归中融佰诚投资管理有限公司</p>
            </div>
        </div>
    </div>
    <#include "./common/common_footer.ftl">
    <!-- 显示用户奖品弹窗 -->
    <div class="hj-alert" style="display:none;" id="dzp-alert">
	    <div class="dzp-alert">
	        <p class="alert-p"></p>
	    </div>
	    <div class="dzp-alert-xie" style="display:none;"></div>
    </div>
    
    <script type="text/javascript">
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
		}
		
		var click=false;
		
		window.onload=function(){
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
		};
		
		$("#dzp-alert .dzp-alert,#dzp-alert .dzp-alert-xie").on("click",function(){
			window.location.reload();
		});
	</script>
</body>
</html>