;
(function () {

    var clientH = $(".personal-main").height(),
        clientH2 = $(".clientH").height(),
        clientHT = $(".clientHT").height();
    if (clientH < 600) {
        $(".personal-main").height(600)
    } else {
        return false;
    };
    if (clientH2 < 700) {
        $(".clientH").height(710);
    } else {
        return false;
    };
    if (clientHT < 600) {
        $(".clientHT").height(600);
    } else {
        return false;
    };
})();