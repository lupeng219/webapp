/*
 * 
 * author : linwu (http://linwu.name)
 * datetime : 2015-6-4
 */
$(function(){
    /*tab切换*/
    var oTab = $(".content");
    var aH3 = oTab.find(".mkli");
    var aDiv = oTab.find(".main-coupons-list");
    for (var i = 0; i < aH3.length; i++) {
        aH3[i].index = i;
        aH3[i].onclick = function () {
            for (var i = 0; i < aH3.length; i++) {
                aH3[i].className = "mkli";
                aDiv[i].style.display = "none";
            }
            this.className = "mkli mknav-cut";
            aDiv[this.index].style.display = "block";
        };
    }
    //复制链接
    $('a#copyButton').zclip({
        path:root+'/js/public/ZeroClipboard.swf',
        copy:$('input#copyUrlInput').val(),
        afterCopy:function(){
            alert("复制成功！");
        }
    });
});
