<!DOCTYPE html>
<html>
<head lang="en">
    <#include "./wap/common/wap_common_src.ftl" />
    <title>佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath}/css/jquery.fullPage.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/wapActiveAxis.css">
</head>
<body>
	<div class="wrap" id="dowebok">
		<div class="section">
			<div class="slide slide1">
				<#if Session["CURRENT_LOGIN_USER"]?exists>
					<a href="${basePath}/service/wapActivity/wapRedEnvelopes">
						<img src="${basePath }/images/wap/minisite-1_1.png"/>
					</a>
				<#else>
					<a href="${basePath}/service/wapLogin/toWapLogin">
						<img src="${basePath }/images/wap/minisite-1_1.png"/>
					</a>
				</#if>
			</div>
			<div class="slide slide2">
				<div>
					<p class="title">幸运转盘抽iPhone 6S</p>
					<div class="contentSub">
		        		<img src="${basePath}/images/wap/turntableBg.png"/>
		        		<div class="sub">
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
		                            <div>
		                            	<span class="img-con jp11">
		                            		<img src="${basePath}/images/special/ihone6s.png"/>
		                            		<em></em>
		                        		</span>
		                                <span class="img-con img-con2 jp10">
		                                	<img src="${basePath}/images/special/hb30.png"/>
		                                	<em></em>
		                            	</span>
		                        	</div>
		                        </li>
		                        <li class="btn-bg">
		                            <p class="textCt">
		                            	<#if Session["CURRENT_LOGIN_USER"]?exists>
		                            		<#if custNoCount gt 0>
		                            			<a href="javascript:void(0);" class="dzp-btn">
			                            			<img src="${basePath}/images/special/kscj.png"/>
			                            		</a>
		                            		<#else>
		                            			<a>
			                            			<img src="${basePath}/images/special/kscj-hui.png"/>
			                            		</a>
		                            		</#if>
		                            	<#else>
		                            		<a href="${basePath}/service/wapLogin/toWapLogin">
		                            			<img src="${basePath}/images/special/kscj.png"/>
		                            		</a>
		                            	</#if>
		                            </p>
		                            <#if Session["CURRENT_LOGIN_USER"]?exists>
			                            <p class="txt-tzjh">您还有<span>${custNoCount}</span>次抽奖机会</p>
			                            <p class="txt-des"><a href="${basePath}/service/wapMessages/wapGoodsReward">【查看实物奖励】</a></p>
		                            </#if>
		                        </li>
		                        <li>
		                            <div>
		                            	<span class="img-con jp4">
		                            		<img src="${basePath}/images/special/hb20.png"/>
		                            		<em></em>
		                        		</span>
		                                <span class="img-con img-con2 jp5">
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
		        	<p class="describe">活动期间每日登陆佰宝金服均可获得一次抽奖机会；<br>每日每次投资也可获得一次抽奖机会，单日最多两次;<br>活动抽取的红包请在"个人中心"-"我的优惠券"中查看。</p>
				</div>
			</div>
			<div class="slide slide3">
				<a href="${basePath}/service/wapActivity/wapInviteFriends"></a>
			</div>
		</div>
	</div>
    <script src="${basePath}/js/public/jquery.fullPage.min.js" type="text/javascript"></script>
    <script type="text/javascript">
    	$(function(){
    		$('#dowebok').fullpage({
	        	css3: true,
	        	slidesNavigation:true,
	        	loopHorizontal:false,
	        	navigationColor:'#ccc'
	        });
    	
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
					if($("#"+id).find(".img-con img").length>0) {
						$lottery = $("#"+id);
						$units = $lottery.find(".img-con img");
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
							myShow("谢谢参与",function(){
								window.location.reload();
							});
						}else{
							myShow("您抽中了"+ lottery.prizeName +"！！！",function(){
								window.location.reload();
							});
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
				    	    	myShow("服务器繁忙，请稍后重试！");
				    	    	click=false;
				    	    	return false;
				    	    },
				    	    success:function(data){
				    	    	if(parseInt(data.prizeNo)==12){
				    	    		myShow("您今天的抽奖次数已用完!");
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
    	});
    </script>
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