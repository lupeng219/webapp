$.fn.clickdown = function (bd1) {
    $(this).click(function () {
        var Index = $(bd1).index(this);
        $(this).toggleClass("bd1");
        $(bd1 + ":not(:eq(" + Index + "))").removeClass("bd1");
        $(this).find(".icon-bottom").attr("src", "./imgs/icon-top.png");
        $(this).siblings(".productContent").slideToggle(100);
        $(this).parent().siblings().children('.productContent').slideUp(100);
    })
}