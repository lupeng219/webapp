/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */
$(function () {
    //控制底部客服，计算器，返回顶部按钮效果
    $(".ba").hover(function () {
        $(".ha").slideToggle("slow");
    });
    $(".bb").hover(function () {
        $(".hb").slideToggle("slow");
    });
    $(".bc").hover(function () {
        $(".hc").slideToggle("slow");
    });
    $(".ic-jsq").hover(function () {
        $(".jsq-desc").slideToggle("fast");
    });
    $(".ic-kf").hover(function () {
        $(".kf-desc").slideToggle("fast");
    });
    $(".ic-top").hover(function () {
        $(".top-desc").slideToggle("fast");
    });
    jinDu();
});

function jinDu() {
    var $biao_ring = $(".biao-ring");
    for (var i = 0; i < $biao_ring.length; i++) {
        var num = $biao_ring[i].getElementsByTagName("p")[0].innerHTML;
        parseInt(num) ? num = parseInt(num) : num = 0;
        $biao_ring[i].style.backgroundPosition = -92 * num + "px 0px";
    }
};