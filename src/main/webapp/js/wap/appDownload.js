/**
 * Created by chen on 2015/10/29.
 */
$(function(){
    $("#andriodBtn").on("click",function(){
        if(is_weixn()){
            $("#content").hide();
            $("#iosImg").hide();
            $("#andriodImg").show();
            $(".page").show();
        }else{
            if(isMobile()){
                if(is_android()){
                	window.location.href="https://www.baibao.com/admin/service/mobileApp/app";
                }else{
                	myShow("请点击iPhone手机专享链接进行下载");
                    return false;
                }
            }else{
            	window.location.href="https://www.baibao.com/admin/service/mobileApp/app";
            }
        }
    });
    $("#iosBtn").on("click",function(){
        if(is_weixn()){
            $("#content").hide();
            $("#andriodImg").hide();
            $("#iosImg").show();
            $(".page").show();
        }else{
            if(isMobile()){
                if(!is_android()){
                    window.location.href="https://itunes.apple.com/cn/app/quan-zi-ben/id1042205791?mt=8";
                }else{
                	myShow("请点击Andriod手机专享链接进行下载");
                    return false;
                }
            }else{
                window.location.href="https://itunes.apple.com/cn/app/quan-zi-ben/id1042205791?mt=8";
            }
        }
    });
});