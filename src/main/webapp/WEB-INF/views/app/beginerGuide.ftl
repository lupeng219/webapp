<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta content="yes" name="apple-mobile-web-app-capable">
	<meta content="black" name="apple-mobile-web-app-status-bar-style">
	<meta content="telephone=no" name="format-detection">
	<meta content="email=no" name="format-detection">
	<title>新手引导</title>
	<link rel="stylesheet" href="${basePath}/css/zepto.fullpage.css">
	<link rel="stylesheet" href="${basePath}/css/swiper-3.3.1.min.css">
	<link rel="stylesheet" href="${basePath}/css/animate.css">
	<link rel="stylesheet" href="${basePath}/css/mobile.beginerGuide.css">
</head>

<body>
	<section class="wp">
		<section class="wp-inner">
			<section class="page page1">
				<section class="js-animate animated" data-animate="bounce">


				</section>
				<span class="start"><b></b></span>
			</section>
			<section class="page page2">
				<section class="js-animate animated" data-animate="bounce">

				</section>
				<span class="start"><b></b></span>
			</section>
			<section class="page page3">
				<section class="js-animate animated" data-animate="bounce">


				</section>
				<span class="start"><b></b></span>
			</section>
			<section class="page page4">
				<section class="js-animate animated" data-animate="bounce">

				</section>
				<span class="start"><b></b></span>
			</section>
			<section class="page page5">
				<section class="js-animate animated" data-animate="bounce">
					<a href="javascript:;" class="goRegister"></a>
				</section>

			</section>
		</section>
	</section>

	<script src="${basePath}/js/baibao/setfontsize.js"></script>
	<script src="${basePath}/js/baibao/zepto.min.js"></script>
	<script src="${basePath}/js/baibao/js.fullpage.js"></script>
	<script src="${basePath}/js/baibao/swiper-3.3.1.jquery.min.js"></script>
	<script src="${basePath}/js/baibao/mobile.contactUs.js"></script>
	<script type="text/javascript">
		var u = navigator.userAgent;
		var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1 || u.indexOf('Linux') > -1; //android终端
		var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
		$(".goRegister").on("click",function(){
			if (isAndroid) {
				 window.robot.goRegister();
			} else if (isiOS) {
				 goRegister();
			}

		});
	</script>
</body>

</html>