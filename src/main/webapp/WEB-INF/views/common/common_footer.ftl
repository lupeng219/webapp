<script type="text/javascript">
	var currentViewUrl=location.href;
	$("#nav .nLi a").each(function(index,element){
		if(currentViewUrl===element.href||currentViewUrl===element.href+"#top"){
			$(element).closest(".nLi").addClass("current");
			return false;
		}
	});
	$(".invest-list-nav .list-nav li a").each(function(index,element){
		if(currentViewUrl===element.href||currentViewUrl===element.href+"#top"
			||currentViewUrl===element.href+"/switcholdaccount"||currentViewUrl===element.href+"/switcholdaccount#top"){
			$(element).closest(".menuLi").addClass("current");
			if($(element).closest(".menuLi").find(".sub").length!=0){
				$(element).closest(".menuLi").find(".sub").css("top","42px");
			}
			return false;
		}
	});
</script>
<div class="main-footer" >
    
    <div class='ft_top'>
        <div class="ft_cont">
            <div class='ft_left bln'>
                <div class='footer_logo'>
                    <img src='${basePath}/pictures/footer/footer-logo.png'>
                </div>
                <p>客服电话<span>010-57492584</span></p>
                <p style="width:400px;display:inline-block">客服邮箱<span>baibao-help@credithundred.com</span></p>
            </div>
            <div class='ft_center'>
                
                <div class='QR_Code'>
                    <img src='${basePath}/pictures/footer/QR-code.png' style='width: 113px;'>
                </div> 
                <div class='ftCt_info'>
                    <p>扫描微信二维码</p>
                    <p>下载手机APP</p>
                    <p>随时随地快捷理财</p>
                </div>
              
            </div>
            <div class='ft_right brn'>
                <h6>关于我们</h6>
                <p>北京总部：朝阳区北辰东路8号北辰时代大厦26层</p>
                <p>青岛分部：山东省青岛市南区东海西路31号保时捷大厦6层</p>
                <p>上海分部：上海市普陀区中山北路3300号月星环球港商务中心11楼AH单元</p>
                <p>大连中山分部：大连市西岗区五惠路32号汇景天地10层</p>
            </div>
        </div>
    </div>
    <div class='ft_btm'>
        <div class="ft_cont">
            <div class='auth_img'>
                <!--
                <img src='${basePath}/pictures/footer/auth_kxlogo.png' class='pdn'>
                <img src='${basePath}/pictures/footer/auth_itrust_certifi.png'>
                <img src='${basePath}/pictures/footer/auth_officialbrand_large.png'>
                <img src='${basePath}/pictures/footer/auth_360jiance.png'>
                -->
            </div>
            <p>Copyright©2016 中融佰诚投资管理(北京)有限公司  京ICP备14060883号</p>
            <p class='comPy'><span class='cutOffRule'>佰诚汇智科技（北京）有限公司</span><span>北京佰诚普众信息咨询有限公司</span></p>
        </div>
    </div>
    	
    </div>
</div>
<div class="index-sider" id="index-sider">
    <a href="http://crm2.qq.com/page/portalpage/wpa.php?uin=800147660&aty=0&a=0&curl=&ty=1" id="openQQ" target="_blank">
        <div class="dericon ic-ct">
            <img src='${basePath}/pictures/index/ICO-QQ.png'>
            <div class="icondesc ct-desc">
                <p>联系客服</p>
            </div>
        </div>
    </a>
   
	<a href="${basePath}/service/productList/toCalculator" target="_blank">
	    <div class="dericon ic-jsq">
            <img src='${basePath}/pictures/index/ICO-The-calculator.png'>
	        <div class="icondesc jsq-desc">
	            <p>计算器</p>
	        </div>
	  
        </div>
         
    </a>
    <div class="dericon ic-top">
        <a href='#top'>
            <img src='${basePath}/pictures/index/ICON-TOP.png'>
            <div class="icondesc top-desc">
                <p>回到顶部</p>
            </div>
        </a>
        </div>
  
   
