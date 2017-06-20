<meta charset="UTF-8"/>
<meta name="baidu-site-verification" content="PFK7Ijzs6u" />
<meta name="renderer" content="webkit|ie-stand"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<script src="${basePath}/js/public/alert.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="${basePath}/css/setting.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/css/iealert.css"/>
<link type="image/x-icon" href="${basePath }/pictures/top/logo.ico" rel="icon" />
<link type="image/x-icon" href="${basePath }/pictures/top/logo.ico" rel="shortcut icon" />
<link type="image/x-icon" href="${basePath }/pictures/top/logo.ico" rel="bookmark" />
<script src="${basePath}/js/public/jquery-1.8.2.js" type="text/javascript"></script>
<script src="${basePath}/js/public/sea.js" type="text/javascript" ></script>
<script src="${basePath}/js/public/jquery.form.js" type="text/javascript"></script>
<script src="${basePath}/js/public/jquery.cookie.pack.js" type="text/javascript"></script>
<script src="${basePath}/js/public/jquery.SuperSlide.2.1.1.js" type="text/javascript"></script>
<script src="${basePath}/js/public/common-verification.js" type="text/javascript"></script>
<script src="${basePath}/js/public/index-sider.js" type="text/javascript"></script>
<!--script src="${basePath}/js/public/logo-nav.js" type="text/javascript"></script-->
<script src="${basePath}/js/public/iealert.js" type="text/javascript"></script>

<!--[if lt IE 9]>
  <script src="${basePath}/js/public/html5shiv.js"></script>
  <script src="${basePath}/js/public/respond.js"></script>
  <script src="${basePath}/js/public/indexOf.js"></script>
<![endif]-->
<script type="text/javascript">
	var root = '${basePath}';
	
    //Set configuration--------------引入seajs之前需引入jQuery库，该代码可放入公有页面
    seajs.config({
        base: root+"/js/baibao/",				//base表示基址寻址时的基址路径
        alias: {							//alias可以对较长的常用路径设置缩写
            //"jquery": "jquery.min.js"
        },
        charset: 'utf-8',					//charset表示下载js时script标签的charset属性
        timeout: 20000,						//timeout表示下载文件的最大时长，以毫秒为单位
        debug: false						//debug表示是否工作在调试模式下
    });
    
    $(document).ready(function () {
        $("body").iealert();
    });
    
    //千分位
    function commafy(num) {   
    	//1.先去除空格,判断是否空值和非数   
    	num = num + "";   
    	num = num.replace(/[ ]/g, ""); //去除空格
    	
	    if (num == "")
	    {   
	    	return;   
	    }   
	    
	    if (isNaN(num))
	    {  
	    	return;   
	    }

	    //2.针对是否有小数点，分情况处理   
	    var index = num.indexOf(".");   
	    if (index==-1)
	    {//无小数点   
	      var reg = /(-?\d+)(\d{3})/;
	         
	      while (reg.test(num))
	      {   
	      	num = num.replace(reg, "$1,$2");   
	      }   
	    } else
	    {   
	        var intPart = num.substring(0, index);   
	        var pointPart = num.substring(index + 1, num.length);   
	        var reg = /(-?\d+)(\d{3})/;   
	        
	        while (reg.test(intPart))
	        {   
	        	intPart = intPart.replace(reg, "$1,$2");   
	        }

	       	num = intPart +"."+ pointPart;   
	    }
    	    
    	return num;   
    } 
</script>
<script src="${basePath}/js/public/ajaxSuccess.js" type="text/javascript"></script>