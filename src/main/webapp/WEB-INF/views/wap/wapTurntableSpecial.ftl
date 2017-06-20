<!DOCTYPE html>
<html>
<head lang="en">
   	<#include "./wap/common/wap_common_src.ftl" />
    <title>幸运大转盘-佰宝金服-安全透明灵活的互联网金融服务平台</title>
    <link rel="stylesheet" type="text/css" href="${basePath }/css/wap/wapTurntableSpecial.css">
</head>
<body>
 	<div class="wrap">
        <header class="op-header">
            <p>幸运大转盘</p>
            <a href="javascript:history.go(-1);" class="out-icon"></a>
            <#if Session["CURRENT_LOGIN_USER"]?exists>
                 <a href="${basePath}/service/wapAccount/wapAccountIndex" class="person-icon"></a>
		    </#if>
        </header>
        <div class="content">
        	<div class="contentSub">
        		<img src="${basePath}/images/wap/turntableTitle.png"/>
        	</div>
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
        	<div class="contentSub">
        		<div class="sub2 textCt">
        			<p class="rulesTitle">
        				<img src="${basePath}/images/wap/rulesTitle.png"/>
        			</p>
        			<div class="rules bor_radius4">
        				<p>
        				1. 用户每日登录后即可获得一次抽奖机会，此项每人每日最多获1次抽奖机会；<br>
        				2. 用户每日投资一次可获得一次抽奖机会，此项每人每日最多获2次抽奖机会。
        				</p>
        				<p class="title">【奖励发放与使用】</p>
        				<p>
        				1. 抽取到实物奖励时系统会提示获奖者填写相关的邮寄方式，活动结束后一周内发放实物奖励，请保持手机畅通便于收取快递；<br>
                        2. 用户抽中红包后，红包即刻到账，投资后即可激活红包并获得现金奖励；<br>
                        3. 获取红包后可在“个人中心”-“我的活动”-“我的优惠券”中查看；<br>
                        4. 红包有效期为领取之日起30天内有效，30天后未激活则红包失效；<br>
                        5. 如有疑问请拨打佰宝金服客服电话：010-57492584。
                        </p>
        			</div>
        		</div>
        	</div>
        </div>
        <div class="wap-footer" id="wap-footer" style="margin-top:0;">
		    <p class="kfrx-p">客服热线：<a href="tel://400-882-2170" style="color:#acb2c8;">400-882-2170</a></p>
		    <p class="footer-btn">
		        <a href="${basePath}/service/wapIndex/download">下载客户端</a>
		        <a href="${basePath}/service/wapLogin/wapAboutWe">关于我们</a>
		        <a href="${basePath}/service/index/index?type=pc">电脑版</a>
		    </p>
		    <p class="kfrx-p">中融佰诚投资管理有限公司 </p>
		    <p class="kfrx-p1"> © 2016 baibao.com 京ICP证 140570号</p>
		</div>
		<div class="projectWindowBg" style="display:none;"></div>
		<div id="contentLoading" style="display:none;position:fixed;z-index:99999;width:100%;height:100%;top:0;bottom:0;left:0;right:0;
			overflow: hidden;text-align:center;">
			<img src="${basePath}/images/loading.gif" style="margin-left:auto;margin-right:auto;width:30px;height:30px;"/>
		</div>
		<script type="text/javascript">
			var marginTop=document.documentElement.clientHeight/2-15;
			$("#contentLoading img").css("margin-top",marginTop+"px");
		</script>
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
	</script>
</body>
</html>