</div>
<div class="projectWindowBg" style="display:none;"></div>
<script type='text/javascript'>
    $(function(){
        $(".ic-ct").on('mouseover',function(){
            $(".ct-desc").slideDown(100)
        }).on('mouseleave',function(){
            $(".ct-desc").slideUp(100)
        })
    
    })
</script>
<!-- 广告位  start -->
<!--
<div class="advertising" style="display:none;">
	<div class="advertisingSub">
		<img src="${basePath}/images/advertisingImg.png"/>
		<span id="closeAdvertising"></span>
	</div>
</div>
<script type="text/javascript">
	var advertisingCookie=getCookie("isNotfirstOpenbaibao")||"";
	if(advertisingCookie!="true"){
		$(".projectWindowBg").show();
		$(".advertising").show();
		setCookie("isNotfirstOpenbaibao",true);
	}
	$("#closeAdvertising").on("click",function(){
		$(".projectWindowBg").hide();
		$(".advertising").hide();
	});
	$(".advertisingSub img").on("click",function(){
		window.location.href=root+'/service/dissertation/slyderAdventures';
	});
</script>
-->
<!-- 广告位  end -->

<div id="contentLoading" style="display:none;position:fixed;z-index:99999;width:100%;height:100%;top:0;bottom:0;left:0;right:0;
	overflow: hidden;text-align:center;">
	<img src="${basePath}/images/loading.gif" style="margin:auto;margin-top:20%;"/>
</div>
<!--<script src="//assets.kf5.com/supportbox/main.js" id="kf5-provide-supportBox" kf5-domain="baibao.kf5.com"></script>-->
<!--<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1258291375'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s95.cnzz.com/z_stat.php%3Fid%3D1258291375%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>-->
<script>
(function() {

//http://wpd.b.qq.com/cgi/get_sign.php?na=800147660&kfuin=800147660&aty=0&a=0&sid=&uid=&url=https%3A%2F%2Fwww.baibaojinfu.com%2Fback-app&
//title=%E4%BD%B0%E5%AE%9D%E9%87%91%E8%9E%8D%E5%90%8E%E5%8F%B0%E7%99%BB%E9%99%86%E9%A1%B5%E9%9D%A2&
//dm=baibaojinfu.com&clkSrc=&ext=&cb=JSONP_CALLBACK_4_76

/*
JSONP_CALLBACK_4_76({"r":0,"data":{"sign":"tencent:\/\/message\/?Menu=yes&amp;uin=800147660&amp;Service=58&amp;SigT=A7F6FEA02730C988A065ACF8721D4D698BB79B5A943B4BDD72C02B0CFB3DBF369A82E0A9D8219160E054C15A1D063070DE18027B398CF5A5602B73463EE53A37071EB405FAA9378DFE35C5E3740D6AF618B7E982289A6892E7B8CE8A3A6AEC7F6FAD2E0B79DE3A37DFFB73765EA3ED5C5EAA26C6F96D40A9&amp;SigU=30E5D5233A443AB2A1FDEF6928BA7FB8993B951356214D0F53A30C8DB548C520A964689528E3F1D1E9A0C44D22ED4CC7BE5ECCD7D14119B3E3B9221253DC46E58FFBB997F95EDDAF","clkID":"3404c3a5b93063052ee315f241853b6cec"}});
*/

var qq = "800147660";

var openQQ = function() {
    $.ajax({
        url: "/wpd-qq/get_sign.php",
        data: {
            na: qq,
            aty: 0,
            a: 0,
            sid: "",
            uid: "",
            url: window.location.href,
            dm: "www.baibaojinfu.com",
            clkSrc: "",
            ext: ""
        },
        dataType:"jsonp",
        jsonp:"cb",
        success: function(response) {
            if (response.r == 0)
            {
                window.location.href = (response.data.sign.replace(/&amp;/g, "&"));
            }
        }
    });
};

$(document).ready(function() {
    /*$("#openQQ").click(function() {
        openQQ();
    });*/
});

})();
</script>
